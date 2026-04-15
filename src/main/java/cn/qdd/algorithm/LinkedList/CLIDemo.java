package cn.qdd.algorithm.LinkedList;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Author: qdd
 * @Description: CLIDemo
 * @DateTime: 2026/4/8 21:51
 **/
public class CLIDemo {
    public static void main(String[] args) {
        try {
            // Windows 示例：dir 命令
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "tencent-news-cli hot");
            // Linux/Mac 示例：ls 命令
            // ProcessBuilder pb = new ProcessBuilder("ls", "-l");

            pb.redirectErrorStream(true); // 合并错误流和标准输出
            Process process = pb.start();

            // 读取命令输出
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(process.getInputStream())
            );
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // 等待命令执行完成
            int exitCode = process.waitFor();
            System.out.println("Exit code: " + exitCode);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}