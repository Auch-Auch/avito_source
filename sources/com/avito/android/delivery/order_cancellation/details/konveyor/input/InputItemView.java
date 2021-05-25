package com.avito.android.delivery.order_cancellation.details.konveyor.input;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\u0006J%\u0010\u000b\u001a\u00020\u00042\u0014\u0010\n\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00040\tH&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "hint", "setHint", "Lkotlin/Function1;", "func", "onInputChange", "(Lkotlin/jvm/functions/Function1;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface InputItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull InputItemView inputItemView) {
            ItemView.DefaultImpls.onUnbind(inputItemView);
        }
    }

    void onInputChange(@NotNull Function1<? super CharSequence, Unit> function1);

    void setHint(@Nullable CharSequence charSequence);

    void setText(@Nullable CharSequence charSequence);
}
