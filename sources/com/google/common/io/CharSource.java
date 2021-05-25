package com.google.common.io;

import a2.j.d.h.f;
import a2.j.d.h.i;
import a2.j.d.h.j;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@GwtIncompatible
public abstract class CharSource {

    public final class a extends ByteSource {
        public final Charset a;

        public a(Charset charset) {
            this.a = (Charset) Preconditions.checkNotNull(charset);
        }

        @Override // com.google.common.io.ByteSource
        public CharSource asCharSource(Charset charset) {
            if (charset.equals(this.a)) {
                return CharSource.this;
            }
            return super.asCharSource(charset);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new j(CharSource.this.openStream(), this.a, 8192);
        }

        public String toString() {
            return CharSource.this.toString() + ".asByteSource(" + this.a + ")";
        }
    }

    public static final class c extends CharSource {
        public final Iterable<? extends CharSource> a;

        public c(Iterable<? extends CharSource> iterable) {
            this.a = (Iterable) Preconditions.checkNotNull(iterable);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() throws IOException {
            for (CharSource charSource : this.a) {
                if (!charSource.isEmpty()) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.google.common.io.CharSource
        public long length() throws IOException {
            long j = 0;
            for (CharSource charSource : this.a) {
                j += charSource.length();
            }
            return j;
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            long j = 0;
            for (CharSource charSource : this.a) {
                Optional<Long> lengthIfKnown = charSource.lengthIfKnown();
                if (!lengthIfKnown.isPresent()) {
                    return Optional.absent();
                }
                j += lengthIfKnown.get().longValue();
            }
            return Optional.of(Long.valueOf(j));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() throws IOException {
            return new i(this.a.iterator());
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharSource.concat(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static final class d extends e {
        public static final d c = new d();

        public d() {
            super("");
        }

        @Override // com.google.common.io.CharSource.b
        public String toString() {
            return "CharSource.empty()";
        }
    }

    public static CharSource concat(Iterable<? extends CharSource> iterable) {
        return new c(iterable);
    }

    public static CharSource empty() {
        return d.c;
    }

    public static CharSource wrap(CharSequence charSequence) {
        return charSequence instanceof String ? new e((String) charSequence) : new b(charSequence);
    }

    @Beta
    public ByteSource asByteSource(Charset charset) {
        return new a(charset);
    }

    @CanIgnoreReturnValue
    public long copyTo(Appendable appendable) throws IOException {
        Preconditions.checkNotNull(appendable);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) create.register(openStream()), appendable);
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public boolean isEmpty() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        boolean z = true;
        if (!lengthIfKnown.isPresent()) {
            Closer create = Closer.create();
            try {
                if (((Reader) create.register(openStream())).read() != -1) {
                    z = false;
                }
                create.close();
                return z;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        } else if (lengthIfKnown.get().longValue() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Beta
    public long length() throws IOException {
        Optional<Long> lengthIfKnown = lengthIfKnown();
        if (lengthIfKnown.isPresent()) {
            return lengthIfKnown.get().longValue();
        }
        Closer create = Closer.create();
        try {
            Reader reader = (Reader) create.register(openStream());
            long j = 0;
            while (true) {
                long skip = reader.skip(Long.MAX_VALUE);
                if (skip != 0) {
                    j += skip;
                } else {
                    create.close();
                    return j;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    public Optional<Long> lengthIfKnown() {
        return Optional.absent();
    }

    public BufferedReader openBufferedStream() throws IOException {
        Reader openStream = openStream();
        return openStream instanceof BufferedReader ? (BufferedReader) openStream : new BufferedReader(openStream);
    }

    public abstract Reader openStream() throws IOException;

    public String read() throws IOException {
        Closer create = Closer.create();
        try {
            String charStreams = CharStreams.toString((Reader) create.register(openStream()));
            create.close();
            return charStreams;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @NullableDecl
    public String readFirstLine() throws IOException {
        Closer create = Closer.create();
        try {
            String readLine = ((BufferedReader) create.register(openBufferedStream())).readLine();
            create.close();
            return readLine;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public ImmutableList<String> readLines() throws IOException {
        Closer create = Closer.create();
        try {
            BufferedReader bufferedReader = (BufferedReader) create.register(openBufferedStream());
            ArrayList newArrayList = Lists.newArrayList();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    newArrayList.add(readLine);
                } else {
                    ImmutableList<String> copyOf = ImmutableList.copyOf((Collection) newArrayList);
                    create.close();
                    return copyOf;
                }
            }
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    public static class b extends CharSource {
        public static final Splitter b = Splitter.onPattern("\r\n|\n|\r");
        public final CharSequence a;

        public b(CharSequence charSequence) {
            this.a = (CharSequence) Preconditions.checkNotNull(charSequence);
        }

        @Override // com.google.common.io.CharSource
        public boolean isEmpty() {
            return this.a.length() == 0;
        }

        @Override // com.google.common.io.CharSource
        public long length() {
            return (long) this.a.length();
        }

        @Override // com.google.common.io.CharSource
        public Optional<Long> lengthIfKnown() {
            return Optional.of(Long.valueOf((long) this.a.length()));
        }

        @Override // com.google.common.io.CharSource
        public Reader openStream() {
            return new a2.j.d.h.e(this.a);
        }

        @Override // com.google.common.io.CharSource
        public String read() {
            return this.a.toString();
        }

        @Override // com.google.common.io.CharSource
        public String readFirstLine() {
            f fVar = new f(this);
            if (fVar.hasNext()) {
                return (String) fVar.next();
            }
            return null;
        }

        @Override // com.google.common.io.CharSource
        public ImmutableList<String> readLines() {
            return ImmutableList.copyOf(new f(this));
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("CharSource.wrap(");
            L.append(Ascii.truncate(this.a, 30, "..."));
            L.append(")");
            return L.toString();
        }

        @Override // com.google.common.io.CharSource
        public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
            f fVar = new f(this);
            while (fVar.hasNext() && lineProcessor.processLine((String) fVar.next())) {
            }
            return lineProcessor.getResult();
        }
    }

    public static class e extends b {
        public e(String str) {
            super(str);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(Appendable appendable) throws IOException {
            appendable.append(this.a);
            return (long) this.a.length();
        }

        @Override // com.google.common.io.CharSource.b, com.google.common.io.CharSource
        public Reader openStream() {
            return new StringReader((String) this.a);
        }

        @Override // com.google.common.io.CharSource
        public long copyTo(CharSink charSink) throws IOException {
            Preconditions.checkNotNull(charSink);
            Closer create = Closer.create();
            try {
                ((Writer) create.register(charSink.openStream())).write((String) this.a);
                long length = (long) this.a.length();
                create.close();
                return length;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        }
    }

    public static CharSource concat(Iterator<? extends CharSource> it) {
        return concat(ImmutableList.copyOf(it));
    }

    public static CharSource concat(CharSource... charSourceArr) {
        return concat(ImmutableList.copyOf(charSourceArr));
    }

    @CanIgnoreReturnValue
    public long copyTo(CharSink charSink) throws IOException {
        Preconditions.checkNotNull(charSink);
        Closer create = Closer.create();
        try {
            long copy = CharStreams.copy((Reader) create.register(openStream()), (Writer) create.register(charSink.openStream()));
            create.close();
            return copy;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    @CanIgnoreReturnValue
    public <T> T readLines(LineProcessor<T> lineProcessor) throws IOException {
        Preconditions.checkNotNull(lineProcessor);
        Closer create = Closer.create();
        try {
            T t = (T) CharStreams.readLines((Reader) create.register(openStream()), lineProcessor);
            create.close();
            return t;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }
}
