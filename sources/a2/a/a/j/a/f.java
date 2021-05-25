package a2.a.a.j.a;

import com.avito.android.app.task.EmptyChatsCleanerImpl;
import com.avito.android.remote.model.messenger.context.ChannelContext;
import com.avito.android.util.LogsT;
import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
public final class f<T, R> implements Function<List<? extends String>, CompletableSource> {
    public final /* synthetic */ EmptyChatsCleanerImpl.a a;
    public final /* synthetic */ String b;

    public f(EmptyChatsCleanerImpl.a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: com.avito.android.messenger.conversation.mvi.data.MessageRepoWriter */
    /* JADX DEBUG: Multi-variable search result rejected for r0v6, resolved type: com.avito.android.messenger.channels.mvi.data.ChannelRepo */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(List<? extends String> list) {
        List<? extends String> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "idsOfChannelsToDelete");
        LogsT.verbose$default("EmptyChatsCleaner", "idsOfChannelsToDelete = " + list2, null, 4, null);
        EmptyChatsCleanerImpl emptyChatsCleanerImpl = this.a.a;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(str, ChannelContext.Item.USER_ID);
        if (!list2.isEmpty()) {
            Completable andThen = emptyChatsCleanerImpl.d.deleteMessagesWithChannelIds(str, list2).andThen(emptyChatsCleanerImpl.e.deleteChannelsById(str, list2));
            Intrinsics.checkNotNullExpressionValue(andThen, "messageRepo.deleteMessag…, idsOfChannelsToDelete))");
            return andThen;
        }
        Completable complete = Completable.complete();
        Intrinsics.checkNotNullExpressionValue(complete, "Completable.complete()");
        return complete;
    }
}
