package a2.j.b.b.r0;

import android.media.AudioTimestamp;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.util.Util;
public final class m {
    @Nullable
    public final a a;
    public int b;
    public long c;
    public long d;
    public long e;
    public long f;

    @RequiresApi(19)
    public static final class a {
        public final AudioTrack a;
        public final AudioTimestamp b = new AudioTimestamp();
        public long c;
        public long d;
        public long e;

        public a(AudioTrack audioTrack) {
            this.a = audioTrack;
        }
    }

    public m(AudioTrack audioTrack) {
        if (Util.SDK_INT >= 19) {
            this.a = new a(audioTrack);
            a();
            return;
        }
        this.a = null;
        b(3);
    }

    public void a() {
        if (this.a != null) {
            b(0);
        }
    }

    public final void b(int i) {
        this.b = i;
        if (i == 0) {
            this.e = 0;
            this.f = -1;
            this.c = System.nanoTime() / 1000;
            this.d = 10000;
        } else if (i == 1) {
            this.d = 10000;
        } else if (i == 2 || i == 3) {
            this.d = 10000000;
        } else if (i == 4) {
            this.d = 500000;
        } else {
            throw new IllegalStateException();
        }
    }
}
