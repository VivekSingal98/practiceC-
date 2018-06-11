#include<set>
#include<iostream>
#include<vector>
using namespace std;

vector<int> longestSubsequence(int *arr, int n){
	// Write your code here
	  vector<int> a;
  	vector<int> b;
  	set<int> s;
    cout<<"after declarign set"<<endl;
  	int min=arr[0];
  	int max=arr[0];
  	for(int i=0;i<n;i++) {
      s.insert(arr[i]);
      if(arr[i]<min) {
        min=arr[i];
      }
      else if(arr[i]>max) {
        max=arr[i];
      }
    }
    cout<<"for loop ended"<<endl;
  	int k=min,tmp=0;
  	while(k<=max) {
      while(s.find(k)!=s.end()) {
        tmp++;
        b.push_back(k);
        cout<<k<<" "<<tmp<<endl;
        k=k+1;
      }
      if(a.size()<b.size()) {
        a=b;
      }
      b.clear();
      k++;
    }
  	return a;
}

int main() {
  int a[]={1,2,3,5,6,7,8,9};
  cout<<"before function";
  vector<int> v=longestSubsequence(a,8);
  for(int i=0;i<v.size();i++) {
    cout<<v[i]<<endl;
  }
  return 0;
}
