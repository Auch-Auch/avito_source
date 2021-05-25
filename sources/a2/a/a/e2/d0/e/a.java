package a2.a.a.e2.d0.e;

import com.avito.android.photo_picker.PhotoUploadKt;
import com.avito.android.remote.model.AuthResult;
import io.reactivex.rxjava3.functions.Action;
public final class a implements Action {
    public final /* synthetic */ b a;
    public final /* synthetic */ AuthResult b;

    public a(b bVar, AuthResult authResult) {
        this.a = bVar;
        this.b = authResult;
    }

    @Override // io.reactivex.rxjava3.functions.Action
    public final void run() {
        this.a.a.a.k.trackSessionUpdate(this.b.getSession(), PhotoUploadKt.UPLOAD_TYPE_PUBLISH);
    }
}
