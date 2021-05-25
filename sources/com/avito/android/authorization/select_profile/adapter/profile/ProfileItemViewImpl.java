package com.avito.android.authorization.select_profile.adapter.profile;

import android.view.View;
import android.widget.TextView;
import com.avito.android.authorization.R;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.remote.model.Image;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020\"¢\u0006\u0004\b(\u0010)J\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0019\u0010\t\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u0017\u0010\f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u001e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00118\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010 ¨\u0006*"}, d2 = {"Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/authorization/select_profile/adapter/profile/ProfileItemView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", MessengerShareContentUtility.SUBTITLE, "setSubtitle", "Lcom/avito/android/remote/model/Image;", "avatar", "setAvatar", "(Lcom/avito/android/remote/model/Image;)V", "Lio/reactivex/rxjava3/core/Observable;", "clicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "s", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Lcom/facebook/drawee/view/SimpleDraweeView;", VKApiConst.VERSION, "Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarView", "Landroid/widget/TextView;", "t", "Landroid/widget/TextView;", "titleView", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "u", "subtitleView", "<init>", "(Landroid/view/View;)V", "authorization_release"}, k = 1, mv = {1, 4, 2})
public final class ProfileItemViewImpl extends BaseViewHolder implements ProfileItemView {
    public Function0<Unit> s;
    public final TextView t;
    public final TextView u;
    public final SimpleDraweeView v;
    public final View w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProfileItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById;
        this.t = textView;
        View findViewById2 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.v = (SimpleDraweeView) findViewById3;
        textView.setMaxLines(1);
    }

    @Override // com.avito.android.authorization.select_profile.adapter.profile.ProfileItemView
    @NotNull
    public Observable<Unit> clicks() {
        return RxView.clicks(this.w);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.s;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.authorization.select_profile.adapter.profile.ProfileItemView
    public void setAvatar(@NotNull Image image) {
        Intrinsics.checkNotNullParameter(image, "avatar");
        SimpleDraweeViewsKt.getRequestBuilder(this.v).picture(AvitoPictureKt.pictureOf$default(image, true, 0.0f, 0.0f, null, 28, null)).load();
    }

    @Override // com.avito.android.authorization.select_profile.adapter.profile.ProfileItemView
    public void setSubtitle(@Nullable String str) {
        TextViews.bindText$default(this.u, str, false, 2, null);
    }

    @Override // com.avito.android.authorization.select_profile.adapter.profile.ProfileItemView
    public void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "title");
        this.t.setText(str);
    }

    @Override // com.avito.android.authorization.select_profile.adapter.profile.ProfileItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.s = function0;
    }
}
