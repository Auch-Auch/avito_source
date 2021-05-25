package com.avito.android.util;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\b¢\u0006\u0004\b\u0002\u0010\u0003\u001a'\u0010\b\u001a\u00020\u00012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\bø\u0001\u0000¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"Landroid/os/Parcelable;", "", "marshallToByteArray", "(Landroid/os/Parcelable;)[B", "Lkotlin/Function1;", "Landroid/os/Parcel;", "", "writer", "parcelableToByteArray", "(Lkotlin/jvm/functions/Function1;)[B", "android_release"}, k = 2, mv = {1, 4, 2})
public final class ParcelablesKt {
    @NotNull
    public static final byte[] marshallToByteArray(@NotNull Parcelable parcelable) {
        Intrinsics.checkNotNullParameter(parcelable, "$this$marshallToByteArray");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        parcelable.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        Intrinsics.checkNotNullExpressionValue(marshall, "bytes");
        return marshall;
    }

    @NotNull
    public static final byte[] parcelableToByteArray(@NotNull Function1<? super Parcel, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "writer");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "Parcel.obtain()");
        function1.invoke(obtain);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        Intrinsics.checkNotNullExpressionValue(marshall, "bytes");
        return marshall;
    }
}
