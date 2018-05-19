#include <iostream>
using namespace std;

void selectionSort(int a[], int size) {
  int min=0,tmp; //tmp for swapping
  for(int i=0;i<size-1;i++) {
    min=i;
    for(int j=i+1;j<size;j++) {
      if(a[j]<a[i]) {
        min=j;
      }
    }
    if(min!=i) {
      tmp=a[i];
      a[i]=a[min];
      a[min]=tmp;
    }
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
  cout<<"\nNow Applying selectionsort..... ";
  selectionSort(a,size);
  cout<<"\nDone. the sorted array is ";
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
}
