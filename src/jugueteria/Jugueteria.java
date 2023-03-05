package jugueteria;

import java.net.URL;
import java.util.ArrayList;

import abstractas.JugueteriaCRUD;
import interfacesEngine.FiltroEngineRoute;
import interfacesEngine.FiltroEngineUrl;
import recursos.TextEngine;





public class Jugueteria extends JugueteriaCRUD implements FiltroEngineRoute, FiltroEngineUrl
{
	
	//---------------------------CAMPOS DE CLASE---------------------------
	private ArrayList<Juguete> Registros = new ArrayList<Juguete>();
	
	//Campos para instanciar TE e indicar en donde se va a guardar el documento txt
	private String fileName = "Registros.txt";
	private String route = "BaseDeDatos/";
	private TextEngine TE = new TextEngine(route, fileName);
	
	//Campos para instanciar TR con una URL e indicar en donde se va a guardar el documento txt
	private URL url = Jugueteria.class.getResource("BaseDeDatos/Registros.txt");	
	private TextEngine TR = new TextEngine(url);
	

	
	//---------------------------METODOS GENERALES---------------------------
		
	//Obtener juguete
	public Juguete getJuguete(int index) 
	{
		return Registros.get(index);		
	}
	
	
	//Obtener el ultimo juguete
	public Juguete getLastToy() 
	{
		//Se devuelve el ultimo elemento de los registros	
		return Registros.get(Registros.size() -1);
	}
	
	
	//Obtener el tamaño del ArrayList Registros
	public int getRegistrosSize() 
	{
		return Registros.size();
	}
	
	
	//Obtener el index del juguete obtenido
	public int getIndexOf(Juguete jug) 
	{
		return Registros.indexOf(jug);
	}
	
	
	//Obtener el index mediante el id
	public int getIndexByID(int id) 
	{
		int posicion = -1;	
		
		for (Juguete Toy : Registros) {

			if (Toy.getId_jug() == id) {
				posicion = Registros.indexOf(Toy);
			}
		}
		
		return posicion;
	}
	
	
	//Verificar si el ArrayList Registros esta vacio
	public boolean isRegistrosEmpty() 
	{
		if(Registros.isEmpty()) 
		{
			return true;
		}else {
			return false;
		}
	}
	
	
	
	//---------------------------METODOS CRUD---------------------------
	
	//Agregar juguetes del Arraylist Registros
	public void addToy(Juguete toy) 
	{
		Registros.add(toy);
			
	}
		
	//Leer juguetes del ArrayList Registros
	public void readToys() 
	{
		for(Juguete toy: Registros) 
		{
			int index = Registros.indexOf(toy);
			System.out.println("Index : " + index + "  -> Nombre: " + toy.getNom_jug());
		}
		
	}
	
	//Modificar juguetes del Arraylist Registros
	public void modifyToy(int index, Juguete modifiedToy) 
	{
		Registros.set(index, modifiedToy);
		
	}
	
	//Eliminar juguetes del Arraylist Registros 
	public void deleteToy(int index) 
	{
		Registros.remove(index);
		
	}
	
	

	//---------------------------METODOS EngineRoute---------------------------
	
	//METODO Que recibe strings con los objetos del archivo de texto y los convierte en objetos juguetes
	public void readRegistrosFile() 
	{				
		ArrayList<String> lectura = TE.readData();
		int indexes[] = new int[lectura.size()];
		int i = 0;
		
		//Se verifica si existen lineas vacias dentro de lectura		
		for(String line:lectura) {
			
			if(line.equals("")) {
				
				i++;
			}
		}
			
		//Se leen los elementos omitiendo lineas vacias al comienzo
		try {				
			for(String item: lectura ) {
				
				if(i == 1) {
					
					i++;
					
				}else {
					
					String[] lineaActual = item.split(",");		
					//Juguete -> [id || int] [nombre || String] [precio || Float] [marca || string] [categoria || int] [proveedor || proveedor] [stock || int]
					Registros.add(new Juguete(Integer.parseInt(lineaActual[0]), lineaActual[1], Float.parseFloat(lineaActual[2]), lineaActual[3], Integer.parseInt(lineaActual[4]), Integer.parseInt(lineaActual[5]), Integer.parseInt(lineaActual[6])));
				}
					
			}
				
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("ERROR ->"  + e.getMessage());
			System.out.println("File Vacio");
		}			
	}
		
	
	//Se actualizan los registros sobreescribiendo el archivo de texto con los registros actuales
	public void updateRegistroFile() 
	{
		TE.writeNewData("");
		for(Juguete toy: Registros) {
			TE.writeData(toy);
		}
	}
	
	//Se crea un archivo de texto con la direccion indicada
	public void createFile() 
	{
		TE.createFile();
	}
	
	//Checa si el folder esta vacio
	public boolean verifyFolder() 
	{
		return TE.verifyFolder();
	}
	
	
	
	//---------------------------METODOS EngineUrl---------------------------
	// 			*NOTA* -> Actualmente estos metodos no funcionan de forma correcta
	
	//Lee los registros mediante una direccion URL
	public void readRegistrosFileURL() 
	{				
		ArrayList<String> lectura = TR.readDatabyURL();
		int indexes[] = new int[lectura.size()];
		int i = 0;
			
		for(String line:lectura) {
			System.out.println("M -> " + line);
			if(line.equals("")) {
				
				i++;
			}
		}
			
						
		System.out.println(i);
						
			
		try {
				
			for(String item: lectura ) {
				if(i == 1) {
					i++;
				}else {
					String[] lineaActual = item.split(",");
					System.out.println("[A] -> " + item);
					//System.out.println("Añadido");
					Registros.add(new Juguete(Integer.parseInt(lineaActual[0]), lineaActual[1], Float.parseFloat(lineaActual[2]), lineaActual[3], Integer.parseInt(lineaActual[4]), Integer.parseInt(lineaActual[5]), Integer.parseInt(lineaActual[6])));
				}
					
			}
				
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("File Vacio");
		}			
	}
	
	//Imprime una URL
	public void imprimirURL() {
		System.out.println("Url desde consola -> " + url);
	}


}

