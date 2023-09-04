package cn.nilsad.test;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created by dingzezhou on 2023-09-01.
 */
@Slf4j
public class TestByteBuffer {
    public static void main(String[] args) {
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            while (true) {
                ByteBuffer buffer = ByteBuffer.allocate(10);
                int read = channel.read(buffer);
                log.info("read: {}", read);
                // 读不到数据，结束循环
                if (read == -1) {
                    break;
                }
                // 切换至读模式
                buffer.flip();
                // 是否还有未读取的数据
                while (buffer.hasRemaining()) {
                    byte b = buffer.get();
                    log.info("main... data: {}", (char) b);
                }
                // 切换至写模式
                buffer.clear();
            }
        } catch (IOException e) {
        }
    }
}
