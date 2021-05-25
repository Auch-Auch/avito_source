package a2.a.a.j.a;

import a2.b.a.a.a;
import arrow.core.None;
import arrow.core.Option;
import arrow.core.Some;
import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.model.ErrorType;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class i<T, R> implements Function<Option<? extends PhotoUpload>, SingleSource<? extends ChatMessage>> {
    public final /* synthetic */ LocalMessageSenderImpl a;
    public final /* synthetic */ MessageBody.LocalImage b;
    public final /* synthetic */ LocalMessage c;
    public final /* synthetic */ Scheduler d;

    public i(LocalMessageSenderImpl localMessageSenderImpl, MessageBody.LocalImage localImage, LocalMessage localMessage, Scheduler scheduler) {
        this.a = localMessageSenderImpl;
        this.b = localImage;
        this.c = localMessage;
        this.d = scheduler;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChatMessage> apply(Option<? extends PhotoUpload> option) {
        Option<? extends PhotoUpload> option2 = option;
        Intrinsics.checkNotNullParameter(option2, "option");
        if (option2 instanceof None) {
            StringBuilder L = a.L("Photo upload not found: (");
            L.append(this.b.getOperationId());
            L.append(", ");
            L.append(this.b.getUploadId());
            L.append(')');
            return Single.error(new NoRetryException(L.toString(), null, 2, null));
        } else if (option2 instanceof Some) {
            PhotoUpload photoUpload = (PhotoUpload) ((Some) option2).getT();
            if (photoUpload.getError() instanceof ErrorType.NonRestorableError) {
                StringBuilder L2 = a.L("Photo cannot be uploaded: (");
                L2.append(this.b.getOperationId());
                L2.append(", ");
                L2.append(this.b.getUploadId());
                L2.append(')');
                Single error = Single.error(new NoRetryException(L2.toString(), null, 2, null));
                Intrinsics.checkNotNullExpressionValue(error, "Single.error<ChatMessage…                        )");
                return error;
            } else if (LocalMessageSenderImpl.access$getDoesNotExist$p(this.a, photoUpload)) {
                StringBuilder L3 = a.L("Photo upload file does not exist: (");
                L3.append(this.b.getOperationId());
                L3.append(", ");
                L3.append(this.b.getUploadId());
                L3.append(')');
                Single error2 = Single.error(new NoRetryException(L3.toString(), null, 2, null));
                Intrinsics.checkNotNullExpressionValue(error2, "Single.error<ChatMessage…                        )");
                return error2;
            } else {
                LocalMessageSenderImpl localMessageSenderImpl = this.a;
                LocalMessage localMessage = this.c;
                return LocalMessageSenderImpl.access$uploadAndSendMessage(localMessageSenderImpl, localMessage.channelId, localMessage.localId, this.b.getOperationId(), photoUpload, this.d);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
