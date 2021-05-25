package a2.a.a.o1.d.a0.m;

import android.net.Uri;
import arrow.core.Option;
import arrow.core.OptionKt;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandler;
import com.avito.android.messenger.conversation.mvi.send.PhotoPickerResultHandlerImpl;
import com.avito.android.photo_picker.PhotoUpload;
import java.util.concurrent.Callable;
public final class a<V> implements Callable<Option<? extends PhotoPickerResultHandler.Photo>> {
    public final /* synthetic */ PhotoPickerResultHandlerImpl a;
    public final /* synthetic */ PhotoUpload b;
    public final /* synthetic */ String c;

    public a(PhotoPickerResultHandlerImpl photoPickerResultHandlerImpl, PhotoUpload photoUpload, String str) {
        this.a = photoPickerResultHandlerImpl;
        this.b = photoUpload;
        this.c = str;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.concurrent.Callable
    public Option<? extends PhotoPickerResultHandler.Photo> call() {
        Uri contentUri = this.b.getContentUri();
        if (contentUri == null) {
            return Option.Companion.empty();
        }
        Uri keep = this.a.b.keep(contentUri);
        if (keep != null) {
            this.a.a.update(this.c, this.b.newBuilder().contentUri(keep).build());
        }
        long id = this.b.getId();
        if (keep != null) {
            contentUri = keep;
        }
        return OptionKt.some(new PhotoPickerResultHandler.Photo(id, contentUri));
    }
}
