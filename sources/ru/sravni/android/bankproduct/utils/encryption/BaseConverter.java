package ru.sravni.android.bankproduct.utils.encryption;

import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lru/sravni/android/bankproduct/utils/encryption/BaseConverter;", "Lru/sravni/android/bankproduct/utils/encryption/IBaseConverter;", "", "source", "", "stringToByte", "(Ljava/lang/String;)[B", "byteToString", "([B)Ljava/lang/String;", "<init>", "()V", "sravnichat_release"}, k = 1, mv = {1, 4, 0})
public final class BaseConverter implements IBaseConverter {
    @Override // ru.sravni.android.bankproduct.utils.encryption.IBaseConverter
    @NotNull
    public String byteToString(@NotNull byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "source");
        String encodeToString = Base64.encodeToString(bArr, 0);
        Intrinsics.checkExpressionValueIsNotNull(encodeToString, "Base64.encodeToString(source, Base64.DEFAULT)");
        return encodeToString;
    }

    @Override // ru.sravni.android.bankproduct.utils.encryption.IBaseConverter
    @NotNull
    public byte[] stringToByte(@NotNull String str) {
        Intrinsics.checkParameterIsNotNull(str, "source");
        byte[] decode = Base64.decode(str, 0);
        Intrinsics.checkExpressionValueIsNotNull(decode, "Base64.decode(source, Base64.DEFAULT)");
        return decode;
    }
}
