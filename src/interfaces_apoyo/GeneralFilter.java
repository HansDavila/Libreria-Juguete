package interfaces_apoyo;

import jugueteria.Juguete;

public interface GeneralFilter<T> {
	public abstract T getItem(int index);
	public abstract T getLastItem();
	public abstract int getRegistrosSize();
	public abstract int getIndexOf(T item);
	public abstract int getIndexByID(int id); 
	public abstract boolean isRegistrosEmpty();
	public abstract void readItems();
	public abstract void modifyItem(int index, T modifiedItem);
	public abstract void deleteItem(int index);
	public abstract void addItem(T item);

}
