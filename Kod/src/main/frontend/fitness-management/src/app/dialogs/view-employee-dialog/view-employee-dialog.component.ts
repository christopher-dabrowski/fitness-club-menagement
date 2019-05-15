import {Component, Inject, OnInit} from '@angular/core';
import {Employee} from "../../models";
import {EMPLOYEES} from "../../mocks/mock-employees";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";

@Component({
  selector: 'app-view-employee-dialog',
  templateUrl: './view-employee-dialog.component.html',
  styleUrls: ['./view-employee-dialog.component.scss']
})
export class ViewEmployeeDialogComponent implements OnInit {

	employee: Employee = EMPLOYEES[this.data['index']];

	constructor(public dialogRef: MatDialogRef<ViewEmployeeDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
	}

	onClose(){
		this.dialogRef.close();
	}

}
