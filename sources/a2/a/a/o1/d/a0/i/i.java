package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl$subscribeToReconnects$1;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.rxkotlin.DisposableKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
public final /* synthetic */ class i extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public i(MessageListInteractorImpl messageListInteractorImpl) {
        super(2, messageListInteractorImpl, MessageListInteractorImpl.class, "subscribeToReconnects", "subscribeToReconnects(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Unit invoke(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, "p1");
        Intrinsics.checkNotNullParameter(str4, "p2");
        MessageListInteractorImpl messageListInteractorImpl = (MessageListInteractorImpl) this.receiver;
        if (messageListInteractorImpl.q.size() == 0) {
            CompositeDisposable compositeDisposable = messageListInteractorImpl.q;
            Disposable subscribe = messageListInteractorImpl.u.allReconnects().observeOn(messageListInteractorImpl.getSchedulers().io()).subscribe(new MessageListInteractorImpl$subscribeToReconnects$1(messageListInteractorImpl, str3, str4));
            Intrinsics.checkNotNullExpressionValue(subscribe, "connection.allReconnects…, deps)\n                }");
            DisposableKt.plusAssign(compositeDisposable, subscribe);
        }
        return Unit.INSTANCE;
    }
}
