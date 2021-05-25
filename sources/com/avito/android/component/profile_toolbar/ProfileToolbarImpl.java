package com.avito.android.component.profile_toolbar;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.avito.android.image_loader.Picture;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u001e\u001a\u00020\u0017¢\u0006\u0004\b1\u00102J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0019\u0010\u001e\u001a\u00020\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u0019\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010$\u001a\u00020\u001f8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001e\u0010)\u001a\n &*\u0004\u0018\u00010%0%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0016\u0010\u0003\u001a\u00020.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/avito/android/component/profile_toolbar/ProfileToolbarImpl;", "Lcom/avito/android/component/profile_toolbar/ProfileToolbar;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "", "isVisible", "withAnimation", "setContentVisible", "(ZZ)V", "f", "Ljava/lang/Boolean;", "isContentVisible", "Landroid/view/View;", AuthSource.BOOKING_ORDER, "Landroid/view/View;", "content", g.a, "getView", "()Landroid/view/View;", "view", "Landroidx/appcompat/widget/Toolbar;", "e", "Landroidx/appcompat/widget/Toolbar;", "getToolbar", "()Landroidx/appcompat/widget/Toolbar;", "toolbar", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "Lcom/facebook/drawee/view/SimpleDraweeView;", "d", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/widget/TextView;", "c", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileToolbarImpl implements ProfileToolbar {
    public final Context a;
    public final View b;
    public final TextView c;
    public final SimpleDraweeView d;
    @NotNull
    public final Toolbar e;
    public Boolean f;
    @NotNull
    public final View g;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserIconType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            UserIconType userIconType = UserIconType.SHOP;
            iArr[2] = 1;
        }
    }

    public ProfileToolbarImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.g = view;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.container);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.b = findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.d = (SimpleDraweeView) findViewById3;
        Objects.requireNonNull(view, "null cannot be cast to non-null type androidx.appcompat.widget.Toolbar");
        this.e = (Toolbar) view;
    }

    @Override // com.avito.android.component.profile_toolbar.ProfileToolbar
    @NotNull
    public Toolbar getToolbar() {
        return this.e;
    }

    @NotNull
    public final View getView() {
        return this.g;
    }

    @Override // com.avito.android.component.profile_toolbar.ProfileToolbar
    public void setAvatar(@Nullable Picture picture) {
        Views.show(this.d);
        SimpleDraweeViewsKt.loadPicture$default(this.d, picture, null, null, 6, null);
    }

    @Override // com.avito.android.component.profile_toolbar.ProfileToolbar
    public void setContentVisible(boolean z, boolean z2) {
        if (!Intrinsics.areEqual(this.f, Boolean.valueOf(z))) {
            this.f = Boolean.valueOf(z);
            float f2 = z ? 1.0f : 0.0f;
            if (z2) {
                this.b.animate().alpha(f2).setDuration(100).start();
            } else {
                this.b.setAlpha(f2);
            }
        }
    }

    @Override // com.avito.android.component.profile_toolbar.ProfileToolbar
    public void setName(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.c, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.profile_toolbar.ProfileToolbar
    public void setUserIconType(@NotNull UserIconType userIconType) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(userIconType, "userIconType");
        if (userIconType.ordinal() != 2) {
            drawable = null;
        } else {
            Drawable drawable2 = this.a.getDrawable(R.drawable.ic_shop_48);
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        }
        ((GenericDraweeHierarchy) this.d.getHierarchy()).setPlaceholderImage(drawable);
    }
}
