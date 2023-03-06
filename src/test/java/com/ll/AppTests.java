package com.ll;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTests {

    @Test
    @DisplayName("스캐너에 키보드입력이 아닌 문자열을 입력으로 설정")
    public void t1(){
        Scanner sc= TestUtil.genScanner("안녕");

        String cmd = sc.nextLine().trim();
        Assertions.assertThat(cmd).isEqualTo("안녕");
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

        Assertions.assertThat(rs).isEqualTo("안녕");

    }

    //앱 테스트 시작



}
