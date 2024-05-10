public class Main {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person(1, "Dung", "dung@gmail.com", "Ha Noi", "1");
        persons[1] = new Person(2, "Huy", "huy@gmail.com", "Da Nang", "2");
        persons[2] = new Person(3, "bao", "bao@gmail.com", "Hue", "2");
        persons[3] = new Person(4, "cuong", "cuong@gmail.com", "Quang Tri", "3");
        persons[4] = new Person(5, "long", "long@gmail.com", "Hoi An", "4");

        for (Person person : persons) {
            if (person != null) {
                if (person.getRole() == "2"){
                    System.out.println(person.getInfo());
                }
            }
        }
    }
}
