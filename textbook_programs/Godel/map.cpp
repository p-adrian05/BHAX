#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

typedef std::pair<std::string, int> pair;

int main()
{
    std::map<std::string, int> map = {
        {"János", 34}, {"Jenő", 45}, {"András", 21}, {"Béla", 39}};

    std::map<std::string, int>::iterator it;

    std::cout << "The map is : \n";
    std::cout << "KEY:VALUE\n";
    for (it = map.begin(); it != map.end(); it++)
    {
        std::cout << it->first
                  << ':'
                  << it->second
                  << std::endl;
    }
    std::cout << '\n';
    std::vector<pair> vector;

    std::copy(map.begin(),
              map.end(),
              std::back_inserter<std::vector<pair>>(vector));

    std::sort(vector.begin(), vector.end(),
              [](const pair &l, const pair &r) {
                  if (l.second != r.second)
                      return l.second < r.second;
              });
    std::cout << "The map after sorted by value : \n";
    std::cout << "KEY:VALUE\n";

    for (auto const &pair : vector)
    {
        std::cout << pair.first << ":" << pair.second << '\n';
    }

    return 0;
}