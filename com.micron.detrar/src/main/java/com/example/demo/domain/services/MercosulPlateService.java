package com.example.demo.domain.services;

public class MercosulPlateService implements PlateService{

	@Override
	public String generatedPlate() {
		String[] leters = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };
		String[] numbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		String plate = "";
		// LLL NLNN
		
			while (plate.length() < 7) {

				while (plate.length() < 3) {
					Integer letter = (int) Math.floor(Math.random() * (25 - 0) + 0);
					plate += leters[letter];
				}
				if(plate.length() != 4) {
					Integer number = (int) Math.floor(Math.random() * (9 - 0) + 0);
					plate += numbers[number];
				}else {
					Integer letter = (int) Math.floor(Math.random() * (25 - 0) + 0);
					plate += leters[letter];
				}
				
				
			}		
		
		return plate;
	}
}
