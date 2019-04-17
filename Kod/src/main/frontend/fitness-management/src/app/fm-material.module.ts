import {NgModule} from '@angular/core';
import {
	MatButtonModule,
	MatCardModule, MatCheckboxModule, MatDatepickerModule, MatDialogModule,
	MatDividerModule,
	MatIconModule, MatInputModule,
	MatMenuModule, MatNativeDateModule, MatSelectModule,
	MatTableModule
} from "@angular/material";

const modules = [
	MatButtonModule,
	MatCardModule,
	MatIconModule,
	MatTableModule,
	MatMenuModule,
	MatDividerModule,
	MatDialogModule,
	MatCheckboxModule,
	MatInputModule,
	MatDatepickerModule,
	MatNativeDateModule,
	MatSelectModule,


];

@NgModule({
	declarations: [],
	imports: [
		...modules,
	],
	exports: [
		...modules
	]
})
export class FmMaterialModule {
}
