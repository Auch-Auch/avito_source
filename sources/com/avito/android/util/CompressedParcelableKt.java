package com.avito.android.util;

import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\"\u0010\u0003\u001a\u0004\u0018\u00018\u0000\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0000*\u00020\u0002H\b¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Landroid/os/Parcelable;", "T", "Lcom/avito/android/util/CompressedParcelable;", "restore", "(Lcom/avito/android/util/CompressedParcelable;)Landroid/os/Parcelable;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class CompressedParcelableKt {
    public static final /* synthetic */ <T extends Parcelable> T restore(CompressedParcelable compressedParcelable) {
        Intrinsics.checkNotNullParameter(compressedParcelable, "$this$restore");
        Intrinsics.reifiedOperationMarker(4, "T");
        Object restore = compressedParcelable.restore(Parcelable.class);
        Intrinsics.reifiedOperationMarker(1, "T?");
        return (T) ((Parcelable) restore);
    }
}
