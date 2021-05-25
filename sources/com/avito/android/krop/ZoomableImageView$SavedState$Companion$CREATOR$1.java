package com.avito.android.krop;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.krop.ZoomableImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"com/avito/android/krop/ZoomableImageView$SavedState$Companion$CREATOR$1", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/krop/ZoomableImageView$SavedState;", "Landroid/os/Parcel;", "parcel", "createFromParcel", "(Landroid/os/Parcel;)Lcom/avito/android/krop/ZoomableImageView$SavedState;", "", "size", "", "newArray", "(I)[Lcom/avito/android/krop/ZoomableImageView$SavedState;", "krop_release"}, k = 1, mv = {1, 4, 0})
public final class ZoomableImageView$SavedState$Companion$CREATOR$1 implements Parcelable.Creator<ZoomableImageView.SavedState> {
    @Override // android.os.Parcelable.Creator
    @NotNull
    public ZoomableImageView.SavedState createFromParcel(@NotNull Parcel parcel) {
        Intrinsics.checkParameterIsNotNull(parcel, "parcel");
        return new ZoomableImageView.SavedState(parcel);
    }

    @Override // android.os.Parcelable.Creator
    @NotNull
    public ZoomableImageView.SavedState[] newArray(int i) {
        return new ZoomableImageView.SavedState[i];
    }
}
