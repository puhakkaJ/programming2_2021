
# This assignment asks you to write an assembly-language program that
# computes the remainder when dividing one positive integer with another.
        
# Your task is to write an assembly-language program that computes the 
# remainder when dividing $0 by $1. The result must be stored into $2. Both
# $0 and $1 are guaranteed to be nonzero positive integers. Note that there
# is a limit to the number of ticks your program may run. Even if your program
# produces correct output you may need to optimize it if it's not fast enough.
#
# What makes this task challenging is that our "armlet" architecture
# has no hardware support for division, so you will have to make do
# without.  Note that there is a limit to the number of ticks your 
# program may run. Even if your program produces correct output you 
# may need to optimize it if it's not fast enough.
#
# Hint: You might try subtracting one number from another repeatedly. But is
# that really the fastest way?

# Here is some wrapper code to test your solution:

        mov     $0, 26064     #devider  # load values to registers $0,$1
        mov     $1, 4706      #divisor

# Your solution starts here ...18826
# ------------------------------------------
        
        nop  
                          # ready for your code over here
        mov $3, $1        #SCALED_divisor
        mov $2, $0        #reminder = output
        mov $5, 1         #multiple

@loop1:                   #here finding the multiply of divisor witch first exceeds the devider
        cmp $3, $0        #if scaled_divisor >= dividend
        bae >done1
        add $3, $3, $3    #multiply of divisor (divisor = divisor*2)
        add $5, $5, $5    #multiply of multiple (multiple = multiple*2)
        jmp >loop1

@done1:                   #now we have the scaled_divisor witch is larger than dividend
        cmp $2, $3        #if remain >= scaled_divisor
        bae >done
        lsr $3, $3, 1     #if remain < scaled_diivisor then (scaled_diivisor = scaled_diivisor/2)
        lsr $5, $5, 1     #if remain < scaled_diivisor then (multiple = multiple/2)
        cmp $5, 0         #if multiple==0 we are done
        beq >end      
        jmp >done1        #if multiple!=0 loop done1 keeps going

@done:                    #here if remain >= scaled_divisor
        sub $2, $2, $3    #remain = remain - scaled_divisor
        lsr $3, $3, 1     #(scaled_diivisor = scaled_diivisor/2)
        lsr $5, $5, 1     #(multiple = multiple/2)
        cmp $5, 0         #if multiple==0 we are done
        beq >end
        jmp >done1        #if multiple!=0 back to loop done1

@end:
        hlt

# ------------------------------------------
# ... and ends here 

        hlt                     # the processor stops here

# (at halt we should have 2534 in $2)


        mov $2, $0
@loop:
        cmp $2, $1
        blt >done
        sub $2, $2, $1
        jmp >loop

@done:  
hlt