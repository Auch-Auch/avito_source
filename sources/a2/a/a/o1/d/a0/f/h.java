package a2.a.a.o1.d.a0.f;

import com.avito.android.analytics.Analytics;
import com.avito.android.messenger.analytics.FileUploadedEvent;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class h<T, R> implements Function<TransferStatus, FileUploadInteractor.FileUploadResult> {
    public final /* synthetic */ k a;

    public h(k kVar) {
        this.a = kVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public FileUploadInteractor.FileUploadResult apply(TransferStatus transferStatus) {
        TransferStatus transferStatus2 = transferStatus;
        Logs.debug$default("FileUploadInteractorImpl", "Upload flow has finished with status = " + transferStatus2 + ", uploadId = " + this.a.a.b, null, 4, null);
        if (transferStatus2 != TransferStatus.SUCCESS) {
            return new FileUploadInteractor.FileUploadResult.Failed(null, 1, null);
        }
        Analytics analytics = this.a.a.a.f;
        k kVar = this.a;
        String str = kVar.a.d;
        String str2 = kVar.b;
        Intrinsics.checkNotNullExpressionValue(str2, MessageBody.File.FILE_ID);
        analytics.track(new FileUploadedEvent(str, str2));
        String str3 = this.a.b;
        Intrinsics.checkNotNullExpressionValue(str3, MessageBody.File.FILE_ID);
        return new FileUploadInteractor.FileUploadResult.Success(str3);
    }
}
