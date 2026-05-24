package cn.qdd.algorithm.tree;

/**
 * @Author: qdd
 * @Description: AVL树  1.高度方法 2.判断平衡方法 3.平衡方法 4.新增节点方法 5.删除节点方法
 * @DateTime: 2026/5/23 14:50
 **/
public class AVLTree {

    static class AVLNode {
        int key;
        Object value;
        AVLNode left;
        AVLNode right;
        int height = 1;

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value, AVLNode left, AVLNode right, int height) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            this.height = height;
        }
    }

    //求节点高度
    private int height(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    //更新节点高度
    private void updateHeight(AVLNode node) {
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    //左右子树高度差 平衡因子
    private int bf(AVLNode node) {
        return node == null ? 0 : height(node.left) - height(node.right);
    }
    // 0 -1 1 平衡
    // >1 <-1 不平衡

/*   四种情况：
     LL   右旋
     LR   先左后右
     RL   先右后左
     RR   左旋
*/

    //右旋
    private AVLNode rightRotate(AVLNode node) {
        AVLNode left = node.left;
        node.left = left.right;  //换爹
        left.right = node;    //旋转上位
        updateHeight(node); //先跟新较低的高度
        updateHeight(left);
        return left;
    }

    //左旋
    private AVLNode leftRotate(AVLNode node) {
        AVLNode right = node.right;
        AVLNode rightLeft = right.left;
        right.left = node;
        node.right = rightLeft;
        updateHeight(node);
        updateHeight(right);
        return right;
    }

    //左右旋
    private AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    //右左旋
    private AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    //检查是否失衡，失衡之后旋转
    private AVLNode balance(AVLNode node) {
        if (node == null) {
            return null;
        }
        int bf = bf(node);
        if (bf > 1 && bf(node.left) >= 0) { //LL
            return rightRotate(node);
        } else if (bf > 1 && bf(node.left) < 0) { //LR
            return leftRightRotate(node);
        } else if (bf < -1 && bf(node.right) <= 0) { //RR
            return leftRotate(node);
        } else if (bf < -1 && bf(node.right) > 0) { //RL
            return rightLeftRotate(node);
        }
        return node;
    }

    AVLNode root;

    //新增节点
    public void put(int key, Object value) {
        root = doPut(root, key, value);
    }

    private AVLNode doPut(AVLNode node, int key, Object value) {
        //1, 找到空位创建新节点
        if (node == null) {
            return new AVLNode(key, value);
        }
        //2. key已存在更新
        if (key == node.key) {
            node.value = value;
        }
        //3. key不存在插入
        if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }
        //4. 更新高度
        updateHeight(node);
        //5. 检查是否失衡，失衡之后旋转
        return balance(node);
    }

    // 删除
    public void remove(int key) {
        root = doRemove(root, key);
    }
    private AVLNode doRemove(AVLNode node, int key) {
        if (node == null){
            return null;
        }
        //2. 没找到key
        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (key > node.key) {
            node.right = doRemove(node.right, key);
        }else {
            // 3. 找到key 1没有孩子 2 只有一个孩子 3 有两个孩子
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            }else {
                AVLNode s = node.right;
                //找删除节点的后继节点
                while (s.left != null) {
                    s = s.left;
                }
                //处理后继节点的后事
                s.right = doRemove(node.right, s.key);
                s.left = node.left;
                node = s;
            }
        }
        //4. 更新高度
        updateHeight(node);
        //5. 检查是否失衡，失衡之后旋转
        return balance(node);
    }
}