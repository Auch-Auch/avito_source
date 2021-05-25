package com.avito.android.cart.summary.konveyor.product;

import com.avito.android.remote.cart.model.Store;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.rambler.libs.swipe_layout.SwipeLayout;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b`\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\f\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H&¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0017\u0010\u0015J\u0019\u0010\u0018\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H&¢\u0006\u0004\b\u0018\u0010\u0015J\u001d\u0010\u0019\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0019\u0010\u0006J\u0017\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001aH&¢\u0006\u0004\b\u001c\u0010\u001dJ\u001d\u0010\u001e\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u001e\u0010\u0006J\u001d\u0010\u001f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u001f\u0010\u0006J\u001d\u0010 \u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b \u0010\u0006J#\u0010#\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030!H&¢\u0006\u0004\b#\u0010$J#\u0010%\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030!H&¢\u0006\u0004\b%\u0010$¨\u0006&"}, d2 = {"Lcom/avito/android/cart/summary/konveyor/product/ProductItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnDeleteClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lru/rambler/libs/swipe_layout/SwipeLayout$OnSwipeListener;", "setSwipeListener", "(Lru/rambler/libs/swipe_layout/SwipeLayout$OnSwipeListener;)V", "Lcom/avito/android/remote/model/Image;", "img", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/remote/model/text/AttributedText;", "price", "setPrice", "(Lcom/avito/android/remote/model/text/AttributedText;)V", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "setItemsLeft", "setPricePerPiece", "setOnLongClickListener", "Lcom/avito/android/remote/cart/model/Store$Item$Stepper;", "stepper", "setStepper", "(Lcom/avito/android/remote/cart/model/Store$Item$Stepper;)V", "setOnStepperMinusClickListener", "setOnStepperPlusClickListener", "setOnStepperValueClickListener", "Lkotlin/Function1;", "", "setOnStepperValueChangesListener", "(Lkotlin/jvm/functions/Function1;)V", "setOnPickerValueSelectedListener", "cart_release"}, k = 1, mv = {1, 4, 2})
public interface ProductItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ProductItemView productItemView) {
            ItemView.DefaultImpls.onUnbind(productItemView);
        }
    }

    void setImage(@Nullable Image image);

    void setItemsLeft(@Nullable AttributedText attributedText);

    void setOnDeleteClickListener(@NotNull Function0<Unit> function0);

    void setOnLongClickListener(@NotNull Function0<Unit> function0);

    void setOnPickerValueSelectedListener(@NotNull Function1<? super Integer, Unit> function1);

    void setOnStepperMinusClickListener(@NotNull Function0<Unit> function0);

    void setOnStepperPlusClickListener(@NotNull Function0<Unit> function0);

    void setOnStepperValueChangesListener(@NotNull Function1<? super Integer, Unit> function1);

    void setOnStepperValueClickListener(@NotNull Function0<Unit> function0);

    void setPrice(@NotNull AttributedText attributedText);

    void setPricePerPiece(@Nullable AttributedText attributedText);

    void setStepper(@NotNull Store.Item.Stepper stepper);

    void setSwipeListener(@NotNull SwipeLayout.OnSwipeListener onSwipeListener);

    void setTitle(@NotNull String str);
}
