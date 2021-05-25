package a2.a.a.o1.d.a0.n;

import com.avito.android.messenger.conversation.mvi.sync.MissingUsersSyncAgentImpl;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import t6.n.e;
public final class e0<T, R> implements Function<MissingUsersSyncAgentImpl.RequestMissingUsers, Pair<? extends String, ? extends Set<? extends String>>> {
    public final /* synthetic */ m0 a;

    public e0(m0 m0Var) {
        this.a = m0Var;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public Pair<? extends String, ? extends Set<? extends String>> apply(MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers) {
        boolean z;
        MissingUsersSyncAgentImpl.RequestMissingUsers requestMissingUsers2 = requestMissingUsers;
        Intrinsics.checkNotNullParameter(requestMissingUsers2, "request");
        List<LocalMessage> messages = requestMissingUsers2.getMessages();
        ArrayList arrayList = new ArrayList();
        for (T t : messages) {
            T t2 = t;
            MessageBody messageBody = t2.body;
            boolean z2 = true;
            if ((messageBody instanceof MessageBody.ItemReference) || (messageBody instanceof MessageBody.Item) || (messageBody instanceof MessageBody.LocalImage) || (messageBody instanceof MessageBody.ImageReference) || (messageBody instanceof MessageBody.ImageBody) || (messageBody instanceof MessageBody.Link) || (messageBody instanceof MessageBody.Location) || (messageBody instanceof MessageBody.Text.Regular) || (messageBody instanceof MessageBody.File) || (messageBody instanceof MessageBody.Text.Reaction) || (messageBody instanceof MessageBody.Call) || (messageBody instanceof MessageBody.AppCall) || (messageBody instanceof MessageBody.Deleted) || (messageBody instanceof MessageBody.Unknown) || (messageBody instanceof MessageBody.SystemMessageBody.Platform.FromUser)) {
                z = true;
            } else if (!(messageBody instanceof MessageBody.SystemMessageBody.Platform.FromAvito) && !(messageBody instanceof MessageBody.SystemMessageBody.Platform.Bubble) && !(messageBody instanceof MessageBody.SystemMessageBody.Text) && !(messageBody instanceof MessageBody.SystemMessageBody.Unknown)) {
                throw new NoWhenBranchMatchedException();
            } else {
                z = false;
            }
            if (!z || Intrinsics.areEqual(t2.fromId, t2.userId)) {
                z2 = false;
            }
            if (z2) {
                arrayList.add(t);
            }
        }
        ArrayList arrayList2 = new ArrayList(e.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(((LocalMessage) it.next()).fromId);
        }
        Set set = CollectionsKt___CollectionsKt.toSet(arrayList2);
        String tag = this.a.a.getTAG();
        Logs.debug$default(tag, "Filtering users. Keep only unique without myself = " + set, null, 4, null);
        return TuplesKt.to(requestMissingUsers2.getChannelId(), set);
    }
}
