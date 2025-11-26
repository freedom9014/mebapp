package human;

public class Student {
    private String name;
    private int height;
    private double weight;
    private String studentID;

    public void setName(String name){
        this.name = name;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public void setWeight(double weight){
        this.weight = weight;
    }
    public void setStudentID(String studentID){
        this.studentID = studentID;
    }
    
    public String getName(){
        return name;
    }

    public int getHeight(){
        return height;
    }

    public double getWeight(){
        return weight;
    }

    public String getStudentID(){
        return studentID;
    }
}
