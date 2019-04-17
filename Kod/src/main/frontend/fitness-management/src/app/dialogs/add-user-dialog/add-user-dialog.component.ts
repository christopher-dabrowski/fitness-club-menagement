import {Component, OnInit} from '@angular/core';
import {SERVICE_PACKAGES} from "../../mocks/mock-service-packages";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {DialogCloseMessage, DialogCloseResult, User} from "../../models";
import {MatDialogRef} from "@angular/material";

@Component({
	selector: 'app-add-user-dialog',
	templateUrl: './add-user-dialog.component.html',
	styleUrls: ['./add-user-dialog.component.scss']
})

export class AddUserDialogComponent implements OnInit {
	result = new DialogCloseResult<User>();
	SERVICE_PACKAGES = SERVICE_PACKAGES;
	userForm = new FormGroup({
		firstName: new FormControl('', Validators.required),
		surname: new FormControl('', Validators.required),
		date: new FormControl(new Date()),
		servicePackage: new FormControl('', Validators.required)
	});
	user: User;


	constructor(public dialogRef: MatDialogRef<AddUserDialogComponent>) {
	}

	ngOnInit() {
		this.user = new User();
	}

	onSubmit() {
		if (this.userForm.valid) {
			this.user.firstName = this.userForm.controls['firstName'].value;
			this.user.surname = this.userForm.controls['surname'].value;
			this.user.startDate = this.userForm.controls['date'].value;
			this.user.cardNumber = Math.floor(Math.random() * 999999);
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





