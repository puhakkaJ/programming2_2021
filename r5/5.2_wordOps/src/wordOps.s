
# This assignment asks you to implement some basic word operations
# with assembly language.

# Namely, your solution should implement all of the following:
# 1) Reverse the order of bits in $0 and store the result in $5
#    (that is, the bit in position 0 goes to position 15, position 1 goes
#    to position 14, position 2 goes to position 13, ..., and position 15
#    goes to position 0; the contents of $0 must remain unchanged);
# 2) Count the number of 1-bits in $0 and store the result in $6; and
# 3) Rotate the bits in $0 by one position to the left and store 
#    the result in $7. (That is, bit in position 0 goes to position 1, 
#    position 1 goes to 2, position 2 goes to 3, ..., position 14 goes 
#    to position 15, and position 15 goes to position 0.)

# Here is some wrapper code to test your solution:
        
        mov     $0, 62361       # load test input to $0
                
# Your solution starts here ...
# ------------------------------------------
        
        nop                     # ready for your code over here
                mov $1, 0
                mov $5, 0x0
                mov $3, 0x1
                mov $4, $0

@loop1:
                cmp $1, 16        # compare $7 (left) and 0 (right)
                beq >done2
                lsl $5, $5, 1
                and $2, $4, $3
                ior $5, $2, $5
                lsr $4, $4, 1
                add $1, $1, 1
jmp >loop1

                @done2:
                mov $1, 0
                mov $6, 0
                mov $3, 0
                mov $4, $0

      @loop2:
                cmp $1, 16        # compare $7 (left) and 0 (right)
                beq >done1
                and $3, $4, 1
                lsr $4, $4, 1 

                cmp $3, 1
                beq >done3

                add $1, $1, 1
                jmp >loop2
@done3:
add $6, $6, 1
add $1, $1, 1
jmp >loop2

@done1:
mov $4, $0
lsl $3, $4, 1 
lsr $1, $4, 15
ior $7, $1, $3
hlt

                
                




                  
# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# (at halt we should have 39375 in $5, 10 in $6, and 59187 in $7)


