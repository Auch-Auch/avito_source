package com.avito.android.advert_core.contactbar;

import a2.g.r.g;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import com.avito.android.Features;
import com.avito.android.advert_core.R;
import com.avito.android.component.contact_bar.AdvertDetailsContactBar;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.image_loader.AvitoPictureKt;
import com.avito.android.lib.design.snackbar.SnackbarExtensionsKt;
import com.avito.android.lib.design.snackbar.SnackbarPosition;
import com.avito.android.lib.design.snackbar.SnackbarType;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import com.avito.android.util.Views;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.c;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002BK\u0012\u0006\u00109\u001a\u00020#\u0012\u0006\u00100\u001a\u00020\u0016\u0012\b\b\u0002\u0010?\u001a\u00020\u0016\u0012\n\b\u0002\u0010=\u001a\u0004\u0018\u00010:\u0012\u0006\u0010G\u001a\u00020F\u0012\n\b\u0002\u0010H\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010J\u001a\u00020I¢\u0006\u0004\bK\u0010LJ;\u0010\u000b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u0011\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0015\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0013H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001cJ\u000f\u0010\u001f\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010\u001b\u001a\u00020\tH\u0016¢\u0006\u0004\b\u001b\u0010 J!\u0010%\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010!2\u0006\u0010$\u001a\u00020#H\u0016¢\u0006\u0004\b%\u0010&J\u000f\u0010(\u001a\u00020'H\u0016¢\u0006\u0004\b(\u0010)J\u000f\u0010*\u001a\u00020'H\u0016¢\u0006\u0004\b*\u0010)J\u0017\u0010,\u001a\u00020\t2\u0006\u0010+\u001a\u00020\rH\u0016¢\u0006\u0004\b,\u0010-R\u0016\u00100\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R\u001d\u00106\u001a\u0002018B@\u0002X\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00109\u001a\u00020#8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b7\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010?\u001a\u00020\u00168\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010/R\u001e\u0010C\u001a\n A*\u0004\u0018\u00010@0@8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b4\u0010BR\u0018\u0010E\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u00108¨\u0006M"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsViewImpl;", "Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "Landroid/view/ViewStub$OnInflateListener;", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onActionClick", "showContactBar", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "name", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "onlineStatus", "updateOnlineStatus", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "visible", "immediately", "animateShowHide", "(ZZ)V", "hide", "(Z)V", "isEnabled", "setEnabled", "show", "()V", "Landroid/view/ViewStub;", "stub", "Landroid/view/View;", "inflated", "onInflate", "(Landroid/view/ViewStub;Landroid/view/View;)V", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "message", "showSnackbarAbove", "(Ljava/lang/String;)V", "e", "Z", "isInPhotoGallery", "Lcom/avito/android/component/contact_bar/ContactBar;", "c", "Lkotlin/Lazy;", AuthSource.SEND_ABUSE, "()Lcom/avito/android/component/contact_bar/ContactBar;", "contactBar", "d", "Landroid/view/View;", "rootView", "Lcom/avito/android/advert_core/contactbar/AdvertContactsBindListener;", g.a, "Lcom/avito/android/advert_core/contactbar/AdvertContactsBindListener;", "bindListener", "f", "isFastOpenAdvertDetails", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "Landroid/content/Context;", "context", AuthSource.BOOKING_ORDER, "contactBarView", "Lcom/avito/android/Features;", "features", "contactBarViewStub", "Lcom/avito/android/advert_core/contactbar/ContactBarProvider;", "contactBarProvider", "<init>", "(Landroid/view/View;ZZLcom/avito/android/advert_core/contactbar/AdvertContactsBindListener;Lcom/avito/android/Features;Landroid/view/ViewStub;Lcom/avito/android/advert_core/contactbar/ContactBarProvider;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class AdvertContactsViewImpl implements AdvertContactsView, ViewStub.OnInflateListener {
    public final Context a;
    public View b;
    public final Lazy c;
    public final View d;
    public final boolean e;
    public final boolean f;
    public final AdvertContactsBindListener g;

    public static final class a extends Lambda implements Function0<ContactBar> {
        public final /* synthetic */ ContactBarProvider a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ContactBarProvider contactBarProvider) {
            super(0);
            this.a = contactBarProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public ContactBar invoke() {
            return this.a.createContactBar();
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ AdvertContactsViewImpl b;

        public b(View view, AdvertContactsViewImpl advertContactsViewImpl) {
            this.a = view;
            this.b = advertContactsViewImpl;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View view = this.b.b;
            int height = view != null ? view.getHeight() : 0;
            if (height > 8) {
                View rootView = this.a.getRootView();
                Intrinsics.checkNotNullExpressionValue(rootView, "rootView");
                height -= Views.dpToPx(rootView, 8);
            }
            AdvertContactsBindListener advertContactsBindListener = this.b.g;
            if (advertContactsBindListener != null) {
                advertContactsBindListener.onContactBarBind(height);
            }
        }
    }

    public AdvertContactsViewImpl(@NotNull View view, boolean z, boolean z2, @Nullable AdvertContactsBindListener advertContactsBindListener, @NotNull Features features, @Nullable ViewStub viewStub, @NotNull ContactBarProvider contactBarProvider) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(features, "features");
        Intrinsics.checkNotNullParameter(contactBarProvider, "contactBarProvider");
        this.d = view;
        this.e = z;
        this.f = z2;
        this.g = advertContactsBindListener;
        this.a = view.getContext();
        this.c = c.lazy(LazyThreadSafetyMode.NONE, (Function0) new a(contactBarProvider));
        if (viewStub != null) {
            viewStub.setOnInflateListener(this);
        }
        if (z2) {
            a().hide();
        }
        new AdvertDetailsContactBar(view, z);
    }

    public final ContactBar a() {
        return (ContactBar) this.c.getValue();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void animateShowHide(boolean z, boolean z2) {
        a().animateShowHide(z, z2);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsTop() {
        return a().getButtonsTop();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public int getButtonsVisibilityPercents() {
        return a().getButtonsVisibilityPercents();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide(boolean z) {
        a().hide(z);
    }

    @Override // android.view.ViewStub.OnInflateListener
    public void onInflate(@Nullable ViewStub viewStub, @NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "inflated");
        this.b = view;
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    @NotNull
    public Observable<Unit> profileClicks() {
        return a().statusContainerClicks();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void setEnabled(boolean z) {
        a().setEnabled(z);
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void show() {
        a().show();
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showContactBar(@Nullable ContactBarData contactBarData, @NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(function1, "onActionClick");
        if (this.f) {
            a().show();
        }
        if (contactBarData != null) {
            a().showStatusContainer();
            updateOnlineStatus(contactBarData.getName(), contactBarData.getOnlineStatus());
            ContactBar a3 = a();
            Image avatar = contactBarData.getAvatar();
            a3.setAvatar(avatar != null ? AvitoPictureKt.pictureOf$default(avatar, true, 0.0f, 0.0f, null, 28, null) : null, contactBarData.getIconType());
        } else {
            a().hideStatusContainer();
        }
        if (!list.isEmpty()) {
            a().setActions(list, function1);
            View view = this.b;
            if (view != null) {
                Views.show(view);
                view.post(new b(view, this));
                return;
            }
            return;
        }
        a().hide();
        View view2 = this.b;
        if (view2 != null) {
            Views.hide(view2);
        }
        AdvertContactsBindListener advertContactsBindListener = this.g;
        if (advertContactsBindListener != null) {
            advertContactsBindListener.onContactBarBind(0);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void showSnackbarAbove(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        View view = this.b;
        if (view == null || !Views.isVisible(view)) {
            SnackbarExtensionsKt.showSnackbar$default(this.d, str, 0, (String) null, 0, (Function0) null, 0, (SnackbarPosition) null, (SnackbarType) null, 254, (Object) null);
            return;
        }
        View view2 = this.b;
        if (view2 != null) {
            SnackbarExtensionsKt.showSnackbar$default(view2, str, 0, (String) null, 0, (Function0) null, 0, SnackbarPosition.ABOVE_VIEW, (SnackbarType) null, 190, (Object) null);
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void updateOnlineStatus(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(sellerOnlineStatus, "onlineStatus");
        a().setOnline(sellerOnlineStatus.isOnline());
        if (sellerOnlineStatus.isOnline()) {
            a().setUserStatus(str, this.a.getString(R.string.advert_contact_bar_online));
        } else {
            a().setUserStatus(str, sellerOnlineStatus.getReplySpeed());
        }
    }

    @Override // com.avito.android.advert_core.contactbar.AdvertContactsView
    public void hide() {
        a().hide();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdvertContactsViewImpl(android.view.View r9, boolean r10, boolean r11, com.avito.android.advert_core.contactbar.AdvertContactsBindListener r12, com.avito.android.Features r13, android.view.ViewStub r14, com.avito.android.advert_core.contactbar.ContactBarProvider r15, int r16, t6.r.a.j r17) {
        /*
            r8 = this;
            r1 = r9
            r0 = r16 & 4
            if (r0 == 0) goto L_0x0008
            r0 = 0
            r3 = 0
            goto L_0x0009
        L_0x0008:
            r3 = r11
        L_0x0009:
            r0 = r16 & 8
            if (r0 == 0) goto L_0x0010
            r0 = 0
            r4 = r0
            goto L_0x0011
        L_0x0010:
            r4 = r12
        L_0x0011:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x001f
            int r0 = com.avito.android.advert_core.R.id.contact_bar_flying
            android.view.View r0 = r9.findViewById(r0)
            android.view.ViewStub r0 = (android.view.ViewStub) r0
            r6 = r0
            goto L_0x0020
        L_0x001f:
            r6 = r14
        L_0x0020:
            r0 = r16 & 64
            if (r0 == 0) goto L_0x002d
            com.avito.android.advert_core.contactbar.ContactBarProviderImpl r0 = new com.avito.android.advert_core.contactbar.ContactBarProviderImpl
            r2 = r10
            r5 = r13
            r0.<init>(r9, r6, r13, r10)
            r7 = r0
            goto L_0x0030
        L_0x002d:
            r2 = r10
            r5 = r13
            r7 = r15
        L_0x0030:
            r0 = r8
            r1 = r9
            r2 = r10
            r5 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.advert_core.contactbar.AdvertContactsViewImpl.<init>(android.view.View, boolean, boolean, com.avito.android.advert_core.contactbar.AdvertContactsBindListener, com.avito.android.Features, android.view.ViewStub, com.avito.android.advert_core.contactbar.ContactBarProvider, int, t6.r.a.j):void");
    }
}
