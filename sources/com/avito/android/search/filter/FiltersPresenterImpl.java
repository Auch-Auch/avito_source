package com.avito.android.search.filter;

import a2.a.a.k2.a.a0;
import a2.a.a.k2.a.u;
import a2.a.a.k2.a.v;
import a2.a.a.k2.a.x;
import a2.a.a.k2.a.y;
import a2.a.a.k2.a.z;
import a2.g.r.g;
import com.avito.android.Features;
import com.avito.android.ab_tests.AutoGenerationsFilterWithPhotos;
import com.avito.android.ab_tests.groups.SimpleTestGroup;
import com.avito.android.ab_tests.models.SingleManuallyExposedAbTestGroup;
import com.avito.android.analytics.screens.ScreenPublicConstsKt;
import com.avito.android.category_parameters.CategoryParametersElementConverter;
import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.items.SelectableItem;
import com.avito.android.location.LocationSource;
import com.avito.android.location.SavedLocationInteractor;
import com.avito.android.recycler.data_aware.DataAwareAdapterPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.ErrorWithMessage;
import com.avito.android.remote.error.TypedError;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.Metro;
import com.avito.android.remote.model.ParcelableEntity;
import com.avito.android.remote.model.Quarter;
import com.avito.android.remote.model.QuarterKt;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.remote.model.SerpDisplayTypeKt;
import com.avito.android.remote.model.category_parameters.DateRangeParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.MetroParameter;
import com.avito.android.remote.model.category_parameters.MultiselectParameter;
import com.avito.android.remote.model.category_parameters.QuartersParameter;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectCategoryParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.SortDirection;
import com.avito.android.remote.model.category_parameters.base.EditableParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.search.filter.FiltersInteractor;
import com.avito.android.search.filter.FiltersPresenter;
import com.avito.android.search.filter.FiltersPresenterImpl;
import com.avito.android.search.filter.analytics.FilterAnalyticsInteractor;
import com.avito.android.search.filter.di.FiltersModule;
import com.avito.android.search.filter.tracker.FiltersTracker;
import com.avito.android.select.Arguments;
import com.avito.android.select.SelectParameterLocalSorter;
import com.avito.android.select.SelectParameterLocalSorterImpl;
import com.avito.android.select.new_metro.analytics.SelectMetroAnalytics;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.SchedulersFactory3;
import com.avito.conveyor_item.Item;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.data_source.IterableDataSource;
import com.avito.konveyor.data_source.ListDataSource;
import com.avito.konveyor.util.DataSources;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import io.reactivex.rxjava3.kotlin.SubscribersKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.d;
import t6.n.e;
import t6.o.a;
import t6.y.l;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ª\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B£\u0001\b\u0007\u0012\b\u0010¤\u0001\u001a\u00030\u0001\u0012\b\u0010¦\u0001\u001a\u00030¥\u0001\u0012\u0006\u0010l\u001a\u00020i\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010N\u001a\u00020K\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0006\u0010p\u001a\u00020m\u0012\u0006\u0010d\u001a\u00020a\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\t\b\u0001\u0010§\u0001\u001a\u00020\f\u0012\u000b\b\u0001\u0010¨\u0001\u001a\u0004\u0018\u00010<\u0012\t\b\u0001\u0010\u0001\u001a\u00020\f\u0012\u0011\b\u0001\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001\u0012\u0006\u0010R\u001a\u00020O\u0012\u0006\u0010V\u001a\u00020S¢\u0006\u0006\b©\u0001\u0010ª\u0001J5\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000f\u001a\u00020\u000e*\u00020\u000b2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J-\u0010\u0015\u001a\u00020\u000e2\u001c\b\u0002\u0010\u0014\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0012\u0004\u0012\u00020\b\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001b\u0010!\u001a\u00020\b2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u001fH\u0002¢\u0006\u0004\b!\u0010\"J#\u0010&\u001a\u00020\b2\b\u0010$\u001a\u0004\u0018\u00010#2\b\u0010%\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0004\b&\u0010'J\u0017\u0010)\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u000bH\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\bH\u0016¢\u0006\u0004\b+\u0010,J5\u0010-\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00050\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b-\u0010\nJ\u0019\u00100\u001a\u00020\b2\b\u0010/\u001a\u0004\u0018\u00010.H\u0016¢\u0006\u0004\b0\u00101J\u0019\u00104\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u000102H\u0016¢\u0006\u0004\b4\u00105J\u001f\u00106\u001a\u00020\b2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0016¢\u0006\u0004\b6\u0010'J\u0017\u00109\u001a\u00020\b2\u0006\u00108\u001a\u000207H\u0016¢\u0006\u0004\b9\u0010:J\u000f\u0010;\u001a\u00020\bH\u0016¢\u0006\u0004\b;\u0010,J\u000f\u0010=\u001a\u00020<H\u0016¢\u0006\u0004\b=\u0010>J\u000f\u0010?\u001a\u00020\bH\u0016¢\u0006\u0004\b?\u0010,J\u000f\u0010@\u001a\u00020\bH\u0016¢\u0006\u0004\b@\u0010,J\u000f\u0010A\u001a\u00020\bH\u0004¢\u0006\u0004\bA\u0010,J\u0017\u0010C\u001a\u00020\b2\u0006\u0010B\u001a\u00020\u0013H\u0014¢\u0006\u0004\bC\u0010DJ/\u0010I\u001a\u00020\b2\u001e\u0010H\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020F0\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00040EH\u0014¢\u0006\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bL\u0010MR\u0016\u0010R\u001a\u00020O8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010Z\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010YR\u0016\u0010\\\u001a\u00020W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b[\u0010YR\u001e\u0010`\u001a\n\u0012\u0004\u0012\u00020F\u0018\u00010]8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR$\u0010(\u001a\u0004\u0018\u00010\u000b8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010*R\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR$\u0010z\u001a\u0004\u0018\u00010\u000e8\u0004@\u0004X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010u\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u001e\u0010~\u001a\n\u0012\u0006\b\u0001\u0012\u00020|0{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010}R\u0019\u0010B\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0010\u0001R\u001f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020F0{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010}R\u0019\u00108\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b!\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010uR\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001f\u0010\u0001\u001a\n\u0012\u0006\b\u0001\u0012\u00020|0{8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010}R\u0019\u0010\u0001\u001a\u00020\f8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\f8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\u0007\n\u0005\b\u000f\u0010\u0001R!\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010¤\u0001\u001a\u00030\u00018\u0004@\u0004X\u0004¢\u0006\u0010\n\u0006\b \u0001\u0010¡\u0001\u001a\u0006\b¢\u0001\u0010£\u0001¨\u0006«\u0001"}, d2 = {"Lcom/avito/android/search/filter/FiltersPresenterImpl;", "Lcom/avito/android/search/filter/FiltersPresenter;", "", "id", "", "Lcom/avito/android/remote/model/ParcelableEntity;", "selection", "sectionTitle", "", AuthSource.BOOKING_ORDER, "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "Lcom/avito/android/search/filter/FiltersView;", "", "skipCurrentState", "Lio/reactivex/rxjava3/disposables/Disposable;", "f", "(Lcom/avito/android/search/filter/FiltersView;Z)Lio/reactivex/rxjava3/disposables/Disposable;", "Lkotlin/Function1;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "additionalOnNext", g.a, "(Lkotlin/jvm/functions/Function1;)Lio/reactivex/rxjava3/disposables/Disposable;", "Lcom/avito/android/remote/model/category_parameters/SelectParameter;", "parameter", "Lcom/avito/android/select/Arguments;", "d", "(Lcom/avito/android/remote/model/category_parameters/SelectParameter;)Lcom/avito/android/select/Arguments;", "Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;", "c", "(Lcom/avito/android/remote/model/category_parameters/MultiselectParameter;)Lcom/avito/android/select/Arguments;", "Lcom/avito/android/remote/error/TypedError;", "error", "e", "(Lcom/avito/android/remote/error/TypedError;)V", "Ljava/util/Date;", "checkInDate", "checkOutDate", AuthSource.SEND_ABUSE, "(Ljava/util/Date;Ljava/util/Date;)V", "view", "attachView", "(Lcom/avito/android/search/filter/FiltersView;)V", "detachView", "()V", "onSelected", "Lcom/avito/android/remote/model/Location;", "location", "onLocationChanged", "(Lcom/avito/android/remote/model/Location;)V", "Lcom/avito/android/remote/model/SearchRadius;", "radius", "onSearchRadiusChanged", "(Lcom/avito/android/remote/model/SearchRadius;)V", "onDatesSelected", "Lcom/avito/android/search/filter/FiltersPresenter$Router;", "router", "attachRouter", "(Lcom/avito/android/search/filter/FiltersPresenter$Router;)V", "detachRouter", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "onBackPressed", "retry", "showResults", ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT, "onParametersLoaded", "(Lcom/avito/android/search/filter/ParametersTreeWithAdditional;)V", "Lkotlin/Pair;", "Lcom/avito/conveyor_item/Item;", "Lkotlin/ranges/IntRange;", "itemsAndGroups", "applyGroupBoundsOrDividers", "(Lkotlin/Pair;)V", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "r", "Lcom/avito/android/search/filter/FiltersResourceProvider;", "resourceProvider", "Lcom/avito/android/location/SavedLocationInteractor;", "y", "Lcom/avito/android/location/SavedLocationInteractor;", "savedLocationInteractor", "Lcom/avito/android/Features;", "z", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/remote/model/SerpDisplayType;", "l", "Lcom/avito/android/remote/model/SerpDisplayType;", "initialDisplayType", "j", "displayType", "Lcom/avito/konveyor/data_source/DataSource;", "k", "Lcom/avito/konveyor/data_source/DataSource;", "itemsDataSource", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "u", "Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;", "selectMetroAnalytics", "Lcom/avito/android/search/filter/FiltersView;", "getView", "()Lcom/avito/android/search/filter/FiltersView;", "setView", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "p", "Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;", "adapterPresenter", "Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "t", "Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;", "filterAnalyticsInteractor", "Lcom/avito/android/select/SelectParameterLocalSorter;", "n", "Lcom/avito/android/select/SelectParameterLocalSorter;", "selectParameterLocalSorter", "Lio/reactivex/rxjava3/disposables/Disposable;", "getParametersTreeDisposable", "()Lio/reactivex/rxjava3/disposables/Disposable;", "setParametersTreeDisposable", "(Lio/reactivex/rxjava3/disposables/Disposable;)V", "parametersTreeDisposable", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/category_parameters/ParameterElement;", "Lio/reactivex/rxjava3/core/Observable;", "clearObservable", "i", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "changeObservable", "Lcom/avito/android/search/filter/FiltersPresenter$Router;", "Lcom/avito/android/util/SchedulersFactory3;", "s", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "h", "counterButtonDisposable", "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", VKApiConst.Q, "Lcom/avito/android/category_parameters/CategoryParametersElementConverter;", "itemConverter", "clickObservable", "w", "Z", "isOnlySortShown", AuthSource.OPEN_CHANNEL_LIST, "displayTypeChanged", "Lcom/avito/android/search/filter/tracker/FiltersTracker;", VKApiConst.VERSION, "Lcom/avito/android/search/filter/tracker/FiltersTracker;", "tracker", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposables", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroup;", "x", "Lcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;", "filterWithPhotosGroup", "Lcom/avito/android/search/filter/FiltersInteractor;", "o", "Lcom/avito/android/search/filter/FiltersInteractor;", "getInteractor", "()Lcom/avito/android/search/filter/FiltersInteractor;", "interactor", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "isFirstStart", "state", "<init>", "(Lcom/avito/android/search/filter/FiltersInteractor;Lcom/avito/android/search/filter/FiltersChangeProvider;Lcom/avito/android/recycler/data_aware/DataAwareAdapterPresenter;Lcom/avito/android/category_parameters/CategoryParametersElementConverter;Lcom/avito/android/search/filter/FiltersResourceProvider;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/search/filter/analytics/FilterAnalyticsInteractor;Lcom/avito/android/select/new_metro/analytics/SelectMetroAnalytics;Lcom/avito/android/search/filter/tracker/FiltersTracker;ZLcom/avito/android/util/Kundle;ZLcom/avito/android/ab_tests/models/SingleManuallyExposedAbTestGroup;Lcom/avito/android/location/SavedLocationInteractor;Lcom/avito/android/Features;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public class FiltersPresenterImpl implements FiltersPresenter {
    public final Observable<? extends Item> a;
    public final Observable<? extends ParameterElement> b;
    public final Observable<? extends ParameterElement> c;
    @Nullable
    public FiltersView d;
    public FiltersPresenter.Router e;
    public final CompositeDisposable f;
    @Nullable
    public Disposable g;
    public Disposable h;
    public ParametersTreeWithAdditional i;
    public SerpDisplayType j;
    public DataSource<Item> k;
    public SerpDisplayType l;
    public boolean m;
    public final SelectParameterLocalSorter n;
    @NotNull
    public final FiltersInteractor o;
    public final DataAwareAdapterPresenter p;
    public final CategoryParametersElementConverter q;
    public final FiltersResourceProvider r;
    public final SchedulersFactory3 s;
    public final FilterAnalyticsInteractor t;
    public final SelectMetroAnalytics u;
    public final FiltersTracker v;
    public final boolean w;
    public final SingleManuallyExposedAbTestGroup<SimpleTestGroup> x;
    public final SavedLocationInteractor y;
    public final Features z;

    public static final class a extends Lambda implements Function1<LoadingState<? super CounterButton>, Unit> {
        public final /* synthetic */ FiltersPresenterImpl a;
        public final /* synthetic */ FiltersView b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FiltersPresenterImpl filtersPresenterImpl, FiltersView filtersView) {
            super(1);
            this.a = filtersPresenterImpl;
            this.b = filtersView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(LoadingState<? super CounterButton> loadingState) {
            LoadingState<? super CounterButton> loadingState2 = loadingState;
            if (loadingState2 instanceof LoadingState.Loading) {
                this.b.setShowButtonEnabled(false);
                this.b.showLiveSearchProgress();
            } else if (loadingState2 instanceof LoadingState.Loaded) {
                LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState2;
                FiltersPresenterImpl.access$updateButtonTitleAndEnabled(this.a, ((CounterButton) loaded.getData()).getTitle(), ((CounterButton) loaded.getData()).getEnabled());
                this.b.hideLiveSearchProgress();
            } else if (loadingState2 instanceof LoadingState.Error) {
                FiltersPresenterImpl.access$updateButtonTitleAndEnabled(this.a, null, Boolean.TRUE);
                this.b.hideLiveSearchProgress();
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super ParametersTreeWithAdditional>> {
        public final /* synthetic */ FiltersPresenterImpl a;
        public final /* synthetic */ Function1 b;

        public b(FiltersPresenterImpl filtersPresenterImpl, Function1 function1) {
            this.a = filtersPresenterImpl;
            this.b = function1;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
            LoadingState<? super ParametersTreeWithAdditional> loadingState2 = loadingState;
            FiltersPresenterImpl filtersPresenterImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState2, "it");
            FiltersPresenterImpl.access$onParametersTreeLoadingStateChanged(filtersPresenterImpl, loadingState2);
            Function1 function1 = this.b;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(loadingState2);
            }
        }
    }

    public static final class c<T> implements Consumer<Throwable> {
        public final /* synthetic */ FiltersPresenterImpl a;

        public c(FiltersPresenterImpl filtersPresenterImpl) {
            this.a = filtersPresenterImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            this.a.e(null);
        }
    }

    @Inject
    public FiltersPresenterImpl(@NotNull FiltersInteractor filtersInteractor, @NotNull FiltersChangeProvider filtersChangeProvider, @NotNull DataAwareAdapterPresenter dataAwareAdapterPresenter, @NotNull CategoryParametersElementConverter categoryParametersElementConverter, @NotNull FiltersResourceProvider filtersResourceProvider, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull FilterAnalyticsInteractor filterAnalyticsInteractor, @NotNull SelectMetroAnalytics selectMetroAnalytics, @NotNull FiltersTracker filtersTracker, @FiltersModule.IsFirstStart boolean z2, @FiltersModule.PresenterState @Nullable Kundle kundle, @FiltersModule.IsOnlySortShown boolean z3, @AutoGenerationsFilterWithPhotos @NotNull SingleManuallyExposedAbTestGroup<SimpleTestGroup> singleManuallyExposedAbTestGroup, @NotNull SavedLocationInteractor savedLocationInteractor, @NotNull Features features) {
        Boolean bool;
        String string;
        Intrinsics.checkNotNullParameter(filtersInteractor, "interactor");
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        Intrinsics.checkNotNullParameter(dataAwareAdapterPresenter, "adapterPresenter");
        Intrinsics.checkNotNullParameter(categoryParametersElementConverter, "itemConverter");
        Intrinsics.checkNotNullParameter(filtersResourceProvider, "resourceProvider");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(filterAnalyticsInteractor, "filterAnalyticsInteractor");
        Intrinsics.checkNotNullParameter(selectMetroAnalytics, "selectMetroAnalytics");
        Intrinsics.checkNotNullParameter(filtersTracker, "tracker");
        Intrinsics.checkNotNullParameter(singleManuallyExposedAbTestGroup, "filterWithPhotosGroup");
        Intrinsics.checkNotNullParameter(savedLocationInteractor, "savedLocationInteractor");
        Intrinsics.checkNotNullParameter(features, "features");
        this.o = filtersInteractor;
        this.p = dataAwareAdapterPresenter;
        this.q = categoryParametersElementConverter;
        this.r = filtersResourceProvider;
        this.s = schedulersFactory3;
        this.t = filterAnalyticsInteractor;
        this.u = selectMetroAnalytics;
        this.v = filtersTracker;
        this.w = z3;
        this.x = singleManuallyExposedAbTestGroup;
        this.y = savedLocationInteractor;
        this.z = features;
        if (z2) {
            filterAnalyticsInteractor.sendStartEvent();
        }
        this.a = filtersChangeProvider.getChangeObservable();
        this.b = filtersChangeProvider.getClickObservable();
        this.c = filtersChangeProvider.getClearObservable();
        this.f = new CompositeDisposable();
        SerpDisplayType serpDisplayType = null;
        this.i = kundle != null ? (ParametersTreeWithAdditional) kundle.getParcelable("parameters_tree") : null;
        this.j = SerpDisplayTypeKt.orDefault(kundle != null ? SerpDisplayType.valueOf(kundle.getString("display_type", SerpDisplayType.List.name())) : null);
        if (!(kundle == null || (string = kundle.getString("display_type_initial")) == null)) {
            serpDisplayType = SerpDisplayType.valueOf(string);
        }
        this.l = serpDisplayType;
        this.m = (kundle == null || (bool = kundle.getBoolean("display_type_changed")) == null) ? false : bool.booleanValue();
        this.n = new SelectParameterLocalSorterImpl();
    }

    public static final void access$closeScreen(FiltersPresenterImpl filtersPresenterImpl) {
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        FiltersPresenter.Router router = filtersPresenterImpl.e;
        if (router != null) {
            router.closeScreen();
        }
    }

    public static final String access$filterNumbersOnly(FiltersPresenterImpl filtersPresenterImpl, String str) {
        Objects.requireNonNull(filtersPresenterImpl);
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "filterTo(StringBuilder(), predicate).toString()");
        return sb2;
    }

    public static final String access$getCategoryId(FiltersPresenterImpl filtersPresenterImpl) {
        SelectCategoryParameter selectCategoryParameter;
        Category category;
        ParametersTreeWithAdditional parametersTreeWithAdditional = filtersPresenterImpl.i;
        String id = (parametersTreeWithAdditional == null || (selectCategoryParameter = (SelectCategoryParameter) parametersTreeWithAdditional.getFirstParameterOfType(SelectCategoryParameter.class)) == null || (category = (Category) selectCategoryParameter.getValue()) == null) ? null : category.getId();
        return id != null ? id : "";
    }

    public static final void access$onMultiselectClicked(FiltersPresenterImpl filtersPresenterImpl, ParameterElement.Multiselect multiselect, MultiselectParameter multiselectParameter) {
        Objects.requireNonNull(filtersPresenterImpl);
        if (multiselect.isDialog()) {
            FiltersView filtersView = filtersPresenterImpl.d;
            if (filtersView != null) {
                filtersView.hideKeyboard();
            }
            FiltersPresenter.Router router = filtersPresenterImpl.e;
            if (router != null) {
                router.showMultiselectDialog(multiselect);
            }
        } else if (multiselect.isGroupSelect()) {
            FiltersView filtersView2 = filtersPresenterImpl.d;
            if (filtersView2 != null) {
                filtersView2.hideKeyboard();
            }
            FiltersPresenter.Router router2 = filtersPresenterImpl.e;
            if (router2 != null) {
                router2.showGroupSelectDialog(multiselect);
            }
        } else if (!multiselect.isBottomSheet() || !filtersPresenterImpl.z.getSelectFiltersInBottomSheet().invoke().booleanValue()) {
            Arguments c2 = filtersPresenterImpl.c(multiselectParameter);
            FiltersView filtersView3 = filtersPresenterImpl.d;
            if (filtersView3 != null) {
                filtersView3.hideKeyboard();
            }
            FiltersPresenter.Router router3 = filtersPresenterImpl.e;
            if (router3 != null) {
                router3.showSelectScreen(c2);
            }
        } else {
            Arguments c3 = filtersPresenterImpl.c(multiselectParameter);
            FiltersView filtersView4 = filtersPresenterImpl.d;
            if (filtersView4 != null) {
                filtersView4.hideKeyboard();
            }
            FiltersPresenter.Router router4 = filtersPresenterImpl.e;
            if (router4 != null) {
                router4.showSelectBottomSheet(c3);
            }
        }
    }

    public static final void access$onParameterClearClicked(FiltersPresenterImpl filtersPresenterImpl, ParameterElement parameterElement) {
        ParametersTreeWithAdditional parametersTreeWithAdditional = filtersPresenterImpl.i;
        Integer num = null;
        ParameterSlot findParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findParameter(parameterElement.getStringId()) : null;
        if (findParameter instanceof DateRangeParameter) {
            filtersPresenterImpl.a(null, null);
        } else if (findParameter instanceof EditableParameter) {
            if (!(findParameter instanceof SelectParameter) || !Intrinsics.areEqual(parameterElement.getStringId(), ParameterId.CATEGORIES)) {
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersPresenterImpl.o, (EditableParameter) findParameter, null, false, 4, null);
            } else {
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersPresenterImpl.o, (EditableParameter) findParameter, "0", false, 4, null);
            }
        } else if (findParameter instanceof MetroParameter) {
            SearchParams searchParamsOrEmpty = filtersPresenterImpl.o.getSearchParamsOrEmpty();
            String categoryId = searchParamsOrEmpty.getCategoryId();
            Integer intOrNull = categoryId != null ? l.toIntOrNull(categoryId) : null;
            String locationId = searchParamsOrEmpty.getLocationId();
            if (locationId != null) {
                num = l.toIntOrNull(locationId);
            }
            if (num != null) {
                filtersPresenterImpl.u.dropSelected(num.intValue(), intOrNull);
            }
            FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersPresenterImpl.o, (EditableParameter) findParameter, null, false, 4, null);
        }
    }

    public static final void access$onParametersTreeLoadingStateChanged(FiltersPresenterImpl filtersPresenterImpl, LoadingState loadingState) {
        Objects.requireNonNull(filtersPresenterImpl);
        if (loadingState instanceof LoadingState.Loading) {
            FiltersView filtersView = filtersPresenterImpl.d;
            if (filtersView != null) {
                filtersView.showProgress();
            }
        } else if (loadingState instanceof LoadingState.Loaded) {
            filtersPresenterImpl.onParametersLoaded((ParametersTreeWithAdditional) ((LoadingState.Loaded) loadingState).getData());
        } else if (loadingState instanceof LoadingState.Error) {
            filtersPresenterImpl.e(((LoadingState.Error) loadingState).getError());
        }
    }

    public static final void access$onSelectClicked(FiltersPresenterImpl filtersPresenterImpl, ParameterElement.Select select, SelectParameter selectParameter) {
        Objects.requireNonNull(filtersPresenterImpl);
        if (select.isDialog()) {
            FiltersView filtersView = filtersPresenterImpl.d;
            if (filtersView != null) {
                filtersView.hideKeyboard();
            }
            FiltersPresenter.Router router = filtersPresenterImpl.e;
            if (router != null) {
                router.showSelectDialog(select);
            }
        } else if (!select.isBottomSheet() || !filtersPresenterImpl.z.getSelectFiltersInBottomSheet().invoke().booleanValue()) {
            Arguments d2 = filtersPresenterImpl.d(selectParameter);
            FiltersView filtersView2 = filtersPresenterImpl.d;
            if (filtersView2 != null) {
                filtersView2.hideKeyboard();
            }
            FiltersPresenter.Router router2 = filtersPresenterImpl.e;
            if (router2 != null) {
                router2.showSelectScreen(d2);
            }
        } else {
            Arguments d3 = filtersPresenterImpl.d(selectParameter);
            FiltersView filtersView3 = filtersPresenterImpl.d;
            if (filtersView3 != null) {
                filtersView3.hideKeyboard();
            }
            FiltersPresenter.Router router3 = filtersPresenterImpl.e;
            if (router3 != null) {
                router3.showSelectBottomSheet(d3);
            }
        }
    }

    public static final void access$onSelectDatesClicked(FiltersPresenterImpl filtersPresenterImpl, ParameterElement.Select select, DateRangeParameter dateRangeParameter) {
        Objects.requireNonNull(filtersPresenterImpl);
        if (select.isCalendar()) {
            FiltersView filtersView = filtersPresenterImpl.d;
            if (filtersView != null) {
                filtersView.hideKeyboard();
            }
            FiltersPresenter.Router router = filtersPresenterImpl.e;
            if (router != null) {
                DateRangeParameter.FormattedDateParameter checkIn = dateRangeParameter.getCheckIn();
                Date date = null;
                Date date2 = checkIn != null ? checkIn.toDate() : null;
                DateRangeParameter.FormattedDateParameter checkOut = dateRangeParameter.getCheckOut();
                if (checkOut != null) {
                    date = checkOut.toDate();
                }
                router.showSelectDatesCalendar(date2, date);
            }
        }
    }

    public static final void access$onSelectMetroClicked(FiltersPresenterImpl filtersPresenterImpl, MetroParameter metroParameter) {
        Integer intOrNull;
        SearchParams searchParamsOrEmpty = filtersPresenterImpl.o.getSearchParamsOrEmpty();
        String locationId = searchParamsOrEmpty.getLocationId();
        String categoryId = searchParamsOrEmpty.getCategoryId();
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        FiltersPresenter.Router router = filtersPresenterImpl.e;
        if (router != null) {
            MetroResponseBody metroWithLines = filtersPresenterImpl.o.getMetroWithLines();
            String id = metroParameter.getId();
            int intValue = (locationId == null || (intOrNull = l.toIntOrNull(locationId)) == null) ? -1 : intOrNull.intValue();
            Integer intOrNull2 = categoryId != null ? l.toIntOrNull(categoryId) : null;
            List<? extends ParcelableEntity<String>> list = (List) metroParameter.getValue();
            if (list == null) {
                list = CollectionsKt__CollectionsKt.emptyList();
            }
            router.showSelectMetroScreen(metroWithLines, id, intValue, intOrNull2, list);
        }
    }

    public static final void access$resubscribeToCounterButton(FiltersPresenterImpl filtersPresenterImpl) {
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            Disposable disposable = filtersPresenterImpl.h;
            if (disposable != null) {
                disposable.dispose();
            }
            filtersPresenterImpl.h = filtersPresenterImpl.f(filtersView, true);
        }
    }

    public static final void access$resubscribeToParametersTree(FiltersPresenterImpl filtersPresenterImpl) {
        Disposable disposable = filtersPresenterImpl.g;
        if (disposable != null) {
            disposable.dispose();
        }
        filtersPresenterImpl.g = h(filtersPresenterImpl, null, 1, null);
    }

    public static final void access$sendBackEvent(FiltersPresenterImpl filtersPresenterImpl, boolean z2) {
        filtersPresenterImpl.t.sendBackClick(z2);
    }

    public static final void access$showLocationScreen(FiltersPresenterImpl filtersPresenterImpl, LocationParameter locationParameter, String str) {
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        FiltersPresenter.Router router = filtersPresenterImpl.e;
        if (router != null) {
            Location location = (Location) locationParameter.getValue();
            router.showRegionSelectScreen(location != null ? location.getId() : null, str);
        }
    }

    public static final void access$showSearchRadiusPickerScreen(FiltersPresenterImpl filtersPresenterImpl, SearchParams searchParams, SearchRadiusParameter searchRadiusParameter) {
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        FiltersPresenter.Router router = filtersPresenterImpl.e;
        if (router != null) {
            router.showSearchRadiusPickerScreen(searchParams, (SearchRadius) searchRadiusParameter.getValue());
        }
    }

    public static final void access$showSelectScreen(FiltersPresenterImpl filtersPresenterImpl, QuartersParameter quartersParameter) {
        List list;
        Objects.requireNonNull(filtersPresenterImpl);
        Quarter selectedValue = quartersParameter.getSelectedValue();
        if (selectedValue == null || (list = d.listOf(selectedValue)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        FiltersView filtersView = filtersPresenterImpl.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        FiltersPresenter.Router router = filtersPresenterImpl.e;
        if (router != null) {
            router.showSelectScreen(new Arguments(quartersParameter.getId(), quartersParameter.getValues(), list, quartersParameter.getTitle(), true, false, false, true, false, false, quartersParameter.getAttributeId(), false, false, null, 14336, null));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0015, code lost:
        if (r4 != null) goto L_0x0020;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void access$updateButtonTitleAndEnabled(com.avito.android.search.filter.FiltersPresenterImpl r2, java.lang.String r3, java.lang.Boolean r4) {
        /*
            java.util.Objects.requireNonNull(r2)
            r0 = 0
            if (r4 == 0) goto L_0x0018
            boolean r4 = r4.booleanValue()
            com.avito.android.search.filter.FiltersView r1 = r2.d
            if (r1 == 0) goto L_0x0014
            r1.setShowButtonEnabled(r4)
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            goto L_0x0015
        L_0x0014:
            r4 = r0
        L_0x0015:
            if (r4 == 0) goto L_0x0018
            goto L_0x0020
        L_0x0018:
            com.avito.android.search.filter.FiltersView r4 = r2.d
            if (r4 == 0) goto L_0x0020
            r1 = 1
            r4.setShowButtonEnabled(r1)
        L_0x0020:
            if (r3 == 0) goto L_0x002e
            com.avito.android.search.filter.FiltersView r4 = r2.d
            if (r4 == 0) goto L_0x002b
            r4.setButtonTitle(r3)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
        L_0x002b:
            if (r0 == 0) goto L_0x002e
            goto L_0x003b
        L_0x002e:
            com.avito.android.search.filter.FiltersView r3 = r2.d
            if (r3 == 0) goto L_0x003b
            com.avito.android.search.filter.FiltersResourceProvider r2 = r2.r
            java.lang.String r2 = r2.getShowAdverts()
            r3.setButtonTitle(r2)
        L_0x003b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.FiltersPresenterImpl.access$updateButtonTitleAndEnabled(com.avito.android.search.filter.FiltersPresenterImpl, java.lang.String, java.lang.Boolean):void");
    }

    public static final void access$updateDataSourceSelectedValue(FiltersPresenterImpl filtersPresenterImpl, ParameterElement.Select select, SelectableItem selectableItem) {
        IterableDataSource iterableDataSource;
        ParameterElement.Select select2;
        Object obj;
        DataSource<Item> dataSource = filtersPresenterImpl.k;
        if (dataSource != null && (iterableDataSource = DataSources.toIterableDataSource(dataSource)) != null) {
            Iterator it = iterableDataSource.iterator();
            while (true) {
                select2 = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((Item) obj).getStringId(), select.getStringId())) {
                    break;
                }
            }
            if (obj instanceof ParameterElement.Select) {
                select2 = obj;
            }
            ParameterElement.Select select3 = select2;
            if (select3 != null) {
                select3.setSelectedValue(selectableItem);
            }
        }
    }

    public static /* synthetic */ Disposable h(FiltersPresenterImpl filtersPresenterImpl, Function1 function1, int i2, Object obj) {
        int i3 = i2 & 1;
        return filtersPresenterImpl.g(null);
    }

    public final void a(Date date, Date date2) {
        DateRangeParameter dateRangeParameter;
        DateRangeParameter.FormattedDateParameter checkIn;
        DateRangeParameter.FormattedDateParameter checkOut;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.i;
        if (parametersTreeWithAdditional != null && (dateRangeParameter = (DateRangeParameter) parametersTreeWithAdditional.getFirstParameterOfType(DateRangeParameter.class)) != null && (checkIn = dateRangeParameter.getCheckIn()) != null && (checkOut = dateRangeParameter.getCheckOut()) != null) {
            String dateToString = date != null ? checkIn.dateToString(date) : null;
            String dateToString2 = date2 != null ? checkOut.dateToString(date2) : null;
            this.o.applyParameterValue(checkIn, dateToString, true);
            FiltersInteractor.DefaultImpls.applyParameterValue$default(this.o, checkOut, dateToString2, false, 4, null);
        }
    }

    public void applyGroupBoundsOrDividers(@NotNull Pair<? extends List<? extends Item>, ? extends List<IntRange>> pair) {
        FiltersView filtersView;
        Intrinsics.checkNotNullParameter(pair, "itemsAndGroups");
        if ((!((Collection) pair.getSecond()).isEmpty()) && (filtersView = this.d) != null) {
            filtersView.setGroupsBounds((List) pair.getSecond());
        }
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void attachRouter(@NotNull FiltersPresenter.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.e = router;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void attachView(@NotNull FiltersView filtersView) {
        Intrinsics.checkNotNullParameter(filtersView, "view");
        this.v.startAdvertServerLoading();
        this.d = filtersView;
        Disposable disposable = this.g;
        boolean z2 = true;
        if (disposable == null || disposable.isDisposed()) {
            this.g = h(this, null, 1, null);
        }
        FiltersView filtersView2 = this.d;
        if (filtersView2 != null) {
            Disposable disposable2 = this.h;
            if (disposable2 != null && !disposable2.isDisposed()) {
                z2 = false;
            }
            if (z2) {
                this.h = f(filtersView2, false);
            }
        }
        CompositeDisposable compositeDisposable = this.f;
        Observable<Unit> upClicks = filtersView.upClicks();
        BackpressureStrategy backpressureStrategy = BackpressureStrategy.DROP;
        DisposableKt.plusAssign(compositeDisposable, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, upClicks.toFlowable(backpressureStrategy), "upClicks().toFlowable(Ba…(schedulers.mainThread())"), (Function1) null, (Function0) null, new a0(this), 3, (Object) null));
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, filtersView.showClicks().toFlowable(backpressureStrategy), "showClicks().toFlowable(…(schedulers.mainThread())"), (Function1) null, (Function0) null, new z(this), 3, (Object) null));
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, filtersView.refreshClicks().toFlowable(backpressureStrategy), "refreshClicks()\n        …(schedulers.mainThread())"), (Function1) null, (Function0) null, new y(this), 3, (Object) null));
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, this.a.toFlowable(BackpressureStrategy.BUFFER), "changeObservable.toFlowa…(schedulers.mainThread())"), (Function1) null, (Function0) null, new v(this), 3, (Object) null));
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, this.b.toFlowable(backpressureStrategy), "clickObservable.toFlowab…(schedulers.mainThread())"), (Function1) null, (Function0) null, new x(this), 3, (Object) null));
        DisposableKt.plusAssign(this.f, SubscribersKt.subscribeBy$default(a2.b.a.a.a.Z1(this.s, this.c.toFlowable(backpressureStrategy), "clearObservable.toFlowab…(schedulers.mainThread())"), (Function1) null, (Function0) null, new Function1<ParameterElement, Unit>(this) { // from class: a2.a.a.k2.a.w
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(ParameterElement parameterElement) {
                ParameterElement parameterElement2 = parameterElement;
                Intrinsics.checkNotNullParameter(parameterElement2, "p1");
                FiltersPresenterImpl.access$onParameterClearClicked((FiltersPresenterImpl) this.receiver, parameterElement2);
                return Unit.INSTANCE;
            }
        }, 3, (Object) null));
    }

    public final void b(String str, List<? extends ParcelableEntity<String>> list, String str2) {
        ParameterSlot findParameter;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.i;
        if (parametersTreeWithAdditional != null && (findParameter = parametersTreeWithAdditional.findParameter(str)) != null) {
            String str3 = null;
            if (findParameter instanceof SelectParameter) {
                if (findParameter instanceof SelectParameter.Sectioned) {
                    this.t.sendSectionedFilterUsageEvent(((SelectParameter) findParameter).getTitle(), str2, this.o.getSearchParamsOrEmpty().getLocationId());
                }
                FiltersInteractor filtersInteractor = this.o;
                EditableParameter editableParameter = (EditableParameter) findParameter;
                ParcelableEntity parcelableEntity = (ParcelableEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                if (parcelableEntity != null) {
                    str3 = (String) parcelableEntity.getId();
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersInteractor, editableParameter, str3, false, 4, null);
            } else if (findParameter instanceof MultiselectParameter) {
                FiltersInteractor filtersInteractor2 = this.o;
                EditableParameter editableParameter2 = (EditableParameter) findParameter;
                ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add((String) it.next().getId());
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersInteractor2, editableParameter2, arrayList, false, 4, null);
            } else if (findParameter instanceof MetroParameter) {
                FiltersInteractor filtersInteractor3 = this.o;
                EditableParameter editableParameter3 = (EditableParameter) findParameter;
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(list, 10));
                for (T t2 : list) {
                    String str4 = (String) t2.getId();
                    String name = t2.getName();
                    if (name == null) {
                        name = "";
                    }
                    arrayList2.add(new Metro(str4, name, null));
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersInteractor3, editableParameter3, arrayList2, false, 4, null);
            } else if (findParameter instanceof QuartersParameter) {
                FiltersInteractor filtersInteractor4 = this.o;
                EditableParameter editableParameter4 = (EditableParameter) findParameter;
                Iterator<T> it2 = ((QuartersParameter) findParameter).getValues().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        break;
                    }
                    T next = it2.next();
                    String id = next.getId();
                    ParcelableEntity parcelableEntity2 = (ParcelableEntity) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) list);
                    if (Intrinsics.areEqual(id, parcelableEntity2 != null ? (String) parcelableEntity2.getId() : null)) {
                        str3 = next;
                        break;
                    }
                }
                FiltersInteractor.DefaultImpls.applyParameterValue$default(filtersInteractor4, editableParameter4, QuarterKt.toQuartersParameterValue((Quarter) str3), false, 4, null);
            }
        }
    }

    public final Arguments c(MultiselectParameter multiselectParameter) {
        List<ParcelableEntity<String>> list;
        boolean z2;
        boolean z3;
        Boolean withImages;
        List<MultiselectParameter.Value> values = multiselectParameter.getValues();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = values.iterator();
        while (true) {
            boolean z4 = false;
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            T t2 = next;
            List list2 = (List) multiselectParameter.getValue();
            if (list2 != null) {
                z4 = list2.contains(t2.getId());
            }
            if (z4) {
                arrayList.add(next);
            }
        }
        MultiselectParameter.Displaying displaying = multiselectParameter.getDisplaying();
        String str = null;
        SortDirection sortDirection = displaying != null ? displaying.getSortDirection() : null;
        if (!this.z.getLocalSortInSelectFilters().invoke().booleanValue() || sortDirection == null) {
            list = multiselectParameter.getValues();
        } else {
            list = this.n.sort(multiselectParameter.getValues(), sortDirection);
        }
        MultiselectParameter.Displaying displaying2 = multiselectParameter.getDisplaying();
        if (displaying2 == null || (withImages = displaying2.getWithImages()) == null) {
            z3 = false;
            z2 = false;
        } else {
            boolean booleanValue = withImages.booleanValue();
            if (!this.z.getImageSelectInFiltersMvp3().invoke().booleanValue() || !(!this.x.getTestGroup().isTest())) {
                booleanValue = false;
            }
            z3 = booleanValue;
            z2 = true;
        }
        boolean z5 = !z3;
        String id = multiselectParameter.getId();
        String title = multiselectParameter.getTitle();
        Boolean typoCorrectionEnabled = multiselectParameter.getTypoCorrectionEnabled();
        boolean booleanValue2 = typoCorrectionEnabled != null ? typoCorrectionEnabled.booleanValue() : false;
        Integer attributeId = multiselectParameter.getAttributeId();
        MultiselectParameter.Displaying displaying3 = multiselectParameter.getDisplaying();
        if (displaying3 != null) {
            str = displaying3.getTitlePattern();
        }
        return new Arguments(id, list, arrayList, title, z5, true, false, true, false, booleanValue2, attributeId, z3, z2, str);
    }

    public final Arguments d(SelectParameter selectParameter) {
        List list;
        List<ParcelableEntity<String>> list2;
        boolean z2;
        boolean z3;
        Boolean withImages;
        SelectParameter.Value selectedValue = selectParameter.getSelectedValue();
        if (selectedValue == null || (list = d.listOf(selectedValue)) == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        SelectParameter.Displaying displaying = selectParameter.getDisplaying();
        String str = null;
        SortDirection sortDirection = displaying != null ? displaying.getSortDirection() : null;
        if (!this.z.getLocalSortInSelectFilters().invoke().booleanValue() || sortDirection == null) {
            list2 = selectParameter.getListToShow();
        } else {
            list2 = this.n.sort(selectParameter.getListToShow(), sortDirection);
        }
        SelectParameter.Displaying displaying2 = selectParameter.getDisplaying();
        if (displaying2 == null || (withImages = displaying2.getWithImages()) == null) {
            z3 = false;
            z2 = false;
        } else {
            boolean booleanValue = withImages.booleanValue();
            if (!this.z.getImageSelectInFiltersMvp3().invoke().booleanValue() || !(!this.x.getTestGroup().isTest())) {
                booleanValue = false;
            }
            z3 = booleanValue;
            z2 = true;
        }
        boolean z4 = !z3;
        String id = selectParameter.getId();
        String title = selectParameter.getTitle();
        Boolean typoCorrectionEnabled = selectParameter.getTypoCorrectionEnabled();
        boolean booleanValue2 = typoCorrectionEnabled != null ? typoCorrectionEnabled.booleanValue() : false;
        Integer attributeId = selectParameter.getAttributeId();
        SelectParameter.Displaying displaying3 = selectParameter.getDisplaying();
        if (displaying3 != null) {
            str = displaying3.getTitlePattern();
        }
        return new Arguments(id, list2, list, title, z4, false, false, true, false, booleanValue2, attributeId, z3, z2, str);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void detachRouter() {
        this.e = null;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void detachView() {
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        Disposable disposable2 = this.h;
        if (disposable2 != null) {
            disposable2.dispose();
        }
        this.f.clear();
        this.d = null;
    }

    public final void e(TypedError typedError) {
        FiltersView filtersView;
        this.v.trackAdvertLoadError();
        this.v.startAdvertDraw();
        if ((typedError instanceof ErrorWithMessage) && (filtersView = this.d) != null) {
            filtersView.showMessage(((ErrorWithMessage) typedError).getMessage());
        }
        FiltersView filtersView2 = this.d;
        if (filtersView2 != null) {
            filtersView2.showLoadingFailure();
        }
        this.v.trackAdvertErrorDraw();
    }

    public final Disposable f(FiltersView filtersView, boolean z2) {
        return SubscribersKt.subscribeBy$default(a2.b.a.a.a.b2(this.s, this.o.counterButtonStream(z2), "interactor.counterButton…(schedulers.mainThread())"), (Function1) null, (Function0) null, new a(this, filtersView), 3, (Object) null);
    }

    public final Disposable g(Function1<? super LoadingState<? super ParametersTreeWithAdditional>, Unit> function1) {
        Disposable subscribe = this.o.parametersTreeStream().observeOn(this.s.mainThread()).subscribe(new b(this, function1), new c(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "interactor.parametersTre…edToLoad()\n            })");
        return subscribe;
    }

    @NotNull
    public final FiltersInteractor getInteractor() {
        return this.o;
    }

    @Nullable
    public final Disposable getParametersTreeDisposable() {
        return this.g;
    }

    @Nullable
    public final FiltersView getView() {
        return this.d;
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void onBackPressed() {
        this.t.sendBackClick(false);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void onDatesSelected(@NotNull Date date, @NotNull Date date2) {
        Intrinsics.checkNotNullParameter(date, "checkInDate");
        Intrinsics.checkNotNullParameter(date2, "checkOutDate");
        a(date, date2);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void onLocationChanged(@Nullable Location location) {
        LocationParameter locationParameter;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.i;
        if (parametersTreeWithAdditional != null && (locationParameter = (LocationParameter) parametersTreeWithAdditional.getFirstParameterOfType(LocationParameter.class)) != null) {
            FiltersInteractor.DefaultImpls.applyParameterValue$default(this.o, locationParameter, location, false, 4, null);
        }
    }

    public void onParametersLoaded(@NotNull ParametersTreeWithAdditional parametersTreeWithAdditional) {
        boolean z2;
        Intrinsics.checkNotNullParameter(parametersTreeWithAdditional, ScreenPublicConstsKt.CONTENT_TYPE_PUBLISH_PARAMETERS_INIT);
        this.v.trackAdvertLoaded();
        this.v.startAdvertDraw();
        this.i = parametersTreeWithAdditional;
        if (this.l == null) {
            this.l = this.o.getSearchParamsOrEmpty().getDisplayType();
        }
        List convert$default = CategoryParametersElementConverter.convert$default(this.q, parametersTreeWithAdditional, null, null, 6, null);
        if (!this.w) {
            if (!(convert$default instanceof Collection) || !convert$default.isEmpty()) {
                Iterator it = convert$default.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Item item = (Item) it.next();
                    if (!(item instanceof ParameterElement.Select) || !((ParameterElement.Select) item).isSerpDisplayType()) {
                        z2 = false;
                        continue;
                    } else {
                        z2 = true;
                        continue;
                    }
                    if (z2) {
                        break;
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Integer num = null;
        int i2 = 0;
        for (Object obj : convert$default) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.throwIndexOverflow();
            }
            Item item2 = (Item) obj;
            if (item2 instanceof ParameterElement.GroupMarker.Start) {
                num = Integer.valueOf(i2 - (arrayList.size() * 2));
            } else if (item2 instanceof ParameterElement.GroupMarker.End) {
                arrayList.add(new IntRange(num != null ? num.intValue() : 0, (i2 - (arrayList.size() * 2)) - 2));
                num = null;
            } else if (num == null) {
                int size = i2 - (arrayList.size() * 2);
                arrayList2.add(new IntRange(size, size));
            }
            i2 = i3;
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object obj2 : convert$default) {
            if (!(((Item) obj2) instanceof ParameterElement.GroupMarker)) {
                arrayList3.add(obj2);
            }
        }
        Pair<? extends List<? extends Item>, ? extends List<IntRange>> pair = new Pair<>(arrayList3, CollectionsKt___CollectionsKt.sortedWith(CollectionsKt___CollectionsKt.plus((Collection) arrayList, (Iterable) arrayList2), new Comparator<T>() { // from class: com.avito.android.search.filter.FiltersPresenterImpl$extractGroupBounds$$inlined$sortedBy$1
            @Override // java.util.Comparator
            public final int compare(T t2, T t3) {
                return a.compareValues(Integer.valueOf(t2.getFirst()), Integer.valueOf(t3.getFirst()));
            }
        }));
        DataAwareAdapterPresenter dataAwareAdapterPresenter = this.p;
        ListDataSource listDataSource = new ListDataSource((List) pair.getFirst());
        this.k = listDataSource;
        dataAwareAdapterPresenter.onDataSourceChanged(listDataSource);
        FiltersView filtersView = this.d;
        if (filtersView != null) {
            filtersView.onDataChanged();
        }
        applyGroupBoundsOrDividers(pair);
        FiltersView filtersView2 = this.d;
        if (filtersView2 != null) {
            filtersView2.hideProgress();
        }
        this.v.trackAdvertDraw();
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle putString = new Kundle().putString("display_type", this.j.name());
        SerpDisplayType serpDisplayType = this.l;
        return putString.putString("display_type_initial", serpDisplayType != null ? serpDisplayType.name() : null).putBoolean("display_type_changed", Boolean.valueOf(this.m)).putParcelable("parameters_tree", this.i).putBoolean("is_only_sort_shown", Boolean.valueOf(this.w));
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void onSearchRadiusChanged(@Nullable SearchRadius searchRadius) {
        SearchRadiusParameter searchRadiusParameter;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.i;
        if (parametersTreeWithAdditional != null && (searchRadiusParameter = (SearchRadiusParameter) parametersTreeWithAdditional.getFirstParameterOfType(SearchRadiusParameter.class)) != null) {
            FiltersInteractor.DefaultImpls.applyParameterValue$default(this.o, searchRadiusParameter, searchRadius, false, 4, null);
        }
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void onSelected(@NotNull String str, @NotNull List<? extends ParcelableEntity<String>> list, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "selection");
        Disposable disposable = this.g;
        if (disposable == null || disposable.isDisposed()) {
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            booleanRef.element = false;
            this.g = g(new u(this, booleanRef, str, list, str2));
            return;
        }
        b(str, list, str2);
    }

    @Override // com.avito.android.search.filter.FiltersPresenter
    public void retry() {
        Disposable disposable = this.g;
        if (disposable != null) {
            disposable.dispose();
        }
        this.g = h(this, null, 1, null);
    }

    public final void setParametersTreeDisposable(@Nullable Disposable disposable) {
        this.g = disposable;
    }

    public final void setView(@Nullable FiltersView filtersView) {
        this.d = filtersView;
    }

    public final void showResults() {
        LocationParameter locationParameter;
        DeepLink deepLink = this.o.getDeepLink();
        if (this.m) {
            SearchParams searchParamsOrEmpty = this.o.getSearchParamsOrEmpty();
            SerpDisplayType displayType = searchParamsOrEmpty.getDisplayType();
            String categoryId = searchParamsOrEmpty.getCategoryId();
            if (!(displayType == null || displayType == this.l)) {
                this.t.sendChangeDisplayType(displayType, categoryId);
            }
        }
        FiltersView filtersView = this.d;
        if (filtersView != null) {
            filtersView.hideKeyboard();
        }
        Boolean isRenamedSearchLocation = this.o.isRenamedSearchLocation();
        if (isRenamedSearchLocation != null && !isRenamedSearchLocation.booleanValue()) {
            ParametersTreeWithAdditional parametersTreeWithAdditional = this.i;
            Location location = (parametersTreeWithAdditional == null || (locationParameter = (LocationParameter) parametersTreeWithAdditional.getFirstParameterOfType(LocationParameter.class)) == null) ? null : (Location) locationParameter.getValue();
            if (location != null) {
                this.y.saveLocation(location, LocationSource.LOCATION_FROM_FILTERS, true);
            }
        }
        FiltersPresenter.Router router = this.e;
        if (router != null) {
            router.closeScreenWithDeepLink(deepLink);
        }
    }
}
