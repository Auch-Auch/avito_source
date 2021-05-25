package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
public final class AudioBecomingNoisyManager {
    public final Context a;
    public final a b;
    public boolean c;

    public interface EventListener {
        void onAudioBecomingNoisy();
    }

    public final class a extends BroadcastReceiver implements Runnable {
        public final EventListener a;
        public final Handler b;

        public a(Handler handler, EventListener eventListener) {
            this.b = handler;
            this.a = eventListener;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (AudioBecomingNoisyManager.this.c) {
                this.a.onAudioBecomingNoisy();
            }
        }
    }

    public AudioBecomingNoisyManager(Context context, Handler handler, EventListener eventListener) {
        this.a = context.getApplicationContext();
        this.b = new a(handler, eventListener);
    }

    public void a(boolean z) {
        if (z && !this.c) {
            this.a.registerReceiver(this.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.c = true;
        } else if (!z && this.c) {
            this.a.unregisterReceiver(this.b);
            this.c = false;
        }
    }
}
