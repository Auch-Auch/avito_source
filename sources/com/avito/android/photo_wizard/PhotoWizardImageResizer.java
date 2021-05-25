package com.avito.android.photo_wizard;

import android.graphics.Bitmap;
import android.graphics.Point;
import com.avito.android.util.Dimension;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J9\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/avito/android/photo_wizard/PhotoWizardImageResizer;", "", "", "data", "Lcom/avito/android/util/Dimension;", "scaledSize", "croppedSize", "Landroid/graphics/Point;", "offset", "Lio/reactivex/rxjava3/core/Observable;", "Landroid/graphics/Bitmap;", "resize", "([BLcom/avito/android/util/Dimension;Lcom/avito/android/util/Dimension;Landroid/graphics/Point;)Lio/reactivex/rxjava3/core/Observable;", "photo-wizard_release"}, k = 1, mv = {1, 4, 2})
public interface PhotoWizardImageResizer {
    @NotNull
    Observable<Bitmap> resize(@NotNull byte[] bArr, @NotNull Dimension dimension, @Nullable Dimension dimension2, @Nullable Point point);
}
