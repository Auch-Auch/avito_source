package com.avito.android.search.filter;

import a2.a.a.k2.a.m;
import a2.a.a.k2.a.n;
import a2.a.a.k2.a.o;
import a2.a.a.k2.a.p;
import a2.a.a.k2.a.q;
import a2.a.a.k2.a.r;
import a2.a.a.k2.a.s;
import a2.a.a.k2.a.t;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.CategoriesInteractor;
import com.avito.android.Features;
import com.avito.android.TopLocationInteractor;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.ItemsSearchLink;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.DetectLocationInteractor;
import com.avito.android.location.find.FindDetectLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.LocationApi;
import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.error.TypedErrorThrowableConverter;
import com.avito.android.remote.model.Category;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.Direction;
import com.avito.android.remote.model.District;
import com.avito.android.remote.model.Location;
import com.avito.android.remote.model.SearchParameters;
import com.avito.android.remote.model.SearchParams;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.remote.model.category_parameters.AdditionalBooleanParameter;
import com.avito.android.remote.model.category_parameters.AdditionalCategoryParameter;
import com.avito.android.remote.model.category_parameters.AdditionalCharParameter;
import com.avito.android.remote.model.category_parameters.LocationParameter;
import com.avito.android.remote.model.category_parameters.ParametersTree;
import com.avito.android.remote.model.category_parameters.SearchRadiusParameter;
import com.avito.android.remote.model.category_parameters.SelectParameter;
import com.avito.android.remote.model.category_parameters.base.ParameterSlot;
import com.avito.android.remote.model.counter.CounterButton;
import com.avito.android.remote.model.metro_lines.MetroResponseBody;
import com.avito.android.remote.model.search.map.Area;
import com.avito.android.remote.model.search.map.AreaKt;
import com.avito.android.search.filter.di.FiltersCoreModule;
import com.avito.android.search.filter.di.FiltersModule;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Kundle;
import com.avito.android.util.LoadingState;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.UrlParams;
import com.avito.android.util.rx3.Observables;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.BiPredicate;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.functions.Function;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¾\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001=BÏ\u0001\b\u0007\u0012\u0006\u0010]\u001a\u00020Z\u0012\u0006\u0010m\u001a\u00020j\u0012\u0006\u0010Y\u001a\u00020V\u0012\u0006\u0010g\u001a\u00020d\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\b\u0010.\u001a\u0004\u0018\u00010-\u0012\n\u0010­\u0001\u001a\u0005\u0018\u00010ª\u0001\u0012\u000b\b\u0001\u0010©\u0001\u001a\u0004\u0018\u00010&\u0012\t\b\u0001\u0010\u0001\u001a\u00020\u0007\u0012\n\b\u0001\u0010¢\u0001\u001a\u00030\u0001\u0012\u0006\u0010s\u001a\u00020p\u0012\b\u0010¦\u0001\u001a\u00030£\u0001\u0012\b\u0010±\u0001\u001a\u00030®\u0001\u0012\u0006\u0010c\u001a\u00020`\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u000b\b\u0001\u0010²\u0001\u001a\u0004\u0018\u00010\u0016\u0012\u0006\u0010U\u001a\u00020R\u0012\b\u0010\u0001\u001a\u00030\u0001\u0012\u0007\u0010\u0001\u001a\u00020¢\u0006\u0006\b³\u0001\u0010´\u0001J\u001b\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J#\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00030\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\u0012\u001a\u00020\u0011\"\u0004\b\u0000\u0010\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\r2\b\u0010\u000f\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0014\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u0019\u0010 \u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010$\u001a\u00020\u00112\u0006\u0010#\u001a\u00020\"H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010+\u001a\u00020*H\u0016¢\u0006\u0004\b+\u0010,J\u0019\u0010/\u001a\u00020\u00112\b\u0010.\u001a\u0004\u0018\u00010-H\u0016¢\u0006\u0004\b/\u00100J\u000f\u00101\u001a\u00020-H\u0016¢\u0006\u0004\b1\u00102J\u000f\u00103\u001a\u00020\u0007H\u0016¢\u0006\u0004\b3\u00104J\u0011\u00106\u001a\u0004\u0018\u000105H\u0016¢\u0006\u0004\b6\u00107J\u0011\u00108\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b8\u00109J\u0011\u0010:\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b:\u0010;J\u0011\u0010<\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b<\u0010;J\u0011\u0010=\u001a\u0004\u0018\u00010&H\u0002¢\u0006\u0004\b=\u0010;J\u000f\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\b>\u0010\u0015J%\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00022\b\u0010?\u001a\u0004\u0018\u00010\u0007H\u0002¢\u0006\u0004\b@\u0010AJ\u0015\u0010C\u001a\b\u0012\u0004\u0012\u00020B0\u0002H\u0002¢\u0006\u0004\bC\u0010\u0006J-\u0010H\u001a\b\u0012\u0004\u0012\u00020E0D*\b\u0012\u0004\u0012\u00020E0D2\f\u0010G\u001a\b\u0012\u0004\u0012\u00020F0DH\u0002¢\u0006\u0004\bH\u0010IJ\u0015\u0010L\u001a\u0004\u0018\u00010K*\u00020JH\u0002¢\u0006\u0004\bL\u0010MJ\u0015\u0010N\u001a\u00020-*\u0004\u0018\u00010-H\u0002¢\u0006\u0004\bN\u0010OR\u0018\u0010Q\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b:\u0010PR\u0016\u0010U\u001a\u00020R8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010Y\u001a\u00020V8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bW\u0010XR\u0016\u0010]\u001a\u00020Z8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b[\u0010\\R\u0018\u0010_\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010^R\u0016\u0010c\u001a\u00020`8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\ba\u0010bR\u0016\u0010g\u001a\u00020d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\be\u0010fR\u0018\u0010.\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010iR\u0016\u0010m\u001a\u00020j8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bk\u0010lR\u0018\u0010o\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010nR\u0016\u0010s\u001a\u00020p8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u0016\u0010v\u001a\u00020t8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010uR\u0018\u0010y\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010xR\\\u0010~\u001aH\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 {*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003 {*#\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004 {*\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00030\u0003\u0018\u00010z¢\u0006\u0002\b|0z¢\u0006\u0002\b|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010}R\u0019\u0010\u0001\u001a\u000208\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R%\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b<\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001RI\u0010\u0001\u001a4\u0012\u000e\u0012\f {*\u0005\u0018\u00010\u00010\u0001 {*\u0019\u0012\u000e\u0012\f {*\u0005\u0018\u00010\u00010\u0001\u0018\u00010z¢\u0006\u0002\b|0z¢\u0006\u0002\b|8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010}R\u001a\u0010\u0001\u001a\u0004\u0018\u00010K8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bC\u0010\u0001R\u0019\u0010\u0001\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u001a\u0010¢\u0001\u001a\u00030\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b \u0001\u0010¡\u0001R\u001a\u0010¦\u0001\u001a\u00030£\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001b\u0010©\u0001\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010­\u0001\u001a\u0005\u0018\u00010ª\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u001a\u0010±\u0001\u001a\u00030®\u00018\u0002@\u0002X\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001¨\u0006µ\u0001"}, d2 = {"Lcom/avito/android/search/filter/FiltersInteractorImpl;", "Lcom/avito/android/search/filter/FiltersInteractor;", "Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/util/LoadingState;", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "parametersTreeStream", "()Lio/reactivex/rxjava3/core/Observable;", "", "skipCurrentState", "Lcom/avito/android/remote/model/counter/CounterButton;", "counterButtonStream", "(Z)Lio/reactivex/rxjava3/core/Observable;", "T", "Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;", "parameter", "value", "ignoreUpdatesForm", "", "applyParameterValue", "(Lcom/avito/android/remote/model/category_parameters/base/EditableParameter;Ljava/lang/Object;Z)V", "sendScreenExitAfterCoordinatesResolve", "()V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Landroid/content/Context;", "context", "registerLocationReceiver", "(Landroid/content/Context;)V", "unregisterLocationReceiver", "Landroid/view/View;", "view", "subscribeOnNotPermissionGranted", "(Landroid/view/View;)V", "Landroid/app/Activity;", "activity", "findCoordinates", "(Landroid/app/Activity;)V", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getDeepLink", "()Lcom/avito/android/deep_linking/links/DeepLink;", "Lcom/avito/android/remote/model/SearchParams;", "searchParams", "updateStateBySearchParams", "(Lcom/avito/android/remote/model/SearchParams;)V", "getSearchParamsOrEmpty", "()Lcom/avito/android/remote/model/SearchParams;", "hasSearchArea", "()Z", "Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "getMetroWithLines", "()Lcom/avito/android/remote/model/metro_lines/MetroResponseBody;", "isRenamedSearchLocation", "()Ljava/lang/Boolean;", "f", "()Ljava/lang/String;", AuthSource.BOOKING_ORDER, "c", "i", "updatesForm", "h", "(Ljava/lang/Boolean;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/Location;", "d", "", "Lcom/avito/android/remote/model/category_parameters/base/ParameterSlot;", "Lcom/avito/android/remote/model/Category;", "categories", "e", "(Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Lcom/avito/android/remote/model/category_parameters/ParametersTree;", "Lcom/avito/android/remote/model/Coordinates;", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/category_parameters/ParametersTree;)Lcom/avito/android/remote/model/Coordinates;", a2.g.r.g.a, "(Lcom/avito/android/remote/model/SearchParams;)Lcom/avito/android/remote/model/SearchParams;", "Ljava/lang/Boolean;", "lastUpdatesForm", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/remote/LocationApi;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/remote/LocationApi;", "locationApi", "Lcom/avito/android/CategoriesInteractor;", "k", "Lcom/avito/android/CategoriesInteractor;", "categoriesInteractor", "Lcom/avito/android/remote/model/counter/CounterButton;", "lastCounterButton", "Lcom/avito/android/util/SchedulersFactory3;", "y", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/remote/SearchApi;", "n", "Lcom/avito/android/remote/SearchApi;", "searchApi", VKApiConst.Q, "Lcom/avito/android/remote/model/SearchParams;", "Lcom/avito/android/TopLocationInteractor;", "l", "Lcom/avito/android/TopLocationInteractor;", "topLocationInteractor", "Lcom/avito/android/search/filter/ParametersTreeWithAdditional;", "parametersTree", "Lcom/avito/android/search/filter/ParametersTreeMapConverter;", VKApiConst.VERSION, "Lcom/avito/android/search/filter/ParametersTreeMapConverter;", "parametersMapConverter", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "disposable", "Lcom/avito/android/search/filter/LocationInfo;", "Lcom/avito/android/search/filter/LocationInfo;", "locationInfo", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "parametersTreeRelay", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "C", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalytics", "j", "Lio/reactivex/rxjava3/core/Observable;", "parametersTreeObservable", "Lcom/avito/android/remote/model/Location;", "topLocation", "Lcom/avito/android/Features;", "z", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/search/filter/FiltersInteractorImpl$c;", "countRelay", "Lcom/avito/android/remote/model/Coordinates;", "coordinates", "t", "Z", UrlParams.SIMPLE_MAP, "Lcom/avito/android/search/filter/CategoriesParameterFactory;", "o", "Lcom/avito/android/search/filter/CategoriesParameterFactory;", "categoriesParameterFactory", "Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;", "p", "Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;", "parametersTreeWrapper", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "B", "Lcom/avito/android/location/find/FindDetectLocationPresenter;", "findDetectLocationPresenter", "Lcom/avito/android/remote/model/SearchParamsConverter;", "u", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParamsMapConverter", "Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;", "w", "Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;", "parametersSearchParamsConverter", "s", "Ljava/lang/String;", "mapSerpState", "Lcom/avito/android/remote/model/search/map/Area;", "r", "Lcom/avito/android/remote/model/search/map/Area;", "searchArea", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "x", "Lcom/avito/android/remote/error/TypedErrorThrowableConverter;", "throwableConverter", "savedState", "<init>", "(Lcom/avito/android/CategoriesInteractor;Lcom/avito/android/TopLocationInteractor;Lcom/avito/android/remote/LocationApi;Lcom/avito/android/remote/SearchApi;Lcom/avito/android/search/filter/CategoriesParameterFactory;Lcom/avito/android/search/filter/ReplaceLocationParametersTreeWrapper;Lcom/avito/android/remote/model/SearchParams;Lcom/avito/android/remote/model/search/map/Area;Ljava/lang/String;ZLcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/search/filter/ParametersTreeMapConverter;Lcom/avito/android/search/filter/ParametersTreeSearchParamsConverter;Lcom/avito/android/remote/error/TypedErrorThrowableConverter;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/Features;Lcom/avito/android/util/Kundle;Lcom/avito/android/permissions/LocationPermissionDialogPresenter;Lcom/avito/android/location/find/FindDetectLocationPresenter;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class FiltersInteractorImpl implements FiltersInteractor {
    public final LocationPermissionDialogPresenter A;
    public final FindDetectLocationPresenter B;
    public final LocationAnalyticsInteractor C;
    public LocationInfo a;
    public Location b;
    public ParametersTreeWithAdditional c;
    public Coordinates d;
    public CounterButton e;
    public Boolean f;
    public final BehaviorRelay<c> g;
    public CompositeDisposable h;
    public final BehaviorRelay<LoadingState<ParametersTreeWithAdditional>> i;
    public final Observable<LoadingState<ParametersTreeWithAdditional>> j;
    public final CategoriesInteractor k;
    public final TopLocationInteractor l;
    public final LocationApi m;
    public final SearchApi n;
    public final CategoriesParameterFactory o;
    public final ReplaceLocationParametersTreeWrapper p;
    public SearchParams q;
    public Area r;
    public final String s;
    public final boolean t;
    public final SearchParamsConverter u;
    public final ParametersTreeMapConverter v;
    public final ParametersTreeSearchParamsConverter w;
    public final TypedErrorThrowableConverter x;
    public final SchedulersFactory3 y;
    public final Features z;

    public static final class a<T1, T2> implements BiPredicate<LoadingState<? super ParametersTreeWithAdditional>, LoadingState<? super ParametersTreeWithAdditional>> {
        public static final a a = new a();

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.BiPredicate
        public boolean test(LoadingState<? super ParametersTreeWithAdditional> loadingState, LoadingState<? super ParametersTreeWithAdditional> loadingState2) {
            return (loadingState instanceof LoadingState.Loading) && (loadingState2 instanceof LoadingState.Loading);
        }
    }

    public static final class b<T> implements Consumer<LoadingState<? super ParametersTreeWithAdditional>> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public b(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.jakewharton.rxrelay3.BehaviorRelay */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
            if (!(loadingState instanceof LoadingState.Loading)) {
                this.a.g.accept(c.START_UPDATE);
            }
        }
    }

    public enum c {
        SHOW_LOADER,
        START_UPDATE
    }

    public static final class e<T, R> implements Function<c, ObservableSource<? extends LoadingState<? super CounterButton>>> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public e(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super CounterButton>> apply(c cVar) {
            if (cVar != c.SHOW_LOADER) {
                return FiltersInteractorImpl.access$getCounterButton(this.a);
            }
            LoadingState.Loading loading = LoadingState.Loading.INSTANCE;
            Objects.requireNonNull(loading, "null cannot be cast to non-null type com.avito.android.util.LoadingState<com.avito.android.remote.model.counter.CounterButton>");
            return Observable.just(loading);
        }
    }

    public static final class f<T> implements Consumer<android.location.Location> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public f(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(android.location.Location location) {
            android.location.Location location2 = location;
            LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.C, location2, null, 2, null);
            FiltersInteractorImpl filtersInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(location2, "it");
            filtersInteractorImpl.d = new Coordinates(location2.getLatitude(), location2.getLongitude());
        }
    }

    public static final class g<T> implements Consumer<Throwable> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public g(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            if (th2 instanceof DetectLocationInteractor.LocationDisabledException) {
                FiltersInteractorImpl.access$resetSortParameterValue(this.a);
            }
            this.a.C.trackResolveCoordinates(null, th2.getMessage());
            Logs.error(th2);
        }
    }

    public static final class h<T> implements Consumer<Location> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public h(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            this.a.b = location;
        }
    }

    public static final class i<T, R> implements Function<Pair<? extends List<? extends Category>, ? extends LoadingState<? super SearchParameters>>, ObservableSource<? extends LoadingState<? super ParametersTreeWithAdditional>>> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public i(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public ObservableSource<? extends LoadingState<? super ParametersTreeWithAdditional>> apply(Pair<? extends List<? extends Category>, ? extends LoadingState<? super SearchParameters>> pair) {
            Pair<? extends List<? extends Category>, ? extends LoadingState<? super SearchParameters>> pair2 = pair;
            List list = (List) pair2.component1();
            LoadingState loadingState = (LoadingState) pair2.component2();
            FiltersInteractorImpl filtersInteractorImpl = this.a;
            Intrinsics.checkNotNullExpressionValue(loadingState, "searchParametersState");
            Intrinsics.checkNotNullExpressionValue(list, "categories");
            return FiltersInteractorImpl.access$combineSearchParametersWithCategories(filtersInteractorImpl, loadingState, list);
        }
    }

    public static final class j<T, R> implements Function<Throwable, LoadingState<? super ParametersTreeWithAdditional>> {
        public final /* synthetic */ FiltersInteractorImpl a;

        public j(FiltersInteractorImpl filtersInteractorImpl) {
            this.a = filtersInteractorImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Function
        public LoadingState<? super ParametersTreeWithAdditional> apply(Throwable th) {
            Throwable th2 = th;
            TypedErrorThrowableConverter typedErrorThrowableConverter = this.a.x;
            Intrinsics.checkNotNullExpressionValue(th2, "it");
            return new LoadingState.Error(typedErrorThrowableConverter.convert(th2));
        }
    }

    @Inject
    public FiltersInteractorImpl(@NotNull CategoriesInteractor categoriesInteractor, @NotNull TopLocationInteractor topLocationInteractor, @NotNull LocationApi locationApi, @NotNull SearchApi searchApi, @NotNull CategoriesParameterFactory categoriesParameterFactory, @NotNull ReplaceLocationParametersTreeWrapper replaceLocationParametersTreeWrapper, @Nullable SearchParams searchParams, @Nullable Area area, @FiltersModule.MapSerpState @Nullable String str, @FiltersModule.ShowSimpleMap boolean z2, @FiltersCoreModule.FiltersSearchParamsConverter @NotNull SearchParamsConverter searchParamsConverter, @NotNull ParametersTreeMapConverter parametersTreeMapConverter, @NotNull ParametersTreeSearchParamsConverter parametersTreeSearchParamsConverter, @NotNull TypedErrorThrowableConverter typedErrorThrowableConverter, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull Features features, @FiltersModule.InteractorState @Nullable Kundle kundle, @NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter, @NotNull FindDetectLocationPresenter findDetectLocationPresenter, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor) {
        Intrinsics.checkNotNullParameter(categoriesInteractor, "categoriesInteractor");
        Intrinsics.checkNotNullParameter(topLocationInteractor, "topLocationInteractor");
        Intrinsics.checkNotNullParameter(locationApi, "locationApi");
        Intrinsics.checkNotNullParameter(searchApi, "searchApi");
        Intrinsics.checkNotNullParameter(categoriesParameterFactory, "categoriesParameterFactory");
        Intrinsics.checkNotNullParameter(replaceLocationParametersTreeWrapper, "parametersTreeWrapper");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParamsMapConverter");
        Intrinsics.checkNotNullParameter(parametersTreeMapConverter, "parametersMapConverter");
        Intrinsics.checkNotNullParameter(parametersTreeSearchParamsConverter, "parametersSearchParamsConverter");
        Intrinsics.checkNotNullParameter(typedErrorThrowableConverter, "throwableConverter");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter, "locationPermissionDialogPresenter");
        Intrinsics.checkNotNullParameter(findDetectLocationPresenter, "findDetectLocationPresenter");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalytics");
        this.k = categoriesInteractor;
        this.l = topLocationInteractor;
        this.m = locationApi;
        this.n = searchApi;
        this.o = categoriesParameterFactory;
        this.p = replaceLocationParametersTreeWrapper;
        this.q = searchParams;
        this.r = area;
        this.s = str;
        this.t = z2;
        this.u = searchParamsConverter;
        this.v = parametersTreeMapConverter;
        this.w = parametersTreeSearchParamsConverter;
        this.x = typedErrorThrowableConverter;
        this.y = schedulersFactory3;
        this.z = features;
        this.A = locationPermissionDialogPresenter;
        this.B = findDetectLocationPresenter;
        this.C = locationAnalyticsInteractor;
        Boolean bool = null;
        this.a = kundle != null ? (LocationInfo) kundle.getParcelable("location_info") : null;
        this.b = kundle != null ? (Location) kundle.getParcelable("top_location") : null;
        this.c = kundle != null ? (ParametersTreeWithAdditional) kundle.getParcelable("parameters_tree") : null;
        this.d = kundle != null ? (Coordinates) kundle.getParcelable("coordinates") : null;
        this.e = kundle != null ? (CounterButton) kundle.getParcelable("last_counter_button") : null;
        this.f = kundle != null ? kundle.getBoolean("last_updates_form") : bool;
        this.g = BehaviorRelay.create();
        this.h = new CompositeDisposable();
        BehaviorRelay<LoadingState<ParametersTreeWithAdditional>> create = BehaviorRelay.create();
        this.i = create;
        Observable<LoadingState<ParametersTreeWithAdditional>> distinctUntilChanged = create.distinctUntilChanged(a.a);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "parametersTreeRelay.dist…e\n            }\n        }");
        this.j = distinctUntilChanged;
        distinctUntilChanged.subscribe(new b(this));
    }

    public static final void access$acceptParametersTreeChange(FiltersInteractorImpl filtersInteractorImpl, LoadingState loadingState) {
        filtersInteractorImpl.i.accept(loadingState);
    }

    public static final Observable access$combineSearchParametersWithCategories(FiltersInteractorImpl filtersInteractorImpl, LoadingState loadingState, List list) {
        Observable observable;
        Objects.requireNonNull(filtersInteractorImpl);
        if (loadingState instanceof LoadingState.Loaded) {
            LoadingState.Loaded loaded = (LoadingState.Loaded) loadingState;
            Observable just = Observable.just(new ParametersTreeWithAdditionalImpl(filtersInteractorImpl.e(((SearchParameters) loaded.getData()).getParameters(), list), ((SearchParameters) loaded.getData()).getAdditionalParameters()));
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            observable = just.flatMap(new a2.a.a.k2.a.c(filtersInteractorImpl)).map(a2.a.a.k2.a.d.a);
        } else {
            observable = Observable.just(loadingState);
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        }
        Objects.requireNonNull(observable, "null cannot be cast to non-null type io.reactivex.rxjava3.core.Observable<com.avito.android.util.LoadingState<com.avito.android.search.filter.ParametersTreeWithAdditional>>");
        Observable doOnNext = observable.doOnNext(new a2.a.a.k2.a.a(filtersInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "observable.doOnNext {\n  …a\n            }\n        }");
        return doOnNext;
    }

    public static final Observable access$getCounterButton(FiltersInteractorImpl filtersInteractorImpl) {
        Objects.requireNonNull(filtersInteractorImpl);
        return a2.b.a.a.a.a2(filtersInteractorImpl.y, Observable.fromCallable(new a2.a.a.k2.a.e(filtersInteractorImpl)).flatMap(new a2.a.a.k2.a.f(filtersInteractorImpl)).map(new a2.a.a.k2.a.g(filtersInteractorImpl)).doOnError(new a2.a.a.k2.a.h(filtersInteractorImpl)).onErrorReturn(new a2.a.a.k2.a.i(filtersInteractorImpl)), "Observable\n            .…scribeOn(schedulers.io())");
    }

    public static final Location access$getLocation(FiltersInteractorImpl filtersInteractorImpl, ParametersTree parametersTree) {
        Objects.requireNonNull(filtersInteractorImpl);
        LocationParameter locationParameter = (LocationParameter) parametersTree.getFirstParameterOfType(LocationParameter.class);
        if (locationParameter != null) {
            return (Location) locationParameter.getValue();
        }
        return null;
    }

    public static final Observable access$getLocationInfo(FiltersInteractorImpl filtersInteractorImpl, ParametersTree parametersTree) {
        Objects.requireNonNull(filtersInteractorImpl);
        Observable doOnNext = Observable.fromCallable(new a2.a.a.k2.a.l(filtersInteractorImpl, parametersTree)).flatMap(new m(filtersInteractorImpl)).doOnNext(new n(filtersInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "Observable.fromCallable …ext { locationInfo = it }");
        return doOnNext;
    }

    public static final void access$resetSortParameterValue(FiltersInteractorImpl filtersInteractorImpl) {
        SelectParameter.Value value;
        String id;
        ParametersTreeWithAdditional parametersTreeWithAdditional = filtersInteractorImpl.c;
        SelectParameter.Flat flat = null;
        ParameterSlot findParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findParameter("sort") : null;
        if (findParameter instanceof SelectParameter.Flat) {
            flat = findParameter;
        }
        SelectParameter.Flat flat2 = flat;
        if (flat2 != null && (value = (SelectParameter.Value) CollectionsKt___CollectionsKt.firstOrNull((List<? extends Object>) flat2.getValues())) != null && (id = value.getId()) != null) {
            flat2.setValue(id);
        }
    }

    public static final Observable access$toLocationInfo(FiltersInteractorImpl filtersInteractorImpl, Location location) {
        Observable<MetroResponseBody> observable;
        Observable<List<District>> observable2;
        Observable<List<Direction>> observable3;
        Objects.requireNonNull(filtersInteractorImpl);
        if (location.getHasMetro()) {
            observable = filtersInteractorImpl.m.getMetroWithLines(location.getId());
        } else {
            observable = Observable.just(new MetroResponseBody(CollectionsKt__CollectionsKt.emptyList(), CollectionsKt__CollectionsKt.emptyList()));
            Intrinsics.checkNotNullExpressionValue(observable, "Observable.just(this)");
        }
        if (location.getHasDistricts()) {
            observable2 = filtersInteractorImpl.m.getDistricts(location.getId());
        } else {
            observable2 = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(observable2, "Observable.just(this)");
        }
        if (location.getHasDirections()) {
            observable3 = filtersInteractorImpl.m.getDirections(location.getId());
        } else {
            Observable<List<Direction>> just = Observable.just(CollectionsKt__CollectionsKt.emptyList());
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            observable3 = just;
        }
        Observable doOnSubscribe = Observable.zip(filtersInteractorImpl.d(), observable, observable2, observable3, new q(filtersInteractorImpl, location)).doOnSubscribe(new r(filtersInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(doOnSubscribe, "Observable.zip(topLocati…e(LoadingState.Loading) }");
        return doOnSubscribe;
    }

    public static final ParametersTreeWithAdditional access$wrapWithLocationInfo(FiltersInteractorImpl filtersInteractorImpl, ParametersTreeWithAdditional parametersTreeWithAdditional, LocationInfo locationInfo) {
        return filtersInteractorImpl.p.wrap(parametersTreeWithAdditional, locationInfo);
    }

    public final Coordinates a(ParametersTree parametersTree) {
        SearchRadius searchRadius;
        SearchRadiusParameter searchRadiusParameter = (SearchRadiusParameter) parametersTree.getFirstParameterOfType(SearchRadiusParameter.class);
        if (searchRadiusParameter == null || (searchRadius = (SearchRadius) searchRadiusParameter.getValue()) == null) {
            return null;
        }
        return searchRadius.getCoordinates();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        if (r0.equals(com.avito.android.search.filter.ParameterId.SUBCATEGORIES) == false) goto L_0x00bc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0068, code lost:
        if (r0.equals(com.avito.android.search.filter.ParameterId.CATEGORIES) != false) goto L_0x006a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00f0  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00f5  */
    @Override // com.avito.android.search.filter.FiltersInteractor
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> void applyParameterValue(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.category_parameters.base.EditableParameter<T> r9, @org.jetbrains.annotations.Nullable T r10, boolean r11) {
        /*
        // Method dump skipped, instructions count: 293
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.FiltersInteractorImpl.applyParameterValue(com.avito.android.remote.model.category_parameters.base.EditableParameter, java.lang.Object, boolean):void");
    }

    public final String b() {
        String value;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.c;
        AdditionalCategoryParameter findAdditionalParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findAdditionalParameter("sellerId") : null;
        if (!(findAdditionalParameter instanceof AdditionalCharParameter)) {
            findAdditionalParameter = null;
        }
        AdditionalCharParameter additionalCharParameter = (AdditionalCharParameter) findAdditionalParameter;
        if (additionalCharParameter != null && (value = additionalCharParameter.getValue()) != null) {
            return value;
        }
        SearchParams searchParams = this.q;
        if (searchParams != null) {
            return searchParams.getSellerId();
        }
        return null;
    }

    public final String c() {
        String value;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.c;
        AdditionalCategoryParameter findAdditionalParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findAdditionalParameter("shopId") : null;
        if (!(findAdditionalParameter instanceof AdditionalCharParameter)) {
            findAdditionalParameter = null;
        }
        AdditionalCharParameter additionalCharParameter = (AdditionalCharParameter) findAdditionalParameter;
        if (additionalCharParameter != null && (value = additionalCharParameter.getValue()) != null) {
            return value;
        }
        SearchParams searchParams = this.q;
        if (searchParams != null) {
            return searchParams.getShopId();
        }
        return null;
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @NotNull
    public Observable<LoadingState<CounterButton>> counterButtonStream(boolean z2) {
        Observable<c> observable;
        if (z2) {
            observable = this.g.skip(1);
        } else {
            observable = this.g;
        }
        Observable flatMap = observable.flatMap(new e(this));
        Observable fromCallable = Observable.fromCallable(new a2.a.a.k2.a.j(this));
        Intrinsics.checkNotNullExpressionValue(fromCallable, "Observable.fromCallable …utton?.title.toOption() }");
        Observable map = Observables.filterDefined(fromCallable).map(new a2.a.a.k2.a.k(this));
        Observable just = Observable.just(LoadingState.Loading.INSTANCE);
        Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
        Observable switchIfEmpty = map.switchIfEmpty(just);
        Intrinsics.checkNotNullExpressionValue(switchIfEmpty, "Observable.fromCallable ….toSingletonObservable())");
        Observable<LoadingState<CounterButton>> startWith = flatMap.startWith(switchIfEmpty);
        Intrinsics.checkNotNullExpressionValue(startWith, "countRelayStream.flatMap…tonOnFirstSubscription())");
        return startWith;
    }

    public final Observable<Location> d() {
        if (this.z.getTopLocationSingleRequest().invoke().booleanValue()) {
            return this.l.getTopLocation();
        }
        Location location = this.b;
        if (location != null) {
            Observable<Location> just = Observable.just(location);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            if (just != null) {
                return just;
            }
        }
        Observable<Location> doOnNext = this.m.getTopLocation().doOnNext(new h(this));
        Intrinsics.checkNotNullExpressionValue(doOnNext, "locationApi.getTopLocati…Next { topLocation = it }");
        return doOnNext;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [com.avito.android.remote.model.category_parameters.GroupParameter] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.avito.android.remote.model.category_parameters.base.ParameterSlot> e(java.util.List<? extends com.avito.android.remote.model.category_parameters.base.ParameterSlot> r6, java.util.List<com.avito.android.remote.model.Category> r7) {
        /*
            r5 = this;
            java.util.Iterator r0 = r6.iterator()
            r1 = 0
        L_0x0005:
            boolean r2 = r0.hasNext()
            r3 = -1
            if (r2 == 0) goto L_0x001a
            java.lang.Object r2 = r0.next()
            com.avito.android.remote.model.category_parameters.base.ParameterSlot r2 = (com.avito.android.remote.model.category_parameters.base.ParameterSlot) r2
            boolean r2 = r2 instanceof com.avito.android.remote.model.category_parameters.SelectCategoryParameter
            if (r2 == 0) goto L_0x0017
            goto L_0x001b
        L_0x0017:
            int r1 = r1 + 1
            goto L_0x0005
        L_0x001a:
            r1 = -1
        L_0x001b:
            if (r1 == r3) goto L_0x003e
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.toMutableList(r6)
            java.lang.Object r6 = r6.get(r1)
            java.lang.String r2 = "null cannot be cast to non-null type com.avito.android.remote.model.category_parameters.SelectCategoryParameter"
            java.util.Objects.requireNonNull(r6, r2)
            com.avito.android.remote.model.category_parameters.SelectCategoryParameter r6 = (com.avito.android.remote.model.category_parameters.SelectCategoryParameter) r6
            java.lang.Object r6 = r6.getValue()
            com.avito.android.remote.model.Category r6 = (com.avito.android.remote.model.Category) r6
            com.avito.android.search.filter.CategoriesParameterFactory r2 = r5.o
            java.util.List r6 = r2.create(r7, r6)
            int r1 = r1 + 1
            r0.addAll(r1, r6)
            goto L_0x0079
        L_0x003e:
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = t6.n.e.collectionSizeOrDefault(r6, r1)
            r0.<init>(r1)
            java.util.Iterator r6 = r6.iterator()
        L_0x004d:
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L_0x0079
            java.lang.Object r1 = r6.next()
            com.avito.android.remote.model.category_parameters.base.ParameterSlot r1 = (com.avito.android.remote.model.category_parameters.base.ParameterSlot) r1
            boolean r2 = r1 instanceof com.avito.android.remote.model.category_parameters.GroupParameter
            if (r2 == 0) goto L_0x0075
            com.avito.android.remote.model.category_parameters.GroupParameter r2 = new com.avito.android.remote.model.category_parameters.GroupParameter
            java.lang.String r3 = r1.getId()
            com.avito.android.remote.model.category_parameters.GroupParameter r1 = (com.avito.android.remote.model.category_parameters.GroupParameter) r1
            java.lang.String r4 = r1.getTitle()
            java.util.List r1 = r1.getParameters()
            java.util.List r1 = r5.e(r1, r7)
            r2.<init>(r3, r4, r1)
            r1 = r2
        L_0x0075:
            r0.add(r1)
            goto L_0x004d
        L_0x0079:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.FiltersInteractorImpl.e(java.util.List, java.util.List):java.util.List");
    }

    public final String f() {
        String value;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.c;
        AdditionalCategoryParameter findAdditionalParameter = parametersTreeWithAdditional != null ? parametersTreeWithAdditional.findAdditionalParameter(PanelStateKt.PANEL_EXPANDED) : null;
        if (!(findAdditionalParameter instanceof AdditionalCharParameter)) {
            findAdditionalParameter = null;
        }
        AdditionalCharParameter additionalCharParameter = (AdditionalCharParameter) findAdditionalParameter;
        if (additionalCharParameter != null && (value = additionalCharParameter.getValue()) != null) {
            return value;
        }
        SearchParams searchParams = this.q;
        if (searchParams != null) {
            return searchParams.getExpanded();
        }
        return null;
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void findCoordinates(@NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = this.B.findLocation(activity, true).subscribe(new f(this), new g(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "findDetectLocationPresen…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public final SearchParams g(SearchParams searchParams) {
        return searchParams != null ? searchParams : new SearchParams(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 8388607, null);
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @NotNull
    public DeepLink getDeepLink() {
        Area area;
        Boolean value;
        Boolean value2;
        LocationParameter locationParameter;
        Location location;
        SearchParams searchParamsOrEmpty = getSearchParamsOrEmpty();
        searchParamsOrEmpty.setExpanded(f());
        searchParamsOrEmpty.setSellerId(b());
        searchParamsOrEmpty.setShopId(c());
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.c;
        String id = (parametersTreeWithAdditional == null || (locationParameter = (LocationParameter) parametersTreeWithAdditional.getFirstParameterOfType(LocationParameter.class)) == null || (location = (Location) locationParameter.getValue()) == null) ? null : location.getId();
        SearchParams searchParams = this.q;
        searchParamsOrEmpty.setForcedLocationForRecommendation(Intrinsics.areEqual(id, searchParams != null ? searchParams.getLocationId() : null) ^ true ? Boolean.TRUE : null);
        ParametersTreeWithAdditional parametersTreeWithAdditional2 = this.c;
        AdditionalCategoryParameter findAdditionalParameter = parametersTreeWithAdditional2 != null ? parametersTreeWithAdditional2.findAdditionalParameter("showMap") : null;
        if (!(findAdditionalParameter instanceof AdditionalBooleanParameter)) {
            findAdditionalParameter = null;
        }
        AdditionalBooleanParameter additionalBooleanParameter = (AdditionalBooleanParameter) findAdditionalParameter;
        boolean booleanValue = (additionalBooleanParameter == null || (value2 = additionalBooleanParameter.getValue()) == null) ? false : value2.booleanValue();
        ParametersTreeWithAdditional parametersTreeWithAdditional3 = this.c;
        AdditionalCategoryParameter findAdditionalParameter2 = parametersTreeWithAdditional3 != null ? parametersTreeWithAdditional3.findAdditionalParameter(UrlParams.SIMPLE_MAP) : null;
        if (!(findAdditionalParameter2 instanceof AdditionalBooleanParameter)) {
            findAdditionalParameter2 = null;
        }
        AdditionalBooleanParameter additionalBooleanParameter2 = (AdditionalBooleanParameter) findAdditionalParameter2;
        boolean booleanValue2 = (additionalBooleanParameter2 == null || (value = additionalBooleanParameter2.getValue()) == null) ? false : value.booleanValue();
        if (booleanValue || booleanValue2) {
            area = this.r;
        } else {
            area = null;
        }
        return new ItemsSearchLink(searchParamsOrEmpty, null, booleanValue, area, null, booleanValue ? this.s : null, null, null, false, null, null, booleanValue2, 1792, null);
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @Nullable
    public MetroResponseBody getMetroWithLines() {
        LocationInfo locationInfo = this.a;
        if (locationInfo != null) {
            return locationInfo.getNewMetroBody();
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005e, code lost:
        if (r1 != null) goto L_0x0060;
     */
    @Override // com.avito.android.search.filter.FiltersInteractor
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.avito.android.remote.model.SearchParams getSearchParamsOrEmpty() {
        /*
            r28 = this;
            r0 = r28
            com.avito.android.search.filter.ParametersTreeWithAdditional r1 = r0.c
            if (r1 == 0) goto L_0x000f
            com.avito.android.search.filter.ParametersTreeSearchParamsConverter r2 = r0.w
            com.avito.android.remote.model.SearchParams r1 = r2.convert(r1)
            if (r1 == 0) goto L_0x000f
            goto L_0x0015
        L_0x000f:
            com.avito.android.remote.model.SearchParams r1 = r0.q
            com.avito.android.remote.model.SearchParams r1 = r0.g(r1)
        L_0x0015:
            r2 = r1
            r3 = 0
            com.avito.android.remote.model.SearchParams r1 = r0.q
            r4 = 0
            if (r1 == 0) goto L_0x0022
            java.lang.String r1 = r1.getQuery()
            r12 = r1
            goto L_0x0023
        L_0x0022:
            r12 = r4
        L_0x0023:
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            com.avito.android.search.filter.ParametersTreeWithAdditional r1 = r0.c
            if (r1 == 0) goto L_0x0033
            com.avito.android.remote.model.Coordinates r1 = r0.a(r1)
            goto L_0x0034
        L_0x0033:
            r1 = r4
        L_0x0034:
            com.avito.android.remote.model.Coordinates r13 = r0.d
            java.lang.String r14 = "distance"
            if (r13 != 0) goto L_0x004f
            com.avito.android.remote.model.Coordinates r13 = r2.getGeoCoords()
            r0.d = r13
            java.lang.String r13 = r2.getSort()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r13 == 0) goto L_0x004f
            if (r1 != 0) goto L_0x004f
            r28.i()
        L_0x004f:
            java.lang.String r13 = r2.getSort()
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual(r13, r14)
            if (r13 == 0) goto L_0x005e
            if (r1 != 0) goto L_0x005e
            com.avito.android.remote.model.Coordinates r1 = r0.d
            goto L_0x0060
        L_0x005e:
            if (r1 == 0) goto L_0x0061
        L_0x0060:
            r4 = r1
        L_0x0061:
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 8388093(0x7ffdfd, float:1.1754222E-38)
            r27 = 0
            com.avito.android.remote.model.SearchParams r1 = com.avito.android.remote.model.SearchParams.copy$default(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.search.filter.FiltersInteractorImpl.getSearchParamsOrEmpty():com.avito.android.remote.model.SearchParams");
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(wrap: double : 0x007e: INVOKE  (r4v0 double) = (r2v11 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLatitude():double), (',' char), (wrap: double : 0x008a: INVOKE  (r4v2 double) = (r2v11 com.avito.android.remote.model.Coordinates) type: VIRTUAL call: com.avito.android.remote.model.Coordinates.getLongitude():double)] */
    public final Observable<LoadingState<ParametersTreeWithAdditional>> h(Boolean bool) {
        Map<String, String> map;
        Coordinates a3;
        this.f = bool;
        ParametersTreeWithAdditional parametersTreeWithAdditional = this.c;
        if (Intrinsics.areEqual(bool, Boolean.TRUE) || parametersTreeWithAdditional == null) {
            Observable<List<Category>> subscribeOn = this.k.getCategories().subscribeOn(this.y.newThread());
            Intrinsics.checkNotNullExpressionValue(subscribeOn, "categoriesInteractor.get…n(schedulers.newThread())");
            ParametersTreeWithAdditional parametersTreeWithAdditional2 = this.c;
            if (parametersTreeWithAdditional2 != null) {
                map = t6.n.r.toMutableMap(this.v.convert(parametersTreeWithAdditional2));
                map.remove(ParameterId.CATEGORIES);
                map.remove(ParameterId.SUBCATEGORIES);
            } else {
                map = SearchParamsConverter.DefaultImpls.convertToMap$default(this.u, g(this.q), null, false, false, 14, null);
            }
            if (hasSearchArea()) {
                map = t6.n.r.plus(map, AreaKt.toMap(this.r));
            }
            ParametersTreeWithAdditional parametersTreeWithAdditional3 = this.c;
            if (!(parametersTreeWithAdditional3 == null || (a3 = a(parametersTreeWithAdditional3)) == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(a3.getLatitude());
                sb.append(',');
                sb.append(a3.getLongitude());
                map = t6.n.r.plus(map, TuplesKt.to(UrlParams.GEO_COORDS, sb.toString()));
            }
            boolean z2 = this.t;
            if (z2) {
                map = t6.n.r.plus(map, TuplesKt.to(UrlParams.SIMPLE_MAP, String.valueOf(z2)));
            }
            Observable<R> onErrorReturn = this.n.getSearchParameters(map).map(o.a).onErrorReturn(new p(this));
            Intrinsics.checkNotNullExpressionValue(onErrorReturn, "searchApi.getSearchParam…eConverter.convert(it)) }");
            Observable just = Observable.just(LoadingState.Loading.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(just, "Observable.just(this)");
            Observable<R> startWith = onErrorReturn.startWith(just);
            Intrinsics.checkNotNullExpressionValue(startWith, "loadSearchParameters().s….toSingletonObservable())");
            Observable combineLatest = Observable.combineLatest(subscribeOn, startWith, FiltersInteractorImpl$parametersTree$$inlined$observableCombineLatest$1.INSTANCE);
            Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…1, t2 -> t1 to t2 }\n    )");
            return a2.b.a.a.a.a2(this.y, combineLatest.switchMap(new i(this)).onErrorReturn(new j(this)), "observableCombineLatest(…scribeOn(schedulers.io())");
        }
        Observable<LoadingState<ParametersTreeWithAdditional>> just2 = Observable.just(new LoadingState.Loaded(parametersTreeWithAdditional));
        Intrinsics.checkNotNullExpressionValue(just2, "Observable.just(this)");
        return just2;
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public boolean hasSearchArea() {
        return this.r != null;
    }

    public final void i() {
        this.C.trackFindCoordinates(FindLocationPage.DISTANCE_SORT.getValue());
        DisposableKt.plusAssign(this.h, this.A.subscriberChangeLocation());
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @Nullable
    public Boolean isRenamedSearchLocation() {
        LocationInfo locationInfo = this.a;
        if (locationInfo != null) {
            return Boolean.valueOf(locationInfo.getRenamed());
        }
        return null;
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void onLocationNotFound(@Nullable String str) {
        if (str != null) {
            this.C.trackResolveCoordinates(null, str);
        }
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putParcelable("location_info", this.a);
        kundle.putParcelable("top_location", this.b);
        kundle.putParcelable("parameters_tree", this.c);
        kundle.putParcelable("coordinates", this.d);
        kundle.putBoolean("last_updates_form", this.f);
        return kundle.putParcelable("last_counter_button", this.e);
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    @NotNull
    public Observable<LoadingState<ParametersTreeWithAdditional>> parametersTreeStream() {
        h(this.f).subscribe(new t(new Function1<LoadingState<? super ParametersTreeWithAdditional>, Unit>(this) { // from class: com.avito.android.search.filter.FiltersInteractorImpl.k
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
                LoadingState<? super ParametersTreeWithAdditional> loadingState2 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState2, "p1");
                FiltersInteractorImpl.access$acceptParametersTreeChange((FiltersInteractorImpl) this.receiver, loadingState2);
                return Unit.INSTANCE;
            }
        }));
        return this.j;
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void registerLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.B.registerLocationReceiver(context);
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void sendScreenExitAfterCoordinatesResolve() {
        this.C.trackScreenExitAfterCoordinatesResolve();
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void subscribeOnNotPermissionGranted(@Nullable View view) {
        this.C.trackResolveCoordinates(null, "PERMISSION DENIED");
        if (view != null) {
            DisposableKt.plusAssign(this.h, this.A.subscriberNotPermissionGranted(view));
        }
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void unregisterLocationReceiver(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.B.unregisterLocationReceiver(context);
    }

    @Override // com.avito.android.search.filter.FiltersInteractor
    public void updateStateBySearchParams(@Nullable SearchParams searchParams) {
        this.q = searchParams;
        this.c = null;
        CompositeDisposable compositeDisposable = this.h;
        Disposable subscribe = h(Boolean.TRUE).subscribe(new t(new Function1<LoadingState<? super ParametersTreeWithAdditional>, Unit>(this) { // from class: com.avito.android.search.filter.FiltersInteractorImpl.l
            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(LoadingState<? super ParametersTreeWithAdditional> loadingState) {
                LoadingState<? super ParametersTreeWithAdditional> loadingState2 = loadingState;
                Intrinsics.checkNotNullParameter(loadingState2, "p1");
                FiltersInteractorImpl.access$acceptParametersTreeChange((FiltersInteractorImpl) this.receiver, loadingState2);
                return Unit.INSTANCE;
            }
        }));
        Intrinsics.checkNotNullExpressionValue(subscribe, "parametersTree(updatesFo…ceptParametersTreeChange)");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    public static final Observable access$toLocationInfo(FiltersInteractorImpl filtersInteractorImpl, Observable observable) {
        Objects.requireNonNull(filtersInteractorImpl);
        Observable flatMap = observable.flatMap(new s(filtersInteractorImpl));
        Intrinsics.checkNotNullExpressionValue(flatMap, "flatMap { it.toLocationInfo() }");
        return flatMap;
    }
}
