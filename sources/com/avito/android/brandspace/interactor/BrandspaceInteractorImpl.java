package com.avito.android.brandspace.interactor;

import a2.g.r.g;
import com.avito.android.brandspace.data.AdvertRepository;
import com.avito.android.brandspace.di.BrandspaceAdvertRepository;
import com.avito.android.brandspace.di.BrandspaceId;
import com.avito.android.brandspace.di.SearchAdvertRepository;
import com.avito.android.brandspace.di.TabsAdvertRepository;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.brandspace.presenter.BrandspaceAdverts;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
import com.avito.android.brandspace.remote.BrandspaceApi;
import com.avito.android.brandspace.remote.model.Brandspace;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpAdvert;
import com.avito.android.remote.model.SerpElement;
import com.avito.android.remote.model.SerpElementResult;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.TypedObservablesKt;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001Bc\b\u0007\u0012\b\b\u0001\u0010\u0015\u001a\u00020\u000e\u0012\u000e\b\u0001\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u001e\u0012\u000e\b\u0001\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001e\u0012\u000e\b\u0001\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e\u0012\u0006\u00100\u001a\u00020-\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0019\u001a\u00020\u0016¢\u0006\u0004\b1\u00102J\u0015\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J%\u0010\u000b\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\n0\t0\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\fJ)\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00022\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020#0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010!R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u001c\u0010,\u001a\b\u0012\u0004\u0012\u00020*0\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010!R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/avito/android/brandspace/interactor/BrandspaceInteractorImpl;", "Lcom/avito/android/brandspace/interactor/BrandspaceInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/brandspace/remote/model/Brandspace;", "loadBrandspace", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "loadAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource;)Lio/reactivex/rxjava3/core/Single;", "", "", "searchParams", "Lcom/avito/android/brandspace/presenter/BrandspaceAdverts;", "loadFilteredAdverts", "(Ljava/util/Map;)Lio/reactivex/rxjava3/core/Observable;", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "id", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "h", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "advertProcessor", "Lcom/avito/android/util/SchedulersFactory3;", g.a, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$TabsSource;", "d", "Lcom/avito/android/brandspace/data/AdvertRepository;", "tabsRepository", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "c", "searchAdvertRepository", "Lcom/avito/android/remote/SearchApi;", "f", "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$LinkSource;", AuthSource.BOOKING_ORDER, "brandspaceAdvertRepository", "Lcom/avito/android/brandspace/remote/BrandspaceApi;", "e", "Lcom/avito/android/brandspace/remote/BrandspaceApi;", "brandspaceApi", "<init>", "(Ljava/lang/String;Lcom/avito/android/brandspace/data/AdvertRepository;Lcom/avito/android/brandspace/data/AdvertRepository;Lcom/avito/android/brandspace/data/AdvertRepository;Lcom/avito/android/brandspace/remote/BrandspaceApi;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class BrandspaceInteractorImpl implements BrandspaceInteractor {
    public final String a;
    public final AdvertRepository<AdvertSource.LinkSource> b;
    public final AdvertRepository<AdvertSource.ParametersSource> c;
    public final AdvertRepository<AdvertSource.TabsSource> d;
    public final BrandspaceApi e;
    public final SearchApi f;
    public final SchedulersFactory3 g;
    public final BrandspaceAdvertItemProcessor h;

    public static final class a<T, R> implements Function<SerpElementResult, BrandspaceAdverts> {
        public final /* synthetic */ BrandspaceInteractorImpl a;
        public final /* synthetic */ int b;

        public a(BrandspaceInteractorImpl brandspaceInteractorImpl, int i) {
            this.a = brandspaceInteractorImpl;
            this.b = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public BrandspaceAdverts apply(SerpElementResult serpElementResult) {
            SerpElementResult serpElementResult2 = serpElementResult;
            List<SerpElement> elements = serpElementResult2.getElements();
            ArrayList arrayList = new ArrayList();
            for (T t : elements) {
                if (t instanceof SerpAdvert) {
                    arrayList.add(t);
                }
            }
            return this.a.h.convert(serpElementResult2.cloneWithNewElements(CollectionsKt___CollectionsKt.take(arrayList, this.b)).getElements());
        }
    }

    @Inject
    public BrandspaceInteractorImpl(@BrandspaceId @NotNull String str, @BrandspaceAdvertRepository @NotNull AdvertRepository<AdvertSource.LinkSource> advertRepository, @SearchAdvertRepository @NotNull AdvertRepository<AdvertSource.ParametersSource> advertRepository2, @TabsAdvertRepository @NotNull AdvertRepository<AdvertSource.TabsSource> advertRepository3, @NotNull BrandspaceApi brandspaceApi, @NotNull SearchApi searchApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull BrandspaceAdvertItemProcessor brandspaceAdvertItemProcessor) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(advertRepository, "brandspaceAdvertRepository");
        Intrinsics.checkNotNullParameter(advertRepository2, "searchAdvertRepository");
        Intrinsics.checkNotNullParameter(advertRepository3, "tabsRepository");
        Intrinsics.checkNotNullParameter(brandspaceApi, "brandspaceApi");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(brandspaceAdvertItemProcessor, "advertProcessor");
        this.a = str;
        this.b = advertRepository;
        this.c = advertRepository2;
        this.d = advertRepository3;
        this.e = brandspaceApi;
        this.f = searchApi;
        this.g = schedulersFactory3;
        this.h = brandspaceAdvertItemProcessor;
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceInteractor
    @NotNull
    public Single<? extends List<BrandspaceItem>> loadAdverts(@NotNull AdvertSource advertSource) {
        Intrinsics.checkNotNullParameter(advertSource, "source");
        if (advertSource instanceof AdvertSource.LinkSource) {
            return this.b.getAdverts(advertSource);
        }
        if (advertSource instanceof AdvertSource.ParametersSource) {
            return this.c.getAdverts(advertSource);
        }
        if (advertSource instanceof AdvertSource.TabsSource) {
            return this.d.getAdverts(advertSource);
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceInteractor
    @NotNull
    public Observable<Brandspace> loadBrandspace() {
        Observable<TypedResult<Brandspace>> subscribeOn = this.e.getBrandspace(this.a).subscribeOn(this.g.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "brandspaceApi.getBrandsp…scribeOn(schedulers.io())");
        return TypedObservablesKt.toTyped(subscribeOn);
    }

    @Override // com.avito.android.brandspace.interactor.BrandspaceInteractor
    @NotNull
    public Observable<BrandspaceAdverts> loadFilteredAdverts(@NotNull Map<String, String> map) {
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(map, "searchParams");
        String str = map.get("limit");
        int intValue = (str == null || (intOrNull = l.toIntOrNull(str)) == null) ? 8 : intOrNull.intValue();
        SearchApi searchApi = this.f;
        Boolean bool = Boolean.FALSE;
        Observable<TypedResult<SerpElementResult>> subscribeOn = searchApi.getSerpElementTypedResult(1, null, null, null, bool, null, map, bool).subscribeOn(this.g.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "searchApi.getSerpElement…scribeOn(schedulers.io())");
        Observable<BrandspaceAdverts> map2 = TypedObservablesKt.toTyped(subscribeOn).map(new a(this, intValue));
        Intrinsics.checkNotNullExpressionValue(map2, "searchApi.getSerpElement…s.elements)\n            }");
        return map2;
    }
}
