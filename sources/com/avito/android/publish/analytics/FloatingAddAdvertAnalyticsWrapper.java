package com.avito.android.publish.analytics;

import a2.g.r.g;
import android.view.View;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.event.UnauthPublishAttemptEvent;
import com.avito.android.analytics.publish.FromPage;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.analytics.events.AddItemEvent;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Single;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.floating_add_advert.AccountLoginStateProvider;
import ru.avito.component.floating_add_advert.AddAdvertInteractor;
import ru.avito.component.floating_add_advert.AdvertShortcut;
import ru.avito.component.floating_add_advert.FloatingAddAdvert;
import ru.avito.component.floating_add_advert.FloatingAddAdvertImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010$\u001a\u00020!\u0012\u0006\u0010(\u001a\u00020%\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010,\u001a\u00020)\u0012\u0006\u00100\u001a\u00020-¢\u0006\u0004\b1\u00102J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\u000e\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\tJ\u000f\u0010\u0011\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\tR\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R$\u0010 \u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/publish/analytics/FloatingAddAdvertAnalyticsWrapper;", "Lru/avito/component/floating_add_advert/FloatingAddAdvert$EventListener;", "Landroid/view/View;", "view", "Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "wrapView", "(Landroid/view/View;)Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "", "onAttach", "()V", "onDetach", "onNewAdvertIntent", "Lru/avito/component/floating_add_advert/AdvertShortcut;", "advertShortcut", "onPublishVerticalChosen", "(Lru/avito/component/floating_add_advert/AdvertShortcut;)V", "onButtonsShowed", "onUserAuntificationRequested", "Lcom/avito/android/account/AccountStateProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", AuthSource.SEND_ABUSE, "Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "getCurrentView", "()Lru/avito/component/floating_add_advert/FloatingAddAdvert;", "setCurrentView", "(Lru/avito/component/floating_add_advert/FloatingAddAdvert;)V", "currentView", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "c", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "d", "Lru/avito/component/floating_add_advert/AddAdvertInteractor;", "interactor", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "f", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lcom/avito/android/analytics/Analytics;", g.a, "Lcom/avito/android/analytics/Analytics;", "analytics", "<init>", "(Lcom/avito/android/account/AccountStateProvider;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lru/avito/component/floating_add_advert/AddAdvertInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/analytics/Analytics;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class FloatingAddAdvertAnalyticsWrapper implements FloatingAddAdvert.EventListener {
    @Nullable
    public FloatingAddAdvert a;
    public final AccountStateProvider b;
    public final PublishAnalyticsDataProvider c;
    public final AddAdvertInteractor d;
    public final SchedulersFactory3 e;
    public final PublishEventTracker f;
    public final Analytics g;

    public FloatingAddAdvertAnalyticsWrapper(@NotNull AccountStateProvider accountStateProvider, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull AddAdvertInteractor addAdvertInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull PublishEventTracker publishEventTracker, @NotNull Analytics analytics) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "accountState");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(addAdvertInteractor, "interactor");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        this.b = accountStateProvider;
        this.c = publishAnalyticsDataProvider;
        this.d = addAdvertInteractor;
        this.e = schedulersFactory3;
        this.f = publishEventTracker;
        this.g = analytics;
    }

    @Nullable
    public final FloatingAddAdvert getCurrentView() {
        return this.a;
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onAttach() {
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert.EventListener
    public void onButtonsShowed() {
        this.g.track(new AddItemEvent.PublishButtonClick());
    }

    @Override // com.avito.android.design.widget.lifecycle_view.AttachListener
    public void onDetach() {
        FloatingAddAdvert floatingAddAdvert = this.a;
        if (floatingAddAdvert != null) {
            floatingAddAdvert.setListener(null);
        }
        this.a = null;
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert.EventListener
    public void onNewAdvertIntent() {
        this.c.setFromPage(FromPage.ITEM_ADD);
        this.c.setItemId(null);
        this.c.setTrackedCategory(null);
        this.f.trackNewAdvertShown();
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert.EventListener
    public void onPublishVerticalChosen(@NotNull AdvertShortcut advertShortcut) {
        Intrinsics.checkNotNullParameter(advertShortcut, "advertShortcut");
        this.f.trackPublishVerticalChosen(advertShortcut.getNavigation());
        this.g.track(new AddItemEvent.CategoryButtonClick());
    }

    @Override // ru.avito.component.floating_add_advert.FloatingAddAdvert.EventListener
    public void onUserAuntificationRequested() {
        this.g.track(new UnauthPublishAttemptEvent());
    }

    public final void setCurrentView(@Nullable FloatingAddAdvert floatingAddAdvert) {
        this.a = floatingAddAdvert;
    }

    @NotNull
    public final FloatingAddAdvert wrapView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        FloatingAddAdvertImpl floatingAddAdvertImpl = new FloatingAddAdvertImpl(view, new AccountLoginStateProvider(this) { // from class: com.avito.android.publish.analytics.FloatingAddAdvertAnalyticsWrapper$wrapView$1
            public final /* synthetic */ FloatingAddAdvertAnalyticsWrapper a;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.a = r1;
            }

            @Override // ru.avito.component.floating_add_advert.AccountLoginStateProvider
            @NotNull
            public Single<Boolean> isAuthorized() {
                return FloatingAddAdvertAnalyticsWrapper.access$getAccountState$p(this.a).currentAuthorized();
            }
        }, this.d, this.e);
        this.a = floatingAddAdvertImpl;
        if (floatingAddAdvertImpl != null) {
            floatingAddAdvertImpl.setListener(this);
        }
        return floatingAddAdvertImpl;
    }
}
