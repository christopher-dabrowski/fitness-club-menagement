import {NgModule} from '@angular/core';
import {MatButtonModule, MatCardModule, MatIconModule} from "@angular/material";

const modules = [
	MatButtonModule,
	MatCardModule,
	MatIconModule
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
