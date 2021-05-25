package com.google.android.exoplayer2.drm;

import a2.j.b.b.t0.n;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
public interface DrmSessionManager {
    public static final DrmSessionManager DUMMY = new a();

    public class a implements DrmSessionManager {
        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        @Nullable
        public DrmSession acquireSession(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format) {
            if (format.drmInitData == null) {
                return null;
            }
            return new ErrorStateDrmSession(new DrmSession.DrmSessionException(new UnsupportedDrmException(1)));
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        @Nullable
        public Class<UnsupportedMediaCrypto> getExoMediaCryptoType(Format format) {
            if (format.drmInitData != null) {
                return UnsupportedMediaCrypto.class;
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void prepare() {
            n.$default$prepare(this);
        }

        @Override // com.google.android.exoplayer2.drm.DrmSessionManager
        public /* synthetic */ void release() {
            n.$default$release(this);
        }
    }

    @Nullable
    DrmSession acquireSession(Looper looper, @Nullable DrmSessionEventListener.EventDispatcher eventDispatcher, Format format);

    @Nullable
    Class<? extends ExoMediaCrypto> getExoMediaCryptoType(Format format);

    void prepare();

    void release();
}
