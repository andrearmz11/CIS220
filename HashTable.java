//Andrea Ramirez
//Chpt 6 PA

//This program implements a hash table to store, search, insert, and remove key-value pairs

// Class to represent the key-value pair (Item)
class Item {
    String key;  
    String value;  
    Item next;  

    // Constructor to initialize the key-value pair and set the next pointer to null
    public Item(String key, String value) {
        this.key = key;  
        this.value = value;  
        this.next = null;  
    }
}

// Class to represent a hash table 
class HashTable {
    private Item[] hashTable;  
    private int length;  

    // Constructor to initialize the hash table with a specified size
    public HashTable (int size) {
        this.length = size;  
        this.hashTable = new Item[length];  
    }

    // Hash method to get the index for a given key
    public int hash(String key) {
    int initialValue = 0; // Initial value
    int multiplier = 13; // Multiplier value
    
   //Loop through each character and update stringHash
    for (int i = 0; i < key.length(); i++) {
        char currentChar = key.charAt(i); 
        initialValue = (initialValue * multiplier) + (int) currentChar;
    }

    return initialValue; // Return the hash value 
}	
    // Method to Insert the specified key-value pair into the hash table, pseudocode found in Figure 6.3.1 with 
    public boolean hashInsert(String key, String value) {
        int bucketIndex = hash(key) % length;  

        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                currentItem.value = value;  
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        Item newItem = new Item(key, value);  
        if (hashTable[bucketIndex] == null) {  
            hashTable[bucketIndex] = newItem;  
        } else {
            previousItem.next = newItem;  
        }
        return true;  
    }

    // Method to search for the specified key and return the corresponding value, pseudocode found in Figure 6.3.1
    public String hashGet(String key) {
        int bucketIndex = hash(key) % length;  
        Item item = hashTable[bucketIndex];  

        while (item != null) {  
            if (item.key.equals(key)) {  
                return item.value;  
            }
            item = item.next;  
        }

        return null;  
    }

    // Method to remove the key-value pair from the hash table, pseudocode found in Figure 6.3.1
    public boolean hashRemove(String key) {
        int bucketIndex = hash(key) % length;  
        Item currentItem = hashTable[bucketIndex];  
        Item previousItem = null;  

        while (currentItem != null) {  
            if (currentItem.key.equals(key)) {  
                if (previousItem == null) {  
                    hashTable[bucketIndex] = currentItem.next;  
                } else {  
                    previousItem.next = currentItem.next;  
                }
                return true;  
            }
            previousItem = currentItem;  
            currentItem = currentItem.next;
        }

        return false;  
    }

    // Method to print the entire hash table, showing each bucket and its key-value pairs
	// Update the method to display the hash for each key-value pair
    public void printTable() {
        for (int i = 0; i < length; i++) {  
            System.out.print("Bucket " + i + ": ");  
            Item currentItem = hashTable[i];  
            if (currentItem == null) {  
                System.out.println("empty");  
            } else {
                while (currentItem != null) {
                    int hashValue = hash(currentItem.key);  
                    System.out.print("[Hash is: " + hashValue + ", key is: " + currentItem.key + ", value is: " + currentItem.value + "] ");
                    currentItem = currentItem.next;  
                }
                System.out.println();  
            }
        }
    }

    // Main method for testing the HashTable class
	// Implement the main method per the assignment instructions
    public static void main(String[] args) {
        HashTable table = new HashTable(5);  // Create a hash table with 5 buckets
        
        //Insert key-value pairs
	table.hashInsert("keyA1", "value1");
        table.hashInsert("keyB2", "value2");
        table.hashInsert("keyC3", "value3");
        table.hashInsert("keyD23", "value23");
        table.hashInsert("keyE45", "value45");
        table.hashInsert("keyF52", "value52");

        System.out.println("HashTable contents: ");
        table.printTable(); // Print the hash table contents

        System.out.println();
        boolean removed = table.hashRemove("keyF52"); // Remove keyF52
        if (removed) {
            System.out.println("keyF52 was removed");
        } else {
            System.out.println("keyF52 removal failed");
        }

        System.out.println();
        String valueZ6 = table.hashGet("keyZ6"); //Attempt to get non-existing key's value
        if (valueZ6 != null) {
            System.out.println(valueZ6);
        } else {
            System.out.println("keyZ6 was not found");
        }

        System.out.println();
        String valueC3 = table.hashGet("keyC3");//Get keyC3
        if (valueC3 != null) {
            System.out.println(valueC3);
        } else {
            System.out.println("keyC3 not found");
        }

        //Insert more key-value pairs
        table.hashInsert("keyG18", "value18"); 
        table.hashInsert("keyH7", "value7"); 
        table.hashInsert("keyI33", "value33"); 
        table.hashInsert("keyD23", "newvalue23");

        System.out.println();
        System.out.println("HashTable contents after additional inserts, removal, and update: ");
        table.printTable(); // Print the hash table contents
    }
}
