package com.avito.android.hints.items;

import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0007H&¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nH&¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/avito/android/hints/items/HintItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "text", "", "setTitle", "(Ljava/lang/String;)V", "", "setDescription", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "hints_release"}, k = 1, mv = {1, 4, 2})
public interface HintItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull HintItemView hintItemView) {
            ItemView.DefaultImpls.onUnbind(hintItemView);
        }
    }

    void setDescription(@NotNull CharSequence charSequence);

    void setPicture(@NotNull Picture picture);

    void setTitle(@NotNull String str);
}
