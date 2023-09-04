package cn.nilsad.test;

import java.nio.ByteBuffer;

/**
 * @author ZeZhou Ding
 * @date 2023-09-04
 */
public class TestBufferAllocate {
    public static void main(String[] args) {
        System.out.println(ByteBuffer.allocate(16).getClass());
        System.out.println(ByteBuffer.allocateDirect(16).getClass());
        /**
         * class java.nio.HeapByteBuffer java堆内存，读写效率较低，会受GC影响
         * class java.nio.DirectByteBuffer 系统内存，读写效率较高（少一次拷贝），不会受GC影响，分配效率较低
         */

    }
}
