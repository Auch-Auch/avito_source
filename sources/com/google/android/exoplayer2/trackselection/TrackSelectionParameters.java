package com.google.android.exoplayer2.trackselection;

import android.content.Context;
import android.os.Looper;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.accessibility.CaptioningManager;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Util;
import java.util.Locale;
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR = new a();
    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final int disabledTextTrackSelectionFlags;
    @Nullable
    public final String preferredAudioLanguage;
    @Nullable
    public final String preferredTextLanguage;
    public final int preferredTextRoleFlags;
    public final boolean selectUndeterminedTextLanguage;

    public class a implements Parcelable.Creator<TrackSelectionParameters> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrackSelectionParameters createFromParcel(Parcel parcel) {
            return new TrackSelectionParameters(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public TrackSelectionParameters[] newArray(int i) {
            return new TrackSelectionParameters[i];
        }
    }

    static {
        TrackSelectionParameters build = new Builder().build();
        DEFAULT_WITHOUT_CONTEXT = build;
        DEFAULT = build;
    }

    public TrackSelectionParameters(@Nullable String str, @Nullable String str2, int i, boolean z, int i2) {
        this.preferredAudioLanguage = Util.normalizeLanguageCode(str);
        this.preferredTextLanguage = Util.normalizeLanguageCode(str2);
        this.preferredTextRoleFlags = i;
        this.selectUndeterminedTextLanguage = z;
        this.disabledTextTrackSelectionFlags = i2;
    }

    public static TrackSelectionParameters getDefaults(Context context) {
        return new Builder(context).build();
    }

    public Builder buildUpon() {
        return new Builder(this);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
        if (TextUtils.equals(this.preferredAudioLanguage, trackSelectionParameters.preferredAudioLanguage) && TextUtils.equals(this.preferredTextLanguage, trackSelectionParameters.preferredTextLanguage) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.disabledTextTrackSelectionFlags == trackSelectionParameters.disabledTextTrackSelectionFlags) {
            return true;
        }
        return false;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.preferredAudioLanguage;
        int i = 0;
        int hashCode = ((str == null ? 0 : str.hashCode()) + 31) * 31;
        String str2 = this.preferredTextLanguage;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return ((((((hashCode + i) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.preferredAudioLanguage);
        parcel.writeString(this.preferredTextLanguage);
        parcel.writeInt(this.preferredTextRoleFlags);
        Util.writeBoolean(parcel, this.selectUndeterminedTextLanguage);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
    }

    public static class Builder {
        @Nullable
        public String a;
        @Nullable
        public String b;
        public int c;
        public boolean d;
        public int e;

        public Builder(Context context) {
            this();
            setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(context);
        }

        public TrackSelectionParameters build() {
            return new TrackSelectionParameters(this.a, this.b, this.c, this.d, this.e);
        }

        public Builder setDisabledTextTrackSelectionFlags(int i) {
            this.e = i;
            return this;
        }

        public Builder setPreferredAudioLanguage(@Nullable String str) {
            this.a = str;
            return this;
        }

        public Builder setPreferredTextLanguage(@Nullable String str) {
            this.b = str;
            return this;
        }

        public Builder setPreferredTextLanguageAndRoleFlagsToCaptioningManagerSettings(Context context) {
            CaptioningManager captioningManager;
            int i = Util.SDK_INT;
            if (i >= 19 && ((i >= 23 || Looper.myLooper() != null) && (captioningManager = (CaptioningManager) context.getSystemService("captioning")) != null && captioningManager.isEnabled())) {
                this.c = 1088;
                Locale locale = captioningManager.getLocale();
                if (locale != null) {
                    this.b = Util.getLocaleLanguageTag(locale);
                }
            }
            return this;
        }

        public Builder setPreferredTextRoleFlags(int i) {
            this.c = i;
            return this;
        }

        public Builder setSelectUndeterminedTextLanguage(boolean z) {
            this.d = z;
            return this;
        }

        @Deprecated
        public Builder() {
            this.a = null;
            this.b = null;
            this.c = 0;
            this.d = false;
            this.e = 0;
        }

        public Builder(TrackSelectionParameters trackSelectionParameters) {
            this.a = trackSelectionParameters.preferredAudioLanguage;
            this.b = trackSelectionParameters.preferredTextLanguage;
            this.c = trackSelectionParameters.preferredTextRoleFlags;
            this.d = trackSelectionParameters.selectUndeterminedTextLanguage;
            this.e = trackSelectionParameters.disabledTextTrackSelectionFlags;
        }
    }

    public TrackSelectionParameters(Parcel parcel) {
        this.preferredAudioLanguage = parcel.readString();
        this.preferredTextLanguage = parcel.readString();
        this.preferredTextRoleFlags = parcel.readInt();
        this.selectUndeterminedTextLanguage = Util.readBoolean(parcel);
        this.disabledTextTrackSelectionFlags = parcel.readInt();
    }
}
