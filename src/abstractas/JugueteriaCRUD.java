package abstractas;


import interfacesEngine.FiltroEngineRoute;
import interfacesEngine.FiltroEngineUrl;
import jugueteria.Juguete;

public abstract class JugueteriaCRUD implements FiltroEngineRoute, FiltroEngineUrl
{
	public abstract void readToys();
	
	
	public abstract void modifyToy(int index, Juguete modifiedToy);
	
	
	public abstract void deleteToy(int index); 
	
	
	public abstract void addToy(Juguete toy);
	
}
