package com.avito.android.remote.model.map_banner;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.SerpElement;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B7\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR(\u0010\f\u001a\u00020\u000b8\u0016@\u0016X\u000e¢\u0006\u0018\n\u0004\b\f\u0010\r\u0012\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0016\u001a\u0004\b\u001f\u0010\u0018R\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/map_banner/MapBanner;", "Lcom/avito/android/remote/model/SerpElement;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "uniqueId", "J", "getUniqueId", "()J", "setUniqueId", "(J)V", "getUniqueId$annotations", "()V", "Landroid/net/Uri;", "darkMapScreenUri", "Landroid/net/Uri;", "getDarkMapScreenUri", "()Landroid/net/Uri;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "lightMapScreenUri", "getLightMapScreenUri", "", "buttonText", "Ljava/lang/String;", "getButtonText", "()Ljava/lang/String;", "<init>", "(Landroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class MapBanner implements SerpElement {
    public static final Parcelable.Creator<MapBanner> CREATOR = new Creator();
    @SerializedName("button_text")
    @Nullable
    private final String buttonText;
    @SerializedName("map_dark_screen_url")
    @Nullable
    private final Uri darkMapScreenUri;
    @SerializedName("deeplink")
    @Nullable
    private final DeepLink deepLink;
    @SerializedName("map_screen_url")
    @Nullable
    private final Uri lightMapScreenUri;
    private long uniqueId;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<MapBanner> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapBanner createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new MapBanner((Uri) parcel.readParcelable(MapBanner.class.getClassLoader()), (Uri) parcel.readParcelable(MapBanner.class.getClassLoader()), parcel.readString(), (DeepLink) parcel.readParcelable(MapBanner.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MapBanner[] newArray(int i) {
            return new MapBanner[i];
        }
    }

    public MapBanner() {
        this(null, null, null, null, 15, null);
    }

    public MapBanner(@Nullable Uri uri, @Nullable Uri uri2, @Nullable String str, @Nullable DeepLink deepLink2) {
        this.lightMapScreenUri = uri;
        this.darkMapScreenUri = uri2;
        this.buttonText = str;
        this.deepLink = deepLink2;
    }

    public static /* synthetic */ void getUniqueId$annotations() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getButtonText() {
        return this.buttonText;
    }

    @Nullable
    public final Uri getDarkMapScreenUri() {
        return this.darkMapScreenUri;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final Uri getLightMapScreenUri() {
        return this.lightMapScreenUri;
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
        parcel.writeParcelable(this.lightMapScreenUri, i);
        parcel.writeParcelable(this.darkMapScreenUri, i);
        parcel.writeString(this.buttonText);
        parcel.writeParcelable(this.deepLink, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MapBanner(Uri uri, Uri uri2, String str, DeepLink deepLink2, int i, j jVar) {
        this((i & 1) != 0 ? null : uri, (i & 2) != 0 ? null : uri2, (i & 4) != 0 ? "" : str, (i & 8) != 0 ? null : deepLink2);
    }
}
