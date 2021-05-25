package com.avito.android.notification_center.landing.recommends.item.title;

import android.view.View;
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
import ru.avito.component.button.ButtonImpl;
import ru.avito.component.text.TextImpl;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\u000b\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0010\u001a\u00020\u00032\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006 "}, d2 = {"Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/notification_center/landing/recommends/item/title/NotificationCenterLandingRecommendsTitleItemView;", "", "onUnbind", "()V", "", "titleText", "setTitleText", "(Ljava/lang/String;)V", "buttonText", "setButtonText", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "Lru/avito/component/text/TextImpl;", "s", "Lru/avito/component/text/TextImpl;", "titleView", "u", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lru/avito/component/button/ButtonImpl;", "t", "Lru/avito/component/button/ButtonImpl;", "buttonView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "notification-center_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationCenterLandingRecommendsTitleItemViewImpl extends BaseViewHolder implements NotificationCenterLandingRecommendsTitleItemView {
    public final TextImpl s;
    public final ButtonImpl t;
    public Function0<Unit> u;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationCenterLandingRecommendsTitleItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.View");
        this.s = new TextImpl(findViewById);
        View findViewById2 = view.findViewById(R.id.button);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.view.View");
        this.t = new ButtonImpl(findViewById2);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemView
    public void setButtonText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "buttonText");
        this.t.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemView
    public void setClickListener(@Nullable Function0<Unit> function0) {
        this.t.setClickListener(function0);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemView
    public void setTitleText(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "titleText");
        this.s.setText(str);
    }

    @Override // com.avito.android.notification_center.landing.recommends.item.title.NotificationCenterLandingRecommendsTitleItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }
}
