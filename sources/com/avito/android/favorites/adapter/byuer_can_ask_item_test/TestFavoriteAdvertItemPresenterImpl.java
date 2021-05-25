package com.avito.android.favorites.adapter.byuer_can_ask_item_test;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItem;
import com.avito.android.favorites.adapter.advert.FavoriteAdvertItemView;
import com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenter;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenterImpl;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;", "view", "Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemView;Lcom/avito/android/favorites/adapter/advert/FavoriteAdvertItem;I)V", "Ldagger/Lazy;", "Lcom/avito/android/favorites/adapter/byuer_can_ask_item_test/TestFavoriteAdvertItemPresenter$Listener;", AuthSource.SEND_ABUSE, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "<init>", "(Ldagger/Lazy;)V", "favorites_release"}, k = 1, mv = {1, 4, 2})
public final class TestFavoriteAdvertItemPresenterImpl implements TestFavoriteAdvertItemPresenter {
    public final Lazy<TestFavoriteAdvertItemPresenter.Listener> a;

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

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                FavoriteAdvertItem favoriteAdvertItem = (FavoriteAdvertItem) this.d;
                ((TestFavoriteAdvertItemPresenter.Listener) ((TestFavoriteAdvertItemPresenterImpl) this.c).a.get()).onFavoriteItemClicked(favoriteAdvertItem, TestFavoriteAdvertItemPresenterImpl.access$createImage((TestFavoriteAdvertItemPresenterImpl) this.c, (TestFavoriteAdvertItemView) this.e, favoriteAdvertItem));
                return Unit.INSTANCE;
            } else if (i == 1) {
                ((TestFavoriteAdvertItemPresenter.Listener) ((TestFavoriteAdvertItemPresenterImpl) this.c).a.get()).onRemoveItemClicked((FavoriteAdvertItem) this.d);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ FavoriteAdvertItem a;
        public final /* synthetic */ TestFavoriteAdvertItemView b;
        public final /* synthetic */ TestFavoriteAdvertItemPresenterImpl c;
        public final /* synthetic */ FavoriteAdvertItem d;
        public final /* synthetic */ TestFavoriteAdvertItemView e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(FavoriteAdvertItem favoriteAdvertItem, TestFavoriteAdvertItemView testFavoriteAdvertItemView, TestFavoriteAdvertItemPresenterImpl testFavoriteAdvertItemPresenterImpl, FavoriteAdvertItem favoriteAdvertItem2, TestFavoriteAdvertItemView testFavoriteAdvertItemView2) {
            super(0);
            this.a = favoriteAdvertItem;
            this.b = testFavoriteAdvertItemView;
            this.c = testFavoriteAdvertItemPresenterImpl;
            this.d = favoriteAdvertItem2;
            this.e = testFavoriteAdvertItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            Dialog access$createDialog = TestFavoriteAdvertItemPresenterImpl.access$createDialog(this.c, this.e, this.d);
            if (access$createDialog != null) {
                access$createDialog.show();
            }
            ((TestFavoriteAdvertItemPresenter.Listener) this.c.a.get()).onClickMoreItemActions(this.a.getStringId());
            return Unit.INSTANCE;
        }
    }

    @Inject
    public TestFavoriteAdvertItemPresenterImpl(@NotNull Lazy<TestFavoriteAdvertItemPresenter.Listener> lazy) {
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.a = lazy;
    }

    public static final Dialog access$createDialog(TestFavoriteAdvertItemPresenterImpl testFavoriteAdvertItemPresenterImpl, TestFavoriteAdvertItemView testFavoriteAdvertItemView, FavoriteAdvertItem favoriteAdvertItem) {
        View view;
        Context context;
        Objects.requireNonNull(testFavoriteAdvertItemPresenterImpl);
        if (!(testFavoriteAdvertItemView instanceof RecyclerView.ViewHolder)) {
            testFavoriteAdvertItemView = null;
        }
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) testFavoriteAdvertItemView;
        if (viewHolder == null || (view = viewHolder.itemView) == null || (context = view.getContext()) == null) {
            return null;
        }
        return new BottomSheetMenuDialog(context, new a2.a.a.t0.z0.b.a(context, testFavoriteAdvertItemPresenterImpl, favoriteAdvertItem));
    }

    public static final Image access$createImage(TestFavoriteAdvertItemPresenterImpl testFavoriteAdvertItemPresenterImpl, FavoriteAdvertItemView favoriteAdvertItemView, FavoriteAdvertItem favoriteAdvertItem) {
        Objects.requireNonNull(testFavoriteAdvertItemPresenterImpl);
        return ImageKt.toSingleImage(favoriteAdvertItemView.getPictureUri(AvitoPictureKt.pictureOf$default(favoriteAdvertItem.getImage(), false, 0.0f, 1.5f, null, 20, null)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0060, code lost:
        if (r11 != null) goto L_0x0067;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindView(@org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemView r9, @org.jetbrains.annotations.NotNull com.avito.android.favorites.adapter.advert.FavoriteAdvertItem r10, int r11) {
        /*
            r8 = this;
            java.lang.String r11 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r11)
            java.lang.String r11 = "item"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r11)
            com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$a r11 = new com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$a
            r1 = 0
            r0 = r11
            r2 = r9
            r3 = r8
            r4 = r10
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r9.setClickListener(r11)
            com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$a r11 = new com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$a
            r3 = 1
            r2 = r11
            r4 = r9
            r5 = r8
            r6 = r10
            r7 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            r9.setOnFavoriteButtonClickListener(r11)
            boolean r11 = r10.getActive()
            r9.setActive(r11)
            java.lang.String r11 = r10.getTitle()
            r9.setTitle(r11)
            java.lang.String r11 = r10.getPrice()
            r9.setCurrentPrice(r11)
            java.lang.String r11 = r10.getShopName()
            r9.setShopName(r11)
            java.lang.String r11 = r10.getSublocation()
            if (r11 == 0) goto L_0x0063
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r10.getOldLocation()
            r0.append(r1)
            java.lang.String r1 = ", "
            r0.append(r1)
            r0.append(r11)
            java.lang.String r11 = r0.toString()
            if (r11 == 0) goto L_0x0063
            goto L_0x0067
        L_0x0063:
            java.lang.String r11 = r10.getOldLocation()
        L_0x0067:
            r9.setAddress(r11)
            com.avito.android.remote.model.Image r0 = r10.getImage()
            r1 = 0
            r2 = 0
            r3 = 1069547520(0x3fc00000, float:1.5)
            r4 = 0
            r5 = 20
            r6 = 0
            com.avito.android.image_loader.Picture r11 = com.avito.android.image_loader.AvitoPictureKt.pictureOf$default(r0, r1, r2, r3, r4, r5, r6)
            r9.setPicture(r11)
            com.avito.android.favorites.adapter.advert.FavoriteAdvertItem$Status r11 = r10.getStatus()
            r9.setStatus(r11)
            boolean r11 = r10.getActive()
            if (r11 == 0) goto L_0x0093
            long r0 = r10.getTime()
            java.lang.Long r11 = java.lang.Long.valueOf(r0)
            goto L_0x0094
        L_0x0093:
            r11 = 0
        L_0x0094:
            r9.setDate(r11)
            java.lang.String r11 = r10.getNote()
            r9.setNote(r11)
            com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$b r11 = new com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl$b
            r0 = r11
            r1 = r10
            r2 = r9
            r3 = r8
            r4 = r10
            r5 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            r9.setMoreClickListener(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemPresenterImpl.bindView(com.avito.android.favorites.adapter.byuer_can_ask_item_test.TestFavoriteAdvertItemView, com.avito.android.favorites.adapter.advert.FavoriteAdvertItem, int):void");
    }
}
