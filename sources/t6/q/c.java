package t6.q;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
public class c extends b {

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ ArrayList a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ArrayList arrayList) {
            super(1);
            this.a = arrayList;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            this.a.add(str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        throw r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void appendBytes(@org.jetbrains.annotations.NotNull java.io.File r2, @org.jetbrains.annotations.NotNull byte[] r3) {
        /*
            java.lang.String r0 = "$this$appendBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r1 = 1
            r0.<init>(r2, r1)
            r0.write(r3)     // Catch:{ all -> 0x001a }
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x001a }
            r2 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            return
        L_0x001a:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001c }
        L_0x001c:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.appendBytes(java.io.File, byte[]):void");
    }

    public static final void appendText(@NotNull File file, @NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(file, "$this$appendText");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        appendBytes(file, bytes);
    }

    public static /* synthetic */ void appendText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        appendText(file, str, charset);
    }

    public static final void forEachBlock(@NotNull File file, @NotNull Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(file, "$this$forEachBlock");
        Intrinsics.checkNotNullParameter(function2, "action");
        forEachBlock(file, 4096, function2);
    }

    public static final void forEachLine(@NotNull File file, @NotNull Charset charset, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(file, "$this$forEachLine");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(function1, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    public static /* synthetic */ void forEachLine$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        forEachLine(file, charset, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a9, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00aa, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        throw r1;
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.io.File r10) {
        /*
            java.lang.String r0 = "$this$readBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r10)
            long r1 = r10.length()     // Catch:{ all -> 0x00a7 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            long r3 = (long) r3
            java.lang.String r5 = "File "
            int r6 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r6 > 0) goto L_0x0085
            int r2 = (int) r1
            byte[] r1 = new byte[r2]
            r3 = 0
            r4 = r2
            r6 = 0
        L_0x001e:
            if (r4 <= 0) goto L_0x002a
            int r7 = r0.read(r1, r6, r4)
            if (r7 >= 0) goto L_0x0027
            goto L_0x002a
        L_0x0027:
            int r4 = r4 - r7
            int r6 = r6 + r7
            goto L_0x001e
        L_0x002a:
            java.lang.String r7 = "java.util.Arrays.copyOf(this, newSize)"
            r8 = 0
            if (r4 <= 0) goto L_0x0037
            byte[] r1 = java.util.Arrays.copyOf(r1, r6)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            goto L_0x0067
        L_0x0037:
            int r4 = r0.read()
            r6 = -1
            if (r4 != r6) goto L_0x003f
            goto L_0x0067
        L_0x003f:
            t6.q.a r6 = new t6.q.a
            r9 = 8193(0x2001, float:1.1481E-41)
            r6.<init>(r9)
            r6.write(r4)
            r4 = 2
            kotlin.io.ByteStreamsKt.copyTo$default(r0, r6, r3, r4, r8)
            int r4 = r6.size()
            int r4 = r4 + r2
            if (r4 < 0) goto L_0x006b
            byte[] r10 = r6.a()
            byte[] r1 = java.util.Arrays.copyOf(r1, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r7)
            int r4 = r6.size()
            byte[] r1 = kotlin.collections.ArraysKt___ArraysJvmKt.copyInto(r10, r1, r2, r3, r4)
        L_0x0067:
            kotlin.io.CloseableKt.closeFinally(r0, r8)
            return r1
        L_0x006b:
            java.lang.OutOfMemoryError r1 = new java.lang.OutOfMemoryError
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r5)
            r2.append(r10)
            java.lang.String r10 = " is too big to fit in memory."
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            r1.<init>(r10)
            throw r1
        L_0x0085:
            java.lang.OutOfMemoryError r3 = new java.lang.OutOfMemoryError
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r5)
            r4.append(r10)
            java.lang.String r10 = " is too big ("
            r4.append(r10)
            r4.append(r1)
            java.lang.String r10 = " bytes) to fit in memory."
            r4.append(r10)
            java.lang.String r10 = r4.toString()
            r3.<init>(r10)
            throw r3
        L_0x00a7:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r10)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.readBytes(java.io.File):byte[]");
    }

    @NotNull
    public static final List<String> readLines(@NotNull File file, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(file, "$this$readLines");
        Intrinsics.checkNotNullParameter(charset, "charset");
        ArrayList arrayList = new ArrayList();
        forEachLine(file, charset, new a(arrayList));
        return arrayList;
    }

    public static /* synthetic */ List readLines$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readLines(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String readText(@org.jetbrains.annotations.NotNull java.io.File r1, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r2) {
        /*
            java.lang.String r0 = "$this$readText"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            java.lang.String r2 = kotlin.io.TextStreamsKt.readText(r1)     // Catch:{ all -> 0x001d }
            r0 = 0
            kotlin.io.CloseableKt.closeFinally(r1, r0)
            return r2
        L_0x001d:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001f }
        L_0x001f:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.readText(java.io.File, java.nio.charset.Charset):java.lang.String");
    }

    public static /* synthetic */ String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return readText(file, charset);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0049, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0057, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005d, code lost:
        throw r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T useLines(@org.jetbrains.annotations.NotNull java.io.File r3, @org.jetbrains.annotations.NotNull java.nio.charset.Charset r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r5) {
        /*
            java.lang.String r0 = "$this$useLines"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r3)
            java.io.InputStreamReader r3 = new java.io.InputStreamReader
            r3.<init>(r0, r4)
            boolean r4 = r3 instanceof java.io.BufferedReader
            if (r4 == 0) goto L_0x0020
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x0028
        L_0x0020:
            java.io.BufferedReader r4 = new java.io.BufferedReader
            r0 = 8192(0x2000, float:1.14794E-41)
            r4.<init>(r3, r0)
            r3 = r4
        L_0x0028:
            r4 = 0
            r0 = 0
            r1 = 1
            kotlin.sequences.Sequence r2 = kotlin.io.TextStreamsKt.lineSequence(r3)     // Catch:{ all -> 0x0047 }
            java.lang.Object r5 = r5.invoke(r2)     // Catch:{ all -> 0x0047 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 == 0) goto L_0x0040
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            goto L_0x0043
        L_0x0040:
            r3.close()
        L_0x0043:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            return r5
        L_0x0047:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0049 }
        L_0x0049:
            r5 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r1)
            boolean r0 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r1, r1, r0)
            if (r0 != 0) goto L_0x0057
            r3.close()     // Catch:{ all -> 0x005a }
            goto L_0x005a
        L_0x0057:
            kotlin.io.CloseableKt.closeFinally(r3, r4)
        L_0x005a:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r1)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.useLines(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x005c, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005f, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0062, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object useLines$default(java.io.File r1, java.nio.charset.Charset r2, kotlin.jvm.functions.Function1 r3, int r4, java.lang.Object r5) {
        /*
            r5 = 1
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0006
            java.nio.charset.Charset r2 = kotlin.text.Charsets.UTF_8
        L_0x0006:
            java.lang.String r4 = "$this$useLines"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r4)
            java.lang.String r4 = "charset"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r4)
            java.lang.String r4 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
            r4 = 8192(0x2000, float:1.14794E-41)
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
            java.io.InputStreamReader r1 = new java.io.InputStreamReader
            r1.<init>(r0, r2)
            boolean r2 = r1 instanceof java.io.BufferedReader
            if (r2 == 0) goto L_0x0028
            java.io.BufferedReader r1 = (java.io.BufferedReader) r1
            goto L_0x002e
        L_0x0028:
            java.io.BufferedReader r2 = new java.io.BufferedReader
            r2.<init>(r1, r4)
            r1 = r2
        L_0x002e:
            r2 = 0
            r4 = 0
            kotlin.sequences.Sequence r0 = kotlin.io.TextStreamsKt.lineSequence(r1)     // Catch:{ all -> 0x004c }
            java.lang.Object r3 = r3.invoke(r0)     // Catch:{ all -> 0x004c }
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r4)
            if (r4 == 0) goto L_0x0045
            kotlin.io.CloseableKt.closeFinally(r1, r2)
            goto L_0x0048
        L_0x0045:
            r1.close()
        L_0x0048:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            return r3
        L_0x004c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x004e }
        L_0x004e:
            r3 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r5)
            boolean r4 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r5, r5, r4)
            if (r4 != 0) goto L_0x005c
            r1.close()     // Catch:{ all -> 0x005f }
            goto L_0x005f
        L_0x005c:
            kotlin.io.CloseableKt.closeFinally(r1, r2)
        L_0x005f:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r5)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.useLines$default(java.io.File, java.nio.charset.Charset, kotlin.jvm.functions.Function1, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001f, code lost:
        throw r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001c, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void writeBytes(@org.jetbrains.annotations.NotNull java.io.File r1, @org.jetbrains.annotations.NotNull byte[] r2) {
        /*
            java.lang.String r0 = "$this$writeBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "array"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.FileOutputStream r0 = new java.io.FileOutputStream
            r0.<init>(r1)
            r0.write(r2)     // Catch:{ all -> 0x0019 }
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0019 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0019:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x001b }
        L_0x001b:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.writeBytes(java.io.File, byte[]):void");
    }

    public static final void writeText(@NotNull File file, @NotNull String str, @NotNull Charset charset) {
        Intrinsics.checkNotNullParameter(file, "$this$writeText");
        Intrinsics.checkNotNullParameter(str, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        byte[] bytes = str.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        writeBytes(file, bytes);
    }

    public static /* synthetic */ void writeText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        writeText(file, str, charset);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: java.io.FileInputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, byte[]] */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
        throw r2;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void forEachBlock(@org.jetbrains.annotations.NotNull java.io.File r1, int r2, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super byte[], ? super java.lang.Integer, kotlin.Unit> r3) {
        /*
            java.lang.String r0 = "$this$forEachBlock"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 512(0x200, float:7.175E-43)
            int r2 = t6.v.e.coerceAtLeast(r2, r0)
            byte[] r2 = new byte[r2]
            java.io.FileInputStream r0 = new java.io.FileInputStream
            r0.<init>(r1)
        L_0x0017:
            int r1 = r0.read(r2)     // Catch:{ all -> 0x002c }
            if (r1 > 0) goto L_0x0024
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x002c }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            return
        L_0x0024:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r3.invoke(r2, r1)
            goto L_0x0017
        L_0x002c:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x002e }
        L_0x002e:
            r2 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: t6.q.c.forEachBlock(java.io.File, int, kotlin.jvm.functions.Function2):void");
    }
}
