package ra.controller;

import ra.Service.SongService;

import java.util.Scanner;

public class SongController {
    SongService songService = new SongService();


    public void songControllerMenu() {
        Scanner sc = new Scanner(System.in);

        boolean isLoop = true;
        do {

            System.out.println("**********************SONG-MANAGEMENT*************************\n");
            System.out.println("1. nhập  bài hát :");
            System.out.println("2. hiển thị bài hát :");
            System.out.println("3. thay dổi thông tin bài hát theo id :");
            System.out.println("4. xóa bài hát theo mã Id");
            System.out.println("5. thoát ");

            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    songService.addSong(sc);
                    break;
                case 2:
                    songService.displaySong();
                    break;
                case 3:
                    songService.updataSong(sc);
                    break;
                case 4:
                    songService.delete(sc);
                    break;
                case 5:
                    isLoop = false;
                default:
                    System.err.println("hãy nhập từ 1 đến 5 : ");
            }


        }while (isLoop);
    }
}
