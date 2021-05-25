package com.avito.android.shop_settings.blueprints.input.multi_line_input;

import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.avito.android.lib.design.component_container.ComponentContainer;
import com.avito.android.lib.design.input.FormatterType;
import com.avito.android.lib.design.input.Input;
import com.avito.android.service_subscription.R;
import com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010,\u001a\u00020+¢\u0006\u0004\b-\u0010.J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0019\u0010\n\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u0019\u0010\u000b\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0019\u0010\f\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\f\u0010\u0007J\u0019\u0010\r\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\r\u0010\u0007J\u0017\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0013\u0010\u0011J\u0017\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ%\u0010\u001e\u001a\u00020\u00052\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006/"}, d2 = {"Lcom/avito/android/shop_settings/blueprints/input/multi_line_input/ShopSettingsMultiLineInputItemViewImpl;", "Lcom/avito/android/shop_settings/blueprints/input/multi_line_input/ShopSettingsMultiLineInputItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "showWarning", "()V", "showError", "showNormal", "setText", "setHint", "", "isConfirmed", "setConfirmed", "(Z)V", "isEnabled", "setEnabled", "", "state", "setInputState", "([I)V", "Lcom/avito/android/lib/design/input/FormatterType;", "type", "setFormatterType", "(Lcom/avito/android/lib/design/input/FormatterType;)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setTextChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "Lcom/avito/android/lib/design/input/Input;", "t", "Lcom/avito/android/lib/design/input/Input;", "inputView", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "s", "Lcom/avito/android/lib/design/component_container/ComponentContainer;", "containerView", "u", "Lkotlin/jvm/functions/Function1;", "textChangeListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "service-subscription_release"}, k = 1, mv = {1, 4, 2})
public final class ShopSettingsMultiLineInputItemViewImpl extends BaseViewHolder implements ShopSettingsMultiLineInputItemView {
    public final ComponentContainer s;
    public final Input t;
    public Function1<? super String, Unit> u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ShopSettingsMultiLineInputItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.shop_settings_multi_line_input_container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.component_container.ComponentContainer");
        this.s = (ComponentContainer) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_settings_multi_line_input);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.input.Input");
        Input input = (Input) findViewById2;
        this.t = input;
        input.addTextChangedListener(new TextWatcher(input, this) { // from class: com.avito.android.shop_settings.blueprints.input.multi_line_input.ShopSettingsMultiLineInputItemViewImpl$$special$$inlined$addDeformattedTextChangedListener$1
            public String a;
            public final /* synthetic */ Input b;
            public final /* synthetic */ ShopSettingsMultiLineInputItemViewImpl c;

            {
                this.b = r1;
                this.c = r2;
                this.a = r1.getDeformattedText();
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(@Nullable Editable editable) {
                String deformattedText = this.b.getDeformattedText();
                if (!Intrinsics.areEqual(deformattedText, this.a)) {
                    Function1 function1 = this.c.u;
                    if (function1 != null) {
                        Unit unit = (Unit) function1.invoke(deformattedText);
                    }
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

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        ShopSettingsMultiLineInputItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setConfirmed(boolean z) {
        if (z) {
            this.t.setRightIcon(R.drawable.shop_settings_checkmark);
        } else {
            this.t.setRightIcon((Drawable) null);
        }
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setFormatterType(@NotNull FormatterType formatterType) {
        Intrinsics.checkNotNullParameter(formatterType, "type");
        Input.setFormatterType$default(this.t, formatterType, false, 2, null);
        Input.setMultiLine$default(this.t, 0, 5, 1, null);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setHint(@Nullable String str) {
        this.t.setHint(str);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setInputState(@NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "state");
        this.t.setState(iArr);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setText(@Nullable String str) {
        Input.setText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setTextChangeListener(@Nullable Function1<? super String, Unit> function1) {
        this.u = function1;
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void showError(@Nullable String str) {
        this.s.showErrorForAll(str, ComponentContainer.Condition.MANUAL);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void showNormal(@Nullable String str) {
        this.s.showNormalForAll(str);
    }

    @Override // com.avito.android.shop_settings.blueprints.input.ShopSettingsInputItemView
    public void showWarning() {
        this.s.showWarningForAll(null, ComponentContainer.Condition.MANUAL);
    }
}
