package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u00002\u00020\u0001:\u00011BG\u0012\u0006\u0010\u000e\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b/\u00100J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0012\u0010\t\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\n\u0010\u0004J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJT\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u000e\u001a\u00020\u00022\b\b\u0002\u0010\u000f\u001a\u00020\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0004J\u0010\u0010\u0018\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u001a\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aHÖ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0019J \u0010$\u001a\u00020#2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0017HÖ\u0001¢\u0006\u0004\b$\u0010%R\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010&\u001a\u0004\b'\u0010\bR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010(\u001a\u0004\b)\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010(\u001a\u0004\b*\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010(\u001a\u0004\b+\u0010\u0004R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010,\u001a\u0004\b-\u0010\rR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010(\u001a\u0004\b.\u0010\u0004¨\u00062"}, d2 = {"Lcom/avito/android/remote/model/LimitsInfo;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/LimitsInfo$Progress;", "component3", "()Lcom/avito/android/remote/model/LimitsInfo$Progress;", "component4", "component5", "Lcom/avito/android/remote/model/text/AttributedText;", "component6", "()Lcom/avito/android/remote/model/text/AttributedText;", "title", "description", "progress", "category", "location", "extraInfo", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/LimitsInfo$Progress;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)Lcom/avito/android/remote/model/LimitsInfo;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/LimitsInfo$Progress;", "getProgress", "Ljava/lang/String;", "getCategory", "getDescription", "getTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getExtraInfo", "getLocation", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/LimitsInfo$Progress;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;)V", "Progress", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
public final class LimitsInfo implements Parcelable {
    public static final Parcelable.Creator<LimitsInfo> CREATOR = new Creator();
    @SerializedName("category")
    @Nullable
    private final String category;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("extraInfo")
    @Nullable
    private final AttributedText extraInfo;
    @SerializedName("location")
    @Nullable
    private final String location;
    @SerializedName("progress")
    @Nullable
    private final Progress progress;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LimitsInfo> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfo createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new LimitsInfo(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Progress.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString(), (AttributedText) parcel.readParcelable(LimitsInfo.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LimitsInfo[] newArray(int i) {
            return new LimitsInfo[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b\b\u0018\u00002\u00020\u0001:\u0001)B'\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b'\u0010(J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÂ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u0010\u0010\nJ\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0017\u001a\u00020\u00162\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0019\u0010\u0013J \u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fR\u0013\u0010!\u001a\u00020\u00028F@\u0006¢\u0006\u0006\u001a\u0004\b \u0010\u0004R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00028\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\"R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010#\u001a\u0004\b$\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010%\u001a\u0004\b&\u0010\u0007¨\u0006*"}, d2 = {"Lcom/avito/android/remote/model/LimitsInfo$Progress;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", "component2", "()Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", "", "component1", "()F", "", "component3", "()Ljava/lang/String;", "value", "_style", "progressHint", "copy", "(FLcom/avito/android/remote/model/LimitsInfo$Progress$Style;Ljava/lang/String;)Lcom/avito/android/remote/model/LimitsInfo$Progress;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getStyle", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", "Ljava/lang/String;", "getProgressHint", "F", "getValue", "<init>", "(FLcom/avito/android/remote/model/LimitsInfo$Progress$Style;Ljava/lang/String;)V", "Style", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
    public static final class Progress implements Parcelable {
        public static final Parcelable.Creator<Progress> CREATOR = new Creator();
        @SerializedName(AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE)
        private final Style _style;
        @SerializedName("hint")
        @Nullable
        private final String progressHint;
        @SerializedName("value")
        private final float value;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Progress> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Progress createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Progress(parcel.readFloat(), parcel.readInt() != 0 ? (Style) Enum.valueOf(Style.class, parcel.readString()) : null, parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Progress[] newArray(int i) {
                return new Progress[i];
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/remote/model/LimitsInfo$Progress$Style;", "", "<init>", "(Ljava/lang/String;I)V", "NORMAL", "WARNING", "publish-limits-info_release"}, k = 1, mv = {1, 4, 2})
        public enum Style {
            NORMAL,
            WARNING
        }

        public Progress(float f, @Nullable Style style, @Nullable String str) {
            this.value = f;
            this._style = style;
            this.progressHint = str;
        }

        private final Style component2() {
            return this._style;
        }

        public static /* synthetic */ Progress copy$default(Progress progress, float f, Style style, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                f = progress.value;
            }
            if ((i & 2) != 0) {
                style = progress._style;
            }
            if ((i & 4) != 0) {
                str = progress.progressHint;
            }
            return progress.copy(f, style, str);
        }

        public final float component1() {
            return this.value;
        }

        @Nullable
        public final String component3() {
            return this.progressHint;
        }

        @NotNull
        public final Progress copy(float f, @Nullable Style style, @Nullable String str) {
            return new Progress(f, style, str);
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
            if (!(obj instanceof Progress)) {
                return false;
            }
            Progress progress = (Progress) obj;
            return Float.compare(this.value, progress.value) == 0 && Intrinsics.areEqual(this._style, progress._style) && Intrinsics.areEqual(this.progressHint, progress.progressHint);
        }

        @Nullable
        public final String getProgressHint() {
            return this.progressHint;
        }

        @NotNull
        public final Style getStyle() {
            Style style = this._style;
            return style != null ? style : Style.NORMAL;
        }

        public final float getValue() {
            return this.value;
        }

        @Override // java.lang.Object
        public int hashCode() {
            int floatToIntBits = Float.floatToIntBits(this.value) * 31;
            Style style = this._style;
            int i = 0;
            int hashCode = (floatToIntBits + (style != null ? style.hashCode() : 0)) * 31;
            String str = this.progressHint;
            if (str != null) {
                i = str.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Progress(value=");
            L.append(this.value);
            L.append(", _style=");
            L.append(this._style);
            L.append(", progressHint=");
            return a.t(L, this.progressHint, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeFloat(this.value);
            Style style = this._style;
            if (style != null) {
                parcel.writeInt(1);
                parcel.writeString(style.name());
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.progressHint);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Progress(float f, Style style, String str, int i, j jVar) {
            this(f, (i & 2) != 0 ? Style.NORMAL : style, (i & 4) != 0 ? null : str);
        }
    }

    public LimitsInfo(@NotNull String str, @NotNull String str2, @Nullable Progress progress2, @Nullable String str3, @Nullable String str4, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.title = str;
        this.description = str2;
        this.progress = progress2;
        this.category = str3;
        this.location = str4;
        this.extraInfo = attributedText;
    }

    public static /* synthetic */ LimitsInfo copy$default(LimitsInfo limitsInfo, String str, String str2, Progress progress2, String str3, String str4, AttributedText attributedText, int i, Object obj) {
        if ((i & 1) != 0) {
            str = limitsInfo.title;
        }
        if ((i & 2) != 0) {
            str2 = limitsInfo.description;
        }
        if ((i & 4) != 0) {
            progress2 = limitsInfo.progress;
        }
        if ((i & 8) != 0) {
            str3 = limitsInfo.category;
        }
        if ((i & 16) != 0) {
            str4 = limitsInfo.location;
        }
        if ((i & 32) != 0) {
            attributedText = limitsInfo.extraInfo;
        }
        return limitsInfo.copy(str, str2, progress2, str3, str4, attributedText);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final Progress component3() {
        return this.progress;
    }

    @Nullable
    public final String component4() {
        return this.category;
    }

    @Nullable
    public final String component5() {
        return this.location;
    }

    @Nullable
    public final AttributedText component6() {
        return this.extraInfo;
    }

    @NotNull
    public final LimitsInfo copy(@NotNull String str, @NotNull String str2, @Nullable Progress progress2, @Nullable String str3, @Nullable String str4, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new LimitsInfo(str, str2, progress2, str3, str4, attributedText);
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
        if (!(obj instanceof LimitsInfo)) {
            return false;
        }
        LimitsInfo limitsInfo = (LimitsInfo) obj;
        return Intrinsics.areEqual(this.title, limitsInfo.title) && Intrinsics.areEqual(this.description, limitsInfo.description) && Intrinsics.areEqual(this.progress, limitsInfo.progress) && Intrinsics.areEqual(this.category, limitsInfo.category) && Intrinsics.areEqual(this.location, limitsInfo.location) && Intrinsics.areEqual(this.extraInfo, limitsInfo.extraInfo);
    }

    @Nullable
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final AttributedText getExtraInfo() {
        return this.extraInfo;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final Progress getProgress() {
        return this.progress;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Progress progress2 = this.progress;
        int hashCode3 = (hashCode2 + (progress2 != null ? progress2.hashCode() : 0)) * 31;
        String str3 = this.category;
        int hashCode4 = (hashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.location;
        int hashCode5 = (hashCode4 + (str4 != null ? str4.hashCode() : 0)) * 31;
        AttributedText attributedText = this.extraInfo;
        if (attributedText != null) {
            i = attributedText.hashCode();
        }
        return hashCode5 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("LimitsInfo(title=");
        L.append(this.title);
        L.append(", description=");
        L.append(this.description);
        L.append(", progress=");
        L.append(this.progress);
        L.append(", category=");
        L.append(this.category);
        L.append(", location=");
        L.append(this.location);
        L.append(", extraInfo=");
        L.append(this.extraInfo);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Progress progress2 = this.progress;
        if (progress2 != null) {
            parcel.writeInt(1);
            progress2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.category);
        parcel.writeString(this.location);
        parcel.writeParcelable(this.extraInfo, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LimitsInfo(String str, String str2, Progress progress2, String str3, String str4, AttributedText attributedText, int i, j jVar) {
        this(str, str2, (i & 4) != 0 ? null : progress2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : attributedText);
    }
}
