#include <unordered_set>
#include <vector>
#include <algorithm>
using namespace std;

int solution(vector<int> nums)
{
    int size = nums.size();
    unordered_set<int> set;

    for (int i = 0; i < size; i++) {
        set.insert(nums[i]);
    }

    return min(static_cast<int>(set.size()), size / 2);
}