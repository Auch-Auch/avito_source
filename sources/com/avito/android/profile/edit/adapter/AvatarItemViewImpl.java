package com.avito.android.profile.edit.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.avito.android.image_loader.Picture;
import com.avito.android.profile.R;
import com.avito.android.util.Contexts;
import com.avito.android.util.DrawablesKt;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001d\u0010\f\u001a\u00020\u00052\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nH\u0016¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0016\u001a\u00020\u000e8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0010\u001a\u0004\b\u0015\u0010\u0012¨\u0006\u001b"}, d2 = {"Lcom/avito/android/profile/edit/adapter/AvatarItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/profile/edit/adapter/AvatarItemView;", "Lcom/avito/android/image_loader/Picture;", "avatar", "", "setAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "clearAvatar", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getAvatarButtonView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "avatarButtonView", "s", "getAvatarView", "avatarView", "Landroid/view/View;", "rootView", "<init>", "(Landroid/view/View;)V", "profile_release"}, k = 1, mv = {1, 4, 2})
public final class AvatarItemViewImpl extends BaseViewHolder implements AvatarItemView {
    @NotNull
    public final SimpleDraweeView s;
    @NotNull
    public final SimpleDraweeView t;

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
    public AvatarItemViewImpl(@NotNull View view) {
        super(view);
        Drawable drawable;
        Intrinsics.checkNotNullParameter(view, "rootView");
        View findViewById = view.findViewById(R.id.avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.avatar_button_layer);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
        this.t = simpleDraweeView;
        Context context = view.getContext();
        Drawable drawable2 = context.getDrawable(com.avito.android.ui_components.R.drawable.ic_photo_camera_24);
        if (drawable2 != null) {
            Intrinsics.checkNotNullExpressionValue(context, "context");
            drawable = DrawablesKt.wrapForTinting(drawable2, Contexts.getColorByAttr(context, com.avito.android.lib.design.R.attr.constantWhite));
        } else {
            drawable = null;
        }
        ((GenericDraweeHierarchy) simpleDraweeView.getHierarchy()).setPlaceholderImage(drawable);
    }

    @Override // com.avito.android.profile.edit.adapter.AvatarItemView
    public void clearAvatar() {
        SimpleDraweeViewsKt.getRequestBuilder(this.s).clear();
    }

    @NotNull
    public final SimpleDraweeView getAvatarButtonView() {
        return this.t;
    }

    @NotNull
    public final SimpleDraweeView getAvatarView() {
        return this.s;
    }

    @Override // com.avito.android.profile.edit.adapter.AvatarItemView
    public void setAvatar(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "avatar");
        a2.b.a.a.a.L0(this.s, picture);
    }

    @Override // com.avito.android.profile.edit.adapter.AvatarItemView
    public void setOnClickListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.t.setOnClickListener(new a(function0));
    }
}
