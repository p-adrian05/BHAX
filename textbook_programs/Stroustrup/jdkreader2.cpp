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
    Reader() : numberOfClasses(0) {}

    void readClasses(path path)
    {

        if (is_regular_file(path))
        {
            string ext(".java");
            if (!ext.compare(extension(path)))
            {
                cout << path << std::endl;
            }
            numberOfClasses++;
        }
        else if (is_directory(path))
            for (directory_entry &entry : directory_iterator(path))
            {
                readClasses(entry.path());
            }
    }
    int getNum()
    {
        return numberOfClasses;
    }
};

int main()
{
    Reader reader;
    reader.readClasses("src");
    cout << "Number of classes:" << reader.getNum() << "\n";

    return 0;
}
