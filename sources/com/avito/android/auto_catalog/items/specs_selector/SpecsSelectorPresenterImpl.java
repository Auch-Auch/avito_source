package com.avito.android.auto_catalog.items.specs_selector;

import com.avito.android.advert_core.specifications.SpecificationsConverterImpl;
import com.avito.android.auto_catalog.AutoCatalogPresenter;
import com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorView;
import com.avito.android.auto_catalog.remote.model.ModificationItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.ModelSpecifications;
import com.avito.android.serp.adapter.SimpleNarrowLayoutTypeProviderImpl;
import com.vk.sdk.api.VKApiConst;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0011\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000e¢\u0006\u0004\b\u0016\u0010\u0017J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\f\u001a\u00020\tH\u0016¢\u0006\u0004\b\f\u0010\rR\u0016\u0010\u0011\u001a\u00020\u000e8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenterImpl;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorPresenter;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView$Listener;", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView;", "view", "Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorItem;", "item", "", VKApiConst.POSITION, "", "bindView", "(Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorView;Lcom/avito/android/auto_catalog/items/specs_selector/SpecsSelectorItem;I)V", "onSpecsClick", "()V", "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/auto_catalog/AutoCatalogPresenter;", "presenter", "Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;", AuthSource.SEND_ABUSE, "Lcom/avito/android/advert_core/specifications/SpecificationsConverterImpl;", "converter", "<init>", "(Lcom/avito/android/auto_catalog/AutoCatalogPresenter;)V", "auto-catalog_release"}, k = 1, mv = {1, 4, 2})
public final class SpecsSelectorPresenterImpl implements SpecsSelectorPresenter, SpecsSelectorView.Listener {
    public final SpecificationsConverterImpl a = new SpecificationsConverterImpl(new SimpleNarrowLayoutTypeProviderImpl());
    public final AutoCatalogPresenter b;

    @Inject
    public SpecsSelectorPresenterImpl(@NotNull AutoCatalogPresenter autoCatalogPresenter) {
        Intrinsics.checkNotNullParameter(autoCatalogPresenter, "presenter");
        this.b = autoCatalogPresenter;
    }

    @Override // com.avito.android.auto_catalog.items.specs_selector.SpecsSelectorView.Listener
    public void onSpecsClick() {
        this.b.onSelectSpecsClick();
    }

    public void bindView(@NotNull SpecsSelectorView specsSelectorView, @NotNull SpecsSelectorItem specsSelectorItem, int i) {
        ModelSpecifications specification;
        Intrinsics.checkNotNullParameter(specsSelectorView, "view");
        Intrinsics.checkNotNullParameter(specsSelectorItem, "item");
        ModificationItem modification = specsSelectorItem.getModification();
        if (modification != null && (specification = modification.getSpecification()) != null) {
            specsSelectorView.setSpecs(specsSelectorItem.getTitleSelected(), this.a.convertSpecifications(specification, specsSelectorItem.getSchemePosition()), specsSelectorItem.isClickableSelector() ? this : null);
        }
    }
}
