package com.avito.android.inline_filters.dialog;

import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.WidgetType;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0002\n\u0000¨\u0006\u0000"}, d2 = {"serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class InlineFiltersDialogItemConverterKt {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            WidgetType.values();
            int[] iArr = new int[7];
            $EnumSwitchMapping$0 = iArr;
            WidgetType widgetType = WidgetType.Select;
            iArr[1] = 1;
            WidgetType widgetType2 = WidgetType.Multiselect;
            iArr[2] = 2;
        }
    }

    public static final boolean access$isChecked(Filter.InnerOptions.Options options, Filter filter) {
        InlineFilterValue.InlineFilterMultiSelectValue inlineFilterMultiSelectValue;
        List<String> selectedOptions;
        Filter.Widget widget = filter.getWidget();
        WidgetType type = widget != null ? widget.getType() : null;
        InlineFilterValue value = filter.getValue();
        if (type == null) {
            return false;
        }
        int ordinal = type.ordinal();
        if (ordinal != 1) {
            if (ordinal != 2 || (inlineFilterMultiSelectValue = (InlineFilterValue.InlineFilterMultiSelectValue) value) == null || (selectedOptions = inlineFilterMultiSelectValue.getSelectedOptions()) == null) {
                return false;
            }
            return CollectionsKt___CollectionsKt.contains(selectedOptions, options.getId());
        } else if (value instanceof InlineFilterValue.InlineFilterSelectValue) {
            return Intrinsics.areEqual(((InlineFilterValue.InlineFilterSelectValue) value).getSelectedOption(), options.getId());
        } else {
            if (value instanceof InlineFilterValue.InlineFilterSelectIntValue) {
                return Intrinsics.areEqual(String.valueOf(((InlineFilterValue.InlineFilterSelectIntValue) value).getSelectedOption()), options.getId());
            }
            return false;
        }
    }
}
