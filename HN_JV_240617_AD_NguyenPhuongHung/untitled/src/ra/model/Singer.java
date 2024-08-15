package ra.model;

import ra.Service.SingerService;

import java.util.Scanner;

public class Singer {
    private int singerId ;
    private String singerName ;
    private  int age;
    private String nationality;
    private boolean gender;
    private String genre;

    public Singer(int singerId, boolean gender, String nationality, int age, String singerName, String genre) {
        this.singerId = singerId;
        this.gender = gender;
        this.nationality = nationality;
        this.age = age;
        this.singerName = singerName;
        this.genre = genre;
    }

    public Singer() {
    }

    public int getSingerId() {
        return singerId;
    }

    public void setSingerId(int singerId) {
        this.singerId = singerId;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public void inputData(Scanner sc, Singer[] singers, int currentSinger) {
        this.singerId = inputSingerId(singers,currentSinger);
        this.singerName = inputSingerName(sc);
        this.age = inputAge(sc);
        this.nationality = inputNationlity(sc);
        this.gender = inputGender(sc);
        this.genre =inputGenre(sc);
    }

    private String inputGenre(Scanner sc) {
        System.out.println("nhập thể loại bài hát  : ");

        do {
            String genre = sc.nextLine();
            if (genre.trim().isEmpty()) {
                System.err.println("nhập thể loại bài hát :  ");
            } else {
                return genre;
            }
        }while (true);

    }

    private boolean inputGender(Scanner sc) {
        System.out.println("nhập giới tính của ca sĩ true or false : ");


        do {
            String gender = sc.nextLine();
            if (gender.trim().equals("true") || gender.trim().equals("false")) {
                return Boolean.parseBoolean(gender);
            } else {
                System.err.println("hãy nhập gới tính ca sĩ true or false : ");
            }
        }while (true);


    }

    private String inputNationlity(Scanner sc) {
        System.out.println("nhập quốc tịch : ");

        do {
            String nationality = sc.nextLine();
            if (nationality.trim().isEmpty()) {
                System.err.println("đừng để quốc tịch trống  ");
            } else {
                return nationality;
            }
        }while (true);

    }

    private int inputAge(Scanner sc) {
        System.out.println("hãy nhập tuổi ca sĩ : ");


        do {
            int age = Integer.parseInt(sc.nextLine());

            if (age > 0) {
                return age;
            }else {
                System.out.println(" tuổi phải lớn hơn 0 ");
            }

        }while (true);
    }

    private String inputSingerName(Scanner sc) {
        System.out.println("Nhập tên ca sĩ : ");

        do {
            String singerName = sc.nextLine();
            if (singerName.trim().isEmpty()) {
                System.err.println("đừng để tên ca sĩ trống ");
            } else {
                return singerName;
            }
        }while (true);

    }

    private int inputSingerId(Singer[] singers, int currentSinger) {
        int maxId = 0;
        for (int i = 0; i < currentSinger; i++) {
            if (singers[i].getSingerId() > maxId) {
                maxId = singers[i].getSingerId();
            }
        }
        return maxId + 1;
    }

    public void display() {

        System.out.printf("[ singerId : %s | singerName : %s | age : %d | nationality : %s | gender : %s | genre : %s ]\n", singerId, singerName, age, nationality, gender, genre);
    }
}
