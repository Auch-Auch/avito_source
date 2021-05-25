package okio;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.imagepipeline.producers.DecodeProducer;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H'¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0014\u001a\u00020\u0013H&¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H&¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0017H&¢\u0006\u0004\b\u001a\u0010\u0019J\u000f\u0010\u001b\u001a\u00020\tH&¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\tH&¢\u0006\u0004\b\u001d\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\tH&¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH&¢\u0006\u0004\b\u001f\u0010\u001cJ\u0017\u0010 \u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b \u0010\rJ\u000f\u0010\"\u001a\u00020!H&¢\u0006\u0004\b\"\u0010#J\u0017\u0010\"\u001a\u00020!2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\"\u0010$J\u0017\u0010'\u001a\u00020\u00172\u0006\u0010&\u001a\u00020%H&¢\u0006\u0004\b'\u0010(J\u000f\u0010*\u001a\u00020)H&¢\u0006\u0004\b*\u0010+J\u0017\u0010*\u001a\u00020)2\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b*\u0010,J\u0017\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020)H&¢\u0006\u0004\b.\u0010/J\u0017\u00100\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020)H&¢\u0006\u0004\b0\u00101J'\u0010.\u001a\u00020\u00172\u0006\u0010-\u001a\u00020)2\u0006\u00102\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\b.\u00103J\u001f\u00100\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b0\u00104J\u0017\u00106\u001a\u00020\t2\u0006\u0010-\u001a\u000205H&¢\u0006\u0004\b6\u00107J\u000f\u00109\u001a\u000208H&¢\u0006\u0004\b9\u0010:J\u0017\u00109\u001a\u0002082\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b9\u0010;J\u0011\u0010<\u001a\u0004\u0018\u000108H&¢\u0006\u0004\b<\u0010:J\u000f\u0010=\u001a\u000208H&¢\u0006\u0004\b=\u0010:J\u0017\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020\tH&¢\u0006\u0004\b=\u0010;J\u000f\u0010?\u001a\u00020\u0017H&¢\u0006\u0004\b?\u0010\u0019J\u0017\u0010B\u001a\u0002082\u0006\u0010A\u001a\u00020@H&¢\u0006\u0004\bB\u0010CJ\u001f\u0010B\u001a\u0002082\u0006\u0010\n\u001a\u00020\t2\u0006\u0010A\u001a\u00020@H&¢\u0006\u0004\bB\u0010DJ\u0017\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u0010H&¢\u0006\u0004\bF\u0010GJ\u001f\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\tH&¢\u0006\u0004\bF\u0010IJ'\u0010F\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\t2\u0006\u0010J\u001a\u00020\tH&¢\u0006\u0004\bF\u0010KJ\u0017\u0010F\u001a\u00020\t2\u0006\u0010L\u001a\u00020!H&¢\u0006\u0004\bF\u0010MJ\u001f\u0010F\u001a\u00020\t2\u0006\u0010L\u001a\u00020!2\u0006\u0010H\u001a\u00020\tH&¢\u0006\u0004\bF\u0010NJ\u0017\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020!H&¢\u0006\u0004\bP\u0010MJ\u001f\u0010P\u001a\u00020\t2\u0006\u0010O\u001a\u00020!2\u0006\u0010H\u001a\u00020\tH&¢\u0006\u0004\bP\u0010NJ\u001f\u0010Q\u001a\u00020\u00062\u0006\u00102\u001a\u00020\t2\u0006\u0010L\u001a\u00020!H&¢\u0006\u0004\bQ\u0010RJ/\u0010Q\u001a\u00020\u00062\u0006\u00102\u001a\u00020\t2\u0006\u0010L\u001a\u00020!2\u0006\u0010S\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u0017H&¢\u0006\u0004\bQ\u0010TJ\u000f\u0010U\u001a\u00020\u0000H&¢\u0006\u0004\bU\u0010VJ\u000f\u0010X\u001a\u00020WH&¢\u0006\u0004\bX\u0010YR\u0016\u0010\u0004\u001a\u00020\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010\u0005¨\u0006["}, d2 = {"Lokio/BufferedSource;", "Lokio/Source;", "Ljava/nio/channels/ReadableByteChannel;", "Lokio/Buffer;", "buffer", "()Lokio/Buffer;", "", "exhausted", "()Z", "", DecodeProducer.EXTRA_BITMAP_BYTES, "", "require", "(J)V", "request", "(J)Z", "", "readByte", "()B", "", "readShort", "()S", "readShortLe", "", "readInt", "()I", "readIntLe", "readLong", "()J", "readLongLe", "readDecimalLong", "readHexadecimalUnsignedLong", "skip", "Lokio/ByteString;", "readByteString", "()Lokio/ByteString;", "(J)Lokio/ByteString;", "Lokio/Options;", "options", "select", "(Lokio/Options;)I", "", "readByteArray", "()[B", "(J)[B", "sink", "read", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "(Lokio/Buffer;J)V", "Lokio/Sink;", "readAll", "(Lokio/Sink;)J", "", "readUtf8", "()Ljava/lang/String;", "(J)Ljava/lang/String;", "readUtf8Line", "readUtf8LineStrict", "limit", "readUtf8CodePoint", "Ljava/nio/charset/Charset;", "charset", "readString", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", AuthSource.BOOKING_ORDER, "indexOf", "(B)J", "fromIndex", "(BJ)J", "toIndex", "(BJJ)J", "bytes", "(Lokio/ByteString;)J", "(Lokio/ByteString;J)J", "targetBytes", "indexOfElement", "rangeEquals", "(JLokio/ByteString;)Z", "bytesOffset", "(JLokio/ByteString;II)Z", "peek", "()Lokio/BufferedSource;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "getBuffer", "okio"}, k = 1, mv = {1, 4, 0})
public interface BufferedSource extends Source, ReadableByteChannel {
    @Override // okio.BufferedSink
    @Deprecated(level = DeprecationLevel.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @ReplaceWith(expression = "buffer", imports = {}))
    @NotNull
    Buffer buffer();

    boolean exhausted() throws IOException;

    @Override // okio.BufferedSink
    @NotNull
    Buffer getBuffer();

    long indexOf(byte b) throws IOException;

    long indexOf(byte b, long j) throws IOException;

    long indexOf(byte b, long j, long j2) throws IOException;

    long indexOf(@NotNull ByteString byteString) throws IOException;

    long indexOf(@NotNull ByteString byteString, long j) throws IOException;

    long indexOfElement(@NotNull ByteString byteString) throws IOException;

    long indexOfElement(@NotNull ByteString byteString, long j) throws IOException;

    @NotNull
    InputStream inputStream();

    @NotNull
    BufferedSource peek();

    boolean rangeEquals(long j, @NotNull ByteString byteString) throws IOException;

    boolean rangeEquals(long j, @NotNull ByteString byteString, int i, int i2) throws IOException;

    int read(@NotNull byte[] bArr) throws IOException;

    int read(@NotNull byte[] bArr, int i, int i2) throws IOException;

    long readAll(@NotNull Sink sink) throws IOException;

    byte readByte() throws IOException;

    @NotNull
    byte[] readByteArray() throws IOException;

    @NotNull
    byte[] readByteArray(long j) throws IOException;

    @NotNull
    ByteString readByteString() throws IOException;

    @NotNull
    ByteString readByteString(long j) throws IOException;

    long readDecimalLong() throws IOException;

    void readFully(@NotNull Buffer buffer, long j) throws IOException;

    void readFully(@NotNull byte[] bArr) throws IOException;

    long readHexadecimalUnsignedLong() throws IOException;

    int readInt() throws IOException;

    int readIntLe() throws IOException;

    long readLong() throws IOException;

    long readLongLe() throws IOException;

    short readShort() throws IOException;

    short readShortLe() throws IOException;

    @NotNull
    String readString(long j, @NotNull Charset charset) throws IOException;

    @NotNull
    String readString(@NotNull Charset charset) throws IOException;

    @NotNull
    String readUtf8() throws IOException;

    @NotNull
    String readUtf8(long j) throws IOException;

    int readUtf8CodePoint() throws IOException;

    @Nullable
    String readUtf8Line() throws IOException;

    @NotNull
    String readUtf8LineStrict() throws IOException;

    @NotNull
    String readUtf8LineStrict(long j) throws IOException;

    boolean request(long j) throws IOException;

    void require(long j) throws IOException;

    int select(@NotNull Options options) throws IOException;

    void skip(long j) throws IOException;
}
