package cn.nilsad.test;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @author ZeZhou Ding
 * @date 2023-09-04
 */
public class TestByteBufferString {
    public static void main(String[] args) {
        // 1. String getBytes方法转存ByteBuffer
        ByteBuffer buffer = ByteBuffer.allocate(16);
        buffer.put("hello".getBytes());
        ByteBufferUtil.debugAll(buffer);

        // 2. Charset 字符集类
        ByteBuffer charsetBuffer = StandardCharsets.UTF_8.encode("hello");
        ByteBufferUtil.debugAll(charsetBuffer);

        // 3. wrap
        ByteBuffer wrapBuffer = ByteBuffer.wrap("hello".getBytes());
        ByteBufferUtil.debugAll(wrapBuffer);

        // ByteBuffer转String
        buffer.flip();
        String str = StandardCharsets.UTF_8.decode(buffer).toString();
        System.out.println(str);
    }
}
