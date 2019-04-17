import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {UsersComponent} from './users.component';
import {RouterModule, Routes} from "@angular/router";
import {FmMaterialModule} from "../fm-material.module";
import {TileModule} from "../tiles/tile.module";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AddUserDialogComponent} from '../dialogs/add-user-dialog/add-user-dialog.component';
import {EditUserDialogComponent} from '../dialogs/edit-user-dialog/edit-user-dialog.component';
import {DialogsModule} from "../dialogs/dialogs.module";


const routes: Routes = [
	{path: '', component: UsersComponent},
];

@NgModule({
	declarations: [
		UsersComponent,
	],
	entryComponents: [
		DeleteConfirmDialogComponent,
		AddUserDialogComponent,
		EditUserDialogComponent
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
export class UsersModule {
}
