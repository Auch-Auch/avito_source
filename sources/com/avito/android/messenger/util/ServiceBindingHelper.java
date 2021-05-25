package com.avito.android.messenger.util;

import a2.g.r.g;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000S\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u001c\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010#\u001a\u00020 \u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\n\b\u0002\u0010'\u001a\u0004\u0018\u00010$\u0012<\b\u0002\u0010\u001b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00020\u0016\u0012%\b\u0002\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u0007\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012¢\u0006\u0004\b(\u0010)J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004R3\u0010\r\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014RJ\u0010\u001b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0018\u0010'\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/messenger/util/ServiceBindingHelper;", "", "", "startService", "()V", "bindService", "unbindService", "Lkotlin/Function1;", "Landroid/content/ComponentName;", "Lkotlin/ParameterName;", "name", "f", "Lkotlin/jvm/functions/Function1;", "onDisconnected", "Landroid/content/Intent;", "c", "Landroid/content/Intent;", "intent", "Lkotlin/Function0;", g.a, "Lkotlin/jvm/functions/Function0;", "onUnbind", "Lkotlin/Function2;", "Landroid/os/IBinder;", NotificationCompat.CATEGORY_SERVICE, "e", "Lkotlin/jvm/functions/Function2;", "onConnected", "com/avito/android/messenger/util/ServiceBindingHelper$serviceConnectionWrapper$1", AuthSource.SEND_ABUSE, "Lcom/avito/android/messenger/util/ServiceBindingHelper$serviceConnectionWrapper$1;", "serviceConnectionWrapper", "Landroid/content/Context;", AuthSource.BOOKING_ORDER, "Landroid/content/Context;", "context", "Landroid/content/ServiceConnection;", "d", "Landroid/content/ServiceConnection;", "serviceConnection", "<init>", "(Landroid/content/Context;Landroid/content/Intent;Landroid/content/ServiceConnection;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class ServiceBindingHelper {
    public final ServiceBindingHelper$serviceConnectionWrapper$1 a;
    public final Context b;
    public final Intent c;
    public final ServiceConnection d;
    public final Function2<ComponentName, IBinder, Unit> e;
    public final Function1<ComponentName, Unit> f;
    public final Function0<Unit> g;

    public static final class a extends Lambda implements Function2<ComponentName, IBinder, Unit> {
        public static final a a = new a();

        public a() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
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

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
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

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: kotlin.jvm.functions.Function2<? super android.content.ComponentName, ? super android.os.IBinder, kotlin.Unit> */
    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: kotlin.jvm.functions.Function1<? super android.content.ComponentName, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public ServiceBindingHelper(@NotNull Context context, @NotNull Intent intent, @Nullable ServiceConnection serviceConnection, @NotNull Function2<? super ComponentName, ? super IBinder, Unit> function2, @NotNull Function1<? super ComponentName, Unit> function1, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        Intrinsics.checkNotNullParameter(function2, "onConnected");
        Intrinsics.checkNotNullParameter(function1, "onDisconnected");
        Intrinsics.checkNotNullParameter(function0, "onUnbind");
        this.b = context;
        this.c = intent;
        this.d = serviceConnection;
        this.e = function2;
        this.f = function1;
        this.g = function0;
        this.a = new ServiceBindingHelper$serviceConnectionWrapper$1(this);
    }

    public final void bindService() {
        this.b.bindService(this.c, this.a, 1);
    }

    public final void startService() {
        this.b.startService(this.c);
    }

    public final void unbindService() {
        try {
            this.b.unbindService(this.a);
        } catch (IllegalArgumentException unused) {
        } catch (Throwable th) {
            this.g.invoke();
            throw th;
        }
        this.g.invoke();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ServiceBindingHelper(Context context, Intent intent, ServiceConnection serviceConnection, Function2 function2, Function1 function1, Function0 function0, int i, j jVar) {
        this(context, intent, (i & 4) != 0 ? null : serviceConnection, (i & 8) != 0 ? a.a : function2, (i & 16) != 0 ? b.a : function1, (i & 32) != 0 ? c.a : function0);
    }
}
