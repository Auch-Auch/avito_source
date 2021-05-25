package com.squareup.tape2;

import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.disk.DefaultDiskStorage;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
public final class QueueFile implements Closeable, Iterable<byte[]> {
    public static final byte[] m = new byte[4096];
    public final RandomAccessFile a;
    public final File b;
    public boolean c;
    public int d;
    public long e;
    public int f;
    public a g;
    public a h;
    public final byte[] i;
    public int j = 0;
    public final boolean k;
    public boolean l;

    public static final class Builder {
        public final File a;
        public boolean b = true;
        public boolean c = false;

        public Builder(File file) {
            Objects.requireNonNull(file, "file == null");
            this.a = file;
        }

        /* JADX INFO: finally extract failed */
        public QueueFile build() throws IOException {
            File file = this.a;
            boolean z = this.c;
            if (!file.exists()) {
                File file2 = new File(file.getPath() + DefaultDiskStorage.FileType.TEMP);
                RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rwd");
                try {
                    randomAccessFile.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                    randomAccessFile.seek(0);
                    if (z) {
                        randomAccessFile.writeInt(4096);
                    } else {
                        randomAccessFile.writeInt(-2147483647);
                        randomAccessFile.writeLong(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                    }
                    randomAccessFile.close();
                    if (!file2.renameTo(file)) {
                        throw new IOException("Rename failed!");
                    }
                } catch (Throwable th) {
                    randomAccessFile.close();
                    throw th;
                }
            }
            return new QueueFile(this.a, new RandomAccessFile(file, "rwd"), this.b, this.c);
        }

        public Builder forceLegacy(boolean z) {
            this.c = z;
            return this;
        }

        public Builder zero(boolean z) {
            this.b = z;
            return this;
        }
    }

    public static class a {
        public static final a c = new a(0, 0);
        public final long a;
        public final int b;

        public a(long j, int i) {
            this.a = j;
            this.b = i;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(a.class.getSimpleName());
            sb.append("[position=");
            sb.append(this.a);
            sb.append(", length=");
            return a2.b.a.a.a.j(sb, this.b, "]");
        }
    }

    public final class b implements Iterator<byte[]> {
        public int a = 0;
        public long b;
        public int c;

        public b() {
            this.b = QueueFile.this.g.a;
            this.c = QueueFile.this.j;
        }

        public final void a() {
            if (QueueFile.this.j != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (!QueueFile.this.l) {
                a();
                return this.a != QueueFile.this.f;
            }
            throw new IllegalStateException("closed");
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.Iterator
        public byte[] next() {
            if (!QueueFile.this.l) {
                a();
                if (!QueueFile.this.isEmpty()) {
                    int i = this.a;
                    QueueFile queueFile = QueueFile.this;
                    if (i < queueFile.f) {
                        try {
                            a a3 = queueFile.a(this.b);
                            byte[] bArr = new byte[a3.b];
                            long g = QueueFile.this.g(a3.a + 4);
                            this.b = g;
                            QueueFile.this.e(g, bArr, 0, a3.b);
                            this.b = QueueFile.this.g(a3.a + 4 + ((long) a3.b));
                            this.a++;
                            return bArr;
                        } catch (IOException e) {
                            throw new RuntimeException("todo: throw a proper error", e);
                        }
                    } else {
                        throw new NoSuchElementException();
                    }
                } else {
                    throw new NoSuchElementException();
                }
            } else {
                throw new IllegalStateException("closed");
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            if (QueueFile.this.isEmpty()) {
                throw new NoSuchElementException();
            } else if (this.a == 1) {
                try {
                    QueueFile.this.remove();
                    this.c = QueueFile.this.j;
                    this.a--;
                } catch (IOException e) {
                    throw new RuntimeException("todo: throw a proper error", e);
                }
            } else {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
        }
    }

    public QueueFile(File file, RandomAccessFile randomAccessFile, boolean z, boolean z2) throws IOException {
        long j2;
        long j3;
        byte[] bArr = new byte[32];
        this.i = bArr;
        this.b = file;
        this.a = randomAccessFile;
        this.k = z;
        randomAccessFile.seek(0);
        randomAccessFile.readFully(bArr);
        boolean z3 = !z2 && (bArr[0] & 128) != 0;
        this.c = z3;
        if (z3) {
            this.d = 32;
            int b2 = b(bArr, 0) & Integer.MAX_VALUE;
            if (b2 == 1) {
                this.e = c(bArr, 4);
                this.f = b(bArr, 12);
                j2 = c(bArr, 16);
                j3 = c(bArr, 24);
            } else {
                throw new IOException(a2.b.a.a.a.Q2("Unable to read version ", b2, " format. Supported versions are 1 and legacy."));
            }
        } else {
            this.d = 16;
            this.e = (long) b(bArr, 0);
            this.f = b(bArr, 4);
            long b3 = (long) b(bArr, 8);
            j3 = (long) b(bArr, 12);
            j2 = b3;
        }
        if (this.e > randomAccessFile.length()) {
            StringBuilder L = a2.b.a.a.a.L("File is truncated. Expected length: ");
            L.append(this.e);
            L.append(", Actual length: ");
            L.append(randomAccessFile.length());
            throw new IOException(L.toString());
        } else if (this.e > ((long) this.d)) {
            this.g = a(j2);
            this.h = a(j3);
        } else {
            throw new IOException(a2.b.a.a.a.l(a2.b.a.a.a.L("File is corrupt; length stored in header ("), this.e, ") is invalid."));
        }
    }

    public static int b(byte[] bArr, int i2) {
        return ((bArr[i2] & 255) << 24) + ((bArr[i2 + 1] & 255) << 16) + ((bArr[i2 + 2] & 255) << 8) + (bArr[i2 + 3] & 255);
    }

    public static long c(byte[] bArr, int i2) {
        return ((((long) bArr[i2]) & 255) << 56) + ((((long) bArr[i2 + 1]) & 255) << 48) + ((((long) bArr[i2 + 2]) & 255) << 40) + ((((long) bArr[i2 + 3]) & 255) << 32) + ((((long) bArr[i2 + 4]) & 255) << 24) + ((((long) bArr[i2 + 5]) & 255) << 16) + ((((long) bArr[i2 + 6]) & 255) << 8) + (((long) bArr[i2 + 7]) & 255);
    }

    public static void i(byte[] bArr, int i2, int i3) {
        bArr[i2] = (byte) (i3 >> 24);
        bArr[i2 + 1] = (byte) (i3 >> 16);
        bArr[i2 + 2] = (byte) (i3 >> 8);
        bArr[i2 + 3] = (byte) i3;
    }

    public static void j(byte[] bArr, int i2, long j2) {
        bArr[i2] = (byte) ((int) (j2 >> 56));
        bArr[i2 + 1] = (byte) ((int) (j2 >> 48));
        bArr[i2 + 2] = (byte) ((int) (j2 >> 40));
        bArr[i2 + 3] = (byte) ((int) (j2 >> 32));
        bArr[i2 + 4] = (byte) ((int) (j2 >> 24));
        bArr[i2 + 5] = (byte) ((int) (j2 >> 16));
        bArr[i2 + 6] = (byte) ((int) (j2 >> 8));
        bArr[i2 + 7] = (byte) ((int) j2);
    }

    public a a(long j2) throws IOException {
        if (j2 == 0) {
            return a.c;
        }
        e(j2, this.i, 0, 4);
        return new a(j2, b(this.i, 0));
    }

    public void add(byte[] bArr) throws IOException {
        add(bArr, 0, bArr.length);
    }

    public void clear() throws IOException {
        if (!this.l) {
            h(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM, 0, 0, 0);
            if (this.k) {
                this.a.seek((long) this.d);
                this.a.write(m, 0, 4096 - this.d);
            }
            this.f = 0;
            a aVar = a.c;
            this.g = aVar;
            this.h = aVar;
            if (this.e > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
                this.a.setLength(PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM);
                this.a.getChannel().force(true);
            }
            this.e = PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM;
            this.j++;
            return;
        }
        throw new IOException("closed");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.l = true;
        this.a.close();
    }

    public final void d(long j2, long j3) throws IOException {
        while (j3 > 0) {
            byte[] bArr = m;
            int min = (int) Math.min(j3, (long) bArr.length);
            f(j2, bArr, 0, min);
            long j4 = (long) min;
            j3 -= j4;
            j2 += j4;
        }
    }

    public void e(long j2, byte[] bArr, int i2, int i3) throws IOException {
        long g2 = g(j2);
        long j3 = this.e;
        if (((long) i3) + g2 <= j3) {
            this.a.seek(g2);
            this.a.readFully(bArr, i2, i3);
            return;
        }
        int i4 = (int) (j3 - g2);
        this.a.seek(g2);
        this.a.readFully(bArr, i2, i4);
        this.a.seek((long) this.d);
        this.a.readFully(bArr, i2 + i4, i3 - i4);
    }

    public final void f(long j2, byte[] bArr, int i2, int i3) throws IOException {
        long g2 = g(j2);
        long j3 = this.e;
        if (((long) i3) + g2 <= j3) {
            this.a.seek(g2);
            this.a.write(bArr, i2, i3);
            return;
        }
        int i4 = (int) (j3 - g2);
        this.a.seek(g2);
        this.a.write(bArr, i2, i4);
        this.a.seek((long) this.d);
        this.a.write(bArr, i2 + i4, i3 - i4);
    }

    public File file() {
        return this.b;
    }

    public long g(long j2) {
        long j3 = this.e;
        return j2 < j3 ? j2 : (((long) this.d) + j2) - j3;
    }

    public final void h(long j2, int i2, long j3, long j4) throws IOException {
        this.a.seek(0);
        if (this.c) {
            i(this.i, 0, -2147483647);
            j(this.i, 4, j2);
            i(this.i, 12, i2);
            j(this.i, 16, j3);
            j(this.i, 24, j4);
            this.a.write(this.i, 0, 32);
            return;
        }
        i(this.i, 0, (int) j2);
        i(this.i, 4, i2);
        i(this.i, 8, (int) j3);
        i(this.i, 12, (int) j4);
        this.a.write(this.i, 0, 16);
    }

    public boolean isEmpty() {
        return this.f == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new b();
    }

    public byte[] peek() throws IOException {
        if (this.l) {
            throw new IOException("closed");
        } else if (isEmpty()) {
            return null;
        } else {
            a aVar = this.g;
            int i2 = aVar.b;
            byte[] bArr = new byte[i2];
            e(4 + aVar.a, bArr, 0, i2);
            return bArr;
        }
    }

    public void remove() throws IOException {
        remove(1);
    }

    public int size() {
        return this.f;
    }

    @Override // java.lang.Object
    public String toString() {
        return QueueFile.class.getSimpleName() + "[length=" + this.e + ", size=" + this.f + ", first=" + this.g + ", last=" + this.h + "]";
    }

    public void add(byte[] bArr, int i2, int i3) throws IOException {
        long j2;
        long j3;
        long j4;
        long j5;
        long j6;
        long j7;
        Objects.requireNonNull(bArr, "data == null");
        if ((i2 | i3) < 0 || i3 > bArr.length - i2) {
            throw new IndexOutOfBoundsException();
        } else if (!this.l) {
            long j8 = ((long) i3) + 4;
            long j9 = this.e;
            if (this.f == 0) {
                j2 = (long) this.d;
            } else {
                a aVar = this.h;
                long j10 = aVar.a;
                long j11 = this.g.a;
                if (j10 >= j11) {
                    j2 = ((long) this.d) + (j10 - j11) + 4 + ((long) aVar.b);
                } else {
                    j2 = (((j10 + 4) + ((long) aVar.b)) + j9) - j11;
                }
            }
            long j12 = j9 - j2;
            if (j12 < j8) {
                while (true) {
                    j12 += j9;
                    j4 = j9 << 1;
                    if (j12 >= j8) {
                        break;
                    }
                    j9 = j4;
                }
                this.a.setLength(j4);
                this.a.getChannel().force(true);
                a aVar2 = this.h;
                long g2 = g(aVar2.a + 4 + ((long) aVar2.b));
                if (g2 <= this.g.a) {
                    FileChannel channel = this.a.getChannel();
                    channel.position(this.e);
                    long j13 = (long) this.d;
                    long j14 = g2 - j13;
                    if (channel.transferTo(j13, j14, channel) == j14) {
                        j5 = j14;
                    } else {
                        throw new AssertionError("Copied insufficient number of bytes!");
                    }
                } else {
                    j5 = 0;
                }
                long j15 = this.h.a;
                long j16 = this.g.a;
                if (j15 < j16) {
                    j6 = j4;
                    long j17 = (this.e + j15) - ((long) this.d);
                    j7 = j5;
                    h(j6, this.f, j16, j17);
                    this.h = new a(j17, this.h.b);
                } else {
                    j7 = j5;
                    j6 = j4;
                    h(j6, this.f, j16, j15);
                }
                this.e = j6;
                if (this.k) {
                    d((long) this.d, j7);
                }
            }
            boolean isEmpty = isEmpty();
            if (isEmpty) {
                j3 = (long) this.d;
            } else {
                a aVar3 = this.h;
                j3 = g(aVar3.a + 4 + ((long) aVar3.b));
            }
            a aVar4 = new a(j3, i3);
            i(this.i, 0, i3);
            f(aVar4.a, this.i, 0, 4);
            f(aVar4.a + 4, bArr, i2, i3);
            h(this.e, this.f + 1, isEmpty ? aVar4.a : this.g.a, aVar4.a);
            this.h = aVar4;
            this.f++;
            this.j++;
            if (isEmpty) {
                this.g = aVar4;
            }
        } else {
            throw new IOException("closed");
        }
    }

    public void remove(int i2) throws IOException {
        if (i2 < 0) {
            throw new IllegalArgumentException(a2.b.a.a.a.Q2("Cannot remove negative (", i2, ") number of elements."));
        } else if (i2 != 0) {
            if (i2 == this.f) {
                clear();
            } else if (isEmpty()) {
                throw new NoSuchElementException();
            } else if (i2 <= this.f) {
                a aVar = this.g;
                long j2 = aVar.a;
                int i3 = aVar.b;
                long j3 = 0;
                long j4 = j2;
                int i4 = 0;
                while (i4 < i2) {
                    j3 += (long) (i3 + 4);
                    long g2 = g(j4 + 4 + ((long) i3));
                    e(g2, this.i, 0, 4);
                    i3 = b(this.i, 0);
                    i4++;
                    j4 = g2;
                }
                h(this.e, this.f - i2, j4, this.h.a);
                this.f -= i2;
                this.j++;
                this.g = new a(j4, i3);
                if (this.k) {
                    d(j2, j3);
                }
            } else {
                throw new IllegalArgumentException(a2.b.a.a.a.j(a2.b.a.a.a.M("Cannot remove more elements (", i2, ") than present in queue ("), this.f, ")."));
            }
        }
    }
}
