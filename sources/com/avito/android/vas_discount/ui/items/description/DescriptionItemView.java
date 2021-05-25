package com.avito.android.vas_discount.ui.items.description;

import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/vas_discount/ui/items/description/DescriptionItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "", "finishDate", "showDiscountTimer", "(J)V", "hideDiscountTimer", "()V", "vas-discount_release"}, k = 1, mv = {1, 4, 2})
public interface DescriptionItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull DescriptionItemView descriptionItemView) {
            ItemView.DefaultImpls.onUnbind(descriptionItemView);
        }
    }

    void hideDiscountTimer();

    void setDescription(@NotNull String str);

    void setTitle(@NotNull String str);

    void showDiscountTimer(long j);
}
