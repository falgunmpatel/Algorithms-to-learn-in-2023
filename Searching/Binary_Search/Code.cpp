#include <iostream>
#include <vector>

using namespace std;

int bruteForceBinarySearch(vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size() - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Element found
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid - 1;
        }
    }

    return -1; // Element not found
}

int optimizedBinarySearch(vector<int> &arr, int target) {
    int left = 0;
    int right = arr.size();

    while (left < right) {
        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid; // Element found
        } else if (arr[mid] < target) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }

    return -1; // Element not found
}

int main() {
    vector<int> arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    int target = 5;

    int resultBruteForce = bruteForceBinarySearch(arr, target);
    int resultOptimized = optimizedBinarySearch(arr, target);

    if (resultBruteForce != -1) {
        cout << "Element found at index (brute-force): " << resultBruteForce << endl;
    } else {
        cout << "Element not found (brute-force)." << endl;
    }

    if (resultOptimized != -1) {
        cout << "Element found at index (optimized): " << resultOptimized << endl;
    } else {
        cout << "Element not found (optimized)." << endl;
    }

    return 0;
}
