package org.spongycastle.crypto.io;

import a2.b.a.a.a;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.crypto.BufferedBlockCipher;
import org.spongycastle.crypto.InvalidCipherTextException;
import org.spongycastle.crypto.SkippingCipher;
import org.spongycastle.crypto.StreamCipher;
import org.spongycastle.crypto.modes.AEADBlockCipher;
import org.spongycastle.util.Arrays;
public class CipherInputStream extends FilterInputStream {
    public SkippingCipher a;
    public byte[] b;
    public BufferedBlockCipher c;
    public StreamCipher d;
    public AEADBlockCipher e;
    public byte[] f;
    public byte[] g;
    public int h;
    public int i;
    public boolean j;
    public long k;
    public int l;

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher) {
        this(inputStream, bufferedBlockCipher, 2048);
    }

    public final void a(int i2, boolean z) {
        if (z) {
            BufferedBlockCipher bufferedBlockCipher = this.c;
            if (bufferedBlockCipher != null) {
                i2 = bufferedBlockCipher.getOutputSize(i2);
            } else {
                AEADBlockCipher aEADBlockCipher = this.e;
                if (aEADBlockCipher != null) {
                    i2 = aEADBlockCipher.getOutputSize(i2);
                }
            }
        } else {
            BufferedBlockCipher bufferedBlockCipher2 = this.c;
            if (bufferedBlockCipher2 != null) {
                i2 = bufferedBlockCipher2.getUpdateOutputSize(i2);
            } else {
                AEADBlockCipher aEADBlockCipher2 = this.e;
                if (aEADBlockCipher2 != null) {
                    i2 = aEADBlockCipher2.getUpdateOutputSize(i2);
                }
            }
        }
        byte[] bArr = this.f;
        if (bArr == null || bArr.length < i2) {
            this.f = new byte[i2];
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int available() throws IOException {
        return this.i - this.h;
    }

    public final void b() throws IOException {
        try {
            this.j = true;
            a(0, true);
            BufferedBlockCipher bufferedBlockCipher = this.c;
            if (bufferedBlockCipher != null) {
                this.i = bufferedBlockCipher.doFinal(this.f, 0);
                return;
            }
            AEADBlockCipher aEADBlockCipher = this.e;
            if (aEADBlockCipher != null) {
                this.i = aEADBlockCipher.doFinal(this.f, 0);
            } else {
                this.i = 0;
            }
        } catch (InvalidCipherTextException e2) {
            throw new InvalidCipherTextIOException("Error finalising cipher", e2);
        } catch (Exception e3) {
            throw new IOException(a.a3("Error finalising cipher ", e3));
        }
    }

    public final int c() throws IOException {
        if (this.j) {
            return -1;
        }
        this.h = 0;
        this.i = 0;
        while (true) {
            int i2 = this.i;
            if (i2 != 0) {
                return i2;
            }
            int read = ((FilterInputStream) this).in.read(this.b);
            if (read == -1) {
                b();
                int i3 = this.i;
                if (i3 == 0) {
                    return -1;
                }
                return i3;
            }
            try {
                a(read, false);
                BufferedBlockCipher bufferedBlockCipher = this.c;
                if (bufferedBlockCipher != null) {
                    this.i = bufferedBlockCipher.processBytes(this.b, 0, read, this.f, 0);
                } else {
                    AEADBlockCipher aEADBlockCipher = this.e;
                    if (aEADBlockCipher != null) {
                        this.i = aEADBlockCipher.processBytes(this.b, 0, read, this.f, 0);
                    } else {
                        this.d.processBytes(this.b, 0, read, this.f, 0);
                        this.i = read;
                    }
                }
            } catch (Exception e2) {
                throw new CipherIOException("Error processing stream ", e2);
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
    public void close() throws IOException {
        try {
            ((FilterInputStream) this).in.close();
            this.h = 0;
            this.i = 0;
            this.l = 0;
            this.k = 0;
            byte[] bArr = this.g;
            if (bArr != null) {
                Arrays.fill(bArr, (byte) 0);
                this.g = null;
            }
            byte[] bArr2 = this.f;
            if (bArr2 != null) {
                Arrays.fill(bArr2, (byte) 0);
                this.f = null;
            }
            Arrays.fill(this.b, (byte) 0);
        } finally {
            if (!this.j) {
                b();
            }
        }
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void mark(int i2) {
        ((FilterInputStream) this).in.mark(i2);
        SkippingCipher skippingCipher = this.a;
        if (skippingCipher != null) {
            this.k = skippingCipher.getPosition();
        }
        byte[] bArr = this.f;
        if (bArr != null) {
            byte[] bArr2 = new byte[bArr.length];
            this.g = bArr2;
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        }
        this.l = this.h;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        if (this.a != null) {
            return ((FilterInputStream) this).in.markSupported();
        }
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read() throws IOException {
        if (this.h >= this.i && c() < 0) {
            return -1;
        }
        byte[] bArr = this.f;
        int i2 = this.h;
        this.h = i2 + 1;
        return bArr[i2] & 255;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public void reset() throws IOException {
        if (this.a != null) {
            ((FilterInputStream) this).in.reset();
            this.a.seekTo(this.k);
            byte[] bArr = this.g;
            if (bArr != null) {
                this.f = bArr;
            }
            this.h = this.l;
            return;
        }
        throw new IOException("cipher must implement SkippingCipher to be used with reset()");
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public long skip(long j2) throws IOException {
        if (j2 <= 0) {
            return 0;
        }
        if (this.a != null) {
            long available = (long) available();
            if (j2 <= available) {
                this.h = (int) (((long) this.h) + j2);
                return j2;
            }
            this.h = this.i;
            long skip = ((FilterInputStream) this).in.skip(j2 - available);
            if (skip == this.a.skip(skip)) {
                return skip + available;
            }
            throw new IOException(a.V2("Unable to skip cipher ", skip, " bytes."));
        }
        int min = (int) Math.min(j2, (long) available());
        this.h += min;
        return (long) min;
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher) {
        this(inputStream, streamCipher, 2048);
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher) {
        this(inputStream, aEADBlockCipher, 2048);
    }

    public CipherInputStream(InputStream inputStream, BufferedBlockCipher bufferedBlockCipher, int i2) {
        super(inputStream);
        this.c = bufferedBlockCipher;
        this.b = new byte[i2];
        this.a = bufferedBlockCipher instanceof SkippingCipher ? (SkippingCipher) bufferedBlockCipher : null;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public int read(byte[] bArr, int i2, int i3) throws IOException {
        if (this.h >= this.i && c() < 0) {
            return -1;
        }
        int min = Math.min(i3, available());
        System.arraycopy(this.f, this.h, bArr, i2, min);
        this.h += min;
        return min;
    }

    public CipherInputStream(InputStream inputStream, StreamCipher streamCipher, int i2) {
        super(inputStream);
        this.d = streamCipher;
        this.b = new byte[i2];
        this.a = streamCipher instanceof SkippingCipher ? (SkippingCipher) streamCipher : null;
    }

    public CipherInputStream(InputStream inputStream, AEADBlockCipher aEADBlockCipher, int i2) {
        super(inputStream);
        this.e = aEADBlockCipher;
        this.b = new byte[i2];
        this.a = aEADBlockCipher instanceof SkippingCipher ? (SkippingCipher) aEADBlockCipher : null;
    }
}
