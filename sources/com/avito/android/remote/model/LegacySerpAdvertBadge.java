package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.badge.Badge;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002BI\u0012\u0006\u0010\"\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0004\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138V@\u0016X\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u000e\u001a\u0004\b\u001f\u0010\u0010R\u001c\u0010 \u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u000e\u001a\u0004\b!\u0010\u0010R\u001c\u0010\"\u001a\u00020\u00198\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\"\u0010\u001b\u001a\u0004\b#\u0010\u001dR\u001e\u0010$\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\u001b\u001a\u0004\b%\u0010\u001dR\u001c\u0010(\u001a\u00020\u00138V@\u0016X\u0004¢\u0006\f\u0012\u0004\b'\u0010\u0017\u001a\u0004\b&\u0010\u0015¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/LegacySerpAdvertBadge;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/badge/Badge;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "backgroundColor", "Lcom/avito/android/remote/model/Color;", "getBackgroundColor", "()Lcom/avito/android/remote/model/Color;", "titleColorDark", "getTitleColorDark", "Lcom/avito/android/remote/model/UniversalColor;", "getUniversalBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "getUniversalBackgroundColor$annotations", "()V", "universalBackgroundColor", "", "backgroundColorName", "Ljava/lang/String;", "getBackgroundColorName", "()Ljava/lang/String;", "backgroundColorDark", "getBackgroundColorDark", "titleColor", "getTitleColor", "title", "getTitle", "titleColorName", "getTitleColorName", "getUniversalTitleColor", "getUniversalTitleColor$annotations", "universalTitleColor", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LegacySerpAdvertBadge implements Parcelable, Badge {
    public static final Parcelable.Creator<LegacySerpAdvertBadge> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @Nullable
    private final Color backgroundColor;
    @SerializedName("backgroundColorDark")
    @Nullable
    private final Color backgroundColorDark;
    @SerializedName("backgroundColorName")
    @Nullable
    private final String backgroundColorName;
    @SerializedName("text")
    @NotNull
    private final String title;
    @SerializedName("textColor")
    @NotNull
    private final Color titleColor;
    @SerializedName("textColorDark")
    @Nullable
    private final Color titleColorDark;
    @SerializedName("textColorName")
    @Nullable
    private final String titleColorName;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<LegacySerpAdvertBadge> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegacySerpAdvertBadge createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            Parcelable.Creator<Color> creator = Color.CREATOR;
            return new LegacySerpAdvertBadge(readString, creator.createFromParcel(parcel), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readString(), parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readInt() != 0 ? creator.createFromParcel(parcel) : null, parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final LegacySerpAdvertBadge[] newArray(int i) {
            return new LegacySerpAdvertBadge[i];
        }
    }

    public LegacySerpAdvertBadge(@NotNull String str, @NotNull Color color, @Nullable Color color2, @Nullable String str2, @Nullable Color color3, @Nullable Color color4, @Nullable String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(color, "titleColor");
        this.title = str;
        this.titleColor = color;
        this.titleColorDark = color2;
        this.titleColorName = str2;
        this.backgroundColor = color3;
        this.backgroundColorDark = color4;
        this.backgroundColorName = str3;
    }

    public static /* synthetic */ void getUniversalBackgroundColor$annotations() {
    }

    public static /* synthetic */ void getUniversalTitleColor$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @Nullable
    public final Color getBackgroundColorDark() {
        return this.backgroundColorDark;
    }

    @Nullable
    public final String getBackgroundColorName() {
        return this.backgroundColorName;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public String getTitle() {
        return this.title;
    }

    @NotNull
    public final Color getTitleColor() {
        return this.titleColor;
    }

    @Nullable
    public final Color getTitleColorDark() {
        return this.titleColorDark;
    }

    @Nullable
    public final String getTitleColorName() {
        return this.titleColorName;
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @Nullable
    public UniversalColor getUniversalBackgroundColor() {
        Color color = this.backgroundColor;
        if (color == null && this.backgroundColorName == null) {
            return null;
        }
        return UniversalColorKt.universalColorOf(this.backgroundColorName, color, this.backgroundColorDark);
    }

    @Override // com.avito.android.remote.model.badge.Badge
    @NotNull
    public UniversalColor getUniversalTitleColor() {
        return UniversalColorKt.universalColorOf(this.titleColorName, this.titleColor, this.titleColorDark);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        this.titleColor.writeToParcel(parcel, 0);
        Color color = this.titleColorDark;
        if (color != null) {
            parcel.writeInt(1);
            color.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.titleColorName);
        Color color2 = this.backgroundColor;
        if (color2 != null) {
            parcel.writeInt(1);
            color2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Color color3 = this.backgroundColorDark;
        if (color3 != null) {
            parcel.writeInt(1);
            color3.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeString(this.backgroundColorName);
    }
}
