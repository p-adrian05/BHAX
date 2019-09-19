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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Person2 extends Person {
    public Person2(String name, int age) {
        super(name, age);
    }

    public int getAge() {
        return age;
    }
}

public class szuloGyerek {

    public static void main(String args[]) {
        Person person = new Person2("Pisti", 37);
        Person2 person2 = new Person2("Jani", 27);

        System.out.println(person.getAge() + " " + person2.getAge());
        // System.out.println(((Person2) person).getAge()+" "+person2.getAge());
    }
}