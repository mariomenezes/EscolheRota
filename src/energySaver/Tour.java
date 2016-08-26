package energySaver;


import java.util.ArrayList;
import java.util.Collections;

public class Tour{

    private ArrayList tour = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    
    // cria um tour vazio
    public Tour(){
        for (int i = 0; i < TourManager.numberOfCities(); i++) {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour){
        this.tour = tour;
    }

    // cria um individuo randomico
    public void generateIndividual() {
    	// loop por todas as cidades destino e adiciona no nosso tour
        for (int cityIndex = 0; cityIndex < TourManager.numberOfCities(); cityIndex++) {
          setCity(cityIndex, TourManager.getCity(cityIndex));
        }
        // sorteia uma ordem para o nosso tour criado
        Collections.shuffle(tour);
    }

    // retorna uma cidade do tour
    public City getCity(int tourPosition) {
        return (City)tour.get(tourPosition);
    }

    // adiciona uma cidade em uma posição especifica do tour
    public void setCity(int tourPosition, City city) {
        tour.set(tourPosition, city);
        // quando o tour é alterado é preciso redefinir fitness e distance
        fitness = 0;
        distance = 0;
    }
    
    // retorna o fitness
    public double getFitness() {
        if (fitness == 0) {
            fitness = 1/(double)getDistance();
            //TODO adicionar ao cálculo do fitness informações sobre congestionamento na regiao
        }
        //System.out.println("valor do nosso fitness " + fitness);
        return fitness;
    }
    
    // retorna a distancia total do tour
    public int getDistance(){
        if (distance == 0) {
            int tourDistance = 0;
            // Loop through our tour's cities
            for (int cityIndex=0; cityIndex < tourSize(); cityIndex++) {
                // recebe a cidade de onde estamos saindos
                City fromCity = getCity(cityIndex);
                // cidade para onde vamos
                City destinationCity;
                // verifica se estamos na ultima cidade do out, se estiver
                // setamos nosso destino final para nossa cidade inicial
                if(cityIndex+1 < tourSize()){
                    destinationCity = getCity(cityIndex+1);
                }
                else{
                    destinationCity = getCity(0);
                }
                // recebe a distancia entre duas cidades
                tourDistance += fromCity.distanceTo(destinationCity);
            }
            distance = tourDistance;
        }
        return distance;
    }

    // numero de cidades no tour
    public int tourSize() {
        return tour.size();
    }
    
    // verofoca se o tour possui uma dada cidade
    public boolean containsCity(City city){
        return tour.contains(city);
    }
    
    //@Override
    public String toString() {
        String geneString = "|";
        for (int i = 0; i < tourSize(); i++) {
            geneString += getCity(i)+"|\n";
        }
        return geneString;
    }
}