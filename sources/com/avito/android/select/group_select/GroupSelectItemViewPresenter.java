package com.avito.android.select.group_select;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.select.group_select.models.SelectableGroup;
import com.avito.android.select.group_select.models.SelectableOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0013\u001a\u00020\u0010\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b\u0012\u0006\u0010\u0016\u001a\u00020\t¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0007\u0010\u0006R$\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0004\u0018\u00010\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0016\u0010\u000f\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u000eR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectItemViewPresenter;", "", "Lcom/avito/android/select/group_select/GroupSelectItemView;", "view", "", "bindView", "(Lcom/avito/android/select/group_select/GroupSelectItemView;)V", AuthSource.SEND_ABUSE, "Lkotlin/Function1;", "", "c", "Lkotlin/jvm/functions/Function1;", "selectionChangedListener", "", "I", "selectedCount", "Lcom/avito/android/select/group_select/models/SelectableGroup;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/select/group_select/models/SelectableGroup;", Navigation.GROUP, "d", "Z", "isGroupCollapsible", "<init>", "(Lcom/avito/android/select/group_select/models/SelectableGroup;Lkotlin/jvm/functions/Function1;Z)V", "select_release"}, k = 1, mv = {1, 4, 2})
public final class GroupSelectItemViewPresenter {
    public int a;
    public final SelectableGroup b;
    public final Function1<Boolean, Unit> c;
    public final boolean d;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectableOption a;
        public final /* synthetic */ GroupSelectItemViewPresenter b;
        public final /* synthetic */ GroupSelectItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SelectableOption selectableOption, GroupSelectItemViewPresenter groupSelectItemViewPresenter, GroupSelectItemView groupSelectItemView) {
            super(1);
            this.a = selectableOption;
            this.b = groupSelectItemViewPresenter;
            this.c = groupSelectItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            this.a.setSelected(booleanValue);
            GroupSelectItemViewPresenter groupSelectItemViewPresenter = this.b;
            int i = groupSelectItemViewPresenter.a;
            groupSelectItemViewPresenter.a = booleanValue ? i + 1 : i - 1;
            Function1 function1 = this.b.c;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(Boolean.valueOf(booleanValue));
            }
            this.b.a(this.c);
            return Unit.INSTANCE;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> */
    /* JADX WARN: Multi-variable type inference failed */
    public GroupSelectItemViewPresenter(@NotNull SelectableGroup selectableGroup, @Nullable Function1<? super Boolean, Unit> function1, boolean z) {
        Intrinsics.checkNotNullParameter(selectableGroup, Navigation.GROUP);
        this.b = selectableGroup;
        this.c = function1;
        this.d = z;
    }

    public final void a(GroupSelectItemView groupSelectItemView) {
        if (this.a == this.b.getItems().size()) {
            groupSelectItemView.select(true, false);
        } else if (this.a > 0) {
            groupSelectItemView.setIndeterminate();
        } else {
            groupSelectItemView.select(false, false);
        }
    }

    public final void bindView(@NotNull GroupSelectItemView groupSelectItemView) {
        Intrinsics.checkNotNullParameter(groupSelectItemView, "view");
        groupSelectItemView.setTitle(this.b.getTitle());
        for (T t : this.b.getItems()) {
            if (t.isSelected()) {
                this.a++;
            }
            groupSelectItemView.addSelectOption(t.getTitle(), t.isSelected(), new a(t, this, groupSelectItemView));
        }
        if (!this.d || this.a != 0) {
            groupSelectItemView.setExpanded(true, false);
        } else {
            groupSelectItemView.setExpanded(false, false);
        }
        groupSelectItemView.setIsCollapsible(this.d);
        a(groupSelectItemView);
    }
}
