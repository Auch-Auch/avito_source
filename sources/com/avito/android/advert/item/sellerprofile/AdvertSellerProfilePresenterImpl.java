package com.avito.android.advert.item.sellerprofile;

import com.avito.android.Features;
import com.avito.android.advert.AdvertDetailsResourcesProvider;
import com.avito.android.advert_core.sellerprofile.ShowSellersProfileSource;
import com.avito.android.remote.auth.AuthSource;
import com.jakewharton.rxrelay3.PublishRelay;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u001e\u001a\u00020\u001b\u0012\u0006\u0010+\u001a\u00020(¢\u0006\u0004\b,\u0010-J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ/\u0010\u0013\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\u00020\u00158\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*¨\u0006."}, d2 = {"Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenterImpl;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfilePresenter;", "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "view", "", "attachView", "(Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;)V", "detachView", "()V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "Lcom/avito/android/remote/model/AdvertSeller;", "seller", "", "isShopAdvert", "isFromCompany", "Lcom/avito/android/remote/model/advert_details/UserIconType;", "iconType", "bindSellerInfo", "(Lcom/avito/android/remote/model/AdvertSeller;ZZLcom/avito/android/remote/model/advert_details/UserIconType;)V", "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "getProfileSourceName", "()Lcom/avito/android/advert_core/sellerprofile/ShowSellersProfileSource;", "profileSourceName", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "e", "Lcom/avito/android/advert/AdvertDetailsResourcesProvider;", "advertDetailsResourcesProvider", "Lio/reactivex/rxjava3/disposables/Disposable;", "d", "Lio/reactivex/rxjava3/disposables/Disposable;", "disposable", "Lcom/jakewharton/rxrelay3/PublishRelay;", "c", "Lcom/jakewharton/rxrelay3/PublishRelay;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert/item/sellerprofile/AdvertSellerProfileView;", "Lcom/avito/android/Features;", "f", "Lcom/avito/android/Features;", "features", "<init>", "(Lcom/avito/android/advert/AdvertDetailsResourcesProvider;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertSellerProfilePresenterImpl implements AdvertSellerProfilePresenter {
    @NotNull
    public final ShowSellersProfileSource a = ShowSellersProfileSource.SELLER_INFO;
    public AdvertSellerProfileView b;
    public final PublishRelay<Unit> c;
    public Disposable d;
    public final AdvertDetailsResourcesProvider e;
    public final Features f;

    @Inject
    public AdvertSellerProfilePresenterImpl(@NotNull AdvertDetailsResourcesProvider advertDetailsResourcesProvider, @NotNull Features features) {
        Intrinsics.checkNotNullParameter(advertDetailsResourcesProvider, "advertDetailsResourcesProvider");
        Intrinsics.checkNotNullParameter(features, "features");
        this.e = advertDetailsResourcesProvider;
        this.f = features;
        PublishRelay<Unit> create = PublishRelay.create();
        Intrinsics.checkNotNullExpressionValue(create, "PublishRelay.create()");
        this.c = create;
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenter
    public void attachView(@NotNull AdvertSellerProfileView advertSellerProfileView) {
        Intrinsics.checkNotNullParameter(advertSellerProfileView, "view");
        this.b = advertSellerProfileView;
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = advertSellerProfileView.profileClicks().subscribe(this.c);
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b4  */
    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenter
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindSellerInfo(@org.jetbrains.annotations.NotNull com.avito.android.remote.model.AdvertSeller r21, boolean r22, boolean r23, @org.jetbrains.annotations.NotNull com.avito.android.remote.model.advert_details.UserIconType r24) {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "seller"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            java.lang.String r1 = "iconType"
            r9 = r24
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r1)
            com.avito.android.advert.item.sellerprofile.AdvertSellerProfileView r1 = r0.b
            if (r1 == 0) goto L_0x00ba
            com.avito.android.component.profile_snippet.ProfileSnippetData r15 = new com.avito.android.component.profile_snippet.ProfileSnippetData
            java.lang.String r4 = r21.getName()
            com.avito.android.Features r3 = r0.f
            com.avito.android.toggle.Feature r3 = r3.getRemoveRentSplittingPrivateOrAgency()
            java.lang.Object r3 = r3.invoke()
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            r5 = 0
            if (r3 == 0) goto L_0x0033
            java.lang.String r3 = r21.getPostfix()
        L_0x0031:
            r6 = r3
            goto L_0x004c
        L_0x0033:
            if (r22 != 0) goto L_0x0047
            if (r23 == 0) goto L_0x0038
            goto L_0x0047
        L_0x0038:
            com.avito.android.remote.model.SellerRating r3 = r21.getRating()
            if (r3 != 0) goto L_0x0045
            com.avito.android.advert.AdvertDetailsResourcesProvider r3 = r0.e
            java.lang.String r3 = r3.getPrivatePerson()
            goto L_0x0031
        L_0x0045:
            r6 = r5
            goto L_0x004c
        L_0x0047:
            java.lang.String r3 = r21.getPostfix()
            goto L_0x0031
        L_0x004c:
            java.lang.String r7 = r21.getSummary()
            java.lang.String r8 = r21.getManager()
            r10 = 0
            com.avito.android.remote.model.Image r11 = r21.getImage()
            com.avito.android.remote.model.SellerRating r3 = r21.getRating()
            if (r3 == 0) goto L_0x0066
            java.lang.Float r3 = r3.getScoreFloat()
            if (r3 == 0) goto L_0x0066
            goto L_0x0074
        L_0x0066:
            com.avito.android.remote.model.SellerRating r3 = r21.getRating()
            if (r3 == 0) goto L_0x0076
            float r3 = r3.getScore()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
        L_0x0074:
            r12 = r3
            goto L_0x0077
        L_0x0076:
            r12 = r5
        L_0x0077:
            com.avito.android.remote.model.SellerRating r3 = r21.getRating()
            if (r3 == 0) goto L_0x0083
            java.lang.String r3 = r3.getText()
            r13 = r3
            goto L_0x0084
        L_0x0083:
            r13 = r5
        L_0x0084:
            java.lang.Boolean r3 = r21.isVerified()
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            com.avito.android.remote.model.SellerVerification r16 = r21.getVerification()
            r17 = 16
            r18 = 0
            r3 = r15
            r5 = r6
            r6 = r7
            r7 = r8
            r8 = r10
            r9 = r24
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r16
            r19 = r15
            r15 = r17
            r16 = r18
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.avito.android.deep_linking.links.DeepLink r2 = r21.getLink()
            if (r2 == 0) goto L_0x00b4
            r2 = 1
            goto L_0x00b5
        L_0x00b4:
            r2 = 0
        L_0x00b5:
            r3 = r19
            r1.showProfileSnippet(r3, r2)
        L_0x00ba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenterImpl.bindSellerInfo(com.avito.android.remote.model.AdvertSeller, boolean, boolean, com.avito.android.remote.model.advert_details.UserIconType):void");
    }

    @Override // com.avito.android.advert.item.sellerprofile.AdvertSellerProfilePresenter
    public void detachView() {
        Disposable disposable = this.d;
        if (disposable != null) {
            disposable.dispose();
        }
        this.d = null;
        this.b = null;
    }

    @Override // com.avito.android.advert_core.sellerprofile.SellerProfileClickSource
    @NotNull
    public ShowSellersProfileSource getProfileSourceName() {
        return this.a;
    }

    @Override // com.avito.android.advert_core.sellerprofile.SellerProfileClickSource
    @NotNull
    public Observable<Unit> profileClicks() {
        return this.c;
    }
}
