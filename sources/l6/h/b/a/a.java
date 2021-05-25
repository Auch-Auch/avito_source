package l6.h.b.a;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import java.util.List;
public final class a {
    public final int[] a;
    public final float[] b;

    public a(@NonNull List<Integer> list, @NonNull List<Float> list2) {
        int size = list.size();
        this.a = new int[size];
        this.b = new float[size];
        for (int i = 0; i < size; i++) {
            this.a[i] = list.get(i).intValue();
            this.b[i] = list2.get(i).floatValue();
        }
    }

    public a(@ColorInt int i, @ColorInt int i2) {
        this.a = new int[]{i, i2};
        this.b = new float[]{0.0f, 1.0f};
    }

    public a(@ColorInt int i, @ColorInt int i2, @ColorInt int i3) {
        this.a = new int[]{i, i2, i3};
        this.b = new float[]{0.0f, 0.5f, 1.0f};
    }
}
