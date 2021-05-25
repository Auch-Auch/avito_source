package a2.a.a.n2.w.b;

import android.view.View;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.lib.design.tooltip.TooltipContent;
public final class c implements View.OnClickListener {
    public final /* synthetic */ DeepLink a;
    public final /* synthetic */ d b;

    public c(DeepLink deepLink, d dVar, TooltipContent tooltipContent) {
        this.a = deepLink;
        this.b = dVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.b.a.h.accept(this.a);
        this.b.d.dismiss();
    }
}
