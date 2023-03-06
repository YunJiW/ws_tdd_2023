package com.ll;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.*;

public class AppTests {

    //유틸테스트 시작
    @Test
    @DisplayName("스캐너에 키보드입력이 아닌 문자열을 입력으로 설정")
    public void t1(){
        Scanner sc= TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        assertThat(cmd).isEqualTo("안녕");
    }
    @Test
    @DisplayName("출력을 모니터에 하지 않고 문자열로 얻기")
    public void t2(){
        //출력을 금지함
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();
        System.out.print("안녕");
        //그동안 출력되지 않던 내용들을 문자열로 반환
        String rs = output.toString();
        //화면 출력을 다시 한다.
        TestUtil.clearSetOutToByteArray(output);

        assertThat(rs).isEqualTo("안녕");

    }
    //유틸 테스트 끝
    //앱 테스트 시작
    @Test
    @DisplayName("프로그램 시작시 타이틀 출력 그리고 종료")
    public void t3(){
        String rs = AppTestRunner.run("");

        assertThat(rs)
                .contains("== 명언 앱 ==")
                .contains("명령)")
                .doesNotContain("올바르지 않은 명령어입니다.")
                .contains("프로그램이 종료되었습니다.");
    }
    @Test
    @DisplayName("잘못된 명령어 입력에 대한 처리")
    public void t4(){
        String rs = AppTestRunner.run("종료2");

        assertThat(rs)
                .contains("올바르지 않은 명령어입니다.");
    }
    @Test
    @DisplayName("등록화면에서 명언과 작가를 입력받고, 명언을 생성한다.")
    public void t5(){
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라.
                작자미상
                """);

        assertThat(rs)
                .contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.");
    }

    @Test
    @DisplayName("명언이 등록될때마다 생성되는 명언의 번호가 1씩 증가한다.")
    public void t6(){
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                내 죽음을 적에게 알리지 마라.
                이순신
                """);

        assertThat(rs)
                .contains("명언 :")
                .contains("작가 :")
                .contains("1번 명언이 등록되었습니다.")
                .contains("2번 명언이 등록되었습니다.")
                .doesNotContain("3번 명언이 등록되었습니다.");

    }

    @Test
    @DisplayName("목록을 입력시 현재 가지고있는 목록을 반환한다.")
    public void t7(){
        String rs = AppTestRunner.run("""
                등록
                현재를 사랑하라.
                작자미상
                등록
                과거에 집작하지 마라.
                작자미상
                목록
                """);

        assertThat(rs)
                .contains("번호 /")
                .contains("작가 /")
                .contains(" 명언")
                .contains("2 / 작자미상 / 과거에 집작하지 마라.")
                .contains("1 / 작자미상 / 현재를 사랑하라.");

    }


}
