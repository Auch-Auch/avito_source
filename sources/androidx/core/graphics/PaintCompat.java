package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDelegateImpl;
import androidx.core.util.Pair;
import com.avito.android.remote.auth.AuthSource;
public final class PaintCompat {
    public static final ThreadLocal<Pair<Rect, Rect>> a = new ThreadLocal<>();

    public static boolean hasGlyph(@NonNull Paint paint, @NonNull String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return paint.hasGlyph(str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("󟿽");
        float measureText2 = paint.measureText(AuthSource.OPEN_CHANNEL_LIST);
        float measureText3 = paint.measureText(str);
        float f = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i = 0;
            while (i < length) {
                int charCount = Character.charCount(str.codePointAt(i)) + i;
                f += paint.measureText(str, i, charCount);
                i = charCount;
            }
            if (measureText3 >= f) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        ThreadLocal<Pair<Rect, Rect>> threadLocal = a;
        Pair<Rect, Rect> pair = threadLocal.get();
        if (pair == null) {
            pair = new Pair<>(new Rect(), new Rect());
            threadLocal.set(pair);
        } else {
            pair.first.setEmpty();
            pair.second.setEmpty();
        }
        paint.getTextBounds("󟿽", 0, 2, (Rect) pair.first);
        paint.getTextBounds(str, 0, length, (Rect) pair.second);
        return !pair.first.equals(pair.second);
    }

    public static boolean setBlendMode(@NonNull Paint paint, @Nullable BlendModeCompat blendModeCompat) {
        PorterDuffXfermode porterDuffXfermode = null;
        BlendMode blendMode = null;
        if (Build.VERSION.SDK_INT >= 29) {
            if (blendModeCompat != null) {
                blendMode = AppCompatDelegateImpl.i.m1(blendModeCompat);
            }
            paint.setBlendMode(blendMode);
            return true;
        } else if (blendModeCompat != null) {
            PorterDuff.Mode n1 = AppCompatDelegateImpl.i.n1(blendModeCompat);
            if (n1 != null) {
                porterDuffXfermode = new PorterDuffXfermode(n1);
            }
            paint.setXfermode(porterDuffXfermode);
            if (n1 != null) {
                return true;
            }
            return false;
        } else {
            paint.setXfermode(null);
            return true;
        }
    }
}
