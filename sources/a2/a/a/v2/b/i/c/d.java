package a2.a.a.v2.b.i.c;

import androidx.lifecycle.Observer;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationDialogItem;
import com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationView;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class d<T> implements Observer<List<? extends HotelsLocationDialogItem>> {
    public final /* synthetic */ HotelsLocationView a;

    public d(HotelsLocationView hotelsLocationView) {
        this.a = hotelsLocationView;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.short_term_rent.hotels.dialogs.location.HotelsLocationView */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.lifecycle.Observer
    public void onChanged(List<? extends HotelsLocationDialogItem> list) {
        List<? extends HotelsLocationDialogItem> list2 = list;
        HotelsLocationView hotelsLocationView = this.a;
        Intrinsics.checkNotNullExpressionValue(list2, "it");
        hotelsLocationView.setItemsView(list2);
    }
}
