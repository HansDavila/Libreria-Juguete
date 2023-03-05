package interfacesEngine;



public interface FiltroEngineRoute<T> extends FiltroGeneral
{
	
	public abstract void readRegistrosFile();
	public abstract void updateRegistroFile();
	public abstract void createFile();
	public boolean verifyFolder();
}
