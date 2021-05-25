package a2.a.a.j.a;

import a2.b.a.a.a;
import android.net.Uri;
import com.avito.android.app.task.LocalMessageSenderImpl;
import com.avito.android.photo_picker.PhotoUpload;
import com.avito.android.util.Logs;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Intrinsics;
import ru.avito.messenger.api.entity.ChatMessage;
public final class n<T> implements Consumer<ChatMessage> {
    public final /* synthetic */ o a;
    public final /* synthetic */ PhotoUpload b;

    public n(o oVar, PhotoUpload photoUpload) {
        this.a = oVar;
        this.b = photoUpload;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // io.reactivex.functions.Consumer
    public void accept(ChatMessage chatMessage) {
        LocalMessageSenderImpl localMessageSenderImpl = this.a.a;
        PhotoUpload photoUpload = this.b;
        Intrinsics.checkNotNullExpressionValue(photoUpload, "finishedUpload");
        try {
            localMessageSenderImpl.d.delete(String.valueOf(photoUpload.getId()));
            Uri contentUri = photoUpload.getContentUri();
            if (contentUri != null) {
                localMessageSenderImpl.e.delete(contentUri);
            }
        } catch (Throwable unused) {
            StringBuilder L = a.L("Failed to delete data for upload: (");
            L.append(photoUpload.getId());
            L.append(", ");
            L.append(photoUpload.getContentUri());
            L.append(") ");
            Logs.error$default(L.toString(), null, 2, null);
        }
    }
}
