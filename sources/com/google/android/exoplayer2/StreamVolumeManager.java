package com.google.android.exoplayer2;

import a2.j.b.b.a0;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
public final class StreamVolumeManager {
    public final Context a;
    public final Handler b;
    public final Listener c;
    public final AudioManager d;
    @Nullable
    public b e;
    public int f = 3;
    public int g;
    public boolean h;

    public interface Listener {
        void onStreamTypeChanged(int i);

        void onStreamVolumeChanged(int i, boolean z);
    }

    public final class b extends BroadcastReceiver {
        public b(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            StreamVolumeManager streamVolumeManager = StreamVolumeManager.this;
            streamVolumeManager.b.post(new a0(streamVolumeManager));
        }
    }

    public StreamVolumeManager(Context context, Handler handler, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = handler;
        this.c = listener;
        AudioManager audioManager = (AudioManager) Assertions.checkStateNotNull((AudioManager) applicationContext.getSystemService("audio"));
        this.d = audioManager;
        this.g = d(audioManager, 3);
        this.h = c(audioManager, this.f);
        b bVar = new b(null);
        try {
            applicationContext.registerReceiver(bVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.e = bVar;
        } catch (RuntimeException e2) {
            Log.w("StreamVolumeManager", "Error registering stream volume receiver", e2);
        }
    }

    public static boolean c(AudioManager audioManager, int i) {
        if (Util.SDK_INT >= 23) {
            return audioManager.isStreamMute(i);
        }
        return d(audioManager, i) == 0;
    }

    public static int d(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e2) {
            Log.w("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i, e2);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    public int a() {
        return this.d.getStreamMaxVolume(this.f);
    }

    public int b() {
        if (Util.SDK_INT >= 28) {
            return this.d.getStreamMinVolume(this.f);
        }
        return 0;
    }

    public final void e() {
        int d2 = d(this.d, this.f);
        boolean c2 = c(this.d, this.f);
        if (this.g != d2 || this.h != c2) {
            this.g = d2;
            this.h = c2;
            this.c.onStreamVolumeChanged(d2, c2);
        }
    }
}
