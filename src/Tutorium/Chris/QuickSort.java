package Tutorium.Chris;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QuickSort {
    public Stream<Integer> streamToSort;
    public ArrayList<Integer> listToSort;

    public void main(String args[]){
        //sortieren wird aufgerufen
    }

    public List<Integer> sortieren(ArrayList<Integer> arrayListToSort){
        Boolean sortiert = false;
        List<Integer> sortierteListe;

        Integer erstesElement = arrayListToSort.get(0);
        Map<Boolean, List<Integer>> ersteSortierteMap = arrayListToSort.stream().collect(Collectors.partitioningBy(i -> i < erstesElement));

        sortierteListe = sortierenWeiter(ersteSortierteMap, sortiert);

        return sortierteListe;
    }

    public List<Integer> sortierenWeiter(Map<Boolean, List<Integer>> mapWeiterSortieren, Boolean sortiert){
        if(sortiert){
            //Map aufloesen und zusammen fuegen + Ausgeben
            //return List<Integer>
        } else {
            //Map weiter sortieren jk
            //check ob sortiert oder nicht, Boolean sortiert = true, sortierenWeiter aufrufen mit Map und Boolean
        }
    }
}
