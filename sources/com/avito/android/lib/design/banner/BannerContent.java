package com.avito.android.lib.design.banner;

import a2.g.r.g;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.method.MovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.R;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010-\u001a\u00020,\u0012\b\u0010/\u001a\u0004\u0018\u00010.\u0012\u0006\u00101\u001a\u000200\u0012\u0006\u00102\u001a\u000200¢\u0006\u0004\b3\u00104J\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\u0006J\u0015\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0017\u0010\u0018R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010+\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b*\u0010(¨\u00065"}, d2 = {"Lcom/avito/android/lib/design/banner/BannerContent;", "", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", SDKConstants.PARAM_A2U_BODY, "setBody", "Landroid/text/method/MovementMethod;", "movement", "setBodyMovementMethod", "(Landroid/text/method/MovementMethod;)V", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setButton", "(Ljava/lang/CharSequence;Landroid/view/View$OnClickListener;)V", "Landroid/view/View;", "view", "attachView$components_release", "(Landroid/view/View;)V", "attachView", "detachView$components_release", "()V", "detachView", AuthSource.BOOKING_ORDER, "Ljava/lang/CharSequence;", AuthSource.SEND_ABUSE, "c", "buttonText", "Lcom/avito/android/lib/design/button/Button;", g.a, "Lcom/avito/android/lib/design/button/Button;", "buttonView", "d", "Landroid/view/View$OnClickListener;", "buttonListener", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "titleView", "f", "bodyView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "components_release"}, k = 1, mv = {1, 4, 2})
public final class BannerContent {
    public CharSequence a;
    public CharSequence b;
    public CharSequence c;
    public View.OnClickListener d;
    public TextView e;
    public TextView f;
    public Button g;

    public BannerContent(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Banner, i, i2);
        this.a = obtainStyledAttributes.getString(R.styleable.Banner_banner_title);
        this.b = obtainStyledAttributes.getString(R.styleable.Banner_banner_body);
        this.c = obtainStyledAttributes.getString(R.styleable.Banner_banner_buttonText);
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void setButton$default(BannerContent bannerContent, CharSequence charSequence, View.OnClickListener onClickListener, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = bannerContent.c;
        }
        if ((i & 2) != 0) {
            onClickListener = bannerContent.d;
        }
        bannerContent.setButton(charSequence, onClickListener);
    }

    public final void attachView$components_release(@Nullable View view) {
        detachView$components_release();
        if (view != null) {
            this.e = (TextView) view.findViewById(R.id.title);
            this.f = (TextView) view.findViewById(R.id.body);
            this.g = (Button) view.findViewById(R.id.button);
            TextView textView = this.e;
            if (textView != null) {
                Views.hide(textView);
            }
            TextView textView2 = this.f;
            if (textView2 != null) {
                Views.hide(textView2);
            }
            Button button = this.g;
            if (button != null) {
                Views.hide(button);
            }
            setTitle(this.a);
            setBody(this.b);
            setButton(this.c, this.d);
        }
    }

    public final void detachView$components_release() {
        this.e = null;
        this.f = null;
        this.g = null;
    }

    public final void setBody(@Nullable CharSequence charSequence) {
        this.b = charSequence;
        TextView textView = this.f;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }

    public final void setBodyMovementMethod(@NotNull MovementMethod movementMethod) {
        Intrinsics.checkNotNullParameter(movementMethod, "movement");
        TextView textView = this.f;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public final void setButton(@Nullable CharSequence charSequence, @Nullable View.OnClickListener onClickListener) {
        this.c = charSequence;
        this.d = onClickListener;
        Button button = this.g;
        if (button != null) {
            ButtonsKt.bindText$default(button, charSequence, false, 2, null);
        }
        Button button2 = this.g;
        if (button2 != null) {
            button2.setOnClickListener(onClickListener);
        }
    }

    public final void setTitle(@Nullable CharSequence charSequence) {
        this.a = charSequence;
        TextView textView = this.e;
        if (textView != null) {
            TextViews.bindText$default(textView, charSequence, false, 2, null);
        }
    }
}
