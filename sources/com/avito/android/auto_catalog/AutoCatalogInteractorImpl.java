package com.avito.android.auto_catalog;

import a2.g.r.g;
import com.avito.android.auto_catalog.di.AutoCatalogModule;
import com.avito.android.auto_catalog.remote.AutoCatalogApi;
import com.avito.android.auto_catalog.remote.model.AutoCatalogResponse;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpAdvertXl;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.android.serp.adapter.SerpElementItemConverter;
import com.avito.android.serp.adapter.ViewTypeSerpItem;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory;
import com.avito.android.util.UrlParams;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001BM\b\u0007\u0012\n\b\u0001\u00104\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u0019\u001a\u00020\u0016\u0012\u0006\u0010!\u001a\u00020\u001e¢\u0006\u0004\b5\u00106J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JW\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u00110\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0018\u00104\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lcom/avito/android/auto_catalog/AutoCatalogInteractorImpl;", "Lcom/avito/android/auto_catalog/AutoCatalogInteractor;", "Lio/reactivex/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/auto_catalog/remote/model/AutoCatalogResponse;", "loadAutoCatalog", "()Lio/reactivex/Observable;", "", "page", "", UrlParams.LAST_STAMP, "", "context", "", "areNotificationsEnabled", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "Lkotlin/Pair;", "", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "getSerpItems", "(Ljava/lang/Integer;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/Boolean;Lcom/avito/android/remote/model/SearchParams;)Lio/reactivex/Observable;", "Lcom/avito/android/util/SchedulersFactory;", g.a, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lcom/avito/android/remote/SearchApi;", "d", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "h", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "Lcom/avito/android/auto_catalog/remote/AutoCatalogApi;", "c", "Lcom/avito/android/auto_catalog/remote/AutoCatalogApi;", "api", "Lcom/avito/android/remote/model/SearchParamsConverter;", "f", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "e", "Lcom/avito/android/serp/adapter/SerpElementItemConverter;", "itemConverter", "Lcom/avito/android/auto_catalog/AutoCatalogData;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/auto_catalog/AutoCatalogData;", "autoCatalogData", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "from", "<init>", "(Ljava/lang/String;Lcom/avito/android/auto_catalog/AutoCatalogData;Lcom/avito/android/auto_catalog/remote/AutoCatalogApi;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/serp/adapter/SerpElementItemConverter;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/util/SchedulersFactory;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class AutoCatalogInteractorImpl implements AutoCatalogInteractor {
    public final String a;
    public final AutoCatalogData b;
    public final AutoCatalogApi c;
    public final SearchApi d;
    public final SerpElementItemConverter e;
    public final SearchParamsConverter f;
    public final SchedulersFactory g;
    public final TypedErrorThrowableConverter h;

    public static final class a<T, R> implements Function<TypedResult<SerpElementResult>, Pair<? extends Long, ? extends List<? extends PersistableSerpItem>>> {
        public final /* synthetic */ AutoCatalogInteractorImpl a;

        public a(AutoCatalogInteractorImpl autoCatalogInteractorImpl) {
            this.a = autoCatalogInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends Long, ? extends List<? extends PersistableSerpItem>> apply(TypedResult<SerpElementResult> typedResult) {
            TypedResult<SerpElementResult> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "typedResult");
            if (!(typedResult2 instanceof TypedResult.OfResult)) {
                return new Pair<>(0L, CollectionsKt__CollectionsKt.emptyList());
            }
            TypedResult.OfResult ofResult = (TypedResult.OfResult) typedResult2;
            Long valueOf = Long.valueOf(((SerpElementResult) ofResult.getResult()).getCount());
            SerpElementItemConverter serpElementItemConverter = this.a.e;
            List<SerpElement> elements = ((SerpElementResult) ofResult.getResult()).getElements();
            ArrayList arrayList = new ArrayList();
            for (T t : elements) {
                T t2 = t;
                if ((t2 instanceof SerpAdvert) && !(t2 instanceof SerpAdvertXl)) {
                    arrayList.add(t);
                }
            }
            List<ViewTypeSerpItem> convert = serpElementItemConverter.convert(CollectionsKt___CollectionsKt.take(arrayList, 6), SerpDisplayType.Grid);
            ArrayList arrayList2 = new ArrayList();
            for (T t3 : convert) {
                if (!(t3 instanceof PersistableSerpItem)) {
                    t3 = null;
                }
                T t4 = t3;
                if (t4 != null) {
                    arrayList2.add(t4);
                }
            }
            return new Pair<>(valueOf, arrayList2);
        }
    }

    public static final class b<T, R> implements Function<Throwable, Pair<? extends Long, ? extends List<? extends PersistableSerpItem>>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public Pair<? extends Long, ? extends List<? extends PersistableSerpItem>> apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return new Pair<>(0L, CollectionsKt__CollectionsKt.emptyList());
        }
    }

    public static final class c<T, R> implements Function<TypedResult<AutoCatalogResponse>, LoadingState<? super AutoCatalogResponse>> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutoCatalogResponse> apply(TypedResult<AutoCatalogResponse> typedResult) {
            TypedResult<AutoCatalogResponse> typedResult2 = typedResult;
            Intrinsics.checkNotNullParameter(typedResult2, "it");
            if (typedResult2 instanceof TypedResult.OfResult) {
                return new LoadingState.Loaded(((TypedResult.OfResult) typedResult2).getResult());
            }
            if (typedResult2 instanceof TypedResult.OfError) {
                return new LoadingState.Error(((TypedResult.OfError) typedResult2).getError());
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final class d<T, R> implements Function<Throwable, LoadingState<? super AutoCatalogResponse>> {
        public final /* synthetic */ AutoCatalogInteractorImpl a;

        public d(AutoCatalogInteractorImpl autoCatalogInteractorImpl) {
            this.a = autoCatalogInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public LoadingState<? super AutoCatalogResponse> apply(Throwable th) {
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(th2, "it");
            return new LoadingState.Error(this.a.h.convert(th2));
        }
    }

    @Inject
    public AutoCatalogInteractorImpl(@AutoCatalogModule.FromScreen @Nullable String str, @NotNull AutoCatalogData autoCatalogData, @NotNull AutoCatalogApi autoCatalogApi, @NotNull SearchApi searchApi, @NotNull SerpElementItemConverter serpElementItemConverter, @NotNull SearchParamsConverter searchParamsConverter, @NotNull SchedulersFactory schedulersFactory, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter) {
        Intrinsics.checkNotNullParameter(autoCatalogData, "autoCatalogData");
        Intrinsics.checkNotNullParameter(autoCatalogApi, "api");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(serpElementItemConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        this.a = str;
        this.b = autoCatalogData;
        this.c = autoCatalogApi;
        this.d = searchApi;
        this.e = serpElementItemConverter;
        this.f = searchParamsConverter;
        this.g = schedulersFactory;
        this.h = typedErrorThrowableConverter;
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogInteractor
    @NotNull
    public Observable<Pair<Long, List<PersistableSerpItem>>> getSerpItems(@Nullable Integer num, @Nullable Long l, @Nullable String str, @Nullable Boolean bool, @NotNull SearchParams searchParams) {
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        return a2.b.a.a.a.S1(this.g, InteropKt.toV2(this.d.getSerpElementTypedResult(num, l, null, str, bool, null, SearchParamsConverter.DefaultImpls.convertToMap$default(this.f, searchParams, null, false, false, 14, null), searchParams.getForcedLocationForRecommendation())).map(new a(this)).onErrorReturn(b.a), "searchApi.getSerpElement…scribeOn(schedulers.io())");
    }

    @Override // com.avito.android.auto_catalog.AutoCatalogInteractor
    @NotNull
    public Observable<LoadingState<AutoCatalogResponse>> loadAutoCatalog() {
        return a2.b.a.a.a.S1(this.g, InteropKt.toV2(this.c.getAutoCatalog(this.b.getGenerationId(), this.b.getBodyTypeId(), this.b.getModificationId(), this.a, this.b.getAdvertLocationId())).map(c.a).startWith((Observable) LoadingState.Loading.INSTANCE).onErrorReturn(new d(this)), "api.getAutoCatalog(\n    …scribeOn(schedulers.io())");
    }
}
