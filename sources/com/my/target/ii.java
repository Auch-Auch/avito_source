package com.my.target;

import a2.b.a.a.a;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import java.util.Iterator;
import java.util.Set;
public class ii {
    public boolean a;
    @Nullable
    public Set<cx> b;
    @Nullable
    public cz c;
    @Nullable
    public Context d;
    @Nullable
    public String e;
    public float f;
    public boolean g = true;

    public ii(@Nullable cf cfVar, @Nullable Context context) {
        if (context != null) {
            this.d = context.getApplicationContext();
        }
        if (cfVar != null) {
            this.c = cfVar.getStatHolder();
            this.b = cfVar.getStatHolder().cA();
            this.e = cfVar.getId();
            this.f = cfVar.getDuration();
            this.g = cfVar.isLogErrors();
        }
    }

    public static ii b(@Nullable cf cfVar, @Nullable Context context) {
        return new ii(cfVar, context);
    }

    public static ii eO() {
        return new ii(null, null);
    }

    public static ii h(@Nullable cf cfVar) {
        return new ii(cfVar, null);
    }

    public void P(boolean z) {
        if (!a()) {
            im.a(this.c.K(z ? "volumeOn" : "volumeOff"), this.d);
        }
    }

    public final boolean a() {
        return this.d == null || this.c == null || this.b == null;
    }

    public void d(float f2, float f3) {
        if (!a()) {
            if (!this.a) {
                im.a(this.c.K("playbackStarted"), this.d);
                this.a = true;
            }
            if (!this.b.isEmpty()) {
                Iterator<cx> it = this.b.iterator();
                while (it.hasNext()) {
                    cx next = it.next();
                    if (next.cu() <= f2) {
                        im.a(next, this.d);
                        it.remove();
                    }
                }
            }
            if (this.f > 0.0f && f3 > 0.0f && !TextUtils.isEmpty(this.e) && this.g && Math.abs(f3 - this.f) > 1.5f) {
                dh M = dh.M("Bad value");
                StringBuilder L = a.L("Media duration error: expected ");
                L.append(this.f);
                L.append(", but was ");
                L.append(f3);
                M.N(L.toString()).P(this.e).v(this.d);
                this.g = false;
            }
        }
    }

    public void eP() {
        if (!a()) {
            im.a(this.c.K("playbackPaused"), this.d);
        }
    }

    public void eQ() {
        if (!a()) {
            im.a(this.c.K("playbackStopped"), this.d);
        }
    }

    public void eR() {
        if (!a()) {
            im.a(this.c.K("closedByUser"), this.d);
        }
    }

    public void eS() {
        if (!a()) {
            im.a(this.c.K("playbackError"), this.d);
        }
    }

    public void eT() {
        if (!a()) {
            im.a(this.c.K("playbackTimeout"), this.d);
        }
    }

    public void i(@Nullable cf cfVar) {
        if (cfVar != null) {
            if (cfVar.getStatHolder() != this.c) {
                this.a = false;
            }
            this.c = cfVar.getStatHolder();
            this.b = cfVar.getStatHolder().cA();
            this.g = cfVar.isLogErrors();
        } else {
            this.c = null;
            this.b = null;
        }
        this.e = null;
        this.f = 0.0f;
    }

    public void refresh() {
        if (!a()) {
            this.b = this.c.cA();
            this.a = false;
        }
    }

    public void setContext(@Nullable Context context) {
        this.d = context;
    }

    public void trackFullscreen(boolean z) {
        if (!a()) {
            im.a(this.c.K(z ? "fullscreenOn" : "fullscreenOff"), this.d);
        }
    }

    public void trackResume() {
        if (!a()) {
            im.a(this.c.K("playbackResumed"), this.d);
        }
    }
}
