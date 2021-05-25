package com.avito.android.util;

import android.text.method.DigitsKeyListener;
import com.avito.android.items.InputItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.text_input.CharSequencePositionFormatterTextWatcher;
import ru.avito.component.text_input.MoneyMaskConstantsKt;
import ru.avito.component.text_input.MoneyValueFormatter;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a-\u0010\u0007\u001a\u00020\u0005*\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u00012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/util/FormattableInputView;", "Lcom/avito/android/items/InputItem;", "element", "Lkotlin/Function1;", "", "", "rawValueListener", "setupPriceTextWatcher", "(Lcom/avito/android/util/FormattableInputView;Lcom/avito/android/items/InputItem;Lkotlin/jvm/functions/Function1;)V", "item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class FormattableInputViewKt {

    public static final class a extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ InputItem a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(InputItem inputItem, Function1 function1) {
            super(1);
            this.a = inputItem;
            this.b = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "newValue");
            String prefix = this.a.getPrefix();
            String removePrefix = prefix != null ? StringsKt__StringsKt.removePrefix(str2, (CharSequence) prefix) : str2;
            String postfix = this.a.getPostfix();
            if (postfix != null) {
                removePrefix = StringsKt__StringsKt.removeSuffix(str2, (CharSequence) postfix);
            }
            Function1 function1 = this.b;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < removePrefix.length(); i++) {
                char charAt = removePrefix.charAt(i);
                if (!t6.y.a.isWhitespace(charAt)) {
                    sb.append(charAt);
                }
            }
            String sb2 = sb.toString();
            Intrinsics.checkNotNullExpressionValue(sb2, "filterNotTo(StringBuilder(), predicate).toString()");
            function1.invoke(sb2);
            return Unit.INSTANCE;
        }
    }

    public static final void setupPriceTextWatcher(@NotNull FormattableInputView formattableInputView, @NotNull InputItem inputItem, @NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(formattableInputView, "$this$setupPriceTextWatcher");
        Intrinsics.checkNotNullParameter(inputItem, "element");
        Intrinsics.checkNotNullParameter(function1, "rawValueListener");
        DigitsKeyListener instance = DigitsKeyListener.getInstance("0123456789" + inputItem.getPostfix() + MoneyMaskConstantsKt.MONEY_MASK_SPACE);
        Intrinsics.checkNotNullExpressionValue(instance, "DigitsKeyListener.getIns…fix}${MONEY_MASK_SPACE}\")");
        formattableInputView.setKeyListener(instance);
        String postfix = inputItem.getPostfix();
        if (postfix == null) {
            postfix = "";
        }
        formattableInputView.setTextWatcher(new CharSequencePositionFormatterTextWatcher(new MoneyValueFormatter(postfix, 12, true), new a(inputItem, function1)));
    }
}
