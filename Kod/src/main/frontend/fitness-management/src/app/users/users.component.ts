import {Component, OnInit} from '@angular/core';
import {USERS} from "../mocks/mock-users";
import {Confirmation, DialogCloseMessage, Mode} from "../models";
import {MatDialog, MatDialogRef} from "@angular/material";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {AddUserDialogComponent} from "../dialogs/add-user-dialog/add-user-dialog.component";
import {EditUserDialogComponent} from "../dialogs/edit-user-dialog/edit-user-dialog.component";


@Component({
	selector: 'app-users',
	templateUrl: './users.component.html',
	styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

	Mode = Mode;

	currentMode: Mode = Mode.VIEW;

	USERS = USERS;

	ask: boolean = true;

	constructor(public dialog: MatDialog) {
	}

	ngOnInit() {
	}

	editModeOn() {
		this.currentMode = Mode.EDIT;
	}

	deleteModeOn() {
		this.currentMode = Mode.DELETE;
	}

	deleteClient(index: number) {
		if (this.ask) {
			let dialogRef = this.dialog.open(DeleteConfirmDialogComponent);
			dialogRef.afterClosed().subscribe(result => {
				if (result.message == DialogCloseMessage.SAVE) {
					if (result.data == Confirmation.DONTASK) {
						this.ask = false;
					}
					this.USERS.splice(index, 1);
					if (this.USERS.length == 0) {
						this.currentMode = Mode.VIEW;
					}
				}
			});
		}
		else {
			this.USERS.splice(index, 1);
			if (this.USERS.length == 0) {
				this.currentMode = Mode.VIEW;
			}
		}

	}

	addClient() {
		let dialogRef = this.dialog.open(AddUserDialogComponent);
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.USERS.push(result.data);
				}
			}
		});
	}

	editClient(i) {
		let dialogRef: MatDialogRef<EditUserDialogComponent, any>;
		dialogRef = this.dialog.open(EditUserDialogComponent, {data: {index: i}});
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.USERS[i] = result.data;
				}
			}
		});
	}

	editsDone() {
		this.currentMode = Mode.VIEW;
	}
}
