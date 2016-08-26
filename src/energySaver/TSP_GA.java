package energySaver;

public class TSP_GA {

    public static void main(String[] args) {

        // cria e adiociona as cidades
        City city = new City(60, 200, "maceio");
        TourManager.addCity(city);
        City city2 = new City(180, 200,"Pindoba");
        TourManager.addCity(city2);
        City city3 = new City(80, 180,"satuba");
        TourManager.addCity(city3);
        City city4 = new City(140, 180,"rio largo");
        TourManager.addCity(city4);
        City city5 = new City(20, 160,"coite do noia");
        TourManager.addCity(city5);
        City city6 = new City(100, 160,"cacimbinhas");
        TourManager.addCity(city6);
        City city7 = new City(200, 160,"agua branca");
        TourManager.addCity(city7);
        City city8 = new City(140, 140,"olho dagua");
        TourManager.addCity(city8);
        City city9 = new City(40, 120,"coruripe");
        TourManager.addCity(city9);
        City city10 = new City(100, 120,"mata do rolo");
        TourManager.addCity(city10);
        City city11 = new City(180, 100,"joao sampaio");
        TourManager.addCity(city11);
        City city12 = new City(60, 80,"jaqueira");
        TourManager.addCity(city12);
        City city13 = new City(120, 80,"campestre");
        TourManager.addCity(city13);
        City city14 = new City(180, 60,"arapiraca");
        TourManager.addCity(city14);
        City city15 = new City(20, 40,"bananal");
        TourManager.addCity(city15);
        City city16 = new City(100, 40,"palmeira");
        TourManager.addCity(city16);
        City city17 = new City(200, 40,"cruzeiro do sul");
        TourManager.addCity(city17);
        City city18 = new City(20, 20,"garanhuns");
        TourManager.addCity(city18);
        City city19 = new City(60, 20,"recife");
        TourManager.addCity(city19);
        City city20 = new City(160, 20,"penedo");
        TourManager.addCity(city20);

        // inicializa a população
        Population pop = new Population(50, true);
        System.out.println("Initial distance: " + pop.getFittest().getDistance());

        // Evolui a população paara 100 gerações
        pop = GA.evolvePopulation(pop);
        for (int i = 0; i < 100; i++) {
            pop = GA.evolvePopulation(pop);
        }

        // resultado final
        System.out.println("Finished");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}