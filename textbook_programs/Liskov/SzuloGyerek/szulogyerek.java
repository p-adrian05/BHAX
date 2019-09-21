class Person {
    protected int age;
    protected String name;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return this.age;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person2 extends Person {
    private String email;

    public Person2(String name, int age, String email) {
        super(name, age);
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

}

class szuloGyerek {

    public static void main(String args[]) {
        Person person = new Person2("Pisti", 37, "email@email.com");

        System.out.println(person.getEmail());
        // System.out.println(((Person2) person).getEmail());
    }
}