/*
score: 7.5 + 1(extra credit)
Great Job! Be careful with corner cases
*/
package test;
/**
 * Created by Rose on 1/21/17.
 * Modified by Kevin(Kaiwen Zheng, 001278638) on 1/23/17.
 * Assignment for your lecture 2. Please finish all the questions under
 * 'Assignment'. Assignment 2 includes 3 interview prepare questions. They
 * are similar to what you will meet during your technical interviews. Write some tests as practice.
 * Please try to think the extra credit question. The deadline of this assignment is 01/26/2017 23:59 PST.
 * Please feel free to contact me for any questions.
 */

class Employee {
    String name;
    int age;
    Gender gender;
    double salary;// salary per month


    public Employee(String name, int age, Gender gender, double salary) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void raiseSalary(double byPercent){this.salary = this.salary * byPercent;}    //New method to change the salary
}

enum Gender {
    MALE,
    FEMALE;
}


public class Assignment2 {
    // Assignment

    /**
     * Write a method to calculate the Social Security Tax of an employee and print it.
     * If the salary is less than or equal to 8900, the Social Security Tax is 6.2% of the salary.
     * If the salary is more than 8900, the Social Security Tax is 6.2% of 106,800.
     */
    public double socialSecurityTax(Employee employee) {                       //correct
        //write your code here

        double sst;

        if (employee.salary <= 8900){    		//For salary less than or equal to 8900
            sst = employee.salary * 0.062;}
        else{                            		//For salary more than 8900
            sst = 106800 * 0.062;}

        return sst;
    }

    /**
     * Write a method to calculate an employee's contribution for insurance coverage and print it.
     * Amount of deduction is computed as follows:
     * If the employee is under 35, rate is 3% of salary; if the employee is between 35 and 50(inclusive), rate is 4% of salary;
     * If the employee is between 50 and 60(exclusive), rate is 5% of salary; If the employee is above 60, rate is 6% of salary.
     */
    public double insuranceCoverage(Employee employee) {                                //correct
        //write your code here

        double ic;

        if (employee.age < 35){                               //For age under 35
            ic = employee.salary * 0.03;}
        else if (employee.age >= 35 && employee.age <= 50){   //For age between 35 and 50(inclusive)
            ic = employee.salary * 0.04;}
        else if (employee.age > 50 && employee.age < 60){     //For age between 50 and 60(exclusive)
            ic = employee.salary * 0.05;}
        else{                                                 //For age above 60
            ic = employee.salary * 0.06;}

        return ic;

    }

    /**
     * Write a method to sort three employees' salary from low to high, and then print their name in order.
     * For example, Alice's salary is 1000, John's salary is 500, Jenny's salary is 1200, you should print:
     * John Alice Jenny
     */
    public void sortSalary(Employee e1, Employee e2, Employee e3) {           //the requirment is sort from low to high, but your output is high to low. However, it is still a good piece of code 
        //write your code here

        String[] nArray = {e1.name, e2.name, e3.name};
        double[] sArray = {e1.salary, e2.salary, e3.salary};     //Two arrays for recording the order

        double s;
        String n;
        for (int i = 0; i < 2; i++) {							 //Change order
            for (int j = i + 1; j < 3; j++){
                if (sArray[j] > sArray[i]) {                    
                    s = sArray[i];                              
                    n = nArray[i];
                    sArray[i] = sArray[j];
                    nArray[i] = nArray[j];
                    sArray[j] = s;
                    nArray[j] = n;
                }
            }
        }

        System.out.println(nArray[0] + " " + nArray[1] + " " + nArray[2]);
    }



    /**
     * Write a method to raise an employee's salary to three times of his/her original salary.
     * Eg: original salary was 1000/month. After using this method, the salary is 3000/month.
     * Do not change the input of this method.
     * Try to add a new method in Employee class: public void raiseSalary(double byPercent)
     */
    public void tripleSalary(Employee employee) {                                     //correct!
        //write your code here

        double b = employee.salary;
        employee.raiseSalary(3);        										//change the salary
        System.out.println("The employee: " + employee.name + "'s salary has been raised from " + b + "/month to " + employee.salary + "/month.");
    }

    //Interview prepare questions

    /**
     * Write a method to determine whether a number is prime
     */
    public boolean isPrime(int n) {                                                      //correct
        //write your code here

        if (n <= 1) {                                                           //Determine if n larger than 1
            return false;}
        else{
            for (int i = 2; i <= (int)Math.sqrt(n); i++){                       //Determine if n is divided exactly by numbers between 2 and sqrt(n)
                if(n%i == 0){
                    return false;
                }
            }
            return true;
        }
    }

    /**
     * Given a non-negative integer n, repeatedly add all its digits until the
     * result has only one digit. For example: Given n = 38, the process is
     * like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
     */
    public int addDigits(int n) {                                    //miss your corner case: if n is 1, your output is 0, but expected output is 1
        //write your code here

        int m = (int)Math.ceil(Math.log10(n));                         //Get the amount of digits of input
        int s = 0;

        if (m == 1 && n != 10){                                        //As for one digit number
            return n;
        }
        else if(n == 10){                                              //As for 10
            return 1;
        }
        else{
            while (m > 1){
                for (int i = m; i > 1; i--) {
                    s = (int) n / ((int) Math.pow(10, (m - 1)));       //Get the left digit of number
                    s += n % ((int) Math.pow(10, (m - 1)));            //Add the left and the unit digit of number
                }
                if (s == 10) {
                    return 1;
                }
                m = (int) Math.ceil(Math.log10(s));
                if (m == 1) { 
                    return s;
                }
                n = s;
            }
            return s;
        }
    }

    /**
     * Write a program to check whether a given number is an ugly number. Ugly
     * numbers are positive numbers whose prime factors only include 2, 3, 5.
     * For example, 6, 8 are ugly, while 14 is not ugly since it includes
     * another prime factor 7. Note that 1 is typically treated as an ugly
     * number.
     */
    public boolean isUgly(int n) {                              //miss corner case: when n is a negative number, it is not a ugly number                                    
        //write your code here

        if (isPrime(n)){										//Determine if prime number
            if (n == 1 || n == 2 || n == 3 || n == 5){			//Special numbers
                return true;
            }
            else{
                return false;
            }
        }
        else{
            while (n > 1){										//Continue divided by 2 or 3 or 5
                if (n % 2 == 0){
                    n /= 2;
                }
                else if (n % 3 == 0){
                    n /= 3;
                }
                else if (n % 5 == 0){
                    n /= 5 ;
                }
                else{
                    return false;
                }
            }
            return true;
        }
    }

    //Extra credit

    /**
     * I have written some code below. What I want is to swap two Employee objects.
     * One is Jenny and one is John. But after running it, I got the result below:
     * Before: a=Jenny
     * Before: b=John
     * After: a=Jenny
     * After: b=John
     * There is no change after swap()! Do you know the reason why my swap failed?
     * Write your understanding of the reason and explain it.
     */
    /*
     write your understanding here.
     I think after "Employee a = new Employee", the program declare a as the reference
     variable assigned to the Employee object named Jenny. Also, b is the reference variable
     assigned to the Employee object named John. When calling the method "swap", two reference
     variables are passed as the arguments. Yet, the passed x and y are only the copies of a and b.
     Swapping x and y will not affected the assignment of a and b. Therefore, a is still assigned to
     Employee "Jenny" and b is still assigned to Employee "John".
    */
    //excellent answer! Totally correct!
    public static void main(String[] args) {
        Employee a = new Employee("Jenny", 20, Gender.FEMALE, 2000);
        Employee b = new Employee("John", 30, Gender.MALE, 2500);
        System.out.println("Before: a=" + a.getName());
        System.out.println("Before: b=" + b.getName());
        swap(a, b);
        System.out.println("After: a=" + a.getName());
        System.out.println("After: b=" + b.getName());
        
        /*
        Assignment2 as = new Assignment2();							//Test here for Assignment2
        Employee e1 = new Employee("e1", 18, Gender.MALE, 10000);
        Employee e2 = new Employee("e2", 40, Gender.FEMALE, 12000);
        Employee e3 = new Employee("e3", 60, Gender.MALE, 8000);
        
        //System.out.println(as.socialSecurityTax(e1));
        //System.out.println(as.insuranceCoverage(e1));
        //as.sortSalary(e1,e2,e3);
        //as.tripleSalary(e1);
        //System.out.println(as.isPrime(4));
        //System.out.println(as.addDigits(38));
        //System.out.println(as.isUgly(8));
        */
        
    }

    public static void swap(Employee x, Employee y) {
        Employee temp = x;
        x = y;
        y = temp;
    }
}
