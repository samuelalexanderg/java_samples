package jackson;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonBean {

	private int age;
	private String name;
	private List<String> messages = new ArrayList<String>();
	private JsonBean subBean;

	public JsonBean(int age, String name, List<String> messages) {
		this.age = age;
		this.name = name;
		this.messages = messages;
	}

	// getter and setter methods

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "User [age=" + age + ", name=" + name + ", " + "messages=" + messages + "]";
	}

	public static void main(String[] args) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonBean jsonBean = new JsonBean(1, null, null);
		System.out.println(objectMapper.writeValueAsString(jsonBean));
	}

	public JsonBean getSubBean() {
		return subBean;
	}

	public void setSubBean(JsonBean subBean) {
		this.subBean = subBean;
	}
}