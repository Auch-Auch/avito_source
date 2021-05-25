package com.avito.android.component.info_block;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.text.Text;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001f\u001a\u00020\u001c¢\u0006\u0004\b \u0010!J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\n\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\tJ\u0019\u0010\r\u001a\u00020\u00052\b\b\u0001\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\r\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\r\u0010\u0011J\u0017\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0016\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0004\b\u0016\u0010\u0007J\u001a\u0010\u0016\u001a\u00020\u00052\b\b\u0001\u0010\u0017\u001a\u00020\u000bH\u0001¢\u0006\u0004\b\u0016\u0010\u000eR\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/component/info_block/InfoBlockImpl;", "Lcom/avito/android/component/info_block/InfoBlock;", "Lru/avito/component/text/Text;", "", "text", "", "bindText", "(Ljava/lang/CharSequence;)V", "show", "()V", "hide", "", "drawableRes", "setIcon", "(I)V", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/content/res/ColorStateList;", "colorList", "setIconTintColor", "(Landroid/content/res/ColorStateList;)V", "setText", "textId", "Landroid/widget/ImageView;", AuthSource.SEND_ABUSE, "Landroid/widget/ImageView;", "iconView", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoBlockImpl implements InfoBlock, Text {
    public final ImageView a;
    public final View b;
    public final /* synthetic */ TextImpl c;

    public InfoBlockImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.c = new TextImpl(findViewById);
        this.b = view;
        View findViewById2 = view.findViewById(R.id.icon);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.a = (ImageView) findViewById2;
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void bindText(@Nullable CharSequence charSequence) {
        if (charSequence == null || charSequence.length() == 0) {
            hide();
        } else {
            show();
        }
        setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void hide() {
        Views.hide(this.b);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@DrawableRes int i) {
        this.a.setImageResource(i);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIconTintColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorList");
        ImageViewsKt.setImageTintListCompat(this.a, colorStateList);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.c.setText(i);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        Views.show(this.b);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.a.setImageDrawable(drawable);
    }
}
