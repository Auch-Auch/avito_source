package com.avito.android.delivery.suggest.konveyor.empty;

import androidx.annotation.StringRes;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/delivery/suggest/konveyor/empty/EmptyItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(I)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public interface EmptyItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull EmptyItemView emptyItemView) {
            ItemView.DefaultImpls.onUnbind(emptyItemView);
        }
    }

    void setText(@StringRes int i);
}
