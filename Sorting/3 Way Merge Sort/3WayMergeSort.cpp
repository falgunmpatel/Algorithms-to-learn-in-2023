#include <iostream>
#include <vector>

// Merge function to merge three sorted subarrays
void merge(std::vector<int>& arr, int left, int middle1, int middle2, int right) {
    int n1 = middle1 - left + 1;
    int n2 = middle2 - middle1;
    int n3 = right - middle2 + 1;

    std::vector<int> leftArray(n1);
    std::vector<int> middleArray(n2);
    std::vector<int> rightArray(n3);

    for (int i = 0; i < n1; i++) {
        leftArray[i] = arr[left + i];
    }

    for (int i = 0; i < n2; i++) {
        middleArray[i] = arr[middle1 + 1 + i];
    }

    for (int i = 0; i < n3; i++) {
        rightArray[i] = arr[middle2 + 1 + i];
    }

    int i = 0, j = 0, k = 0, l = left;

    while (i < n1 && j < n2 && k < n3) {
        if (leftArray[i] <= middleArray[j] && leftArray[i] <= rightArray[k]) {
            arr[l] = leftArray[i];
            i++;
        } else if (middleArray[j] <= leftArray[i] && middleArray[j] <= rightArray[k]) {
            arr[l] = middleArray[j];
            j++;
        } else {
            arr[l] = rightArray[k];
            k++;
        }
        l++;
    }

    while (i < n1) {
        arr[l] = leftArray[i];
        i++;
        l++;
    }

    while (j < n2) {
        arr[l] = middleArray[j];
        j++;
        l++;
    }

    while (k < n3) {
        arr[l] = rightArray[k];
        k++;
        l++;
    }
}

// Three-way merge sort function
void threeWayMergeSort(std::vector<int>& arr, int left, int right) {
    if (left < right) {
        int n = right - left + 1;
        if (n > 2) {
            int middle1 = left + n / 3;
            int middle2 = left + 2 * (n / 3);
            threeWayMergeSort(arr, left, middle1);
            threeWayMergeSort(arr, middle1 + 1, middle2);
            threeWayMergeSort(arr, middle2 + 1, right);
            merge(arr, left, middle1, middle2, right);
        }
    }
}

int main() {
    std::vector<int> arr = {12, 11, 13, 5, 6, 7};

    int n = arr.size();
    threeWayMergeSort(arr, 0, n - 1);

    std::cout << "Sorted array: ";
    for (int num : arr) {
        std::cout << num << " ";
    }
    std::cout << std::endl;

    return 0;
}
