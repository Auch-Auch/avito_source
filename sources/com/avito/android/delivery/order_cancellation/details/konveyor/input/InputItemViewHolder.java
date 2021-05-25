package com.avito.android.delivery.order_cancellation.details.konveyor.input;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.avito.android.delivery.R;
import com.avito.android.lib.design.input.Input;
import com.avito.konveyor.adapter.BaseViewHolder;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J%\u0010\f\u001a\u00020\u00052\u0014\u0010\u000b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/delivery/order_cancellation/details/konveyor/input/InputItemView;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "hint", "setHint", "Lkotlin/Function1;", "func", "onInputChange", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/lib/design/input/Input;", "s", "Lcom/avito/android/lib/design/input/Input;", "inputView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "delivery_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemViewHolder extends BaseViewHolder implements InputItemView {
    public final Input s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputItemViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.input);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.s = (Input) findViewById;
    }

    @Override // com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemView
    public void onInputChange(@NotNull Function1<? super CharSequence, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "func");
        this.s.addTextChangedListener(new TextWatcher(function1) { // from class: com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemViewHolder$onInputChange$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
            }

            @Override // android.text.TextWatcher
            public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                this.a.invoke(charSequence);
            }
        });
    }

    @Override // com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemView
    public void setHint(@Nullable CharSequence charSequence) {
        this.s.setHint(charSequence);
    }

    @Override // com.avito.android.delivery.order_cancellation.details.konveyor.input.InputItemView
    public void setText(@Nullable CharSequence charSequence) {
        Input.setText$default(this.s, charSequence, false, 2, null);
    }
}
