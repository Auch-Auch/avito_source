package com.avito.android.advert.item.safe_show.contact_bar;

import android.view.View;
import com.avito.android.Features;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarView;
import com.avito.android.advert_core.contactbar.AdvertContactsViewImpl;
import com.avito.android.advert_core.contactbar.ContactBarProvider;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B-\u0012\u0006\u00100\u001a\u00020/\u0012\u0006\u00102\u001a\u000201\u0012\u0006\u00104\u001a\u000203\u0012\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0+¢\u0006\u0004\b5\u00106J;\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u001f\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u001f\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u001d\u0010\u001bJ\u000f\u0010\u001e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010\u001a\u001a\u00020\bH\u0016¢\u0006\u0004\b\u001a\u0010\u001fJ\u000f\u0010!\u001a\u00020 H\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H\u0016¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\u000fH\u0016¢\u0006\u0004\b%\u0010&R\u0016\u0010*\u001a\u00020'8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u001c\u0010.\u001a\b\u0012\u0004\u0012\u00020\b0+8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00067"}, d2 = {"Lcom/avito/android/advert/item/safe_show/contact_bar/SafeShowContactBarViewImpl;", "Lcom/avito/android/advert/item/contactbar/AdvertDetailsContactBarView;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onActionClick", "showContactBar", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "name", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "onlineStatus", "updateOnlineStatus", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)V", "", "visible", "immediately", "animateShowHide", "(ZZ)V", "hide", "(Z)V", "isEnabled", "setEnabled", "show", "()V", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "message", "showSnackbarAbove", "(Ljava/lang/String;)V", "Lcom/avito/android/advert_core/contactbar/AdvertContactsViewImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/contactbar/AdvertContactsViewImpl;", "advertContactsView", "Lkotlin/Function0;", AuthSource.BOOKING_ORDER, "Lkotlin/jvm/functions/Function0;", "buttonOnClickListener", "Landroid/view/View;", "view", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_core/contactbar/ContactBarProvider;", "contactBarProvider", "<init>", "(Landroid/view/View;Lcom/avito/android/Features;Lcom/avito/android/advert_core/contactbar/ContactBarProvider;Lkotlin/jvm/functions/Function0;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowContactBarViewImpl implements AdvertDetailsContactBarView {
    public final AdvertContactsViewImpl a;
    public final Function0<Unit> b;

    public static final class a extends Lambda implements Function1<ContactBar.Action, Unit> {
        public final /* synthetic */ SafeShowContactBarViewImpl a;
        public final /* synthetic */ Function1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(SafeShowContactBarViewImpl safeShowContactBarViewImpl, Function1 function1) {
            super(1);
            this.a = safeShowContactBarViewImpl;
            this.b = function1;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ContactBar.Action action) {
            ContactBar.Action action2 = action;
            Intrinsics.checkNotNullParameter(action2, "action");
            this.a.b.invoke();
            this.b.invoke(action2);
            return Unit.INSTANCE;
        }
    }

    public SafeShowContactBarViewImpl(@NotNull View view, @NotNull Features features, @NotNull ContactBarProvider contactBarProvider, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(contactBarProvider, "contactBarProvider");
        Intrinsics.checkNotNullParameter(function0, "buttonOnClickListener");
        this.b = function0;
        this.a = new AdvertContactsViewImpl(view, false, false, null, features, null, contactBarProvider, 44, null);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void animateShowHide(boolean z, boolean z2) {
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsTop() {
        return this.a.getButtonsTop();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsVisibilityPercents() {
        return this.a.getButtonsVisibilityPercents();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide(boolean z) {
        this.a.hide(z);
    }

    @Override // com.avito.konveyor.blueprint.ItemView
    public void onUnbind() {
        AdvertDetailsContactBarView.DefaultImpls.onUnbind(this);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    @NotNull
    public Observable<Unit> profileClicks() {
        return this.a.profileClicks();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void setEnabled(boolean z) {
        this.a.setEnabled(z);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void show() {
        this.a.show();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showContactBar(@Nullable ContactBarData contactBarData, @NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onActionClick");
        this.a.showContactBar(contactBarData, list, new a(this, function1));
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showSnackbarAbove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.a.showSnackbarAbove(str);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void updateOnlineStatus(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        this.a.updateOnlineStatus(str, sellerOnlineStatus);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide() {
        this.a.hide();
    }
}
