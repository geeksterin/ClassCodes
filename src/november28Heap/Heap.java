package november28Heap;

import java.util.ArrayList;

public class Heap {
    ArrayList<Integer> data = new ArrayList<>();

    public Heap(){

    }

    public void add(int val){
        //add val to arraylist
        this.data.add(val);
        // to place it on correct position
        // process is upheapify
        upheapify(data.size() - 1);
    }

    // upheapify
    private void upheapify(int ci){
        //whether it is first element or not
        if(ci == 0){
            return ;
        }
        int pi = (ci-1)/2;
        if(isHp(ci,pi) == false) {
            swap(ci, pi);
            upheapify(pi);
        }
    }

    private boolean isHp(int ci,int pi){
        return data.get(ci) < data.get(pi);
    }

    private void swap(int ci,int pi){
        int cith = data.get(ci);
        int pith = data.get(pi);
        data.set(ci,pith);
        data.set(pi,cith);
    }


    // remove
    public int remove(){
        int relement = data.get(0);
        swap(0,data.size()-1);
        data.remove(data.size()-1);
        downheapify(0);
        return relement;
    }

    private void downheapify(int pi){
        int max_index = pi;
        int lci = 2*pi + 1;
        if(lci < data.size() && isHp(lci,max_index)==false){
            max_index = lci;
        }
        int rci = 2*pi + 2;
        if(rci < data.size() && isHp(rci,max_index)==false){
            max_index = rci;
        }
        if(max_index != pi){
            swap(max_index,pi);
            downheapify(max_index);
        }

    }

    public int peek(){
        return data.get(0);
    }

    public int size(){
        return data.size();
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }

    public void display(){
        for (Integer i : data){
            System.out.print(i + " ");
        }
    }
}
