package a2.a.a.w.c;

import com.avito.android.brandspace.presenter.BrandspaceItem;
import com.avito.android.brandspace.presenter.virtualitems.extraloading.ExtraLoadingListItems;
import java.util.List;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class t extends Lambda implements Function1<List<? extends BrandspaceItem>, Unit> {
    public final /* synthetic */ Triple a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t(Triple triple) {
        super(1);
        this.a = triple;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(List<? extends BrandspaceItem> list) {
        List<? extends BrandspaceItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "it");
        ((ExtraLoadingListItems) this.a.getFirst()).addItems(list2);
        return Unit.INSTANCE;
    }
}
