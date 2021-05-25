package com.avito.android.photo_picker.legacy.thumbnail_list;

import android.net.Uri;
import androidx.annotation.IntegerRes;
import com.avito.android.photo_picker.legacy.DraggablePhotoViewHolder;
import com.avito.android.util.Rotation;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u0006\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0005H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&¢\u0006\u0004\b\u0013\u0010\u0014J\u001d\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011H&¢\u0006\u0004\b\u0015\u0010\u0014J\u001f\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\rH&¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\rH&¢\u0006\u0004\b\u001c\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/avito/android/photo_picker/legacy/thumbnail_list/ThumbnailItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/photo_picker/legacy/DraggablePhotoViewHolder;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "showImage", "(Landroid/net/Uri;)V", "", "resId", "(I)V", "hideImage", "()V", "", "selected", "setSelected", "(Z)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "Lcom/avito/android/util/Rotation;", "rotation", "animate", "setRotation", "(Lcom/avito/android/util/Rotation;Z)V", "isVisible", "setProgressVisibility", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface ThumbnailItemView extends ItemView, DraggablePhotoViewHolder {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ThumbnailItemView thumbnailItemView) {
            ItemView.DefaultImpls.onUnbind(thumbnailItemView);
        }
    }

    void hideImage();

    void setClickListener(@NotNull Function0<Unit> function0);

    void setProgressVisibility(boolean z);

    void setRotation(@NotNull Rotation rotation, boolean z);

    void setSelected(boolean z);

    void setUnbindListener(@NotNull Function0<Unit> function0);

    void showImage(@IntegerRes int i);

    void showImage(@NotNull Uri uri);
}
