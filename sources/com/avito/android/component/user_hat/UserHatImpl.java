package com.avito.android.component.user_hat;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.FloatsKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010*\u001a\u00020!¢\u0006\u0004\b@\u0010AJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J5\u0010\u0012\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00022\b\b\u0001\u0010\u0011\u001a\u00020\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0016\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0014H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001e\u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001cH\u0016¢\u0006\u0004\b \u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020!8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010#R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00100\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b/\u0010'R\u0016\u00102\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010'R\u001e\u00107\u001a\n 4*\u0004\u0018\u000103038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u00106R\u0016\u00109\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u0010'R\u0016\u0010;\u001a\u00020%8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010'R\u0016\u0010?\u001a\u00020<8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010>¨\u0006B"}, d2 = {"Lcom/avito/android/component/user_hat/UserHatImpl;", "Lcom/avito/android/component/user_hat/UserHat;", "", "name", "", "setName", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "description", "setDescription", "", "score", "", "enableFloatingRating", "text", "", "textColorAttr", "setRating", "(Ljava/lang/Float;ZLjava/lang/CharSequence;I)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setUserIconType", "(Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setRatingClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setAvatarClickListener", "Landroid/view/View;", "h", "Landroid/view/View;", "ratingContainer", "Landroid/widget/TextView;", "e", "Landroid/widget/TextView;", "descriptionView", "j", "rootView", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", g.a, "ratingTextView", "c", "nameView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "i", "ratingNumberView", "d", "subtitleView", "Lcom/avito/android/lib/design/rating/RatingBar;", "f", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingScoreView", "<init>", "(Landroid/view/View;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class UserHatImpl implements UserHat {
    public final Context a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final RatingBar f;
    public final TextView g;
    public final View h;
    public final TextView i;
    public final View j;

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

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Function0 a;

        public b(Function0 function0) {
            this.a = function0;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            this.a.invoke();
        }
    }

    public UserHatImpl(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.j = view;
        this.a = view.getContext();
        View findViewById = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.name);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.rating_score);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.f = (RatingBar) findViewById5;
        View findViewById6 = view.findViewById(R.id.rating_text);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.rating_container);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.view.View");
        this.h = findViewById7;
        View findViewById8 = view.findViewById(R.id.rating_number);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.i = (TextView) findViewById8;
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setAvatar(@Nullable Picture picture) {
        SimpleDraweeViewsKt.loadPicture$default(this.b, picture, null, null, 6, null);
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setAvatarClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.b.setOnClickListener(new a(function0));
        } else {
            this.b.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.e, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setName(@Nullable CharSequence charSequence) {
        this.c.setText(charSequence);
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setRating(@Nullable Float f2, boolean z, @Nullable CharSequence charSequence, @AttrRes int i2) {
        boolean z2 = true;
        boolean z3 = f2 != null;
        if (charSequence == null) {
            z2 = false;
        }
        Views.setVisible(this.f, z3);
        Views.setVisible(this.g, z2);
        Views.setVisible(this.h, z3);
        this.f.setFloatingRatingIsEnabled(z);
        this.f.setRating(f2 != null ? f2.floatValue() : 0.0f);
        TextView textView = this.g;
        Context context = this.a;
        Intrinsics.checkNotNullExpressionValue(context, "context");
        if (charSequence == null) {
            i2 = com.avito.android.lib.design.R.attr.gray28;
        }
        textView.setTextColor(Contexts.getColorByAttr(context, i2));
        TextView textView2 = this.g;
        if (charSequence == null) {
            charSequence = this.j.getContext().getString(R.string.user_hat_more_info);
        }
        textView2.setText(charSequence);
        Views.setVisible(this.i, z);
        TextView textView3 = this.i;
        String str = null;
        if (f2 != null) {
            str = FloatsKt.formatWithSeparator$default(f2.floatValue(), null, 0, 3, null);
        }
        textView3.setText(str);
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setRatingClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.j.setOnClickListener(new b(function0));
        } else {
            this.j.setOnClickListener(null);
        }
    }

    @Override // com.avito.android.component.user_hat.UserHat
    public void setSubtitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.d, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.user_hat.UserHat
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
        ((GenericDraweeHierarchy) this.b.getHierarchy()).setPlaceholderImage(drawable);
    }
}
