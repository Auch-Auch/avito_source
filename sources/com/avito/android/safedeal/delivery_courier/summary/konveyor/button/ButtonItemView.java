package com.avito.android.safedeal.delivery_courier.summary.konveyor.button;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/button/ButtonItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setButtonTitle", "(Ljava/lang/String;)V", "Lkotlin/Function0;", "action", "setOnButtonClickListener", "(Lkotlin/jvm/functions/Function0;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ButtonItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ButtonItemView buttonItemView) {
            ItemView.DefaultImpls.onUnbind(buttonItemView);
        }
    }

    void setButtonTitle(@NotNull String str);

    void setOnButtonClickListener(@NotNull Function0<Unit> function0);
}
