#include <iostream>
class Person
{
protected:
    int ageP;
    string nameP;

public:
    Person(string name, int age)
    {
        nameP = name;
        ageP = age;
    }

    void setAge(int age)
    {
        ageP = age;
    }

    string getName()
    {
        return nameP;
    }

    void setName(string name)
    {
        nameP = name;
    }
}

class Person2 : public Person
{
public:
    Person2(string name, int age)
    {
        ageP = age;
        nameP = name;
    }

    int getAge()
    {
        return ageP;
    }
}

int
main()
{

    Person person = new Person2("Pisti", 37);
    Person2 person2 = new Person2("Jani", 27);
    std::cout << person2.getName();
}