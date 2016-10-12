package jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TaskInfo {

	public TaskInfo(String id, Parent parentList) {
		super();
		this.id = id;
		this.parentList = parentList;
	}

	private String id;
	private Parent parentList;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Parent getParentList() {
		return parentList;
	}

	public void setParentList(Parent parentList) {
		this.parentList = parentList;
	}

	public static void main(String args[]) throws IOException {
		Parent parent = new Parent("123");
		TaskInfo taskInfo = new TaskInfo("taskID", parent);
		String json = new ObjectMapper().writeValueAsString(taskInfo);

		System.out.println(json);
	}

}

class Parent {

	public Parent(String parentId) {
		this.parentId = parentId;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	private String parentId;
	// Parent class code
}