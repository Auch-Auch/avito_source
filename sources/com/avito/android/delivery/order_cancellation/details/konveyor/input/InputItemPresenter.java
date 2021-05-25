package com.avito.android.delivery.order_cancellation.details.konveyor.input;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.avito.konveyor.blueprint.ItemPresenter;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\u0012\u000e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemPresenter;", "Lcom/avito/konveyor/blueprint/ItemPresenter;", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemView;", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "view", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;I)V", "Lio/reactivex/functions/Consumer;", "", AuthSource.SEND_ABUSE, "Lio/reactivex/functions/Consumer;", "inputChangeConsumer", "<init>", "(Lio/reactivex/functions/Consumer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenter implements ItemPresenter<InputItemView, ParameterElement.Input> {
    public final Consumer<CharSequence> a;

    public static final class a extends Lambda implements Function1<CharSequence, Unit> {
        public final /* synthetic */ InputItemPresenter a;
        public final /* synthetic */ ParameterElement.Input b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItemPresenter inputItemPresenter, ParameterElement.Input input) {
            super(1);
            this.a = inputItemPresenter;
            this.b = input;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(CharSequence charSequence) {
            CharSequence charSequence2 = charSequence;
            this.b.setValue(charSequence2 != null ? charSequence2.toString() : null);
            this.a.a.accept(charSequence2);
            return Unit.INSTANCE;
        }
    }

    public InputItemPresenter(@NotNull Consumer<CharSequence> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "inputChangeConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull InputItemView inputItemView, @NotNull ParameterElement.Input input, int i) {
        Intrinsics.checkNotNullParameter(inputItemView, "view");
        Intrinsics.checkNotNullParameter(input, "item");
        inputItemView.setHint(input.getPlaceholder());
        inputItemView.setText(input.getValue());
        inputItemView.onInputChange(new a(this, input));
    }
}
