package com.google.android.gms.common.internal.safeparcel;

import androidx.annotation.RecentlyNonNull;
public abstract class AbstractSafeParcelable implements SafeParcelable {
    @Override // android.os.Parcelable
    @RecentlyNonNull
    public final int describeContents() {
        return 0;
    }
}
