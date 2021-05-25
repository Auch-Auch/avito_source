package a2.a.a.o1.d.a0.j;

import com.avito.android.messenger.conversation.mvi.new_messages.NewMessagesPresenterImpl;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
public final class a extends Lambda implements Function0<Unit> {
    public final /* synthetic */ NewMessagesPresenterImpl.c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(NewMessagesPresenterImpl.c cVar) {
        super(0);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // kotlin.jvm.functions.Function0
    public Unit invoke() {
        NewMessagesPresenterImpl.access$markMessagesAsRead(this.a.a);
        return Unit.INSTANCE;
    }
}
