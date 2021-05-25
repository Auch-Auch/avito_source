package a2.a.a.o1.h;

import com.avito.android.messenger.support.SupportChatFormPresenter;
import com.avito.android.messenger.support.SupportChatFormPresenterImpl;
import io.reactivex.rxjava3.functions.Function;
public final class c<T, R> implements Function<Throwable, SupportChatFormPresenter.State> {
    public final /* synthetic */ SupportChatFormPresenterImpl.SendClickedComposite.StartSupportChatMutator.a a;
    public final /* synthetic */ SupportChatFormPresenter.State b;

    public c(SupportChatFormPresenterImpl.SendClickedComposite.StartSupportChatMutator.a aVar, SupportChatFormPresenter.State state) {
        this.a = aVar;
        this.b = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.avito.android.util.Formatter */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.rxjava3.functions.Function
    public SupportChatFormPresenter.State apply(Throwable th) {
        this.a.a.g.getErrorStream().postValue(this.a.a.g.s.format(th));
        return this.b.copy(SupportChatFormPresenter.SendingState.Idle.INSTANCE);
    }
}
