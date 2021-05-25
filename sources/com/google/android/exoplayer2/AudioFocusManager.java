package com.google.android.exoplayer2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
public final class AudioFocusManager {
    public final AudioManager a;
    public final a b;
    @Nullable
    public PlayerControl c;
    @Nullable
    public AudioAttributes d;
    public int e;
    public int f;
    public float g = 1.0f;
    public AudioFocusRequest h;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlayerCommand {
    }

    public interface PlayerControl {
        void executePlayerCommand(int i);

        void setVolumeMultiplier(float f);
    }

    public class a implements AudioManager.OnAudioFocusChangeListener {
        public final Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i) {
            this.a.post(new a2.j.b.b.a(this, i));
        }
    }

    public AudioFocusManager(Context context, Handler handler, PlayerControl playerControl) {
        this.a = (AudioManager) Assertions.checkNotNull((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.c = playerControl;
        this.b = new a(handler);
        this.e = 0;
    }

    public final void a() {
        if (this.e != 0) {
            if (Util.SDK_INT >= 26) {
                AudioFocusRequest audioFocusRequest = this.h;
                if (audioFocusRequest != null) {
                    this.a.abandonAudioFocusRequest(audioFocusRequest);
                }
            } else {
                this.a.abandonAudioFocus(this.b);
            }
            d(0);
        }
    }

    public final void b(int i) {
        PlayerControl playerControl = this.c;
        if (playerControl != null) {
            playerControl.executePlayerCommand(i);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        if (r6.contentType == 1) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void c(@androidx.annotation.Nullable com.google.android.exoplayer2.audio.AudioAttributes r6) {
        /*
            r5 = this;
            com.google.android.exoplayer2.audio.AudioAttributes r0 = r5.d
            boolean r0 = com.google.android.exoplayer2.util.Util.areEqual(r0, r6)
            if (r0 != 0) goto L_0x004c
            r5.d = r6
            r0 = 0
            r1 = 1
            if (r6 != 0) goto L_0x000f
            goto L_0x003f
        L_0x000f:
            int r2 = r6.usage
            r3 = 3
            java.lang.String r4 = "AudioFocusManager"
            switch(r2) {
                case 0: goto L_0x0038;
                case 1: goto L_0x003d;
                case 2: goto L_0x0036;
                case 3: goto L_0x003f;
                case 4: goto L_0x0036;
                case 5: goto L_0x0040;
                case 6: goto L_0x0040;
                case 7: goto L_0x0040;
                case 8: goto L_0x0040;
                case 9: goto L_0x0040;
                case 10: goto L_0x0040;
                case 11: goto L_0x0032;
                case 12: goto L_0x0040;
                case 13: goto L_0x0040;
                case 14: goto L_0x003d;
                case 15: goto L_0x0017;
                case 16: goto L_0x002a;
                default: goto L_0x0017;
            }
        L_0x0017:
            java.lang.String r2 = "Unidentified audio usage: "
            java.lang.StringBuilder r2 = a2.b.a.a.a.L(r2)
            int r6 = r6.usage
            r2.append(r6)
            java.lang.String r6 = r2.toString()
            com.google.android.exoplayer2.util.Log.w(r4, r6)
            goto L_0x003f
        L_0x002a:
            int r6 = com.google.android.exoplayer2.util.Util.SDK_INT
            r2 = 19
            if (r6 < r2) goto L_0x0036
            r3 = 4
            goto L_0x0040
        L_0x0032:
            int r6 = r6.contentType
            if (r6 != r1) goto L_0x0040
        L_0x0036:
            r3 = 2
            goto L_0x0040
        L_0x0038:
            java.lang.String r6 = "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default."
            com.google.android.exoplayer2.util.Log.w(r4, r6)
        L_0x003d:
            r3 = 1
            goto L_0x0040
        L_0x003f:
            r3 = 0
        L_0x0040:
            r5.f = r3
            if (r3 == r1) goto L_0x0046
            if (r3 != 0) goto L_0x0047
        L_0x0046:
            r0 = 1
        L_0x0047:
            java.lang.String r6 = "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME."
            com.google.android.exoplayer2.util.Assertions.checkArgument(r0, r6)
        L_0x004c:
            return
            switch-data {0->0x0038, 1->0x003d, 2->0x0036, 3->0x003f, 4->0x0036, 5->0x0040, 6->0x0040, 7->0x0040, 8->0x0040, 9->0x0040, 10->0x0040, 11->0x0032, 12->0x0040, 13->0x0040, 14->0x003d, 15->0x0017, 16->0x002a, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.AudioFocusManager.c(com.google.android.exoplayer2.audio.AudioAttributes):void");
    }

    public final void d(int i) {
        if (this.e != i) {
            this.e = i;
            float f2 = i == 3 ? 0.2f : 1.0f;
            if (this.g != f2) {
                this.g = f2;
                PlayerControl playerControl = this.c;
                if (playerControl != null) {
                    playerControl.setVolumeMultiplier(f2);
                }
            }
        }
    }

    public int e(boolean z, int i) {
        int i2;
        AudioFocusRequest.Builder builder;
        int i3 = 1;
        if (i == 1 || this.f != 1) {
            a();
            if (z) {
                return 1;
            }
            return -1;
        } else if (!z) {
            return -1;
        } else {
            if (this.e != 1) {
                if (Util.SDK_INT >= 26) {
                    AudioFocusRequest audioFocusRequest = this.h;
                    if (audioFocusRequest == null) {
                        if (audioFocusRequest == null) {
                            builder = new AudioFocusRequest.Builder(this.f);
                        } else {
                            builder = new AudioFocusRequest.Builder(this.h);
                        }
                        AudioAttributes audioAttributes = this.d;
                        this.h = builder.setAudioAttributes(((AudioAttributes) Assertions.checkNotNull(audioAttributes)).getAudioAttributesV21()).setWillPauseWhenDucked(audioAttributes != null && audioAttributes.contentType == 1).setOnAudioFocusChangeListener(this.b).build();
                    }
                    i2 = this.a.requestAudioFocus(this.h);
                } else {
                    i2 = this.a.requestAudioFocus(this.b, Util.getStreamTypeForAudioUsage(((AudioAttributes) Assertions.checkNotNull(this.d)).usage), this.f);
                }
                if (i2 == 1) {
                    d(1);
                } else {
                    d(0);
                    i3 = -1;
                }
            }
            return i3;
        }
    }
}
