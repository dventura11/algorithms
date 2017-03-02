#include <stdio.h>

int main(){
    int cases, n, sum;
    for (scanf("%d",&cases); cases > 0; cases--) {
        sum = 0;
        for (scanf("%d",&n); n > 0; n/=10) {
            sum += n%10;
        }
        printf("%d\n",sum);
    }
    return 0;
}
