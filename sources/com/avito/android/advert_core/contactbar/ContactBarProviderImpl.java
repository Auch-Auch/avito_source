package com.avito.android.advert_core.contactbar;

import android.view.View;
import android.view.ViewStub;
import com.avito.android.Features;
import com.avito.android.component.contact_bar.AdvertDetailsContactBar;
import com.avito.android.component.contact_bar.AdvertDetailsFloatingContactBar;
import com.avito.android.component.contact_bar.ContactBar;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00058\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/avito/android/advert_core/contactbar/ContactBarProviderImpl;", "Lcom/avito/android/advert_core/contactbar/ContactBarProvider;", "Lcom/avito/android/component/contact_bar/ContactBar;", "createContactBar", "()Lcom/avito/android/component/contact_bar/ContactBar;", "Landroid/view/View;", AuthSource.SEND_ABUSE, "Landroid/view/View;", "rootView", "", "c", "Z", "isInPhotoGallery", "Landroid/view/ViewStub;", AuthSource.BOOKING_ORDER, "Landroid/view/ViewStub;", "contactBarViewStub", "Lcom/avito/android/Features;", "features", "<init>", "(Landroid/view/View;Landroid/view/ViewStub;Lcom/avito/android/Features;Z)V", "advert-core_release"}, k = 1, mv = {1, 4, 2})
public final class ContactBarProviderImpl implements ContactBarProvider {
    public final View a;
    public final ViewStub b;
    public final boolean c;

    public ContactBarProviderImpl(@NotNull View view, @Nullable ViewStub viewStub, @NotNull Features features, boolean z) {
        Intrinsics.checkNotNullParameter(view, "rootView");
        Intrinsics.checkNotNullParameter(features, "features");
        this.a = view;
        this.b = viewStub;
        this.c = z;
    }

    @Override // com.avito.android.advert_core.contactbar.ContactBarProvider
    @NotNull
    public ContactBar createContactBar() {
        ViewStub viewStub = this.b;
        if (viewStub == null) {
            return new AdvertDetailsContactBar(this.a, this.c);
        }
        View inflate = viewStub.inflate();
        Intrinsics.checkNotNullExpressionValue(inflate, "contactBarViewStub.inflate()");
        return new AdvertDetailsFloatingContactBar(inflate);
    }
}
