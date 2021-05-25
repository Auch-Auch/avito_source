package com.avito.android.serp;

import a2.b.a.a.a;
import com.avito.android.Features;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilters;
import com.avito.android.remote.model.search.WidgetType;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import io.reactivex.rxjava3.core.Observable;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B9\b\u0007\u0012\u0006\u0010\"\u001a\u00020\u001f\u0012\u0006\u0010\u001a\u001a\u00020\u0017\u0012\u0006\u0010\u0016\u001a\u00020\u0013\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010*\u001a\u00020'\u0012\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b+\u0010,J9\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\fJ7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lcom/avito/android/serp/InlineFiltersInteractorImpl;", "Lcom/avito/android/serp/InlineFiltersInteractor;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "", "", "changesMap", "", UrlParams.SIMPLE_MAP, "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/InlineFilters;", "loadInlineFilters", "(Lcom/avito/android/remote/model/SearchParams;Ljava/util/Map;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/search/Filter;", "filter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValues", "applyInlineFilters", "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;Lcom/avito/android/remote/model/SearchParams;Z)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;", "c", "Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;", "inlineFiltersChangesParamsConverter", "Lcom/avito/android/remote/model/SearchParamsConverter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsConverter", "Lcom/avito/android/serp/InlineFiltersParametersKeyWrapper;", "d", "Lcom/avito/android/serp/InlineFiltersParametersKeyWrapper;", "keyWrapper", "Lcom/avito/android/remote/SearchApi;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/SearchApi;", "searchApi", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/util/SchedulersFactory3;", "e", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "<init>", "(Lcom/avito/android/remote/SearchApi;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/serp/InlineFiltersChangesParamsConverter;Lcom/avito/android/serp/InlineFiltersParametersKeyWrapper;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class InlineFiltersInteractorImpl implements InlineFiltersInteractor {
    public final SearchApi a;
    public final SearchParamsConverter b;
    public final InlineFiltersChangesParamsConverter c;
    public final InlineFiltersParametersKeyWrapper d;
    public final SchedulersFactory3 e;
    public final Features f;

    @Inject
    public InlineFiltersInteractorImpl(@NotNull SearchApi searchApi, @NotNull SearchParamsConverter searchParamsConverter, @NotNull InlineFiltersChangesParamsConverter inlineFiltersChangesParamsConverter, @NotNull InlineFiltersParametersKeyWrapper inlineFiltersParametersKeyWrapper, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsConverter");
        Intrinsics.checkNotNullParameter(inlineFiltersChangesParamsConverter, "inlineFiltersChangesParamsConverter");
        Intrinsics.checkNotNullParameter(inlineFiltersParametersKeyWrapper, "keyWrapper");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = searchApi;
        this.b = searchParamsConverter;
        this.c = inlineFiltersChangesParamsConverter;
        this.d = inlineFiltersParametersKeyWrapper;
        this.e = schedulersFactory3;
        this.f = features;
    }

    @Override // com.avito.android.serp.InlineFiltersInteractor
    @NotNull
    public Observable<InlineFilters> applyInlineFilters(@NotNull Filter filter, @NotNull InlineFilterValue inlineFilterValue, @Nullable SearchParams searchParams, boolean z) {
        Filter.Widget widget;
        Intrinsics.checkNotNullParameter(filter, "filter");
        Intrinsics.checkNotNullParameter(inlineFilterValue, "selectedValues");
        String id = filter.getId();
        if (id == null) {
            id = "";
        }
        Filter.Widget widget2 = filter.getWidget();
        String format = ((widget2 != null ? widget2.getType() : null) != WidgetType.Calendar || (widget = filter.getWidget()) == null) ? null : widget.getFormat();
        if (searchParams != null) {
            if (id.length() > 0) {
                return loadInlineFilters(searchParams, inlineFilterValue.queryMap(id, format), z);
            }
        }
        Observable<InlineFilters> just = Observable.just(new InlineFilters(null, null));
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(InlineFilters(null, null))");
        return just;
    }

    @Override // com.avito.android.serp.InlineFiltersInteractor
    @NotNull
    public Observable<InlineFilters> loadInlineFilters(@NotNull SearchParams searchParams, @NotNull Map<String, String> map, boolean z) {
        Observable<InlineFilters> observable;
        Intrinsics.checkNotNullParameter(searchParams, "searchParams");
        Intrinsics.checkNotNullParameter(map, "changesMap");
        Map<String, String> convertToMap$default = SearchParamsConverter.DefaultImpls.convertToMap$default(this.b, searchParams, this.d, false, z, 4, null);
        Map<String, String> convert = this.c.convert(map);
        if (this.f.getItemsSearchHeaderV3().invoke().booleanValue()) {
            observable = this.a.getInlineFilters(convertToMap$default, convert);
        } else {
            observable = this.a.getInlineFiltersV2(convertToMap$default, convert);
        }
        return a.a2(this.e, observable, "if (features.itemsSearch…scribeOn(schedulers.io())");
    }
}
