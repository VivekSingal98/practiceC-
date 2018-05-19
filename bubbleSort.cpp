#include <iostream>
using namespace std;

void bubblesort(int a[], int size) {
  int temp; //for swaping
  for(int i=0; i<size-1;i++) {
    for(int j=0;j<size-i-1;j++) {
      if(a[j]>a[j+1]){
        temp=a[j];
        a[j]=a[j+1];
        a[j+1]=temp;
      }

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
  cout<<"\nNow Applying bubblesort..... ";
  bubblesort(a,size);
  cout<<"\nDone. the sorted array is ";
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
}
