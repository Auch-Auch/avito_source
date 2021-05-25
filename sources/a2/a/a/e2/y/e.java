package a2.a.a.e2.y;

import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.publish.premoderation.SelectListWidget;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class e extends Lambda implements Function2<RadioButton, Boolean, Unit> {
    public final /* synthetic */ SelectListWidget a;
    public final /* synthetic */ RadioButton b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ SelectListWidget.Data d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(SelectListWidget selectListWidget, RadioButton radioButton, Function2 function2, SelectListWidget.Data data) {
        super(2);
        this.a = selectListWidget;
        this.b = radioButton;
        this.c = function2;
        this.d = data;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(RadioButton radioButton, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        Intrinsics.checkNotNullParameter(radioButton, "<anonymous parameter 0>");
        RadioButton radioButton2 = this.a.b;
        if (radioButton2 != null) {
            radioButton2.setChecked(false);
        }
        if (booleanValue) {
            this.a.b = this.b;
        }
        this.c.invoke(this.d, Boolean.valueOf(booleanValue));
        return Unit.INSTANCE;
    }
}
