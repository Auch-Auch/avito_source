package com.avito.android.lib.design.tooltip;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.common.util.UriUtil;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b+\u0010,J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\tJ\u0015\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011J%\u0010\u0015\u001a\u00020\u00042\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0017\u0010\tJ\u0017\u0010\u0018\u001a\u00020\u00042\b\b\u0001\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\u0018\u0010\tJ\u0015\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0007¢\u0006\u0004\b\u001a\u0010\tR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010!¨\u0006-"}, d2 = {"Lcom/avito/android/lib/design/tooltip/TooltipContent;", "", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "", UriUtil.LOCAL_RESOURCE_SCHEME, "(I)V", SDKConstants.PARAM_A2U_BODY, "setBody", "text", "setButtonText", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButtonClickListener", "(Landroid/view/View$OnClickListener;)V", "Landroid/graphics/drawable/Drawable;", "image", "background", "setImage", "(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V", "setImageResource", "setBackgroundResource", "gravity", "setImageGravity", "Lcom/avito/android/lib/design/button/Button;", "c", "Lcom/avito/android/lib/design/button/Button;", "buttonView", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "bodyView", "Landroid/widget/ImageView;", "d", "Landroid/widget/ImageView;", "imageView", AuthSource.SEND_ABUSE, "titleView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class TooltipContent {
    public final TextView a;
    public final TextView b;
    public final Button c;
    public final ImageView d;

    public TooltipContent(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        TextView textView = (TextView) view.findViewById(R.id.title);
        this.a = textView;
        TextView textView2 = (TextView) view.findViewById(R.id.body);
        this.b = textView2;
        Button button = (Button) view.findViewById(R.id.button);
        this.c = button;
        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        this.d = imageView;
        if (textView != null) {
            Views.hide(textView);
        }
        if (textView2 != null) {
            Views.hide(textView2);
        }
        if (button != null) {
            Views.hide(button);
        }
        if (imageView != null) {
            Views.hide(imageView);
        }
    }

    public static /* synthetic */ void setImage$default(TooltipContent tooltipContent, Drawable drawable, Drawable drawable2, int i, Object obj) {
        if ((i & 1) != 0) {
            ImageView imageView = tooltipContent.d;
            drawable = imageView != null ? imageView.getDrawable() : null;
        }
        if ((i & 2) != 0) {
            ImageView imageView2 = tooltipContent.d;
            drawable2 = imageView2 != null ? imageView2.getBackground() : null;
        }
        tooltipContent.setImage(drawable, drawable2);
    }

    public final void setBackgroundResource(@DrawableRes int i) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setBackgroundResource(i);
        }
        Views.setVisible(this.d, i != 0);
    }

    public final void setBody(@Nullable CharSequence charSequence) {
        TextView textView = this.b;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setButtonClickListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Button button = this.c;
        if (button != null) {
            button.setOnClickListener(onClickListener);
        }
    }

    public final void setButtonText(@Nullable CharSequence charSequence) {
        Button button = this.c;
        if (button != null) {
            ButtonsKt.bindText$default(button, charSequence, false, 2, null);
        }
    }

    public final void setImage(@Nullable Drawable drawable, @Nullable Drawable drawable2) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        ImageView imageView2 = this.d;
        if (imageView2 != null) {
            imageView2.setBackground(drawable2);
        }
        Views.setVisible(this.d, drawable != null);
    }

    public final void setImageGravity(int i) {
        ImageView imageView = this.d;
        ViewGroup.LayoutParams layoutParams = imageView != null ? imageView.getLayoutParams() : null;
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        ((LinearLayout.LayoutParams) layoutParams).gravity = i;
        this.d.requestLayout();
    }

    public final void setImageResource(@DrawableRes int i) {
        ImageView imageView = this.d;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        Views.setVisible(this.d, i != 0);
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        TextView textView = this.a;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setBody(@StringRes int i) {
        TextView textView = this.b;
        if (textView != null) {
            textView.setText(i);
        }
        Views.setVisible(this.b, i != 0);
    }

    public final void setButtonText(@StringRes int i) {
        Button button = this.c;
        if (button != null) {
            button.setText(i);
        }
        Views.setVisible(this.c, i != 0);
    }

    public final void setTitle(@StringRes int i) {
        TextView textView = this.a;
        if (textView != null) {
            textView.setText(i);
        }
        Views.setVisible(this.a, i != 0);
    }
}
