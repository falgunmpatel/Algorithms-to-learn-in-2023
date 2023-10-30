#include<stdio.h>
int main()
{
 int i,j,n,flag;
 printf("Enter how many numbers are to be sorted:\n");
 scanf("%d",&n);
 int a[n];
 for(i=0;i<n;i++)
 {
 printf("Enter Number:");
 scanf("%d",&a[i]);
 printf("\n");
 }
 for(i=1;i<n;i++)
 {
 flag=a[i];
 j=i-1;
 while(j>=0 && a[j]>flag)
 {
 a[j+1]=a[j];
 j--;
 }
 a[j+1]=flag;
 }
 printf("After sorting, the arranged data is:\n");
 for(i=0;i<n;i++)
 {
 printf("%d\t",a[i]);
 }
 return 0;
}
