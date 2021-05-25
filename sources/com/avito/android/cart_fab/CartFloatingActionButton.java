package com.avito.android.cart_fab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.avito.android.advert_core.analytics.contactbar.PhonePageSourceKt;
import com.avito.android.lib.design.notification_badge.NotificationBadge;
import com.avito.android.remote.auth.AuthSource;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0012¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/avito/android/cart_fab/CartFloatingActionButton;", "Landroid/widget/FrameLayout;", "Lcom/avito/android/lib/design/notification_badge/NotificationBadge;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/lib/design/notification_badge/NotificationBadge;", "getBadge", "()Lcom/avito/android/lib/design/notification_badge/NotificationBadge;", "badge", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", AuthSource.SEND_ABUSE, "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "getButton", "()Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", PhonePageSourceKt.PHONE_SOURCE_BUTTON, "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "cart-fab_release"}, k = 1, mv = {1, 4, 2})
public final class CartFloatingActionButton extends FrameLayout {
    @NotNull
    public final FloatingActionButton a;
    @NotNull
    public final NotificationBadge b;

    @JvmOverloads
    public CartFloatingActionButton(@NotNull Context context) {
        this(context, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public CartFloatingActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
    }

    @JvmOverloads
    public CartFloatingActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CartFloatingActionButton(Context context, AttributeSet attributeSet, int i, int i2, int i3, j jVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    @NotNull
    public final NotificationBadge getBadge() {
        return this.b;
    }

    @NotNull
    public final FloatingActionButton getButton() {
        return this.a;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CartFloatingActionButton(@NotNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(context).inflate(R.layout.cart_fab_content, (ViewGroup) this, true);
        View findViewById = findViewById(R.id.cart_fab_button);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.google.android.material.floatingactionbutton.FloatingActionButton");
        this.a = (FloatingActionButton) findViewById;
        View findViewById2 = findViewById(R.id.cart_fab_badge);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.avito.android.lib.design.notification_badge.NotificationBadge");
        this.b = (NotificationBadge) findViewById2;
    }
}
