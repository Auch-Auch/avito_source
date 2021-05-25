package y6.a.a;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import pl.droidsonroids.gif.AnimationListener;
import pl.droidsonroids.gif.GifDrawable;
public class e extends Handler {
    public final WeakReference<GifDrawable> a;

    public e(GifDrawable gifDrawable) {
        super(Looper.getMainLooper());
        this.a = new WeakReference<>(gifDrawable);
    }

    @Override // android.os.Handler
    public void handleMessage(@NonNull Message message) {
        GifDrawable gifDrawable = this.a.get();
        if (gifDrawable != null) {
            if (message.what == -1) {
                gifDrawable.invalidateSelf();
                return;
            }
            Iterator<AnimationListener> it = gifDrawable.g.iterator();
            while (it.hasNext()) {
                it.next().onAnimationCompleted(message.what);
            }
        }
    }
}
