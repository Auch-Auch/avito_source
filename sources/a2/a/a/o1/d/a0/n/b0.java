package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.MessengerEntityConverter;
import com.avito.android.messenger.channels.mvi.data.UserRepo;
import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.util.Logs;
import io.reactivex.CompletableSource;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChannelUser;
import t6.n.e;
public final class b0<T, R> implements Function<List<? extends ChannelUser>, CompletableSource> {
    public final /* synthetic */ MissingUsersSyncAgentImpl.RequestMissingUsersAction.a a;

    public b0(MissingUsersSyncAgentImpl.RequestMissingUsersAction.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public CompletableSource apply(List<? extends ChannelUser> list) {
        List<? extends ChannelUser> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "receivedMissedUsers");
        String tag = this.a.a.g.getTAG();
        Logs.debug$default(tag, "users received = " + list2, null, 4, null);
        UserRepo userRepo = this.a.a.g.t;
        String userId = this.a.a.getUserId();
        String channelId = this.a.a.getChannelId();
        MessengerEntityConverter messengerEntityConverter = this.a.a.g.s;
        ArrayList arrayList = new ArrayList(e.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(messengerEntityConverter.convertUser(it.next()));
        }
        return userRepo.insertUsers(userId, channelId, arrayList);
    }
}
