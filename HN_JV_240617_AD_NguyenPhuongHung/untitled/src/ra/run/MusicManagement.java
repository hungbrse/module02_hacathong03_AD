package ra.run;

import com.sun.tools.javac.Main;
import ra.Service.SingerService;
import ra.Service.SongService;
import ra.controller.SingerController;
import ra.controller.SongController;
import ra.model.Song;

import java.util.Arrays;
import java.util.Scanner;

public class MusicManagement {
    public static void main(String[] args) {

        SingerController singerController = new SingerController();
        SongController songController = new SongController();

        MusicManagement musicManagement = new MusicManagement();

        boolean isLoop = true;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************************MUSIC-MANAGEMENT*************************");
            System.out.println("1. Quản lý ca sĩ");
            System.out.println("2. Quản lý bài hát");
            System.out.println("3. Tìm kiếm bài hát");
            System.out.println("4. thoát ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    singerController.SingerControllerMenu(sc);
                    break;
                case 2:
                    songController.songControllerMenu();
                    break;
                case 3:
                    musicManagement.searchManagement(sc);
                    break;
                case 4:
                    isLoop = false;
                    break;
                default:
                    System.err.println("hãy nhập từ 1 đến 4 : ");

            }
        } while (isLoop);
    }

    public void searchManagement(Scanner scanner) {


        boolean isLoop = true;
        do {
            System.out.println("*********************SEARCH-MANAGEMENT************************\n");
            System.out.println("1. tìm kiếm bài hát theo tên ca sĩ :");
            System.out.println("2. tìm kiếm ca sĩ theo tên :");
            System.out.println("3. hiển thị bài hát theo thứ tự tăng dần :");
            System.out.println("4 hiển thị 10 bài hát được đăng mới nhất :");
            System.out.println("5. thoát");

            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    findSongbySingerName(scanner);
                    break;
                case 2:
                    findSingerbySingerName(scanner);
                    break;

                case 3:
                    showSongbyAlphabet();
                    break;

                case 4 :
                    showNewSongs();
                    break;
                    case 5:
                        isLoop = false;
                        break;


            }
        } while (isLoop);
    }

    public void findSongbySingerName(Scanner sc) {
        System.out.println("nhập tên ca sĩ để tìm bài hát : ");
        boolean check = false;
        String id = sc.nextLine();
        for (int i = 0; i < SongService.currentSong; i++) {
            if (SongService.songs[i].getSinger().equals(id)) {
                SongService.songs[i].displaySong();
                check = true;
            }
        }
        if (!check) {
            System.err.println("không có bài hát nào của ca sĩ : " + id);
        }
    }

    public void findSingerbySingerName(Scanner sc) {
        System.out.println("nhập ký tự để tìm tên ca sĩ : ");
        boolean check = false;
        String name = sc.nextLine();

        for (int i = 0; i < SingerService.currentSinger; i++) {
            if (SingerService.singers[i].getSingerName().contains(name)) {
                SingerService.singers[i].display();
                check = true;
            }
        }

        if (!check) {
            System.err.println("danh sách tìm kiếm trống huhu : ");
        }

    }

    public void showSongbyAlphabet() {
        Song[] sortedSongs = new Song[SongService.currentSong];
        for (int i = 0; i < SongService.currentSong; i++) {
            sortedSongs[i] = SongService.songs[i];
        }

        for (int i = 0; i < sortedSongs.length - 1; i++) {
            for (int j = i + 1; j < sortedSongs.length; j++) {
                if (sortedSongs[i].getSongName().compareToIgnoreCase(sortedSongs[j].getSongName()) > 0) {

                    Song temp = sortedSongs[i];
                    sortedSongs[i] = sortedSongs[j];
                    sortedSongs[j] = temp;
                }
            }
        }


        for (int i = 0; i < sortedSongs.length; i++) {
            sortedSongs[i].displaySong();
        }

    }

    // 1 2 3 4 5 6

    public void showNewSongs() {

        if (SongService.currentSong < 10) {
            for (int i = SongService.currentSong - 1; i >= 0; i--) {
                SongService.songs[i].displaySong();
            }
        }else {
            for (int i = 9 ; i >= 0; i--) {
                SongService.songs[i].displaySong();
            }
        }

    }

}
