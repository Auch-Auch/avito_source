package com.avito.android.advert.item.contactbar;

import android.view.View;
import com.avito.android.Features;
import com.avito.android.advert_core.contactbar.AdvertContactsViewImpl;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import com.avito.konveyor.adapter.BaseViewHolder;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\u0012\u0006\u0010+\u001a\u00020(\u0012\u0006\u00101\u001a\u000200¢\u0006\u0004\b2\u00103J;\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u001f\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010 J\u000f\u0010\"\u001a\u00020!H\u0016¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020!H\u0016¢\u0006\u0004\b$\u0010#J\u0017\u0010&\u001a\u00020\t2\u0006\u0010%\u001a\u00020\u0010H\u0016¢\u0006\u0004\b&\u0010'R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010/\u001a\u00020,8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u0010.¨\u00064"}, d2 = {"Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarViewImpl;", "Lcom/avito/konveyor/adapter/BaseViewHolder;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarView;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onActionClick", "showContactBar", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "name", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "onlineStatus", "updateOnlineStatus", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)V", "", "visible", "immediately", "animateShowHide", "(ZZ)V", "hide", "(Z)V", "isEnabled", "setEnabled", "show", "()V", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "message", "showSnackbarAbove", "(Ljava/lang/String;)V", "Landroid/view/View;", "t", "Landroid/view/View;", "view", "Lcom/avito/android/advert_core/contactbar/AdvertContactsViewImpl;", "s", "Lcom/avito/android/advert_core/contactbar/AdvertContactsViewImpl;", "advertContactsView", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertDetailsContactBarViewImpl extends BaseViewHolder implements AdvertDetailsContactBarView {
    public final AdvertContactsViewImpl s;
    public final View t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AdvertDetailsContactBarViewImpl(@NotNull View view, @NotNull Features features) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        this.t = view;
        this.s = new AdvertContactsViewImpl(view, false, false, null, features, null, null, 108, null);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void animateShowHide(boolean z, boolean z2) {
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsTop() {
        return this.s.getButtonsTop();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsVisibilityPercents() {
        return this.s.getButtonsVisibilityPercents();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide(boolean z) {
        this.s.hide(z);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    @NotNull
    public Observable<Unit> profileClicks() {
        return this.s.profileClicks();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void setEnabled(boolean z) {
        this.s.setEnabled(z);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void show() {
        this.s.show();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showContactBar(@Nullable ContactBarData contactBarData, @NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onActionClick");
        this.s.showContactBar(contactBarData, list, function1);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showSnackbarAbove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.s.showSnackbarAbove(str);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void updateOnlineStatus(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        this.s.updateOnlineStatus(str, sellerOnlineStatus);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide() {
        this.s.hide();
    }
}
