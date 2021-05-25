package com.avito.android.advert_core.contactbar;

import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.model.advert_details.ContactBarData;
import com.avito.android.remote.model.advert_details.SellerOnlineStatus;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J;\u0010\n\u001a\u00020\b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H&¢\u0006\u0004\b\n\u0010\u000bJ\u001f\u0010\u0010\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH&¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0012H&¢\u0006\u0004\b\u0013\u0010\u0014J!\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H&¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\bH&¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\bH&¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u0015H&¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001e\u001a\u00020\u0015H&¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010!\u001a\u00020 H&¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020 H&¢\u0006\u0004\b#\u0010\"J\u0017\u0010%\u001a\u00020\b2\u0006\u0010$\u001a\u00020\fH&¢\u0006\u0004\b%\u0010&¨\u0006'"}, d2 = {"Lcom/avito/android/advert_core/contactbar/AdvertContactsView;", "", "Lcom/avito/android/remote/model/advert_details/ContactBarData;", "data", "", "Lcom/avito/android/component/contact_bar/ContactBar$Action;", "actions", "Lkotlin/Function1;", "", "onActionClick", "showContactBar", "(Lcom/avito/android/remote/model/advert_details/ContactBarData;Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "", "name", "Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;", "onlineStatus", "updateOnlineStatus", "(Ljava/lang/String;Lcom/avito/android/remote/model/advert_details/SellerOnlineStatus;)V", "Lio/reactivex/rxjava3/core/Observable;", "profileClicks", "()Lio/reactivex/rxjava3/core/Observable;", "", "visible", "immediately", "animateShowHide", "(ZZ)V", "show", "()V", "hide", "(Z)V", "isEnabled", "setEnabled", "", "getButtonsTop", "()I", "getButtonsVisibilityPercents", "message", "showSnackbarAbove", "(Ljava/lang/String;)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public interface AdvertContactsView {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ void animateShowHide$default(AdvertContactsView advertContactsView, boolean z, boolean z2, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    z2 = false;
                }
                advertContactsView.animateShowHide(z, z2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateShowHide");
        }
    }

    void animateShowHide(boolean z, boolean z2);

    int getButtonsTop();

    int getButtonsVisibilityPercents();

    void hide();

    void hide(boolean z);

    @NotNull
    Observable<Unit> profileClicks();

    void setEnabled(boolean z);

    void show();

    void showContactBar(@Nullable ContactBarData contactBarData, @NotNull List<ContactBar.Action> list, @NotNull Function1<? super ContactBar.Action, Unit> function1);

    void showSnackbarAbove(@NotNull String str);

    void updateOnlineStatus(@NotNull String str, @NotNull SellerOnlineStatus sellerOnlineStatus);
}
