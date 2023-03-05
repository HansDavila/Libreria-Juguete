package abstractas;

public abstract class CRUD<T> {
	
	//Agregar juguetes del Arraylist Registros
	
	public abstract void addItem(T item);
	
	public abstract void readItems();
	
	
	public abstract void modifyItem(int index, T modifiedItem);
	
	
	public abstract void deleteItem(int index); 

	
	
}
