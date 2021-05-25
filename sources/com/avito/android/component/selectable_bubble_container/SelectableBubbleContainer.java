package com.avito.android.component.selectable_bubble_container;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001aJ\u001d\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH&¢\u0006\u0004\b\u0010\u0010\u000fJ+\u0010\u0013\u001a\u00020\u00052\u001a\u0010\u0012\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\fH&¢\u0006\u0004\b\u0015\u0010\u0016J%\u0010\u0018\u001a\u00020\u00052\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0017H&¢\u0006\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer;", "", "", "Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer$Item;", "items", "", "setItems", "(Ljava/util/List;)V", "", "title", "setTitle", "(Ljava/lang/String;)V", "", VKApiConst.POSITION, "setSelectedItem", "(I)V", "scrollToPosition", "Lkotlin/Function2;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setSelectedItemListener", "(Lkotlin/jvm/functions/Function2;)V", "getSelectedPosition", "()I", "Lkotlin/Function1;", "setOnScrollPositionChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Item", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface SelectableBubbleContainer {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001R\u0016\u0010\u0005\u001a\u00020\u00028&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/component/selectable_bubble_container/SelectableBubbleContainer$Item;", "", "", "getTitle", "()Ljava/lang/String;", "title", "", "getId", "()J", "id", "ui-components_release"}, k = 1, mv = {1, 4, 2})
    public interface Item {
        long getId();

        @NotNull
        String getTitle();
    }

    int getSelectedPosition();

    void scrollToPosition(int i);

    void setItems(@NotNull List<? extends Item> list);

    void setOnScrollPositionChangeListener(@Nullable Function1<? super Integer, Unit> function1);

    void setSelectedItem(int i);

    void setSelectedItemListener(@Nullable Function2<? super Integer, ? super Item, Unit> function2);

    void setTitle(@NotNull String str);
}
