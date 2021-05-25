package a2.a.a.o1.d.a0.f;

import a2.b.a.a.a;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractor;
import com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl;
import com.avito.android.messenger.conversation.mvi.file_upload.MessengerFileUploadStarter;
import com.avito.android.messenger.conversation.mvi.file_upload.UploadUniqueInfo;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.avito.android.util.Logs;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.BiFunction;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.android.persistence.messenger.TransferStatus;
public final class k<T, R> implements Function<File, SingleSource<? extends FileUploadInteractor.FileUploadResult>> {
    public final /* synthetic */ FileUploadInteractorImpl.a a;
    public final /* synthetic */ String b;

    public k(FileUploadInteractorImpl.a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends FileUploadInteractor.FileUploadResult> apply(File file) {
        File file2 = file;
        StringBuilder L = a.L("File is copied to internal storage and ready for uploadId = ");
        L.append(this.a.b);
        Logs.debug$default("FileUploadInteractorImpl", L.toString(), null, 4, null);
        MessengerFileUploadStarter access$getFileUploadStarter$p = FileUploadInteractorImpl.access$getFileUploadStarter$p(this.a.a);
        UploadUniqueInfo uploadUniqueInfo = this.a.b;
        String str = this.b;
        Intrinsics.checkNotNullExpressionValue(str, MessageBody.File.FILE_ID);
        Intrinsics.checkNotNullExpressionValue(file2, "file");
        Observable<T> andThen = access$getFileUploadStarter$p.startUpload(uploadUniqueInfo, str, file2, this.a.f).doOnComplete(new j(this)).andThen(Observable.just(TransferStatus.IN_PROGRESS));
        FileUploadInteractorImpl.a aVar = this.a;
        Observable access$observeUploadStatus = FileUploadInteractorImpl.access$observeUploadStatus(aVar.a, aVar.c, aVar.d, aVar.e);
        Intrinsics.checkNotNullExpressionValue(andThen, "startUpload");
        Observable combineLatest = Observable.combineLatest(access$observeUploadStatus, andThen, new BiFunction<T1, T2, R>() { // from class: com.avito.android.messenger.conversation.mvi.file_upload.FileUploadInteractorImpl$uploadFile$1$1$$special$$inlined$combineLatestWith$1
            /* JADX WARN: Type inference failed for: r2v1, types: [ru.avito.android.persistence.messenger.TransferStatus, R] */
            @Override // io.reactivex.rxjava3.functions.BiFunction
            public final R apply(T1 t1, T2 t2) {
                Intrinsics.checkNotNullExpressionValue(t1, "t1");
                Intrinsics.checkNotNullExpressionValue(t2, "t2");
                return t1;
            }
        });
        Intrinsics.checkNotNullExpressionValue(combineLatest, "Observable.combineLatest…ombineFunction(t1, t2) })");
        return combineLatest.filter(g.a).firstOrError().map(new h(this)).doOnError(new i(file2));
    }
}
