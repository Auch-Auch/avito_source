package ru.avito.component.shop;

import a2.g.r.g;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000201¢\u0006\u0004\b5\u00106J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u001d\u0010\r\u001a\u00020\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001dR\u0016\u0010,\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010\u0019R\u0016\u0010.\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010\u0019R\u0016\u00100\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010!R\u0016\u00104\u001a\u0002018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b2\u00103¨\u00067"}, d2 = {"Lru/avito/component/shop/ShopListCardImpl;", "Lru/avito/component/shop/ShopListCard;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "category", "setCategory", "description", "setDescription", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "", "isEnabled", "setEnabled", "(Z)V", "Landroid/widget/TextView;", AuthSource.BOOKING_ORDER, "Landroid/widget/TextView;", "nameView", "", "i", "I", "secondaryTextColor", "", "e", "F", "enabledAlpha", "h", "primaryTextColor", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.SEND_ABUSE, "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", g.a, "disabledTextColor", "d", "descriptionView", "c", "categoryView", "f", "disabledAlpha", "Landroid/view/View;", "j", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ShopListCardImpl implements ShopListCard {
    public final SimpleDraweeView a;
    public final TextView b;
    public final TextView c;
    public final TextView d;
    public final float e;
    public final float f;
    public final int g;
    public final int h;
    public final int i;
    public final View j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public a(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public ShopListCardImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.j = view;
        View findViewById = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.a = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.category);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById4;
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.g = Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28);
        Context context2 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        this.h = Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.black);
        Context context3 = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "view.context");
        this.i = Contexts.getColorByAttr(context3, com.avito.android.lib.design.R.attr.gray48);
        TypedValue typedValue = new TypedValue();
        view.getResources().getValue(R.dimen.inactive_alpha_old, typedValue, true);
        this.f = typedValue.getFloat();
        view.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        this.e = typedValue.getFloat();
        setEnabled(true);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setCategory(@Nullable String str) {
        TextViews.bindText$default(this.c, str, false, 2, null);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.j.setOnClickListener(new a(function0));
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setDescription(@Nullable String str) {
        TextViews.bindText$default(this.d, str, false, 2, null);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setEnabled(boolean z) {
        this.j.setClickable(z);
        if (z) {
            this.a.setAlpha(this.e);
            this.b.setTextColor(this.h);
            this.c.setTextColor(this.i);
            this.d.setTextColor(this.i);
            return;
        }
        this.a.setAlpha(this.f);
        this.b.setTextColor(this.g);
        this.c.setTextColor(this.g);
        this.d.setTextColor(this.g);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.a, picture);
    }

    @Override // ru.avito.component.shop.ShopListCard
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.b.setText(str);
    }
}
