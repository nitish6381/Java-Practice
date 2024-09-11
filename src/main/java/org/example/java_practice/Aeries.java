package org.example.java_practice;
import java.util.*;
import java.util.stream.Collectors;

public class Aeries {
    public static void main(String[] args){
        System.out.println("hello world");

        Map<Integer, Integer> map= new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the student record");
        for(int i =0;i<10;i++){
            String str = sc.nextLine();
            String[] str1 = str.split("-");
            if(map.containsKey(Integer.valueOf(str1[0]))){
                if(map.get(Integer.valueOf(str1[0])) < Integer.valueOf(str1[1])){
                    map.put(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
                }
            }else{
                map.put(Integer.valueOf(str1[0]), Integer.valueOf(str1[1]));
            }
        }

        List<Integer> list = new ArrayList();

        Map<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (e1, e2) -> e1, LinkedHashMap::new));
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            list.add(entry.getValue());
        }
        Collections.sort(list, Collections.reverseOrder());
        Collections.sort(list);
        for(int i =list.size()-1;i>=0;i--){
//            map.
//            for(Map.Entry<Integer, Integer> entry: map.entrySet()){
//                if(entry.getValue() == list.get(i)){
//                    System.out.println(entry.getKey()+"-"+entry.getValue());
//                }
//            }
        }


    }
}
