package com.avito.android.social_management.adapter.notification;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import com.avito.android.lib.design.alert_banner.AlertBanner;
import com.avito.android.lib.design.alert_banner.AlertBannerContent;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.social_management.R;
import com.avito.android.util.text.AttributedTextFormatter;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u001f\u001a\u00020\u001c\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b \u0010!J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u001d\u0010\n\u001a\u00020\u00052\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\f\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\bH\u0016¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0014R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001e¨\u0006\""}, d2 = {"Lcom/avito/android/social_management/adapter/notification/NotificationItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/social_management/adapter/notification/NotificationItemView;", "Lcom/avito/android/remote/model/text/AttributedText;", "attributedText", "", "setText", "(Lcom/avito/android/remote/model/text/AttributedText;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setCrossClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "onUnbind", "()V", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "s", "Lcom/avito/android/lib/design/alert_banner/AlertBanner;", "banner", "t", "Lkotlin/jvm/functions/Function0;", "crossClickListener", "u", "unbindListener", "Lcom/avito/android/util/text/AttributedTextFormatter;", "w", "Lcom/avito/android/util/text/AttributedTextFormatter;", "attributedTextFormatter", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Lcom/avito/android/util/text/AttributedTextFormatter;)V", "social-network-editor_release"}, k = 1, mv = {1, 4, 2})
public final class NotificationItemViewImpl extends BaseViewHolder implements NotificationItemView {
    public final AlertBanner s;
    public Function0<Unit> t;
    public Function0<Unit> u;
    public final View v;
    public final AttributedTextFormatter w;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ NotificationItemViewImpl a;

        public a(NotificationItemViewImpl notificationItemViewImpl) {
            this.a = notificationItemViewImpl;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Function0 function0 = this.a.t;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NotificationItemViewImpl(@NotNull View view, @NotNull AttributedTextFormatter attributedTextFormatter) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(attributedTextFormatter, "attributedTextFormatter");
        this.v = view;
        this.w = attributedTextFormatter;
        View findViewById = view.findViewById(R.id.social_banner);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.social_banner)");
        AlertBanner alertBanner = (AlertBanner) findViewById;
        this.s = alertBanner;
        AlertBannerContent content = alertBanner.getContent();
        MovementMethod instance = LinkMovementMethod.getInstance();
        Intrinsics.checkNotNullExpressionValue(instance, "LinkMovementMethod.getInstance()");
        content.setBodyMovementMethod(instance);
        alertBanner.setCloseButtonListener(new a(this));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.u;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.social_management.adapter.notification.NotificationItemView
    public void setCrossClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t = function0;
    }

    @Override // com.avito.android.social_management.adapter.notification.NotificationItemView
    public void setText(@NotNull AttributedText attributedText) {
        Intrinsics.checkNotNullParameter(attributedText, "attributedText");
        AttributedTextFormatter attributedTextFormatter = this.w;
        Context context = this.v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        this.s.getContent().setBody(attributedTextFormatter.format(context, attributedText));
    }

    @Override // com.avito.android.social_management.adapter.notification.NotificationItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.u = function0;
    }
}
