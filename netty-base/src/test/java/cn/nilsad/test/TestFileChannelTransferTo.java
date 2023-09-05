package cn.nilsad.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * Created by dingzezhou on 2023-09-05.
 */
public class TestFileChannelTransferTo {
    public static void main(String[] args) {
        try (
                FileChannel from = new FileInputStream("text/data.txt").getChannel();
                FileChannel to = new FileOutputStream("text/to.txt").getChannel()
        ) {
            // 效率高，底层会使用操作系统的零拷贝进行优化
            from.transferTo(0, from.size(), to);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
