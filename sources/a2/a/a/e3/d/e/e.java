package a2.a.a.e3.d.e;

import com.avito.android.tariff.edit_info.item.button.ButtonItem;
import com.avito.android.tariff.edit_info.item.button.EditButtonAction;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<ButtonItem, EditButtonAction> {
    public static final e a = new e();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public EditButtonAction apply(ButtonItem buttonItem) {
        ButtonItem buttonItem2 = buttonItem;
        Intrinsics.checkNotNullParameter(buttonItem2, "it");
        return buttonItem2.getEditAction();
    }
}
