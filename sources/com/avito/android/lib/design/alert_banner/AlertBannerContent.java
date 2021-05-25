package com.avito.android.lib.design.alert_banner;

import a2.g.r.g;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.ImageViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010S\u001a\u00020R\u0012\b\u0010U\u001a\u0004\u0018\u00010T\u0012\u0006\u0010V\u001a\u00020&\u0012\u0006\u0010W\u001a\u00020&¢\u0006\u0004\bX\u0010YJ\u0019\u0010\u0007\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0000¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\n\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0010\u0010\u000eJ\u0015\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0011¢\u0006\u0004\b\u0013\u0010\u0014J%\u0010\u0018\u001a\u00020\u00042\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ%\u0010\u001f\u001a\u00020\u00042\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\b\u001f\u0010\u0019J\u0017\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b\"\u0010#J\u0017\u0010%\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010 ¢\u0006\u0004\b%\u0010#J\u0017\u0010(\u001a\u00020\u00042\b\b\u0001\u0010'\u001a\u00020&¢\u0006\u0004\b(\u0010)J\u0017\u0010(\u001a\u00020\u00042\b\u0010'\u001a\u0004\u0018\u00010*¢\u0006\u0004\b(\u0010+R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u0010!\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b5\u00101R\u0018\u00108\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010;\u001a\u00020\u001a8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b9\u0010:R\u0018\u0010?\u001a\u0004\u0018\u00010<8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b=\u0010>R\u0018\u0010A\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010.R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u00101R\u0018\u0010H\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bG\u00107R\u0018\u0010J\u001a\u0004\u0018\u00010 8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bI\u00104R\u0018\u0010M\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bK\u0010LR\u0018\u0010O\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010.R\u0018\u0010Q\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u00101¨\u0006Z"}, d2 = {"Lcom/avito/android/lib/design/alert_banner/AlertBannerContent;", "", "Landroid/view/View;", "view", "", "attachView$components_release", "(Landroid/view/View;)V", "attachView", "detachView$components_release", "()V", "detachView", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", SDKConstants.PARAM_A2U_BODY, "setBody", "Landroid/text/method/MovementMethod;", "movement", "setBodyMovementMethod", "(Landroid/text/method/MovementMethod;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButton", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "", "isVisible", "setButtonVisible", "(Z)V", "link", "setLink", "Landroid/graphics/drawable/Drawable;", "image", "setImageDrawable", "(Landroid/graphics/drawable/Drawable;)V", "background", "setImageBackground", "", "color", "setImageTint", "(I)V", "Landroid/content/res/ColorStateList;", "(Landroid/content/res/ColorStateList;)V", "Landroid/widget/TextView;", "n", "Landroid/widget/TextView;", "linkView", "e", "Ljava/lang/CharSequence;", "linkText", g.a, "Landroid/graphics/drawable/Drawable;", AuthSource.BOOKING_ORDER, "d", "Landroid/view/View$OnClickListener;", "buttonListener", "j", "Z", "isImageTintChanged", "Lcom/avito/android/lib/design/button/Button;", AuthSource.OPEN_CHANNEL_LIST, "Lcom/avito/android/lib/design/button/Button;", "buttonView", "l", "bodyView", "Landroid/widget/ImageView;", "o", "Landroid/widget/ImageView;", "imageView", AuthSource.SEND_ABUSE, "f", "linkListener", "h", "imageBackground", "i", "Landroid/content/res/ColorStateList;", "imageTint", "k", "titleView", "c", "buttonText", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class AlertBannerContent {
    public CharSequence a;
    public CharSequence b;
    public CharSequence c;
    public View.OnClickListener d;
    public CharSequence e;
    public View.OnClickListener f;
    public Drawable g;
    public Drawable h;
    public ColorStateList i;
    public boolean j;
    public TextView k;
    public TextView l;
    public Button m;
    public TextView n;
    public ImageView o;

    public AlertBannerContent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i2, int i3) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AlertBanner, i2, i3);
        this.a = obtainStyledAttributes.getString(R.styleable.AlertBanner_alertBanner_title);
        this.b = obtainStyledAttributes.getString(R.styleable.AlertBanner_alertBanner_body);
        this.c = obtainStyledAttributes.getString(R.styleable.AlertBanner_alertBanner_buttonText);
        this.e = obtainStyledAttributes.getString(R.styleable.AlertBanner_alertBanner_linkText);
        this.g = obtainStyledAttributes.getDrawable(R.styleable.AlertBanner_alertBanner_image);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void setButton$default(AlertBannerContent alertBannerContent, CharSequence charSequence, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = alertBannerContent.c;
        }
        if ((i2 & 2) != 0) {
            onClickListener = alertBannerContent.d;
        }
        alertBannerContent.setButton(charSequence, onClickListener);
    }

    public static /* synthetic */ void setLink$default(AlertBannerContent alertBannerContent, CharSequence charSequence, View.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charSequence = alertBannerContent.e;
        }
        if ((i2 & 2) != 0) {
            onClickListener = alertBannerContent.f;
        }
        alertBannerContent.setLink(charSequence, onClickListener);
    }

    public final void attachView$components_release(@Nullable View view) {
        ImageView imageView;
        detachView$components_release();
        if (view != null) {
            this.k = (TextView) view.findViewById(R.id.title);
            this.l = (TextView) view.findViewById(R.id.body);
            this.m = (Button) view.findViewById(R.id.button);
            this.n = (TextView) view.findViewById(R.id.link);
            this.o = (ImageView) view.findViewById(R.id.image);
            TextView textView = this.k;
            if (textView != null) {
                Views.hide(textView);
            }
            TextView textView2 = this.l;
            if (textView2 != null) {
                Views.hide(textView2);
            }
            ImageView imageView2 = this.o;
            if (imageView2 != null) {
                Views.hide(imageView2);
            }
            Button button = this.m;
            if (button != null) {
                Views.hide(button);
            }
            TextView textView3 = this.n;
            if (textView3 != null) {
                Views.hide(textView3);
            }
            TextView textView4 = this.n;
            if (textView4 != null) {
                textView4.setMovementMethod(LinkMovementMethod.getInstance());
            }
            setTitle(this.a);
            setBody(this.b);
            setImageBackground(this.h);
            setImageDrawable(this.g);
            setButton(this.c, this.d);
            setLink(this.e, this.f);
            if (this.j && (imageView = this.o) != null) {
                ImageViewsKt.setImageTintListCompat(imageView, this.i);
            }
        }
    }

    public final void detachView$components_release() {
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public final void setBody(@Nullable CharSequence charSequence) {
        this.b = charSequence;
        TextView textView = this.l;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setBodyMovementMethod(@NotNull MovementMethod movementMethod) {
        Intrinsics.checkNotNullParameter(movementMethod, "movement");
        TextView textView = this.l;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public final void setButton(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        this.c = charSequence;
        this.d = onClickListener;
        Button button = this.m;
        if (button != null) {
            ButtonsKt.bindText$default(button, charSequence, false, 2, null);
        }
        Button button2 = this.m;
        if (button2 != null) {
            button2.setOnClickListener(onClickListener);
        }
    }

    public final void setButtonVisible(boolean z) {
        Button button = this.m;
        if (button != null) {
            Views.setVisible(button, z);
        }
    }

    public final void setImageBackground(@Nullable Drawable drawable) {
        this.h = drawable;
        ImageView imageView = this.o;
        if (imageView != null) {
            Views.setBackgroundCompat(imageView, drawable);
        }
    }

    public final void setImageDrawable(@Nullable Drawable drawable) {
        this.g = drawable;
        ImageView imageView = this.o;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        }
        ImageView imageView2 = this.o;
        if (imageView2 != null) {
            Views.setVisible(imageView2, drawable != null);
        }
    }

    public final void setImageTint(@ColorInt int i2) {
        setImageTint(ColorStateList.valueOf(i2));
    }

    public final void setLink(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        this.e = charSequence;
        this.f = onClickListener;
        TextView textView = this.n;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
        TextView textView2 = this.n;
        if (textView2 != null) {
            textView2.setOnClickListener(onClickListener);
        }
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        this.a = charSequence;
        TextView textView = this.k;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setImageTint(@Nullable ColorStateList colorStateList) {
        this.i = colorStateList;
        this.j = true;
        ImageView imageView = this.o;
        if (imageView != null) {
            ImageViewsKt.setImageTintListCompat(imageView, colorStateList);
        }
    }
}
