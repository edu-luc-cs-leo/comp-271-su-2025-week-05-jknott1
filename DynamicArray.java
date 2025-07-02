/**
 * Object adjusts the size of underlying array to accommodate any number of new
 * elements added to it. The class is written as generic.
 */
public class DynamicArray {

    private static final int DEFAULT_SIZE = 4;
    private static final int RESIZE_FACTOR = 2;

    /** The underlying array of the data structure */
    private String[] underlying;
    /** How many elements have been added to the underlying array */
    private int occupancy;

    /** Basic constructor */
    public DynamicArray(int size) {
        // Guard statement here to ensure that the user-provided size is legit.
        if (size < 1) {
            size = DEFAULT_SIZE;
        }
        // Create an Object array of the requested size, then cast it
        // as an array of objects E
        this.underlying = new String[size];
        // At the beginning the underlying array is empty
        this.occupancy = 0;
    } // basic constructor

    /** Default constructor */
    public DynamicArray() {
        this(DEFAULT_SIZE);
    } // default constructor

    /**
     * Resize the underlying array as needed.
     * 
     * @param resize_by int factor multiply the size of the underlying array
     */
    private void resize() {
        // Create temporary array of DOUBLE the size of the underlying array
        String[] temp = new String[2 * this.underlying.length];
        for (int i = 0; i < this.underlying.length; i++) {
            temp[i] = this.underlying[i];
        }
        this.underlying = temp;
    } // method resize

    public void add(String string) {
        // Is there room in the underlying array?
        if (this.occupancy == this.underlying.length) {
            this.resize();
        }
        // At this point there is guaranteed room in the array, either
        // because we just doubled it in size or because there was enough
        // room for one more element to begin with.
        this.underlying[this.occupancy] = string;
        this.occupancy++;
    } // method add

    /**
     * method to find the position of an element in the underlying array. ASSIGNMENT 04 NOTE: only finds the first instance of
     * the element in the array.
     * 
     * @return -1 if string not present, otherwise underlying array position of
     *         first occurrence of string.
     */
    public int indexOf(String string) {
        // default assignment assumes the value is not in the list, returning -1.
        int index = -1;
        // cursor index - starts at the first element, [0]
        int cursor = 0;
        // scan the underlying list to see if desired string is in the list.
        // if i exceeds the length of the list or i is found, stop iterating through the list.
        while (cursor < this.underlying.length && this.underlying[cursor] != string) {
            // moves on in the list by increasing cursor index by 1.
            cursor++;
        }
        // if the loop doesn't find the element, the index will be the size of the underlying array. The index also
        // cannot be greater than the length of the array, as shown above.
        // So, cursor can only be equal to or less than the length. If it is not equal to the length of the array,
        // then the loop found the element
        if (cursor != this.underlying.length) {
            index = cursor;
        }
        return index;
    } // method indexOf

    /** Method to tell if a string exists in the underlying array */
    public boolean contains(String string) {
        return (this.indexOf(string) >= 0); // uses indexOf and sees if it returns the default value or not and returns that boolean
    } // method contains

    /** Method to count how many times a string appears in the underlying array*/
    public int countOf(String string) {
        // counts how many times the instance of string appears
        int count = 0;
        // tracks the current index
        int index = 0;
        // loop iterates through the list and adds one to "count" when an instance is detected.
        while (index < this.underlying.length) {
            if (this.underlying[index] == string) {
                count++;
            }
            // moves through underlying list
            index++;
        }
        return count; //either returns 0 as the default or the number of instances.
    } // method countOf

    /** method to remove items from the underlying array */
    public String remove(int index) {
        // string to be returned
        // has a default value of "null"
        String retStr = null;
        // initializes a new temporary array 
        // has length of one less than the old array, as one element is being removed.
        String[] temp  = new String[this.underlying.length - 1];
        // if the index is valid (not negative and not greater than the array)
        // starts a loop
        if (!(index >= this.underlying.length || index < 0)) {
            // return string returns the removes element
            retStr = this.underlying[index];
            // two loops:
            // the first assigns the elements directly from the original array to the new one until the element at index
            // is reached
            // the second assigns the element starting one ahead from the index in the old array to the index in the temp array.
            for (int i = 0; i < index ; i++) {
                temp[i] = this.underlying[i];
            }
            for (int i = index; i < temp.length; i++) {
                temp[i] = this.underlying[i + 1];
            }
            // assigns the temp array as the new underlying
            this.underlying = temp;
        }
        return retStr;
    } //method remove

    /** overload remove */ 
    public String remove(String string) {
        // assigns index to the first element that matches the "string" parameter.
        int index = this.indexOf(string);
        // string to be returned
        // has a default value of "null"
        String retStr = null;
        // initializes a new temporary array 
        // has length of one less than the old array, as one element is being removed.
        String[] temp  = new String[this.underlying.length - 1];
        // if the index is valid (not negative and not greater than the array)
        // starts a loop
        if (!(index >= this.underlying.length || index < 0)) {
            // return string returns the removes element
            retStr = this.underlying[index];
            // two loops:
            // the first assigns the elements directly from the original array to the new one until the element at index
            // is reached
            // the second assigns the element starting one ahead from the index in the old array to the index in the temp array.
            for (int i = 0; i < index ; i++) {
                temp[i] = this.underlying[i];
            }
            for (int i = index; i < temp.length; i++) {
                temp[i] = this.underlying[i + 1];
            }
            // assigns the temp array as the new underlying
            this.underlying = temp;
        }
        return retStr;
    } //method remove

    /** Complete this method */
    public String toString() {
        // initializing return string
        String retStr;
        // beginning of the string is formatted to be brackets (as arrays usually start with)
        String begString = "[";
        // ends with a closing brackets
        String endString = "]";
        // initializing the mid contents of the string, which is all the new values
        String midString = "";
        for (int i = 0; i < this.underlying.length; i++) {
            // fencepost - first element is formatted differently. doesn't start with a comma and a space
            // other than that, every element is seperated by commas and is encased in quotes
            if (i == 0) {
                midString += "\"" + this.underlying[i] + "\"";
            } else {
                midString += ", \"" + this.underlying[i] + "\"";
            }
        }
        // builds the entire return string
        retStr = begString + midString + endString;
        return retStr;
    } //method toString

} // class DynamicArray