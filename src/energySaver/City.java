package energySaver;


public class City {
    private int x;
    private int y;
    private String name;
    
    // construtor de city, adiciona as coordenadas x,y e o nome da cidade
    public City(int x, int y, String name){
        this.x = x;
        this.y = y;
        this.name = name;
    }
    
    // retorna a coordenada x da cidade
    public int getX(){
        return this.x;
    }
    
    // retorna a coordenada y da cidade
    public int getY(){
        return this.y;
    }
    public String getName(){
    	return name;
    }
    
    // retorna a distancia da cidade dada
    public double distanceTo(City city){
        int xDistance = Math.abs(this.getX() - city.getX()); //adicionado this
        int yDistance = Math.abs(this.getY() - city.getY()); //adicionado o this
        double distance = Math.sqrt( (xDistance*xDistance) + (yDistance*yDistance) );
        
        return distance;
    }
    
    //@Override
    public String toString(){
        return getX()+", "+getY()+", "+getName();
    }
}