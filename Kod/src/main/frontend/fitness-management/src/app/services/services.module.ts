import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ServicesComponent} from './services.component';
import {RouterModule, Routes} from "@angular/router";
import {FmMaterialModule} from "../fm-material.module";
import {TileModule} from "../tiles/tile.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {DialogsModule} from "../dialogs/dialogs.module";
import {DeleteConfirmDialogComponent} from "../dialogs/delete-confirm-dialog/delete-confirm-dialog.component";
import {EditServicePackageDialogComponent} from "../dialogs/edit-service-package-dialog/edit-service-package-dialog.component";
import {AddServicePackageDialogComponent} from "../dialogs/add-service-package-dialog/add-service-package-dialog.component";

const routes: Routes = [
	{path: '', component: ServicesComponent},
];

@NgModule({
	declarations: [ServicesComponent],
	entryComponents: [
		DeleteConfirmDialogComponent,
		EditServicePackageDialogComponent,
		AddServicePackageDialogComponent
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
export class ServicesModule {
}
