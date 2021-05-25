package a2.a.a.h1.a;

import android.view.View;
import com.avito.android.item_map.view.ItemMapViewImpl;
import com.avito.android.lib.design.tooltip.Tooltip;
import kotlin.Unit;
public final class a implements View.OnClickListener {
    public final /* synthetic */ ItemMapViewImpl.c a;

    public a(ItemMapViewImpl.c cVar) {
        this.a = cVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Tooltip tooltip = this.a.a.r;
        if (tooltip != null) {
            tooltip.dismiss();
        }
        this.a.a.h.accept(Unit.INSTANCE);
    }
}
