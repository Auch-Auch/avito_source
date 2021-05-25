package com.avito.android.serp.adapter.vertical_main.vertical_filter;

import a2.g.r.g;
import android.os.Parcelable;
import com.avito.android.analytics.Analytics;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.NoMatchLink;
import com.avito.android.inline_filters.dialog.InlineFilterDialogOpener;
import com.avito.android.inline_filters.dialog.InlineFiltersDialogItemConverter;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilterValueKt;
import com.avito.android.remote.model.search.NextActionType;
import com.avito.android.remote.model.search.WidgetType;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAction;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetAnalyticParams;
import com.avito.android.remote.model.vertical_main.SearchFormWidgetSubmitParam;
import com.avito.android.serp.adapter.vertical_main.analytics.SearchWidgetAction;
import com.avito.android.serp.adapter.vertical_main.analytics.VerticalMainChangeFilterWidgetEvent;
import com.avito.android.serp.adapter.vertical_main.analytics.VerticalMainSearchWidgetActionEvent;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B;\b\u0007\u0012\u0006\u0010?\u001a\u00020<\u0012\u0006\u0010i\u001a\u00020f\u0012\u0006\u0010I\u001a\u00020F\u0012\u0006\u0010S\u001a\u00020P\u0012\u0006\u0010e\u001a\u00020b\u0012\b\u0010j\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\bk\u0010lJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006JI\u0010\u0012\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\t2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0015\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u0019J\u0011\u0010\u001d\u001a\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010!\u001a\u00020\u00042\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u0011\u0010#\u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b#\u0010$J\u0017\u0010&\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\nH\u0016¢\u0006\u0004\b&\u0010'J!\u0010*\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\n2\b\u0010)\u001a\u0004\u0018\u00010(H\u0016¢\u0006\u0004\b*\u0010+J\u000f\u0010,\u001a\u00020\u0004H\u0016¢\u0006\u0004\b,\u0010\u0015J\u0017\u0010/\u001a\u00020\u00042\u0006\u0010.\u001a\u00020-H\u0002¢\u0006\u0004\b/\u00100J\u001f\u00104\u001a\u00020\u00042\u0006\u00101\u001a\u00020\n2\u0006\u00103\u001a\u000202H\u0002¢\u0006\u0004\b4\u00105J\u000f\u00106\u001a\u00020\u0004H\u0002¢\u0006\u0004\b6\u0010\u0015J\u0019\u00108\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u000207H\u0002¢\u0006\u0004\b8\u00109R\u0018\u0010 \u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u0010@RD\u0010E\u001a0\u0012\f\u0012\n B*\u0004\u0018\u00010\u001a0\u001a B*\u0017\u0012\f\u0012\n B*\u0004\u0018\u00010\u001a0\u001a\u0018\u00010A¢\u0006\u0002\bC0A¢\u0006\u0002\bC8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010DR\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HRD\u0010J\u001a0\u0012\f\u0012\n B*\u0004\u0018\u00010\u00170\u0017 B*\u0017\u0012\f\u0012\n B*\u0004\u0018\u00010\u00170\u0017\u0018\u00010A¢\u0006\u0002\bC0A¢\u0006\u0002\bC8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010DR(\u0010O\u001a\u0014\u0012\u0004\u0012\u00020\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0\t0K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010S\u001a\u00020P8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010RR\u0018\u0010W\u001a\u0004\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bU\u0010VR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0018\u0010]\u001a\u0004\u0018\u00010Z8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010.\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u0010aR\u0016\u0010e\u001a\u00020b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010i\u001a\u00020f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bg\u0010h¨\u0006m"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenterImpl;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterPresenter;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "inlineFilterDialogOpener", "", "attachDialogOpener", "(Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;)V", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterView;", "view", "", "Lcom/avito/android/remote/model/search/Filter;", "initialFilters", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;", "action", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetSubmitParam;", "submitParams", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "analyticParams", "attachView", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterView;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAction;Ljava/util/List;Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;)V", "detachView", "()V", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/deep_linking/links/DeepLink;", "submitEvents", "()Lio/reactivex/rxjava3/core/Observable;", "", "loadingErrors", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "onSaveState", "()Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;", "", "xHash", "setXHash", "(Ljava/lang/String;)V", "getXHash", "()Ljava/lang/String;", "targetFilter", "onFilterClick", "(Lcom/avito/android/remote/model/search/Filter;)V", "Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;", "option", "onSegmentedSelect", "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/Filter$InnerOptions$Options;)V", "invalidate", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;", "filterData", AuthSource.SEND_ABUSE, "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/FilterData;)V", "filter", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "selectedValue", "c", "(Lcom/avito/android/remote/model/search/Filter;Lcom/avito/android/remote/model/search/InlineFilterValue;)V", "d", "Lcom/avito/android/serp/adapter/vertical_main/analytics/SearchWidgetAction;", AuthSource.BOOKING_ORDER, "(Lcom/avito/android/serp/adapter/vertical_main/analytics/SearchWidgetAction;)V", "i", "Ljava/lang/String;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "k", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;", "verticalFilterInteractor", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialogOpener;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/PublishRelay;", "errorsRelay", "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;", "inlineFiltersDialogItemConverter", "submitRelay", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "f", "Ljava/util/Map;", "convertedItems", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "n", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;", "resourceProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", "e", "Lio/reactivex/rxjava3/disposables/Disposable;", "filterSubscription", "j", "Lcom/avito/android/remote/model/vertical_main/SearchFormWidgetAnalyticParams;", "Landroid/os/Parcelable;", "h", "Landroid/os/Parcelable;", "dialogState", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", g.a, "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterData;", "Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterView;", "Lcom/avito/android/util/SchedulersFactory3;", "o", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/analytics/Analytics;", "l", "Lcom/avito/android/analytics/Analytics;", "analytics", "state", "<init>", "(Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterInteractor;Lcom/avito/android/analytics/Analytics;Lcom/avito/android/inline_filters/dialog/InlineFiltersDialogItemConverter;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalSearchFilterResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/VerticalFilterState;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class VerticalFilterPresenterImpl implements VerticalFilterPresenter {
    public final PublishRelay<DeepLink> a = PublishRelay.create();
    public final PublishRelay<Throwable> b = PublishRelay.create();
    public InlineFilterDialogOpener c;
    public VerticalFilterView d;
    public Disposable e;
    public final Map<String, List<InlineFiltersDialogItem>> f = new HashMap();
    public VerticalFilterData g;
    public Parcelable h;
    public String i;
    public SearchFormWidgetAnalyticParams j;
    public final VerticalFilterInteractor k;
    public final Analytics l;
    public final InlineFiltersDialogItemConverter m;
    public final VerticalSearchFilterResourceProvider n;
    public final SchedulersFactory3 o;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            NextActionType.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            NextActionType nextActionType = NextActionType.FocusField;
            iArr[1] = 1;
            NextActionType nextActionType2 = NextActionType.Autocomplete;
            iArr[0] = 2;
            WidgetType.values();
            int[] iArr2 = new int[7];
            $EnumSwitchMapping$1 = iArr2;
            WidgetType widgetType = WidgetType.Multiselect;
            iArr2[2] = 1;
            WidgetType widgetType2 = WidgetType.Segmented;
            iArr2[6] = 2;
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj) {
            super(0);
            this.a = i;
            this.b = obj;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i != 0) {
                VerticalFilterData verticalFilterData = null;
                if (i == 1) {
                    VerticalFilterPresenterImpl verticalFilterPresenterImpl = (VerticalFilterPresenterImpl) this.b;
                    VerticalFilterData verticalFilterData2 = verticalFilterPresenterImpl.g;
                    if (verticalFilterData2 != null) {
                        verticalFilterData = VerticalFilterData.copy$default(verticalFilterData2, null, null, null, null, false, null, 31, null);
                    }
                    verticalFilterPresenterImpl.g = verticalFilterData;
                    ((VerticalFilterPresenterImpl) this.b).d();
                    return Unit.INSTANCE;
                }
                throw null;
            }
            ((Function0) this.b).invoke();
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<InlineFilterValue, Unit> {
        public final /* synthetic */ VerticalFilterPresenterImpl a;
        public final /* synthetic */ Filter b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(VerticalFilterPresenterImpl verticalFilterPresenterImpl, Filter filter) {
            super(1);
            this.a = verticalFilterPresenterImpl;
            this.b = filter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(InlineFilterValue inlineFilterValue) {
            InlineFilterValue inlineFilterValue2 = inlineFilterValue;
            Intrinsics.checkNotNullParameter(inlineFilterValue2, "selectedValue");
            this.a.c(this.b, inlineFilterValue2);
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ VerticalFilterPresenterImpl a;
        public final /* synthetic */ InlineFilterValue b;
        public final /* synthetic */ Filter c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(VerticalFilterPresenterImpl verticalFilterPresenterImpl, InlineFilterValue inlineFilterValue, Filter filter) {
            super(0);
            this.a = verticalFilterPresenterImpl;
            this.b = inlineFilterValue;
            this.c = filter;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            NextActionType access$nexActionType;
            Filter.Widget widget;
            Filter.Config config;
            Filter.NextAction nextAction;
            String focusField;
            VerticalFilterData verticalFilterData;
            List<FilterData> filters;
            String str;
            if (InlineFilterValueKt.isNotEmpty(this.b) && (access$nexActionType = VerticalFilterPresenterKt.access$nexActionType(this.c)) != null) {
                int ordinal = access$nexActionType.ordinal();
                if (ordinal == 0) {
                    this.a.b(SearchWidgetAction.AUTO);
                } else if (!(ordinal != 1 || (widget = this.c.getWidget()) == null || (config = widget.getConfig()) == null || (nextAction = config.getNextAction()) == null || (focusField = nextAction.getFocusField()) == null || (verticalFilterData = this.a.g) == null || (filters = verticalFilterData.getFilters()) == null)) {
                    Iterator<T> it = filters.iterator();
                    while (true) {
                        str = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        Filter paramFilter = next.getParamFilter();
                        if (paramFilter != null) {
                            str = paramFilter.getId();
                        }
                        if (Intrinsics.areEqual(str, focusField)) {
                            str = next;
                            break;
                        }
                    }
                    FilterData filterData = (FilterData) str;
                    if (filterData != null) {
                        this.a.a(filterData);
                    }
                }
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public VerticalFilterPresenterImpl(@NotNull VerticalFilterInteractor verticalFilterInteractor, @NotNull Analytics analytics, @NotNull InlineFiltersDialogItemConverter inlineFiltersDialogItemConverter, @NotNull VerticalSearchFilterResourceProvider verticalSearchFilterResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @Nullable VerticalFilterState verticalFilterState) {
        Intrinsics.checkNotNullParameter(verticalFilterInteractor, "verticalFilterInteractor");
        Intrinsics.checkNotNullParameter(analytics, "analytics");
        Intrinsics.checkNotNullParameter(inlineFiltersDialogItemConverter, "inlineFiltersDialogItemConverter");
        Intrinsics.checkNotNullParameter(verticalSearchFilterResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        this.k = verticalFilterInteractor;
        this.l = analytics;
        this.m = inlineFiltersDialogItemConverter;
        this.n = verticalSearchFilterResourceProvider;
        this.o = schedulersFactory3;
        String str = null;
        this.g = verticalFilterState != null ? verticalFilterState.getData() : null;
        this.h = verticalFilterState != null ? verticalFilterState.getDialogState() : null;
        this.i = verticalFilterState != null ? verticalFilterState.getXHash() : str;
    }

    public final void a(FilterData filterData) {
        Filter paramFilter = filterData.getParamFilter();
        if (paramFilter != null) {
            VerticalFilterData verticalFilterData = this.g;
            this.g = verticalFilterData != null ? VerticalFilterData.copy$default(verticalFilterData, null, null, null, null, false, filterData, 31, null) : null;
            a aVar = new a(1, this);
            InlineFilterDialogOpener inlineFilterDialogOpener = this.c;
            if (inlineFilterDialogOpener != null) {
                List<InlineFiltersDialogItem> list = this.f.get(paramFilter.getId());
                if (list == null) {
                    list = this.m.convertItems(paramFilter);
                }
                inlineFilterDialogOpener.show(paramFilter, list, this.h, new b(this, paramFilter), aVar, new a(0, aVar));
            }
        }
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void attachDialogOpener(@NotNull InlineFilterDialogOpener inlineFilterDialogOpener) {
        FilterData openedFilter;
        Intrinsics.checkNotNullParameter(inlineFilterDialogOpener, "inlineFilterDialogOpener");
        this.c = inlineFilterDialogOpener;
        VerticalFilterData verticalFilterData = this.g;
        if (verticalFilterData != null && (openedFilter = verticalFilterData.getOpenedFilter()) != null) {
            a(openedFilter);
            this.h = null;
        }
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void attachView(@NotNull VerticalFilterView verticalFilterView, @Nullable List<Filter> list, @Nullable SearchFormWidgetAction searchFormWidgetAction, @NotNull List<SearchFormWidgetSubmitParam> list2, @Nullable SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams) {
        VerticalFilterData verticalFilterData;
        DeepLink deepLink;
        List<FilterData> filters;
        Intrinsics.checkNotNullParameter(verticalFilterView, "view");
        Intrinsics.checkNotNullParameter(list2, "submitParams");
        this.d = verticalFilterView;
        this.j = searchFormWidgetAnalyticParams;
        if (verticalFilterView != null) {
            verticalFilterView.setSubmitListener(new a2.a.a.n2.w.d.a.a(this));
        }
        if (list != null && ((verticalFilterData = this.g) == null || !(verticalFilterData == null || (filters = verticalFilterData.getFilters()) == null || !filters.isEmpty()))) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new FilterData(it.next()));
            }
            String title = searchFormWidgetAction != null ? searchFormWidgetAction.getTitle() : null;
            if (searchFormWidgetAction == null || (deepLink = searchFormWidgetAction.getUri()) == null) {
                deepLink = new NoMatchLink();
            }
            this.g = new VerticalFilterData(arrayList, title, deepLink, list2, false, null, 48, null);
        }
        d();
    }

    public final void b(SearchWidgetAction searchWidgetAction) {
        VerticalFilterData verticalFilterData = this.g;
        if (verticalFilterData != null) {
            this.a.accept(verticalFilterData.getButtonLink());
            Analytics analytics = this.l;
            SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams = this.j;
            String str = null;
            String categoryId = searchFormWidgetAnalyticParams != null ? searchFormWidgetAnalyticParams.getCategoryId() : null;
            SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams2 = this.j;
            if (searchFormWidgetAnalyticParams2 != null) {
                str = searchFormWidgetAnalyticParams2.getFormRawParams();
            }
            analytics.track(new VerticalMainSearchWidgetActionEvent(categoryId, str, searchWidgetAction));
        }
    }

    public final void c(Filter filter, InlineFilterValue inlineFilterValue) {
        Analytics analytics = this.l;
        SearchFormWidgetAnalyticParams searchFormWidgetAnalyticParams = this.j;
        analytics.track(new VerticalMainChangeFilterWidgetEvent(searchFormWidgetAnalyticParams != null ? searchFormWidgetAnalyticParams.getCategoryId() : null, filter.getId(), inlineFilterValue.toStringList()));
        c cVar = new c(this, inlineFilterValue, filter);
        VerticalFilterData verticalFilterData = this.g;
        if (verticalFilterData != null) {
            Disposable disposable = this.e;
            if (disposable != null) {
                disposable.dispose();
            }
            VerticalFilterView verticalFilterView = this.d;
            if (verticalFilterView != null) {
                verticalFilterView.setSubmitState(false, true, null);
            }
            this.e = this.k.loadVerticalSearchForm(verticalFilterData, filter, inlineFilterValue).observeOn(this.o.mainThread()).subscribe(new a2.a.a.n2.w.d.a.b(this, cVar), new a2.a.a.n2.w.d.a.c(this));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00a3 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() {
        /*
        // Method dump skipped, instructions count: 294
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenterImpl.d():void");
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void detachView() {
        this.d = null;
        InlineFilterDialogOpener inlineFilterDialogOpener = this.c;
        if (inlineFilterDialogOpener != null) {
            inlineFilterDialogOpener.dismiss();
        }
        this.c = null;
        Disposable disposable = this.e;
        if (disposable != null) {
            disposable.dispose();
        }
        this.e = null;
        this.g = null;
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    @Nullable
    public String getXHash() {
        return this.i;
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void invalidate() {
        this.g = null;
        this.h = null;
        this.j = null;
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    @NotNull
    public Observable<Throwable> loadingErrors() {
        Observable<Throwable> hide = this.b.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "errorsRelay.hide()");
        return hide;
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void onFilterClick(@NotNull Filter filter) {
        Intrinsics.checkNotNullParameter(filter, "targetFilter");
        a(new FilterData(filter));
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    @Nullable
    public VerticalFilterState onSaveState() {
        VerticalFilterData verticalFilterData = this.g;
        Parcelable parcelable = null;
        if (verticalFilterData == null) {
            return null;
        }
        InlineFilterDialogOpener inlineFilterDialogOpener = this.c;
        if (inlineFilterDialogOpener != null) {
            parcelable = inlineFilterDialogOpener.onSaveState();
        }
        return new VerticalFilterState(verticalFilterData, parcelable, this.i);
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void onSegmentedSelect(@NotNull Filter filter, @Nullable Filter.InnerOptions.Options options) {
        Intrinsics.checkNotNullParameter(filter, "targetFilter");
        c(filter, new InlineFilterValue.InlineFilterSelectValue(options != null ? options.getId() : null));
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    public void setXHash(@Nullable String str) {
    }

    @Override // com.avito.android.serp.adapter.vertical_main.vertical_filter.VerticalFilterPresenter
    @NotNull
    public Observable<DeepLink> submitEvents() {
        Observable<DeepLink> hide = this.a.hide();
        Intrinsics.checkNotNullExpressionValue(hide, "submitRelay.hide()");
        return hide;
    }
}
