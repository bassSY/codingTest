package edu.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {

	public String findWord = "it"; // 찾는 단어

    /**
     * 1
     * 영문파일을 읽어서 공백이 있는 임의의 문자열을 받아 공백을 기준으로 한 단어씩 거꾸로 쓰시오.(java.util.List 사용)
     */
    public String q1(String str) {
        List<String> strList = Arrays.asList(str.split("\\s")); // 공백 기준 String[] -> List<String>
        Collections.reverse(strList); // list reverse 뒤집기

        // stream 객체 -> map: 요소들을 특정 조건에 해당하는 값으로 변환 -> collect: 필터링한 요소 수집 - 지정된 구분 기호로 구분된 입력 요소를 연결
        String result = strList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining(" ")); // List<String> -> String

        return result;
    }

    /**
     * 2
     * 영문파일을 읽어서 공백이 있는 임의의 문자열 안에 "it"이 몇번 들가는지 갯수를 반환하시오. (단, "its"는 "it"로 간주, java.util.List 사용)
     */
    public int q2(String str) {
        int wordCnt = 0; // 단어 갯수

        List<String> strList = Arrays.asList(str.split("\\s")); // 공백 기준으로 String[] -> List<String>

        for (String s : strList) {
            if (s.contains(findWord)) { // "it"이 '포함'되어 있다면
                wordCnt++;
            }
        }
        return wordCnt;
    }

    /**
     * 3
     * 영문파일을 읽어서 공백이 있는 임의의 문자열 안에 "it"이 몇번 들가는지 갯수를 반환하시오. (정확히 "it"로만 갯수를 반환, java.util.List 사용)
     */
    public int q3(String str) {
        int wordCnt = 0; // 단어 갯수

        List<String> strList = Arrays.asList(str.split("\\s")); // 공백 기준 String[] -> List<String>

        Iterator<String> iter = strList.iterator(); // Iterator: 저장된 요소들을 순회
        while (iter.hasNext()) { // 다음 값이 들어있다면
            if (findWord.equals(iter.next())) { // 해당 문자열이 "it"과 동일하다면
                wordCnt++;
            }
        }

        return wordCnt;
    }

    /**
     * 4
     * 영문파일을 읽어서 공백이 있는 임의의 문자열 안에 "it"의 첫번째 위치를 반환하시오. (정확히 "it"와 일치하는 위치 반환, java.util.List 사용)
     */
    public int q4(String str) {
        int tokenStartIndex = 0; // 각 단어 시작 인덱스
        int result = -1;

        List<String> strList = Arrays.asList(str.split("\\s")); // 공백 기준 String[] -> List<String>

        for (String s : strList) {
            if (findWord.equals(s)) { // 해당 문자열이 "it"과 동일하다면
                result = tokenStartIndex + s.indexOf(findWord); // 각 단어 시작 인덱스 + 해당 단어의 "it"이 위치한 인덱스
                break;
            }
            tokenStartIndex += s.length() + 1; // 각 단어의 길이 + 1(공백) -> 각 단어 시작 인덱스 값을 추가하면서 "it"이 있는 인덱스 번호를 찾기 위함
        }

        return result; // "it" 단어가 없을 때
    }

    /**
     * 5
     * 영문파일을 읽어서 공백이 있는 임의의 문자열 안에 두번째 "it"의 위치를 반환하시오. (단, "its"는 "it"로 간주, java.util.List 사용)
     */
    public int q5(String str) {
        int wordCnt = 0; // 단어 갯수
        int tokenStartIndex = 0; // 각 단어 시작 인덱스
        int result = -1;

        List<String> strList = Arrays.asList(str.split("\\s")); // 공백 기준 String[] -> List<String>

        for (String s : strList) {
            if (s.contains(findWord)) { // "it"이 '포함'되어 있다면
                wordCnt++;
                if (wordCnt > 1) {// 두번째 "it"가 '포함'되어 있을 때
                    result = tokenStartIndex;
                    break;
                }

            }
            tokenStartIndex += s.length() + 1; // 각 단어의 길이 + 1(공백) -> 각 단어 시작 인덱스 값을 추가하면서 "it"이 있는 인덱스 번호를 찾기 위함
        }

        return result; // "it" 단어가 없을 때
    }

    /**
     * 6
     * 국영 혼용 파일을 거꾸로 출력하시오. (read 후 byte 배열로 할당 → 역순의 byte 배열 처리 → 파일로 출력)
     */
    public String q6(String str) {
        byte[] strToByte = str.getBytes(); // 입력한 문자열을 바이트 배열로 변환
        byte[] reverse = new byte[str.getBytes().length]; // 역바이트 배열 생성
        String[] strArr = str.split(""); // 한 글자씩 나누기
        int totLen = strToByte.length; // 바이트 배열의 길이

        int[] byteLen = new int[strArr.length]; // 글자마다 바이트 배열의 길이를 담는 배열
        for (int i = 0; i < str.length(); i++) {
            byteLen[i] = strArr[i].getBytes().length; // 글자마다 바이트 길이를 담는다.
        }

        int byteStartIndex = totLen; // 바이트 시작 인덱스, 글자마다 바이트 길이 체크하는 역할
        for (int i = 0; i < byteLen.length; i++) {
            byteStartIndex -= byteLen[i]; // 바이트 길이마다 바이트 시작 인덱스 감소
            int reverseIndex = totLen - byteStartIndex - byteLen[i]; // 바이트 총 길이 - 바이트 시작 인덱스 - 해당 바이트의 길이 ->
            if (byteLen[i] > 1) { // 글자의 바이트 길이가 1byte보다 클 때
                for (int j = 0; j < byteLen[i]; j++) {
                    reverse[byteStartIndex + j] = strToByte[reverseIndex + j];
                }
            } else { // 1byte일 때
                reverse[byteStartIndex] = strToByte[reverseIndex];
            }
        }

        return new String(reverse);
    }

    /**
     * 7
     * 국영 혼용 파일을 한 단어씩 거꾸로 파일로 출력하시오. (read 후 byte 배열로 할당 → 역순의 byte 배열 처리 → 파일로 출력)
     */
    public String q7(String str) {
        String[] split = str.split("\\s"); // 공백 기준 String -> String[]
        List<byte[]> byteList = new ArrayList<>(); // 바이트 배열을 객체로 갖는 ArrayList 생성

        for (int i = 0; i < split.length; i++) {
            byteList.add(split[i].getBytes()); // 각 단어의 바이트 배열을 리스트에 추가
        }

        Collections.reverse(byteList); // list reverse 뒤집기

        // stream 객체 -> map: 요소들을 특정 조건에 해당하는 값으로 변환 -> collect: 필터링한 요소 수집 - 지정된 구분 기호로 구분된 입력 요소를 연결
        String result = byteList.stream().map(n -> new String(n)).collect(Collectors.joining(" ")); // List<String> -> String

        return result;
    }
}
