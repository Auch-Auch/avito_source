package com.avito.android.safedeal.delivery_type.items.button;

import com.avito.android.safedeal.delivery_type.ButtonClickListener;
import com.avito.android.safedeal.remote.model.OrderType;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/safedeal/delivery_type/items/button/ButtonView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/safedeal/remote/model/OrderType;", "data", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/safedeal/delivery_type/ButtonClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setButton", "(Lcom/avito/android/safedeal/remote/model/OrderType;Lcom/avito/android/util/text/AttributedTextFormatter;Lcom/avito/android/safedeal/delivery_type/ButtonClickListener;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public interface ButtonView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ButtonView buttonView) {
            ItemView.DefaultImpls.onUnbind(buttonView);
        }
    }

    void setButton(@NotNull OrderType orderType, @NotNull AttributedTextFormatter attributedTextFormatter, @NotNull ButtonClickListener buttonClickListener);
}
