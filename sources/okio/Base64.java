package okio;

import com.avito.android.remote.auth.AuthSource;
import com.google.common.base.Ascii;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u000e\n\u0002\u0010\u0012\n\u0002\b\u000e\u001a\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0001*\u00020\u0000H\u0000¢\u0006\u0004\b\u0002\u0010\u0003\u001a\u001d\u0010\u0005\u001a\u00020\u0000*\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u0001H\u0000¢\u0006\u0004\b\u0005\u0010\u0006\"\u001c\u0010\u000b\u001a\u00020\u00018\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u001c\u0010\u000e\u001a\u00020\u00018\u0000@\u0000X\u0004¢\u0006\f\n\u0004\b\f\u0010\b\u001a\u0004\b\r\u0010\n¨\u0006\u000f"}, d2 = {"", "", "decodeBase64ToArray", "(Ljava/lang/String;)[B", "map", "encodeBase64", "([B[B)Ljava/lang/String;", AuthSource.SEND_ABUSE, "[B", "getBASE64", "()[B", "BASE64", AuthSource.BOOKING_ORDER, "getBASE64_URL_SAFE", "BASE64_URL_SAFE", "okio"}, k = 2, mv = {1, 4, 0})
@JvmName(name = "-Base64")
/* renamed from: okio.-Base64  reason: invalid class name */
public final class Base64 {
    @NotNull
    public static final byte[] a;
    @NotNull
    public static final byte[] b;

    static {
        ByteString.Companion companion = ByteString.Companion;
        a = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/").getData$okio();
        b = companion.encodeUtf8("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_").getData$okio();
    }

    @Nullable
    public static final byte[] decodeBase64ToArray(@NotNull String str) {
        int i;
        Intrinsics.checkNotNullParameter(str, "$this$decodeBase64ToArray");
        int length = str.length();
        while (length > 0 && ((r5 = str.charAt(length - 1)) == '=' || r5 == '\n' || r5 == '\r' || r5 == ' ' || r5 == '\t')) {
            length--;
        }
        int i2 = (int) ((((long) length) * 6) / 8);
        byte[] bArr = new byte[i2];
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < length; i6++) {
            char charAt = str.charAt(i6);
            if ('A' <= charAt && 'Z' >= charAt) {
                i = charAt - 'A';
            } else if ('a' <= charAt && 'z' >= charAt) {
                i = charAt - 'G';
            } else if ('0' <= charAt && '9' >= charAt) {
                i = charAt + 4;
            } else if (charAt == '+' || charAt == '-') {
                i = 62;
            } else if (charAt == '/' || charAt == '_') {
                i = 63;
            } else {
                if (!(charAt == '\n' || charAt == '\r' || charAt == ' ' || charAt == '\t')) {
                    return null;
                }
            }
            i4 = (i4 << 6) | i;
            i3++;
            if (i3 % 4 == 0) {
                int i7 = i5 + 1;
                bArr[i5] = (byte) (i4 >> 16);
                int i8 = i7 + 1;
                bArr[i7] = (byte) (i4 >> 8);
                bArr[i8] = (byte) i4;
                i5 = i8 + 1;
            }
        }
        int i9 = i3 % 4;
        if (i9 == 1) {
            return null;
        }
        if (i9 == 2) {
            bArr[i5] = (byte) ((i4 << 12) >> 16);
            i5++;
        } else if (i9 == 3) {
            int i10 = i4 << 6;
            int i11 = i5 + 1;
            bArr[i5] = (byte) (i10 >> 16);
            i5 = i11 + 1;
            bArr[i11] = (byte) (i10 >> 8);
        }
        if (i5 == i2) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i5);
        Intrinsics.checkNotNullExpressionValue(copyOf, "java.util.Arrays.copyOf(this, newSize)");
        return copyOf;
    }

    @NotNull
    public static final String encodeBase64(@NotNull byte[] bArr, @NotNull byte[] bArr2) {
        Intrinsics.checkNotNullParameter(bArr, "$this$encodeBase64");
        Intrinsics.checkNotNullParameter(bArr2, "map");
        byte[] bArr3 = new byte[(((bArr.length + 2) / 3) * 4)];
        int length = bArr.length - (bArr.length % 3);
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = i + 1;
            byte b2 = bArr[i];
            int i4 = i3 + 1;
            byte b3 = bArr[i3];
            int i5 = i4 + 1;
            byte b4 = bArr[i4];
            int i6 = i2 + 1;
            bArr3[i2] = bArr2[(b2 & 255) >> 2];
            int i7 = i6 + 1;
            bArr3[i6] = bArr2[((b2 & 3) << 4) | ((b3 & 255) >> 4)];
            int i8 = i7 + 1;
            bArr3[i7] = bArr2[((b3 & Ascii.SI) << 2) | ((b4 & 255) >> 6)];
            i2 = i8 + 1;
            bArr3[i8] = bArr2[b4 & Utf8.REPLACEMENT_BYTE];
            i = i5;
        }
        int length2 = bArr.length - length;
        if (length2 == 1) {
            byte b5 = bArr[i];
            int i9 = i2 + 1;
            bArr3[i2] = bArr2[(b5 & 255) >> 2];
            int i10 = i9 + 1;
            bArr3[i9] = bArr2[(b5 & 3) << 4];
            byte b6 = (byte) 61;
            bArr3[i10] = b6;
            bArr3[i10 + 1] = b6;
        } else if (length2 == 2) {
            int i11 = i + 1;
            byte b8 = bArr[i];
            byte b9 = bArr[i11];
            int i12 = i2 + 1;
            bArr3[i2] = bArr2[(b8 & 255) >> 2];
            int i13 = i12 + 1;
            bArr3[i12] = bArr2[((b8 & 3) << 4) | ((b9 & 255) >> 4)];
            bArr3[i13] = bArr2[(b9 & Ascii.SI) << 2];
            bArr3[i13 + 1] = (byte) 61;
        }
        return Platform.toUtf8String(bArr3);
    }

    public static /* synthetic */ String encodeBase64$default(byte[] bArr, byte[] bArr2, int i, Object obj) {
        if ((i & 1) != 0) {
            bArr2 = a;
        }
        return encodeBase64(bArr, bArr2);
    }

    @NotNull
    public static final byte[] getBASE64() {
        return a;
    }

    @NotNull
    public static final byte[] getBASE64_URL_SAFE() {
        return b;
    }
}
