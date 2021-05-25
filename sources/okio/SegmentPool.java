package okio;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\n\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\tH\u0002¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0006XD¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000eR$\u0010\u0016\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t0\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0018\u001a\u00020\f8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0010R\u0016\u0010\u001a\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019¨\u0006\u001d"}, d2 = {"Lokio/SegmentPool;", "", "Lokio/Segment;", "take", "()Lokio/Segment;", "segment", "", "recycle", "(Lokio/Segment;)V", "Ljava/util/concurrent/atomic/AtomicReference;", AuthSource.SEND_ABUSE, "()Ljava/util/concurrent/atomic/AtomicReference;", "", "MAX_SIZE", "I", "getMAX_SIZE", "()I", AuthSource.BOOKING_ORDER, "HASH_BUCKET_COUNT", "", "c", "[Ljava/util/concurrent/atomic/AtomicReference;", "hashBuckets", "getByteCount", DecodeProducer.EXTRA_BITMAP_BYTES, "Lokio/Segment;", "LOCK", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
public final class SegmentPool {
    public static final SegmentPool INSTANCE = new SegmentPool();
    public static final Segment a = new Segment(new byte[0], 0, 0, false, false);
    public static final int b;
    public static final AtomicReference<Segment>[] c;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        b = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i = 0; i < highestOneBit; i++) {
            atomicReferenceArr[i] = new AtomicReference<>();
        }
        c = atomicReferenceArr;
    }

    @JvmStatic
    public static final void recycle(@NotNull Segment segment) {
        AtomicReference<Segment> a3;
        Segment segment2;
        Intrinsics.checkNotNullParameter(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.shared && (segment2 = (a3 = INSTANCE.a()).get()) != a) {
            int i = segment2 != null ? segment2.limit : 0;
            if (i < 65536) {
                segment.next = segment2;
                segment.pos = 0;
                segment.limit = i + 8192;
                if (!a3.compareAndSet(segment2, segment)) {
                    segment.next = null;
                }
            }
        }
    }

    @JvmStatic
    @NotNull
    public static final Segment take() {
        AtomicReference<Segment> a3 = INSTANCE.a();
        Segment segment = a;
        Segment andSet = a3.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            a3.set(null);
            return new Segment();
        }
        a3.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final AtomicReference<Segment> a() {
        Thread currentThread = Thread.currentThread();
        Intrinsics.checkNotNullExpressionValue(currentThread, "Thread.currentThread()");
        return c[(int) (currentThread.getId() & (((long) b) - 1))];
    }

    public final int getByteCount() {
        Segment segment = a().get();
        if (segment != null) {
            return segment.limit;
        }
        return 0;
    }

    public final int getMAX_SIZE() {
        return 65536;
    }
}
