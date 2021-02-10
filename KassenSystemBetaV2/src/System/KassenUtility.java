package System;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.function.BiFunction;

public class KassenUtility {
	Scanner reader= new Scanner(System.in);
	
	public void loadLageVonDatabase() throws SQLException{
		try (Connection c = Lage.getConnectionInMemoryDatabase()) {
			Lage.createTable(c);
			Lage.fillTable(c);
			Lage.loadLage(c);
		}
	}
	
	
	public BiFunction<Ware,Integer,Double> getDerPrice = (warePrice,menge)->
	(warePrice.getPrice()) * menge;
	
	public void barBezahlen (double summe) {

        System.out.println("Bitte geben Sie Ihren Geldbetrag ein ?");
        double barGeld = reader.nextDouble();

        if (summe > barGeld) {
            System.out.println("Nicht genug Geld !! Sie sollen "+ summe+"€ bezalen");
            while (summe > barGeld) {
            	System.out.println("Bitte geben Sie Ihren Geldbetrag nochmal ein ?");
            	barGeld = reader.nextDouble();
			}
        }
        else {
            if (summe>=30) {
                double rabatt=summe*0.10;
                summe -=summe*0.10;
                System.out.printf("Ihrer Rabatt = %.2f ",rabatt);
            }
            System.out.printf("Sie haben bezahlt = %.2f € Sie bekommen zurück = %.2f €" , summe , (barGeld - summe));
            System.out.println("\n---------------------------- Danke und bitte komm wieder :)-----------------------------\n");
        }

	}
//	BiFunction<Ware,Integer,Double> getDerPriceMitMWST = (warePrice,menge)->
//	(warePrice.getPrice()) * menge*0.7;
	
	
	public  void consoleMenu() {


        System.out.println("wahlen Sie eine Nummer davon ?");
        System.out.println("1. Zeig die Waren in der Lage. ");
        System.out.println("2. Füg eine Ware zu der Lage ein.");
        System.out.println("3. Lösch eine Ware von der Lage.");
        System.out.println("4. Aktualisieren eine Ware in der Lage.");
        System.out.println("5. Füg eine Ware zum Einkaufswagen ein.");
        System.out.println("6. Exit.");

    }
	public void logo() {
        System.out.println(" _____   ___  ___  ___ _____   ___   _   _  _____     _____  _____  _      _      _____  _____  _____ \n" + 
        		"/  __ \\ / _ \\ |  \\/  |/  __ \\ / _ \\ | | | ||  ___|   /  __ \\|  _  || |    | |    |  ___||  __ \\|  ___|\n" + 
        		"| /  \\// /_\\ \\| .  . || /  \\// /_\\ \\| | | || |__     | /  \\/| | | || |    | |    | |__  | |  \\/| |__  \n" + 
        		"| |    |  _  || |\\/| || |    |  _  || | | ||  __|    | |    | | | || |    | |    |  __| | | __ |  __| \n" + 
        		"| \\__/\\| | | || |  | || \\__/\\| | | |\\ \\_/ /| |___  _ | \\__/\\\\ \\_/ /| |____| |____| |___ | |_\\ \\| |___ \n" + 
        		" \\____/\\_| |_/\\_|  |_/ \\____/\\_| |_/ \\___/ \\____/ (_) \\____/ \\___/ \\_____/\\_____/\\____/  \\____/\\____/ \n" + 
        		"                                                                                                      \n" + 
        		"                                                                                                      \n" + 
        		"______  _____  _    _  _____  _    _           _   __  ___   _____  _____  _____                      \n" + 
        		"| ___ \\|  ___|| |  | ||  ___|| |  | |         | | / / / _ \\ /  ___|/  ___||  ___|                     \n" + 
        		"| |_/ /| |__  | |  | || |__  | |  | |  ______ | |/ / / /_\\ \\\\ `--. \\ `--. | |__                       \n" + 
        		"|    / |  __| | |/\\| ||  __| | |/\\| | |______||    \\ |  _  | `--. \\ `--. \\|  __|                      \n" + 
        		"| |\\ \\ | |___ \\  /\\  /| |___ \\  /\\  /         | |\\  \\| | | |/\\__/ //\\__/ /| |___                      \n" + 
        		"\\_| \\_|\\____/  \\/  \\/ \\____/  \\/  \\/          \\_| \\_/\\_| |_/\\____/ \\____/ \\____/                      \n" + 
        		"                                                                                                      \n" + 
        		"                                                                                                      ");
        System.out.println("Kauff über 30€ ein und bekomm 10% Rabatt nur jetzt Wegen Korona");
	}
}
