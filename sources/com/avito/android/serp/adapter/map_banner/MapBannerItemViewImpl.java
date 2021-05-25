package com.avito.android.serp.adapter.map_banner;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.avito.android.lib.design.button.Button;
import com.avito.android.lib.design.button.ButtonsKt;
import com.avito.android.lib.util.DarkThemeManagerKt;
import com.avito.android.serp.adapter.map_banner.MapBannerItemView;
import com.avito.android.ui_components.R;
import com.avito.konveyor.adapter.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.jakewharton.rxbinding4.view.RxView;
import com.vk.sdk.api.VKApiConst;
import io.reactivex.rxjava3.core.Observable;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0004\b\"\u0010#J#\u0010\u0007\u001a\u00020\u00062\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u00118\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0013\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006$"}, d2 = {"Lcom/avito/android/serp/adapter/map_banner/MapBannerItemViewImpl;", "Lcom/avito/android/serp/adapter/map_banner/MapBannerItemView;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Landroid/net/Uri;", "darkMapScreenUri", "lightMapScreenUri", "", "setImage", "(Landroid/net/Uri;Landroid/net/Uri;)V", "", "buttonText", "setButtonText", "(Ljava/lang/String;)V", "Landroid/view/View;", "w", "Landroid/view/View;", "view", "Lio/reactivex/rxjava3/core/Observable;", "u", "Lio/reactivex/rxjava3/core/Observable;", "getButtonClicks", "()Lio/reactivex/rxjava3/core/Observable;", "buttonClicks", VKApiConst.VERSION, "getMapImageClicks", "mapImageClicks", "Lcom/facebook/drawee/view/SimpleDraweeView;", "t", "Lcom/facebook/drawee/view/SimpleDraweeView;", "mapImage", "Lcom/avito/android/lib/design/button/Button;", "s", "Lcom/avito/android/lib/design/button/Button;", "goToMapButton", "<init>", "(Landroid/view/View;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class MapBannerItemViewImpl extends BaseViewHolder implements MapBannerItemView {
    public final Button s;
    public final SimpleDraweeView t;
    @NotNull
    public final Observable<Unit> u;
    @NotNull
    public final Observable<Unit> v;
    public View w;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MapBannerItemViewImpl(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        this.w = view;
        View findViewById = view.findViewById(R.id.goToMapButton);
        Objects.requireNonNull(findViewById, "null cannot be cast to non-null type com.avito.android.lib.design.button.Button");
        Button button = (Button) findViewById;
        this.s = button;
        View findViewById2 = this.w.findViewById(R.id.mapImage);
        Objects.requireNonNull(findViewById2, "null cannot be cast to non-null type com.facebook.drawee.view.SimpleDraweeView");
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById2;
        this.t = simpleDraweeView;
        this.u = RxView.clicks(button);
        this.v = RxView.clicks(simpleDraweeView);
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemView
    @NotNull
    public Observable<Unit> getButtonClicks() {
        return this.u;
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemView
    @NotNull
    public Observable<Unit> getMapImageClicks() {
        return this.v;
    }

    @Override // com.avito.konveyor.adapter.BaseViewHolder, com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        MapBannerItemView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemView
    public void setButtonText(@Nullable String str) {
        ButtonsKt.bindText$default(this.s, str, false, 2, null);
    }

    @Override // com.avito.android.serp.adapter.map_banner.MapBannerItemView
    public void setImage(@Nullable Uri uri, @Nullable Uri uri2) {
        SimpleDraweeView simpleDraweeView = this.t;
        Context context = this.w.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "view.context");
        if (!DarkThemeManagerKt.isDarkTheme(context)) {
            uri = uri2;
        }
        simpleDraweeView.setImageURI(uri, (Object) null);
    }
}
