package ru.avito.component.text_input;

import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010.\u001a\u00020-¢\u0006\u0004\b/\u00100J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0013\u0010\u000f\u001a\u00020\u000e*\u00020\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002XD¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R$\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R$\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000e8V@VX\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R3\u0010\b\u001a\u001f\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010\"\u001a\u00020\u00038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u001e\u0010%\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010(\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010'R\u0016\u0010,\u001a\u00020)8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b*\u0010+¨\u00061"}, d2 = {"Lru/avito/component/text_input/MoneyBigInputImpl;", "Lru/avito/component/text_input/MoneyBigInput;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "rawText", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRawInputListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "", AuthSource.SEND_ABUSE, "(Ljava/lang/CharSequence;)Ljava/lang/CharSequence;", "", "d", "C", "space", "value", "getFormattedText", "()Ljava/lang/CharSequence;", "setFormattedText", "(Ljava/lang/CharSequence;)V", "formattedText", "getRawTextValue", "setRawTextValue", "rawTextValue", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function1;", "c", "Ljava/lang/String;", "postfix", "f", "Lkotlin/jvm/functions/Function0;", "actionListener", "Landroid/widget/EditText;", "Landroid/widget/EditText;", "editText", "Lru/avito/component/text_input/MoneyValueFormatter;", "e", "Lru/avito/component/text_input/MoneyValueFormatter;", "maskFormatter", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class MoneyBigInputImpl implements MoneyBigInput {
    public final EditText a;
    public Function1<? super String, Unit> b;
    public final String c;
    public final char d = MoneyMaskConstantsKt.MONEY_MASK_SPACE;
    public final MoneyValueFormatter e;
    public Function0<Unit> f;

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ MoneyBigInputImpl a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MoneyBigInputImpl moneyBigInputImpl) {
            super(1);
            this.a = moneyBigInputImpl;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "it");
            Function1 function1 = this.a.b;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(this.a.a(str2).toString());
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b implements TextView.OnEditorActionListener {
        public final /* synthetic */ MoneyBigInputImpl a;

        public b(MoneyBigInputImpl moneyBigInputImpl) {
            this.a = moneyBigInputImpl;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 6 && (keyEvent == null || keyEvent.getAction() != 0 || keyEvent.getKeyCode() != 66)) {
                return false;
            }
            Function0 function0 = this.a.f;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
            return true;
        }
    }

    public MoneyBigInputImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        EditText editText = (EditText) view;
        this.a = editText;
        String string = view.getResources().getString(R.string.money_input_postfix);
        Intrinsics.checkNotNullExpressionValue(string, "view.resources.getString…ring.money_input_postfix)");
        this.c = string;
        MoneyValueFormatter moneyValueFormatter = new MoneyValueFormatter(string, 0, false, 6, null);
        this.e = moneyValueFormatter;
        editText.setMaxLines(1);
        editText.setInputType(2);
        editText.setKeyListener(DigitsKeyListener.getInstance("0123456789" + string + MoneyMaskConstantsKt.MONEY_MASK_SPACE));
        editText.setImeOptions(268435462);
        editText.addTextChangedListener(new CharSequencePositionFormatterTextWatcher(moneyValueFormatter, new a(this)));
        editText.setOnEditorActionListener(new b(this));
    }

    public final CharSequence a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder();
        int length = charSequence.length();
        for (int i = 0; i < length; i++) {
            char charAt = charSequence.charAt(i);
            if (Character.isDigit(charAt)) {
                sb.append(charAt);
            }
        }
        return sb;
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    @NotNull
    public CharSequence getFormattedText() {
        Editable text = this.a.getText();
        Intrinsics.checkNotNullExpressionValue(text, "editText.text");
        return text;
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    @NotNull
    public CharSequence getRawTextValue() {
        Editable text = this.a.getText();
        Intrinsics.checkNotNullExpressionValue(text, "editText.text");
        return a(text);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setActionListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f = function0;
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setFormattedText(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setRawInputListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function1;
    }

    @Override // ru.avito.component.text_input.MoneyBigInput
    public void setRawTextValue(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.a.setText(charSequence);
    }
}
