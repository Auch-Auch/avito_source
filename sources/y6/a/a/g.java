package y6.a.a;

import android.os.SystemClock;
import java.util.concurrent.TimeUnit;
import pl.droidsonroids.gif.GifDrawable;
public class g extends h {
    public g(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    @Override // y6.a.a.h
    public void a() {
        GifDrawable gifDrawable = this.a;
        long A = gifDrawable.f.A(gifDrawable.e);
        if (A >= 0) {
            this.a.c = SystemClock.uptimeMillis() + A;
            if (this.a.isVisible() && this.a.b) {
                GifDrawable gifDrawable2 = this.a;
                if (!gifDrawable2.k) {
                    gifDrawable2.a.remove(this);
                    GifDrawable gifDrawable3 = this.a;
                    gifDrawable3.o = gifDrawable3.a.schedule(this, A, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.a.g.isEmpty() && this.a.getCurrentFrameIndex() == this.a.f.m() - 1) {
                GifDrawable gifDrawable4 = this.a;
                gifDrawable4.l.sendEmptyMessageAtTime(gifDrawable4.getCurrentLoop(), this.a.c);
            }
        } else {
            GifDrawable gifDrawable5 = this.a;
            gifDrawable5.c = Long.MIN_VALUE;
            gifDrawable5.b = false;
        }
        if (this.a.isVisible() && !this.a.l.hasMessages(-1)) {
            this.a.l.sendEmptyMessageAtTime(-1, 0);
        }
    }
}
