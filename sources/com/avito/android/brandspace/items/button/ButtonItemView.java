package com.avito.android.brandspace.items.button;

import android.view.View;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/brandspace/items/button/ButtonItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "value", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "bind", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "brandspace_release"}, k = 1, mv = {1, 4, 2})
public interface ButtonItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ButtonItemView buttonItemView) {
            ItemView.DefaultImpls.onUnbind(buttonItemView);
        }
    }

    void bind(@NotNull CharSequence charSequence, @NotNull View.OnClickListener onClickListener);
}
