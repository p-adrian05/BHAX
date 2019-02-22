#include <iostream>
#include <vector>
#include <unistd.h>
using namespace std;

const int szelesseg = 40;//ablak szelesseg
const int magassag = 20;//ablak magassag
int x=1, y=1; //labda kezdoertek
int deltax=1,deltay=1; // hanyasaval lepkedjen
vector<int> ablakx;
vector<int> ablaky;

void kirajzol(){

    for(int i=0;i<szelesseg+2;i++)
    {
        cout << "#";
    }
    cout << endl;

    for(int i=0;i<y;i++)
    {
         cout << "#";
         for(int j=1;j<szelesseg+1;j++)
         {
             cout <<" ";

         }
         cout << "#";
         cout << endl;
    }

    cout << "#";
    for(int i=0;i<x;i++)
    {
        cout <<" ";
    }
    cout<<"O";

    for(int i=x+1;i<szelesseg;i++)
    {
        cout <<" ";
    }
    cout << "#\n";


    for(int i=y+1;i<magassag+1;i++)
    {
         cout << "#";
         for(int j=1;j<szelesseg+1;j++)
         {
            cout<<" ";
         }
         cout << "#\n";
    }

    for(int i=0;i<szelesseg+2;i++)
    {
        cout << "#";
    }
    cout << endl;
}

void mozgatas(){
	x=x+deltax;
	y=y+deltay;
	deltax=deltax*ablakx[x];
	deltay=deltay*ablaky[y];
}

int main(){

    for (int i=0; i<szelesseg; i++)
    {
         ablakx.push_back(1);
    }

    for (int i=0; i<magassag; i++)
    {
        ablaky.push_back(1);
    }

    ablakx[0]=-1;//bal oldal
    ablakx[szelesseg-1]=-1; // jobb oldal
    ablaky[0]=-1; //teteje
    ablaky[magassag]=-1; // alja

    for(;;)
    {
        kirajzol();
        mozgatas();
        usleep(100000);
    }

}
