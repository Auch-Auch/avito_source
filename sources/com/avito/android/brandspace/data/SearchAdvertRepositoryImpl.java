package com.avito.android.brandspace.data;

import com.avito.android.brandspace.items.adverts.BrandspaceAdvertItem;
import com.avito.android.brandspace.presenter.BrandspaceAdvertItemProcessor;
import com.avito.android.brandspace.presenter.BrandspaceAdverts;
import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.AdvertSource;
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
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0007\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/brandspace/data/SearchAdvertRepositoryImpl;", "Lcom/avito/android/brandspace/data/AdvertRepository;", "Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;", "source", "Lio/reactivex/rxjava3/core/Single;", "", "Lcom/avito/android/brandspace/presenter/BrandspaceItem;", "getAdverts", "(Lcom/avito/android/brandspace/presenter/virtualitems/extraloading/AdvertSource$ParametersSource;)Lio/reactivex/rxjava3/core/Single;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "c", "Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;", "advertProcessor", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "searchApi", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/brandspace/presenter/BrandspaceAdvertItemProcessor;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public final class SearchAdvertRepositoryImpl implements AdvertRepository<AdvertSource.ParametersSource> {
    public final SearchApi a;
    public final SchedulersFactory3 b;
    public final BrandspaceAdvertItemProcessor c;

    public static final class a<T, R> implements Function<SerpElementResult, BrandspaceAdverts> {
        public final /* synthetic */ SearchAdvertRepositoryImpl a;
        public final /* synthetic */ Integer b;

        public a(SearchAdvertRepositoryImpl searchAdvertRepositoryImpl, Integer num) {
            this.a = searchAdvertRepositoryImpl;
            this.b = num;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public BrandspaceAdverts apply(SerpElementResult serpElementResult) {
            SerpElementResult serpElementResult2 = serpElementResult;
            Integer num = this.b;
            if (num != null) {
                int intValue = num.intValue();
                List<SerpElement> elements = serpElementResult2.getElements();
                ArrayList arrayList = new ArrayList();
                for (T t : elements) {
                    if (t instanceof SerpAdvert) {
                        arrayList.add(t);
                    }
                }
                BrandspaceAdverts convert = this.a.c.convert(serpElementResult2.cloneWithNewElements(CollectionsKt___CollectionsKt.take(arrayList, intValue)).getElements());
                if (convert != null) {
                    return convert;
                }
            }
            return new BrandspaceAdverts(null, 1, null);
        }
    }

    public static final class b<T, R> implements Function<BrandspaceAdverts, List<? extends BrandspaceAdvertItem>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public List<? extends BrandspaceAdvertItem> apply(BrandspaceAdverts brandspaceAdverts) {
            return brandspaceAdverts.getAdverts();
        }
    }

    @Inject
    public SearchAdvertRepositoryImpl(@NotNull SearchApi searchApi, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull BrandspaceAdvertItemProcessor brandspaceAdvertItemProcessor) {
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(brandspaceAdvertItemProcessor, "advertProcessor");
        this.a = searchApi;
        this.b = schedulersFactory3;
        this.c = brandspaceAdvertItemProcessor;
    }

    @NotNull
    public Single<? extends List<BrandspaceItem>> getAdverts(@NotNull AdvertSource.ParametersSource parametersSource) {
        Intrinsics.checkNotNullParameter(parametersSource, "source");
        Map<String, String> extraLoadingParameters = parametersSource.getExtraLoadingParameters();
        String str = extraLoadingParameters.get("limit");
        Integer intOrNull = str != null ? l.toIntOrNull(str) : null;
        SearchApi searchApi = this.a;
        Boolean bool = Boolean.FALSE;
        Observable<TypedResult<SerpElementResult>> subscribeOn = searchApi.getSerpElementTypedResult(1, null, null, null, bool, null, extraLoadingParameters, bool).subscribeOn(this.b.io());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "searchApi.getSerpElement…scribeOn(schedulers.io())");
        Single<? extends List<BrandspaceItem>> map = TypedObservablesKt.toTyped(subscribeOn).map(new a(this, intOrNull)).firstOrError().map(b.a);
        Intrinsics.checkNotNullExpressionValue(map, "searchApi.getSerpElement…      .map { it.adverts }");
        return map;
    }
}
