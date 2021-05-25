package com.avito.android.favorites.adapter.advert;

import a2.a.a.t0.z0.a.b;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.ab_tests.groups.SimpleTestGroupWithNone;
import com.avito.android.ab_tests.models.ExposedAbTestGroup;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenter;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.bottom_sheet.BottomSheetMenuDialog;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.ImageKt;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.Objects;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u001c\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;", "view", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemView;Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "Lcom/avito/android/ab_tests/groups/SimpleTestGroupWithNone;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;", "favoriteSimilarAdvertsTestGroup", "<init>", "(Ldagger/Lazy;Lcom/avito/android/ab_tests/models/ExposedAbTestGroup;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class FavoriteAdvertItemPresenterImpl implements FavoriteAdvertItemPresenter {
    public final Lazy<FavoriteAdvertItemPresenter.Listener> a;
    public final ExposedAbTestGroup<SimpleTestGroupWithNone> b;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3, Object obj4) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i != 0) {
                boolean z = true;
                if (i == 1) {
                    ((FavoriteAdvertItemPresenter.Listener) ((FavoriteAdvertItemPresenterImpl) this.c).a.get()).onRemoveItemClicked((FavoriteAdvertItem) this.d);
                    return Unit.INSTANCE;
                } else if (i == 2) {
                    ((FavoriteAdvertItemView) this.b).setClickListener(null);
                    ((FavoriteAdvertItemView) this.b).setOnFavoriteButtonClickListener(null);
                    ((FavoriteAdvertItemView) this.b).setUnbindListener(null);
                    ((FavoriteAdvertItemView) this.b).setMoreClickListener(null);
                    ((FavoriteAdvertItemView) this.b).setSimilarClickListener(null);
                    return Unit.INSTANCE;
                } else if (i == 3) {
                    Dialog access$createDialog = FavoriteAdvertItemPresenterImpl.access$createDialog((FavoriteAdvertItemPresenterImpl) this.c, (FavoriteAdvertItemView) this.e, (FavoriteAdvertItem) this.d);
                    if (access$createDialog != null) {
                        access$createDialog.show();
                    }
                    return Unit.INSTANCE;
                } else if (i == 4) {
                    FavoriteAdvertItemPresenter.Listener listener = (FavoriteAdvertItemPresenter.Listener) ((FavoriteAdvertItemPresenterImpl) this.c).a.get();
                    String stringId = ((FavoriteAdvertItem) this.d).getStringId();
                    if (((FavoriteAdvertItem) this.d).getShopName() == null) {
                        z = false;
                    }
                    listener.onClickSimilar(stringId, z);
                    return Unit.INSTANCE;
                } else {
                    throw null;
                }
            } else {
                FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) this.d;
                ((FavoriteAdvertItemPresenter.Listener) ((FavoriteAdvertItemPresenterImpl) this.c).a.get()).onFavoriteItemClicked(favoriteAdvertItem, FavoriteAdvertItemPresenterImpl.access$createImage((FavoriteAdvertItemPresenterImpl) this.c, (FavoriteAdvertItemView) this.e, favoriteAdvertItem));
                return Unit.INSTANCE;
            }
        }
    }

    @Inject
    public FavoriteAdvertItemPresenterImpl(@NotNull Lazy<FavoriteAdvertItemPresenter.Listener> lazy, @NotNull ExposedAbTestGroup<SimpleTestGroupWithNone> exposedAbTestGroup) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(exposedAbTestGroup, "favoriteSimilarAdvertsTestGroup");
        this.a = lazy;
        this.b = exposedAbTestGroup;
    }

    public static final Dialog access$createDialog(FavoriteAdvertItemPresenterImpl favoriteAdvertItemPresenterImpl, FavoriteAdvertItemView favoriteAdvertItemView, FavoriteAdvertItem favoriteAdvertItem) {
        View view;
        Context context;
        Objects.requireNonNull(favoriteAdvertItemPresenterImpl);
        if (!(favoriteAdvertItemView instanceof RecyclerView.ViewHolder)) {
            favoriteAdvertItemView = null;
        }
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) favoriteAdvertItemView;
        if (viewHolder == null || (view = viewHolder.itemView) == null || (context = view.getContext()) == null) {
            return null;
        }
        return new BottomSheetMenuDialog(context, new b(context, favoriteAdvertItemPresenterImpl, favoriteAdvertItem));
    }

    public static final Image access$createImage(FavoriteAdvertItemPresenterImpl favoriteAdvertItemPresenterImpl, FavoriteAdvertItemView favoriteAdvertItemView, FavoriteAdvertItem favoriteAdvertItem) {
        Objects.requireNonNull(favoriteAdvertItemPresenterImpl);
        return ImageKt.toSingleImage(favoriteAdvertItemView.getPictureUri(AvitoPictureKt.pictureOf$default(favoriteAdvertItem.getImage(), false, 0.0f, 1.5f, null, 20, null)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0123, code lost:
        if (r15 != null) goto L_0x012a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView r13, @org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItem r14, int r15) {
        /*
        // Method dump skipped, instructions count: 320
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.adapter.advert.FavoriteAdvertItemPresenterImpl.bindView(com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView, com.avito.android.favorites.adapter.advert.FavoriteAdvertItem, int):void");
    }
}
