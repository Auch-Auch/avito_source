package com.google.android.gms.ads;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzyg;
import com.google.android.gms.internal.ads.zzzz;
import javax.annotation.concurrent.GuardedBy;
public final class VideoController {
    @KeepForSdk
    public static final int PLAYBACK_STATE_ENDED = 3;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PAUSED = 2;
    @KeepForSdk
    public static final int PLAYBACK_STATE_PLAYING = 1;
    @KeepForSdk
    public static final int PLAYBACK_STATE_READY = 5;
    @KeepForSdk
    public static final int PLAYBACK_STATE_UNKNOWN = 0;
    private final Object lock = new Object();
    @Nullable
    @GuardedBy("lock")
    private zzyg zzado;
    @Nullable
    @GuardedBy("lock")
    private VideoLifecycleCallbacks zzadp;

    public static abstract class VideoLifecycleCallbacks {
        public void onVideoEnd() {
        }

        public void onVideoMute(boolean z) {
        }

        public void onVideoPause() {
        }

        public void onVideoPlay() {
        }

        public void onVideoStart() {
        }
    }

    @Deprecated
    public final float getAspectRatio() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return 0.0f;
            }
            try {
                return zzyg.getAspectRatio();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call getAspectRatio on video controller.", e);
                return 0.0f;
            }
        }
    }

    @KeepForSdk
    public final int getPlaybackState() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return 0;
            }
            try {
                return zzyg.getPlaybackState();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call getPlaybackState on video controller.", e);
                return 0;
            }
        }
    }

    public final float getVideoCurrentTime() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return 0.0f;
            }
            try {
                return zzyg.getCurrentTime();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call getCurrentTime on video controller.", e);
                return 0.0f;
            }
        }
    }

    public final float getVideoDuration() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return 0.0f;
            }
            try {
                return zzyg.getDuration();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call getDuration on video controller.", e);
                return 0.0f;
            }
        }
    }

    @Nullable
    public final VideoLifecycleCallbacks getVideoLifecycleCallbacks() {
        VideoLifecycleCallbacks videoLifecycleCallbacks;
        synchronized (this.lock) {
            videoLifecycleCallbacks = this.zzadp;
        }
        return videoLifecycleCallbacks;
    }

    public final boolean hasVideoContent() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzado != null;
        }
        return z;
    }

    public final boolean isClickToExpandEnabled() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return false;
            }
            try {
                return zzyg.isClickToExpandEnabled();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call isClickToExpandEnabled.", e);
                return false;
            }
        }
    }

    public final boolean isCustomControlsEnabled() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return false;
            }
            try {
                return zzyg.isCustomControlsEnabled();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call isUsingCustomPlayerControls.", e);
                return false;
            }
        }
    }

    public final boolean isMuted() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg == null) {
                return true;
            }
            try {
                return zzyg.isMuted();
            } catch (RemoteException e) {
                zzbbd.zzc("Unable to call isMuted on video controller.", e);
                return true;
            }
        }
    }

    public final void mute(boolean z) {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg != null) {
                try {
                    zzyg.mute(z);
                } catch (RemoteException e) {
                    zzbbd.zzc("Unable to call mute on video controller.", e);
                }
            }
        }
    }

    public final void pause() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg != null) {
                try {
                    zzyg.pause();
                } catch (RemoteException e) {
                    zzbbd.zzc("Unable to call pause on video controller.", e);
                }
            }
        }
    }

    public final void play() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg != null) {
                try {
                    zzyg.play();
                } catch (RemoteException e) {
                    zzbbd.zzc("Unable to call play on video controller.", e);
                }
            }
        }
    }

    public final void setVideoLifecycleCallbacks(VideoLifecycleCallbacks videoLifecycleCallbacks) {
        Preconditions.checkNotNull(videoLifecycleCallbacks, "VideoLifecycleCallbacks may not be null.");
        synchronized (this.lock) {
            this.zzadp = videoLifecycleCallbacks;
            zzyg zzyg = this.zzado;
            if (zzyg != null) {
                try {
                    zzyg.zza(new zzzz(videoLifecycleCallbacks));
                } catch (RemoteException e) {
                    zzbbd.zzc("Unable to call setVideoLifecycleCallbacks on video controller.", e);
                }
            }
        }
    }

    public final void stop() {
        synchronized (this.lock) {
            zzyg zzyg = this.zzado;
            if (zzyg != null) {
                try {
                    zzyg.stop();
                } catch (RemoteException e) {
                    zzbbd.zzc("Unable to call stop on video controller.", e);
                }
            }
        }
    }

    public final void zza(zzyg zzyg) {
        synchronized (this.lock) {
            this.zzado = zzyg;
            VideoLifecycleCallbacks videoLifecycleCallbacks = this.zzadp;
            if (videoLifecycleCallbacks != null) {
                setVideoLifecycleCallbacks(videoLifecycleCallbacks);
            }
        }
    }

    public final zzyg zzdt() {
        zzyg zzyg;
        synchronized (this.lock) {
            zzyg = this.zzado;
        }
        return zzyg;
    }
}
