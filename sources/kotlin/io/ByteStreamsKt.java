package kotlin.io;

import com.vk.sdk.api.VKApiConst;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.collections.ByteIterator;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u001a#\u0010\n\u001a\u00020\t*\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001d\u0010\u000e\u001a\u00020\r*\u00020\u00042\b\b\u0002\u0010\f\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0013\u0010\u000e\u001a\u00020\r*\u00020\u0004H\u0007¢\u0006\u0004\b\u000e\u0010\u0010¨\u0006\u0011"}, d2 = {"Ljava/io/BufferedInputStream;", "Lkotlin/collections/ByteIterator;", "iterator", "(Ljava/io/BufferedInputStream;)Lkotlin/collections/ByteIterator;", "Ljava/io/InputStream;", "Ljava/io/OutputStream;", VKApiConst.OUT, "", "bufferSize", "", "copyTo", "(Ljava/io/InputStream;Ljava/io/OutputStream;I)J", "estimatedSize", "", "readBytes", "(Ljava/io/InputStream;I)[B", "(Ljava/io/InputStream;)[B", "kotlin-stdlib"}, k = 2, mv = {1, 4, 1})
@JvmName(name = "ByteStreamsKt")
public final class ByteStreamsKt {
    public static final long copyTo(@NotNull InputStream inputStream, @NotNull OutputStream outputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$copyTo");
        Intrinsics.checkNotNullParameter(outputStream, VKApiConst.OUT);
        byte[] bArr = new byte[i];
        int read = inputStream.read(bArr);
        long j = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j += (long) read;
            read = inputStream.read(bArr);
        }
        return j;
    }

    public static /* synthetic */ long copyTo$default(InputStream inputStream, OutputStream outputStream, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 8192;
        }
        return copyTo(inputStream, outputStream, i);
    }

    @NotNull
    public static final ByteIterator iterator(@NotNull BufferedInputStream bufferedInputStream) {
        Intrinsics.checkNotNullParameter(bufferedInputStream, "$this$iterator");
        return new ByteIterator(bufferedInputStream) { // from class: kotlin.io.ByteStreamsKt$iterator$1
            public int a = -1;
            public boolean b;
            public boolean c;
            public final /* synthetic */ BufferedInputStream d;

            {
                this.d = r1;
            }

            public final void a() {
                if (!this.b && !this.c) {
                    int read = this.d.read();
                    this.a = read;
                    boolean z = true;
                    this.b = true;
                    if (read != -1) {
                        z = false;
                    }
                    this.c = z;
                }
            }

            public final boolean getFinished() {
                return this.c;
            }

            public final int getNextByte() {
                return this.a;
            }

            public final boolean getNextPrepared() {
                return this.b;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                a();
                return !this.c;
            }

            @Override // kotlin.collections.ByteIterator
            public byte nextByte() {
                a();
                if (!this.c) {
                    byte b2 = (byte) this.a;
                    this.b = false;
                    return b2;
                }
                throw new NoSuchElementException("Input stream is over.");
            }

            public final void setFinished(boolean z) {
                this.c = z;
            }

            public final void setNextByte(int i) {
                this.a = i;
            }

            public final void setNextPrepared(boolean z) {
                this.b = z;
            }
        };
    }

    @Deprecated(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @ReplaceWith(expression = "readBytes()", imports = {}))
    @NotNull
    public static final byte[] readBytes(@NotNull InputStream inputStream, int i) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }

    public static /* synthetic */ byte[] readBytes$default(InputStream inputStream, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 8192;
        }
        return readBytes(inputStream, i);
    }

    @SinceKotlin(version = "1.3")
    @NotNull
    public static final byte[] readBytes(@NotNull InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "$this$readBytes");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        copyTo$default(inputStream, byteArrayOutputStream, 0, 2, null);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "buffer.toByteArray()");
        return byteArray;
    }
}
