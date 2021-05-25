package kotlin.io;

import com.vk.sdk.api.VKApiConst;
import java.io.BufferedReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\u001a%\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007*\u00020\u0000¢\u0006\u0004\b\b\u0010\t\u001a:\u0010\u000e\u001a\u00028\u0000\"\u0004\b\u0000\u0010\n*\u00020\u00002\u0018\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u000b\u0012\u0004\u0012\u00028\u00000\u0001H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\u00020\u0010¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0011\u0010\u0013\u001a\u00020\u0002*\u00020\u0000¢\u0006\u0004\b\u0013\u0010\u0014\u001a#\u0010\u001a\u001a\u00020\u0019*\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0011\u0010\u001e\u001a\u00020\u001d*\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001f\u0002\u000f\n\u0006\b\u0011(\r0\u0001\n\u0005\b20\u0001¨\u0006 "}, d2 = {"Ljava/io/Reader;", "Lkotlin/Function1;", "", "", "action", "forEachLine", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)V", "", "readLines", "(Ljava/io/Reader;)Ljava/util/List;", "T", "Lkotlin/sequences/Sequence;", "block", "Requires newer compiler version to be inlined correctly.", "useLines", "(Ljava/io/Reader;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Ljava/io/BufferedReader;", "lineSequence", "(Ljava/io/BufferedReader;)Lkotlin/sequences/Sequence;", "readText", "(Ljava/io/Reader;)Ljava/lang/String;", "Ljava/io/Writer;", VKApiConst.OUT, "", "bufferSize", "", "copyTo", "(Ljava/io/Reader;Ljava/io/Writer;I)J", "Ljava/net/URL;", "", "readBytes", "(Ljava/net/URL;)[B", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "TextStreamsKt")
public final class TextStreamsKt {

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

    public static final long copyTo(@NotNull Reader reader, @NotNull Writer writer, int i) {
        Intrinsics.checkNotNullParameter(reader, "$this$copyTo");
        Intrinsics.checkNotNullParameter(writer, VKApiConst.OUT);
        char[] cArr = new char[i];
        int read = reader.read(cArr);
        long j = 0;
        while (read >= 0) {
            writer.write(cArr, 0, read);
            j += (long) read;
            read = reader.read(cArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(Reader reader, Writer writer, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(reader, writer, i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0036, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
        kotlin.io.CloseableKt.closeFinally(r3, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003a, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void forEachLine(@org.jetbrains.annotations.NotNull java.io.Reader r3, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r4) {
        /*
            java.lang.String r0 = "$this$forEachLine"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "action"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            boolean r0 = r3 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r3, r1)
            r3 = r0
        L_0x0019:
            r0 = 0
            kotlin.sequences.Sequence r1 = lineSequence(r3)     // Catch:{ all -> 0x0034 }
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x0034 }
        L_0x0022:
            boolean r2 = r1.hasNext()     // Catch:{ all -> 0x0034 }
            if (r2 == 0) goto L_0x0030
            java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x0034 }
            r4.invoke(r2)     // Catch:{ all -> 0x0034 }
            goto L_0x0022
        L_0x0030:
            kotlin.io.CloseableKt.closeFinally(r3, r0)
            return
        L_0x0034:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0036 }
        L_0x0036:
            r0 = move-exception
            kotlin.io.CloseableKt.closeFinally(r3, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.forEachLine(java.io.Reader, kotlin.jvm.functions.Function1):void");
    }

    @NotNull
    public static final Sequence<String> lineSequence(@NotNull BufferedReader bufferedReader) {
        Intrinsics.checkNotNullParameter(bufferedReader, "$this$lineSequence");
        return SequencesKt__SequencesKt.constrainOnce(new LinesSequence(bufferedReader));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
        kotlin.io.CloseableKt.closeFinally(r2, r0);
     */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final byte[] readBytes(@org.jetbrains.annotations.NotNull java.net.URL r2) {
        /*
            java.lang.String r0 = "$this$readBytes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.io.InputStream r2 = r2.openStream()
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)     // Catch:{ all -> 0x0017 }
            byte[] r0 = kotlin.io.ByteStreamsKt.readBytes(r2)     // Catch:{ all -> 0x0017 }
            r1 = 0
            kotlin.io.CloseableKt.closeFinally(r2, r1)
            return r0
        L_0x0017:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0019 }
        L_0x0019:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.readBytes(java.net.URL):byte[]");
    }

    @NotNull
    public static final List<String> readLines(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "$this$readLines");
        ArrayList arrayList = new ArrayList();
        forEachLine(reader, new a(arrayList));
        return arrayList;
    }

    @NotNull
    public static final String readText(@NotNull Reader reader) {
        Intrinsics.checkNotNullParameter(reader, "$this$readText");
        StringWriter stringWriter = new StringWriter();
        copyTo$default(reader, stringWriter, 0, 2, null);
        String stringWriter2 = stringWriter.toString();
        Intrinsics.checkNotNullExpressionValue(stringWriter2, "buffer.toString()");
        return stringWriter2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003a, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        kotlin.jvm.internal.InlineMarker.finallyStart(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0) == false) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r4.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0048, code lost:
        kotlin.io.CloseableKt.closeFinally(r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004b, code lost:
        kotlin.jvm.internal.InlineMarker.finallyEnd(1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> T useLines(@org.jetbrains.annotations.NotNull java.io.Reader r4, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super kotlin.sequences.Sequence<java.lang.String>, ? extends T> r5) {
        /*
            java.lang.String r0 = "$this$useLines"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            boolean r0 = r4 instanceof java.io.BufferedReader
            if (r0 == 0) goto L_0x0011
            java.io.BufferedReader r4 = (java.io.BufferedReader) r4
            goto L_0x0019
        L_0x0011:
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r1 = 8192(0x2000, float:1.14794E-41)
            r0.<init>(r4, r1)
            r4 = r0
        L_0x0019:
            r0 = 0
            r1 = 0
            r2 = 1
            kotlin.sequences.Sequence r3 = lineSequence(r4)     // Catch:{ all -> 0x0038 }
            java.lang.Object r5 = r5.invoke(r3)     // Catch:{ all -> 0x0038 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r2, r2, r1)
            if (r1 == 0) goto L_0x0031
            kotlin.io.CloseableKt.closeFinally(r4, r0)
            goto L_0x0034
        L_0x0031:
            r4.close()
        L_0x0034:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            return r5
        L_0x0038:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x003a }
        L_0x003a:
            r0 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r2)
            boolean r1 = kotlin.internal.PlatformImplementationsKt.apiVersionIsAtLeast(r2, r2, r1)
            if (r1 != 0) goto L_0x0048
            r4.close()     // Catch:{ all -> 0x004b }
            goto L_0x004b
        L_0x0048:
            kotlin.io.CloseableKt.closeFinally(r4, r5)
        L_0x004b:
            kotlin.jvm.internal.InlineMarker.finallyEnd(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.io.TextStreamsKt.useLines(java.io.Reader, kotlin.jvm.functions.Function1):java.lang.Object");
    }
}
