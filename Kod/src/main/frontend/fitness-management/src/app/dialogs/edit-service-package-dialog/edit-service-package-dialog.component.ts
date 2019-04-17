import {Component, Inject, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material";
import {DialogCloseMessage, DialogCloseResult, servicePackage, User} from "../../models";
import {SERVICE_PACKAGES} from "../../mocks/mock-service-packages";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
	selector: 'app-edit-service-package-dialog',
	templateUrl: './edit-service-package-dialog.component.html',
	styleUrls: ['./edit-service-package-dialog.component.scss']
})
export class EditServicePackageDialogComponent implements OnInit {

	servicePackage: servicePackage = SERVICE_PACKAGES[this.data['index']];
	result = new DialogCloseResult<User>();

	servicePackageForm = new FormGroup({
		name: new FormControl(this.servicePackage.name, Validators.required),
		cost: new FormControl(this.servicePackage.cost, [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		duration: new FormControl(this.servicePackage.duration, [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		classesIncluded: new FormControl(this.servicePackage.classesIncluded)
	})

	constructor(public dialogRef: MatDialogRef<EditServicePackageDialogComponent>, @Inject(MAT_DIALOG_DATA) public data: any) {
	}

	ngOnInit() {
	}

	onSubmit() {
		if (this.servicePackageForm.valid) {
			this.servicePackage.name = this.servicePackageForm.controls['name'].value;
			this.servicePackage.cost = this.servicePackageForm.controls['cost'].value;
			this.servicePackage.duration = this.servicePackageForm.controls['duration'].value;
			this.servicePackage.classesIncluded = this.servicePackageForm.controls['classesIncluded'].value;
			this.result.data = this.servicePackage;
			this.result.message = DialogCloseMessage.SAVE;
			this.dialogRef.close(this.result);
		}
	}

	onCancel() {
		this.result.message = DialogCloseMessage.CANCEL;
		this.dialogRef.close(this.result);
	}

}
