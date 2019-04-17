import {Component, OnInit} from '@angular/core';
import {DialogCloseMessage, DialogCloseResult, servicePackage} from "../../models";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {MatDialogRef} from "@angular/material";

@Component({
	selector: 'app-add-service-package-dialog',
	templateUrl: './add-service-package-dialog.component.html',
	styleUrls: ['./add-service-package-dialog.component.scss']
})
export class AddServicePackageDialogComponent implements OnInit {

	result = new DialogCloseResult<servicePackage>();

	servicePackage: servicePackage = new servicePackage();

	servicePackageForm = new FormGroup({
		name: new FormControl('', Validators.required),
		cost: new FormControl('', [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		duration: new FormControl('', [
			Validators.required,
			Validators.pattern("^[0-9]*$")
		]),
		classesIncluded: new FormControl(false)
	})

	constructor(public dialogRef: MatDialogRef<AddServicePackageDialogComponent>) {
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
