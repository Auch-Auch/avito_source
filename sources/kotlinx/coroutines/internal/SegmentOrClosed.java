package kotlinx.coroutines.internal;

import androidx.exifinterface.media.ExifInterface;
import com.avito.android.remote.auth.AuthSource;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Segment;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\b@\u0018\u0000*\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0003B\u0014\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003HÖ\u0003¢\u0006\u0004\b\f\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0015\u001a\u00028\u00008F@\u0006¢\u0006\f\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0017\u001a\u00020\u000b8F@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lkotlinx/coroutines/internal/SegmentOrClosed;", "Lkotlinx/coroutines/internal/Segment;", ExifInterface.LATITUDE_SOUTH, "", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "value", "getSegment-impl", "(Ljava/lang/Object;)Lkotlinx/coroutines/internal/Segment;", "getSegment$annotations", "()V", "segment", "isClosed-impl", "isClosed", "constructor-impl", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
public final class SegmentOrClosed<S extends Segment<S>> {
    public final Object a;

    public /* synthetic */ SegmentOrClosed(@Nullable Object obj) {
        this.a = obj;
    }

    @NotNull
    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ SegmentOrClosed m529boximpl(@Nullable Object obj) {
        return new SegmentOrClosed(obj);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static Object m530constructorimpl(@Nullable Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m531equalsimpl(Object obj, @Nullable Object obj2) {
        return (obj2 instanceof SegmentOrClosed) && Intrinsics.areEqual(obj, ((SegmentOrClosed) obj2).m537unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m532equalsimpl0(@Nullable Object obj, @Nullable Object obj2) {
        return Intrinsics.areEqual(obj, obj2);
    }

    public static /* synthetic */ void getSegment$annotations() {
    }

    @NotNull
    /* renamed from: getSegment-impl  reason: not valid java name */
    public static final S m533getSegmentimpl(Object obj) {
        if (obj != ConcurrentLinkedListKt.access$getCLOSED$p()) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type S");
            return (S) ((Segment) obj);
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m534hashCodeimpl(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m535isClosedimpl(Object obj) {
        return obj == ConcurrentLinkedListKt.access$getCLOSED$p();
    }

    @NotNull
    /* renamed from: toString-impl  reason: not valid java name */
    public static String m536toStringimpl(Object obj) {
        return "SegmentOrClosed(value=" + obj + ")";
    }

    public boolean equals(Object obj) {
        return m531equalsimpl(this.a, obj);
    }

    public int hashCode() {
        return m534hashCodeimpl(this.a);
    }

    public String toString() {
        return m536toStringimpl(this.a);
    }

    @Nullable
    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m537unboximpl() {
        return this.a;
    }
}
