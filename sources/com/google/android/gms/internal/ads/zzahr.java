package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Map;
@SafeParcelable.Class(creator = "HttpRequestParcelCreator")
public final class zzahr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzahr> CREATOR = new zzahu();
    @SafeParcelable.Field(id = 1)
    private final String url;
    @SafeParcelable.Field(id = 2)
    private final String[] zzdey;
    @SafeParcelable.Field(id = 3)
    private final String[] zzdez;

    @SafeParcelable.Constructor
    public zzahr(@SafeParcelable.Param(id = 1) String str, @SafeParcelable.Param(id = 2) String[] strArr, @SafeParcelable.Param(id = 3) String[] strArr2) {
        this.url = str;
        this.zzdey = strArr;
        this.zzdez = strArr2;
    }

    public static zzahr zzh(zzaa<?> zzaa) throws zzl {
        Map<String, String> headers = zzaa.getHeaders();
        int size = headers.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i = 0;
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            strArr[i] = entry.getKey();
            strArr2[i] = entry.getValue();
            i++;
        }
        return new zzahr(zzaa.getUrl(), strArr, strArr2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.url, false);
        SafeParcelWriter.writeStringArray(parcel, 2, this.zzdey, false);
        SafeParcelWriter.writeStringArray(parcel, 3, this.zzdez, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
