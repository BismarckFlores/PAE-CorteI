package ni.edu.uam.paecortei.models;

public class Employe {
    private String names;
    private String surnames;
    private String position;
    private float salary;

    public Employe() {
    }

    public Employe(String names, String surnames, String position, float salary) {
        this.names = names;
        this.surnames = surnames;
        this.position = position;
        this.salary = salary;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurnames() {
        return surnames;
    }

    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return names + ' ' + surnames;
    }
}
