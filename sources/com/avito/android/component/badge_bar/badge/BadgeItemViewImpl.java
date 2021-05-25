package com.avito.android.component.badge_bar.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import com.avito.android.component.badge_bar.badge.BadgeItemView;
import com.avito.android.lib.design.avito.R;
import com.avito.android.lib.expected.badge_bar.AdvertBadgeView;
import com.avito.android.lib.expected.badge_bar.AdvertBadgeViewsKt;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.UniversalColor;
import com.avito.android.util.color.ContextsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020 ¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J#\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0015\u0010\u0014J\u0019\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u001c\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u001f\u0010\u0014R\u0016\u0010#\u001a\u00020 8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/component/badge_bar/badge/BadgeItemViewImpl;", "Lcom/avito/android/component/badge_bar/badge/BadgeItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "description", "setDescription", "Lcom/avito/android/remote/model/UniversalColor;", "color", "rippleColor", "setBackground", "(Lcom/avito/android/remote/model/UniversalColor;Lcom/avito/android/remote/model/UniversalColor;)V", "setTextColor", "(Lcom/avito/android/remote/model/UniversalColor;)V", "", "maxLines", "setTitleMaxLines", "(I)V", "setDescriptionMaxLines", "Lcom/avito/android/remote/model/Image;", "image", "setImage", "(Lcom/avito/android/remote/model/Image;)V", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Landroid/view/View$OnClickListener;)V", "imageRes", "setLocalHardcodedImage", "Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;", "s", "Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;", "view", "<init>", "(Lcom/avito/android/lib/expected/badge_bar/AdvertBadgeView;)V", "ui-components_release"}, k = 1, mv = {1, 4, 2})
public final class BadgeItemViewImpl extends BaseViewHolder implements BadgeItemView {
    public final AdvertBadgeView s;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BadgeItemViewImpl(@NotNull AdvertBadgeView advertBadgeView) {
        super(advertBadgeView);
        Intrinsics.checkNotNullParameter(advertBadgeView, "view");
        this.s = advertBadgeView;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        BadgeItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setBackground(@Nullable UniversalColor universalColor, @Nullable UniversalColor universalColor2) {
        Context context = this.s.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        int i = R.color.avito_white;
        int colorFrom = ContextsKt.getColorFrom(context, universalColor, i);
        Context context2 = this.s.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "view.context");
        int colorFrom2 = ContextsKt.getColorFrom(context2, universalColor2, i);
        AdvertBadgeView advertBadgeView = this.s;
        ColorStateList valueOf = ColorStateList.valueOf(colorFrom);
        Intrinsics.checkNotNullExpressionValue(valueOf, "ColorStateList.valueOf(backgroundColor)");
        ColorStateList valueOf2 = ColorStateList.valueOf(colorFrom2);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "ColorStateList.valueOf(ripple)");
        advertBadgeView.setBackground(valueOf, valueOf2);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "description");
        this.s.setSubtitle(str);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setDescriptionMaxLines(int i) {
        this.s.setSubtitleMaxLines(i);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setImage(@Nullable Image image) {
        if (image != null) {
            AdvertBadgeViewsKt.loadImage(this.s, image);
        } else {
            this.s.showIconLoading();
        }
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setLocalHardcodedImage(int i) {
        AdvertBadgeViewsKt.setImage(this.s, i);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setOnClickListener(@Nullable View.OnClickListener onClickListener) {
        this.s.setOnClickListener(onClickListener);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setTextColor(@Nullable UniversalColor universalColor) {
        Context context = this.s.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s.setTextColor(ContextsKt.getColorFrom(context, universalColor, R.color.avito_black));
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setTitle(str);
    }

    @Override // com.avito.android.component.badge_bar.badge.BadgeItemView
    public void setTitleMaxLines(int i) {
        this.s.setTitleMaxLines(i);
    }
}
