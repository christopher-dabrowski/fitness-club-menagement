import {Component, OnInit} from '@angular/core';
import {Confirmation, DialogCloseMessage, Mode} from "../models";
import {EMPLOYEES} from "../mocks/mock-employees";
import {MatDialog, MatDialogRef} from "@angular/material";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {AddEmployeeDialogComponent} from "../dialogs/add-employee-dialog/add-employee-dialog.component";
import {OCCUPATIONS} from "../mocks/mock-occupations";
import {EditEmployeeDialogComponent} from "../dialogs/edit-employee-dialog/edit-employee-dialog.component";
import {ViewEmployeeDialogComponent} from "../dialogs/view-employee-dialog/view-employee-dialog.component";

@Component({
	selector: 'app-employees',
	templateUrl: './employees.component.html',
	styleUrls: ['./employees.component.scss']
})
export class EmployeesComponent implements OnInit {

	Mode = Mode;

	currentMode: Mode = Mode.VIEW;

	EMPLOYEES = EMPLOYEES;

	OCCUPATIONS = OCCUPATIONS;

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

	deleteEmployee(index: number) {
		if (this.ask) {
			let dialogRef = this.dialog.open(DeleteConfirmDialogComponent);
			dialogRef.afterClosed().subscribe(result => {
				if (result.message == DialogCloseMessage.SAVE) {
					if (result.data == Confirmation.DONTASK) {
						this.ask = false;
					}
					this.EMPLOYEES.splice(index, 1);
					this.OCCUPATIONS.splice(this.OCCUPATIONS.indexOf(this.EMPLOYEES[index].occupation) - 1, 1);
					if (this.EMPLOYEES.length == 0) {
						this.currentMode = Mode.VIEW;
					}
				}
			});
		}
		else {
			this.EMPLOYEES.splice(index, 1);
			if (this.EMPLOYEES.length == 0) {
				this.currentMode = Mode.VIEW;
			}
		}

	}

	addEmployee() {
		let dialogRef = this.dialog.open(AddEmployeeDialogComponent);
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.EMPLOYEES.push(result.data);
				}
			}
		});
	}

	editEmployee(i) {
		let dialogRef: MatDialogRef<EditEmployeeDialogComponent, any>;
		dialogRef = this.dialog.open(EditEmployeeDialogComponent, {data: {index: i}});
		dialogRef.afterClosed().subscribe(result => {
			if (result != null) {
				if (result.message == DialogCloseMessage.SAVE) {
					this.EMPLOYEES[i] = result.data;
				}
			}
		});
	}


	editsDone() {
		this.currentMode = Mode.VIEW;
	}

	viewEmployee(i){
		this.dialog.open(ViewEmployeeDialogComponent, {data: {index: i}});
	}
}
