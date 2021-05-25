package com.google.android.gms.common.api.internal;

import a2.b.a.a.a;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.WorkerThread;
import androidx.collection.ArrayMap;
import androidx.collection.ArraySet;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.UnsupportedApiCallException;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zaj;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.internal.base.zap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.concurrent.GuardedBy;
import org.checkerframework.checker.initialization.qual.NotOnlyInitialized;
@KeepForSdk
public class GoogleApiManager implements Handler.Callback {
    @RecentlyNonNull
    public static final Status zaa = new Status(4, "Sign-out occurred while this API call was in progress.");
    private static final Status zab = new Status(4, "The user must be signed in to make this API call.");
    private static final Object zaf = new Object();
    @Nullable
    @GuardedBy("lock")
    private static GoogleApiManager zag;
    private long zac = 5000;
    private long zad = 120000;
    private long zae = 10000;
    private final Context zah;
    private final GoogleApiAvailability zai;
    private final zaj zaj;
    private final AtomicInteger zak = new AtomicInteger(1);
    private final AtomicInteger zal = new AtomicInteger(0);
    private final Map<ApiKey<?>, zaa<?>> zam = new ConcurrentHashMap(5, 0.75f, 1);
    @Nullable
    @GuardedBy("lock")
    private zax zan = null;
    @GuardedBy("lock")
    private final Set<ApiKey<?>> zao = new ArraySet();
    private final Set<ApiKey<?>> zap = new ArraySet();
    @NotOnlyInitialized
    private final Handler zaq;
    private volatile boolean zar = true;

    public class zaa<O extends Api.ApiOptions> implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener, zar {
        private final Queue<zac> zab = new LinkedList();
        @NotOnlyInitialized
        private final Api.Client zac;
        private final ApiKey<O> zad;
        private final zaw zae;
        private final Set<zaj> zaf = new HashSet();
        private final Map<ListenerHolder.ListenerKey<?>, zabs> zag = new HashMap();
        private final int zah;
        @Nullable
        private final zacb zai;
        private boolean zaj;
        private final List<zab> zak = new ArrayList();
        @Nullable
        private ConnectionResult zal = null;

        @WorkerThread
        public zaa(GoogleApi<O> googleApi) {
            Api.Client zaa2 = googleApi.zaa(GoogleApiManager.this.zaq.getLooper(), this);
            this.zac = zaa2;
            this.zad = googleApi.getApiKey();
            this.zae = new zaw();
            this.zah = googleApi.zaa();
            if (zaa2.requiresSignIn()) {
                this.zai = googleApi.zaa(GoogleApiManager.this.zah, GoogleApiManager.this.zaq);
            } else {
                this.zai = null;
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zaa(int i) {
            zad();
            this.zaj = true;
            this.zae.zaa(i, this.zac.getLastDisconnectMessage());
            GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 9, this.zad), GoogleApiManager.this.zac);
            GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 11, this.zad), GoogleApiManager.this.zad);
            GoogleApiManager.this.zaj.zaa();
            for (zabs zabs : this.zag.values()) {
                zabs.zac.run();
            }
        }

        @WorkerThread
        private final boolean zab(@NonNull ConnectionResult connectionResult) {
            synchronized (GoogleApiManager.zaf) {
                if (GoogleApiManager.this.zan == null || !GoogleApiManager.this.zao.contains(this.zad)) {
                    return false;
                }
                GoogleApiManager.this.zan.zab(connectionResult, this.zah);
                return true;
            }
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zam() {
            zad();
            zac(ConnectionResult.RESULT_SUCCESS);
            zao();
            Iterator<zabs> it = this.zag.values().iterator();
            while (it.hasNext()) {
                zabs next = it.next();
                if (zaa(next.zaa.getRequiredFeatures()) != null) {
                    it.remove();
                } else {
                    try {
                        next.zaa.registerListener(this.zac, new TaskCompletionSource<>());
                    } catch (DeadObjectException unused) {
                        onConnectionSuspended(3);
                        this.zac.disconnect("DeadObjectException thrown while calling register listener method.");
                    } catch (RemoteException unused2) {
                        it.remove();
                    }
                }
            }
            zan();
            zap();
        }

        @WorkerThread
        private final void zan() {
            ArrayList arrayList = new ArrayList(this.zab);
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                zac zac2 = (zac) obj;
                if (!this.zac.isConnected()) {
                    return;
                }
                if (zab(zac2)) {
                    this.zab.remove(zac2);
                }
            }
        }

        @WorkerThread
        private final void zao() {
            if (this.zaj) {
                GoogleApiManager.this.zaq.removeMessages(11, this.zad);
                GoogleApiManager.this.zaq.removeMessages(9, this.zad);
                this.zaj = false;
            }
        }

        private final void zap() {
            GoogleApiManager.this.zaq.removeMessages(12, this.zad);
            GoogleApiManager.this.zaq.sendMessageDelayed(GoogleApiManager.this.zaq.obtainMessage(12, this.zad), GoogleApiManager.this.zae);
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnected(@Nullable Bundle bundle) {
            if (Looper.myLooper() == GoogleApiManager.this.zaq.getLooper()) {
                zam();
            } else {
                GoogleApiManager.this.zaq.post(new zabe(this));
            }
        }

        @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
        @WorkerThread
        public final void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
            zaa(connectionResult, (Exception) null);
        }

        @Override // com.google.android.gms.common.api.internal.ConnectionCallbacks
        public final void onConnectionSuspended(int i) {
            if (Looper.myLooper() == GoogleApiManager.this.zaq.getLooper()) {
                zaa(i);
            } else {
                GoogleApiManager.this.zaq.post(new zabd(this, i));
            }
        }

        public final Map<ListenerHolder.ListenerKey<?>, zabs> zac() {
            return this.zag;
        }

        @WorkerThread
        public final void zad() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            this.zal = null;
        }

        @Nullable
        @WorkerThread
        public final ConnectionResult zae() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            return this.zal;
        }

        @WorkerThread
        public final void zaf() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            if (this.zaj) {
                zai();
            }
        }

        @WorkerThread
        public final void zag() {
            Status status;
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            if (this.zaj) {
                zao();
                if (GoogleApiManager.this.zai.isGooglePlayServicesAvailable(GoogleApiManager.this.zah) == 18) {
                    status = new Status(21, "Connection timed out waiting for Google Play services update to complete.");
                } else {
                    status = new Status(22, "API failed to connect while resuming due to an unknown error.");
                }
                zaa(status);
                this.zac.disconnect("Timing out connection while resuming.");
            }
        }

        @WorkerThread
        public final boolean zah() {
            return zaa(true);
        }

        @WorkerThread
        public final void zai() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected() && !this.zac.isConnecting()) {
                try {
                    int zaa2 = GoogleApiManager.this.zaj.zaa(GoogleApiManager.this.zah, this.zac);
                    if (zaa2 != 0) {
                        ConnectionResult connectionResult = new ConnectionResult(zaa2, null);
                        String name = this.zac.getClass().getName();
                        String valueOf = String.valueOf(connectionResult);
                        name.length();
                        valueOf.length();
                        onConnectionFailed(connectionResult);
                        return;
                    }
                    zac zac2 = new zac(this.zac, this.zad);
                    if (this.zac.requiresSignIn()) {
                        ((zacb) Preconditions.checkNotNull(this.zai)).zaa(zac2);
                    }
                    try {
                        this.zac.connect(zac2);
                    } catch (SecurityException e) {
                        zaa(new ConnectionResult(10), e);
                    }
                } catch (IllegalStateException e2) {
                    zaa(new ConnectionResult(10), e2);
                }
            }
        }

        public final boolean zaj() {
            return this.zac.isConnected();
        }

        public final boolean zak() {
            return this.zac.requiresSignIn();
        }

        public final int zal() {
            return this.zah;
        }

        @WorkerThread
        private final void zac(zac zac2) {
            zac2.zaa(this.zae, zak());
            try {
                zac2.zac(this);
            } catch (DeadObjectException unused) {
                onConnectionSuspended(1);
                this.zac.disconnect("DeadObjectException thrown while running ApiCallRunner.");
            } catch (Throwable th) {
                throw new IllegalStateException(String.format("Error in GoogleApi implementation for client %s.", this.zac.getClass().getName()), th);
            }
        }

        private final Status zad(ConnectionResult connectionResult) {
            return GoogleApiManager.zab((ApiKey<?>) this.zad, connectionResult);
        }

        public final Api.Client zab() {
            return this.zac;
        }

        @WorkerThread
        private final boolean zab(zac zac2) {
            if (!(zac2 instanceof zab)) {
                zac(zac2);
                return true;
            }
            zab zab2 = (zab) zac2;
            Feature zaa2 = zaa(zab2.zaa((zaa<?>) this));
            if (zaa2 == null) {
                zac(zac2);
                return true;
            }
            String name = this.zac.getClass().getName();
            String name2 = zaa2.getName();
            zaa2.getVersion();
            name.length();
            String.valueOf(name2).length();
            if (!GoogleApiManager.this.zar || !zab2.zab((zaa<?>) this)) {
                zab2.zaa(new UnsupportedApiCallException(zaa2));
                return true;
            }
            zab zab3 = new zab(this.zad, zaa2, null);
            int indexOf = this.zak.indexOf(zab3);
            if (indexOf >= 0) {
                zab zab4 = this.zak.get(indexOf);
                GoogleApiManager.this.zaq.removeMessages(15, zab4);
                GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 15, zab4), GoogleApiManager.this.zac);
                return false;
            }
            this.zak.add(zab3);
            GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 15, zab3), GoogleApiManager.this.zac);
            GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 16, zab3), GoogleApiManager.this.zad);
            ConnectionResult connectionResult = new ConnectionResult(2, null);
            if (zab(connectionResult)) {
                return false;
            }
            GoogleApiManager.this.zaa(connectionResult, this.zah);
            return false;
        }

        @WorkerThread
        private final void zac(ConnectionResult connectionResult) {
            for (zaj zaj2 : this.zaf) {
                String str = null;
                if (Objects.equal(connectionResult, ConnectionResult.RESULT_SUCCESS)) {
                    str = this.zac.getEndpointPackageName();
                }
                zaj2.zaa(this.zad, connectionResult, str);
            }
            this.zaf.clear();
        }

        @WorkerThread
        public final void zaa(@NonNull ConnectionResult connectionResult) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            Api.Client client = this.zac;
            String name = client.getClass().getName();
            String valueOf = String.valueOf(connectionResult);
            client.disconnect(a.t2(valueOf.length() + name.length() + 25, "onSignInFailed for ", name, " with ", valueOf));
            onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.api.internal.zar
        public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
            if (Looper.myLooper() == GoogleApiManager.this.zaq.getLooper()) {
                onConnectionFailed(connectionResult);
            } else {
                GoogleApiManager.this.zaq.post(new zabg(this, connectionResult));
            }
        }

        @WorkerThread
        private final void zaa(@NonNull ConnectionResult connectionResult, @Nullable Exception exc) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            zacb zacb = this.zai;
            if (zacb != null) {
                zacb.zaa();
            }
            zad();
            GoogleApiManager.this.zaj.zaa();
            zac(connectionResult);
            if (connectionResult.getErrorCode() == 4) {
                zaa(GoogleApiManager.zab);
            } else if (this.zab.isEmpty()) {
                this.zal = connectionResult;
            } else if (exc != null) {
                Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
                zaa((Status) null, exc, false);
            } else if (!GoogleApiManager.this.zar) {
                zaa(zad(connectionResult));
            } else {
                zaa(zad(connectionResult), (Exception) null, true);
                if (!this.zab.isEmpty() && !zab(connectionResult) && !GoogleApiManager.this.zaa(connectionResult, this.zah)) {
                    if (connectionResult.getErrorCode() == 18) {
                        this.zaj = true;
                    }
                    if (this.zaj) {
                        GoogleApiManager.this.zaq.sendMessageDelayed(Message.obtain(GoogleApiManager.this.zaq, 9, this.zad), GoogleApiManager.this.zac);
                    } else {
                        zaa(zad(connectionResult));
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @WorkerThread
        private final void zab(zab zab2) {
            Feature[] zaa2;
            if (this.zak.remove(zab2)) {
                GoogleApiManager.this.zaq.removeMessages(15, zab2);
                GoogleApiManager.this.zaq.removeMessages(16, zab2);
                Feature feature = zab2.zab;
                ArrayList arrayList = new ArrayList(this.zab.size());
                for (zac zac2 : this.zab) {
                    if ((zac2 instanceof zab) && (zaa2 = ((zab) zac2).zaa((zaa<?>) this)) != null && ArrayUtils.contains(zaa2, feature)) {
                        arrayList.add(zac2);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    zac zac3 = (zac) obj;
                    this.zab.remove(zac3);
                    zac3.zaa(new UnsupportedApiCallException(feature));
                }
            }
        }

        @WorkerThread
        public final void zaa(zac zac2) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected()) {
                this.zab.add(zac2);
                ConnectionResult connectionResult = this.zal;
                if (connectionResult == null || !connectionResult.hasResolution()) {
                    zai();
                } else {
                    onConnectionFailed(this.zal);
                }
            } else if (zab(zac2)) {
                zap();
            } else {
                this.zab.add(zac2);
            }
        }

        @WorkerThread
        public final void zaa() {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            zaa(GoogleApiManager.zaa);
            this.zae.zab();
            for (ListenerHolder.ListenerKey listenerKey : (ListenerHolder.ListenerKey[]) this.zag.keySet().toArray(new ListenerHolder.ListenerKey[0])) {
                zaa(new zah(listenerKey, new TaskCompletionSource()));
            }
            zac(new ConnectionResult(4));
            if (this.zac.isConnected()) {
                this.zac.onUserSignOut(new zabf(this));
            }
        }

        @WorkerThread
        private final void zaa(@Nullable Status status, @Nullable Exception exc, boolean z) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            boolean z2 = true;
            boolean z3 = status == null;
            if (exc != null) {
                z2 = false;
            }
            if (z3 != z2) {
                Iterator<zac> it = this.zab.iterator();
                while (it.hasNext()) {
                    zac next = it.next();
                    if (!z || next.zaa == 2) {
                        if (status != null) {
                            next.zaa(status);
                        } else {
                            next.zaa(exc);
                        }
                        it.remove();
                    }
                }
                return;
            }
            throw new IllegalArgumentException("Status XOR exception should be null");
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @WorkerThread
        private final void zaa(Status status) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            zaa(status, (Exception) null, false);
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @WorkerThread
        private final boolean zaa(boolean z) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            if (!this.zac.isConnected() || this.zag.size() != 0) {
                return false;
            }
            if (this.zae.zaa()) {
                if (z) {
                    zap();
                }
                return false;
            }
            this.zac.disconnect("Timing out service connection.");
            return true;
        }

        @WorkerThread
        public final void zaa(zaj zaj2) {
            Preconditions.checkHandlerThread(GoogleApiManager.this.zaq);
            this.zaf.add(zaj2);
        }

        @Nullable
        @WorkerThread
        private final Feature zaa(@Nullable Feature[] featureArr) {
            if (!(featureArr == null || featureArr.length == 0)) {
                Feature[] availableFeatures = this.zac.getAvailableFeatures();
                if (availableFeatures == null) {
                    availableFeatures = new Feature[0];
                }
                ArrayMap arrayMap = new ArrayMap(availableFeatures.length);
                for (Feature feature : availableFeatures) {
                    arrayMap.put(feature.getName(), Long.valueOf(feature.getVersion()));
                }
                for (Feature feature2 : featureArr) {
                    Long l = (Long) arrayMap.get(feature2.getName());
                    if (l == null || l.longValue() < feature2.getVersion()) {
                        return feature2;
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        @WorkerThread
        private final void zaa(zab zab2) {
            if (!this.zak.contains(zab2) || this.zaj) {
                return;
            }
            if (!this.zac.isConnected()) {
                zai();
            } else {
                zan();
            }
        }
    }

    @KeepForSdk
    private GoogleApiManager(Context context, Looper looper, GoogleApiAvailability googleApiAvailability) {
        this.zah = context;
        zap zap2 = new zap(looper, this);
        this.zaq = zap2;
        this.zai = googleApiAvailability;
        this.zaj = new zaj(googleApiAvailability);
        if (DeviceProperties.isAuto(context)) {
            this.zar = false;
        }
        zap2.sendMessage(zap2.obtainMessage(6));
    }

    @KeepForSdk
    public static void reportSignOut() {
        synchronized (zaf) {
            GoogleApiManager googleApiManager = zag;
            if (googleApiManager != null) {
                googleApiManager.zal.incrementAndGet();
                Handler handler = googleApiManager.zaq;
                handler.sendMessageAtFrontOfQueue(handler.obtainMessage(10));
            }
        }
    }

    @RecentlyNonNull
    public static GoogleApiManager zaa(@RecentlyNonNull Context context) {
        GoogleApiManager googleApiManager;
        synchronized (zaf) {
            if (zag == null) {
                HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
                handlerThread.start();
                zag = new GoogleApiManager(context.getApplicationContext(), handlerThread.getLooper(), GoogleApiAvailability.getInstance());
            }
            googleApiManager = zag;
        }
        return googleApiManager;
    }

    @WorkerThread
    private final zaa<?> zac(GoogleApi<?> googleApi) {
        ApiKey<?> apiKey = googleApi.getApiKey();
        zaa<?> zaa2 = this.zam.get(apiKey);
        if (zaa2 == null) {
            zaa2 = new zaa<>(googleApi);
            this.zam.put(apiKey, zaa2);
        }
        if (zaa2.zak()) {
            this.zap.add(apiKey);
        }
        zaa2.zai();
        return zaa2;
    }

    @Override // android.os.Handler.Callback
    @RecentlyNonNull
    @WorkerThread
    public boolean handleMessage(@RecentlyNonNull Message message) {
        long j = 300000;
        zaa<?> zaa2 = null;
        switch (message.what) {
            case 1:
                if (((Boolean) message.obj).booleanValue()) {
                    j = 10000;
                }
                this.zae = j;
                this.zaq.removeMessages(12);
                for (ApiKey<?> apiKey : this.zam.keySet()) {
                    Handler handler = this.zaq;
                    handler.sendMessageDelayed(handler.obtainMessage(12, apiKey), this.zae);
                }
                break;
            case 2:
                zaj zaj2 = (zaj) message.obj;
                Iterator<ApiKey<?>> it = zaj2.zaa().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    } else {
                        ApiKey<?> next = it.next();
                        zaa<?> zaa3 = this.zam.get(next);
                        if (zaa3 == null) {
                            zaj2.zaa(next, new ConnectionResult(13), null);
                            break;
                        } else if (zaa3.zaj()) {
                            zaj2.zaa(next, ConnectionResult.RESULT_SUCCESS, zaa3.zab().getEndpointPackageName());
                        } else {
                            ConnectionResult zae2 = zaa3.zae();
                            if (zae2 != null) {
                                zaj2.zaa(next, zae2, null);
                            } else {
                                zaa3.zaa(zaj2);
                                zaa3.zai();
                            }
                        }
                    }
                }
            case 3:
                for (zaa<?> zaa4 : this.zam.values()) {
                    zaa4.zad();
                    zaa4.zai();
                }
                break;
            case 4:
            case 8:
            case 13:
                zabr zabr = (zabr) message.obj;
                zaa<?> zaa5 = this.zam.get(zabr.zac.getApiKey());
                if (zaa5 == null) {
                    zaa5 = zac(zabr.zac);
                }
                if (!zaa5.zak() || this.zal.get() == zabr.zab) {
                    zaa5.zaa(zabr.zaa);
                    break;
                } else {
                    zabr.zaa.zaa(zaa);
                    zaa5.zaa();
                    break;
                }
                break;
            case 5:
                int i = message.arg1;
                ConnectionResult connectionResult = (ConnectionResult) message.obj;
                Iterator<zaa<?>> it2 = this.zam.values().iterator();
                while (true) {
                    if (it2.hasNext()) {
                        zaa<?> next2 = it2.next();
                        if (next2.zal() == i) {
                            zaa2 = next2;
                        }
                    }
                }
                if (zaa2 != null) {
                    if (connectionResult.getErrorCode() == 13) {
                        String errorString = this.zai.getErrorString(connectionResult.getErrorCode());
                        String errorMessage = connectionResult.getErrorMessage();
                        zaa2.zaa(new Status(17, a.t2(a.q0(errorMessage, a.q0(errorString, 69)), "Error resolution was canceled by the user, original error message: ", errorString, ": ", errorMessage)));
                        break;
                    } else {
                        zaa2.zaa(zab(((zaa) zaa2).zad, connectionResult));
                        break;
                    }
                } else {
                    Log.wtf("GoogleApiManager", a.o2(76, "Could not find API instance ", i, " while trying to fail enqueued calls."), new Exception());
                    break;
                }
            case 6:
                if (this.zah.getApplicationContext() instanceof Application) {
                    BackgroundDetector.initialize((Application) this.zah.getApplicationContext());
                    BackgroundDetector.getInstance().addListener(new zabc(this));
                    if (!BackgroundDetector.getInstance().readCurrentStateIfPossible(true)) {
                        this.zae = 300000;
                        break;
                    }
                }
                break;
            case 7:
                zac((GoogleApi) message.obj);
                break;
            case 9:
                if (this.zam.containsKey(message.obj)) {
                    this.zam.get(message.obj).zaf();
                    break;
                }
                break;
            case 10:
                for (ApiKey<?> apiKey2 : this.zap) {
                    zaa<?> remove = this.zam.remove(apiKey2);
                    if (remove != null) {
                        remove.zaa();
                    }
                }
                this.zap.clear();
                break;
            case 11:
                if (this.zam.containsKey(message.obj)) {
                    this.zam.get(message.obj).zag();
                    break;
                }
                break;
            case 12:
                if (this.zam.containsKey(message.obj)) {
                    this.zam.get(message.obj).zah();
                    break;
                }
                break;
            case 14:
                zaaa zaaa = (zaaa) message.obj;
                ApiKey<?> zaa6 = zaaa.zaa();
                if (!this.zam.containsKey(zaa6)) {
                    zaaa.zab().setResult(Boolean.FALSE);
                    break;
                } else {
                    zaaa.zab().setResult(Boolean.valueOf(this.zam.get(zaa6).zaa(false)));
                    break;
                }
            case 15:
                zab zab2 = (zab) message.obj;
                if (this.zam.containsKey(zab2.zaa)) {
                    this.zam.get(zab2.zaa).zaa(zab2);
                    break;
                }
                break;
            case 16:
                zab zab3 = (zab) message.obj;
                if (this.zam.containsKey(zab3.zaa)) {
                    this.zam.get(zab3.zaa).zab(zab3);
                    break;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    @RecentlyNonNull
    public final int zab() {
        return this.zak.getAndIncrement();
    }

    public class zac implements zace, BaseGmsClient.ConnectionProgressReportCallbacks {
        private final Api.Client zab;
        private final ApiKey<?> zac;
        @Nullable
        private IAccountAccessor zad = null;
        @Nullable
        private Set<Scope> zae = null;
        private boolean zaf = false;

        public zac(Api.Client client, ApiKey<?> apiKey) {
            this.zab = client;
            this.zac = apiKey;
        }

        @Override // com.google.android.gms.common.internal.BaseGmsClient.ConnectionProgressReportCallbacks
        public final void onReportServiceBinding(@NonNull ConnectionResult connectionResult) {
            GoogleApiManager.this.zaq.post(new zabi(this, connectionResult));
        }

        @Override // com.google.android.gms.common.api.internal.zace
        @WorkerThread
        public final void zaa(ConnectionResult connectionResult) {
            zaa zaa2 = (zaa) GoogleApiManager.this.zam.get(this.zac);
            if (zaa2 != null) {
                zaa2.zaa(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.api.internal.zace
        @WorkerThread
        public final void zaa(@Nullable IAccountAccessor iAccountAccessor, @Nullable Set<Scope> set) {
            if (iAccountAccessor == null || set == null) {
                Log.wtf("GoogleApiManager", "Received null response from onSignInSuccess", new Exception());
                zaa(new ConnectionResult(4));
                return;
            }
            this.zad = iAccountAccessor;
            this.zae = set;
            zaa();
        }

        /* access modifiers changed from: private */
        @WorkerThread
        public final void zaa() {
            IAccountAccessor iAccountAccessor;
            if (this.zaf && (iAccountAccessor = this.zad) != null) {
                this.zab.getRemoteService(iAccountAccessor, this.zae);
            }
        }
    }

    public final void zab(@NonNull zax zax) {
        synchronized (zaf) {
            if (this.zan == zax) {
                this.zan = null;
                this.zao.clear();
            }
        }
    }

    public static class zab {
        private final ApiKey<?> zaa;
        private final Feature zab;

        private zab(ApiKey<?> apiKey, Feature feature) {
            this.zaa = apiKey;
            this.zab = feature;
        }

        public final boolean equals(@Nullable Object obj) {
            if (obj != null && (obj instanceof zab)) {
                zab zab2 = (zab) obj;
                if (Objects.equal(this.zaa, zab2.zaa) && Objects.equal(this.zab, zab2.zab)) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return Objects.hashCode(this.zaa, this.zab);
        }

        public final String toString() {
            return Objects.toStringHelper(this).add("key", this.zaa).add("feature", this.zab).toString();
        }

        public /* synthetic */ zab(ApiKey apiKey, Feature feature, zabc zabc) {
            this(apiKey, feature);
        }
    }

    @RecentlyNonNull
    public final Task<Boolean> zab(@RecentlyNonNull GoogleApi<?> googleApi) {
        zaaa zaaa = new zaaa(googleApi.getApiKey());
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(14, zaaa));
        return zaaa.zab().getTask();
    }

    public final void zac() {
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(3));
    }

    @RecentlyNonNull
    public static GoogleApiManager zaa() {
        GoogleApiManager googleApiManager;
        synchronized (zaf) {
            Preconditions.checkNotNull(zag, "Must guarantee manager is non-null before using getInstance");
            googleApiManager = zag;
        }
        return googleApiManager;
    }

    public final void zab(@RecentlyNonNull ConnectionResult connectionResult, @RecentlyNonNull int i) {
        if (!zaa(connectionResult, i)) {
            Handler handler = this.zaq;
            handler.sendMessage(handler.obtainMessage(5, i, 0, connectionResult));
        }
    }

    /* access modifiers changed from: private */
    public static Status zab(ApiKey<?> apiKey, ConnectionResult connectionResult) {
        String apiName = apiKey.getApiName();
        String valueOf = String.valueOf(connectionResult);
        return new Status(connectionResult, a.t2(valueOf.length() + a.q0(apiName, 63), "API: ", apiName, " is not available on this device. Connection failed with: ", valueOf));
    }

    public final void zaa(@RecentlyNonNull GoogleApi<?> googleApi) {
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(7, googleApi));
    }

    public final void zaa(@NonNull zax zax) {
        synchronized (zaf) {
            if (this.zan != zax) {
                this.zan = zax;
                this.zao.clear();
            }
            this.zao.addAll(zax.zac());
        }
    }

    @RecentlyNonNull
    public final Task<Map<ApiKey<?>, String>> zaa(@RecentlyNonNull Iterable<? extends HasApiKey<?>> iterable) {
        zaj zaj2 = new zaj(iterable);
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(2, zaj2));
        return zaj2.zab();
    }

    public final <O extends Api.ApiOptions> void zaa(@RecentlyNonNull GoogleApi<O> googleApi, @RecentlyNonNull int i, @RecentlyNonNull BaseImplementation.ApiMethodImpl<? extends Result, Api.AnyClient> apiMethodImpl) {
        zad zad2 = new zad(i, apiMethodImpl);
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(4, new zabr(zad2, this.zal.get(), googleApi)));
    }

    public final <O extends Api.ApiOptions, ResultT> void zaa(@RecentlyNonNull GoogleApi<O> googleApi, @RecentlyNonNull int i, @RecentlyNonNull TaskApiCall<Api.AnyClient, ResultT> taskApiCall, @RecentlyNonNull TaskCompletionSource<ResultT> taskCompletionSource, @RecentlyNonNull StatusExceptionMapper statusExceptionMapper) {
        zaf zaf2 = new zaf(i, taskApiCall, taskCompletionSource, statusExceptionMapper);
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(4, new zabr(zaf2, this.zal.get(), googleApi)));
    }

    @RecentlyNonNull
    public final <O extends Api.ApiOptions> Task<Void> zaa(@RecentlyNonNull GoogleApi<O> googleApi, @RecentlyNonNull RegisterListenerMethod<Api.AnyClient, ?> registerListenerMethod, @RecentlyNonNull UnregisterListenerMethod<Api.AnyClient, ?> unregisterListenerMethod, @RecentlyNonNull Runnable runnable) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zag zag2 = new zag(new zabs(registerListenerMethod, unregisterListenerMethod, runnable), taskCompletionSource);
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(8, new zabr(zag2, this.zal.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    @RecentlyNonNull
    public final <O extends Api.ApiOptions> Task<Boolean> zaa(@RecentlyNonNull GoogleApi<O> googleApi, @RecentlyNonNull ListenerHolder.ListenerKey<?> listenerKey) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        zah zah2 = new zah(listenerKey, taskCompletionSource);
        Handler handler = this.zaq;
        handler.sendMessage(handler.obtainMessage(13, new zabr(zah2, this.zal.get(), googleApi)));
        return taskCompletionSource.getTask();
    }

    public final boolean zaa(ConnectionResult connectionResult, int i) {
        return this.zai.zaa(this.zah, connectionResult, i);
    }
}
