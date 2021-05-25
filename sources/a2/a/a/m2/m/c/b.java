package a2.a.a.m2.m.c;

import com.avito.android.select.new_metro.adapter.filter.MetroFilterItem;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class b extends Lambda implements Function1<MetroFilterItem, Integer> {
    public static final b a = new b();

    public b() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Integer invoke(MetroFilterItem metroFilterItem) {
        MetroFilterItem metroFilterItem2 = metroFilterItem;
        Intrinsics.checkNotNullParameter(metroFilterItem2, "it");
        return Integer.valueOf(metroFilterItem2.getFilterId());
    }
}
