# Learning-Optimization-Algortihm
Optimizes a Student's Class Schedule Using The Class Deadlines and Arbitrary "Learning Values"


Problem Description:
You are a computer science undergrad student and you want to maximize your learning while minimizing the amount of work you do. You are given a set of N courses where each course comes with a deadline and a
learning value. You can only take a course if you complete it by its deadline. Find the number of courses you can take and the maximum learning value you can achieve. You can only take one course at a time, and
each course takes a single unit of time.

NOTE:-If a particular course has a deadline of 'x', it means that it needs to be completed at any time before 'x'. For example, if a course has a deadline of two, it means that it needs to be completed by the end
of the second semester.

The assumption that the start time is zero means that the student can start taking courses immediately.


Sample Run:
Enter the Total Number of Classes:
7

Enter the Information for 7 Classes (Class ID, Semester Deadline, Learning Value):
1 1 20
2 1 40
3 1 30
4 1 30
5 7 10
6 7 10
7 7 10

Number of Courses Taken: 4
Total Learning Value: 70

Process finished with exit code 0


Sample Run Description:
In this sample run, there are four courses with a deadline of one, so only one of them can be chosen, which is course 2 since it has the highest learning value. The other three courses have a deadline of seven, so
they can all be chosen because they can be taken before the deadline. The courses chosen are 2, 5, 6, and 7 with a total learning value of 70.
