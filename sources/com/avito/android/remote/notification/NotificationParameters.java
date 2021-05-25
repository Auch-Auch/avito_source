package com.avito.android.remote.notification;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.notification.Payload;
import com.avito.android.util.ParcelUtils;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\n\u0018\u0000 ;2\u00020\u0001:\u0002;<Ba\u0012\u0006\u0010,\u001a\u00020'\u0012\u0014\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u000103\u0012\u0006\u0010 \u001a\u00020\u0012\u0012\u0006\u0010\u0017\u001a\u00020\u0012\u0012\u0006\u00102\u001a\u00020-\u0012\b\u0010&\u001a\u0004\u0018\u00010!\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0018\u0012\u000e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\u0004\b9\u0010:J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR!\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\u0017\u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00188\u0006@\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0019\u0010 \u001a\u00020\u00128\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u0014\u001a\u0004\b\u001f\u0010\u0016R\u001b\u0010&\u001a\u0004\u0018\u00010!8\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R\u0019\u0010,\u001a\u00020'8\u0006@\u0006¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u0019\u00102\u001a\u00020-8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R'\u00108\u001a\u0010\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0012\u0018\u0001038\u0006@\u0006¢\u0006\f\n\u0004\b4\u00105\u001a\u0004\b6\u00107¨\u0006="}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", VKApiConst.OUT, "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "Lcom/avito/android/remote/model/Action;", "h", "Ljava/util/List;", "getActions", "()Ljava/util/List;", "actions", "", "d", "Ljava/lang/String;", "getBody", "()Ljava/lang/String;", SDKConstants.PARAM_A2U_BODY, "Lcom/avito/android/remote/notification/NotificationParameters$Style;", g.a, "Lcom/avito/android/remote/notification/NotificationParameters$Style;", "getStyle", "()Lcom/avito/android/remote/notification/NotificationParameters$Style;", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "c", "getTitle", "title", "Lcom/avito/android/remote/model/notification/Payload;", "f", "Lcom/avito/android/remote/model/notification/Payload;", "getPayload", "()Lcom/avito/android/remote/model/notification/Payload;", "payload", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "link", "", "e", "Z", "getSoundAndVibrateEnabled", "()Z", "soundAndVibrateEnabled", "", AuthSource.BOOKING_ORDER, "Ljava/util/Map;", "getAnalytics", "()Ljava/util/Map;", "analytics", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/notification/Payload;Lcom/avito/android/remote/notification/NotificationParameters$Style;Ljava/util/List;)V", "Companion", "Style", "notifications_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationParameters implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<NotificationParameters> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final DeepLink a;
    @Nullable
    public final Map<String, String> b;
    @NotNull
    public final String c;
    @NotNull
    public final String d;
    public final boolean e;
    @Nullable
    public final Payload f;
    @Nullable
    public final Style g;
    @Nullable
    public final List<Action> h;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/notification/NotificationParameters;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\r\u000eB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\n\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Style;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "dest", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "<init>", "()V", "BigImage", "BigText", "Lcom/avito/android/remote/notification/NotificationParameters$Style$BigImage;", "Lcom/avito/android/remote/notification/NotificationParameters$Style$BigText;", "notifications_release"}, k = 1, mv = {1, 4, 2})
    public static abstract class Style implements Parcelable {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u000f\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Style$BigImage;", "Lcom/avito/android/remote/notification/NotificationParameters$Style;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "<init>", "(Lcom/avito/android/remote/model/Image;)V", "Companion", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static final class BigImage extends Style {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<BigImage> CREATOR = Parcels.creator(a.a);
            @NotNull
            public static final Companion Companion = new Companion(null);
            @SerializedName("image")
            @NotNull
            private final Image image;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Style$BigImage$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/notification/NotificationParameters$Style$BigImage;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                public Companion(j jVar) {
                }
            }

            public static final class a extends Lambda implements Function1<Parcel, BigImage> {
                public static final a a = new a();

                public a() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public BigImage invoke(Parcel parcel) {
                    Parcel parcel2 = parcel;
                    Intrinsics.checkNotNullParameter(parcel2, "$receiver");
                    return new BigImage((Image) a2.b.a.a.a.z1(Image.class, parcel2));
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public BigImage(@NotNull Image image2) {
                super(null);
                Intrinsics.checkNotNullParameter(image2, "image");
                this.image = image2;
            }

            @NotNull
            public final Image getImage() {
                return this.image;
            }

            @Override // com.avito.android.remote.notification.NotificationParameters.Style, android.os.Parcelable
            public void writeToParcel(@NotNull Parcel parcel, int i) {
                Intrinsics.checkNotNullParameter(parcel, "dest");
                parcel.writeParcelable(this.image, i);
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Style$BigText;", "Lcom/avito/android/remote/notification/NotificationParameters$Style;", "<init>", "()V", "Companion", "notifications_release"}, k = 1, mv = {1, 4, 2})
        public static final class BigText extends Style {
            @JvmField
            @NotNull
            public static final Parcelable.Creator<BigText> CREATOR = Parcels.creator(a.a);
            @NotNull
            public static final Companion Companion = new Companion(null);

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/notification/NotificationParameters$Style$BigText$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/notification/NotificationParameters$Style$BigText;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "notifications_release"}, k = 1, mv = {1, 4, 2})
            public static final class Companion {
                public Companion() {
                }

                public Companion(j jVar) {
                }
            }

            public static final class a extends Lambda implements Function1<Parcel, BigText> {
                public static final a a = new a();

                public a() {
                    super(1);
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // kotlin.jvm.functions.Function1
                public BigText invoke(Parcel parcel) {
                    Intrinsics.checkNotNullParameter(parcel, "$receiver");
                    return new BigText();
                }
            }

            public BigText() {
                super(null);
            }
        }

        public Style() {
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
        }

        public Style(j jVar) {
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, NotificationParameters> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public NotificationParameters invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            return new NotificationParameters((DeepLink) a2.b.a.a.a.z1(DeepLink.class, parcel2), ParcelUtils.createValueMap(parcel2, String.class, String.class), a2.b.a.a.a.u2(parcel2, "readString()!!"), a2.b.a.a.a.u2(parcel2, "readString()!!"), ParcelsKt.readBool(parcel2), (Payload) parcel2.readParcelable(Payload.class.getClassLoader()), (Style) parcel2.readParcelable(Style.class.getClassLoader()), ParcelsKt.createParcelableList(parcel2, Action.class));
        }
    }

    public NotificationParameters(@NotNull DeepLink deepLink, @Nullable Map<String, String> map, @NotNull String str, @NotNull String str2, boolean z, @Nullable Payload payload, @Nullable Style style, @Nullable List<Action> list) {
        Intrinsics.checkNotNullParameter(deepLink, "link");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, SDKConstants.PARAM_A2U_BODY);
        this.a = deepLink;
        this.b = map;
        this.c = str;
        this.d = str2;
        this.e = z;
        this.f = payload;
        this.g = style;
        this.h = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final List<Action> getActions() {
        return this.h;
    }

    @Nullable
    public final Map<String, String> getAnalytics() {
        return this.b;
    }

    @NotNull
    public final String getBody() {
        return this.d;
    }

    @NotNull
    public final DeepLink getLink() {
        return this.a;
    }

    @Nullable
    public final Payload getPayload() {
        return this.f;
    }

    public final boolean getSoundAndVibrateEnabled() {
        return this.e;
    }

    @Nullable
    public final Style getStyle() {
        return this.g;
    }

    @NotNull
    public final String getTitle() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, VKApiConst.OUT);
        parcel.writeParcelable(this.a, i);
        ParcelsKt.writeValueMap(parcel, this.b);
        parcel.writeString(this.c);
        parcel.writeString(this.d);
        ParcelsKt.writeBool(parcel, this.e);
        parcel.writeParcelable(this.f, i);
        parcel.writeParcelable(this.g, i);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.h, i);
    }
}
