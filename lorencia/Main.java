import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class UserDefinedException extends RuntimeException
{
    public UserDefinedException(String str)
    {
        // Calling constructor of parent Exception
        super(str);
    }


}

public class Main {
    public static void method() throws FileNotFoundException {

        FileReader file = new FileReader("C:\\Users\\galya\\Downloads\\Galya_algorithms_ex1.ppt");
        BufferedReader fileInput = new BufferedReader(file);


        throw new UserDefinedException("anyway");


    }

    //main method
    public static void main(String[] args) {
        //function to check if person is eligible to vote or not

        try
        {
            method();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("rest of the code...");
    }
}

