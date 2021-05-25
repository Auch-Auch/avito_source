package com.avito.android.location_picker;

import a2.a.a.n1.a0;
import a2.a.a.n1.b0;
import a2.a.a.n1.c0;
import a2.a.a.n1.d0;
import a2.a.a.n1.e;
import a2.a.a.n1.e0;
import a2.a.a.n1.f;
import a2.a.a.n1.f0;
import a2.a.a.n1.g0;
import a2.a.a.n1.h;
import a2.a.a.n1.h0;
import a2.a.a.n1.i;
import a2.a.a.n1.i0;
import a2.a.a.n1.j;
import a2.a.a.n1.j0;
import a2.a.a.n1.k;
import a2.a.a.n1.k0;
import a2.a.a.n1.l;
import a2.a.a.n1.m;
import a2.a.a.n1.m0;
import a2.a.a.n1.n0;
import a2.a.a.n1.o0;
import a2.a.a.n1.p0;
import a2.a.a.n1.q;
import a2.a.a.n1.q0;
import a2.a.a.n1.r0;
import a2.a.a.n1.s;
import a2.a.a.n1.s0;
import a2.a.a.n1.t;
import a2.a.a.n1.u;
import a2.a.a.n1.u0;
import a2.a.a.n1.v;
import a2.a.a.n1.w;
import a2.a.a.n1.x;
import a2.a.a.n1.y;
import a2.a.a.n1.z;
import a2.g.r.g;
import android.app.Activity;
import com.avito.android.avito_map.AvitoMapPoint;
import com.avito.android.location.analytics.FindLocationPage;
import com.avito.android.location.analytics.LocationAnalyticsInteractor;
import com.avito.android.location.find.FusedLocationInteractor;
import com.avito.android.location_picker.LocationPickerBinder;
import com.avito.android.location_picker.analytics.LocationPickerAnalyticsInteractor;
import com.avito.android.location_picker.entities.ActivityResult;
import com.avito.android.location_picker.entities.LocationPickerErrors;
import com.avito.android.location_picker.entities.LocationPickerState;
import com.avito.android.location_picker.job.JobAssistantInteractor;
import com.avito.android.location_picker.job.SendLocationToJobAssistant;
import com.avito.android.location_picker.providers.AddressGeoCoder;
import com.avito.android.location_picker.providers.AddressValidationProvider;
import com.avito.android.location_picker.providers.AdvertsCountProvider;
import com.avito.android.location_picker.providers.LocationPickerAnalyticsProvider;
import com.avito.android.location_picker.providers.RadiusListProvider;
import com.avito.android.location_picker.view.LocationPickerInputView;
import com.avito.android.location_picker.view.LocationPickerOutputView;
import com.avito.android.location_picker.view.LocationPickerViewChangerKt;
import com.avito.android.permissions.LocationPermissionProvider;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Coordinates;
import com.avito.android.remote.model.SearchParamsConverter;
import com.avito.android.remote.model.SearchRadius;
import com.avito.android.util.BuildInfo;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import com.jakewharton.rxrelay3.BehaviorRelay;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000ì\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B¯\u0001\b\u0007\u0012\u0006\u00104\u001a\u00020\u0005\u0012\u0006\u0010\\\u001a\u00020Y\u0012\u0006\u0010Q\u001a\u00020N\u0012\u0006\u0010M\u001a\u00020J\u0012\u0006\u0010p\u001a\u00020m\u0012\u0006\u0010`\u001a\u00020]\u0012\u0006\u00101\u001a\u00020.\u0012\u0006\u0010d\u001a\u00020a\u0012\u0006\u0010I\u001a\u00020F\u0012\f\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u0003\u0012\u0006\u00108\u001a\u000205\u0012\u0006\u0010@\u001a\u00020=\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010h\u001a\u00020e\u0012\u0006\u0010%\u001a\u00020\"\u0012\u0006\u0010l\u001a\u00020i\u0012\u0006\u0010t\u001a\u00020q\u0012\u0006\u0010<\u001a\u000209\u0012\u0006\u0010-\u001a\u00020*\u0012\u0006\u0010D\u001a\u00020A¢\u0006\u0004\bz\u0010{J²\u0001\u0010\u000f\u001a#\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00050\u000e0\u0003\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u000328\b\u0002\u0010\u000b\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00050\u000426\u0010\r\u001a2\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u000f\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0011\u0010\u001b\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u001d\u0010\u0017R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u001c\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00050&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100R\u0016\u00104\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010D\u001a\u00020A8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bB\u0010CR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010ER\u0016\u0010I\u001a\u00020F8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bG\u0010HR\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u0016\u0010Q\u001a\u00020N8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bO\u0010PR(\u0010T\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\u00048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020U0\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010\\\u001a\u00020Y8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bZ\u0010[R\u0016\u0010`\u001a\u00020]8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010d\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bb\u0010cR\u0016\u0010h\u001a\u00020e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010l\u001a\u00020i8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bj\u0010kR\u0016\u0010p\u001a\u00020m8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bn\u0010oR\u0016\u0010t\u001a\u00020q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\br\u0010sR¿\u0001\u0010y\u001aª\u0001\u0012\u0004\u0012\u00020\u0005\u0012\u0001\u0012\u0001\u0012B\u0012@\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005 u*\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e0\u000e u*M\u0012B\u0012@\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005 u*\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000e0\u000e\u0018\u00010\u0003¢\u0006\u0002\bv0\u0003¢\u0006\u0002\bv0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010x¨\u0006|"}, d2 = {"Lcom/avito/android/location_picker/LocationPickerBinderImpl;", "Lcom/avito/android/location_picker/LocationPickerBinder;", "T", "Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function2;", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "Lkotlin/ParameterName;", "name", "state", "", "error", "errorReducer", "item", "reducer", "Lkotlin/Function1;", AuthSource.SEND_ABUSE, "(Lio/reactivex/rxjava3/core/Observable;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/location_picker/LocationPickerBinder$Router;", "router", "", "attachRouter", "(Lcom/avito/android/location_picker/LocationPickerBinder$Router;)V", "detachRouter", "()V", "Lio/reactivex/rxjava3/disposables/Disposable;", "bind", "()Lio/reactivex/rxjava3/disposables/Disposable;", "getCurrentState", "()Lcom/avito/android/location_picker/entities/LocationPickerState;", "sendScreenExitAfterCoordinatesResolve", "Lcom/avito/android/location_picker/providers/AddressValidationProvider;", VKApiConst.Q, "Lcom/avito/android/location_picker/providers/AddressValidationProvider;", "addressValidationProvider", "Lcom/avito/android/location_picker/MapTransformationsProvider;", "s", "Lcom/avito/android/location_picker/MapTransformationsProvider;", "mapTransformationsProvider", "Lcom/jakewharton/rxrelay3/BehaviorRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay3/BehaviorRelay;", "stateRelay", "Lcom/avito/android/util/BuildInfo;", "w", "Lcom/avito/android/util/BuildInfo;", "build", "Lcom/avito/android/permissions/LocationPermissionProvider;", "k", "Lcom/avito/android/permissions/LocationPermissionProvider;", "locationPermissionProvider", "e", "Lcom/avito/android/location_picker/entities/LocationPickerState;", "initialState", "Lcom/avito/android/location_picker/providers/RadiusListProvider;", "o", "Lcom/avito/android/location_picker/providers/RadiusListProvider;", "radiusListProvider", "Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;", VKApiConst.VERSION, "Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;", "sendLocationToJobAssistant", "Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "p", "Lcom/avito/android/location_picker/providers/AdvertsCountProvider;", "advertsCountProvider", "Landroid/app/Activity;", "x", "Landroid/app/Activity;", "activity", "Lcom/avito/android/location_picker/LocationPickerBinder$Router;", "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;", "locationAnalytics", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "h", "Lcom/avito/android/location_picker/providers/AddressGeoCoder;", "geoCoder", "Lcom/avito/android/location_picker/view/LocationPickerOutputView;", g.a, "Lcom/avito/android/location_picker/view/LocationPickerOutputView;", "outPutView", "d", "Lkotlin/jvm/functions/Function2;", "defaultErrorReducer", "Lcom/avito/android/location_picker/entities/ActivityResult;", "n", "Lio/reactivex/rxjava3/core/Observable;", "activityResult", "Lcom/avito/android/location_picker/view/LocationPickerInputView;", "f", "Lcom/avito/android/location_picker/view/LocationPickerInputView;", "inputView", "Lcom/avito/android/util/SchedulersFactory3;", "j", "Lcom/avito/android/util/SchedulersFactory3;", "schedulers", "Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "l", "Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;", "analyticsProvider", "Lcom/avito/android/remote/model/SearchParamsConverter;", "r", "Lcom/avito/android/remote/model/SearchParamsConverter;", "searchParametersConverter", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "t", "Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;", "analyticsInteractor", "Lcom/avito/android/location/find/FusedLocationInteractor;", "i", "Lcom/avito/android/location/find/FusedLocationInteractor;", "fusedLocation", "Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "u", "Lcom/avito/android/location_picker/job/JobAssistantInteractor;", "jobAssistantGeoInteractor", "kotlin.jvm.PlatformType", "Lio/reactivex/rxjava3/annotations/NonNull;", "c", "Lkotlin/jvm/functions/Function1;", "combinedStateChanges", "<init>", "(Lcom/avito/android/location_picker/entities/LocationPickerState;Lcom/avito/android/location_picker/view/LocationPickerInputView;Lcom/avito/android/location_picker/view/LocationPickerOutputView;Lcom/avito/android/location_picker/providers/AddressGeoCoder;Lcom/avito/android/location/find/FusedLocationInteractor;Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/permissions/LocationPermissionProvider;Lcom/avito/android/location_picker/providers/LocationPickerAnalyticsProvider;Lcom/avito/android/location/analytics/LocationAnalyticsInteractor;Lio/reactivex/rxjava3/core/Observable;Lcom/avito/android/location_picker/providers/RadiusListProvider;Lcom/avito/android/location_picker/providers/AdvertsCountProvider;Lcom/avito/android/location_picker/providers/AddressValidationProvider;Lcom/avito/android/remote/model/SearchParamsConverter;Lcom/avito/android/location_picker/MapTransformationsProvider;Lcom/avito/android/location_picker/analytics/LocationPickerAnalyticsInteractor;Lcom/avito/android/location_picker/job/JobAssistantInteractor;Lcom/avito/android/location_picker/job/SendLocationToJobAssistant;Lcom/avito/android/util/BuildInfo;Landroid/app/Activity;)V", "location-picker_release"}, k = 1, mv = {1, 4, 2})
public final class LocationPickerBinderImpl implements LocationPickerBinder {
    public LocationPickerBinder.Router a;
    public final BehaviorRelay<LocationPickerState> b;
    public final Function1<LocationPickerState, Observable<Function1<LocationPickerState, LocationPickerState>>> c = new a(this);
    public final Function2<LocationPickerState, Throwable, LocationPickerState> d = b.a;
    public final LocationPickerState e;
    public final LocationPickerInputView f;
    public final LocationPickerOutputView g;
    public final AddressGeoCoder h;
    public final FusedLocationInteractor i;
    public final SchedulersFactory3 j;
    public final LocationPermissionProvider k;
    public final LocationPickerAnalyticsProvider l;
    public final LocationAnalyticsInteractor m;
    public final Observable<ActivityResult> n;
    public final RadiusListProvider o;
    public final AdvertsCountProvider p;
    public final AddressValidationProvider q;
    public final SearchParamsConverter r;
    public final MapTransformationsProvider s;
    public final LocationPickerAnalyticsInteractor t;
    public final JobAssistantInteractor u;
    public final SendLocationToJobAssistant v;
    public final BuildInfo w;
    public final Activity x;

    public static final class a extends Lambda implements Function1<LocationPickerState, Observable<Function1<? super LocationPickerState, ? extends LocationPickerState>>> {
        public final /* synthetic */ LocationPickerBinderImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LocationPickerBinderImpl locationPickerBinderImpl) {
            super(1);
            this.a = locationPickerBinderImpl;
        }

        @Override // kotlin.jvm.functions.Function1
        public Observable<Function1<? super LocationPickerState, ? extends LocationPickerState>> invoke(LocationPickerState locationPickerState) {
            Observable observable;
            int i;
            Observable observable2;
            Observable observable3;
            Observable observable4;
            LocationPickerState locationPickerState2 = locationPickerState;
            Intrinsics.checkNotNullParameter(locationPickerState2, "currentState");
            LocationPickerBinderImpl locationPickerBinderImpl = this.a;
            Observable<R> flatMapObservable = UtilsKt.toMaybe(locationPickerState2.getSendLocationToJobAssistant()).flatMapObservable(new i0(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable, "currentState.sendLocatio…         }\n\n            }");
            Observable b = LocationPickerBinderImpl.b(locationPickerBinderImpl, flatMapObservable, null, j0.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl2 = this.a;
            Observable<Unit> observable5 = UtilsKt.toMaybe(locationPickerState2.getShouldVerifyCoords()).filter(new r1(0, locationPickerState2)).toObservable();
            Intrinsics.checkNotNullExpressionValue(observable5, "currentState.shouldVerif…          .toObservable()");
            Observable b2 = LocationPickerBinderImpl.b(locationPickerBinderImpl2, observable5, null, new h6(0, this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl3 = this.a;
            Observable<R> flatMapObservable2 = UtilsKt.toMaybe(locationPickerState2.getShouldVerifyCoords()).filter(new r1(2, locationPickerState2)).flatMapObservable(new i(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable2, "currentState.shouldVerif…bservable()\n            }");
            Observable a3 = locationPickerBinderImpl3.a(flatMapObservable2, k.a, new j(this));
            LocationPickerBinderImpl locationPickerBinderImpl4 = this.a;
            Observable<R> flatMapObservable3 = UtilsKt.toMaybe(locationPickerState2.getRadiusState().getShouldLoadRadiusList() || locationPickerState2.getShouldLoadRadiusList()).flatMapObservable(new z(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable3, "(currentState.radiusStat…bservable()\n            }");
            Observable b3 = LocationPickerBinderImpl.b(locationPickerBinderImpl4, flatMapObservable3, null, new a0(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl5 = this.a;
            Observable<R> flatMapObservable4 = UtilsKt.toMaybe(locationPickerState2.getShouldConfirmAddress()).flatMapObservable(new e(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable4, "currentState.shouldConfi…bservable()\n            }");
            Observable b4 = LocationPickerBinderImpl.b(locationPickerBinderImpl5, flatMapObservable4, null, f.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl6 = this.a;
            Observable<R> flatMapObservable5 = UtilsKt.toMaybe(locationPickerState2.getAddressValidationState().getTriggerValidateRadius()).filter(new r1(1, locationPickerState2)).flatMapObservable(new a2.a.a.n1.g(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable5, "currentState.addressVali…          }\n            }");
            Observable b5 = LocationPickerBinderImpl.b(locationPickerBinderImpl6, flatMapObservable5, null, h.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl7 = this.a;
            Observable<R> switchMap = UtilsKt.toMaybe(locationPickerState2.getShouldLoadSuggestions()).flatMapObservable(new m0(this)).switchMap(new n0(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(switchMap, "currentState.shouldLoadS…bservable()\n            }");
            Observable b6 = LocationPickerBinderImpl.b(locationPickerBinderImpl7, switchMap, null, new o0(locationPickerState2), 1);
            LocationPickerBinderImpl locationPickerBinderImpl8 = this.a;
            Observable<R> flatMapObservable6 = UtilsKt.toMaybe(locationPickerState2.getRadiusState().getShouldInvalidateAdvertsCount()).flatMapObservable(new l(this, locationPickerState2));
            Intrinsics.checkNotNullExpressionValue(flatMapObservable6, "currentState.radiusState…bservable()\n            }");
            Observable b8 = LocationPickerBinderImpl.b(locationPickerBinderImpl8, flatMapObservable6, null, m.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl9 = this.a;
            Observable<String> filter = locationPickerBinderImpl9.g.getSearchClicked().filter(f.c);
            Intrinsics.checkNotNullExpressionValue(filter, "outPutView.searchClicked…er { it.isEmpty().not() }");
            Observable b9 = LocationPickerBinderImpl.b(locationPickerBinderImpl9, filter, null, f0.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl10 = this.a;
            Observable flatMap = Observable.just(locationPickerState2.getAddressStringToSearchFor()).filter(f.b).flatMap(new x(this));
            Intrinsics.checkNotNullExpressionValue(flatMap, "Observable.just(currentS…bservable()\n            }");
            Observable b10 = LocationPickerBinderImpl.b(locationPickerBinderImpl10, flatMap, null, new y(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl11 = this.a;
            Observable b11 = LocationPickerBinderImpl.b(locationPickerBinderImpl11, locationPickerBinderImpl11.g.getCleanQueryClicked(), null, z5.h, 1);
            LocationPickerBinderImpl locationPickerBinderImpl12 = this.a;
            Observable b12 = LocationPickerBinderImpl.b(locationPickerBinderImpl12, locationPickerBinderImpl12.g.getTextQueryChanged(), null, new h0(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl13 = this.a;
            Observable b13 = LocationPickerBinderImpl.b(locationPickerBinderImpl13, locationPickerBinderImpl13.g.getDialogOkButtonClicked(), null, z5.e, 1);
            LocationPickerBinderImpl locationPickerBinderImpl14 = this.a;
            Observable b14 = LocationPickerBinderImpl.b(locationPickerBinderImpl14, locationPickerBinderImpl14.g.getSuggestionClicked(), null, new k0(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl15 = this.a;
            Observable b15 = LocationPickerBinderImpl.b(locationPickerBinderImpl15, locationPickerBinderImpl15.g.getMapConcealerClicked(), null, z5.f, 1);
            LocationPickerBinderImpl locationPickerBinderImpl16 = this.a;
            Observable<R> filter2 = locationPickerBinderImpl16.g.getFindMeClicked().map(new v(this)).filter(new r1(3, this)).flatMapSingle(new w(this)).filter(j.d);
            Intrinsics.checkNotNullExpressionValue(filter2, "outPutView.findMeClicked…     .filter { it.not() }");
            Observable b16 = LocationPickerBinderImpl.b(locationPickerBinderImpl16, filter2, null, e4.c, 1);
            LocationPickerBinder.Router router = this.a.a;
            if (router == null || !router.accessGoogleServices()) {
                observable = b16;
                i = 1;
                LocationPickerBinderImpl locationPickerBinderImpl17 = this.a;
                Observable<R> observable6 = UtilsKt.toMaybe(locationPickerState2.getShouldMoveToDeviceLocation()).flatMap(new t0(1, this)).toObservable();
                Intrinsics.checkNotNullExpressionValue(observable6, "currentState.shouldMoveT…          .toObservable()");
                observable2 = LocationPickerBinderImpl.b(locationPickerBinderImpl17, observable6, null, new h6(1, this), 1);
            } else {
                LocationPickerBinderImpl locationPickerBinderImpl18 = this.a;
                Observable<R> flatMapObservable7 = UtilsKt.toMaybe(locationPickerState2.getShouldMoveToDeviceLocation()).flatMap(new t0(0, this)).flatMapObservable(new f1(2, this));
                Intrinsics.checkNotNullExpressionValue(flatMapObservable7, "currentState.shouldMoveT…vable()\n                }");
                observable = b16;
                i = 1;
                observable2 = LocationPickerBinderImpl.b(locationPickerBinderImpl18, flatMapObservable7, null, f4.c, 1);
            }
            LocationPickerBinder.Router router2 = this.a.a;
            if (router2 == null || router2.accessGoogleServices() != i) {
                observable3 = observable2;
                LocationPickerBinderImpl locationPickerBinderImpl19 = this.a;
                Observable<R> filter3 = locationPickerBinderImpl19.g.getFindMeClicked().flatMap(new f1(i, this)).filter(j.c);
                Intrinsics.checkNotNullExpressionValue(filter3, "outPutView.findMeClicked…           .filter { it }");
                observable4 = LocationPickerBinderImpl.b(locationPickerBinderImpl19, filter3, null, e4.b, i);
            } else {
                LocationPickerBinderImpl locationPickerBinderImpl20 = this.a;
                Observable<R> flatMapSingle = locationPickerBinderImpl20.g.getFindMeClicked().flatMap(new f1(0, this)).filter(j.b).flatMapSingle(new u(this));
                Intrinsics.checkNotNullExpressionValue(flatMapSingle, "outPutView.findMeClicked…abled()\n                }");
                observable3 = observable2;
                i = 1;
                observable4 = LocationPickerBinderImpl.b(locationPickerBinderImpl20, flatMapSingle, null, f4.b, 1);
            }
            LocationPickerBinderImpl locationPickerBinderImpl21 = this.a;
            Observable filter4 = locationPickerBinderImpl21.n.filter(new b0(this));
            Intrinsics.checkNotNullExpressionValue(filter4, "activityResult\n         …estCode && it.isSuccess }");
            Observable b17 = LocationPickerBinderImpl.b(locationPickerBinderImpl21, filter4, null, c0.a, i);
            a2.a.a.n1.b bVar = new a2.a.a.n1.b(this, locationPickerState2);
            a2.a.a.n1.d dVar = new a2.a.a.n1.d(this);
            LocationPickerBinderImpl locationPickerBinderImpl22 = this.a;
            Observable<Unit> observable7 = UtilsKt.toMaybe(locationPickerState2.isInitialCoordinates()).toObservable();
            Intrinsics.checkNotNullExpressionValue(observable7, "currentState.isInitialCo…          .toObservable()");
            Observable b18 = LocationPickerBinderImpl.b(locationPickerBinderImpl22, observable7, null, g4.c, 1);
            Observable<R> onErrorReturn = UtilsKt.toMaybe(locationPickerState2.getMoveCameraToDeviceLocation()).flatMapObservable(new q(this, bVar, dVar)).onErrorReturn(s.a);
            LocationPickerBinderImpl locationPickerBinderImpl23 = this.a;
            Observable b19 = LocationPickerBinderImpl.b(locationPickerBinderImpl23, locationPickerBinderImpl23.g.getSearchFocus(), null, g0.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl24 = this.a;
            Observable<Unit> throttleFirst = locationPickerBinderImpl24.g.getCameraMovedByGesture().throttleFirst(300, TimeUnit.MILLISECONDS, this.a.j.computation());
            Intrinsics.checkNotNullExpressionValue(throttleFirst, "outPutView.cameraMovedBy…schedulers.computation())");
            Observable b20 = LocationPickerBinderImpl.b(locationPickerBinderImpl24, throttleFirst, null, g4.b, 1);
            LocationPickerBinderImpl locationPickerBinderImpl25 = this.a;
            Observable b21 = LocationPickerBinderImpl.b(locationPickerBinderImpl25, locationPickerBinderImpl25.g.getCameraIdlePositionChanged(), null, new t(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl26 = this.a;
            Observable b22 = LocationPickerBinderImpl.b(locationPickerBinderImpl26, locationPickerBinderImpl26.g.getChooseClicked(), null, z5.d, 1);
            LocationPickerBinderImpl locationPickerBinderImpl27 = this.a;
            Observable b23 = LocationPickerBinderImpl.b(locationPickerBinderImpl27, locationPickerBinderImpl27.g.getRetryClicked(), null, z5.g, 1);
            LocationPickerBinderImpl locationPickerBinderImpl28 = this.a;
            Observable b24 = LocationPickerBinderImpl.b(locationPickerBinderImpl28, locationPickerBinderImpl28.g.getSettingsClicked(), null, z5.j, 1);
            LocationPickerBinderImpl locationPickerBinderImpl29 = this.a;
            Observable b25 = LocationPickerBinderImpl.b(locationPickerBinderImpl29, locationPickerBinderImpl29.g.getBackClicked(), null, z5.b, 1);
            LocationPickerBinderImpl locationPickerBinderImpl30 = this.a;
            Observable b26 = LocationPickerBinderImpl.b(locationPickerBinderImpl30, locationPickerBinderImpl30.g.getSelectRadiusButtonClicked(), null, z5.i, 1);
            LocationPickerBinderImpl locationPickerBinderImpl31 = this.a;
            Observable b27 = LocationPickerBinderImpl.b(locationPickerBinderImpl31, locationPickerBinderImpl31.g.getRadiusClicked(), null, new d0(this), 1);
            LocationPickerBinderImpl locationPickerBinderImpl32 = this.a;
            Observable b28 = LocationPickerBinderImpl.b(locationPickerBinderImpl32, locationPickerBinderImpl32.g.getCameraMoveEnd(), null, p0.a, 1);
            LocationPickerBinderImpl locationPickerBinderImpl33 = this.a;
            Observable b29 = LocationPickerBinderImpl.b(locationPickerBinderImpl33, locationPickerBinderImpl33.g.getCameraMoveStart(), null, z5.c, 1);
            LocationPickerBinderImpl locationPickerBinderImpl34 = this.a;
            return Observable.merge(CollectionsKt__CollectionsKt.listOf((Object[]) new Observable[]{b2, a3, b4, b6, b11, b12, b14, b13, b10, observable, observable4, b18, b15, b17, onErrorReturn, observable3, b19, b9, b20, b21, b22, b23, b24, b25, b3, b26, b27, b8, b28, b29, LocationPickerBinderImpl.b(locationPickerBinderImpl34, locationPickerBinderImpl34.g.getScreenClosed(), null, new e0(this), 1), b, b5}));
        }
    }

    public static final class b extends Lambda implements Function2<LocationPickerState, Throwable, LocationPickerState> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public LocationPickerState invoke(LocationPickerState locationPickerState, Throwable th) {
            LocationPickerState locationPickerState2 = locationPickerState;
            Throwable th2 = th;
            Intrinsics.checkNotNullParameter(locationPickerState2, "state");
            Intrinsics.checkNotNullParameter(th2, "error");
            Logs.error("LocationPickerBinder", th2);
            return LocationPickerState.copy$default(locationPickerState2, null, null, false, 0.0f, null, false, null, false, false, false, null, null, LocationPickerErrors.copy$default(locationPickerState2.getErrors(), false, false, null, th2.getMessage(), false, false, false, false, false, false, 1015, null), false, false, false, null, false, null, false, null, null, 4190207, null);
        }
    }

    public static final class c<T, R> implements Function<T, Function1<? super LocationPickerState, ? extends LocationPickerState>> {
        public final /* synthetic */ Function2 a;

        public c(Function2 function2) {
            this.a = function2;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Function1<? super LocationPickerState, ? extends LocationPickerState> apply(Object obj) {
            return new q0(this, obj);
        }
    }

    public static final class d<T, R> implements Function<Throwable, Function1<? super LocationPickerState, ? extends LocationPickerState>> {
        public final /* synthetic */ Function2 a;

        public d(Function2 function2) {
            this.a = function2;
        }

        @Override // io.reactivex.rxjava3.functions.Function
        public Function1<? super LocationPickerState, ? extends LocationPickerState> apply(Throwable th) {
            return new r0(this, th);
        }
    }

    @Inject
    public LocationPickerBinderImpl(@NotNull LocationPickerState locationPickerState, @NotNull LocationPickerInputView locationPickerInputView, @NotNull LocationPickerOutputView locationPickerOutputView, @NotNull AddressGeoCoder addressGeoCoder, @NotNull FusedLocationInteractor fusedLocationInteractor, @NotNull SchedulersFactory3 schedulersFactory3, @NotNull LocationPermissionProvider locationPermissionProvider, @NotNull LocationPickerAnalyticsProvider locationPickerAnalyticsProvider, @NotNull LocationAnalyticsInteractor locationAnalyticsInteractor, @NotNull Observable<ActivityResult> observable, @NotNull RadiusListProvider radiusListProvider, @NotNull AdvertsCountProvider advertsCountProvider, @NotNull AddressValidationProvider addressValidationProvider, @NotNull SearchParamsConverter searchParamsConverter, @NotNull MapTransformationsProvider mapTransformationsProvider, @NotNull LocationPickerAnalyticsInteractor locationPickerAnalyticsInteractor, @NotNull JobAssistantInteractor jobAssistantInteractor, @NotNull SendLocationToJobAssistant sendLocationToJobAssistant, @NotNull BuildInfo buildInfo, @NotNull Activity activity) {
        Intrinsics.checkNotNullParameter(locationPickerState, "initialState");
        Intrinsics.checkNotNullParameter(locationPickerInputView, "inputView");
        Intrinsics.checkNotNullParameter(locationPickerOutputView, "outPutView");
        Intrinsics.checkNotNullParameter(addressGeoCoder, "geoCoder");
        Intrinsics.checkNotNullParameter(fusedLocationInteractor, "fusedLocation");
        Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulers");
        Intrinsics.checkNotNullParameter(locationPermissionProvider, "locationPermissionProvider");
        Intrinsics.checkNotNullParameter(locationPickerAnalyticsProvider, "analyticsProvider");
        Intrinsics.checkNotNullParameter(locationAnalyticsInteractor, "locationAnalytics");
        Intrinsics.checkNotNullParameter(observable, "activityResult");
        Intrinsics.checkNotNullParameter(radiusListProvider, "radiusListProvider");
        Intrinsics.checkNotNullParameter(advertsCountProvider, "advertsCountProvider");
        Intrinsics.checkNotNullParameter(addressValidationProvider, "addressValidationProvider");
        Intrinsics.checkNotNullParameter(searchParamsConverter, "searchParametersConverter");
        Intrinsics.checkNotNullParameter(mapTransformationsProvider, "mapTransformationsProvider");
        Intrinsics.checkNotNullParameter(locationPickerAnalyticsInteractor, "analyticsInteractor");
        Intrinsics.checkNotNullParameter(jobAssistantInteractor, "jobAssistantGeoInteractor");
        Intrinsics.checkNotNullParameter(sendLocationToJobAssistant, "sendLocationToJobAssistant");
        Intrinsics.checkNotNullParameter(buildInfo, "build");
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.e = locationPickerState;
        this.f = locationPickerInputView;
        this.g = locationPickerOutputView;
        this.h = addressGeoCoder;
        this.i = fusedLocationInteractor;
        this.j = schedulersFactory3;
        this.k = locationPermissionProvider;
        this.l = locationPickerAnalyticsProvider;
        this.m = locationAnalyticsInteractor;
        this.n = observable;
        this.o = radiusListProvider;
        this.p = advertsCountProvider;
        this.q = addressValidationProvider;
        this.r = searchParamsConverter;
        this.s = mapTransformationsProvider;
        this.t = locationPickerAnalyticsInteractor;
        this.u = jobAssistantInteractor;
        this.v = sendLocationToJobAssistant;
        this.w = buildInfo;
        this.x = activity;
        BehaviorRelay<LocationPickerState> create = BehaviorRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "BehaviorRelay.create<LocationPickerState>()");
        this.b = create;
    }

    public static final List access$setSelected(LocationPickerBinderImpl locationPickerBinderImpl, List list, String str) {
        Objects.requireNonNull(locationPickerBinderImpl);
        ArrayList arrayList = new ArrayList(t6.n.e.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            SearchRadius searchRadius = (SearchRadius) it.next();
            searchRadius.setActive(Intrinsics.areEqual(searchRadius.getId(), str));
            arrayList.add(searchRadius);
        }
        return arrayList;
    }

    public static final boolean access$shouldSaveZoomLevel(LocationPickerBinderImpl locationPickerBinderImpl, LocationPickerState locationPickerState) {
        Objects.requireNonNull(locationPickerBinderImpl);
        return (locationPickerState.getRadiusState().getRadiusId().length() > 0) && locationPickerState.getRadiusState().getDistanceInMeters() != 0;
    }

    public static final AvitoMapPoint access$toAvitoMapPoint(LocationPickerBinderImpl locationPickerBinderImpl, Coordinates coordinates) {
        Objects.requireNonNull(locationPickerBinderImpl);
        return new AvitoMapPoint(coordinates.getLatitude(), coordinates.getLongitude());
    }

    public static final void access$trackFindCoordinates(LocationPickerBinderImpl locationPickerBinderImpl) {
        String str;
        LocationAnalyticsInteractor locationAnalyticsInteractor = locationPickerBinderImpl.m;
        if (locationPickerBinderImpl.e.getRadiusState().getInitialRadius() != null) {
            str = FindLocationPage.SMALL_RADIUS.getValue();
        } else {
            str = FindLocationPage.ADD_ADV_MAP.getValue();
        }
        locationAnalyticsInteractor.trackFindCoordinates(str);
    }

    public static /* synthetic */ Observable b(LocationPickerBinderImpl locationPickerBinderImpl, Observable observable, Function2 function2, Function2 function22, int i2) {
        return locationPickerBinderImpl.a(observable, (i2 & 1) != 0 ? locationPickerBinderImpl.d : null, function22);
    }

    public final <T> Observable<Function1<LocationPickerState, LocationPickerState>> a(Observable<T> observable, Function2<? super LocationPickerState, ? super Throwable, LocationPickerState> function2, Function2<? super LocationPickerState, ? super T, LocationPickerState> function22) {
        Observable<R> onErrorReturn = observable.map(new c(function22)).onErrorReturn(new d(function2));
        Intrinsics.checkNotNullExpressionValue(onErrorReturn, "this\n        .map { item…Reducer(state, error) } }");
        return onErrorReturn;
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder
    public void attachRouter(@NotNull LocationPickerBinder.Router router) {
        Intrinsics.checkNotNullParameter(router, "router");
        this.a = router;
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder
    @NotNull
    public Disposable bind() {
        Disposable subscribe = this.g.getMapInitialized().ambWith(Observable.timer(5, TimeUnit.SECONDS).map(s0.a).observeOn(this.j.mainThread())).unsubscribeOn(this.j.mainThread()).switchMap(new u0(this)).observeOn(this.j.mainThread()).subscribe(this.b);
        Intrinsics.checkNotNullExpressionValue(subscribe, "outPutView\n        .mapI…   .subscribe(stateRelay)");
        return new CompositeDisposable(subscribe, LocationPickerViewChangerKt.subscribeInputView(this.f, this.b, this.s));
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder
    public void detachRouter() {
        this.a = null;
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder
    @Nullable
    public LocationPickerState getCurrentState() {
        return this.b.getValue();
    }

    @Override // com.avito.android.location_picker.LocationPickerBinder
    public void sendScreenExitAfterCoordinatesResolve() {
        this.m.trackScreenExitAfterCoordinatesResolve();
    }
}
