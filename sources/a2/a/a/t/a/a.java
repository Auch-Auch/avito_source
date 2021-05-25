package a2.a.a.t.a;

import com.avito.android.blueprints.input.MultiStateInputItemPresenterImpl;
import com.avito.android.items.InputItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MultiStateInputItemPresenterImpl a;
    public final /* synthetic */ InputItem b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MultiStateInputItemPresenterImpl multiStateInputItemPresenterImpl, InputItem inputItem) {
        super(0);
        this.a = multiStateInputItemPresenterImpl;
        this.b = inputItem;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.c.accept(this.b);
        return Unit.INSTANCE;
    }
}
