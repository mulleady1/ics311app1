IMPORTANT
---------
The DynamicSet interface declares that search(), minimum(), maximum(),
successor(), and predecessor() all return an Object. My implementations of
DynamicSet return an Object that can be casted to a KeyType. You can and 
should cast the returned element to a KeyType, that way you can call its
getValue() method to get the data that was inserted.


ABOUT THESE FILES
-----------------
The java files in the ics311km directory are my open source implementations
of the data structures for Assignment 1. You can use them for your project,
which is a win-win for both of us:

- You have much less code to write now
- I get extra credit because you're using my code

If you use my code, you have to credit me in the comments of your code as well
as in your README file. Check out the details under "Including Open Source 
Software" and "Documentation Requirements" here:

http://www2.hawaii.edu/~suthers/courses/ics311f13/Syllabus/Assignments.html

Mahalo and enjoy!

Kyle Mulleady
