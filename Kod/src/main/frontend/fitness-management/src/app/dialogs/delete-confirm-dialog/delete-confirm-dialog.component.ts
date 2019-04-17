import {Component, OnInit} from '@angular/core';
import {MatDialogRef} from "@angular/material";
import {Confirmation, DialogCloseMessage, DialogCloseResult} from "../../models";

@Component({
	selector: 'app-delete-confirm-dialog',
	templateUrl: './delete-confirm-dialog.component.html',
	styleUrls: ['./delete-confirm-dialog.component.scss']
})


export class DeleteConfirmDialogComponent implements OnInit {

	result = new DialogCloseResult<Confirmation>();

	ask: Confirmation = Confirmation.ASK;

	constructor(public dialogRef: MatDialogRef<DeleteConfirmDialogComponent>) {
	}

	ngOnInit() {
	}

	cancel() {
		this.result.data = this.ask;
		this.result.message = DialogCloseMessage.CANCEL;
		this.dialogRef.close(this.result);
	}

	confirm() {
		this.result.data = this.ask;
		this.result.message = DialogCloseMessage.SAVE;
		this.dialogRef.close(this.result);
	}
}
