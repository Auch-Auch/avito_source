package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0010\u001a\u00020\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\n\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b2\u00103J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u000b\u001a\u00020\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00022\b\b\u0002\u0010\u0012\u001a\u00020\u00022\b\b\u0002\u0010\u0013\u001a\u00020\u00072\b\b\u0002\u0010\u0014\u001a\u00020\n2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0018\u0010\u0004J\u0010\u0010\u001a\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u001a\u0010\u001e\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÖ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b \u0010\u001bJ \u0010%\u001a\u00020$2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\u0019HÖ\u0001¢\u0006\u0004\b%\u0010&R\u001c\u0010\u0013\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010'\u001a\u0004\b(\u0010\tR$\u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010)\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b*\u0010+R\u001c\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010,\u001a\u0004\b-\u0010\fR\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010.\u001a\u0004\b/\u0010\u0004R\u001c\u0010\u0010\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010.\u001a\u0004\b0\u0010\u0004R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010.\u001a\u0004\b1\u0010\u0004¨\u00064"}, d2 = {"Lcom/avito/android/remote/model/Story;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "component2", "component3", "Lcom/avito/android/remote/model/Color;", "component4", "()Lcom/avito/android/remote/model/Color;", "Lcom/avito/android/remote/model/Image;", "component5", "()Lcom/avito/android/remote/model/Image;", "", "component6", "()Ljava/lang/Boolean;", "id", "title", "url", "backgroundColor", "image", "isViewed", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;)Lcom/avito/android/remote/model/Story;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Color;", "getBackgroundColor", "Ljava/lang/Boolean;", "setViewed", "(Ljava/lang/Boolean;)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/String;", "getUrl", "getId", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Color;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;)V", "stories_release"}, k = 1, mv = {1, 4, 2})
public final class Story implements Parcelable {
    public static final Parcelable.Creator<Story> CREATOR = new Creator();
    @SerializedName("backgroundColor")
    @NotNull
    private final Color backgroundColor;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("viewed")
    @Nullable
    private Boolean isViewed;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName("url")
    @NotNull
    private final String url;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Story> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Story createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            Color color = (Color) parcel.readParcelable(Story.class.getClassLoader());
            Image image = (Image) parcel.readParcelable(Story.class.getClassLoader());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            return new Story(readString, readString2, readString3, color, image, bool);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Story[] newArray(int i) {
            return new Story[i];
        }
    }

    public Story(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Color color, @NotNull Image image2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(color, "backgroundColor");
        Intrinsics.checkNotNullParameter(image2, "image");
        this.id = str;
        this.title = str2;
        this.url = str3;
        this.backgroundColor = color;
        this.image = image2;
        this.isViewed = bool;
    }

    public static /* synthetic */ Story copy$default(Story story, String str, String str2, String str3, Color color, Image image2, Boolean bool, int i, Object obj) {
        if ((i & 1) != 0) {
            str = story.id;
        }
        if ((i & 2) != 0) {
            str2 = story.title;
        }
        if ((i & 4) != 0) {
            str3 = story.url;
        }
        if ((i & 8) != 0) {
            color = story.backgroundColor;
        }
        if ((i & 16) != 0) {
            image2 = story.image;
        }
        if ((i & 32) != 0) {
            bool = story.isViewed;
        }
        return story.copy(str, str2, str3, color, image2, bool);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.url;
    }

    @NotNull
    public final Color component4() {
        return this.backgroundColor;
    }

    @NotNull
    public final Image component5() {
        return this.image;
    }

    @Nullable
    public final Boolean component6() {
        return this.isViewed;
    }

    @NotNull
    public final Story copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Color color, @NotNull Image image2, @Nullable Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "url");
        Intrinsics.checkNotNullParameter(color, "backgroundColor");
        Intrinsics.checkNotNullParameter(image2, "image");
        return new Story(str, str2, str3, color, image2, bool);
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
        if (!(obj instanceof Story)) {
            return false;
        }
        Story story = (Story) obj;
        return Intrinsics.areEqual(this.id, story.id) && Intrinsics.areEqual(this.title, story.title) && Intrinsics.areEqual(this.url, story.url) && Intrinsics.areEqual(this.backgroundColor, story.backgroundColor) && Intrinsics.areEqual(this.image, story.image) && Intrinsics.areEqual(this.isViewed, story.isViewed);
    }

    @NotNull
    public final Color getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.url;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        Color color = this.backgroundColor;
        int hashCode4 = (hashCode3 + (color != null ? color.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode5 = (hashCode4 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Boolean bool = this.isViewed;
        if (bool != null) {
            i = bool.hashCode();
        }
        return hashCode5 + i;
    }

    @Nullable
    public final Boolean isViewed() {
        return this.isViewed;
    }

    public final void setViewed(@Nullable Boolean bool) {
        this.isViewed = bool;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("Story(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", url=");
        L.append(this.url);
        L.append(", backgroundColor=");
        L.append(this.backgroundColor);
        L.append(", image=");
        L.append(this.image);
        L.append(", isViewed=");
        return a.o(L, this.isViewed, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        boolean z;
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
        parcel.writeParcelable(this.backgroundColor, i);
        parcel.writeParcelable(this.image, i);
        Boolean bool = this.isViewed;
        if (bool != null) {
            parcel.writeInt(1);
            z = bool.booleanValue();
        } else {
            z = false;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        parcel.writeInt(i2);
    }
}
