package com.avito.android.serp.adapter.rich_snippets.job;

import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.AdvertShownClickStreamEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.di.module.RichGalleryState;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.AdvertAction;
import com.avito.android.remote.model.AdvertActions;
import com.avito.android.remote.model.AdvertSellerInfo;
import com.avito.android.remote.model.GeoReference;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.advert_xl.AdvertXlItem;
import com.avito.android.serp.adapter.rich_snippets.AdvertGalleryState;
import com.avito.android.serp.adapter.rich_snippets.AdvertRichItemListener;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.avito.android.util.Collections;
import com.avito.android.util.Kundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.serp.PhoneLoadingState;
import ru.avito.component.serp.cyclic_gallery.image_carousel.ActionData;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BB\b\u0007\u0012\u0011\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u0014\u0012\b\b\u0001\u0010!\u001a\u00020\u001e\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010%\u001a\u00020\"\u0012\n\b\u0001\u0010&\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b'\u0010(J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R!\u0010\u0019\u001a\r\u0012\t\u0012\u00070\u0015¢\u0006\u0002\b\u00160\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$¨\u0006)"}, d2 = {"Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenterImpl;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertXlRichJobItemPresenter;", "Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;", "view", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/rich_snippets/job/AdvertRichJobItemView;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidate", "()V", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/rich_snippets/AdvertGalleryState;", "advertGalleryState", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/rich_snippets/AdvertRichItemListener;", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.BOOKING_ORDER, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "d", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "c", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "Lcom/avito/android/analytics/Analytics;", "e", "Lcom/avito/android/analytics/Analytics;", "analytics", "galleryPresenterState", "<init>", "(Ldagger/Lazy;Lcom/avito/android/date_time_formatter/DateTimeFormatter;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/util/Kundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlRichJobItemPresenterImpl implements AdvertXlRichJobItemPresenter {
    public final AdvertGalleryState a;
    public final Lazy<AdvertRichItemListener> b;
    public final DateTimeFormatter c;
    public final AsyncPhonePresenter d;
    public final Analytics e;

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
                AdvertActions contacts = ((AdvertXlItem) this.c).getContacts();
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
                    ((AdvertRichItemListener) ((AdvertXlRichJobItemPresenterImpl) this.e).b.get()).onWriteActionClicked(((AdvertXlItem) this.c).getStringId(), deepLink, ContactSource.CONTACT_REGULAR);
                }
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertSellerInfo advertSellerInfo = (AdvertSellerInfo) this.c;
                if (!(advertSellerInfo == null || (link = advertSellerInfo.getLink()) == null)) {
                    ((AdvertRichItemListener) ((AdvertXlRichJobItemPresenterImpl) this.e).b.get()).onDeepLinkActionClicked(link);
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
                ((AdvertRichItemListener) ((AdvertXlRichJobItemPresenterImpl) this.d).b.get()).onFavoriteButtonClicked((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertRichJobItemPresenterKt.clearCallbacks((AdvertRichJobItemView) this.c);
                ((AdvertRichJobItemView) this.c).clearPictures();
                ((AdvertRichJobItemView) this.c).clearActions();
                ((AdvertXlRichJobItemPresenterImpl) this.d).d.unbindItem((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertRichJobItemView b;
        public final /* synthetic */ AdvertXlRichJobItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ AdvertRichJobItemView e;
        public final /* synthetic */ int f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertXlItem advertXlItem, AdvertRichJobItemView advertRichJobItemView, AdvertXlRichJobItemPresenterImpl advertXlRichJobItemPresenterImpl, AdvertXlItem advertXlItem2, AdvertRichJobItemView advertRichJobItemView2, int i) {
            super(1);
            this.a = advertXlItem;
            this.b = advertRichJobItemView;
            this.c = advertXlRichJobItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = advertRichJobItemView2;
            this.f = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            Integer num2 = num;
            ((AdvertRichItemListener) this.c.b.get()).onRichAdvertXlClicked(this.a, this.f, AdvertXlRichJobItemPresenterImpl.access$createImage(this.c, this.e, this.d, num2), num2);
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertRichJobItemView b;
        public final /* synthetic */ AdvertXlRichJobItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ AdvertRichJobItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AdvertXlItem advertXlItem, AdvertRichJobItemView advertRichJobItemView, AdvertXlRichJobItemPresenterImpl advertXlRichJobItemPresenterImpl, AdvertXlItem advertXlItem2, AdvertRichJobItemView advertRichJobItemView2, int i) {
            super(0);
            this.a = advertXlItem;
            this.b = advertRichJobItemView;
            this.c = advertXlRichJobItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = advertRichJobItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink trackSnippetCallEvent;
            if (this.d.getPhoneLoadingState() == PhoneLoadingState.IDLE && (trackSnippetCallEvent = AdvertRichItemPresenterKt.trackSnippetCallEvent(this.a, false, this.c.e)) != null) {
                this.c.d.loadPhoneLink(this.d, this.e, trackSnippetCallEvent, ContactSource.CONTACT_XL, new a2.a.a.n2.w.c.a.b(this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class e extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertRichJobItemView a;
        public final /* synthetic */ AdvertXlRichJobItemPresenterImpl b;
        public final /* synthetic */ AdvertXlItem c;
        public final /* synthetic */ AdvertRichJobItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(AdvertRichJobItemView advertRichJobItemView, AdvertXlRichJobItemPresenterImpl advertXlRichJobItemPresenterImpl, AdvertXlItem advertXlItem, AdvertRichJobItemView advertRichJobItemView2, int i) {
            super(1);
            this.a = advertRichJobItemView;
            this.b = advertXlRichJobItemPresenterImpl;
            this.c = advertXlItem;
            this.d = advertRichJobItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            num.intValue();
            AdvertRichItemPresenterKt.putAdvertState(this.b.a, this.c.getStringId(), this.a.getGalleryState());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertXlRichJobItemPresenterImpl(@NotNull Lazy<AdvertRichItemListener> lazy, @DateTimeFormatterModule.UpperCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull Analytics analytics, @RichGalleryState @Nullable Kundle kundle) {
        AdvertGalleryState advertGalleryState;
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "formatter");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = lazy;
        this.c = dateTimeFormatter;
        this.d = asyncPhonePresenter;
        this.e = analytics;
        this.a = (kundle == null || (advertGalleryState = (AdvertGalleryState) kundle.getParcelable("advert_xl_gallery_state")) == null) ? new AdvertGalleryState(null, 1, null) : advertGalleryState;
    }

    public static final Image access$createImage(AdvertXlRichJobItemPresenterImpl advertXlRichJobItemPresenterImpl, AdvertRichJobItemView advertRichJobItemView, AdvertXlItem advertXlItem, Integer num) {
        Objects.requireNonNull(advertXlRichJobItemPresenterImpl);
        int intValue = num != null ? num.intValue() : 0;
        if (advertXlItem.getImageList() == null || advertXlItem.getImageList().isEmpty()) {
            return null;
        }
        return ImageKt.toSingleImage(advertRichJobItemView.getPictureUri(AvitoPictureKt.pictureOf$default(advertXlItem.getImageList().get(intValue), true, 0.0f, 0.0f, null, 28, null)));
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    public void invalidate() {
        this.a.clear();
    }

    @Override // com.avito.android.serp.adapter.rich_snippets.RichSnippetStateProvider
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("advert_xl_gallery_state", this.a);
    }

    public void bindView(@NotNull AdvertRichJobItemView advertRichJobItemView, @NotNull AdvertXlItem advertXlItem, int i) {
        List<AdvertAction> actions;
        Intrinsics.checkNotNullParameter(advertRichJobItemView, "view");
        Intrinsics.checkNotNullParameter(advertXlItem, "item");
        Map<String, String> analyticParams = advertXlItem.getAnalyticParams();
        if (analyticParams != null) {
            this.e.track(new AdvertShownClickStreamEvent(analyticParams));
        }
        advertRichJobItemView.setTitle(advertXlItem.getTitle());
        advertRichJobItemView.setPrice(advertXlItem.getPrice(), advertXlItem.isHighlighted());
        advertRichJobItemView.setDescription(advertXlItem.getDescription());
        advertRichJobItemView.setAddress(advertXlItem.getAddress());
        Set<ActionData> set = null;
        advertRichJobItemView.setDate(advertXlItem.getTime() > 0 ? this.c.format(Long.valueOf(advertXlItem.getTime()), TimeUnit.SECONDS) : null);
        String location = advertXlItem.getLocation();
        String distance = advertXlItem.getDistance();
        List<GeoReference> geoReferences = advertXlItem.getGeoReferences();
        advertRichJobItemView.setLocation(location, distance, geoReferences != null ? AdvertXlRichJobItemPresenterKt.getMetroLines(geoReferences) : null);
        boolean z = !Collections.isNullOrEmpty(advertXlItem.getImageList());
        if (advertXlItem.getImageList() == null || !z) {
            advertRichJobItemView.clearPictures();
        } else {
            List<Image> imageList = advertXlItem.getImageList();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = imageList.iterator();
            while (it.hasNext()) {
                arrayList.add(AvitoPictureKt.pictureOf$default(it.next(), false, 0.0f, 0.0f, null, 28, null));
            }
            advertRichJobItemView.setPictures(CollectionsKt___CollectionsKt.toList(arrayList));
            advertRichJobItemView.restoreGalleryState(this.a.getState(advertXlItem.getStringId()));
        }
        advertRichJobItemView.setFavorite(advertXlItem.isFavorite(), z);
        advertRichJobItemView.setActive(advertXlItem.isActive());
        advertRichJobItemView.setViewed(advertXlItem.isViewed(), z);
        SerpBadgeBar badgeBar = advertXlItem.getBadgeBar();
        advertRichJobItemView.bindBadgeBar(badgeBar != null ? badgeBar.getBadges() : null);
        AdvertActions contacts = advertXlItem.getContacts();
        if (!(contacts == null || (actions = contacts.getActions()) == null)) {
            set = AdvertRichItemPresenterKt.mapActions(actions);
        }
        if (set == null || !(!set.isEmpty())) {
            advertRichJobItemView.clearActions();
        } else {
            advertRichJobItemView.setActions(set);
        }
        AdvertSellerInfo sellerInfo = advertXlItem.getSellerInfo();
        if (sellerInfo != null) {
            advertRichJobItemView.setSellerInfo(sellerInfo.getName(), sellerInfo.getDate(), AvitoPictureKt.pictureOf$default(sellerInfo.getImage(), true, 0.0f, 0.0f, null, 28, null));
        } else {
            advertRichJobItemView.clearSellerInfo();
        }
        this.d.bindItem(advertXlItem, advertRichJobItemView);
        advertRichJobItemView.clearListeners();
        advertRichJobItemView.itemClicks(new c(advertXlItem, advertRichJobItemView, this, advertXlItem, advertRichJobItemView, i));
        advertRichJobItemView.writeClicks(new a(0, i, advertXlItem, advertRichJobItemView, this, advertXlItem, advertRichJobItemView));
        advertRichJobItemView.callClicks(new d(advertXlItem, advertRichJobItemView, this, advertXlItem, advertRichJobItemView, i));
        advertRichJobItemView.sellerClicks(new a(1, i, sellerInfo, advertRichJobItemView, this, advertXlItem, advertRichJobItemView));
        advertRichJobItemView.favoriteClicks(new b(0, i, advertRichJobItemView, this, advertXlItem, advertRichJobItemView));
        advertRichJobItemView.pictureChanges(new e(advertRichJobItemView, this, advertXlItem, advertRichJobItemView, i));
        advertRichJobItemView.setUnbindListener(new b(1, i, advertRichJobItemView, this, advertXlItem, advertRichJobItemView));
    }
}
