package energySaver;

import java.util.ArrayList;
/*Apenas armazena todas as cidades*/
public class TourManager {

    private static ArrayList destinationCities = new ArrayList<City>();

    // Adiciona uma cidade destino
    public static void addCity(City city) {
        destinationCities.add(city);
    }
    
    // retorna uma cidade
    public static City getCity(int index){
        return (City)destinationCities.get(index);
    }
    
    // retorna a quantidade de cidades destino
    public static int numberOfCities(){
        return destinationCities.size();
    }
}