import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {EmployeesComponent} from './employees.component';
import {RouterModule, Routes} from "@angular/router";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {FmMaterialModule} from "../fm-material.module";
import {TileModule} from "../tiles/tile.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DialogsModule} from "../dialogs/dialogs.module";
import {EditEmployeeDialogComponent} from "../dialogs/edit-employee-dialog/edit-employee-dialog.component";
import {AddEmployeeDialogComponent} from "../dialogs/add-employee-dialog/add-employee-dialog.component";

const routes: Routes = [
	{path: '', component: EmployeesComponent},
];


@NgModule({
	declarations: [
		EmployeesComponent,
	],
	entryComponents: [
		DeleteConfirmDialogComponent,
		EditEmployeeDialogComponent,
		AddEmployeeDialogComponent
	],
	imports: [
		CommonModule,
		RouterModule.forChild(routes),
		FmMaterialModule,
		TileModule,
		FormsModule,
		ReactiveFormsModule,
		DialogsModule
	]
})
export class EmployeesModule {
}
