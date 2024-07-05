/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class ClimateData {
    private ArrayList<CountryTemperature> countryTemperatures;

    public ClimateData() {
        countryTemperatures = new ArrayList<>();
    }

    public void updateData(String country) {
        Random rand = new Random();
        int newTemperature;
        CountryTemperature foundCountry = findCountry(country);

        if (foundCountry != null) {
            int currentTemperature = foundCountry.getTemperature();
            int change = rand.nextInt(13) - 6; 
            newTemperature = currentTemperature + change;
            foundCountry.setTemperature(newTemperature);
        } else {
            newTemperature = rand.nextInt(40);
            countryTemperatures.add(new CountryTemperature(country, newTemperature));
        }
    }

    public void displayData(String country) {
        CountryTemperature foundCountry = findCountry(country);

        if (foundCountry != null) {
            int temperature = foundCountry.getTemperature();
            System.out.println(country + " current climate data:");
            System.out.println("Temperature: " + temperature + " degree");
        } else {
            System.out.println(country + " has no climate data. Please enter the country to generate data.");
        }
    }

    private CountryTemperature findCountry(String country) {
        for (CountryTemperature ct : countryTemperatures) {
            if (ct.getCountry().equalsIgnoreCase(country)) {
                return ct;
            }
        }
        return null;
    }
}

class CountryTemperature {
    private String country;
    private int temperature;

    public CountryTemperature(String country, int temperature) {
        this.country = country;
        this.temperature = temperature;
    }

    public String getCountry() {
        return country;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}

public class RealTimeClimateData {
    public static void main(String[] args) {
        ClimateData climateData = new ClimateData();
        Scanner scanner = new Scanner(System.in);
        String userInput;

        do {
            System.out.println("Enter the country name to get or update climate data, or 'exit' to quit:");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("exit")) {
                climateData.updateData(userInput);
                climateData.displayData(userInput);
            }
        } while (!userInput.equalsIgnoreCase("exit"));

        scanner.close();
        System.out.println("Program has ended.");
    }
}