import {User} from "../models";
import {SERVICE_PACKAGES} from "./mock-service-packages";

export const USERS: User[] = [
	{
		firstName: 'Name1',
		surname: 'Surname1',
		startDate: new Date(),
		cardNumber: 234567890,
		servicePackage: SERVICE_PACKAGES[0]
	},
	{
		firstName: 'Name2',
		surname: 'Surname2',
		startDate: new Date(),
		cardNumber: 234567891,
		servicePackage: SERVICE_PACKAGES[2]
	},
	{
		firstName: 'Name3',
		surname: 'Surname3',
		startDate: new Date(),
		cardNumber: 234567892,
		servicePackage: SERVICE_PACKAGES[1]
	},
	{
		firstName: 'Name4',
		surname: 'Surname4',
		startDate: new Date(),
		cardNumber: 234567893,
		servicePackage: SERVICE_PACKAGES[0]
	},
	{
		firstName: 'Name5',
		surname: 'Surname5',
		startDate: new Date(),
		cardNumber: 234567894,
		servicePackage: SERVICE_PACKAGES[3]
	}
];