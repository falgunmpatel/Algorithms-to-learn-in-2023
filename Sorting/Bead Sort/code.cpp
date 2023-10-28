#include <iostream>
#include <algorithm>
#include <vector>

std::vector<int> beadSort(std::vector<int> a, int len)
{
	// Find the maximum element
	int max = a[0];
	for (int i = 1; i < len; i++) {
		if (a[i] > max) {
			max = a[i];
		}
	}

	// allocating memory
	std::vector<std::vector<int>> beads;
	beads.resize(len);
	for (int i = 0; i < len; i++) {
		beads[i].resize(max);
		std::fill(beads[i].begin(), beads[i].end(), 0);
	}

	// mark the beads
	for (int i = 0; i < len; i++) {
		for (int j = 0; j < a[i]; j++) {
			beads[i][j] = 1;
		}
	}

	// move down the beads
	for (int j = 0; j < max; j++) {
		int sum = 0;
		for (int i = 0; i < len; i++) {
			sum += beads[i][j];
			beads[i][j] = 0;
		}
		for (int i = len-1; i >= len-sum; i--) {
			beads[i][j] = 1;
		}
	}

	// to get sorted array
	std::vector<int> result;
	result.resize(len);
	for (int i = 0; i < len; i++) {
		int sum = 0;
		for (int j = 0; j < max; j++) {
			sum += beads[i][j];
		}
		result[i] = sum;
	}
	return result;
}

int main(){
	std::vector<int> a = {3, 1, 4, 1, 5};
	std::vector<int> result = beadSort(a, 5);
	std::cout << "The sorted array is : ";
	for (int i = 0; i < result.size(); i++)
		std::cout << result[i] << " ";
	return 0;
}