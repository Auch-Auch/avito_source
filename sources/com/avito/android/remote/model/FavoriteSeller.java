package com.avito.android.remote.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 .2\u00020\u0001:\u0001.Bk\u0012\b\u0010 \u001a\u0004\u0018\u00010\u000f\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010\"\u001a\u00020\u0014\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014\u0012\u0006\u0010&\u001a\u00020%\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b,\u0010-J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0010\u001a\u00020\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001e\u0010\u0018\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0019\u0010\u0017R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001e\u0010\u001f\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0016\u001a\u0004\b\u001f\u0010\u0017R\u001e\u0010 \u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0011\u001a\u0004\b!\u0010\u0013R\u001c\u0010\"\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b\"\u0010$R\u001c\u0010&\u001a\u00020%8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001e\u0010*\u001a\u0004\u0018\u00010\u000f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010\u0011\u001a\u0004\b+\u0010\u0013¨\u0006/"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSeller;", "Lcom/avito/android/remote/model/FavoriteSellersResultItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/SerpElement;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "", "userKey", "Ljava/lang/String;", "getUserKey", "()Ljava/lang/String;", "", "isShop", "Ljava/lang/Boolean;", "()Ljava/lang/Boolean;", "hasNewItems", "getHasNewItems", "Lcom/avito/android/remote/model/Image;", "avatar", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "isNotificationsActivated", "name", "getName", "isDisabled", "Z", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "description", "getDescription", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/Boolean;ZLjava/lang/Boolean;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/List;Ljava/lang/Boolean;)V", "Companion", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteSeller extends FavoriteSellersResultItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<FavoriteSeller> CREATOR = Parcels.creator(FavoriteSeller$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("avatar")
    @Nullable
    private final Image avatar;
    @SerializedName(ShareConstants.MEDIA_URI)
    @NotNull
    private final DeepLink deepLink;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("hasNewItems")
    @Nullable
    private final Boolean hasNewItems;
    @SerializedName("isDisabled")
    private final boolean isDisabled;
    @SerializedName("isNotificationsActivated")
    @Nullable
    private final Boolean isNotificationsActivated;
    @SerializedName("isShop")
    @Nullable
    private final Boolean isShop;
    @SerializedName("entries")
    @Nullable
    private final List<SerpElement> items;
    @SerializedName("name")
    @Nullable
    private final String name;
    @SerializedName("hashUserId")
    @NotNull
    private final String userKey;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/FavoriteSeller$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/FavoriteSeller;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "favorite-sellers_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public FavoriteSeller(@Nullable String str, @Nullable String str2, @Nullable Image image, @NotNull String str3, @Nullable Boolean bool, boolean z, @Nullable Boolean bool2, @NotNull DeepLink deepLink2, @Nullable List<? extends SerpElement> list, @Nullable Boolean bool3) {
        Intrinsics.checkNotNullParameter(str3, "userKey");
        Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
        this.name = str;
        this.description = str2;
        this.avatar = image;
        this.userKey = str3;
        this.isShop = bool;
        this.isDisabled = z;
        this.isNotificationsActivated = bool2;
        this.deepLink = deepLink2;
        this.items = list;
        this.hasNewItems = bool3;
    }

    @Nullable
    public final Image getAvatar() {
        return this.avatar;
    }

    @NotNull
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Boolean getHasNewItems() {
        return this.hasNewItems;
    }

    @Nullable
    public final List<SerpElement> getItems() {
        return this.items;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final String getUserKey() {
        return this.userKey;
    }

    public final boolean isDisabled() {
        return this.isDisabled;
    }

    @Nullable
    public final Boolean isNotificationsActivated() {
        return this.isNotificationsActivated;
    }

    @Nullable
    public final Boolean isShop() {
        return this.isShop;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.name);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.avatar, i);
        parcel.writeString(this.userKey);
        ParcelsKt.writeNullableValue(parcel, this.isShop);
        ParcelsKt.writeBool(parcel, this.isDisabled);
        ParcelsKt.writeNullableValue(parcel, this.isNotificationsActivated);
        parcel.writeParcelable(this.deepLink, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.items, i);
        ParcelsKt.writeNullableValue(parcel, this.hasNewItems);
    }
}
