package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.photo_picker.PhotoUpload;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
public final class m<T, R> implements Function<Throwable, SingleSource<? extends PhotoUpload>> {
    public final /* synthetic */ String a;
    public final /* synthetic */ PhotoUpload b;

    public m(String str, PhotoUpload photoUpload) {
        this.a = str;
        this.b = photoUpload;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends PhotoUpload> apply(Throwable th) {
        StringBuilder L = a.L("Failed to find photo upload: (");
        L.append(this.a);
        L.append(", ");
        L.append(this.b.getId());
        L.append(')');
        return Single.error(new NoRetryException(L.toString(), th));
    }
}
