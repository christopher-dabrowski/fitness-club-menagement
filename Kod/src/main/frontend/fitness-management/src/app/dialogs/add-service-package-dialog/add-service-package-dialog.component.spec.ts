import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {AddServicePackageDialogComponent} from './add-service-package-dialog.component';

describe('AddServicePackageDialogComponent', () => {
	let component: AddServicePackageDialogComponent;
	let fixture: ComponentFixture<AddServicePackageDialogComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [AddServicePackageDialogComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(AddServicePackageDialogComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
