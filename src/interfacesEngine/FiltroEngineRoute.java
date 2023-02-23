package interfacesEngine;



public interface FiltroEngineRoute extends FiltroGeneral
{
	
	public abstract void readRegistrosFile();
	public abstract void updateRegistroFile();
	public abstract void createFile();
	public boolean verifyFolder();
}
