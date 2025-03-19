class Node{
    Node left;
    int val;
    Node right;

    Node(int val,Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Tree{
    Node root;

    Tree(Node root){
        this.root = root;
    }

    void insert(Node root,int val){
        if(root ==null){
            root = new Node(val,null,null);
        }else if(val<root.val){
            if(root.left==null){
                root.left = new Node(val,null,null);
            }else{
               insert(root.left,val);
            }
        }else{
            if(root.right==null){
                root.right = new Node(val,null,null);
            }else{
               insert(root.right,val);
            }
        }
    }
}

class BinaryTree {
    public static void main(String args[]){
        Tree tree = new Tree(null);
        tree.insert(tree.root,50);
    }
}
