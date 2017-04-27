#include <stdio.h>

int main(){
    int cases, n, temp, fail;
    long sum;
    for (scanf("%d",&cases); cases > 0; cases--) {
        sum = 0;
        fail = 0;
        for (scanf("%d",&n); n > 0; n--) {
            scanf("%d",&temp);
            if (temp == 1 && fail) {
                sum++;
            } else if (temp == 0) {
                sum += 11;
                fail = 1;
            }
        }
        printf( "%ld\n",(sum*100));
    }
    return 0;
}
