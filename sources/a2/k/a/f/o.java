package a2.k.a.f;

import android.widget.RadioGroup;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
public final class o<T> implements Consumer<Integer> {
    public final /* synthetic */ RadioGroup a;

    public o(RadioGroup radioGroup) {
        this.a = radioGroup;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(Integer num) {
        Integer num2 = num;
        if (num2 != null && num2.intValue() == -1) {
            this.a.clearCheck();
            return;
        }
        RadioGroup radioGroup = this.a;
        if (num2 == null) {
            Intrinsics.throwNpe();
        }
        radioGroup.check(num2.intValue());
    }
}
