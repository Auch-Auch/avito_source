package ru.avito.component.statistics;

import android.view.View;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0002H&¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lru/avito/component/statistics/Statistics;", "", "", "viewsEver", "viewsToday", "likes", "", "setData", "(III)V", "Landroid/view/View$OnClickListener;", "clickListener", "setOnStatisticsClickListener", "(Landroid/view/View$OnClickListener;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface Statistics {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void setData$default(Statistics statistics, int i, int i2, int i3, int i4, Object obj) {
            if (obj == null) {
                if ((i4 & 1) != 0) {
                    i = 0;
                }
                if ((i4 & 2) != 0) {
                    i2 = 0;
                }
                if ((i4 & 4) != 0) {
                    i3 = 0;
                }
                statistics.setData(i, i2, i3);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setData");
        }
    }

    void setData(int i, int i2, int i3);

    void setOnStatisticsClickListener(@Nullable View.OnClickListener onClickListener);
}
