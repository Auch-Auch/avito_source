package com.avito.android.location_picker.entities;

import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/avito/android/location_picker/entities/ActivityResult;", "", "", AuthSource.SEND_ABUSE, "I", "getRequestCode", "()I", "requestCode", "", AuthSource.BOOKING_ORDER, "Z", "isSuccess", "()Z", "Landroid/os/Parcelable;", "data", "<init>", "(IZLandroid/os/Parcelable;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class ActivityResult {
    public final int a;
    public final boolean b;

    public ActivityResult(int i, boolean z, @Nullable Parcelable parcelable) {
        this.a = i;
        this.b = z;
    }

    public final int getRequestCode() {
        return this.a;
    }

    public final boolean isSuccess() {
        return this.b;
    }
}
