package beans;

public class Teacher {
    private int id;
    private String teacher_name;
    private String teacher_password;

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", teacher_name='" + teacher_name + '\'' +
                ", teacher_password='" + teacher_password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    public String getTeacher_password() {
        return teacher_password;
    }

    public void setTeacher_password(String teacher_password) {
        this.teacher_password = teacher_password;
    }
}
