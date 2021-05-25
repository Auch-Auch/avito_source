package com.avito.android.str_calendar.calendar.view.konveyor.items.month;

import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemView;", "Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItem;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItemView;Lcom/avito/android/str_calendar/calendar/view/konveyor/items/month/MonthItem;I)V", "<init>", "()V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class MonthItemPresenter implements ItemPresenter<MonthItemView, MonthItem> {
    public void bindView(@NotNull MonthItemView monthItemView, @NotNull MonthItem monthItem, int i) {
        Intrinsics.checkNotNullParameter(monthItemView, "view");
        Intrinsics.checkNotNullParameter(monthItem, "item");
        StringBuilder sb = new StringBuilder();
        String text = monthItem.getText();
        Objects.requireNonNull(text, "null cannot be cast to non-null type java.lang.String");
        String substring = text.substring(0, 1);
        Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        Objects.requireNonNull(substring, "null cannot be cast to non-null type java.lang.String");
        String upperCase = substring.toUpperCase();
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase()");
        sb.append(upperCase);
        String text2 = monthItem.getText();
        Objects.requireNonNull(text2, "null cannot be cast to non-null type java.lang.String");
        String substring2 = text2.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring2, "(this as java.lang.String).substring(startIndex)");
        sb.append(substring2);
        monthItemView.setText(sb.toString());
    }
}
