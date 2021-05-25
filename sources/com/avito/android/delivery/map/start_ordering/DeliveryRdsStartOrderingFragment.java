package com.avito.android.delivery.map.start_ordering;

import a2.a.a.k0.a.b.c;
import a2.a.a.k0.a.b.d;
import a2.a.a.k0.a.b.e;
import a2.a.a.k0.a.b.f;
import a2.a.a.k0.a.b.h;
import a2.a.a.k0.a.b.i;
import a2.a.a.k0.a.b.j;
import a2.a.a.k0.a.b.k;
import a2.a.a.k0.a.b.l;
import a2.a.a.k0.a.b.m;
import a2.a.a.k0.a.b.n;
import a2.a.a.k0.a.b.o;
import a2.a.a.k0.a.b.p;
import a2.a.a.k0.a.b.q;
import a2.a.a.k0.a.b.r;
import a2.g.r.g;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.avito.android.ActivityIntentFactory;
import com.avito.android.SummaryState;
import com.avito.android.account.AccountStateProvider;
import com.avito.android.advert_core.analytics.AdvertDetailsAnalyticsInteractorKt;
import com.avito.android.advert_core.marketplace.MarketplacePresenterKt;
import com.avito.android.analytics.Analytics;
import com.avito.android.analytics.screens.Timer;
import com.avito.android.analytics.screens.tracker.BaseScreenPerformanceTracker;
import com.avito.android.avito_map.AvitoMapAttachHelper;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.delivery.R;
import com.avito.android.delivery.analytics.map.PVZIsChosenEvent;
import com.avito.android.delivery.analytics.summary.DeliveryOrderInfoConfirmScreenEvent;
import com.avito.android.delivery.analytics.summary.DeliverySummaryEditOrderInfoScreenEvent;
import com.avito.android.delivery.di.component.DaggerDeliveryRdsStartOrderingComponent;
import com.avito.android.delivery.di.component.DeliveryRdsCommonDependencies;
import com.avito.android.delivery.di.component.DeliveryRdsStartOrderingComponent;
import com.avito.android.delivery.map.common.DeliveryMapView;
import com.avito.android.delivery.map.common.DeliveryMapViewImpl;
import com.avito.android.delivery.map.common.DeliveryMapViewModel;
import com.avito.android.delivery.map.common.marker.ClusterMarkerManager;
import com.avito.android.delivery.map.common.marker.DeliveryMapMarkerIconFactory;
import com.avito.android.delivery.map.common.marker.Marker;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoView;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewImpl;
import com.avito.android.delivery.map.point_info.DeliveryRdsPointInfoViewModel;
import com.avito.android.delivery.summary.DeliveryRdsSummaryActivityKt;
import com.avito.android.delivery.utils.CoordinatesKt;
import com.avito.android.di.ComponentDependenciesKt;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FindLocationPresenter;
import com.avito.android.permissions.LocationPermissionDialogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.ParametrizedEvent;
import com.avito.android.ui.fragments.BaseFragment;
import com.avito.android.util.AvitoSnackbar;
import com.avito.android.util.FragmentsKt;
import com.avito.android.util.ImplicitIntentFactory;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.avito.android.util.preferences.GeoContract;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.ItemBinder;
import com.avito.konveyor.adapter.AdapterPresenter;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0002Ö\u0001B\b¢\u0006\u0005\bÕ\u0001\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\f\u001a\u00020\u000b2\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0014¢\u0006\u0004\b\f\u0010\rJ)\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J+\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u00172\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ!\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001f\u0010\u0006J\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0004H\u0016¢\u0006\u0004\b$\u0010\u0006J\u000f\u0010%\u001a\u00020\u0004H\u0016¢\u0006\u0004\b%\u0010\u0006J\u000f\u0010&\u001a\u00020\u0004H\u0016¢\u0006\u0004\b&\u0010\u0006J\u000f\u0010'\u001a\u00020\u0004H\u0016¢\u0006\u0004\b'\u0010\u0006J\u000f\u0010(\u001a\u00020\u0004H\u0016¢\u0006\u0004\b(\u0010\u0006J\u000f\u0010)\u001a\u00020\u0004H\u0016¢\u0006\u0004\b)\u0010\u0006J\u000f\u0010*\u001a\u00020\u0004H\u0016¢\u0006\u0004\b*\u0010\u0006J\u0019\u0010-\u001a\u00020\u00042\b\u0010,\u001a\u0004\u0018\u00010+H\u0016¢\u0006\u0004\b-\u0010.J\u000f\u0010/\u001a\u00020\u0004H\u0016¢\u0006\u0004\b/\u0010\u0006R\u0016\u00103\u001a\u0002008\u0002@\u0002X.¢\u0006\u0006\n\u0004\b1\u00102R\"\u00105\u001a\u0002048\u0006@\u0006X.¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\"\u0010<\u001a\u00020;8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010C\u001a\u00020B8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u0010JR\u0016\u0010N\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\"\u0010P\u001a\u00020O8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X.¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\u0018\u0010e\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bd\u0010JR\"\u0010g\u001a\u00020f8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bg\u0010h\u001a\u0004\bi\u0010j\"\u0004\bk\u0010lR\"\u0010n\u001a\u00020m8\u0006@\u0006X.¢\u0006\u0012\n\u0004\bn\u0010o\u001a\u0004\bp\u0010q\"\u0004\br\u0010sR\u0016\u0010w\u001a\u00020t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\bu\u0010vR\u0016\u0010{\u001a\u00020x8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0016\u0010}\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b|\u0010MR'\u0010\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0017\n\u0005\b\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010JR*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b\u0001\u0010JR*\u0010\u0001\u001a\u00030\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b\u0001\u0010 \u0001\u001a\u0006\b¡\u0001\u0010¢\u0001\"\u0006\b£\u0001\u0010¤\u0001R*\u0010¦\u0001\u001a\u00030¥\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¦\u0001\u0010§\u0001\u001a\u0006\b¨\u0001\u0010©\u0001\"\u0006\bª\u0001\u0010«\u0001R\u001a\u0010­\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010JR*\u0010¯\u0001\u001a\u00030®\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¯\u0001\u0010°\u0001\u001a\u0006\b±\u0001\u0010²\u0001\"\u0006\b³\u0001\u0010´\u0001R*\u0010¶\u0001\u001a\u00030µ\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b¶\u0001\u0010·\u0001\u001a\u0006\b¸\u0001\u0010¹\u0001\"\u0006\bº\u0001\u0010»\u0001R*\u0010½\u0001\u001a\u00030¼\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R\u001a\u0010Ä\u0001\u001a\u0004\u0018\u00010+8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bÃ\u0001\u0010JR\u0018\u0010Æ\u0001\u001a\u00020\u000b8\u0002@\u0002X\u000e¢\u0006\u0007\n\u0005\bÅ\u0001\u0010MR)\u0010Ç\u0001\u001a\u00020~8\u0006@\u0006X.¢\u0006\u0018\n\u0006\bÇ\u0001\u0010\u0001\u001a\u0006\bÈ\u0001\u0010\u0001\"\u0006\bÉ\u0001\u0010\u0001R*\u0010Ë\u0001\u001a\u00030Ê\u00018\u0006@\u0006X.¢\u0006\u0018\n\u0006\bË\u0001\u0010Ì\u0001\u001a\u0006\bÍ\u0001\u0010Î\u0001\"\u0006\bÏ\u0001\u0010Ð\u0001R\u001c\u0010Ô\u0001\u001a\u0005\u0018\u00010Ñ\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001¨\u0006×\u0001"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;", "Lcom/avito/android/ui/fragments/BaseFragment;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Router;", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter$Subscriber;", "", AuthSource.SEND_ABUSE, "()V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "setUpFragmentComponent", "(Landroid/os/Bundle;)Z", "", "requestCode", "resultCode", "Landroid/content/Intent;", "data", "onActivityResult", "(IILandroid/content/Intent;)V", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onStart", "Landroid/content/Context;", "context", "onAttach", "(Landroid/content/Context;)V", "onResume", "onPause", "onStop", "onDestroy", "onLowMemory", "findLocation", "onClickLocationSnackbar", "", "error", "onLocationNotFound", "(Ljava/lang/String;)V", "onNotPermissionGranted", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView;", "d", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoView;", "pointInfoView", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "avitoMapAttachHelper", "Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "getAvitoMapAttachHelper", "()Lcom/avito/android/avito_map/AvitoMapAttachHelper;", "setAvitoMapAttachHelper", "(Lcom/avito/android/avito_map/AvitoMapAttachHelper;)V", "Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "mapViewModel", "Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "getMapViewModel", "()Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;", "setMapViewModel", "(Lcom/avito/android/delivery/map/common/DeliveryMapViewModel;)V", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "tracker", "Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "getTracker", "()Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;", "setTracker", "(Lcom/avito/android/analytics/screens/tracker/BaseScreenPerformanceTracker;)V", "f", "Ljava/lang/String;", BookingInfoActivity.EXTRA_ITEM_ID, "h", "Z", "isMarketplace", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "adapterPresenter", "Lcom/avito/konveyor/adapter/AdapterPresenter;", "getAdapterPresenter", "()Lcom/avito/konveyor/adapter/AdapterPresenter;", "setAdapterPresenter", "(Lcom/avito/konveyor/adapter/AdapterPresenter;)V", "Lcom/avito/android/analytics/Analytics;", "analytics", "Lcom/avito/android/analytics/Analytics;", "getAnalytics", "()Lcom/avito/android/analytics/Analytics;", "setAnalytics", "(Lcom/avito/android/analytics/Analytics;)V", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "startOrderingViewModel", "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "getStartOrderingViewModel", "()Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;", "setStartOrderingViewModel", "(Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingViewModel;)V", "n", "source", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/util/SchedulersFactory3;", "getSchedulers", "()Lcom/avito/android/util/SchedulersFactory3;", "setSchedulers", "(Lcom/avito/android/util/SchedulersFactory3;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/util/text/AttributedTextFormatter;", "getAttributedTextFormatter", "()Lcom/avito/android/util/text/AttributedTextFormatter;", "setAttributedTextFormatter", "(Lcom/avito/android/util/text/AttributedTextFormatter;)V", "Lcom/avito/android/delivery/map/common/DeliveryMapView;", "c", "Lcom/avito/android/delivery/map/common/DeliveryMapView;", "mapView", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "e", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "subscriptions", AuthSource.OPEN_CHANNEL_LIST, "fromSummary", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "locationPermissionDialogPresenter", "Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "getLocationPermissionDialogPresenter", "()Lcom/avito/android/permissions/LocationPermissionDialogPresenter;", "setLocationPermissionDialogPresenter", "(Lcom/avito/android/permissions/LocationPermissionDialogPresenter;)V", "k", "searchContext", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "clusterMarkerManager", "Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "getClusterMarkerManager", "()Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;", "setClusterMarkerManager", "(Lcom/avito/android/delivery/map/common/marker/ClusterMarkerManager;)V", "Lcom/avito/android/location/find/FindLocationPresenter;", "findLocationPresenter", "Lcom/avito/android/location/find/FindLocationPresenter;", "getFindLocationPresenter", "()Lcom/avito/android/location/find/FindLocationPresenter;", "setFindLocationPresenter", "(Lcom/avito/android/location/find/FindLocationPresenter;)V", "Lcom/avito/android/account/AccountStateProvider;", "accountState", "Lcom/avito/android/account/AccountStateProvider;", "getAccountState", "()Lcom/avito/android/account/AccountStateProvider;", "setAccountState", "(Lcom/avito/android/account/AccountStateProvider;)V", g.a, "analyticsAdvertId", "Lcom/avito/konveyor/ItemBinder;", "itemBinder", "Lcom/avito/konveyor/ItemBinder;", "getItemBinder", "()Lcom/avito/konveyor/ItemBinder;", "setItemBinder", "(Lcom/avito/konveyor/ItemBinder;)V", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "iconFactory", "Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "getIconFactory", "()Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;", "setIconFactory", "(Lcom/avito/android/delivery/map/common/marker/DeliveryMapMarkerIconFactory;)V", "l", "cartItems", "Lcom/avito/android/util/ImplicitIntentFactory;", "implicitIntentFactory", "Lcom/avito/android/util/ImplicitIntentFactory;", "getImplicitIntentFactory", "()Lcom/avito/android/util/ImplicitIntentFactory;", "setImplicitIntentFactory", "(Lcom/avito/android/util/ImplicitIntentFactory;)V", "Lcom/avito/android/ActivityIntentFactory;", "intentFactory", "Lcom/avito/android/ActivityIntentFactory;", "getIntentFactory", "()Lcom/avito/android/ActivityIntentFactory;", "setIntentFactory", "(Lcom/avito/android/ActivityIntentFactory;)V", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalyticsInteractor", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "getLocationAnalyticsInteractor", "()Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "setLocationAnalyticsInteractor", "(Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;)V", "j", "safedealServices", "i", "isCart", "locationPermissionPresenter", "getLocationPermissionPresenter", "setLocationPermissionPresenter", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "pointInfoViewModel", "Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "getPointInfoViewModel", "()Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;", "setPointInfoViewModel", "(Lcom/avito/android/delivery/map/point_info/DeliveryRdsPointInfoViewModel;)V", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "o", "Lcom/avito/android/delivery/map/common/marker/Marker$Pin;", "selectedPin", "<init>", "Factory", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class DeliveryRdsStartOrderingFragment extends BaseFragment implements LocationPermissionDialogPresenter.Router, LocationPermissionDialogPresenter.Subscriber {
    @Inject
    public AccountStateProvider accountState;
    @Inject
    public AdapterPresenter adapterPresenter;
    @Inject
    public Analytics analytics;
    @Inject
    public AttributedTextFormatter attributedTextFormatter;
    @Inject
    public AvitoMapAttachHelper avitoMapAttachHelper;
    public DeliveryMapView c;
    @Inject
    public ClusterMarkerManager clusterMarkerManager;
    public DeliveryRdsPointInfoView d;
    public final CompositeDisposable e = new CompositeDisposable();
    public String f;
    @Inject
    public FindLocationPresenter findLocationPresenter;
    public String g;
    public boolean h;
    public boolean i;
    @Inject
    public DeliveryMapMarkerIconFactory iconFactory;
    @Inject
    public ImplicitIntentFactory implicitIntentFactory;
    @Inject
    public ActivityIntentFactory intentFactory;
    @Inject
    public ItemBinder itemBinder;
    public String j;
    public String k;
    public String l;
    @Inject
    public LocationAnalyticsInteractor locationAnalyticsInteractor;
    @Inject
    public LocationPermissionDialogPresenter locationPermissionDialogPresenter;
    @Inject
    public LocationPermissionDialogPresenter locationPermissionPresenter;
    public boolean m;
    @Inject
    public DeliveryMapViewModel mapViewModel;
    public String n;
    public Marker.Pin o;
    @Inject
    public DeliveryRdsPointInfoViewModel pointInfoViewModel;
    @Inject
    public SchedulersFactory3 schedulers;
    @Inject
    public DeliveryRdsStartOrderingViewModel startOrderingViewModel;
    @Inject
    public BaseScreenPerformanceTracker tracker;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J_\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0010J\u0001\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u000f\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment$Factory;", "", "", BookingInfoActivity.EXTRA_ITEM_ID, "source", "searchContext", "", "isMarketplace", "isCart", "firstCartItemId", "cartItems", "fromSummary", "Lcom/avito/android/remote/model/ParametrizedEvent;", MarketplacePresenterKt.KEY_CONTACT_EVENT, "Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;", "createInstance", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;ZLcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;", "", GeoContract.LATITUDE, GeoContract.LONGITUDE, "fiasGuid", "", "serviceIDs", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLjava/lang/String;Ljava/lang/String;DDLjava/lang/String;Ljava/util/List;ZLcom/avito/android/remote/model/ParametrizedEvent;)Lcom/avito/android/delivery/map/start_ordering/DeliveryRdsStartOrderingFragment;", "<init>", "()V", "delivery_release"}, k = 1, mv = {1, 4, 2})
    public static final class Factory {

        public static final class a extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ String f;
            public final /* synthetic */ String g;
            public final /* synthetic */ boolean h;
            public final /* synthetic */ ParametrizedEvent i;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, boolean z3, ParametrizedEvent parametrizedEvent) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = z;
                this.e = z2;
                this.f = str4;
                this.g = str5;
                this.h = z3;
                this.i = parametrizedEvent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                String str = this.a;
                if (str != null) {
                    bundle2.putString("advert_id", str);
                }
                bundle2.putString("source", this.b);
                String str2 = this.c;
                if (str2 != null) {
                    bundle2.putString("search_context", str2);
                }
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, this.d);
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, this.e);
                bundle2.putString(DeliveryRdsStartOrderingActivityKt.EXTRA_FIRST_CART_ITEM_ID, this.f);
                bundle2.putString(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_ITEMS, this.g);
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_FROM_SUMMARY, this.h);
                bundle2.putParcelable(DeliveryRdsStartOrderingActivityKt.EXTRA_CONTACT_EVENT, this.i);
                return Unit.INSTANCE;
            }
        }

        public static final class b extends Lambda implements Function1<Bundle, Unit> {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ boolean d;
            public final /* synthetic */ boolean e;
            public final /* synthetic */ String f;
            public final /* synthetic */ String g;
            public final /* synthetic */ double h;
            public final /* synthetic */ double i;
            public final /* synthetic */ String j;
            public final /* synthetic */ boolean k;
            public final /* synthetic */ List l;
            public final /* synthetic */ ParametrizedEvent m;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public b(String str, String str2, String str3, boolean z, boolean z2, String str4, String str5, double d2, double d3, String str6, boolean z3, List list, ParametrizedEvent parametrizedEvent) {
                super(1);
                this.a = str;
                this.b = str2;
                this.c = str3;
                this.d = z;
                this.e = z2;
                this.f = str4;
                this.g = str5;
                this.h = d2;
                this.i = d3;
                this.j = str6;
                this.k = z3;
                this.l = list;
                this.m = parametrizedEvent;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public Unit invoke(Bundle bundle) {
                Bundle bundle2 = bundle;
                Intrinsics.checkNotNullParameter(bundle2, "$receiver");
                String str = this.a;
                if (str != null) {
                    bundle2.putString("advert_id", str);
                }
                bundle2.putString("source", this.b);
                String str2 = this.c;
                if (str2 != null) {
                    bundle2.putString("search_context", str2);
                }
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG, this.d);
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG, this.e);
                bundle2.putString(DeliveryRdsStartOrderingActivityKt.EXTRA_FIRST_CART_ITEM_ID, this.f);
                bundle2.putString(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_ITEMS, this.g);
                bundle2.putDouble(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LAT, this.h);
                bundle2.putDouble(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LNG, this.i);
                bundle2.putString(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_FIAS_GUID, this.j);
                bundle2.putBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_FROM_SUMMARY, this.k);
                if (this.l != null) {
                    bundle2.putStringArrayList(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_SERVICE_IDS, new ArrayList<>(this.l));
                }
                bundle2.putParcelable(DeliveryRdsStartOrderingActivityKt.EXTRA_CONTACT_EVENT, this.m);
                return Unit.INSTANCE;
            }
        }

        @NotNull
        public final DeliveryRdsStartOrderingFragment createInstance(@Nullable String str, @NotNull String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, boolean z3, @Nullable ParametrizedEvent parametrizedEvent) {
            Intrinsics.checkNotNullParameter(str2, "source");
            return (DeliveryRdsStartOrderingFragment) FragmentsKt.arguments(new DeliveryRdsStartOrderingFragment(), 6, new a(str, str2, str3, z, z2, str4, str5, z3, parametrizedEvent));
        }

        @NotNull
        public final DeliveryRdsStartOrderingFragment createInstance(@Nullable String str, @Nullable String str2, @Nullable String str3, boolean z, boolean z2, @Nullable String str4, @Nullable String str5, double d, double d2, @Nullable String str6, @Nullable List<String> list, boolean z3, @Nullable ParametrizedEvent parametrizedEvent) {
            return (DeliveryRdsStartOrderingFragment) FragmentsKt.arguments(new DeliveryRdsStartOrderingFragment(), 6, new b(str, str2, str3, z, z2, str4, str5, d, d2, str6, z3, list, parametrizedEvent));
        }
    }

    public static final class a<T> implements Consumer<Location> {
        public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

        public a(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
            this.a = deliveryRdsStartOrderingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Location location) {
            Location location2 = location;
            LocationAnalyticsInteractor.DefaultImpls.trackResolveCoordinates$default(this.a.getLocationAnalyticsInteractor(), location2, null, 2, null);
            Intrinsics.checkNotNullExpressionValue(location2, "newUserLocation");
            AvitoMapPoint avitoMapPoint = new AvitoMapPoint(location2.getLatitude(), location2.getLongitude());
            this.a.getStartOrderingViewModel().onNewLocation(avitoMapPoint);
            DeliveryRdsStartOrderingFragment.access$onNewLocation(this.a, avitoMapPoint);
        }
    }

    public static final class b<T> implements Consumer<Throwable> {
        public final /* synthetic */ DeliveryRdsStartOrderingFragment a;

        public b(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
            this.a = deliveryRdsStartOrderingFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(Throwable th) {
            Throwable th2 = th;
            this.a.getLocationAnalyticsInteractor().trackResolveCoordinates(null, th2.getMessage());
            this.a.getMapViewModel().requestLocationFromServer();
            this.a.getStartOrderingViewModel().onNewLocation(null);
            Logs.error(th2);
        }
    }

    public static final void access$findMe(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        deliveryRdsStartOrderingFragment.a();
        DeliveryMapViewModel deliveryMapViewModel = deliveryRdsStartOrderingFragment.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.onFindMeClick();
    }

    public static final /* synthetic */ DeliveryMapView access$getMapView$p(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        DeliveryMapView deliveryMapView = deliveryRdsStartOrderingFragment.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        return deliveryMapView;
    }

    public static final /* synthetic */ DeliveryRdsPointInfoView access$getPointInfoView$p(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment) {
        DeliveryRdsPointInfoView deliveryRdsPointInfoView = deliveryRdsStartOrderingFragment.d;
        if (deliveryRdsPointInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointInfoView");
        }
        return deliveryRdsPointInfoView;
    }

    public static final void access$onNewLocation(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, AvitoMapPoint avitoMapPoint) {
        DeliveryMapViewModel deliveryMapViewModel = deliveryRdsStartOrderingFragment.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.onNewLocation(avitoMapPoint);
    }

    public static final void access$openDeliveryRdsSummary(DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment, String str, String str2, String str3, String str4) {
        Integer num;
        SummaryState summaryState;
        SummaryState copy$default;
        Objects.requireNonNull(deliveryRdsStartOrderingFragment);
        if (str2 == null) {
            num = Integer.valueOf(R.string.delivery_point_not_selected);
        } else {
            num = str3 == null ? Integer.valueOf(R.string.has_error_occurred) : null;
        }
        if (num != null) {
            num.intValue();
            View view = deliveryRdsStartOrderingFragment.getView();
            if (view != null) {
                AvitoSnackbar avitoSnackbar = AvitoSnackbar.INSTANCE;
                Intrinsics.checkNotNullExpressionValue(view, "it");
                AvitoSnackbar.make$default(avitoSnackbar, view, num.intValue(), 0, null, 0, null, null, 0, 0, 504, null).show();
            }
            DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel = deliveryRdsStartOrderingFragment.pointInfoViewModel;
            if (deliveryRdsPointInfoViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pointInfoViewModel");
            }
            deliveryRdsPointInfoViewModel.hide();
            return;
        }
        Analytics analytics2 = deliveryRdsStartOrderingFragment.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        analytics2.track(new PVZIsChosenEvent());
        if (deliveryRdsStartOrderingFragment.m) {
            FragmentActivity activity = deliveryRdsStartOrderingFragment.getActivity();
            if (activity != null) {
                Intent intent = new Intent();
                intent.putExtra(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE, new SummaryState(str4, str3, str2, str, null, false, 48, null));
                activity.setResult(-1, intent);
            }
            FragmentActivity activity2 = deliveryRdsStartOrderingFragment.getActivity();
            if (activity2 != null) {
                activity2.finish();
            }
        } else {
            Context requireContext = deliveryRdsStartOrderingFragment.requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            String str5 = deliveryRdsStartOrderingFragment.k;
            DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel = deliveryRdsStartOrderingFragment.startOrderingViewModel;
            if (deliveryRdsStartOrderingViewModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
            }
            SummaryState summaryState2 = deliveryRdsStartOrderingViewModel.summaryState();
            if (summaryState2 == null || (copy$default = SummaryState.copy$default(summaryState2, str4, str3, str2, str, null, false, 48, null)) == null) {
                summaryState = new SummaryState(str4, str3, str2, str, null, false, 48, null);
            } else {
                summaryState = copy$default;
            }
            deliveryRdsStartOrderingFragment.startActivityForResult(DeliveryRdsSummaryActivityKt.createDeliveryRdsSummaryIntent(requireContext, str5, summaryState, deliveryRdsStartOrderingFragment.i, deliveryRdsStartOrderingFragment.h, deliveryRdsStartOrderingFragment.n), 2);
        }
        Analytics analytics3 = deliveryRdsStartOrderingFragment.analytics;
        if (analytics3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        String str6 = deliveryRdsStartOrderingFragment.g;
        AccountStateProvider accountStateProvider = deliveryRdsStartOrderingFragment.accountState;
        if (accountStateProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountState");
        }
        analytics3.track(new DeliveryOrderInfoConfirmScreenEvent(str6, accountStateProvider.getCurrentUserId(), deliveryRdsStartOrderingFragment.h, deliveryRdsStartOrderingFragment.i, deliveryRdsStartOrderingFragment.l, deliveryRdsStartOrderingFragment.j));
    }

    public final void a() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        locationAnalyticsInteractor2.trackFindCoordinates(FindLocationPage.DELIVERY_MAP.getValue());
        CompositeDisposable compositeDisposable = this.e;
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        DisposableKt.plusAssign(compositeDisposable, locationPermissionDialogPresenter2.subscriberChangeLocation());
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Router
    public void findLocation() {
        CompositeDisposable compositeDisposable = this.e;
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        Disposable subscribe = FindLocationPresenter.DefaultImpls.findLocation$default(findLocationPresenter2, requireActivity, false, 2, null).subscribe(new a(this), new b(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "findLocationPresenter.fi…ror(error)\n            })");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
    }

    @NotNull
    public final AccountStateProvider getAccountState() {
        AccountStateProvider accountStateProvider = this.accountState;
        if (accountStateProvider == null) {
            Intrinsics.throwUninitializedPropertyAccessException("accountState");
        }
        return accountStateProvider;
    }

    @NotNull
    public final AdapterPresenter getAdapterPresenter() {
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        return adapterPresenter2;
    }

    @NotNull
    public final Analytics getAnalytics() {
        Analytics analytics2 = this.analytics;
        if (analytics2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("analytics");
        }
        return analytics2;
    }

    @NotNull
    public final AttributedTextFormatter getAttributedTextFormatter() {
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        return attributedTextFormatter2;
    }

    @NotNull
    public final AvitoMapAttachHelper getAvitoMapAttachHelper() {
        AvitoMapAttachHelper avitoMapAttachHelper2 = this.avitoMapAttachHelper;
        if (avitoMapAttachHelper2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avitoMapAttachHelper");
        }
        return avitoMapAttachHelper2;
    }

    @NotNull
    public final ClusterMarkerManager getClusterMarkerManager() {
        ClusterMarkerManager clusterMarkerManager2 = this.clusterMarkerManager;
        if (clusterMarkerManager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clusterMarkerManager");
        }
        return clusterMarkerManager2;
    }

    @NotNull
    public final FindLocationPresenter getFindLocationPresenter() {
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        return findLocationPresenter2;
    }

    @NotNull
    public final DeliveryMapMarkerIconFactory getIconFactory() {
        DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory = this.iconFactory;
        if (deliveryMapMarkerIconFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconFactory");
        }
        return deliveryMapMarkerIconFactory;
    }

    @NotNull
    public final ImplicitIntentFactory getImplicitIntentFactory() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        return implicitIntentFactory2;
    }

    @NotNull
    public final ActivityIntentFactory getIntentFactory() {
        ActivityIntentFactory activityIntentFactory = this.intentFactory;
        if (activityIntentFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("intentFactory");
        }
        return activityIntentFactory;
    }

    @NotNull
    public final ItemBinder getItemBinder() {
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        return itemBinder2;
    }

    @NotNull
    public final LocationAnalyticsInteractor getLocationAnalyticsInteractor() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        return locationAnalyticsInteractor2;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionDialogPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final LocationPermissionDialogPresenter getLocationPermissionPresenter() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionPresenter");
        }
        return locationPermissionDialogPresenter2;
    }

    @NotNull
    public final DeliveryMapViewModel getMapViewModel() {
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        return deliveryMapViewModel;
    }

    @NotNull
    public final DeliveryRdsPointInfoViewModel getPointInfoViewModel() {
        DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel = this.pointInfoViewModel;
        if (deliveryRdsPointInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointInfoViewModel");
        }
        return deliveryRdsPointInfoViewModel;
    }

    @NotNull
    public final SchedulersFactory3 getSchedulers() {
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        return schedulersFactory3;
    }

    @NotNull
    public final DeliveryRdsStartOrderingViewModel getStartOrderingViewModel() {
        DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel = this.startOrderingViewModel;
        if (deliveryRdsStartOrderingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
        }
        return deliveryRdsStartOrderingViewModel;
    }

    @NotNull
    public final BaseScreenPerformanceTracker getTracker() {
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        return baseScreenPerformanceTracker;
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i2, int i3, @Nullable Intent intent) {
        super.onActivityResult(i2, i3, intent);
        Coordinates coordinates = null;
        SummaryState summaryState = null;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    if (i3 == -1) {
                        DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel = this.startOrderingViewModel;
                        if (deliveryRdsStartOrderingViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
                        }
                        deliveryRdsStartOrderingViewModel.onAuthCompleted();
                        a();
                        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
                        if (deliveryMapViewModel == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
                        }
                        deliveryMapViewModel.onFindMeClick();
                        DeliveryMapViewModel deliveryMapViewModel2 = this.mapViewModel;
                        if (deliveryMapViewModel2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
                        }
                        deliveryMapViewModel2.showContent();
                        return;
                    }
                    FragmentActivity activity = getActivity();
                    if (activity != null) {
                        activity.finish();
                    }
                }
            } else if (i3 == -1) {
                if (intent != null) {
                    summaryState = (SummaryState) intent.getParcelableExtra(DeliveryRdsSummaryActivityKt.EXTRA_SUMMARY_STATE);
                }
                DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel2 = this.startOrderingViewModel;
                if (deliveryRdsStartOrderingViewModel2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
                }
                deliveryRdsStartOrderingViewModel2.setDataFromCheckout(summaryState);
                if (summaryState != null) {
                    Analytics analytics2 = this.analytics;
                    if (analytics2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("analytics");
                    }
                    String str = this.f;
                    AccountStateProvider accountStateProvider = this.accountState;
                    if (accountStateProvider == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("accountState");
                    }
                    analytics2.track(new DeliverySummaryEditOrderInfoScreenEvent(str, accountStateProvider.getCurrentUserId(), this.h, this.i, this.j));
                    return;
                }
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    activity2.setResult(-1, intent);
                }
                FragmentActivity activity3 = getActivity();
                if (activity3 != null) {
                    activity3.finish();
                }
            } else {
                DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel3 = this.startOrderingViewModel;
                if (deliveryRdsStartOrderingViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
                }
                deliveryRdsStartOrderingViewModel3.setDataFromCheckout(null);
            }
        } else if (i3 == -1) {
            if (intent != null) {
                coordinates = (Coordinates) intent.getParcelableExtra(DeliveryRdsStartOrderingFragmentKt.EXTRA_COORDINATES);
            }
            if (coordinates != null) {
                DeliveryMapViewModel deliveryMapViewModel3 = this.mapViewModel;
                if (deliveryMapViewModel3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
                }
                deliveryMapViewModel3.moveCamera(CoordinatesKt.toAvitoMapPoint(coordinates));
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
        FragmentActivity requireActivity = requireActivity();
        Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
        requireActivity.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(this, true) { // from class: com.avito.android.delivery.map.start_ordering.DeliveryRdsStartOrderingFragment$onAttach$1
            public final /* synthetic */ DeliveryRdsStartOrderingFragment c;

            {
                this.c = r1;
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                if (this.c.getStartOrderingViewModel().isNeedOpenCheckout()) {
                    SummaryState summaryState = this.c.getStartOrderingViewModel().summaryState();
                    DeliveryRdsStartOrderingFragment deliveryRdsStartOrderingFragment = this.c;
                    String str = deliveryRdsStartOrderingFragment.f;
                    String str2 = null;
                    String serviceId = summaryState != null ? summaryState.getServiceId() : null;
                    String fiasGuid = summaryState != null ? summaryState.getFiasGuid() : null;
                    if (summaryState != null) {
                        str2 = summaryState.getMarkerId();
                    }
                    DeliveryRdsStartOrderingFragment.access$openDeliveryRdsSummary(deliveryRdsStartOrderingFragment, str, serviceId, fiasGuid, str2);
                    return;
                }
                setEnabled(false);
                this.c.requireActivity().finish();
            }
        });
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onClickLocationSnackbar() {
        ImplicitIntentFactory implicitIntentFactory2 = this.implicitIntentFactory;
        if (implicitIntentFactory2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("implicitIntentFactory");
        }
        startActivity(implicitIntentFactory2.createAppSettingsIntent());
    }

    @Override // com.avito.android.ui.fragments.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory = this.iconFactory;
        if (deliveryMapMarkerIconFactory == null) {
            Intrinsics.throwUninitializedPropertyAccessException("iconFactory");
        }
        deliveryMapViewModel.attachIconFactory(deliveryMapMarkerIconFactory);
    }

    @Override // androidx.fragment.app.Fragment
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.startInit();
        View inflate = layoutInflater.inflate(R.layout.delivery_rds_fragment_start_ordering, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflater.inflate(R.layou…dering, container, false)");
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        DeliveryMapView deliveryMapView = this.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        deliveryMapView.onMapDestroy();
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.detachIconFactory();
        super.onDestroy();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onLocationNotFound(@Nullable String str) {
        if (str != null) {
            LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
            if (locationAnalyticsInteractor2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
            }
            locationAnalyticsInteractor2.trackResolveCoordinates(null, str);
        }
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.requestLocationFromServer();
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public void onLowMemory() {
        super.onLowMemory();
        DeliveryMapView deliveryMapView = this.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        deliveryMapView.onMapLowMemory();
    }

    @Override // com.avito.android.permissions.LocationPermissionDialogPresenter.Subscriber
    public void onNotPermissionGranted() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        locationAnalyticsInteractor2.trackResolveCoordinates(null, "PERMISSION DENIED");
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.requestLocationFromServer();
        View view = getView();
        if (view != null) {
            CompositeDisposable compositeDisposable = this.e;
            LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionPresenter;
            if (locationPermissionDialogPresenter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("locationPermissionPresenter");
            }
            Intrinsics.checkNotNullExpressionValue(view, "it");
            DisposableKt.plusAssign(compositeDisposable, locationPermissionDialogPresenter2.subscriberNotPermissionGranted(view));
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        LocationAnalyticsInteractor locationAnalyticsInteractor2 = this.locationAnalyticsInteractor;
        if (locationAnalyticsInteractor2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationAnalyticsInteractor");
        }
        locationAnalyticsInteractor2.trackScreenExitAfterCoordinatesResolve();
        DeliveryMapView deliveryMapView = this.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        deliveryMapView.onMapPause();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.unregisterLocationReceiver(requireContext);
        super.onPause();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        DeliveryMapView deliveryMapView = this.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        deliveryMapView.onMapResume();
        FindLocationPresenter findLocationPresenter2 = this.findLocationPresenter;
        if (findLocationPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("findLocationPresenter");
        }
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        findLocationPresenter2.registerLocationReceiver(requireContext);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        DeliveryMapView deliveryMapView = this.c;
        if (deliveryMapView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        Disposable subscribe = deliveryMapView.getCameraCoordinatesObservable().subscribe(new f(this));
        Intrinsics.checkNotNullExpressionValue(subscribe, "mapView.cameraCoordinate…oordinates)\n            }");
        DisposableKt.addTo(subscribe, this.e);
        Disposable subscribe2 = deliveryMapView.getFindMeClicks().throttleFirst(1000, TimeUnit.MILLISECONDS).subscribe(new h(this), new i(this));
        Intrinsics.checkNotNullExpressionValue(subscribe2, "mapView.findMeClicks\n   …          }\n            )");
        DisposableKt.addTo(subscribe2, this.e);
        Disposable subscribe3 = deliveryMapView.getMarkersClicks().subscribe(new j(this, deliveryMapView));
        Intrinsics.checkNotNullExpressionValue(subscribe3, "mapView.markersClicks\n  …          }\n            }");
        DisposableKt.addTo(subscribe3, this.e);
        DeliveryRdsPointInfoView deliveryRdsPointInfoView = this.d;
        if (deliveryRdsPointInfoView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointInfoView");
        }
        Observable<Unit> bottomSheetHideObservable = deliveryRdsPointInfoView.getBottomSheetHideObservable();
        SchedulersFactory3 schedulersFactory3 = this.schedulers;
        if (schedulersFactory3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe4 = bottomSheetHideObservable.observeOn(schedulersFactory3.mainThread()).subscribe(new e1(0, this));
        Intrinsics.checkNotNullExpressionValue(subscribe4, "pointInfoView.bottomShee…odel.hide()\n            }");
        DisposableKt.addTo(subscribe4, this.e);
        Observable<Unit> submitButtonClicks = deliveryRdsPointInfoView.getSubmitButtonClicks();
        SchedulersFactory3 schedulersFactory32 = this.schedulers;
        if (schedulersFactory32 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe5 = submitButtonClicks.observeOn(schedulersFactory32.mainThread()).subscribe(new e1(1, this));
        Intrinsics.checkNotNullExpressionValue(subscribe5, "pointInfoView.submitButt…          )\n            }");
        DisposableKt.addTo(subscribe5, this.e);
        Observable<Unit> retryButtonClicks = deliveryRdsPointInfoView.getRetryButtonClicks();
        SchedulersFactory3 schedulersFactory33 = this.schedulers;
        if (schedulersFactory33 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("schedulers");
        }
        Disposable subscribe6 = retryButtonClicks.observeOn(schedulersFactory33.mainThread()).subscribe(new e1(2, this));
        Intrinsics.checkNotNullExpressionValue(subscribe6, "pointInfoView.retryButto…ntInfoViewModel.retry() }");
        DisposableKt.addTo(subscribe6, this.e);
        DeliveryMapView deliveryMapView2 = this.c;
        if (deliveryMapView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapView");
        }
        deliveryMapView2.initPlatformMap();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionPresenter");
        }
        locationPermissionDialogPresenter2.attachRouter(this);
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionPresenter");
        }
        locationPermissionDialogPresenter3.setSubscriber(this);
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        LocationPermissionDialogPresenter locationPermissionDialogPresenter2 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter2.detachSubscriber();
        LocationPermissionDialogPresenter locationPermissionDialogPresenter3 = this.locationPermissionDialogPresenter;
        if (locationPermissionDialogPresenter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("locationPermissionDialogPresenter");
        }
        locationPermissionDialogPresenter3.detachRouter();
        this.e.clear();
        super.onStop();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        toolbar.setNavigationIcon(com.avito.android.ui_components.R.drawable.ic_close_24);
        toolbar.setNavigationOnClickListener(new q(this));
        toolbar.inflateMenu(R.menu.delivery_point_map_geo);
        toolbar.setOnMenuItemClickListener(new r(this));
        FragmentManager fragmentManager = getFragmentManager();
        if (fragmentManager != null) {
            Intrinsics.checkNotNullExpressionValue(fragmentManager, "fragmentManager ?: return");
            Analytics analytics2 = this.analytics;
            if (analytics2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("analytics");
            }
            ClusterMarkerManager clusterMarkerManager2 = this.clusterMarkerManager;
            if (clusterMarkerManager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clusterMarkerManager");
            }
            AvitoMapAttachHelper avitoMapAttachHelper2 = this.avitoMapAttachHelper;
            if (avitoMapAttachHelper2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("avitoMapAttachHelper");
            }
            DeliveryMapViewImpl deliveryMapViewImpl = new DeliveryMapViewImpl(view, analytics2, clusterMarkerManager2, avitoMapAttachHelper2, fragmentManager);
            deliveryMapViewImpl.getMapIsReadyChanges().observe(getViewLifecycleOwner(), new p(this));
            this.c = deliveryMapViewImpl;
        }
        AdapterPresenter adapterPresenter2 = this.adapterPresenter;
        if (adapterPresenter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapterPresenter");
        }
        ItemBinder itemBinder2 = this.itemBinder;
        if (itemBinder2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemBinder");
        }
        AttributedTextFormatter attributedTextFormatter2 = this.attributedTextFormatter;
        if (attributedTextFormatter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("attributedTextFormatter");
        }
        this.d = new DeliveryRdsPointInfoViewImpl(view, adapterPresenter2, itemBinder2, attributedTextFormatter2);
        DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel = this.pointInfoViewModel;
        if (deliveryRdsPointInfoViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pointInfoViewModel");
        }
        deliveryRdsPointInfoViewModel.getPointInfoStateChanges().observe(getViewLifecycleOwner(), new a2.a.a.k0.a.b.a(this));
        deliveryRdsPointInfoViewModel.getSnackBarEvents().observe(getViewLifecycleOwner(), new a2.a.a.k0.a.b.b(this));
        Marker.Pin pin = this.o;
        if (pin != null) {
            deliveryRdsPointInfoViewModel.onMarkerClicked(pin);
        }
        DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel = this.startOrderingViewModel;
        if (deliveryRdsStartOrderingViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("startOrderingViewModel");
        }
        deliveryRdsStartOrderingViewModel.getNewMarkersEvents().observe(getViewLifecycleOwner(), new c(this));
        deliveryRdsStartOrderingViewModel.getOverlayEvent().observe(getViewLifecycleOwner(), new d(this));
        deliveryRdsStartOrderingViewModel.getSnackBarEvents().observe(getViewLifecycleOwner(), new y2(0, this));
        deliveryRdsStartOrderingViewModel.getAuthScreenChanges().observe(getViewLifecycleOwner(), new e(this));
        deliveryRdsStartOrderingViewModel.getPreselectPinEvent().observe(getViewLifecycleOwner(), new a2.a.a.k0.a.b.g(this));
        deliveryRdsStartOrderingViewModel.getSelectCheckoutPinEvent().observe(getViewLifecycleOwner(), new y2(1, this));
        DeliveryMapViewModel deliveryMapViewModel = this.mapViewModel;
        if (deliveryMapViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mapViewModel");
        }
        deliveryMapViewModel.getRequestLocationEvents().observe(getViewLifecycleOwner(), new k(this, deliveryMapViewModel));
        deliveryMapViewModel.getSnackBarEvents().observe(getViewLifecycleOwner(), new l(this));
        deliveryMapViewModel.getMarkerClicks().observe(getViewLifecycleOwner(), new m(this));
        deliveryMapViewModel.getSelectedMarkerDisappearedEvents().observe(getViewLifecycleOwner(), new n(this));
        deliveryMapViewModel.getViewStateChanges().observe(getViewLifecycleOwner(), new o(this));
        AvitoMapAttachHelper avitoMapAttachHelper3 = this.avitoMapAttachHelper;
        if (avitoMapAttachHelper3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("avitoMapAttachHelper");
        }
        deliveryMapViewModel.setMapAttachHelper(avitoMapAttachHelper3);
        BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
        if (baseScreenPerformanceTracker == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tracker");
        }
        baseScreenPerformanceTracker.trackInit();
    }

    public final void setAccountState(@NotNull AccountStateProvider accountStateProvider) {
        Intrinsics.checkNotNullParameter(accountStateProvider, "<set-?>");
        this.accountState = accountStateProvider;
    }

    public final void setAdapterPresenter(@NotNull AdapterPresenter adapterPresenter2) {
        Intrinsics.checkNotNullParameter(adapterPresenter2, "<set-?>");
        this.adapterPresenter = adapterPresenter2;
    }

    public final void setAnalytics(@NotNull Analytics analytics2) {
        Intrinsics.checkNotNullParameter(analytics2, "<set-?>");
        this.analytics = analytics2;
    }

    public final void setAttributedTextFormatter(@NotNull AttributedTextFormatter attributedTextFormatter2) {
        Intrinsics.checkNotNullParameter(attributedTextFormatter2, "<set-?>");
        this.attributedTextFormatter = attributedTextFormatter2;
    }

    public final void setAvitoMapAttachHelper(@NotNull AvitoMapAttachHelper avitoMapAttachHelper2) {
        Intrinsics.checkNotNullParameter(avitoMapAttachHelper2, "<set-?>");
        this.avitoMapAttachHelper = avitoMapAttachHelper2;
    }

    public final void setClusterMarkerManager(@NotNull ClusterMarkerManager clusterMarkerManager2) {
        Intrinsics.checkNotNullParameter(clusterMarkerManager2, "<set-?>");
        this.clusterMarkerManager = clusterMarkerManager2;
    }

    public final void setFindLocationPresenter(@NotNull FindLocationPresenter findLocationPresenter2) {
        Intrinsics.checkNotNullParameter(findLocationPresenter2, "<set-?>");
        this.findLocationPresenter = findLocationPresenter2;
    }

    public final void setIconFactory(@NotNull DeliveryMapMarkerIconFactory deliveryMapMarkerIconFactory) {
        Intrinsics.checkNotNullParameter(deliveryMapMarkerIconFactory, "<set-?>");
        this.iconFactory = deliveryMapMarkerIconFactory;
    }

    public final void setImplicitIntentFactory(@NotNull ImplicitIntentFactory implicitIntentFactory2) {
        Intrinsics.checkNotNullParameter(implicitIntentFactory2, "<set-?>");
        this.implicitIntentFactory = implicitIntentFactory2;
    }

    public final void setIntentFactory(@NotNull ActivityIntentFactory activityIntentFactory) {
        Intrinsics.checkNotNullParameter(activityIntentFactory, "<set-?>");
        this.intentFactory = activityIntentFactory;
    }

    public final void setItemBinder(@NotNull ItemBinder itemBinder2) {
        Intrinsics.checkNotNullParameter(itemBinder2, "<set-?>");
        this.itemBinder = itemBinder2;
    }

    public final void setLocationAnalyticsInteractor(@NotNull LocationAnalyticsInteractor locationAnalyticsInteractor2) {
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor2, "<set-?>");
        this.locationAnalyticsInteractor = locationAnalyticsInteractor2;
    }

    public final void setLocationPermissionDialogPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
        this.locationPermissionDialogPresenter = locationPermissionDialogPresenter2;
    }

    public final void setLocationPermissionPresenter(@NotNull LocationPermissionDialogPresenter locationPermissionDialogPresenter2) {
        Intrinsics.checkNotNullParameter(locationPermissionDialogPresenter2, "<set-?>");
        this.locationPermissionPresenter = locationPermissionDialogPresenter2;
    }

    public final void setMapViewModel(@NotNull DeliveryMapViewModel deliveryMapViewModel) {
        Intrinsics.checkNotNullParameter(deliveryMapViewModel, "<set-?>");
        this.mapViewModel = deliveryMapViewModel;
    }

    public final void setPointInfoViewModel(@NotNull DeliveryRdsPointInfoViewModel deliveryRdsPointInfoViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsPointInfoViewModel, "<set-?>");
        this.pointInfoViewModel = deliveryRdsPointInfoViewModel;
    }

    public final void setSchedulers(@NotNull SchedulersFactory3 schedulersFactory3) {
        Intrinsics.checkNotNullParameter(schedulersFactory3, "<set-?>");
        this.schedulers = schedulersFactory3;
    }

    public final void setStartOrderingViewModel(@NotNull DeliveryRdsStartOrderingViewModel deliveryRdsStartOrderingViewModel) {
        Intrinsics.checkNotNullParameter(deliveryRdsStartOrderingViewModel, "<set-?>");
        this.startOrderingViewModel = deliveryRdsStartOrderingViewModel;
    }

    public final void setTracker(@NotNull BaseScreenPerformanceTracker baseScreenPerformanceTracker) {
        Intrinsics.checkNotNullParameter(baseScreenPerformanceTracker, "<set-?>");
        this.tracker = baseScreenPerformanceTracker;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r4v0 double), (',' char), (r6v0 double)] */
    @Override // com.avito.android.ui.fragments.BaseFragment
    public boolean setUpFragmentComponent(@Nullable Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            Intrinsics.checkNotNullExpressionValue(arguments, "arguments ?: throw Illeg…tion(\"Arguments not set\")");
            this.f = arguments.getString("advert_id");
            this.n = arguments.getString("source");
            this.k = arguments.getString("search_context");
            boolean z = arguments.getBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_MARKETPLACE_FLAG);
            this.h = z;
            if (z) {
                this.j = AdvertDetailsAnalyticsInteractorKt.SAFEDEAL_SERVICE_MARKETPLACE;
            }
            this.i = arguments.getBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_FLAG);
            this.m = arguments.getBoolean(DeliveryRdsStartOrderingActivityKt.EXTRA_FROM_SUMMARY);
            String string = arguments.getString(DeliveryRdsStartOrderingActivityKt.EXTRA_FIRST_CART_ITEM_ID);
            if (!this.i) {
                string = this.f;
            }
            this.g = string;
            this.l = arguments.getString(DeliveryRdsStartOrderingActivityKt.EXTRA_CART_ITEMS);
            ParametrizedEvent parametrizedEvent = (ParametrizedEvent) arguments.getParcelable(DeliveryRdsStartOrderingActivityKt.EXTRA_CONTACT_EVENT);
            double d2 = arguments.getDouble(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LAT, 180.01d);
            double d3 = arguments.getDouble(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_LNG, 180.01d);
            String string2 = arguments.getString(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_FIAS_GUID);
            ArrayList<String> stringArrayList = arguments.getStringArrayList(DeliveryRdsStartOrderingActivityKt.EXTRA_PIN_SERVICE_IDS);
            if (!(d2 == 180.01d || d3 == 180.01d || string2 == null || stringArrayList == null)) {
                StringBuilder sb = new StringBuilder();
                sb.append(d2);
                sb.append(',');
                sb.append(d3);
                this.o = new Marker.Pin(sb.toString(), new AvitoMapPoint(d2, d3), string2, CollectionsKt___CollectionsKt.toList(stringArrayList), null, null, 32, null);
            }
            Timer B1 = a2.b.a.a.a.B1();
            DeliveryRdsStartOrderingComponent.Factory factory = DaggerDeliveryRdsStartOrderingComponent.factory();
            FragmentActivity requireActivity = requireActivity();
            Intrinsics.checkNotNullExpressionValue(requireActivity, "requireActivity()");
            Resources resources = getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            factory.create(requireActivity, resources, this, requireContext, this.f, this.g, this.n, this.h, this.i, this.l, parametrizedEvent, (DeliveryRdsCommonDependencies) ComponentDependenciesKt.getDependencies(DeliveryRdsCommonDependencies.class, ComponentDependenciesKt.findComponentDependenciesHolder(this))).inject(this);
            BaseScreenPerformanceTracker baseScreenPerformanceTracker = this.tracker;
            if (baseScreenPerformanceTracker == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tracker");
            }
            baseScreenPerformanceTracker.trackDiInject(B1.elapsed());
            return true;
        }
        throw new IllegalStateException("Arguments not set");
    }
}
