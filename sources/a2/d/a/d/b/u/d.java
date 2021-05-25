package a2.d.a.d.b.u;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
public interface d {
    @Nullable
    Bitmap get(int i, int i2, Bitmap.Config config);

    int getSize(Bitmap bitmap);

    String logBitmap(int i, int i2, Bitmap.Config config);

    String logBitmap(Bitmap bitmap);

    void put(Bitmap bitmap);

    @Nullable
    Bitmap removeLast();
}
