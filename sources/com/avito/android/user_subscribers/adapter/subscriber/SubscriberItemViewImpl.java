package com.avito.android.user_subscribers.adapter.subscriber;

import android.view.View;
import android.widget.TextView;
import com.avito.android.image_loader.Picture;
import com.avito.android.user_subscribers.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding3.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u0018¢\u0006\u0004\b)\u0010*J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000f\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0019\u0010\u0011\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0004\b\u0011\u0010\u0010J\u0017\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0017\u001a\u00020\u00042\b\u0010\u0016\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0017\u0010\u0015R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001f\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u001e\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0013\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010'\u001a\u00020\u001c8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010\u001eR\u0016\u0010\u0016\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010%¨\u0006+"}, d2 = {"Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/user_subscribers/adapter/subscriber/SubscriberItemView;", "Lio/reactivex/Observable;", "", "clicks", "()Lio/reactivex/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setUserAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setShopAvatar", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "description", "setDescription", "Landroid/view/View;", "x", "Landroid/view/View;", "view", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "shopAvatar", "w", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "s", "userAvatar", VKApiConst.VERSION, "<init>", "(Landroid/view/View;)V", "user-subscribers_release"}, k = 1, mv = {1, 4, 2})
public final class SubscriberItemViewImpl extends BaseViewHolder implements SubscriberItemView {
    public final SimpleDraweeView s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public Function0<Unit> w;
    public final View x;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SubscriberItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.x = view;
        View findViewById = view.findViewById(R.id.user_avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_avatar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.description);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.x);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.w;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    public void setShopAvatar(@Nullable Picture picture) {
        Views.hide(this.s);
        Views.show(this.t);
        SimpleDraweeViewsKt.loadPicture$default(this.t, picture, null, null, 6, null);
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        this.u.setText(charSequence);
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.w = function0;
    }

    @Override // com.avito.android.user_subscribers.adapter.subscriber.SubscriberItemView
    public void setUserAvatar(@Nullable Picture picture) {
        Views.hide(this.t);
        Views.show(this.s);
        SimpleDraweeViewsKt.loadPicture$default(this.s, picture, null, null, 6, null);
    }
}
