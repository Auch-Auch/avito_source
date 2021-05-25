package a2.a.a.o1.d.a0.n;

import com.avito.android.remote.model.messenger.message.MessageBody;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import ru.avito.messenger.api.entity.body.item.BodyItem;
public final class b extends Lambda implements Function1<BodyItem, MessageBody.Item> {
    public final /* synthetic */ c a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(c cVar) {
        super(1);
        this.a = cVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public MessageBody.Item invoke(BodyItem bodyItem) {
        BodyItem bodyItem2 = bodyItem;
        Intrinsics.checkNotNullParameter(bodyItem2, "it");
        MessageBody convertBody = this.a.b.b.convertBody(bodyItem2);
        if (!(convertBody instanceof MessageBody.Item)) {
            convertBody = null;
        }
        return (MessageBody.Item) convertBody;
    }
}
