package a2.a.a.c2.f;

import com.avito.android.profile_phones.phones_list.PhonesListFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class f extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PhonesListFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(PhonesListFragment phonesListFragment) {
        super(0);
        this.a = phonesListFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        PhonesListFragment.access$getPhonesListViewModel$p(this.a).refresh();
        return Unit.INSTANCE;
    }
}
