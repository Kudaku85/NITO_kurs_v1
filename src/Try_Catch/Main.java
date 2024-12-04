package Try_Catch;

import javax.swing.*;
/* We have an assignment. We are going to make a small program used in a productivity analysis for Foodora.
Foodora is interested in finding out how much time their delivery people use on travel, per delivery. Each delivery
has an attached invoice for travel costs using Voi electric scooters. Voi's cost is 3 kr per minute of use, and always
rounds up to the nearest full minute. Our program will take the invoice price and cost per minute as inputs from
the user, and output the length of the ride in minutes.
*/
public class Main {
    public static void main(String[] args) {
        //Normally, if Java finds an exception it will stop (or crash) the program. You will occasionally see this when playing games
        // or using your browser. Crashing software is not ideal, so we'd like to avoid that. One way is using try/catch code.

        //Below we take all the code we want to test for errors, and put it in a try block. If the code inside the try block
        //causes an error, or "throws an exception", Java will first check the catch blocks below to see how to handle the error.
        int totalPrice = 0;
        try {
            //input dialog frequently cause exceptions, because users can provide the wrong data format.
            //An example would be users that input text instead of numbers, or try to divide by zero. Try it yourself!

            totalPrice = Integer.parseInt(JOptionPane.showInputDialog("What was cost of the ride?"));
            int pricePerMinute = Integer.parseInt(JOptionPane.showInputDialog("What was the cost per minute?"));

            //Below we use an if statement to throw a custom Exception if the totalPrice is above 10 000 kr.
            // This is a way to catch user input errors that won't cause exceptions but should still be stopped,
            // such as abnormally high values.
            if (totalPrice > 10_000) {
                throw new IllegalArgumentException("That value is too high, please try again.");
            }
            //Assuming our if statement does not trigger, the code below will run.
            int rideLength = totalPrice / pricePerMinute;
            JOptionPane.showMessageDialog(null, "The ride was " + rideLength + " minutes long.");

            //If the user provides the wrong input, they will trigger an Exception. The catch(NumberFormatException) below tells Java how
            // to handle cases where the user inputs text instead of numbers, uses a comma instead of a period etc. This way Java can help the user
            //correct instead of simply crashing the program.
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "The number value you typed in was not recognized.");
        }

        //The catch(ArithmeticException) below tells Java how to handle arithmetic errors, such as when users try to divide an integer by zero.
        catch (ArithmeticException e) {
            JOptionPane.showMessageDialog(null, "I'd appreciate if you did not divide by zero, it gives me a headache.");
        }
        //The code belows tells Java how to handle the IllegalArgumentError we created on line 26.
        catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(null, "Are you sure the cost of your trip was " + totalPrice + "? That seems like a lot");
        }
        //Finally, if none of the other catches have been triggered, we have a generic catch(Exception) that will handle all other error messages.
        catch (Exception e) {
            //Note that all the catch methods take in "e", which contains the error message from Java.
            // We can use "e" to print the error message Java gives us, as shown below. That's not quite as good as writing our own error messages
            // (Java error messages tend to be cryptic), but better than nothing.
            JOptionPane.showMessageDialog(null, "Something went wrong. Here is the error message: \n" + e);
        }
    }
}