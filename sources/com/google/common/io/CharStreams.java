package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
@GwtIncompatible
public final class CharStreams {

    public static final class a extends Writer {
        public static final a a = new a();

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(char c) {
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence) {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer, java.lang.Appendable
        /* renamed from: append  reason: collision with other method in class */
        public Appendable mo141append(char c) throws IOException {
            return this;
        }

        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
        }

        @Override // java.lang.Object
        public String toString() {
            return "CharStreams.nullWriter()";
        }

        @Override // java.io.Writer
        public void write(int i) {
        }

        @Override // java.io.Writer
        public void write(char[] cArr) {
            Preconditions.checkNotNull(cArr);
        }

        @Override // java.io.Writer, java.lang.Appendable
        /* renamed from: append  reason: collision with other method in class */
        public Appendable mo142append(CharSequence charSequence) throws IOException {
            Preconditions.checkNotNull(charSequence);
            return this;
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, cArr.length);
        }

        @Override // java.io.Writer, java.lang.Appendable
        public Writer append(CharSequence charSequence, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, charSequence.length());
            return this;
        }

        @Override // java.io.Writer
        public void write(String str) {
            Preconditions.checkNotNull(str);
        }

        @Override // java.io.Writer, java.lang.Appendable
        /* renamed from: append  reason: collision with other method in class */
        public Appendable mo143append(CharSequence charSequence, int i, int i2) throws IOException {
            Preconditions.checkPositionIndexes(i, i2, charSequence.length());
            return this;
        }

        @Override // java.io.Writer
        public void write(String str, int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2 + i, str.length());
        }
    }

    @CanIgnoreReturnValue
    public static long a(Reader reader, StringBuilder sb) throws IOException {
        Preconditions.checkNotNull(reader);
        Preconditions.checkNotNull(sb);
        char[] cArr = new char[2048];
        long j = 0;
        while (true) {
            int read = reader.read(cArr);
            if (read == -1) {
                return j;
            }
            sb.append(cArr, 0, read);
            j += (long) read;
        }
    }

    @Beta
    public static Writer asWriter(Appendable appendable) {
        if (appendable instanceof Writer) {
            return (Writer) appendable;
        }
        return new a2.j.d.h.a(appendable);
    }

    public static CharBuffer b() {
        return CharBuffer.allocate(2048);
    }

    @CanIgnoreReturnValue
    public static long copy(Readable readable, Appendable appendable) throws IOException {
        long j = 0;
        if (!(readable instanceof Reader)) {
            Preconditions.checkNotNull(readable);
            Preconditions.checkNotNull(appendable);
            CharBuffer b = b();
            while (readable.read(b) != -1) {
                b.flip();
                appendable.append(b);
                j += (long) b.remaining();
                b.clear();
            }
            return j;
        } else if (appendable instanceof StringBuilder) {
            return a((Reader) readable, (StringBuilder) appendable);
        } else {
            Reader reader = (Reader) readable;
            Writer asWriter = asWriter(appendable);
            Preconditions.checkNotNull(reader);
            Preconditions.checkNotNull(asWriter);
            char[] cArr = new char[2048];
            while (true) {
                int read = reader.read(cArr);
                if (read == -1) {
                    return j;
                }
                asWriter.write(cArr, 0, read);
                j += (long) read;
            }
        }
    }

    @CanIgnoreReturnValue
    @Beta
    public static long exhaust(Readable readable) throws IOException {
        CharBuffer b = b();
        long j = 0;
        while (true) {
            long read = (long) readable.read(b);
            if (read == -1) {
                return j;
            }
            j += read;
            b.clear();
        }
    }

    @Beta
    public static Writer nullWriter() {
        return a.a;
    }

    @Beta
    public static List<String> readLines(Readable readable) throws IOException {
        ArrayList arrayList = new ArrayList();
        LineReader lineReader = new LineReader(readable);
        while (true) {
            String readLine = lineReader.readLine();
            if (readLine == null) {
                return arrayList;
            }
            arrayList.add(readLine);
        }
    }

    @Beta
    public static void skipFully(Reader reader, long j) throws IOException {
        Preconditions.checkNotNull(reader);
        while (j > 0) {
            long skip = reader.skip(j);
            if (skip != 0) {
                j -= skip;
            } else {
                throw new EOFException();
            }
        }
    }

    public static String toString(Readable readable) throws IOException {
        StringBuilder sb = new StringBuilder();
        if (readable instanceof Reader) {
            a((Reader) readable, sb);
        } else {
            copy(readable, sb);
        }
        return sb.toString();
    }

    @Beta
    @CanIgnoreReturnValue
    public static <T> T readLines(Readable readable, LineProcessor<T> lineProcessor) throws IOException {
        String readLine;
        Preconditions.checkNotNull(readable);
        Preconditions.checkNotNull(lineProcessor);
        LineReader lineReader = new LineReader(readable);
        do {
            readLine = lineReader.readLine();
            if (readLine == null) {
                break;
            }
        } while (lineProcessor.processLine(readLine));
        return lineProcessor.getResult();
    }
}
