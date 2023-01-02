//Создать информационную систему позволяющую работать с сотрудниками некой компании \ студентами вуза \ учениками школы
//(прямая отсылка к первому семинару “введение в базы данных”)

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {
        Infrastructure infrastructure = new Infrastructure();

        System.out.println(infrastructure.getAllInfo(1));
        System.out.println(infrastructure.getAllInfo(2));
        System.out.println(infrastructure.getAllInfo(3));
        System.out.println(infrastructure.getAllInfo(33));
        infrastructure.showBirthYear("2008");
        infrastructure.showAddress(7);
        infrastructure.showStatus(2);
        infrastructure.showClass(3);
    }
}

class Infrastructure {
    public Infrastructure() {
        init();
    }

    Db db;

    public String getAllInfo(int idStudent) {
        for(int i = 0; i<db.students.size(); i++) {
            if(db.students.get(i).id == idStudent) {
                Student s = db.students.get(i);

                return String.format("%d %s %s %s %s %s %s",
                        s.id,
                        s.name,
                        s.birthYear,
                        db.addresses.get(s.address - 1).streetName,
                        db.statuses.get(s.status - 1).status,
                        db.classes.get(s.classIndex - 1).classIndex,
                        db.phones.get(s.phone - 1).phone);
            }
        }
        return "Информация отсутствует.";
    }

    public void showBirthYear(String year) {
        System.out.println("Ученики запрашиваемого года рождения:");
        for(int i = 0; i<db.students.size(); i++){
            if(db.students.get(i).birthYear.contains(year)){
                System.out.println(getAllInfo(db.students.get(i).id));;
            }
        }
    }

    public void showAddress(int addressId) {
        System.out.println("Ученики проживающие по запрашиваемой улице:");
        for(int i = 0; i<db.students.size(); i++){
            if(db.students.get(i).address == addressId){
                System.out.println(getAllInfo(db.students.get(i).id));;
            }
        }
    }

    public void showStatus(int statusId) {
        System.out.println("Ученики запрашиваемой успеваемости:");
        for(int i = 0; i<db.students.size(); i++){
            if(db.students.get(i).status == statusId){
                System.out.println(getAllInfo(db.students.get(i).id));;
            }
        }
    }

    public void showClass(int classId) {
        System.out.println("Ученики запрашиваемого класса:");
        for(int i = 0; i<db.students.size(); i++){
            if(db.students.get(i).classIndex == classId){
                System.out.println(getAllInfo(db.students.get(i).id));;
            }
        }
    }

    Db init() {
        db = new Db();

        db.students.add(new Student(1, "Буханова Жанна", "2010", 1, 1, 1, 1));
        db.students.add(new Student(2, "Волков Никита", "2006", 2, 2, 4, 2));
        db.students.add(new Student(3, "Голева Алина", "2009", 3, 3, 2, 3));
        db.students.add(new Student(4, "Емельянов Арсений", "2008", 4, 1, 3, 4));
        db.students.add(new Student(5, "Казакова Надежда", "2010", 5, 2, 1, 5));
        db.students.add(new Student(6, "Морозова Ольга", "2006", 6, 3, 4, 6));
        db.students.add(new Student(7, "Неклюдова Мария", "2009", 7, 1, 2, 7));
        db.students.add(new Student(8, "Поляков Данил", "2008", 8, 2, 3, 8));
        db.students.add(new Student(9, "Сковородская Карина", "2008", 9, 3, 3, 9));
        db.students.add(new Student(10, "Тараканов Артём", "2006", 10, 1, 4, 10));

        db.addresses.add(new Address(1, "Энергетиков"));
        db.addresses.add(new Address(2, "Ленина"));
        db.addresses.add(new Address(3, "Воровского"));
        db.addresses.add(new Address(4, "Степана Разина"));
        db.addresses.add(new Address(5, "Победы"));
        db.addresses.add(new Address(6, "Аношкина"));
        db.addresses.add(new Address(7, "Чичерина"));
        db.addresses.add(new Address(8, "Молодогвардейцев"));
        db.addresses.add(new Address(9, "Шота Руставели"));
        db.addresses.add(new Address(10, "Гагарина"));
        db.addresses.add(new Address(11, "Дзержинского"));
        db.addresses.add(new Address(12, "Бажова"));
        db.addresses.add(new Address(13, "Кулибина"));
        db.addresses.add(new Address(14, "Сергея Герасимова"));
        db.addresses.add(new Address(15, "Жукова"));

        db.statuses.add(new Status(1, "Отличник"));
        db.statuses.add(new Status(2, "Ударник"));
        db.statuses.add(new Status(3, "Троечник"));
        db.statuses.add(new Status(4, "Двоечник"));

        db.classes.add(new ClassIndex(1, "5А"));
        db.classes.add(new ClassIndex(2, "6А"));
        db.classes.add(new ClassIndex(3, "7Б"));
        db.classes.add(new ClassIndex(4, "9А"));

        db.phones.add(new Phone(1, "89270569009"));
        db.phones.add(new Phone(2, "89271189845"));
        db.phones.add(new Phone(3, "89379797230"));
        db.phones.add(new Phone(4, "89093313065"));
        db.phones.add(new Phone(5, "88005553535"));
        db.phones.add(new Phone(6, "89276222498"));
        db.phones.add(new Phone(7, "89119012450"));
        db.phones.add(new Phone(8, "89678087775"));
        db.phones.add(new Phone(9, "89878209939"));
        db.phones.add(new Phone(10, "89272291788"));

        return db;
    }
}

class Db {
    ArrayList<Student> students = new ArrayList<>();
    ArrayList<Address> addresses = new ArrayList<>();
    ArrayList<Status> statuses = new ArrayList<>();
    ArrayList<ClassIndex> classes = new ArrayList<>();
    ArrayList<Phone> phones = new ArrayList<>();
}

class Student {
    int id;
    int address;
    String name;
    String birthYear;
    int status;
    int classIndex;
    int phone;

    public Student(int id, String name, String birthYear, int address, int status, int classIndex, int phone) {
        this.id = id;
        this.address = address;
        this.name = name;
        this.birthYear = birthYear;
        this.status = status;
        this.classIndex = classIndex;
        this.phone = phone;
    }
}

class Address {
    int id;
    String streetName;

    public Address(int id, String streetName) {
        this.id = id;
        this.streetName = streetName;
    }
}

class Status {
    int id;
    String status;

    public Status(int id, String status) {
        this.id = id;
        this.status = status;
    }
}

class ClassIndex {
    int id;
    String classIndex;

    public ClassIndex(int id, String classIndex) {
        this.id = id;
        this.classIndex = classIndex;
    }
}

class Phone {
    int id;
    String phone;

    public Phone(int id, String phone) {
        this.id = id;
        this.phone = phone;
    }
}
