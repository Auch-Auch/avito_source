package ru.avito.component.text_input;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\t\bf\u0018\u00002\u00020\u0001J2\u0010\t\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\f\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000bH&¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0013\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0016\u001a\u00020\u000e8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012¨\u0006\u0017"}, d2 = {"Lru/avito/component/text_input/MoneyBigInput;", "", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "rawText", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRawInputListener", "(Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function0;", "setActionListener", "(Lkotlin/jvm/functions/Function0;)V", "", "getFormattedText", "()Ljava/lang/CharSequence;", "setFormattedText", "(Ljava/lang/CharSequence;)V", "formattedText", "getRawTextValue", "setRawTextValue", "rawTextValue", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface MoneyBigInput {
    @NotNull
    CharSequence getFormattedText();

    @NotNull
    CharSequence getRawTextValue();

    void setActionListener(@NotNull Function0<Unit> function0);

    void setFormattedText(@NotNull CharSequence charSequence);

    void setRawInputListener(@NotNull Function1<? super String, Unit> function1);

    void setRawTextValue(@NotNull CharSequence charSequence);
}
