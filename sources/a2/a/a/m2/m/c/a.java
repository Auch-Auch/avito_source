package a2.a.a.m2.m.c;

import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function1<MetroFilterItem, Boolean> {
    public final /* synthetic */ SelectMetroViewModel a;
    public final /* synthetic */ Set b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(SelectMetroViewModel selectMetroViewModel, Set set) {
        super(1);
        this.a = selectMetroViewModel;
        this.b = set;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Boolean invoke(MetroFilterItem metroFilterItem) {
        MetroFilterItem metroFilterItem2 = metroFilterItem;
        Intrinsics.checkNotNullParameter(metroFilterItem2, "it");
        return Boolean.valueOf(SelectMetroViewModel.access$isFilterSelected(this.a, metroFilterItem2, this.b));
    }
}
