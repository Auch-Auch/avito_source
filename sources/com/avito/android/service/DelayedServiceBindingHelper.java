package com.avito.android.service;

import a2.g.r.g;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\t\u0018\u00002\u00020\u0001B \u0001\u0012\u0006\u0010\u0018\u001a\u00020\u0015\u0012\u0006\u0010)\u001a\u00020&\u0012\u0006\u00101\u001a\u00020.\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0011\u0012<\b\u0002\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00020\u0019\u0012%\b\u0002\u0010-\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00020*\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r¢\u0006\u0004\b2\u00103J\u000f\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017RJ\u0010!\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001c\u0012\u0015\u0012\u0013\u0018\u00010\u001d¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001e\u0012\u0004\u0012\u00020\u00020\u00198\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R3\u0010-\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00064"}, d2 = {"Lcom/avito/android/service/DelayedServiceBindingHelper;", "Landroidx/lifecycle/LifecycleObserver;", "", "onStop", "()V", "onDestroy", "startService", "bindService", "unbindService", "com/avito/android/service/DelayedServiceBindingHelper$serviceConnectionWrapper$1", AuthSource.BOOKING_ORDER, "Lcom/avito/android/service/DelayedServiceBindingHelper$serviceConnectionWrapper$1;", "serviceConnectionWrapper", "Lkotlin/Function0;", "i", "Lkotlin/jvm/functions/Function0;", "onUnbind", "Landroid/content/ServiceConnection;", "f", "Landroid/content/ServiceConnection;", "serviceConnection", "Landroid/content/Context;", "c", "Landroid/content/Context;", "context", "Lkotlin/Function2;", "Landroid/content/ComponentName;", "Lkotlin/ParameterName;", "name", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, g.a, "Lkotlin/jvm/functions/Function2;", "onConnected", "Lio/reactivex/disposables/CompositeDisposable;", AuthSource.SEND_ABUSE, "Lio/reactivex/disposables/CompositeDisposable;", "disposable", "Landroidx/lifecycle/Lifecycle;", "d", "Landroidx/lifecycle/Lifecycle;", "lifecycle", "Lkotlin/Function1;", "h", "Lkotlin/jvm/functions/Function1;", "onDisconnected", "Landroid/content/Intent;", "e", "Landroid/content/Intent;", "intent", "<init>", "(Landroid/content/Context;Landroidx/lifecycle/Lifecycle;Landroid/content/Intent;Landroid/content/ServiceConnection;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "android_release"}, k = 1, mv = {1, 4, 2})
public final class DelayedServiceBindingHelper implements LifecycleObserver {
    public final CompositeDisposable a;
    public final DelayedServiceBindingHelper$serviceConnectionWrapper$1 b;
    public final Context c;
    public final Lifecycle d;
    public final Intent e;
    public final ServiceConnection f;
    public final Function2<ComponentName, IBinder, Unit> g;
    public final Function1<ComponentName, Unit> h;
    public final Function0<Unit> i;

    public static final class a extends Lambda implements Function2<ComponentName, IBinder, Unit> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(ComponentName componentName, IBinder iBinder) {
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function1<ComponentName, Unit> {
        public static final b a = new b();

        public b() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ComponentName componentName) {
            return Unit.INSTANCE;
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public static final c a = new c();

        public c() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class d<T> implements Consumer<Boolean> {
        public final /* synthetic */ DelayedServiceBindingHelper a;

        public d(DelayedServiceBindingHelper delayedServiceBindingHelper) {
            this.a = delayedServiceBindingHelper;
        }

        @Override // io.reactivex.functions.Consumer
        public void accept(Boolean bool) {
            this.a.c.startService(this.a.e);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function2<? super android.content.ComponentName, ? super android.os.IBinder, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: kotlin.jvm.functions.Function1<? super android.content.ComponentName, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public DelayedServiceBindingHelper(@NotNull Context context, @NotNull Lifecycle lifecycle, @NotNull Intent intent, @Nullable ServiceConnection serviceConnection, @NotNull Function2<? super ComponentName, ? super IBinder, Unit> function2, @NotNull Function1<? super ComponentName, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(lifecycle, "lifecycle");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function2, "onConnected");
        Intrinsics.checkNotNullParameter(function1, "onDisconnected");
        Intrinsics.checkNotNullParameter(function0, "onUnbind");
        this.c = context;
        this.d = lifecycle;
        this.e = intent;
        this.f = serviceConnection;
        this.g = function2;
        this.h = function1;
        this.i = function0;
        this.a = new CompositeDisposable();
        this.b = new DelayedServiceBindingHelper$serviceConnectionWrapper$1(this);
        lifecycle.addObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    private final void onDestroy() {
        this.d.removeObserver(this);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    private final void onStop() {
        this.a.clear();
    }

    public final void bindService() {
        this.c.bindService(this.e, this.b, 1);
    }

    public final void startService() {
        if (Build.VERSION.SDK_INT < 26) {
            this.c.startService(this.e);
        } else {
            this.a.add(Single.just(Boolean.TRUE).delaySubscription(300, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(new d(this)));
        }
    }

    public final void unbindService() {
        try {
            this.c.unbindService(this.b);
        } catch (IllegalArgumentException unused) {
        } catch (Throwable th) {
            this.i.invoke();
            throw th;
        }
        this.i.invoke();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DelayedServiceBindingHelper(Context context, Lifecycle lifecycle, Intent intent, ServiceConnection serviceConnection, Function2 function2, Function1 function1, Function0 function0, int i2, j jVar) {
        this(context, lifecycle, intent, (i2 & 8) != 0 ? null : serviceConnection, (i2 & 16) != 0 ? a.a : function2, (i2 & 32) != 0 ? b.a : function1, (i2 & 64) != 0 ? c.a : function0);
    }
}
