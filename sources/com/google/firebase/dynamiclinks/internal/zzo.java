package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.List;
@SafeParcelable.Class(creator = "ShortDynamicLinkImplCreator")
public final class zzo extends AbstractSafeParcelable implements ShortDynamicLink {
    public static final Parcelable.Creator<zzo> CREATOR = new zzq();
    @SafeParcelable.Field(getter = "getShortLink", id = 1)
    public final Uri a;
    @SafeParcelable.Field(getter = "getPreviewLink", id = 2)
    public final Uri b;
    @SafeParcelable.Field(getter = "getWarnings", id = 3)
    public final List<zzr> c;

    @SafeParcelable.Constructor
    public zzo(@SafeParcelable.Param(id = 1) Uri uri, @SafeParcelable.Param(id = 2) Uri uri2, @SafeParcelable.Param(id = 3) List<zzr> list) {
        this.a = uri;
        this.b = uri2;
        this.c = list;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public final Uri getPreviewLink() {
        return this.b;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public final Uri getShortLink() {
        return this.a;
    }

    @Override // com.google.firebase.dynamiclinks.ShortDynamicLink
    public final List<zzr> getWarnings() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getShortLink(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getPreviewLink(), i, false);
        SafeParcelWriter.writeTypedList(parcel, 3, getWarnings(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
