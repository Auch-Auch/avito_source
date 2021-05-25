package com.avito.android.serp.adapter.advert_xl;

import a2.g.r.g;
import androidx.collection.ArrayMap;
import com.avito.android.Features;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.AdvertShownClickStreamEvent;
import com.avito.android.analytics.event.ContactSource;
import com.avito.android.async_phone.AsyncPhonePresenter;
import com.avito.android.date_time_formatter.DateTimeFormatter;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.di.module.AdvertXlState;
import com.avito.android.di.module.DateTimeFormatterModule;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ForegroundImage;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.avito.android.remote.model.badge_bar.SerpBadge;
import com.avito.android.remote.model.badge_bar.SerpBadgeBar;
import com.avito.android.serp.adapter.onboarding.SerpOnboardingHandler;
import com.avito.android.serp.adapter.rich_snippets.regular.AdvertRichItemPresenterKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.ListUtils;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001BW\b\u0007\u0012\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c\u0012\b\b\u0001\u00102\u001a\u00020/\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010\u001b\u001a\u00020\u0018\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0001\u00107\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b8\u00109J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\"\u0010.\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006:"}, d2 = {"Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenterImpl;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemPresenter;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemView;", "view", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemView;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItem;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "invalidate", "()V", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "i", "Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;", "onboardingHandler", "Lcom/avito/android/Features;", "h", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "Ldagger/Lazy;", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlItemListener;", "c", "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;", "e", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;", "dimensionsProvider", "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", AuthSource.SEND_ABUSE, "Lcom/avito/android/serp/adapter/advert_xl/AdvertXlPicturesState;", "picturesState", "Landroidx/collection/ArrayMap;", "Lcom/avito/android/remote/model/Image;", "", AuthSource.BOOKING_ORDER, "Landroidx/collection/ArrayMap;", "imageScaleFactor", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "d", "Lcom/avito/android/date_time_formatter/DateTimeFormatter;", "formatter", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "f", "Lcom/avito/android/async_phone/AsyncPhonePresenter;", "asyncPhonePresenter", "advertXlPresenterState", "<init>", "(Ldagger/Lazy;Lcom/avito/android/date_time_formatter/DateTimeFormatter;Lcom/avito/android/serp/adapter/advert_xl/AdvertXlDimensionsProvider;Lcom/avito/android/async_phone/AsyncPhonePresenter;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/Features;Lcom/avito/android/serp/adapter/onboarding/SerpOnboardingHandler;Lcom/avito/android/util/Kundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertXlItemPresenterImpl implements AdvertXlItemPresenter {
    public final AdvertXlPicturesState a;
    public final ArrayMap<Image, Float> b;
    public final Lazy<AdvertXlItemListener> c;
    public final DateTimeFormatter d;
    public final AdvertXlDimensionsProvider e;
    public final AsyncPhonePresenter f;
    public final Analytics g;
    public final Features h;
    public final SerpOnboardingHandler i;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, int i2, Object obj, Object obj2, Object obj3, Object obj4) {
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
                ((AdvertXlItemListener) ((AdvertXlItemPresenterImpl) this.d).c.get()).onFavoriteButtonClicked((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else if (i == 1) {
                AdvertXlItemPresenterImpl.access$clearListeners((AdvertXlItemPresenterImpl) this.d, (AdvertXlItemView) this.c);
                ((AdvertXlItemView) this.c).clearPictures();
                ((AdvertXlItemPresenterImpl) this.d).f.unbindItem((AdvertXlItem) this.e);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertXlItemView b;
        public final /* synthetic */ AdvertXlItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ int e;
        public final /* synthetic */ AdvertXlItemView f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(AdvertXlItem advertXlItem, AdvertXlItemView advertXlItemView, AdvertXlItemPresenterImpl advertXlItemPresenterImpl, AdvertXlItem advertXlItem2, int i, AdvertXlItemView advertXlItemView2) {
            super(0);
            this.a = advertXlItem;
            this.b = advertXlItemView;
            this.c = advertXlItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = i;
            this.f = advertXlItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ((AdvertXlItemListener) this.c.c.get()).onAdvertClicked(this.a, this.e, AdvertXlItemPresenterImpl.access$createImage(this.c, this.f, this.d));
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertXlItemView b;
        public final /* synthetic */ AdvertXlItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItem d;
        public final /* synthetic */ AdvertXlItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(AdvertXlItem advertXlItem, AdvertXlItemView advertXlItemView, AdvertXlItemPresenterImpl advertXlItemPresenterImpl, AdvertXlItem advertXlItem2, int i, AdvertXlItemView advertXlItemView2) {
            super(0);
            this.a = advertXlItem;
            this.b = advertXlItemView;
            this.c = advertXlItemPresenterImpl;
            this.d = advertXlItem2;
            this.e = advertXlItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink trackSnippetCallEvent;
            if (this.d.getPhoneLoadingState() == PhoneLoadingState.IDLE && (trackSnippetCallEvent = AdvertRichItemPresenterKt.trackSnippetCallEvent(this.a, false, this.c.g)) != null) {
                this.c.f.loadPhoneLink(this.d, this.e, trackSnippetCallEvent, ContactSource.CONTACT_XL, new a2.a.a.n2.w.a.a(this));
            }
            return Unit.INSTANCE;
        }
    }

    public static final class d extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ AdvertXlItem a;
        public final /* synthetic */ AdvertXlItemView b;
        public final /* synthetic */ AdvertXlItemPresenterImpl c;
        public final /* synthetic */ AdvertXlItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(AdvertXlItem advertXlItem, AdvertXlItemView advertXlItemView, AdvertXlItemPresenterImpl advertXlItemPresenterImpl, AdvertXlItem advertXlItem2, int i, AdvertXlItemView advertXlItemView2) {
            super(1);
            this.a = advertXlItem;
            this.b = advertXlItemView;
            this.c = advertXlItemPresenterImpl;
            this.d = advertXlItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            this.c.a.saveSelectedPosition(this.a.getStringId(), num.intValue());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public AdvertXlItemPresenterImpl(@NotNull Lazy<AdvertXlItemListener> lazy, @DateTimeFormatterModule.UpperCase @NotNull DateTimeFormatter dateTimeFormatter, @NotNull AdvertXlDimensionsProvider advertXlDimensionsProvider, @NotNull AsyncPhonePresenter asyncPhonePresenter, @NotNull Analytics analytics, @NotNull Features features, @Nullable SerpOnboardingHandler serpOnboardingHandler, @AdvertXlState @Nullable Kundle kundle) {
        AdvertXlPicturesState advertXlPicturesState;
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(dateTimeFormatter, "formatter");
        Intrinsics.checkNotNullParameter(advertXlDimensionsProvider, "dimensionsProvider");
        Intrinsics.checkNotNullParameter(asyncPhonePresenter, "asyncPhonePresenter");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(features, "features");
        this.c = lazy;
        this.d = dateTimeFormatter;
        this.e = advertXlDimensionsProvider;
        this.f = asyncPhonePresenter;
        this.g = analytics;
        this.h = features;
        this.i = serpOnboardingHandler;
        this.a = (kundle == null || (advertXlPicturesState = (AdvertXlPicturesState) kundle.getParcelable("advert_xl_state")) == null) ? new AdvertXlPicturesState(null, 1, null) : advertXlPicturesState;
        this.b = new ArrayMap<>();
    }

    public static final void access$clearListeners(AdvertXlItemPresenterImpl advertXlItemPresenterImpl, AdvertXlItemView advertXlItemView) {
        Objects.requireNonNull(advertXlItemPresenterImpl);
        advertXlItemView.setPictureChangeListener(null);
        advertXlItemView.setOnFavoriteButtonClickListener(null);
        advertXlItemView.setClickListener(null);
        advertXlItemView.setCallActionListener(null);
        advertXlItemView.setUnbindListener(null);
    }

    public static final Image access$createImage(AdvertXlItemPresenterImpl advertXlItemPresenterImpl, AdvertXlItemView advertXlItemView, AdvertXlItem advertXlItem) {
        Objects.requireNonNull(advertXlItemPresenterImpl);
        List<Image> imageList = advertXlItem.getImageList();
        return ImageKt.toSingleImage(advertXlItemView.getPictureUri(AvitoPictureKt.pictureOf$default(imageList != null ? (Image) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) imageList) : null, advertXlItem.getSpanCount() == 2, 0.0f, 0.0f, null, 28, null)));
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider
    public void invalidate() {
        this.a.clear();
        this.b.clear();
    }

    @Override // com.avito.android.serp.adapter.advert_xl.AdvertXlStateProvider
    @NotNull
    public Kundle onSaveState() {
        return new Kundle().putParcelable("advert_xl_state", this.a);
    }

    public void bindView(@NotNull AdvertXlItemView advertXlItemView, @NotNull AdvertXlItem advertXlItem, int i2) {
        Intrinsics.checkNotNullParameter(advertXlItemView, "view");
        Intrinsics.checkNotNullParameter(advertXlItem, "item");
        Map<String, String> analyticParams = advertXlItem.getAnalyticParams();
        boolean z = true;
        if (analyticParams != null && (!analyticParams.isEmpty())) {
            this.g.track(new AdvertShownClickStreamEvent(advertXlItem.getAnalyticParams()));
        }
        advertXlItemView.setupGallerySize(this.e.getGalleryWidth(), this.e.getGalleryHeight());
        List<SerpBadge> list = null;
        advertXlItemView.setPictureChangeListener(null);
        advertXlItemView.setTitle(advertXlItem.getTitle());
        advertXlItemView.setPrice(advertXlItem.getPrice(), advertXlItem.isHighlighted());
        advertXlItemView.setPriceWithoutDiscount(advertXlItem.getPriceWithoutDiscount());
        if (advertXlItem.getImageList() == null || !(!advertXlItem.getImageList().isEmpty())) {
            advertXlItemView.clearPictures();
        } else {
            boolean z2 = advertXlItem.getSpanCount() == 2;
            ArrayList arrayList = new ArrayList();
            ForegroundImage infoImage = advertXlItem.getInfoImage();
            if (infoImage != null) {
                arrayList.add(AvitoPictureKt.pictureOf$default(z2, 0.0f, 0.0f, infoImage, 6, null));
            }
            List<Image> imageList = advertXlItem.getImageList();
            if (imageList != null) {
                Iterator<T> it = imageList.iterator();
                while (it.hasNext()) {
                    arrayList.add(AvitoPictureKt.pictureOf$default(it.next(), z2, 0.0f, 0.0f, null, 28, null));
                }
            }
            advertXlItemView.setPictures(CollectionsKt___CollectionsKt.toList(arrayList));
            advertXlItemView.setCurrentPicture(this.a.getSelectedPosition(advertXlItem.getStringId()), false);
        }
        advertXlItemView.setAddress(advertXlItem.getAddress());
        advertXlItemView.setDescription(advertXlItem.getDescription());
        advertXlItemView.setDeliveryVisible(advertXlItem.getHasDelivery());
        advertXlItemView.setSeller(advertXlItem.getShopName());
        advertXlItemView.setDate(advertXlItem.getTime() > 0 ? this.d.format(Long.valueOf(advertXlItem.getTime()), TimeUnit.SECONDS) : null);
        advertXlItemView.setLocation(advertXlItem.getLocation());
        advertXlItemView.setFavorite(advertXlItem.isFavorite());
        if ((!advertXlItem.isActive()) && (!advertXlItem.isFavorite())) {
            z = false;
        }
        advertXlItemView.setFavoriteVisible(z);
        advertXlItemView.setActive(advertXlItem.isActive());
        advertXlItemView.setViewed(advertXlItem.isViewed());
        if (advertXlItem.isMarketplace()) {
            advertXlItemView.setClassifiedDiscount(null);
            advertXlItemView.setMarketplaceDiscount(advertXlItem.getPreviousPrice(), advertXlItem.getDiscountPercentage());
        } else {
            advertXlItemView.setMarketplaceDiscount(null, null);
            advertXlItemView.setClassifiedDiscount(advertXlItem.getPreviousPrice());
        }
        advertXlItemView.setClickListener(new b(advertXlItem, advertXlItemView, this, advertXlItem, i2, advertXlItemView));
        advertXlItemView.setOnFavoriteButtonClickListener(new a(0, i2, advertXlItemView, this, advertXlItem, advertXlItemView));
        Action callAction = advertXlItem.getCallAction();
        advertXlItemView.setCallActionText(callAction != null ? callAction.getTitle() : null);
        this.f.bindItem(advertXlItem, advertXlItemView);
        advertXlItemView.setCallActionListener(new c(advertXlItem, advertXlItemView, this, advertXlItem, i2, advertXlItemView));
        advertXlItemView.setPictureChangeListener(new d(advertXlItem, advertXlItemView, this, advertXlItem, i2, advertXlItemView));
        advertXlItemView.setAdditionalName(advertXlItem.getAdditionalName());
        advertXlItemView.setVideoIconEnlarged(this.h.getBadgeBarOnSerp().invoke().booleanValue());
        SerpBadgeBar badgeBar = advertXlItem.getBadgeBar();
        List<SerpBadge> badges = badgeBar != null ? badgeBar.getBadges() : null;
        SerpOnboardingHandler serpOnboardingHandler = this.i;
        advertXlItemView.bindBadges(badges, serpOnboardingHandler != null ? serpOnboardingHandler.bindBadgeListenerToBadgeBar(advertXlItem.getBadgeBar()) : null);
        if (advertXlItem.getBadge() != null) {
            SerpBadgeBar badgeBar2 = advertXlItem.getBadgeBar();
            if (badgeBar2 != null) {
                list = badgeBar2.getBadges();
            }
            if (!ListUtils.isNotNullAndNotEmpty(list)) {
                advertXlItemView.setBadge(advertXlItem.getBadge());
                advertXlItemView.setHasVideo(advertXlItem.getHasVideo());
                advertXlItemView.setUnbindListener(new a(1, i2, advertXlItemView, this, advertXlItem, advertXlItemView));
            }
        }
        advertXlItemView.hideBadge();
        advertXlItemView.setHasVideo(advertXlItem.getHasVideo());
        advertXlItemView.setUnbindListener(new a(1, i2, advertXlItemView, this, advertXlItem, advertXlItemView));
    }
}
