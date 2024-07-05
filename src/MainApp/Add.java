package MainApp;

import java.util.ArrayList;

public class Add {

    private String country;
    private int numOfDeaths;
    private int numOfInjured;
    private int missingPerson;
    private ArrayList<String> countryList;

    public Add(String Country, int numOfDeaths, int numOfInjured,int missingPerson) {
        this.country = country;
        this.numOfDeaths = numOfDeaths;
        this.numOfInjured = numOfInjured;
        this.missingPerson = missingPerson;

        this.countryList = new ArrayList<>();
        this.countryList.add("United States");
        this.countryList.add("Switzerland");
        this.countryList.add("Sweden");
        this.countryList.add("Kazakhstan");
    }

    public String getCountry() {
        return country;
    }

    public int getNumOfDeaths() {
        return numOfDeaths;
    }

    public int getNumOfInjured() {
        return numOfInjured;
    }
    
    public int getMissingPerson(){
        return missingPerson;
    }

    public void addInfoToCountryList() {
       if (!countryList.contains(country)) {
            countryList.add(country);
        }
       }
    

}
