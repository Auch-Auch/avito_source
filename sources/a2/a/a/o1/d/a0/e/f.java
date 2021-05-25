package a2.a.a.o1.d.a0.e;

import android.net.Uri;
import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.file_download.FileDownloadWorkerDelegateImpl;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import okhttp3.Call;
public final class f<T, R> implements Function<Call, SingleSource<? extends Option<? extends Uri>>> {
    public final /* synthetic */ FileDownloadWorkerDelegateImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ String g;

    public f(FileDownloadWorkerDelegateImpl fileDownloadWorkerDelegateImpl, String str, String str2, String str3, String str4, String str5, String str6) {
        this.a = fileDownloadWorkerDelegateImpl;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Option<? extends Uri>> apply(Call call) {
        return FileDownloadWorkerDelegateImpl.access$getFileStorageHelper$p(this.a).createTempFileInInternalDownloadCacheDir().flatMap(new e(this, call));
    }
}
