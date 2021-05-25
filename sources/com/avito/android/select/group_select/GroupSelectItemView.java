package com.avito.android.select.group_select;

import com.avito.android.lib.design.toggle.State;
import com.avito.android.search.map.view.PanelStateKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\f\u001a\u00020\u00042\u0014\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ3\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH&¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000eH&¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u000eH&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/select/group_select/GroupSelectItemView;", "Lcom/avito/android/select/group_select/SelectableView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "setIndeterminate", "()V", "Lkotlin/Function1;", "Lcom/avito/android/lib/design/toggle/State;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectionStateListener", "(Lkotlin/jvm/functions/Function1;)V", "", "isSelected", "selectionListener", "addSelectOption", "(Ljava/lang/String;ZLkotlin/jvm/functions/Function1;)V", "notify", "select", "(ZZ)V", PanelStateKt.PANEL_EXPANDED, "animate", "setExpanded", "isCollapsible", "setIsCollapsible", "(Z)V", "select_release"}, k = 1, mv = {1, 4, 2})
public interface GroupSelectItemView extends SelectableView {
    void addSelectOption(@NotNull String str, boolean z, @NotNull Function1<? super Boolean, Unit> function1);

    @Override // com.avito.android.select.group_select.SelectableView
    void select(boolean z, boolean z2);

    void setExpanded(boolean z, boolean z2);

    void setIndeterminate();

    void setIsCollapsible(boolean z);

    void setSelectionStateListener(@Nullable Function1<? super State, Unit> function1);

    void setTitle(@Nullable String str);
}
