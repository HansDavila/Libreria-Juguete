package interfaces_apoyo;

public interface EngineRouteFilter<T> extends GeneralFilter<T> {

	public abstract void readRegistrosFile();
	public abstract void updateRegistroFile();
	public abstract void createFile();
	public boolean verifyFolder();
}
