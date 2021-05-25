package com.avito.android.component.info_block_verification;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b,\u0010-J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0005\u0010\tJ\u0019\u0010\n\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\b\u0001\u0010\u000e\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u000f\u0010\tJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u000f\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u001d\u0010\u001a\u001a\u00020\u00042\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/component/info_block_verification/InfoBlockVerificationImpl;", "Lcom/avito/android/component/info_block_verification/InfoBlockVerification;", "", "text", "", "setText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "bindText", "show", "()V", "hide", "drawableRes", "setIcon", "Landroid/graphics/drawable/Drawable;", "drawable", "(Landroid/graphics/drawable/Drawable;)V", "Landroid/content/res/ColorStateList;", "colorList", "setIconTintColor", "(Landroid/content/res/ColorStateList;)V", "", "Lcom/avito/android/component/info_block_verification/ConnectionLabel;", "connectionLabels", "setConnectionLabels", "(Ljava/util/List;)V", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "d", "Landroid/view/View;", "view", "Landroid/view/LayoutInflater;", "c", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewGroup;", "rightIconsViewGroup", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class InfoBlockVerificationImpl implements InfoBlockVerification {
    public final TextView a;
    public final ViewGroup b;
    public final LayoutInflater c;
    public final View d;

    public InfoBlockVerificationImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.d = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.right_icons);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.ViewGroup");
        this.b = (ViewGroup) findViewById2;
        LayoutInflater from = LayoutInflater.from(view.getContext());
        Intrinsics.checkNotNullExpressionValue(from, "LayoutInflater.from(view.context)");
        this.c = from;
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
        Views.hide(this.d);
    }

    @Override // com.avito.android.component.info_block_verification.InfoBlockVerification
    public void setConnectionLabels(@NotNull List<? extends ConnectionLabel> list) {
        Intrinsics.checkNotNullParameter(list, "connectionLabels");
        this.b.removeAllViews();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            View inflate = this.c.inflate(R.layout.connection_view, this.b, false);
            Objects.requireNonNull(inflate, "null cannot be cast to non-null type android.widget.ImageView");
            ImageView imageView = (ImageView) inflate;
            imageView.setImageResource(it.next().getImageRes());
            this.b.addView(imageView);
        }
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@DrawableRes int i) {
        TextViews.setCompoundDrawables$default(this.a, i, 0, 0, 0, 14, (Object) null);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIconTintColor(@NotNull ColorStateList colorStateList) {
        Intrinsics.checkNotNullParameter(colorStateList, "colorList");
    }

    @Override // ru.avito.component.text.Text
    public void setText(@Nullable CharSequence charSequence) {
        this.a.setText(charSequence);
    }

    @Override // ru.avito.component.text.Text
    public void show() {
        Views.show(this.d);
    }

    @Override // com.avito.android.component.info_block.InfoBlock
    public void setIcon(@NotNull Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        TextViews.setCompoundDrawables$default(this.a, drawable, (Drawable) null, (Drawable) null, (Drawable) null, 14, (Object) null);
    }

    @Override // ru.avito.component.text.Text
    public void setText(@StringRes int i) {
        this.a.setText(i);
    }
}
