package com.avito.android.publish.infomodel_request;

import a2.a.a.e2.v.d;
import a2.a.a.e2.v.e;
import a2.a.a.e2.v.f;
import a2.a.a.e2.v.h;
import a2.a.a.e2.v.i;
import a2.g.r.g;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.avito.android.analytics.publish.FromPage;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.analytics.screens.tracker.UnknownScreenTracker;
import com.avito.android.publish.PublishParametersInteractor;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.PublishViewModel;
import com.avito.android.publish.drafts.analytics.PublishDraftEventTracker;
import com.avito.android.publish.drafts.analytics.PublishSessionIdGenerator;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Draft;
import com.avito.android.remote.model.ItemBrief;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.Logs;
import com.avito.android.util.MultiStateLoading;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u00103\u001a\u000200\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010&\u001a\u00020#\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010/\u001a\u00020,¢\u0006\u0004\b;\u0010<J\u0017\u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\r\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0010\u001a\u00020\u000b¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\u000bH\u0014¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0012\u0010\u000fR\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\n\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010\"\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010 R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u0007\u001a\u00020\u00068\u0002@\u0002X.¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010+\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R \u0010\u0004\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0003048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109¨\u0006="}, d2 = {"Lcom/avito/android/publish/infomodel_request/InfomodelRequestViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroidx/lifecycle/LiveData;", "Lcom/avito/android/util/MultiStateLoading;", "screenState", "()Landroidx/lifecycle/LiveData;", "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "", "initialRequest", "trackDraftResumed", "", "initScreen", "(Lcom/avito/android/publish/PublishViewModel;ZZ)V", "onRetryClicked", "()V", "onBackPressed", "onCleared", "c", "Lcom/avito/android/publish/PublishParametersInteractor;", "h", "Lcom/avito/android/publish/PublishParametersInteractor;", "publishParametersInteractor", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "k", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;", "draftEventTracker", "f", "Z", "e", "isInitialRequest", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "l", "Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;", "idGenerator", "d", "Lcom/avito/android/publish/PublishViewModel;", "Lio/reactivex/disposables/CompositeDisposable;", "Lio/reactivex/disposables/CompositeDisposable;", "subscriptions", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "n", "Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;", "performanceTracker", "Lcom/avito/android/util/SchedulersFactory;", "j", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Landroidx/lifecycle/MutableLiveData;", g.a, "Landroidx/lifecycle/MutableLiveData;", "Lcom/google/gson/Gson;", "i", "Lcom/google/gson/Gson;", "gson", "<init>", "(Lcom/avito/android/publish/PublishParametersInteractor;Lcom/google/gson/Gson;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/analytics/PublishSessionIdGenerator;Lcom/avito/android/publish/drafts/analytics/PublishDraftEventTracker;Lcom/avito/android/analytics/screens/tracker/UnknownScreenTracker;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class InfomodelRequestViewModel extends ViewModel {
    public final CompositeDisposable c = new CompositeDisposable();
    public PublishViewModel d;
    public boolean e = true;
    public boolean f;
    public final MutableLiveData<MultiStateLoading<?>> g = new MutableLiveData<>();
    public final PublishParametersInteractor h;
    public final Gson i;
    public final SchedulersFactory j;
    public final PublishAnalyticsDataProvider k;
    public PublishSessionIdGenerator l;
    public final PublishDraftEventTracker m;
    public final UnknownScreenTracker n;

    public static final class a<T> implements Consumer<MultiStateLoading<? super a2.a.a.e2.v.a>> {
        public final /* synthetic */ InfomodelRequestViewModel a;

        public a(InfomodelRequestViewModel infomodelRequestViewModel) {
            this.a = infomodelRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: androidx.lifecycle.MutableLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(MultiStateLoading<? super a2.a.a.e2.v.a> multiStateLoading) {
            MultiStateLoading<? super a2.a.a.e2.v.a> multiStateLoading2 = multiStateLoading;
            this.a.g.setValue(multiStateLoading2);
            if (multiStateLoading2 instanceof MultiStateLoading.Loaded) {
                InfomodelRequestViewModel.access$onDataLoaded(this.a, (a2.a.a.e2.v.a) ((MultiStateLoading.Loaded) multiStateLoading2).getData());
            } else if (multiStateLoading2 instanceof MultiStateLoading.InitError) {
                StringBuilder L = a2.b.a.a.a.L("loadInfomodelData failed: ");
                L.append(((MultiStateLoading.InitError) multiStateLoading2).getError());
                Logs.error$default("InfoModel", L.toString(), null, 4, null);
            }
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ InfomodelRequestViewModel a;

        public b(InfomodelRequestViewModel infomodelRequestViewModel) {
            this.a = infomodelRequestViewModel;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            InfomodelRequestViewModel.access$getPublishViewModel$p(this.a).onUnexpectedErrorOccurred(new Exception("Failed to load infomodel data", th));
        }
    }

    public InfomodelRequestViewModel(@NotNull PublishParametersInteractor publishParametersInteractor, @NotNull Gson gson, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishSessionIdGenerator publishSessionIdGenerator, @NotNull PublishDraftEventTracker publishDraftEventTracker, @NotNull UnknownScreenTracker unknownScreenTracker) {
        Intrinsics.checkNotNullParameter(publishParametersInteractor, "publishParametersInteractor");
        Intrinsics.checkNotNullParameter(gson, "gson");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishSessionIdGenerator, "idGenerator");
        Intrinsics.checkNotNullParameter(publishDraftEventTracker, "draftEventTracker");
        Intrinsics.checkNotNullParameter(unknownScreenTracker, "performanceTracker");
        this.h = publishParametersInteractor;
        this.i = gson;
        this.j = schedulersFactory;
        this.k = publishAnalyticsDataProvider;
        this.l = publishSessionIdGenerator;
        this.m = publishDraftEventTracker;
        this.n = unknownScreenTracker;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(InfomodelRequestViewModel infomodelRequestViewModel) {
        PublishViewModel publishViewModel = infomodelRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final void access$onDataLoaded(InfomodelRequestViewModel infomodelRequestViewModel, a2.a.a.e2.v.a aVar) {
        PublishState publishState;
        infomodelRequestViewModel.n.trackLoading();
        Draft draft = aVar.a.getDraft();
        Navigation navigation = aVar.a.getNavigation();
        if (draft != null) {
            infomodelRequestViewModel.k.setSessionId(draft.getPublishSessionId());
            if (infomodelRequestViewModel.f) {
                infomodelRequestViewModel.m.trackDraftAccepted(navigation, draft.getDraftId());
            }
        }
        PublishViewModel publishViewModel = infomodelRequestViewModel.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        if (!publishViewModel.getShouldRestoreDraft() || (publishState = aVar.b) == null) {
            publishViewModel.setCategoryParametersAndInitSteps(aVar.a);
            publishViewModel.goToNextStep(infomodelRequestViewModel.n.toScreenTransfer());
        } else {
            publishViewModel.restoreState(aVar.a, publishState);
        }
        publishViewModel.setCategoryChanged(false);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00d5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final a2.a.a.e2.v.a access$toParametersWithState(com.avito.android.publish.infomodel_request.InfomodelRequestViewModel r28, com.avito.android.publish.PublishParametersInteractor.Data r29) {
        /*
        // Method dump skipped, instructions count: 619
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.infomodel_request.InfomodelRequestViewModel.access$toParametersWithState(com.avito.android.publish.infomodel_request.InfomodelRequestViewModel, com.avito.android.publish.PublishParametersInteractor$Data):a2.a.a.e2.v.a");
    }

    public final void c() {
        Single single;
        Single<R> single2;
        Single<PublishParametersInteractor.Data> single3;
        this.n.startLoading();
        CompositeDisposable compositeDisposable = this.c;
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        ItemBrief item = publishViewModel.getItem();
        String id = item != null ? item.getId() : null;
        if (id == null) {
            PublishViewModel publishViewModel2 = this.d;
            if (publishViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            this.k.setFromPage(FromPage.ITEM_ADD);
            this.k.setItemId(null);
            if (this.e) {
                single3 = this.h.loadParametersAndStepsWithDraft(publishViewModel2.getNavigation(), publishViewModel2.getDraftId());
            } else {
                single3 = this.h.loadExtraSteps(publishViewModel2.getNavigation(), publishViewModel2.getCategoryParameters(), publishViewModel2.isCategoryChanged());
            }
            single = a2.b.a.a.a.V1(this.j, single3, "with(publishViewModel) {…scribeOn(schedulers.io())");
        } else {
            PublishViewModel publishViewModel3 = this.d;
            if (publishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            if (publishViewModel3.getNavigation().isEmpty()) {
                this.k.setSessionId(this.l.reCreatePublishSessionId());
                this.k.setFromPage(FromPage.ITEM_EDIT);
                this.k.setItemId(id);
                single2 = this.h.loadItem(id).subscribeOn(this.j.io()).observeOn(this.j.mainThread()).doOnSuccess(new h(this)).map(i.a);
            } else {
                PublishViewModel publishViewModel4 = this.d;
                if (publishViewModel4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                single2 = Single.just(publishViewModel4.getNavigation());
            }
            Intrinsics.checkNotNullExpressionValue(single2, "if (publishViewModel.nav…lishViewModel.navigation)");
            single = single2.observeOn(this.j.io()).flatMap(new a2.a.a.e2.v.g(this, id));
            Intrinsics.checkNotNullExpressionValue(single, "navigationRequest.observ…d\n            )\n        }");
        }
        Observable map = single.toObservable().map(new d(this)).map(e.a);
        Intrinsics.checkNotNullExpressionValue(map, "when (val itemId = publi…      .map { Loaded(it) }");
        Observable cast = map.cast(MultiStateLoading.class);
        Intrinsics.checkExpressionValueIsNotNull(cast, "cast(R::class.java)");
        Observable startWith = cast.onErrorReturn(f.a).startWith((Observable) MultiStateLoading.InitLoading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(startWith, "when (val itemId = publi…  .startWith(InitLoading)");
        Disposable subscribe = startWith.observeOn(this.j.mainThread()).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "infomodelDataRequest()\n …          }\n            )");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final void initScreen(@NotNull PublishViewModel publishViewModel, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(publishViewModel, "publishViewModel");
        this.d = publishViewModel;
        this.e = z;
        this.f = z2;
        if (this.g.getValue() == null) {
            c();
        }
    }

    public final void onBackPressed() {
        PublishViewModel publishViewModel = this.d;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.goToPreviousStep();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        this.c.clear();
        super.onCleared();
    }

    public final void onRetryClicked() {
        c();
    }

    @NotNull
    public final LiveData<MultiStateLoading<?>> screenState() {
        return this.g;
    }
}
