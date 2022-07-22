package AddingAndDeletingResource;

public class payloads {
	
	public static String addBody(String name, String job)
	{
		String s = "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return s;
	}
	
	public static String updateBody(String name, String job)
	{
		String s = "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
		return s;
	}

}
