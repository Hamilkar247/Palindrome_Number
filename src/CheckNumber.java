import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by Matball on 2017-05-15.
 */
public class CheckNumber {

    ArrayList<Integer> list_of_palindrome=new ArrayList<>();

    CheckNumber(){
        Scanner reader = new Scanner(System.in);
        char c = reader.next().charAt(0);
        check_Number();
        Print_palindrome();
    }

    void check_Number(){
        for(int i=10;i<100;i++){
            for(int j=10;j<100;j++){
                if(i*j<10000 && i*j>1000){
                    checkThatNumber(i,j);
                }
                else {;}
            }
        }
    }

    void checkThatNumber(int i,int j){
        double number =(double)(i*j);
        if(number%11==0){
            int thousand_diget=(int)Math.floor(number/1000);
            int hundred_diget=(int)Math.floor((number-thousand_diget*1000)/100);
            int ten_diget=(int)Math.floor((number-thousand_diget*1000-hundred_diget*100)/10);
            int one_diget=(int)Math.floor((number-thousand_diget*1000-hundred_diget*100-10*ten_diget)/1);
            if(thousand_diget==one_diget && hundred_diget ==ten_diget ) {
                CheckAndAddNumber((int)number);
            }
        }
    }

    void CheckAndAddNumber(int number){
        boolean flag=true;
        for(int i=0;i<list_of_palindrome.size();i++){
            if(number==list_of_palindrome.get(i)){
                flag=false;
                break;
            }
            flag=true;
        }
        if(flag==true){list_of_palindrome.add(number);}
    }

    void SortPalindrome(){
        Collections.sort(list_of_palindrome, Collections.reverseOrder());
        Collections.reverse(list_of_palindrome);
    }

    void Print_palindrome(){
        SortPalindrome();
        System.out.println(list_of_palindrome);
    }

}
