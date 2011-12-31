
package org.open2jam.utils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/**
 * wraps a nio.ByteBuffer in a InputStream
 *
 * @author fox
 */
public class ByteBufferInputStream extends InputStream
{
    private final ByteBuffer buf;

    public ByteBufferInputStream(ByteBuffer buf){
        this.buf = buf;
    }

    @Override
    public int read() throws IOException {

        if(!buf.hasRemaining())return -1;
        return buf.get();
    }

    @Override
    public int read(byte[] bytes, int off, int len) throws IOException {
        // Read only what's left
        if(!buf.hasRemaining())return -1;
        len = Math.min(len, buf.remaining());
        buf.get(bytes, off, len);
        return len;
    }
}