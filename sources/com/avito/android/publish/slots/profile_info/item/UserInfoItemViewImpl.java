package com.avito.android.publish.slots.profile_info.item;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import com.avito.android.component.profile_snippet.AvatarRenderer;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.rating.RatingBar;
import com.avito.android.remote.model.advert_details.UserIconType;
import com.avito.android.ui_components.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.vk.sdk.api.VKApiConst;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010.\u001a\u00020*\u0012\u0006\u0010\u001e\u001a\u00020\u001b¢\u0006\u0004\b/\u00100J\u0019\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J#\u0010\u000b\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\n\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\fJ!\u0010\u0011\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001e\u0010#\u001a\n  *\u0004\u0018\u00010\u001f0\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010)\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0019R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00061"}, d2 = {"Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/publish/slots/profile_info/item/UserInfoItemView;", "", "name", "", "setName", "(Ljava/lang/String;)V", "", "score", "text", "setRating", "(Ljava/lang/Float;Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "image", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "setAvatar", "(Lcom/avito/android/image_loader/Picture;Lcom/avito/android/remote/model/advert_details/UserIconType;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "y", "Lcom/avito/android/component/profile_snippet/AvatarRenderer;", "avatarRenderer", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "s", "Landroid/content/Context;", "context", "Lcom/avito/android/lib/design/rating/RatingBar;", "w", "Lcom/avito/android/lib/design/rating/RatingBar;", "ratingView", "x", "ratingTextView", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "ratingContainer", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/component/profile_snippet/AvatarRenderer;)V", "publish_release"}, k = 1, mv = {1, 4, 2})
public final class UserInfoItemViewImpl extends BaseViewHolder implements UserInfoItemView {
    public final Context s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final View v;
    public final RatingBar w;
    public final TextView x;
    public final AvatarRenderer y;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public UserInfoItemViewImpl(@NotNull View view, @NotNull AvatarRenderer avatarRenderer) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(avatarRenderer, "avatarRenderer");
        this.y = avatarRenderer;
        this.s = view.getContext();
        View findViewById = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rating_container);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.view.View");
        this.v = findViewById3;
        View findViewById4 = view.findViewById(R.id.rating);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type com.avito.android.lib.design.rating.RatingBar");
        this.w = (RatingBar) findViewById4;
        View findViewById5 = view.findViewById(R.id.rating_text);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById5;
    }

    @Override // com.avito.android.publish.slots.profile_info.item.UserInfoItemView
    public void setAvatar(@Nullable Picture picture, @NotNull UserIconType userIconType) {
        Drawable drawable;
        Intrinsics.checkNotNullParameter(userIconType, "iconType");
        int ordinal = userIconType.ordinal();
        if (ordinal == 1) {
            Drawable drawable2 = this.s.getDrawable(R.drawable.ic_company_40);
            Context context = this.s;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = Contexts.getTintedDrawable(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.gray28));
        } else if (ordinal != 2) {
            drawable = null;
        } else {
            Drawable drawable3 = this.s.getDrawable(R.drawable.ic_shop_40);
            Context context2 = this.s;
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            drawable = Contexts.getTintedDrawable(drawable3, Contexts.getColorByAttr(context2, com.avito.android.lib.design.R.attr.gray28));
        }
        this.y.renderAvatar(this.t, picture, userIconType, drawable);
    }

    @Override // com.avito.android.publish.slots.profile_info.item.UserInfoItemView
    public void setName(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
        if ((r7.floatValue() > 0.0f) != false) goto L_0x0038;
     */
    @Override // com.avito.android.publish.slots.profile_info.item.UserInfoItemView
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setRating(@org.jetbrains.annotations.Nullable java.lang.Float r7, @org.jetbrains.annotations.Nullable java.lang.String r8) {
        /*
            r6 = this;
            r0 = 0
            if (r7 != 0) goto L_0x000b
            if (r8 != 0) goto L_0x000b
            android.view.View r7 = r6.v
            com.avito.android.util.Views.setVisible(r7, r0)
            return
        L_0x000b:
            android.view.View r1 = r6.v
            r2 = 1
            com.avito.android.util.Views.setVisible(r1, r2)
            com.avito.android.lib.design.rating.RatingBar r1 = r6.w
            r1.setFloatingRatingIsEnabled(r2)
            com.avito.android.lib.design.rating.RatingBar r1 = r6.w
            r3 = 0
            if (r7 == 0) goto L_0x0020
            float r4 = r7.floatValue()
            goto L_0x0021
        L_0x0020:
            r4 = 0
        L_0x0021:
            r1.setRating(r4)
            com.avito.android.lib.design.rating.RatingBar r1 = r6.w
            r4 = 0
            if (r7 == 0) goto L_0x0037
            float r5 = r7.floatValue()
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0033
            r3 = 1
            goto L_0x0034
        L_0x0033:
            r3 = 0
        L_0x0034:
            if (r3 == 0) goto L_0x0037
            goto L_0x0038
        L_0x0037:
            r7 = r4
        L_0x0038:
            if (r7 == 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            com.avito.android.util.Views.setVisible(r1, r2)
            android.widget.TextView r7 = r6.x
            r1 = 2
            com.avito.android.util.TextViews.bindText$default(r7, r8, r0, r1, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.publish.slots.profile_info.item.UserInfoItemViewImpl.setRating(java.lang.Float, java.lang.String):void");
    }
}
