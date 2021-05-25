package com.avito.android.inline_filters.dialog.select;

import a2.a.a.g1.e.d.a;
import a2.a.a.g1.e.d.b;
import a2.a.a.g1.e.d.c;
import a2.a.a.g1.e.d.d;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.avito.android.inline_filters.dialog.InlineFilterDialog;
import com.avito.android.inline_filters.dialog.select.adapter.InlineFiltersDialogItem;
import com.avito.android.lib.design.bottom_sheet.BottomSheetDialog;
import com.avito.android.remote.model.search.Filter;
import com.avito.android.remote.model.search.InlineFilterValue;
import com.avito.android.select.group_select.GroupSelectPresenter;
import com.avito.android.select.group_select.GroupSelectView;
import com.avito.android.select.group_select.GroupSelectViewImpl;
import com.avito.android.select.group_select.models.SelectableGroup;
import com.avito.android.select.group_select.models.SelectableOption;
import com.avito.android.serp_core.R;
import com.avito.android.util.Logs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
import t6.n.h;
import t6.n.r;
import t6.y.m;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B`\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u0012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0002\u0012!\u0010#\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\"0\u001d\u0012\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\"0$¢\u0006\u0004\b&\u0010'J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0003X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006("}, d2 = {"Lcom/avito/android/inline_filters/dialog/select/GroupSelectFilterDialog;", "Lcom/avito/android/inline_filters/dialog/InlineFilterDialog;", "Landroid/os/Parcelable;", "onSaveState", "()Landroid/os/Parcelable;", "Landroid/view/View;", "c", "Landroid/view/View;", "contentView", "", "Lcom/avito/android/select/group_select/models/SelectableGroup;", "f", "Ljava/util/List;", "groups", "Lcom/avito/android/select/group_select/GroupSelectViewImpl;", "d", "Lcom/avito/android/select/group_select/GroupSelectViewImpl;", "dialogView", "Lcom/avito/android/select/group_select/GroupSelectPresenter;", "e", "Lcom/avito/android/select/group_select/GroupSelectPresenter;", "dialogPresenter", "Landroid/content/Context;", "context", "Lcom/avito/android/remote/model/search/Filter;", "inlineFilter", "Lcom/avito/android/inline_filters/dialog/select/adapter/InlineFiltersDialogItem;", "convertedItems", "state", "Lkotlin/Function1;", "Lcom/avito/android/remote/model/search/InlineFilterValue;", "Lkotlin/ParameterName;", "name", "selectedValue", "", "selectedItemListener", "Lkotlin/Function0;", "dialogCloseListener", "<init>", "(Landroid/content/Context;Lcom/avito/android/remote/model/search/Filter;Ljava/util/List;Landroid/os/Parcelable;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectFilterDialog extends InlineFilterDialog {
    @SuppressLint({"InflateParams"})
    public final View c;
    public final GroupSelectViewImpl d;
    public final GroupSelectPresenter e = new GroupSelectPresenter();
    public List<SelectableGroup> f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GroupSelectFilterDialog(@NotNull Context context, @NotNull Filter filter, @NotNull List<InlineFiltersDialogItem> list, @Nullable Parcelable parcelable, @NotNull Function1<? super InlineFilterValue, Unit> function1, @NotNull Function0<Unit> function0) {
        super(context, 0, 2, null);
        Parcelable parcelable2;
        List<Filter.OptionsGroup> list2;
        List<SelectableGroup> list3;
        Filter.Config config;
        Boolean areGroupsCollapsible;
        SelectableOption selectableOption;
        Filter.Config config2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(filter, "inlineFilter");
        Intrinsics.checkNotNullParameter(list, "convertedItems");
        Intrinsics.checkNotNullParameter(function1, "selectedItemListener");
        Intrinsics.checkNotNullParameter(function0, "dialogCloseListener");
        SelectableGroup selectableGroup = null;
        View inflate = LayoutInflater.from(context).inflate(GroupSelectView.Companion.getLayout(), (ViewGroup) null);
        Intrinsics.checkNotNullExpressionValue(inflate, "LayoutInflater.from(cont…pSelectView.layout, null)");
        this.c = inflate;
        this.d = new GroupSelectViewImpl(inflate);
        c cVar = new c(this, function0);
        BottomSheetDialog dialog = getDialog();
        dialog.setContentView(inflate, false);
        dialog.setSkipCollapsed(true);
        dialog.setFitContentPeekHeight(true);
        String title = filter.getTitle();
        dialog.setHeaderParams(title == null ? "" : title, inflate.getContext().getString(R.string.clear_inline_filter), true, true);
        dialog.setOnCloseListener(new l4(0, this, filter, cVar));
        dialog.setCanceledOnTouchOutside(true);
        dialog.setOnCancelListener(new a(this, filter, cVar));
        dialog.setOnActionClickListener(new l4(1, this, filter, cVar));
        d dVar = new d(this);
        b bVar = new b(function1, cVar);
        Filter.Widget widget = filter.getWidget();
        if (widget == null || (config2 = widget.getConfig()) == null) {
            parcelable2 = parcelable;
            list2 = null;
        } else {
            list2 = config2.getGroups();
            parcelable2 = parcelable;
        }
        GroupSelectFilterViewState groupSelectFilterViewState = (GroupSelectFilterViewState) (!(parcelable2 instanceof GroupSelectFilterViewState) ? null : parcelable2);
        if (list2 != null) {
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list, 10));
            for (T t : list) {
                arrayList.add(TuplesKt.to(t.getFilterId(), TuplesKt.to(t.getText(), Boolean.valueOf(t.getChecked()))));
            }
            Map map = r.toMap(arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (T t2 : list2) {
                List<String> groupIds = t2.getGroupIds();
                ArrayList arrayList3 = new ArrayList();
                for (T t3 : groupIds) {
                    Pair pair = (Pair) map.get(t3);
                    pair = pair == null ? TuplesKt.to("", Boolean.FALSE) : pair;
                    String str = (String) pair.component1();
                    boolean booleanValue = ((Boolean) pair.component2()).booleanValue();
                    if (!m.isBlank(str)) {
                        selectableOption = new SelectableOption(t3, str, groupSelectFilterViewState != null ? groupSelectFilterViewState.isChecked(t3) : booleanValue);
                        selectableGroup = null;
                    } else {
                        StringBuilder R = a2.b.a.a.a.R("Id ", t3, " из OptionsGroup '");
                        R.append(t2.getGroupTitle());
                        R.append("' не найден среди Options фильтра");
                        selectableOption = null;
                        Logs.warning$default("GroupSelectFilterDialog", R.toString(), null, 4, null);
                        selectableGroup = null;
                    }
                    if (selectableOption != null) {
                        arrayList3.add(selectableOption);
                    }
                }
                SelectableGroup selectableGroup2 = arrayList3.isEmpty() ^ true ? new SelectableGroup(t2.getGroupTitle(), arrayList3) : selectableGroup;
                if (selectableGroup2 != null) {
                    arrayList2.add(selectableGroup2);
                }
            }
            list3 = arrayList2;
        } else {
            list3 = CollectionsKt__CollectionsKt.emptyList();
        }
        this.f = list3;
        GroupSelectPresenter groupSelectPresenter = this.e;
        GroupSelectViewImpl groupSelectViewImpl = this.d;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groups");
        }
        Filter.Widget widget2 = filter.getWidget();
        groupSelectPresenter.bindView(groupSelectViewImpl, list3, (widget2 == null || (config = widget2.getConfig()) == null || (areGroupsCollapsible = config.getAreGroupsCollapsible()) == null) ? false : areGroupsCollapsible.booleanValue(), bVar, dVar);
    }

    @Override // com.avito.android.inline_filters.dialog.InlineFilterDialog
    @Nullable
    public Parcelable onSaveState() {
        List<SelectableGroup> list = this.f;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("groups");
        }
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            List<SelectableOption> items = it.next().getItems();
            ArrayList<SelectableOption> arrayList2 = new ArrayList();
            for (T t : items) {
                if (t.isSelected()) {
                    arrayList2.add(t);
                }
            }
            ArrayList arrayList3 = new ArrayList(e.collectionSizeOrDefault(arrayList2, 10));
            for (SelectableOption selectableOption : arrayList2) {
                arrayList3.add(selectableOption.getId());
            }
            h.addAll(arrayList, arrayList3);
        }
        Set set = CollectionsKt___CollectionsKt.toSet(arrayList);
        if (!set.isEmpty()) {
            return new GroupSelectFilterViewState(set);
        }
        return null;
    }
}
