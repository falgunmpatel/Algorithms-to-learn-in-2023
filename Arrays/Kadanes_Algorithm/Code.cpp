#include <iostream>
#include <vector>

using namespace std;

// Brute-Force Approach
int maxSubArraySumBruteForce(vector<int>& nums) {
    int maxSum = INT_MIN;
    int n = nums.size();

    for (int i = 0; i < n; i++) {
        for (int j = i; j < n; j++) {
            int sum = 0;
            for (int k = i; k <= j; k++) {
                sum += nums[k];
            }
            maxSum = max(maxSum, sum);
        }
    }

    return maxSum;
}

// Improved Brute-Force Approach
int maxSubArraySumImprovedBruteForce(vector<int>& nums) {
    int maxSum = INT_MIN;
    int n = nums.size();

    for (int i = 0; i < n; i++) {
        int sum = 0;
        for (int j = i; j < n; j++) {
            sum += nums[j];
            maxSum = max(maxSum, sum);
        }
    }

    return maxSum;
}

// Divide and Conquer Approach
int maxCrossingSum(vector<int>& nums, int left, int mid, int right) {
    int sum = 0;
    int leftSum = INT_MIN;

    for (int i = mid; i >= left; i--) {
        sum += nums[i];
        leftSum = max(leftSum, sum);
    }

    sum = 0;
    int rightSum = INT_MIN;

    for (int i = mid + 1; i <= right; i++) {
        sum += nums[i];
        rightSum = max(rightSum, sum);
    }

    return leftSum + rightSum;
}

int maxSubArraySumDivideConquer(vector<int>& nums, int left, int right) {
    if (left == right) {
        return nums[left];
    }

    int mid = (left + right) / 2;

    int leftSum = maxSubArraySumDivideConquer(nums, left, mid);
    int rightSum = maxSubArraySumDivideConquer(nums, mid + 1, right);
    int crossingSum = maxCrossingSum(nums, left, mid, right);

    return max({leftSum, rightSum, crossingSum});
}

// Kadane's Algorithm
int maxSubArraySumKadane(vector<int>& nums) {
    int max_so_far = INT_MIN;
    int max_ending_here = 0;

    for (int num : nums) {
        max_ending_here = max(num, max_ending_here + num);
        max_so_far = max(max_so_far, max_ending_here);
    }

    return max_so_far;
}

int main() {
    vector<int> arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    cout << "Brute-Force Approach: " << maxSubArraySumBruteForce(arr) << endl;
    cout << "Improved Brute-Force Approach: " << maxSubArraySumImprovedBruteForce(arr) << endl;
    cout << "Divide and Conquer Approach: " << maxSubArraySumDivideConquer(arr, 0, arr.size() - 1) << endl;
    cout << "Kadane's Algorithm: " << maxSubArraySumKadane(arr) << endl;

    return 0;
}
