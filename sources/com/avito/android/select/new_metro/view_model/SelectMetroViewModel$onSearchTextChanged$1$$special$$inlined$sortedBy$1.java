package com.avito.android.select.new_metro.view_model;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.select.new_metro.view_model.SelectMetroViewModel;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.text.StringsKt__StringsKt;
import t6.o.a;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\u0010\b\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00018\u00008\u00002\u000e\u0010\u0003\u001a\n \u0001*\u0004\u0018\u00018\u00008\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"T", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, AuthSource.BOOKING_ORDER, "", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2", "<anonymous>"}, k = 3, mv = {1, 4, 2})
public final class SelectMetroViewModel$onSearchTextChanged$1$$special$$inlined$sortedBy$1<T> implements Comparator<T> {
    public final /* synthetic */ SelectMetroViewModel.a a;

    public SelectMetroViewModel$onSearchTextChanged$1$$special$$inlined$sortedBy$1(SelectMetroViewModel.a aVar) {
        this.a = aVar;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(StringsKt__StringsKt.indexOf$default((CharSequence) t.getStationName(), this.a.c, 0, true, 2, (Object) null)), Integer.valueOf(StringsKt__StringsKt.indexOf$default((CharSequence) t2.getStationName(), this.a.c, 0, true, 2, (Object) null)));
    }
}
