//Andrea Ramirez
//Chpt 7 PA

//This program implements a binary search tree with recursive and iterative insert/search methods, and prints the tree in reverse order and 2D format.

class BSTNode {
    int key;
    BSTNode left, right;
	
	// Constructor to initialize a new BST node with a given key
    public BSTNode(int key) {
        this.key = key;
        this.left = this.right = null;
    }
}

class BST {
    private BSTNode root;

	// Construct to initialize an empty BST
    public BST() {
        root = null;
    }
	
	// Getter method to access the root node
	public BSTNode getRoot() {
		return root;
	}

	// Implement the BSTSearchRecursive PseudoCode found in PA 7.9.1
    public BSTNode searchRecursive(BSTNode node, int key) {
        if (node == null || node.key == key) {     //If node is empty of key is found, return it
            return node;
        }
        if (key < node.key) {                      //If key is smaller, go left 
            return searchRecursive(node.left, key);
        } else {                                  // If key is bigger, go right 
            return searchRecursive(node.right, key);
        }
    }
	
	// Implement the BSTSearch PseudoCode found in PA 7.9.1
	public BSTNode search(int key) {
           BSTNode current = root;
           //Start at the root and move left or right based on the key until it's found or no nodes are left
           while (current != null) {
               if (key == current.key) {
                  return current;
               } else if (key < current.key) {
                   current = current.left;
               } else {
                   current = current.right;
               }  
           }
        return null;
	}

	// Checks if the tree contains a node with the given key
    public boolean contains(int key) {
        return search(key) != null;
    }

	// Inserts a key into the BST if it does not already exist
    public boolean insertKey(int key) {
        if (contains(key)) {
            return false; // Duplicate keys not allowed
        }
		// Create a new node
        BSTNode newNode = new BSTNode(key);
		// Call insertNode method
        insertNode(newNode);
        return true;
    }
	
	// Implement the BSTInsertNode PseudoCode found in Fig. 7.9.2
	private void insertNode(BSTNode node) {
	    if (root == null) {
            root = node;
            return;
            }

            BSTNode parent = null;
            BSTNode current = root;

            //Find the correct spot for the new node, move left if smaller, move right if bigger
            while (current != null) {
                   parent = current;
                   if (node.key < current.key) {
                       current = current.left;
                   } else {
                       current = current.right;
                   }
           }
           
          //Attach the new node to the correct side of the parent 
          if (node.key < parent.key) {
             parent.left = node;
          } else {
              parent.right = node;
          }
	}
			

	// Implement the BSTInsertRecursive PseudoCode found in Fig. 7.9.2
    private void insertRecursive(BSTNode parent, BSTNode nodeToInsert) {
        //Checks if the new node should go to the left or right of the parent, and puts it there
        if (nodeToInsert.key < parent.key) {
            if (parent.left == null) {
                parent.left = nodeToInsert;
            } else {
                insertRecursive(parent.left, nodeToInsert);
            }
        } else {
            if (parent.right == null) {
                parent.right = nodeToInsert;
            } else {
                insertRecursive(parent.right, nodeToInsert);
            }
        }		
	}
	
	// Implement a printInReverseOrder method discussed in Section 7.7 
	public void printInReverseOrder(BSTNode node) {
            if (node == null) return; //If there is no node, stop
            printInReverseOrder(node.right); //Go to the right child
            System.out.print(node.key + " "); //Print current node 
            printInReverseOrder(node.left);  //Go to the left child
	}

	// Implement the main method based on the program instructions
	public static void main(String[] args) {
           BST tree = new BST();
           int[] keys = {35, 41, 13, 57, 3, 83, 88, 51, 38, 20, 11, 22, 27, 21, 48, 8};

        // Insert keys into the BST
           for (int key : keys) {
               tree.insertKey(key);
        }

        // Print in reverse order
           System.out.println("--------------------------------------");
           System.out.println("Binary Search Tree After Inserts:");
           tree.printInReverseOrder(tree.getRoot());
           System.out.println("\n");

        // Print in 2D
           BSTPrint.print2D(tree.getRoot());

        // Search for key 27 using iterative search
           if (tree.search(27) != null) {
              System.out.println("Found node with key = 27.");
           } else {
               System.out.println("Key 27 not found.");
           }
        
           System.out.println();
           
        // Search for key 89 using iterative search
           if (tree.search(89) != null) {
              System.out.println("Found node with key = 89.");
           } else {
               System.out.println("Key 89 not found.");
        }
    }
}
