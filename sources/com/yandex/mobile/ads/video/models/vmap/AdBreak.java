package com.yandex.mobile.ads.video.models.vmap;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.mobile.ads.impl.vh;
import com.yandex.mobile.ads.video.models.common.Extension;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public final class AdBreak implements Parcelable {
    public static final Parcelable.Creator<AdBreak> CREATOR = new Parcelable.Creator<AdBreak>() { // from class: com.yandex.mobile.ads.video.models.vmap.AdBreak.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ AdBreak createFromParcel(@NonNull Parcel parcel) {
            return new AdBreak(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ AdBreak[] newArray(int i) {
            return new AdBreak[i];
        }
    };
    @NonNull
    private final AdSource a;
    @Nullable
    private final String b;
    @Nullable
    private final Long c;
    @NonNull
    private final TimeOffset d;
    @NonNull
    private final List<String> e;
    @NonNull
    private final List<Extension> f;
    @NonNull
    private final Map<String, List<String>> g;
    @Nullable
    private vh h;

    public static final class BreakId {
        public static final String INPAGE = "inpage";
        public static final String MIDROLL = "midroll";
        public static final String PAUSEROLL = "pauseroll";
        public static final String POSTROLL = "postroll";
        public static final String PREROLL = "preroll";
    }

    public static final class BreakType {
        public static final String DISPLAY = "display";
        public static final String LINEAR = "linear";
        public static final String NONLINEAR = "nonlinear";
    }

    public AdBreak(@NonNull AdSource adSource, @Nullable String str, @Nullable Long l, @NonNull TimeOffset timeOffset, @NonNull List<String> list, @NonNull List<Extension> list2, @NonNull Map<String, List<String>> map) {
        this.a = adSource;
        this.b = str;
        this.e = list;
        this.c = l;
        this.d = timeOffset;
        this.f = list2;
        this.g = map;
    }

    public final void a(@NonNull vh vhVar) {
        this.h = vhVar;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @NonNull
    public final AdSource getAdSource() {
        return this.a;
    }

    @Nullable
    public final String getBreakId() {
        return this.b;
    }

    @NonNull
    public final List<String> getBreakTypes() {
        return this.e;
    }

    @NonNull
    public final List<Extension> getExtensions() {
        return this.f;
    }

    @Nullable
    public final Long getRepeatAfterMillis() {
        return this.c;
    }

    @NonNull
    public final TimeOffset getTimeOffset() {
        return this.d;
    }

    @NonNull
    public final Map<String, List<String>> getTrackingEvents() {
        return this.g;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeParcelable(this.a, i);
        parcel.writeString(this.b);
        parcel.writeValue(this.c);
        parcel.writeParcelable(this.d, i);
        parcel.writeStringList(this.e);
        parcel.writeTypedList(this.f);
        parcel.writeParcelable(this.h, i);
        parcel.writeInt(this.g.size());
        for (Map.Entry<String, List<String>> entry : this.g.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeStringList(entry.getValue());
        }
    }

    @Nullable
    public final vh a() {
        return this.h;
    }

    public AdBreak(@NonNull Parcel parcel) {
        this.a = (AdSource) parcel.readParcelable(AdSource.class.getClassLoader());
        this.b = parcel.readString();
        this.c = (Long) parcel.readValue(Long.class.getClassLoader());
        this.d = (TimeOffset) parcel.readParcelable(TimeOffset.class.getClassLoader());
        this.e = parcel.createStringArrayList();
        this.f = parcel.createTypedArrayList(Extension.CREATOR);
        this.h = (vh) parcel.readParcelable(vh.class.getClassLoader());
        this.g = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.g.put(parcel.readString(), parcel.createStringArrayList());
        }
    }
}
