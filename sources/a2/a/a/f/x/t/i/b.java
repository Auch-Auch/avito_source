package a2.a.a.f.x.t.i;

import android.view.View;
import com.avito.android.advert.item.dfpcreditinfo.calculator.SravniCalculatorView;
import com.avito.android.lib.design.input.Input;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class b implements View.OnClickListener {
    public final /* synthetic */ SravniCalculatorView a;
    public final /* synthetic */ List b;

    public static final class a extends Lambda implements Function1<Integer, String> {
        public final /* synthetic */ b a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar) {
            super(1);
            this.a = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public String invoke(Integer num) {
            return this.a.a.formatTerm(num.intValue(), false);
        }
    }

    /* renamed from: a2.a.a.f.x.t.i.b$b  reason: collision with other inner class name */
    public static final class C0005b extends Lambda implements Function1<Integer, Unit> {
        public final /* synthetic */ b a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0005b(b bVar) {
            super(1);
            this.a = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Integer num) {
            int intValue = num.intValue();
            this.a.a.m = intValue;
            Input input = this.a.a.i;
            if (input != null) {
                input.setTextWithoutWatcher(this.a.a.formatTerm(intValue, true));
            }
            this.a.a.getListener().onTermSelected(intValue);
            return Unit.INSTANCE;
        }
    }

    public b(SravniCalculatorView sravniCalculatorView, List list) {
        this.a = sravniCalculatorView;
        this.b = list;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.getListener().onTermClicked();
        SravniCalculatorView sravniCalculatorView = this.a;
        sravniCalculatorView.showTermPicker(sravniCalculatorView.m, this.b, new a(this), new C0005b(this));
    }
}
