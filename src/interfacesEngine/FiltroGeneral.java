package interfacesEngine;

import jugueteria.Juguete;

public interface FiltroGeneral {

	public abstract Juguete getJuguete(int index);
	public abstract Juguete getLastToy();
	public abstract int getRegistrosSize();
	public abstract int getIndexOf(Juguete jug);
	public abstract int getIndexByID(int id); 
	public abstract boolean isRegistrosEmpty();
	public abstract void readToys();
	public abstract void modifyToy(int index, Juguete modifiedToy);
	public abstract void deleteToy(int index);
	public abstract void addToy(Juguete toy);
}
