package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private Scanner sc;

    long wiseSayingId =0;

    private List<WiseSaying> WiseList;

    public App(Scanner sc){
        this.sc= sc;
        WiseList = new ArrayList<>();
    }


    public void run(){
        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String cmd = sc.nextLine().trim();

            if(cmd.isEmpty()) continue;

            switch (cmd){
                case "종료":
                    System.out.println("프로그램이 종료되었습니다.");
                    return;
                case "등록":
                    System.out.print("명언 :");
                    String content =sc.nextLine().trim();
                    System.out.print("작가 :");
                    String authorName = sc.nextLine().trim();

                    long id = ++wiseSayingId;

                    WiseList.add(new WiseSaying(id,authorName,content));
                    System.out.printf("%d번 명언이 등록되었습니다. \n",id);
                    break;
                case "목록":
                    System.out.println("번호 / 작가 /명언");
                    System.out.println("----------------------");
                    for(int idx = WiseList.size()-1;idx >=0;idx--){
                        WiseSaying wiseSaying = WiseList.get(idx);
                        System.out.printf("%d / %s / %s \n",wiseSaying.getNum(),wiseSaying.getAuthorName(),wiseSaying.getContent());
                    }
                    break;
                default:
                    System.out.printf("'%s' (은)는 올바르지 않은 명령어입니다. \n",cmd);
                    break;
            }
        }
    }
}
