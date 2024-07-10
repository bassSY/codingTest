package edu.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Example3Run {

	private static String txtUrl = System.getProperty("user.home") + "\\Desktop\\file\\"; // 파일 경로

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
        Example3 example3 = new Example3();

        String txtFile1 = "ex1.txt";
        String txtFile2 = "ex2.txt";

        String result = null;

        boolean isRun = true;

        while(isRun) {
            System.out.print("문제 번호 입력 > ");
            try {
                int selNum = sc.nextInt(); // 문제 번호
                switch (selNum) {
                    case 1:
                        result = example3.q1(txtFileReader(txtFile1));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 2:
                        result = "갯수: " + example3.q2(txtFileReader(txtFile1));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 3:
                        result = "갯수: " + example3.q3(txtFileReader(txtFile1));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 4:
                        result = "index: " + example3.q4(txtFileReader(txtFile1));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 5:
                        result = "index: " + example3.q5(txtFileReader(txtFile1));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 6:
                        result = example3.q6(txtFileReader(txtFile2));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    case 7:
                        result = example3.q7(txtFileReader(txtFile2));
                        System.out.println(result);
                        txtFileWriter(result, selNum);
                        break;
                    default:
                        isRun = false;
                }
            } catch (NullPointerException e) {
                isRun = false;
                System.out.println("빈 파일이거나 값이 없습니다.");
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                isRun = false;
                System.out.println("지정된 파일을 찾을 수 없습니다");
                e.printStackTrace();
            } catch (IOException e) {
                isRun = false;
                System.out.println("입출력 에러");
                e.printStackTrace();
            } catch (Exception e) {
                isRun = false;
                System.out.println("관리자 문의");
                e.printStackTrace();
            }
        }
	}

	// read
    public static String txtFileReader(String txtFileName) throws FileNotFoundException, IOException, Exception{
    	BufferedReader br = null;
    	StringBuilder sb = new StringBuilder();

    	try {
    		br = new BufferedReader(new FileReader(txtUrl + txtFileName)); // 바탕화면에 위치한 ex1.txt를 읽는다.

            String line;
            while((line = br.readLine()) != null) {
            	sb.append(line);
            }
    	} catch (FileNotFoundException e) {
    		throw e;
		} catch (Exception e) {
			throw e;
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch (IOException e) {
				throw e;
			}
		}
    	return sb.toString();
    }

 // write
    public static void txtFileWriter(String str, int num) throws IOException {
    	FileWriter fw = null;
    	try {
    		fw = new FileWriter(String.format("%sanswer%s.txt", txtUrl, num)); // 바탕화면에 answer~.txt를 쓴다.
    		fw.write(str);
            fw.flush(); // 모든 출력은 도착 지점으로 나가지 않고 버퍼에 먼저 쌓인다. -> flush()를 해주어야 쌓인 버퍼를 목적지로 내보내게 된다. flush를 해주지 않으면 목적지에 내용이 도착하지 않을 수 있다.
    	} catch(IOException e) {
    		throw e;
    	} finally {
    		if(fw != null) {
    			fw.close();
    		}
    	}
    }
}
