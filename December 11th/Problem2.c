#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main()
{
    char buffer[100000];
    scanf("%s", buffer);

    char* delimiter = ",";
    char* token = strtok(buffer, delimiter);

    int ver = 0;
    int hor = 0;
    int max = 0;

    while (token != NULL)
    {
        if (strcmp(token, "n") == 0) ++ver;
        if (strcmp(token, "s") == 0) --ver;
        if (strcmp(token, "e") == 0) ++hor;
        if (strcmp(token, "w") == 0) --hor;

        if (strcmp(token, "ne") == 0) { ++ver; ++hor; }
        if (strcmp(token, "nw") == 0) { ++ver; --hor; }
        if (strcmp(token, "se") == 0) { --ver; ++hor; }
        if (strcmp(token, "sw") == 0) { --ver; --hor; }

        token = strtok(NULL, delimiter);

        int m = abs(ver) > abs(hor) ? abs(ver) : abs(hor);
        if (m > max) max = m;
    }

    printf("%d", max);
}