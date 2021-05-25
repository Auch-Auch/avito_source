package a2.a.a.f.x.t.i;

import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.calculator.TinkoffCalculatorView;
import com.avito.android.lib.design.input.Input;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class e implements View.OnClickListener {
    public final /* synthetic */ TinkoffCalculatorView a;
    public final /* synthetic */ List b;

    public static final class a extends Lambda implements Function1<Integer, String> {
        public final /* synthetic */ e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(e eVar) {
            super(1);
            this.a = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(Integer num) {
            return this.a.a.formatTerm(num.intValue(), false);
        }
    }

    public static final class b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ e a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(e eVar) {
            super(1);
            this.a = eVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            this.a.a.l = intValue;
            Input input = this.a.a.i;
            if (input != null) {
                input.setTextWithoutWatcher(this.a.a.formatTerm(intValue, true));
            }
            this.a.a.getListener().onTermSelected(intValue);
            return Unit.INSTANCE;
        }
    }

    public e(TinkoffCalculatorView tinkoffCalculatorView, List list) {
        this.a = tinkoffCalculatorView;
        this.b = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getListener().onTermClicked();
        TinkoffCalculatorView tinkoffCalculatorView = this.a;
        tinkoffCalculatorView.showTermPicker(tinkoffCalculatorView.l, this.b, new a(this), new b(this));
    }
}
