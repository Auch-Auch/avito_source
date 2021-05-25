package com.avito.android.remote.shop.detailed;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.item.details.ParameterId;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 92\u00020\u0001:\u00039:;B\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u0010\u0012\u0006\u0010%\u001a\u00020\u0010\u0012\u0006\u0010)\u001a\u00020\u0010\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010!\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010+\u001a\u0004\u0018\u00010\u0010\u0012\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-\u0012\b\u00103\u001a\u0004\u0018\u000102\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010#\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u001a¢\u0006\u0004\b7\u00108J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0016\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001e\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010\u0012\u001a\u0004\b \u0010\u0014R\u001e\u0010!\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010\u0012\u001a\u0004\b\"\u0010\u0014R\u001e\u0010#\u001a\u0004\u0018\u00010\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010\u0017\u001a\u0004\b$\u0010\u0019R\u001c\u0010%\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010\u0012\u001a\u0004\b&\u0010\u0014R\u001e\u0010'\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010\u0012\u001a\u0004\b(\u0010\u0014R\u001c\u0010)\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010\u0012\u001a\u0004\b*\u0010\u0014R\u001e\u0010+\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010\u0012\u001a\u0004\b,\u0010\u0014R$\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010-8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001e\u00103\u001a\u0004\u0018\u0001028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;", "showcase", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;", "getShowcase", "()Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "logo", "Lcom/avito/android/remote/model/Image;", "getLogo", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "Lcom/avito/android/remote/model/Coordinates;", "getCoordinates", "()Lcom/avito/android/remote/model/Coordinates;", "type", "getType", "shortDescription", "getShortDescription", "background", "getBackground", "id", "getId", "categoryName", "getCategoryName", "name", "getName", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "getAddress", "", "phones", "Ljava/util/List;", "getPhones", "()Ljava/util/List;", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;", "site", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;", "getSite", "()Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Lcom/avito/android/remote/model/Coordinates;)V", "Companion", "Showcase", "Site", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopDetailed implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<ShopDetailed> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
    @Nullable
    private final String address;
    @SerializedName("brandingImage")
    @Nullable
    private final Image background;
    @SerializedName("categoryName")
    @Nullable
    private final String categoryName;
    @SerializedName(ParameterId.COORDS)
    @Nullable
    private final Coordinates coordinates;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("logo")
    @Nullable
    private final Image logo;
    @SerializedName("name")
    @NotNull
    private final String name;
    @SerializedName("phones")
    @Nullable
    private final List<String> phones;
    @SerializedName("shortDescription")
    @Nullable
    private final String shortDescription;
    @SerializedName("items")
    @Nullable
    private final Showcase showcase;
    @SerializedName("site")
    @Nullable
    private final Site site;
    @SerializedName("type")
    @NotNull
    private final String type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/shop/detailed/ShopDetailed;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u001f\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/SerpElement;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "Companion", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Showcase implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Showcase> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("list")
        @NotNull
        private final List<SerpElement> elements;
        @SerializedName("title")
        @Nullable
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Showcase;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Showcase> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Showcase invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                String readString = parcel2.readString();
                List createParcelableList = ParcelsKt.createParcelableList(parcel2, SerpElement.class);
                if (createParcelableList == null) {
                    createParcelableList = CollectionsKt__CollectionsKt.emptyList();
                }
                return new Showcase(readString, createParcelableList);
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: java.util.List<? extends com.avito.android.remote.model.SerpElement> */
        /* JADX WARN: Multi-variable type inference failed */
        public Showcase(@Nullable String str, @NotNull List<? extends SerpElement> list) {
            Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
            this.title = str;
            this.elements = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<SerpElement> getElements() {
            return this.elements;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeString(this.title);
            ParcelsKt.writeOptimizedParcelableList(parcel, this.elements, i);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "<init>", "(Landroid/net/Uri;)V", "Companion", "shop_release"}, k = 1, mv = {1, 4, 2})
    public static final class Site implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Site> CREATOR = Parcels.creator(a.a);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName(ShareConstants.MEDIA_URI)
        @Nullable
        private final Uri uri;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/shop/detailed/ShopDetailed$Site;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "shop_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            public Companion() {
            }

            public Companion(j jVar) {
            }
        }

        public static final class a extends Lambda implements Function1<Parcel, Site> {
            public static final a a = new a();

            public a() {
                super(1);
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Site invoke(Parcel parcel) {
                Parcel parcel2 = parcel;
                Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                return new Site((Uri) parcel2.readParcelable(Uri.class.getClassLoader()));
            }
        }

        public Site(@Nullable Uri uri2) {
            this.uri = uri2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Uri getUri() {
            return this.uri;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            parcel.writeParcelable(this.uri, i);
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, ShopDetailed> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public ShopDetailed invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new ShopDetailed(a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), (Showcase) parcel2.readParcelable(Showcase.class.getClassLoader()), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.createStringArrayList(), (Site) parcel2.readParcelable(Site.class.getClassLoader()), (Image) parcel2.readParcelable(Image.class.getClassLoader()), (Image) parcel2.readParcelable(Image.class.getClassLoader()), parcel2.readString(), (Coordinates) parcel2.readParcelable(Coordinates.class.getClassLoader()));
        }
    }

    public ShopDetailed(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable Showcase showcase2, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable List<String> list, @Nullable Site site2, @Nullable Image image, @Nullable Image image2, @Nullable String str7, @Nullable Coordinates coordinates2) {
        a2.b.a.a.a.Z0(str, "type", str2, "id", str3, "name");
        this.type = str;
        this.id = str2;
        this.name = str3;
        this.showcase = showcase2;
        this.description = str4;
        this.shortDescription = str5;
        this.address = str6;
        this.phones = list;
        this.site = site2;
        this.logo = image;
        this.background = image2;
        this.categoryName = str7;
        this.coordinates = coordinates2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final Image getBackground() {
        return this.background;
    }

    @Nullable
    public final String getCategoryName() {
        return this.categoryName;
    }

    @Nullable
    public final Coordinates getCoordinates() {
        return this.coordinates;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.id;
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
    public final List<String> getPhones() {
        return this.phones;
    }

    @Nullable
    public final String getShortDescription() {
        return this.shortDescription;
    }

    @Nullable
    public final Showcase getShowcase() {
        return this.showcase;
    }

    @Nullable
    public final Site getSite() {
        return this.site;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.type);
        parcel.writeString(this.id);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.showcase, i);
        parcel.writeString(this.description);
        parcel.writeString(this.shortDescription);
        parcel.writeStringList(this.phones);
        parcel.writeString(this.address);
        parcel.writeParcelable(this.site, i);
        parcel.writeParcelable(this.logo, i);
        parcel.writeParcelable(this.background, i);
        parcel.writeString(this.categoryName);
        parcel.writeParcelable(this.coordinates, i);
    }
}
