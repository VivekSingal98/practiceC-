#include <iostream>

using namespace std;
void insertionSort(int a[], int size) {
  int pos=0,tmp;
  for(int i=1;i<size;i++) {
    pos=i;
    for(int j=0;j<i;j++) {
      if(a[j]>a[i]) {
        pos=j;
        break;
      }
    }
  tmp=a[i];
  for(int j=i;j>pos;j--) {
    a[j]=a[j-1];
  }
  a[pos]=tmp;
  }
}
int main() {
  int size, a[20];
  cout<<"Size of the array? ";
  do {
    cin>>size;
    if(size>20) {
      cout<<"Please enter size less than 20";
    }
  } while(size>20);
  cout<<"Please enter the array";
  //Initialising the array
  for (int i=0;i<size;i++) {
    cin>>a[i];
  }
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
  cout<<"\nNow Applying insertionSort..... ";
  insertionSort(a,size);
  cout<<"\nDone. the sorted array is ";
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
}
