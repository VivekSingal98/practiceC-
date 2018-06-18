package com.vivek.compressionLZ4;

import java.util.Scanner;

public class Murder {
	private static int stairs[];
	private static int size;
	private static int diary[];
	
	private static void fillDiaryAndSortStair(int startIndex,int endIndex) {
		if((endIndex-startIndex)==0) {
			return;
		}
		int mid=(startIndex+endIndex)/2;
		fillDiaryAndSortStair(startIndex,mid);
		fillDiaryAndSortStair(mid+1,endIndex);
		int newarr[]=new int[endIndex-startIndex+1];
		int left=startIndex,right=mid+1,newarrIndex=0;
		int sumStair=0;
		while(left<=mid && right<=endIndex) {
			if(stairs[left]<stairs[right]) {
				newarr[newarrIndex++]=stairs[left];
				sumStair+=stairs[left];
				left++;
				
			}
			else {
				diary[right]+=sumStair;
				newarr[newarrIndex++]=stairs[right++];
			}
		}
		while(left<=mid) {
			newarr[newarrIndex++]=stairs[left++];
		}
		while(right<=endIndex) {
			diary[right]+=sumStair;
			newarr[newarrIndex++]=stairs[right++];
		}
		for(int k=0,n=newarr.length;k<n;k++) {
			stairs[startIndex+k]=newarr[k];
		}
		return;
	}
	public static void main(String arg[]) {
		Scanner sc=new Scanner(System.in);
      	int t=sc.nextInt();
      	while(t!=0) {
          size=sc.nextInt();
          stairs=new int[size];
          diary=new int[size];
          for(int i=0;i<size;i++) {
        	  stairs[i]=sc.nextInt();
          }
         fillDiaryAndSortStair(0,size-1);
         long sumDiary=0;
         for(int i=0;i<size;i++) {
        	 sumDiary+=diary[i];
         }
         System.out.println(sumDiary);
             
          t--;
        }
      	sc.close();
	}
}
