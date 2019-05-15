import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {EditServicePackageDialogComponent} from './edit-service-package-dialog.component';

describe('EditServicePackageDialogComponent', () => {
	let component: EditServicePackageDialogComponent;
	let fixture: ComponentFixture<EditServicePackageDialogComponent>;

	beforeEach(async(() => {
		TestBed.configureTestingModule({
			declarations: [EditServicePackageDialogComponent]
		})
			.compileComponents();
	}));

	beforeEach(() => {
		fixture = TestBed.createComponent(EditServicePackageDialogComponent);
		component = fixture.componentInstance;
		fixture.detectChanges();
	});

	it('should create', () => {
		expect(component).toBeTruthy();
	});
});
