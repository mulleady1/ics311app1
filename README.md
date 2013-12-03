COMPILING AND RUNNING
---------------------
I wrote two shell scripts for compiling and running my project. 

- To compile and run my project and get to the interactive interface of my app, type

    ./run names_sorted_###.txt

  Replace 'names_sorted_###.txt' with whichever input file you want to use.

- To compile and run my project and have it automatically do a 'runtest' on all input files, type

    ./runtests

  Using this method, the output is sent to output.txt. Edit the runtests file as needed to comment
  or uncomment unwanted input files.  Currently, the 1,000,000-sized inputs are commented out.

Or, if you want to compile it yourself, I suggest the following:
    
    cd src
    javac -d ../bin/ ics311km/*.java
    cd ../bin/
    java ics311km/Driver ../names_unsorted_###.txt


CREDITS
-------
Just me.


REVISION HISTORY
----------------
None.


BUG REPORT
----------
No known bugs.


AVAILABLE DOCUMENTATION
-----------------------
Operation:      operation.txt
Reference:      reference.txt, Javadocs in the doc directory
Testing:        testing.txt
