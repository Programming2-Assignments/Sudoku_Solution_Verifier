package org.project;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateUtils {

    public List<DuplicateRecord> checkRow(int rowNum,int[] row){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < row.length; i++){
            int value = row[i];
            if (map.containsKey(value)){
                map.get(value).add(i);  //this appends the positions where there are duplications
            }
            else{
                map.put(value,new ArrayList<>());
                map.get(value).add(i);
            }
        }
        List<DuplicateRecord> duplicateRecords = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key).size()>1){
                for(int colNum : map.get(key)){
                    DuplicateRecord dup = new DuplicateRecord(key,new int[]{rowNum,colNum},"ROW");
                    duplicateRecords.add(dup);
                }
            }
        }
        return duplicateRecords;
    }

    public List<DuplicateRecord> checkColumn(int colNum,int[] column){
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < column.length; i++){
            int value = column[i];
            if (map.containsKey(value)){
                map.get(value).add(i);  //this appends the positions where there are duplications
            }
            else{
                map.put(value,new ArrayList<>());
                map.get(value).add(i);
            }
        }
        List<DuplicateRecord> duplicateRecords = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key).size()>1){
                for(int rowNum : map.get(key)){
                    DuplicateRecord dup = new DuplicateRecord(key,new int[]{rowNum,colNum},"COLUMN");
                    duplicateRecords.add(dup);
                }
            }
        }
        return duplicateRecords;
    }

    public List<DuplicateRecord> checkBox(int[][] box){
        HashMap<Integer, ArrayList<int[]>> map = new HashMap<>();
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                int value =box[i][j];
                if (map.containsKey(value)){
                    map.get(value).add(new int[]{i,j});  //this appends the positions where there are duplications
                }
                else{
                    map.put(value,new ArrayList<>());
                    map.get(value).add(new int[]{i,j});
                }
            }
        }
        List<DuplicateRecord> duplicateRecords = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key).size()>1){
                for(int position[] : map.get(key)){
                        DuplicateRecord dup = new DuplicateRecord(key,new int[]{position[0],position[1]},"BOX");
                        duplicateRecords.add(dup);
                }
            }
        }
        return duplicateRecords;
    }
}
