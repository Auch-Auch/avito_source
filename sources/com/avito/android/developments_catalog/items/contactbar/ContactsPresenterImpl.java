package com.avito.android.developments_catalog.items.contactbar;

import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.PhoneLink;
import com.avito.android.deep_linking.links.PhoneRequestLink;
import com.avito.android.developments_catalog.DevelopmentsCatalogPresenter;
import com.avito.android.remote.auth.AuthSource;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u000b¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u000e\u001a\u00020\u000b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/avito/android/developments_catalog/items/contactbar/ContactsPresenterImpl;", "Lcom/avito/android/developments_catalog/items/contactbar/ContactsPresenter;", "Lcom/avito/android/developments_catalog/items/contactbar/ContactsView;", "view", "Lcom/avito/android/developments_catalog/items/contactbar/ContactsItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/developments_catalog/items/contactbar/ContactsView;Lcom/avito/android/developments_catalog/items/contactbar/ContactsItem;I)V", "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", AuthSource.SEND_ABUSE, "Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;", "presenter", "<init>", "(Lcom/avito/android/developments_catalog/DevelopmentsCatalogPresenter;)V", "developments-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class ContactsPresenterImpl implements ContactsPresenter {
    public final DevelopmentsCatalogPresenter a;

    public static final class a extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ContactsPresenterImpl a;
        public final /* synthetic */ ContactsItem b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ContactsPresenterImpl contactsPresenterImpl, ContactsItem contactsItem) {
            super(0);
            this.a = contactsPresenterImpl;
            this.b = contactsItem;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.jvm.functions.Function0
        public Unit invoke() {
            DeepLink deepLink = this.b.getPhone().getDeepLink();
            if (deepLink instanceof PhoneLink) {
                this.a.a.onCallButtonClick((PhoneLink) deepLink);
            } else if (deepLink instanceof PhoneRequestLink) {
                this.a.a.trackContactButtonClick();
                this.a.a.followDeepLink(deepLink);
            }
            return Unit.INSTANCE;
        }
    }

    @Inject
    public ContactsPresenterImpl(@NotNull DevelopmentsCatalogPresenter developmentsCatalogPresenter) {
        Intrinsics.checkNotNullParameter(developmentsCatalogPresenter, "presenter");
        this.a = developmentsCatalogPresenter;
    }

    public void bindView(@NotNull ContactsView contactsView, @NotNull ContactsItem contactsItem, int i) {
        Intrinsics.checkNotNullParameter(contactsView, "view");
        Intrinsics.checkNotNullParameter(contactsItem, "item");
        contactsView.bindAction(contactsItem.getPhone().getTitle(), new a(this, contactsItem));
    }
}
