package com.avito.android.extended_profile.adapter.category.category_advert.grid;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.avito.android.booking.info.BookingInfoActivity;
import com.avito.android.image_loader.ForegroundConverter;
import com.avito.android.image_loader.ForegroundConverterImpl;
import com.avito.android.image_loader.ImageRequest;
import com.avito.android.image_loader.Picture;
import com.avito.android.ui_components.R;
import com.avito.android.util.SimpleDraweeViewsKt;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import com.avito.android.util.text.AttributedTextFormatterImpl;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.internal.CheckableImageButton;
import com.google.firebase.analytics.FirebaseAnalytics;
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
import ru.avito.component.serp.HighlightDelegate;
import ru.avito.component.serp.PriceHighlightDelegate;
import ru.avito.component.serp.SerpAdvertTileCardKt;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u00106\u001a\u000203¢\u0006\u0004\bh\u0010iJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J!\u0010\u000b\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u000e\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u000e\u0010\u0007J\u0019\u0010\u0010\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0010\u0010\u0007J\u0019\u0010\u0012\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0012\u0010\u0007J\u0019\u0010\u0014\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0014\u0010\u0007J!\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\tH\u0017¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b!\u0010\u0007J\u0017\u0010#\u001a\u00020\u00052\u0006\u0010\"\u001a\u00020\tH\u0016¢\u0006\u0004\b#\u0010\u001dJ\u0017\u0010%\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b%\u0010&J\u001f\u0010)\u001a\u00020\u00052\u000e\u0010(\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010'H\u0016¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0005H\u0016¢\u0006\u0004\b+\u0010,R\u0016\u00100\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u0016\u00102\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b1\u0010/R\u0016\u00106\u001a\u0002038\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u00105R\"\u0010<\u001a\b\u0012\u0004\u0012\u00020\u0005078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b8\u00109\u001a\u0004\b:\u0010;R\u0016\u0010@\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010B\u001a\u00020=8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010?R\u0016\u0010D\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bC\u0010/R\"\u0010G\u001a\b\u0012\u0004\u0012\u00020\u0005078\u0016@\u0016X\u0004¢\u0006\f\n\u0004\bE\u00109\u001a\u0004\bF\u0010;R\u0016\u0010I\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bH\u0010/R\u0016\u0010M\u001a\u00020J8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bK\u0010LR\u001e\u0010P\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010'8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bN\u0010OR\u0016\u0010T\u001a\u00020Q8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bR\u0010SR\u0016\u0010X\u001a\u00020U8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bV\u0010WR\u0016\u0010Z\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bY\u0010/R\u0016\u0010^\u001a\u00020[8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\\\u0010]R\u0016\u0010`\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b_\u0010/R\u0016\u0010c\u001a\u00020a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b?\u0010bR\u0016\u0010e\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bd\u0010/R\u0016\u0010g\u001a\u00020-8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bf\u0010/¨\u0006j"}, d2 = {"Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/extended_profile/adapter/category/category_advert/grid/CategoryAdvertGridItemView;", "", "title", "", "setTitle", "(Ljava/lang/CharSequence;)V", "price", "", "isHighlighted", "setPrice", "(Ljava/lang/CharSequence;Z)V", "value", "setDiscount", "priceWithoutDiscount", "setPriceWithoutDiscount", "location", "setLocation", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "setAddress", "Lcom/avito/android/image_loader/Picture;", "picture", "", BookingInfoActivity.EXTRA_ITEM_ID, "setPicture", "(Lcom/avito/android/image_loader/Picture;Ljava/lang/String;)V", "visible", "setFavoriteVisible", "(Z)V", "favorite", "setFavorite", "description", "setDescription", "viewed", "setViewed", "Landroid/net/Uri;", "getPictureUri", "(Lcom/avito/android/image_loader/Picture;)Landroid/net/Uri;", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "onUnbind", "()V", "Landroid/widget/TextView;", "z", "Landroid/widget/TextView;", "addressView", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "descriptionView", "Landroid/view/View;", "K", "Landroid/view/View;", "rootView", "Lio/reactivex/rxjava3/core/Observable;", "J", "Lio/reactivex/rxjava3/core/Observable;", "getFavoriteClicks", "()Lio/reactivex/rxjava3/core/Observable;", "favoriteClicks", "", "H", "F", "viewedAlpha", "G", "activeAlpha", "y", FirebaseAnalytics.Param.DISCOUNT, "I", "getItemClicks", "itemClicks", "w", "priceView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "imageView", ExifInterface.LONGITUDE_EAST, "Lkotlin/jvm/functions/Function0;", "unbindListener", "Landroid/view/ViewGroup;", "s", "Landroid/view/ViewGroup;", "advertContent", "Lcom/google/android/material/internal/CheckableImageButton;", "B", "Lcom/google/android/material/internal/CheckableImageButton;", "favoriteButton", "C", "infoBadge", "Lru/avito/component/serp/HighlightDelegate;", "D", "Lru/avito/component/serp/HighlightDelegate;", "priceHighlighter", VKApiConst.VERSION, "locationView", "Lcom/avito/android/image_loader/ForegroundConverter;", "Lcom/avito/android/image_loader/ForegroundConverter;", "foregroundImageConverter", "x", "priceWithoutDiscountView", "u", "titleView", "<init>", "(Landroid/view/View;)V", "extended-profile_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryAdvertGridItemViewImpl extends BaseViewHolder implements CategoryAdvertGridItemView {
    public final TextView A;
    public final CheckableImageButton B;
    public final TextView C;
    public final HighlightDelegate D;
    public Function0<Unit> E;
    public final ForegroundConverter F = new ForegroundConverterImpl(new AttributedTextFormatterImpl());
    public final float G;
    public final float H;
    @NotNull
    public final Observable<Unit> I;
    @NotNull
    public final Observable<Unit> J;
    public final View K;
    public final ViewGroup s;
    public final SimpleDraweeView t;
    public final TextView u;
    public final TextView v;
    public final TextView w;
    public final TextView x;
    public final TextView y;
    public final TextView z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CategoryAdvertGridItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "rootView");
        this.K = view;
        View findViewById = view.findViewById(R.id.advert_content);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type android.view.ViewGroup");
        this.s = (ViewGroup) findViewById;
        View findViewById2 = view.findViewById(R.id.image);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        this.t = (SimpleDraweeView) findViewById2;
        View findViewById3 = view.findViewById(R.id.title);
        Objects.requireNonNull(findViewById3, "null cannot be cast to non-null type android.widget.TextView");
        this.u = (TextView) findViewById3;
        View findViewById4 = view.findViewById(R.id.location);
        Objects.requireNonNull(findViewById4, "null cannot be cast to non-null type android.widget.TextView");
        this.v = (TextView) findViewById4;
        View findViewById5 = view.findViewById(R.id.price);
        Objects.requireNonNull(findViewById5, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView = (TextView) findViewById5;
        this.w = textView;
        View findViewById6 = view.findViewById(R.id.price_without_discount);
        Objects.requireNonNull(findViewById6, "null cannot be cast to non-null type android.widget.TextView");
        this.x = (TextView) findViewById6;
        View findViewById7 = view.findViewById(R.id.discount);
        Objects.requireNonNull(findViewById7, "null cannot be cast to non-null type android.widget.TextView");
        this.y = (TextView) findViewById7;
        View findViewById8 = view.findViewById(R.id.address);
        Objects.requireNonNull(findViewById8, "null cannot be cast to non-null type android.widget.TextView");
        this.z = (TextView) findViewById8;
        View findViewById9 = view.findViewById(R.id.additional_name);
        Objects.requireNonNull(findViewById9, "null cannot be cast to non-null type android.widget.TextView");
        TextView textView2 = (TextView) findViewById9;
        this.A = textView2;
        View findViewById10 = view.findViewById(R.id.btn_favorite);
        Objects.requireNonNull(findViewById10, "null cannot be cast to non-null type com.google.android.material.internal.CheckableImageButton");
        CheckableImageButton checkableImageButton = (CheckableImageButton) findViewById10;
        this.B = checkableImageButton;
        View findViewById11 = view.findViewById(R.id.card_info_badge);
        Objects.requireNonNull(findViewById11, "null cannot be cast to non-null type android.widget.TextView");
        this.C = (TextView) findViewById11;
        this.D = new PriceHighlightDelegate(textView, true, true);
        this.I = RxView.clicks(view);
        this.J = RxView.clicks(checkableImageButton);
        TypedValue typedValue = new TypedValue();
        view.getResources().getValue(R.dimen.active_alpha, typedValue, true);
        this.G = typedValue.getFloat();
        view.getResources().getValue(R.dimen.viewed_alpha, typedValue, true);
        this.H = typedValue.getFloat();
        textView2.setMaxLines(2);
        textView2.setEllipsize(TextUtils.TruncateAt.END);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    @NotNull
    public Observable<Unit> getFavoriteClicks() {
        return this.J;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    @NotNull
    public Observable<Unit> getItemClicks() {
        return this.I;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    @NotNull
    public Uri getPictureUri(@NotNull Picture picture) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        return picture.getUri(this.t);
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        Function0<Unit> function0 = this.E;
        if (function0 != null) {
            function0.invoke();
        }
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setAddress(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.z, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setDescription(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.A, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setDiscount(@Nullable CharSequence charSequence) {
        SerpAdvertTileCardKt.applyClassifiedDiscountToViews$default(this.y, this.w, charSequence != null ? charSequence.toString() : null, true, false, 16, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    @SuppressLint({"RestrictedApi"})
    public void setFavorite(boolean z2) {
        this.B.setChecked(z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setFavoriteVisible(boolean z2) {
        Views.setVisible(this.B, z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setLocation(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.v, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setPicture(@NotNull Picture picture, @Nullable String str) {
        Intrinsics.checkNotNullParameter(picture, "picture");
        ForegroundConverter foregroundConverter = this.F;
        Context context = this.K.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "rootView.context");
        SimpleDraweeViewsKt.getRequestBuilder(this.t).picture(picture).foreground(ForegroundConverter.DefaultImpls.convert$default(foregroundConverter, context, picture, null, 4, null)).sourcePlace(ImageRequest.SourcePlace.SNIPPET).advertId(str).load();
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setPrice(@Nullable CharSequence charSequence, boolean z2) {
        this.D.setText(charSequence != null ? charSequence.toString() : null, z2);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setPriceWithoutDiscount(@Nullable CharSequence charSequence) {
        TextViews.bindText$default(this.x, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setTitle(@NotNull CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "title");
        TextViews.bindText$default(this.u, charSequence, false, 2, null);
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setUnbindListener(@Nullable Function0<Unit> function0) {
        this.E = function0;
    }

    @Override // com.avito.android.extended_profile.adapter.category.category_advert.grid.CategoryAdvertGridItemView
    public void setViewed(boolean z2) {
        if (z2) {
            this.s.setAlpha(this.H);
            Views.show(this.C);
            return;
        }
        this.s.setAlpha(this.G);
        Views.hide(this.C);
    }
}
