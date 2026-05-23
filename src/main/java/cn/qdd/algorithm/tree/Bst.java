package cn.qdd.algorithm.tree;

import java.util.TreeMap;

/**
 * @Author: qdd
 * @Description: Bst
 * @DateTime: 2026/5/17 16:37
 **/
public class Bst {
    public static void main(String[] args) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
/*
         static <K,V> Entry<K,V> predecessor(Entry<K,V> t)
         //前继节点
         1.如果有左子树就找左子树的最右节点 (左子树的最大值)
         2.如果没有左子树就找最近的从从左到当前接节点的祖先节点
*/

/*
            static <K,V> Entry<K,V> successor(Entry<K,V> t)
            //后继节点
            1.如果有右子树就找右子树的最左节点 (右子树的最小值)
            2.如果没有右子树就找最近的从从右到当前接节点的祖先节点
*/

/*
          private void deleteEntry(Entry<K,V> p)
          //删除节点
 */
    }

}
