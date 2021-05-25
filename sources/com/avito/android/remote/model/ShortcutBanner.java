package com.avito.android.remote.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.section.SectionElement;
import com.avito.android.util.Parcels;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0001+B7\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013\u0012\u0006\u0010\u001b\u001a\u00020\u001a\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\n\u0010\u000bR\"\u0010\r\u001a\u00020\f8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0015\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\u001b\u001a\u00020\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/ShortcutBanner;", "Lcom/avito/android/remote/model/SerpElement;", "Lcom/avito/android/remote/model/section/SectionElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "id", "getId", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "Lcom/avito/android/remote/model/BannerImages;", "images", "Lcom/avito/android/remote/model/BannerImages;", "getImages", "()Lcom/avito/android/remote/model/BannerImages;", "Lcom/avito/android/remote/model/Background;", "background", "Lcom/avito/android/remote/model/Background;", "getBackground", "()Lcom/avito/android/remote/model/Background;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Landroid/net/Uri;Lcom/avito/android/remote/model/BannerImages;Lcom/avito/android/remote/model/Background;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShortcutBanner implements SerpElement, SectionElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShortcutBanner> CREATOR = Parcels.creator(ShortcutBanner$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("background")
    @Nullable
    private final Background background;
    @SerializedName("id")
    @Nullable
    private final String id;
    @SerializedName("images")
    @Nullable
    private final BannerImages images;
    @SerializedName("title")
    @Nullable
    private final String title;
    private long uniqueId;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final Uri uri;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ShortcutBanner$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/ShortcutBanner;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public ShortcutBanner(@Nullable String str, @Nullable String str2, @NotNull Uri uri2, @Nullable BannerImages bannerImages, @Nullable Background background2) {
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.id = str;
        this.title = str2;
        this.uri = uri2;
        this.images = bannerImages;
        this.background = background2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Background getBackground() {
        return this.background;
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final BannerImages getImages() {
        return this.images;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
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
        parcel.writeParcelable(this.uri, i);
        parcel.writeParcelable(this.images, i);
        parcel.writeParcelable(this.background, i);
        parcel.writeLong(getUniqueId());
    }
}
