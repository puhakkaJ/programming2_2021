
# This assignment asks you to find the most frequent value in a data array.
        
# Namely, you must find the most frequently occurring value in a data
# array that starts at memory address $0 and contains $1 words.
# The most frequent value must be stored in register $2.
# Complete and submit the part delimited by "----" and indicated
# by a "nop" below.

# Here is some wrapper code to test your solution:

        mov     $0, >test_data  # set up the address where to get the data
        mov     $1, >test_len   # set up address where to get the length
        loa     $1, $1          # load the length from memory to $1

# Your solution starts here ...
# ------------------------------------------
        
      nop                     # ready for your code over here


      mov $2, $0
      sub $1, $1, 1           
      mov $5, 0               # max numbers in list
      mov $6, $2              # set up address of observed
      add $1, $2, $1          # address of the last data item
      
      jmp >loop1

@loop:
      add $6, $6, 1
      cmp $3, $5              # compare count to the max
      bae >max
      jmp >loop1

@max:
      mov $5, $3
      mov $2, $0              # max item in the moment
      jmp >loop1

@loop1:
      cmp $6, $1              # compare observed address and last address if > then done 
      bab >end
      mov $3, 1               # count of words in the list
      loa $0, $6              # set up a item thats been observed
      add $7, $6, 1           # set up address of the next element after the observed one
      jmp >loop2

@loop2:
      cmp $7, $1              # compare current address and last address if > then done with the item
      bab >loop
      loa $4, $7              # set up a item thats been observed
      cmp $4, $0              # compare observed item and current item if == then count += 1
      beq >add1
      add $7, $7, 1
      jmp >loop2
      
@add1:
      add $3, $3, 1
      add $7, $7, 1
      jmp >loop2
      
@end:
    hlt



# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# Here is the test data:
# (the most frequent value is 56369 with frequency 5 in the array)

@test_len:
        %data   23
@test_data:
        %data   18701, 1100, 590, 17017, 56369, 19296, 1100, 56369, 1100, 56369, 590, 18701, 19296, 19296, 56369, 1100, 55034, 590, 29135, 18701, 18701, 29135, 56369


