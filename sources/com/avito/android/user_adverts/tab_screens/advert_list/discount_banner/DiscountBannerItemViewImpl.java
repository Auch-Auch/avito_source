package com.avito.android.user_adverts.tab_screens.advert_list.discount_banner;

import android.view.View;
import android.widget.TextView;
import com.avito.android.component.timer.CountDownTimerWidget;
import com.avito.android.user_adverts.R;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010#\u001a\u00020\"¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u000b\u0010\u0007J\u0017\u0010\u000e\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u001d\u0010\u0014\u001a\u00020\u00052\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001f\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001cR\u0016\u0010!\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010\u001c¨\u0006&"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/discount_banner/DiscountBannerItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "limit", "setLimitDescription", FirebaseAnalytics.Param.DISCOUNT, "setDiscountAmount", "", "finishDate", "showDiscountTimer", "(J)V", "hideDiscountTimer", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/component/timer/CountDownTimerWidget;", VKApiConst.VERSION, "Lcom/avito/android/component/timer/CountDownTimerWidget;", "timerWidget", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "limitView", "s", "titleView", "t", "discountView", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class DiscountBannerItemViewImpl extends BaseViewHolder implements DiscountBannerItemView {
    public final TextView s;
    public final TextView t;
    public final TextView u;
    public final CountDownTimerWidget v;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DiscountBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.title_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title_view)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.discount_amount_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.discount_amount_view)");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.discount_limit_view);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.discount_limit_view)");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.timer_widget);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.timer_widget)");
        this.v = (CountDownTimerWidget) findViewById4;
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void hideDiscountTimer() {
        Views.hide(this.v);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemView.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void setDiscountAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, FirebaseAnalytics.Param.DISCOUNT);
        this.t.setText(str);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void setLimitDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "limit");
        this.u.setText(str);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.discount_banner.DiscountBannerItemView
    public void showDiscountTimer(long j) {
        this.v.setFinishDate(j);
        Views.show(this.v);
    }
}
