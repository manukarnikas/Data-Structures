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

    Node insert(Node root,int val){
        if(root == null){
            root = new Node(val,null,null);
        }else if(val<root.val){
            root.left =  insert(root.left,val);
        }else{
            root.right = insert(root.right,val);
        }
        return root;
    }

    void preorderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.val+ " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.val+ " ");
        inorderTraversal(root.right);
    }

    void postorderTraversal(Node root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.val+ " ");
    }
}

class BinaryTree {
    public static void main(String args[]){
        Tree tree = new Tree(null);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 1);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 8);
        tree.root = tree.insert(tree.root, 6);
        tree.root = tree.insert(tree.root, 9);
        System.out.println("Preorder Traversal:");
        tree.preorderTraversal(tree.root);
        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println("\nPostorder Traversal:");
        tree.postorderTraversal(tree.root);
    }
}
