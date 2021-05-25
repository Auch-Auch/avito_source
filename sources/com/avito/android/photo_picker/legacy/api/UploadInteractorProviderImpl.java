package com.avito.android.photo_picker.legacy.api;

import a2.b.a.a.a;
import com.avito.android.remote.auth.AuthSource;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u001c\u0010\u000b\u001a\u0018\u0012\t\u0012\u00070\u0002¢\u0006\u0002\b\b\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R,\u0010\u000b\u001a\u0018\u0012\t\u0012\u00070\u0002¢\u0006\u0002\b\b\u0012\t\u0012\u00070\u0004¢\u0006\u0002\b\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProviderImpl;", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractorProvider;", "", "typeId", "Lcom/avito/android/photo_picker/legacy/api/UploadInteractor;", "getUploadInteractor", "(Ljava/lang/String;)Lcom/avito/android/photo_picker/legacy/api/UploadInteractor;", "", "Lkotlin/jvm/JvmSuppressWildcards;", AuthSource.SEND_ABUSE, "Ljava/util/Map;", "interactors", "<init>", "(Ljava/util/Map;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class UploadInteractorProviderImpl implements UploadInteractorProvider {
    public final Map<String, UploadInteractor> a;

    @Inject
    public UploadInteractorProviderImpl(@NotNull Map<String, UploadInteractor> map) {
        Intrinsics.checkNotNullParameter(map, "interactors");
        this.a = map;
    }

    @Override // com.avito.android.photo_picker.legacy.api.UploadInteractorProvider
    @NotNull
    public UploadInteractor getUploadInteractor(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "typeId");
        UploadInteractor uploadInteractor = this.a.get(str);
        if (uploadInteractor != null) {
            return uploadInteractor;
        }
        throw new IllegalArgumentException(a.c3("Unexpected typeId=", str));
    }
}
