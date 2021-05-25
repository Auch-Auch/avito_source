package a2.a.a.v2.c.e.a;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.avito.android.lib.design.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
public final class b implements Runnable {
    public final /* synthetic */ TextView a;

    public b(TextView textView) {
        this.a = textView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Views.setBackgroundCompat(this.a, (Drawable) null);
        TextView textView = this.a;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, R.attr.black));
    }
}
