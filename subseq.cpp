#include<iostream>
using  namespace std;
int subs(string input,string output[]){
  if(input.size()==0){
    output[0]="";
    return 1;
  }
  string s1=input.substr(1);
  int substrSize=subs(s1,output);
  for(int i=0;i<substrSize;i++) {
    output[i+substrSize]=output[i]+input[0];
  }
  return 2*substrSize;
}
int main() {
  string input;
  cout<<"Enter the input string: ";
  cin>>input;
  string* output=new string[1000];
  int size=subs(input,output);
  for(int i=0;i<size;i++){
    cout<<output[i]<<endl;
  }
  return 0;
}
