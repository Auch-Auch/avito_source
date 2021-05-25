package com.avito.android.blueprints.select;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.item_temporary.R;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.Input;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fJ\u0019\u0010\u0011\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0016\u001a\u00020\u00052\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ%\u0010\u001f\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001eH\u0016¢\u0006\u0004\b\u001f\u0010 R\u0018\u0010$\u001a\u0004\u0018\u00010!8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lcom/avito/android/blueprints/select/MultiStateSelectViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/select/MultiStateSelectItemView;", "", "value", "", "setValue", "(Ljava/lang/String;)V", "title", "setTitle", InternalConstsKt.PLACEHOLDER, "setPlaceholder", "", "message", "setErrorState", "(Ljava/lang/CharSequence;)V", "setWarningState", "setNormalState", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "enabled", "setEnabled", "(Z)V", "visible", "setClearButtonVisible", "Lkotlin/Function1;", "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Landroid/text/TextWatcher;", "u", "Landroid/text/TextWatcher;", "valueChangedTextWatcher", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "t", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "componentContainer", "Lcom/avito/android/lib/design/input/Input;", "s", "Lcom/avito/android/lib/design/input/Input;", "select", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class MultiStateSelectViewHolder extends BaseViewHolder implements MultiStateSelectItemView {
    public final Input s;
    public final ComponentContainer t;
    public TextWatcher u;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiStateSelectViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.select);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.select)");
        Input input = (Input) findViewById;
        this.s = input;
        View findViewById2 = view.findViewById(R.id.container);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.container)");
        this.t = (ComponentContainer) findViewById2;
        Input.setMultiLine$default(input, 0, 0, 3, null);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.setOnClickListener(null);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setClearButtonVisible(boolean z) {
        this.s.setClearButton(z);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setErrorState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showErrorForAll$default(this.t, charSequence, null, 2, null);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setNormalState(@Nullable CharSequence charSequence) {
        this.t.showNormalForAll(charSequence);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setOnValueChangeListener(@Nullable Function1<? super String, Unit> function1) {
        TextWatcher textWatcher = this.u;
        if (textWatcher != null) {
            this.s.removeTextChangedListener(textWatcher);
        }
        if (function1 != null) {
            Input input = this.s;
            MultiStateSelectViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 multiStateSelectViewHolder$$special$$inlined$addDeformattedTextChangedListener$1 = new TextWatcher(input, function1) { // from class: com.avito.android.blueprints.select.MultiStateSelectViewHolder$$special$$inlined$addDeformattedTextChangedListener$1
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
            input.addTextChangedListener(multiStateSelectViewHolder$$special$$inlined$addDeformattedTextChangedListener$1);
            this.u = multiStateSelectViewHolder$$special$$inlined$addDeformattedTextChangedListener$1;
        }
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setPlaceholder(@Nullable String str) {
        this.s.setHint(str);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setTitle(str);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setValue(@Nullable String str) {
        Input.setText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.blueprints.select.MultiStateSelectItemView
    public void setWarningState(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "message");
        ComponentContainer.showWarningForAll$default(this.t, charSequence, null, 2, null);
    }
}
