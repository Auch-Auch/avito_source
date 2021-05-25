package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.vertical_main.Form;
import com.avito.android.remote.model.vertical_main.SearchFormResult;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetSubmitParam;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0013\u0010\u0014J1\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractorImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "data", "Lcom/avito/android/remote/model/search/Filter;", "appliedFilter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValues", "Lio/reactivex/rxjava3/core/Observable;", "loadVerticalSearchForm", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/SchedulersFactory3;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "searchApi", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/util/SchedulersFactory3;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterInteractorImpl implements VerticalFilterInteractor {
    public final SearchApi a;
    public final SchedulersFactory3 b;

    public static final class a<T, R> implements Function<TypedResult<SearchFormResult>, ObservableSource<? extends Form>> {
        public static final a a = new a();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Form> apply(TypedResult<SearchFormResult> typedResult) {
            TypedResult<SearchFormResult> typedResult2 = typedResult;
            if (typedResult2 instanceof TypedResult.OfResult) {
                Observable just = Observable.just(((SearchFormResult) ((TypedResult.OfResult) typedResult2).getResult()).getForm());
                Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
                return just;
            } else if (typedResult2 instanceof TypedResult.OfError) {
                return Observable.error(new Exception(((TypedResult.OfError) typedResult2).getError().getMessage()));
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
    }

    public static final class b<T, R> implements Function<Form, ObservableSource<? extends Form>> {
        public static final b a = new b();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends Form> apply(Form form) {
            Form form2 = form;
            if (form2.getFilters().isEmpty()) {
                return Observable.error(new Exception("empty filters"));
            }
            Observable just = Observable.just(form2);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            return just;
        }
    }

    public static final class c<T, R> implements Function<Form, VerticalFilterData> {
        public static final c a = new c();

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public VerticalFilterData apply(Form form) {
            Form form2 = form;
            List<Filter> filters = form2.getFilters();
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(filters, 10));
            Iterator<T> it = filters.iterator();
            while (it.hasNext()) {
                arrayList.add(new FilterData(it.next()));
            }
            return new VerticalFilterData(arrayList, form2.getAction().getTitle(), form2.getAction().getUri(), form2.getSubmitParams(), false, null, 48, null);
        }
    }

    @Inject
    public VerticalFilterInteractorImpl(@NotNull SearchApi searchApi, @NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.a = searchApi;
        this.b = schedulersFactory3;
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterInteractor
    @NotNull
    public Observable<VerticalFilterData> loadVerticalSearchForm(@NotNull VerticalFilterData verticalFilterData, @Nullable Filter filter, @Nullable InlineFilterValue inlineFilterValue) {
        LinkedHashMap linkedHashMap;
        String changedParamType;
        Integer attrId;
        Intrinsics.checkNotNullParameter(verticalFilterData, "data");
        List<SearchFormWidgetSubmitParam> submitParams = verticalFilterData.getSubmitParams();
        if (submitParams != null) {
            linkedHashMap = new LinkedHashMap();
            for (T t : submitParams) {
                linkedHashMap.put(t.getKey(), t.getValue());
            }
        } else {
            linkedHashMap = new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (!(filter == null || (attrId = filter.getAttrId()) == null)) {
            linkedHashMap2.put("changedParamId", String.valueOf(attrId.intValue()));
        }
        if (!(filter == null || (changedParamType = filter.getChangedParamType()) == null)) {
            linkedHashMap2.put("changedParamType", changedParamType);
        }
        if (inlineFilterValue != null) {
            linkedHashMap2.putAll(inlineFilterValue.changedParamsMap());
        }
        linkedHashMap.putAll(linkedHashMap2);
        Observable<R> map = this.a.getVerticalFormTypedResult(linkedHashMap).subscribeOn(this.b.io()).flatMap(a.a).flatMap(b.a).map(c.a);
        Intrinsics.checkNotNullExpressionValue(map, "searchApi.getVerticalFor…          )\n            }");
        return map;
    }
}
