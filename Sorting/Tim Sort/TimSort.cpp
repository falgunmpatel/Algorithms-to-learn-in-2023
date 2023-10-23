#include <iostream>
#include <vector>
#include <algorithm>

const int MIN_MERGE = 32;

// Function to find the minimum of two integers
int min(int a, int b) {
    return (a < b) ? a : b;
}

// Function to perform insertion sort on a section of the array
void insertionSort(std::vector<int>& arr, int left, int right) {
    for (int i = left + 1; i <= right; i++) {
        int key = arr[i];
        int j = i - 1;

        while (j >= left && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }
        arr[j + 1] = key;
    }
}

// Function to merge two sorted subarrays
void merge(std::vector<int>& arr, int l, int m, int r) {
    int len1 = m - l + 1;
    int len2 = r - m;

    std::vector<int> left(len1);
    std::vector<int> right(len2);

    for (int i = 0; i < len1; i++) {
        left[i] = arr[l + i];
    }

    for (int i = 0; i < len2; i++) {
        right[i] = arr[m + 1 + i];
    }

    int i = 0, j = 0, k = l;

    while (i < len1 && j < len2) {
        if (left[i] <= right[j]) {
            arr[k] = left[i];
            i++;
        } else {
            arr[k] = right[j];
            j++;
        }
        k++;
    }

    while (i < len1) {
        arr[k] = left[i];
        i++;
        k++;
    }

    while (j < len2) {
        arr[k] = right[j];
        j++;
        k++;
    }
}

// Function to perform Tim Sort
void timSort(std::vector<int>& arr, int n) {
    for (int i = 0; i < n; i += MIN_MERGE) {
        insertionSort(arr, i, min((i + MIN_MERGE - 1), (n - 1));
    }

    for (int size = MIN_MERGE; size < n; size = 2 * size) {
        for (int left = 0; left < n; left += 2 * size) {
            int mid = min((left + size - 1), (n - 1));
            int right = min((left + 2 * size - 1), (n - 1));

            if (left < mid && mid < right) {
                merge(arr, left, mid, right);
            }
        }
    }
}

int main() {
    std::vector<int> arr = {12, 11, 13, 5, 6, 7};

    int n = arr.size();
    timSort(arr, n);

    std::cout << "Sorted array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}
