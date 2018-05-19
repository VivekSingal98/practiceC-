#include <iostream>
using namespace std;
int binarySearch(int a[], int size, int elem) {
  int i=0;
  int l=size-1;
  int m;
  while(l>=i) {
    m=i+(l-i)/2;
    if(a[m]==elem) {
      return m;
    }
    else if(a[m]>elem) {
      l=m-1;
    }
    else
      i=m+1;
  }
  return -1;
}

int main() {
  int size, a[20],elem;
  char c; // for iterating search
  cout<<"Size of the array? ";
  do {
    cin>>size;
    if(size>20) {
      cout<<"Please enter size less than 20";
    }
  } while(size>20);
  cout<<"Please enter the array in ascending order";
  //Initialising the array
  for (int i=0;i<size;i++) {
    cin>>a[i];
  }
    //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
  cout<<"\n";
  do {
    cout<<"What element you want to find?";
    cin>>elem;
    int pos=binarySearch(a,size,elem);
    if(pos>=0) {
      cout<<"Element is found at "<<pos;
    }
    else {
      cout<<"Element not found :/";
    }
    cout<<"\nDo you want to search more?(y/n) ";
    cin>>c;

  }while(c=='y');
  return 0;
}
