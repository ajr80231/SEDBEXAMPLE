public class Customer {
    private String name;
    private String email;
    private String  city;
    private String occupation;
    private int age;

    public Customer(String name, String email, String city, String ocp, int age){
        this.name = name;
        this.email = email;
        this.city = city;
        this.occupation = ocp;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void print(){
        System.out.println("Customer: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
        System.out.println("City: " + city);
        System.out.println("Occupation: " + occupation);
    }
}
