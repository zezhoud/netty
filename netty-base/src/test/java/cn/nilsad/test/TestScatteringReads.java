package cn.nilsad.test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author ZeZhou Ding
 * @date 2023-09-04
 */
public class TestScatteringReads {
    public static void main(String[] args) {
        try(FileChannel channel = new RandomAccessFile("text/words.txt", "r").getChannel()){
            ByteBuffer buffer1 = ByteBuffer.allocate(3);
            ByteBuffer buffer2 = ByteBuffer.allocate(3);
            ByteBuffer buffer3 = ByteBuffer.allocate(5);
            channel.read(new ByteBuffer[]{buffer1, buffer2, buffer3});
            buffer1.flip();
            buffer2.flip();
            buffer3.flip();
            ByteBufferUtil.debugAll(buffer1);
            ByteBufferUtil.debugAll(buffer2);
            ByteBufferUtil.debugAll(buffer3);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
