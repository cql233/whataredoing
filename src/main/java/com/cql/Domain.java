package com.cql;

import java.util.Vector;

/**
 * 〈入口〉
 *
 * @author cql
 * @create 2021/7/1
 * @since 1.0.0
 */
public class Domain {
    public static void main(String[] args) {
        Vector<Vector<Integer>> M=new Vector<>(3,0);
        Vector<Integer> one=new Vector<>(3,0);
        one.add(0);
        one.add(1);
        one.add(0);
        M.add(one);
        M.add(one);
        M.add(one);

        int len_row=M.size();
        int len_col=M.get(0).size();
        Vector<Integer> rows=new Vector<>(len_col,0);
        Vector<Integer> cols=new Vector<>(len_col,0);
        Vector<Integer> dia=new Vector<>(len_col,0);
        Vector<Integer> rev_dia=new Vector<>(len_col,0);

        int res=0;
        for(int i=0;i<len_row;i++){
            int pre=dia.set(0,0);
            for(int j=0;j<len_col;j++){
                if(M.get(i).get(j)==1){
                    rows.set(j,j>0?rows.get(j-1)+1:1);
                    cols.set(j,j>0?cols.get(j)+1:1);
                    int tem=dia.get(j);
                    dia.set(j,i>0&&j>0?pre+1:1);
                    pre=tem;

                    rev_dia.set(j,i>0&&j<len_col-1?rev_dia.get(j+i)+1:1);
                    //todo 获取最大值

                }else{
                    rows.set(j,0);
                    cols.set(j,0);
                    pre=dia.get(j);
                    dia.set(j,0);
                    rev_dia.set(j,0);
                }
            }
        }
        System.out.println("res = " + res);
    }

}