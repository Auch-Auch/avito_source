package com.google.android.exoplayer2.audio;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.provider.Settings;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
public final class AudioCapabilitiesReceiver {
    public final Context a;
    public final Listener b;
    public final Handler c;
    @Nullable
    public final BroadcastReceiver d;
    @Nullable
    public final b e;
    @Nullable
    public AudioCapabilities f;
    public boolean g;

    public interface Listener {
        void onAudioCapabilitiesChanged(AudioCapabilities audioCapabilities);
    }

    public final class b extends ContentObserver {
        public final ContentResolver a;
        public final Uri b;

        public b(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.a = contentResolver;
            this.b = uri;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
            AudioCapabilities capabilities = AudioCapabilities.getCapabilities(audioCapabilitiesReceiver.a);
            if (audioCapabilitiesReceiver.g && !capabilities.equals(audioCapabilitiesReceiver.f)) {
                audioCapabilitiesReceiver.f = capabilities;
                audioCapabilitiesReceiver.b.onAudioCapabilitiesChanged(capabilities);
            }
        }
    }

    public final class c extends BroadcastReceiver {
        public c(a aVar) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (!isInitialStickyBroadcast()) {
                AudioCapabilitiesReceiver audioCapabilitiesReceiver = AudioCapabilitiesReceiver.this;
                AudioCapabilities b = AudioCapabilities.b(context, intent);
                if (audioCapabilitiesReceiver.g && !b.equals(audioCapabilitiesReceiver.f)) {
                    audioCapabilitiesReceiver.f = b;
                    audioCapabilitiesReceiver.b.onAudioCapabilitiesChanged(b);
                }
            }
        }
    }

    public AudioCapabilitiesReceiver(Context context, Listener listener) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = (Listener) Assertions.checkNotNull(listener);
        Handler createHandlerForCurrentOrMainLooper = Util.createHandlerForCurrentOrMainLooper();
        this.c = createHandlerForCurrentOrMainLooper;
        b bVar = null;
        this.d = Util.SDK_INT >= 21 ? new c(null) : null;
        Uri uriFor = AudioCapabilities.a() ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.e = uriFor != null ? new b(createHandlerForCurrentOrMainLooper, applicationContext.getContentResolver(), uriFor) : bVar;
    }

    public AudioCapabilities register() {
        if (this.g) {
            return (AudioCapabilities) Assertions.checkNotNull(this.f);
        }
        this.g = true;
        b bVar = this.e;
        if (bVar != null) {
            bVar.a.registerContentObserver(bVar.b, false, bVar);
        }
        Intent intent = null;
        if (this.d != null) {
            intent = this.a.registerReceiver(this.d, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.c);
        }
        AudioCapabilities b2 = AudioCapabilities.b(this.a, intent);
        this.f = b2;
        return b2;
    }

    public void unregister() {
        if (this.g) {
            this.f = null;
            BroadcastReceiver broadcastReceiver = this.d;
            if (broadcastReceiver != null) {
                this.a.unregisterReceiver(broadcastReceiver);
            }
            b bVar = this.e;
            if (bVar != null) {
                bVar.a.unregisterContentObserver(bVar);
            }
            this.g = false;
        }
    }
}
