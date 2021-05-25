package com.avito.android.shop.detailed.item;

import a2.g.r.g;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.image_loader.Picture;
import com.avito.android.lib.design.snackbar.util.CompositeSnackbarPresenter;
import com.avito.android.public_profile.ui.SubscriptionsPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Action;
import com.avito.android.remote.model.ActionNullable;
import com.avito.android.remote.model.SellerVerification;
import com.avito.android.shop.detailed.ShopHeaderListener;
import com.avito.android.shop.detailed.di.ShopDetailedModule;
import com.avito.android.ui_components.R;
import com.avito.android.util.Collections;
import com.avito.android.util.Kundle;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BC\b\u0007\u0012\u0006\u0010\u001d\u001a\u00020\u001a\u0012\u0006\u0010\u0011\u001a\u00020\u000e\u0012\u0006\u0010!\u001a\u00020\u001e\u0012\f\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"\u0012\u0006\u0010*\u001a\u00020)\u0012\n\b\u0001\u0010+\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b,\u0010-J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0019\u001a\u00020\u00168\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001d\u001a\u00020\u001a8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010!\u001a\u00020\u001e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u001c\u0010&\u001a\b\u0012\u0004\u0012\u00020#0\"8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010(\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b'\u0010\u0014¨\u0006."}, d2 = {"Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenterImpl;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemPresenter;", "Lcom/avito/android/shop/detailed/item/ShopGoldItemView;", "view", "Lcom/avito/android/shop/detailed/item/ShopGoldItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/shop/detailed/item/ShopGoldItemView;Lcom/avito/android/shop/detailed/item/ShopGoldItem;I)V", "Lcom/avito/android/util/Kundle;", "onSaveState", "()Lcom/avito/android/util/Kundle;", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "e", "Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;", "snackbarPresenter", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "expandedContactsName", "", AuthSource.SEND_ABUSE, "Z", "contactsExpanded", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "d", "Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;", "subscriptionsPresenter", "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "f", "Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;", "ratingPresenter", "Ldagger/Lazy;", "Lcom/avito/android/shop/detailed/ShopHeaderListener;", g.a, "Ldagger/Lazy;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "c", "collapsedContactsName", "Lcom/avito/android/shop/detailed/item/ShopGoldResourceProvider;", "resourceProvider", "state", "<init>", "(Lcom/avito/android/public_profile/ui/SubscriptionsPresenter;Lcom/avito/android/lib/design/snackbar/util/CompositeSnackbarPresenter;Lcom/avito/android/shop/detailed/item/ShopItemRatingPresenter;Ldagger/Lazy;Lcom/avito/android/shop/detailed/item/ShopGoldResourceProvider;Lcom/avito/android/util/Kundle;)V", "shop_release"}, k = 1, mv = {1, 4, 2})
public final class ShopGoldItemPresenterImpl implements ShopGoldItemPresenter {
    public boolean a;
    public final String b;
    public final String c;
    public final SubscriptionsPresenter d;
    public final CompositeSnackbarPresenter e;
    public final ShopItemRatingPresenter f;
    public final Lazy<ShopHeaderListener> g;

    /* compiled from: kotlin-style lambda group */
    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Object b;
        public final /* synthetic */ Object c;
        public final /* synthetic */ Object d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(int i, Object obj, Object obj2, Object obj3) {
            super(0);
            this.a = i;
            this.b = obj;
            this.c = obj2;
            this.d = obj3;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            String str;
            String str2;
            int i = this.a;
            Action action = null;
            if (i == 0) {
                ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, ((Action) this.b).getDeepLink(), null, 2, null);
                return Unit.INSTANCE;
            } else if (i == 1) {
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
            } else if (i == 2) {
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
            } else if (i == 3) {
                DeepLink deepLink = ((ActionNullable) this.b).getDeepLink();
                if (deepLink != null) {
                    ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, deepLink, null, 2, null);
                }
                return Unit.INSTANCE;
            } else if (i == 4) {
                ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default((ShopHeaderListener) this.d, ((Action) this.b).getDeepLink(), null, 2, null);
                return Unit.INSTANCE;
            } else if (i == 5) {
                ((ShopGoldItemPresenterImpl) this.b).e.removeOptionalElement((ShopGoldItemView) this.d);
                ((ShopGoldItemView) this.d).setUnbindListener(null);
                return Unit.INSTANCE;
            } else {
                throw null;
            }
        }
    }

    public static final class b extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ShopHeaderListener a;
        public final /* synthetic */ ShopGoldItem b;
        public final /* synthetic */ ShopGoldItemView c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ShopHeaderListener shopHeaderListener, ShopGoldItemPresenterImpl shopGoldItemPresenterImpl, ShopGoldItem shopGoldItem, ShopGoldItemView shopGoldItemView) {
            super(0);
            this.a = shopHeaderListener;
            this.b = shopGoldItem;
            this.c = shopGoldItemView;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            ShopHeaderListener.DefaultImpls.onDeepLinkFollowed$default(this.a, this.b.getDescription().getDeepLink(), null, 2, null);
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ShopGoldItemPresenterImpl(@NotNull SubscriptionsPresenter subscriptionsPresenter, @NotNull CompositeSnackbarPresenter compositeSnackbarPresenter, @NotNull ShopItemRatingPresenter shopItemRatingPresenter, @NotNull Lazy<ShopHeaderListener> lazy, @NotNull ShopGoldResourceProvider shopGoldResourceProvider, @ShopDetailedModule.ShopGoldItemPresenterState @Nullable Kundle kundle) {
        Boolean bool;
        Intrinsics.checkNotNullParameter(subscriptionsPresenter, "subscriptionsPresenter");
        Intrinsics.checkNotNullParameter(compositeSnackbarPresenter, "snackbarPresenter");
        Intrinsics.checkNotNullParameter(shopItemRatingPresenter, "ratingPresenter");
        Intrinsics.checkNotNullParameter(lazy, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        Intrinsics.checkNotNullParameter(shopGoldResourceProvider, "resourceProvider");
        this.d = subscriptionsPresenter;
        this.e = compositeSnackbarPresenter;
        this.f = shopItemRatingPresenter;
        this.g = lazy;
        this.a = (kundle == null || (bool = kundle.getBoolean("contacts_expanded")) == null) ? false : bool.booleanValue();
        this.b = shopGoldResourceProvider.getExpandedContactsText();
        this.c = shopGoldResourceProvider.getCollapsedContactsText();
    }

    public static final void access$collapse(ShopGoldItemPresenterImpl shopGoldItemPresenterImpl, ShopGoldItemView shopGoldItemView) {
        shopGoldItemView.setContactsHandlerName(shopGoldItemPresenterImpl.c);
        shopGoldItemView.collapseContacts();
        shopGoldItemView.setContactsHandlerListener(new a2.a.a.s2.b.l.a(shopGoldItemPresenterImpl, shopGoldItemView));
    }

    public static final void access$expand(ShopGoldItemPresenterImpl shopGoldItemPresenterImpl, ShopGoldItemView shopGoldItemView) {
        shopGoldItemView.setContactsHandlerName(shopGoldItemPresenterImpl.b);
        shopGoldItemView.expandContacts();
        shopGoldItemView.setContactsHandlerListener(new a2.a.a.s2.b.l.b(shopGoldItemPresenterImpl, shopGoldItemView));
    }

    @Override // com.avito.android.shop.detailed.item.ShopGoldItemPresenter
    @NotNull
    public Kundle onSaveState() {
        Kundle kundle = new Kundle();
        kundle.putBoolean("contacts_expanded", Boolean.valueOf(this.a));
        return kundle;
    }

    public void bindView(@NotNull ShopGoldItemView shopGoldItemView, @NotNull ShopGoldItem shopGoldItem, int i) {
        Intrinsics.checkNotNullParameter(shopGoldItemView, "view");
        Intrinsics.checkNotNullParameter(shopGoldItem, "item");
        ShopHeaderListener shopHeaderListener = this.g.get();
        shopGoldItemView.setName(shopGoldItem.getName());
        shopGoldItemView.setCategory(shopGoldItem.getCategory());
        shopGoldItemView.setCreationDate(shopGoldItem.getCreationDate());
        SellerVerification sellerVerification = shopGoldItem.getSellerVerification();
        if (sellerVerification != null) {
            SellerVerification.VerificationItem internal = sellerVerification.getInternal();
            shopGoldItemView.setInternalVerification(internal != null ? internal.getTitle() : null, new a(1, sellerVerification, shopGoldItemView, shopHeaderListener));
            SellerVerification.VerificationItem external = sellerVerification.getExternal();
            shopGoldItemView.setExternalVerification(external != null ? external.getTitle() : null, new a(2, sellerVerification, shopGoldItemView, shopHeaderListener));
            shopGoldItemView.showVerification();
        }
        Picture pictureOf$default = AvitoPictureKt.pictureOf$default(shopGoldItem.getLogo(), false, 0.0f, 0.0f, null, 28, null);
        if (shopGoldItem.getBackground() == null) {
            shopGoldItemView.setLogo(pictureOf$default);
        }
        if (shopGoldItem.getDescription() != null) {
            shopGoldItemView.setDescription(shopGoldItem.getDescription().getTitle(), new b(shopHeaderListener, this, shopGoldItem, shopGoldItemView));
        }
        this.f.bindRatingToView(shopGoldItem.getRating(), shopGoldItemView);
        if (this.a) {
            shopGoldItemView.setContactsHandlerName(this.b);
            shopGoldItemView.expandContacts();
            shopGoldItemView.setContactsHandlerListener(new a2.a.a.s2.b.l.b(this, shopGoldItemView));
        } else {
            shopGoldItemView.setContactsHandlerName(this.c);
            shopGoldItemView.collapseContacts();
            shopGoldItemView.setContactsHandlerListener(new a2.a.a.s2.b.l.a(this, shopGoldItemView));
        }
        this.d.setUserData(shopGoldItem.getUserKey(), null);
        this.d.attachButtonsView(shopGoldItemView);
        SubscriptionsPresenter.DefaultImpls.updateSellersSubscription$default(this.d, shopGoldItem.getSubscribeInfo(), false, 2, null);
        this.e.addOptionalElement(shopGoldItemView);
        shopGoldItemView.clearContacts();
        if (Collections.isNullOrEmpty(shopGoldItem.getPhones()) && shopGoldItem.getSite() == null) {
            shopGoldItemView.hideContactsButton();
        }
        List<Action> phones = shopGoldItem.getPhones();
        if (phones != null) {
            for (T t : phones) {
                shopGoldItemView.addContactCell(t.getTitle(), R.drawable.ic_phone_24_blue, new a(0, t, shopGoldItemView, shopHeaderListener));
            }
        }
        ActionNullable address = shopGoldItem.getAddress();
        if (address != null) {
            shopGoldItemView.showLocation(address.getTitle(), new a(3, address, shopGoldItemView, shopHeaderListener));
        }
        Action site = shopGoldItem.getSite();
        if (site != null) {
            shopGoldItemView.addContactCell(site.getTitle(), R.drawable.ic_web_24_blue, new a(4, site, shopGoldItemView, shopHeaderListener));
        }
        shopGoldItemView.setUnbindListener(new a(5, this, shopGoldItem, shopGoldItemView));
    }
}
