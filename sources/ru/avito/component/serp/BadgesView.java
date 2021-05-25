package ru.avito.component.serp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Views;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0016\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001c"}, d2 = {"Lru/avito/component/serp/BadgesView;", "Landroid/widget/LinearLayout;", "Landroid/widget/ImageView;", "c", "Landroid/widget/ImageView;", "getHasVideoBadge", "()Landroid/widget/ImageView;", "hasVideoBadge", "Landroid/widget/TextView;", AuthSource.SEND_ABUSE, "Landroid/widget/TextView;", "getBadge", "()Landroid/widget/TextView;", "badge", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "getHasDelivery", "()Landroid/view/View;", "hasDelivery", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgesView extends LinearLayout {
    @Nullable
    public final TextView a;
    @NotNull
    public final View b;
    @NotNull
    public final ImageView c;

    @JvmOverloads
    public BadgesView(@NotNull Context context) {
        this(context, null, 0, 6, null);
    }

    @JvmOverloads
    public BadgesView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BadgesView(Context context, AttributeSet attributeSet, int i, int i2, j jVar) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    @Nullable
    public final TextView getBadge() {
        return this.a;
    }

    @NotNull
    public final View getHasDelivery() {
        return this.b;
    }

    @NotNull
    public final ImageView getHasVideoBadge() {
        return this.c;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public BadgesView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.layout.advert_status_info_badges, (ViewGroup) this, true);
        setLayoutParams(new ViewGroup.MarginLayoutParams(-2, -2));
        Views.changeMargin$default(this, getResources().getDimensionPixelOffset(R.dimen.rich_snippet_info_badge_horizontal_offset), 0, 0, getResources().getDimensionPixelOffset(R.dimen.rich_snippet_info_badge_vertical_offset), 6, null);
        this.a = (TextView) findViewById(R.id.badge);
        View findViewById = findViewById(R.id.delivery_status);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        View findViewById2 = findViewById(R.id.has_video);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.ImageView");
        this.c = (ImageView) findViewById2;
    }
}
