/*
랜덤한 팀 만들기
 */
package kr.hs.emirim.randomteam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String answer;
        int lastNumber;
        int teamCount;

        //input Last Number
        System.out.println("input Last Number");
        answer = scanner.nextLine();
        lastNumber = Integer.parseInt(answer);

        //input Team count
        System.out.println("input Team count");
        answer = scanner.nextLine();
        teamCount = Integer.parseInt(answer);

        ArrayList<Integer> numbers = new ArrayList<>(lastNumber);
        for (int i = 1; i <= lastNumber; i++) {
            numbers.add(i);
        }

        //exclude Member
        System.out.println("exclude Member(separator : \",\")");
        String[] excludeNumberStrings;
        answer = scanner.nextLine();
        if (!answer.equals("")) {
            excludeNumberStrings = answer.split(",");
            for (String excludeNumberString : excludeNumberStrings) {
                numbers.remove(new Integer(excludeNumberString));
            }
        }

        //random Team
        System.out.println("random...");
        Collections.shuffle(numbers);

        //print Team
        System.out.println();
        int size = numbers.size();
        int startIndex = 0;
        int rest = size % teamCount;
        int currentMemberCount;
        for (int i = 0; i < teamCount; i++) {
            System.out.print("team" + i + " :\t");
            //나머지가 있을 때
            if (rest > 0) {
                currentMemberCount = (size / teamCount) + 1;
                rest--;
            } else {
                currentMemberCount = (size / teamCount);
            }
            int endIndex = currentMemberCount;
            System.out.print(arrayToString(numbers, startIndex, startIndex + endIndex));
            System.out.println();
            startIndex += endIndex;
        }
    }

    static String arrayToString(ArrayList<Integer> arrayList, int startIndex, int endIndex) {
        StringBuffer sb = new StringBuffer();
        for (int i = startIndex; i < endIndex; i++) {
            sb.append(arrayList.get(i));
            sb.append(" ");
        }

        return sb.toString();
    }
}
