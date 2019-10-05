#include <fstream>
#include "productinventory.h"
#include "productfactory.h"
#include "computerproductfactory.h"
#include "display.h"
#include "harddisk.h"
#include "computerconfiguration.h"

using namespace std;

void readInvFileTest(ProductInventory &inv);
void writeInvFileTest(ProductInventory &inv);

int main()
{
    try
    {
        ProductFactory::Init(new ComputerProductFactory);

        //Teszt1: készlet létrehozása és kiírása a kimenetre.
        cout << "Test1: create inventory and printing it to the screen." << endl;
        time_t currentTime;
        time(&currentTime);
        ProductInventory inv1;
        inv1.addProduct(new Display("TFT1", 30000, currentTime, 13, 12));
        inv1.addProduct(new HardDisk("WD", 25000, currentTime, 7500));
        inv1.printProducts(cout);

        cout << "Press any key to continue...";
        cin.get();
        cout << endl;

        cout << "Test2: loading inventory from a file (computerproducts.txt), printing it,"
                " and then writing it to a file (computerproducts_out.txt)."
             << endl;
        ProductInventory inv2;
        readInvFileTest(inv2);
        writeInvFileTest(inv2);

        cout << endl;
        cout << "Done.";
        //várunk billenytű leütésre
        cin.get();

        return 0;
    }
    catch (const std::exception &e)
    {
        cerr << "There was an error: " << endl;
        cerr << e.what() << endl;
    }
    catch (...)
    {
        cout << "Unexpected error occured." << endl;
    }
}
// Termékek betöltése a "computerproducts.txt" állományból és listázásuk a szabványos kimenetre.
void readInvFromFileTest(ProductInventory &inv)
{
    ifstream fs("computerproducts.txt");

    if (!fs)
    {
        cerr << "Error opening file." << endl;
        return;
    }

    inv.readInventory(fs);
    cout << "The content of computerproducts.txt is: " << endl;
    inv.printProducts(cout);
    cout << endl;
}
//Termékek kiírása a "computerproducts_out.txt" állományba.
void writeInvFileTest(ProductInventory &inv)
{
    ofstream fs("computerproducts_out.txt");

    if (!fs)
    {
        cerr << "Error opening file." << endl;
        return;
    }
    inv.writeInventory(fs);
    cout << "The content of the inventory has been written to computerproducts_out.txt" << endl;
}
