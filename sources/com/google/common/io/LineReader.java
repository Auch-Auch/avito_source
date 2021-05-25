package com.google.common.io;

import a2.j.d.h.g;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Reader;
import java.nio.CharBuffer;
import java.util.LinkedList;
import java.util.Queue;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
@Beta
@GwtIncompatible
public final class LineReader {
    public final Readable a;
    @NullableDecl
    public final Reader b;
    public final CharBuffer c;
    public final char[] d;
    public final Queue<String> e = new LinkedList();
    public final g f = new a();

    public class a extends g {
        public a() {
        }
    }

    public LineReader(Readable readable) {
        CharBuffer b2 = CharStreams.b();
        this.c = b2;
        this.d = b2.array();
        this.a = (Readable) Preconditions.checkNotNull(readable);
        this.b = readable instanceof Reader ? (Reader) readable : null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0057  */
    @com.google.errorprone.annotations.CanIgnoreReturnValue
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String readLine() throws java.io.IOException {
        /*
            r10 = this;
        L_0x0000:
            java.util.Queue<java.lang.String> r0 = r10.e
            java.lang.Object r0 = r0.peek()
            if (r0 != 0) goto L_0x0091
            java.nio.CharBuffer r0 = r10.c
            r0.clear()
            java.io.Reader r0 = r10.b
            r1 = 0
            if (r0 == 0) goto L_0x001a
            char[] r2 = r10.d
            int r3 = r2.length
            int r0 = r0.read(r2, r1, r3)
            goto L_0x0022
        L_0x001a:
            java.lang.Readable r0 = r10.a
            java.nio.CharBuffer r2 = r10.c
            int r0 = r0.read(r2)
        L_0x0022:
            r2 = -1
            if (r0 != r2) goto L_0x0037
            a2.j.d.h.g r0 = r10.f
            boolean r2 = r0.b
            if (r2 != 0) goto L_0x0033
            java.lang.StringBuilder r2 = r0.a
            int r2 = r2.length()
            if (r2 <= 0) goto L_0x0091
        L_0x0033:
            r0.a(r1)
            goto L_0x0091
        L_0x0037:
            a2.j.d.h.g r2 = r10.f
            char[] r3 = r10.d
            boolean r4 = r2.b
            r5 = 10
            r6 = 1
            if (r4 == 0) goto L_0x0052
            if (r0 <= 0) goto L_0x0052
            char r4 = r3[r1]
            if (r4 != r5) goto L_0x004a
            r4 = 1
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            r2.a(r4)
            if (r4 == 0) goto L_0x0052
            r4 = 1
            goto L_0x0053
        L_0x0052:
            r4 = 0
        L_0x0053:
            int r0 = r0 + r1
            r7 = r4
        L_0x0055:
            if (r4 >= r0) goto L_0x0089
            char r8 = r3[r4]
            if (r8 == r5) goto L_0x007b
            r9 = 13
            if (r8 == r9) goto L_0x0060
            goto L_0x0087
        L_0x0060:
            java.lang.StringBuilder r8 = r2.a
            int r9 = r4 - r7
            r8.append(r3, r7, r9)
            r2.b = r6
            int r7 = r4 + 1
            if (r7 >= r0) goto L_0x0085
            char r8 = r3[r7]
            if (r8 != r5) goto L_0x0073
            r8 = 1
            goto L_0x0074
        L_0x0073:
            r8 = 0
        L_0x0074:
            r2.a(r8)
            if (r8 == 0) goto L_0x0085
            r4 = r7
            goto L_0x0085
        L_0x007b:
            java.lang.StringBuilder r8 = r2.a
            int r9 = r4 - r7
            r8.append(r3, r7, r9)
            r2.a(r6)
        L_0x0085:
            int r7 = r4 + 1
        L_0x0087:
            int r4 = r4 + r6
            goto L_0x0055
        L_0x0089:
            java.lang.StringBuilder r1 = r2.a
            int r0 = r0 - r7
            r1.append(r3, r7, r0)
            goto L_0x0000
        L_0x0091:
            java.util.Queue<java.lang.String> r0 = r10.e
            java.lang.Object r0 = r0.poll()
            java.lang.String r0 = (java.lang.String) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.io.LineReader.readLine():java.lang.String");
    }
}
