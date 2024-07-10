package edu.example;

import java.util.StringTokenizer;

public class Example2 {

	public String findWord = "it"; // 찾고자하는 단어

    /**
     * 1
     * 공백이 있는 임의의 문자열을 받아 공백을 기준으로 한 단어씩 거꾸로 쓰시오.
     * (String[] 사용)
     */
    public String q1(String str) {
        String[] split = str.split(" "); // 공백을 기준으로 split -> String[]
        String[] tmp = new String[split.length];
//        for (int i = (split.length / 2); i >= 0; i--) { // 배열의 길이가 5라면 [0]-[4], [1]-[3] 서로 위치 변경
//            tmp = split[i];
//            split[i] = split[split.length - i - 1];
//            split[split.length - i - 1] = tmp;
//        }
        for (int i = split.length - 1; i >= 0; i--) {
        	tmp[split.length - i -1] = split[i];
        }
        return String.join(" ", tmp); // 공백을 기준으로 String[] 연결
    }

    /**
     * 2
     * 공백이 있는 임의의 문자열 안에 "it"이 몇번 들가는지 갯수를 반환하시오.
     * 단 "its"는 "it"로 간주.
     * (String[] 사용)
     */
    public int q2(String str) {
        String[] split = str.split("\\s"); // 공백을 기준으로 split -> String[]
        int wordCnt = 0; // 단어의 갯수
        for (String s : split) {
            if (s.contains(findWord)) { // 찾는 단어가 포함되어 있을 때
                wordCnt++;
            }
        }
        return wordCnt;
    }

    /**
     * 3
     * 공백이 있는 임의의 문자열 안에 "it"이 몇번 들가는지 갯수를 반환하시오.
     * 정확히 "it"로만 갯수를 반환.
     * (String[] 사용)
     */
    public int q3(String str) {
        int wordCnt = 0; // 단어의 갯수
        String[] split = str.split("\\s"); // 공백을 기준으로 split -> String[]
        for (String s : split) {
//        	s = null;
//            if (s.equals(findWord)) {
        	if (findWord.equals(s)) {
                wordCnt++;
            }
        }
        return wordCnt;
    }

    /**
     * 4
     * 공백이 있는 임의의 문자열 안에 "it"의 첫번째 위치를 반환하시오.
     * (it 포함하는 문자열 중복 - its, little, herit등)
     * (StringTokenizer 사용)
     */
    public int q4(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int tokenStartIndex = 0; // 토큰의 시작 인덱스
        while (st.hasMoreTokens()) { // 토큰 값이 존재하면
//            System.out.println("tokenStartIndex = " + tokenStartIndex);
            String token = st.nextToken();
            if (token.contains(findWord)) { // 토큰과 찾는 단어가 같을 때
                return tokenStartIndex + token.indexOf(findWord); // 토큰의 시작 인덱스 + 토큰 안에서 단어의 인덱스
            }
            tokenStartIndex += token.length() + 1; // 토큰마다 시작 인덱스 측정하기 위한
        }
        return -1; // 찾고자 하는 단어 없는 경우
    }

    /**
     * 5
     * 공백이 있는 임의의 문자열 안에 첫번째 "it"의 위치를 반환하시오.
     * 정확히 "it"와 일치하는 위치 반환.
     * (StringTokenizer 사용)
     */
    public int q5(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int tokenStartIndex = 0; // 토큰의 시작 인덱스
        while (st.hasMoreTokens()) { // 토큰 값이 존재하면
            String token = st.nextToken();
            if (findWord.equals(token)) { // 토큰과 찾는 단어가 같을 때
                return tokenStartIndex; // 토큰의 시작 인덱스
            }
            tokenStartIndex += token.length() + 1; // 토큰마다 시작 인덱스 측정하기 위한
        }
        return -1; // 찾고자 하는 단어 없는 경우
    }

    /**
     * 6
     * 공백이 있는 임의의 문자열 안에 두번째 "it"의 위치를 반환하시오.
     * 단 "its"는 "it"로 간주.
     * (StringTokenizer 사용)
     */
    public int q6(String str) {
        StringTokenizer st = new StringTokenizer(str);
        int fromIndex = 0; // 몇번째 단어
        int tokenStartIndex = 0; // 토큰의 시작 인덱스
        while (st.hasMoreTokens()) { // 토큰 값이 존재하면
            String token = st.nextToken();
            if (token.contains(findWord)) { // 토큰에 단어가 포함이 되어있는지
            	fromIndex++;
            	if (fromIndex > 1)
            		return tokenStartIndex + token.indexOf(findWord);
//                if (!(fromIndex == 2)) { // 두번째 단어가 아니면
//                    fromIndex++;
//                } else {
//                    return tokenStartIndex + token.indexOf(findWord); // 토큰의 시작 인덱스 + 토큰 안에서 단어의 인덱스
//                }
            }
            tokenStartIndex += token.length() + 1; // 토큰마다 시작 인덱스 측정하기 위한
        }
        return -1; // 찾고자 하는 단어 없는 경우
    }

    /**
     * 7
     * 임의의 한글 문자열을 거꾸로 출력하시오.
     * (byte배열을 사용하여 출력)
     */
    public void q7(String str) {
    	byte[] strToByte = str.getBytes(); // 입력한 문자열을 바이트 배열로 변환
    	int totLen = strToByte.length; // 바이트 배열의 길이

        String[] strArr = str.split(""); // 한 글자씩 나누기
        int[] byteLen = new int[strArr.length]; // 글자마다 바이트 배열의 길이를 담는 배열
        for (int i = 0; i < str.length(); i++) {
            byteLen[i] = strArr[i].getBytes().length; // 글자마다 바이트 길이를 담는다.
        }

        byte[] reverse = new byte[str.getBytes().length]; // 역바이트 배열 생성
        int byteStartIndex = totLen; // 바이트 시작 인덱스, 글자마다 바이트 길이 체크하는 역할
        for (int i = 0; i < byteLen.length; i++) {
            byteStartIndex -= byteLen[i]; // 바이트 길이마다 바이트 시작 인덱스 감소
            int reverseIndex = totLen - byteStartIndex - byteLen[i];
            if (byteLen[i] > 1) { // 글자의 바이트 길이가 1byte보다 클 때
                for (int j = 0; j < byteLen[i]; j++) {
                    reverse[byteStartIndex + j] = strToByte[reverseIndex + j];
                }
            } else { // 1byte일 때
                reverse[byteStartIndex] = strToByte[reverseIndex];
            }
        }
        System.out.println(new String(reverse));
    }
}
