package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.remote.model.messenger.message.LocalMessage;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class j<T, R> implements Function<FileUploadInteractor.FileUploadResult, SingleSource<? extends ChatMessage>> {
    public final /* synthetic */ LocalMessageSenderImpl a;
    public final /* synthetic */ LocalMessage b;

    public j(LocalMessageSenderImpl localMessageSenderImpl, LocalMessage localMessage) {
        this.a = localMessageSenderImpl;
        this.b = localMessage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChatMessage> apply(FileUploadInteractor.FileUploadResult fileUploadResult) {
        FileUploadInteractor.FileUploadResult fileUploadResult2 = fileUploadResult;
        Intrinsics.checkNotNullParameter(fileUploadResult2, "result");
        if (fileUploadResult2 instanceof FileUploadInteractor.FileUploadResult.Success) {
            return this.a.a.sendFileMessage(this.b.channelId, ((FileUploadInteractor.FileUploadResult.Success) fileUploadResult2).getFileId(), this.b.localId);
        }
        if (fileUploadResult2 instanceof FileUploadInteractor.FileUploadResult.Failed) {
            StringBuilder Q = a.Q("File message upload failed ", "userId=");
            Q.append(this.b.userId);
            Q.append(" localId=");
            Q.append(this.b.localId);
            Q.append(" channelId=");
            Q.append(this.b.channelId);
            Single error = Single.error(new NoRetryException(Q.toString(), ((FileUploadInteractor.FileUploadResult.Failed) fileUploadResult2).getException()));
            Intrinsics.checkNotNullExpressionValue(error, "Single.error<ChatMessage…                        )");
            return error;
        }
        throw new NoWhenBranchMatchedException();
    }
}
