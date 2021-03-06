package sg.edu.rp.c346.workouttracker;

public class Records {

    private String name;
    private String sets;
    private String reps;



    public Records(String name, String sets, String reps) {
        this.name = name;
        this.sets = sets;
        this.reps = reps;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSets() {
        return sets;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public String getReps() {
        return reps;
    }

    public void setReps(String reps) {
        this.reps = reps;
    }

    @Override
    public String toString() {
        return "Records{" +
                "name='" + name + '\'' +
                ", sets='" + sets + '\'' +
                ", reps='" + reps + '\'' +
                '}';
    }
}

