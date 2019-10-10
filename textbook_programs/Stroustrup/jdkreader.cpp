#include <iostream>
#include <vector>
#include <string>
#include <stdio.h>
#include <boost/filesystem.hpp>
#include <boost/filesystem/fstream.hpp>

using namespace std;

void readClasses(string path, vector<string> &classes);
int main(int argc, char const *argv[])
{

    string path;
    vector<string> classes;
    if (argc == 1)
    {
        path = argv[0];
        readClasses(path, classes);
    }

    for (int i = 0; i < classes.size(); i++)
    {
        std::cout << classes[i] << "\n";
    }
    cout << "All in all there were " << classes.size() << " classes found\n";
    return 0;
}
void readClasses(boost::filesystem::path path, vector<string> &classes)
{
    if (is_regular_file(path))
    {
        std::string ext(".java");
        if (!ext.compare(boost::filesystem::extension(path)))
        {
            classes.push_back(path.string());
        }
    }
    else if (is_directory(path))
        for (boost::filesystem::directory_entry &entry : boost::filesystem::directory_iterator(path))
            readClasses(entry.path(), classes);
}
