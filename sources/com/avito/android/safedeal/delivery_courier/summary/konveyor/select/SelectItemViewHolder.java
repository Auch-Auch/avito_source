package com.avito.android.safedeal.delivery_courier.summary.konveyor.select;

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
import com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemView;
import com.avito.android.util.Keyboards;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u00108\u001a\u000207\u0012\u0006\u00102\u001a\u00020/¢\u0006\u0004\b9\u0010:J\u001d\u0010\u0006\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u0015\u0010\u000bJ\u0017\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J#\u0010\u001b\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00040\u001aH\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001d\u0010\u000bJ\u0019\u0010\u001e\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\u001e\u0010\u000bJ\u0019\u0010\u001f\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u0013J%\u0010 \u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b \u0010\u001cJ\u000f\u0010!\u001a\u00020\u0004H\u0016¢\u0006\u0004\b!\u0010\"J\u0017\u0010%\u001a\u00020\u00042\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u0019\u0010)\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105¨\u0006;"}, d2 = {"Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemViewHolder;", "Lcom/avito/android/safedeal/delivery_courier/summary/konveyor/select/SelectItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "value", "setPrefix", "(Ljava/lang/String;)V", "setPostfix", "Lcom/avito/android/lib/design/input/FormatterType;", "type", "setFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "", "setText", "(Ljava/lang/CharSequence;)V", "text", "showError", "", "visible", "setClearVisible", "(Z)V", "Lkotlin/Function1;", "setOnFocusChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setTitle", "showNormal", "setHint", "setTextChangeListener", PlatformActions.HIDE_KEYBOARD, "()V", "", "lines", "setMinLines", "(I)V", "Lcom/avito/android/remote/model/text/AttributedText;", "status", "setMotivation", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "selectView", "Lcom/avito/android/util/text/AttributedTextFormatter;", "u", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "containerView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "safedeal_release"}, k = 1, mv = {1, 4, 2})
public final class SelectItemViewHolder extends BaseViewHolder implements SelectItemView {
    public final ComponentContainer s;
    public final Input t;
    public final AttributedTextFormatter u;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public static final class b implements View.OnFocusChangeListener {
        public final /* synthetic */ Function1 a;

        public b(Function1 function1) {
            this.a = function1;
        }

        @Override // android.view.View.OnFocusChangeListener
        public final void onFocusChange(View view, boolean z) {
            this.a.invoke(Boolean.valueOf(z));
        }
    }

    public static final class c extends Lambda implements Function2<View, Integer, Unit> {
        public static final c a = new c();

        public c() {
            super(2);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(View view, Integer num) {
            View view2 = view;
            int intValue = num.intValue();
            Intrinsics.checkNotNullParameter(view2, "$receiver");
            view2.setPadding(view2.getPaddingStart(), Views.dpToPx(view2, intValue), view2.getPaddingEnd(), view2.getPaddingBottom());
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectItemViewHolder(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.u = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.select_item_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.s = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.select_item);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        this.t = (Input) findViewById2;
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void hideKeyboard() {
        Keyboards.hideKeyboard(this.t, false);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        SelectItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setClearVisible(boolean z) {
        this.t.setClearButton(z);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setFormatterType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "type");
        Input.setFormatterType$default(this.t, formatterType, false, 2, null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setHint(@Nullable CharSequence charSequence) {
        this.t.setHint(charSequence);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setMinLines(int i) {
        if (i >= 1) {
            if (i == 1) {
                this.t.setSingleLine();
            } else {
                Input.setMultiLine$default(this.t, 0, i, 1, null);
            }
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setMotivation(@Nullable AttributedText attributedText) {
        ComponentContainer componentContainer = this.s;
        AttributedTextFormatter attributedTextFormatter = this.u;
        Context context = componentContainer.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "containerView.context");
        componentContainer.setMessage(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setFocusChangeListener(new b(function1));
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setPostfix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.t.setPostfix(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setPrefix(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.t.setPrefix(str);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setText(@Nullable CharSequence charSequence) {
        Input.setText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setTextChangeListener(@Nullable Function1<? super String, Unit> function1) {
        if (function1 != null) {
            Input input = this.t;
            input.addTextChangedListener(new TextWatcher(input, function1) { // from class: com.avito.android.safedeal.delivery_courier.summary.konveyor.select.SelectItemViewHolder$$special$$inlined$addDeformattedTextChangedListener$1
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
            });
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setTitle(str);
        c cVar = c.a;
        if (!(str.length() > 0) || getAdapterPosition() == 0) {
            cVar.invoke(this.s, 0);
        } else {
            cVar.invoke(this.s, 8);
        }
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void showError(@Nullable String str) {
        this.s.showErrorForAll(str, ComponentContainer.Condition.MANUAL);
    }

    @Override // com.avito.android.safedeal.delivery_courier.order_update.konveyor.input.InputItemView
    public void showNormal(@Nullable String str) {
        this.s.showNormalForAll(str);
    }
}
