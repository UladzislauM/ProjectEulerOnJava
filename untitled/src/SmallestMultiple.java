import java.util.Arrays;

public class SmallestMultiple {
//    2520 - самое маленькое число, которое делится без остатка на все числа от 1 до 10.
//    Какое самое маленькое число делится нацело на все числа от 1 до 20?
    public static void main(String[] args) {
        int[] LCM = new int[20]; //НОК
        int GCD = GCDByEuclids(3, 2); //НОД
        LCM[3] = (3 * 2) / GCD;

        //НОК для n-ного числа
        for (int i = 4; i < 21; i++) {
            if(i != LCM.length) {
                if(GCD > i + 1) {
                    GCD = GCDByEuclids(LCM[i-1], i);
                }else {
                    GCD = GCDByEuclids(i, LCM[i-1]);
                }
                LCM[i] = (LCM[i - 1] * i) / GCD;
            }
        }
        Arrays.stream(LCM).forEach(System.out::println);
    }
    public static int GCDByEuclids(int n1, int n2) {
        return n2 == 0 ? n1 : GCDByEuclids(n2, n1 % n2);
    }
}
