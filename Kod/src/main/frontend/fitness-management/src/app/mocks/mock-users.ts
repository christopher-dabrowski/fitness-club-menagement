import {User} from "../models";
import {SERVICE_PACKAGES} from "./mock-service-packages";

export const USERS: User[] = [
	{
		firstName: 'First Name1',
		surname: 'Last Name1',
		startDate: new Date(),
		cardNumber: 234567890,
		servicePackage: SERVICE_PACKAGES[0]
	},
	{
		firstName: 'First Name2',
		surname: 'Last Name2',
		startDate: new Date(),
		cardNumber: 234567891,
		servicePackage: SERVICE_PACKAGES[2]
	},
	{
		firstName: 'First Name3',
		surname: 'Last Name3',
		startDate: new Date(),
		cardNumber: 234567892,
		servicePackage: SERVICE_PACKAGES[1]
	},
	{
		firstName: 'First Name4',
		surname: 'Last Name4',
		startDate: new Date(),
		cardNumber: 234567893,
		servicePackage: SERVICE_PACKAGES[0]
	},
	{
		firstName: 'First Name5',
		surname: 'Last Name5',
		startDate: new Date(),
		cardNumber: 234567894,
		servicePackage: SERVICE_PACKAGES[3]
	}
];