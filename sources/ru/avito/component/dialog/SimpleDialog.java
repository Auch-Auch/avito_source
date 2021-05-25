package ru.avito.component.dialog;

import android.graphics.drawable.Drawable;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanel;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\r\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H&¢\u0006\u0004\b\u0005\u0010\tJ\u000f\u0010\n\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H&¢\u0006\u0004\b\f\u0010\u000bJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u000f\u0010\u0006J\u000f\u0010\u0012\u001a\u00020\u0004H&¢\u0006\u0004\b\u0012\u0010\u000bJ\u000f\u0010\u0013\u001a\u00020\u0004H&¢\u0006\u0004\b\u0013\u0010\u000bJ\u000f\u0010\u0014\u001a\u00020\u0004H&¢\u0006\u0004\b\u0014\u0010\u000bJ\u000f\u0010\u0015\u001a\u00020\u0004H&¢\u0006\u0004\b\u0015\u0010\u000bJ\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0016\u0010\u0010J\u0019\u0010\u0016\u001a\u00020\u00042\b\b\u0001\u0010\u0011\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0006J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH&¢\u0006\u0004\b\u0017\u0010\u0010¨\u0006\u0018"}, d2 = {"Lru/avito/component/dialog/SimpleDialog;", "Lru/avito/component/button_panel/ButtonPanel;", "", "imageId", "", "setImage", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "showImage", "()V", "hideImage", "", "text", "setTitle", "(Ljava/lang/CharSequence;)V", "textId", "showTitle", "hideTitle", "showBody", "hideBody", "setBody", "setEmbeddedLink", "deprecated-components_release"}, k = 1, mv = {1, 4, 2})
public interface SimpleDialog extends ButtonPanel {
    void hideBody();

    void hideImage();

    void hideTitle();

    void setBody(@StringRes int i);

    void setBody(@Nullable CharSequence charSequence);

    void setEmbeddedLink(@Nullable CharSequence charSequence);

    void setImage(@DrawableRes int i);

    void setImage(@Nullable Drawable drawable);

    void setTitle(@StringRes int i);

    void setTitle(@Nullable CharSequence charSequence);

    void showBody();

    void showImage();

    void showTitle();
}
