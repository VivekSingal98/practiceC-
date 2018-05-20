#include <iostream>
using namespace std;
void quicksort(int a[], int size) {
  if(size<=1) {
    return;
  }
  int pivot;
  pivot=a[0];
  int i=1,j=size-1,tmp;
  while(i<=j) {
    if(a[i]>pivot && a[j]<pivot) {
      tmp=a[i];
      a[i]=a[j];
      a[j]=tmp;
      i++;
      j--;
      continue;
    }
    if(a[i]<=pivot) {
      i++;
    }
    if(a[j]>pivot) {
      j--;
    }
  }
  int b[20],c[20];
  for(int k=1;k<=i-1;k++) {
    b[k-1]=a[k];
  }
  for(int k=0,l=i;l<size;k++,l++){
    c[k]=a[l];
  }

  quicksort(b,i-1);
  quicksort(c,size-i);
  for(int k=0;k<i-1;k++) {
    a[k]=b[k];
  }
  a[i-1]=pivot;
  for(int k=i;k<size;k++) {
    a[k]=c[k-i];
  }
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
  cout<<"\n";
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
  cout<<"\nNow Applying quicksort..... ";
  quicksort(a,size);
  cout<<"\nDone. the sorted array is ";
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
}
