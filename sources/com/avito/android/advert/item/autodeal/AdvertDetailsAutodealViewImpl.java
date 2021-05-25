package com.avito.android.advert.item.autodeal;

import android.view.View;
import android.widget.TextView;
import com.avito.android.advert_details.R;
import com.avito.android.remote.model.AutoDeal;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\f¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0012R\u0016\u0010\u0004\u001a\u00020\u00038\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/autodeal/AdvertDetailsAutodealView;", "Landroid/view/View$OnClickListener;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "", "setListener", "(Landroid/view/View$OnClickListener;)V", "Lcom/avito/android/remote/model/AutoDeal;", "autoDeal", "showAutodeal", "(Lcom/avito/android/remote/model/AutoDeal;)V", "Landroid/view/View;", "s", "Landroid/view/View;", "rootView", "Landroid/widget/TextView;", VKApiConst.VERSION, "Landroid/widget/TextView;", "buttonView", "u", "subTitleView", "w", "Landroid/view/View$OnClickListener;", "t", "titleView", "view", "<init>", "(Landroid/view/View;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsAutodealViewImpl extends BaseViewHolder implements AdvertDetailsAutodealView {
    public View s;
    public TextView t;
    public TextView u;
    public TextView v;
    public View.OnClickListener w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsAutodealViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.autodeal_container);
        this.s = findViewById;
        TextView textView = null;
        this.t = findViewById != null ? (TextView) findViewById.findViewById(R.id.title) : null;
        View view2 = this.s;
        this.u = view2 != null ? (TextView) view2.findViewById(R.id.sub_title) : null;
        View view3 = this.s;
        this.v = view3 != null ? (TextView) view3.findViewById(R.id.button) : textView;
    }

    @Override // com.avito.android.advert.item.autodeal.AdvertDetailsAutodealView
    public void setListener(@NotNull View.OnClickListener onClickListener) {
        Intrinsics.checkNotNullParameter(onClickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.w = onClickListener;
    }

    @Override // com.avito.android.advert.item.autodeal.AdvertDetailsAutodealView
    public void showAutodeal(@NotNull AutoDeal autoDeal) {
        Intrinsics.checkNotNullParameter(autoDeal, "autoDeal");
        TextView textView = this.t;
        if (textView != null) {
            TextViews.bindText$default(textView, autoDeal.getTitle(), false, 2, null);
        }
        TextView textView2 = this.u;
        if (textView2 != null) {
            TextViews.bindText$default(textView2, autoDeal.getDescription(), false, 2, null);
        }
        TextView textView3 = this.v;
        if (textView3 != null) {
            TextViews.bindText$default(textView3, autoDeal.getAction().getTitle(), false, 2, null);
        }
        TextView textView4 = this.v;
        if (textView4 != null) {
            View.OnClickListener onClickListener = this.w;
            if (onClickListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException(ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            }
            textView4.setOnClickListener(onClickListener);
        }
    }
}
