package com.avito.android.blueprints;

import android.text.TextWatcher;
import android.view.View;
import androidx.annotation.DimenRes;
import com.avito.android.common.InputFormatter;
import com.avito.android.design.widget.FullWidthInputView;
import com.avito.android.item_temporary.R;
import com.avito.android.util.Keyboards;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u001b\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0003\u00100\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b1\u00102J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000f\u0010\rJ\u0017\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0011\u0010\rJ\u0019\u0010\u0013\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0013\u0010\u0007J\u0019\u0010\u0015\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0015\u0010\u0007J\u0019\u0010\u0017\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0017\u0010\u0007J#\u0010\u001a\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\nH\u0016¢\u0006\u0004\b\u001d\u0010\rJ#\u0010\u001f\u001a\u00020\u00052\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00050\u0018H\u0016¢\u0006\u0004\b\u001f\u0010\u001bJ\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0005H\u0016¢\u0006\u0004\b$\u0010%J\u0019\u0010(\u001a\u00020\u00052\b\u0010'\u001a\u0004\u0018\u00010&H\u0016¢\u0006\u0004\b(\u0010)R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/avito/android/blueprints/InputViewHolder;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/blueprints/InputItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "value", "setValue", "", "inputType", "setInputType", "(I)V", "maxLines", "setMaxLines", "minLines", "setMinLines", "error", "setError", "prefix", "setPrefix", "postfix", "setPostfix", "Lkotlin/Function1;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnValueChangeListener", "(Lkotlin/jvm/functions/Function1;)V", "labelMode", "setLabelMode", "", "setFocusChangeListener", "Landroid/text/TextWatcher;", "textWatcher", "setTextWatcher", "(Landroid/text/TextWatcher;)V", "onUnbind", "()V", "Lcom/avito/android/common/InputFormatter;", "formatter", "setFormatter", "(Lcom/avito/android/common/InputFormatter;)V", "Lcom/avito/android/design/widget/FullWidthInputView;", "s", "Lcom/avito/android/design/widget/FullWidthInputView;", "inputView", "Landroid/view/View;", "view", "sidePaddingRes", "<init>", "(Landroid/view/View;Ljava/lang/Integer;)V", "item-temporary_release"}, k = 1, mv = {1, 4, 2})
public final class InputViewHolder extends BaseViewHolder implements InputItemView {
    public final FullWidthInputView s;

    public static final class a extends Lambda implements Function2<FullWidthInputView, Boolean, Unit> {
        public final /* synthetic */ InputViewHolder a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputViewHolder inputViewHolder, Function1 function1) {
            super(2);
            this.a = inputViewHolder;
            this.b = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(FullWidthInputView fullWidthInputView, Boolean bool) {
            boolean booleanValue = bool.booleanValue();
            Intrinsics.checkNotNullParameter(fullWidthInputView, "view");
            if (!booleanValue) {
                Keyboards.hideKeyboard(this.a.s, false);
            }
            this.b.invoke(Boolean.valueOf(booleanValue));
            return Unit.INSTANCE;
        }
    }

    public static final class b extends Lambda implements Function2<FullWidthInputView, String, Unit> {
        public final /* synthetic */ Function1 a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(Function1 function1) {
            super(2);
            this.a = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(FullWidthInputView fullWidthInputView, String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(fullWidthInputView, "view");
            Intrinsics.checkNotNullParameter(str2, "newValue");
            this.a.invoke(str2);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputViewHolder(@NotNull View view, @DimenRes @Nullable Integer num) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.input_view);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.design.widget.FullWidthInputView");
        FullWidthInputView fullWidthInputView = (FullWidthInputView) findViewById;
        this.s = fullWidthInputView;
        if (num != null) {
            int dimensionPixelSize = view.getResources().getDimensionPixelSize(num.intValue());
            fullWidthInputView.setPadding(dimensionPixelSize, fullWidthInputView.getPaddingTop(), dimensionPixelSize, fullWidthInputView.getPaddingBottom());
        }
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        this.s.removeTextWatcher();
        Keyboards.hideKeyboard$default(this.s, false, 1, null);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setError(@Nullable String str) {
        this.s.setError(str);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setFocusChangeListener(@NotNull Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setFocusChangeListener(new a(this, function1));
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setFormatter(@Nullable InputFormatter inputFormatter) {
        this.s.setFormatter(inputFormatter);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setInputType(int i) {
        this.s.setInputType(i);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setLabelMode(int i) {
        this.s.setFloatingLabelMode(i);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setMaxLines(int i) {
        this.s.setMaxLines(i);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setMinLines(int i) {
        this.s.setMinLines(i);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setOnValueChangeListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.s.setChangeListener(new b(function1));
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setPostfix(@Nullable String str) {
        this.s.setPostfix(str);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setPrefix(@Nullable String str) {
        this.s.setPrefix(str);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setTextWatcher(@NotNull TextWatcher textWatcher) {
        Intrinsics.checkNotNullParameter(textWatcher, "textWatcher");
        this.s.setTextWatcher(textWatcher);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.blueprints.InputItemView
    public void setValue(@Nullable String str) {
        this.s.setValue(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InputViewHolder(View view, Integer num, int i, j jVar) {
        this(view, (i & 2) != 0 ? null : num);
    }
}
