package com.google.android.gms.common.internal;

import a2.b.a.a.a;
import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.BinderThread;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.avito.android.BuildConfig;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GmsClientSupervisor;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.IGmsServiceBroker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzi;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
@KeepForSdk
public abstract class BaseGmsClient<T extends IInterface> {
    @RecentlyNonNull
    @KeepForSdk
    public static final int CONNECT_STATE_CONNECTED = 4;
    @RecentlyNonNull
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTED = 1;
    @RecentlyNonNull
    @KeepForSdk
    public static final int CONNECT_STATE_DISCONNECTING = 5;
    @RecentlyNonNull
    @KeepForSdk
    public static final String DEFAULT_ACCOUNT = "<<default account>>";
    @RecentlyNonNull
    @KeepForSdk
    public static final String[] GOOGLE_PLUS_REQUIRED_FEATURES = {"service_esmobile", "service_googleme"};
    @RecentlyNonNull
    @KeepForSdk
    public static final String KEY_PENDING_INTENT = "pendingIntent";
    private static final Feature[] zzd = new Feature[0];
    public final Handler zza;
    @Nullable
    private ConnectionResult zzaa;
    private boolean zzab;
    @Nullable
    private volatile zzc zzac;
    @RecentlyNonNull
    @VisibleForTesting
    public ConnectionProgressReportCallbacks zzb;
    @RecentlyNonNull
    @VisibleForTesting
    public AtomicInteger zzc;
    private int zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;
    @Nullable
    private volatile String zzj;
    @VisibleForTesting
    private zzl zzk;
    private final Context zzl;
    private final Looper zzm;
    private final GmsClientSupervisor zzn;
    private final GoogleApiAvailabilityLight zzo;
    private final Object zzp;
    private final Object zzq;
    @Nullable
    @GuardedBy("mServiceBrokerLock")
    private IGmsServiceBroker zzr;
    @Nullable
    @GuardedBy("mLock")
    private T zzs;
    private final ArrayList<zzc<?>> zzt;
    @Nullable
    @GuardedBy("mLock")
    private zzd zzu;
    @GuardedBy("mLock")
    private int zzv;
    @Nullable
    private final BaseConnectionCallbacks zzw;
    @Nullable
    private final BaseOnConnectionFailedListener zzx;
    private final int zzy;
    @Nullable
    private final String zzz;

    @KeepForSdk
    public interface BaseConnectionCallbacks {
        @RecentlyNonNull
        @KeepForSdk
        public static final int CAUSE_DEAD_OBJECT_EXCEPTION = 3;
        @RecentlyNonNull
        @KeepForSdk
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        @KeepForSdk
        void onConnected(@Nullable Bundle bundle);

        @KeepForSdk
        void onConnectionSuspended(@RecentlyNonNull int i);
    }

    @KeepForSdk
    public interface BaseOnConnectionFailedListener {
        @KeepForSdk
        void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult);
    }

    @KeepForSdk
    public interface ConnectionProgressReportCallbacks {
        @KeepForSdk
        void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult);
    }

    public class LegacyClientCallbackAdapter implements ConnectionProgressReportCallbacks {
        @KeepForSdk
        public LegacyClientCallbackAdapter() {
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public void onReportServiceBinding(@RecentlyNonNull ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                baseGmsClient.getRemoteService(null, baseGmsClient.getScopes());
            } else if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
        }
    }

    @KeepForSdk
    public interface SignOutCallbacks {
        @KeepForSdk
        void onSignOutComplete();
    }

    public abstract class zza extends zzc<Boolean> {
        private final int zza;
        @Nullable
        private final Bundle zzb;

        @BinderThread
        public zza(int i, @Nullable Bundle bundle) {
            super(Boolean.TRUE);
            this.zza = i;
            this.zzb = bundle;
        }

        public abstract void zza(ConnectionResult connectionResult);

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final /* synthetic */ void zza(Boolean bool) {
            PendingIntent pendingIntent = null;
            if (bool == null) {
                BaseGmsClient.this.zza(1, (int) null);
            } else if (this.zza != 0) {
                BaseGmsClient.this.zza(1, (int) null);
                Bundle bundle = this.zzb;
                if (bundle != null) {
                    pendingIntent = (PendingIntent) bundle.getParcelable(BaseGmsClient.KEY_PENDING_INTENT);
                }
                zza(new ConnectionResult(this.zza, pendingIntent));
            } else if (!zza()) {
                BaseGmsClient.this.zza(1, (int) null);
                zza(new ConnectionResult(8, null));
            }
        }

        public abstract boolean zza();

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zzc
        public final void zzb() {
        }
    }

    public final class zzb extends zzi {
        public zzb(Looper looper) {
            super(looper);
        }

        private static void zza(Message message) {
            zzc zzc = (zzc) message.obj;
            zzc.zzb();
            zzc.zzd();
        }

        private static boolean zzb(Message message) {
            int i = message.what;
            return i == 2 || i == 1 || i == 7;
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ConnectionResult connectionResult;
            ConnectionResult connectionResult2;
            if (BaseGmsClient.this.zzc.get() == message.arg1) {
                int i = message.what;
                if ((i == 1 || i == 7 || ((i == 4 && !BaseGmsClient.this.enableLocalFallback()) || message.what == 5)) && !BaseGmsClient.this.isConnecting()) {
                    zza(message);
                    return;
                }
                int i2 = message.what;
                PendingIntent pendingIntent = null;
                if (i2 == 4) {
                    BaseGmsClient.this.zzaa = new ConnectionResult(message.arg2);
                    if (!BaseGmsClient.this.zzc() || BaseGmsClient.this.zzab) {
                        if (BaseGmsClient.this.zzaa != null) {
                            connectionResult2 = BaseGmsClient.this.zzaa;
                        } else {
                            connectionResult2 = new ConnectionResult(8);
                        }
                        BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult2);
                        BaseGmsClient.this.onConnectionFailed(connectionResult2);
                        return;
                    }
                    BaseGmsClient.this.zza(3, (int) null);
                } else if (i2 == 5) {
                    if (BaseGmsClient.this.zzaa != null) {
                        connectionResult = BaseGmsClient.this.zzaa;
                    } else {
                        connectionResult = new ConnectionResult(8);
                    }
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                    BaseGmsClient.this.onConnectionFailed(connectionResult);
                } else if (i2 == 3) {
                    Object obj = message.obj;
                    if (obj instanceof PendingIntent) {
                        pendingIntent = (PendingIntent) obj;
                    }
                    ConnectionResult connectionResult3 = new ConnectionResult(message.arg2, pendingIntent);
                    BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult3);
                    BaseGmsClient.this.onConnectionFailed(connectionResult3);
                } else if (i2 == 6) {
                    BaseGmsClient.this.zza(5, (int) null);
                    if (BaseGmsClient.this.zzw != null) {
                        BaseGmsClient.this.zzw.onConnectionSuspended(message.arg2);
                    }
                    BaseGmsClient.this.onConnectionSuspended(message.arg2);
                    BaseGmsClient.this.zza(5, 1, (int) null);
                } else if (i2 == 2 && !BaseGmsClient.this.isConnected()) {
                    zza(message);
                } else if (zzb(message)) {
                    ((zzc) message.obj).zzc();
                } else {
                    Log.wtf("GmsClient", a.m2(45, "Don't know how to handle message: ", message.what), new Exception());
                }
            } else if (zzb(message)) {
                zza(message);
            }
        }
    }

    public abstract class zzc<TListener> {
        @Nullable
        private TListener zza;
        private boolean zzb = false;

        public zzc(TListener tlistener) {
            this.zza = tlistener;
        }

        public abstract void zza(TListener tlistener);

        public abstract void zzb();

        public final void zzc() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.zza;
                if (this.zzb) {
                    String.valueOf(this).length();
                }
            }
            if (tlistener != null) {
                try {
                    zza(tlistener);
                } catch (RuntimeException e) {
                    zzb();
                    throw e;
                }
            } else {
                zzb();
            }
            synchronized (this) {
                this.zzb = true;
            }
            zzd();
        }

        public final void zzd() {
            zze();
            synchronized (BaseGmsClient.this.zzt) {
                BaseGmsClient.this.zzt.remove(this);
            }
        }

        public final void zze() {
            synchronized (this) {
                this.zza = null;
            }
        }
    }

    @VisibleForTesting
    public final class zzd implements ServiceConnection {
        private final int zza;

        public zzd(int i) {
            this.zza = i;
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IGmsServiceBroker iGmsServiceBroker;
            if (iBinder == null) {
                BaseGmsClient.this.zza(16);
                return;
            }
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient baseGmsClient = BaseGmsClient.this;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                if (queryLocalInterface == null || !(queryLocalInterface instanceof IGmsServiceBroker)) {
                    iGmsServiceBroker = new IGmsServiceBroker.Stub.zza(iBinder);
                } else {
                    iGmsServiceBroker = (IGmsServiceBroker) queryLocalInterface;
                }
                baseGmsClient.zzr = iGmsServiceBroker;
            }
            BaseGmsClient.this.zza(0, (Bundle) null, this.zza);
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            synchronized (BaseGmsClient.this.zzq) {
                BaseGmsClient.this.zzr = null;
            }
            Handler handler = BaseGmsClient.this.zza;
            handler.sendMessage(handler.obtainMessage(6, this.zza, 1));
        }
    }

    @VisibleForTesting
    public static final class zze extends IGmsCallbacks.zza {
        @Nullable
        private BaseGmsClient zza;
        private final int zzb;

        public zze(@NonNull BaseGmsClient baseGmsClient, int i) {
            this.zza = baseGmsClient;
            this.zzb = i;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void onPostInitComplete(int i, @NonNull IBinder iBinder, @Nullable Bundle bundle) {
            Preconditions.checkNotNull(this.zza, "onPostInitComplete can be called only once per call to getRemoteService");
            this.zza.onPostInitHandler(i, iBinder, bundle, this.zzb);
            this.zza = null;
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void zza(int i, @Nullable Bundle bundle) {
            Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
        }

        @Override // com.google.android.gms.common.internal.IGmsCallbacks
        @BinderThread
        public final void zza(int i, @NonNull IBinder iBinder, @NonNull zzc zzc) {
            BaseGmsClient baseGmsClient = this.zza;
            Preconditions.checkNotNull(baseGmsClient, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
            Preconditions.checkNotNull(zzc);
            baseGmsClient.zza(zzc);
            onPostInitComplete(i, iBinder, zzc.zza);
        }
    }

    @KeepForSdk
    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull int i, @RecentlyNonNull BaseConnectionCallbacks baseConnectionCallbacks, @RecentlyNonNull BaseOnConnectionFailedListener baseOnConnectionFailedListener, @RecentlyNonNull String str) {
        this(context, looper, GmsClientSupervisor.getInstance(context), GoogleApiAvailabilityLight.getInstance(), i, (BaseConnectionCallbacks) Preconditions.checkNotNull(baseConnectionCallbacks), (BaseOnConnectionFailedListener) Preconditions.checkNotNull(baseOnConnectionFailedListener), str);
    }

    private final String zza() {
        String str = this.zzz;
        return str == null ? this.zzl.getClass().getName() : str;
    }

    private final boolean zzb() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 3;
        }
        return z;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zzc() {
        if (this.zzab || TextUtils.isEmpty(getServiceDescriptor()) || TextUtils.isEmpty(getLocalStartServiceAction())) {
            return false;
        }
        try {
            Class.forName(getServiceDescriptor());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @KeepForSdk
    public void checkAvailabilityAndConnect() {
        int isGooglePlayServicesAvailable = this.zzo.isGooglePlayServicesAvailable(this.zzl, getMinApkVersion());
        if (isGooglePlayServicesAvailable != 0) {
            zza(1, (int) null);
            triggerNotAvailable(new LegacyClientCallbackAdapter(), isGooglePlayServicesAvailable, null);
            return;
        }
        connect(new LegacyClientCallbackAdapter());
    }

    @KeepForSdk
    public final void checkConnected() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    @KeepForSdk
    public void connect(@RecentlyNonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks) {
        this.zzb = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        zza(2, (int) null);
    }

    @RecentlyNullable
    @KeepForSdk
    public abstract T createServiceInterface(@RecentlyNonNull IBinder iBinder);

    @KeepForSdk
    public void disconnect(@RecentlyNonNull String str) {
        this.zzj = str;
        disconnect();
    }

    @KeepForSdk
    public void dump(@RecentlyNonNull String str, @RecentlyNonNull FileDescriptor fileDescriptor, @RecentlyNonNull PrintWriter printWriter, @RecentlyNonNull String[] strArr) {
        int i;
        T t;
        IGmsServiceBroker iGmsServiceBroker;
        synchronized (this.zzp) {
            i = this.zzv;
            t = this.zzs;
        }
        synchronized (this.zzq) {
            iGmsServiceBroker = this.zzr;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        if (i == 1) {
            printWriter.print("DISCONNECTED");
        } else if (i == 2) {
            printWriter.print("REMOTE_CONNECTING");
        } else if (i == 3) {
            printWriter.print("LOCAL_CONNECTING");
        } else if (i == 4) {
            printWriter.print("CONNECTED");
        } else if (i != 5) {
            printWriter.print("UNKNOWN");
        } else {
            printWriter.print("DISCONNECTING");
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.append(BuildConfig.ADJUST_DEFAULT_TRACKER);
        } else {
            printWriter.append((CharSequence) getServiceDescriptor()).append("@").append((CharSequence) Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
        printWriter.append(" mServiceBroker=");
        if (iGmsServiceBroker == null) {
            printWriter.println(BuildConfig.ADJUST_DEFAULT_TRACKER);
        } else {
            printWriter.append("IGmsServiceBroker@").println(Integer.toHexString(System.identityHashCode(iGmsServiceBroker.asBinder())));
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.US);
        if (this.zzg > 0) {
            PrintWriter append = printWriter.append((CharSequence) str).append("lastConnectedTime=");
            long j = this.zzg;
            String format = simpleDateFormat.format(new Date(this.zzg));
            StringBuilder sb = new StringBuilder(String.valueOf(format).length() + 21);
            sb.append(j);
            sb.append(" ");
            sb.append(format);
            append.println(sb.toString());
        }
        if (this.zzf > 0) {
            printWriter.append((CharSequence) str).append("lastSuspendedCause=");
            int i2 = this.zze;
            if (i2 == 1) {
                printWriter.append("CAUSE_SERVICE_DISCONNECTED");
            } else if (i2 == 2) {
                printWriter.append("CAUSE_NETWORK_LOST");
            } else if (i2 != 3) {
                printWriter.append((CharSequence) String.valueOf(i2));
            } else {
                printWriter.append("CAUSE_DEAD_OBJECT_EXCEPTION");
            }
            PrintWriter append2 = printWriter.append(" lastSuspendedTime=");
            long j2 = this.zzf;
            String format2 = simpleDateFormat.format(new Date(this.zzf));
            StringBuilder sb2 = new StringBuilder(String.valueOf(format2).length() + 21);
            sb2.append(j2);
            sb2.append(" ");
            sb2.append(format2);
            append2.println(sb2.toString());
        }
        if (this.zzi > 0) {
            printWriter.append((CharSequence) str).append("lastFailedStatus=").append((CharSequence) CommonStatusCodes.getStatusCodeString(this.zzh));
            PrintWriter append3 = printWriter.append(" lastFailedTime=");
            long j3 = this.zzi;
            String format3 = simpleDateFormat.format(new Date(this.zzi));
            StringBuilder sb3 = new StringBuilder(String.valueOf(format3).length() + 21);
            sb3.append(j3);
            sb3.append(" ");
            sb3.append(format3);
            append3.println(sb3.toString());
        }
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean enableLocalFallback() {
        return false;
    }

    @RecentlyNullable
    @KeepForSdk
    public Account getAccount() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public Feature[] getApiFeatures() {
        return zzd;
    }

    @RecentlyNullable
    @KeepForSdk
    public final Feature[] getAvailableFeatures() {
        zzc zzc2 = this.zzac;
        if (zzc2 == null) {
            return null;
        }
        return zzc2.zzb;
    }

    @RecentlyNullable
    @KeepForSdk
    public Bundle getConnectionHint() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Context getContext() {
        return this.zzl;
    }

    @RecentlyNonNull
    @KeepForSdk
    public String getEndpointPackageName() {
        zzl zzl2;
        if (isConnected() && (zzl2 = this.zzk) != null) {
            return zzl2.zzb();
        }
        throw new RuntimeException("Failed to connect when checking package");
    }

    @RecentlyNonNull
    @KeepForSdk
    public Bundle getGetServiceRequestExtraArgs() {
        return new Bundle();
    }

    @RecentlyNullable
    @KeepForSdk
    public String getLastDisconnectMessage() {
        return this.zzj;
    }

    @RecentlyNullable
    @KeepForSdk
    public String getLocalStartServiceAction() {
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final Looper getLooper() {
        return this.zzm;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    @KeepForSdk
    public int getMinApkVersion() {
        return GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007f, code lost:
        onPostInitHandler(8, null, null, r3.zzc.get());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008b, code lost:
        return;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    @androidx.annotation.WorkerThread
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getRemoteService(@androidx.annotation.Nullable com.google.android.gms.common.internal.IAccountAccessor r4, @androidx.annotation.RecentlyNonNull java.util.Set<com.google.android.gms.common.api.Scope> r5) {
        /*
            r3 = this;
            android.os.Bundle r0 = r3.getGetServiceRequestExtraArgs()
            com.google.android.gms.common.internal.GetServiceRequest r1 = new com.google.android.gms.common.internal.GetServiceRequest
            int r2 = r3.zzy
            r1.<init>(r2)
            android.content.Context r2 = r3.zzl
            java.lang.String r2 = r2.getPackageName()
            r1.zza = r2
            r1.zzd = r0
            if (r5 == 0) goto L_0x0025
            int r0 = r5.size()
            com.google.android.gms.common.api.Scope[] r0 = new com.google.android.gms.common.api.Scope[r0]
            java.lang.Object[] r5 = r5.toArray(r0)
            com.google.android.gms.common.api.Scope[] r5 = (com.google.android.gms.common.api.Scope[]) r5
            r1.zzc = r5
        L_0x0025:
            boolean r5 = r3.requiresSignIn()
            if (r5 == 0) goto L_0x0046
            android.accounts.Account r5 = r3.getAccount()
            if (r5 == 0) goto L_0x0032
            goto L_0x003b
        L_0x0032:
            android.accounts.Account r5 = new android.accounts.Account
            java.lang.String r0 = "<<default account>>"
            java.lang.String r2 = "com.google"
            r5.<init>(r0, r2)
        L_0x003b:
            r1.zze = r5
            if (r4 == 0) goto L_0x0052
            android.os.IBinder r4 = r4.asBinder()
            r1.zzb = r4
            goto L_0x0052
        L_0x0046:
            boolean r4 = r3.requiresAccount()
            if (r4 == 0) goto L_0x0052
            android.accounts.Account r4 = r3.getAccount()
            r1.zze = r4
        L_0x0052:
            com.google.android.gms.common.Feature[] r4 = com.google.android.gms.common.internal.BaseGmsClient.zzd
            r1.zzf = r4
            com.google.android.gms.common.Feature[] r4 = r3.getApiFeatures()
            r1.zzg = r4
            boolean r4 = r3.usesClientTelemetry()
            if (r4 == 0) goto L_0x0065
            r4 = 1
            r1.zzh = r4
        L_0x0065:
            java.lang.Object r4 = r3.zzq     // Catch:{ DeadObjectException -> 0x008e, SecurityException -> 0x008c }
            monitor-enter(r4)     // Catch:{ DeadObjectException -> 0x008e, SecurityException -> 0x008c }
            com.google.android.gms.common.internal.IGmsServiceBroker r5 = r3.zzr     // Catch:{ all -> 0x007c }
            if (r5 == 0) goto L_0x007a
            com.google.android.gms.common.internal.BaseGmsClient$zze r0 = new com.google.android.gms.common.internal.BaseGmsClient$zze     // Catch:{ all -> 0x007c }
            java.util.concurrent.atomic.AtomicInteger r2 = r3.zzc     // Catch:{ all -> 0x007c }
            int r2 = r2.get()     // Catch:{ all -> 0x007c }
            r0.<init>(r3, r2)     // Catch:{ all -> 0x007c }
            r5.getService(r0, r1)     // Catch:{ all -> 0x007c }
        L_0x007a:
            monitor-exit(r4)     // Catch:{ all -> 0x007c }
            return
        L_0x007c:
            r5 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x007c }
            throw r5     // Catch:{ RemoteException | RuntimeException -> 0x007f }
        L_0x007f:
            r4 = 8
            java.util.concurrent.atomic.AtomicInteger r5 = r3.zzc
            int r5 = r5.get()
            r0 = 0
            r3.onPostInitHandler(r4, r0, r0, r5)
            return
        L_0x008c:
            r4 = move-exception
            throw r4
        L_0x008e:
            r4 = 3
            r3.triggerConnectionSuspended(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.BaseGmsClient.getRemoteService(com.google.android.gms.common.internal.IAccountAccessor, java.util.Set):void");
    }

    @RecentlyNonNull
    @KeepForSdk
    public Set<Scope> getScopes() {
        return Collections.emptySet();
    }

    @RecentlyNonNull
    @KeepForSdk
    public final T getService() throws DeadObjectException {
        T t;
        synchronized (this.zzp) {
            if (this.zzv != 5) {
                checkConnected();
                t = (T) ((IInterface) Preconditions.checkNotNull(this.zzs, "Client is connected but service is null"));
            } else {
                throw new DeadObjectException();
            }
        }
        return t;
    }

    @RecentlyNullable
    @KeepForSdk
    public IBinder getServiceBrokerBinder() {
        synchronized (this.zzq) {
            IGmsServiceBroker iGmsServiceBroker = this.zzr;
            if (iGmsServiceBroker == null) {
                return null;
            }
            return iGmsServiceBroker.asBinder();
        }
    }

    @NonNull
    @KeepForSdk
    public abstract String getServiceDescriptor();

    @Override // com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    @KeepForSdk
    public Intent getSignInIntent() {
        throw new UnsupportedOperationException("Not a sign in API");
    }

    @NonNull
    @KeepForSdk
    public abstract String getStartServiceAction();

    @RecentlyNonNull
    @KeepForSdk
    public String getStartServicePackage() {
        return "com.google.android.gms";
    }

    @RecentlyNullable
    @KeepForSdk
    public ConnectionTelemetryConfiguration getTelemetryConfiguration() {
        if (this.zzac == null) {
        }
        return null;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean getUseDynamicLookup() {
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzp) {
            z = this.zzv == 4;
        }
        return z;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzp) {
            int i = this.zzv;
            if (i != 2) {
                if (i != 3) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    @KeepForSdk
    @CallSuper
    public void onConnectedLocked(@RecentlyNonNull T t) {
        this.zzg = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionFailed(@RecentlyNonNull ConnectionResult connectionResult) {
        this.zzh = connectionResult.getErrorCode();
        this.zzi = System.currentTimeMillis();
    }

    @KeepForSdk
    @CallSuper
    public void onConnectionSuspended(@RecentlyNonNull int i) {
        this.zze = i;
        this.zzf = System.currentTimeMillis();
    }

    @KeepForSdk
    public void onPostInitHandler(@RecentlyNonNull int i, @Nullable IBinder iBinder, @Nullable Bundle bundle, @RecentlyNonNull int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(1, i2, -1, new zzf(i, iBinder, bundle)));
    }

    @KeepForSdk
    public void onUserSignOut(@RecentlyNonNull SignOutCallbacks signOutCallbacks) {
        signOutCallbacks.onSignOutComplete();
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    @KeepForSdk
    public boolean providesSignIn() {
        return false;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    @KeepForSdk
    public boolean requiresAccount() {
        return false;
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean requiresGooglePlayServices() {
        return true;
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @RecentlyNonNull
    @KeepForSdk
    public boolean requiresSignIn() {
        return false;
    }

    @KeepForSdk
    public void triggerConnectionSuspended(@RecentlyNonNull int i) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(6, this.zzc.get(), i));
    }

    @VisibleForTesting
    @KeepForSdk
    public void triggerNotAvailable(@RecentlyNonNull ConnectionProgressReportCallbacks connectionProgressReportCallbacks, @RecentlyNonNull int i, @Nullable PendingIntent pendingIntent) {
        this.zzb = (ConnectionProgressReportCallbacks) Preconditions.checkNotNull(connectionProgressReportCallbacks, "Connection progress callbacks cannot be null.");
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(3, this.zzc.get(), i, pendingIntent));
    }

    @RecentlyNonNull
    @KeepForSdk
    public boolean usesClientTelemetry() {
        return false;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(zzc zzc2) {
        this.zzac = zzc2;
    }

    public final class zzf extends zza {
        @Nullable
        private final IBinder zza;

        @BinderThread
        public zzf(int i, @Nullable IBinder iBinder, @Nullable Bundle bundle) {
            super(i, bundle);
            this.zza = iBinder;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            if (BaseGmsClient.this.zzx != null) {
                BaseGmsClient.this.zzx.onConnectionFailed(connectionResult);
            }
            BaseGmsClient.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            try {
                String interfaceDescriptor = ((IBinder) Preconditions.checkNotNull(this.zza)).getInterfaceDescriptor();
                if (!BaseGmsClient.this.getServiceDescriptor().equals(interfaceDescriptor)) {
                    String.valueOf(BaseGmsClient.this.getServiceDescriptor()).length();
                    String.valueOf(interfaceDescriptor).length();
                    return false;
                }
                IInterface createServiceInterface = BaseGmsClient.this.createServiceInterface(this.zza);
                if (createServiceInterface == null) {
                    return false;
                }
                if (!BaseGmsClient.this.zza(2, 4, (int) createServiceInterface) && !BaseGmsClient.this.zza(3, 4, (int) createServiceInterface)) {
                    return false;
                }
                BaseGmsClient.this.zzaa = null;
                Bundle connectionHint = BaseGmsClient.this.getConnectionHint();
                if (BaseGmsClient.this.zzw != null) {
                    BaseGmsClient.this.zzw.onConnected(connectionHint);
                }
                return true;
            } catch (RemoteException unused) {
                return false;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: com.google.android.gms.common.internal.BaseGmsClient<T extends android.os.IInterface> */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i, @Nullable T t) {
        zzl zzl2;
        zzl zzl3;
        boolean z = false;
        if ((i == 4) == (t != null)) {
            z = true;
        }
        Preconditions.checkArgument(z);
        synchronized (this.zzp) {
            this.zzv = i;
            this.zzs = t;
            if (i == 1) {
                zzd zzd2 = this.zzu;
                if (zzd2 != null) {
                    this.zzn.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), zzd2, zza(), this.zzk.zzd());
                    this.zzu = null;
                }
            } else if (i == 2 || i == 3) {
                zzd zzd3 = this.zzu;
                if (!(zzd3 == null || (zzl3 = this.zzk) == null)) {
                    String zza2 = zzl3.zza();
                    String zzb2 = this.zzk.zzb();
                    String.valueOf(zza2).length();
                    String.valueOf(zzb2).length();
                    this.zzn.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), zzd3, zza(), this.zzk.zzd());
                    this.zzc.incrementAndGet();
                }
                zzd zzd4 = new zzd(this.zzc.get());
                this.zzu = zzd4;
                if (this.zzv != 3 || getLocalStartServiceAction() == null) {
                    zzl2 = new zzl(getStartServicePackage(), getStartServiceAction(), false, GmsClientSupervisor.getDefaultBindFlags(), getUseDynamicLookup());
                } else {
                    zzl2 = new zzl(getContext().getPackageName(), getLocalStartServiceAction(), true, GmsClientSupervisor.getDefaultBindFlags(), false);
                }
                this.zzk = zzl2;
                if (!zzl2.zzd() || getMinApkVersion() >= 17895000) {
                    if (!this.zzn.zza(new GmsClientSupervisor.zza((String) Preconditions.checkNotNull(this.zzk.zza()), this.zzk.zzb(), this.zzk.zzc(), this.zzk.zzd()), zzd4, zza())) {
                        String zza3 = this.zzk.zza();
                        String zzb3 = this.zzk.zzb();
                        String.valueOf(zza3).length();
                        String.valueOf(zzb3).length();
                        zza(16, (Bundle) null, this.zzc.get());
                    }
                } else {
                    String valueOf = String.valueOf(this.zzk.zza());
                    throw new IllegalStateException(valueOf.length() != 0 ? "Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(valueOf) : new String("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: "));
                }
            } else if (i == 4) {
                onConnectedLocked((IInterface) Preconditions.checkNotNull(t));
            }
        }
    }

    @Override // com.google.android.gms.common.api.Api.Client
    @KeepForSdk
    public void disconnect() {
        this.zzc.incrementAndGet();
        synchronized (this.zzt) {
            int size = this.zzt.size();
            for (int i = 0; i < size; i++) {
                this.zzt.get(i).zze();
            }
            this.zzt.clear();
        }
        synchronized (this.zzq) {
            this.zzr = null;
        }
        zza(1, (int) null);
    }

    public final class zzg extends zza {
        @BinderThread
        public zzg(int i, @Nullable Bundle bundle) {
            super(i, null);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final void zza(ConnectionResult connectionResult) {
            if (!BaseGmsClient.this.enableLocalFallback() || !BaseGmsClient.this.zzc()) {
                BaseGmsClient.this.zzb.onReportServiceBinding(connectionResult);
                BaseGmsClient.this.onConnectionFailed(connectionResult);
                return;
            }
            BaseGmsClient.this.zza(16);
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.zza
        public final boolean zza() {
            BaseGmsClient.this.zzb.onReportServiceBinding(ConnectionResult.RESULT_SUCCESS);
            return true;
        }
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Looper looper, @RecentlyNonNull GmsClientSupervisor gmsClientSupervisor, @RecentlyNonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, @RecentlyNonNull int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener, @Nullable String str) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        this.zzl = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zzm = (Looper) Preconditions.checkNotNull(looper, "Looper must not be null");
        this.zzn = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzo = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zza = new zzb(looper);
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = str;
    }

    @VisibleForTesting
    @KeepForSdk
    public BaseGmsClient(@RecentlyNonNull Context context, @RecentlyNonNull Handler handler, @RecentlyNonNull GmsClientSupervisor gmsClientSupervisor, @RecentlyNonNull GoogleApiAvailabilityLight googleApiAvailabilityLight, @RecentlyNonNull int i, @Nullable BaseConnectionCallbacks baseConnectionCallbacks, @Nullable BaseOnConnectionFailedListener baseOnConnectionFailedListener) {
        this.zzj = null;
        this.zzp = new Object();
        this.zzq = new Object();
        this.zzt = new ArrayList<>();
        this.zzv = 1;
        this.zzaa = null;
        this.zzab = false;
        this.zzac = null;
        this.zzc = new AtomicInteger(0);
        this.zzl = (Context) Preconditions.checkNotNull(context, "Context must not be null");
        this.zza = (Handler) Preconditions.checkNotNull(handler, "Handler must not be null");
        this.zzm = handler.getLooper();
        this.zzn = (GmsClientSupervisor) Preconditions.checkNotNull(gmsClientSupervisor, "Supervisor must not be null");
        this.zzo = (GoogleApiAvailabilityLight) Preconditions.checkNotNull(googleApiAvailabilityLight, "API availability must not be null");
        this.zzy = i;
        this.zzw = baseConnectionCallbacks;
        this.zzx = baseOnConnectionFailedListener;
        this.zzz = null;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final boolean zza(int i, int i2, @Nullable T t) {
        synchronized (this.zzp) {
            if (this.zzv != i) {
                return false;
            }
            zza(i2, (int) t);
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final void zza(int i) {
        int i2;
        if (zzb()) {
            i2 = 5;
            this.zzab = true;
        } else {
            i2 = 4;
        }
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(i2, this.zzc.get(), 16));
    }

    public final void zza(@RecentlyNonNull int i, @Nullable Bundle bundle, @RecentlyNonNull int i2) {
        Handler handler = this.zza;
        handler.sendMessage(handler.obtainMessage(7, i2, -1, new zzg(i, null)));
    }
}
