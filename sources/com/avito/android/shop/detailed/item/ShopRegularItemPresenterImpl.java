package com.avito.android.shop.detailed.item;

import a2.a.a.s2.b.l.d;
import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ActionNullable;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.detailed.AwardsClickListener;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.ui_components.R;
import com.avito.android.util.Collections;
import com.avito.android.util.Kundle;
import com.vk.sdk.api.VKApiConst;
import dagger.Lazy;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BQ\b\u0007\u0012\u0006\u0010\u0015\u001a\u00020\u0012\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\u0006\u0010-\u001a\u00020*\u0012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u0016\u0012\u0006\u0010/\u001a\u00020.\u0012\n\b\u0001\u00100\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b1\u00102J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001c\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u0019R\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010$R\u0016\u0010)\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010\u0010R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00063"}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopRegularItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShopRegularItemView;", "view", "Lcom/avito/android/shop/detailed/item/ShopRegularItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop/detailed/item/ShopRegularItemView;Lcom/avito/android/shop/detailed/item/ShopRegularItem;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "", "c", "Ljava/lang/String;", "expandedName", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "e", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Ldagger/Lazy;", "Lcom/avito/android/shop/detailed/ShopHeaderListener;", "h", "Ldagger/Lazy;", "shopHeaderListener", "Lcom/avito/android/shop/detailed/AwardsClickListener;", "i", "awardsClickListener", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "f", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "", AuthSource.SEND_ABUSE, "Z", "descriptionExpanded", AuthSource.BOOKING_ORDER, "contactsExpanded", "d", "collapsedName", "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", g.a, "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "ratingPresenter", "Lcom/avito/android/shop/detailed/item/ShopRegularResourceProvider;", "resourceProvider", "state", "<init>", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;Ldagger/Lazy;Ldagger/Lazy;Lcom/avito/android/shop/detailed/item/ShopRegularResourceProvider;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopRegularItemPresenterImpl implements ShopRegularItemPresenter {
    public boolean a;
    public boolean b;
    public final String c;
    public final String d;
    public final SubscriptionsPresenter e;
    public final CompositeSnackbarPresenter f;
    public final ShopItemRatingPresenter g;
    public final Lazy<ShopHeaderListener> h;
    public final Lazy<AwardsClickListener> i;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ Object e;
        public final /* synthetic */ Object f;
        public final /* synthetic */ Object g;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
            this.e = obj4;
            this.f = obj5;
            this.g = obj6;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            String str;
            String str2;
            int i = this.a;
            Action action = null;
            if (i == 0) {
                ShopHeaderListener shopHeaderListener = (ShopHeaderListener) this.d;
                SellerVerification.VerificationItem internal = ((SellerVerification) this.b).getInternal();
                if (internal != null) {
                    str = internal.getDescriptionTitle();
                    if (str == null) {
                        str = internal.getTitle();
                    }
                } else {
                    str = null;
                }
                SellerVerification.VerificationItem internal2 = ((SellerVerification) this.b).getInternal();
                String description = internal2 != null ? internal2.getDescription() : null;
                SellerVerification.VerificationItem internal3 = ((SellerVerification) this.b).getInternal();
                if (internal3 != null) {
                    action = internal3.getAction();
                }
                shopHeaderListener.onShowPopup(str, description, action);
                return Unit.INSTANCE;
            } else if (i == 1) {
                ShopHeaderListener shopHeaderListener2 = (ShopHeaderListener) this.d;
                SellerVerification.VerificationItem external = ((SellerVerification) this.b).getExternal();
                if (external != null) {
                    str2 = external.getDescriptionTitle();
                    if (str2 == null) {
                        str2 = external.getTitle();
                    }
                } else {
                    str2 = null;
                }
                SellerVerification.VerificationItem external2 = ((SellerVerification) this.b).getExternal();
                String description2 = external2 != null ? external2.getDescription() : null;
                SellerVerification.VerificationItem external3 = ((SellerVerification) this.b).getExternal();
                if (external3 != null) {
                    action = external3.getAction();
                }
                shopHeaderListener2.onShowPopup(str2, description2, action);
                return Unit.INSTANCE;
            } else if (i == 2) {
                ((AwardsClickListener) ((ShopRegularItemPresenterImpl) this.e).i.get()).onAwardsClicked((SellerVerification.AwardsItem) this.b);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    /* compiled from: kotlin-style lambda group */
    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            int i = this.a;
            if (i == 0) {
                ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, ((Action) this.b).getDeepLink(), null, 2, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
                DeepLink deepLink = ((ActionNullable) this.b).getDeepLink();
                if (deepLink != null) {
                    ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, deepLink, null, 2, null);
                }
                return Unit.INSTANCE;
            } else if (i == 2) {
                ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, ((Action) this.b).getDeepLink(), null, 2, null);
                return Unit.INSTANCE;
            } else if (i == 3) {
                ((ShopRegularItemPresenterImpl) this.b).f.removeOptionalElement((ShopRegularItemView) this.d);
                ((ShopRegularItemView) this.d).setUnbindListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class c extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopRegularItemView a;
        public final /* synthetic */ ShopHeaderListener b;
        public final /* synthetic */ ShopRegularItemPresenterImpl c;
        public final /* synthetic */ ShopRegularItemView d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ShopRegularItemView shopRegularItemView, ShopHeaderListener shopHeaderListener, ShopRegularItemPresenterImpl shopRegularItemPresenterImpl, ShopRegularItem shopRegularItem, ShopRegularItemView shopRegularItemView2) {
            super(0);
            this.a = shopRegularItemView;
            this.b = shopHeaderListener;
            this.c = shopRegularItemPresenterImpl;
            this.d = shopRegularItemView2;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.b.onContactsExpanded();
            this.c.b = true;
            this.a.expandContacts();
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopRegularItemPresenterImpl(@NotNull SubscriptionsPresenter subscriptionsPresenter, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull ShopItemRatingPresenter shopItemRatingPresenter, @NotNull Lazy<ShopHeaderListener> lazy, @NotNull Lazy<AwardsClickListener> lazy2, @NotNull ShopRegularResourceProvider shopRegularResourceProvider, @ShopDetailedModule.ShopRegularItemPresenterState @Nullable Kundle kundle) {
        Boolean bool;
        Boolean bool2;
        Intrinsics.checkNotNullParameter(subscriptionsPresenter, "subscriptionsPresenter");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(shopItemRatingPresenter, "ratingPresenter");
        Intrinsics.checkNotNullParameter(lazy, "shopHeaderListener");
        Intrinsics.checkNotNullParameter(lazy2, "awardsClickListener");
        Intrinsics.checkNotNullParameter(shopRegularResourceProvider, "resourceProvider");
        this.e = subscriptionsPresenter;
        this.f = compositeSnackbarPresenter;
        this.g = shopItemRatingPresenter;
        this.h = lazy;
        this.i = lazy2;
        boolean z = false;
        this.a = (kundle == null || (bool2 = kundle.getBoolean("description_expanded")) == null) ? false : bool2.booleanValue();
        if (!(kundle == null || (bool = kundle.getBoolean("contacts_expanded")) == null)) {
            z = bool.booleanValue();
        }
        this.b = z;
        this.c = shopRegularResourceProvider.getExpandedDescriptionText();
        this.d = shopRegularResourceProvider.getCollapsedDescriptionText();
    }

    public static final void access$collapse(ShopRegularItemPresenterImpl shopRegularItemPresenterImpl, ShopRegularItemView shopRegularItemView) {
        shopRegularItemPresenterImpl.a = false;
        shopRegularItemView.setDescriptionHandlerButtonName(shopRegularItemPresenterImpl.c);
        shopRegularItemView.collapseDescription();
        shopRegularItemView.setDescriptionListener(new a2.a.a.s2.b.l.c(shopRegularItemPresenterImpl, shopRegularItemView));
    }

    public static final void access$expand(ShopRegularItemPresenterImpl shopRegularItemPresenterImpl, ShopRegularItemView shopRegularItemView) {
        shopRegularItemPresenterImpl.a = true;
        shopRegularItemView.setDescriptionHandlerButtonName(shopRegularItemPresenterImpl.d);
        shopRegularItemView.expandDescription();
        shopRegularItemView.setDescriptionListener(new d(shopRegularItemPresenterImpl, shopRegularItemView));
    }

    @Override // com.avito.android.shop.detailed.item.ShopRegularItemPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putBoolean("description_expanded", Boolean.valueOf(this.a));
        kundle.putBoolean("contacts_expanded", Boolean.valueOf(this.b));
        return kundle;
    }

    public void bindView(@NotNull ShopRegularItemView shopRegularItemView, @NotNull ShopRegularItem shopRegularItem, int i2) {
        Intrinsics.checkNotNullParameter(shopRegularItemView, "view");
        Intrinsics.checkNotNullParameter(shopRegularItem, "item");
        ShopHeaderListener shopHeaderListener = this.h.get();
        shopRegularItemView.setName(shopRegularItem.getName());
        shopRegularItemView.setCategory(shopRegularItem.getCategory());
        shopRegularItemView.setLogo(AvitoPictureKt.pictureOf$default(shopRegularItem.getLogo(), false, 0.0f, 0.0f, null, 28, null));
        shopRegularItemView.setDescription(shopRegularItem.getDescription());
        SellerVerification sellerVerification = shopRegularItem.getSellerVerification();
        if (sellerVerification != null) {
            SellerVerification.VerificationItem internal = sellerVerification.getInternal();
            shopRegularItemView.setInternalVerification(internal != null ? internal.getTitle() : null, new a(0, sellerVerification, shopRegularItemView, shopHeaderListener, this, shopRegularItem, shopRegularItemView));
            SellerVerification.VerificationItem external = sellerVerification.getExternal();
            shopRegularItemView.setExternalVerification(external != null ? external.getTitle() : null, new a(1, sellerVerification, shopRegularItemView, shopHeaderListener, this, shopRegularItem, shopRegularItemView));
            shopRegularItemView.showVerification();
            SellerVerification.AwardsItem awards = sellerVerification.getAwards();
            if (awards != null) {
                shopRegularItemView.setAwards(awards.getTitle());
                shopRegularItemView.setAwardsOnClickListener(new a(2, awards, shopRegularItemView, shopHeaderListener, this, shopRegularItem, shopRegularItemView));
            }
        }
        if (this.a) {
            this.a = true;
            shopRegularItemView.setDescriptionHandlerButtonName(this.d);
            shopRegularItemView.expandDescription();
            shopRegularItemView.setDescriptionListener(new d(this, shopRegularItemView));
        } else {
            this.a = false;
            shopRegularItemView.setDescriptionHandlerButtonName(this.c);
            shopRegularItemView.collapseDescription();
            shopRegularItemView.setDescriptionListener(new a2.a.a.s2.b.l.c(this, shopRegularItemView));
        }
        this.g.bindRatingToView(shopRegularItem.getRating(), shopRegularItemView);
        this.e.setUserData(shopRegularItem.getUserKey(), null);
        this.e.attachButtonsView(shopRegularItemView);
        SubscriptionsPresenter.DefaultImpls.updateSellersSubscription$default(this.e, shopRegularItem.getSubscribeInfo(), false, 2, null);
        this.f.addOptionalElement(shopRegularItemView);
        shopRegularItemView.clearContacts();
        if (Collections.isNullOrEmpty(shopRegularItem.getPhones()) && shopRegularItem.getSite() == null) {
            shopRegularItemView.hideContactsButton();
        }
        List<Action> phones = shopRegularItem.getPhones();
        if (phones != null) {
            for (T t : phones) {
                shopRegularItemView.addContactCell(t.getTitle(), R.drawable.ic_phone_24_blue, new b(0, t, shopRegularItemView, shopHeaderListener));
            }
        }
        ActionNullable address = shopRegularItem.getAddress();
        if (address != null) {
            shopRegularItemView.showLocation(address.getTitle(), new b(1, address, shopRegularItemView, shopHeaderListener));
        }
        Action site = shopRegularItem.getSite();
        if (site != null) {
            shopRegularItemView.addContactCell(site.getTitle(), R.drawable.ic_web_24_blue, new b(2, site, shopRegularItemView, shopHeaderListener));
        }
        shopRegularItemView.setExpandContactsClickListener(new c(shopRegularItemView, shopHeaderListener, this, shopRegularItem, shopRegularItemView));
        if (this.b) {
            shopRegularItemView.expandContacts();
        }
        shopRegularItemView.setUnbindListener(new b(3, this, shopRegularItem, shopRegularItemView));
    }
}
