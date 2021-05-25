package org.webrtc.audio;

import a2.b.a.a.a;
import android.media.AudioManager;
import androidx.annotation.Nullable;
import com.yandex.mobile.ads.video.tracking.Tracker;
import java.util.Timer;
import java.util.TimerTask;
import org.webrtc.Logging;
public class VolumeLogger {
    private static final String TAG = "VolumeLogger";
    private static final String THREAD_NAME = "WebRtcVolumeLevelLoggerThread";
    private static final int TIMER_PERIOD_IN_SECONDS = 30;
    private final AudioManager audioManager;
    @Nullable
    private Timer timer;

    public class LogVolumeTask extends TimerTask {
        private final int maxRingVolume;
        private final int maxVoiceCallVolume;

        public LogVolumeTask(int i, int i2) {
            this.maxRingVolume = i;
            this.maxVoiceCallVolume = i2;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            int mode = VolumeLogger.this.audioManager.getMode();
            if (mode == 1) {
                StringBuilder L = a.L("STREAM_RING stream volume: ");
                L.append(VolumeLogger.this.audioManager.getStreamVolume(2));
                L.append(" (max=");
                L.append(this.maxRingVolume);
                L.append(")");
                Logging.d(VolumeLogger.TAG, L.toString());
            } else if (mode == 3) {
                StringBuilder L2 = a.L("VOICE_CALL stream volume: ");
                L2.append(VolumeLogger.this.audioManager.getStreamVolume(0));
                L2.append(" (max=");
                L2.append(this.maxVoiceCallVolume);
                L2.append(")");
                Logging.d(VolumeLogger.TAG, L2.toString());
            }
        }
    }

    public VolumeLogger(AudioManager audioManager2) {
        this.audioManager = audioManager2;
    }

    public void start() {
        StringBuilder L = a.L(Tracker.Events.CREATIVE_START);
        L.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, L.toString());
        if (this.timer == null) {
            StringBuilder L2 = a.L("audio mode is: ");
            L2.append(WebRtcAudioUtils.modeToString(this.audioManager.getMode()));
            Logging.d(TAG, L2.toString());
            Timer timer2 = new Timer(THREAD_NAME);
            this.timer = timer2;
            timer2.schedule(new LogVolumeTask(this.audioManager.getStreamMaxVolume(2), this.audioManager.getStreamMaxVolume(0)), 0, 30000);
        }
    }

    public void stop() {
        StringBuilder L = a.L("stop");
        L.append(WebRtcAudioUtils.getThreadInfo());
        Logging.d(TAG, L.toString());
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }
}
