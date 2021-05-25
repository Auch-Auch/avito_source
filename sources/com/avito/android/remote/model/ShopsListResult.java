package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.avito_map.amenity.AmenityMarkerIconFactoryKt;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.avito.android.util.UrlParams;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\u00020\u0001:\u0003#$%BK\u0012\u0006\u0010\u001b\u001a\u00020\u0004\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011¢\u0006\u0004\b!\u0010\"J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u00020\u00048\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\nR$\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u000e\u001a\u0004\b \u0010\u0010¨\u0006&"}, d2 = {"Lcom/avito/android/remote/model/ShopsListResult;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/ShopsListResult$Element;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "", "", "firebaseParams", "Ljava/util/Map;", "getFirebaseParams", "()Ljava/util/Map;", UrlParams.LAST_STAMP, "Ljava/lang/String;", "getLastStamp", "()Ljava/lang/String;", "count", "I", "getCount", "Lcom/avito/android/remote/model/LinkAction;", "actions", "getActions", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/Map;)V", "Companion", "Element", "Shop", "models_release"}, k = 1, mv = {1, 4, 2})
public final class ShopsListResult implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopsListResult> CREATOR = Parcels.creator(ShopsListResult$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("actions")
    @Nullable
    private final List<LinkAction> actions;
    @SerializedName("count")
    private final int count;
    @SerializedName(AmenityMarkerIconFactoryKt.AMENITY_TYPE_SHOPS)
    @NotNull
    private final List<Element> elements;
    @SerializedName("firebaseParams")
    @Nullable
    private final Map<String, String> firebaseParams;
    @SerializedName(UrlParams.LAST_STAMP)
    @NotNull
    private final String lastStamp;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/ShopsListResult$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/ShopsListResult;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/avito/android/remote/model/ShopsListResult$Element;", "Landroid/os/Parcelable;", "models_release"}, k = 1, mv = {1, 4, 2})
    public interface Element extends Parcelable {
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u001e\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010 \u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014¢\u0006\u0004\b%\u0010&J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000fR\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001e\u0010\r\u001a\u0004\b\u001f\u0010\u000fR\u001e\u0010!\u001a\u0004\u0018\u00010 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/avito/android/remote/model/ShopsListResult$Shop;", "Lcom/avito/android/remote/model/ShopsListResult$Element;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "itemsCountDescription", "Ljava/lang/String;", "getItemsCountDescription", "()Ljava/lang/String;", "category", "getCategory", "name", "getName", "Lcom/avito/android/deep_linking/links/DeepLink;", ShareConstants.MEDIA_URI, "Lcom/avito/android/deep_linking/links/DeepLink;", "getUri", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/Image;", "logo", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "id", "getId", "", "itemsCount", "Ljava/lang/Long;", "getItemsCount", "()Ljava/lang/Long;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Shop implements Element {
        public static final Parcelable.Creator<Shop> CREATOR = new Creator();
        @SerializedName("categoryName")
        @Nullable
        private final String category;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("itemsCount")
        @Nullable
        private final Long itemsCount;
        @SerializedName("itemsCountDescription")
        @NotNull
        private final String itemsCountDescription;
        @SerializedName("logo")
        @Nullable
        private final Image logo;
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final DeepLink uri;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Shop> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Shop createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Shop(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Long.valueOf(parcel.readLong()) : null, parcel.readString(), (Image) parcel.readParcelable(Shop.class.getClassLoader()), (DeepLink) parcel.readParcelable(Shop.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Shop[] newArray(int i) {
                return new Shop[i];
            }
        }

        public Shop(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Long l, @Nullable String str4, @Nullable Image image, @Nullable DeepLink deepLink) {
            a.Z0(str, "id", str2, "name", str3, "itemsCountDescription");
            this.id = str;
            this.name = str2;
            this.itemsCountDescription = str3;
            this.itemsCount = l;
            this.category = str4;
            this.logo = image;
            this.uri = deepLink;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getCategory() {
            return this.category;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Long getItemsCount() {
            return this.itemsCount;
        }

        @NotNull
        public final String getItemsCountDescription() {
            return this.itemsCountDescription;
        }

        @Nullable
        public final Image getLogo() {
            return this.logo;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final DeepLink getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.name);
            parcel.writeString(this.itemsCountDescription);
            Long l = this.itemsCount;
            if (l != null) {
                a.I0(parcel, 1, l);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeString(this.category);
            parcel.writeParcelable(this.logo, i);
            parcel.writeParcelable(this.uri, i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.List<? extends com.avito.android.remote.model.ShopsListResult$Element> */
    /* JADX WARN: Multi-variable type inference failed */
    public ShopsListResult(int i, @NotNull String str, @NotNull List<? extends Element> list, @Nullable List<LinkAction> list2, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, UrlParams.LAST_STAMP);
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.count = i;
        this.lastStamp = str;
        this.elements = list;
        this.actions = list2;
        this.firebaseParams = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<LinkAction> getActions() {
        return this.actions;
    }

    public final int getCount() {
        return this.count;
    }

    @NotNull
    public final List<Element> getElements() {
        return this.elements;
    }

    @Nullable
    public final Map<String, String> getFirebaseParams() {
        return this.firebaseParams;
    }

    @NotNull
    public final String getLastStamp() {
        return this.lastStamp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.count);
        parcel.writeString(this.lastStamp);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.elements, 0, 2, null);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.actions, 0, 2, null);
        ParcelsKt.writeValueMap(parcel, this.firebaseParams);
    }
}
