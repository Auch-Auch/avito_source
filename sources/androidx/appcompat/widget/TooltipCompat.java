package androidx.appcompat.widget;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import l6.b.d.r;
public class TooltipCompat {
    public static void setTooltipText(@NonNull View view, @Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
            return;
        }
        r rVar = r.j;
        if (rVar != null && rVar.a == view) {
            r.c(null);
        }
        if (TextUtils.isEmpty(charSequence)) {
            r rVar2 = r.k;
            if (rVar2 != null && rVar2.a == view) {
                rVar2.b();
            }
            view.setOnLongClickListener(null);
            view.setLongClickable(false);
            view.setOnHoverListener(null);
            return;
        }
        new r(view, charSequence);
    }
}
