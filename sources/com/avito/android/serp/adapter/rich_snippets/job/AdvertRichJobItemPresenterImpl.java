package com.avito.android.serp.adapter.rich_snippets.job;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.AdvertShownClickStreamEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertSellerInfo;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.AdvertItem;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B6\b\u0007\u0012\u0011\u0010\u0018\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00150\u0013\u0012\b\b\u0001\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u001d\u0010\u001eJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R!\u0010\u0018\u001a\r\u0012\t\u0012\u00070\u0014¢\u0006\u0002\b\u00150\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;", "view", "Lcom/avito/android/serp/adapter/AdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;Lcom/avito/android/serp/adapter/AdvertItem;I)V", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "Lcom/avito/android/analytics/Analytics;", "d", "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "c", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "<init>", "(Ldagger/Lazy;Lcom/avito/android/date_time_formatter/DateTimeFormatter;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/analytics/Analytics;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertRichJobItemPresenterImpl implements AdvertRichJobItemPresenter {
    public final Lazy<AdvertRichItemListener> a;
    public final DateTimeFormatter b;
    public final AsyncPhonePresenter c;
    public final Analytics d;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
            this.g = obj5;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            List<AdvertAction> actions;
            T t;
            DeepLink link;
            int i = this.a;
            DeepLink deepLink = null;
            if (i == 0) {
                AdvertActions contacts = ((AdvertItem) this.c).getContacts();
                if (!(contacts == null || (actions = contacts.getActions()) == null)) {
                    Iterator<T> it = actions.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            t = null;
                            break;
                        }
                        t = it.next();
                        if (t instanceof AdvertAction.Messenger) {
                            break;
                        }
                    }
                    T t2 = t;
                    if (t2 != null) {
                        deepLink = t2.getDeepLink();
                    }
                }
                if (deepLink != null) {
                    ((AdvertRichItemListener) ((AdvertRichJobItemPresenterImpl) this.e).a.get()).onWriteActionClicked(((AdvertItem) this.c).getStringId(), deepLink, ContactSource.CONTACT_REGULAR);
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertSellerInfo advertSellerInfo = (AdvertSellerInfo) this.c;
                if (!(advertSellerInfo == null || (link = advertSellerInfo.getLink()) == null)) {
                    ((AdvertRichItemListener) ((AdvertRichJobItemPresenterImpl) this.e).a.get()).onDeepLinkActionClicked(link);
                }
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = i2;
            this.c = obj;
            this.d = obj2;
            this.e = obj3;
            this.f = obj4;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ((AdvertRichItemListener) ((AdvertRichJobItemPresenterImpl) this.d).a.get()).onFavoriteButtonClicked((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertRichJobItemPresenterKt.clearCallbacks((AdvertRichJobItemView) this.c);
                ((AdvertRichJobItemView) this.c).clearPictures();
                ((AdvertRichJobItemView) this.c).clearActions();
                ((AdvertRichJobItemPresenterImpl) this.d).c.unbindItem((AdvertItem) this.e);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertItem a;
        public final /* synthetic */ AdvertRichJobItemView b;
        public final /* synthetic */ AdvertRichJobItemPresenterImpl c;
        public final /* synthetic */ AdvertRichJobItemView d;
        public final /* synthetic */ int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertItem advertItem, AdvertRichJobItemView advertRichJobItemView, AdvertRichJobItemPresenterImpl advertRichJobItemPresenterImpl, AdvertItem advertItem2, AdvertRichJobItemView advertRichJobItemView2, int i) {
            super(1);
            this.a = advertItem;
            this.b = advertRichJobItemView;
            this.c = advertRichJobItemPresenterImpl;
            this.d = advertRichJobItemView2;
            this.e = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            ((AdvertRichItemListener) this.c.a.get()).onRichAdvertClicked(this.a, this.e, null, num);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertItem a;
        public final /* synthetic */ AdvertRichJobItemView b;
        public final /* synthetic */ AdvertRichJobItemPresenterImpl c;
        public final /* synthetic */ AdvertItem d;
        public final /* synthetic */ AdvertRichJobItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AdvertItem advertItem, AdvertRichJobItemView advertRichJobItemView, AdvertRichJobItemPresenterImpl advertRichJobItemPresenterImpl, AdvertItem advertItem2, AdvertRichJobItemView advertRichJobItemView2, int i) {
            super(0);
            this.a = advertItem;
            this.b = advertRichJobItemView;
            this.c = advertRichJobItemPresenterImpl;
            this.d = advertItem2;
            this.e = advertRichJobItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink trackSnippetCallEvent;
            if (this.d.getPhoneLoadingState() == PhoneLoadingState.IDLE && (trackSnippetCallEvent = AdvertRichItemPresenterKt.trackSnippetCallEvent(this.a, false, this.c.d)) != null) {
                this.c.c.loadPhoneLink(this.d, this.e, trackSnippetCallEvent, ContactSource.CONTACT_REGULAR, new a2.a.a.n2.w.c.a.a(this));
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertRichJobItemPresenterImpl(@NotNull Lazy<AdvertRichItemListener> lazy, @DateTimeFormatterModule.UpperCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "formatter");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.a = lazy;
        this.b = dateTimeFormatter;
        this.c = asyncPhonePresenter;
        this.d = analytics;
    }

    public void bindView(@NotNull AdvertRichJobItemView advertRichJobItemView, @NotNull AdvertItem advertItem, int i) {
        List<AdvertAction> actions;
        Intrinsics.checkNotNullParameter(advertRichJobItemView, "view");
        Intrinsics.checkNotNullParameter(advertItem, "item");
        Map<String, String> analyticParams = advertItem.getAnalyticParams();
        if (analyticParams != null && (!analyticParams.isEmpty())) {
            this.d.track(new AdvertShownClickStreamEvent(advertItem.getAnalyticParams()));
        }
        advertRichJobItemView.setTitle(advertItem.getTitle());
        advertRichJobItemView.setPrice(advertItem.getPrice(), advertItem.isHighlighted());
        advertRichJobItemView.setDescription(advertItem.getDescription());
        advertRichJobItemView.setAddress(advertItem.getAddress());
        Set<ActionData> set = null;
        advertRichJobItemView.setDate(advertItem.getTime() > 0 ? this.b.format(Long.valueOf(advertItem.getTime()), TimeUnit.SECONDS) : null);
        String location = advertItem.getLocation();
        String distance = advertItem.getDistance();
        List<GeoReference> geoReferences = advertItem.getGeoReferences();
        advertRichJobItemView.setLocation(location, distance, geoReferences != null ? AdvertXlRichJobItemPresenterKt.getMetroLines(geoReferences) : null);
        advertRichJobItemView.setFavorite(advertItem.isFavorite(), false);
        advertRichJobItemView.setActive(advertItem.isActive());
        advertRichJobItemView.setViewed(advertItem.isViewed(), false);
        SerpBadgeBar badgeBar = advertItem.getBadgeBar();
        advertRichJobItemView.bindBadgeBar(badgeBar != null ? badgeBar.getBadges() : null);
        AdvertActions contacts = advertItem.getContacts();
        if (!(contacts == null || (actions = contacts.getActions()) == null)) {
            set = AdvertRichItemPresenterKt.mapActions(actions);
        }
        if (set == null || !(!set.isEmpty())) {
            advertRichJobItemView.clearActions();
        } else {
            advertRichJobItemView.setActions(set);
        }
        AdvertSellerInfo sellerInfo = advertItem.getSellerInfo();
        if (sellerInfo != null) {
            advertRichJobItemView.setSellerInfo(sellerInfo.getName(), sellerInfo.getDate(), AvitoPictureKt.pictureOf$default(sellerInfo.getImage(), true, 0.0f, 0.0f, null, 28, null));
        } else {
            advertRichJobItemView.clearSellerInfo();
        }
        this.c.bindItem(advertItem, advertRichJobItemView);
        advertRichJobItemView.clearListeners();
        advertRichJobItemView.itemClicks(new c(advertItem, advertRichJobItemView, this, advertItem, advertRichJobItemView, i));
        advertRichJobItemView.writeClicks(new a(0, i, advertItem, advertRichJobItemView, this, advertItem, advertRichJobItemView));
        advertRichJobItemView.callClicks(new d(advertItem, advertRichJobItemView, this, advertItem, advertRichJobItemView, i));
        advertRichJobItemView.sellerClicks(new a(1, i, sellerInfo, advertRichJobItemView, this, advertItem, advertRichJobItemView));
        advertRichJobItemView.favoriteClicks(new b(0, i, advertRichJobItemView, this, advertItem, advertRichJobItemView));
        advertRichJobItemView.setUnbindListener(new b(1, i, advertRichJobItemView, this, advertItem, advertRichJobItemView));
    }
}
