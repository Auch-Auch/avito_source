package ru.avito.component.floating_button;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import ru.avito.component.button.Button;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH&¢\u0006\u0004\b\u000f\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000bH&¢\u0006\u0004\b\u0011\u0010\u000e¨\u0006\u0012"}, d2 = {"Lru/avito/component/floating_button/PrimaryFloatingButton;", "Lru/avito/component/button/Button;", "", "drawableRes", "", "setImageResource", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "", "animate", "moveIn", "(Z)V", "moveOut", "visible", "setProgressBarVisible", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public interface PrimaryFloatingButton extends Button {
    void moveIn(boolean z);

    void moveOut(boolean z);

    void setImageDrawable(@NotNull Drawable drawable);

    void setImageResource(@DrawableRes int i);

    void setProgressBarVisible(boolean z);
}
