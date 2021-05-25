package com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.util.TextViews;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b$\u0010%J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\n\u001a\u00020\u00052\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\bH\u0016¢\u0006\u0004\b\r\u0010\u000bJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001c\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u0019R\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u001e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b!\u0010\"¨\u0006&"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/advert_list/adapter/other_adverts/OtherAdvertsItemView;", "", "widthPx", "", "setWidth", "(I)V", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "subtitleView", "t", "titleView", "Landroid/view/View;", VKApiConst.VERSION, "Landroid/view/View;", "view", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "<init>", "(Landroid/view/View;)V", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class OtherAdvertsItemViewImpl extends BaseViewHolder implements OtherAdvertsItemView {
    public Function0<Unit> s;
    public final TextView t;
    public final TextView u;
    public final View v;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OtherAdvertsItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.v = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemView
    @NotNull
    public Observable<Unit> clicks() {
        return InteropKt.toV3(RxView.clicks(this.v));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemView
    public void setSubtitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.t, charSequence, false, 2, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }

    @Override // com.avito.android.favorite_sellers.adapter.advert_list.adapter.other_adverts.OtherAdvertsItemView
    public void setWidth(int i) {
        ViewGroup.LayoutParams layoutParams = this.v.getLayoutParams();
        layoutParams.width = i;
        this.v.setLayoutParams(layoutParams);
    }
}
