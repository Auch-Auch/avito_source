package com.avito.android.inline_filters.dialog.select;

import a2.a.a.g1.e.d.k;
import a2.a.a.g1.e.d.l;
import a2.a.a.g1.e.d.m;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.inline_filters.dialog.InlineFilterDialog;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.serp_core.R;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B~\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u000b\u0012\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/SelectFilterDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "closeButtonListener", "imageFilterExposeListener", "<init>", "(Landroid/content/Context;Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SelectFilterDialog extends InlineFilterDialog {
    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SelectFilterDialog(Context context, Filter filter, List list, Parcelable parcelable, Function1 function1, Function0 function0, Function0 function02, Function0 function03, int i, j jVar) {
        this(context, filter, list, parcelable, function1, function0, (i & 64) != 0 ? function0 : function02, function03);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectFilterDialog(@NotNull Context context, @NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02, @NotNull Function0<Unit> function03) {
        super(context, 0, 2, null);
        int i;
        Filter.Config config;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filter, "inlineFilter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        Intrinsics.checkNotNullParameter(function02, "closeButtonListener");
        Intrinsics.checkNotNullParameter(function03, "imageFilterExposeListener");
        Object systemService = context.getSystemService("layout_inflater");
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        View inflate = ((LayoutInflater) systemService).inflate(R.layout.inline_filters_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "containerView");
        setView(new SelectFilterView(inflate));
        m mVar = new m(function0, inflate);
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(inflate, false);
        dialog.setSkipCollapsed(true);
        dialog.setOnCloseListener(new a2.a.a.g1.e.d.j(inflate, mVar));
        dialog.setOnCancelListener(new k(inflate, mVar));
        BottomSheetDialog.setHeaderParams$default(dialog, null, null, false, true, 7, null);
        dialog.setForceExpandedState(true);
        InlineFiltersView view = getView();
        if (view != null) {
            String title = filter.getTitle();
            view.setTitle(title == null ? "" : title);
            view.setCloseAction(new b4(0, this, filter, function02, inflate, function1, mVar, list, function03, parcelable));
            view.setResetAction(new b4(1, this, filter, function02, inflate, function1, mVar, list, function03, parcelable));
            view.setResetActionClickable(filter.getValue() != null);
            Filter.Widget widget = filter.getWidget();
            if (!(widget == null || (config = widget.getConfig()) == null)) {
                Boolean resetDisabled = config.getResetDisabled();
                Boolean bool = Boolean.TRUE;
                view.setResetActionVisibility(!Intrinsics.areEqual(resetDisabled, bool));
                view.setBackButtonEnabled(Intrinsics.areEqual(config.getWithBackButton(), bool));
            }
            view.setItemsView(list);
            view.selectAction().subscribe(new l(this, filter, function02, inflate, function1, mVar, list, function03, parcelable));
            view.setImageFilterExposeAction(new b4(2, this, filter, function02, inflate, function1, mVar, list, function03, parcelable));
            view.setState(parcelable);
        }
        List<Filter.InnerOptions> options = filter.getOptions();
        if (options != null) {
            if (options.isEmpty()) {
                i = 0;
            } else {
                Iterator<T> it = options.iterator();
                i = 0;
                while (it.hasNext()) {
                    List<Filter.InnerOptions.Options> options2 = it.next().getOptions();
                    if (((options2 != null ? options2.size() : 0) > 7) && (i = i + 1) < 0) {
                        CollectionsKt__CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i == 0) {
                InlineFiltersView view2 = getView();
                if (view2 != null) {
                    view2.setSearchInputVisibility(8);
                }
                getDialog().setForceExpandedState(false);
            }
        }
    }
}
