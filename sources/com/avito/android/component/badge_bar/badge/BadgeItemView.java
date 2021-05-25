package com.avito.android.component.badge_bar.badge;

import android.view.View;
import androidx.annotation.DrawableRes;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.konveyor.blueprint.ItemView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\u0006J#\u0010\f\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\tH&¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H&¢\u0006\u0004\b\u0014\u0010\u0013J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H&¢\u0006\u0004\b\u0017\u0010\u0018J\u0019\u0010\u001b\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cJ\u0019\u0010\u001e\u001a\u00020\u00042\b\b\u0001\u0010\u001d\u001a\u00020\u0010H&¢\u0006\u0004\b\u001e\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/avito/android/component/badge_bar/badge/BadgeItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "Lcom/avito/android/remote/model/UniversalColor;", "color", "rippleColor", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "setTextColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "", "maxLines", "setTitleMaxLines", "(I)V", "setDescriptionMaxLines", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "imageRes", "setLocalHardcodedImage", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface BadgeItemView extends ItemView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull BadgeItemView badgeItemView) {
            ItemView.DefaultImpls.onUnbind(badgeItemView);
        }
    }

    void setBackground(@Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2);

    void setDescription(@NotNull String str);

    void setDescriptionMaxLines(int i);

    void setImage(@Nullable Image image);

    void setLocalHardcodedImage(@DrawableRes int i);

    void setOnClickListener(@Nullable View.OnClickListener onClickListener);

    void setTextColor(@Nullable UniversalColor universalColor);

    void setTitle(@NotNull String str);

    void setTitleMaxLines(int i);
}
