package nl.scalda.woshmato.models;

public class Category implements Comparable<Category>{

	private int id;
	private String name;
	
	public Category(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Category() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

    @Override
    public int compareTo(Category t) {
        if(this.getName().equals(t.getName())){
            return 0;
        }
        return 1;
    }
}
