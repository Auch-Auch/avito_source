package com.avito.android.serp.adapter.vertical_main.vertical_filter.adapter.segmented;

import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u0005H&¢\u0006\u0004\b\b\u0010\tJ2\u0010\u000f\u001a\u00020\u00072!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00070\nH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/avito/android/serp/adapter/vertical_main/vertical_filter/adapter/segmented/VerticalSearchFilterSegmentedItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "", "texts", "", "selectedPosition", "", "setTexts", "(Ljava/util/List;I)V", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "currentSelected", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function1;)V", "", "enabled", "setIsEnabled", "(Z)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface VerticalSearchFilterSegmentedItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull VerticalSearchFilterSegmentedItemView verticalSearchFilterSegmentedItemView) {
            ItemView.DefaultImpls.onUnbind(verticalSearchFilterSegmentedItemView);
        }

        public static /* synthetic */ void setTexts$default(VerticalSearchFilterSegmentedItemView verticalSearchFilterSegmentedItemView, List list, int i, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 2) != 0) {
                    i = 0;
                }
                verticalSearchFilterSegmentedItemView.setTexts(list, i);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setTexts");
        }
    }

    void setIsEnabled(boolean z);

    void setOnClickListener(@NotNull Function1<? super Integer, Unit> function1);

    void setTexts(@NotNull List<String> list, int i);
}
