package tienda;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;

import abstractas.CRUD;
import interfaces_apoyo.EngineRouteFilter;
import interfaces_apoyo.Registro;
import jugueteria.Juguete;
import recursos.TextEngine;

public class TIENDA<T extends Registro> extends CRUD<T> implements EngineRouteFilter<T>{

	//* NOTA: Esta clase TIENDA solo va a trabajar con clases que implementen la clase Registro ya que es indispensable en la lectura de los datos
	
	//---------------------------CAMPOS DE CLASE---------------------------
		private Class<T> clase;
		private ArrayList<T> Registros = new ArrayList<T>();
		
		//Campos para instanciar TE e indicar en donde se va a guardar el documento txt
		private String fileName = "Registros.txt";
		private String route = "BaseDeDatos/";
		private TextEngine TE = new TextEngine(route, fileName);
		
		//Campos para instanciar TR con una URL e indicar en donde se va a guardar el documento txt
		private URL url = TIENDA.class.getResource("BaseDeDatos/Registros.txt");	
		private TextEngine TR = new TextEngine(url);
		

		//CONSTRUCTOR
		//Se obtiene la clase del elemento generico
		public TIENDA(Class<T> clase) {
	        this.clase = clase;
	    }
		
		//---------------------------METODOS GENERALES---------------------------
			
		//Obtener juguete
		public T getItem(int index) 
		{
			return Registros.get(index);		
		}
		
		
		
		//Obtener el ultimo juguete
		public T getLastItem() 
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
		public int getIndexOf(T jug) 
		{
			return Registros.indexOf(jug);
		}
		
		
		//Obtener el index mediante el id
		public int getIndexByID(int id) 
		{
			int posicion = -1;	
			
			for (T item : Registros) {

				if (reflectionID(item) == id) {
					posicion = Registros.indexOf(item);
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
		
		//Metodo que devuelve la lista de los registros
		public ArrayList<T> getRegistrosList(){
			return Registros;		
		}
		
		
		
		//---------------------------METODOS CRUD---------------------------
		
		//Agregar juguetes del Arraylist Registros
		public void addItem(T item) 
		{
			Registros.add(item);
				
		}
			
		//Leer juguetes del ArrayList Registros
		public void readItems() 
		{
			int id;
			for(T item: Registros) 
			{
				System.out.println(item);
			}
			
			
		}
			
		//Modificar juguetes del Arraylist Registros
		public void modifyItem(int index, T modifiedItem) 
		{
			Registros.set(index, modifiedItem);
			
		}
		
		//Eliminar juguetes del Arraylist Registros 
		public void deleteItem(int index) 
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
				System.out.println(line);
				if(line.equals("")) {
					
					i++;
				}
			}
				System.out.println("");
			//Se leen los elementos omitiendo lineas vacias al comienzo
			try {				
				for(String item: lectura ) {
					
					if(i == 1) {
						
						i++;
						
					}else {
						
						String[] lineaActual = item.split(",");		
						//Juguete -> [id || int] [nombre || String] [precio || Float] [marca || string] [categoria || int] [proveedor || proveedor] [stock || int]
						
						//Se crea una instancia de la clase generica
						T objeto = clase.newInstance();						

						//Se parsea la información obtenida del array lineaActual y se guarda en el objeto instanciado
		                objeto.parseLineaActual(lineaActual);
		                Registros.add(objeto);
		               
					}
						
				}
					
			} catch (NumberFormatException | InstantiationException | IllegalAccessException e) {
				// TODO: handle exception
				System.out.println("ERROR ->"  + e.getMessage());
				System.out.println(e);
				System.out.println("File Vacio");
			}			
		}
		
			
		
		//Se actualizan los registros sobreescribiendo el archivo de texto con los registros actuales
		public void updateRegistroFile() 
		{
			TE.writeNewData("");
			for(T item: Registros) {
				TE.writeData(item);
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
						//Registros.add(new Juguete(Integer.parseInt(lineaActual[0]), lineaActual[1], Float.parseFloat(lineaActual[2]), lineaActual[3], Integer.parseInt(lineaActual[4]), Integer.parseInt(lineaActual[5]), Integer.parseInt(lineaActual[6])));
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
		
		
		
		
		
		
		
		//---------------------------METODOS REFLECTION---------------------------
		
		
		public <T> void usandoReflection(T bean) 
		{
			Method[] metodos = bean.getClass().getMethods();		
			String get = "get";
			
			for(Method m: metodos)
			{
				if(m.getName().contains(get) && m.getName().contains("_vid")) 
				{
					if(!m.getName().equals("getClass")) 
					{
						try {
							System.out.print(m.invoke(bean, null) + ", " );
							
						} catch (IllegalAccessException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			System.out.println();
		}
		
		public <T> int reflectionID(T bean) 
		{
			Method[] metodos = bean.getClass().getMethods();		
			String id = "getId";
			
			for(Method m: metodos)
			{
				if(m.getName().contains(id)) 
				{
					if(!m.getName().equals("getClass")) 
					{
						try {
							return (int) m.invoke(bean, null);
							
						} catch (IllegalAccessException | InvocationTargetException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			
			System.out.println();
			return 0;
		}
		

}
