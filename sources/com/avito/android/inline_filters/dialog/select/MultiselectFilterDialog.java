package com.avito.android.inline_filters.dialog.select;

import a2.a.a.g1.e.d.f;
import a2.a.a.g1.e.d.g;
import a2.a.a.g1.e.d.h;
import a2.a.a.g1.e.d.i;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.inline_filters.dialog.InlineFilterDialog;
import com.avito.android.inline_filters.dialog.InlineFiltersView;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.remote.model.search.InlineFilterValueKt;
import com.avito.android.serp_core.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bn\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d\u0012!\u0010$\u001a\u001d\u0012\u0013\u0012\u00110 ¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0004\u0012\u00020\u00050\u001f\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00050%\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00050%¢\u0006\u0004\b(\u0010)J\u001b\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007R$\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0014@\u0014X\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006*"}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/MultiselectFilterDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/inline_filters/dialog/InlineFiltersView;Lcom/avito/android/remote/model/search/Filter;)V", "d", "Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "getView", "()Lcom/avito/android/inline_filters/dialog/InlineFiltersView;", "setView", "(Lcom/avito/android/inline_filters/dialog/InlineFiltersView;)V", "view", "", "", "e", "Ljava/util/List;", "selectedFilterOptionsId", "Landroid/view/View;", "c", "Landroid/view/View;", "contentView", "Landroid/content/Context;", "context", "", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "Landroid/os/Parcelable;", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "imageFilterExposeListener", "<init>", "(Landroid/content/Context;Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MultiselectFilterDialog extends InlineFilterDialog {
    @SuppressLint({"InflateParams"})
    public final View c;
    @Nullable
    public InlineFiltersView d;
    public List<String> e = new ArrayList();

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiselectFilterDialog(@NotNull Context context, @NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        super(context, 0, 2, null);
        List<String> selectedOptions;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filter, "inlineFilter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        Intrinsics.checkNotNullParameter(function02, "imageFilterExposeListener");
        View inflate = LayoutInflater.from(context).inflate(R.layout.inline_filters_dialog, (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…ine_filters_dialog, null)");
        this.c = inflate;
        this.d = new MultiselectFilterView(inflate);
        InlineFilterValue.InlineFilterMultiSelectValue inlineFilterMultiSelectValue = (InlineFilterValue.InlineFilterMultiSelectValue) filter.getValue();
        this.e = new ArrayList();
        if (!(inlineFilterMultiSelectValue == null || (selectedOptions = inlineFilterMultiSelectValue.getSelectedOptions()) == null)) {
            this.e.addAll(selectedOptions);
        }
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
        for (T t : list) {
            arrayList.add(new InlineFiltersDialogItem(t.getStringId(), t.getText(), t.getSecondaryText(), t.getFilterId(), t.isHeading(), t.getChecked(), false, t.isMultiselect(), t.getWithImages(), t.getShouldExposeImageGroup(), t.getImage(), 64, null));
        }
        Function0<Unit> q5Var = new q5(1, this, function0);
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(this.c, false);
        dialog.setSkipCollapsed(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(new a2.a.a.g1.e.d.e(this, q5Var));
        dialog.setOnCloseListener(new q5(0, this, q5Var));
        BottomSheetDialog.setHeaderParams$default(dialog, null, null, false, true, 7, null);
        dialog.setFitContentPeekHeight(true);
        InlineFiltersView view = getView();
        if (view != null) {
            String title = filter.getTitle();
            view.setTitle(title == null ? "" : title);
            view.setCloseAction(q5Var);
            view.setResetAction(new f(view, this, filter, q5Var, arrayList, function1, list, parcelable, function02));
            String string = this.c.getContext().getString(R.string.clear_inline_filter);
            Intrinsics.checkNotNullExpressionValue(string, "contentView.context.getS…ring.clear_inline_filter)");
            view.setResetActionHint(string);
            view.setItemsView(arrayList);
            view.selectAction().subscribe(new g<>(view, this, filter, q5Var, arrayList, function1, list, parcelable, function02));
            view.setApplyAction(new h(this, filter, q5Var, arrayList, function1, list, parcelable, function02));
            String string2 = this.c.getContext().getString(R.string.apply_inline_filter);
            Intrinsics.checkNotNullExpressionValue(string2, "contentView.context.getS…ring.apply_inline_filter)");
            view.setApplyBtnText(string2);
            view.setSearchInputVisibility(8);
            view.setState(parcelable);
            a(view, filter);
            view.setImageFilterExposeAction(new i(this, filter, q5Var, arrayList, function1, list, parcelable, function02));
        }
    }

    public static final void access$updateSelection(MultiselectFilterDialog multiselectFilterDialog, List list, List list2) {
        Objects.requireNonNull(multiselectFilterDialog);
        Iterator it = list.iterator();
        Iterator it2 = list2.iterator();
        ArrayList arrayList = new ArrayList(Math.min(e.collectionSizeOrDefault(list, 10), e.collectionSizeOrDefault(list2, 10)));
        while (it.hasNext() && it2.hasNext()) {
            ((InlineFiltersDialogItem) it.next()).setChecked(((InlineFiltersDialogItem) it2.next()).getChecked());
            arrayList.add(Unit.INSTANCE);
        }
    }

    public final void a(InlineFiltersView inlineFiltersView, Filter filter) {
        boolean z = true;
        inlineFiltersView.setResetActionClickable(!this.e.isEmpty());
        if (!(!this.e.isEmpty()) && !InlineFilterValueKt.isNotEmpty(filter.getValue())) {
            z = false;
        }
        inlineFiltersView.setApplyBtnVisible(z);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    @Nullable
    public InlineFiltersView getView() {
        return this.d;
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    public void setView(@Nullable InlineFiltersView inlineFiltersView) {
        this.d = inlineFiltersView;
    }
}
