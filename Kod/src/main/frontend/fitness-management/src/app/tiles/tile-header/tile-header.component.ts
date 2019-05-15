import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
	selector: 'tile-header',
	templateUrl: './tile-header.component.html',
	styleUrls: ['./tile-header.component.scss']
})
export class TileHeaderComponent implements OnInit {

	@Output()
	onModeChange = new EventEmitter();

	@Input()
	optionsButton: boolean = false;

	@Output()
	onOptionsButtonClicked = new EventEmitter();

	constructor() {
	}

	ngOnInit() {
	}

	optionsButtonClick() {
		this.onOptionsButtonClicked.emit();
	}
}
