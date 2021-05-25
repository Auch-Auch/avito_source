package com.avito.android.search.filter.groupSelect;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.search.filter.DialogDismissListener;
import com.avito.android.search.filter.FiltersChangeProvider;
import com.avito.android.select.group_select.GroupSelectPresenter;
import com.avito.android.select.group_select.GroupSelectView;
import com.avito.android.select.group_select.models.SelectableGroup;
import com.avito.android.select.group_select.models.SelectableOption;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ=\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001c"}, d2 = {"Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenterImpl;", "Lcom/avito/android/search/filter/groupSelect/GroupSelectDialogPresenter;", "Lcom/avito/android/select/group_select/GroupSelectView;", "view", "Lcom/avito/android/search/filter/DialogDismissListener;", "dismissListener", "Lkotlin/Function1;", "", "", "selectionStateListener", "Lcom/avito/android/category_parameters/ParameterElement$Multiselect;", "item", "bindView", "(Lcom/avito/android/select/group_select/GroupSelectView;Lcom/avito/android/search/filter/DialogDismissListener;Lkotlin/jvm/functions/Function1;Lcom/avito/android/category_parameters/ParameterElement$Multiselect;)V", "unbind", "()V", "Lcom/avito/android/select/group_select/GroupSelectPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/select/group_select/GroupSelectPresenter;", "groupSelectPresenter", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "changeConsumer", "Lcom/avito/android/search/filter/FiltersChangeProvider;", "changeProvider", "<init>", "(Lcom/avito/android/select/group_select/GroupSelectPresenter;Lcom/avito/android/search/filter/FiltersChangeProvider;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectDialogPresenterImpl implements GroupSelectDialogPresenter {
    public final Consumer<ParameterElement.Multiselect> a;
    public final GroupSelectPresenter b;

    public static final class a extends Lambda implements Function1<List<? extends SelectableGroup>, Unit> {
        public final /* synthetic */ GroupSelectDialogPresenterImpl a;
        public final /* synthetic */ ParameterElement.Multiselect b;
        public final /* synthetic */ DialogDismissListener c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(GroupSelectDialogPresenterImpl groupSelectDialogPresenterImpl, ParameterElement.Multiselect multiselect, DialogDismissListener dialogDismissListener) {
            super(1);
            this.a = groupSelectDialogPresenterImpl;
            this.b = multiselect;
            this.c = dialogDismissListener;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(List<? extends SelectableGroup> list) {
            List<? extends SelectableGroup> list2 = list;
            Intrinsics.checkNotNullParameter(list2, "groups");
            GroupSelectDialogPresenterImpl.access$updateValues(this.a, this.b, list2);
            this.a.a.accept(this.b);
            this.c.dismiss();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public GroupSelectDialogPresenterImpl(@NotNull GroupSelectPresenter groupSelectPresenter, @NotNull FiltersChangeProvider filtersChangeProvider) {
        Intrinsics.checkNotNullParameter(groupSelectPresenter, "groupSelectPresenter");
        Intrinsics.checkNotNullParameter(filtersChangeProvider, "changeProvider");
        this.b = groupSelectPresenter;
        this.a = filtersChangeProvider.getMultiselectChangeConsumer();
    }

    public static final void access$updateValues(GroupSelectDialogPresenterImpl groupSelectDialogPresenterImpl, ParameterElement.Multiselect multiselect, List list) {
        Objects.requireNonNull(groupSelectDialogPresenterImpl);
        List<ParameterElement.Multiselect.SelectableGroup> groups = multiselect.getGroups();
        if (groups != null) {
            Iterator<T> it = groups.iterator();
            Iterator it2 = list.iterator();
            ArrayList arrayList = new ArrayList(Math.min(e.collectionSizeOrDefault(groups, 10), e.collectionSizeOrDefault(list, 10)));
            while (it.hasNext() && it2.hasNext()) {
                List<SelectableItem> items = it.next().getItems();
                List<SelectableOption> items2 = ((SelectableGroup) it2.next()).getItems();
                Iterator<T> it3 = items.iterator();
                Iterator<T> it4 = items2.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(e.collectionSizeOrDefault(items, 10), e.collectionSizeOrDefault(items2, 10)));
                while (it3.hasNext() && it4.hasNext()) {
                    it3.next().setSelected(it4.next().isSelected());
                    arrayList2.add(Unit.INSTANCE);
                }
                arrayList.add(arrayList2);
            }
        }
    }

    @Override // com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenter
    public void bindView(@NotNull GroupSelectView groupSelectView, @NotNull DialogDismissListener dialogDismissListener, @Nullable Function1<? super Boolean, Unit> function1, @NotNull ParameterElement.Multiselect multiselect) {
        Intrinsics.checkNotNullParameter(groupSelectView, "view");
        Intrinsics.checkNotNullParameter(dialogDismissListener, "dismissListener");
        Intrinsics.checkNotNullParameter(multiselect, "item");
        List<ParameterElement.Multiselect.SelectableGroup> groups = multiselect.getGroups();
        if (!(groups == null || groups.isEmpty())) {
            a aVar = new a(this, multiselect, dialogDismissListener);
            List<ParameterElement.Multiselect.SelectableGroup> groups2 = multiselect.getGroups();
            Intrinsics.checkNotNull(groups2);
            ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(groups2, 10));
            for (T t : groups2) {
                List<SelectableItem> items = t.getItems();
                ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(items, 10));
                for (T t2 : items) {
                    arrayList2.add(new SelectableOption(t2.getStringId(), t2.getTitle(), t2.isSelected()));
                }
                arrayList.add(new SelectableGroup(t.getTitle(), arrayList2));
            }
            GroupSelectPresenter groupSelectPresenter = this.b;
            Boolean areGroupsCollapsible = multiselect.getAreGroupsCollapsible();
            groupSelectPresenter.bindView(groupSelectView, arrayList, areGroupsCollapsible != null ? areGroupsCollapsible.booleanValue() : false, aVar, function1);
        }
    }

    @Override // com.avito.android.search.filter.groupSelect.GroupSelectDialogPresenter
    public void unbind() {
        this.b.unbind();
    }
}
