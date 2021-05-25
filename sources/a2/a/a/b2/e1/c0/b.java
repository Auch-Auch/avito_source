package a2.a.a.b2.e1.c0;

import com.avito.http.FileUtils;
import io.reactivex.functions.Function;
import java.io.File;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
public final class b<T, R> implements Function<File, MultipartBody.Part> {
    public static final b a = new b();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public MultipartBody.Part apply(File file) {
        File file2 = file;
        Intrinsics.checkNotNullParameter(file2, "it");
        return FileUtils.convertToImageMultipart$default(file2, null, null, 3, null);
    }
}
