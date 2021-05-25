package a2.j.b.b.t0;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DrmSession;
/* compiled from: DrmSession */
public final /* synthetic */ class l {
    public static boolean $default$playClearSamplesWithoutKeys(DrmSession drmSession) {
        return false;
    }

    public static void a(@Nullable DrmSession drmSession, @Nullable DrmSession drmSession2) {
        if (drmSession != drmSession2) {
            if (drmSession2 != null) {
                drmSession2.acquire(null);
            }
            if (drmSession != null) {
                drmSession.release(null);
            }
        }
    }
}
