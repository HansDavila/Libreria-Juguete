package jugueteria;

import java.util.ArrayList;

import interfacesEngine.FiltroEngineRoute;
import interfaces_apoyo.EngineRouteFilter;
import tienda.TIENDA;

public class Pruebas {

	public static <T> void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<T> listaArticulos = new ArrayList<T>();
		Jugueteria J = new Jugueteria();
		TIENDA<Juguete> T = new TIENDA<Juguete>(Juguete.class);
		EngineRouteFilter ER = new TIENDA<Juguete>(Juguete.class); 
		
		
		
		J.readRegistrosFile();	
		J.readToys();
		
		FiltroEngineRoute F = new Jugueteria();
		
		
		
		listaArticulos.add( (T) new Juguete(1, "Zelda", 800, "Nintendo", 1, 1, 5));
		listaArticulos.add( (T) new Juguete(2, "Halo", 500, "Microsoft", 4, 2, 10));
		listaArticulos.add( (T) new Juguete(3, "TLOU", 1200, "Sony", 3, 3, 12));
		listaArticulos.add( (T) new Juguete(4, "Mario Odessey", 1500, "Nintendo", 1, 1, 11));
		

		for(Juguete obj: J.getRegistrosList()) {
			listaArticulos.add((T) obj);
		}
		
		
		for(T objeto: listaArticulos) 
		{
			J.usandoReflection(objeto);			
			T.reflectionID(objeto);
		}
		
		System.out.println("continue:");
		
		T.readRegistrosFile();
		System.out.println("read:");
		T.readItems();
		System.out.println("size ->" + T.getRegistrosSize());

		
	}

}
