package com.avito.android.remote.model.guide;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Color;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u001a\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u0012\u001a\u0004\b\u001d\u0010\u0014¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/guide/GuideSection;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Color;", "backgroundColorLight", "Lcom/avito/android/remote/model/Color;", "getBackgroundColorLight", "()Lcom/avito/android/remote/model/Color;", "Landroid/net/Uri;", "url", "Landroid/net/Uri;", "getUrl", "()Landroid/net/Uri;", "title", "getTitle", "backgroundColorDark", "getBackgroundColorDark", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Color;Landroid/net/Uri;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class GuideSection implements Parcelable {
    public static final Parcelable.Creator<GuideSection> CREATOR = new Creator();
    @SerializedName("backgroundColorDark")
    @Nullable
    private final Color backgroundColorDark;
    @SerializedName("backgroundColorLight")
    @Nullable
    private final Color backgroundColorLight;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("url")
    @Nullable
    private final Uri url;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<GuideSection> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GuideSection createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new GuideSection(parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? Color.CREATOR.createFromParcel(parcel) : null, (Uri) parcel.readParcelable(GuideSection.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final GuideSection[] newArray(int i) {
            return new GuideSection[i];
        }
    }

    public GuideSection(@NotNull String str, @Nullable String str2, @Nullable Color color, @Nullable Color color2, @Nullable Uri uri) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.title = str;
        this.description = str2;
        this.backgroundColorLight = color;
        this.backgroundColorDark = color2;
        this.url = uri;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Color getBackgroundColorDark() {
        return this.backgroundColorDark;
    }

    @Nullable
    public final Color getBackgroundColorLight() {
        return this.backgroundColorLight;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Uri getUrl() {
        return this.url;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeString(this.description);
        Color color = this.backgroundColorLight;
        if (color != null) {
            parcel.writeInt(1);
            color.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Color color2 = this.backgroundColorDark;
        if (color2 != null) {
            parcel.writeInt(1);
            color2.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.url, i);
    }
}
