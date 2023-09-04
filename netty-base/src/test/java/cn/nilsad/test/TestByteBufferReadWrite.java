package cn.nilsad.test;

import java.nio.ByteBuffer;

/**
 * @author ZeZhou Ding
 * @date 2023-09-04
 */
public class TestByteBufferReadWrite {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        // 'a'
        buffer.put((byte) 0x61);
        ByteBufferUtil.debugAll(buffer);
        // 'b' 'c' 'd'
        buffer.put(new byte[]{0x62, 0x63, 0x64});
        ByteBufferUtil.debugAll(buffer);
        // 切换到读模式
        buffer.flip();
        System.out.println(buffer.get());
        ByteBufferUtil.debugAll(buffer);
        // 切换到写模式
        buffer.compact();
        ByteBufferUtil.debugAll(buffer);
        buffer.put(new byte[]{0x65, 0x66});
        ByteBufferUtil.debugAll(buffer);
    }
}
