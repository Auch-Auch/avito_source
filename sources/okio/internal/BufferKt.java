package okio.internal;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.preferences.db_preferences.Types;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.common.base.Ascii;
import com.vk.sdk.api.VKApiConst;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysJvmKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import okhttp3.internal.connection.RealConnection;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.asn1.cmc.BodyPartID;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0013\u001a7\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\t\u0010\n\u001a\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u001aA\u0010\u0015\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0011*\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\f2\u001a\u0010\u0014\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0000\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00028\u00000\u0013H\bø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016\u001a%\u0010\u001a\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00172\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a,\u0010\u001f\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b\u001f\u0010 \u001a\u0014\u0010!\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\b!\u0010\"\u001a\u0014\u0010$\u001a\u00020#*\u00020\u000bH\b¢\u0006\u0004\b$\u0010%\u001a\u0014\u0010'\u001a\u00020&*\u00020\u000bH\b¢\u0006\u0004\b'\u0010(\u001a\u0014\u0010)\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\b)\u0010*\u001a\u0014\u0010+\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\b+\u0010\"\u001a\u001c\u0010-\u001a\u00020#*\u00020\u000b2\u0006\u0010,\u001a\u00020\fH\b¢\u0006\u0004\b-\u0010.\u001a\u0014\u00100\u001a\u00020/*\u00020\u000bH\b¢\u0006\u0004\b0\u00101\u001a\u001c\u00102\u001a\u00020/*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b2\u00103\u001a0\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u00105\u001a\u0002042\b\b\u0002\u0010\u001d\u001a\u00020\u00022\b\b\u0002\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\b6\u00107\u001a\u001c\u00109\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\b9\u0010:\u001a\u001c\u0010;\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\b;\u0010:\u001a\u001c\u0010=\u001a\u00020\u0000*\u00020\u000b2\u0006\u0010<\u001a\u00020\u0002H\b¢\u0006\u0004\b=\u0010>\u001a\u001c\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u0004H\b¢\u0006\u0004\b6\u0010@\u001a,\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\b6\u0010A\u001a\u0014\u0010B\u001a\u00020\u0004*\u00020\u000bH\b¢\u0006\u0004\bB\u0010C\u001a\u001c\u0010B\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bB\u0010D\u001a\u001c\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\b¢\u0006\u0004\bF\u0010G\u001a\u001c\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u0004H\b¢\u0006\u0004\bH\u0010I\u001a,\u0010F\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\bF\u0010J\u001a\u0014\u0010K\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\bK\u0010\"\u001a\u0014\u0010L\u001a\u00020\f*\u00020\u000bH\b¢\u0006\u0004\bL\u0010\"\u001a\u0014\u0010M\u001a\u000204*\u00020\u000bH\b¢\u0006\u0004\bM\u0010N\u001a\u001c\u0010M\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bM\u0010O\u001a\u001c\u0010P\u001a\u00020\u0002*\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u0017H\b¢\u0006\u0004\bP\u0010Q\u001a$\u0010H\u001a\u00020/*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bH\u0010R\u001a\u001c\u0010T\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020SH\b¢\u0006\u0004\bT\u0010U\u001a\u001c\u0010V\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bV\u0010\u0010\u001a\u0016\u0010W\u001a\u0004\u0018\u00010\u000e*\u00020\u000bH\b¢\u0006\u0004\bW\u0010X\u001a\u001c\u0010Z\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010Y\u001a\u00020\fH\b¢\u0006\u0004\bZ\u0010\u0010\u001a\u0014\u0010[\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\b[\u0010*\u001a,\u0010_\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010\\\u001a\u00020\u000e2\u0006\u0010]\u001a\u00020\u00022\u0006\u0010^\u001a\u00020\u0002H\b¢\u0006\u0004\b_\u0010`\u001a\u001c\u0010b\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010a\u001a\u00020\u0002H\b¢\u0006\u0004\bb\u0010c\u001a\u001c\u0010e\u001a\u00020\f*\u00020\u000b2\u0006\u0010?\u001a\u00020dH\b¢\u0006\u0004\be\u0010f\u001a$\u00106\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010?\u001a\u00020d2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b6\u0010g\u001a\u001c\u0010i\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010h\u001a\u00020\u0002H\b¢\u0006\u0004\bi\u0010c\u001a\u001c\u0010k\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010j\u001a\u00020\u0002H\b¢\u0006\u0004\bk\u0010c\u001a\u001c\u0010m\u001a\u00020\u000b*\u00020\u000b2\u0006\u0010l\u001a\u00020\u0002H\b¢\u0006\u0004\bm\u0010c\u001a\u001c\u0010n\u001a\u00020\u000b*\u00020\u000b2\u0006\u00108\u001a\u00020\fH\b¢\u0006\u0004\bn\u0010:\u001a$\u00106\u001a\u00020/*\u00020\u000b2\u0006\u0010?\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\b6\u0010R\u001a$\u0010F\u001a\u00020\f*\u00020\u000b2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\fH\b¢\u0006\u0004\bF\u0010o\u001a,\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010h\u001a\u00020#2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010p\u001a\u00020\fH\b¢\u0006\u0004\bq\u0010r\u001a$\u0010q\u001a\u00020\f*\u00020\u000b2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\b¢\u0006\u0004\bq\u0010s\u001a$\u0010u\u001a\u00020\f*\u00020\u000b2\u0006\u0010t\u001a\u0002042\u0006\u0010\u0012\u001a\u00020\fH\b¢\u0006\u0004\bu\u0010s\u001a4\u0010v\u001a\u00020\b*\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u0002042\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0004\bv\u0010w\u001a\u001e\u0010z\u001a\u00020\b*\u00020\u000b2\b\u0010y\u001a\u0004\u0018\u00010xH\b¢\u0006\u0004\bz\u0010{\u001a\u0014\u0010|\u001a\u00020\u0002*\u00020\u000bH\b¢\u0006\u0004\b|\u0010*\u001a\u0014\u0010}\u001a\u00020\u000b*\u00020\u000bH\b¢\u0006\u0004\b}\u0010~\u001a\u0014\u0010\u001a\u000204*\u00020\u000bH\b¢\u0006\u0004\b\u0010N\u001a\u001d\u0010\u001a\u000204*\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u0002H\b¢\u0006\u0005\b\u0010\u0001\"\u0019\u0010\u0001\u001a\u00020\f8\u0000@\u0000XT¢\u0006\b\n\u0006\b\u0001\u0010\u0001\"!\u0010\u0001\u001a\u00020\u00048\u0000@\u0000X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00020\f8\u0000@\u0000XT¢\u0006\b\n\u0006\b\u0001\u0010\u0001\"\u0019\u0010\u0001\u001a\u00020\u00028\u0000@\u0000XT¢\u0006\b\n\u0006\b\u0001\u0010\u0001\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Lokio/Segment;", "segment", "", "segmentPos", "", "bytes", "bytesOffset", "bytesLimit", "", "rangeEquals", "(Lokio/Segment;I[BII)Z", "Lokio/Buffer;", "", "newline", "", "readUtf8Line", "(Lokio/Buffer;J)Ljava/lang/String;", "T", "fromIndex", "Lkotlin/Function2;", "lambda", "seek", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "Lokio/Options;", "options", "selectTruncated", "selectPrefix", "(Lokio/Buffer;Lokio/Options;Z)I", VKApiConst.OUT, "offset", DecodeProducer.EXTRA_BITMAP_BYTES, "commonCopyTo", "(Lokio/Buffer;Lokio/Buffer;JJ)Lokio/Buffer;", "commonCompleteSegmentByteCount", "(Lokio/Buffer;)J", "", "commonReadByte", "(Lokio/Buffer;)B", "", "commonReadShort", "(Lokio/Buffer;)S", "commonReadInt", "(Lokio/Buffer;)I", "commonReadLong", "pos", "commonGet", "(Lokio/Buffer;J)B", "", "commonClear", "(Lokio/Buffer;)V", "commonSkip", "(Lokio/Buffer;J)V", "Lokio/ByteString;", "byteString", "commonWrite", "(Lokio/Buffer;Lokio/ByteString;II)Lokio/Buffer;", VKApiConst.VERSION, "commonWriteDecimalLong", "(Lokio/Buffer;J)Lokio/Buffer;", "commonWriteHexadecimalUnsignedLong", "minimumCapacity", "commonWritableSegment", "(Lokio/Buffer;I)Lokio/Segment;", "source", "(Lokio/Buffer;[B)Lokio/Buffer;", "(Lokio/Buffer;[BII)Lokio/Buffer;", "commonReadByteArray", "(Lokio/Buffer;)[B", "(Lokio/Buffer;J)[B", "sink", "commonRead", "(Lokio/Buffer;[B)I", "commonReadFully", "(Lokio/Buffer;[B)V", "(Lokio/Buffer;[BII)I", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonReadByteString", "(Lokio/Buffer;)Lokio/ByteString;", "(Lokio/Buffer;J)Lokio/ByteString;", "commonSelect", "(Lokio/Buffer;Lokio/Options;)I", "(Lokio/Buffer;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/Buffer;Lokio/Sink;)J", "commonReadUtf8", "commonReadUtf8Line", "(Lokio/Buffer;)Ljava/lang/String;", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", Types.STRING, "beginIndex", "endIndex", "commonWriteUtf8", "(Lokio/Buffer;Ljava/lang/String;II)Lokio/Buffer;", "codePoint", "commonWriteUtf8CodePoint", "(Lokio/Buffer;I)Lokio/Buffer;", "Lokio/Source;", "commonWriteAll", "(Lokio/Buffer;Lokio/Source;)J", "(Lokio/Buffer;Lokio/Source;J)Lokio/Buffer;", AuthSource.BOOKING_ORDER, "commonWriteByte", "s", "commonWriteShort", "i", "commonWriteInt", "commonWriteLong", "(Lokio/Buffer;Lokio/Buffer;J)J", "toIndex", "commonIndexOf", "(Lokio/Buffer;BJJ)J", "(Lokio/Buffer;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "commonRangeEquals", "(Lokio/Buffer;JLokio/ByteString;II)Z", "", "other", "commonEquals", "(Lokio/Buffer;Ljava/lang/Object;)Z", "commonHashCode", "commonCopy", "(Lokio/Buffer;)Lokio/Buffer;", "commonSnapshot", "(Lokio/Buffer;I)Lokio/ByteString;", "OVERFLOW_ZONE", "J", AuthSource.SEND_ABUSE, "[B", "getHEX_DIGIT_BYTES", "()[B", "HEX_DIGIT_BYTES", "OVERFLOW_DIGIT_START", "SEGMENTING_THRESHOLD", "I", "okio"}, k = 2, mv = {1, 4, 0})
public final class BufferKt {
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;
    @NotNull
    public static final byte[] a = Platform.asUtf8ToByteArray("0123456789abcdef");

    public static final void commonClear(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = segment.prev;
        Intrinsics.checkNotNull(segment2);
        int i = segment2.limit;
        return (i >= 8192 || !segment2.owner) ? size : size - ((long) (i - segment2.pos));
    }

    @NotNull
    public static final Buffer commonCopy(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = sharedCopy;
        sharedCopy.next = sharedCopy;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            Intrinsics.checkNotNull(segment3);
            Intrinsics.checkNotNull(segment2);
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @NotNull
    public static final Buffer commonCopyTo(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j, long j2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonCopyTo");
        Intrinsics.checkNotNullParameter(buffer2, VKApiConst.OUT);
        Util.checkOffsetAndCount(buffer.size(), j, j2);
        if (j2 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j2);
        Segment segment = buffer.head;
        while (true) {
            Intrinsics.checkNotNull(segment);
            int i = segment.limit;
            int i2 = segment.pos;
            if (j < ((long) (i - i2))) {
                break;
            }
            j -= (long) (i - i2);
            segment = segment.next;
        }
        while (j2 > 0) {
            Intrinsics.checkNotNull(segment);
            Segment sharedCopy = segment.sharedCopy();
            int i3 = sharedCopy.pos + ((int) j);
            sharedCopy.pos = i3;
            sharedCopy.limit = Math.min(i3 + ((int) j2), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy;
                buffer2.head = sharedCopy;
            } else {
                Intrinsics.checkNotNull(segment2);
                Segment segment3 = segment2.prev;
                Intrinsics.checkNotNull(segment3);
                segment3.push(sharedCopy);
            }
            j2 -= (long) (sharedCopy.limit - sharedCopy.pos);
            segment = segment.next;
            j = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(@NotNull Buffer buffer, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        Intrinsics.checkNotNull(segment);
        Segment segment2 = buffer2.head;
        Intrinsics.checkNotNull(segment2);
        int i = segment.pos;
        int i2 = segment2.pos;
        long j = 0;
        while (j < buffer.size()) {
            long min = (long) Math.min(segment.limit - i, segment2.limit - i2);
            long j2 = 0;
            while (j2 < min) {
                int i3 = i + 1;
                int i4 = i2 + 1;
                if (segment.data[i] != segment2.data[i2]) {
                    return false;
                }
                j2++;
                i = i3;
                i2 = i4;
            }
            if (i == segment.limit) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                i = segment.pos;
            }
            if (i2 == segment2.limit) {
                segment2 = segment2.next;
                Intrinsics.checkNotNull(segment2);
                i2 = segment2.pos;
            }
            j += min;
        }
        return true;
    }

    public static final byte commonGet(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j, 1);
        Segment segment = buffer.head;
        if (segment == null) {
            Intrinsics.checkNotNull(null);
            throw null;
        } else if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            Intrinsics.checkNotNull(segment);
            return segment.data[(int) ((((long) segment.pos) + j) - size)];
        } else {
            long j2 = 0;
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    Intrinsics.checkNotNull(segment);
                    return segment.data[(int) ((((long) segment.pos) + j) - j2)];
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
        }
    }

    public static final int commonHashCode(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = segment.limit;
            for (int i3 = segment.pos; i3 < i2; i3++) {
                i = (i * 31) + segment.data[i3];
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
        } while (segment != buffer.head);
        return i;
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, byte b, long j, long j2) {
        Segment segment;
        int i;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonIndexOf");
        long j3 = 0;
        if (0 <= j && j2 >= j) {
            if (j2 > buffer.size()) {
                j2 = buffer.size();
            }
            if (j == j2 || (segment = buffer.head) == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j3 = buffer.size();
                while (j3 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j3 -= (long) (segment.limit - segment.pos);
                }
                while (j3 < j2) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                    i = (int) ((((long) segment.pos) + j) - j3);
                    while (i < min) {
                        if (bArr[i] != b) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j3;
                }
                return -1;
            }
            while (true) {
                long j4 = ((long) (segment.limit - segment.pos)) + j3;
                if (j4 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j3 = j4;
            }
            while (j3 < j2) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + j2) - j3);
                i = (int) ((((long) segment.pos) + j) - j3);
                while (i < min2) {
                    if (bArr2[i] != b) {
                        i++;
                    }
                }
                j3 += (long) (segment.limit - segment.pos);
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j = j3;
            }
            return -1;
            return ((long) (i - segment.pos)) + j3;
        }
        StringBuilder L = a.L("size=");
        L.append(buffer.size());
        L.append(" fromIndex=");
        L.append(j);
        L.append(" toIndex=");
        L.append(j2);
        throw new IllegalArgumentException(L.toString().toString());
    }

    public static final long commonIndexOfElement(@NotNull Buffer buffer, @NotNull ByteString byteString, long j) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        long j2 = 0;
        if (j >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1;
            }
            if (buffer.size() - j < j) {
                j2 = buffer.size();
                while (j2 > j) {
                    segment = segment.prev;
                    Intrinsics.checkNotNull(segment);
                    j2 -= (long) (segment.limit - segment.pos);
                }
                if (byteString.size() == 2) {
                    byte b = byteString.getByte(0);
                    byte b2 = byteString.getByte(1);
                    while (j2 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i3 = segment.limit;
                        while (i < i3) {
                            byte b3 = bArr[i];
                            if (!(b3 == b || b3 == b2)) {
                                i++;
                            }
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j2 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i = (int) ((((long) segment.pos) + j) - j2);
                        int i4 = segment.limit;
                        while (i < i4) {
                            byte b4 = bArr2[i];
                            for (byte b5 : internalArray$okio) {
                                if (b4 == b5) {
                                    i2 = segment.pos;
                                    return ((long) (i - i2)) + j2;
                                }
                            }
                            i++;
                        }
                        j2 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        j = j2;
                    }
                }
                return -1;
            }
            while (true) {
                long j3 = ((long) (segment.limit - segment.pos)) + j2;
                if (j3 > j) {
                    break;
                }
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                j2 = j3;
            }
            if (byteString.size() == 2) {
                byte b6 = byteString.getByte(0);
                byte b8 = byteString.getByte(1);
                while (j2 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i5 = segment.limit;
                    while (i < i5) {
                        byte b9 = bArr3[i];
                        if (!(b9 == b6 || b9 == b8)) {
                            i++;
                        }
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j2 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    i = (int) ((((long) segment.pos) + j) - j2);
                    int i6 = segment.limit;
                    while (i < i6) {
                        byte b10 = bArr4[i];
                        for (byte b11 : internalArray$okio2) {
                            if (b10 == b11) {
                                i2 = segment.pos;
                                return ((long) (i - i2)) + j2;
                            }
                        }
                        i++;
                    }
                    j2 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j = j2;
                }
            }
            return -1;
            i2 = segment.pos;
            return ((long) (i - i2)) + j2;
        }
        throw new IllegalArgumentException(a.T2("fromIndex < 0: ", j).toString());
    }

    public static final boolean commonRangeEquals(@NotNull Buffer buffer, long j, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (j < 0 || i < 0 || i2 < 0 || buffer.size() - j < ((long) i2) || byteString.size() - i < i2) {
            return false;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            if (buffer.getByte(((long) i3) + j) != byteString.getByte(i + i3)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(@NotNull Buffer buffer, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByte");
        if (buffer.size() != 0) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            int i3 = i + 1;
            byte b = segment.data[i];
            buffer.setSize$okio(buffer.size() - 1);
            if (i3 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i3;
            }
            return b;
        }
        throw new EOFException();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0081, code lost:
        if (r5 == 0) goto L_0x0085;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0083, code lost:
        r7 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0085, code lost:
        r1 = a2.b.a.a.a.L("Expected leading [0-9] or '-' character but was 0x");
        r1.append(okio.Util.toHexString(r12));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x009b, code lost:
        throw new java.lang.NumberFormatException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009c, code lost:
        if (r10 != r11) goto L_0x00a8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009e, code lost:
        r17.head = r8.pop();
        okio.SegmentPool.recycle(r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a8, code lost:
        r8.pos = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00aa, code lost:
        if (r7 != false) goto L_0x00b0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.Buffer r17) {
        /*
            r0 = r17
            java.lang.String r1 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            long r1 = r17.size()
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x00be
            r1 = -7
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0016:
            okio.Segment r8 = r0.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            byte[] r9 = r8.data
            int r10 = r8.pos
            int r11 = r8.limit
        L_0x0021:
            if (r10 >= r11) goto L_0x009c
            byte r12 = r9[r10]
            r13 = 48
            byte r13 = (byte) r13
            if (r12 < r13) goto L_0x0071
            r14 = 57
            byte r14 = (byte) r14
            if (r12 > r14) goto L_0x0071
            int r13 = r13 - r12
            r14 = -922337203685477580(0xf333333333333334, double:-8.390303882365713E246)
            int r16 = (r3 > r14 ? 1 : (r3 == r14 ? 0 : -1))
            if (r16 < 0) goto L_0x0048
            if (r16 != 0) goto L_0x0041
            long r14 = (long) r13
            int r16 = (r14 > r1 ? 1 : (r14 == r1 ? 0 : -1))
            if (r16 >= 0) goto L_0x0041
            goto L_0x0048
        L_0x0041:
            r14 = 10
            long r3 = r3 * r14
            long r12 = (long) r13
            long r3 = r3 + r12
            goto L_0x007c
        L_0x0048:
            okio.Buffer r0 = new okio.Buffer
            r0.<init>()
            okio.Buffer r0 = r0.writeDecimalLong(r3)
            okio.Buffer r0 = r0.writeByte(r12)
            if (r6 != 0) goto L_0x005a
            r0.readByte()
        L_0x005a:
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            java.lang.String r2 = "Number too large: "
            java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
            java.lang.String r0 = r0.readUtf8()
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        L_0x0071:
            r13 = 45
            byte r13 = (byte) r13
            if (r12 != r13) goto L_0x0081
            if (r5 != 0) goto L_0x0081
            r12 = 1
            long r1 = r1 - r12
            r6 = 1
        L_0x007c:
            int r10 = r10 + 1
            int r5 = r5 + 1
            goto L_0x0021
        L_0x0081:
            if (r5 == 0) goto L_0x0085
            r7 = 1
            goto L_0x009c
        L_0x0085:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r2 = okio.Util.toHexString(r12)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x009c:
            if (r10 != r11) goto L_0x00a8
            okio.Segment r9 = r8.pop()
            r0.head = r9
            okio.SegmentPool.recycle(r8)
            goto L_0x00aa
        L_0x00a8:
            r8.pos = r10
        L_0x00aa:
            if (r7 != 0) goto L_0x00b0
            okio.Segment r8 = r0.head
            if (r8 != 0) goto L_0x0016
        L_0x00b0:
            long r1 = r17.size()
            long r7 = (long) r5
            long r1 = r1 - r7
            r0.setSize$okio(r1)
            if (r6 == 0) goto L_0x00bc
            goto L_0x00bd
        L_0x00bc:
            long r3 = -r3
        L_0x00bd:
            return r3
        L_0x00be:
            java.io.EOFException r0 = new java.io.EOFException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        int i = 0;
        while (i < bArr.length) {
            int read = buffer.read(bArr, i, bArr.length - i);
            if (read != -1) {
                i += read;
            } else {
                throw new EOFException();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        if (r0 == 0) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007d, code lost:
        r1 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007f, code lost:
        r0 = a2.b.a.a.a.L("Expected leading [0-9a-fA-F] character but was 0x");
        r0.append(okio.Util.toHexString(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0095, code lost:
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadHexadecimalUnsignedLong(@org.jetbrains.annotations.NotNull okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b4
            r0 = 0
            r1 = 0
            r4 = r2
        L_0x0012:
            okio.Segment r6 = r15.head
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6)
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L_0x001d:
            if (r8 >= r9) goto L_0x0096
            byte r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x002e
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x002e
            int r11 = r10 - r11
            goto L_0x0047
        L_0x002e:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x0039
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x0039
            goto L_0x0043
        L_0x0039:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L_0x007b
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L_0x007b
        L_0x0043:
            int r11 = r10 - r11
            int r11 = r11 + 10
        L_0x0047:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L_0x0057
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L_0x001d
        L_0x0057:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.String r1 = "Number too large: "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L_0x007b:
            if (r0 == 0) goto L_0x007f
            r1 = 1
            goto L_0x0096
        L_0x007f:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9a-fA-F] character but was 0x"
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        L_0x0096:
            if (r8 != r9) goto L_0x00a2
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool.recycle(r6)
            goto L_0x00a4
        L_0x00a2:
            r6.pos = r8
        L_0x00a4:
            if (r1 != 0) goto L_0x00aa
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L_0x0012
        L_0x00aa:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        L_0x00b4:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadInt");
        if (buffer.size() >= 4) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 4) {
                return (buffer.readByte() & 255) | ((buffer.readByte() & 255) << 24) | ((buffer.readByte() & 255) << 16) | ((buffer.readByte() & 255) << 8);
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 24) | ((bArr[i3] & 255) << 16);
            int i6 = i4 + 1;
            int i7 = i5 | ((bArr[i4] & 255) << 8);
            int i8 = i6 + 1;
            int i9 = i7 | (bArr[i6] & 255);
            buffer.setSize$okio(buffer.size() - 4);
            if (i8 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i8;
            }
            return i9;
        }
        throw new EOFException();
    }

    public static final long commonReadLong(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadLong");
        if (buffer.size() >= 8) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (((long) (i2 - i)) < 8) {
                return ((((long) buffer.readInt()) & BodyPartID.bodyIdMax) << 32) | (BodyPartID.bodyIdMax & ((long) buffer.readInt()));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = i4 + 1;
            long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i3]) & 255) << 48) | ((((long) bArr[i4]) & 255) << 40);
            int i6 = i5 + 1;
            long j2 = ((((long) bArr[i5]) & 255) << 32) | j;
            int i7 = i6 + 1;
            int i8 = i7 + 1;
            long j3 = j2 | ((((long) bArr[i6]) & 255) << 24) | ((((long) bArr[i7]) & 255) << 16);
            int i9 = i8 + 1;
            int i10 = i9 + 1;
            long j4 = j3 | ((((long) bArr[i8]) & 255) << 8) | (((long) bArr[i9]) & 255);
            buffer.setSize$okio(buffer.size() - 8);
            if (i10 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i10;
            }
            return j4;
        }
        throw new EOFException();
    }

    public static final short commonReadShort(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadShort");
        if (buffer.size() >= 2) {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i = segment.pos;
            int i2 = segment.limit;
            if (i2 - i < 2) {
                return (short) ((buffer.readByte() & 255) | ((buffer.readByte() & 255) << 8));
            }
            byte[] bArr = segment.data;
            int i3 = i + 1;
            int i4 = i3 + 1;
            int i5 = ((bArr[i] & 255) << 8) | (bArr[i3] & 255);
            buffer.setSize$okio(buffer.size() - 2);
            if (i4 == i2) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            } else {
                segment.pos = i4;
            }
            return (short) i5;
        }
        throw new EOFException();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (!(i >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (i == 0) {
            return "";
        } else {
            Segment segment = buffer.head;
            Intrinsics.checkNotNull(segment);
            int i2 = segment.pos;
            if (((long) i2) + j > ((long) segment.limit)) {
                return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j), 0, 0, 3, null);
            }
            int i3 = (int) j;
            String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i2, i2 + i3);
            segment.pos += i3;
            buffer.setSize$okio(buffer.size() - j);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.recycle(segment);
            }
            return commonToUtf8String;
        }
    }

    public static final int commonReadUtf8CodePoint(@NotNull Buffer buffer) {
        int i;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() != 0) {
            byte b = buffer.getByte(0);
            if ((b & 128) == 0) {
                i3 = b & Byte.MAX_VALUE;
                i2 = 1;
                i = 0;
            } else if ((b & 224) == 192) {
                i3 = b & Ascii.US;
                i2 = 2;
                i = 128;
            } else if ((b & 240) == 224) {
                i3 = b & Ascii.SI;
                i2 = 3;
                i = 2048;
            } else if ((b & 248) == 240) {
                i3 = b & 7;
                i2 = 4;
                i = 65536;
            } else {
                buffer.skip(1);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            long j = (long) i2;
            if (buffer.size() >= j) {
                for (int i4 = 1; i4 < i2; i4++) {
                    long j2 = (long) i4;
                    byte b2 = buffer.getByte(j2);
                    if ((b2 & 192) == 128) {
                        i3 = (i3 << 6) | (b2 & Utf8.REPLACEMENT_BYTE);
                    } else {
                        buffer.skip(j2);
                        return Utf8.REPLACEMENT_CODE_POINT;
                    }
                }
                buffer.skip(j);
                if (i3 > 1114111) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                if ((55296 <= i3 && 57343 >= i3) || i3 < i) {
                    return Utf8.REPLACEMENT_CODE_POINT;
                }
                return i3;
            }
            StringBuilder M = a.M("size < ", i2, ": ");
            M.append(buffer.size());
            M.append(" (to read code point prefixed 0x");
            M.append(Util.toHexString(b));
            M.append(')');
            throw new EOFException(M.toString());
        }
        throw new EOFException();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8Line");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadUtf8LineStrict");
        if (j >= 0) {
            long j2 = Long.MAX_VALUE;
            if (j != Long.MAX_VALUE) {
                j2 = j + 1;
            }
            byte b = (byte) 10;
            long indexOf = buffer.indexOf(b, 0, j2);
            if (indexOf != -1) {
                return readUtf8Line(buffer, indexOf);
            }
            if (j2 < buffer.size() && buffer.getByte(j2 - 1) == ((byte) 13) && buffer.getByte(j2) == b) {
                return readUtf8Line(buffer, j2);
            }
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, Math.min((long) 32, buffer.size()));
            StringBuilder L = a.L("\\n not found: limit=");
            L.append(Math.min(buffer.size(), j));
            L.append(" content=");
            L.append(buffer2.readByteString().hex());
            L.append(Typography.ellipsis);
            throw new EOFException(L.toString());
        }
        throw new IllegalArgumentException(a.T2("limit < 0: ", j).toString());
    }

    public static final int commonSelect(@NotNull Buffer buffer, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip((long) options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSkip");
        while (j > 0) {
            Segment segment = buffer.head;
            if (segment != null) {
                int min = (int) Math.min(j, (long) (segment.limit - segment.pos));
                long j2 = (long) min;
                buffer.setSize$okio(buffer.size() - j2);
                j -= j2;
                int i = segment.pos + min;
                segment.pos = i;
                if (i == segment.limit) {
                    buffer.head = segment.pop();
                    SegmentPool.recycle(segment);
                }
            } else {
                throw new EOFException();
            }
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        StringBuilder L = a.L("size > Int.MAX_VALUE: ");
        L.append(buffer.size());
        throw new IllegalStateException(L.toString().toString());
    }

    @NotNull
    public static final Segment commonWritableSegment(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWritableSegment");
        boolean z = true;
        if (i < 1 || i > 8192) {
            z = false;
        }
        if (z) {
            Segment segment = buffer.head;
            if (segment == null) {
                Segment take = SegmentPool.take();
                buffer.head = take;
                take.prev = take;
                take.next = take;
                return take;
            }
            Intrinsics.checkNotNull(segment);
            Segment segment2 = segment.prev;
            Intrinsics.checkNotNull(segment2);
            return (segment2.limit + i > 8192 || !segment2.owner) ? segment2.push(SegmentPool.take()) : segment2;
        }
        throw new IllegalArgumentException("unexpected capacity".toString());
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(byteString, "byteString");
        byteString.write$okio(buffer, i, i2);
        return buffer;
    }

    public static final long commonWriteAll(@NotNull Buffer buffer, @NotNull Source source) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteAll");
        Intrinsics.checkNotNullParameter(source, "source");
        long j = 0;
        while (true) {
            long read = source.read(buffer, (long) 8192);
            if (read == -1) {
                return j;
            }
            j += read;
        }
    }

    @NotNull
    public static final Buffer commonWriteByte(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteByte");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        writableSegment$okio.limit = i2 + 1;
        bArr[i2] = (byte) i;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteDecimalLong(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteDecimalLong");
        int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
        if (i == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (i < 0) {
            j = -j;
            if (j < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j >= 100000000) {
            i2 = j < 1000000000000L ? j < RealConnection.IDLE_CONNECTION_HEALTHY_NS ? j < 1000000000 ? 9 : 10 : j < 100000000000L ? 11 : 12 : j < 1000000000000000L ? j < 10000000000000L ? 13 : j < 100000000000000L ? 14 : 15 : j < 100000000000000000L ? j < 10000000000000000L ? 16 : 17 : j < 1000000000000000000L ? 18 : 19;
        } else if (j >= 10000) {
            i2 = j < 1000000 ? j < 100000 ? 5 : 6 : j < 10000000 ? 7 : 8;
        } else if (j >= 100) {
            i2 = j < 1000 ? 3 : 4;
        } else if (j >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j != 0) {
            long j2 = (long) 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j % j2)];
            j /= j2;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + ((long) i2));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteHexadecimalUnsignedLong(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j == 0) {
            return buffer.writeByte(48);
        }
        long j2 = (j >>> 1) | j;
        long j3 = j2 | (j2 >>> 2);
        long j4 = j3 | (j3 >>> 4);
        long j5 = j4 | (j4 >>> 8);
        long j6 = j5 | (j5 >>> 16);
        long j7 = j6 | (j6 >>> 32);
        long j8 = j7 - ((j7 >>> 1) & 6148914691236517205L);
        long j9 = ((j8 >>> 2) & 3689348814741910323L) + (j8 & 3689348814741910323L);
        long j10 = ((j9 >>> 4) + j9) & 1085102592571150095L;
        long j11 = j10 + (j10 >>> 8);
        long j12 = j11 + (j11 >>> 16);
        int i = (int) ((((j12 & 63) + ((j12 >>> 32) & 63)) + ((long) 3)) / ((long) 4));
        Segment writableSegment$okio = buffer.writableSegment$okio(i);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        for (int i3 = (i2 + i) - 1; i3 >= i2; i3--) {
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (15 & j)];
            j >>>= 4;
        }
        writableSegment$okio.limit += i;
        buffer.setSize$okio(buffer.size() + ((long) i));
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteInt(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteInt");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 24) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i >>> 16) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i >>> 8) & 255);
        bArr[i5] = (byte) (i & 255);
        writableSegment$okio.limit = i5 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteLong(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteLong");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i = writableSegment$okio.limit;
        int i2 = i + 1;
        bArr[i] = (byte) ((int) ((j >>> 56) & 255));
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((int) ((j >>> 48) & 255));
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((int) ((j >>> 40) & 255));
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((int) ((j >>> 32) & 255));
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((int) ((j >>> 24) & 255));
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((int) ((j >>> 16) & 255));
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((int) ((j >>> 8) & 255));
        bArr[i8] = (byte) ((int) (j & 255));
        writableSegment$okio.limit = i8 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteShort(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteShort");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((i >>> 8) & 255);
        bArr[i3] = (byte) (i & 255);
        writableSegment$okio.limit = i3 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @NotNull
    public static final Buffer commonWriteUtf8(@NotNull Buffer buffer, @NotNull String str, int i, int i2) {
        char charAt;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteUtf8");
        Intrinsics.checkNotNullParameter(str, Types.STRING);
        if (i >= 0) {
            if (i2 >= i) {
                if (i2 <= str.length()) {
                    while (i < i2) {
                        char charAt2 = str.charAt(i);
                        if (charAt2 < 128) {
                            Segment writableSegment$okio = buffer.writableSegment$okio(1);
                            byte[] bArr = writableSegment$okio.data;
                            int i3 = writableSegment$okio.limit - i;
                            int min = Math.min(i2, 8192 - i3);
                            int i4 = i + 1;
                            bArr[i + i3] = (byte) charAt2;
                            while (true) {
                                i = i4;
                                if (i >= min || (charAt = str.charAt(i)) >= 128) {
                                    break;
                                }
                                i4 = i + 1;
                                bArr[i + i3] = (byte) charAt;
                            }
                            int i5 = writableSegment$okio.limit;
                            int i6 = (i3 + i) - i5;
                            writableSegment$okio.limit = i5 + i6;
                            buffer.setSize$okio(buffer.size() + ((long) i6));
                        } else {
                            if (charAt2 < 2048) {
                                Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                                byte[] bArr2 = writableSegment$okio2.data;
                                int i7 = writableSegment$okio2.limit;
                                bArr2[i7] = (byte) ((charAt2 >> 6) | 192);
                                bArr2[i7 + 1] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio2.limit = i7 + 2;
                                buffer.setSize$okio(buffer.size() + 2);
                            } else if (charAt2 < 55296 || charAt2 > 57343) {
                                Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                                byte[] bArr3 = writableSegment$okio3.data;
                                int i8 = writableSegment$okio3.limit;
                                bArr3[i8] = (byte) ((charAt2 >> '\f') | 224);
                                bArr3[i8 + 1] = (byte) ((63 & (charAt2 >> 6)) | 128);
                                bArr3[i8 + 2] = (byte) ((charAt2 & '?') | 128);
                                writableSegment$okio3.limit = i8 + 3;
                                buffer.setSize$okio(buffer.size() + 3);
                            } else {
                                int i9 = i + 1;
                                char charAt3 = i9 < i2 ? str.charAt(i9) : 0;
                                if (charAt2 > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                                    buffer.writeByte(63);
                                    i = i9;
                                } else {
                                    int i10 = (((charAt2 & 1023) << 10) | (charAt3 & 1023)) + 65536;
                                    Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                                    byte[] bArr4 = writableSegment$okio4.data;
                                    int i11 = writableSegment$okio4.limit;
                                    bArr4[i11] = (byte) ((i10 >> 18) | 240);
                                    bArr4[i11 + 1] = (byte) (((i10 >> 12) & 63) | 128);
                                    bArr4[i11 + 2] = (byte) (((i10 >> 6) & 63) | 128);
                                    bArr4[i11 + 3] = (byte) ((i10 & 63) | 128);
                                    writableSegment$okio4.limit = i11 + 4;
                                    buffer.setSize$okio(buffer.size() + 4);
                                    i += 2;
                                }
                            }
                            i++;
                        }
                    }
                    return buffer;
                }
                StringBuilder M = a.M("endIndex > string.length: ", i2, " > ");
                M.append(str.length());
                throw new IllegalArgumentException(M.toString().toString());
            }
            throw new IllegalArgumentException(a.R2("endIndex < beginIndex: ", i2, " < ", i).toString());
        }
        throw new IllegalArgumentException(a.M2("beginIndex < 0: ", i).toString());
    }

    @NotNull
    public static final Buffer commonWriteUtf8CodePoint(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWriteUtf8CodePoint");
        if (i < 128) {
            buffer.writeByte(i);
        } else if (i < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i2 = writableSegment$okio.limit;
            bArr[i2] = (byte) ((i >> 6) | 192);
            bArr[i2 + 1] = (byte) ((i & 63) | 128);
            writableSegment$okio.limit = i2 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i && 57343 >= i) {
            buffer.writeByte(63);
        } else if (i < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i3 = writableSegment$okio2.limit;
            bArr2[i3] = (byte) ((i >> 12) | 224);
            bArr2[i3 + 1] = (byte) (((i >> 6) & 63) | 128);
            bArr2[i3 + 2] = (byte) ((i & 63) | 128);
            writableSegment$okio2.limit = i3 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else if (i <= 1114111) {
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i4 = writableSegment$okio3.limit;
            bArr3[i4] = (byte) ((i >> 18) | 240);
            bArr3[i4 + 1] = (byte) (((i >> 12) & 63) | 128);
            bArr3[i4 + 2] = (byte) (((i >> 6) & 63) | 128);
            bArr3[i4 + 3] = (byte) ((i & 63) | 128);
            writableSegment$okio3.limit = i4 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        } else {
            StringBuilder L = a.L("Unexpected code point: 0x");
            L.append(Util.toHexString(i));
            throw new IllegalArgumentException(L.toString());
        }
        return buffer;
    }

    @NotNull
    public static final byte[] getHEX_DIGIT_BYTES() {
        return a;
    }

    public static final boolean rangeEquals(@NotNull Segment segment, int i, @NotNull byte[] bArr, int i2, int i3) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        int i4 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i2 < i3) {
            if (i == i4) {
                segment = segment.next;
                Intrinsics.checkNotNull(segment);
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i = segment.pos;
                i4 = segment.limit;
            }
            if (bArr2[i] != bArr[i2]) {
                return false;
            }
            i++;
            i2++;
        }
        return true;
    }

    @NotNull
    public static final String readUtf8Line(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$readUtf8Line");
        if (j > 0) {
            long j2 = j - 1;
            if (buffer.getByte(j2) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j2);
                buffer.skip(2);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j);
        buffer.skip(1);
        return readUtf82;
    }

    public static final <T> T seek(@NotNull Buffer buffer, long j, @NotNull Function2<? super Segment, ? super Long, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$seek");
        Intrinsics.checkNotNullParameter(function2, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return (T) function2.invoke(null, -1L);
        }
        if (buffer.size() - j < j) {
            long size = buffer.size();
            while (size > j) {
                segment = segment.prev;
                Intrinsics.checkNotNull(segment);
                size -= (long) (segment.limit - segment.pos);
            }
            return (T) function2.invoke(segment, Long.valueOf(size));
        }
        long j2 = 0;
        while (true) {
            long j3 = ((long) (segment.limit - segment.pos)) + j2;
            if (j3 > j) {
                return (T) function2.invoke(segment, Long.valueOf(j2));
            }
            segment = segment.next;
            Intrinsics.checkNotNull(segment);
            j2 = j3;
        }
    }

    public static final int selectPrefix(@NotNull Buffer buffer, @NotNull Options options, boolean z) {
        int i;
        int i2;
        int i3;
        Segment segment;
        int i4;
        Intrinsics.checkNotNullParameter(buffer, "$this$selectPrefix");
        Intrinsics.checkNotNullParameter(options, "options");
        Segment segment2 = buffer.head;
        if (segment2 != null) {
            byte[] bArr = segment2.data;
            int i5 = segment2.pos;
            int i6 = segment2.limit;
            int[] trie$okio = options.getTrie$okio();
            Segment segment3 = segment2;
            int i7 = 0;
            int i8 = -1;
            loop0:
            while (true) {
                int i9 = i7 + 1;
                int i10 = trie$okio[i7];
                int i11 = i9 + 1;
                int i12 = trie$okio[i9];
                if (i12 != -1) {
                    i8 = i12;
                }
                if (segment3 == null) {
                    break;
                }
                if (i10 < 0) {
                    int i13 = (i10 * -1) + i11;
                    while (true) {
                        int i14 = i5 + 1;
                        int i15 = i11 + 1;
                        if ((bArr[i5] & 255) != trie$okio[i11]) {
                            return i8;
                        }
                        boolean z2 = i15 == i13;
                        if (i14 == i6) {
                            Intrinsics.checkNotNull(segment3);
                            Segment segment4 = segment3.next;
                            Intrinsics.checkNotNull(segment4);
                            i4 = segment4.pos;
                            byte[] bArr2 = segment4.data;
                            i3 = segment4.limit;
                            if (segment4 != segment2) {
                                segment = segment4;
                                bArr = bArr2;
                            } else if (!z2) {
                                break loop0;
                            } else {
                                bArr = bArr2;
                                segment = null;
                            }
                        } else {
                            i3 = i6;
                            i4 = i14;
                            segment = segment3;
                        }
                        if (z2) {
                            i2 = trie$okio[i15];
                            i = i4;
                            i6 = i3;
                            segment3 = segment;
                            break;
                        }
                        i5 = i4;
                        i6 = i3;
                        i11 = i15;
                        segment3 = segment;
                    }
                } else {
                    i = i5 + 1;
                    int i16 = bArr[i5] & 255;
                    int i17 = i11 + i10;
                    while (i11 != i17) {
                        if (i16 == trie$okio[i11]) {
                            i2 = trie$okio[i11 + i10];
                            if (i == i6) {
                                segment3 = segment3.next;
                                Intrinsics.checkNotNull(segment3);
                                i = segment3.pos;
                                bArr = segment3.data;
                                i6 = segment3.limit;
                                if (segment3 == segment2) {
                                    segment3 = null;
                                }
                            }
                        } else {
                            i11++;
                        }
                    }
                    return i8;
                }
                if (i2 >= 0) {
                    return i2;
                }
                i7 = -i2;
                i5 = i;
            }
            if (z) {
                return -2;
            }
            return i8;
        } else if (z) {
            return -2;
        } else {
            return -1;
        }
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@NotNull Buffer buffer, @NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        Util.checkOffsetAndCount((long) bArr.length, (long) i, (long) i2);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i2, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i3 = segment.pos;
        ArraysKt___ArraysJvmKt.copyInto(bArr2, bArr, i, i3, i3 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - ((long) min));
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.recycle(segment);
        }
        return min;
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteArray");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (buffer.size() >= j) {
            byte[] bArr = new byte[((int) j)];
            buffer.readFully(bArr);
            return bArr;
        } else {
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadByteString");
        if (!(j >= 0 && j <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(a.T2("byteCount: ", j).toString());
        } else if (buffer.size() < j) {
            throw new EOFException();
        } else if (j < ((long) 4096)) {
            return new ByteString(buffer.readByteArray(j));
        } else {
            ByteString snapshot = buffer.snapshot((int) j);
            buffer.skip(j);
            return snapshot;
        }
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(bArr, "source");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        int i3 = i2 + i;
        while (i < i3) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i3 - i, 8192 - writableSegment$okio.limit);
            int i4 = i + min;
            ArraysKt___ArraysJvmKt.copyInto(bArr, writableSegment$okio.data, writableSegment$okio.limit, i, i4);
            writableSegment$okio.limit += min;
            i = i4;
        }
        buffer.setSize$okio(buffer.size() + j);
        return buffer;
    }

    public static final void commonReadFully(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (buffer.size() >= j) {
            buffer2.write(buffer, j);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @NotNull
    public static final ByteString commonSnapshot(@NotNull Buffer buffer, int i) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonSnapshot");
        if (i == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0, (long) i);
        Segment segment = buffer.head;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            Intrinsics.checkNotNull(segment);
            int i5 = segment.limit;
            int i6 = segment.pos;
            if (i5 != i6) {
                i3 += i5 - i6;
                i4++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i4][];
        int[] iArr = new int[(i4 * 2)];
        Segment segment2 = buffer.head;
        int i7 = 0;
        while (i2 < i) {
            Intrinsics.checkNotNull(segment2);
            bArr[i7] = segment2.data;
            i2 += segment2.limit - segment2.pos;
            iArr[i7] = Math.min(i2, i);
            iArr[i7 + i4] = segment2.pos;
            segment2.shared = true;
            i7++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @NotNull
    public static final Buffer commonWrite(@NotNull Buffer buffer, @NotNull Source source, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(source, "source");
        while (j > 0) {
            long read = source.read(buffer, j);
            if (read != -1) {
                j -= read;
            } else {
                throw new EOFException();
            }
        }
        return buffer;
    }

    public static final long commonRead(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j) {
        Intrinsics.checkNotNullParameter(buffer, "$this$commonRead");
        Intrinsics.checkNotNullParameter(buffer2, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (buffer.size() == 0) {
            return -1;
        } else {
            if (j > buffer.size()) {
                j = buffer.size();
            }
            buffer2.write(buffer, j);
            return j;
        }
    }

    public static final void commonWrite(@NotNull Buffer buffer, @NotNull Buffer buffer2, long j) {
        Segment segment;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonWrite");
        Intrinsics.checkNotNullParameter(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0, j);
            while (j > 0) {
                Segment segment2 = buffer2.head;
                Intrinsics.checkNotNull(segment2);
                int i = segment2.limit;
                Segment segment3 = buffer2.head;
                Intrinsics.checkNotNull(segment3);
                if (j < ((long) (i - segment3.pos))) {
                    Segment segment4 = buffer.head;
                    if (segment4 != null) {
                        Intrinsics.checkNotNull(segment4);
                        segment = segment4.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((((long) segment.limit) + j) - ((long) (segment.shared ? 0 : segment.pos)) <= ((long) 8192)) {
                            Segment segment5 = buffer2.head;
                            Intrinsics.checkNotNull(segment5);
                            segment5.writeTo(segment, (int) j);
                            buffer2.setSize$okio(buffer2.size() - j);
                            buffer.setSize$okio(buffer.size() + j);
                            return;
                        }
                    }
                    Segment segment6 = buffer2.head;
                    Intrinsics.checkNotNull(segment6);
                    buffer2.head = segment6.split((int) j);
                }
                Segment segment7 = buffer2.head;
                Intrinsics.checkNotNull(segment7);
                long j2 = (long) (segment7.limit - segment7.pos);
                buffer2.head = segment7.pop();
                Segment segment8 = buffer.head;
                if (segment8 == null) {
                    buffer.head = segment7;
                    segment7.prev = segment7;
                    segment7.next = segment7;
                } else {
                    Intrinsics.checkNotNull(segment8);
                    Segment segment9 = segment8.prev;
                    Intrinsics.checkNotNull(segment9);
                    segment9.push(segment7).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j2);
                buffer.setSize$okio(buffer.size() + j2);
                j -= j2;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@NotNull Buffer buffer, @NotNull ByteString byteString, long j) {
        int i;
        long j2 = j;
        Intrinsics.checkNotNullParameter(buffer, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (byteString.size() > 0) {
            long j3 = 0;
            if (j2 >= 0) {
                Segment segment = buffer.head;
                if (segment == null) {
                    return -1;
                }
                if (buffer.size() - j2 < j2) {
                    long size = buffer.size();
                    while (size > j2) {
                        segment = segment.prev;
                        Intrinsics.checkNotNull(segment);
                        size -= (long) (segment.limit - segment.pos);
                    }
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    byte b = internalArray$okio[0];
                    int size2 = byteString.size();
                    long size3 = (buffer.size() - ((long) size2)) + 1;
                    j3 = size;
                    while (j3 < size3) {
                        byte[] bArr = segment.data;
                        int min = (int) Math.min((long) segment.limit, (((long) segment.pos) + size3) - j3);
                        i = (int) ((((long) segment.pos) + j2) - j3);
                        while (i < min) {
                            if (bArr[i] == b) {
                                if (rangeEquals(segment, i + 1, internalArray$okio, 1, size2)) {
                                }
                            }
                            i++;
                        }
                        j3 += (long) (segment.limit - segment.pos);
                        segment = segment.next;
                        Intrinsics.checkNotNull(segment);
                        size3 = size3;
                        j2 = j3;
                    }
                    return -1;
                }
                while (true) {
                    long j4 = ((long) (segment.limit - segment.pos)) + j3;
                    if (j4 > j2) {
                        break;
                    }
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j3 = j4;
                }
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                byte b2 = internalArray$okio2[0];
                int size4 = byteString.size();
                long size5 = (buffer.size() - ((long) size4)) + 1;
                while (j3 < size5) {
                    byte[] bArr2 = segment.data;
                    int min2 = (int) Math.min((long) segment.limit, (((long) segment.pos) + size5) - j3);
                    i = (int) ((((long) segment.pos) + j2) - j3);
                    while (i < min2) {
                        if (bArr2[i] != b2 || !rangeEquals(segment, i + 1, internalArray$okio2, 1, size4)) {
                            i++;
                        }
                    }
                    j3 += (long) (segment.limit - segment.pos);
                    segment = segment.next;
                    Intrinsics.checkNotNull(segment);
                    j2 = j3;
                }
                return -1;
                return ((long) (i - segment.pos)) + j3;
            }
            throw new IllegalArgumentException(a.T2("fromIndex < 0: ", j2).toString());
        }
        throw new IllegalArgumentException("bytes is empty".toString());
    }
}
