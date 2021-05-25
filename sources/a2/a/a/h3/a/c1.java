package a2.a.a.h3.a;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.avito.android.analytics.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.ImplicitIntentFactory;
import kotlin.jvm.internal.Intrinsics;
public final class c1 implements View.OnClickListener {
    public final /* synthetic */ d1 a;

    public c1(d1 d1Var) {
        this.a = d1Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        T t = this.a.b.element;
        if (t != null) {
            t.dismiss();
        }
        Uri parse = Uri.parse(this.a.a.b.getString(R.string.new_statistics_info_link));
        Context context = this.a.a.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        ImplicitIntentFactory implicitIntentFactory = this.a.a.g0;
        Intrinsics.checkNotNullExpressionValue(parse, "link");
        Contexts.startActivitySafely(context, implicitIntentFactory.uriIntent(parse));
    }
}
