import {Component, OnInit} from '@angular/core';
import {SERVICE_PACKAGES} from "../mocks/mock-service-packages";
import {Confirmation, DialogCloseMessage, Mode} from "../models";
import {MatDialog, MatDialogRef} from "@angular/material";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {AddServicePackageDialogComponent} from "../dialogs/add-service-package-dialog/add-service-package-dialog.component";
import {EditServicePackageDialogComponent} from "../dialogs/edit-service-package-dialog/edit-service-package-dialog.component";

@Component({
	selector: 'app-services',
	templateUrl: './services.component.html',
	styleUrls: ['./services.component.scss']
})
export class ServicesComponent implements OnInit {

	SERVICE_PACKAGES = SERVICE_PACKAGES;

	Mode = Mode;

	currentMode: Mode = Mode.VIEW;

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

	deleteServicePackage(index: number) {
		if (this.ask) {
			let dialogRef = this.dialog.open(DeleteConfirmDialogComponent);
			dialogRef.afterClosed().subscribe(result => {
				if (result.message == DialogCloseMessage.SAVE) {
					if (result.data == Confirmation.DONTASK) {
						this.ask = false;
					}
					this.SERVICE_PACKAGES.splice(index, 1);
					if (this.SERVICE_PACKAGES.length == 0) {
						this.currentMode = Mode.VIEW;
					}
				}
			});
		}
		else {
			this.SERVICE_PACKAGES.splice(index, 1);
			if (this.SERVICE_PACKAGES.length == 0) {
				this.currentMode = Mode.VIEW;
			}
		}

	}

	addServicePackage() {
		let dialogRef = this.dialog.open(AddServicePackageDialogComponent);
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.SERVICE_PACKAGES.push(result.data);
				}
			}
		});
	}

	editServicePackage(i) {
		let dialogRef: MatDialogRef<EditServicePackageDialogComponent, any>;
		dialogRef = this.dialog.open(EditServicePackageDialogComponent, {data: {index: i}});
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.SERVICE_PACKAGES[i] = result.data;
				}
			}
		});
	}


	editsDone() {
		this.currentMode = Mode.VIEW;
	}
}

