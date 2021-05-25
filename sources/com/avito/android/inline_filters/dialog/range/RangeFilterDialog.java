package com.avito.android.inline_filters.dialog.range;

import a2.a.a.g1.e.c.a;
import a2.a.a.g1.e.c.b;
import a2.a.a.g1.e.c.c;
import a2.a.a.g1.e.c.d;
import android.app.Activity;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.inline_filters.dialog.InlineFilterDialog;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilterValueKt;
import com.avito.android.serp_core.R;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BR\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00020\u000b\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"Lcom/avito/android/inline_filters/dialog/range/RangeFilterDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "", "show", "()V", "Landroid/app/Activity;", "activity", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "<init>", "(Landroid/app/Activity;Lcom/avito/android/remote/model/search/Filter;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class RangeFilterDialog extends InlineFilterDialog {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RangeFilterDialog(@NotNull Activity activity, @NotNull Filter filter, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0) {
        super(activity, R.style.RangeFilterDialog);
        String str;
        Filter.Config config;
        String thousandsSeparator;
        Filter.Config config2;
        String toValueFormat;
        Filter.Config config3;
        String toPlaceholder;
        Filter.Config config4;
        String fromValueFormat;
        Filter.Config config5;
        String fromPlaceholder;
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(filter, "inlineFilter");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        InlineFilterValue.InlineFilterNumericRangeValue inlineFilterNumericRangeValue = (InlineFilterValue.InlineFilterNumericRangeValue) filter.getValue();
        Object systemService = activity.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        Long l = null;
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.inline_filters_dialog_range, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "containerView");
        Filter.Widget widget = filter.getWidget();
        String str2 = "";
        String str3 = (widget == null || (config5 = widget.getConfig()) == null || (fromPlaceholder = config5.getFromPlaceholder()) == null) ? str2 : fromPlaceholder;
        Filter.Widget widget2 = filter.getWidget();
        String str4 = (widget2 == null || (config4 = widget2.getConfig()) == null || (fromValueFormat = config4.getFromValueFormat()) == null) ? "%s" : fromValueFormat;
        Filter.Widget widget3 = filter.getWidget();
        String str5 = (widget3 == null || (config3 = widget3.getConfig()) == null || (toPlaceholder = config3.getToPlaceholder()) == null) ? str2 : toPlaceholder;
        Filter.Widget widget4 = filter.getWidget();
        if (widget4 == null || (config2 = widget4.getConfig()) == null || (toValueFormat = config2.getToValueFormat()) == null) {
            str = "%s";
        } else {
            str = toValueFormat;
        }
        boolean isNotEmpty = InlineFilterValueKt.isNotEmpty(inlineFilterNumericRangeValue);
        Filter.Widget widget5 = filter.getWidget();
        setView(new RangeFilterView(inflate, str3, str4, str5, str, isNotEmpty, (widget5 == null || (config = widget5.getConfig()) == null || (thousandsSeparator = config.getThousandsSeparator()) == null) ? str2 : thousandsSeparator));
        d dVar = new d(this, inflate, function0);
        InlineFiltersView view = getView();
        RangeFilterView rangeFilterView = (RangeFilterView) (!(view instanceof RangeFilterView) ? null : view);
        if (rangeFilterView != null) {
            rangeFilterView.setInputValues(inlineFilterNumericRangeValue != null ? inlineFilterNumericRangeValue.getFrom() : null, inlineFilterNumericRangeValue != null ? inlineFilterNumericRangeValue.getTo() : l);
            rangeFilterView.setSearchInputVisibility(8);
            String title = filter.getTitle();
            rangeFilterView.setTitle(title != null ? title : str2);
            rangeFilterView.setCloseAction(new v4(0, inlineFilterNumericRangeValue, filter, dVar, function1, parcelable));
            rangeFilterView.setApplyAction(new a(inlineFilterNumericRangeValue, filter, dVar, function1, parcelable));
            rangeFilterView.setResetAction(new v4(1, inlineFilterNumericRangeValue, filter, dVar, function1, parcelable));
            InlineFilterValue value = filter.getValue();
            rangeFilterView.setResetActionClickable(!(value != null ? value.isEmpty() : true));
            rangeFilterView.setState(parcelable);
        }
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(inflate, false);
        dialog.setOnCloseListener(new b(inflate, dVar));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(new c(inflate, dVar));
        BottomSheetDialog.setHeaderParams$default(dialog, null, null, false, true, 7, null);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    public void show() {
        super.show();
        InlineFiltersView view = getView();
        if (!(view instanceof RangeFilterView)) {
            view = null;
        }
        RangeFilterView rangeFilterView = (RangeFilterView) view;
        if (rangeFilterView != null) {
            rangeFilterView.showKeyboard();
        }
    }
}
