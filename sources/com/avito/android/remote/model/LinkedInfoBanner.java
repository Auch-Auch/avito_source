package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 72\u00020\u00012\u00020\u0002:\u00017BW\u0012\b\u0010)\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\b\u0010%\u001a\u0004\u0018\u00010$\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0004\b5\u00106J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\u001e\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0012\u0010\u0010R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(R\u001e\u0010)\u001a\u0004\u0018\u00010\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010\u000e\u001a\u0004\b*\u0010\u0010R\u001e\u0010,\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/R\u001e\u00101\u001a\u0004\u0018\u0001008\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u00102\u001a\u0004\b3\u00104¨\u00068"}, d2 = {"Lcom/avito/android/remote/model/LinkedInfoBanner;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/remote/model/section/SectionElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "title", "getTitle", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "icon", "Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "getIcon", "()Lcom/avito/android/remote/model/LinkedInfoBannerIcon;", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", "closeBtnVisible", "Ljava/lang/Boolean;", "getCloseBtnVisible", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/UniversalColor;", "background", "Lcom/avito/android/remote/model/UniversalColor;", "getBackground", "()Lcom/avito/android/remote/model/UniversalColor;", "id", "getId", "Lcom/avito/android/remote/model/text/AttributedText;", "detailsLink", "Lcom/avito/android/remote/model/text/AttributedText;", "getDetailsLink", "()Lcom/avito/android/remote/model/text/AttributedText;", "Lcom/avito/android/remote/model/LinkedInfoBannerButton;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Lcom/avito/android/remote/model/LinkedInfoBannerButton;", "getButton", "()Lcom/avito/android/remote/model/LinkedInfoBannerButton;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/text/AttributedText;Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/LinkedInfoBannerIcon;Ljava/lang/Boolean;Lcom/avito/android/remote/model/LinkedInfoBannerButton;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class LinkedInfoBanner implements SerpElement, SectionElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<LinkedInfoBanner> CREATOR = Parcels.creator(LinkedInfoBanner$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("background")
    @Nullable
    private final UniversalColor background;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @Nullable
    private final LinkedInfoBannerButton button;
    @SerializedName("closeBtnVisible")
    @Nullable
    private final Boolean closeBtnVisible;
    @SerializedName("detailsLink")
    @Nullable
    private final AttributedText detailsLink;
    @SerializedName("icon")
    @Nullable
    private final LinkedInfoBannerIcon icon;
    @SerializedName("id")
    @Nullable
    private final String id;
    @SerializedName("message")
    @Nullable
    private final String message;
    @SerializedName("title")
    @Nullable
    private final String title;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/LinkedInfoBanner$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/LinkedInfoBanner;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public LinkedInfoBanner(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable AttributedText attributedText, @Nullable UniversalColor universalColor, @Nullable LinkedInfoBannerIcon linkedInfoBannerIcon, @Nullable Boolean bool, @Nullable LinkedInfoBannerButton linkedInfoBannerButton) {
        this.id = str;
        this.title = str2;
        this.message = str3;
        this.detailsLink = attributedText;
        this.background = universalColor;
        this.icon = linkedInfoBannerIcon;
        this.closeBtnVisible = bool;
        this.button = linkedInfoBannerButton;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final UniversalColor getBackground() {
        return this.background;
    }

    @Nullable
    public final LinkedInfoBannerButton getButton() {
        return this.button;
    }

    @Nullable
    public final Boolean getCloseBtnVisible() {
        return this.closeBtnVisible;
    }

    @Nullable
    public final AttributedText getDetailsLink() {
        return this.detailsLink;
    }

    @Nullable
    public final LinkedInfoBannerIcon getIcon() {
        return this.icon;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getMessage() {
        return this.message;
    }

    @Nullable
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
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.message);
        parcel.writeParcelable(this.detailsLink, i);
        parcel.writeParcelable(this.background, i);
        parcel.writeParcelable(this.icon, i);
        ParcelsKt.writeOptBoolean(parcel, this.closeBtnVisible);
        parcel.writeParcelable(this.button, i);
        parcel.writeLong(getUniqueId());
    }
}
