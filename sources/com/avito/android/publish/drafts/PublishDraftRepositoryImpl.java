package com.avito.android.publish.drafts;

import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.app.work.PublishDraftsSyncWorkFactory;
import com.avito.android.publish.PhotoSyncDelegate;
import com.avito.android.publish.drafts.PublishDraftRepository;
import com.avito.android.publish.drafts.db.PublishDraftsDao;
import com.avito.android.remote.DeviceIdProvider;
import com.avito.android.remote.PublishApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.remote.model.PublishDraftResponse;
import com.avito.android.remote.model.SaveDraftResponse;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.category_parameters.AttributeNode;
import com.avito.android.remote.model.category_parameters.AttributesTreeConverter;
import com.avito.android.remote.model.category_parameters.CategoryParameters;
import com.avito.android.remote.model.category_parameters.CategoryParametersConverter;
import com.avito.android.remote.model.category_parameters.PhotoParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.Singles;
import com.avito.android.util.TypedSingleKt;
import com.avito.android.util.rx3.InteropKt;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ê\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Ba\u0012\u0006\u00104\u001a\u000201\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010W\u001a\u00020T\u0012\u0006\u0010O\u001a\u00020L\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010K\u001a\u00020H\u0012\f\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0A\u0012\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020605¢\u0006\u0004\bX\u0010YJ)\u0010\u0006\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 \u0005*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u00030\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001b\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0007J\u000f\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012Js\u0010%\u001a\b\u0012\u0004\u0012\u00020$0#2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020\u0018H\u0016¢\u0006\u0004\b%\u0010&J/\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020*0)0\u00022\u0006\u0010'\u001a\u00020\u00042\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\"\u00109\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u000206058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R$\u0010<\u001a\u0010\u0012\f\u0012\n \u0005*\u0004\u0018\u00010\u000e0\u000e0\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u001c\u0010D\u001a\b\u0012\u0004\u0012\u00020\t0A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0016\u0010G\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010FR\u0016\u0010K\u001a\u00020H8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010O\u001a\u00020L8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0016\u0010W\u001a\u00020T8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bU\u0010V¨\u0006Z"}, d2 = {"Lcom/avito/android/publish/drafts/PublishDraftRepositoryImpl;", "Lcom/avito/android/publish/drafts/PublishDraftRepository;", "Lio/reactivex/Single;", "Larrow/core/Option;", "Lcom/avito/android/publish/drafts/LocalDraft;", "kotlin.jvm.PlatformType", "getDraft", "()Lio/reactivex/Single;", "Lio/reactivex/Observable;", "", "observeDraftsById", "()Lio/reactivex/Observable;", "Lcom/avito/android/remote/model/PublishDraftResponse;", "getLatestDraftData", "Lcom/avito/android/publish/drafts/PublishDraftRepository$DraftSyncResult;", "syncDraftIfNeeded", "Lio/reactivex/Completable;", "deleteDraft", "()Lio/reactivex/Completable;", "sessionId", "draftId", "Lcom/avito/android/remote/model/category_parameters/CategoryParameters;", "categoryParameters", "state", "", "hasLocalChanges", "serverDraftId", "", "version", "Lcom/avito/android/remote/model/Navigation;", "navigation", "activeFieldId", "Lcom/avito/android/publish/drafts/LocalPublishState;", "localPublishState", "showInfoMessages", "Lio/reactivex/Maybe;", "Lcom/avito/android/publish/drafts/PublishInfoMessage;", "saveDraft", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/category_parameters/CategoryParameters;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Integer;Lcom/avito/android/remote/model/Navigation;Ljava/lang/String;Lcom/avito/android/publish/drafts/LocalPublishState;Z)Lio/reactivex/Maybe;", "localDraft", "showResultMessage", "Lcom/avito/android/remote/model/TypedResult;", "Lcom/avito/android/remote/model/SaveDraftResponse;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/publish/drafts/LocalDraft;Ljava/lang/Boolean;)Lio/reactivex/Single;", "Lcom/avito/android/remote/DeviceIdProvider;", "h", "Lcom/avito/android/remote/DeviceIdProvider;", "deviceIdProvider", "Lcom/avito/android/remote/PublishApi;", "c", "Lcom/avito/android/remote/PublishApi;", "publishApi", "Lkotlin/Function1;", "Lcom/avito/android/publish/PhotoSyncDelegate;", "k", "Lkotlin/jvm/functions/Function1;", "photoSyncDelegateProvider", AuthSource.BOOKING_ORDER, "Lio/reactivex/Single;", "syncDraftSingle", "Lcom/avito/android/publish/drafts/db/PublishDraftsDao;", "d", "Lcom/avito/android/publish/drafts/db/PublishDraftsDao;", "publishDraftsDao", "Lcom/jakewharton/rxrelay3/PublishRelay;", "j", "Lcom/jakewharton/rxrelay3/PublishRelay;", "draftUpdateConsumer", "Lio/reactivex/Scheduler;", "Lio/reactivex/Scheduler;", "draftSyncScheduler", "Lcom/avito/android/util/SchedulersFactory;", "i", "Lcom/avito/android/util/SchedulersFactory;", "schedulersFactory", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "f", "Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;", "attributesTreeConverter", "Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;", a2.g.r.g.a, "Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;", "syncWorker", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "e", "Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;", "categoryConverter", "<init>", "(Lcom/avito/android/remote/PublishApi;Lcom/avito/android/publish/drafts/db/PublishDraftsDao;Lcom/avito/android/remote/model/category_parameters/CategoryParametersConverter;Lcom/avito/android/remote/model/category_parameters/AttributesTreeConverter;Lcom/avito/android/app/work/PublishDraftsSyncWorkFactory;Lcom/avito/android/remote/DeviceIdProvider;Lcom/avito/android/util/SchedulersFactory;Lcom/jakewharton/rxrelay3/PublishRelay;Lkotlin/jvm/functions/Function1;)V", "publish-drafts_release"}, k = 1, mv = {1, 4, 2})
public final class PublishDraftRepositoryImpl implements PublishDraftRepository {
    public final Scheduler a;
    public final Single<PublishDraftRepository.DraftSyncResult> b;
    public final PublishApi c;
    public final PublishDraftsDao d;
    public final CategoryParametersConverter e;
    public final AttributesTreeConverter f;
    public final PublishDraftsSyncWorkFactory g;
    public final DeviceIdProvider h;
    public final SchedulersFactory i;
    public final PublishRelay<String> j;
    public final Function1<String, PhotoSyncDelegate> k;

    public static final class a<V> implements Callable<Object> {
        public final /* synthetic */ PublishDraftRepositoryImpl a;

        public a(PublishDraftRepositoryImpl publishDraftRepositoryImpl) {
            this.a = publishDraftRepositoryImpl;
        }

        @Override // java.util.concurrent.Callable
        public Object call() {
            this.a.d.delete();
            return Unit.INSTANCE;
        }
    }

    public static final class b<T, R> implements Function<TypedResult<PublishDraftResponse>, PublishDraftResponse> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PublishDraftResponse apply(TypedResult<PublishDraftResponse> typedResult) {
            TypedResult<PublishDraftResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return (PublishDraftResponse) ((TypedResult.OfResult) typedResult2).getResult();
            }
            return PublishDraftResponse.NotFound.INSTANCE;
        }
    }

    public static final class c<T, R> implements Function<Throwable, PublishDraftResponse> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PublishDraftResponse apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return PublishDraftResponse.NotFound.INSTANCE;
        }
    }

    public static final class d<V> implements Callable<LocalDraft> {
        public final /* synthetic */ PublishDraftRepositoryImpl a;
        public final /* synthetic */ CategoryParameters b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ Integer f;
        public final /* synthetic */ boolean g;
        public final /* synthetic */ String h;
        public final /* synthetic */ Navigation i;
        public final /* synthetic */ String j;
        public final /* synthetic */ LocalPublishState k;

        public d(PublishDraftRepositoryImpl publishDraftRepositoryImpl, CategoryParameters categoryParameters, String str, String str2, String str3, Integer num, boolean z, String str4, Navigation navigation, String str5, LocalPublishState localPublishState) {
            this.a = publishDraftRepositoryImpl;
            this.b = categoryParameters;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = num;
            this.g = z;
            this.h = str4;
            this.i = navigation;
            this.j = str5;
            this.k = localPublishState;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public LocalDraft call() {
            String str;
            LocalDraft load = this.a.d.load();
            List<ParameterSlot> parametersExceptOwnedBySlots = this.b.getParametersExceptOwnedBySlots();
            List<AttributeNode> convertToSlotAttributesTree = this.a.f.convertToSlotAttributesTree(parametersExceptOwnedBySlots);
            List<AttributeNode> convertToParameterAttributesTree = this.a.f.convertToParameterAttributesTree(parametersExceptOwnedBySlots);
            String str2 = this.c;
            String str3 = this.d;
            String str4 = this.e;
            Integer num = this.f;
            if (num == null) {
                num = load != null ? Integer.valueOf(load.getVersion()) : null;
            }
            int intValue = num != null ? num.intValue() : 0;
            boolean z = this.g;
            if (load == null || (str = load.getServerDraftId()) == null) {
                str = this.h;
            }
            LocalDraft localDraft = new LocalDraft(str2, str3, str4, intValue, z, str, convertToSlotAttributesTree, convertToParameterAttributesTree, this.i, this.j, this.k);
            PublishDraftRepositoryImpl.access$updateLocalDraft(this.a, localDraft);
            return localDraft;
        }
    }

    public static final class e<T, R> implements Function<LocalDraft, MaybeSource<? extends PublishInfoMessage>> {
        public final /* synthetic */ PublishDraftRepositoryImpl a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ boolean c;

        public e(PublishDraftRepositoryImpl publishDraftRepositoryImpl, boolean z, boolean z2) {
            this.a = publishDraftRepositoryImpl;
            this.b = z;
            this.c = z2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MaybeSource<? extends PublishInfoMessage> apply(LocalDraft localDraft) {
            LocalDraft localDraft2 = localDraft;
            Intrinsics.checkNotNullParameter(localDraft2, "localDraft");
            if (this.b) {
                return this.a.a(localDraft2, Boolean.valueOf(this.c)).flatMapMaybe(new a2.a.a.e2.t.a(this));
            }
            return Maybe.empty();
        }
    }

    public static final class f<T> implements Consumer<TypedResult<SaveDraftResponse>> {
        public final /* synthetic */ PublishDraftRepositoryImpl a;
        public final /* synthetic */ LocalDraft b;

        public f(PublishDraftRepositoryImpl publishDraftRepositoryImpl, LocalDraft localDraft) {
            this.a = publishDraftRepositoryImpl;
            this.b = localDraft;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r0v5, resolved type: com.jakewharton.rxrelay3.PublishRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public void accept(TypedResult<SaveDraftResponse> typedResult) {
            TypedResult<SaveDraftResponse> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                SaveDraftResponse saveDraftResponse = (SaveDraftResponse) ((TypedResult.OfResult) typedResult2).getResult();
                if (saveDraftResponse instanceof SaveDraftResponse.Ok) {
                    SaveDraftResponse.Ok.Draft draft = ((SaveDraftResponse.Ok) saveDraftResponse).getDraft();
                    PublishDraftRepositoryImpl.access$updateLocalDraft(this.a, LocalDraft.copy$default(this.b, null, null, null, draft.getVersion(), false, draft.getId(), null, null, null, null, null, 1991, null));
                    this.a.j.accept(draft.getId());
                }
            }
        }
    }

    public static final class g<V> implements Callable<SingleSource<? extends PublishDraftRepository.DraftSyncResult>> {
        public final /* synthetic */ PublishDraftRepositoryImpl a;

        public g(PublishDraftRepositoryImpl publishDraftRepositoryImpl) {
            this.a = publishDraftRepositoryImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // java.util.concurrent.Callable
        public SingleSource<? extends PublishDraftRepository.DraftSyncResult> call() {
            Completable completable;
            LocalDraft load = this.a.d.load();
            if (load == null) {
                return Single.just(PublishDraftRepository.DraftSyncResult.SUCCESS);
            }
            if (load.getHasLocalChanges()) {
                completable = TypedSingleKt.toTyped(this.a.a(load, null)).ignoreElement();
            } else {
                completable = Completable.complete();
            }
            Single flatMap = ((PhotoSyncDelegate) this.a.k.invoke(load.getDraftId())).syncPhotoObservable(new a2.a.a.e2.t.c(this)).toSingleDefault(Unit.INSTANCE).flatMap(new PublishDraftRepositoryImpl$syncDraftSingle$1$$special$$inlined$flatMapSingle$1());
            Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
            return completable.andThen(flatMap);
        }
    }

    public static final class h<T, R> implements Function<Throwable, PublishDraftRepository.DraftSyncResult> {
        public static final h a = new h();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public PublishDraftRepository.DraftSyncResult apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return PublishDraftRepository.DraftSyncResult.ERROR;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r10v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.String, ? extends com.avito.android.publish.PhotoSyncDelegate> */
    /* JADX WARN: Multi-variable type inference failed */
    public PublishDraftRepositoryImpl(@NotNull PublishApi publishApi, @NotNull PublishDraftsDao publishDraftsDao, @NotNull CategoryParametersConverter categoryParametersConverter, @NotNull AttributesTreeConverter attributesTreeConverter, @NotNull PublishDraftsSyncWorkFactory publishDraftsSyncWorkFactory, @NotNull DeviceIdProvider deviceIdProvider, @NotNull SchedulersFactory schedulersFactory, @NotNull PublishRelay<String> publishRelay, @NotNull Function1<? super String, ? extends PhotoSyncDelegate> function1) {
        Intrinsics.checkNotNullParameter(publishApi, "publishApi");
        Intrinsics.checkNotNullParameter(publishDraftsDao, "publishDraftsDao");
        Intrinsics.checkNotNullParameter(categoryParametersConverter, "categoryConverter");
        Intrinsics.checkNotNullParameter(attributesTreeConverter, "attributesTreeConverter");
        Intrinsics.checkNotNullParameter(publishDraftsSyncWorkFactory, "syncWorker");
        Intrinsics.checkNotNullParameter(deviceIdProvider, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulersFactory");
        Intrinsics.checkNotNullParameter(publishRelay, "draftUpdateConsumer");
        Intrinsics.checkNotNullParameter(function1, "photoSyncDelegateProvider");
        this.c = publishApi;
        this.d = publishDraftsDao;
        this.e = categoryParametersConverter;
        this.f = attributesTreeConverter;
        this.g = publishDraftsSyncWorkFactory;
        this.h = deviceIdProvider;
        this.i = schedulersFactory;
        this.j = publishRelay;
        this.k = function1;
        Scheduler single = schedulersFactory.single();
        this.a = single;
        Single<PublishDraftRepository.DraftSyncResult> onErrorReturn = Single.defer(new g(this)).toObservable().subscribeOn(single).share().firstOrError().timeout(15, TimeUnit.SECONDS).onErrorReturn(h.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "Single.defer {\n        v…{ DraftSyncResult.ERROR }");
        this.b = onErrorReturn;
    }

    public static final Completable access$syncPhotoParameter(PublishDraftRepositoryImpl publishDraftRepositoryImpl, PhotoParameter photoParameter) {
        LocalDraft load = publishDraftRepositoryImpl.d.load();
        if (load != null) {
            AttributeNode attributeNode = (AttributeNode) CollectionsKt___CollectionsKt.first((List<? extends Object>) publishDraftRepositoryImpl.f.convertToParameterAttributesTree(t6.n.d.listOf(photoParameter)));
            if (load.getParameters().contains(attributeNode)) {
                Completable complete = Completable.complete();
                Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
                return complete;
            }
            List mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) load.getParameters());
            t6.n.h.removeAll(mutableList, (Function1) new a2.a.a.e2.t.d(attributeNode));
            mutableList.add(attributeNode);
            LocalDraft copy$default = LocalDraft.copy$default(load, null, null, null, 0, false, null, null, mutableList, null, null, null, 1919, null);
            publishDraftRepositoryImpl.d.save(copy$default);
            Completable ignoreElement = TypedSingleKt.toTyped(publishDraftRepositoryImpl.a(copy$default, Boolean.FALSE)).ignoreElement();
            Intrinsics.checkNotNullExpressionValue(ignoreElement, "saveDraftToRemote(update…         .ignoreElement()");
            return ignoreElement;
        }
        Completable complete2 = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete2, "Completable.complete()");
        return complete2;
    }

    public static final void access$updateLocalDraft(PublishDraftRepositoryImpl publishDraftRepositoryImpl, LocalDraft localDraft) {
        publishDraftRepositoryImpl.d.save(localDraft);
    }

    public final Single<TypedResult<SaveDraftResponse>> a(LocalDraft localDraft, Boolean bool) {
        Single<TypedResult<SaveDraftResponse>> doOnSuccess = InteropKt.toV2(this.c.saveDraft(localDraft.getSessionId(), this.h.getValue(), this.e.convertToFieldMap(localDraft.getNavigation()), this.f.convertToParameterAttributesMap(localDraft.getParameters()), this.f.convertToSlotAttributesMap(localDraft.getSlots()), this.e.convertToFieldMap(TuplesKt.to("state", localDraft.getLocalPublishState())), localDraft.getServerDraftId(), Integer.valueOf(localDraft.getVersion()), localDraft.getActiveFieldId(), bool)).doOnSuccess(new f(this, localDraft));
        Intrinsics.checkNotNullExpressionValue(doOnSuccess, "publishApi.saveDraft(\n  …          }\n            }");
        return doOnSuccess;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Completable deleteDraft() {
        Completable fromCallable = Completable.fromCallable(new a(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Completable.fromCallable…hDraftsDao.delete()\n    }");
        return fromCallable;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Single<Option<LocalDraft>> getDraft() {
        Single<Option<LocalDraft>> subscribeOn = Singles.toSingle(OptionKt.toOption(this.d.load())).subscribeOn(this.a);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "publishDraftsDao.load().…ibeOn(draftSyncScheduler)");
        return subscribeOn;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Single<PublishDraftResponse> getLatestDraftData() {
        Single<PublishDraftResponse> onErrorReturn = InteropKt.toV2(this.c.getLatestDraft()).timeout(1, TimeUnit.SECONDS, this.i.computation()).map(b.a).onErrorReturn(c.a);
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "publishApi.getLatestDraf…hDraftResponse.NotFound }");
        return onErrorReturn;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Observable<Option<String>> observeDraftsById() {
        return this.d.observeDraftsById();
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Maybe<PublishInfoMessage> saveDraft(@NotNull String str, @NotNull String str2, @NotNull CategoryParameters categoryParameters, @NotNull String str3, boolean z, @Nullable String str4, @Nullable Integer num, @NotNull Navigation navigation, @Nullable String str5, @NotNull LocalPublishState localPublishState, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        Intrinsics.checkNotNullParameter(str2, "draftId");
        Intrinsics.checkNotNullParameter(categoryParameters, "categoryParameters");
        Intrinsics.checkNotNullParameter(str3, "state");
        Intrinsics.checkNotNullParameter(navigation, "navigation");
        Intrinsics.checkNotNullParameter(localPublishState, "localPublishState");
        Maybe<PublishInfoMessage> subscribeOn = Single.fromCallable(new d(this, categoryParameters, str, str2, str3, num, z, str4, navigation, str5, localPublishState)).flatMapMaybe(new e(this, z, z2)).subscribeOn(this.a);
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "Single.fromCallable {\n  …ibeOn(draftSyncScheduler)");
        return subscribeOn;
    }

    @Override // com.avito.android.publish.drafts.PublishDraftRepository
    @NotNull
    public Single<PublishDraftRepository.DraftSyncResult> syncDraftIfNeeded() {
        return this.b;
    }
}
