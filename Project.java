import java.util.*;

public class Project {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int arrayLength, instructionsCount;

        //Getting array length
        arrayLength = input.nextInt();

        //Getting instructions count
        instructionsCount = input.nextInt();

        //Defining array
        LinkedList<Integer>[] array = new LinkedList[(int) Math.sqrt(arrayLength)];

        //Resolving null pointer exception
        for (int i = 0 ; i < array.length ; i++) {
            array[i] = new LinkedList<>();
        }

        //Getting values and putting them in array
        for (int i = 0 ; i < array.length ; i++) {
            for (int j = 0 ; j < (int) Math.sqrt(arrayLength) ; j++) {
                array[i].add(input.nextInt());
            }
        }

        //Putting remaining numbers in last linked list
        int z = array.length * array.length;
        if (z != arrayLength) {
            for (int i = 0 ; i < arrayLength - z ; i++) {
                array[array.length - 1].add(input.nextInt());
            }
        }

        //Getting and executing instructions
        for (int i = 0 ; i < instructionsCount ; i++) {

            //x is index of start linked list and y is index of end linked list
            int x = 0, y = 0;

            //Executing instruction of first kind (cyclic shift with array[i] and array[j])
            if (input.nextInt() == 1) {

                //Finding start index
                int start = input.nextInt();
                while (start > array[x].size()) {
                    start -= array[x].size();
                    x++;
                }
                start--;

                //Finding end index
                int end = input.nextInt();
                while (end > array[y].size()) {
                    end -= array[y].size();
                    y++;
                }
                end--;

                //Deleting last member of middle linked lists and adding them into the first place of the next one
                for (int n = x + 1 ; n < y ; n++) {
                    array[n + 1].addFirst(array[n].getLast());
                    array[n].removeLast();

                    //Adding end index in case of one member is added to the first place of linked list
                    if (n == y - 1) {
                        end++;
                    }
                }

                //Deleting end index and adding it before start index
                array[x].add(start, array[y].get(end));
                array[y].remove(end);

            }

            //Executing instruction of second kind (printing array[i])
            else {
                int index = input.nextInt();
                while (index > array[y].size()) {
                    index -= array[y].size();
                    y++;
                }
                System.out.println(array[y].get(index - 1));
            }
        }

    }

}