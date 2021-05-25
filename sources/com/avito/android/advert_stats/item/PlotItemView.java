package com.avito.android.advert_stats.item;

import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J%\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\rJ#\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J#\u0010\u0012\u001a\u00020\u00072\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u000eH&¢\u0006\u0004\b\u0012\u0010\u0011J\u001f\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0005H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0007H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\nH&¢\u0006\u0004\b\u001a\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/avito/android/advert_stats/item/PlotItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "Lcom/avito/android/advert_stats/item/WeekItem;", "items", "", "hasSelectedBar", "", "setItems", "(Ljava/util/List;Z)V", "", ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, "setHeight", "(I)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setScrollStateListener", "(Lkotlin/jvm/functions/Function1;)V", "setWeekSelectedListener", "dayIndex", "selected", "setDaySelected", "(IZ)V", "removeDaySelection", "()V", FirebaseAnalytics.Param.INDEX, "scrollToItem", "advert-stats_release"}, k = 1, mv = {1, 4, 2})
public interface PlotItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull PlotItemView plotItemView) {
            ItemView.DefaultImpls.onUnbind(plotItemView);
        }
    }

    void removeDaySelection();

    void scrollToItem(int i);

    void setDaySelected(int i, boolean z);

    void setHeight(int i);

    void setItems(@NotNull List<WeekItem> list, boolean z);

    void setScrollStateListener(@NotNull Function1<? super Boolean, Unit> function1);

    void setWeekSelectedListener(@NotNull Function1<? super Integer, Unit> function1);
}
