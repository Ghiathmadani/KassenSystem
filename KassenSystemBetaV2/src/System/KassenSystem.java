package System;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class KassenSystem {

	static KassenUtility utility = new KassenUtility();
	static Scanner reader = new Scanner(System.in);

	public static void main(String[] args) {

		// fields
		int chosenWare, removedWare, auswahl, menge;
		String x = "yes", wareName;
		double zwischenSumme = 0.0, warePrice;

		utility.logo();
		try {
			utility.loadLageVonDatabase();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		try {
			while (true) {
				utility.consoleMenu();
				auswahl = reader.nextInt();

				switch (auswahl) {

				case 1:
//					try (Connection c = Lage.getConnectionInMemoryDatabase()) {
//						Lage.printLage(c);
//					}
					System.out.println(Lage.listToString(Lage.lagelist));
					break;
				case 2:
					System.out.print("Schreiben Sie den Name der Ware ?");
					wareName = reader.next();
					System.out.print("Schreiben Sie die Menge der Ware ?");
					menge = reader.nextInt();
					System.out.print("Schreiben Sie den Price der Ware ?");
					warePrice = reader.nextDouble();
					Lage.lagelist.add(new Ware(wareName, menge, warePrice));
					System.out.println("Item added successfully!");
					System.out.println(Lage.listToString(Lage.lagelist));
					break;

				case 3:

					System.out.println(Lage.listToString(Lage.lagelist));
					System.out.print("Enter the Item's id to remove: ");
					auswahl = reader.nextInt();
					Lage.lagelist.remove(auswahl - 1);
					System.out.println("Item removed successfully!");
					System.out.println(Lage.listToString(Lage.lagelist));
					break;

				case 4:
					System.out.println(Lage.listToString(Lage.lagelist));
					System.out.print("Geben Sie Id-Nummer der Ware zu aktualisieren");
					auswahl = reader.nextInt();
					Ware alteWare = Lage.lagelist.get(auswahl - 1);
					System.out.print("Geben Sie den neuen Name zu aktualisieren");
					wareName = reader.next();
					System.out.print("Geben Sie den neuen Menge zu aktualisieren");
					menge = reader.nextInt();
					System.out.print("Geben Sie den neuen Price zu aktualisieren");
					warePrice = reader.nextDouble();
					alteWare.setName(wareName);
					alteWare.setMenge(menge);
					alteWare.setPrice(warePrice);
					System.out.println("Waren aktualisiert");
					System.out.println(Lage.listToString(Lage.lagelist));
					break;

				case 5:
					do {
						System.out.println(Lage.listToString(Lage.lagelist));
						System.out.println("Welche Ware möchten Sie bestellen [1][2][3][4].... ");
						chosenWare = reader.nextInt();
						System.out.print("Wie viele Stück möchten Sie ? ");
						menge = reader.nextInt();
						if (menge > Lage.lagelist.get(chosenWare - 1).getMenge()) {
							System.out.println(
									"Sorry, Wir haben nur " + Lage.lagelist.get(chosenWare - 1).getMenge() + " Stück");
						}
						zwischenSumme += utility.getDerPrice.apply(Lage.lagelist.get(chosenWare - 1), menge);
						Lage.lagelist.get(chosenWare - 1).decreaseMenge(menge);
						// noch fage
						System.out.println("Möchten Sie noch bestellen ? [ja][nein] ");
						x = reader.next();
					} while (x.equalsIgnoreCase("ja"));

					System.out.println("Ihre Rechnung ohne MWST  " + zwischenSumme);
					double Summe = zwischenSumme + (zwischenSumme / 100 * 0.7);
					System.out.println("Ihre Rechnung mit MWST (0.7%)  " + (Summe));
					utility.barBezahlen(Summe);
					break;
				case 6:
					System.out.println(
							"\n---------------------------- Danke und bitte komm wieder :)-----------------------------\n");
					System.exit(1);
					break;
				default:
					System.out.println("Invalid input");
					continue;
				}
			}
		} catch (InputMismatchException  e) {
			System.out.println("You have made an invalid input");
		}catch (Exception e) {
			System.out.println("You have made something invalid (Andere Exception)");
	}
	}

}
