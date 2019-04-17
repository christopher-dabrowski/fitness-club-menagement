import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ValueTileComponent} from './value-tile/value-tile.component';
import {TileComponent} from './tile/tile.component';
import {TileHeaderComponent} from './tile-header/tile-header.component';
import {TileActionsComponent} from './tile-actions/tile-actions.component';
import {TileContentComponent} from "./tile-content/tile-content.component";
import {FmMaterialModule} from "../fm-material.module";

const declarations = [
	ValueTileComponent,
	TileComponent,
	TileHeaderComponent,
	TileActionsComponent,
	TileContentComponent
];

@NgModule({
	declarations: declarations,
	imports: [
		CommonModule,
		FmMaterialModule
	],
	exports: declarations
})
export class TileModule {
}
