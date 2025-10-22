public class BitManipulation {
    public static void main(String[]args){
        // printBits(32);
        // printOddEven(35);
        // int res = setIthBit(32, 0);
        // printBits(res);

        // printBits(33);
        // int res = toggleIthBit(33, 4);
        // printBits(res);

        // printBits(33);
        // int res = unsetIthBit(33, 0);
        // printBits(res);

        // isPowerOfTwo(32);
        // printBits(48);
        // int res = unsetRightMostBit(40);
        // printBits(res);
        // System.out.println(countUnsetBits(48));
        // printBits(53);
        // int res1 = clearLSB(53, 4);
        // printBits(res1);

        // int res2 = clearMSB(53,4);
        // printBits(res2);

        // int res3 = clearMSBexclusive(53, 4);
        // printBits(res3);

        char ch1 = convertCharToLowerCase('A');
        System.out.println(ch1);
        char ch2 = covertCharToUpperCase('a');
        System.out.println(ch2);


        
    }
    
    //print Bits of a number
    //considering a number of 8 bits
    public static  void printBits(int num){
        for(int i = 7; i>=0;i--){
            System.out.print((num >> i) & 1);
        }
        System.out.println();
    }

    //check if a number is odd or even
    public static void printOddEven(int num){
        if(isSet(num, 0)){
            System.out.println("Number is odd");
        }else{
            System.out.println("Number is even");
        }
    }

    //checks if the ith bit of a number is set or not
    public static boolean isSet(int num , int bit){
        int res = num & (1 << bit);
        return (res == 0)?false :true;
    }

    //set the ith bit of a number
    public static int setIthBit(int num , int bit){
        return num | (1 << bit);
    }

    //toggle the ith bit of a number
    public static int toggleIthBit(int num , int bit){
        return num ^ (1<<bit);
    }
    
    //unset the bit at ith position
    public static int unsetIthBit(int num , int bit){
        return num & ~(1 << bit);
    }

    //to check if a number is power of 2
    public static void isPowerOfTwo(int num){
        if((num & num -1) == 0){
            System.out.println("Number is a power of 2");
        }else{
            System.out.println("Number is not a power of 2");
        }
    }

    //unset the right most bit of a number
    public static int unsetRightMostBit(int num){
        return (num & (num-1));
    }

    //check the number of unset bits in a number
    public static int countUnsetBits(int num){
        int count = 0;
        while (num !=0){
            num = unsetRightMostBit(num);
            count+=1;
        }

        return count;
    }

    //clear all LSB's from ith position
    public static int clearLSB(int num,int bit){
        return num & ~((1<<(bit+1))-1);
    }

    //clear all MSB's till ith position
    public static int clearMSB(int num , int bit){
        return num &((1<<bit)-1);
    }

    //clear all MSBs till (i-1)th positiion
    public static int clearMSBexclusive(int num , int bit){
        return num & ((1<<bit+1)-1);
    }

    //Convert lower case to upper case
    public static char covertCharToUpperCase(int num){
        return (char)(num & ~(1<<5));
    }

    //Convert upper to lower case
    public static char convertCharToLowerCase(int num){
        return (char)(num | (1<<5));
    }
    

}
