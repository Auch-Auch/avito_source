package butterknife;

import androidx.annotation.UiThread;
import p6.a;
public interface Unbinder {
    public static final Unbinder EMPTY = a.a;

    @UiThread
    void unbind();
}
