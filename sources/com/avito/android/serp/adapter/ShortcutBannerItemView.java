package com.avito.android.serp.adapter;

import androidx.annotation.ColorInt;
import com.avito.android.image_loader.Picture;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0019\u0010\u0012\u001a\u00020\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u0014\u0010\u000eJ\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0010H&¢\u0006\u0004\b\u0016\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/serp/adapter/ShortcutBannerItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lkotlin/Function0;", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "", "text", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setLeftImage", "(Lcom/avito/android/image_loader/Picture;)V", "setRightImage", "", "color", "setBackground", "(I)V", "setImage", "widthPx", "setShortcutWidth", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface ShortcutBannerItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ShortcutBannerItemView shortcutBannerItemView) {
            ItemView.DefaultImpls.onUnbind(shortcutBannerItemView);
        }
    }

    void setBackground(@ColorInt int i);

    void setClickListener(@NotNull Function0<Unit> function0);

    void setImage(@NotNull Picture picture);

    void setLeftImage(@NotNull Picture picture);

    void setRightImage(@NotNull Picture picture);

    void setShortcutWidth(int i);

    void setTitle(@Nullable String str);
}
