import {Component, Inject, OnInit} from '@angular/core';
import {DialogCloseMessage, DialogCloseResult, User} from "../../models";
import {SERVICE_PACKAGES} from "../../mocks/mock-service-packages";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {USERS} from "../../mocks/mock-users";

@Component({
	selector: 'app-edit-user-dialog',
	templateUrl: './edit-user-dialog.component.html',
	styleUrls: ['./edit-user-dialog.component.scss']
})
export class EditUserDialogComponent implements OnInit {

	user: User = USERS[this.data['index']];
	result = new DialogCloseResult<User>();
	SERVICE_PACKAGES = SERVICE_PACKAGES;
	userForm = new FormGroup({
		firstName: new FormControl(this.user.firstName, Validators.required),
		surname: new FormControl(this.user.surname, Validators.required),
		date: new FormControl(this.user.startDate),
		servicePackage: new FormControl(this.user.servicePackage, Validators.required)
	});


	constructor(public dialogRef: MatDialogRef<EditUserDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
	}

	onSubmit() {
		if (this.userForm.valid) {
			this.user.firstName = this.userForm.controls['firstName'].value;
			this.user.surname = this.userForm.controls['surname'].value;
			this.user.startDate = this.userForm.controls['date'].value;
			this.user.cardNumber = this.user.cardNumber;
			this.user.servicePackage = this.userForm.controls['servicePackage'].value;
			this.result.data = this.user;
			this.result.message = DialogCloseMessage.SAVE;
			this.dialogRef.close(this.result);
		}
	}

	onCancel() {
		this.result.message = DialogCloseMessage.CANCEL;
		this.dialogRef.close(this.result);
	}
}


