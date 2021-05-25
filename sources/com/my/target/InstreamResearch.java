package com.my.target;

import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.avito.android.remote.model.user_profile.SubscriptionStatus;
import com.my.target.common.BaseAd;
import com.my.target.l;
import java.util.ArrayList;
import java.util.Objects;
public class InstreamResearch extends BaseAd {
    public final int b;
    @NonNull
    public final Context c;
    public int d = 0;
    public int e = -1;
    @Nullable
    public InstreamResearchListener f;
    @Nullable
    public z g;
    @Nullable
    public aa h;
    @Nullable
    public br i;

    public interface InstreamResearchListener {
        void onLoad(@NonNull InstreamResearch instreamResearch);

        void onNoData(@NonNull InstreamResearch instreamResearch, @Nullable String str);
    }

    public class a implements l.b {
        public a() {
        }

        @Override // com.my.target.b.AbstractC0305b
        public void onResult(@Nullable cn cnVar, @Nullable String str) {
            bs bsVar = (bs) cnVar;
            InstreamResearch instreamResearch = InstreamResearch.this;
            Objects.requireNonNull(instreamResearch);
            if (bsVar != null) {
                br br = bsVar.br();
                instreamResearch.i = br;
                if (br != null) {
                    instreamResearch.g = z.a(br.getStatHolder());
                    instreamResearch.h = aa.b(instreamResearch.i.getStatHolder());
                    InstreamResearchListener instreamResearchListener = instreamResearch.f;
                    if (instreamResearchListener != null) {
                        instreamResearchListener.onLoad(instreamResearch);
                        return;
                    }
                    return;
                }
            }
            InstreamResearchListener instreamResearchListener2 = instreamResearch.f;
            if (instreamResearchListener2 != null) {
                instreamResearchListener2.onNoData(instreamResearch, str);
            }
        }
    }

    public InstreamResearch(int i2, int i3, @NonNull Context context) {
        super(i2, "instreamresearch");
        this.b = i3;
        this.c = context;
        ae.c("InstreamResearch created. Version: 5.12.2");
    }

    @NonNull
    public static InstreamResearch newResearch(int i2, int i3, @NonNull Context context) {
        return new InstreamResearch(i2, i3, context);
    }

    public final String a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknown" : "completed" : SubscriptionStatus.PAUSED : "started" : "idle";
    }

    public final void b(@NonNull String str) {
        br brVar = this.i;
        if (brVar != null) {
            ArrayList<cy> K = brVar.getStatHolder().K(str);
            if (!K.isEmpty()) {
                im.a(K, this.c);
            }
        }
    }

    public void load() {
        l.a(this.adConfig, this.b).a(new a()).a(this.c);
    }

    public void registerPlayerView(@NonNull View view) {
        aa aaVar = this.h;
        if (aaVar != null) {
            aaVar.setView(view);
        }
    }

    public void setListener(@Nullable InstreamResearchListener instreamResearchListener) {
        this.f = instreamResearchListener;
    }

    public void trackFullscreen(boolean z) {
        b(z ? "fullscreenOn" : "fullscreenOff");
    }

    public void trackMute(boolean z) {
        b(z ? "volumeOff" : "volumeOn");
    }

    public void trackPause() {
        if (this.d != 1) {
            StringBuilder L = a2.b.a.a.a.L("Unable to track pause, wrong state ");
            L.append(a(this.d));
            ae.b(L.toString());
            return;
        }
        b("playbackPaused");
        this.d = 2;
    }

    public void trackProgress(float f2) {
        if (this.d < 1) {
            b("playbackStarted");
            this.d = 1;
        }
        if (this.d > 1) {
            StringBuilder L = a2.b.a.a.a.L("Unable to track progress while state is: ");
            L.append(a(this.d));
            ae.a(L.toString());
            return;
        }
        int round = Math.round(f2);
        int i2 = this.e;
        if (round < i2) {
            b("rewind");
        } else if (round == i2) {
            return;
        }
        this.e = round;
        aa aaVar = this.h;
        if (aaVar != null) {
            aaVar.c(round);
        }
        z zVar = this.g;
        if (zVar != null) {
            zVar.a(round, this.b, this.c);
        }
    }

    public void trackResume() {
        if (this.d != 2) {
            StringBuilder L = a2.b.a.a.a.L("VideoAdTracker error: unable to track resume, wrong state ");
            L.append(a(this.d));
            ae.b(L.toString());
            return;
        }
        b("playbackResumed");
        this.d = 1;
    }

    public void unregisterPlayerView() {
        aa aaVar = this.h;
        if (aaVar != null) {
            aaVar.setView(null);
        }
    }
}
