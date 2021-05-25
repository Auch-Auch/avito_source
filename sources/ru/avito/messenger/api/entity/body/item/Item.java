package ru.avito.messenger.api.entity.body.item;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Parcels;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.messenger.api.entity.Images;
import ru.avito.messenger.api.entity.Metro;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0017\b\b\u0018\u0000 I2\u00020\u0001:\u0001IB\u0012\u0006\u0010 \u001a\u00020\u000b\u0012\b\u0010!\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\"\u001a\u00020\u000b\u0012\u0006\u0010#\u001a\u00020\u000b\u0012\u0006\u0010$\u001a\u00020\u000b\u0012\u0006\u0010%\u001a\u00020\u0012\u0012\b\u0010&\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010'\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010(\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010)\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010*\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010+\u001a\u0004\u0018\u00010\u001c\u0012\b\u0010,\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\bG\u0010HJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0010\u0010\u000f\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0010\u0010\u0010\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0010\u0010\u0011\u001a\u00020\u000bHÆ\u0003¢\u0006\u0004\b\u0011\u0010\rJ\u0010\u0010\u0013\u001a\u00020\u0012HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0015\u0010\rJ\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0019\u0010\rJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001b\u0010\rJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001cHÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001f\u0010\rJ¢\u0001\u0010-\u001a\u00020\u00002\b\b\u0002\u0010 \u001a\u00020\u000b2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2\b\b\u0002\u0010#\u001a\u00020\u000b2\b\b\u0002\u0010$\u001a\u00020\u000b2\b\b\u0002\u0010%\u001a\u00020\u00122\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\u001c2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\u000bHÆ\u0001¢\u0006\u0004\b-\u0010.J\u0010\u0010/\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b/\u0010\rJ\u0010\u00100\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b0\u0010\nJ\u001a\u00104\u001a\u0002032\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b4\u00105R\u001c\u0010 \u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u00106\u001a\u0004\b7\u0010\rR\u001c\u0010$\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u00106\u001a\u0004\b8\u0010\rR\u001e\u0010&\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u00106\u001a\u0004\b9\u0010\rR\u001c\u0010#\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u00106\u001a\u0004\b:\u0010\rR\u001e\u0010*\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u00106\u001a\u0004\b;\u0010\rR\u001e\u0010!\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u00106\u001a\u0004\b<\u0010\rR\u001e\u0010)\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u00106\u001a\u0004\b=\u0010\rR\u001e\u0010+\u001a\u0004\u0018\u00010\u001c8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\b?\u0010\u001eR\u001e\u0010,\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b,\u00106\u001a\u0004\b@\u0010\rR\u001c\u0010\"\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u00106\u001a\u0004\bA\u0010\rR\u001e\u0010'\u001a\u0004\u0018\u00010\u00168\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b'\u0010B\u001a\u0004\bC\u0010\u0018R\u001c\u0010%\u001a\u00020\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010D\u001a\u0004\bE\u0010\u0014R\u001e\u0010(\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u00106\u001a\u0004\bF\u0010\r¨\u0006J"}, d2 = {"Lru/avito/messenger/api/entity/body/item/Item;", "Lru/avito/messenger/api/entity/body/item/BodyItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "component5", "", "component6", "()J", "component7", "Lru/avito/messenger/api/entity/Images;", "component8", "()Lru/avito/messenger/api/entity/Images;", "component9", "component10", "component11", "Lru/avito/messenger/api/entity/Metro;", "component12", "()Lru/avito/messenger/api/entity/Metro;", "component13", "id", ChannelContext.Item.USER_ID, "title", "categoryId", "category", "dateTime", "description", "images", "formattedPrice", "priceMetric", "price", "metro", "location", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lru/avito/messenger/api/entity/Images;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/Metro;Ljava/lang/String;)Lru/avito/messenger/api/entity/body/item/Item;", "toString", "hashCode", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getId", "getCategory", "getDescription", "getCategoryId", "getPrice", "getUserId", "getPriceMetric", "Lru/avito/messenger/api/entity/Metro;", "getMetro", "getLocation", "getTitle", "Lru/avito/messenger/api/entity/Images;", "getImages", "J", "getDateTime", "getFormattedPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Lru/avito/messenger/api/entity/Images;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lru/avito/messenger/api/entity/Metro;Ljava/lang/String;)V", "Companion", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class Item implements BodyItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<Item> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("category")
    @NotNull
    private final String category;
    @SerializedName("categoryId")
    @NotNull
    private final String categoryId;
    @SerializedName("datetime")
    private final long dateTime;
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("priceString")
    @Nullable
    private final String formattedPrice;
    @SerializedName("id")
    @NotNull
    private final String id;
    @SerializedName("images")
    @Nullable
    private final Images images;
    @SerializedName("location")
    @Nullable
    private final String location;
    @SerializedName("metro")
    @Nullable
    private final Metro metro;
    @SerializedName("price")
    @Nullable
    private final String price;
    @SerializedName("metric")
    @Nullable
    private final String priceMetric;
    @SerializedName("title")
    @NotNull
    private final String title;
    @SerializedName(ChannelContext.Item.USER_ID)
    @Nullable
    private final String userId;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lru/avito/messenger/api/entity/body/item/Item$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lru/avito/messenger/api/entity/body/item/Item;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, Item> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Item invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new Item(a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readString(), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), parcel2.readLong(), parcel2.readString(), (Images) parcel2.readParcelable(Images.class.getClassLoader()), parcel2.readString(), parcel2.readString(), parcel2.readString(), (Metro) parcel2.readParcelable(Metro.class.getClassLoader()), parcel2.readString());
        }
    }

    public Item(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @Nullable String str6, @Nullable Images images2, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Metro metro2, @Nullable String str10) {
        a2.b.a.a.a.b1(str, "id", str3, "title", str4, "categoryId", str5, "category");
        this.id = str;
        this.userId = str2;
        this.title = str3;
        this.categoryId = str4;
        this.category = str5;
        this.dateTime = j;
        this.description = str6;
        this.images = images2;
        this.formattedPrice = str7;
        this.priceMetric = str8;
        this.price = str9;
        this.metro = metro2;
        this.location = str10;
    }

    public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, String str5, long j, String str6, Images images2, String str7, String str8, String str9, Metro metro2, String str10, int i, Object obj) {
        return item.copy((i & 1) != 0 ? item.id : str, (i & 2) != 0 ? item.userId : str2, (i & 4) != 0 ? item.title : str3, (i & 8) != 0 ? item.categoryId : str4, (i & 16) != 0 ? item.category : str5, (i & 32) != 0 ? item.dateTime : j, (i & 64) != 0 ? item.description : str6, (i & 128) != 0 ? item.images : images2, (i & 256) != 0 ? item.formattedPrice : str7, (i & 512) != 0 ? item.priceMetric : str8, (i & 1024) != 0 ? item.price : str9, (i & 2048) != 0 ? item.metro : metro2, (i & 4096) != 0 ? item.location : str10);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final String component10() {
        return this.priceMetric;
    }

    @Nullable
    public final String component11() {
        return this.price;
    }

    @Nullable
    public final Metro component12() {
        return this.metro;
    }

    @Nullable
    public final String component13() {
        return this.location;
    }

    @Nullable
    public final String component2() {
        return this.userId;
    }

    @NotNull
    public final String component3() {
        return this.title;
    }

    @NotNull
    public final String component4() {
        return this.categoryId;
    }

    @NotNull
    public final String component5() {
        return this.category;
    }

    public final long component6() {
        return this.dateTime;
    }

    @Nullable
    public final String component7() {
        return this.description;
    }

    @Nullable
    public final Images component8() {
        return this.images;
    }

    @Nullable
    public final String component9() {
        return this.formattedPrice;
    }

    @NotNull
    public final Item copy(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, long j, @Nullable String str6, @Nullable Images images2, @Nullable String str7, @Nullable String str8, @Nullable String str9, @Nullable Metro metro2, @Nullable String str10) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str3, "title");
        Intrinsics.checkNotNullParameter(str4, "categoryId");
        Intrinsics.checkNotNullParameter(str5, "category");
        return new Item(str, str2, str3, str4, str5, j, str6, images2, str7, str8, str9, metro2, str10);
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
        if (!(obj instanceof Item)) {
            return false;
        }
        Item item = (Item) obj;
        return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.userId, item.userId) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.categoryId, item.categoryId) && Intrinsics.areEqual(this.category, item.category) && this.dateTime == item.dateTime && Intrinsics.areEqual(this.description, item.description) && Intrinsics.areEqual(this.images, item.images) && Intrinsics.areEqual(this.formattedPrice, item.formattedPrice) && Intrinsics.areEqual(this.priceMetric, item.priceMetric) && Intrinsics.areEqual(this.price, item.price) && Intrinsics.areEqual(this.metro, item.metro) && Intrinsics.areEqual(this.location, item.location);
    }

    @NotNull
    public final String getCategory() {
        return this.category;
    }

    @NotNull
    public final String getCategoryId() {
        return this.categoryId;
    }

    public final long getDateTime() {
        return this.dateTime;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getFormattedPrice() {
        return this.formattedPrice;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final Images getImages() {
        return this.images;
    }

    @Nullable
    public final String getLocation() {
        return this.location;
    }

    @Nullable
    public final Metro getMetro() {
        return this.metro;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final String getPriceMetric() {
        return this.priceMetric;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUserId() {
        return this.userId;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.userId;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.title;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.categoryId;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        String str5 = this.category;
        int hashCode5 = (((hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31) + c.a(this.dateTime)) * 31;
        String str6 = this.description;
        int hashCode6 = (hashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31;
        Images images2 = this.images;
        int hashCode7 = (hashCode6 + (images2 != null ? images2.hashCode() : 0)) * 31;
        String str7 = this.formattedPrice;
        int hashCode8 = (hashCode7 + (str7 != null ? str7.hashCode() : 0)) * 31;
        String str8 = this.priceMetric;
        int hashCode9 = (hashCode8 + (str8 != null ? str8.hashCode() : 0)) * 31;
        String str9 = this.price;
        int hashCode10 = (hashCode9 + (str9 != null ? str9.hashCode() : 0)) * 31;
        Metro metro2 = this.metro;
        int hashCode11 = (hashCode10 + (metro2 != null ? metro2.hashCode() : 0)) * 31;
        String str10 = this.location;
        if (str10 != null) {
            i = str10.hashCode();
        }
        return hashCode11 + i;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a2.b.a.a.a.L("Item(id=");
        L.append(this.id);
        L.append(", userId=");
        L.append(this.userId);
        L.append(", title=");
        L.append(this.title);
        L.append(", categoryId=");
        L.append(this.categoryId);
        L.append(", category=");
        L.append(this.category);
        L.append(", dateTime=");
        L.append(this.dateTime);
        L.append(", description=");
        L.append(this.description);
        L.append(", images=");
        L.append(this.images);
        L.append(", formattedPrice=");
        L.append(this.formattedPrice);
        L.append(", priceMetric=");
        L.append(this.priceMetric);
        L.append(", price=");
        L.append(this.price);
        L.append(", metro=");
        L.append(this.metro);
        L.append(", location=");
        return a2.b.a.a.a.t(L, this.location, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.userId);
        parcel.writeString(this.title);
        parcel.writeString(this.categoryId);
        parcel.writeString(this.category);
        parcel.writeLong(this.dateTime);
        parcel.writeString(this.description);
        parcel.writeParcelable(this.images, i);
        parcel.writeString(this.formattedPrice);
        parcel.writeString(this.priceMetric);
        parcel.writeString(this.price);
        parcel.writeParcelable(this.metro, i);
        parcel.writeString(this.location);
    }
}
