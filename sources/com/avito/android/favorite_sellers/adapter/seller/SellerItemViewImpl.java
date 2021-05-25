package com.avito.android.favorite_sellers.adapter.seller;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.favorite_sellers_items.R;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.button.Button;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007*\u00013\u0018\u00002\u00020\u00012\u00020\u0002:\u0001IB\u000f\u0012\u0006\u0010.\u001a\u00020+¢\u0006\u0004\bG\u0010HJ\u0015\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\t\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u000b\u001a\u00020\u00042\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0010\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0004\b\u0012\u0010\u0011J\u0019\u0010\u0015\u001a\u00020\u00042\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J!\u0010\u001a\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u0018H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020$8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001e\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0016\u0010.\u001a\u00020+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0016\u00102\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\u0016\u00108\u001a\u00020/8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00101R\u0016\u0010<\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010>\u001a\u0002098\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b=\u0010;R\u0016\u0010B\u001a\u00020?8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b@\u0010AR\u0016\u0010F\u001a\u00020C8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006J"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemView;", "Lio/reactivex/rxjava3/core/Observable;", "", "moreButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setOnClickListener", "(Lkotlin/jvm/functions/Function0;)V", "setUnbindListener", "onUnbind", "()V", "Lcom/avito/android/image_loader/Picture;", "avatar", "setUserAvatar", "(Lcom/avito/android/image_loader/Picture;)V", "setShopAvatar", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", MessengerShareContentUtility.SUBTITLE, "", "maxLines", "setSubtitle", "(Ljava/lang/CharSequence;I)V", "", "isDisabled", "setDisabled", "(Z)V", "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$NewItemsIndicatorState;", "state", "setNewItemsIndicatorState", "(Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$NewItemsIndicatorState;)V", "Landroid/view/ViewGroup;", "x", "Landroid/view/ViewGroup;", "content", "z", "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/View;", "B", "Landroid/view/View;", "view", "Landroid/widget/TextView;", "u", "Landroid/widget/TextView;", "titleView", "com/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$shopAvatarImageListener$1", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$shopAvatarImageListener$1;", "shopAvatarImageListener", VKApiConst.VERSION, "subtitleView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "s", "Lcom/facebook/drawee/view/SimpleDraweeView;", "userAvatarView", "t", "shopAvatarView", "Landroid/widget/ImageView;", "y", "Landroid/widget/ImageView;", "newItemsIndicator", "Lcom/avito/android/lib/design/button/Button;", "w", "Lcom/avito/android/lib/design/button/Button;", "moreButton", "<init>", "(Landroid/view/View;)V", "NewItemsIndicatorState", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
public final class SellerItemViewImpl extends BaseViewHolder implements SellerItemView {
    public final SellerItemViewImpl$shopAvatarImageListener$1 A = new SellerItemViewImpl$shopAvatarImageListener$1(this);
    public final View B;
    public final SimpleDraweeView s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final Button w;
    public final ViewGroup x;
    public final ImageView y;
    public Function0<Unit> z;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/favorite_sellers/adapter/seller/SellerItemViewImpl$NewItemsIndicatorState;", "", "<init>", "(Ljava/lang/String;I)V", "RED", "GRAY", "HIDDEN", "favorite-sellers-items_release"}, k = 1, mv = {1, 4, 2})
    public enum NewItemsIndicatorState {
        RED,
        GRAY,
        HIDDEN
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            NewItemsIndicatorState.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[0] = 1;
            iArr[1] = 2;
            iArr[2] = 3;
        }
    }

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
    public SellerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.B = view;
        View findViewById = view.findViewById(R.id.user_avatar);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.s = (SimpleDraweeView) findViewById;
        View findViewById2 = view.findViewById(R.id.shop_avatar);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.subtitle);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.btn_more);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        this.w = (Button) findViewById5;
        View findViewById6 = view.findViewById(R.id.content);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.view.ViewGroup");
        this.x = (ViewGroup) findViewById6;
        View findViewById7 = view.findViewById(R.id.new_items_indicator);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.ImageView");
        this.y = (ImageView) findViewById7;
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    @NotNull
    public Observable<Unit> moreButtonClicks() {
        return InteropKt.toV3(RxView.clicks(this.w));
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.z;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setDisabled(boolean z2) {
        this.x.setAlpha(z2 ? 0.5f : 1.0f);
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setNewItemsIndicatorState(@NotNull NewItemsIndicatorState newItemsIndicatorState) {
        Intrinsics.checkNotNullParameter(newItemsIndicatorState, "state");
        ImageView imageView = this.y;
        int ordinal = newItemsIndicatorState.ordinal();
        if (ordinal == 0) {
            imageView.setImageResource(R.drawable.new_items_indicator_red);
            Views.show(imageView);
        } else if (ordinal == 1) {
            imageView.setImageResource(R.drawable.new_items_indicator_gray);
            Views.show(imageView);
        } else if (ordinal == 2) {
            Views.hide(imageView);
        }
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setOnClickListener(@Nullable Function0<Unit> function0) {
        this.B.setOnClickListener(function0 != null ? new a(function0) : null);
        this.B.setClickable(function0 != null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setShopAvatar(@Nullable Picture picture) {
        Views.hide(this.s);
        Views.show(this.t);
        SimpleDraweeViewsKt.loadPicture(this.t, picture, this.A);
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setSubtitle(@Nullable CharSequence charSequence, int i) {
        boolean z2 = false;
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
        this.v.setMaxLines(i);
        TextView textView = this.v;
        if (i == 1) {
            z2 = true;
        }
        textView.setSingleLine(z2);
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setTitle(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.z = function0;
    }

    @Override // com.avito.android.favorite_sellers.adapter.seller.SellerItemView
    public void setUserAvatar(@Nullable Picture picture) {
        Views.hide(this.t);
        Views.show(this.s);
        SimpleDraweeViewsKt.loadPicture$default(this.s, picture, null, null, 6, null);
    }
}
