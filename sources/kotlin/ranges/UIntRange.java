package kotlin.ranges;

import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UInt;
import kotlin.UnsignedKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@SinceKotlin(version = "1.3")
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u0000 \u001b2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u001bB\u001a\u0012\u0006\u0010\u0018\u001a\u00020\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00038V@\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0011R\u001c\u0010\u0018\u001a\u00020\u00038V@\u0016X\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0011ø\u0001\u0000\u0002\b\n\u0002\b\u0019\n\u0002\b!¨\u0006\u001c"}, d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "value", "", "contains-WZ4Q5Ns", "(I)Z", "contains", "isEmpty", "()Z", "", "other", "equals", "(Ljava/lang/Object;)Z", "", "hashCode", "()I", "", "toString", "()Ljava/lang/String;", "getEndInclusive-pVg5ArA", "endInclusive", "getStart-pVg5ArA", Tracker.Events.CREATIVE_START, "<init>", "(IILt6/r/a/j;)V", "Companion", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
@ExperimentalUnsignedTypes
public final class UIntRange extends UIntProgression implements ClosedRange<UInt> {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final UIntRange d = new UIntRange(-1, 0, null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lkotlin/ranges/UIntRange$Companion;", "", "Lkotlin/ranges/UIntRange;", "EMPTY", "Lkotlin/ranges/UIntRange;", "getEMPTY", "()Lkotlin/ranges/UIntRange;", "<init>", "()V", "kotlin-stdlib"}, k = 1, mv = {1, 4, 1})
    public static final class Companion {
        public Companion() {
        }

        @NotNull
        public final UIntRange getEMPTY() {
            return UIntRange.d;
        }

        public Companion(j jVar) {
        }
    }

    public UIntRange(int i, int i2, j jVar) {
        super(i, i2, 1, null);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Comparable] */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ boolean contains(UInt uInt) {
        return m413containsWZ4Q5Ns(uInt.m282unboximpl());
    }

    /* renamed from: contains-WZ4Q5Ns  reason: not valid java name */
    public boolean m413containsWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(m410getFirstpVg5ArA(), i) <= 0 && UnsignedKt.uintCompare(i, m411getLastpVg5ArA()) <= 0;
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof UIntRange) {
            if (!isEmpty() || !((UIntRange) obj).isEmpty()) {
                UIntRange uIntRange = (UIntRange) obj;
                if (!(m410getFirstpVg5ArA() == uIntRange.m410getFirstpVg5ArA() && m411getLastpVg5ArA() == uIntRange.m411getLastpVg5ArA())) {
                }
            }
            return true;
        }
        return false;
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getEndInclusive() {
        return UInt.m276boximpl(m414getEndInclusivepVg5ArA());
    }

    /* renamed from: getEndInclusive-pVg5ArA  reason: not valid java name */
    public int m414getEndInclusivepVg5ArA() {
        return m411getLastpVg5ArA();
    }

    /* Return type fixed from 'java.lang.Comparable' to match base method */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ /* synthetic */ UInt getStart() {
        return UInt.m276boximpl(m415getStartpVg5ArA());
    }

    /* renamed from: getStart-pVg5ArA  reason: not valid java name */
    public int m415getStartpVg5ArA() {
        return m410getFirstpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m410getFirstpVg5ArA() * 31) + m411getLastpVg5ArA();
    }

    @Override // kotlin.ranges.UIntProgression, kotlin.ranges.ClosedRange
    public boolean isEmpty() {
        return UnsignedKt.uintCompare(m410getFirstpVg5ArA(), m411getLastpVg5ArA()) > 0;
    }

    @Override // kotlin.ranges.UIntProgression, java.lang.Object
    @NotNull
    public String toString() {
        return UInt.m281toStringimpl(m410getFirstpVg5ArA()) + ".." + UInt.m281toStringimpl(m411getLastpVg5ArA());
    }
}
