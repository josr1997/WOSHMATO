package nl.scalda.woshmato.models;

public class Task {

    private int id;
    private String name;
    private String description;
    private double lessonhour;
    private double clockhour;
    private Category category;
    private int archived;

    public Task(int id, String name, String description, double lessonhour, double clockhour, int archived, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lessonhour = lessonhour;
        this.clockhour = clockhour;
        this.archived = archived;
        this.category = category;
    }

    public Task(int id, String name, String description, double lessonhour, int archived, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.lessonhour = lessonhour;
        this.archived = archived;
        this.clockhour = lessonhour * 0.8333333333333333;
        this.category = category;
    }

    public Task(String name, String description, int archived, double clockhour, int id, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clockhour = clockhour;
        this.archived = archived;
        this.lessonhour = clockhour * 1.2;
        this.category = category;
    }

    public Task() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getArchived() {
        return archived;
    }

    public void setArchived(int archived) {
        this.archived = archived;
    }

    public double getLessonhour() {
        return lessonhour;
    }

    public void setLessonhour(double lessonhour) {
        this.lessonhour = lessonhour;
    }

    public double getClockhour() {
        return clockhour;
    }

    public void setClockhour(double clockhour) {
        this.clockhour = clockhour;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
