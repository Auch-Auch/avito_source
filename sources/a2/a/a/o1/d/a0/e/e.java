package a2.a.a.o1.d.a0.e;

import a2.a.a.o1.d.a0.e.e;
import a2.a.a.o1.d.a0.e.f;
import android.net.Uri;
import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.data.MessageRepo;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileStorageHelper;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegateImpl;
import com.avito.android.util.rx3.InteropKt;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
public final class e<T, R> implements Function<File, SingleSource<? extends Option<? extends Uri>>> {
    public final /* synthetic */ f a;
    public final /* synthetic */ Call b;

    public e(f fVar, Call call) {
        this.a = fVar;
        this.b = call;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Option<? extends Uri>> apply(File file) {
        File file2 = file;
        MessageRepo access$getMessageRepo$p = FileDownloadWorkerDelegateImpl.access$getMessageRepo$p(this.a.a);
        f fVar = this.a;
        String str = fVar.b;
        String str2 = fVar.c;
        String str3 = fVar.d;
        Intrinsics.checkNotNullExpressionValue(file2, "cacheFile");
        Completable andThen = InteropKt.toV3(access$getMessageRepo$p.setFileDownloadInternalPath(str, str2, str3, file2.getPath())).andThen(Completable.fromCallable(new b(this, file2)).subscribeOn(FileDownloadWorkerDelegateImpl.access$getSchedulers$p(this.a.a).io()));
        Intrinsics.checkNotNullExpressionValue(andThen, "messageRepo.setFileDownl…                        )");
        Single<R> flatMap = andThen.toSingleDefault(Unit.INSTANCE).flatMap(new Function<Unit, SingleSource<? extends T>>(file2) { // from class: com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegateImpl$downloadFileAndCopyToExternalStorage$1$1$$special$$inlined$flatMapSingle$1
            public final /* synthetic */ File b;

            {
                this.b = r2;
            }

            public final SingleSource<? extends T> apply(Unit unit) {
                FileStorageHelper fileStorageHelper = e.this.a.a.f;
                File file3 = this.b;
                Intrinsics.checkNotNullExpressionValue(file3, "cacheFile");
                f fVar2 = e.this.a;
                return fileStorageHelper.copyFileToDownloads(file3, fVar2.f, fVar2.g);
            }
        });
        Intrinsics.checkNotNullExpressionValue(flatMap, "toSingleDefault(Unit).flatMap { singleFactory() }");
        return flatMap.flatMap(new c(this, file2)).doOnError(new d(file2));
    }
}
