package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAction;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAnalyticParams;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetSubmitParam;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0015\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0019H&¢\u0006\u0004\b\u001e\u0010\u001cJ\u0017\u0010 \u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\nH&¢\u0006\u0004\b \u0010!J!\u0010$\u001a\u00020\u00042\u0006\u0010\u001f\u001a\u00020\n2\b\u0010#\u001a\u0004\u0018\u00010\"H&¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0004H&¢\u0006\u0004\b&\u0010\u0015J\u0019\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b)\u0010*J\u0011\u0010+\u001a\u0004\u0018\u00010'H&¢\u0006\u0004\b+\u0010,¨\u0006-"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "inlineFilterDialogOpener", "", "attachDialogOpener", "(Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;)V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterView;", "view", "", "Lcom/avito/android/remote/model/search/Filter;", "initialFilters", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "action", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", "submitParams", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "analyticParams", "attachView", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterView;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;)V", "detachView", "()V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "onSaveState", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "submitEvents", "()Lio/reactivex/rxjava3/core/Observable;", "", "loadingErrors", "targetFilter", "onFilterClick", "(Lcom/avito/android/remote/model/search/Filter;)V", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "option", "onSegmentedSelect", "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;)V", "invalidate", "", "xHash", "setXHash", "(Ljava/lang/String;)V", "getXHash", "()Ljava/lang/String;", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface VerticalFilterPresenter {
    void attachDialogOpener(@NotNull InlineFilterDialogOpener inlineFilterDialogOpener);

    void attachView(@NotNull VerticalFilterView verticalFilterView, @Nullable List<Filter> list, @Nullable SearchFormWidgetAction searchFormWidgetAction, @NotNull List<SearchFormWidgetSubmitParam> list2, @Nullable SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams);

    void detachView();

    @Nullable
    String getXHash();

    void invalidate();

    @NotNull
    Observable<Throwable> loadingErrors();

    void onFilterClick(@NotNull Filter filter);

    @Nullable
    VerticalFilterState onSaveState();

    void onSegmentedSelect(@NotNull Filter filter, @Nullable Filter.InnerOptions.Options options);

    void setXHash(@Nullable String str);

    @NotNull
    Observable<DeepLink> submitEvents();
}
