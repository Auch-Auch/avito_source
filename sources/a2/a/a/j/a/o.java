package a2.a.a.j.a;

import a2.b.a.a.a;
import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.app.task.NoRetryException;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.remote.model.ErrorType;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.SingleSource;
import io.reactivex.functions.Function;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class o<T, R> implements Function<PhotoUpload, SingleSource<? extends ChatMessage>> {
    public final /* synthetic */ LocalMessageSenderImpl a;
    public final /* synthetic */ String b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Scheduler d;
    public final /* synthetic */ PhotoUpload e;
    public final /* synthetic */ String f;

    public o(LocalMessageSenderImpl localMessageSenderImpl, String str, String str2, Scheduler scheduler, PhotoUpload photoUpload, String str3) {
        this.a = localMessageSenderImpl;
        this.b = str;
        this.c = str2;
        this.d = scheduler;
        this.e = photoUpload;
        this.f = str3;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Function
    public SingleSource<? extends ChatMessage> apply(PhotoUpload photoUpload) {
        PhotoUpload photoUpload2 = photoUpload;
        Intrinsics.checkNotNullParameter(photoUpload2, "finishedUpload");
        String uploadId = photoUpload2.getUploadId();
        if (uploadId != null) {
            return this.a.a.sendImageMessage(this.b, this.c, uploadId).subscribeOn(this.d).observeOn(this.d).doOnSuccess(new n(this, photoUpload2));
        }
        if (photoUpload2.getError() instanceof ErrorType.NonRestorableError) {
            return Single.error(new NoRetryException("Image upload failed", null, 2, null));
        }
        if (LocalMessageSenderImpl.access$getDoesNotExist$p(this.a, this.e)) {
            StringBuilder L = a.L("Photo upload file does not exist: (");
            L.append(this.f);
            L.append(", ");
            L.append(photoUpload2.getId());
            L.append(')');
            return Single.error(new NoRetryException(L.toString(), null, 2, null));
        } else if (photoUpload2.getError() instanceof ErrorType.RestorableError) {
            return Single.error(new IOException("Image upload failed"));
        } else {
            return Single.error(new IllegalStateException("Unexpected case"));
        }
    }
}
