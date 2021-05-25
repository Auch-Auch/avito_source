package a2.a.a.c2.a;

import com.avito.android.profile_phones.add_phone.AddPhoneFragment;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
public final class h extends Lambda implements Function1<Boolean, Unit> {
    public final /* synthetic */ AddPhoneFragment a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(AddPhoneFragment addPhoneFragment) {
        super(1);
        this.a = addPhoneFragment;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public Unit invoke(Boolean bool) {
        AddPhoneFragment.access$getAppBarLayout$p(this.a).setExpanded(!bool.booleanValue());
        return Unit.INSTANCE;
    }
}
