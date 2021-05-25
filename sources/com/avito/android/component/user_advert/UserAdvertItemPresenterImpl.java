package com.avito.android.component.user_advert;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.R;
import com.avito.android.remote.UserAdvertStatusType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertStats;
import com.avito.android.remote.model.AdvertStatsContact;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TimeToLive;
import com.avito.android.remote.model.UserAdvert;
import com.avito.android.remote.model.badge.Badge;
import com.avito.android.remote.model.user_adverts.UserOrderStatus;
import com.avito.android.util.Strings;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxrelay3.PublishRelay;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import io.reactivex.rxjava3.core.Observable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.MoneyMaskConstantsKt;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u0014¢\u0006\u0004\b\u001f\u0010 J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u0004\u0018\u00010\u000b*\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\f\u0010\rRD\u0010\u0013\u001a0\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f \u0010*\u0017\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000f0\u000f\u0018\u00010\u000e¢\u0006\u0002\b\u00110\u000e¢\u0006\u0002\b\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\u0012R\u001e\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00198\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d¨\u0006!"}, d2 = {"Lcom/avito/android/component/user_advert/UserAdvertItemPresenterImpl;", "Lcom/avito/android/component/user_advert/UserAdvertItemPresenter;", "Lcom/avito/android/component/user_advert/UserAdvertItemView;", "view", "Lcom/avito/android/component/user_advert/UserAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/component/user_advert/UserAdvertItemView;Lcom/avito/android/component/user_advert/UserAdvertItem;I)V", "", AuthSource.SEND_ABUSE, "(Ljava/lang/Integer;)Ljava/lang/String;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "Lcom/avito/android/deep_linking/links/DeepLink;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "deeplinkRelay", "Ldagger/Lazy;", "Lcom/avito/android/component/user_advert/UserAdvertItemClickListener;", "c", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lio/reactivex/rxjava3/core/Observable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/rxjava3/core/Observable;", "getDeeplinkClicks", "()Lio/reactivex/rxjava3/core/Observable;", "deeplinkClicks", "<init>", "(Ldagger/Lazy;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class UserAdvertItemPresenterImpl implements UserAdvertItemPresenter {
    public final PublishRelay<DeepLink> a;
    @NotNull
    public final Observable<DeepLink> b;
    public final Lazy<? extends UserAdvertItemClickListener> c;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            UserOrderStatus.Type.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            UserOrderStatus.Type type = UserOrderStatus.Type.PROCESSING;
            iArr[0] = 1;
            UserOrderStatus.Type type2 = UserOrderStatus.Type.DONE;
            iArr[1] = 2;
            UserOrderStatus.Type type3 = UserOrderStatus.Type.WARNING;
            iArr[2] = 3;
            UserOrderStatus.Type type4 = UserOrderStatus.Type.ERROR;
            iArr[3] = 4;
            UserAdvertStatusType.values();
            int[] iArr2 = new int[1];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[0] = 1;
        }
    }

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ UserAdvertItemPresenterImpl a;
        public final /* synthetic */ UserAdvertItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(UserAdvertItemPresenterImpl userAdvertItemPresenterImpl, UserAdvertItem userAdvertItem) {
            super(0);
            this.a = userAdvertItemPresenterImpl;
            this.b = userAdvertItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((UserAdvertItemClickListener) this.a.c.get()).onAdvertClicked(this.b);
            this.a.a.accept(this.b.getDeepLink());
            return Unit.INSTANCE;
        }
    }

    public UserAdvertItemPresenterImpl(@NotNull Lazy<? extends UserAdvertItemClickListener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.c = lazy;
        PublishRelay<DeepLink> create = PublishRelay.create();
        this.a = create;
        Intrinsics.checkNotNullExpressionValue(create, "deeplinkRelay");
        this.b = create;
    }

    public final String a(Integer num) {
        return Strings.formatAsNumber(num != null ? String.valueOf(num.intValue()) : null, MoneyMaskConstantsKt.MONEY_MASK_SPACE);
    }

    @Override // com.avito.android.deep_linking.DeeplinkClickStreamProvider3
    @NotNull
    public Observable<DeepLink> getDeeplinkClicks() {
        return this.b;
    }

    public void bindView(@NotNull UserAdvertItemView userAdvertItemView, @NotNull UserAdvertItem userAdvertItem, int i) {
        Picture picture;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(userAdvertItemView, "view");
        Intrinsics.checkNotNullParameter(userAdvertItem, "item");
        userAdvertItemView.setClickListener(new a(this, userAdvertItem));
        userAdvertItemView.setTitle(userAdvertItem.getTitle());
        userAdvertItemView.setPrice(userAdvertItem.getPrice());
        Map<String, Image> servicesIcons = userAdvertItem.getServicesIcons();
        boolean z = false;
        boolean z2 = servicesIcons != null && (servicesIcons.isEmpty() ^ true);
        Badge priceTypeBadge = userAdvertItem.getPriceTypeBadge();
        if (priceTypeBadge == null || z2) {
            userAdvertItemView.hidePriceBadge();
        } else {
            userAdvertItemView.setPriceBadge(priceTypeBadge);
        }
        userAdvertItemView.setModerationStatus(userAdvertItem.isModerated());
        userAdvertItemView.setDeliveryVisible(userAdvertItem.getHasDelivery());
        AdvertStats stats = userAdvertItem.getStats();
        String str = null;
        if (stats == null || !stats.hasCounters()) {
            userAdvertItemView.hideStats();
        } else {
            Integer total = stats.getTotal();
            if (total != null && total.intValue() == 0) {
                userAdvertItemView.showViewsStatsNoViews();
            } else {
                String a3 = a(stats.getTotal());
                Integer today = stats.getToday();
                if (!(today == null || today.intValue() != 0)) {
                    today = null;
                }
                userAdvertItemView.showViewsStats(a3, a(today));
            }
            AdvertStatsContact contacts = stats.getContacts();
            if (contacts == null) {
                userAdvertItemView.hideContactStats();
            } else if (contacts.getTotal() == 0) {
                userAdvertItemView.showContactStatsNoViews();
            } else {
                String a4 = a(Integer.valueOf(contacts.getTotal()));
                Integer valueOf = Integer.valueOf(contacts.getToday());
                if (valueOf.intValue() != 0) {
                    z = true;
                }
                if (!z) {
                    valueOf = null;
                }
                userAdvertItemView.showContactStats(a4, a(valueOf));
            }
            userAdvertItemView.showFavoritesStats(a(stats.getFavorites()));
        }
        if (userAdvertItem.getDeclineReason() != null) {
            userAdvertItemView.setDeclineReason(userAdvertItem.getDeclineReason(), !Intrinsics.areEqual(userAdvertItem.getShortcut(), "rejected"));
        } else {
            TimeToLive ttl = userAdvertItem.getTtl();
            if (ttl != null) {
                str = ttl.getDescription();
            }
            userAdvertItemView.setTimeToLive(str);
        }
        if (userAdvertItem.getForegroundImage() == null) {
            picture = AvitoPictureKt.pictureOf$default(userAdvertItem.getImage(), false, 0.0f, 0.0f, null, 28, null);
        } else {
            picture = AvitoPictureKt.pictureOf$default(false, 0.0f, 0.0f, userAdvertItem.getForegroundImage(), 6, null);
        }
        userAdvertItemView.setImage(picture);
        if (z2) {
            Intrinsics.checkNotNull(servicesIcons);
            Map<String, ? extends Picture> linkedHashMap = new LinkedHashMap<>(q.mapCapacity(servicesIcons.size()));
            for (T t : servicesIcons.entrySet()) {
                linkedHashMap.put(t.getKey(), AvitoPictureKt.pictureOf$default((Image) t.getValue(), true, 0.0f, 0.0f, null, 28, null));
            }
            userAdvertItemView.setServiceIcons(linkedHashMap);
        } else {
            userAdvertItemView.hideServices();
        }
        UserAdvert.Status status = userAdvertItem.getStatus();
        if (status == null) {
            userAdvertItemView.hideStatus();
        } else {
            String description = status.getDescription();
            if (status.getType().ordinal() != 0) {
                i3 = R.attr.gray28;
            } else {
                i3 = R.attr.green;
            }
            userAdvertItemView.showStatus(description, i3);
        }
        UserOrderStatus orderStatus = userAdvertItem.getOrderStatus();
        if (orderStatus == null) {
            userAdvertItemView.hideOrderStatus();
        } else {
            String description2 = orderStatus.getDescription();
            UserOrderStatus.Type type = orderStatus.getType();
            if (type != null) {
                int ordinal = type.ordinal();
                if (ordinal == 0) {
                    i2 = R.attr.gray4;
                } else if (ordinal == 1) {
                    i2 = R.attr.green200;
                } else if (ordinal == 2) {
                    i2 = R.attr.orange100;
                } else if (ordinal == 3) {
                    i2 = R.attr.red200;
                }
                userAdvertItemView.showOrderStatus(description2, i2);
            }
            i2 = R.attr.white;
            userAdvertItemView.showOrderStatus(description2, i2);
        }
        userAdvertItemView.setAutoPublishVisibility(userAdvertItem.isAutoPublishOn());
    }
}
