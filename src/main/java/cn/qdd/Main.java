package cn.qdd;

public class Main {
    public static void main(String[] args) {
        int num = 20;

        System.out.println("原始数字: " + num);
        System.out.println("个位: " + (num % 10));
        System.out.println("十位: " + ((num / 10) % 10));
        System.out.println("百位: " + ((num / 100) % 10));
        System.out.println("千位: " + ((num / 1000) % 10));
        System.out.println("万位: " + (num / 10000));

        // 或者使用循环
        System.out.println("\n从低位到高位:");
        int temp = num;
        int position = 1;
        while(temp > 0) {
            System.out.println("第" + position + "位(从低位): " + (temp % 10));
            temp /= 10;
            position++;
        }
    }
}