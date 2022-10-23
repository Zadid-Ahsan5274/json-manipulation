package lib;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonHandling {

	public static void writeFile() {
		try {
			FileWriter fw = new FileWriter("MyFile.txt");
			// fw.write("Hello World");
			fw.write("[]");
			fw.write("\r\n"); // write new line
			fw.write("Hello Java!");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile() throws IOException {
		FileReader reader = new FileReader("MyFile.txt");
		int character;
		while ((character = reader.read()) != -1) {
			System.out.print((char) character);
		}
		reader.close();
	}

	public static void writeJSONFile(String fileName) throws IOException {
		JSONObject empObj = new JSONObject();
		empObj.put("name", "Mr. Shajib");
		empObj.put("Department", "IT");
		empObj.put("Designation", "Software Engineer");
		JSONObject addressObj = new JSONObject();
		addressObj.put("present_address", "Badda,Gulshan-1");
		addressObj.put("PO", "Gulshan");
		addressObj.put("Area", "Gulshan-1");
		empObj.put("address", addressObj);
		empObj.put("phone_number", "01620141540");
		FileWriter file = new FileWriter(fileName);
		file.write(empObj.toJSONString());
		file.flush(); // better time saving - hence better to use "flush"
		System.out.print(empObj);
	}

	public static void readJSONFile() throws IOException, ParseException {
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader("./src/main/resources/Employee.json"));
		JSONObject empObj = (JSONObject) obj;

		System.out.println(empObj);
		String name = (String) empObj.get("name");
		System.out.println(name);
		String department = (String) empObj.get("Department");
		System.out.println(department);
		String designation = (String) empObj.get("Designation");
		System.out.println(designation);

		JSONObject addressObj = (JSONObject) empObj.get("address");
		String area = (String) addressObj.get("Area");
		System.out.println(area);
		String po = (String) addressObj.get("PO");
		System.out.println(po);
		String present_address = (String) addressObj.get("present_address");
		System.out.println(present_address);

		String phone_number = (String) empObj.get("phone_number");
		System.out.println(phone_number);
	}

	public static void writejsonList() throws IOException, ParseException {
		char ch = 'y';
		String fileName = "./src/main/resources/Student.json";
		do {
			JSONParser jsonParser = new JSONParser();
			Object obj = jsonParser.parse(new FileReader(fileName));
			JSONObject studentObj = new JSONObject();

			Scanner input = new Scanner(System.in);
			System.out.println("Input student ID: ");
			studentObj.put("id", input.next());
			System.out.println("Input student name: ");
			studentObj.put("name", input.next());
			System.out.println("Input Department ");
			studentObj.put("department", input.next());

			JSONArray jsonArray = (JSONArray) obj;
			jsonArray.add(studentObj);
			System.out.print(jsonArray);
			FileWriter file = new FileWriter(fileName);
			file.write(jsonArray.toJSONString());
			file.flush();
			file.close();
			System.out.println("Saved!");
			System.out.print(jsonArray);
			System.out.println("\nDo you want to add more?[y/n]");
			ch = input.next().charAt(0);
		} while (ch != 'n');
	}

	public static void readJSONArray(int pos) throws IOException, ParseException {

		String fileName = "./src/main/resources/Student.json";
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(fileName));
		JSONArray jsonArray = (JSONArray) obj;
		System.out.println(jsonArray);
		JSONObject json = (JSONObject) jsonArray.get(pos);

		String name = (String) json.get("name");
		String id = (String) json.get("id");
		// String section = (String) json.get("section");
		// String _class = (String) json.get("class");
		System.out.println(name);
		System.out.println(id);
		// System.out.println(section);
		// System.out.println(_class);
	}

	public static void updateJSON(String key, String value) throws IOException, ParseException {
		String fileName = "employee.json";
		JSONParser jsonParser = new JSONParser();
		Object obj = jsonParser.parse(new FileReader(fileName));
		JSONObject empObj = (JSONObject) obj;
		System.out.println(empObj);
		empObj.put("Department", "IT");
		FileWriter file = new FileWriter(fileName);
		file.write(empObj.toJSONString());
		file.flush();
		file.close();
		System.out.println("Updated!");
		System.out.print(empObj);
	}

	public static void main(String[] args) throws IOException, ParseException {
		// writeFile();
		// readFile();
		// writeJSONFile("./src/main/resources/Employee.json");
		// writeJSONFile("./src/main/resources/Student.json");
		// readJSONFile();
		// writejsonList();
		readJSONArray(0);

	}

}
