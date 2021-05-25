package com.yandex.metrica.impl.ac;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.yandex.metrica.impl.ob.ado;
import com.yandex.metrica.impl.ob.eh;
import com.yandex.metrica.impl.ob.em;
import com.yandex.metrica.impl.ob.pc;
import com.yandex.metrica.impl.ob.pd;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
public class a implements pd {
    private volatile String a = null;
    private volatile Boolean b = null;
    @NonNull
    private final ado c = new ado();

    public class b implements ServiceConnection {
        private boolean b;
        private final BlockingQueue<IBinder> c;

        private b() {
            this.b = false;
            this.c = new LinkedBlockingQueue();
        }

        public IBinder a() throws InterruptedException {
            if (!this.b) {
                this.b = true;
                return this.c.take();
            }
            throw new IllegalStateException();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.c.put(iBinder);
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    private void a(String str) {
        eh.a().b(new em(str));
        this.a = str;
    }

    private boolean b(Context context) {
        try {
            return Class.forName("com.google.android.gms.common.GooglePlayServicesUtil").getMethod("isGooglePlayServicesAvailable", Context.class).invoke(null, context).equals(0);
        } catch (Exception unused) {
            return false;
        }
    }

    private void c(Context context) {
        try {
            Object invoke = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient").getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
            Class<?> cls = Class.forName("com.google.android.gms.ads.identifier.AdvertisingIdClient$Info");
            String str = (String) cls.getMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            Boolean bool = (Boolean) cls.getMethod("isLimitAdTrackingEnabled", new Class[0]).invoke(invoke, new Object[0]);
            synchronized (this) {
                a(str);
                a(bool);
            }
        } catch (Throwable unused) {
        }
    }

    private void d(Context context) {
        b bVar = new b();
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        if (this.c.c(context, intent, 0) != null && context.bindService(intent, bVar, 1)) {
            try {
                AbstractC0334a a3 = AbstractC0334a.AbstractBinderC0335a.a(bVar.a());
                String a4 = a3.a();
                Boolean valueOf = Boolean.valueOf(a3.a(true));
                synchronized (this) {
                    a(a4);
                    a(valueOf);
                }
            } catch (Throwable unused) {
            }
            context.unbindService(bVar);
        }
    }

    private void a(Boolean bool) {
        this.b = bool;
    }

    private synchronized boolean a() {
        return (this.a == null || this.b == null) ? false : true;
    }

    @Override // com.yandex.metrica.impl.ob.pd
    @Nullable
    public pc a(@NonNull Context context) {
        if (!a()) {
            Context applicationContext = context.getApplicationContext();
            if (b(applicationContext)) {
                c(applicationContext);
            }
            if (!a()) {
                d(applicationContext);
            }
            if (!a()) {
                return null;
            }
        }
        return new pc(pc.a.GOOGLE, this.a, this.b);
    }

    /* renamed from: com.yandex.metrica.impl.ac.a$a  reason: collision with other inner class name */
    public interface AbstractC0334a extends IInterface {
        String a() throws RemoteException;

        boolean a(boolean z) throws RemoteException;

        /* renamed from: com.yandex.metrica.impl.ac.a$a$a  reason: collision with other inner class name */
        public static abstract class AbstractBinderC0335a extends Binder implements AbstractC0334a {
            public static AbstractC0334a a(IBinder iBinder) {
                if (iBinder == null) {
                    return null;
                }
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof AbstractC0334a)) {
                    return new C0336a(iBinder);
                }
                return (AbstractC0334a) queryLocalInterface;
            }

            @Override // android.os.Binder
            public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
                if (i == 1) {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    String a = a();
                    parcel2.writeNoException();
                    parcel2.writeString(a);
                    return true;
                } else if (i != 2) {
                    return super.onTransact(i, parcel, parcel2, i2);
                } else {
                    parcel.enforceInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                    boolean a3 = a(parcel.readInt() != 0);
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                }
            }

            /* renamed from: com.yandex.metrica.impl.ac.a$a$a$a  reason: collision with other inner class name */
            public static class C0336a implements AbstractC0334a {
                private IBinder a;

                public C0336a(IBinder iBinder) {
                    this.a = iBinder;
                }

                @Override // com.yandex.metrica.impl.ac.a.AbstractC0334a
                public String a() throws RemoteException {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        this.a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }

                @Override // android.os.IInterface
                public IBinder asBinder() {
                    return this.a;
                }

                @Override // com.yandex.metrica.impl.ac.a.AbstractC0334a
                public boolean a(boolean z) throws RemoteException {
                    Parcel obtain = Parcel.obtain();
                    Parcel obtain2 = Parcel.obtain();
                    try {
                        obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                        boolean z2 = true;
                        obtain.writeInt(z ? 1 : 0);
                        this.a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() == 0) {
                            z2 = false;
                        }
                        return z2;
                    } finally {
                        obtain2.recycle();
                        obtain.recycle();
                    }
                }
            }
        }
    }
}
