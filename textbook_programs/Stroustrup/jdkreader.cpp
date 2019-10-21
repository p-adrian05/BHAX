#include <iostream>
#include <string>
#include <boost/filesystem.hpp>

using namespace boost::filesystem;

class Tourist
{
private:
    unsigned int numOfClasses;

public:
    Tourist() : numOfClasses(0)
    {
    }

    unsigned int getNumOfClasses()
    {
        return numOfClasses;
    }
    void listJDK(path thePath)
    {

        if (is_regular_file(thePath))
        {
            std::string ext(".java");
            if (!ext.compare(extension(thePath)))
            {
                std::cout << thePath << std::endl;
            }
            numOfClasses++;
        }
        else if (is_directory(thePath))
            for (directory_entry &entry : directory_iterator(thePath))
            {
                listJDK(entry.path());
            }
    }
};

int main()
{
    Tourist theTourist;
    std::cout << "Searching for Java classes\n";

    theTourist.listJDK("src");

    std::cout << "Found " << theTourist.getNumOfClasses() << " classes.\n";

    return 0;
}
