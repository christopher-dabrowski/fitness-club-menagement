export class servicePackage {
	name: string;
	cost: number;
	duration: number;
	classesIncluded: boolean;

}

export class Person {
	firstName: string;
	surname: string;
}

export class Occupation {
	name: string;
	since: Date;
	to: Date;
	hours: number;
	salary: number;

}

export class Employee extends Person{
	id: number;
	occupation: Occupation;

}

export class User extends Person{
	startDate: Date;
	cardNumber: number;
	servicePackage: servicePackage;
}


export enum Mode {
	VIEW, EDIT, DELETE
}

export enum Confirmation{
	ASK, DONTASK
}

export enum DialogCloseMessage{
	SAVE, CANCEL
}

export class DialogCloseResult<T>{
	data: T;
	message: DialogCloseMessage;
}