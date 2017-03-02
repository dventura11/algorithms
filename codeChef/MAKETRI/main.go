package main

import "fmt"

type empty struct{}

func main() {
	var n, l, r, t, sum int
	m := make(map[int]*empty)
	for fmt.Scanf("%d %d %d", &n, &l, &r); n > 0; n-- {
		fmt.Scanf("%d", &t)
		m[t] = nil
	}
	v := make([]int, len(m), len(m))
	i := 0
	for k := range m {
		v[i] = k
		i++
	}
	for ; l <= r; l++ {
		sum += findTriangle(l, v)
	}
	fmt.Printf("%d\n", sum)
}

func findTriangle(a int, v []int) int {

	for b := range v {
		for c := b + 1; c < len(v); c++ {
			if isTriangle(a, b, c) {
				return 1
			}
		}
	}
	return 0
}

func isTriangle(a, b, c int) bool {
	if a == b || a == c || b == c {
		return false
	}
	if a+b <= c || a+c <= b || b+c <= a {
		return false
	}
	return true
}
