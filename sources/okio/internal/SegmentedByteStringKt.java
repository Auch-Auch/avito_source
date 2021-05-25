package okio.internal;

import a2.b.a.a.a;
import com.facebook.imagepipeline.producers.DecodeProducer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000T\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\u001a+\u0010\u0005\u001a\u00020\u0001*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u001b\u0010\t\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\t\u0010\n\u001ad\u0010\u0014\u001a\u00020\u0012*\u00020\u00072K\u0010\u0013\u001aG\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00120\u000bH\bø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015\u001a$\u0010\u0019\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0001H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u001c\u0010\u001c\u001a\u00020\u001b*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u00020\u0001*\u00020\u0007H\b¢\u0006\u0004\b\u001e\u0010\u001f\u001a\u0014\u0010 \u001a\u00020\f*\u00020\u0007H\b¢\u0006\u0004\b \u0010!\u001a,\u0010$\u001a\u00020\u0012*\u00020\u00072\u0006\u0010#\u001a\u00020\"2\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b$\u0010%\u001a4\u0010)\u001a\u00020(*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u00182\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b)\u0010*\u001a4\u0010)\u001a\u00020(*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u0001H\b¢\u0006\u0004\b)\u0010+\u001a\u001e\u0010-\u001a\u00020(*\u00020\u00072\b\u0010&\u001a\u0004\u0018\u00010,H\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u0010/\u001a\u00020\u0001*\u00020\u0007H\b¢\u0006\u0004\b/\u0010\u001f\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"", "", "value", "fromIndex", "toIndex", "binarySearch", "([IIII)I", "Lokio/SegmentedByteString;", "pos", "segment", "(Lokio/SegmentedByteString;I)I", "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "data", "offset", DecodeProducer.EXTRA_BITMAP_BYTES, "", "action", "forEachSegment", "(Lokio/SegmentedByteString;Lkotlin/jvm/functions/Function3;)V", "beginIndex", "endIndex", "Lokio/ByteString;", "commonSubstring", "(Lokio/SegmentedByteString;II)Lokio/ByteString;", "", "commonInternalGet", "(Lokio/SegmentedByteString;I)B", "commonGetSize", "(Lokio/SegmentedByteString;)I", "commonToByteArray", "(Lokio/SegmentedByteString;)[B", "Lokio/Buffer;", "buffer", "commonWrite", "(Lokio/SegmentedByteString;Lokio/Buffer;II)V", "other", "otherOffset", "", "commonRangeEquals", "(Lokio/SegmentedByteString;ILokio/ByteString;II)Z", "(Lokio/SegmentedByteString;I[BII)Z", "", "commonEquals", "(Lokio/SegmentedByteString;Ljava/lang/Object;)Z", "commonHashCode", "okio"}, k = 2, mv = {1, 4, 0})
public final class SegmentedByteStringKt {
    public static final void access$forEachSegment(SegmentedByteString segmentedByteString, int i, int i2, Function3 function3) {
        int i3;
        int segment = segment(segmentedByteString, i);
        while (i < i2) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i4 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i2, (segmentedByteString.getDirectory$okio()[segment] - i3) + i3) - i;
            function3.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf((i - i3) + i4), Integer.valueOf(min));
            i += min;
            segment++;
        }
    }

    public static final int binarySearch(@NotNull int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "$this$binarySearch");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else if (i6 <= i) {
                return i5;
            } else {
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final boolean commonEquals(@NotNull SegmentedByteString segmentedByteString, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 1;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            byte[] bArr = segmentedByteString.getSegments$okio()[i];
            int i6 = (i5 - i2) + i4;
            while (i4 < i6) {
                i3 = (i3 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i2 = i5;
        }
        segmentedByteString.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@NotNull SegmentedByteString segmentedByteString, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount((long) segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], (long) i, 1);
        int segment = segment(segmentedByteString, i);
        if (segment == 0) {
            i2 = 0;
        } else {
            i2 = segmentedByteString.getDirectory$okio()[segment - 1];
        }
        return segmentedByteString.getSegments$okio()[segment][(i - i2) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i, @NotNull ByteString byteString, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString, "other");
        if (i < 0 || i > segmentedByteString.size() - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = segment(segmentedByteString, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, (segmentedByteString.getDirectory$okio()[segment] - i4) + i4) - i;
            if (!byteString.rangeEquals(i2, segmentedByteString.getSegments$okio()[segment], (i - i4) + i6, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }

    @NotNull
    public static final ByteString commonSubstring(@NotNull SegmentedByteString segmentedByteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonSubstring");
        int i3 = 0;
        if (i >= 0) {
            if (i2 <= segmentedByteString.size()) {
                int i4 = i2 - i;
                if (!(i4 >= 0)) {
                    throw new IllegalArgumentException(a.R2("endIndex=", i2, " < beginIndex=", i).toString());
                } else if (i == 0 && i2 == segmentedByteString.size()) {
                    return segmentedByteString;
                } else {
                    if (i == i2) {
                        return ByteString.EMPTY;
                    }
                    int segment = segment(segmentedByteString, i);
                    int segment2 = segment(segmentedByteString, i2 - 1);
                    byte[][] bArr = (byte[][]) ArraysKt___ArraysJvmKt.copyOfRange(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
                    int[] iArr = new int[(bArr.length * 2)];
                    if (segment <= segment2) {
                        int i5 = 0;
                        int i6 = segment;
                        while (true) {
                            iArr[i5] = Math.min(segmentedByteString.getDirectory$okio()[i6] - i, i4);
                            int i7 = i5 + 1;
                            iArr[i5 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i6];
                            if (i6 == segment2) {
                                break;
                            }
                            i6++;
                            i5 = i7;
                        }
                    }
                    if (segment != 0) {
                        i3 = segmentedByteString.getDirectory$okio()[segment - 1];
                    }
                    int length = bArr.length;
                    iArr[length] = (i - i3) + iArr[length];
                    return new SegmentedByteString(bArr, iArr);
                }
            } else {
                StringBuilder M = a.M("endIndex=", i2, " > length(");
                M.append(segmentedByteString.size());
                M.append(')');
                throw new IllegalArgumentException(M.toString().toString());
            }
        } else {
            throw new IllegalArgumentException(a.Q2("beginIndex=", i, " < 0").toString());
        }
    }

    @NotNull
    public static final byte[] commonToByteArray(@NotNull SegmentedByteString segmentedByteString) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i];
            int i5 = segmentedByteString.getDirectory$okio()[i];
            int i6 = i5 - i2;
            ArraysKt___ArraysJvmKt.copyInto(segmentedByteString.getSegments$okio()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(@NotNull SegmentedByteString segmentedByteString, @NotNull Buffer buffer, int i, int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i4 = i2 + i;
        int segment = segment(segmentedByteString, i);
        while (i < i4) {
            if (segment == 0) {
                i3 = 0;
            } else {
                i3 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i5 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, (segmentedByteString.getDirectory$okio()[segment] - i3) + i3) - i;
            int i6 = (i - i3) + i5;
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i6, i6 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2;
                buffer.head = segment2;
            } else {
                Intrinsics.checkNotNull(segment3);
                Segment segment4 = segment3.prev;
                Intrinsics.checkNotNull(segment4);
                segment4.push(segment2);
            }
            i += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + ((long) segmentedByteString.size()));
    }

    public static final void forEachSegment(@NotNull SegmentedByteString segmentedByteString, @NotNull Function3<? super byte[], ? super Integer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$forEachSegment");
        Intrinsics.checkNotNullParameter(function3, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = segmentedByteString.getDirectory$okio()[length + i];
            int i4 = segmentedByteString.getDirectory$okio()[i];
            function3.invoke(segmentedByteString.getSegments$okio()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    public static final int segment(@NotNull SegmentedByteString segmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$segment");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i + 1, 0, segmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    public static final boolean commonRangeEquals(@NotNull SegmentedByteString segmentedByteString, int i, @NotNull byte[] bArr, int i2, int i3) {
        int i4;
        Intrinsics.checkNotNullParameter(segmentedByteString, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(bArr, "other");
        if (i < 0 || i > segmentedByteString.size() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i5 = i3 + i;
        int segment = segment(segmentedByteString, i);
        while (i < i5) {
            if (segment == 0) {
                i4 = 0;
            } else {
                i4 = segmentedByteString.getDirectory$okio()[segment - 1];
            }
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, (segmentedByteString.getDirectory$okio()[segment] - i4) + i4) - i;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], (i - i4) + i6, bArr, i2, min)) {
                return false;
            }
            i2 += min;
            i += min;
            segment++;
        }
        return true;
    }
}
