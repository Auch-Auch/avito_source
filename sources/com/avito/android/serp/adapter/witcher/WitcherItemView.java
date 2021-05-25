package com.avito.android.serp.adapter.witcher;

import android.os.Parcelable;
import com.avito.android.advert.viewed.ViewedAdvertsPresenter;
import com.avito.android.advert.viewed.ViewedAdvertsView;
import com.avito.android.favorite.FavoriteAdvertsPresenter;
import com.avito.android.favorite.FavoriteAdvertsView;
import com.avito.android.lib.design.R;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.serp.adapter.PersistableSerpItem;
import com.avito.konveyor.blueprint.ItemView;
import com.avito.konveyor.data_source.DataSource;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import io.reactivex.rxjava3.core.Observable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u00011J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u001d\u0010\f\u001a\u00020\u00062\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u000e\u0010\bJ\u0017\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000fH&¢\u0006\u0004\b\u0011\u0010\u0012J\u0019\u0010\u0015\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H&¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H&¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u001b\u001a\u00020\u00062\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0019H&¢\u0006\u0004\b\u001b\u0010\u001cR\u001c\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u001d8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0016\u0010&\u001a\u00020#8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001c\u0010,\u001a\u00020'8&@&X¦\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u00100\u001a\u00020-8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/favorite/FavoriteAdvertsView;", "Lcom/avito/android/advert/viewed/ViewedAdvertsView;", "", "title", "", "setTitle", "(Ljava/lang/String;)V", "Lcom/avito/konveyor/data_source/DataSource;", "Lcom/avito/android/serp/adapter/PersistableSerpItem;", "items", "setItems", "(Lcom/avito/konveyor/data_source/DataSource;)V", "setButtonText", "Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;", "selectionType", "setSelectionType", "(Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;)V", "Landroid/os/Parcelable;", "parcel", "setInnerItemsSavedState", "(Landroid/os/Parcelable;)V", "subscribeToScrollChanges", "()V", "Lkotlin/Function0;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "setUnbindListener", "(Lkotlin/jvm/functions/Function0;)V", "Lio/reactivex/rxjava3/core/Observable;", "getTitleClicks", "()Lio/reactivex/rxjava3/core/Observable;", "titleClicks", "getButtonClicks", "buttonClicks", "Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "getFavoriteAdvertsPresenter", "()Lcom/avito/android/favorite/FavoriteAdvertsPresenter;", "favoriteAdvertsPresenter", "", "getHasCarousel", "()Z", "setHasCarousel", "(Z)V", "hasCarousel", "Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "getViewedAdvertsPresenter", "()Lcom/avito/android/advert/viewed/ViewedAdvertsPresenter;", "viewedAdvertsPresenter", "SelectionType", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface WitcherItemView extends ItemView, FavoriteAdvertsView, ViewedAdvertsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull WitcherItemView witcherItemView) {
            ItemView.DefaultImpls.onUnbind(witcherItemView);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\r\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0010\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\u000f\u0010\fR\u0019\u0010\u0013\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0011\u0010\n\u001a\u0004\b\u0012\u0010\fR\u0019\u0010\u0016\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0015\u0010\fR\u0019\u0010\u0019\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\n\u001a\u0004\b\u0018\u0010\fj\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Lcom/avito/android/serp/adapter/witcher/WitcherItemView$SelectionType;", "", "", AuthSource.SEND_ABUSE, "I", "getBackgroundColor", "()I", "backgroundColor", "", "c", "Z", "getHasElevation", "()Z", "hasElevation", AuthSource.BOOKING_ORDER, "getHasExtraPaddingTop", "hasExtraPaddingTop", "e", "getCustomButtonStyle", "customButtonStyle", "f", "getCustomBackground", "customBackground", "d", "getHasCarousel", "hasCarousel", "REGULAR", "SELECTED", "SCROLLABLE", "SCROLLABLE_CLICKABLE_HEADER", "MARKETPLACE", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public enum SelectionType {
        REGULAR(R.attr.oldBackground, false, false, false, false, false, 56),
        SELECTED(0, false, false, false, false, false, 63),
        SCROLLABLE(0, false, false, true, false, false, 55),
        SCROLLABLE_CLICKABLE_HEADER(0, false, false, true, false, false, 55),
        MARKETPLACE(0, false, false, true, true, true, 3);
        
        public final int a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final boolean f;

        /* access modifiers changed from: public */
        SelectionType(int i, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, int i2) {
            i = (i2 & 1) != 0 ? R.attr.orange50 : i;
            z = (i2 & 2) != 0 ? true : z;
            z2 = (i2 & 4) != 0 ? true : z2;
            z3 = (i2 & 8) != 0 ? false : z3;
            z4 = (i2 & 16) != 0 ? false : z4;
            z5 = (i2 & 32) != 0 ? false : z5;
            this.a = i;
            this.b = z;
            this.c = z2;
            this.d = z3;
            this.e = z4;
            this.f = z5;
        }

        public final int getBackgroundColor() {
            return this.a;
        }

        public final boolean getCustomBackground() {
            return this.f;
        }

        public final boolean getCustomButtonStyle() {
            return this.e;
        }

        public final boolean getHasCarousel() {
            return this.d;
        }

        public final boolean getHasElevation() {
            return this.c;
        }

        public final boolean getHasExtraPaddingTop() {
            return this.b;
        }
    }

    @NotNull
    Observable<Unit> getButtonClicks();

    @NotNull
    FavoriteAdvertsPresenter getFavoriteAdvertsPresenter();

    boolean getHasCarousel();

    @NotNull
    Observable<Unit> getTitleClicks();

    @NotNull
    ViewedAdvertsPresenter getViewedAdvertsPresenter();

    void setButtonText(@NotNull String str);

    void setHasCarousel(boolean z);

    void setInnerItemsSavedState(@Nullable Parcelable parcelable);

    void setItems(@NotNull DataSource<PersistableSerpItem> dataSource);

    void setSelectionType(@NotNull SelectionType selectionType);

    void setTitle(@NotNull String str);

    void setUnbindListener(@Nullable Function0<Unit> function0);

    void subscribeToScrollChanges();
}
