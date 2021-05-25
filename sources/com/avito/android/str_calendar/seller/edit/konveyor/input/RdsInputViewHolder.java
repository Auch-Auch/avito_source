package com.avito.android.str_calendar.seller.edit.konveyor.input;

import android.view.View;
import com.avito.android.common.InputFormatter;
import com.avito.android.lib.design.deprecated.select.SelectView;
import com.avito.android.remote.model.messenger.context_actions.PlatformActions;
import com.avito.android.str_calendar.R;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b*\u0010+J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J5\u0010\u000e\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0015\u0010\u0013J\u0017\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J%\u0010\u001c\u001a\u00020\u00052\u0014\u0010\u001b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\u00050\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ#\u0010\u001e\u001a\u00020\u00052\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00050\u001aH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u001d\u0010 \u001a\u00020\u00052\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001fH\u0016¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006,"}, d2 = {"Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/str_calendar/seller/edit/konveyor/input/RdsInputItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/common/InputFormatter;", "formatter", "", "inputType", "prefix", "postfix", "initInput", "(Lcom/avito/android/common/InputFormatter;ILjava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "value", "setValue", "(Ljava/lang/String;)V", "error", "setError", "", "visible", "setClearVisible", "(Z)V", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "setOnFocusChangeListener", "Lkotlin/Function0;", "setOnClearClickListener", "(Lkotlin/jvm/functions/Function0;)V", PlatformActions.HIDE_KEYBOARD, "()V", "Lcom/avito/android/lib/design/deprecated/select/SelectView;", "s", "Lcom/avito/android/lib/design/deprecated/select/SelectView;", "inputView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "str-calendar_release"}, k = 1, mv = {1, 4, 2})
public final class RdsInputViewHolder extends BaseViewHolder implements RdsInputItemView {
    public final SelectView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RdsInputViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.input);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.deprecated.select.SelectView");
        SelectView selectView = (SelectView) findViewById;
        this.s = selectView;
        selectView.setSingleLine(true);
        selectView.inputMode();
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void hideKeyboard() {
        Keyboards.hideKeyboard(this.s, false);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void initInput(@Nullable InputFormatter inputFormatter, int i, @Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        this.s.initInput(inputFormatter, i, charSequence, null, charSequence2, null);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setClearVisible(boolean z) {
        this.s.setClearVisible(z);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setError(@Nullable String str) {
        this.s.setError(str);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setOnClearClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnClearClickListener(new SelectView.ClearClickListener(function0) { // from class: com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputViewHolder$setOnClearClickListener$1
            public final /* synthetic */ Function0 a;

            {
                this.a = r1;
            }

            @Override // kotlin.jvm.functions.Function0
            public void invoke() {
                this.a.invoke();
            }
        });
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setOnFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnFocusChangeListener(new SelectView.FocusChangeListener(function1) { // from class: com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputViewHolder$setOnFocusChangeListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public void invoke(boolean z) {
                this.a.invoke(Boolean.valueOf(z));
            }
        });
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setOnChangeListener(new SelectView.ChangeListener(function1) { // from class: com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputViewHolder$setOnValueChangeListener$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke(str);
                return Unit.INSTANCE;
            }

            public void invoke(@NotNull String str) {
                Intrinsics.checkNotNullParameter(str, "value");
                this.a.invoke(str);
            }
        });
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        int lastIndexOf$default = StringsKt__StringsKt.lastIndexOf$default(charSequence, ',', 0, false, 6, (Object) null);
        this.s.initField(charSequence, null, lastIndexOf$default < StringsKt__StringsKt.getLastIndex(charSequence) ? StringsKt__StringsKt.trim(charSequence.subSequence(lastIndexOf$default + 1, charSequence.length())) : null);
    }

    @Override // com.avito.android.str_calendar.seller.edit.konveyor.input.RdsInputItemView
    public void setValue(@Nullable String str) {
        this.s.setValue(str);
    }
}
