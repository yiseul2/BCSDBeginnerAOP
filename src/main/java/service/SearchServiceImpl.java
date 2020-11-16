package service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class SearchServiceImpl implements SearchService {

    ArrayList<Integer> arrayList;
    final int max_value = 10000000;

    public SearchServiceImpl() {
        arrayList = new ArrayList<Integer>();
        for(int i = 0; i < max_value; i++) {
            arrayList.add(i);
        }
    }

    public void binarySearch(int key) {
        int mid;
        int left = 0;
        int right = max_value-1;

        while(right >= left) {
            mid = (right + left) / 2;

            if(key == arrayList.get(mid)) break;

            if(key < arrayList.get(mid))
                right=mid-1;
            else
                left=mid+1;
        }
    }

    public void linearSearch(int key) {
        for(int i = 0; i < max_value; i++) {
            if(arrayList.get(i) == key) break;
        }
    }

    public void NullPointer() {
        String str = null;
        // NullPointerException!
        System.out.println(str.indexOf(0));
    }
}
