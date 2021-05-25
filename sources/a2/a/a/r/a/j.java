package a2.a.a.r.a;

import android.content.res.Resources;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.basket_legacy.ui.LegacyCheckoutFragment;
import com.avito.android.basket_legacy.ui.PaddingDecoration;
import com.avito.android.util.Views;
import kotlin.jvm.internal.Intrinsics;
public final class j implements Runnable {
    public final /* synthetic */ LegacyCheckoutFragment a;

    public j(LegacyCheckoutFragment legacyCheckoutFragment) {
        this.a = legacyCheckoutFragment;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.a.isAdded()) {
            RecyclerView access$getRecyclerView$p = LegacyCheckoutFragment.access$getRecyclerView$p(this.a);
            Resources resources = this.a.getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "resources");
            access$getRecyclerView$p.addItemDecoration(new PaddingDecoration(resources, Views.heightWithMargins(LegacyCheckoutFragment.access$getProceedButton$p(this.a))));
            Views.show(LegacyCheckoutFragment.access$getRecyclerView$p(this.a));
        }
    }
}
