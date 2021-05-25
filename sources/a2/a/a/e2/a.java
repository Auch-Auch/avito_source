package a2.a.a.e2;

import com.avito.android.publish.PublishActivity;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ PublishActivity a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(PublishActivity publishActivity) {
        super(0);
        this.a = publishActivity;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        this.a.finish();
        return Unit.INSTANCE;
    }
}
