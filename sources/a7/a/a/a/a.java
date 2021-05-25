package a7.a.a.a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.core.graphics.ColorUtils;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@SuppressLint({"ViewConstructor"})
public final class a extends View {
    @ColorInt
    public final Integer a;
    public boolean b;
    public final int c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(@NotNull Context context, @ColorInt int i) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.c = i;
        Window a3 = a();
        this.a = a3 != null ? Integer.valueOf(a3.getStatusBarColor()) : null;
        Views.setBackgroundCompat(this, new ColorDrawable(i));
    }

    public final Window a() {
        Context context = getContext();
        if (!(context instanceof Activity)) {
            context = null;
        }
        Activity activity = (Activity) context;
        if (activity != null) {
            return activity.getWindow();
        }
        return null;
    }

    public final void b() {
        Integer num;
        if (this.b && (num = this.a) != null) {
            int intValue = num.intValue();
            Window a3 = a();
            if (a3 != null) {
                a3.setStatusBarColor(intValue);
            }
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        b();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onSetAlpha(int i) {
        float f = ((float) i) / 255.0f;
        if (this.b) {
            float alpha = ((float) Color.alpha(this.c)) / 255.0f;
            Integer num = this.a;
            if (num != null) {
                int intValue = num.intValue();
                Window a3 = a();
                if (a3 != null) {
                    a3.setStatusBarColor(ColorUtils.blendARGB(intValue, this.c, alpha * f));
                }
            }
        }
        return super.onSetAlpha(i);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NotNull View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        super.onVisibilityChanged(view, i);
        if (i != 0) {
            b();
        }
    }
}
