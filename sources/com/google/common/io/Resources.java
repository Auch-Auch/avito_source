package com.google.common.io;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
@Beta
@GwtIncompatible
public final class Resources {

    public static class a implements LineProcessor<List<String>> {
        public final List<String> a = Lists.newArrayList();

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.google.common.io.LineProcessor
        public List<String> getResult() {
            return this.a;
        }

        @Override // com.google.common.io.LineProcessor
        public boolean processLine(String str) {
            this.a.add(str);
            return true;
        }
    }

    public static final class b extends ByteSource {
        public final URL a;

        public b(URL url, a aVar) {
            this.a = (URL) Preconditions.checkNotNull(url);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return this.a.openStream();
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Resources.asByteSource(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public static ByteSource asByteSource(URL url) {
        return new b(url, null);
    }

    public static CharSource asCharSource(URL url, Charset charset) {
        return asByteSource(url).asCharSource(charset);
    }

    public static void copy(URL url, OutputStream outputStream) throws IOException {
        asByteSource(url).copyTo(outputStream);
    }

    @CanIgnoreReturnValue
    public static URL getResource(String str) {
        URL resource = ((ClassLoader) MoreObjects.firstNonNull(Thread.currentThread().getContextClassLoader(), Resources.class.getClassLoader())).getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s not found.", str);
        return resource;
    }

    @CanIgnoreReturnValue
    public static <T> T readLines(URL url, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) asCharSource(url, charset).readLines(lineProcessor);
    }

    public static byte[] toByteArray(URL url) throws IOException {
        return asByteSource(url).read();
    }

    public static String toString(URL url, Charset charset) throws IOException {
        return asCharSource(url, charset).read();
    }

    public static List<String> readLines(URL url, Charset charset) throws IOException {
        return (List) readLines(url, charset, new a());
    }

    public static URL getResource(Class<?> cls, String str) {
        URL resource = cls.getResource(str);
        Preconditions.checkArgument(resource != null, "resource %s relative to %s not found.", str, cls.getName());
        return resource;
    }
}
