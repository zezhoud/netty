package cn.nilsad.test;

import java.nio.ByteBuffer;

/**
 * Created by dingzezhou on 2023-09-05.
 */
public class TestByteBufferExam {
    /**
     网络上有多条数据发送给服务端，数据之间使用 \n 进行分隔
     但由于某种原因这些数据在接收时，被进行了重新组合，例如原始数据有3条为
     Hello,world\n
     I'm zhangsan\n
     How are you?\n
     变成了下面的两个 byteBuffer (黏包，半包)
     Hello,world\nI'm zhangsan\nHo
     w are you?\n
     现在要求编写程序，将错乱的数据恢复成原始的按 \n 分隔的数据
     */
    public static void main(String[] args) {
        ByteBuffer source = ByteBuffer.allocate(32);
        source.put("Hello,world\nI'm zhangsan\nHo".getBytes());
        split(source);
        source.put("w are you?\nhaha!\n".getBytes());
        split(source);
    }

    private static void split(ByteBuffer source) {
        // 切换到读模式，读取内容
        source.flip();
        for (int i = 0; i < source.limit(); i++) {
            if (source.get(i) == '\n') {
                int len = i + 1 - source.position();
                // 把完整的消息存入新的bytebuffer中
                ByteBuffer buffer = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    buffer.put(source.get());
                }
                ByteBufferUtil.debugAll(buffer);
            }
        }
        // 切换到写模式，继续处理文本
        source.compact();
    }
}
