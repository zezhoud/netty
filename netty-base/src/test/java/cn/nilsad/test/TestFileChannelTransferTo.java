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
            // 效率高，底层会使用操作系统的零拷贝进行优化，文件上限2GB
            long size = from.size();
            for (long left = size; left > 0; ) {
                left -= from.transferTo((size - left), left, to);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
