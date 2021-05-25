package com.my.target;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.my.target.common.models.AudioData;
import com.my.target.instreamads.InstreamAudioAdPlayer;
import java.util.Stack;
public class ai {
    @NonNull
    public final c a = new c(null);
    @NonNull
    public final ik b = ik.J(200);
    @NonNull
    public final d c = new d(null);
    @NonNull
    public final Stack<cx> d = new Stack<>();
    @NonNull
    public final ii e = ii.eO();
    public float f = 1.0f;
    @Nullable
    public InstreamAudioAdPlayer g;
    @Nullable
    public b h;
    @Nullable
    public cf<AudioData> i;
    public int j;
    public float k;
    public int l = 10;
    public boolean m;
    public int n = 0;

    public interface b {
        void a(float f, float f2, @NonNull cf cfVar);

        void a(@NonNull String str, @NonNull cf cfVar);

        void b(@NonNull cf cfVar);

        void c(@NonNull cf cfVar);

        void d(@NonNull cf cfVar);
    }

    public class c implements InstreamAudioAdPlayer.AdPlayerListener {
        public float a = 1.0f;

        public c(a aVar) {
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioCompleted() {
            ai aiVar = ai.this;
            if (aiVar.n != 2) {
                if (!(aiVar.i == null || aiVar.h == null)) {
                    ai.b(aiVar);
                    ai aiVar2 = ai.this;
                    cf<AudioData> cfVar = aiVar2.i;
                    aiVar2.i = null;
                    if (cfVar != null) {
                        float duration = cfVar.getDuration();
                        ai.this.e.d(duration, duration);
                        ai.this.h.d(cfVar);
                    }
                }
                ai.this.n = 2;
            }
            ai aiVar3 = ai.this;
            aiVar3.b.e(aiVar3.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioError(@NonNull String str) {
            b bVar;
            InstreamAudioAdPlayer instreamAudioAdPlayer = ai.this.g;
            if (instreamAudioAdPlayer != null) {
                instreamAudioAdPlayer.stopAdAudio();
            }
            ai aiVar = ai.this;
            cf<AudioData> cfVar = aiVar.i;
            if (!(cfVar == null || (bVar = aiVar.h) == null)) {
                bVar.a(str, cfVar);
            }
            ai.this.e.eS();
            ai aiVar2 = ai.this;
            aiVar2.b.e(aiVar2.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioPaused() {
            Context context = ai.this.getContext();
            ai aiVar = ai.this;
            if (!(aiVar.i == null || context == null)) {
                aiVar.e.eP();
            }
            ai aiVar2 = ai.this;
            aiVar2.b.e(aiVar2.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioResumed() {
            Context context = ai.this.getContext();
            ai aiVar = ai.this;
            if (!(aiVar.i == null || context == null)) {
                aiVar.e.trackResume();
            }
            ai aiVar2 = ai.this;
            aiVar2.b.d(aiVar2.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioStarted() {
            InstreamAudioAdPlayer instreamAudioAdPlayer;
            cf<AudioData> cfVar;
            b bVar;
            ai aiVar = ai.this;
            aiVar.n = 1;
            if (!aiVar.m && (instreamAudioAdPlayer = aiVar.g) != null) {
                float adAudioDuration = instreamAudioAdPlayer.getAdAudioDuration();
                cf<AudioData> cfVar2 = aiVar.i;
                if (!(cfVar2 == null || (bVar = aiVar.h) == null)) {
                    bVar.b(cfVar2);
                }
                b bVar2 = aiVar.h;
                if (!(bVar2 == null || (cfVar = aiVar.i) == null)) {
                    bVar2.a(0.0f, adAudioDuration, cfVar);
                }
                aiVar.e.d(0.0f, adAudioDuration);
                aiVar.m = true;
            }
            ai aiVar2 = ai.this;
            aiVar2.b.d(aiVar2.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onAdAudioStopped() {
            ai aiVar = ai.this;
            if (aiVar.n == 1) {
                if (!(aiVar.i == null || aiVar.h == null)) {
                    aiVar.e.eQ();
                    ai aiVar2 = ai.this;
                    aiVar2.h.c(aiVar2.i);
                }
                ai.this.n = 0;
            }
            ai aiVar3 = ai.this;
            aiVar3.b.e(aiVar3.c);
        }

        @Override // com.my.target.instreamads.InstreamAudioAdPlayer.AdPlayerListener
        public void onVolumeChanged(float f) {
            boolean z;
            ii iiVar;
            float f2 = this.a;
            if (f != f2) {
                int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
                if (i <= 0 || f > 0.0f) {
                    if (i == 0 && f > 0.0f && ai.this.getContext() != null) {
                        ai aiVar = ai.this;
                        if (aiVar.i != null) {
                            iiVar = aiVar.e;
                            z = true;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                } else if (ai.this.getContext() != null) {
                    ai aiVar2 = ai.this;
                    if (aiVar2.i != null) {
                        iiVar = aiVar2.e;
                        z = false;
                    } else {
                        return;
                    }
                } else {
                    return;
                }
                iiVar.P(z);
                this.a = f;
                ai.this.f = f;
            }
        }
    }

    public class d implements Runnable {
        public d(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            ai.b(ai.this);
        }
    }

    public static void b(ai aiVar) {
        float f2;
        float f3;
        float f4;
        cf<AudioData> cfVar;
        b bVar;
        cf<AudioData> cfVar2;
        cf<AudioData> cfVar3;
        InstreamAudioAdPlayer instreamAudioAdPlayer;
        cf<AudioData> cfVar4 = aiVar.i;
        float duration = cfVar4 != null ? cfVar4.getDuration() : 0.0f;
        if (aiVar.i == null) {
            aiVar.b.e(aiVar.c);
            return;
        }
        if (aiVar.n != 1 || (instreamAudioAdPlayer = aiVar.g) == null) {
            f4 = 0.0f;
            f3 = 0.0f;
            f2 = 0.0f;
        } else {
            f4 = instreamAudioAdPlayer.getAdAudioDuration();
            f3 = aiVar.g.getAdAudioPosition();
            f2 = duration - f3;
        }
        if (aiVar.n != 1 || aiVar.k == f3 || f4 <= 0.0f) {
            aiVar.j++;
        } else {
            aiVar.j = 0;
            aiVar.k = f3;
            if (f3 < duration) {
                aiVar.e.d(f3, duration);
                b bVar2 = aiVar.h;
                if (!(bVar2 == null || (cfVar3 = aiVar.i) == null)) {
                    bVar2.a(f2, duration, cfVar3);
                }
            } else {
                aiVar.e.d(duration, duration);
                b bVar3 = aiVar.h;
                if (!(bVar3 == null || (cfVar2 = aiVar.i) == null)) {
                    bVar3.a(0.0f, duration, cfVar2);
                }
                aiVar.b.e(aiVar.c);
                if (aiVar.n != 2) {
                    aiVar.n = 2;
                    InstreamAudioAdPlayer instreamAudioAdPlayer2 = aiVar.g;
                    if (instreamAudioAdPlayer2 != null) {
                        instreamAudioAdPlayer2.stopAdAudio();
                    }
                    cf<AudioData> cfVar5 = aiVar.i;
                    if (!(cfVar5 == null || (bVar = aiVar.h) == null)) {
                        aiVar.i = null;
                        bVar.d(cfVar5);
                    }
                }
            }
        }
        if (aiVar.j >= (aiVar.l * 1000) / 200) {
            StringBuilder L = a2.b.a.a.a.L("video freeze more then ");
            L.append(aiVar.l);
            L.append(" seconds, stopping");
            ae.a(L.toString());
            InstreamAudioAdPlayer instreamAudioAdPlayer3 = aiVar.g;
            if (instreamAudioAdPlayer3 != null) {
                instreamAudioAdPlayer3.stopAdAudio();
            }
            aiVar.b.e(aiVar.c);
            aiVar.e.eT();
            b bVar4 = aiVar.h;
            if (bVar4 != null && (cfVar = aiVar.i) != null) {
                bVar4.a("Timeout", cfVar);
            }
        }
    }

    @NonNull
    public static ai q() {
        return new ai();
    }

    public void a(@Nullable b bVar) {
        this.h = bVar;
    }

    public void a(@NonNull cf<AudioData> cfVar) {
        this.i = cfVar;
        this.e.i(cfVar);
        this.m = false;
        cfVar.getStatHolder().c(this.d);
        AudioData mediaData = cfVar.getMediaData();
        if (mediaData != null) {
            Uri parse = Uri.parse(mediaData.getUrl());
            InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
            if (instreamAudioAdPlayer != null) {
                instreamAudioAdPlayer.setVolume(this.f);
                this.g.playAdAudio(parse);
            }
        }
    }

    public void destroy() {
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.destroy();
        }
        this.g = null;
    }

    @Nullable
    public Context getContext() {
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer == null) {
            return null;
        }
        return instreamAudioAdPlayer.getCurrentContext();
    }

    @Nullable
    public InstreamAudioAdPlayer getPlayer() {
        return this.g;
    }

    public float getVolume() {
        return this.f;
    }

    public void pause() {
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.pauseAdAudio();
        }
    }

    public void resume() {
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.resumeAdAudio();
        }
    }

    public void setConnectionTimeout(int i2) {
        this.l = i2;
    }

    public void setPlayer(@Nullable InstreamAudioAdPlayer instreamAudioAdPlayer) {
        InstreamAudioAdPlayer instreamAudioAdPlayer2 = this.g;
        if (instreamAudioAdPlayer2 != null) {
            instreamAudioAdPlayer2.setAdPlayerListener(null);
        }
        this.g = instreamAudioAdPlayer;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.setAdPlayerListener(this.a);
            this.e.setContext(instreamAudioAdPlayer.getCurrentContext());
            return;
        }
        this.e.setContext(null);
    }

    public void setVolume(float f2) {
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.setVolume(f2);
        }
        this.f = f2;
    }

    public void stop() {
        if (this.n == 1) {
            if (!(this.i == null || this.h == null)) {
                this.e.eQ();
                this.h.c(this.i);
            }
            this.n = 0;
        }
        InstreamAudioAdPlayer instreamAudioAdPlayer = this.g;
        if (instreamAudioAdPlayer != null) {
            instreamAudioAdPlayer.stopAdAudio();
        }
    }
}
