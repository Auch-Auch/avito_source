package com.avito.android.publish;

import android.annotation.SuppressLint;
import com.avito.android.analytics.publish.PublishAnalyticsDataProvider;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.publish.PublishState;
import com.avito.android.publish.SubmissionPresenter;
import com.avito.android.publish.analytics.PublishEventTracker;
import com.avito.android.publish.drafts.IdValuePair;
import com.avito.android.publish.drafts.LocalPublishState;
import com.avito.android.publish.drafts.PublishDraftDataHolder;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.PublishDraftWiper;
import com.avito.android.publish.drafts.PublishInfoMessage;
import com.avito.android.publish.drafts.PublishMessageHandler;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.DeepLinksDialogInfo;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryPublishStep;
import com.avito.android.remote.model.category_parameters.CharParameter;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory;
import com.google.gson.Gson;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.rxkotlin.DisposableKt;
import io.reactivex.rxkotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.q;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001BO\u0012\u0006\u00106\u001a\u000203\u0012\u0006\u0010B\u001a\u00020?\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010J\u001a\u00020G\u0012\u0006\u0010N\u001a\u00020K\u0012\u0006\u0010>\u001a\u00020;\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010:\u001a\u000207¢\u0006\u0004\bO\u0010PJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0017¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0012\u0010\fJ\u001f\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J)\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00172\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010,\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010>\u001a\u00020;8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b<\u0010=R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010ER\u0016\u0010J\u001a\u00020G8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010M¨\u0006Q"}, d2 = {"Lcom/avito/android/publish/SubmissionPresenterImpl;", "Lcom/avito/android/publish/SubmissionPresenter;", "Lcom/avito/android/publish/PublishViewModel;", "viewModel", "", "setPublishViewModel", "(Lcom/avito/android/publish/PublishViewModel;)V", "", "showInfoMessages", "saveDraftIfNeeded", "(Z)Z", "detachRouter", "()V", "Lcom/avito/android/publish/SubmissionPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/publish/SubmissionPresenter$Router;)V", "onViewCreated", "onViewDestroyed", "isFinishing", "shouldSaveOnClose", "detachView", "(ZZ)V", "", "requestCode", "resultCode", "", BookingInfoActivity.EXTRA_ITEM_ID, "onResult", "(IILjava/lang/String;)Z", "Lcom/avito/android/publish/PublishedAdvertData;", "publishedAdvertData", "onAdvertPublished", "(Lcom/avito/android/publish/PublishedAdvertData;)V", "Lcom/google/gson/Gson;", "j", "Lcom/google/gson/Gson;", "publishSessionStateSerializer", "Lcom/avito/android/util/BuildInfo;", "k", "Lcom/avito/android/util/BuildInfo;", "buildInfo", AuthSource.SEND_ABUSE, "Lcom/avito/android/publish/PublishViewModel;", "publishViewModel", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "f", "Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;", "analyticsDataProvider", "c", "Lcom/avito/android/publish/SubmissionPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory;", "d", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/publish/drafts/PublishMessageHandler;", "l", "Lcom/avito/android/publish/drafts/PublishMessageHandler;", "publishMessageHandler", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "i", "Lcom/avito/android/publish/drafts/PublishDraftDataHolder;", "publishDraftDataHolder", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "e", "Lcom/avito/android/publish/analytics/PublishEventTracker;", "eventTracker", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.BOOKING_ORDER, "Lio/reactivex/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", a2.g.r.g.a, "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "publishDraftRepository", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "h", "Lcom/avito/android/publish/drafts/PublishDraftWiper;", "publishDraftWiper", "<init>", "(Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/publish/analytics/PublishEventTracker;Lcom/avito/android/analytics/publish/PublishAnalyticsDataProvider;Lcom/avito/android/publish/drafts/PublishDraftRepository;Lcom/avito/android/publish/drafts/PublishDraftWiper;Lcom/avito/android/publish/drafts/PublishDraftDataHolder;Lcom/google/gson/Gson;Lcom/avito/android/util/BuildInfo;Lcom/avito/android/publish/drafts/PublishMessageHandler;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class SubmissionPresenterImpl implements SubmissionPresenter {
    public PublishViewModel a;
    public final CompositeDisposable b = new CompositeDisposable();
    public SubmissionPresenter.Router c;
    public final SchedulersFactory d;
    public final PublishEventTracker e;
    public final PublishAnalyticsDataProvider f;
    public final PublishDraftRepository g;
    public final PublishDraftWiper h;
    public final PublishDraftDataHolder i;
    public final Gson j;
    public final BuildInfo k;
    public final PublishMessageHandler l;

    public static final class a implements Action {
        public static final a a = new a();

        @Override // io.reactivex.functions.Action
        public final void run() {
            Logs.debug$default("PublishDrafts", "Publish draft was deleted", null, 4, null);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ SubmissionPresenterImpl a;

        public b(SubmissionPresenterImpl submissionPresenterImpl) {
            this.a = submissionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            Logs.error("Failed to delete publish draft!", th2);
            if (this.a.k.isDebug()) {
                Intrinsics.checkNotNullExpressionValue(th2, "it");
                throw th2;
            }
        }
    }

    public static final class c<T, R> implements Function<Integer, Unit> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(Integer num) {
            Intrinsics.checkNotNullParameter(num, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class d<T, R> implements Function<EditableParameter<?>, Unit> {
        public static final d a = new d();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Unit apply(EditableParameter<?> editableParameter) {
            Intrinsics.checkNotNullParameter(editableParameter, "it");
            return Unit.INSTANCE;
        }
    }

    public static final class e<T> implements Consumer<Unit> {
        public final /* synthetic */ SubmissionPresenterImpl a;

        public e(SubmissionPresenterImpl submissionPresenterImpl) {
            this.a = submissionPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Unit unit) {
            SubmissionPresenter.DefaultImpls.saveDraftIfNeeded$default(this.a, false, 1, null);
        }
    }

    public static final class f<T> implements Consumer<Throwable> {
        public static final f a = new f();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Consumer
        public void accept(Throwable th) {
            Logs.error("Failed to listen to parameter changes", th);
        }
    }

    public static final class g<V> implements Callable<String> {
        public final /* synthetic */ SubmissionPresenterImpl a;
        public final /* synthetic */ PublishState b;

        public g(SubmissionPresenterImpl submissionPresenterImpl, PublishState publishState) {
            this.a = submissionPresenterImpl;
            this.b = publishState;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public String call() {
            return this.a.j.toJson(this.b);
        }
    }

    public static final class h<T, R> implements Function<String, MaybeSource<? extends PublishInfoMessage>> {
        public final /* synthetic */ SubmissionPresenterImpl a;
        public final /* synthetic */ CategoryParameters b;
        public final /* synthetic */ PublishState c;
        public final /* synthetic */ boolean d;

        public h(SubmissionPresenterImpl submissionPresenterImpl, CategoryParameters categoryParameters, PublishState publishState, boolean z) {
            this.a = submissionPresenterImpl;
            this.b = categoryParameters;
            this.c = publishState;
            this.d = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MaybeSource<? extends PublishInfoMessage> apply(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "serializedState");
            PublishDraftRepository publishDraftRepository = this.a.g;
            String sessionId = this.a.f.getSessionId();
            String draftId = this.a.i.getDraftId();
            CategoryParameters categoryParameters = this.b;
            boolean shouldSaveDraft = categoryParameters.getShouldSaveDraft();
            Navigation publishProcessNavigation = this.c.getPublishProcessNavigation();
            String activeFieldId = this.c.getActiveFieldId();
            SubmissionPresenterImpl submissionPresenterImpl = this.a;
            PublishState publishState = this.c;
            List<CategoryPublishStep> steps = this.b.getSteps();
            if (steps == null) {
                steps = CollectionsKt__CollectionsKt.emptyList();
            }
            return PublishDraftRepository.DefaultImpls.saveDraft$default(publishDraftRepository, sessionId, draftId, categoryParameters, str2, shouldSaveDraft, null, null, publishProcessNavigation, activeFieldId, SubmissionPresenterImpl.access$toTransferState(submissionPresenterImpl, publishState, steps, this.b.getParameters()), this.d, 96, null);
        }
    }

    public static final class i extends Lambda implements Function0<Unit> {
        public static final i a = new i();

        public i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Logs.debug$default("saveDraftIfNeeded", "Draft saved!", null, 4, null);
            return Unit.INSTANCE;
        }
    }

    public static final class j extends Lambda implements Function1<Throwable, Unit> {
        public final /* synthetic */ SubmissionPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(SubmissionPresenterImpl submissionPresenterImpl) {
            super(1);
            this.a = submissionPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            Logs.error("saveDraftIfNeeded", th2);
            if (!this.a.k.isDebug()) {
                return Unit.INSTANCE;
            }
            throw th2;
        }
    }

    public static final class k extends Lambda implements Function1<PublishInfoMessage, Unit> {
        public final /* synthetic */ SubmissionPresenterImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(SubmissionPresenterImpl submissionPresenterImpl) {
            super(1);
            this.a = submissionPresenterImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(PublishInfoMessage publishInfoMessage) {
            PublishInfoMessage publishInfoMessage2 = publishInfoMessage;
            String draftId = publishInfoMessage2.getDraftId();
            if (draftId != null) {
                SubmissionPresenterImpl.access$getPublishViewModel$p(this.a).setDraftId(draftId);
            }
            String message = publishInfoMessage2.getMessage();
            if (message != null) {
                this.a.l.handleMessage(message);
            }
            DeepLinksDialogInfo dialogInfo = publishInfoMessage2.getDialogInfo();
            if (dialogInfo != null) {
                SubmissionPresenterImpl.access$getPublishViewModel$p(this.a).getDialogs().postValue(dialogInfo);
            }
            return Unit.INSTANCE;
        }
    }

    public SubmissionPresenterImpl(@NotNull SchedulersFactory schedulersFactory, @NotNull PublishEventTracker publishEventTracker, @NotNull PublishAnalyticsDataProvider publishAnalyticsDataProvider, @NotNull PublishDraftRepository publishDraftRepository, @NotNull PublishDraftWiper publishDraftWiper, @NotNull PublishDraftDataHolder publishDraftDataHolder, @NotNull Gson gson, @NotNull BuildInfo buildInfo, @NotNull PublishMessageHandler publishMessageHandler) {
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(publishEventTracker, "eventTracker");
        Intrinsics.checkNotNullParameter(publishAnalyticsDataProvider, "analyticsDataProvider");
        Intrinsics.checkNotNullParameter(publishDraftRepository, "publishDraftRepository");
        Intrinsics.checkNotNullParameter(publishDraftWiper, "publishDraftWiper");
        Intrinsics.checkNotNullParameter(publishDraftDataHolder, "publishDraftDataHolder");
        Intrinsics.checkNotNullParameter(gson, "publishSessionStateSerializer");
        Intrinsics.checkNotNullParameter(buildInfo, "buildInfo");
        Intrinsics.checkNotNullParameter(publishMessageHandler, "publishMessageHandler");
        this.d = schedulersFactory;
        this.e = publishEventTracker;
        this.f = publishAnalyticsDataProvider;
        this.g = publishDraftRepository;
        this.h = publishDraftWiper;
        this.i = publishDraftDataHolder;
        this.j = gson;
        this.k = buildInfo;
        this.l = publishMessageHandler;
    }

    public static final /* synthetic */ PublishViewModel access$getPublishViewModel$p(SubmissionPresenterImpl submissionPresenterImpl) {
        PublishViewModel publishViewModel = submissionPresenterImpl.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        return publishViewModel;
    }

    public static final LocalPublishState access$toTransferState(SubmissionPresenterImpl submissionPresenterImpl, PublishState publishState, List list, List list2) {
        T t;
        boolean z;
        Objects.requireNonNull(submissionPresenterImpl);
        ArrayList arrayList = new ArrayList();
        Iterator it = list2.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            ParameterSlot parameterSlot = (ParameterSlot) next;
            if ((parameterSlot instanceof CharParameter) && ((CharParameter) parameterSlot).getInputType() == CharParameter.InputType.VIN) {
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(t6.v.e.coerceAtLeast(q.mapCapacity(t6.n.e.collectionSizeOrDefault(arrayList, 10)), 16));
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Object next2 = it2.next();
            linkedHashMap.put(((ParameterSlot) next2).getId(), next2);
        }
        Set<Map.Entry<Integer, PublishState.StepState>> entrySet = publishState.getStepStates().entrySet();
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : entrySet) {
            int intValue = ((Number) t2.getKey()).intValue();
            PublishState.StepState stepState = (PublishState.StepState) t2.getValue();
            if (stepState instanceof PublishState.StepState.Vin) {
                Iterator<T> it3 = ((CategoryPublishStep) list.get(intValue)).getFields().iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it3.next();
                    if (linkedHashMap.get(t) != null) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                T t3 = t;
                String recognizedVin = ((PublishState.StepState.Vin) stepState).getRecognizedVin();
                if (!(recognizedVin == null || t3 == null)) {
                    arrayList2.add(new IdValuePair(t3, recognizedVin));
                }
            }
        }
        return new LocalPublishState(arrayList2, CollectionsKt___CollectionsKt.toList(publishState.getChangedFieldIds()));
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void attachRouter(@NotNull SubmissionPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.c = router;
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void detachRouter() {
        this.c = null;
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void detachView(boolean z, boolean z2) {
        if (z && z2) {
            saveDraftIfNeeded(true);
        }
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void onAdvertPublished(@NotNull PublishedAdvertData publishedAdvertData) {
        Intrinsics.checkNotNullParameter(publishedAdvertData, "publishedAdvertData");
        PublishViewModel publishViewModel = this.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishViewModel.setAdvertId(publishedAdvertData.getAdvertId());
        this.h.deleteDraftWithPhotos().subscribeOn(this.d.io()).subscribe(a.a, new b(this));
        String advertId = publishedAdvertData.getAdvertId();
        PublishEventTracker publishEventTracker = this.e;
        PublishViewModel publishViewModel2 = this.a;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        publishEventTracker.trackAddAdvert(publishViewModel2.getNavigation().getCategoryId());
        PublishViewModel publishViewModel3 = this.a;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Integer categoryId = publishViewModel3.getState().getRootNavigation().getCategoryId();
        if (categoryId != null) {
            this.e.trackAddAdvertWithVertical(categoryId.intValue());
        }
        DeepLink nextStepUri = publishedAdvertData.getNextStepUri();
        if (!(nextStepUri instanceof NoMatchLink)) {
            SubmissionPresenter.Router router = this.c;
            if (router != null) {
                router.openDeepLink(nextStepUri);
            }
        } else if (publishedAdvertData.getShowFees()) {
            SubmissionPresenter.Router router2 = this.c;
            if (router2 != null) {
                router2.showListingFeesScreen(advertId);
            }
        } else {
            SubmissionPresenter.Router router3 = this.c;
            if (router3 != null) {
                SubmissionPresenter.Router.DefaultImpls.showItemScreen$default(router3, advertId, null, true, 2, null);
            }
        }
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public boolean onResult(int i2, int i3, @Nullable String str) {
        if (i2 == 1) {
            PublishViewModel publishViewModel = this.a;
            if (publishViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            if (publishViewModel.getAdvertId() == null) {
                PublishViewModel publishViewModel2 = this.a;
                if (publishViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel2.setAdvertId(str);
            }
            PublishViewModel publishViewModel3 = this.a;
            if (publishViewModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            String advertId = publishViewModel3.getAdvertId();
            if (advertId == null) {
                return false;
            }
            if (i3 == -1) {
                SubmissionPresenter.Router router = this.c;
                if (router != null) {
                    SubmissionPresenter.Router.DefaultImpls.showItemScreen$default(router, advertId, null, true, 2, null);
                }
            } else {
                SubmissionPresenter.Router router2 = this.c;
                if (router2 != null) {
                    SubmissionPresenter.Router.DefaultImpls.showItemScreen$default(router2, advertId, null, false, 2, null);
                }
            }
        } else if (i2 != 2) {
            return false;
        } else {
            PublishViewModel publishViewModel4 = this.a;
            if (publishViewModel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            if (publishViewModel4.getAdvertId() == null) {
                PublishViewModel publishViewModel5 = this.a;
                if (publishViewModel5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
                }
                publishViewModel5.setAdvertId(str);
            }
            PublishViewModel publishViewModel6 = this.a;
            if (publishViewModel6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
            }
            String advertId2 = publishViewModel6.getAdvertId();
            if (advertId2 == null) {
                return false;
            }
            SubmissionPresenter.Router router3 = this.c;
            if (router3 != null) {
                SubmissionPresenter.Router.DefaultImpls.showItemScreen$default(router3, advertId2, null, true, 2, null);
            }
        }
        return true;
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void onViewCreated() {
        CompositeDisposable compositeDisposable = this.b;
        PublishViewModel publishViewModel = this.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Observable<R> map = publishViewModel.getStepIndexChanges().map(c.a);
        PublishViewModel publishViewModel2 = this.a;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        Disposable subscribe = map.mergeWith(publishViewModel2.getParametersValueChanges().map(d.a).throttleLast(5, TimeUnit.SECONDS)).subscribe(new e(this), f.a);
        Intrinsics.checkNotNullExpressionValue(subscribe, "publishViewModel.stepInd…nges\", it)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void onViewDestroyed() {
        this.b.clear();
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    @SuppressLint({"CheckResult"})
    public boolean saveDraftIfNeeded(boolean z) {
        CategoryParameters deepCopy;
        PublishViewModel publishViewModel = this.a;
        if (publishViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        if (publishViewModel.isItemPublished()) {
            return false;
        }
        PublishViewModel publishViewModel2 = this.a;
        if (publishViewModel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        CategoryParameters categoryParameters = publishViewModel2.getCategoryParameters();
        if (categoryParameters == null || (deepCopy = categoryParameters.deepCopy()) == null) {
            return false;
        }
        PublishViewModel publishViewModel3 = this.a;
        if (publishViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("publishViewModel");
        }
        PublishState deepCopy2 = publishViewModel3.getState().deepCopy();
        if (deepCopy2.getChangedFieldIds().isEmpty()) {
            return false;
        }
        Maybe observeOn = Single.fromCallable(new g(this, deepCopy2)).flatMapMaybe(new h(this, deepCopy, deepCopy2, z)).subscribeOn(this.d.io()).observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "Single.fromCallable { pu…dSchedulers.mainThread())");
        SubscribersKt.subscribeBy(observeOn, new j(this), i.a, new k(this));
        return true;
    }

    @Override // com.avito.android.publish.SubmissionPresenter
    public void setPublishViewModel(@NotNull PublishViewModel publishViewModel) {
        Intrinsics.checkNotNullParameter(publishViewModel, "viewModel");
        this.a = publishViewModel;
    }
}
