package com.avito.android.safedeal.delivery_courier.summary.konveyor.input;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.safedeal.R;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00109\u001a\u000208\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b:\u0010;J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0011\u0010\u0007J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J#\u0010\u0018\u001a\u00020\u00052\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00050\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001a\u0010\u0007J\u0019\u0010\u001b\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u001b\u0010\u0007J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u001c\u0010\u000fJ%\u0010\u001d\u001a\u00020\u00052\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u001d\u0010\u0019J\u000f\u0010\u001e\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u0019\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u00102R\u0016\u00107\u001a\u0002048\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106¨\u0006<"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/input/InputItemView;", "", "value", "", "setPrefix", "(Ljava/lang/String;)V", "setPostfix", "Lcom/avito/android/lib/design/input/FormatterType;", "type", "setFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "", "setText", "(Ljava/lang/CharSequence;)V", "text", "showError", "", "visible", "setClearVisible", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setTitle", "showNormal", "setHint", "setTextChangeListener", PlatformActions.HIDE_KEYBOARD, "()V", "", "lines", "setMinLines", "(I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "status", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/util/text/AttributedTextFormatter;", VKApiConst.VERSION, "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/text/TextWatcher;", "u", "Landroid/text/TextWatcher;", "textWatcher", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "inputView", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "containerView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class InputItemViewHolder extends BaseViewHolder implements InputItemView {
    public final ComponentContainer s;
    public final Input t;
    public TextWatcher u;
    public final AttributedTextFormatter v;

    public static final class a implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }
    }

    public static final class b extends Lambda implements Function2<View, Integer, Unit> {
        public static final b a = new b();

        public b() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(View view, Integer num) {
            View view2 = view;
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(view2, "$receiver");
            view2.setPadding(view2.getPaddingStart(), Views.dpToPx(view2, intValue) + view2.getPaddingTop(), view2.getPaddingEnd(), view2.getPaddingBottom());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.v = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.input_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.s = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.input);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.t = (Input) findViewById2;
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void hideKeyboard() {
        Keyboards.hideKeyboard(this.t, false);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setClearVisible(boolean z) {
        this.t.setClearButton(z);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setFormatterType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "type");
        Input.setFormatterType$default(this.t, formatterType, false, 2, null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setHint(@Nullable CharSequence charSequence) {
        this.t.setHint(charSequence);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setMinLines(int i) {
        if (i >= 1) {
            if (i == 1) {
                this.t.setSingleLine();
            } else {
                Input.setMultiLine$default(this.t, 0, i, 1, null);
            }
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setMotivation(@Nullable AttributedText attributedText) {
        ComponentContainer componentContainer = this.s;
        AttributedTextFormatter attributedTextFormatter = this.v;
        Context context = componentContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        componentContainer.setMessage(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setFocusChangeListener(new a(function1));
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setPostfix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.t.setPostfix(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setPrefix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.t.setPrefix(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setText(@Nullable CharSequence charSequence) {
        Input.setText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setTextChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.u;
        if (textWatcher != null) {
            this.t.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.t;
            InputItemViewHolder$setTextChangeListener$$inlined$addDeformattedTextChangedListener$1 inputItemViewHolder$setTextChangeListener$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemViewHolder$setTextChangeListener$$inlined$addDeformattedTextChangedListener$1
                public String a;
                public final /* synthetic */ Input b;
                public final /* synthetic */ Function1 c;

                {
                    this.b = r1;
                    this.c = r2;
                    this.a = r1.getDeformattedText();
                }

                @Override // android.text.TextWatcher
                public void afterTextChanged(@Nullable Editable editable) {
                    String deformattedText = this.b.getDeformattedText();
                    if (!Intrinsics.areEqual(deformattedText, this.a)) {
                        this.c.invoke(deformattedText);
                        this.a = deformattedText;
                    }
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(@Nullable CharSequence charSequence, int i, int i2, int i3) {
                }
            };
            input.addTextChangedListener(inputItemViewHolder$setTextChangeListener$$inlined$addDeformattedTextChangedListener$1);
            this.u = inputItemViewHolder$setTextChangeListener$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setTitle(str);
        b bVar = b.a;
        if (!(str.length() > 0) || getAdapterPosition() == 0) {
            bVar.invoke(this.s, 0);
        } else {
            bVar.invoke(this.s, 8);
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void showError(@Nullable String str) {
        this.s.showError(new int[]{this.t.getId()}, str, ComponentContainer.Condition.MANUAL);
        this.t.setState(Input.Companion.getSTATE_ERROR());
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.input.InputItemView
    public void showNormal(@Nullable String str) {
        this.s.showNormalForAll(str);
    }
}
