/**
  
 */
import java.util.ArrayList;
import java.util.Arrays;

public class UserOfMerge {
    
    public static void main(String[] commandLine) {
        ArrayList< String> cards = new ArrayList< String>(
          /* Java's Arrays.asList provides a perspicuous
             way to build a Collection from literals,
             suitable for constructing an ArrayList */
          Arrays.asList(
              // data to be ignored; see README
              "z", "y"  // descending order
              
              // one sorted sub-list
            , "4", "5", "6", "9"

              // the other sorted sub-list
            , "2", "3", "4", "6", "7", "J", "Q", "k"
            
              // more data to be ignored
            , "-", "+", "*"  // descending order
            ));

        oneTest( "card decks"
               , cards, 2, 6, 14 );

        ArrayList<String> sortTest = new ArrayList<String>( Arrays.asList ("9","8","7","6","5","4","3","2","1","0"));
        sortTest = SubSortThenMerge_Sorter.SubSortThenMerge(sortTest);
    }

    
    /** 
     Run one test
     */
    private static void oneTest(
        String description
      , ArrayList<String> mergeMe
        // indexes of sub-list boundaries; see README
      , int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int end1    // index past end of list1

                               ) {

        Merger merger = new Merger( mergeMe);

        System.out.println( 
            System.lineSeparator()
          + description + System.lineSeparator()
          + "before: " + merger
          );
        merger.merge( start0, start1, end1);
        System.out.println( "after:  " + merger);
        System.out.println(
            "sorted: "
          + merger.isSorted( start0, end1));
     }
    

}


