package com.avito.android.tariff.change;

import androidx.viewpager2.widget.ViewPager2;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/avito/android/tariff/change/TariffChangeFragment$pageChangeCallback$1", "Landroidx/viewpager2/widget/ViewPager2$OnPageChangeCallback;", "", VKApiConst.POSITION, "", "onPageSelected", "(I)V", "tariff_release"}, k = 1, mv = {1, 4, 2})
public final class TariffChangeFragment$pageChangeCallback$1 extends ViewPager2.OnPageChangeCallback {
    public final /* synthetic */ TariffChangeFragment a;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    public TariffChangeFragment$pageChangeCallback$1(TariffChangeFragment tariffChangeFragment) {
        this.a = tariffChangeFragment;
    }

    @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
    public void onPageSelected(int i) {
        this.a.getViewModel().onPageSelected(i);
    }
}
