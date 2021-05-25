package com.avito.android.advert.item.safe_show;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.avito.android.Features;
import com.avito.android.advert.di.AdvertFragmentModule;
import com.avito.android.advert.item.contactbar.AdvertDetailsContactBarItem;
import com.avito.android.advert.item.safe_show.contact_bar.SafeShowContactBarProvider;
import com.avito.android.advert.item.safe_show.contact_bar.SafeShowContactBarViewImpl;
import com.avito.android.advert_core.contactbar.AdvertContactsPresenter;
import com.avito.android.advert_core.safe_show.SafeShowDialogFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.ui_components.R;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\u00020\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0014\u001a\u00020\u0013\u0012\u0006\u0010\u0012\u001a\u00020\u000f\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u0015\u0010\u0016J+\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0017"}, d2 = {"Lcom/avito/android/advert/item/safe_show/SafeShowAdvertDetailsDialogFactory;", "Lcom/avito/android/advert_core/safe_show/SafeShowDialogFactory;", "Landroid/content/Context;", "context", "Lcom/avito/android/advert/item/safe_show/SafeShowItem;", "item", "Lkotlin/Function0;", "", "onContactsBtnClicked", "show", "(Landroid/content/Context;Lcom/avito/android/advert/item/safe_show/SafeShowItem;Lkotlin/jvm/functions/Function0;)V", "Lcom/avito/android/Features;", "c", "Lcom/avito/android/Features;", "features", "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;", "contactsPresenter", "", "isTablet", "<init>", "(ZLcom/avito/android/advert_core/contactbar/AdvertContactsPresenter;Lcom/avito/android/Features;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowAdvertDetailsDialogFactory extends SafeShowDialogFactory {
    public final AdvertContactsPresenter b;
    public final Features c;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Function0 a;
        public final /* synthetic */ Dialog b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Function0 function0, Dialog dialog) {
            super(0);
            this.a = function0;
            this.b = dialog;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            this.a.invoke();
            this.b.cancel();
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SafeShowAdvertDetailsDialogFactory(@AdvertFragmentModule.IsTablet boolean z, @NotNull AdvertContactsPresenter advertContactsPresenter, @NotNull Features features) {
        super(z);
        Intrinsics.checkNotNullParameter(advertContactsPresenter, "contactsPresenter");
        Intrinsics.checkNotNullParameter(features, "features");
        this.b = advertContactsPresenter;
        this.c = features;
    }

    public final void show(@NotNull Context context, @NotNull SafeShowItem safeShowItem, @NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(safeShowItem, "item");
        Intrinsics.checkNotNullParameter(function0, "onContactsBtnClicked");
        AdvertDetailsContactBarItem advertDetailsContactBarItem = new AdvertDetailsContactBarItem(0, null, safeShowItem.getActions(), safeShowItem.getContactBarData(), null, 0, null, null, 211, null);
        Dialog build = super.build(context, safeShowItem.getBottomSheetTitle(), safeShowItem.getBottomSheetText());
        View findViewById = build.findViewById(R.id.contact_bar_buttons_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(id)");
        String contactBtnText = safeShowItem.getContactBtnText();
        if (contactBtnText == null) {
            contactBtnText = context.getString(com.avito.android.advert_details.R.string.advert_details_safe_show_default_btn_text);
            Intrinsics.checkNotNullExpressionValue(contactBtnText, "context.getString(R.stri…fe_show_default_btn_text)");
        }
        this.b.bindSafeShowData(new SafeShowContactBarViewImpl(findViewById, this.c, new SafeShowContactBarProvider(findViewById, contactBtnText), new a(function0, build)), advertDetailsContactBarItem.getActions(), advertDetailsContactBarItem.getContactBarData());
        build.show();
    }
}
