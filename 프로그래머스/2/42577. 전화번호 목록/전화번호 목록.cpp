#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool solution(vector<string> phone_book) {
    bool answer = true;
    unordered_set<string> set;

    for (int i = 0; i < phone_book.size(); i++)
    {
        set.insert(phone_book[i]);
    }

    for (int i = 0; i < phone_book.size(); i++) {
        for (int j = 0; j < phone_book[i].size(); j++)
        {
            string subStr = phone_book[i].substr(0, j);
            if (set.find(subStr) != set.end()) {
                return false;
            }
        }
        
    }

    return answer;
}