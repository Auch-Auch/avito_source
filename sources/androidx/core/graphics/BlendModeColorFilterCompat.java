package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
public class BlendModeColorFilterCompat {
    @Nullable
    public static ColorFilter createBlendModeColorFilterCompat(int i, @NonNull BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode m1 = AppCompatDelegateImpl.i.m1(blendModeCompat);
            if (m1 != null) {
                return new BlendModeColorFilter(i, m1);
            }
            return null;
        }
        PorterDuff.Mode n1 = AppCompatDelegateImpl.i.n1(blendModeCompat);
        if (n1 != null) {
            return new PorterDuffColorFilter(i, n1);
        }
        return null;
    }
}
