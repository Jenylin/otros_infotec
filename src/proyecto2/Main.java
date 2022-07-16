package proyecto2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import com.google.gson.Gson;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Date fecha = new Date();
		Gson gson = new Gson();	

		Path path = Path.of("src/archivo.json");
		String lectura = Files.readString(path);
		System.out.println(lectura);
		
		Path path2 = Paths.get("archivo3.json");
		Files.writeString(path2, lectura);
		
		ArchivoJSON arch = gson.fromJson(lectura, ArchivoJSON.class);
		System.out.println(arch.getNombre());
		
		arch.setNombre(arch.getNombre() + "-modificacion");
		Files.writeString(path, gson.toJson(arch, ArchivoJSON.class));
		
	}
	
}
