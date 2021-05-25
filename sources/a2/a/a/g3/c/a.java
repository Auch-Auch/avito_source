package a2.a.a.g3.c;

import com.avito.android.component.radio_button.RadioButton;
import com.avito.android.items.SelectableItem;
import com.avito.android.ui.widget.InlineSelectView;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function2<RadioButton, Boolean, Unit> {
    public final /* synthetic */ InlineSelectView a;
    public final /* synthetic */ RadioButton b;
    public final /* synthetic */ Function2 c;
    public final /* synthetic */ SelectableItem d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(InlineSelectView inlineSelectView, RadioButton radioButton, Function2 function2, SelectableItem selectableItem) {
        super(2);
        this.a = inlineSelectView;
        this.b = radioButton;
        this.c = function2;
        this.d = selectableItem;
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
