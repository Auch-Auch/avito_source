package com.avito.android.lib.design.page_indicator;

import android.database.DataSetObserver;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0004¨\u0006\u0006"}, d2 = {"com/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$adapterDataObserver$1", "Landroid/database/DataSetObserver;", "", "onChanged", "()V", "onInvalidated", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ViewPagerAttachDelegate$adapterDataObserver$1 extends DataSetObserver {
    public final /* synthetic */ ViewPagerAttachDelegate a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ViewPagerAttachDelegate$adapterDataObserver$1(ViewPagerAttachDelegate viewPagerAttachDelegate) {
        this.a = viewPagerAttachDelegate;
    }

    @Override // android.database.DataSetObserver
    public void onChanged() {
        this.a.a();
    }

    @Override // android.database.DataSetObserver
    public void onInvalidated() {
        this.a.a();
    }
}
