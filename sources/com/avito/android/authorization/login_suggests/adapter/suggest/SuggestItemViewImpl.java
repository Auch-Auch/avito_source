package com.avito.android.authorization.login_suggests.adapter.suggest;

import android.view.View;
import android.widget.TextView;
import com.avito.android.authorization.R;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.Image;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u001a\u001a\u00020\u0017¢\u0006\u0004\b(\u0010)J\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u0017\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0010J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u001a\u001a\u00020\u00178\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010\"\u001a\u00020\u001f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010$\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010\u001dR\u001e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b%\u0010&¨\u0006*"}, d2 = {"Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/authorization/login_suggests/adapter/suggest/SuggestItemView;", "Lio/reactivex/Observable;", "", "clicks", "()Lio/reactivex/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "", "name", "setName", "(Ljava/lang/String;)V", "hint", "setHint", "Lcom/avito/android/remote/model/Image;", "image", "setAvatar", "(Lcom/avito/android/remote/model/Image;)V", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "subtitleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "u", "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "s", "titleView", VKApiConst.VERSION, "Lkotlin/jvm/functions/Function0;", "unbindListener", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestItemViewImpl extends BaseViewHolder implements SuggestItemView {
    public final TextView s;
    public final TextView t;
    public final SimpleDraweeView u;
    public Function0<Unit> v;
    public final View w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.s = textView;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.t = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.u = (SimpleDraweeView) findViewById3;
        textView.setMaxLines(1);
    }

    @Override // com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.w);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.v;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemView
    public void setAvatar(@Nullable Image image) {
        SimpleDraweeViewsKt.getRequestBuilder(this.u).picture(AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null)).load();
    }

    @Override // com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemView
    public void setHint(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hint");
        TextViews.bindText$default(this.t, str, false, 2, null);
    }

    @Override // com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemView
    public void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.s.setText(str);
    }

    @Override // com.avito.android.authorization.login_suggests.adapter.suggest.SuggestItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.v = function0;
    }
}
