package com.avito.android.advert.item.safe_show.contact_bar;

import android.view.View;
import com.avito.android.advert_core.contactbar.ContactBarProvider;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/avito/android/advert/item/safe_show/contact_bar/SafeShowContactBarProvider;", "Lcom/avito/android/advert_core/contactbar/ContactBarProvider;", "Lcom/avito/android/component/contact_bar/ContactBar;", "createContactBar", "()Lcom/avito/android/component/contact_bar/ContactBar;", "", AuthSource.BOOKING_ORDER, "Ljava/lang/String;", "btnText", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;Ljava/lang/String;)V", "advert-details_release"}, k = 1, mv = {1, 4, 2})
public final class SafeShowContactBarProvider implements ContactBarProvider {
    public final View a;
    public final String b;

    public SafeShowContactBarProvider(@NotNull View view, @NotNull String str) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(str, "btnText");
        this.a = view;
        this.b = str;
    }

    @Override // com.avito.android.advert_core.contactbar.ContactBarProvider
    @NotNull
    public ContactBar createContactBar() {
        return new SafeShowContactBarImpl(this.a, this.b);
    }
}
