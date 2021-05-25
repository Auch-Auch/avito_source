package a2.a.a.o1.d.a0.i;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.ShowFoundMessageEvent;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class l extends Lambda implements Function0<Unit> {
    public final /* synthetic */ MessageListInteractorImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(MessageListInteractorImpl.a aVar) {
        super(0);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        if (this.a.a.n != null) {
            MessageListInteractorImpl.a aVar = this.a;
            Analytics analytics = aVar.b;
            String str = aVar.a.m;
            String str2 = this.a.a.n;
            String str3 = this.a.a.o;
            if (str3 == null) {
                str3 = "";
            }
            analytics.track(new ShowFoundMessageEvent(str, str2, str3, true, 0));
        }
        return Unit.INSTANCE;
    }
}
