package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;
@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzta extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzta> CREATOR = new zzsz();
    @Nullable
    @SafeParcelable.Field(id = 2)
    public final String url;
    @SafeParcelable.Field(id = 3)
    private final long zzbuz;
    @SafeParcelable.Field(id = 4)
    private final String zzbva;
    @SafeParcelable.Field(id = 5)
    private final String zzbvb;
    @SafeParcelable.Field(id = 6)
    private final String zzbvc;
    @SafeParcelable.Field(id = 7)
    private final Bundle zzbvd;
    @SafeParcelable.Field(id = 8)
    public final boolean zzbve;
    @SafeParcelable.Field(id = 9)
    public long zzbvf;

    @SafeParcelable.Constructor
    public zzta(@Nullable @SafeParcelable.Param(id = 2) String str, @SafeParcelable.Param(id = 3) long j, @SafeParcelable.Param(id = 4) String str2, @SafeParcelable.Param(id = 5) String str3, @SafeParcelable.Param(id = 6) String str4, @SafeParcelable.Param(id = 7) Bundle bundle, @SafeParcelable.Param(id = 8) boolean z, @SafeParcelable.Param(id = 9) long j2) {
        this.url = str;
        this.zzbuz = j;
        this.zzbva = str2 == null ? "" : str2;
        this.zzbvb = str3 == null ? "" : str3;
        this.zzbvc = str4 == null ? "" : str4;
        this.zzbvd = bundle == null ? new Bundle() : bundle;
        this.zzbve = z;
        this.zzbvf = j2;
    }

    @Nullable
    public static zzta zzbw(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzta zzd(Uri uri) {
        long j;
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzbbd.zzfe(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter("url");
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            if (queryParameter2 == null) {
                j = 0;
            } else {
                j = Long.parseLong(queryParameter2);
            }
            Bundle bundle = new Bundle();
            zzp.zzkr();
            for (String str3 : uri.getQueryParameterNames()) {
                if (str3.startsWith("tag.")) {
                    bundle.putString(str3.substring(4), uri.getQueryParameter(str3));
                }
            }
            return new zzta(queryParameter, j, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzbbd.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbuz);
        SafeParcelWriter.writeString(parcel, 4, this.zzbva, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbvb, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbvc, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbvd, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbve);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbvf);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
