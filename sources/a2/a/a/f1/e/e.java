package a2.a.a.f1.e;

import com.avito.android.in_app_calls.logging.LogUploader;
import io.reactivex.rxjava3.core.CompletableSource;
import io.reactivex.rxjava3.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
public final class e<T, R> implements Function<File, CompletableSource> {
    public final /* synthetic */ LogUploader.a a;

    public e(LogUploader.a aVar) {
        this.a = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public CompletableSource apply(File file) {
        File file2 = file;
        LogUploader logUploader = this.a.a;
        Intrinsics.checkNotNullExpressionValue(file2, "compressedFile");
        return LogUploader.access$uploadAndDelete(logUploader, file2);
    }
}
