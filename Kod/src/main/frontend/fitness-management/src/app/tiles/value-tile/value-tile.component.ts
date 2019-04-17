import {Component, OnInit} from '@angular/core';
import {AbstractTile} from "../abstract-tile";

@Component({
	selector: 'app-value-tile',
	templateUrl: './value-tile.component.html',
	styleUrls: ['./value-tile.component.scss']
})
export class ValueTileComponent extends AbstractTile implements OnInit {

	constructor() {
		super();
	}

	ngOnInit() {
	}

}
