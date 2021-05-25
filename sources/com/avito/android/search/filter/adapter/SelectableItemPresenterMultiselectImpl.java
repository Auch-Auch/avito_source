package com.avito.android.search.filter.adapter;

import com.avito.android.search.filter.MultiselectDialogPresenter;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/avito/android/search/filter/adapter/SelectableItemPresenterMultiselectImpl;", "Lcom/avito/android/search/filter/adapter/SelectableItemPresenterInternal;", "Lcom/avito/android/search/filter/MultiselectDialogPresenter;", "dialogPresenter", "<init>", "(Lcom/avito/android/search/filter/MultiselectDialogPresenter;)V", "filter_release"}, k = 1, mv = {1, 4, 2})
public final class SelectableItemPresenterMultiselectImpl extends SelectableItemPresenterInternal {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @Inject
    public SelectableItemPresenterMultiselectImpl(@NotNull MultiselectDialogPresenter multiselectDialogPresenter) {
        super(multiselectDialogPresenter.selectableItemChangeConsumer());
        Intrinsics.checkNotNullParameter(multiselectDialogPresenter, "dialogPresenter");
    }
}
