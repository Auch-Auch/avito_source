package com.avito.android.notification_center.landing.recommends.item.review;

import android.view.View;
import androidx.annotation.StringRes;
import com.avito.android.notification_center.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.avito.component.button_panel.ButtonPanel;
import ru.avito.component.button_panel.ButtonPanelImpl;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u000f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u001f\u0010\f\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u0013\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u0013\u0010\u0017J \u0010\u0018\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u0018\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0019\u0010\u0010J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0011H\u0001¢\u0006\u0004\b\u001a\u0010\u0014J\u001a\u0010\u001a\u001a\u00020\u00042\b\b\u0001\u0010\u0016\u001a\u00020\u0015H\u0001¢\u0006\u0004\b\u001a\u0010\u0017J\u0018\u0010\u001c\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\rH\u0001¢\u0006\u0004\b\u001c\u0010\u0010J \u0010\u001d\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0001¢\u0006\u0004\b\u001d\u0010\nR\u001e\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006%"}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/recommends/item/review/NotificationCenterLandingRecommendsReviewItemView;", "Lru/avito/component/button_panel/ButtonPanel;", "", "onUnbind", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setPositiveClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setNegativeClickListener", "setUnbindListener", "", "enabled", "setPrimaryButtonEnabled", "(Z)V", "", "text", "setPrimaryButtonText", "(Ljava/lang/CharSequence;)V", "", "textId", "(I)V", "setPrimaryClickListener", "setSecondaryButtonEnabled", "setSecondaryButtonText", "visible", "setSecondaryButtonVisible", "setSecondaryClickListener", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsReviewItemViewImpl extends BaseViewHolder implements NotificationCenterLandingRecommendsReviewItemView, ButtonPanel {
    public Function0<Unit> s;
    public final /* synthetic */ ButtonPanelImpl t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterLandingRecommendsReviewItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.t = new ButtonPanelImpl(view);
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        new TextImpl(findViewById).setText(com.avito.android.ui_components.R.string.notification_center_recommends_review_title);
        setPrimaryButtonText(com.avito.android.ui_components.R.string.notification_center_recommends_review_no);
        setSecondaryButtonText(com.avito.android.ui_components.R.string.notification_center_recommends_review_yes);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemView
    public void setNegativeClickListener(@Nullable Function0<Unit> function0) {
        setPrimaryClickListener(function0);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemView
    public void setPositiveClickListener(@Nullable Function0<Unit> function0) {
        setSecondaryClickListener(function0);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonEnabled(boolean z) {
        this.t.setPrimaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@StringRes int i) {
        this.t.setPrimaryButtonText(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryButtonText(@Nullable CharSequence charSequence) {
        this.t.setPrimaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setPrimaryClickListener(@Nullable Function0<Unit> function0) {
        this.t.setPrimaryClickListener(function0);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonEnabled(boolean z) {
        this.t.setSecondaryButtonEnabled(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@StringRes int i) {
        this.t.setSecondaryButtonText(i);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonText(@Nullable CharSequence charSequence) {
        this.t.setSecondaryButtonText(charSequence);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryButtonVisible(boolean z) {
        this.t.setSecondaryButtonVisible(z);
    }

    @Override // ru.avito.component.button_panel.ButtonPanel
    public void setSecondaryClickListener(@Nullable Function0<Unit> function0) {
        this.t.setSecondaryClickListener(function0);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.review.NotificationCenterLandingRecommendsReviewItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }
}
