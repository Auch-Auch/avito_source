package com.avito.android.publish.new_advert;

import a2.g.r.g;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.publish.drafts.PublishDraftAvailabilityChecker;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.publish.new_advert.NewAdvertPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import dagger.Lazy;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B=\u0012\f\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(\u0012\u0006\u0010'\u001a\u00020$\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b1\u00102J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\bJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\bJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000f\u0010\bR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020)0(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u0010\n\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/publish/new_advert/NewAdvertPresenterImpl;", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter;", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;", "view", "", "attachView", "(Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;)V", "detachView", "()V", "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;)V", "detachRouter", "onRestoreDraftRejected", "onNewAdvertViewAboutToBeExpanded", "Lcom/avito/android/util/BuildInfo;", g.a, "Lcom/avito/android/util/BuildInfo;", "build", "Lio/reactivex/disposables/CompositeDisposable;", "c", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "i", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "idGenerator", "Lcom/avito/android/util/SchedulersFactory;", "f", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "h", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "e", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "Ldagger/Lazy;", "Lcom/avito/android/publish/drafts/PublishDraftAvailabilityChecker;", "d", "Ldagger/Lazy;", "publishDraftAvailabilityChecker", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$View;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/publish/new_advert/NewAdvertPresenter$Router;", "<init>", "(Ldagger/Lazy;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class NewAdvertPresenterImpl implements NewAdvertPresenter {
    public NewAdvertPresenter.View a;
    public NewAdvertPresenter.Router b;
    public final CompositeDisposable c = new CompositeDisposable();
    public final Lazy<PublishDraftAvailabilityChecker> d;
    public final PublishDraftWiper e;
    public final SchedulersFactory f;
    public final BuildInfo g;
    public final PublishAnalyticsDataProvider h;
    public final PublishSessionIdGenerator i;

    public static final class a<T> implements Consumer<PublishDraftResponse> {
        public final /* synthetic */ NewAdvertPresenterImpl a;

        public a(NewAdvertPresenterImpl newAdvertPresenterImpl) {
            this.a = newAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(PublishDraftResponse publishDraftResponse) {
            PublishDraftResponse publishDraftResponse2 = publishDraftResponse;
            if (publishDraftResponse2 instanceof PublishDraftResponse.Ok) {
                PublishDraftResponse.Ok ok = (PublishDraftResponse.Ok) publishDraftResponse2;
                PublishDraftResponse.Ok.Draft draft = ok.getDraft();
                NewAdvertPresenter.Router router = this.a.b;
                if (router != null) {
                    router.showPublishDraftAvailableDialog(draft.getSessionId(), ok.getDialogInfo());
                }
            } else if (publishDraftResponse2 instanceof PublishDraftResponse.NotFound) {
                NewAdvertPresenterImpl.access$launchNewAdvertFlow(this.a);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ NewAdvertPresenterImpl a;

        public b(NewAdvertPresenterImpl newAdvertPresenterImpl) {
            this.a = newAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("PublishDrafts", "Failed to ask draftRepo if it has drafts!", th2);
            if (!this.a.g.isDebug()) {
                NewAdvertPresenterImpl.access$launchNewAdvertFlow(this.a);
            } else {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public static final class c implements Action {
        public static final c a = new c();

        @Override // io.reactivex.functions.Action
        public final void run() {
            Logs.debug$default("PublishDrafts", "Publish draft deleted", null, 4, null);
        }
    }

    public static final class d<T> implements Consumer<Throwable> {
        public final /* synthetic */ NewAdvertPresenterImpl a;

        public d(NewAdvertPresenterImpl newAdvertPresenterImpl) {
            this.a = newAdvertPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("PublishDrafts", "Failed to delete draft", th2);
            if (this.a.g.isDebug()) {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public NewAdvertPresenterImpl(@NotNull Lazy<PublishDraftAvailabilityChecker> lazy, @NotNull PublishDraftWiper publishDraftWiper, @NotNull SchedulersFactory schedulersFactory, @NotNull BuildInfo buildInfo, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator) {
        Intrinsics.checkNotNullParameter(lazy, "publishDraftAvailabilityChecker");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "idGenerator");
        this.d = lazy;
        this.e = publishDraftWiper;
        this.f = schedulersFactory;
        this.g = buildInfo;
        this.h = publishAnalyticsDataProvider;
        this.i = publishSessionIdGenerator;
    }

    public static final void access$launchNewAdvertFlow(NewAdvertPresenterImpl newAdvertPresenterImpl) {
        newAdvertPresenterImpl.h.setSessionId(newAdvertPresenterImpl.i.reCreatePublishSessionId());
        NewAdvertPresenter.View view = newAdvertPresenterImpl.a;
        if (view != null) {
            view.continueExpandAddAdvert();
        }
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void attachRouter(@NotNull NewAdvertPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.b = router;
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void attachView(@NotNull NewAdvertPresenter.View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.a = view;
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void detachRouter() {
        this.b = null;
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void detachView() {
        this.c.clear();
        this.a = null;
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void onNewAdvertViewAboutToBeExpanded() {
        CompositeDisposable compositeDisposable = this.c;
        Disposable subscribe = this.d.get().getOrDeleteIfNeeded().toObservable().subscribeOn(this.f.io()).observeOn(this.f.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishDraftAvailability…          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish.new_advert.NewAdvertPresenter
    public void onRestoreDraftRejected() {
        this.h.setSessionId(this.i.reCreatePublishSessionId());
        NewAdvertPresenter.View view = this.a;
        if (view != null) {
            view.continueExpandAddAdvert();
        }
        this.e.deleteDraftWithPhotos().subscribeOn(this.f.io()).subscribe(c.a, new d(this));
    }
}
