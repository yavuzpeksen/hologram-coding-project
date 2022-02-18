package com.hologramsciences;

import java.util.ArrayList;
import java.util.List;

public class Algorithms {
    /**
     *
     *  Compute the cartesian product of a list of lists of any type T
     *  the result is a list of lists of type T, where each element comes
     *  each successive element of the each list.
     *
     *  https://en.wikipedia.org/wiki/Cartesian_product
     *
     *  For this problem order matters.
     *
     *  Example:
     *
     *   listOfLists = Arrays.asList(
     *                         Arrays.asList("A", "B"),
     *                         Arrays.asList("K", "L"),
     *                         Arrays.asList("Z", "X", "Y")
     *                 )
     * AK AL BK BL - Z X Y-> AKZ AKX AKY ALZ ALX ALY BKZ BKX BKY BLZ BLX BLY
     *   returns:
     *
     *   Arrays.asList(
     *         Arrays.asList("A", "K"),
     *         Arrays.asList("A", "L"),
     *         Arrays.asList("B", "K"),
     *         Arrays.asList("B", "L")
     *   )
     *
     *
     *
     */
    public static final <T> List<List<T>> cartesianProductForLists(final List<List<T>> listOfLists) {
        
        //Base case, here we cross join each element one by one.
        List<List<T>> oldListOfLists = listOfLists;
        if (listOfLists.size() == 2) {
            List<List<T>> result = new ArrayList<>();
            for (T leftElement : listOfLists.get(0)) {
                for (T rightElement : listOfLists.get(1)) { // <K,L>
                    List<T> cartesianList = new ArrayList<>(List.of(leftElement));
                    cartesianList.add(rightElement);
                    result.add(cartesianList);
                }
            }
            return result;
        }
        List<List<T>> leftMostList = cartesianProductForLists(listOfLists.subList(0, oldListOfLists.size()-1));
        List<T> rightList = listOfLists.get(listOfLists.size()-1);

        List<List<T>> result = new ArrayList<>();
        for (int i = 0; i<leftMostList.size(); i++) {
            for (T rightElement : rightList) {
                List<T> cartesianList = new ArrayList<>(leftMostList.get(i));
                cartesianList.add(rightElement);
                result.add(cartesianList);
            }
            
        }
        return result;
    }
    
    /**
     *
     *  In the United States there are six coins:
     *  1¢ 5¢ 10¢ 25¢ 50¢ 100¢
     *  Assuming you have an unlimited supply of each coin,
     *  implement a method which returns the number of distinct ways to make totalCents
     */
    public static final long countNumWaysMakeChange(final int totalCents) {
        List<List<Long>> listOfCombinations = new ArrayList<>();
        int[] coins = {1,5,10,25,50,100};
        traceBackFromEnd(listOfCombinations, new ArrayList<>(), coins, totalCents, 0);
        return listOfCombinations.size();
    }

    private static void traceBackFromEnd(List<List<Long>> listOfCombinations, List<Long> list, int[] coins,
            int remain, int start) {
        
        if (remain<0) {
            return;
        } else if(remain==0) {
            listOfCombinations.add(new ArrayList<>(list));
        } else {
            for (int i = start; i < coins.length; i++) {
                list.add(Long.valueOf(coins[i]));
                traceBackFromEnd(listOfCombinations, list, coins, remain - coins[i], i);
                list.remove(list.size() - 1);  
            }
        }

        
    }
}
