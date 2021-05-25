package com.avito.android.connection_quality.connectivity;

import a2.a.a.g0.a.d;
import a2.a.a.g0.a.e;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.RequiresPermission;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.SchedulersFactory;
import com.github.pwittchen.reactivenetwork.library.rx2.Connectivity;
import com.jakewharton.rxrelay2.BehaviorRelay;
import com.jakewharton.rxrelay2.PublishRelay;
import io.reactivex.Observable;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\b\u0007\u0012\u0006\u0010\u0018\u001a\u00020\u0006\u0012\u0006\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u001e\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\tR#\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8W@\u0016X\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R:\u0010\u0015\u001a&\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003 \u0007*\u0012\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00030\u0003\u0018\u00010\u00120\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\f8W@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001d"}, d2 = {"Lcom/avito/android/connection_quality/connectivity/ConnectivityProviderImpl;", "Lcom/avito/android/connection_quality/connectivity/ConnectivityProvider;", "Landroidx/lifecycle/LifecycleObserver;", "", "onAppForeground", "()V", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "applicationContext", "Lio/reactivex/Observable;", "", "c", "Lkotlin/Lazy;", "getConnectionAvailability", "()Lio/reactivex/Observable;", "connectionAvailability", "Lcom/jakewharton/rxrelay2/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/jakewharton/rxrelay2/PublishRelay;", "foregroundEvents", "isConnectionAvailable", "()Z", "context", "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "<init>", "(Landroid/content/Context;Lcom/avito/android/util/SchedulersFactory;)V", "connection-quality_release"}, k = 1, mv = {1, 4, 2})
@SuppressLint({"MissingPermission"})
public final class ConnectivityProviderImpl implements ConnectivityProvider, LifecycleObserver {
    public final Context a;
    public final PublishRelay<Unit> b = PublishRelay.create();
    @NotNull
    public final Lazy c;

    public static final class a implements Runnable {
        public final /* synthetic */ ConnectivityProviderImpl a;

        public a(ConnectivityProviderImpl connectivityProviderImpl) {
            this.a = connectivityProviderImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            LifecycleOwner lifecycleOwner = ProcessLifecycleOwner.get();
            Intrinsics.checkNotNullExpressionValue(lifecycleOwner, "ProcessLifecycleOwner.get()");
            lifecycleOwner.getLifecycle().addObserver(this.a);
        }
    }

    public static final class b extends Lambda implements Function0<BehaviorRelay<Boolean>> {
        public final /* synthetic */ ConnectivityProviderImpl a;
        public final /* synthetic */ SchedulersFactory b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ConnectivityProviderImpl connectivityProviderImpl, SchedulersFactory schedulersFactory) {
            super(0);
            this.a = connectivityProviderImpl;
            this.b = schedulersFactory;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public BehaviorRelay<Boolean> invoke() {
            BehaviorRelay<Boolean> create = BehaviorRelay.create();
            this.a.b.observeOn(this.b.computation()).startWith((Observable) Unit.INSTANCE).switchMap(new a2.a.a.g0.a.a(this)).subscribe(new d(create), new e(create));
            return create;
        }
    }

    @Inject
    public ConnectivityProviderImpl(@NotNull Context context, @NotNull SchedulersFactory schedulersFactory) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        this.a = context.getApplicationContext();
        this.c = c.lazy(new b(this, schedulersFactory));
        new Handler(Looper.getMainLooper()).post(new a(this));
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    private final void onAppForeground() {
        this.b.accept(Unit.INSTANCE);
    }

    @Override // com.avito.android.connection_quality.connectivity.ConnectivityProvider
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    @NotNull
    public Observable<Boolean> getConnectionAvailability() {
        return (Observable) this.c.getValue();
    }

    @Override // com.avito.android.connection_quality.connectivity.ConnectivityProvider
    @RequiresPermission("android.permission.ACCESS_NETWORK_STATE")
    public boolean isConnectionAvailable() {
        Connectivity create = Connectivity.create(this.a);
        Intrinsics.checkNotNullExpressionValue(create, "Connectivity.create(applicationContext)");
        return ConnectivityProviderKt.access$isConnected$p(create);
    }
}
