package okio;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b$\u0010%J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lokio/PeekSource;", "Lokio/Source;", "Lokio/Buffer;", "sink", "", DecodeProducer.EXTRA_BITMAP_BYTES, "read", "(Lokio/Buffer;J)J", "Lokio/Timeout;", "timeout", "()Lokio/Timeout;", "", "close", "()V", "Lokio/Segment;", AuthSource.BOOKING_ORDER, "Lokio/Segment;", "expectedSegment", "", "c", "I", "expectedPos", "e", "J", "pos", AuthSource.SEND_ABUSE, "Lokio/Buffer;", "buffer", "Lokio/BufferedSource;", "f", "Lokio/BufferedSource;", "upstream", "", "d", "Z", "closed", "<init>", "(Lokio/BufferedSource;)V", "okio"}, k = 1, mv = {1, 4, 0})
public final class PeekSource implements Source {
    public final Buffer a;
    public Segment b;
    public int c;
    public boolean d;
    public long e;
    public final BufferedSource f;

    public PeekSource(@NotNull BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "upstream");
        this.f = bufferedSource;
        Buffer buffer = bufferedSource.getBuffer();
        this.a = buffer;
        Segment segment = buffer.head;
        this.b = segment;
        this.c = segment != null ? segment.pos : -1;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.d = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r4 == r5.pos) goto L_0x002a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x006f  */
    @Override // okio.Source
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long read(@org.jetbrains.annotations.NotNull okio.Buffer r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = 0
            r1 = 0
            int r3 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r3 < 0) goto L_0x000e
            r4 = 1
            goto L_0x000f
        L_0x000e:
            r4 = 0
        L_0x000f:
            if (r4 == 0) goto L_0x0087
            boolean r4 = r8.d
            r4 = r4 ^ 1
            if (r4 == 0) goto L_0x007b
            okio.Segment r4 = r8.b
            if (r4 == 0) goto L_0x002a
            okio.Buffer r5 = r8.a
            okio.Segment r5 = r5.head
            if (r4 != r5) goto L_0x002b
            int r4 = r8.c
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.pos
            if (r4 != r5) goto L_0x002b
        L_0x002a:
            r0 = 1
        L_0x002b:
            if (r0 == 0) goto L_0x006f
            if (r3 != 0) goto L_0x0030
            return r1
        L_0x0030:
            okio.BufferedSource r0 = r8.f
            long r1 = r8.e
            r3 = 1
            long r1 = r1 + r3
            boolean r0 = r0.request(r1)
            if (r0 != 0) goto L_0x0040
            r9 = -1
            return r9
        L_0x0040:
            okio.Segment r0 = r8.b
            if (r0 != 0) goto L_0x0053
            okio.Buffer r0 = r8.a
            okio.Segment r0 = r0.head
            if (r0 == 0) goto L_0x0053
            r8.b = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            int r0 = r0.pos
            r8.c = r0
        L_0x0053:
            okio.Buffer r0 = r8.a
            long r0 = r0.size()
            long r2 = r8.e
            long r0 = r0 - r2
            long r10 = java.lang.Math.min(r10, r0)
            okio.Buffer r2 = r8.a
            long r4 = r8.e
            r3 = r9
            r6 = r10
            r2.copyTo(r3, r4, r6)
            long r0 = r8.e
            long r0 = r0 + r10
            r8.e = r0
            return r10
        L_0x006f:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x007b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L_0x0087:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = a2.b.a.a.a.T2(r9, r10)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.PeekSource.read(okio.Buffer, long):long");
    }

    @Override // okio.Source
    @NotNull
    public Timeout timeout() {
        return this.f.timeout();
    }
}
