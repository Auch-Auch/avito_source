package a2.a.a.o1.d.a0.i;

import com.avito.android.messenger.conversation.mvi.messages.MessageListInteractorImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import io.reactivex.Single;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class k extends Lambda implements Function2<String, String, Single<Boolean>> {
    public final /* synthetic */ MessageListInteractorImpl.a a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(MessageListInteractorImpl.a aVar) {
        super(2);
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
    @Override // kotlin.jvm.functions.Function2
    public Single<Boolean> invoke(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkNotNullParameter(str3, ChannelContext.Item.USER_ID);
        Intrinsics.checkNotNullParameter(str4, "channelId");
        return this.a.a.t.syncPreviousPageOfMessages(str3, str4);
    }
}
