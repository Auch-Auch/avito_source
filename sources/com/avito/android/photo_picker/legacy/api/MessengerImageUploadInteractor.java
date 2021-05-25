package com.avito.android.photo_picker.legacy.api;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.Single;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.MessengerImageUploadApi;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/api/MessengerImageUploadInteractor;", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractor;", "Ljava/io/File;", "file", "Lio/reactivex/Single;", "", "uploadFile", "(Ljava/io/File;)Lio/reactivex/Single;", "Lru/avito/messenger/MessengerImageUploadApi;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/MessengerImageUploadApi;", "api", "<init>", "(Lru/avito/messenger/MessengerImageUploadApi;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class MessengerImageUploadInteractor implements UploadInteractor {
    public final MessengerImageUploadApi a;

    public MessengerImageUploadInteractor(@NotNull MessengerImageUploadApi messengerImageUploadApi) {
        Intrinsics.checkNotNullParameter(messengerImageUploadApi, "api");
        this.a = messengerImageUploadApi;
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadInteractor
    @NotNull
    public Single<String> uploadFile(@NotNull File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.a.uploadImage(file);
    }
}
