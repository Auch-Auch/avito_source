package com.avito.android.photo_picker.legacy.details_list;

import android.net.Uri;
import com.avito.android.krop.util.Transformation;
import com.avito.android.util.Rotation;
import com.avito.konveyor.blueprint.ItemView;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H&¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J#\u0010\u0015\u001a\u00020\u00062\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u0017\u001a\u00020\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u000fH&¢\u0006\u0004\b\u0017\u0010\u0012J\u0017\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H&¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/EditorItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Landroid/net/Uri;", ShareConstants.MEDIA_URI, "Lcom/avito/android/util/Rotation;", "rotation", "", "showPreview", "(Landroid/net/Uri;Lcom/avito/android/util/Rotation;)V", "showCrop", "(Landroid/net/Uri;)V", "hideImage", "()V", "rotateUi", "(Lcom/avito/android/util/Rotation;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRemoveClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lkotlin/Function1;", "Lcom/avito/android/krop/util/Transformation;", "setCropListener", "(Lkotlin/jvm/functions/Function1;)V", "setOnUnbindListener", "", "isVisible", "setProgressVisibility", "(Z)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public interface EditorItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull EditorItemView editorItemView) {
            ItemView.DefaultImpls.onUnbind(editorItemView);
        }
    }

    void hideImage();

    void rotateUi(@NotNull Rotation rotation);

    void setCropListener(@NotNull Function1<? super Transformation, Unit> function1);

    void setOnUnbindListener(@NotNull Function0<Unit> function0);

    void setProgressVisibility(boolean z);

    void setRemoveClickListener(@Nullable Function0<Unit> function0);

    void showCrop(@NotNull Uri uri);

    void showPreview(@NotNull Uri uri, @NotNull Rotation rotation);
}
