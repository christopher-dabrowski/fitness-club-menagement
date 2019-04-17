import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {DeleteConfirmDialogComponent} from "./delete-confirm-dialog/delete-confirm-dialog.component";
import {AddUserDialogComponent} from "./add-user-dialog/add-user-dialog.component";
import {EditUserDialogComponent} from "./edit-user-dialog/edit-user-dialog.component";
import {FmMaterialModule} from "../fm-material.module";
import {TileModule} from "../tiles/tile.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AddEmployeeDialogComponent } from './add-employee-dialog/add-employee-dialog.component';
import { EditEmployeeDialogComponent } from './edit-employee-dialog/edit-employee-dialog.component';
import { EditServicePackageDialogComponent } from './edit-service-package-dialog/edit-service-package-dialog.component';
import { AddServicePackageDialogComponent } from './add-service-package-dialog/add-service-package-dialog.component';

@NgModule({
	declarations: [
		DeleteConfirmDialogComponent,
		AddUserDialogComponent,
		EditUserDialogComponent,
		AddEmployeeDialogComponent,
		EditEmployeeDialogComponent,
		EditServicePackageDialogComponent,
		AddServicePackageDialogComponent
	],
	imports: [
		CommonModule,
		FmMaterialModule,
		TileModule,
		FormsModule,
		ReactiveFormsModule
	]
})
export class DialogsModule {
}
