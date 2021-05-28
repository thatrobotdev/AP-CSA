package apcs.student;

public class StudentRunner {
    public static void main(String[] args) {
        System.out.println("Building Student 1");
        Student s1 = new Student (123456);
        System.out.println (s1);
        s1.setName("Sergio Aguilar");
        System.out.println (s1);
        System.out.println ("Average score: " + s1.getAverage());
        System.out.println ("Maximum score: " + s1.getMaximum());
        s1.setScore(1, 95.0);
        System.out.println (s1);
        System.out.println ("Average score: " + s1.getAverage());
        System.out.println ("Maximum score: " + s1.getMaximum());
        s1.setScore(2, 99.0);
        System.out.println("Final data for " + s1.getName() + ":");
        System.out.println ("id: " + s1.getId());
        System.out.println ("Test 1: " + s1.getScore(1));
        System.out.println ("Test 2: " + s1.getScore(2));
        System.out.println ("Average score: " + s1.getAverage());
        System.out.println ("Maximum score: " + s1.getMaximum());

        System.out.println ();

        System.out.println("Building Student 2");
        Student s2 = new Student (987654);
        System.out.println (s2);
        s2.setName("Sarah Bates");
        System.out.println (s2);
        s2.setScore(2, 95.0);
        System.out.println (s2);
        System.out.println ("Average score: " + s2.getAverage());
        System.out.println ("Maximum score: " + s2.getMaximum());
        s2.setScore(1, 99.0);
        System.out.println (s2);
        System.out.println ("Average score: " + s2.getAverage());
        System.out.println ("Maximum score: " + s2.getMaximum());

        System.out.println ();

        System.out.println("Building Student 3 (with same id as Student 1)");
        Student s3 = new Student ("Herman Johnson", 123456, 98, 96);
        System.out.println (s3);
        System.out.println ("Average score: " + s3.getAverage());
        System.out.println ("Maximum score: " + s3.getMaximum());

        System.out.println ();

        if (s1.equals(s2)) {
            System.out.println(s1.getName() + " is actually the same student as " + s2.getName());
        }
        else{
            System.out.println(s1.getName() + " is a different student as " + s2.getName());
        }

        if (s1.equals(s3)) {
            System.out.println(s1.getName() + " is actually the same student as " + s3.getName());
        }
        else{
            System.out.println(s1.getName() + " is a different student as " + s3.getName());
        }

    }
}