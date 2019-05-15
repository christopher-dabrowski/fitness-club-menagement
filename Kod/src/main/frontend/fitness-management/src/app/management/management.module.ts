import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ManagementComponent} from './management.component';
import {RouterModule, Routes} from "@angular/router";
import {FmMaterialModule} from "../fm-material.module";
import {TileModule} from "../tiles/tile.module";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

const routes: Routes = [
	{path: '', component: ManagementComponent},
];

@NgModule({
	declarations: [ManagementComponent],
	imports: [
		CommonModule,
		RouterModule.forChild(routes),
		FmMaterialModule,
		TileModule,
		FormsModule,
		ReactiveFormsModule
	]
})
export class ManagementModule {
}
