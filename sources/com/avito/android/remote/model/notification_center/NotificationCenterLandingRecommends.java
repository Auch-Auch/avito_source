package com.avito.android.remote.model.notification_center;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.Sort;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.facebook.share.internal.ShareConstants;
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
import t6.r.a.j;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0001$BC\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\"\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR*\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element;", MessengerShareContentUtility.ELEMENTS, "Ljava/util/List;", "getElements", "()Ljava/util/List;", "", "analyticParams", "Ljava/util/Map;", "getAnalyticParams", "()Ljava/util/Map;", "title", "getTitle", "<init>", "(Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/Map;)V", "Element", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommends implements Parcelable {
    public static final Parcelable.Creator<NotificationCenterLandingRecommends> CREATOR = new Creator();
    @SerializedName("analyticParams")
    @Nullable
    private final Map<String, String> analyticParams;
    @SerializedName("description")
    @NotNull
    private final String description;
    @SerializedName(MessengerShareContentUtility.ELEMENTS)
    @NotNull
    private final List<Element> elements;
    @SerializedName("image")
    @NotNull
    private final Image image;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<NotificationCenterLandingRecommends> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingRecommends createFromParcel(@NotNull Parcel parcel) {
            LinkedHashMap linkedHashMap;
            Intrinsics.checkNotNullParameter(parcel, "in");
            Image image = (Image) parcel.readParcelable(NotificationCenterLandingRecommends.class.getClassLoader());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            while (readInt != 0) {
                arrayList.add((Element) parcel.readParcelable(NotificationCenterLandingRecommends.class.getClassLoader()));
                readInt--;
            }
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                linkedHashMap = new LinkedHashMap(readInt2);
                while (readInt2 != 0) {
                    readInt2 = a.U(parcel, linkedHashMap, parcel.readString(), readInt2, -1);
                }
            } else {
                linkedHashMap = null;
            }
            return new NotificationCenterLandingRecommends(image, readString, readString2, arrayList, linkedHashMap);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NotificationCenterLandingRecommends[] newArray(int i) {
            return new NotificationCenterLandingRecommends[i];
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element;", "Landroid/os/Parcelable;", "<init>", "()V", "Advert", "Title", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element$Advert;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element$Title;", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Element implements Parcelable {

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0007\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010 \u001a\u00020\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0019\u001a\u00020\u0010\u0012\u0006\u0010\"\u001a\u00020\u0010\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b*\u0010+J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u00020\u00158\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0016\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001c\u0010\u001c\u001a\u00020\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010\u0012\u001a\u0004\b!\u0010\u0014R\u001c\u0010\"\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010\u0012\u001a\u0004\b#\u0010\u0014R\u001e\u0010$\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010\u0012\u001a\u0004\b%\u0010\u0014R\u001e\u0010&\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010\u0012\u001a\u0004\b'\u0010\u0014R\u001e\u0010(\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b(\u0010\u0012\u001a\u0004\b)\u0010\u0014¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element$Advert;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "Ljava/lang/String;", "getAddress", "()Ljava/lang/String;", "", "isFavorite", "Z", "()Z", "title", "getTitle", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "id", "getId", "price", "getPrice", "location", "getLocation", Sort.DISTANCE, "getDistance", "priceWithoutDiscount", "getPriceWithoutDiscount", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static final class Advert extends Element {
            public static final Parcelable.Creator<Advert> CREATOR = new Creator();
            @SerializedName(IntegrityManager.INTEGRITY_TYPE_ADDRESS)
            @Nullable
            private final String address;
            @SerializedName(ShareConstants.MEDIA_URI)
            @NotNull
            private final DeepLink deepLink;
            @SerializedName(Sort.DISTANCE)
            @Nullable
            private final String distance;
            @SerializedName("id")
            @NotNull
            private final String id;
            @SerializedName("image")
            @NotNull
            private final Image image;
            @SerializedName("isFavorite")
            private final boolean isFavorite;
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
                    return new Advert(parcel.readString(), (Image) parcel.readParcelable(Advert.class.getClassLoader()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, (DeepLink) parcel.readParcelable(Advert.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Advert[] newArray(int i) {
                    return new Advert[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Advert(@NotNull String str, @NotNull Image image2, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, boolean z, @NotNull DeepLink deepLink2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(image2, "image");
                Intrinsics.checkNotNullParameter(str2, "title");
                Intrinsics.checkNotNullParameter(str3, "price");
                Intrinsics.checkNotNullParameter(deepLink2, "deepLink");
                this.id = str;
                this.image = image2;
                this.title = str2;
                this.price = str3;
                this.priceWithoutDiscount = str4;
                this.location = str5;
                this.distance = str6;
                this.address = str7;
                this.isFavorite = z;
                this.deepLink = deepLink2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @Nullable
            public final String getAddress() {
                return this.address;
            }

            @NotNull
            public final DeepLink getDeepLink() {
                return this.deepLink;
            }

            @Nullable
            public final String getDistance() {
                return this.distance;
            }

            @NotNull
            public final String getId() {
                return this.id;
            }

            @NotNull
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

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.id);
                parcel.writeParcelable(this.image, i);
                parcel.writeString(this.title);
                parcel.writeString(this.price);
                parcel.writeString(this.priceWithoutDiscount);
                parcel.writeString(this.location);
                parcel.writeString(this.distance);
                parcel.writeString(this.address);
                parcel.writeInt(this.isFavorite ? 1 : 0);
                parcel.writeParcelable(this.deepLink, i);
            }
        }

        @Parcelize
        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element$Title;", "Lcom/avito/android/remote/model/notification_center/NotificationCenterLandingRecommends$Element;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Action;)V", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static final class Title extends Element {
            public static final Parcelable.Creator<Title> CREATOR = new Creator();
            @SerializedName("action")
            @NotNull
            private final Action action;
            @SerializedName("title")
            @NotNull
            private final String title;

            @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
            public static class Creator implements Parcelable.Creator<Title> {
                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Title createFromParcel(@NotNull Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "in");
                    return new Title(parcel.readString(), (Action) parcel.readParcelable(Title.class.getClassLoader()));
                }

                @Override // android.os.Parcelable.Creator
                @NotNull
                public final Title[] newArray(int i) {
                    return new Title[i];
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Title(@NotNull String str, @NotNull Action action2) {
                super(null);
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(action2, "action");
                this.title = str;
                this.action = action2;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            @NotNull
            public final Action getAction() {
                return this.action;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                parcel.writeString(this.title);
                parcel.writeParcelable(this.action, i);
            }
        }

        private Element() {
        }

        public /* synthetic */ Element(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends$Element> */
    /* JADX WARN: Multi-variable type inference failed */
    public NotificationCenterLandingRecommends(@NotNull Image image2, @NotNull String str, @NotNull String str2, @NotNull List<? extends Element> list, @Nullable Map<String, String> map) {
        Intrinsics.checkNotNullParameter(image2, "image");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(list, MessengerShareContentUtility.ELEMENTS);
        this.image = image2;
        this.title = str;
        this.description = str2;
        this.elements = list;
        this.analyticParams = map;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Map<String, String> getAnalyticParams() {
        return this.analyticParams;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final List<Element> getElements() {
        return this.elements;
    }

    @NotNull
    public final Image getImage() {
        return this.image;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [java.util.Map$Entry, java.lang.Object] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // android.os.Parcelable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
        /*
            r2 = this;
            java.lang.String r0 = "parcel"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.avito.android.remote.model.Image r0 = r2.image
            r3.writeParcelable(r0, r4)
            java.lang.String r0 = r2.title
            r3.writeString(r0)
            java.lang.String r0 = r2.description
            r3.writeString(r0)
            java.util.List<com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends$Element> r0 = r2.elements
            java.util.Iterator r0 = a2.b.a.a.a.n0(r0, r3)
        L_0x001a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x002a
            java.lang.Object r1 = r0.next()
            com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends$Element r1 = (com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends.Element) r1
            r3.writeParcelable(r1, r4)
            goto L_0x001a
        L_0x002a:
            java.util.Map<java.lang.String, java.lang.String> r4 = r2.analyticParams
            if (r4 == 0) goto L_0x0050
            r0 = 1
            java.util.Iterator r4 = a2.b.a.a.a.m0(r3, r0, r4)
        L_0x0033:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x0054
            java.lang.Object r0 = r4.next()
            java.lang.Object r1 = r0.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r3.writeString(r1)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r0 = (java.lang.String) r0
            r3.writeString(r0)
            goto L_0x0033
        L_0x0050:
            r4 = 0
            r3.writeInt(r4)
        L_0x0054:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.model.notification_center.NotificationCenterLandingRecommends.writeToParcel(android.os.Parcel, int):void");
    }
}
