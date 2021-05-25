package com.avito.android.util;

import android.os.Parcel;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"", "Landroid/os/Parcel;", "unmarshallToParcel", "([B)Landroid/os/Parcel;", "android_release"}, k = 2, mv = {1, 4, 2})
@JvmName(name = "ByteArrays")
public final class ByteArrays {
    @NotNull
    public static final Parcel unmarshallToParcel(@NotNull byte[] bArr) {
        Intrinsics.checkNotNullParameter(bArr, "$this$unmarshallToParcel");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        return obtain;
    }
}
