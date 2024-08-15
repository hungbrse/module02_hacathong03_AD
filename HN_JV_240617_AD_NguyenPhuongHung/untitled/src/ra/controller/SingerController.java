package ra.controller;

import ra.Service.SingerService;

import java.util.Scanner;

public class SingerController {

    public void SingerControllerMenu(Scanner sc) {

        boolean isLoop = true;
        SingerService singerServiceservice = new SingerService();

        do {
            System.out.println("**********************SINGER-MANAGEMENT*************************");
            System.out.println("1. 1.Nhập vào số lượng ca sĩ cần thêm và nhập thông tin cần thêm mới");
            System.out.println("2.Hiển thị danh sách tất cả ca sĩ đã lưu trữ");
            System.out.println("3.Thay đổi thông tin ca sĩ theo mã id");
            System.out.println("4.Xóa ca sĩ theo mã id");
            System.out.println("5. thoát ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    singerServiceservice.addSinger(sc);
                    break;
                case  2 :
                    singerServiceservice.showSinger();
                    break;
                    case  3 :
                        singerServiceservice.updataSinger(sc);
                        break;
                case 4 :
                    singerServiceservice.deleteSinger(sc);
                    break;
                    case 5 :
                        isLoop = false;
                        break;
                default:
                    System.err.println(" hãy nhập từ 1 đến 5 ");
            }
        }while (isLoop);
    }
}
