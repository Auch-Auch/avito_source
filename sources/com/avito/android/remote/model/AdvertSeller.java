package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongycastle.i18n.ErrorBundle;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0002\b\"\b\b\u0018\u0000 g2\u00020\u0001:\u0001gBÑ\u0001\u0012\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u0014\u0012\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010:\u001a\u00020\u001e\u0012\n\b\u0002\u0010;\u001a\u0004\u0018\u00010!\u0012\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010(\u0012\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010A\u001a\u0004\u0018\u00010.¢\u0006\u0004\be\u0010fJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u0010\u0010\rJ\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u001a\u0010\rJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0012\u0010\"\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0004\b\"\u0010#J\u0012\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b$\u0010\rJ\u0012\u0010%\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b%\u0010\rJ\u0012\u0010&\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010)\u001a\u0004\u0018\u00010(HÆ\u0003¢\u0006\u0004\b)\u0010*J\u0012\u0010,\u001a\u0004\u0018\u00010+HÆ\u0003¢\u0006\u0004\b,\u0010-J\u0012\u0010/\u001a\u0004\u0018\u00010.HÆ\u0003¢\u0006\u0004\b/\u00100JÚ\u0001\u0010B\u001a\u00020\u00002\n\b\u0002\u00101\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00104\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u00107\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u00108\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010:\u001a\u00020\u001e2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010!2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010(2\n\b\u0002\u0010@\u001a\u0004\u0018\u00010+2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010.HÆ\u0001¢\u0006\u0004\bB\u0010CJ\u0010\u0010D\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\bD\u0010\rJ\u0010\u0010E\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\bE\u0010\nJ\u001a\u0010H\u001a\u00020\u001e2\b\u0010G\u001a\u0004\u0018\u00010FHÖ\u0003¢\u0006\u0004\bH\u0010IR\u001e\u00102\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b2\u0010J\u001a\u0004\bK\u0010\rR\u001e\u00105\u001a\u0004\u0018\u00010\u00118\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b5\u0010L\u001a\u0004\bM\u0010\u0013R\u001e\u00108\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b8\u0010J\u001a\u0004\bN\u0010\rR\u001c\u0010:\u001a\u00020\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b:\u0010O\u001a\u0004\bP\u0010 R\u001e\u0010;\u001a\u0004\u0018\u00010!8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b;\u0010Q\u001a\u0004\bR\u0010#R\u001e\u0010@\u001a\u0004\u0018\u00010+8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b@\u0010S\u001a\u0004\bT\u0010-R\u001e\u00101\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b1\u0010J\u001a\u0004\bU\u0010\rR\u001e\u0010?\u001a\u0004\u0018\u00010(8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b?\u0010V\u001a\u0004\bW\u0010*R\u001e\u0010=\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b=\u0010J\u001a\u0004\bX\u0010\rR\u001e\u00107\u001a\u0004\u0018\u00010\u00178\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b7\u0010Y\u001a\u0004\bZ\u0010\u0019R\u001e\u00106\u001a\u0004\u0018\u00010\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b6\u0010[\u001a\u0004\b\\\u0010\u0016R\u001e\u0010>\u001a\u0004\u0018\u00010\u001e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b>\u0010]\u001a\u0004\b>\u0010'R\u001e\u0010A\u001a\u0004\u0018\u00010.8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\bA\u0010^\u001a\u0004\b_\u00100R\u001e\u00104\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b4\u0010J\u001a\u0004\b`\u0010\rR\u001e\u00103\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b3\u0010J\u001a\u0004\ba\u0010\rR\u001e\u0010<\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b<\u0010J\u001a\u0004\bb\u0010\rR\u001e\u00109\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b9\u0010c\u001a\u0004\bd\u0010\u001d¨\u0006h"}, d2 = {"Lcom/avito/android/remote/model/AdvertSeller;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "component3", "component4", "Lcom/avito/android/remote/model/SellerConnection;", "component5", "()Lcom/avito/android/remote/model/SellerConnection;", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component7", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component8", "Lcom/avito/android/remote/model/SellerRating;", "component9", "()Lcom/avito/android/remote/model/SellerRating;", "", "component10", "()Z", "Lcom/avito/android/remote/model/SellerReplySpeed;", "component11", "()Lcom/avito/android/remote/model/SellerReplySpeed;", "component12", "component13", "component14", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/SellerVerification;", "component15", "()Lcom/avito/android/remote/model/SellerVerification;", "Lcom/avito/android/remote/model/SellerSubscriptionInfo;", "component16", "()Lcom/avito/android/remote/model/SellerSubscriptionInfo;", "Lcom/avito/android/remote/model/Action;", "component17", "()Lcom/avito/android/remote/model/Action;", "title", "name", "postfix", "manager", "connection", "image", "link", ErrorBundle.SUMMARY_ENTRY, "rating", "online", "replySpeed", "userHashId", "userKey", "isVerified", "verification", "subscriptionInfo", "ratingAction", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerConnection;Lcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/remote/model/SellerRating;ZLcom/avito/android/remote/model/SellerReplySpeed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/SellerVerification;Lcom/avito/android/remote/model/SellerSubscriptionInfo;Lcom/avito/android/remote/model/Action;)Lcom/avito/android/remote/model/AdvertSeller;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Lcom/avito/android/remote/model/SellerConnection;", "getConnection", "getSummary", "Z", "getOnline", "Lcom/avito/android/remote/model/SellerReplySpeed;", "getReplySpeed", "Lcom/avito/android/remote/model/SellerSubscriptionInfo;", "getSubscriptionInfo", "getTitle", "Lcom/avito/android/remote/model/SellerVerification;", "getVerification", "getUserKey", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/Action;", "getRatingAction", "getManager", "getPostfix", "getUserHashId", "Lcom/avito/android/remote/model/SellerRating;", "getRating", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/SellerConnection;Lcom/avito/android/remote/model/Image;Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;Lcom/avito/android/remote/model/SellerRating;ZLcom/avito/android/remote/model/SellerReplySpeed;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/SellerVerification;Lcom/avito/android/remote/model/SellerSubscriptionInfo;Lcom/avito/android/remote/model/Action;)V", "Companion", "api_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSeller implements Parcelable {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<AdvertSeller> CREATOR = Parcels.creator(AdvertSeller$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("connection")
    @Nullable
    private final SellerConnection connection;
    @SerializedName("images")
    @Nullable
    private final Image image;
    @SerializedName("isVerified")
    @Nullable
    private final Boolean isVerified;
    @SerializedName("link")
    @Nullable
    private final DeepLink link;
    @SerializedName("manager")
    @Nullable
    private final String manager;
    @SerializedName("name")
    @Nullable
    private final String name;
    @SerializedName("online")
    private final boolean online;
    @SerializedName("postfix")
    @Nullable
    private final String postfix;
    @SerializedName("rating")
    @Nullable
    private final SellerRating rating;
    @SerializedName("ratingAction")
    @Nullable
    private final Action ratingAction;
    @SerializedName(ChannelContext.Item.REPLY_TIME)
    @Nullable
    private final SellerReplySpeed replySpeed;
    @SerializedName("subscribeInfo")
    @Nullable
    private final SellerSubscriptionInfo subscriptionInfo;
    @SerializedName(ErrorBundle.SUMMARY_ENTRY)
    @Nullable
    private final String summary;
    @SerializedName("title")
    @Nullable
    private final String title;
    @SerializedName("userHashId")
    @Nullable
    private final String userHashId;
    @SerializedName("userHash")
    @Nullable
    private final String userKey;
    @SerializedName("verification")
    @Nullable
    private final SellerVerification verification;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/AdvertSeller$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/AdvertSeller;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "api_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    public AdvertSeller() {
        this(null, null, null, null, null, null, null, null, null, false, null, null, null, null, null, null, null, 131071, null);
    }

    public AdvertSeller(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SellerConnection sellerConnection, @Nullable Image image2, @Nullable DeepLink deepLink, @Nullable String str5, @Nullable SellerRating sellerRating, boolean z, @Nullable SellerReplySpeed sellerReplySpeed, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable SellerVerification sellerVerification, @Nullable SellerSubscriptionInfo sellerSubscriptionInfo, @Nullable Action action) {
        this.title = str;
        this.name = str2;
        this.postfix = str3;
        this.manager = str4;
        this.connection = sellerConnection;
        this.image = image2;
        this.link = deepLink;
        this.summary = str5;
        this.rating = sellerRating;
        this.online = z;
        this.replySpeed = sellerReplySpeed;
        this.userHashId = str6;
        this.userKey = str7;
        this.isVerified = bool;
        this.verification = sellerVerification;
        this.subscriptionInfo = sellerSubscriptionInfo;
        this.ratingAction = action;
    }

    public static /* synthetic */ AdvertSeller copy$default(AdvertSeller advertSeller, String str, String str2, String str3, String str4, SellerConnection sellerConnection, Image image2, DeepLink deepLink, String str5, SellerRating sellerRating, boolean z, SellerReplySpeed sellerReplySpeed, String str6, String str7, Boolean bool, SellerVerification sellerVerification, SellerSubscriptionInfo sellerSubscriptionInfo, Action action, int i, Object obj) {
        return advertSeller.copy((i & 1) != 0 ? advertSeller.title : str, (i & 2) != 0 ? advertSeller.name : str2, (i & 4) != 0 ? advertSeller.postfix : str3, (i & 8) != 0 ? advertSeller.manager : str4, (i & 16) != 0 ? advertSeller.connection : sellerConnection, (i & 32) != 0 ? advertSeller.image : image2, (i & 64) != 0 ? advertSeller.link : deepLink, (i & 128) != 0 ? advertSeller.summary : str5, (i & 256) != 0 ? advertSeller.rating : sellerRating, (i & 512) != 0 ? advertSeller.online : z, (i & 1024) != 0 ? advertSeller.replySpeed : sellerReplySpeed, (i & 2048) != 0 ? advertSeller.userHashId : str6, (i & 4096) != 0 ? advertSeller.userKey : str7, (i & 8192) != 0 ? advertSeller.isVerified : bool, (i & 16384) != 0 ? advertSeller.verification : sellerVerification, (i & 32768) != 0 ? advertSeller.subscriptionInfo : sellerSubscriptionInfo, (i & 65536) != 0 ? advertSeller.ratingAction : action);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    public final boolean component10() {
        return this.online;
    }

    @Nullable
    public final SellerReplySpeed component11() {
        return this.replySpeed;
    }

    @Nullable
    public final String component12() {
        return this.userHashId;
    }

    @Nullable
    public final String component13() {
        return this.userKey;
    }

    @Nullable
    public final Boolean component14() {
        return this.isVerified;
    }

    @Nullable
    public final SellerVerification component15() {
        return this.verification;
    }

    @Nullable
    public final SellerSubscriptionInfo component16() {
        return this.subscriptionInfo;
    }

    @Nullable
    public final Action component17() {
        return this.ratingAction;
    }

    @Nullable
    public final String component2() {
        return this.name;
    }

    @Nullable
    public final String component3() {
        return this.postfix;
    }

    @Nullable
    public final String component4() {
        return this.manager;
    }

    @Nullable
    public final SellerConnection component5() {
        return this.connection;
    }

    @Nullable
    public final Image component6() {
        return this.image;
    }

    @Nullable
    public final DeepLink component7() {
        return this.link;
    }

    @Nullable
    public final String component8() {
        return this.summary;
    }

    @Nullable
    public final SellerRating component9() {
        return this.rating;
    }

    @NotNull
    public final AdvertSeller copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable SellerConnection sellerConnection, @Nullable Image image2, @Nullable DeepLink deepLink, @Nullable String str5, @Nullable SellerRating sellerRating, boolean z, @Nullable SellerReplySpeed sellerReplySpeed, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable SellerVerification sellerVerification, @Nullable SellerSubscriptionInfo sellerSubscriptionInfo, @Nullable Action action) {
        return new AdvertSeller(str, str2, str3, str4, sellerConnection, image2, deepLink, str5, sellerRating, z, sellerReplySpeed, str6, str7, bool, sellerVerification, sellerSubscriptionInfo, action);
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
        if (!(obj instanceof AdvertSeller)) {
            return false;
        }
        AdvertSeller advertSeller = (AdvertSeller) obj;
        return Intrinsics.areEqual(this.title, advertSeller.title) && Intrinsics.areEqual(this.name, advertSeller.name) && Intrinsics.areEqual(this.postfix, advertSeller.postfix) && Intrinsics.areEqual(this.manager, advertSeller.manager) && Intrinsics.areEqual(this.connection, advertSeller.connection) && Intrinsics.areEqual(this.image, advertSeller.image) && Intrinsics.areEqual(this.link, advertSeller.link) && Intrinsics.areEqual(this.summary, advertSeller.summary) && Intrinsics.areEqual(this.rating, advertSeller.rating) && this.online == advertSeller.online && Intrinsics.areEqual(this.replySpeed, advertSeller.replySpeed) && Intrinsics.areEqual(this.userHashId, advertSeller.userHashId) && Intrinsics.areEqual(this.userKey, advertSeller.userKey) && Intrinsics.areEqual(this.isVerified, advertSeller.isVerified) && Intrinsics.areEqual(this.verification, advertSeller.verification) && Intrinsics.areEqual(this.subscriptionInfo, advertSeller.subscriptionInfo) && Intrinsics.areEqual(this.ratingAction, advertSeller.ratingAction);
    }

    @Nullable
    public final SellerConnection getConnection() {
        return this.connection;
    }

    @Nullable
    public final Image getImage() {
        return this.image;
    }

    @Nullable
    public final DeepLink getLink() {
        return this.link;
    }

    @Nullable
    public final String getManager() {
        return this.manager;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    public final boolean getOnline() {
        return this.online;
    }

    @Nullable
    public final String getPostfix() {
        return this.postfix;
    }

    @Nullable
    public final SellerRating getRating() {
        return this.rating;
    }

    @Nullable
    public final Action getRatingAction() {
        return this.ratingAction;
    }

    @Nullable
    public final SellerReplySpeed getReplySpeed() {
        return this.replySpeed;
    }

    @Nullable
    public final SellerSubscriptionInfo getSubscriptionInfo() {
        return this.subscriptionInfo;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getUserHashId() {
        return this.userHashId;
    }

    @Nullable
    public final String getUserKey() {
        return this.userKey;
    }

    @Nullable
    public final SellerVerification getVerification() {
        return this.verification;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.title;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.postfix;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.manager;
        int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
        SellerConnection sellerConnection = this.connection;
        int hashCode5 = (hashCode4 + (sellerConnection != null ? sellerConnection.hashCode() : 0)) * 31;
        Image image2 = this.image;
        int hashCode6 = (hashCode5 + (image2 != null ? image2.hashCode() : 0)) * 31;
        DeepLink deepLink = this.link;
        int hashCode7 = (hashCode6 + (deepLink != null ? deepLink.hashCode() : 0)) * 31;
        String str5 = this.summary;
        int hashCode8 = (hashCode7 + (str5 != null ? str5.hashCode() : 0)) * 31;
        SellerRating sellerRating = this.rating;
        int hashCode9 = (hashCode8 + (sellerRating != null ? sellerRating.hashCode() : 0)) * 31;
        boolean z = this.online;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode9 + i2) * 31;
        SellerReplySpeed sellerReplySpeed = this.replySpeed;
        int hashCode10 = (i5 + (sellerReplySpeed != null ? sellerReplySpeed.hashCode() : 0)) * 31;
        String str6 = this.userHashId;
        int hashCode11 = (hashCode10 + (str6 != null ? str6.hashCode() : 0)) * 31;
        String str7 = this.userKey;
        int hashCode12 = (hashCode11 + (str7 != null ? str7.hashCode() : 0)) * 31;
        Boolean bool = this.isVerified;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 31;
        SellerVerification sellerVerification = this.verification;
        int hashCode14 = (hashCode13 + (sellerVerification != null ? sellerVerification.hashCode() : 0)) * 31;
        SellerSubscriptionInfo sellerSubscriptionInfo = this.subscriptionInfo;
        int hashCode15 = (hashCode14 + (sellerSubscriptionInfo != null ? sellerSubscriptionInfo.hashCode() : 0)) * 31;
        Action action = this.ratingAction;
        if (action != null) {
            i = action.hashCode();
        }
        return hashCode15 + i;
    }

    @Nullable
    public final Boolean isVerified() {
        return this.isVerified;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("AdvertSeller(title=");
        L.append(this.title);
        L.append(", name=");
        L.append(this.name);
        L.append(", postfix=");
        L.append(this.postfix);
        L.append(", manager=");
        L.append(this.manager);
        L.append(", connection=");
        L.append(this.connection);
        L.append(", image=");
        L.append(this.image);
        L.append(", link=");
        L.append(this.link);
        L.append(", summary=");
        L.append(this.summary);
        L.append(", rating=");
        L.append(this.rating);
        L.append(", online=");
        L.append(this.online);
        L.append(", replySpeed=");
        L.append(this.replySpeed);
        L.append(", userHashId=");
        L.append(this.userHashId);
        L.append(", userKey=");
        L.append(this.userKey);
        L.append(", isVerified=");
        L.append(this.isVerified);
        L.append(", verification=");
        L.append(this.verification);
        L.append(", subscriptionInfo=");
        L.append(this.subscriptionInfo);
        L.append(", ratingAction=");
        L.append(this.ratingAction);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeString(this.name);
        parcel.writeString(this.postfix);
        parcel.writeString(this.manager);
        parcel.writeParcelable(this.connection, i);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.link, i);
        parcel.writeString(this.summary);
        parcel.writeParcelable(this.rating, i);
        ParcelsKt.writeBool(parcel, this.online);
        parcel.writeParcelable(this.replySpeed, i);
        parcel.writeString(this.userHashId);
        parcel.writeString(this.userKey);
        ParcelsKt.writeNullableValue(parcel, this.isVerified);
        parcel.writeParcelable(this.verification, i);
        parcel.writeParcelable(this.subscriptionInfo, i);
        parcel.writeParcelable(this.ratingAction, i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AdvertSeller(String str, String str2, String str3, String str4, SellerConnection sellerConnection, Image image2, DeepLink deepLink, String str5, SellerRating sellerRating, boolean z, SellerReplySpeed sellerReplySpeed, String str6, String str7, Boolean bool, SellerVerification sellerVerification, SellerSubscriptionInfo sellerSubscriptionInfo, Action action, int i, j jVar) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : sellerConnection, (i & 32) != 0 ? null : image2, (i & 64) != 0 ? null : deepLink, (i & 128) != 0 ? null : str5, (i & 256) != 0 ? null : sellerRating, (i & 512) != 0 ? false : z, (i & 1024) != 0 ? null : sellerReplySpeed, (i & 2048) != 0 ? null : str6, (i & 4096) != 0 ? null : str7, (i & 8192) != 0 ? null : bool, (i & 16384) != 0 ? null : sellerVerification, (i & 32768) != 0 ? null : sellerSubscriptionInfo, (i & 65536) != 0 ? null : action);
    }
}
