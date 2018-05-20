#include <iostream>

using namespace std;
void merge(int a[], int b[], int c[], int sizeb, int sizec) {
  int i=0,j=0,k=0;
  while(j<sizeb && k<sizec) {
    if(b[j]<c[k]) {
      a[i]=b[j];
      j++;
      i++;
    }
    else {
      a[i]=c[k];
      k++;
      i++;
    }
  }
  while(j<sizeb) {
    a[i]=b[j];
    i++;
    j++;
  }
  while(k<sizec) {
    a[i]=c[k];
    i++;
    k++;
  }
}
void mergesort(int a[],int size) {
  if(size==1) {
    return;
  }
  int b[10],c[10];
  for(int i=0; i<size/2;i++) {
    b[i]=a[i];
  }
  for(int i=size/2,j=0; i<size;i++,j++) {
    c[j]=a[i];
  }
  cout<<b[0];
  cout<<c[0];
  mergesort(b,size/2);
  mergesort(c,size-size/2);
  merge(a,b,c,size/2,size-size/2);
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
  cout<<"\nNow Applying mergesort..... ";
  mergesort(a,size);
  cout<<"\nDone. the sorted array is ";
  //Printing the array
  for(int i=0;i<size;i++) {
    cout<<" "<<a[i];
  }
}
