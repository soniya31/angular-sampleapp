package testing;



        import java.io.IOException;
        import java.util.HashMap;
        import java.util.HashSet;

public class SerializationTest {

    public static void main(String[] args) {
        String fileName="employee.ser";
        Employee emp = new Employee();
        emp.setId(100);
        emp.setName("Pankaj");
        emp.setSalary(5000);

        //serialize to file
       /* try {
            SerializationUtil.serialize(emp, fileName);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }*/

        Employee empNew = null;
        try {
            empNew = (Employee) SerializationUtil.deserialize(fileName);
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
//        System.out.println("emp Object::"+emp);
        System.out.println("empNew Object::"+empNew);
        HashSet<Character> hs =new HashSet<>();
        char ch ='a';
        hs.add(ch);
        hs.contains(ch);

        HashMap<Integer,Character> hm =new HashMap();


    }
}
