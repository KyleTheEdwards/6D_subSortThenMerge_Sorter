import java.util.ArrayList;

public class SubSortThenMerge_Sorter{

	//This is where the problem is. Given an arrayList of strings, sort the elements in ascending order.
	public static ArrayList<String> SubSortThenMerge(ArrayList<String> toSort){
		return sortListHelper(toSort, 0, toSort.size());
	}

	//This is a helper function, so that the user doesn't have to know what the starting and ending points mean
	//This is also the recursive abstraction. When asked to sort the elements of the list in ascending order, the recursive abstraction can split the list in half, sort the two halves, and merge those halves
	private static ArrayList<String> sortListHelper(ArrayList<String> toSort, int listStart, int listSize){
		//This is the base case. When the size of the list is 1, then of course the list is already sorted since there's only one element.
		if(listSize <= 1){
			//The solution of the base case is just to return the list as is, since it's already sorted.
			return toSort;
		} else {
			//This is the recursive case
			ArrayList<String> toRet = new ArrayList<String>(toSort.size());
			System.out.println("Currently examining list " + toSort + " from " + listStart + " to " + (listStart + listSize));
			//The result of applying the recursive abstraction to the first half is that the first half is now sorted
			toRet = sortListHelper(toSort, listStart, listSize/2);
			//The result of applying the recursive  abstraction to the second half is that the second half is now sorted
			toRet = sortListHelper(toSort, listStart + (listSize / 2), listSize - (listSize / 2));

			//We combine the results of the recursive abstraction by merging the two sorted halves of the list
			Merger merger = new Merger(toRet);
			merger.merge(listStart, listStart + listSize / 2, listStart + listSize);
			System.out.println("Result of merging " + toSort + " from " + listStart + " to " + (listStart + listSize));


			return merger.usersData;

		}
	}
}