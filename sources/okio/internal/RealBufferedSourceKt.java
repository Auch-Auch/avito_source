package okio.internal;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.EOFException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\n\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0005\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0005\u0010\u0006\u001a\u0014\u0010\b\u001a\u00020\u0007*\u00020\u0000H\b¢\u0006\u0004\b\b\u0010\t\u001a\u001c\u0010\u000b\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u000b\u0010\f\u001a\u001c\u0010\r\u001a\u00020\u0007*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u0000H\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u0014\u0010\u0013\u001a\u00020\u0012*\u00020\u0000H\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a\u001c\u0010\u0013\u001a\u00020\u0012*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u0013\u0010\u0015\u001a\u001c\u0010\u0019\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0016H\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a\u0014\u0010\u001c\u001a\u00020\u001b*\u00020\u0000H\b¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001c\u001a\u00020\u001b*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001bH\b¢\u0006\u0004\b\u001f\u0010 \u001a,\u0010\u0005\u001a\u00020\u0018*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\b¢\u0006\u0004\b\u0005\u0010\"\u001a$\u0010\u001f\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b\u001f\u0010#\u001a\u001c\u0010%\u001a\u00020\u0003*\u00020\u00002\u0006\u0010\u0002\u001a\u00020$H\b¢\u0006\u0004\b%\u0010&\u001a\u0014\u0010(\u001a\u00020'*\u00020\u0000H\b¢\u0006\u0004\b(\u0010)\u001a\u001c\u0010(\u001a\u00020'*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b(\u0010*\u001a\u0016\u0010+\u001a\u0004\u0018\u00010'*\u00020\u0000H\b¢\u0006\u0004\b+\u0010)\u001a\u001c\u0010-\u001a\u00020'*\u00020\u00002\u0006\u0010,\u001a\u00020\u0003H\b¢\u0006\u0004\b-\u0010*\u001a\u0014\u0010.\u001a\u00020\u0018*\u00020\u0000H\b¢\u0006\u0004\b.\u0010/\u001a\u0014\u00101\u001a\u000200*\u00020\u0000H\b¢\u0006\u0004\b1\u00102\u001a\u0014\u00103\u001a\u000200*\u00020\u0000H\b¢\u0006\u0004\b3\u00102\u001a\u0014\u00104\u001a\u00020\u0018*\u00020\u0000H\b¢\u0006\u0004\b4\u0010/\u001a\u0014\u00105\u001a\u00020\u0018*\u00020\u0000H\b¢\u0006\u0004\b5\u0010/\u001a\u0014\u00106\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b6\u00107\u001a\u0014\u00108\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b8\u00107\u001a\u0014\u00109\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b9\u00107\u001a\u0014\u0010:\u001a\u00020\u0003*\u00020\u0000H\b¢\u0006\u0004\b:\u00107\u001a\u001c\u0010;\u001a\u00020\n*\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0003H\b¢\u0006\u0004\b;\u0010\f\u001a,\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\u00032\u0006\u0010>\u001a\u00020\u0003H\b¢\u0006\u0004\b?\u0010@\u001a$\u0010?\u001a\u00020\u0003*\u00020\u00002\u0006\u0010A\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\b¢\u0006\u0004\b?\u0010B\u001a$\u0010D\u001a\u00020\u0003*\u00020\u00002\u0006\u0010C\u001a\u00020\u00122\u0006\u0010=\u001a\u00020\u0003H\b¢\u0006\u0004\bD\u0010B\u001a4\u0010F\u001a\u00020\u0007*\u00020\u00002\u0006\u0010!\u001a\u00020\u00032\u0006\u0010A\u001a\u00020\u00122\u0006\u0010E\u001a\u00020\u00182\u0006\u0010\u0004\u001a\u00020\u0018H\b¢\u0006\u0004\bF\u0010G\u001a\u0014\u0010I\u001a\u00020H*\u00020\u0000H\b¢\u0006\u0004\bI\u0010J\u001a\u0014\u0010K\u001a\u00020\n*\u00020\u0000H\b¢\u0006\u0004\bK\u0010L\u001a\u0014\u0010N\u001a\u00020M*\u00020\u0000H\b¢\u0006\u0004\bN\u0010O\u001a\u0014\u0010P\u001a\u00020'*\u00020\u0000H\b¢\u0006\u0004\bP\u0010)¨\u0006Q"}, d2 = {"Lokio/RealBufferedSource;", "Lokio/Buffer;", "sink", "", DecodeProducer.EXTRA_BITMAP_BYTES, "commonRead", "(Lokio/RealBufferedSource;Lokio/Buffer;J)J", "", "commonExhausted", "(Lokio/RealBufferedSource;)Z", "", "commonRequire", "(Lokio/RealBufferedSource;J)V", "commonRequest", "(Lokio/RealBufferedSource;J)Z", "", "commonReadByte", "(Lokio/RealBufferedSource;)B", "Lokio/ByteString;", "commonReadByteString", "(Lokio/RealBufferedSource;)Lokio/ByteString;", "(Lokio/RealBufferedSource;J)Lokio/ByteString;", "Lokio/Options;", "options", "", "commonSelect", "(Lokio/RealBufferedSource;Lokio/Options;)I", "", "commonReadByteArray", "(Lokio/RealBufferedSource;)[B", "(Lokio/RealBufferedSource;J)[B", "commonReadFully", "(Lokio/RealBufferedSource;[B)V", "offset", "(Lokio/RealBufferedSource;[BII)I", "(Lokio/RealBufferedSource;Lokio/Buffer;J)V", "Lokio/Sink;", "commonReadAll", "(Lokio/RealBufferedSource;Lokio/Sink;)J", "", "commonReadUtf8", "(Lokio/RealBufferedSource;)Ljava/lang/String;", "(Lokio/RealBufferedSource;J)Ljava/lang/String;", "commonReadUtf8Line", "limit", "commonReadUtf8LineStrict", "commonReadUtf8CodePoint", "(Lokio/RealBufferedSource;)I", "", "commonReadShort", "(Lokio/RealBufferedSource;)S", "commonReadShortLe", "commonReadInt", "commonReadIntLe", "commonReadLong", "(Lokio/RealBufferedSource;)J", "commonReadLongLe", "commonReadDecimalLong", "commonReadHexadecimalUnsignedLong", "commonSkip", AuthSource.BOOKING_ORDER, "fromIndex", "toIndex", "commonIndexOf", "(Lokio/RealBufferedSource;BJJ)J", "bytes", "(Lokio/RealBufferedSource;Lokio/ByteString;J)J", "targetBytes", "commonIndexOfElement", "bytesOffset", "commonRangeEquals", "(Lokio/RealBufferedSource;JLokio/ByteString;II)Z", "Lokio/BufferedSource;", "commonPeek", "(Lokio/RealBufferedSource;)Lokio/BufferedSource;", "commonClose", "(Lokio/RealBufferedSource;)V", "Lokio/Timeout;", "commonTimeout", "(Lokio/RealBufferedSource;)Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 4, 0})
public final class RealBufferedSourceKt {
    public static final void commonClose(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonClose");
        if (!realBufferedSource.closed) {
            realBufferedSource.closed = true;
            realBufferedSource.source.close();
            realBufferedSource.bufferField.clear();
        }
    }

    public static final boolean commonExhausted(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonExhausted");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (!realBufferedSource.bufferField.exhausted() || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            return false;
        } else {
            return true;
        }
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonIndexOf");
        boolean z = true;
        if (!realBufferedSource.closed) {
            if (0 > j || j2 < j) {
                z = false;
            }
            if (z) {
                while (j < j2) {
                    long indexOf = realBufferedSource.bufferField.indexOf(b, j, j2);
                    if (indexOf == -1) {
                        long size = realBufferedSource.bufferField.size();
                        if (size >= j2 || realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                            break;
                        }
                        j = Math.max(j, size);
                    } else {
                        return indexOf;
                    }
                }
                return -1;
            }
            StringBuilder O = a.O("fromIndex=", j, " toIndex=");
            O.append(j2);
            throw new IllegalArgumentException(O.toString().toString());
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOfElement(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonIndexOfElement");
        Intrinsics.checkNotNullParameter(byteString, "targetBytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j);
                if (indexOfElement != -1) {
                    return indexOfElement;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, size);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @NotNull
    public static final BufferedSource commonPeek(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonPeek");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@NotNull RealBufferedSource realBufferedSource, long j, @NotNull ByteString byteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonRangeEquals");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (j < 0 || i < 0 || i2 < 0 || byteString.size() - i < i2) {
            return false;
        } else {
            for (int i3 = 0; i3 < i2; i3++) {
                long j2 = ((long) i3) + j;
                if (!(realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == byteString.getByte(i + i3))) {
                    return false;
                }
            }
            return true;
        }
    }

    public static final long commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonRead");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        } else if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        } else {
            return realBufferedSource.bufferField.read(buffer, Math.min(j, realBufferedSource.bufferField.size()));
        }
    }

    public static final long commonReadAll(@NotNull RealBufferedSource realBufferedSource, @NotNull Sink sink) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadAll");
        Intrinsics.checkNotNullParameter(sink, "sink");
        long j = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j;
        }
        long size = j + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1);
        return realBufferedSource.bufferField.readByte();
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        if (r9 == 0) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        r0 = a2.b.a.a.a.L("Expected leading [0-9] or '-' character but was 0x");
        r1 = java.lang.Integer.toString(r8, t6.y.a.checkRadix(t6.y.a.checkRadix(16)));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0059, code lost:
        throw new java.lang.NumberFormatException(r0.toString());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long commonReadDecimalLong(@org.jetbrains.annotations.NotNull okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "$this$commonReadDecimalLong"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        L_0x000d:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L_0x005a
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L_0x0025
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L_0x002f
        L_0x0025:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L_0x0031
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L_0x002f
            goto L_0x0031
        L_0x002f:
            r4 = r6
            goto L_0x000d
        L_0x0031:
            if (r9 == 0) goto L_0x0034
            goto L_0x005a
        L_0x0034:
            java.lang.NumberFormatException r10 = new java.lang.NumberFormatException
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was 0x"
            java.lang.StringBuilder r0 = a2.b.a.a.a.L(r0)
            r1 = 16
            int r1 = t6.y.a.checkRadix(r1)
            int r1 = t6.y.a.checkRadix(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L_0x005a:
            okio.Buffer r10 = r10.bufferField
            long r0 = r10.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSourceKt.commonReadDecimalLong(okio.RealBufferedSource):long");
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        try {
            realBufferedSource.require((long) bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(bArr, i, (int) buffer.size());
                if (read != -1) {
                    i += read;
                } else {
                    throw new AssertionError();
                }
            }
            throw e;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@NotNull RealBufferedSource realBufferedSource) {
        byte b;
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadHexadecimalUnsignedLong");
        realBufferedSource.require(1);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!realBufferedSource.request((long) i2)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte((long) i);
            if ((b < ((byte) 48) || b > ((byte) 57)) && ((b < ((byte) 97) || b > ((byte) 102)) && (b < ((byte) 65) || b > ((byte) 70)))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            StringBuilder L = a.L("Expected leading [0-9a-fA-F] character but was 0x");
            String num = Integer.toString(b, t6.y.a.checkRadix(t6.y.a.checkRadix(16)));
            Intrinsics.checkNotNullExpressionValue(num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            L.append(num);
            throw new NumberFormatException(L.toString());
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2);
        return realBufferedSource.bufferField.readShortLe();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final int commonReadUtf8CodePoint(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1);
        byte b = realBufferedSource.bufferField.getByte(0);
        if ((b & 224) == 192) {
            realBufferedSource.require(2);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @Nullable
    public static final String commonReadUtf8Line(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadUtf8Line");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @NotNull
    public static final String commonReadUtf8LineStrict(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (j >= 0) {
            long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
            byte b = (byte) 10;
            long indexOf = realBufferedSource.indexOf(b, 0, j2);
            if (indexOf != -1) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
            }
            if (j2 < Long.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == ((byte) 13) && realBufferedSource.request(1 + j2) && realBufferedSource.bufferField.getByte(j2) == b) {
                return BufferKt.readUtf8Line(realBufferedSource.bufferField, j2);
            }
            Buffer buffer = new Buffer();
            Buffer buffer2 = realBufferedSource.bufferField;
            buffer2.copyTo(buffer, 0, Math.min((long) 32, buffer2.size()));
            StringBuilder L = a.L("\\n not found: limit=");
            L.append(Math.min(realBufferedSource.bufferField.size(), j));
            L.append(" content=");
            L.append(buffer.readByteString().hex());
            L.append("…");
            throw new EOFException(L.toString());
        }
        throw new IllegalArgumentException(a.T2("limit < 0: ", j).toString());
    }

    public static final boolean commonRequest(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonRequest");
        if (!(j >= 0)) {
            throw new IllegalArgumentException(a.T2("byteCount < 0: ", j).toString());
        } else if (!realBufferedSource.closed) {
            while (realBufferedSource.bufferField.size() < j) {
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return false;
                }
            }
            return true;
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final void commonRequire(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@NotNull RealBufferedSource realBufferedSource, @NotNull Options options) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonSelect");
        Intrinsics.checkNotNullParameter(options, "options");
        if (!realBufferedSource.closed) {
            do {
                int selectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
                if (selectPrefix != -2) {
                    if (selectPrefix == -1) {
                        return -1;
                    }
                    realBufferedSource.bufferField.skip((long) options.getByteStrings$okio()[selectPrefix].size());
                    return selectPrefix;
                }
            } while (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) != -1);
            return -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final void commonSkip(@NotNull RealBufferedSource realBufferedSource, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonSkip");
        if (!realBufferedSource.closed) {
            while (j > 0) {
                if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    throw new EOFException();
                }
                long min = Math.min(j, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(min);
                j -= min;
            }
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @NotNull
    public static final Timeout commonTimeout(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    @NotNull
    public static final String commonToString(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    @NotNull
    public static final byte[] commonReadByteArray(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @NotNull
    public static final ByteString commonReadByteString(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @NotNull
    public static final String commonReadUtf8(@NotNull RealBufferedSource realBufferedSource) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@NotNull RealBufferedSource realBufferedSource, @NotNull Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonReadFully");
        Intrinsics.checkNotNullParameter(buffer, "sink");
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e;
        }
    }

    public static final long commonIndexOf(@NotNull RealBufferedSource realBufferedSource, @NotNull ByteString byteString, long j) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonIndexOf");
        Intrinsics.checkNotNullParameter(byteString, "bytes");
        if (!realBufferedSource.closed) {
            while (true) {
                long indexOf = realBufferedSource.bufferField.indexOf(byteString, j);
                if (indexOf != -1) {
                    return indexOf;
                }
                long size = realBufferedSource.bufferField.size();
                if (realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
                    return -1;
                }
                j = Math.max(j, (size - ((long) byteString.size())) + 1);
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    public static final int commonRead(@NotNull RealBufferedSource realBufferedSource, @NotNull byte[] bArr, int i, int i2) {
        Intrinsics.checkNotNullParameter(realBufferedSource, "$this$commonRead");
        Intrinsics.checkNotNullParameter(bArr, "sink");
        long j = (long) i2;
        Util.checkOffsetAndCount((long) bArr.length, (long) i, j);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }
}
