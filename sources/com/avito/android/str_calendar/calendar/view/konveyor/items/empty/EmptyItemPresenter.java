package com.avito.android.str_calendar.calendar.view.konveyor.items.empty;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemView;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItemView;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/empty/EmptyItem;I)V", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class EmptyItemPresenter implements ItemPresenter<EmptyItemView, EmptyItem> {
    public void bindView(@NotNull EmptyItemView emptyItemView, @NotNull EmptyItem emptyItem, int i) {
        Intrinsics.checkNotNullParameter(emptyItemView, "view");
        Intrinsics.checkNotNullParameter(emptyItem, "item");
        emptyItemView.bind(emptyItem.getState());
    }
}
