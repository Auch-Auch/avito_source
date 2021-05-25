package com.avito.android.remote.model.delivery;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0003+,-BW\u0012\u0006\u0010\u0018\u001a\u00020\u0017\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b\u0012\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011\u0012\b\u0010 \u001a\u0004\u0018\u00010\u001f\u0012\b\u0010%\u001a\u0004\u0018\u00010$¢\u0006\u0004\b)\u0010*J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0018\u001a\u00020\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR$\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001e\u0010\u0010R\u001e\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010%\u001a\u0004\u0018\u00010$8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(¨\u0006."}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummary;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/delivery/DeliverySummary$Price;", "prices", "Ljava/util/List;", "getPrices", "()Ljava/util/List;", "", "", "motivations", "Ljava/util/Map;", "getMotivations", "()Ljava/util/Map;", "Lcom/avito/android/remote/model/delivery/DeliverySummary$Item;", "item", "Lcom/avito/android/remote/model/delivery/DeliverySummary$Item;", "getItem", "()Lcom/avito/android/remote/model/delivery/DeliverySummary$Item;", "Lcom/avito/android/remote/model/delivery/CategoryParameterGroup;", "formSections", "getFormSections", "Lcom/avito/android/remote/model/delivery/DeliverySummary$Contacts;", "contacts", "Lcom/avito/android/remote/model/delivery/DeliverySummary$Contacts;", "getContacts", "()Lcom/avito/android/remote/model/delivery/DeliverySummary$Contacts;", "Lcom/avito/android/remote/model/text/AttributedText;", "disclaimer", "Lcom/avito/android/remote/model/text/AttributedText;", "getDisclaimer", "()Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "(Lcom/avito/android/remote/model/delivery/DeliverySummary$Item;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Lcom/avito/android/remote/model/delivery/DeliverySummary$Contacts;Lcom/avito/android/remote/model/text/AttributedText;)V", "Contacts", "Item", "Price", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliverySummary implements Parcelable {
    public static final Parcelable.Creator<DeliverySummary> CREATOR = new Creator();
    @SerializedName("contacts")
    @Nullable
    private final Contacts contacts;
    @SerializedName("disclaimer")
    @Nullable
    private final AttributedText disclaimer;
    @SerializedName("formSections")
    @Nullable
    private final List<CategoryParameterGroup> formSections;
    @SerializedName("item")
    @NotNull
    private final Item item;
    @SerializedName("motivations")
    @Nullable
    private final Map<String, String> motivations;
    @SerializedName("prices")
    @NotNull
    private final List<Price> prices;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummary$Contacts;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Contacts implements Parcelable {
        public static final Parcelable.Creator<Contacts> CREATOR = new Creator();
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @NotNull
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Contacts> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Contacts createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Contacts(parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Contacts[] newArray(int i) {
                return new Contacts[i];
            }
        }

        public Contacts(@NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, MessengerShareContentUtility.SUBTITLE);
            this.title = str;
            this.subtitle = str2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DeliverySummary> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummary createFromParcel(@NotNull Parcel parcel) {
            ArrayList arrayList;
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Item createFromParcel = Item.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList2.add(Price.CREATOR.createFromParcel(parcel));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add((CategoryParameterGroup) parcel.readParcelable(DeliverySummary.class.getClassLoader()));
                    readInt2--;
                }
            } else {
                arrayList = null;
            }
            if (parcel.readInt() != 0) {
                int readInt3 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt3);
                while (readInt3 != 0) {
                    readInt3 = a.U(parcel, linkedHashMap, parcel.readString(), readInt3, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new DeliverySummary(createFromParcel, arrayList2, arrayList, linkedHashMap, parcel.readInt() != 0 ? Contacts.CREATOR.createFromParcel(parcel) : null, (AttributedText) parcel.readParcelable(DeliverySummary.class.getClassLoader()));
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DeliverySummary[] newArray(int i) {
            return new DeliverySummary[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0015\u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummary$Item;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "price", "getPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item implements Parcelable {
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @SerializedName("image")
        @NotNull
        private final Image image;
        @SerializedName("price")
        @NotNull
        private final String price;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Item(parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(Item.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        public Item(@NotNull String str, @NotNull String str2, @NotNull Image image2) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(str2, "price");
            Intrinsics.checkNotNullParameter(image2, "image");
            this.title = str;
            this.price = str2;
            this.image = image2;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final Image getImage() {
            return this.image;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.price);
            parcel.writeParcelable(this.image, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001c\u0010\u0012\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/delivery/DeliverySummary$Price;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "price", "getPrice", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Price implements Parcelable {
        public static final Parcelable.Creator<Price> CREATOR = new Creator();
        @SerializedName("price")
        @NotNull
        private final String price;
        @SerializedName(MessengerShareContentUtility.SUBTITLE)
        @NotNull
        private final String subtitle;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Price> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Price createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Price(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Price[] newArray(int i) {
                return new Price[i];
            }
        }

        public Price(@NotNull String str, @NotNull String str2, @NotNull String str3) {
            a.Z0(str, "title", str2, MessengerShareContentUtility.SUBTITLE, str3, "price");
            this.title = str;
            this.subtitle = str2;
            this.price = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        @NotNull
        public final String getSubtitle() {
            return this.subtitle;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.subtitle);
            parcel.writeString(this.price);
        }
    }

    public DeliverySummary(@NotNull Item item2, @NotNull List<Price> list, @Nullable List<CategoryParameterGroup> list2, @Nullable Map<String, String> map, @Nullable Contacts contacts2, @Nullable AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(item2, "item");
        Intrinsics.checkNotNullParameter(list, "prices");
        this.item = item2;
        this.prices = list;
        this.formSections = list2;
        this.motivations = map;
        this.contacts = contacts2;
        this.disclaimer = attributedText;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Contacts getContacts() {
        return this.contacts;
    }

    @Nullable
    public final AttributedText getDisclaimer() {
        return this.disclaimer;
    }

    @Nullable
    public final List<CategoryParameterGroup> getFormSections() {
        return this.formSections;
    }

    @NotNull
    public final Item getItem() {
        return this.item;
    }

    @Nullable
    public final Map<String, String> getMotivations() {
        return this.motivations;
    }

    @NotNull
    public final List<Price> getPrices() {
        return this.prices;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r6, int r7) {
        /*
            r5 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            com.avito.android.remote.model.delivery.DeliverySummary$Item r0 = r5.item
            r1 = 0
            r0.writeToParcel(r6, r1)
            java.util.List<com.avito.android.remote.model.delivery.DeliverySummary$Price> r0 = r5.prices
            java.util.Iterator r0 = a2.b.a.a.a.n0(r0, r6)
        L_0x0011:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0021
            java.lang.Object r2 = r0.next()
            com.avito.android.remote.model.delivery.DeliverySummary$Price r2 = (com.avito.android.remote.model.delivery.DeliverySummary.Price) r2
            r2.writeToParcel(r6, r1)
            goto L_0x0011
        L_0x0021:
            java.util.List<com.avito.android.remote.model.delivery.CategoryParameterGroup> r0 = r5.formSections
            r2 = 1
            if (r0 == 0) goto L_0x003a
            java.util.Iterator r0 = a2.b.a.a.a.l0(r6, r2, r0)
        L_0x002a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x003d
            java.lang.Object r3 = r0.next()
            com.avito.android.remote.model.delivery.CategoryParameterGroup r3 = (com.avito.android.remote.model.delivery.CategoryParameterGroup) r3
            r6.writeParcelable(r3, r7)
            goto L_0x002a
        L_0x003a:
            r6.writeInt(r1)
        L_0x003d:
            java.util.Map<java.lang.String, java.lang.String> r0 = r5.motivations
            if (r0 == 0) goto L_0x0062
            java.util.Iterator r0 = a2.b.a.a.a.m0(r6, r2, r0)
        L_0x0045:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0065
            java.lang.Object r3 = r0.next()
            java.lang.Object r4 = r3.getKey()
            java.lang.String r4 = (java.lang.String) r4
            r6.writeString(r4)
            java.lang.Object r3 = r3.getValue()
            java.lang.String r3 = (java.lang.String) r3
            r6.writeString(r3)
            goto L_0x0045
        L_0x0062:
            r6.writeInt(r1)
        L_0x0065:
            com.avito.android.remote.model.delivery.DeliverySummary$Contacts r0 = r5.contacts
            if (r0 == 0) goto L_0x0070
            r6.writeInt(r2)
            r0.writeToParcel(r6, r1)
            goto L_0x0073
        L_0x0070:
            r6.writeInt(r1)
        L_0x0073:
            com.avito.android.remote.model.text.AttributedText r0 = r5.disclaimer
            r6.writeParcelable(r0, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.delivery.DeliverySummary.writeToParcel(android.os.Parcel, int):void");
    }
}
