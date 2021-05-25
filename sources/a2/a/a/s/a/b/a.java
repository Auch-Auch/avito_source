package a2.a.a.s.a.b;

import com.avito.android.beduin.ui.viewmodel.BeduinViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ BeduinViewModel a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(BeduinViewModel beduinViewModel) {
        super(0);
        this.a = beduinViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public final void invoke() {
        this.a.e.setValue(BeduinViewModel.BeduinEvent.GeneralError);
        this.a.fetchData();
    }
}
