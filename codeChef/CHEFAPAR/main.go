package main

import "fmt"

func main() {
	var cases, n, temp, sum, last int
	for fmt.Scanf("%d", &cases); cases > 0; cases-- {
		sum = 0
		last = 1
		for fmt.Scanf("%d", &n); n > 0; n-- {
			fmt.Scanf("%d", &temp)
			if temp == 0 {
				sum += 1100
			} else if last == 0 {
				sum += 100
			}
			last = temp
		}
		fmt.Println(sum)
	}
}
