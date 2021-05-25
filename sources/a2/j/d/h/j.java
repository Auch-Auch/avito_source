package a2.j.d.h;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Arrays;
@GwtIncompatible
public final class j extends InputStream {
    public final Reader a;
    public final CharsetEncoder b;
    public final byte[] c = new byte[1];
    public CharBuffer d;
    public ByteBuffer e;
    public boolean f;
    public boolean g;
    public boolean h;

    public j(Reader reader, Charset charset, int i) {
        CharsetEncoder onUnmappableCharacter = charset.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        boolean z = true;
        this.a = (Reader) Preconditions.checkNotNull(reader);
        this.b = (CharsetEncoder) Preconditions.checkNotNull(onUnmappableCharacter);
        Preconditions.checkArgument(i <= 0 ? false : z, "bufferSize must be positive: %s", i);
        onUnmappableCharacter.reset();
        CharBuffer allocate = CharBuffer.allocate(i);
        this.d = allocate;
        allocate.flip();
        this.e = ByteBuffer.allocate(i);
    }

    public final void a(boolean z) {
        this.e.flip();
        if (!z || this.e.remaining() != 0) {
            this.g = true;
        } else {
            this.e = ByteBuffer.allocate(this.e.capacity() * 2);
        }
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.c) == 1) {
            return UnsignedBytes.toInt(this.c[0]);
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        CoderResult coderResult;
        Preconditions.checkPositionIndexes(i, i + i2, bArr.length);
        if (i2 == 0) {
            return 0;
        }
        boolean z = this.f;
        int i3 = 0;
        while (true) {
            if (this.g) {
                int min = Math.min(i2 - i3, this.e.remaining());
                this.e.get(bArr, i + i3, min);
                i3 += min;
                if (i3 == i2 || this.h) {
                    break;
                }
                this.g = false;
                this.e.clear();
            }
            while (true) {
                if (this.h) {
                    coderResult = CoderResult.UNDERFLOW;
                } else if (z) {
                    coderResult = this.b.flush(this.e);
                } else {
                    coderResult = this.b.encode(this.d, this.e, this.f);
                }
                if (coderResult.isOverflow()) {
                    a(true);
                    break;
                } else if (coderResult.isUnderflow()) {
                    if (z) {
                        this.h = true;
                        a(false);
                        break;
                    } else if (this.f) {
                        z = true;
                    } else {
                        CharBuffer charBuffer = this.d;
                        if (charBuffer.capacity() - charBuffer.limit() == 0) {
                            if (this.d.position() > 0) {
                                this.d.compact().flip();
                            } else {
                                CharBuffer charBuffer2 = this.d;
                                CharBuffer wrap = CharBuffer.wrap(Arrays.copyOf(charBuffer2.array(), charBuffer2.capacity() * 2));
                                wrap.position(charBuffer2.position());
                                wrap.limit(charBuffer2.limit());
                                this.d = wrap;
                            }
                        }
                        int limit = this.d.limit();
                        Reader reader = this.a;
                        char[] array = this.d.array();
                        CharBuffer charBuffer3 = this.d;
                        int read = reader.read(array, limit, charBuffer3.capacity() - charBuffer3.limit());
                        if (read == -1) {
                            this.f = true;
                        } else {
                            this.d.limit(limit + read);
                        }
                    }
                } else if (coderResult.isError()) {
                    coderResult.throwException();
                    return 0;
                }
            }
        }
        if (i3 > 0) {
            return i3;
        }
        return -1;
    }
}
