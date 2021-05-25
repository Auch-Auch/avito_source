package com.avito.android.lib.design.page_indicator;

import androidx.viewpager.widget.ViewPager;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$pageChangeListener$1", "Landroidx/viewpager/widget/ViewPager$SimpleOnPageChangeListener;", "", VKApiConst.POSITION, "", "onPageSelected", "(I)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ViewPagerAttachDelegate$pageChangeListener$1 extends ViewPager.SimpleOnPageChangeListener {
    public final /* synthetic */ ViewPagerAttachDelegate a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public ViewPagerAttachDelegate$pageChangeListener$1(ViewPagerAttachDelegate viewPagerAttachDelegate) {
        this.a = viewPagerAttachDelegate;
    }

    @Override // androidx.viewpager.widget.ViewPager.SimpleOnPageChangeListener, androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        PageIndicator.setSelectedPage$components_release$default(this.a.e, i, 0, 2, null);
    }
}
