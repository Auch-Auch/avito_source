package com.google.firebase.crashlytics.internal.log;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
public class QueueFile implements Closeable {
    public static final Logger g = Logger.getLogger(QueueFile.class.getName());
    public final RandomAccessFile a;
    public int b;
    public int c;
    public b d;
    public b e;
    public final byte[] f = new byte[16];

    public interface ElementReader {
        void read(InputStream inputStream, int i) throws IOException;
    }

    public class a implements ElementReader {
        public boolean a = true;
        public final /* synthetic */ StringBuilder b;

        public a(QueueFile queueFile, StringBuilder sb) {
            this.b = sb;
        }

        @Override // com.google.firebase.crashlytics.internal.log.QueueFile.ElementReader
        public void read(InputStream inputStream, int i) throws IOException {
            if (this.a) {
                this.a = false;
            } else {
                this.b.append(", ");
            }
            this.b.append(i);
        }
    }

    public static class b {
        public static final b c = new b(0, 0);
        public final int a;
        public final int b;

        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(b.class.getSimpleName());
            sb.append("[position = ");
            sb.append(this.a);
            sb.append(", length = ");
            return a2.b.a.a.a.j(sb, this.b, "]");
        }
    }

    /* JADX INFO: finally extract failed */
    public QueueFile(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
            try {
                randomAccessFile.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                randomAccessFile.seek(0);
                byte[] bArr = new byte[16];
                int[] iArr = {4096, 0, 0, 0};
                int i = 0;
                for (int i2 = 0; i2 < 4; i2++) {
                    o(bArr, i, iArr[i2]);
                    i += 4;
                }
                randomAccessFile.write(bArr);
                randomAccessFile.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFile.close();
                throw th;
            }
        }
        RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "rwd");
        this.a = randomAccessFile2;
        randomAccessFile2.seek(0);
        randomAccessFile2.readFully(this.f);
        int h = h(this.f, 0);
        this.b = h;
        if (((long) h) <= randomAccessFile2.length()) {
            this.c = h(this.f, 4);
            int h2 = h(this.f, 8);
            int h3 = h(this.f, 12);
            this.d = g(h2);
            this.e = g(h3);
            return;
        }
        StringBuilder L = a2.b.a.a.a.L("File is truncated. Expected length: ");
        L.append(this.b);
        L.append(", Actual length: ");
        L.append(randomAccessFile2.length());
        throw new IOException(L.toString());
    }

    public static int a(QueueFile queueFile, int i) {
        int i2 = queueFile.b;
        return i < i2 ? i : (i + 16) - i2;
    }

    public static int h(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16) + ((bArr[i + 2] & 255) << 8) + (bArr[i + 3] & 255);
    }

    public static void o(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    public void b(byte[] bArr) throws IOException {
        int i;
        int length = bArr.length;
        synchronized (this) {
            if ((0 | length) >= 0) {
                if (length <= bArr.length - 0) {
                    d(length);
                    boolean f2 = f();
                    if (f2) {
                        i = 16;
                    } else {
                        b bVar = this.e;
                        i = m(bVar.a + 4 + bVar.b);
                    }
                    b bVar2 = new b(i, length);
                    o(this.f, 0, length);
                    k(bVar2.a, this.f, 0, 4);
                    k(bVar2.a + 4, bArr, 0, length);
                    n(this.b, this.c + 1, f2 ? bVar2.a : this.d.a, bVar2.a);
                    this.e = bVar2;
                    this.c++;
                    if (f2) {
                        this.d = bVar2;
                    }
                }
            }
            throw new IndexOutOfBoundsException();
        }
    }

    public synchronized void c() throws IOException {
        n(4096, 0, 0, 0);
        this.c = 0;
        b bVar = b.c;
        this.d = bVar;
        this.e = bVar;
        if (this.b > 4096) {
            this.a.setLength((long) 4096);
            this.a.getChannel().force(true);
        }
        this.b = 4096;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.a.close();
    }

    public final void d(int i) throws IOException {
        int i2 = i + 4;
        int l = this.b - l();
        if (l < i2) {
            int i3 = this.b;
            do {
                l += i3;
                i3 <<= 1;
            } while (l < i2);
            this.a.setLength((long) i3);
            this.a.getChannel().force(true);
            b bVar = this.e;
            int m = m(bVar.a + 4 + bVar.b);
            if (m < this.d.a) {
                FileChannel channel = this.a.getChannel();
                channel.position((long) this.b);
                long j = (long) (m - 4);
                if (channel.transferTo(16, j, channel) != j) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            int i4 = this.e.a;
            int i5 = this.d.a;
            if (i4 < i5) {
                int i6 = (this.b + i4) - 16;
                n(i3, this.c, i5, i6);
                this.e = new b(i6, this.e.b);
            } else {
                n(i3, this.c, i5, i4);
            }
            this.b = i3;
        }
    }

    public synchronized void e(ElementReader elementReader) throws IOException {
        int i = this.d.a;
        for (int i2 = 0; i2 < this.c; i2++) {
            b g2 = g(i);
            elementReader.read(new c(g2, null), g2.b);
            i = m(g2.a + 4 + g2.b);
        }
    }

    public synchronized boolean f() {
        return this.c == 0;
    }

    public final b g(int i) throws IOException {
        if (i == 0) {
            return b.c;
        }
        this.a.seek((long) i);
        return new b(i, this.a.readInt());
    }

    public synchronized void i() throws IOException {
        if (f()) {
            throw new NoSuchElementException();
        } else if (this.c == 1) {
            c();
        } else {
            b bVar = this.d;
            int m = m(bVar.a + 4 + bVar.b);
            j(m, this.f, 0, 4);
            int h = h(this.f, 0);
            n(this.b, this.c - 1, m, this.e.a);
            this.c--;
            this.d = new b(m, h);
        }
    }

    public final void j(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.b;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.a.seek((long) i);
            this.a.readFully(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.a.seek((long) i);
        this.a.readFully(bArr, i2, i5);
        this.a.seek(16);
        this.a.readFully(bArr, i2 + i5, i3 - i5);
    }

    public final void k(int i, byte[] bArr, int i2, int i3) throws IOException {
        int i4 = this.b;
        if (i >= i4) {
            i = (i + 16) - i4;
        }
        if (i + i3 <= i4) {
            this.a.seek((long) i);
            this.a.write(bArr, i2, i3);
            return;
        }
        int i5 = i4 - i;
        this.a.seek((long) i);
        this.a.write(bArr, i2, i5);
        this.a.seek(16);
        this.a.write(bArr, i2 + i5, i3 - i5);
    }

    public int l() {
        if (this.c == 0) {
            return 16;
        }
        b bVar = this.e;
        int i = bVar.a;
        int i2 = this.d.a;
        if (i >= i2) {
            return (i - i2) + 4 + bVar.b + 16;
        }
        return (((i + 4) + bVar.b) + this.b) - i2;
    }

    public final int m(int i) {
        int i2 = this.b;
        return i < i2 ? i : (i + 16) - i2;
    }

    public final void n(int i, int i2, int i3, int i4) throws IOException {
        byte[] bArr = this.f;
        int[] iArr = {i, i2, i3, i4};
        int i5 = 0;
        for (int i6 = 0; i6 < 4; i6++) {
            o(bArr, i5, iArr[i6]);
            i5 += 4;
        }
        this.a.seek(0);
        this.a.write(this.f);
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(QueueFile.class.getSimpleName());
        sb.append('[');
        sb.append("fileLength=");
        sb.append(this.b);
        sb.append(", size=");
        sb.append(this.c);
        sb.append(", first=");
        sb.append(this.d);
        sb.append(", last=");
        sb.append(this.e);
        sb.append(", element lengths=[");
        try {
            e(new a(this, sb));
        } catch (IOException e2) {
            g.log(Level.WARNING, "read error", (Throwable) e2);
        }
        sb.append("]]");
        return sb.toString();
    }

    public final class c extends InputStream {
        public int a;
        public int b;

        public c(b bVar, a aVar) {
            int i = bVar.a + 4;
            int i2 = QueueFile.this.b;
            this.a = i >= i2 ? (i + 16) - i2 : i;
            this.b = bVar.b;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IOException {
            Objects.requireNonNull(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i3 = this.b;
            if (i3 <= 0) {
                return -1;
            }
            if (i2 > i3) {
                i2 = i3;
            }
            QueueFile.this.j(this.a, bArr, i, i2);
            this.a = QueueFile.a(QueueFile.this, this.a + i2);
            this.b -= i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.b == 0) {
                return -1;
            }
            QueueFile.this.a.seek((long) this.a);
            int read = QueueFile.this.a.read();
            this.a = QueueFile.a(QueueFile.this, this.a + 1);
            this.b--;
            return read;
        }
    }
}
