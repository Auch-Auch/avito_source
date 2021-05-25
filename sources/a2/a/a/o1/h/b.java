package a2.a.a.o1.h;

import com.avito.android.messenger.support.SupportChatFormPresenter;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class b<T, R> implements Function<String, SupportChatFormPresenter.State> {
    public final /* synthetic */ SupportChatFormPresenter.State a;

    public b(SupportChatFormPresenter.State state) {
        this.a = state;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SupportChatFormPresenter.State apply(String str) {
        String str2 = str;
        SupportChatFormPresenter.State state = this.a;
        Intrinsics.checkNotNullExpressionValue(str2, "channelId");
        return state.copy(new SupportChatFormPresenter.SendingState.Success(str2));
    }
}
