import {servicePackage} from "../models";

export const SERVICE_PACKAGES: servicePackage[] = [
	{
		name: 'Beginner',
		cost: 30,
		duration: 1,
		classesIncluded: false
	},
	{
		name: 'Intermediate',
		cost: 50,
		duration: 2,
		classesIncluded: true
	},
	{
		name: 'Open',
		cost: 75,
		duration: 1,
		classesIncluded: false
	},
	{
		name: 'Professional',
		cost: 100,
		duration: 1,
		classesIncluded: true
	}
]