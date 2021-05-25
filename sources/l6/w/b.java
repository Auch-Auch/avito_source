package l6.w;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.IMultiInstanceInvalidationCallback;
import androidx.room.IMultiInstanceInvalidationService;
import androidx.room.InvalidationTracker;
import androidx.room.MultiInstanceInvalidationService;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
public class b {
    public final Context a;
    public final String b;
    public int c;
    public final InvalidationTracker d;
    public final InvalidationTracker.Observer e;
    @Nullable
    public IMultiInstanceInvalidationService f;
    public final Executor g;
    public final IMultiInstanceInvalidationCallback h = new a();
    public final AtomicBoolean i = new AtomicBoolean(false);
    public final ServiceConnection j;
    public final Runnable k;
    public final Runnable l;
    public final Runnable m;

    public class a extends IMultiInstanceInvalidationCallback.Stub {

        /* renamed from: l6.w.b$a$a  reason: collision with other inner class name */
        public class RunnableC0539a implements Runnable {
            public final /* synthetic */ String[] a;

            public RunnableC0539a(String[] strArr) {
                this.a = strArr;
            }

            @Override // java.lang.Runnable
            public void run() {
                b.this.d.notifyObserversByTableNames(this.a);
            }
        }

        public a() {
        }

        @Override // androidx.room.IMultiInstanceInvalidationCallback
        public void onInvalidation(String[] strArr) {
            b.this.g.execute(new RunnableC0539a(strArr));
        }
    }

    /* renamed from: l6.w.b$b  reason: collision with other inner class name */
    public class ServiceConnectionC0540b implements ServiceConnection {
        public ServiceConnectionC0540b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            b.this.f = IMultiInstanceInvalidationService.Stub.asInterface(iBinder);
            b bVar = b.this;
            bVar.g.execute(bVar.k);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            b bVar = b.this;
            bVar.g.execute(bVar.l);
            b.this.f = null;
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                b bVar = b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar.f;
                if (iMultiInstanceInvalidationService != null) {
                    bVar.c = iMultiInstanceInvalidationService.registerCallback(bVar.h, bVar.b);
                    b bVar2 = b.this;
                    bVar2.d.addObserver(bVar2.e);
                }
            } catch (RemoteException unused) {
            }
        }
    }

    public class d implements Runnable {
        public d() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.d.removeObserver(bVar.e);
        }
    }

    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            b bVar = b.this;
            bVar.d.removeObserver(bVar.e);
            try {
                b bVar2 = b.this;
                IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar2.f;
                if (iMultiInstanceInvalidationService != null) {
                    iMultiInstanceInvalidationService.unregisterCallback(bVar2.h, bVar2.c);
                }
            } catch (RemoteException unused) {
            }
            b bVar3 = b.this;
            bVar3.a.unbindService(bVar3.j);
        }
    }

    public class f extends InvalidationTracker.Observer {
        public f(String[] strArr) {
            super(strArr);
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public boolean a() {
            return true;
        }

        @Override // androidx.room.InvalidationTracker.Observer
        public void onInvalidated(@NonNull Set<String> set) {
            if (!b.this.i.get()) {
                try {
                    b bVar = b.this;
                    IMultiInstanceInvalidationService iMultiInstanceInvalidationService = bVar.f;
                    if (iMultiInstanceInvalidationService != null) {
                        iMultiInstanceInvalidationService.broadcastInvalidation(bVar.c, (String[]) set.toArray(new String[0]));
                    }
                } catch (RemoteException unused) {
                }
            }
        }
    }

    public b(Context context, String str, InvalidationTracker invalidationTracker, Executor executor) {
        ServiceConnectionC0540b bVar = new ServiceConnectionC0540b();
        this.j = bVar;
        this.k = new c();
        this.l = new d();
        this.m = new e();
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = str;
        this.d = invalidationTracker;
        this.g = executor;
        this.e = new f((String[]) invalidationTracker.a.keySet().toArray(new String[0]));
        applicationContext.bindService(new Intent(applicationContext, MultiInstanceInvalidationService.class), bVar, 1);
    }
}
