package cn.nilsad.test;

import java.nio.ByteBuffer;

/**
 * @author ZeZhou Ding
 * @date 2023-09-04
 */
public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a', 'b', 'c', 'd'});
        buffer.flip();

        // rewind从头开始读
//        buffer.get(new byte[4]);
//        ByteBufferUtil.debugAll(buffer);
//        buffer.rewind();
//        ByteBufferUtil.debugAll(buffer);
//        System.out.println(buffer.get());

        /*
         * mark() 标记position位置
         * reset() 将position重置到mark的位置
         */
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        ByteBufferUtil.debugAll(buffer);
//        buffer.mark();
//        System.out.println((char) buffer.get());
//        System.out.println((char) buffer.get());
//        ByteBufferUtil.debugAll(buffer);
//        buffer.reset();
//        ByteBufferUtil.debugAll(buffer);

        // get(i) 不会改变position的位置
//        System.out.println((char) buffer.get(1));
//        ByteBufferUtil.debugAll(buffer);
    }
}
