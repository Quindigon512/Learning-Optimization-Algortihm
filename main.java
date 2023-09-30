///////////////////////////////////////////////////////
// Author:   Quinn Trate
// Date:     September 29, 2023
// Class:    CMPSC 463 Algorithms
// Language: Java
// Purpose:  Optimizes a Student's Class Schedule
//           Using The Class Deadlines and Arbitrary
//           "Learning Values"
///////////////////////////////////////////////////////

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        // Variables
        Scanner scanner = new Scanner(System.in);
        int length = 0;
        int deadline;
        int index = -1;
        int index2 = -1;
        int totalCourses = 0;
        int totalLearning = 0;

        // Get Number of Classes
        System.out.println("Enter the Total Number of Classes:");
        int n = scanner.nextInt();

        // Get Class Information
        System.out.println("\nEnter the Information for " + n + " Classes (Class ID, Semester Deadline, Learning Value):");
        int[][] course = new int[n][3];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < 3; j++)
                course[i][j] = scanner.nextInt();
        }

        // Set Maximum Length of the Schedule
        for (int i = 0; i < n; i++)
        {
            if (course[i][1] > length)
                length = course[i][1];
        }

        // Sort the Courses Array
        int sortLength = course.length;
        for (int i = 0; i < sortLength - 1; i++)
        {
            int curr = i;
            for (int j = i + 1; j < sortLength; j++)
            {
                if (course[j][2] > course[curr][2])
                    curr = j;
            }
            int[] temp = course[i];
            course[i] = course[curr];
            course[curr] = temp;
        }

        // Create Learning Array Filled with -1
        int[] takenCourses = new int[n];
        Arrays.fill(takenCourses, -1);

        // Fill Learning Array with Values
        for(int i = 0; i < n; i++)
        {
            deadline = course[i][1];
            if (takenCourses[deadline - 1] < course[i][2])
            {
                for (int k = 0; k < deadline; k++)
                {
                    if (takenCourses[k] == -1)
                        index = k;
                }
                if (index != -1)
                    takenCourses[index] = course[i][2];
            }
            else
            {
                for (int j = deadline - 1; j > 0; j--)
                {
                    if (takenCourses[j - 1] < course[i][2])
                    {
                        if (takenCourses[j - 1] == -1)
                        {
                            takenCourses[j - 1] = course[i][2];
                            break;
                        }
                        else
                        {
                            for (int k = 0; k < deadline; k++)
                            {
                                if (takenCourses[k] == -1)
                                    index2 = k;
                            }
                            if (index2 != -1)
                                takenCourses[index2] = course[i][2];
                        }
                    }
                }
            }
        }

        // Add up non -1 Values in Learning Array
        for (int i = 0; i < length; i++)
        {
            if (takenCourses[i] != - 1)
            {
                totalCourses++;
                totalLearning += takenCourses[i];
            }
        }

        // Output
        System.out.println("\nNumber of Courses Taken: " + totalCourses);
        System.out.println("Total Learning Value: " + totalLearning);
    }
}
