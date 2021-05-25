package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J+\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\b\u0010\tJ+\u0010\n\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\t¨\u0006\u000b"}, d2 = {"Lcom/avito/android/DealProofsIntentFactory;", "", "", "operationId", "", "maxPhotoCount", "selectedPhotoId", "Landroid/content/Intent;", "createPhotoPickerIntentForRatingsFiles", "(Ljava/lang/String;ILjava/lang/String;)Landroid/content/Intent;", "createPhotoPickerIntentForRatingImages", "core_release"}, k = 1, mv = {1, 4, 2})
public interface DealProofsIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent createPhotoPickerIntentForRatingImages$default(DealProofsIntentFactory dealProofsIntentFactory, String str, int i, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str2 = null;
                }
                return dealProofsIntentFactory.createPhotoPickerIntentForRatingImages(str, i, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPhotoPickerIntentForRatingImages");
        }

        public static /* synthetic */ Intent createPhotoPickerIntentForRatingsFiles$default(DealProofsIntentFactory dealProofsIntentFactory, String str, int i, String str2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    str2 = null;
                }
                return dealProofsIntentFactory.createPhotoPickerIntentForRatingsFiles(str, i, str2);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createPhotoPickerIntentForRatingsFiles");
        }
    }

    @NotNull
    Intent createPhotoPickerIntentForRatingImages(@NotNull String str, int i, @Nullable String str2);

    @NotNull
    Intent createPhotoPickerIntentForRatingsFiles(@NotNull String str, int i, @Nullable String str2);
}
