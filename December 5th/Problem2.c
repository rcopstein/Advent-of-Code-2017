#include <stdio.h>

int main()
{
    int size = 1090;

    int i;
    int list[size];
    for (i = 0; i < size; ++i) scanf("%d", &list[i]);
    
    int aux = 0;
    int count = 0;
    while (aux >= 0 && aux < size) { 
        
        int offset = list[aux]; 
        list[aux] = list[aux] >= 3 ? list[aux] - 1 : list[aux] + 1; 
        aux += offset;
        count++; 
        
    }

    printf("%d\n", count);

}