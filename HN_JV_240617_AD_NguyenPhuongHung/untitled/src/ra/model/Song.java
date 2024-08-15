package ra.model;
import ra.Service.SongService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Song {
    private String songId;
    private String songName;
    private String descriptions;
    private String singer;
    private String writter;
    private Date createdDate;
    private Boolean songStatus;

    public Song() {
    }

    public Song(String songId, Date creationDate, Boolean songStatus, String writter, String singer, String descriptions, String songName) {
        this.songId = songId;
        this.createdDate = creationDate;
        this.songStatus = songStatus;
        this.writter = writter;
        this.singer = singer;
        this.descriptions = descriptions;
        this.songName = songName;
    }

    public void dataInputSong (Scanner sc, Singer[] singers , int currentSInger) {
        this.songId = inputSongId(sc);
        this.songName = inputSongName(sc);
        System.out.println("hãy nhập mô tả bài hát : ");
        this.descriptions = sc.nextLine();
        this.singer = inputSongSinger(sc, singers ,currentSInger);
        this.writter = inputSongWritter(sc);
        this.createdDate = inputCreatedDate(sc);
        this.songStatus = inputSongStatus(sc);
    }

    private Boolean inputSongStatus(Scanner sc) {
        System.out.println("nhập trạng thái của bài hát :");

        do {
            String songStatus = sc.nextLine();

            if (songStatus.trim().isEmpty()) {
                System.err.println("đừng để trạng thái trống ");
            } else  {

                if (songStatus.equalsIgnoreCase("true") || songStatus.equalsIgnoreCase("false")) {
                    return Boolean.parseBoolean(songStatus);
                } else  {
                    System.err.println("Hãy nhập trạng thái bài hát là true Or false :");
                }
            }
        }while (true);



    }

    private String inputSongSinger(Scanner sc, Singer[] singers, int currentSinger) {
        if (currentSinger == 0) {
            System.err.println("Danh sách trống.");
            return "";
        } else {
            for (int i = 0; i < currentSinger; i++) {
                System.out.printf("[singerId : %d | singerName : %s]\n", singers[i].getSingerId(), singers[i].getSingerName());
            }
            System.out.println("Hãy nhập id ca sĩ:");
            do {
                try {
                    int singerId = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < currentSinger; i++) {
                        if (singers[i].getSingerId() == singerId) {
                            return singers[i].getSingerName();
                        }
                    }
                    System.out.println("Không tìm thấy ca sĩ với id đã nhập, vui lòng nhập lại.");
                } catch (NumberFormatException e) {
                    System.err.println("ID ca sĩ phải là một số nguyên. Vui lòng thử lại.");
                }
            } while (true);
        }
    }



    private String inputSongId(Scanner sc) {

        System.out.println("Nhập Id bài hát bắt đầu bằng S và Id có 4 kí tự :");

        do {
            String songId = sc.nextLine();
            boolean check= true;
            for (int i = 0; i < SongService.currentSong; i++) {
                if (SongService.songs[i].getSongId().equals(songId)) {
                    check = false;
                    break;
                }
            }

            if (check) {
                if (songId.trim().isEmpty()) {
                    System.err.println("Nhập Id bài hát bắt đầu bằng S và Id có 4 kí tự :");
                }else {
                    if ( songId.charAt(0) == 'S' && songId.length() == 4) {
                        return songId;
                    } else {
                        System.err.println("Nhập Id bài hát bắt đầu bằng S và Id có 4 kí tự :");
                    }
                }
            }else {
                System.out.println("Id đã tồn tại");
            }





        } while (true);
    }


    private String inputSongName(Scanner sc) {

        System.out.println("nhập tên bài hát");


        do {
            String songName = sc.nextLine();

            if (songName.trim().isEmpty()) {
                System.err.println("đừng để tên bài hát trống ");
            } else {
                return songName;
            }

        }while (true);




    }

    private String inputSongWritter(Scanner sc) {

        System.out.println("Nhập tác giả :");

        do {
            String writter = sc.nextLine();
            if (writter.trim().isEmpty()) {
                System.err.println("đừng để tên tác giả trống :");
            }else {
                return writter;
            }

        }while (true);

    }
    private Date inputCreatedDate(Scanner sc) {

        System.out.println("Nhập ngày phát hành bài hát :");

        SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");

        do {

            String date = sc.nextLine();

            try {
                return sdf.parse(date);
            }catch (ParseException e) {

                System.err.println("nhập định dạng ngày không đúng :");

            }

        }while (true);


    }

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    public Boolean getSongStatus() {
        return songStatus;
    }

    public void setSongStatus(Boolean songStatus) {
        this.songStatus = songStatus;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getWritter() {
        return writter;
    }

    public void setWritter(String writter) {
        this.writter = writter;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public void displaySong() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        System.out.printf("[ songId : %s | songName : %s |  singer : %s | songWritter : %s | createdDate : %s | songStatus : %s\n",
                this.songId,
                this.songName,
                this.singer,
                this.writter,
                sdf.format(this.createdDate),
                this.songStatus ? "Hoạt Động" : "Không hoạt động"
        );

    }


}

