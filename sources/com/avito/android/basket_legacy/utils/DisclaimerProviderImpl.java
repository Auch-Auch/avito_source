package com.avito.android.basket_legacy.utils;

import com.avito.android.component.disclaimer.DisclaimerItem;
import com.avito.android.deep_linking.links.InfoPageLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.text.AttributedText;
import com.avito.android.remote.model.text.DeepLinkAttribute;
import com.avito.conveyor_item.Item;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u00020\u00028\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/basket_legacy/utils/DisclaimerProviderImpl;", "Lcom/avito/android/basket_legacy/utils/DisclaimerProvider;", "Lcom/avito/conveyor_item/Item;", AuthSource.SEND_ABUSE, "Lcom/avito/conveyor_item/Item;", "getDisclaimerItem", "()Lcom/avito/conveyor_item/Item;", "disclaimerItem", "Lcom/avito/android/basket_legacy/utils/StringProvider;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/basket_legacy/utils/StringProvider;", "stringProvider", "<init>", "(Lcom/avito/android/basket_legacy/utils/StringProvider;)V", "basket_release"}, k = 1, mv = {1, 4, 2})
public final class DisclaimerProviderImpl implements DisclaimerProvider {
    @NotNull
    public final Item a;
    public final StringProvider b;

    @Inject
    public DisclaimerProviderImpl(@NotNull StringProvider stringProvider) {
        Intrinsics.checkNotNullParameter(stringProvider, "stringProvider");
        this.b = stringProvider;
        this.a = new DisclaimerItem("disclaimerId", new AttributedText(stringProvider.getFeesAgreementPlaceholder(), d.listOf(new DeepLinkAttribute("link1", stringProvider.getDisclaimerTitle(), new InfoPageLink("oferta", stringProvider.getOfferTitle()), null, null, 24, null))));
    }

    @Override // com.avito.android.basket_legacy.utils.DisclaimerProvider
    @NotNull
    public Item getDisclaimerItem() {
        return this.a;
    }
}
