package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.UserAdvertStatusType;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.google.firebase.messaging.Constants;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0002\b.\b\b\u0018\u0000 \u00012\u00020\u00012\u00020\u0002:\u0004\u0001\u0001BÙ\u0001\u0012\u0006\u0010?\u001a\u00020\f\u0012\u0006\u0010@\u001a\u00020\f\u0012\b\u0010A\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010B\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010C\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010D\u001a\u0004\u0018\u00010\f\u0012\b\u0010E\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010F\u001a\u00020\u001b\u0012\b\u0010G\u001a\u0004\u0018\u00010\u001e\u0012\u000e\u0010H\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!\u0012\b\u0010I\u001a\u0004\u0018\u00010%\u0012\b\u0010J\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010K\u001a\u00020)\u0012\b\u0010L\u001a\u0004\u0018\u00010,\u0012\b\u0010M\u001a\u0004\u0018\u00010)\u0012\b\u0010N\u001a\u0004\u0018\u000101\u0012\b\u0010O\u001a\u0004\u0018\u000104\u0012\b\u0010P\u001a\u0004\u0018\u00010\f\u0012\b\u0010Q\u001a\u0004\u0018\u000108\u0012\b\u0010R\u001a\u0004\u0018\u00010)\u0012\b\u0010S\u001a\u0004\u0018\u00010<¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\fHÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u0019\u0010\u000eJ\u0012\u0010\u001a\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\u001a\u0010\u000eJ\u0010\u0010\u001c\u001a\u00020\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001eHÆ\u0003¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!HÆ\u0003¢\u0006\u0004\b#\u0010$J\u0012\u0010&\u001a\u0004\u0018\u00010%HÆ\u0003¢\u0006\u0004\b&\u0010'J\u0012\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b(\u0010\u000eJ\u0010\u0010*\u001a\u00020)HÆ\u0003¢\u0006\u0004\b*\u0010+J\u0012\u0010-\u001a\u0004\u0018\u00010,HÆ\u0003¢\u0006\u0004\b-\u0010.J\u0012\u0010/\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b/\u00100J\u0012\u00102\u001a\u0004\u0018\u000101HÆ\u0003¢\u0006\u0004\b2\u00103J\u0012\u00105\u001a\u0004\u0018\u000104HÆ\u0003¢\u0006\u0004\b5\u00106J\u0012\u00107\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b7\u0010\u000eJ\u0012\u00109\u001a\u0004\u0018\u000108HÆ\u0003¢\u0006\u0004\b9\u0010:J\u0012\u0010;\u001a\u0004\u0018\u00010)HÆ\u0003¢\u0006\u0004\b;\u00100J\u0012\u0010=\u001a\u0004\u0018\u00010<HÆ\u0003¢\u0006\u0004\b=\u0010>J\u0002\u0010T\u001a\u00020\u00002\b\b\u0002\u0010?\u001a\u00020\f2\b\b\u0002\u0010@\u001a\u00020\f2\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010B\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010C\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010F\u001a\u00020\u001b2\n\b\u0002\u0010G\u001a\u0004\u0018\u00010\u001e2\u0010\b\u0002\u0010H\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!2\n\b\u0002\u0010I\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010J\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010K\u001a\u00020)2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010M\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010N\u001a\u0004\u0018\u0001012\n\b\u0002\u0010O\u001a\u0004\u0018\u0001042\n\b\u0002\u0010P\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010Q\u001a\u0004\u0018\u0001082\n\b\u0002\u0010R\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010S\u001a\u0004\u0018\u00010<HÆ\u0001¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020\fHÖ\u0001¢\u0006\u0004\bV\u0010\u000eJ\u0010\u0010W\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\bW\u0010\u000bJ\u001a\u0010Z\u001a\u00020)2\b\u0010Y\u001a\u0004\u0018\u00010XHÖ\u0003¢\u0006\u0004\bZ\u0010[R\u001b\u0010R\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\bR\u0010\\\u001a\u0004\bR\u00100R\u001b\u0010J\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bJ\u0010]\u001a\u0004\b^\u0010\u000eR\u001b\u0010C\u001a\u0004\u0018\u00010\u00168\u0006@\u0006¢\u0006\f\n\u0004\bC\u0010_\u001a\u0004\b`\u0010\u0018R\u001b\u0010D\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bD\u0010]\u001a\u0004\ba\u0010\u000eR\u001b\u0010E\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bE\u0010]\u001a\u0004\bb\u0010\u000eR\u001b\u0010G\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006¢\u0006\f\n\u0004\bG\u0010c\u001a\u0004\bd\u0010 R\u0019\u0010F\u001a\u00020\u001b8\u0006@\u0006¢\u0006\f\n\u0004\bF\u0010e\u001a\u0004\bf\u0010\u001dR\u001b\u0010M\u001a\u0004\u0018\u00010)8\u0006@\u0006¢\u0006\f\n\u0004\bM\u0010\\\u001a\u0004\bg\u00100R\u0019\u0010@\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b@\u0010]\u001a\u0004\bh\u0010\u000eR\u001b\u0010Q\u001a\u0004\u0018\u0001088\u0006@\u0006¢\u0006\f\n\u0004\bQ\u0010i\u001a\u0004\bj\u0010:R\u001b\u0010L\u001a\u0004\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\bL\u0010k\u001a\u0004\bl\u0010.R\u001b\u0010P\u001a\u0004\u0018\u00010\f8\u0006@\u0006¢\u0006\f\n\u0004\bP\u0010]\u001a\u0004\bm\u0010\u000eR\"\u0010n\u001a\u00020\u001b8\u0016@\u0016X\u000e¢\u0006\u0012\n\u0004\bn\u0010e\u001a\u0004\bo\u0010\u001d\"\u0004\bp\u0010qR\u001b\u0010A\u001a\u0004\u0018\u00010\u00108\u0006@\u0006¢\u0006\f\n\u0004\bA\u0010r\u001a\u0004\bs\u0010\u0012R\u0019\u0010K\u001a\u00020)8\u0006@\u0006¢\u0006\f\n\u0004\bK\u0010t\u001a\u0004\bK\u0010+R\u0019\u0010?\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\b?\u0010]\u001a\u0004\bu\u0010\u000eR\u001b\u0010I\u001a\u0004\u0018\u00010%8\u0006@\u0006¢\u0006\f\n\u0004\bI\u0010v\u001a\u0004\bw\u0010'R\u001b\u0010O\u001a\u0004\u0018\u0001048\u0006@\u0006¢\u0006\f\n\u0004\bO\u0010x\u001a\u0004\by\u00106R\u001b\u0010S\u001a\u0004\u0018\u00010<8\u0006@\u0006¢\u0006\f\n\u0004\bS\u0010z\u001a\u0004\b{\u0010>R\u001b\u0010B\u001a\u0004\u0018\u00010\u00138\u0006@\u0006¢\u0006\f\n\u0004\bB\u0010|\u001a\u0004\b}\u0010\u0015R\u001b\u0010N\u001a\u0004\u0018\u0001018\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010~\u001a\u0004\b\u00103R#\u0010H\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006¢\u0006\u000e\n\u0005\bH\u0010\u0001\u001a\u0005\b\u0001\u0010$¨\u0006\u0001"}, d2 = {"Lcom/avito/android/remote/model/UserAdvert;", "Landroid/os/Parcelable;", "Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/NameIdEntity;", "component3", "()Lcom/avito/android/remote/model/NameIdEntity;", "Lcom/avito/android/remote/model/AdvertImage;", "component4", "()Lcom/avito/android/remote/model/AdvertImage;", "Lcom/avito/android/remote/model/Video;", "component5", "()Lcom/avito/android/remote/model/Video;", "component6", "component7", "", "component8", "()J", "Lcom/avito/android/remote/model/AdvertStats;", "component9", "()Lcom/avito/android/remote/model/AdvertStats;", "", "Lcom/avito/android/remote/model/Service;", "component10", "()Ljava/util/List;", "Lcom/avito/android/remote/model/TimeToLive;", "component11", "()Lcom/avito/android/remote/model/TimeToLive;", "component12", "", "component13", "()Z", "Lcom/avito/android/deep_linking/links/DeepLink;", "component14", "()Lcom/avito/android/deep_linking/links/DeepLink;", "component15", "()Ljava/lang/Boolean;", "Lcom/avito/android/remote/model/UserAdvert$Status;", "component16", "()Lcom/avito/android/remote/model/UserAdvert$Status;", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "component17", "()Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "component18", "Lcom/avito/android/remote/model/PriceBadge;", "component19", "()Lcom/avito/android/remote/model/PriceBadge;", "component20", "Lcom/avito/android/remote/model/ForegroundImage;", "component21", "()Lcom/avito/android/remote/model/ForegroundImage;", "id", "title", "category", "image", "video", "price", "shortcut", "time", "stats", "servicesIcons", Constants.FirelogAnalytics.PARAM_TTL, "declineReason", "isModerated", "deepLink", "hasDelivery", "status", "orderStatus", "shortcutTitle", "priceBadge", "isAutoPublishOn", "foregroundImage", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/NameIdEntity;Lcom/avito/android/remote/model/AdvertImage;Lcom/avito/android/remote/model/Video;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/AdvertStats;Ljava/util/List;Lcom/avito/android/remote/model/TimeToLive;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;Lcom/avito/android/remote/model/UserAdvert$Status;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Ljava/lang/String;Lcom/avito/android/remote/model/PriceBadge;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ForegroundImage;)Lcom/avito/android/remote/model/UserAdvert;", "toString", "hashCode", "", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "Ljava/lang/String;", "getDeclineReason", "Lcom/avito/android/remote/model/Video;", "getVideo", "getPrice", "getShortcut", "Lcom/avito/android/remote/model/AdvertStats;", "getStats", "J", "getTime", "getHasDelivery", "getTitle", "Lcom/avito/android/remote/model/PriceBadge;", "getPriceBadge", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "getShortcutTitle", "uniqueId", "getUniqueId", "setUniqueId", "(J)V", "Lcom/avito/android/remote/model/NameIdEntity;", "getCategory", "Z", "getId", "Lcom/avito/android/remote/model/TimeToLive;", "getTtl", "Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;", "getOrderStatus", "Lcom/avito/android/remote/model/ForegroundImage;", "getForegroundImage", "Lcom/avito/android/remote/model/AdvertImage;", "getImage", "Lcom/avito/android/remote/model/UserAdvert$Status;", "getStatus", "Ljava/util/List;", "getServicesIcons", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/NameIdEntity;Lcom/avito/android/remote/model/AdvertImage;Lcom/avito/android/remote/model/Video;Ljava/lang/String;Ljava/lang/String;JLcom/avito/android/remote/model/AdvertStats;Ljava/util/List;Lcom/avito/android/remote/model/TimeToLive;Ljava/lang/String;ZLcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/Boolean;Lcom/avito/android/remote/model/UserAdvert$Status;Lcom/avito/android/remote/model/user_adverts/UserOrderStatus;Ljava/lang/String;Lcom/avito/android/remote/model/PriceBadge;Ljava/lang/Boolean;Lcom/avito/android/remote/model/ForegroundImage;)V", "Companion", "Status", "models_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvert implements Parcelable, SerpElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<UserAdvert> CREATOR = Parcels.creator(UserAdvert$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final NameIdEntity category;
    @Nullable
    private final String declineReason;
    @Nullable
    private final DeepLink deepLink;
    @Nullable
    private final ForegroundImage foregroundImage;
    @Nullable
    private final Boolean hasDelivery;
    @NotNull
    private final String id;
    @Nullable
    private final AdvertImage image;
    @Nullable
    private final Boolean isAutoPublishOn;
    private final boolean isModerated;
    @Nullable
    private final UserOrderStatus orderStatus;
    @Nullable
    private final String price;
    @Nullable
    private final PriceBadge priceBadge;
    @Nullable
    private final List<Service> servicesIcons;
    @Nullable
    private final String shortcut;
    @Nullable
    private final String shortcutTitle;
    @Nullable
    private final AdvertStats stats;
    @Nullable
    private final Status status;
    private final long time;
    @NotNull
    private final String title;
    @Nullable
    private final TimeToLive ttl;
    private long uniqueId;
    @Nullable
    private final Video video;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/UserAdvert$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/UserAdvert;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0017\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\u00020\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0011\u001a\u00020\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/remote/model/UserAdvert$Status;", "Landroid/os/Parcelable;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/UserAdvertStatusType;", "type", "Lcom/avito/android/remote/UserAdvertStatusType;", "getType", "()Lcom/avito/android/remote/UserAdvertStatusType;", "", "description", "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "<init>", "(Lcom/avito/android/remote/UserAdvertStatusType;Ljava/lang/String;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Status implements Parcelable {
        @JvmField
        @NotNull
        public static final Parcelable.Creator<Status> CREATOR = Parcels.creator(UserAdvert$Status$Companion$CREATOR$1.INSTANCE);
        @NotNull
        public static final Companion Companion = new Companion(null);
        @SerializedName("description")
        @NotNull
        private final String description;
        @SerializedName("type")
        @NotNull
        private final UserAdvertStatusType type;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/UserAdvert$Status$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/UserAdvert$Status;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        public Status(@NotNull UserAdvertStatusType userAdvertStatusType, @NotNull String str) {
            Intrinsics.checkNotNullParameter(userAdvertStatusType, "type");
            Intrinsics.checkNotNullParameter(str, "description");
            this.type = userAdvertStatusType;
            this.description = str;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getDescription() {
            return this.description;
        }

        @NotNull
        public final UserAdvertStatusType getType() {
            return this.type;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "dest");
            ParcelsKt.writeEnum(parcel, this.type);
            parcel.writeString(this.description);
        }
    }

    public UserAdvert(@NotNull String str, @NotNull String str2, @Nullable NameIdEntity nameIdEntity, @Nullable AdvertImage advertImage, @Nullable Video video2, @Nullable String str3, @Nullable String str4, long j, @Nullable AdvertStats advertStats, @Nullable List<Service> list, @Nullable TimeToLive timeToLive, @Nullable String str5, boolean z, @Nullable DeepLink deepLink2, @Nullable Boolean bool, @Nullable Status status2, @Nullable UserOrderStatus userOrderStatus, @Nullable String str6, @Nullable PriceBadge priceBadge2, @Nullable Boolean bool2, @Nullable ForegroundImage foregroundImage2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        this.id = str;
        this.title = str2;
        this.category = nameIdEntity;
        this.image = advertImage;
        this.video = video2;
        this.price = str3;
        this.shortcut = str4;
        this.time = j;
        this.stats = advertStats;
        this.servicesIcons = list;
        this.ttl = timeToLive;
        this.declineReason = str5;
        this.isModerated = z;
        this.deepLink = deepLink2;
        this.hasDelivery = bool;
        this.status = status2;
        this.orderStatus = userOrderStatus;
        this.shortcutTitle = str6;
        this.priceBadge = priceBadge2;
        this.isAutoPublishOn = bool2;
        this.foregroundImage = foregroundImage2;
    }

    public static /* synthetic */ UserAdvert copy$default(UserAdvert userAdvert, String str, String str2, NameIdEntity nameIdEntity, AdvertImage advertImage, Video video2, String str3, String str4, long j, AdvertStats advertStats, List list, TimeToLive timeToLive, String str5, boolean z, DeepLink deepLink2, Boolean bool, Status status2, UserOrderStatus userOrderStatus, String str6, PriceBadge priceBadge2, Boolean bool2, ForegroundImage foregroundImage2, int i, Object obj) {
        return userAdvert.copy((i & 1) != 0 ? userAdvert.id : str, (i & 2) != 0 ? userAdvert.title : str2, (i & 4) != 0 ? userAdvert.category : nameIdEntity, (i & 8) != 0 ? userAdvert.image : advertImage, (i & 16) != 0 ? userAdvert.video : video2, (i & 32) != 0 ? userAdvert.price : str3, (i & 64) != 0 ? userAdvert.shortcut : str4, (i & 128) != 0 ? userAdvert.time : j, (i & 256) != 0 ? userAdvert.stats : advertStats, (i & 512) != 0 ? userAdvert.servicesIcons : list, (i & 1024) != 0 ? userAdvert.ttl : timeToLive, (i & 2048) != 0 ? userAdvert.declineReason : str5, (i & 4096) != 0 ? userAdvert.isModerated : z, (i & 8192) != 0 ? userAdvert.deepLink : deepLink2, (i & 16384) != 0 ? userAdvert.hasDelivery : bool, (i & 32768) != 0 ? userAdvert.status : status2, (i & 65536) != 0 ? userAdvert.orderStatus : userOrderStatus, (i & 131072) != 0 ? userAdvert.shortcutTitle : str6, (i & 262144) != 0 ? userAdvert.priceBadge : priceBadge2, (i & 524288) != 0 ? userAdvert.isAutoPublishOn : bool2, (i & 1048576) != 0 ? userAdvert.foregroundImage : foregroundImage2);
    }

    @NotNull
    public final String component1() {
        return this.id;
    }

    @Nullable
    public final List<Service> component10() {
        return this.servicesIcons;
    }

    @Nullable
    public final TimeToLive component11() {
        return this.ttl;
    }

    @Nullable
    public final String component12() {
        return this.declineReason;
    }

    public final boolean component13() {
        return this.isModerated;
    }

    @Nullable
    public final DeepLink component14() {
        return this.deepLink;
    }

    @Nullable
    public final Boolean component15() {
        return this.hasDelivery;
    }

    @Nullable
    public final Status component16() {
        return this.status;
    }

    @Nullable
    public final UserOrderStatus component17() {
        return this.orderStatus;
    }

    @Nullable
    public final String component18() {
        return this.shortcutTitle;
    }

    @Nullable
    public final PriceBadge component19() {
        return this.priceBadge;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @Nullable
    public final Boolean component20() {
        return this.isAutoPublishOn;
    }

    @Nullable
    public final ForegroundImage component21() {
        return this.foregroundImage;
    }

    @Nullable
    public final NameIdEntity component3() {
        return this.category;
    }

    @Nullable
    public final AdvertImage component4() {
        return this.image;
    }

    @Nullable
    public final Video component5() {
        return this.video;
    }

    @Nullable
    public final String component6() {
        return this.price;
    }

    @Nullable
    public final String component7() {
        return this.shortcut;
    }

    public final long component8() {
        return this.time;
    }

    @Nullable
    public final AdvertStats component9() {
        return this.stats;
    }

    @NotNull
    public final UserAdvert copy(@NotNull String str, @NotNull String str2, @Nullable NameIdEntity nameIdEntity, @Nullable AdvertImage advertImage, @Nullable Video video2, @Nullable String str3, @Nullable String str4, long j, @Nullable AdvertStats advertStats, @Nullable List<Service> list, @Nullable TimeToLive timeToLive, @Nullable String str5, boolean z, @Nullable DeepLink deepLink2, @Nullable Boolean bool, @Nullable Status status2, @Nullable UserOrderStatus userOrderStatus, @Nullable String str6, @Nullable PriceBadge priceBadge2, @Nullable Boolean bool2, @Nullable ForegroundImage foregroundImage2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        return new UserAdvert(str, str2, nameIdEntity, advertImage, video2, str3, str4, j, advertStats, list, timeToLive, str5, z, deepLink2, bool, status2, userOrderStatus, str6, priceBadge2, bool2, foregroundImage2);
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
        if (!(obj instanceof UserAdvert)) {
            return false;
        }
        UserAdvert userAdvert = (UserAdvert) obj;
        return Intrinsics.areEqual(this.id, userAdvert.id) && Intrinsics.areEqual(this.title, userAdvert.title) && Intrinsics.areEqual(this.category, userAdvert.category) && Intrinsics.areEqual(this.image, userAdvert.image) && Intrinsics.areEqual(this.video, userAdvert.video) && Intrinsics.areEqual(this.price, userAdvert.price) && Intrinsics.areEqual(this.shortcut, userAdvert.shortcut) && this.time == userAdvert.time && Intrinsics.areEqual(this.stats, userAdvert.stats) && Intrinsics.areEqual(this.servicesIcons, userAdvert.servicesIcons) && Intrinsics.areEqual(this.ttl, userAdvert.ttl) && Intrinsics.areEqual(this.declineReason, userAdvert.declineReason) && this.isModerated == userAdvert.isModerated && Intrinsics.areEqual(this.deepLink, userAdvert.deepLink) && Intrinsics.areEqual(this.hasDelivery, userAdvert.hasDelivery) && Intrinsics.areEqual(this.status, userAdvert.status) && Intrinsics.areEqual(this.orderStatus, userAdvert.orderStatus) && Intrinsics.areEqual(this.shortcutTitle, userAdvert.shortcutTitle) && Intrinsics.areEqual(this.priceBadge, userAdvert.priceBadge) && Intrinsics.areEqual(this.isAutoPublishOn, userAdvert.isAutoPublishOn) && Intrinsics.areEqual(this.foregroundImage, userAdvert.foregroundImage);
    }

    @Nullable
    public final NameIdEntity getCategory() {
        return this.category;
    }

    @Nullable
    public final String getDeclineReason() {
        return this.declineReason;
    }

    @Nullable
    public final DeepLink getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final ForegroundImage getForegroundImage() {
        return this.foregroundImage;
    }

    @Nullable
    public final Boolean getHasDelivery() {
        return this.hasDelivery;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final AdvertImage getImage() {
        return this.image;
    }

    @Nullable
    public final UserOrderStatus getOrderStatus() {
        return this.orderStatus;
    }

    @Nullable
    public final String getPrice() {
        return this.price;
    }

    @Nullable
    public final PriceBadge getPriceBadge() {
        return this.priceBadge;
    }

    @Nullable
    public final List<Service> getServicesIcons() {
        return this.servicesIcons;
    }

    @Nullable
    public final String getShortcut() {
        return this.shortcut;
    }

    @Nullable
    public final String getShortcutTitle() {
        return this.shortcutTitle;
    }

    @Nullable
    public final AdvertStats getStats() {
        return this.stats;
    }

    @Nullable
    public final Status getStatus() {
        return this.status;
    }

    public final long getTime() {
        return this.time;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final TimeToLive getTtl() {
        return this.ttl;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Nullable
    public final Video getVideo() {
        return this.video;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.title;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        NameIdEntity nameIdEntity = this.category;
        int hashCode3 = (hashCode2 + (nameIdEntity != null ? nameIdEntity.hashCode() : 0)) * 31;
        AdvertImage advertImage = this.image;
        int hashCode4 = (hashCode3 + (advertImage != null ? advertImage.hashCode() : 0)) * 31;
        Video video2 = this.video;
        int hashCode5 = (hashCode4 + (video2 != null ? video2.hashCode() : 0)) * 31;
        String str3 = this.price;
        int hashCode6 = (hashCode5 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.shortcut;
        int hashCode7 = (((hashCode6 + (str4 != null ? str4.hashCode() : 0)) * 31) + c.a(this.time)) * 31;
        AdvertStats advertStats = this.stats;
        int hashCode8 = (hashCode7 + (advertStats != null ? advertStats.hashCode() : 0)) * 31;
        List<Service> list = this.servicesIcons;
        int hashCode9 = (hashCode8 + (list != null ? list.hashCode() : 0)) * 31;
        TimeToLive timeToLive = this.ttl;
        int hashCode10 = (hashCode9 + (timeToLive != null ? timeToLive.hashCode() : 0)) * 31;
        String str5 = this.declineReason;
        int hashCode11 = (hashCode10 + (str5 != null ? str5.hashCode() : 0)) * 31;
        boolean z = this.isModerated;
        if (z) {
            z = true;
        }
        int i2 = z ? 1 : 0;
        int i3 = z ? 1 : 0;
        int i4 = z ? 1 : 0;
        int i5 = (hashCode11 + i2) * 31;
        DeepLink deepLink2 = this.deepLink;
        int hashCode12 = (i5 + (deepLink2 != null ? deepLink2.hashCode() : 0)) * 31;
        Boolean bool = this.hasDelivery;
        int hashCode13 = (hashCode12 + (bool != null ? bool.hashCode() : 0)) * 31;
        Status status2 = this.status;
        int hashCode14 = (hashCode13 + (status2 != null ? status2.hashCode() : 0)) * 31;
        UserOrderStatus userOrderStatus = this.orderStatus;
        int hashCode15 = (hashCode14 + (userOrderStatus != null ? userOrderStatus.hashCode() : 0)) * 31;
        String str6 = this.shortcutTitle;
        int hashCode16 = (hashCode15 + (str6 != null ? str6.hashCode() : 0)) * 31;
        PriceBadge priceBadge2 = this.priceBadge;
        int hashCode17 = (hashCode16 + (priceBadge2 != null ? priceBadge2.hashCode() : 0)) * 31;
        Boolean bool2 = this.isAutoPublishOn;
        int hashCode18 = (hashCode17 + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        ForegroundImage foregroundImage2 = this.foregroundImage;
        if (foregroundImage2 != null) {
            i = foregroundImage2.hashCode();
        }
        return hashCode18 + i;
    }

    @Nullable
    public final Boolean isAutoPublishOn() {
        return this.isAutoPublishOn;
    }

    public final boolean isModerated() {
        return this.isModerated;
    }

    @Override // com.avito.android.remote.model.SerpElement
    public void setUniqueId(long j) {
        this.uniqueId = j;
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        StringBuilder L = a.L("UserAdvert(id=");
        L.append(this.id);
        L.append(", title=");
        L.append(this.title);
        L.append(", category=");
        L.append(this.category);
        L.append(", image=");
        L.append(this.image);
        L.append(", video=");
        L.append(this.video);
        L.append(", price=");
        L.append(this.price);
        L.append(", shortcut=");
        L.append(this.shortcut);
        L.append(", time=");
        L.append(this.time);
        L.append(", stats=");
        L.append(this.stats);
        L.append(", servicesIcons=");
        L.append(this.servicesIcons);
        L.append(", ttl=");
        L.append(this.ttl);
        L.append(", declineReason=");
        L.append(this.declineReason);
        L.append(", isModerated=");
        L.append(this.isModerated);
        L.append(", deepLink=");
        L.append(this.deepLink);
        L.append(", hasDelivery=");
        L.append(this.hasDelivery);
        L.append(", status=");
        L.append(this.status);
        L.append(", orderStatus=");
        L.append(this.orderStatus);
        L.append(", shortcutTitle=");
        L.append(this.shortcutTitle);
        L.append(", priceBadge=");
        L.append(this.priceBadge);
        L.append(", isAutoPublishOn=");
        L.append(this.isAutoPublishOn);
        L.append(", foregroundImage=");
        L.append(this.foregroundImage);
        L.append(")");
        return L.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.id);
        parcel.writeString(this.title);
        parcel.writeParcelable(this.category, i);
        parcel.writeParcelable(this.image, i);
        parcel.writeParcelable(this.video, i);
        parcel.writeString(this.price);
        parcel.writeString(this.shortcut);
        parcel.writeLong(this.time);
        parcel.writeParcelable(this.stats, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.servicesIcons, 0, 2, null);
        parcel.writeParcelable(this.ttl, i);
        parcel.writeString(this.declineReason);
        ParcelsKt.writeBool(parcel, this.isModerated);
        parcel.writeParcelable(this.deepLink, i);
        ParcelsKt.writeNullableValue(parcel, this.hasDelivery);
        parcel.writeParcelable(this.status, i);
        parcel.writeParcelable(this.orderStatus, i);
        parcel.writeString(this.shortcutTitle);
        parcel.writeParcelable(this.priceBadge, i);
        ParcelsKt.writeOptBoolean(parcel, this.isAutoPublishOn);
        parcel.writeParcelable(this.foregroundImage, i);
        parcel.writeLong(getUniqueId());
    }
}
