#include <stdio.h>
#include <curses.h>
#include <unistd.h>


int main ( void )
{
    WINDOW *ablak;
    ablak = initscr ();

    int x = 0; // oszlop kezdopont
    int y = 0; // sor kezdopont

    int deltax = 1; // hanyasaval lepkedjen
    int deltay = 1;

    int mx; // oszlopok
    int my; // sorok

    for ( ;; ) {

        getmaxyx ( ablak, my , mx );
        
        mvprintw ( y, x, "O" );

        refresh ();
        usleep ( 100000 );
        
        clear();

        x = x + deltax;
        y = y + deltay;

        if ( x>=mx-1) { // elerte-e a jobb oldalt?
            deltax = deltax * -1;
        }
        if ( x<=0 ) { // elerte-e a bal oldalt?
            deltax = deltax * -1;
        }
        if ( y<=0 ) { // elerte-e a tetejet?
            deltay = deltay * -1;
        }
        if ( y>=my ) { // elerte-e a aljat?
            deltay = deltay * -1;
        }

    }

    return 0;
}
