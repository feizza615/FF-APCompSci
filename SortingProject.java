import java.util.Arrays;
import java.util.Scanner;

public class SortingProject
{
  private static int[] arr2;
  public static void main(String[]args)
  {
   int[] arr = new int[10];
   randArr(arr);
   
   Scanner scan = new Scanner(System.in);
   System.out.println("Which sort would you like to use: 1 = Selection | 2 = Insertion | 3 = Merge | 4 = Quick");
   int input = scan.nextInt();
   
   System.out.println("Original Array: " + Arrays.toString(arr));
   
   if(input == 1)
   {
     System.out.println("Selection Sorted Array: " + Arrays.toString(select(arr)));
   }
   else if(input == 2)
   {
     System.out.println("Insertion Sorted Array: " + Arrays.toString(insert(arr)));
   }
   else if(input==3)
   {
     sort(arr);
     mergeSplit(0, 9);
     System.out.println(Arrays.toString(arr2));
   }
   else if(input == 4)
   {
     quick(arr, 0, 9);
     System.out.println("Quick Sorted Array: " + Arrays.toString(arr));
   }
  
   
  }
  
  public static int[] select(int[]arr)
  {
    for(int i =0; i <arr.length-1; i++)
    {
      int index = i;
      for(int j = i+1; j<arr.length; j++)
      {
        if(arr[j]<arr[index])
        {
          int temp = arr[index];
          arr[index]=arr[j];
          arr[j]=temp;
        }
      }
    }
    return arr;
  }
  
  public static int[] insert(int[]arr)
  {

    for(int i = 1; i<arr.length;i++)
    {
      for(int j = 0; j<arr.length; j++)
      {
        if(arr[i]<arr[j])
        {
          int temp= arr[i];
          arr[i]=arr[j];
          arr[j]=temp;
        }
      }
    }
    return arr;
  }
  
    public static void sort(int input[]) {
        arr2 = input;
    }
  public static void mergeSplit(int min, int max)
  {
    if(min < max)
    {
      int mid = (min + max)/2;
      mergeSplit(min, mid);
      mergeSplit(mid+1, max);
      merge(min, mid, max);
    }
  }
  
  public static void merge(int min, int mid, int max)
  {
   int[] temp = new int[10];
   for(int a = min; a<=max;a++)
   {
     temp[a] = arr2[a];
   }
   
   int x = min;
   int y = mid+1;
   int z = min;
   
   while(x<=mid &&y <=max)
   {
     if(temp[x]<=temp[y])
     {
       arr2[z] = temp[x];
       x++;
     }
     else
     {
       arr2[z]=temp[y];
       y++;
     }
     z++;
   }
   while(x<=mid)
   {
     arr2[z]= temp[x];
     z++;
     x++;
   }
  }
  
  public static void quick(int[]arr, int low, int high)
  {
    int min = low;
    int max = high;
    int pivot = (low + high) /2;
 
    while(min<=max)
    {
      while(arr[min]<arr[pivot])
      {
        min++;
      }
      while(arr[max]>arr[pivot])
      {
        max--;
      }
      
      if(min<=max)
      {
        int temp = arr[min];
        arr[min] = arr[max];
        arr[max] = temp;
        min++;
        max--;
      }
    }  
    if(low <= max)
    {
      quick(arr, low, max);
    }
    
    if (min <= high)
    {
       quick(arr, min, high);
    }
  }
  
  public static void randArr(int[]arr)
  {
    for(int a = 0; a<arr.length;a++)
    {
      int y = (int)(Math.random()*10);
      arr[a]=y;
    }
  }
}