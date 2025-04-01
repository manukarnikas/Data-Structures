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

    int search(Node root,int val){
        if(root == null){
            return -1;
        }else if(root.val == val){
            return 0;
        }else if(val<root.val){
            return search(root.left,val);
        }else{
            return search(root.right,val);
        }
    }

    Node findMinInRightSubtree(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }

    Node delete(Node root,int val){
        if(root == null){
            return root;
        }else if(val<root.val){
            root.left =  delete(root.left,val);
        }else if(val>root.val){
            root.right = delete(root.right,val);
        }else{
            // no child
            if(root.left == null && root.right==null){
                return null;
            }

            //one child
            if(root.left==null && root.right!=null){
                return root.right;
            }
            if(root.left!=null && root.right==null){
                return root.left;
            }

            //two child
            Node selectedNode = findMinInRightSubtree(root.right);   // or can use find max in left subtree
            root.val = selectedNode.val;
            root.right = delete(root.right,selectedNode.val);
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
        int search_value = 6;
        int result = tree.search(tree.root, search_value);
        if(result < 0){
            System.out.println("\n Value not found: "+search_value);
        }else{
            System.out.println("\nValue found: "+search_value);
        }
        tree.root = tree.delete(tree.root,5);
        System.out.println("\nInorder Traversal:");
        tree.inorderTraversal(tree.root);
    }
}
