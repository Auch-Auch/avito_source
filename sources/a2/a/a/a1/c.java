package a2.a.a.a1;

import com.avito.android.bottom_navigation.KeyboardListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ KeyboardListener a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(KeyboardListener keyboardListener) {
        super(1);
        this.a = keyboardListener;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        this.a.onKeyboardVisibilityChanged(bool.booleanValue());
        return Unit.INSTANCE;
    }
}
