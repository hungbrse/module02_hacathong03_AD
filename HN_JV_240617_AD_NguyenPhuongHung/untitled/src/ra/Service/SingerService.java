package ra.Service;

import ra.model.Singer;

import java.util.Scanner;

public class SingerService {

    public static Singer[] singers = new Singer[100];
    public static  int currentSinger = 0;

    public void addSinger(Scanner sc ) {
        System.out.println(" nhập số lượng ca sĩ muốn thêm ");

        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.println("thêm ca sĩ thứ : " + (i + 1));
            singers[currentSinger] = new Singer();
            singers[currentSinger].inputData(sc , singers, currentSinger);
            currentSinger++;
        }
    }

    public void showSinger() {

        for (int i = 0; i <  currentSinger; i++) {
            singers[i].display();
        }

    }


    public void updataSinger(Scanner sc) {
        System.out.println("nhập id muốn sửa : ");
        int id = Integer.parseInt(sc.nextLine());

        int updataIndex = findIndexSinger(id);

        if (updataIndex != -1) {
            singers[updataIndex].inputData(sc , singers, updataIndex);
        }else {
            System.err.println("không tồn tại id " + id);
        }

    }


    public void deleteSinger(Scanner sc) {
        System.out.println("nhập id ca sĩ muốn xóa : ");
        int id = Integer.parseInt(sc.nextLine());
        int deleteIndex = findIndexSinger(id);
        if (deleteIndex != -1) {
            for (int i = deleteIndex; i <  currentSinger; i++) {
                singers[i] = singers[i+1];
            }
            currentSinger--;
        } else  {
            System.err.println("không tồn tại id " + id);
        }
    }

    private int findIndexSinger(int id) {
        for (int i = 0; i <  currentSinger; i++) {
            if (singers[i].getSingerId() == id) {
                return i;
            }
        }
        return -1;
    }
}
