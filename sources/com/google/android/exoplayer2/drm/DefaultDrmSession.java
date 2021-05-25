package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CopyOnWriteMultiset;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
@RequiresApi(18)
public class DefaultDrmSession implements DrmSession {
    @Nullable
    public final List<DrmInitData.SchemeData> a;
    public final ExoMediaDrm b;
    public final ProvisioningManager c;
    public final ReferenceCountListener d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap<String, String> h;
    public final CopyOnWriteMultiset<DrmSessionEventListener.EventDispatcher> i;
    public final LoadErrorHandlingPolicy j;
    public final MediaDrmCallback k;
    public final UUID l;
    public final c m;
    public int n;
    public int o;
    @Nullable
    public HandlerThread p;
    @Nullable
    public a q;
    @Nullable
    public ExoMediaCrypto r;
    @Nullable
    public DrmSession.DrmSessionException s;
    @Nullable
    public byte[] t;
    public byte[] u;
    @Nullable
    public ExoMediaDrm.KeyRequest v;
    @Nullable
    public ExoMediaDrm.ProvisionRequest w;

    public interface ProvisioningManager {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession defaultDrmSession);
    }

    public interface ReferenceCountListener {
        void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i);

        void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i);
    }

    public static final class UnexpectedDrmSessionException extends IOException {
        public UnexpectedDrmSessionException(@Nullable Throwable th) {
            super(th);
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void a(int i, Object obj, boolean z) {
            obtainMessage(i, new b(LoadEventInfo.getNewId(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        /* JADX DEBUG: Failed to insert an additional move for type inference into block B:24:0x00b7 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Object */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [com.google.android.exoplayer2.drm.MediaDrmCallbackException, java.io.IOException] */
        /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Throwable, java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r0v9, types: [byte[]] */
        /* JADX WARN: Type inference failed for: r0v13, types: [byte[]] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00b9 A[RETURN] */
        @Override // android.os.Handler
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void handleMessage(android.os.Message r23) {
            /*
                r22 = this;
                r1 = r22
                r2 = r23
                java.lang.Object r0 = r2.obj
                r3 = r0
                com.google.android.exoplayer2.drm.DefaultDrmSession$b r3 = (com.google.android.exoplayer2.drm.DefaultDrmSession.b) r3
                r4 = 1
                int r0 = r2.what     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                if (r0 == 0) goto L_0x0026
                if (r0 != r4) goto L_0x0020
                com.google.android.exoplayer2.drm.DefaultDrmSession r0 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                com.google.android.exoplayer2.drm.MediaDrmCallback r5 = r0.k     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                java.util.UUID r0 = r0.l     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                java.lang.Object r6 = r3.d     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                com.google.android.exoplayer2.drm.ExoMediaDrm$KeyRequest r6 = (com.google.android.exoplayer2.drm.ExoMediaDrm.KeyRequest) r6     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                byte[] r0 = r5.executeKeyRequest(r0, r6)     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                goto L_0x00ba
            L_0x0020:
                java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                r0.<init>()     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                throw r0     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
            L_0x0026:
                com.google.android.exoplayer2.drm.DefaultDrmSession r0 = com.google.android.exoplayer2.drm.DefaultDrmSession.this     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                com.google.android.exoplayer2.drm.MediaDrmCallback r5 = r0.k     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                java.util.UUID r0 = r0.l     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                java.lang.Object r6 = r3.d     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                com.google.android.exoplayer2.drm.ExoMediaDrm$ProvisionRequest r6 = (com.google.android.exoplayer2.drm.ExoMediaDrm.ProvisionRequest) r6     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                byte[] r0 = r5.executeProvisionRequest(r0, r6)     // Catch:{ MediaDrmCallbackException -> 0x0040, Exception -> 0x0036 }
                goto L_0x00ba
            L_0x0036:
                r0 = move-exception
                java.lang.String r4 = "DefaultDrmSession"
                java.lang.String r5 = "Key/provisioning request produced an unexpected exception. Not retrying."
                com.google.android.exoplayer2.util.Log.w(r4, r5, r0)
                goto L_0x00ba
            L_0x0040:
                r0 = move-exception
                java.lang.Object r5 = r2.obj
                com.google.android.exoplayer2.drm.DefaultDrmSession$b r5 = (com.google.android.exoplayer2.drm.DefaultDrmSession.b) r5
                boolean r6 = r5.b
                if (r6 != 0) goto L_0x004b
            L_0x0049:
                r4 = 0
                goto L_0x00b7
            L_0x004b:
                int r6 = r5.e
                int r6 = r6 + r4
                r5.e = r6
                com.google.android.exoplayer2.drm.DefaultDrmSession r8 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r8 = r8.j
                r9 = 3
                int r8 = r8.getMinimumLoadableRetryCount(r9)
                if (r6 <= r8) goto L_0x005c
                goto L_0x0049
            L_0x005c:
                com.google.android.exoplayer2.source.LoadEventInfo r6 = new com.google.android.exoplayer2.source.LoadEventInfo
                long r11 = r5.a
                com.google.android.exoplayer2.upstream.DataSpec r13 = r0.dataSpec
                android.net.Uri r14 = r0.uriAfterRedirects
                java.util.Map<java.lang.String, java.util.List<java.lang.String>> r15 = r0.responseHeaders
                long r16 = android.os.SystemClock.elapsedRealtime()
                long r18 = android.os.SystemClock.elapsedRealtime()
                long r7 = r5.c
                long r18 = r18 - r7
                long r7 = r0.bytesLoaded
                r10 = r6
                r20 = r7
                r10.<init>(r11, r13, r14, r15, r16, r18, r20)
                com.google.android.exoplayer2.source.MediaLoadData r7 = new com.google.android.exoplayer2.source.MediaLoadData
                r7.<init>(r9)
                java.lang.Throwable r8 = r0.getCause()
                boolean r8 = r8 instanceof java.io.IOException
                if (r8 == 0) goto L_0x008e
                java.lang.Throwable r8 = r0.getCause()
                java.io.IOException r8 = (java.io.IOException) r8
                goto L_0x0097
            L_0x008e:
                com.google.android.exoplayer2.drm.DefaultDrmSession$UnexpectedDrmSessionException r8 = new com.google.android.exoplayer2.drm.DefaultDrmSession$UnexpectedDrmSessionException
                java.lang.Throwable r9 = r0.getCause()
                r8.<init>(r9)
            L_0x0097:
                com.google.android.exoplayer2.drm.DefaultDrmSession r9 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r9 = r9.j
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo r10 = new com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo
                int r5 = r5.e
                r10.<init>(r6, r7, r8, r5)
                long r5 = r9.getRetryDelayMsFor(r10)
                r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
                int r9 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r9 != 0) goto L_0x00b0
                goto L_0x0049
            L_0x00b0:
                android.os.Message r7 = android.os.Message.obtain(r23)
                r1.sendMessageDelayed(r7, r5)
            L_0x00b7:
                if (r4 == 0) goto L_0x00ba
                return
            L_0x00ba:
                com.google.android.exoplayer2.drm.DefaultDrmSession r4 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy r4 = r4.j
                long r5 = r3.a
                r4.onLoadTaskConcluded(r5)
                com.google.android.exoplayer2.drm.DefaultDrmSession r4 = com.google.android.exoplayer2.drm.DefaultDrmSession.this
                com.google.android.exoplayer2.drm.DefaultDrmSession$c r4 = r4.m
                int r2 = r2.what
                java.lang.Object r3 = r3.d
                android.util.Pair r0 = android.util.Pair.create(r3, r0)
                android.os.Message r0 = r4.obtainMessage(r2, r0)
                r0.sendToTarget()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.drm.DefaultDrmSession.a.handleMessage(android.os.Message):void");
        }
    }

    public static final class b {
        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;

        public b(long j, boolean z, long j2, Object obj) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                if (obj != defaultDrmSession.w) {
                    return;
                }
                if (defaultDrmSession.n == 2 || defaultDrmSession.b()) {
                    defaultDrmSession.w = null;
                    if (obj2 instanceof Exception) {
                        defaultDrmSession.c.onProvisionError((Exception) obj2);
                        return;
                    }
                    try {
                        defaultDrmSession.b.provideProvisionResponse((byte[]) obj2);
                        defaultDrmSession.c.onProvisionCompleted();
                    } catch (Exception e) {
                        defaultDrmSession.c.onProvisionError(e);
                    }
                }
            } else if (i == 1) {
                DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                if (obj == defaultDrmSession2.v && defaultDrmSession2.b()) {
                    defaultDrmSession2.v = null;
                    if (obj2 instanceof Exception) {
                        defaultDrmSession2.d((Exception) obj2);
                        return;
                    }
                    try {
                        byte[] bArr = (byte[]) obj2;
                        if (defaultDrmSession2.e == 3) {
                            defaultDrmSession2.b.provideKeyResponse((byte[]) Util.castNonNull(defaultDrmSession2.u), bArr);
                            for (DrmSessionEventListener.EventDispatcher eventDispatcher : defaultDrmSession2.i.elementSet()) {
                                eventDispatcher.drmKeysRemoved();
                            }
                            return;
                        }
                        byte[] provideKeyResponse = defaultDrmSession2.b.provideKeyResponse(defaultDrmSession2.t, bArr);
                        int i2 = defaultDrmSession2.e;
                        if (!((i2 != 2 && (i2 != 0 || defaultDrmSession2.u == null)) || provideKeyResponse == null || provideKeyResponse.length == 0)) {
                            defaultDrmSession2.u = provideKeyResponse;
                        }
                        defaultDrmSession2.n = 4;
                        for (DrmSessionEventListener.EventDispatcher eventDispatcher2 : defaultDrmSession2.i.elementSet()) {
                            eventDispatcher2.drmKeysLoaded();
                        }
                    } catch (Exception e2) {
                        defaultDrmSession2.d(e2);
                    }
                }
            }
        }
    }

    public DefaultDrmSession(UUID uuid, ExoMediaDrm exoMediaDrm, ProvisioningManager provisioningManager, ReferenceCountListener referenceCountListener, @Nullable List<DrmInitData.SchemeData> list, int i2, boolean z, boolean z2, @Nullable byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (i2 == 1 || i2 == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.l = uuid;
        this.c = provisioningManager;
        this.d = referenceCountListener;
        this.b = exoMediaDrm;
        this.e = i2;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.u = bArr;
            this.a = null;
        } else {
            this.a = Collections.unmodifiableList((List) Assertions.checkNotNull(list));
        }
        this.h = hashMap;
        this.k = mediaDrmCallback;
        this.i = new CopyOnWriteMultiset<>();
        this.j = loadErrorHandlingPolicy;
        this.n = 2;
        this.m = new c(looper);
    }

    @RequiresNonNull({"sessionId"})
    public final void a(boolean z) {
        long j2;
        if (!this.g) {
            byte[] bArr = (byte[]) Util.castNonNull(this.t);
            int i2 = this.e;
            if (i2 == 0 || i2 == 1) {
                if (this.u == null) {
                    f(bArr, 1, z);
                } else if (this.n == 4 || h()) {
                    if (!C.WIDEVINE_UUID.equals(this.l)) {
                        j2 = Long.MAX_VALUE;
                    } else {
                        Pair pair = (Pair) Assertions.checkNotNull(WidevineUtil.getLicenseDurationRemainingSec(this));
                        j2 = Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
                    }
                    if (this.e == 0 && j2 <= 60) {
                        Log.d("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + j2);
                        f(bArr, 2, z);
                    } else if (j2 <= 0) {
                        c(new KeysExpiredException());
                    } else {
                        this.n = 4;
                        for (DrmSessionEventListener.EventDispatcher eventDispatcher : this.i.elementSet()) {
                            eventDispatcher.drmKeysRestored();
                        }
                    }
                }
            } else if (i2 != 2) {
                if (i2 == 3) {
                    Assertions.checkNotNull(this.u);
                    Assertions.checkNotNull(this.t);
                    if (h()) {
                        f(this.u, 3, z);
                    }
                }
            } else if (this.u == null || h()) {
                f(bArr, 2, z);
            }
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void acquire(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        boolean z = false;
        Assertions.checkState(this.o >= 0);
        if (eventDispatcher != null) {
            this.i.add(eventDispatcher);
        }
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 == 1) {
            if (this.n == 2) {
                z = true;
            }
            Assertions.checkState(z);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.p = handlerThread;
            handlerThread.start();
            this.q = new a(this.p.getLooper());
            if (e(true)) {
                a(true);
            }
        } else if (eventDispatcher != null && b()) {
            eventDispatcher.drmSessionAcquired();
        }
        this.d.onReferenceCountIncremented(this, this.o);
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean b() {
        int i2 = this.n;
        return i2 == 3 || i2 == 4;
    }

    public final void c(Exception exc) {
        this.s = new DrmSession.DrmSessionException(exc);
        for (DrmSessionEventListener.EventDispatcher eventDispatcher : this.i.elementSet()) {
            eventDispatcher.drmSessionManagerError(exc);
        }
        if (this.n != 4) {
            this.n = 1;
        }
    }

    public final void d(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.c.provisionRequired(this);
        } else {
            c(exc);
        }
    }

    @EnsuresNonNullIf(expression = {"sessionId"}, result = true)
    public final boolean e(boolean z) {
        if (b()) {
            return true;
        }
        try {
            byte[] openSession = this.b.openSession();
            this.t = openSession;
            this.r = this.b.createMediaCrypto(openSession);
            for (DrmSessionEventListener.EventDispatcher eventDispatcher : this.i.elementSet()) {
                eventDispatcher.drmSessionAcquired();
            }
            this.n = 3;
            Assertions.checkNotNull(this.t);
            return true;
        } catch (NotProvisionedException e2) {
            if (z) {
                this.c.provisionRequired(this);
                return false;
            }
            c(e2);
            return false;
        } catch (Exception e3) {
            c(e3);
            return false;
        }
    }

    public final void f(byte[] bArr, int i2, boolean z) {
        try {
            this.v = this.b.getKeyRequest(bArr, this.a, i2, this.h);
            ((a) Util.castNonNull(this.q)).a(1, Assertions.checkNotNull(this.v), z);
        } catch (Exception e2) {
            d(e2);
        }
    }

    public void g() {
        this.w = this.b.getProvisionRequest();
        ((a) Util.castNonNull(this.q)).a(0, Assertions.checkNotNull(this.w), true);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final DrmSession.DrmSessionException getError() {
        if (this.n == 1) {
            return this.s;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public final ExoMediaCrypto getMediaCrypto() {
        return this.r;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public byte[] getOfflineLicenseKeySetId() {
        return this.u;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public final int getState() {
        return this.n;
    }

    @RequiresNonNull({"sessionId", "offlineLicenseKeySetId"})
    public final boolean h() {
        try {
            this.b.restoreKeys(this.t, this.u);
            return true;
        } catch (Exception e2) {
            Log.e("DefaultDrmSession", "Error trying to restore keys.", e2);
            c(e2);
            return false;
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public boolean playClearSamplesWithoutKeys() {
        return this.f;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    @Nullable
    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.t;
        if (bArr == null) {
            return null;
        }
        return this.b.queryKeyStatus(bArr);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSession
    public void release(@Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkState(this.o > 0);
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 == 0) {
            this.n = 0;
            ((c) Util.castNonNull(this.m)).removeCallbacksAndMessages(null);
            ((a) Util.castNonNull(this.q)).removeCallbacksAndMessages(null);
            this.q = null;
            ((HandlerThread) Util.castNonNull(this.p)).quit();
            this.p = null;
            this.r = null;
            this.s = null;
            this.v = null;
            this.w = null;
            byte[] bArr = this.t;
            if (bArr != null) {
                this.b.closeSession(bArr);
                this.t = null;
            }
            for (DrmSessionEventListener.EventDispatcher eventDispatcher2 : this.i.elementSet()) {
                eventDispatcher2.drmSessionReleased();
            }
        }
        if (eventDispatcher != null) {
            if (b()) {
                eventDispatcher.drmSessionReleased();
            }
            this.i.remove(eventDispatcher);
        }
        this.d.onReferenceCountDecremented(this, this.o);
    }
}
