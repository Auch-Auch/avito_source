package com.google.android.gms.common.api.internal;

import a2.b.a.a.a;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
@KeepForSdk
@KeepName
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {
    public static final ThreadLocal<Boolean> zaa = new zao();
    @KeepName
    private zaa mResultGuardian;
    private final Object zab;
    private final CallbackHandler<R> zac;
    private final WeakReference<GoogleApiClient> zad;
    private final CountDownLatch zae;
    private final ArrayList<PendingResult.StatusListener> zaf;
    @Nullable
    private ResultCallback<? super R> zag;
    private final AtomicReference<zacn> zah;
    @Nullable
    private R zai;
    private Status zaj;
    private volatile boolean zak;
    private boolean zal;
    private boolean zam;
    @Nullable
    private ICancelToken zan;
    private volatile zack<R> zao;
    private boolean zap;

    @VisibleForTesting
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: com.google.android.gms.common.api.ResultCallback */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(@RecentlyNonNull Message message) {
            int i = message.what;
            if (i == 1) {
                Pair pair = (Pair) message.obj;
                ResultCallback resultCallback = (ResultCallback) pair.first;
                Result result = (Result) pair.second;
                try {
                    resultCallback.onResult(result);
                } catch (RuntimeException e) {
                    BasePendingResult.zaa(result);
                    throw e;
                }
            } else if (i != 2) {
                Log.wtf("BasePendingResult", a.m2(45, "Don't know how to handle message: ", i), new Exception());
            } else {
                ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        }

        public final void zaa(@RecentlyNonNull ResultCallback<? super R> resultCallback, @RecentlyNonNull R r) {
            sendMessage(obtainMessage(1, new Pair((ResultCallback) Preconditions.checkNotNull(BasePendingResult.zab(resultCallback)), r)));
        }

        public CallbackHandler(@RecentlyNonNull Looper looper) {
            super(looper);
        }
    }

    public final class zaa {
        private zaa() {
        }

        public final void finalize() throws Throwable {
            BasePendingResult.zaa(BasePendingResult.this.zai);
            super.finalize();
        }

        public /* synthetic */ zaa(BasePendingResult basePendingResult, zao zao) {
            this();
        }
    }

    @Deprecated
    public BasePendingResult() {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(Looper.getMainLooper());
        this.zad = new WeakReference<>(null);
    }

    /* access modifiers changed from: private */
    @Nullable
    public static <R extends Result> ResultCallback<R> zab(@Nullable ResultCallback<R> resultCallback) {
        return resultCallback;
    }

    private final R zac() {
        R r;
        synchronized (this.zab) {
            Preconditions.checkState(!this.zak, "Result has already been consumed.");
            Preconditions.checkState(isReady(), "Result is not ready.");
            r = this.zai;
            this.zai = null;
            this.zag = null;
            this.zak = true;
        }
        zacn andSet = this.zah.getAndSet(null);
        if (andSet != null) {
            andSet.zaa(this);
        }
        return (R) ((Result) Preconditions.checkNotNull(r));
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void addStatusListener(@RecentlyNonNull PendingResult.StatusListener statusListener) {
        Preconditions.checkArgument(statusListener != null, "Callback cannot be null.");
        synchronized (this.zab) {
            if (isReady()) {
                statusListener.onComplete(this.zaj);
            } else {
                this.zaf.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public final R await() {
        Preconditions.checkNotMainThread("await must not be called on the UI thread");
        boolean z = true;
        Preconditions.checkState(!this.zak, "Result has already been consumed");
        if (this.zao != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            this.zae.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zac();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void cancel() {
        synchronized (this.zab) {
            if (!this.zal) {
                if (!this.zak) {
                    ICancelToken iCancelToken = this.zan;
                    if (iCancelToken != null) {
                        try {
                            iCancelToken.cancel();
                        } catch (RemoteException unused) {
                        }
                    }
                    zaa(this.zai);
                    this.zal = true;
                    zab((BasePendingResult<R>) createFailedResult(Status.RESULT_CANCELED));
                }
            }
        }
    }

    @NonNull
    @KeepForSdk
    public abstract R createFailedResult(@RecentlyNonNull Status status);

    @KeepForSdk
    @Deprecated
    public final void forceFailureUnlessReady(@RecentlyNonNull Status status) {
        synchronized (this.zab) {
            if (!isReady()) {
                setResult(createFailedResult(status));
                this.zam = true;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zab) {
            z = this.zal;
        }
        return z;
    }

    @RecentlyNonNull
    @KeepForSdk
    public final boolean isReady() {
        return this.zae.getCount() == 0;
    }

    @KeepForSdk
    public final void setCancelToken(@RecentlyNonNull ICancelToken iCancelToken) {
        synchronized (this.zab) {
            this.zan = iCancelToken;
        }
    }

    @KeepForSdk
    public final void setResult(@RecentlyNonNull R r) {
        synchronized (this.zab) {
            if (this.zam || this.zal) {
                zaa(r);
                return;
            }
            isReady();
            boolean z = true;
            Preconditions.checkState(!isReady(), "Results have already been set");
            if (this.zak) {
                z = false;
            }
            Preconditions.checkState(z, "Result has already been consumed");
            zab((BasePendingResult<R>) r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(@Nullable ResultCallback<? super R> resultCallback) {
        synchronized (this.zab) {
            if (resultCallback == null) {
                this.zag = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zac.zaa(resultCallback, zac());
                } else {
                    this.zag = resultCallback;
                }
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public <S extends Result> TransformedResult<S> then(@RecentlyNonNull ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        Preconditions.checkState(!this.zak, "Result has already been consumed.");
        synchronized (this.zab) {
            boolean z = false;
            Preconditions.checkState(this.zao == null, "Cannot call then() twice.");
            Preconditions.checkState(this.zag == null, "Cannot call then() if callbacks are set.");
            if (!this.zal) {
                z = true;
            }
            Preconditions.checkState(z, "Cannot call then() if result was canceled.");
            this.zap = true;
            this.zao = new zack<>(this.zad);
            then = this.zao.then(resultTransform);
            if (isReady()) {
                this.zac.zaa(this.zao, zac());
            } else {
                this.zag = this.zao;
            }
        }
        return then;
    }

    @RecentlyNonNull
    public final boolean zaa() {
        boolean isCanceled;
        synchronized (this.zab) {
            if (this.zad.get() == null || !this.zap) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public final void zab() {
        this.zap = this.zap || zaa.get().booleanValue();
    }

    private final void zab(R r) {
        this.zai = r;
        this.zaj = r.getStatus();
        this.zan = null;
        this.zae.countDown();
        if (this.zal) {
            this.zag = null;
        } else {
            ResultCallback<? super R> resultCallback = this.zag;
            if (resultCallback != null) {
                this.zac.removeMessages(2);
                this.zac.zaa(resultCallback, zac());
            } else if (this.zai instanceof Releasable) {
                this.mResultGuardian = new zaa(this, null);
            }
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.zaf;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.onComplete(this.zaj);
        }
        this.zaf.clear();
    }

    public final void zaa(@Nullable zacn zacn) {
        this.zah.set(zacn);
    }

    public static void zaa(@Nullable Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException unused) {
                String.valueOf(result).length();
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @RecentlyNonNull
    public final R await(@RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.checkNotMainThread("await must not be called on the UI thread when time is greater than zero.");
        }
        boolean z = true;
        Preconditions.checkState(!this.zak, "Result has already been consumed.");
        if (this.zao != null) {
            z = false;
        }
        Preconditions.checkState(z, "Cannot await if then() has been called.");
        try {
            if (!this.zae.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.RESULT_TIMEOUT);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.RESULT_INTERRUPTED);
        }
        Preconditions.checkState(isReady(), "Result is not ready.");
        return zac();
    }

    @KeepForSdk
    public BasePendingResult(@Nullable GoogleApiClient googleApiClient) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.zad = new WeakReference<>(googleApiClient);
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void setResultCallback(@RecentlyNonNull ResultCallback<? super R> resultCallback, @RecentlyNonNull long j, @RecentlyNonNull TimeUnit timeUnit) {
        synchronized (this.zab) {
            if (resultCallback == null) {
                this.zag = null;
                return;
            }
            boolean z = true;
            Preconditions.checkState(!this.zak, "Result has already been consumed.");
            if (this.zao != null) {
                z = false;
            }
            Preconditions.checkState(z, "Cannot set callbacks if then() has been called.");
            if (!isCanceled()) {
                if (isReady()) {
                    this.zac.zaa(resultCallback, zac());
                } else {
                    this.zag = resultCallback;
                    CallbackHandler<R> callbackHandler = this.zac;
                    callbackHandler.sendMessageDelayed(callbackHandler.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            }
        }
    }

    @KeepForSdk
    @Deprecated
    public BasePendingResult(@RecentlyNonNull Looper looper) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = new CallbackHandler<>(looper);
        this.zad = new WeakReference<>(null);
    }

    @VisibleForTesting
    @KeepForSdk
    public BasePendingResult(@RecentlyNonNull CallbackHandler<R> callbackHandler) {
        this.zab = new Object();
        this.zae = new CountDownLatch(1);
        this.zaf = new ArrayList<>();
        this.zah = new AtomicReference<>();
        this.zap = false;
        this.zac = (CallbackHandler) Preconditions.checkNotNull(callbackHandler, "CallbackHandler must not be null");
        this.zad = new WeakReference<>(null);
    }
}
