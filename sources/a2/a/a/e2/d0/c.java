package a2.a.a.e2.d0;

import com.avito.android.publish.slots.SlotsFactoryImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class c extends Lambda implements Function0<String> {
    public final /* synthetic */ SlotsFactoryImpl a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(SlotsFactoryImpl slotsFactoryImpl) {
        super(0);
        this.a = slotsFactoryImpl;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public String invoke() {
        return this.a.getPublishViewModel().getDraftId();
    }
}
