package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DefaultDrmSession;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.ExoMediaDrm;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
@RequiresApi(18)
public class DefaultDrmSessionManager implements DrmSessionManager {
    public static final long DEFAULT_SESSION_KEEPALIVE_MS = 300000;
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    public final UUID a;
    public final ExoMediaDrm.Provider b;
    public final MediaDrmCallback c;
    public final HashMap<String, String> d;
    public final boolean e;
    public final int[] f;
    public final boolean g;
    public final d h;
    public final LoadErrorHandlingPolicy i;
    public final e j;
    public final long k;
    public final List<DefaultDrmSession> l;
    public final List<DefaultDrmSession> m;
    public final Set<DefaultDrmSession> n;
    public int o;
    @Nullable
    public ExoMediaDrm p;
    @Nullable
    public DefaultDrmSession q;
    @Nullable
    public DefaultDrmSession r;
    @Nullable
    public Looper s;
    public Handler t;
    public int u;
    @Nullable
    public byte[] v;
    @Nullable
    public volatile c w;

    public static final class Builder {
        public final HashMap<String, String> a = new HashMap<>();
        public UUID b = C.WIDEVINE_UUID;
        public ExoMediaDrm.Provider c = FrameworkMediaDrm.DEFAULT_PROVIDER;
        public boolean d;
        public int[] e = new int[0];
        public boolean f;
        public LoadErrorHandlingPolicy g = new DefaultLoadErrorHandlingPolicy();
        public long h = 300000;

        public DefaultDrmSessionManager build(MediaDrmCallback mediaDrmCallback) {
            return new DefaultDrmSessionManager(this.b, this.c, mediaDrmCallback, this.a, this.d, this.e, this.f, this.g, this.h);
        }

        public Builder setKeyRequestParameters(@Nullable Map<String, String> map) {
            this.a.clear();
            if (map != null) {
                this.a.putAll(map);
            }
            return this;
        }

        public Builder setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
            this.g = (LoadErrorHandlingPolicy) Assertions.checkNotNull(loadErrorHandlingPolicy);
            return this;
        }

        public Builder setMultiSession(boolean z) {
            this.d = z;
            return this;
        }

        public Builder setPlayClearSamplesWithoutKeys(boolean z) {
            this.f = z;
            return this;
        }

        public Builder setSessionKeepaliveMs(long j) {
            Assertions.checkArgument(j > 0 || j == C.TIME_UNSET);
            this.h = j;
            return this;
        }

        public Builder setUseDrmSessionsForClearContent(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (!(i == 2 || i == 1)) {
                    z = false;
                }
                Assertions.checkArgument(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public Builder setUuidAndExoMediaDrmProvider(UUID uuid, ExoMediaDrm.Provider provider) {
            this.b = (UUID) Assertions.checkNotNull(uuid);
            this.c = (ExoMediaDrm.Provider) Assertions.checkNotNull(provider);
            return this;
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        public MissingSchemeDataException(UUID uuid, a aVar) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    public class b implements ExoMediaDrm.OnEventListener {
        public b(a aVar) {
        }

        @Override // com.google.android.exoplayer2.drm.ExoMediaDrm.OnEventListener
        public void onEvent(ExoMediaDrm exoMediaDrm, @Nullable byte[] bArr, int i, int i2, @Nullable byte[] bArr2) {
            ((c) Assertions.checkNotNull(DefaultDrmSessionManager.this.w)).obtainMessage(i, bArr).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    public class c extends Handler {
        public c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr != null) {
                for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.l) {
                    if (Arrays.equals(defaultDrmSession.t, bArr)) {
                        if (message.what == 2 && defaultDrmSession.e == 0 && defaultDrmSession.n == 4) {
                            Util.castNonNull(defaultDrmSession.t);
                            defaultDrmSession.a(false);
                            return;
                        }
                        return;
                    }
                }
            }
        }
    }

    public class d implements DefaultDrmSession.ProvisioningManager {
        public d(a aVar) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionCompleted() {
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.m) {
                if (defaultDrmSession.e(false)) {
                    defaultDrmSession.a(true);
                }
            }
            DefaultDrmSessionManager.this.m.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void onProvisionError(Exception exc) {
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.m) {
                defaultDrmSession.c(exc);
            }
            DefaultDrmSessionManager.this.m.clear();
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ProvisioningManager
        public void provisionRequired(DefaultDrmSession defaultDrmSession) {
            if (!DefaultDrmSessionManager.this.m.contains(defaultDrmSession)) {
                DefaultDrmSessionManager.this.m.add(defaultDrmSession);
                if (DefaultDrmSessionManager.this.m.size() == 1) {
                    defaultDrmSession.g();
                }
            }
        }
    }

    public class e implements DefaultDrmSession.ReferenceCountListener {
        public e(a aVar) {
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void onReferenceCountDecremented(DefaultDrmSession defaultDrmSession, int i) {
            if (i == 1) {
                DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager.k != C.TIME_UNSET) {
                    defaultDrmSessionManager.n.add(defaultDrmSession);
                    ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.t)).postAtTime(new a2.j.b.b.t0.a(defaultDrmSession), defaultDrmSession, SystemClock.uptimeMillis() + DefaultDrmSessionManager.this.k);
                    return;
                }
            }
            if (i == 0) {
                DefaultDrmSessionManager.this.l.remove(defaultDrmSession);
                DefaultDrmSessionManager defaultDrmSessionManager2 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager2.q == defaultDrmSession) {
                    defaultDrmSessionManager2.q = null;
                }
                if (defaultDrmSessionManager2.r == defaultDrmSession) {
                    defaultDrmSessionManager2.r = null;
                }
                if (defaultDrmSessionManager2.m.size() > 1 && DefaultDrmSessionManager.this.m.get(0) == defaultDrmSession) {
                    DefaultDrmSessionManager.this.m.get(1).g();
                }
                DefaultDrmSessionManager.this.m.remove(defaultDrmSession);
                DefaultDrmSessionManager defaultDrmSessionManager3 = DefaultDrmSessionManager.this;
                if (defaultDrmSessionManager3.k != C.TIME_UNSET) {
                    ((Handler) Assertions.checkNotNull(defaultDrmSessionManager3.t)).removeCallbacksAndMessages(defaultDrmSession);
                    DefaultDrmSessionManager.this.n.remove(defaultDrmSession);
                }
            }
        }

        @Override // com.google.android.exoplayer2.drm.DefaultDrmSession.ReferenceCountListener
        public void onReferenceCountIncremented(DefaultDrmSession defaultDrmSession, int i) {
            DefaultDrmSessionManager defaultDrmSessionManager = DefaultDrmSessionManager.this;
            if (defaultDrmSessionManager.k != C.TIME_UNSET) {
                defaultDrmSessionManager.n.remove(defaultDrmSession);
                ((Handler) Assertions.checkNotNull(DefaultDrmSessionManager.this.t)).removeCallbacksAndMessages(defaultDrmSession);
            }
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, false, 3);
    }

    public static List<DrmInitData.SchemeData> c(DrmInitData drmInitData, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i2 = 0; i2 < drmInitData.schemeDataCount; i2++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i2);
            if ((schemeData.matches(uuid) || (C.CLEARKEY_UUID.equals(uuid) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z)) {
                arrayList.add(schemeData);
            }
        }
        return arrayList;
    }

    public final DefaultDrmSession a(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        Assertions.checkNotNull(this.p);
        DefaultDrmSession defaultDrmSession = new DefaultDrmSession(this.a, this.p, this.h, this.j, list, this.u, this.g | z, z, this.v, this.d, this.c, (Looper) Assertions.checkNotNull(this.s), this.i);
        defaultDrmSession.acquire(eventDispatcher);
        if (this.k != C.TIME_UNSET) {
            defaultDrmSession.acquire(null);
        }
        return defaultDrmSession;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @Nullable
    public DrmSession acquireSession(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
        List<DrmInitData.SchemeData> list;
        Looper looper2 = this.s;
        boolean z = false;
        if (looper2 == null) {
            this.s = looper;
            this.t = new Handler(looper);
        } else {
            Assertions.checkState(looper2 == looper);
        }
        if (this.w == null) {
            this.w = new c(looper);
        }
        DrmInitData drmInitData = format.drmInitData;
        DefaultDrmSession defaultDrmSession = null;
        if (drmInitData == null) {
            int trackType = MimeTypes.getTrackType(format.sampleMimeType);
            ExoMediaDrm exoMediaDrm = (ExoMediaDrm) Assertions.checkNotNull(this.p);
            if (FrameworkMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType()) && FrameworkMediaCrypto.WORKAROUND_DEVICE_NEEDS_KEYS_TO_CONFIGURE_CODEC) {
                z = true;
            }
            if (z || Util.linearSearch(this.f, trackType) == -1 || UnsupportedMediaCrypto.class.equals(exoMediaDrm.getExoMediaCryptoType())) {
                return null;
            }
            DefaultDrmSession defaultDrmSession2 = this.q;
            if (defaultDrmSession2 == null) {
                DefaultDrmSession b2 = b(ImmutableList.of(), true, null);
                this.l.add(b2);
                this.q = b2;
            } else {
                defaultDrmSession2.acquire(null);
            }
            return this.q;
        }
        if (this.v == null) {
            list = c((DrmInitData) Assertions.checkNotNull(drmInitData), this.a, false);
            if (((ArrayList) list).isEmpty()) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.a, null);
                if (eventDispatcher != null) {
                    eventDispatcher.drmSessionManagerError(missingSchemeDataException);
                }
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
        } else {
            list = null;
        }
        if (this.e) {
            Iterator<DefaultDrmSession> it = this.l.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (Util.areEqual(next.a, list)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else {
            defaultDrmSession = this.r;
        }
        if (defaultDrmSession == null) {
            defaultDrmSession = b(list, false, eventDispatcher);
            if (!this.e) {
                this.r = defaultDrmSession;
            }
            this.l.add(defaultDrmSession);
        } else {
            defaultDrmSession.acquire(eventDispatcher);
        }
        return defaultDrmSession;
    }

    public final DefaultDrmSession b(@Nullable List<DrmInitData.SchemeData> list, boolean z, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher) {
        DefaultDrmSession a3 = a(list, z, eventDispatcher);
        if (a3.n != 1) {
            return a3;
        }
        if ((Util.SDK_INT >= 19 && !(((DrmSession.DrmSessionException) Assertions.checkNotNull(a3.getError())).getCause() instanceof ResourceBusyException)) || this.n.isEmpty()) {
            return a3;
        }
        UnmodifiableIterator it = ImmutableList.copyOf((Collection) this.n).mo99iterator();
        while (it.hasNext()) {
            ((DrmSession) it.next()).release(null);
        }
        a3.release(eventDispatcher);
        if (this.k != C.TIME_UNSET) {
            a3.release(null);
        }
        return a(list, z, eventDispatcher);
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    @Nullable
    public Class<? extends ExoMediaCrypto> getExoMediaCryptoType(Format format) {
        Class<? extends ExoMediaCrypto> exoMediaCryptoType = ((ExoMediaDrm) Assertions.checkNotNull(this.p)).getExoMediaCryptoType();
        DrmInitData drmInitData = format.drmInitData;
        if (drmInitData == null) {
            if (Util.linearSearch(this.f, MimeTypes.getTrackType(format.sampleMimeType)) != -1) {
                return exoMediaCryptoType;
            }
            return null;
        }
        boolean z = true;
        if (this.v == null) {
            if (((ArrayList) c(drmInitData, this.a, true)).isEmpty()) {
                if (drmInitData.schemeDataCount == 1 && drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                    StringBuilder L = a2.b.a.a.a.L("DrmInitData only contains common PSSH SchemeData. Assuming support for: ");
                    L.append(this.a);
                    Log.w("DefaultDrmSessionMgr", L.toString());
                }
                z = false;
            }
            String str = drmInitData.schemeType;
            if (str != null) {
                if (!C.CENC_TYPE_cenc.equals(str)) {
                    if (!C.CENC_TYPE_cbcs.equals(str)) {
                        z = false;
                    }
                }
            }
        }
        return z ? exoMediaCryptoType : UnsupportedMediaCrypto.class;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void prepare() {
        int i2 = this.o;
        this.o = i2 + 1;
        if (i2 == 0) {
            Assertions.checkState(this.p == null);
            ExoMediaDrm acquireExoMediaDrm = this.b.acquireExoMediaDrm(this.a);
            this.p = acquireExoMediaDrm;
            acquireExoMediaDrm.setOnEventListener(new b(null));
        }
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager
    public final void release() {
        int i2 = this.o - 1;
        this.o = i2;
        if (i2 == 0) {
            ArrayList arrayList = new ArrayList(this.l);
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                ((DefaultDrmSession) arrayList.get(i3)).release(null);
            }
            ((ExoMediaDrm) Assertions.checkNotNull(this.p)).release();
            this.p = null;
        }
    }

    public void setMode(int i2, @Nullable byte[] bArr) {
        Assertions.checkState(this.l.isEmpty());
        if (i2 == 1 || i2 == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.u = i2;
        this.v = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z) {
        this(uuid, exoMediaDrm, mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, 3);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm exoMediaDrm, MediaDrmCallback mediaDrmCallback, @Nullable HashMap<String, String> hashMap, boolean z, int i2) {
        this(uuid, new ExoMediaDrm.AppManagedProvider(exoMediaDrm), mediaDrmCallback, hashMap == null ? new HashMap<>() : hashMap, z, new int[0], false, new DefaultLoadErrorHandlingPolicy(i2), 300000);
    }

    public DefaultDrmSessionManager(UUID uuid, ExoMediaDrm.Provider provider, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z, int[] iArr, boolean z2, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long j2) {
        Assertions.checkNotNull(uuid);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.a = uuid;
        this.b = provider;
        this.c = mediaDrmCallback;
        this.d = hashMap;
        this.e = z;
        this.f = iArr;
        this.g = z2;
        this.i = loadErrorHandlingPolicy;
        this.h = new d(null);
        this.j = new e(null);
        this.u = 0;
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.n = Sets.newIdentityHashSet();
        this.k = j2;
    }
}
