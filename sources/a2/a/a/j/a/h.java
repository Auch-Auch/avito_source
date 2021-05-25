package a2.a.a.j.a;

import a2.b.a.a.a;
import arrow.core.Option;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.model.messenger.message.MessageBody;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
public final class h<T, R> implements Function<Throwable, SingleSource<? extends Option<? extends PhotoUpload>>> {
    public final /* synthetic */ MessageBody.LocalImage a;

    public h(MessageBody.LocalImage localImage) {
        this.a = localImage;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends Option<? extends PhotoUpload>> apply(Throwable th) {
        StringBuilder L = a.L("Failed to find photo upload: (");
        L.append(this.a.getOperationId());
        L.append(", ");
        L.append(this.a.getUploadId());
        L.append(')');
        return Single.error(new NoRetryException(L.toString(), th));
    }
}
