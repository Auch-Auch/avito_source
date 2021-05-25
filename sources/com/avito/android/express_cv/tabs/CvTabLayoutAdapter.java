package com.avito.android.express_cv.tabs;

import android.content.Context;
import android.view.View;
import com.avito.android.express_cv.R;
import com.avito.android.ui.adapter.tab.TabAdapter;
import com.avito.android.ui.adapter.tab.TabsDataProvider;
import com.avito.android.util.DeviceMetrics;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B%\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00020\u0012\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\f\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, d2 = {"Lcom/avito/android/express_cv/tabs/CvTabLayoutAdapter;", "Lcom/avito/android/ui/adapter/tab/TabAdapter;", "Lcom/avito/android/express_cv/tabs/CvTabItem;", "Lcom/avito/android/express_cv/tabs/CvTabView;", "Landroid/view/View;", "view", "Lcom/avito/android/express_cv/tabs/CvTabViewImpl;", "createTabItemView", "(Landroid/view/View;)Lcom/avito/android/express_cv/tabs/CvTabViewImpl;", "tabItemView", "item", "", "bind", "(Lcom/avito/android/express_cv/tabs/CvTabView;Lcom/avito/android/express_cv/tabs/CvTabItem;)V", "Lcom/avito/android/util/DeviceMetrics;", "e", "Lcom/avito/android/util/DeviceMetrics;", "deviceMetrics", "Lcom/avito/android/ui/adapter/tab/TabsDataProvider;", "tabs", "Landroid/content/Context;", "context", "<init>", "(Lcom/avito/android/ui/adapter/tab/TabsDataProvider;Landroid/content/Context;Lcom/avito/android/util/DeviceMetrics;)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public final class CvTabLayoutAdapter extends TabAdapter<CvTabItem, CvTabView> {
    public final DeviceMetrics e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CvTabLayoutAdapter(@NotNull TabsDataProvider<CvTabItem> tabsDataProvider, @NotNull Context context, @NotNull DeviceMetrics deviceMetrics) {
        super(tabsDataProvider, context, R.layout.cv_tab);
        Intrinsics.checkNotNullParameter(tabsDataProvider, "tabs");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(deviceMetrics, "deviceMetrics");
        this.e = deviceMetrics;
    }

    public void bind(@NotNull CvTabView cvTabView, @NotNull CvTabItem cvTabItem) {
        Intrinsics.checkNotNullParameter(cvTabView, "tabItemView");
        Intrinsics.checkNotNullParameter(cvTabItem, "item");
        cvTabView.bind(cvTabItem.getTitle());
        cvTabView.setWidth(this.e.getDisplayWidth() / getTabs().getCount());
    }

    /* Return type fixed from 'com.avito.android.express_cv.tabs.CvTabViewImpl' to match base method */
    @Override // com.avito.android.ui.adapter.tab.TabAdapter
    @NotNull
    public CvTabView createTabItemView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return new CvTabViewImpl(view);
    }
}
