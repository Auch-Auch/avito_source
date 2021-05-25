package com.avito.android.delivery.summary.konveyor.input;

import com.avito.android.category_parameters.ParameterElement;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/delivery/summary/konveyor/input/InputItemPresenterImpl;", "Lcom/avito/android/delivery/summary/konveyor/input/InputItemPresenter;", "Lcom/avito/android/delivery/summary/konveyor/input/InputItemView;", "view", "Lcom/avito/android/category_parameters/ParameterElement$Input;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/delivery/summary/konveyor/input/InputItemView;Lcom/avito/android/category_parameters/ParameterElement$Input;I)V", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Lio/reactivex/rxjava3/functions/Consumer;", "textChangeConsumer", "<init>", "(Lio/reactivex/rxjava3/functions/Consumer;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemPresenterImpl implements InputItemPresenter {
    public final Consumer<ParameterElement.Input> a;

    public static final class a extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ InputItemView a;
        public final /* synthetic */ InputItemPresenterImpl b;
        public final /* synthetic */ ParameterElement.Input c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItemView inputItemView, InputItemPresenterImpl inputItemPresenterImpl, ParameterElement.Input input) {
            super(1);
            this.a = inputItemView;
            this.b = inputItemPresenterImpl;
            this.c = input;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Boolean bool) {
            if (bool.booleanValue()) {
                this.a.setTextChangeListener(new a2.a.a.k0.e.j0.a.a(this));
            } else {
                this.a.hideKeyboard();
                this.a.setTextChangeListener(null);
            }
            return Unit.INSTANCE;
        }
    }

    public InputItemPresenterImpl(@NotNull Consumer<ParameterElement.Input> consumer) {
        Intrinsics.checkNotNullParameter(consumer, "textChangeConsumer");
        this.a = consumer;
    }

    public void bindView(@NotNull InputItemView inputItemView, @NotNull ParameterElement.Input input, int i) {
        Intrinsics.checkNotNullParameter(inputItemView, "view");
        Intrinsics.checkNotNullParameter(input, "item");
        inputItemView.setTitle(input.getTitle());
        inputItemView.setFormatterType(input.getInputType());
        inputItemView.setHint(input.getPlaceholder());
        inputItemView.setMinLines(input.getLines());
        inputItemView.setText(input.getValue());
        if (input.getError() != null) {
            inputItemView.showError(input.getError());
        } else if (input.getMotivation() != null) {
            inputItemView.setMotivation(input.getMotivation());
        } else {
            inputItemView.showNormal(null);
        }
        inputItemView.setClearVisible(true);
        String prefix = input.getPrefix();
        if (prefix != null) {
            inputItemView.setPrefix(prefix);
        }
        String postfix = input.getPostfix();
        if (postfix != null) {
            inputItemView.setPostfix(postfix);
        }
        inputItemView.setOnFocusChangeListener(new a(inputItemView, this, input));
    }
}
