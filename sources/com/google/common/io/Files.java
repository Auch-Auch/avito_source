package com.google.common.io;

import com.avito.android.search.map.reducer.MapReducerKt;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Joiner;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.TreeTraverser;
import com.google.common.graph.SuccessorsFunction;
import com.google.common.graph.Traverser;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@GwtIncompatible
public final class Files {
    public static final SuccessorsFunction<File> a = new c();

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

    public static class b extends TreeTraverser<File> {
        /* Return type fixed from 'java.lang.Iterable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.collect.TreeTraverser
        public Iterable<File> children(File file) {
            return Files.a(file);
        }

        public String toString() {
            return "Files.fileTreeTraverser()";
        }
    }

    public static class c implements SuccessorsFunction<File> {
        /* Return type fixed from 'java.lang.Iterable' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.common.graph.SuccessorsFunction
        /* renamed from: successors */
        public Iterable<? extends File> mo140successors(File file) {
            return Files.a(file);
        }
    }

    public static final class d extends ByteSink {
        public final File a;
        public final ImmutableSet<FileWriteMode> b;

        public d(File file, FileWriteMode[] fileWriteModeArr, a aVar) {
            this.a = (File) Preconditions.checkNotNull(file);
            this.b = ImmutableSet.copyOf(fileWriteModeArr);
        }

        @Override // com.google.common.io.ByteSink
        public OutputStream openStream() throws IOException {
            return new FileOutputStream(this.a, this.b.contains(FileWriteMode.APPEND));
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Files.asByteSink(");
            L.append(this.a);
            L.append(", ");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }
    }

    public static final class e extends ByteSource {
        public final File a;

        public e(File file, a aVar) {
            this.a = (File) Preconditions.checkNotNull(file);
        }

        @Override // com.google.common.io.ByteSource
        public InputStream openStream() throws IOException {
            return new FileInputStream(this.a);
        }

        @Override // com.google.common.io.ByteSource
        public byte[] read() throws IOException {
            Closer create = Closer.create();
            try {
                FileInputStream fileInputStream = (FileInputStream) create.register(new FileInputStream(this.a));
                byte[] c = ByteStreams.c(fileInputStream, fileInputStream.getChannel().size());
                create.close();
                return c;
            } catch (Throwable th) {
                create.close();
                throw th;
            }
        }

        @Override // com.google.common.io.ByteSource
        public long size() throws IOException {
            if (this.a.isFile()) {
                return this.a.length();
            }
            throw new FileNotFoundException(this.a.toString());
        }

        @Override // com.google.common.io.ByteSource
        public Optional<Long> sizeIfKnown() {
            if (this.a.isFile()) {
                return Optional.of(Long.valueOf(this.a.length()));
            }
            return Optional.absent();
        }

        public String toString() {
            StringBuilder L = a2.b.a.a.a.L("Files.asByteSource(");
            L.append(this.a);
            L.append(")");
            return L.toString();
        }
    }

    public enum f implements Predicate<File> {
        IS_DIRECTORY {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isDirectory();
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Files.isDirectory()";
            }
        },
        IS_FILE {
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.google.common.base.Predicate
            public boolean apply(File file) {
                return file.isFile();
            }

            @Override // java.lang.Enum, java.lang.Object
            public String toString() {
                return "Files.isFile()";
            }
        };

        /* access modifiers changed from: public */
        f(a aVar) {
        }
    }

    static {
        new b();
    }

    public static Iterable a(File file) {
        File[] listFiles;
        if (!file.isDirectory() || (listFiles = file.listFiles()) == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(Arrays.asList(listFiles));
    }

    @Beta
    @Deprecated
    public static void append(CharSequence charSequence, File file, Charset charset) throws IOException {
        asCharSink(file, charset, FileWriteMode.APPEND).write(charSequence);
    }

    public static ByteSink asByteSink(File file, FileWriteMode... fileWriteModeArr) {
        return new d(file, fileWriteModeArr, null);
    }

    public static ByteSource asByteSource(File file) {
        return new e(file, null);
    }

    public static CharSink asCharSink(File file, Charset charset, FileWriteMode... fileWriteModeArr) {
        return asByteSink(file, fileWriteModeArr).asCharSink(charset);
    }

    public static CharSource asCharSource(File file, Charset charset) {
        return asByteSource(file).asCharSource(charset);
    }

    public static MappedByteBuffer b(File file, FileChannel.MapMode mapMode, long j) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(mapMode);
        Closer create = Closer.create();
        try {
            FileChannel fileChannel = (FileChannel) create.register(((RandomAccessFile) create.register(new RandomAccessFile(file, mapMode == FileChannel.MapMode.READ_ONLY ? "r" : "rw"))).getChannel());
            if (j == -1) {
                j = fileChannel.size();
            }
            MappedByteBuffer map = fileChannel.map(mapMode, 0, j);
            create.close();
            return map;
        } catch (Throwable th) {
            create.close();
            throw th;
        }
    }

    @Beta
    public static void copy(File file, OutputStream outputStream) throws IOException {
        asByteSource(file).copyTo(outputStream);
    }

    @Beta
    public static void createParentDirs(File file) throws IOException {
        Preconditions.checkNotNull(file);
        File parentFile = file.getCanonicalFile().getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                throw new IOException(a2.b.a.a.a.Y2("Unable to create parent directories of ", file));
            }
        }
    }

    @Beta
    public static File createTempDir() {
        File file = new File(System.getProperty("java.io.tmpdir"));
        String str = System.currentTimeMillis() + "-";
        for (int i = 0; i < 10000; i++) {
            File file2 = new File(file, a2.b.a.a.a.M2(str, i));
            if (file2.mkdir()) {
                return file2;
            }
        }
        throw new IllegalStateException("Failed to create directory within 10000 attempts (tried " + str + "0 to " + str + MapReducerKt.MAX_PIN_COUNT + ')');
    }

    @Beta
    public static boolean equal(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        if (file == file2 || file.equals(file2)) {
            return true;
        }
        long length = file.length();
        long length2 = file2.length();
        if (length == 0 || length2 == 0 || length == length2) {
            return asByteSource(file).contentEquals(asByteSource(file2));
        }
        return false;
    }

    @Beta
    public static Traverser<File> fileTraverser() {
        return Traverser.forTree(a);
    }

    @Beta
    public static String getFileExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf == -1) {
            return "";
        }
        return name.substring(lastIndexOf + 1);
    }

    @Beta
    public static String getNameWithoutExtension(String str) {
        Preconditions.checkNotNull(str);
        String name = new File(str).getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf == -1 ? name : name.substring(0, lastIndexOf);
    }

    @Beta
    @Deprecated
    public static HashCode hash(File file, HashFunction hashFunction) throws IOException {
        return asByteSource(file).hash(hashFunction);
    }

    @Beta
    public static Predicate<File> isDirectory() {
        return f.IS_DIRECTORY;
    }

    @Beta
    public static Predicate<File> isFile() {
        return f.IS_FILE;
    }

    @Beta
    public static MappedByteBuffer map(File file) throws IOException {
        Preconditions.checkNotNull(file);
        return map(file, FileChannel.MapMode.READ_ONLY);
    }

    @Beta
    public static void move(File file, File file2) throws IOException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(file2);
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        if (!file.renameTo(file2)) {
            copy(file, file2);
            if (file.delete()) {
                return;
            }
            if (!file2.delete()) {
                throw new IOException(a2.b.a.a.a.Y2("Unable to delete ", file2));
            }
            throw new IOException(a2.b.a.a.a.Y2("Unable to delete ", file));
        }
    }

    @Beta
    public static BufferedReader newReader(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedReader(new InputStreamReader(new FileInputStream(file), charset));
    }

    @Beta
    public static BufferedWriter newWriter(File file, Charset charset) throws FileNotFoundException {
        Preconditions.checkNotNull(file);
        Preconditions.checkNotNull(charset);
        return new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), charset));
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T readBytes(File file, ByteProcessor<T> byteProcessor) throws IOException {
        return (T) asByteSource(file).read(byteProcessor);
    }

    @Beta
    @Deprecated
    public static String readFirstLine(File file, Charset charset) throws IOException {
        return asCharSource(file, charset).readFirstLine();
    }

    @Beta
    public static List<String> readLines(File file, Charset charset) throws IOException {
        return (List) asCharSource(file, charset).readLines(new a());
    }

    @Beta
    public static String simplifyPath(String str) {
        Preconditions.checkNotNull(str);
        if (str.length() == 0) {
            return ".";
        }
        Iterable<String> split = Splitter.on('/').omitEmptyStrings().split(str);
        ArrayList arrayList = new ArrayList();
        for (String str2 : split) {
            str2.hashCode();
            if (!str2.equals(".")) {
                if (!str2.equals("..")) {
                    arrayList.add(str2);
                } else if (arrayList.size() <= 0 || ((String) arrayList.get(arrayList.size() - 1)).equals("..")) {
                    arrayList.add("..");
                } else {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        String join = Joiner.on('/').join(arrayList);
        if (str.charAt(0) == '/') {
            join = a2.b.a.a.a.c3("/", join);
        }
        while (join.startsWith("/../")) {
            join = join.substring(3);
        }
        if (join.equals("/..")) {
            return "/";
        }
        if ("".equals(join)) {
            return ".";
        }
        return join;
    }

    @Beta
    public static byte[] toByteArray(File file) throws IOException {
        return asByteSource(file).read();
    }

    @Beta
    @Deprecated
    public static String toString(File file, Charset charset) throws IOException {
        return asCharSource(file, charset).read();
    }

    @Beta
    public static void touch(File file) throws IOException {
        Preconditions.checkNotNull(file);
        if (!file.createNewFile() && !file.setLastModified(System.currentTimeMillis())) {
            throw new IOException(a2.b.a.a.a.Y2("Unable to update modification time of ", file));
        }
    }

    @Beta
    public static void write(byte[] bArr, File file) throws IOException {
        asByteSink(file, new FileWriteMode[0]).write(bArr);
    }

    @Beta
    public static void copy(File file, File file2) throws IOException {
        Preconditions.checkArgument(!file.equals(file2), "Source %s and destination %s must be different", file, file2);
        asByteSource(file).copyTo(asByteSink(file2, new FileWriteMode[0]));
    }

    @Beta
    @Deprecated
    public static void write(CharSequence charSequence, File file, Charset charset) throws IOException {
        asCharSink(file, charset, new FileWriteMode[0]).write(charSequence);
    }

    @Beta
    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode) throws IOException {
        return b(file, mapMode, -1);
    }

    @Beta
    @Deprecated
    @CanIgnoreReturnValue
    public static <T> T readLines(File file, Charset charset, LineProcessor<T> lineProcessor) throws IOException {
        return (T) asCharSource(file, charset).readLines(lineProcessor);
    }

    @Beta
    @Deprecated
    public static void copy(File file, Charset charset, Appendable appendable) throws IOException {
        asCharSource(file, charset).copyTo(appendable);
    }

    @Beta
    public static MappedByteBuffer map(File file, FileChannel.MapMode mapMode, long j) throws IOException {
        Preconditions.checkArgument(j >= 0, "size (%s) may not be negative", j);
        return b(file, mapMode, j);
    }
}
