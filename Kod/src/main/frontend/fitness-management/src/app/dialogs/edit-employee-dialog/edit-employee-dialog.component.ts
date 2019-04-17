import {Component, Inject, OnInit} from '@angular/core';
import {DialogCloseMessage, DialogCloseResult, Employee, Occupation} from "../../models";
import {EMPLOYEES} from "../../mocks/mock-employees";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {OCCUPATIONS} from "../../mocks/mock-occupations";

@Component({
  selector: 'app-edit-employee-dialog',
  templateUrl: './edit-employee-dialog.component.html',
  styleUrls: ['./edit-employee-dialog.component.scss']
})
export class EditEmployeeDialogComponent implements OnInit {

	OCCUPATIONS = OCCUPATIONS;

	employee: Employee = EMPLOYEES[this.data['index']];

	occupationIndex = OCCUPATIONS.indexOf(this.employee.occupation);

	occupation: Occupation = OCCUPATIONS[this.occupationIndex];

	result = new DialogCloseResult<Employee>();

	employeeForm = new FormGroup({
		firstName: new FormControl(this.employee.firstName, Validators.required),
		surname: new FormControl(this.employee.surname, Validators.required),
		name: new FormControl(this.occupation.name, Validators.required),
		since: new FormControl(this.occupation.since),
		to: new FormControl(this.occupation.to),
		hours: new FormControl(this.occupation.hours, [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		salary: new FormControl(this.occupation.salary, [Validators.required,
			Validators.pattern("^[0-9]*$")
		])
	});

  constructor(public dialogRef: MatDialogRef<EditEmployeeDialogComponent>, @Inject(MAT_DIALOG_DATA) public data:any) { }

  ngOnInit() {
  }

	onSubmit() {
		if (this.employeeForm.valid) {
			this.occupation.name = this.employeeForm.controls['name'].value;
			this.occupation.since = this.employeeForm.controls['since'].value;
			this.occupation.to = this.employeeForm.controls['to'].value;
			this.occupation.hours = this.employeeForm.controls['hours'].value;
			this.occupation.salary = this.employeeForm.controls['salary'].value;
			this.OCCUPATIONS[this.occupationIndex] = this.occupation;

			this.employee.firstName = this.employeeForm.controls['firstName'].value;
			this.employee.surname = this.employeeForm.controls['surname'].value;
			this.employee.id = Math.floor(Math.random() * 999999);
			this.employee.occupation = OCCUPATIONS[OCCUPATIONS.length-1];
			this.result.data = this.employee;
			this.result.message = DialogCloseMessage.SAVE;
			this.dialogRef.close(this.result);
		}
	}
}
