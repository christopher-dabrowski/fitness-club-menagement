import {Component, OnInit} from '@angular/core';
import {DialogCloseMessage, DialogCloseResult, Employee, Occupation} from "../../models";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material";
import {OCCUPATIONS} from "../../mocks/mock-occupations";

@Component({
	selector: 'app-add-employee-dialog',
	templateUrl: './add-employee-dialog.component.html',
	styleUrls: ['./add-employee-dialog.component.scss']
})
export class AddEmployeeDialogComponent implements OnInit {
	result = new DialogCloseResult<Employee>();
	employeeForm = new FormGroup({
		firstName: new FormControl('', Validators.required),
		surname: new FormControl('', Validators.required),
		name: new FormControl('', Validators.required),
		since: new FormControl(new Date()),
		to: new FormControl(new Date()),
		hours: new FormControl('', [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		salary: new FormControl('', [Validators.required,
			Validators.pattern("^[0-9]*$")
		])
	});

	employee: Employee = new Employee();

	OCCUPATIONS = OCCUPATIONS;

	occupation: Occupation = new Occupation();


	constructor(public dialogRef: MatDialogRef<AddEmployeeDialogComponent>) {
	}

	ngOnInit() {
	}

	onSubmit() {
		if (this.employeeForm.valid) {
			this.occupation.name = this.employeeForm.controls['name'].value;
			this.occupation.since = this.employeeForm.controls['since'].value;
			this.occupation.to = this.employeeForm.controls['to'].value;
			this.occupation.hours = this.employeeForm.controls['hours'].value;
			this.occupation.salary = this.employeeForm.controls['salary'].value;
			this.OCCUPATIONS.push(this.occupation);

			this.employee.firstName = this.employeeForm.controls['firstName'].value;
			this.employee.surname = this.employeeForm.controls['surname'].value;
			this.employee.id = Math.floor(Math.random() * 999999);
			this.employee.occupation = OCCUPATIONS[OCCUPATIONS.length - 1];
			this.result.data = this.employee;
			this.result.message = DialogCloseMessage.SAVE;
			this.dialogRef.close(this.result);
		}
	}

	onCancel() {
		this.result.message = DialogCloseMessage.CANCEL;
		this.dialogRef.close(this.result);
	}
}





