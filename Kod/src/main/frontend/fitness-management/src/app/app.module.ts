import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppComponent} from './app.component';
import {FmMaterialModule} from "./fm-material.module";
import {RouterModule, Routes} from "@angular/router";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";

const routes: Routes = [
	{path: '', loadChildren: './home/home.module#HomeModule'},
	{path: 'users', loadChildren: './users/users.module#UsersModule'},
	{path: 'employees', loadChildren: './employees/employees.module#EmployeesModule'},
	{path: 'services', loadChildren: './services/services.module#ServicesModule'},
	{path: 'management', loadChildren: './management/management.module#ManagementModule'}
];

@NgModule({
	declarations: [
		AppComponent,
	],

	imports: [
		BrowserModule,
		FmMaterialModule,
		RouterModule.forRoot(routes),
		BrowserAnimationsModule,
		FormsModule,
		ReactiveFormsModule
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule {
}