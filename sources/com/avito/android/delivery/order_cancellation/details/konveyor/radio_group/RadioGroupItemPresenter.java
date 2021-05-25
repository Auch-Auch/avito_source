package com.avito.android.delivery.order_cancellation.details.konveyor.radio_group;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.items.SelectableItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001f\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\r\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/order_cancellation/details/konveyor/radio_group/RadioGroupItemView;Lcom/avito/android/category_parameters/ParameterElement$Select$Flat;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Integer;", "selectedRadioButtonId", "Lio/reactivex/functions/Consumer;", "Lcom/avito/android/category_parameters/ParameterElement$Select;", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "changeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;Ljava/lang/Integer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class RadioGroupItemPresenter implements ItemPresenter<RadioGroupItemView, ParameterElement.Select.Flat> {
    public final Consumer<ParameterElement.Select> a;
    public final Integer b;

    public static final class a extends Lambda implements Function2<SelectableItem, Boolean, Unit> {
        public final /* synthetic */ RadioGroupItemPresenter a;
        public final /* synthetic */ ParameterElement.Select.Flat b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(RadioGroupItemPresenter radioGroupItemPresenter, ParameterElement.Select.Flat flat) {
            super(2);
            this.a = radioGroupItemPresenter;
            this.b = flat;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(SelectableItem selectableItem, Boolean bool) {
            SelectableItem selectableItem2 = selectableItem;
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(selectableItem2, "value");
            if (booleanValue) {
                this.b.setSelectedValue(selectableItem2);
                this.a.a.accept(this.b);
            }
            return Unit.INSTANCE;
        }
    }

    public RadioGroupItemPresenter(@NotNull Consumer<ParameterElement.Select> consumer, @Nullable Integer num) {
        Intrinsics.checkNotNullParameter(consumer, "changeConsumer");
        this.a = consumer;
        this.b = num;
    }

    public void bindView(@NotNull RadioGroupItemView radioGroupItemView, @NotNull ParameterElement.Select.Flat flat, int i) {
        Intrinsics.checkNotNullParameter(radioGroupItemView, "view");
        Intrinsics.checkNotNullParameter(flat, "item");
        radioGroupItemView.setValues(flat.getValues(), flat.getSelectedValue(), new a(this, flat));
        Integer num = this.b;
        if (num != null) {
            radioGroupItemView.check(num.intValue());
        }
    }
}
