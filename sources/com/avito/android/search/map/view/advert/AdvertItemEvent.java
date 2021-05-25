package com.avito.android.search.map.view.advert;

import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhoneRequestData;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.search.map.action.MapAction;
import com.avito.android.serp.ad.BannerInfo;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.FavorableItem;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.warning.SerpWarningItem;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u000e\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u000e\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f¨\u0006 "}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/search/map/action/MapAction;", "<init>", "()V", "AdBannerOpened", "AdvertCall", "AdvertClicked", "AdvertWrite", "AdvertXlClicked", "AuthForPhoneRequest", "DeepLinkClicked", "EmptyPlaceholderActionClicked", "FavoriteButtonClicked", "GroupClicked", "MapBannerItemSearchOnMapClicked", "WarningItemActionClicked", "WarningItemCloseClicked", "WitcherItemSearchButtonClicked", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertXlClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertCall;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertWrite;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$FavoriteButtonClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdBannerOpened;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$EmptyPlaceholderActionClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WitcherItemSearchButtonClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$MapBannerItemSearchOnMapClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$GroupClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$DeepLinkClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WarningItemActionClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WarningItemCloseClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AuthForPhoneRequest;", "map_release"}, k = 1, mv = {1, 4, 2})
public abstract class AdvertItemEvent implements MapAction {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdBannerOpened;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/serp/ad/BannerInfo;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/ad/BannerInfo;", "getBannerInfo", "()Lcom/avito/android/serp/ad/BannerInfo;", "bannerInfo", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(Lcom/avito/android/serp/ad/BannerInfo;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdBannerOpened extends AdvertItemEvent {
        @NotNull
        public final BannerInfo a;
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdBannerOpened(@NotNull BannerInfo bannerInfo, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(bannerInfo, "bannerInfo");
            this.a = bannerInfo;
            this.b = i;
        }

        @NotNull
        public final BannerInfo getBannerInfo() {
            return this.a;
        }

        public final int getPosition() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0013\u001a\u00020\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertCall;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "Lcom/avito/android/analytics/event/ContactSource;", "c", "Lcom/avito/android/analytics/event/ContactSource;", "getContactSource", "()Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertCall extends AdvertItemEvent {
        @NotNull
        public final String a;
        @Nullable
        public final DeepLink b;
        @NotNull
        public final ContactSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertCall(@NotNull String str, @Nullable DeepLink deepLink, @NotNull ContactSource contactSource) {
            super(null);
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(contactSource, "contactSource");
            this.a = str;
            this.b = deepLink;
            this.c = contactSource;
        }

        @NotNull
        public final String getAdvertId() {
            return this.a;
        }

        @NotNull
        public final ContactSource getContactSource() {
            return this.c;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0013\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/serp/adapter/AdvertItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/AdvertItem;", "getAdvert", "()Lcom/avito/android/serp/adapter/AdvertItem;", "advert", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "<init>", "(Lcom/avito/android/serp/adapter/AdvertItem;ILcom/avito/android/remote/model/Image;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertClicked extends AdvertItemEvent {
        @NotNull
        public final AdvertItem a;
        public final int b;
        @Nullable
        public final Image c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertClicked(@NotNull AdvertItem advertItem, int i, @Nullable Image image) {
            super(null);
            Intrinsics.checkNotNullParameter(advertItem, "advert");
            this.a = advertItem;
            this.b = i;
            this.c = image;
        }

        @NotNull
        public final AdvertItem getAdvert() {
            return this.a;
        }

        @Nullable
        public final Image getImage() {
            return this.c;
        }

        public final int getPosition() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertWrite;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/analytics/event/ContactSource;", "c", "Lcom/avito/android/analytics/event/ContactSource;", "getContactSource", "()Lcom/avito/android/analytics/event/ContactSource;", "contactSource", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getAdvertId", "()Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;Lcom/avito/android/analytics/event/ContactSource;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertWrite extends AdvertItemEvent {
        @NotNull
        public final String a;
        @Nullable
        public final DeepLink b;
        @NotNull
        public final ContactSource c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertWrite(@NotNull String str, @Nullable DeepLink deepLink, @NotNull ContactSource contactSource) {
            super(null);
            Intrinsics.checkNotNullParameter(str, BookingInfoActivity.EXTRA_ITEM_ID);
            Intrinsics.checkNotNullParameter(contactSource, "contactSource");
            this.a = str;
            this.b = deepLink;
            this.c = contactSource;
        }

        @NotNull
        public final String getAdvertId() {
            return this.a;
        }

        @NotNull
        public final ContactSource getContactSource() {
            return this.c;
        }

        @Nullable
        public final DeepLink getDeepLink() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u0013\u001a\u00020\u000e\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AdvertXlClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getImage", "()Lcom/avito/android/remote/model/Image;", "image", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "getAdvert", "()Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "advert", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;ILcom/avito/android/remote/model/Image;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AdvertXlClicked extends AdvertItemEvent {
        @NotNull
        public final AdvertXlItem a;
        public final int b;
        @Nullable
        public final Image c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AdvertXlClicked(@NotNull AdvertXlItem advertXlItem, int i, @Nullable Image image) {
            super(null);
            Intrinsics.checkNotNullParameter(advertXlItem, "advert");
            this.a = advertXlItem;
            this.b = i;
            this.c = image;
        }

        @NotNull
        public final AdvertXlItem getAdvert() {
            return this.a;
        }

        @Nullable
        public final Image getImage() {
            return this.c;
        }

        public final int getPosition() {
            return this.b;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$AuthForPhoneRequest;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", AuthSource.SEND_ABUSE, "Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "getData", "()Lcom/avito/android/async_phone/AsyncPhoneRequestData;", "data", "<init>", "(Lcom/avito/android/async_phone/AsyncPhoneRequestData;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class AuthForPhoneRequest extends AdvertItemEvent {
        @NotNull
        public final AsyncPhoneRequestData a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AuthForPhoneRequest(@NotNull AsyncPhoneRequestData asyncPhoneRequestData) {
            super(null);
            Intrinsics.checkNotNullParameter(asyncPhoneRequestData, "data");
            this.a = asyncPhoneRequestData;
        }

        @NotNull
        public final AsyncPhoneRequestData getData() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$DeepLinkClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class DeepLinkClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public DeepLinkClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$EmptyPlaceholderActionClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class EmptyPlaceholderActionClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public EmptyPlaceholderActionClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$FavoriteButtonClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/serp/adapter/FavorableItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/FavorableItem;", "getItem", "()Lcom/avito/android/serp/adapter/FavorableItem;", "item", "<init>", "(Lcom/avito/android/serp/adapter/FavorableItem;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class FavoriteButtonClicked extends AdvertItemEvent {
        @NotNull
        public final FavorableItem a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FavoriteButtonClicked(@NotNull FavorableItem favorableItem) {
            super(null);
            Intrinsics.checkNotNullParameter(favorableItem, "item");
            this.a = favorableItem;
        }

        @NotNull
        public final FavorableItem getItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$GroupClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class GroupClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public GroupClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$MapBannerItemSearchOnMapClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class MapBannerItemSearchOnMapClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MapBannerItemSearchOnMapClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WarningItemActionClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class WarningItemActionClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WarningItemActionClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\b¢\u0006\u0004\b\u000e\u0010\u000fR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WarningItemCloseClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "getWarningItem", "()Lcom/avito/android/serp/adapter/warning/SerpWarningItem;", "warningItem", "", AuthSource.BOOKING_ORDER, "I", "getPosition", "()I", VKApiConst.POSITION, "<init>", "(Lcom/avito/android/serp/adapter/warning/SerpWarningItem;I)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class WarningItemCloseClicked extends AdvertItemEvent {
        @NotNull
        public final SerpWarningItem a;
        public final int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WarningItemCloseClicked(@NotNull SerpWarningItem serpWarningItem, int i) {
            super(null);
            Intrinsics.checkNotNullParameter(serpWarningItem, "warningItem");
            this.a = serpWarningItem;
            this.b = i;
        }

        public final int getPosition() {
            return this.b;
        }

        @NotNull
        public final SerpWarningItem getWarningItem() {
            return this.a;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/search/map/view/advert/AdvertItemEvent$WitcherItemSearchButtonClicked;", "Lcom/avito/android/search/map/view/advert/AdvertItemEvent;", "Lcom/avito/android/deep_linking/links/DeepLink;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "map_release"}, k = 1, mv = {1, 4, 2})
    public static final class WitcherItemSearchButtonClicked extends AdvertItemEvent {
        @NotNull
        public final DeepLink a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public WitcherItemSearchButtonClicked(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "deepLink");
            this.a = deepLink;
        }

        @NotNull
        public final DeepLink getDeepLink() {
            return this.a;
        }
    }

    public AdvertItemEvent() {
    }

    public AdvertItemEvent(j jVar) {
    }
}
