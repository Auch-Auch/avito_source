package com.avito.android.photo_picker.gallery.gallery_list;

import android.net.Uri;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH&¢\u0006\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/avito/android/photo_picker/gallery/gallery_list/GalleryItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "", "showImage", "(Landroid/net/Uri;)V", "", "selected", "setSelected", "(I)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface GalleryItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull GalleryItemView galleryItemView) {
            ItemView.DefaultImpls.onUnbind(galleryItemView);
        }
    }

    void setClickListener(@NotNull Function0<Unit> function0);

    void setSelected(int i);

    void setUnbindListener(@NotNull Function0<Unit> function0);

    void showImage(@NotNull Uri uri);
}
