#include <iostream>
#include <string>
class Person
{
protected:
    int ageP;
    std::string nameP;

public:
    Person(std::string name, int age)
    {
        nameP = name;
        ageP = age;
    }

    void setAge(int age)
    {
        ageP = age;
    }

    std::string getName()
    {
        return nameP;
    }
    int getAge()
    {
        return ageP;
    }

    void setName(std::string name)
    {
        nameP = name;
    }
};

class Person2 : public Person
{
private:
    std::string emailP;

public:
    Person2(std::string name, int age, std::string email) : Person(name, age)
    {
        emailP = email;
    }
    std::string getEmail()
    {
        return emailP;
    }
};

int main()
{
    Person *person = new Person2("Pisti", 37, "email");
    td::cout << person->getEmail();
}