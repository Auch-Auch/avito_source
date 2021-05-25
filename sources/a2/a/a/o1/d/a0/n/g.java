package a2.a.a.o1.d.a0.n;

import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import java.util.Objects;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
public final class g extends Lambda implements Function1<LocalMessage, String> {
    public static final g a = new g();

    public g() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public String invoke(LocalMessage localMessage) {
        LocalMessage localMessage2 = localMessage;
        Intrinsics.checkNotNullParameter(localMessage2, "message");
        MessageBody messageBody = localMessage2.body;
        Objects.requireNonNull(messageBody, "null cannot be cast to non-null type com.avito.android.remote.model.messenger.message.MessageBody.Unknown");
        MessageBody.Unknown unknown = (MessageBody.Unknown) messageBody;
        String fallbackText = unknown.getFallbackText();
        if (fallbackText == null || fallbackText.length() == 0) {
            return unknown.getType();
        }
        return null;
    }
}
