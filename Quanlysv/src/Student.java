public class Student {
    private String name;

    private int age;

    private String email;

    private String phone;

    private String code;

    private int gender;

    private float grade;



    public Student(String name, int age, String email, String phone, String code, int gender, float grade) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
        this.code = code;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name; }


    public int getAge() {
        return age; }


    public String getEmail() {
        return email; }


    public String getPhone() {
        return phone; }


    public String getCode() {
        return code; }


    public int getGender() {
        return gender; }


    public float getGrade() {
        return grade; }


    @Override
    public String toString() {

        return "Name: " + name +
                ", Age: " + age +
                ", Email: " + email +
                ", Phone: " + phone +
                ", Code: " + code +
                ", Gender: " + gender +
                ", Grade: " + grade;
    }
}