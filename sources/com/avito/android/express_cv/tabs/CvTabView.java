package com.avito.android.express_cv.tabs;

import com.avito.android.ui.adapter.tab.TabItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/express_cv/tabs/CvTabView;", "Lcom/avito/android/ui/adapter/tab/TabItemView;", "", "text", "", "bind", "(Ljava/lang/String;)V", "", "widthPx", "setWidth", "(I)V", "express-cv_release"}, k = 1, mv = {1, 4, 2})
public interface CvTabView extends TabItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void setSelected(@NotNull CvTabView cvTabView, int i, int i2, boolean z) {
            TabItemView.DefaultImpls.setSelected(cvTabView, i, i2, z);
        }

        public static void setSelected(@NotNull CvTabView cvTabView, boolean z) {
            TabItemView.DefaultImpls.setSelected(cvTabView, z);
        }
    }

    void bind(@NotNull String str);

    void setWidth(int i);
}
