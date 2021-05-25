package kotlin.reflect.jvm.internal.impl.metadata.jvm.deserialization;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
public final class UtfEncodingKt {
    @NotNull
    public static final byte[] stringsToBytes(@NotNull String[] strArr) {
        int i;
        Intrinsics.checkNotNullParameter(strArr, "strings");
        int i2 = 0;
        for (String str : strArr) {
            i2 += str.length();
        }
        byte[] bArr = new byte[i2];
        int length = strArr.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            String str2 = strArr[i3];
            i3++;
            int length2 = str2.length() - 1;
            if (length2 >= 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i5 + 1;
                    i = i4 + 1;
                    bArr[i4] = (byte) str2.charAt(i5);
                    if (i5 == length2) {
                        break;
                    }
                    i5 = i6;
                    i4 = i;
                }
                i4 = i;
            }
        }
        return bArr;
    }
}
