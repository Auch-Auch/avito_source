package com.avito.android.short_term_rent.start_booking.items.disclaimer;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/short_term_rent/start_booking/items/disclaimer/DisclaimerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setText", "(Ljava/lang/String;)V", "short-term-rent_release"}, k = 1, mv = {1, 4, 2})
public interface DisclaimerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull DisclaimerItemView disclaimerItemView) {
            ItemView.DefaultImpls.onUnbind(disclaimerItemView);
        }
    }

    void setText(@NotNull String str);
}
