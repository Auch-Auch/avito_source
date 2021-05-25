package com.avito.android.deep_linking.links;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalImage;
import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0013\b\b\u0018\u00002\u00020\u0001B]\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b=\u0010>J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0012\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0012\u0010\u000eJ\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015Jp\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0004J\u0010\u0010\"\u001a\u00020!HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020\f2\b\u0010%\u001a\u0004\u0018\u00010$HÖ\u0003¢\u0006\u0004\b&\u0010'J\u0010\u0010(\u001a\u00020!HÖ\u0001¢\u0006\u0004\b(\u0010#J \u0010-\u001a\u00020,2\u0006\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020!HÖ\u0001¢\u0006\u0004\b-\u0010.R\u001e\u0010\u001d\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010/\u001a\u0004\b0\u0010\u0015R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u00101\u001a\u0004\b2\u0010\u000bR\u001e\u0010\u001c\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u00103\u001a\u0004\b4\u0010\u000eR\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u00105\u001a\u0004\b6\u0010\u0004R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u00107\u001a\u0004\b8\u0010\u0007R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u00105\u001a\u0004\b9\u0010\u0004R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u00103\u001a\u0004\b:\u0010\u000eR\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010;\u001a\u0004\b<\u0010\u0011¨\u0006?"}, d2 = {"Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "Landroid/os/Parcelable;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "component2", "()Lcom/avito/android/remote/model/text/AttributedText;", "component3", "Lcom/avito/android/deep_linking/links/DetailsSheetButton;", "component4", "()Lcom/avito/android/deep_linking/links/DetailsSheetButton;", "", "component5", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "component7", "Lcom/avito/android/remote/model/UniversalImage;", "component8", "()Lcom/avito/android/remote/model/UniversalImage;", "title", "attributedText", "warning", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "closeButton", "image", "supportTablets", "universalImage", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DetailsSheetButton;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/remote/model/UniversalImage;)Lcom/avito/android/deep_linking/links/DetailsSheetLinkBody;", "toString", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/UniversalImage;", "getUniversalImage", "Lcom/avito/android/deep_linking/links/DetailsSheetButton;", "getButton", "Ljava/lang/Boolean;", "getSupportTablets", "Ljava/lang/String;", "getTitle", "Lcom/avito/android/remote/model/text/AttributedText;", "getAttributedText", "getWarning", "getCloseButton", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DetailsSheetButton;Ljava/lang/Boolean;Lcom/avito/android/remote/model/Image;Ljava/lang/Boolean;Lcom/avito/android/remote/model/UniversalImage;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class DetailsSheetLinkBody implements Parcelable {
    public static final Parcelable.Creator<DetailsSheetLinkBody> CREATOR = new Creator();
    @SerializedName("description")
    @Nullable
    private final AttributedText attributedText;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @Nullable
    private final DetailsSheetButton button;
    @SerializedName("closeButton")
    @Nullable
    private final Boolean closeButton;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("supportTablets")
    @Nullable
    private final Boolean supportTablets;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("dynamicImage")
    @Nullable
    private final UniversalImage universalImage;
    @SerializedName("warning")
    @Nullable
    private final String warning;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DetailsSheetLinkBody> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DetailsSheetLinkBody createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Intrinsics.checkNotNullParameter(parcel, "in");
            String readString = parcel.readString();
            AttributedText attributedText = (AttributedText) parcel.readParcelable(DetailsSheetLinkBody.class.getClassLoader());
            String readString2 = parcel.readString();
            DetailsSheetButton createFromParcel = parcel.readInt() != 0 ? DetailsSheetButton.CREATOR.createFromParcel(parcel) : null;
            boolean z = true;
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            } else {
                bool = null;
            }
            Image image = (Image) parcel.readParcelable(DetailsSheetLinkBody.class.getClassLoader());
            if (parcel.readInt() != 0) {
                if (parcel.readInt() == 0) {
                    z = false;
                }
                bool2 = Boolean.valueOf(z);
            } else {
                bool2 = null;
            }
            return new DetailsSheetLinkBody(readString, attributedText, readString2, createFromParcel, bool, image, bool2, parcel.readInt() != 0 ? UniversalImage.CREATOR.createFromParcel(parcel) : null);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DetailsSheetLinkBody[] newArray(int i) {
            return new DetailsSheetLinkBody[i];
        }
    }

    public DetailsSheetLinkBody(@Nullable String str, @Nullable AttributedText attributedText2, @Nullable String str2, @Nullable DetailsSheetButton detailsSheetButton, @Nullable Boolean bool, @Nullable Image image2, @Nullable Boolean bool2, @Nullable UniversalImage universalImage2) {
        this.title = str;
        this.attributedText = attributedText2;
        this.warning = str2;
        this.button = detailsSheetButton;
        this.closeButton = bool;
        this.image = image2;
        this.supportTablets = bool2;
        this.universalImage = universalImage2;
    }

    public static /* synthetic */ DetailsSheetLinkBody copy$default(DetailsSheetLinkBody detailsSheetLinkBody, String str, AttributedText attributedText2, String str2, DetailsSheetButton detailsSheetButton, Boolean bool, Image image2, Boolean bool2, UniversalImage universalImage2, int i, Object obj) {
        return detailsSheetLinkBody.copy((i & 1) != 0 ? detailsSheetLinkBody.title : str, (i & 2) != 0 ? detailsSheetLinkBody.attributedText : attributedText2, (i & 4) != 0 ? detailsSheetLinkBody.warning : str2, (i & 8) != 0 ? detailsSheetLinkBody.button : detailsSheetButton, (i & 16) != 0 ? detailsSheetLinkBody.closeButton : bool, (i & 32) != 0 ? detailsSheetLinkBody.image : image2, (i & 64) != 0 ? detailsSheetLinkBody.supportTablets : bool2, (i & 128) != 0 ? detailsSheetLinkBody.universalImage : universalImage2);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final AttributedText component2() {
        return this.attributedText;
    }

    @Nullable
    public final String component3() {
        return this.warning;
    }

    @Nullable
    public final DetailsSheetButton component4() {
        return this.button;
    }

    @Nullable
    public final Boolean component5() {
        return this.closeButton;
    }

    @Nullable
    public final Image component6() {
        return this.image;
    }

    @Nullable
    public final Boolean component7() {
        return this.supportTablets;
    }

    @Nullable
    public final UniversalImage component8() {
        return this.universalImage;
    }

    @NotNull
    public final DetailsSheetLinkBody copy(@Nullable String str, @Nullable AttributedText attributedText2, @Nullable String str2, @Nullable DetailsSheetButton detailsSheetButton, @Nullable Boolean bool, @Nullable Image image2, @Nullable Boolean bool2, @Nullable UniversalImage universalImage2) {
        return new DetailsSheetLinkBody(str, attributedText2, str2, detailsSheetButton, bool, image2, bool2, universalImage2);
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
        if (!(obj instanceof DetailsSheetLinkBody)) {
            return false;
        }
        DetailsSheetLinkBody detailsSheetLinkBody = (DetailsSheetLinkBody) obj;
        return Intrinsics.areEqual(this.title, detailsSheetLinkBody.title) && Intrinsics.areEqual(this.attributedText, detailsSheetLinkBody.attributedText) && Intrinsics.areEqual(this.warning, detailsSheetLinkBody.warning) && Intrinsics.areEqual(this.button, detailsSheetLinkBody.button) && Intrinsics.areEqual(this.closeButton, detailsSheetLinkBody.closeButton) && Intrinsics.areEqual(this.image, detailsSheetLinkBody.image) && Intrinsics.areEqual(this.supportTablets, detailsSheetLinkBody.supportTablets) && Intrinsics.areEqual(this.universalImage, detailsSheetLinkBody.universalImage);
    }

    @Nullable
    public final AttributedText getAttributedText() {
        return this.attributedText;
    }

    @Nullable
    public final DetailsSheetButton getButton() {
        return this.button;
    }

    @Nullable
    public final Boolean getCloseButton() {
        return this.closeButton;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final Boolean getSupportTablets() {
        return this.supportTablets;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final UniversalImage getUniversalImage() {
        return this.universalImage;
    }

    @Nullable
    public final String getWarning() {
        return this.warning;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        AttributedText attributedText2 = this.attributedText;
        int hashCode2 = (hashCode + (attributedText2 != null ? attributedText2.hashCode() : 0)) * 31;
        String str2 = this.warning;
        int hashCode3 = (hashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        DetailsSheetButton detailsSheetButton = this.button;
        int hashCode4 = (hashCode3 + (detailsSheetButton != null ? detailsSheetButton.hashCode() : 0)) * 31;
        Boolean bool = this.closeButton;
        int hashCode5 = (hashCode4 + (bool != null ? bool.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode6 = (hashCode5 + (image2 != null ? image2.hashCode() : 0)) * 31;
        Boolean bool2 = this.supportTablets;
        int hashCode7 = (hashCode6 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        UniversalImage universalImage2 = this.universalImage;
        if (universalImage2 != null) {
            i = universalImage2.hashCode();
        }
        return hashCode7 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("DetailsSheetLinkBody(title=");
        L.append(this.title);
        L.append(", attributedText=");
        L.append(this.attributedText);
        L.append(", warning=");
        L.append(this.warning);
        L.append(", button=");
        L.append(this.button);
        L.append(", closeButton=");
        L.append(this.closeButton);
        L.append(", image=");
        L.append(this.image);
        L.append(", supportTablets=");
        L.append(this.supportTablets);
        L.append(", universalImage=");
        L.append(this.universalImage);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.title);
        parcel.writeParcelable(this.attributedText, i);
        parcel.writeString(this.warning);
        DetailsSheetButton detailsSheetButton = this.button;
        if (detailsSheetButton != null) {
            parcel.writeInt(1);
            detailsSheetButton.writeToParcel(parcel, 0);
        } else {
            parcel.writeInt(0);
        }
        Boolean bool = this.closeButton;
        if (bool != null) {
            a.G0(parcel, 1, bool);
        } else {
            parcel.writeInt(0);
        }
        parcel.writeParcelable(this.image, i);
        Boolean bool2 = this.supportTablets;
        if (bool2 != null) {
            a.G0(parcel, 1, bool2);
        } else {
            parcel.writeInt(0);
        }
        UniversalImage universalImage2 = this.universalImage;
        if (universalImage2 != null) {
            parcel.writeInt(1);
            universalImage2.writeToParcel(parcel, 0);
            return;
        }
        parcel.writeInt(0);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DetailsSheetLinkBody(String str, AttributedText attributedText2, String str2, DetailsSheetButton detailsSheetButton, Boolean bool, Image image2, Boolean bool2, UniversalImage universalImage2, int i, j jVar) {
        this(str, attributedText2, str2, detailsSheetButton, (i & 16) != 0 ? Boolean.FALSE : bool, image2, (i & 64) != 0 ? Boolean.FALSE : bool2, (i & 128) != 0 ? null : universalImage2);
    }
}
