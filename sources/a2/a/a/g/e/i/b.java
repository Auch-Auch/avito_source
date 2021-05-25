package a2.a.a.g.e.i;

import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.button.Button;
import io.reactivex.rxjava3.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class b<T> implements Consumer<CharSequence> {
    public final /* synthetic */ Button a;

    public b(Button button) {
        this.a = button;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Consumer
    public void accept(CharSequence charSequence) {
        CharSequence charSequence2 = charSequence;
        Button button = this.a;
        Intrinsics.checkNotNullExpressionValue(button, PhonePageSourceKt.PHONE_SOURCE_BUTTON);
        Intrinsics.checkNotNullExpressionValue(charSequence2, "it");
        button.setEnabled(charSequence2.length() > 0);
    }
}
