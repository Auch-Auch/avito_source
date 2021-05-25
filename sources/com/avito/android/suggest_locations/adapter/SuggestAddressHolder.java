package com.avito.android.suggest_locations.adapter;

import android.view.View;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.remote.model.location_picker.AddressSuggestion;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestAddressHolder;", "Lcom/avito/android/suggest_locations/adapter/SuggestHolder;", "Lcom/avito/android/remote/model/location_picker/AddressSuggestion;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", "bind", "(Lcom/avito/android/remote/model/location_picker/AddressSuggestion;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestAddressHolder extends SuggestHolder<AddressSuggestion> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestAddressHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void bind(@NotNull AddressSuggestion addressSuggestion) {
        Intrinsics.checkNotNullParameter(addressSuggestion, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        TextViews.bindText$default(getTextLocation(), addressSuggestion.getTitle(), false, 2, null);
        TextViews.bindText$default(getTextParent(), addressSuggestion.getSubtitle(), false, 2, null);
        if (addressSuggestion.getSuggestType() == AddressSuggestion.SuggestType.HISTORICAL) {
            Views.show(getImageSuggestType());
        } else {
            Views.hide(getImageSuggestType());
        }
    }
}
