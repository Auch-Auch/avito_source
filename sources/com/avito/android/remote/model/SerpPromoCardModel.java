package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010 \u001a\u00020\u0010¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R(\u0010\u0018\u001a\u00020\u00178\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\u0018\u0010\u0019\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010 \u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b#\u0010\u000fR\u001c\u0010%\u001a\u00020$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/avito/android/remote/model/SerpPromoCardModel;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalColor;", "highlightedBackgroundColor", "Lcom/avito/android/remote/model/UniversalColor;", "getHighlightedBackgroundColor", "()Lcom/avito/android/remote/model/UniversalColor;", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "title", "getTitle", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "image", "getImage", "backgroundColor", "getBackgroundColor", "Lcom/avito/android/deep_linking/links/DeepLink;", "action", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "()Lcom/avito/android/deep_linking/links/DeepLink;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Ljava/lang/String;)V", "api_release"}, k = 1, mv = {1, 4, 2})
public final class SerpPromoCardModel implements SerpElement {
    public static final Parcelable.Creator<SerpPromoCardModel> CREATOR = new Creator();
    @SerializedName("action")
    @NotNull
    private final DeepLink action;
    @SerializedName("backgroundColor")
    @NotNull
    private final UniversalColor backgroundColor;
    @SerializedName("highlightedBackgroundColor")
    @NotNull
    private final UniversalColor highlightedBackgroundColor;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("image")
    @NotNull
    private final String image;
    @SerializedName("title")
    @NotNull
    private final String title;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<SerpPromoCardModel> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpPromoCardModel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new SerpPromoCardModel(parcel.readString(), (UniversalColor) parcel.readParcelable(SerpPromoCardModel.class.getClassLoader()), (UniversalColor) parcel.readParcelable(SerpPromoCardModel.class.getClassLoader()), (DeepLink) parcel.readParcelable(SerpPromoCardModel.class.getClassLoader()), parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final SerpPromoCardModel[] newArray(int i) {
            return new SerpPromoCardModel[i];
        }
    }

    public SerpPromoCardModel(@NotNull String str, @NotNull UniversalColor universalColor, @NotNull UniversalColor universalColor2, @NotNull DeepLink deepLink, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(universalColor, "backgroundColor");
        Intrinsics.checkNotNullParameter(universalColor2, "highlightedBackgroundColor");
        Intrinsics.checkNotNullParameter(deepLink, "action");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "image");
        this.id = str;
        this.backgroundColor = universalColor;
        this.highlightedBackgroundColor = universalColor2;
        this.action = deepLink;
        this.title = str2;
        this.image = str3;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final DeepLink getAction() {
        return this.action;
    }

    @NotNull
    public final UniversalColor getBackgroundColor() {
        return this.backgroundColor;
    }

    @NotNull
    public final UniversalColor getHighlightedBackgroundColor() {
        return this.highlightedBackgroundColor;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.id);
        parcel.writeParcelable(this.backgroundColor, i);
        parcel.writeParcelable(this.highlightedBackgroundColor, i);
        parcel.writeParcelable(this.action, i);
        parcel.writeString(this.title);
        parcel.writeString(this.image);
    }
}
