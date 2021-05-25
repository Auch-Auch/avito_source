package com.avito.android.component.profile_snippet;

import a2.g.r.g;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
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
import org.spongycastle.i18n.ErrorBundle;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010:\u001a\u000207\u0012\u0006\u0010)\u001a\u00020&¢\u0006\u0004\bS\u0010TJ\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0019\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\f\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J#\u0010\r\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eJ+\u0010\u0013\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0019\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u000f\u0010\u001b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u001d\u0010\u001cJ\u001f\u0010 \u001a\u00020\u00042\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001eH\u0016¢\u0006\u0004\b \u0010!R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u001e\u00102\u001a\n /*\u0004\u0018\u00010.0.8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00104\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b3\u0010,R\u0016\u00106\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b5\u0010,R\u0016\u0010:\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010<\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010,R\u0016\u0010>\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010,R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010D\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010,R\u0016\u0010H\u001a\u00020E8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010J\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bI\u0010,R\u0016\u0010L\u001a\u0002078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u00109R\u0016\u0010P\u001a\u00020M8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010R\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bQ\u0010,¨\u0006U"}, d2 = {"Lcom/avito/android/component/profile_snippet/ProfileSnippetImpl;", "Lcom/avito/android/component/profile_snippet/ProfileSnippet;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "text", "setVerification", ErrorBundle.SUMMARY_ENTRY, "setSummary", "setContact", "(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)V", "", "score", "", "enableFloatingRating", "setRating", "(Ljava/lang/Float;ZLjava/lang/CharSequence;)V", "Lcom/avito/android/image_loader/Picture;", "avatar", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "userIconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "show", "()V", "hide", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/graphics/drawable/Drawable;", "n", "Landroid/graphics/drawable/Drawable;", "verifiedDrawable", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "p", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "avatarRenderer", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "contactSubtitleView", "Landroid/content/Context;", "kotlin.jvm.PlatformType", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "c", "titleView", AuthSource.OPEN_CHANNEL_LIST, "ratingNumber", "Landroid/view/View;", "o", "Landroid/view/View;", "rootView", g.a, "contactTitleView", "f", "summaryView", "Lcom/avito/android/lib/design/rating/RatingBar;", "k", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "d", "subtitleView", "Landroid/view/ViewGroup;", "i", "Landroid/view/ViewGroup;", "contactContainer", "e", "verificationView", "j", "ratingContainer", "Lcom/facebook/drawee/view/SimpleDraweeView;", AuthSource.BOOKING_ORDER, "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "l", "ratingTextView", "<init>", "(Landroid/view/View;Lcom/avito/android/component/profile_snippet/AvatarRenderer;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileSnippetImpl implements ProfileSnippet {
    public final Context a;
    public final SimpleDraweeView b;
    public final TextView c;
    public final TextView d;
    public final TextView e;
    public final TextView f;
    public final TextView g;
    public final TextView h;
    public final ViewGroup i;
    public final View j;
    public final RatingBar k;
    public final TextView l;
    public final TextView m;
    public final Drawable n;
    public final View o;
    public final AvatarRenderer p;

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            UserIconType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            UserIconType userIconType = UserIconType.SHOP;
            iArr[2] = 1;
            UserIconType userIconType2 = UserIconType.COMPANY;
            iArr[1] = 2;
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

    public ProfileSnippetImpl(@NotNull View view, @NotNull AvatarRenderer avatarRenderer) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(avatarRenderer, "avatarRenderer");
        this.o = view;
        this.p = avatarRenderer;
        Context context = view.getContext();
        this.a = context;
        View findViewById = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.b = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.d = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.verification);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.e = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.summary);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.f = (TextView) findViewById5;
        View findViewById6 = view.findViewById(R.id.contact_title);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.g = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.contact_subtitle);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.h = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.contact_container);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.view.ViewGroup");
        this.i = (ViewGroup) findViewById8;
        View findViewById9 = view.findViewById(R.id.rating_container);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.view.View");
        this.j = findViewById9;
        View findViewById10 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.k = (RatingBar) findViewById10;
        View findViewById11 = view.findViewById(R.id.rating_text);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.l = (TextView) findViewById11;
        View findViewById12 = view.findViewById(R.id.rating_number);
        Objects.requireNonNull(findViewById12, "null cannot be cast to non-null type android.widget.TextView");
        this.m = (TextView) findViewById12;
        this.n = context.getDrawable(R.drawable.ic_shield_16);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void hide() {
        Views.hide(this.o);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(userIconType, "userIconType");
        int ordinal = userIconType.ordinal();
        if (ordinal == 1) {
            Drawable drawable2 = this.a.getDrawable(R.drawable.ic_company_40);
            Context context = this.a;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        } else if (ordinal != 2) {
            drawable = null;
        } else {
            Drawable drawable3 = this.a.getDrawable(R.drawable.ic_shop_40);
            Context context2 = this.a;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            drawable = Contexts.getTintedDrawable(drawable3, Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28));
        }
        this.p.renderAvatar(this.b, picture, userIconType, drawable);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setContact(@Nullable CharSequence charSequence, @Nullable CharSequence charSequence2) {
        ViewGroup viewGroup = this.i;
        boolean z = true;
        if (charSequence == null || charSequence.length() == 0) {
            if (charSequence2 == null || charSequence2.length() == 0) {
                z = false;
            }
        }
        Views.setVisible(viewGroup, z);
        TextViews.bindText$default(this.g, charSequence, false, 2, null);
        TextView textView = this.h;
        if (charSequence2 == null) {
            charSequence2 = this.a.getString(R.string.profile_snippet_contact_name);
            Intrinsics.checkNotNullExpressionValue(charSequence2, "context.getString(R.stri…ile_snippet_contact_name)");
        }
        TextViews.bindText$default(textView, charSequence2, false, 2, null);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        if (function0 != null) {
            this.o.setOnClickListener(new a(function0));
        } else {
            this.o.setOnClickListener(null);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        if (r8 == null) goto L_0x005e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0066  */
    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRating(@org.jetbrains.annotations.Nullable java.lang.Float r7, boolean r8, @org.jetbrains.annotations.Nullable java.lang.CharSequence r9) {
        /*
            r6 = this;
            android.view.View r0 = r6.j
            r1 = 1
            r2 = 0
            if (r7 != 0) goto L_0x000b
            if (r9 == 0) goto L_0x0009
            goto L_0x000b
        L_0x0009:
            r3 = 0
            goto L_0x000c
        L_0x000b:
            r3 = 1
        L_0x000c:
            com.avito.android.util.Views.setVisible(r0, r3)
            com.avito.android.lib.design.rating.RatingBar r0 = r6.k
            r0.setFloatingRatingIsEnabled(r8)
            com.avito.android.lib.design.rating.RatingBar r0 = r6.k
            r3 = 0
            if (r7 == 0) goto L_0x001e
            float r4 = r7.floatValue()
            goto L_0x001f
        L_0x001e:
            r4 = 0
        L_0x001f:
            r0.setRating(r4)
            com.avito.android.lib.design.rating.RatingBar r0 = r6.k
            r4 = 0
            if (r7 == 0) goto L_0x0036
            float r5 = r7.floatValue()
            int r5 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r5 <= 0) goto L_0x0031
            r5 = 1
            goto L_0x0032
        L_0x0031:
            r5 = 0
        L_0x0032:
            if (r5 == 0) goto L_0x0036
            r5 = r7
            goto L_0x0037
        L_0x0036:
            r5 = r4
        L_0x0037:
            if (r5 == 0) goto L_0x003b
            r5 = 1
            goto L_0x003c
        L_0x003b:
            r5 = 0
        L_0x003c:
            com.avito.android.util.Views.setVisible(r0, r5)
            android.widget.TextView r0 = r6.l
            r5 = 2
            com.avito.android.util.TextViews.bindText$default(r0, r9, r2, r5, r4)
            android.widget.TextView r9 = r6.m
            if (r8 == 0) goto L_0x005e
            if (r7 == 0) goto L_0x005a
            float r8 = r7.floatValue()
            int r8 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r8 <= 0) goto L_0x0055
            r8 = 1
            goto L_0x0056
        L_0x0055:
            r8 = 0
        L_0x0056:
            if (r8 == 0) goto L_0x005a
            r8 = r7
            goto L_0x005b
        L_0x005a:
            r8 = r4
        L_0x005b:
            if (r8 == 0) goto L_0x005e
            goto L_0x005f
        L_0x005e:
            r1 = 0
        L_0x005f:
            com.avito.android.util.Views.setVisible(r9, r1)
            android.widget.TextView r8 = r6.m
            if (r7 == 0) goto L_0x006f
            float r7 = r7.floatValue()
            r9 = 3
            java.lang.String r4 = com.avito.android.util.FloatsKt.formatWithSeparator$default(r7, r4, r2, r9, r4)
        L_0x006f:
            r8.setText(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.component.profile_snippet.ProfileSnippetImpl.setRating(java.lang.Float, boolean, java.lang.CharSequence):void");
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setSubtitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.d, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setSummary(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.f, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.c, charSequence, false, 2, null);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void setVerification(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.e, charSequence, false, 2, null);
        TextViews.setCompoundDrawables$default(this.e, (Drawable) null, (Drawable) null, this.n, (Drawable) null, 11, (Object) null);
    }

    @Override // com.avito.android.component.profile_snippet.ProfileSnippet
    public void show() {
        Views.show(this.o);
    }
}
