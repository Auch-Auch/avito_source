package pl.droidsonroids.gif;

import androidx.annotation.IntRange;
public class GifOptions {
    public char a = 1;
    public boolean b = false;

    public void setInIsOpaque(boolean z) {
        this.b = z;
    }

    public void setInSampleSize(@IntRange(from = 1, to = 65535) int i) {
        if (i < 1 || i > 65535) {
            this.a = 1;
        } else {
            this.a = (char) i;
        }
    }
}
