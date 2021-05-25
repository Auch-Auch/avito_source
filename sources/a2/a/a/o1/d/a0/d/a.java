package a2.a.a.o1.d.a0.d;

import arrow.core.Option;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileAttachmentException;
import com.avito.android.messenger.conversation.mvi.file_attachment.FileInfo;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleSource;
import io.reactivex.rxjava3.functions.Function;
import kotlin.jvm.internal.Intrinsics;
public final class a<T, R> implements Function<Throwable, SingleSource<? extends Option<? extends FileInfo>>> {
    public static final a a = new a();

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.rxjava3.functions.Function
    public SingleSource<? extends Option<? extends FileInfo>> apply(Throwable th) {
        Throwable th2 = th;
        Intrinsics.checkNotNullExpressionValue(th2, "t");
        return Single.error(new FileAttachmentException.ReadFileInfoException(th2));
    }
}
