import java.util.*;

class Student {
    String name;
    int NoOfSubject;
    int [] marks= new int[NoOfSubject];
    int totalmarks;
    double avgPercentage;
    String grade;

    Student(String name,int NoOfSubject)
    {
        this.name=name;
        this.NoOfSubject=NoOfSubject;
        this.marks=new int[NoOfSubject];
        this.totalmarks=0;
        this.avgPercentage=0;
        this.grade="";

    }
    public void inputMarks(Scanner sc)
    
    {
        for(int i=0;i<NoOfSubject;i++)
        {
            System.out.print("enter marks for the subject "+(i+1)+": ");
            int m=sc.nextInt();

            while (m<0 || m>100) {
                System.out.print("invalid input: please enter between 1 to 100 marks");
                m=sc.nextInt();
                
            }
            marks[i]=m;
        }

    }

    public void calTotal()
    {
         totalmarks=0;
        for (int i=0;i<marks.length;i++)
        {
            totalmarks+=marks[i];
        }
    }
    public void calAvg()
    {
        avgPercentage=(double)totalmarks/NoOfSubject;
    }
    public void calGrade()
    {
        if(avgPercentage>=90)
        {
            grade="A+";

        }
        else if(avgPercentage>=80 && avgPercentage<90)
        {
            grade="A";
        }
        else if(avgPercentage>=70&& avgPercentage<80)
        {
            grade="B";
        }
        else if(avgPercentage>=60 && avgPercentage<70)
        {
            grade="C";

        }
        else if(avgPercentage>=50 && avgPercentage<60)
        {
            grade="D";

        }
        else 
        {
            grade="F";
        }

    }
   public void displayResult()
   {
    System.out.print("!!! RESULT !!!");
    System.out.print("the name of the student is: "+name+"\n");
      System.out.print("the total marks  of the student is: "+totalmarks+"\n");
        System.out.printf("the avg percentage of the student is : %.2f%%\n",avgPercentage);
          System.out.print("the final grade of the student is: "+grade+"\n");
   }

}

public class GradeMain
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the name of the student: ");
        String name=sc.nextLine();

        System.out.print("enter the no of subjects: ");
        int NoOfSubject=sc.nextInt();

        Student s1=new Student(name, NoOfSubject);

        s1.inputMarks(sc);
        s1.calTotal();
        s1.calAvg();
        s1.calGrade();
        s1.displayResult();
        sc.close();
    }
}

