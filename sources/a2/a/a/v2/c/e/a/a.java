package a2.a.a.v2.c.e.a;

import android.content.Context;
import android.widget.TextView;
import com.avito.android.short_term_rent.R;
import com.avito.android.util.Contexts;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
public final class a implements Runnable {
    public final /* synthetic */ TextView a;
    public final /* synthetic */ Function0 b;

    public a(TextView textView, Function0 function0) {
        this.a = textView;
        this.b = function0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setBackgroundResource(R.drawable.selected_guest_count_background);
        TextView textView = this.a;
        Context context = textView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        textView.setTextColor(Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite));
        this.b.invoke();
    }
}
