#include <iostream>
#include <string>
#include <boost/filesystem.hpp>

using namespace boost::filesystem;
using namespace std;

class Reader
{
private:
    int numberOfClasses;

public:
    Reader()
    {
        numberOfClasses = 0;
    }

    void readClasses(path path)
    {
        if (is_regular_file(path))
        {
            string ext(".java");
            if (!ext.compare(extension(path)))
            {
                cout << path;
                numberOfClasses++;
            }
        }
        else if (is_directory(path))
            for (directory_entry &entry : directory_iterator(path))
            {
                readClasses(entry.path());
            }
    }
    int getNumberOfClasses()
    {
        return numberOfClasses;
    }
};

int main()
{
    Reader reader;
    reader.readClasses("src");
    cout << "Number of classes:" << reader.getNumberOfClasses() << "\n";

    return 0;
}