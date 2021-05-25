package com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner;

import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.user_adverts.R;
import com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemView;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0017\u001a\u00020\u0014¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u001d\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0004\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemViewImpl;", "Lcom/avito/android/user_adverts/tab_screens/advert_list/performance_vas_banner/PerformanceVasBannerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/android/image_loader/Picture;", "picture", "setPicture", "(Lcom/avito/android/image_loader/Picture;)V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "icon", "Landroid/view/View;", "u", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "s", "Landroid/widget/TextView;", "<init>", "(Landroid/view/View;)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public final class PerformanceVasBannerItemViewImpl extends BaseViewHolder implements PerformanceVasBannerItemView {
    public final TextView s;
    public final SimpleDraweeView t;
    public final View u;

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
    public PerformanceVasBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.u = view;
        View findViewById = view.findViewById(R.id.title);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.title)");
        this.s = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.icon);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.icon)");
        this.t = (SimpleDraweeView) findViewById2;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        PerformanceVasBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemView
    public void setClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.u.setOnClickListener(new a(function0));
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemView
    public void setPicture(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        a2.b.a.a.a.L0(this.t, picture);
    }

    @Override // com.avito.android.user_adverts.tab_screens.advert_list.performance_vas_banner.PerformanceVasBannerItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.s.setText(str);
    }
}
