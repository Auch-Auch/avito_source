package com.avito.android.messenger.service;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/messenger/service/ImageUploadStarter;", "", "", "operationId", "", "photoId", "", "uploadAfterNonRestorableError", "", "startImageUpload", "(Ljava/lang/String;Ljava/lang/Long;Z)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public interface ImageUploadStarter {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void startImageUpload$default(ImageUploadStarter imageUploadStarter, String str, Long l, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    l = null;
                }
                imageUploadStarter.startImageUpload(str, l, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startImageUpload");
        }
    }

    void startImageUpload(@NotNull String str, @Nullable Long l, boolean z);
}
