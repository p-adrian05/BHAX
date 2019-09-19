#include <iostream>
class Rectangle
{

public:
    int r_height;
    int r_width;

    int getHeight()
    {
        return r_height;
    }

    virtual void setHeight(int height)
    {
        r_height = height;
    }

    int getWidth()
    {
        return r_width;
    }

    virtual void setWidth(int width)
    {
        r_width = width;
    }

    int getArea()
    {
        return r_width * r_height;
    }
};

class Square : public Rectangle
{

public:
    void setWidth(int width)
    {
        r_height = width;
        r_width = width;
    }

    void setHeight(int height)
    {
        r_height = height;
        r_width = height;
    }
};

int main()
{
    Rectangle *r = new Square();
    r->setWidth(2);
    r->setHeight(5);
    std::cout << r->getArea();
}