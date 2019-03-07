
int *pointerFg(int *c)
{
    return c;
}

int fuggveny(int a, int b)
{
    return a;
}

typedef int(*A) (int,int);;
A fuggveny2(int);


int main()
{
    //egesz
    int a = 1;

    //egeszre mutato mutato
    int *b;

    //egesz referenciaja
    b = &a;

    //egeszek tombje
    int tomb[5] = {1,2,3,4,5};

    //egeszek tombjenek referenciaja
     int (&tombref)[5] = tomb;

    //egeszre mutato mutatok tombje
    int *tombMutato[5];

    //egeszre mutato mutatot visszaado fuggveny
    int *c = pointerFg(&a);

    //egeszre mutato mutatot visszaado fuggvenyre mutato mutato
    int *(*mutato)(int*) = pointerFg;

    //egeszet visszaade es ket egészet kapo fuggvenyre mutato mutatot visszaado, egeszet kapo fuggveny
    A st = fuggveny2(10);


}



