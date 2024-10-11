#include <string>
#include <vector>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> map;

    for (const auto& name : participant) {
        map[name]++;
    }

    for (const auto& name : completion) {
        map[name]--;
        if (map[name] == 0) {
            map.erase(name);
        }
    }

    return map.begin()->first;
}