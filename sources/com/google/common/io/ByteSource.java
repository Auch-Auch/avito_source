package com.google.common.io;

import a2.j.d.h.h;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.Funnels;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.common.hash.Hasher;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
@GwtIncompatible
public abstract class ByteSource {

    public class a extends CharSource {
        public final Charset a;

        public a(Charset charset) {
            this.a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.CharSource
        public ByteSource asByteSource(Charset charset) {
            if (charset.equals(this.a)) {
                return ByteSource.this;
            }
            return super.asByteSource(charset);
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new InputStreamReader(ByteSource.this.openStream(), this.a);
        }

        @Override // com.google.common.io.CharSource
        public String read() throws IOException {
            return new String(ByteSource.this.read(), this.a);
        }

        public String toString() {
            return ByteSource.this.toString() + ".asCharSource(" + this.a + ")";
        }
    }

    public static class b extends ByteSource {
        public final byte[] a;
        public final int b;
        public final int c;

        public b(byte[] bArr) {
            int length = bArr.length;
            this.a = bArr;
            this.b = 0;
            this.c = length;
        }

        @Override // com.google.common.io.ByteSource
        public long copyTo(OutputStream outputStream) throws IOException {
            outputStream.write(this.a, this.b, this.c);
            return (long) this.c;
        }

        @Override // com.google.common.io.ByteSource
        public HashCode hash(HashFunction hashFunction) throws IOException {
            return hashFunction.hashBytes(this.a, this.b, this.c);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() {
            return this.c == 0;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return openStream();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() {
            return new ByteArrayInputStream(this.a, this.b, this.c);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() {
            byte[] bArr = this.a;
            int i = this.b;
            return Arrays.copyOfRange(bArr, i, this.c + i);
        }

        @Override // com.google.common.io.ByteSource
        public long size() {
            return (long) this.c;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            return Optional.of(Long.valueOf((long) this.c));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j, long j2) {
            boolean z = false;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            if (j2 >= 0) {
                z = true;
            }
            Preconditions.checkArgument(z, "length (%s) may not be negative", j2);
            long min = Math.min(j, (long) this.c);
            return new b(this.a, this.b + ((int) min), (int) Math.min(j2, ((long) this.c) - min));
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ByteSource.wrap(");
            L.append(Ascii.truncate(BaseEncoding.base16().encode(this.a, this.b, this.c), 30, "..."));
            L.append(")");
            return L.toString();
        }

        @Override // com.google.common.io.ByteSource
        public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
            byteProcessor.processBytes(this.a, this.b, this.c);
            return byteProcessor.getResult();
        }

        public b(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
        }
    }

    public static final class c extends ByteSource {
        public final Iterable<? extends ByteSource> a;

        public c(Iterable<? extends ByteSource> iterable) {
            this.a = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            for (ByteSource byteSource : this.a) {
                if (!byteSource.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new h(this.a.iterator());
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            long j = 0;
            for (ByteSource byteSource : this.a) {
                j += byteSource.size();
                if (j < 0) {
                    return Long.MAX_VALUE;
                }
            }
            return j;
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Iterable<? extends ByteSource> iterable = this.a;
            if (!(iterable instanceof Collection)) {
                return Optional.absent();
            }
            long j = 0;
            for (ByteSource byteSource : iterable) {
                Optional<Long> sizeIfKnown = byteSource.sizeIfKnown();
                if (!sizeIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j += sizeIfKnown.get().longValue();
                if (j < 0) {
                    return Optional.of(Long.MAX_VALUE);
                }
            }
            return Optional.of(Long.valueOf(j));
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("ByteSource.concat(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static final class d extends b {
        public static final d d = new d();

        public d() {
            super(new byte[0]);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            Preconditions.checkNotNull(charset);
            return CharSource.empty();
        }

        @Override // com.google.common.io.ByteSource.b, com.google.common.io.ByteSource
        public byte[] read() {
            return this.a;
        }

        @Override // com.google.common.io.ByteSource.b
        public String toString() {
            return "ByteSource.empty()";
        }
    }

    public final class e extends ByteSource {
        public final long a;
        public final long b;

        public e(long j, long j2) {
            boolean z = false;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            Preconditions.checkArgument(j2 >= 0 ? true : z, "length (%s) may not be negative", j2);
            this.a = j;
            this.b = j2;
        }

        public final InputStream a(InputStream inputStream) throws IOException {
            Closer create;
            long j = this.a;
            if (j > 0) {
                try {
                    if (ByteStreams.b(inputStream, j) < this.a) {
                        inputStream.close();
                        return new ByteArrayInputStream(new byte[0]);
                    }
                } catch (Throwable th) {
                    create.close();
                    throw th;
                }
            }
            return ByteStreams.limit(inputStream, this.b);
        }

        @Override // com.google.common.io.ByteSource
        public boolean isEmpty() throws IOException {
            return this.b == 0 || ByteSource.super.isEmpty();
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openBufferedStream() throws IOException {
            return a(ByteSource.this.openBufferedStream());
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return a(ByteSource.this.openStream());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            Optional<Long> sizeIfKnown = ByteSource.this.sizeIfKnown();
            if (!sizeIfKnown.isPresent()) {
                return Optional.absent();
            }
            long longValue = sizeIfKnown.get().longValue();
            return Optional.of(Long.valueOf(Math.min(this.b, longValue - Math.min(this.a, longValue))));
        }

        @Override // com.google.common.io.ByteSource
        public ByteSource slice(long j, long j2) {
            boolean z = true;
            Preconditions.checkArgument(j >= 0, "offset (%s) may not be negative", j);
            if (j2 < 0) {
                z = false;
            }
            Preconditions.checkArgument(z, "length (%s) may not be negative", j2);
            return ByteSource.this.slice(this.a + j, Math.min(j2, this.b - j));
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(ByteSource.this.toString());
            sb.append(".slice(");
            sb.append(this.a);
            sb.append(", ");
            return a2.b.a.a.a.l(sb, this.b, ")");
        }
    }

    public static ByteSource concat(Iterable<? extends ByteSource> iterable) {
        return new c(iterable);
    }

    public static ByteSource empty() {
        return d.d;
    }

    public static ByteSource wrap(byte[] bArr) {
        return new b(bArr);
    }

    public CharSource asCharSource(Charset charset) {
        return new a(charset);
    }

    public boolean contentEquals(ByteSource byteSource) throws IOException {
        int read;
        Preconditions.checkNotNull(byteSource);
        OutputStream outputStream = ByteStreams.a;
        byte[] bArr = new byte[8192];
        byte[] bArr2 = new byte[8192];
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            InputStream inputStream2 = (InputStream) create.register(byteSource.openStream());
            do {
                read = ByteStreams.read(inputStream, bArr, 0, 8192);
                if (read != ByteStreams.read(inputStream2, bArr2, 0, 8192) || !Arrays.equals(bArr, bArr2)) {
                    create.close();
                    return false;
                }
            } while (read == 8192);
            create.close();
            return true;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @CanIgnoreReturnValue
    public long copyTo(OutputStream outputStream) throws IOException {
        Preconditions.checkNotNull(outputStream);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), outputStream);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public HashCode hash(HashFunction hashFunction) throws IOException {
        Hasher newHasher = hashFunction.newHasher();
        copyTo(Funnels.asOutputStream(newHasher));
        return newHasher.hash();
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> sizeIfKnown = sizeIfKnown();
        boolean z = true;
        if (!sizeIfKnown.isPresent()) {
            Closer create = Closer.create();
            try {
                if (((InputStream) create.register(openStream())).read() != -1) {
                    z = false;
                }
                create.close();
                return z;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        } else if (sizeIfKnown.get().longValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public InputStream openBufferedStream() throws IOException {
        InputStream openStream = openStream();
        return openStream instanceof BufferedInputStream ? (BufferedInputStream) openStream : new BufferedInputStream(openStream);
    }

    public abstract InputStream openStream() throws IOException;

    public byte[] read() throws IOException {
        byte[] bArr;
        Closer create = Closer.create();
        try {
            InputStream inputStream = (InputStream) create.register(openStream());
            Optional<Long> sizeIfKnown = sizeIfKnown();
            if (sizeIfKnown.isPresent()) {
                bArr = ByteStreams.c(inputStream, sizeIfKnown.get().longValue());
            } else {
                bArr = ByteStreams.toByteArray(inputStream);
            }
            create.close();
            return bArr;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public long size() throws IOException {
        Closer create;
        Optional<Long> sizeIfKnown = sizeIfKnown();
        if (sizeIfKnown.isPresent()) {
            return sizeIfKnown.get().longValue();
        }
        Closer create2 = Closer.create();
        try {
            InputStream inputStream = (InputStream) create2.register(openStream());
            long j = 0;
            while (true) {
                long b2 = ByteStreams.b(inputStream, 2147483647L);
                if (b2 > 0) {
                    j += b2;
                } else {
                    create2.close();
                    return j;
                }
            }
        } catch (IOException unused) {
            create2.close();
            create = Closer.create();
            long exhaust = ByteStreams.exhaust((InputStream) create.register(openStream()));
            create.close();
            return exhaust;
        } catch (Throwable th) {
            try {
                throw create.rethrow(th);
            } catch (Throwable th2) {
                create.close();
                throw th2;
            }
        }
    }

    @Beta
    public Optional<Long> sizeIfKnown() {
        return Optional.absent();
    }

    public ByteSource slice(long j, long j2) {
        return new e(j, j2);
    }

    public static ByteSource concat(Iterator<? extends ByteSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static ByteSource concat(ByteSource... byteSourceArr) {
        return concat(ImmutableList.copyOf(byteSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(ByteSink byteSink) throws IOException {
        Preconditions.checkNotNull(byteSink);
        Closer create = Closer.create();
        try {
            long copy = ByteStreams.copy((InputStream) create.register(openStream()), (OutputStream) create.register(byteSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    @CanIgnoreReturnValue
    public <T> T read(ByteProcessor<T> byteProcessor) throws IOException {
        Preconditions.checkNotNull(byteProcessor);
        Closer create = Closer.create();
        try {
            T t = (T) ByteStreams.readBytes((InputStream) create.register(openStream()), byteProcessor);
            create.close();
            return t;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
