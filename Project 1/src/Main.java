import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        int i;
        int j;
        boolean trueBFS = false;


        /**
         * Take input argument (file location and name)
         * Separates values based on the comma
         */
        Scanner scanner = new Scanner(new File(args[0]));
        scanner.useDelimiter(",");

        /**
         * creates new adjacency matrix of integers based on number of vertices
         */
        int sizeOfMatrix = Integer.parseInt(scanner.next());
        int[][] adjMatrix = new int[sizeOfMatrix][sizeOfMatrix];

        for (i = 0; i < sizeOfMatrix; i++) {
            for (j = 0; j < sizeOfMatrix; j++) {
                adjMatrix[i][j] = Integer.parseInt(scanner.next());
            }
        }

        /**
         * checks if there are entries for shortest path and makes breadth first search true
         */
        if (scanner.hasNext()) {
            int firstVertex = Integer.parseInt(scanner.next()) - 1;
            int secondVertex = Integer.parseInt(scanner.next()) - 1;
            trueBFS = true;

            bfs(adjMatrix, firstVertex, secondVertex);
        }

        /**
         * Prints out matrix created as test
         */
        System.out.println("Here is the matrix: ");
        for (i = 0; i < sizeOfMatrix; i++) {
            for (j = 0; j < sizeOfMatrix; j++) {
                System.out.print(adjMatrix[i][j]);
            }
            System.out.print('\n');
        }
    }

    public static void bfs(int [][] inputMatrix)
    {
        Queue <Integer> myQueue = new LinkedList();

        int numberVertices = inputMatrix[0].length;
        System.out.println("ACTUAL SIZE??? " + numberVertices);

        List <Integer> visited = new ArrayList();


        boolean isConnected = true;
        boolean isCycle = false;
        boolean isBipartite = false;

        int currentVertex = 0;

        outerloop:
        while(visited.size() < numberVertices)
        {
            for(int i = 0; i < numberVertices; i++)
            {
                System.out.println("\nRun number: " + i + "\nCurrent Vertex: " + currentVertex);
                if(inputMatrix[currentVertex][i] == 1 && !visited.contains(i))
                {
                    if(myQueue.contains(i))
                        isCycle = true;
                    else
                        myQueue.add(i);
                }
                System.out.println("This is the queue right now: " + myQueue);
                System.out.println("This is the visited list right now: " + visited);
            }
            visited.add(currentVertex);
            if(visited.size() < numberVertices && myQueue.isEmpty()) {
                isConnected = false;
                break outerloop;
            }

            if(visited.size() < numberVertices)
                currentVertex = myQueue.remove();


        }
        System.out.println(visited);
        int i = 0;
        while(i < visited.size())
        {
            visited.set(i,visited.get(i)+1);
            i++;
        }
        System.out.println("Is this a cycle? " + isCycle + "\n Is this connected? " + isConnected);
        System.out.println(visited);

    }

    public static void bfs(int [][] inputMatrix, int startingLocation, int endingLocation)
    {
        Queue <Integer> myQueue = new LinkedList();

        int numberVertices = inputMatrix[0].length;
        System.out.println("ACTUAL SIZE??? " + numberVertices);

        List <Integer> visited = new ArrayList();

        int currentVertex = startingLocation;

        outerloop:
        while(!visited.contains(endingLocation))
        {
            for(int i = 0; i < numberVertices; i++)
            {
                System.out.println("\nRun number: " + i + "\nCurrent Vertex: " + currentVertex);
                if(inputMatrix[currentVertex][i] == 1 && !visited.contains(i) && !myQueue.contains(i))
                {
                        myQueue.add(i);
                }
                System.out.println("This is the queue right now: " + myQueue);
                System.out.println("This is the visited list right now: " + visited);
            }
            visited.add(currentVertex);
            if(visited.size() < numberVertices)
                currentVertex = myQueue.remove();
        }
        System.out.println(visited);
        int i = 0;
        while(i < visited.size())
        {
            visited.set(i,visited.get(i)+1);
            i++;
        }
        System.out.println(visited);
    }
}


//6,0,1,0,1,0,0,1,0,1,0,1,0,0,1,0,1,0,0,1,0,1,0,0,0,0,1,0,0,0,1,0,0,0,0,1,0


/*

        int i, element;

        visited[1] = 1;
        myQueue.add(1);

        boolean isCycle = false;

        while(!myQueue.isEmpty())
        {
            element = myQueue.remove();
            i = element;
            System.out.print(i + "\t");
            while(i <= numberVertices){
                if(inputMatrix[element][i] == 1 && visited[i] == 0)
                {
                    if(myQueue.contains(i))
                        isCycle = true;
                    myQueue.add(i);
                    visited[i] = 1;
                }
                i++;
            }
        }
        System.out.println("Is it a cycle: " + isCycle);
 */


    /*    public static boolean is_connected(int sizeOfMatrix, int[][] adjMatrix){

            /**
             * If a matrix has a full row or column of 0's, it is not connected
             * First nested loop checks 0's in each row for all column values
             * Second nested loop checks 0's in each column for all row values


            for (int i = 0; i < sizeOfMatrix; i++){
                int zeroChecker = 0;
                for(int j = 0; j < sizeOfMatrix; j++){
                   if(adjMatrix[i][j] == 0){
                       zeroChecker += 1;
                   }
                }
                if(zeroChecker == sizeOfMatrix - 1){
                    return false;
                }
            }
            for (int i = 0; i < sizeOfMatrix; i++){
                int zeroChecker = 0;
                for(int j = 0; j < sizeOfMatrix; j++){
                    if(adjMatrix[j][i] == 0){
                        zeroChecker += 1;
                    }
                }
                if(zeroChecker == sizeOfMatrix - 1){
                    return false;
                }
            }
            return true;
        }
*/