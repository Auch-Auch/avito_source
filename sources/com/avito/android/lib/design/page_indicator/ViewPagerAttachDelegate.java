package com.avito.android.lib.design.page_indicator;

import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\b\t*\u0002\u0012\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\t\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00028\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\t\u0010\u001a¨\u0006\u001e"}, d2 = {"Lcom/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate;", "Lcom/avito/android/lib/design/page_indicator/AttachDelegate;", "Landroidx/viewpager/widget/ViewPager;", "view", "", "attachSelf", "(Landroidx/viewpager/widget/ViewPager;)V", "detachSelf", "()V", AuthSource.SEND_ABUSE, "Landroidx/viewpager/widget/PagerAdapter;", AuthSource.BOOKING_ORDER, "Landroidx/viewpager/widget/PagerAdapter;", "adapter", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "e", "Lcom/avito/android/lib/design/page_indicator/PageIndicator;", "pageIndicator", "com/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$adapterDataObserver$1", "d", "Lcom/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$adapterDataObserver$1;", "adapterDataObserver", "com/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$pageChangeListener$1", "c", "Lcom/avito/android/lib/design/page_indicator/ViewPagerAttachDelegate$pageChangeListener$1;", "pageChangeListener", "Landroidx/viewpager/widget/ViewPager;", "viewPager", "<init>", "(Lcom/avito/android/lib/design/page_indicator/PageIndicator;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class ViewPagerAttachDelegate implements AttachDelegate<ViewPager> {
    public ViewPager a;
    public PagerAdapter b;
    public final ViewPagerAttachDelegate$pageChangeListener$1 c = new ViewPagerAttachDelegate$pageChangeListener$1(this);
    public final ViewPagerAttachDelegate$adapterDataObserver$1 d = new ViewPagerAttachDelegate$adapterDataObserver$1(this);
    public final PageIndicator e;

    public ViewPagerAttachDelegate(@NotNull PageIndicator pageIndicator) {
        Intrinsics.checkNotNullParameter(pageIndicator, "pageIndicator");
        this.e = pageIndicator;
    }

    public final void a() {
        PageIndicator pageIndicator = this.e;
        PagerAdapter pagerAdapter = this.b;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pageIndicator.setPageCount$components_release(pagerAdapter.getCount());
        ViewPager viewPager = this.a;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        int currentItem = viewPager.getCurrentItem();
        PagerAdapter pagerAdapter2 = this.b;
        if (pagerAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        int count = pagerAdapter2.getCount();
        if (currentItem >= 0 && count > currentItem) {
            PageIndicator.setSelectedPage$components_release$default(this.e, currentItem, 0, 2, null);
        }
    }

    @Override // com.avito.android.lib.design.page_indicator.AttachDelegate
    public void detachSelf() {
        PagerAdapter pagerAdapter = this.b;
        if (pagerAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
        }
        pagerAdapter.unregisterDataSetObserver(this.d);
        ViewPager viewPager = this.a;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        viewPager.removeOnPageChangeListener(this.c);
    }

    public void attachSelf(@NotNull ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "view");
        this.a = viewPager;
        if (viewPager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        }
        PagerAdapter adapter = viewPager.getAdapter();
        if (adapter != null) {
            this.b = adapter;
            if (adapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            }
            adapter.registerDataSetObserver(this.d);
            ViewPager viewPager2 = this.a;
            if (viewPager2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewPager");
            }
            viewPager2.addOnPageChangeListener(this.c);
            a();
            return;
        }
        throw new IllegalArgumentException("ViewPager's Adapter must be set for PageIndicator");
    }
}
