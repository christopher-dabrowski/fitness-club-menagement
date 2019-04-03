import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {HomeComponent} from './home.component';
import {RouterModule, Routes} from "@angular/router";
import {FmMaterialModule} from "../fm-material.module";

const routes: Routes = [
	{path: '', component: HomeComponent},
];

@NgModule({
	declarations: [HomeComponent],
	imports: [
		CommonModule,
		RouterModule.forChild(routes),
		FmMaterialModule
	]
})
export class HomeModule {
}
