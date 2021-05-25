package com.avito.android.remote.model.notification_center;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.remote.model.Image;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0002*+BO\u0012\b\u0010$\u001a\u0004\u0018\u00010#\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u0012\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\u0006\u0010\u001f\u001a\u00020\u001e\u0012\u0006\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b(\u0010)J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR(\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00128\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u00020\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001e\u0010$\u001a\u0004\u0018\u00010#8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Ljava/lang/String;", "getButton", "()Ljava/lang/String;", "title", "getTitle", "", "analytics", "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "description", "getDescription", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Share;", "share", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Share;", "getShare", "()Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Share;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Advert;", "advert", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Advert;", "getAdvert", "()Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Advert;", "<init>", "(Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Advert;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Share;Ljava/lang/String;)V", "Advert", "Share", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingShare implements Parcelable {
    public static final Parcelable.Creator<NotificationCenterLandingShare> CREATOR = new Creator();
    @SerializedName("advert")
    @Nullable
    private final Advert advert;
    @SerializedName("analytics")
    @NotNull
    private final Map<String, String> analytics;
    @SerializedName(PhonePageSourceKt.PHONE_SOURCE_BUTTON)
    @NotNull
    private final String button;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName("image")
    @Nullable
    private final Image image;
    @SerializedName("share")
    @NotNull
    private final Share share;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\u00020\u0001B5\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0015\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\u0017\u001a\u00020\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0016\u0010\u000fR\u001c\u0010\u0017\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\r\u001a\u0004\b\u001a\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Advert;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "priceWithoutDiscount", "Ljava/lang/String;", "getPriceWithoutDiscount", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "price", "getPrice", "title", "getTitle", "location", "getLocation", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Advert implements Parcelable {
        public static final Parcelable.Creator<Advert> CREATOR = new Creator();
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("location")
        @Nullable
        private final String location;
        @SerializedName("price")
        @NotNull
        private final String price;
        @SerializedName("priceWithoutDiscount")
        @Nullable
        private final String priceWithoutDiscount;
        @SerializedName("title")
        @NotNull
        private final String title;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Advert> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Advert((Image) parcel.readParcelable(Advert.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Advert[] newArray(int i) {
                return new Advert[i];
            }
        }

        public Advert(@Nullable Image image2, @Nullable String str, @NotNull String str2, @Nullable String str3, @NotNull String str4) {
            Intrinsics.checkNotNullParameter(str2, "price");
            Intrinsics.checkNotNullParameter(str4, "title");
            this.image = image2;
            this.location = str;
            this.price = str2;
            this.priceWithoutDiscount = str3;
            this.title = str4;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Nullable
        public final String getLocation() {
            return this.location;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        @Nullable
        public final String getPriceWithoutDiscount() {
            return this.priceWithoutDiscount;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.image, i);
            parcel.writeString(this.location);
            parcel.writeString(this.price);
            parcel.writeString(this.priceWithoutDiscount);
            parcel.writeString(this.title);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationCenterLandingShare> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingShare createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            Advert createFromParcel = parcel.readInt() != 0 ? Advert.CREATOR.createFromParcel(parcel) : null;
            int readInt = parcel.readInt();
            LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
            while (true) {
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                if (readInt == 0) {
                    return new NotificationCenterLandingShare(createFromParcel, linkedHashMap, readString, readString2, (Image) parcel.readParcelable(NotificationCenterLandingShare.class.getClassLoader()), Share.CREATOR.createFromParcel(parcel), parcel.readString());
                }
                linkedHashMap.put(readString, readString2);
                readInt--;
            }
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingShare[] newArray(int i) {
            return new NotificationCenterLandingShare[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0010\u0010\r\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingShare$Share;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "title", "getTitle", "urlImage", "getUrlImage", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Share implements Parcelable {
        public static final Parcelable.Creator<Share> CREATOR = new Creator();
        @SerializedName("title")
        @Nullable
        private final String title;
        @SerializedName("url")
        @NotNull
        private final String url;
        @SerializedName("urlImage")
        @Nullable
        private final String urlImage;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Share> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Share createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Share(parcel.readString(), parcel.readString(), parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Share[] newArray(int i) {
                return new Share[i];
            }
        }

        public Share(@Nullable String str, @NotNull String str2, @Nullable String str3) {
            Intrinsics.checkNotNullParameter(str2, "url");
            this.title = str;
            this.url = str2;
            this.urlImage = str3;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Nullable
        public final String getTitle() {
            return this.title;
        }

        @NotNull
        public final String getUrl() {
            return this.url;
        }

        @Nullable
        public final String getUrlImage() {
            return this.urlImage;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.title);
            parcel.writeString(this.url);
            parcel.writeString(this.urlImage);
        }
    }

    public NotificationCenterLandingShare(@Nullable Advert advert2, @NotNull Map<String, String> map, @NotNull String str, @NotNull String str2, @Nullable Image image2, @NotNull Share share2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(map, "analytics");
        Intrinsics.checkNotNullParameter(str, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(share2, "share");
        Intrinsics.checkNotNullParameter(str3, "title");
        this.advert = advert2;
        this.analytics = map;
        this.button = str;
        this.description = str2;
        this.image = image2;
        this.share = share2;
        this.title = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Advert getAdvert() {
        return this.advert;
    }

    @NotNull
    public final Map<String, String> getAnalytics() {
        return this.analytics;
    }

    @NotNull
    public final String getButton() {
        return this.button;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final Share getShare() {
        return this.share;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            com.avito.android.remote.model.notification_center.NotificationCenterLandingShare$Advert r0 = r4.advert
            r1 = 0
            if (r0 == 0) goto L_0x0012
            r2 = 1
            r5.writeInt(r2)
            r0.writeToParcel(r5, r1)
            goto L_0x0015
        L_0x0012:
            r5.writeInt(r1)
        L_0x0015:
            java.util.Map<java.lang.String, java.lang.String> r0 = r4.analytics
            java.util.Iterator r0 = a2.b.a.a.a.o0(r0, r5)
        L_0x001b:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0038
            java.lang.Object r2 = r0.next()
            java.lang.Object r3 = r2.getKey()
            java.lang.String r3 = (java.lang.String) r3
            r5.writeString(r3)
            java.lang.Object r2 = r2.getValue()
            java.lang.String r2 = (java.lang.String) r2
            r5.writeString(r2)
            goto L_0x001b
        L_0x0038:
            java.lang.String r0 = r4.button
            r5.writeString(r0)
            java.lang.String r0 = r4.description
            r5.writeString(r0)
            com.avito.android.remote.model.Image r0 = r4.image
            r5.writeParcelable(r0, r6)
            com.avito.android.remote.model.notification_center.NotificationCenterLandingShare$Share r6 = r4.share
            r6.writeToParcel(r5, r1)
            java.lang.String r6 = r4.title
            r5.writeString(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.NotificationCenterLandingShare.writeToParcel(android.os.Parcel, int):void");
    }
}
