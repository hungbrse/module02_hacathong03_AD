package ra.Service;

import ra.model.Song;

import java.util.Scanner;

public class SongService {

    public static Song[] songs = new Song[100];
    public static int currentSong = 0;

    public void addSong(Scanner sc) {

        if (SingerService.currentSinger == 0) {
            System.err.println("vui lòng nhập ca sĩ trước : ");
        }else  {
            System.out.println("Nhập số bài hát muốn thêm : ");
            int n = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < n; i++) {
                System.out.println("thêm bài hát thứ : " + (i + 1));
                songs[currentSong] = new Song();
                songs[currentSong].dataInputSong(sc, SingerService.singers,SingerService.currentSinger);
                currentSong++;
            }
        }



    }


    public void displaySong() {
        for (int i = 0; i < currentSong; i++) {
            songs[i].displaySong();
        }
    }

    public void updataSong(Scanner sc) {

        System.out.println("Nhập id bài hát muốn sửa :");

        String  id = sc.nextLine();

        int songIndex = findIndex(id);

        if (songIndex   != -1) {
            songs[songIndex].dataInputSong(sc, SingerService.singers,SingerService.currentSinger);
        }else  {
            System.err.println("không tồn tại id " + id);
        }

    }


    public void delete(Scanner sc) {
        System.out.println("nhập id bài hát muốn xóa ");
        String  id = sc.nextLine();
        int songIndex = findIndex(id);
        if (songIndex != -1) {
            for (int i = songIndex ; i < currentSong ; i++) {
                songs[i] = songs[i+1];
            }
            currentSong--;
        } else {
            System.err.println("không tồn tại id " + id);
        }
    }

    private int findIndex(String id) {

        for (int i = 0 ; i < currentSong ; i++) {
            if (songs[i].getSongId().equals(id)) {
                return i;
            }
        }
        return -1;
    }
}
