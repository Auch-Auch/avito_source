package a2.a.a.j.a;

import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.jsonrpc.client.JsonRpcCallException;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadCanceller;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.util.concurrent.TimeoutException;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.ResponseCodesKt;
import ru.avito.messenger.api.entity.ChatMessage;
public final class g<T, R> implements Function<Throwable, SingleSource<? extends ChatMessage>> {
    public final /* synthetic */ LocalMessageSenderImpl a;
    public final /* synthetic */ LocalMessage b;

    public g(LocalMessageSenderImpl localMessageSenderImpl, LocalMessage localMessage) {
        this.a = localMessageSenderImpl;
        this.b = localMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChatMessage> apply(Throwable th) {
        NoRetryException noRetryException;
        Throwable th2 = th;
        Intrinsics.checkNotNullParameter(th2, "it");
        String str = "";
        if (!(th2 instanceof JsonRpcCallException) || ResponseCodesKt.needRetryAfterError(((JsonRpcCallException) th2).getCode())) {
            if ((this.b.body instanceof MessageBody.File) && (th2 instanceof TimeoutException)) {
                MessengerFileUploadCanceller messengerFileUploadCanceller = this.a.j;
                LocalMessage localMessage = this.b;
                messengerFileUploadCanceller.cancelUpload(new UploadUniqueInfo(localMessage.localId, localMessage.userId, localMessage.channelId));
                String message = th2.getMessage();
                if (message != null) {
                    str = message;
                }
                noRetryException = new NoRetryException(str, th2);
            }
            return Single.error(th2);
        }
        String message2 = th2.getMessage();
        if (message2 != null) {
            str = message2;
        }
        noRetryException = new NoRetryException(str, th2);
        th2 = noRetryException;
        return Single.error(th2);
    }
}
