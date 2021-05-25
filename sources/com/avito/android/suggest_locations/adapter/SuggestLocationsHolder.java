package com.avito.android.suggest_locations.adapter;

import a2.b.a.a.a;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;
import com.avito.android.inline_filters.analytics.VerticalFilterCloseDialogEventKt;
import com.avito.android.suggest_locations.adapter.SuggestLocationItem;
import com.avito.android.util.TextViews;
import com.avito.android.util.Views;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/suggest_locations/adapter/SuggestLocationsHolder;", "Lcom/avito/android/suggest_locations/adapter/SuggestHolder;", "Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;", VerticalFilterCloseDialogEventKt.MODEL_DIALOG, "", "bind", "(Lcom/avito/android/suggest_locations/adapter/SuggestLocationItem;)V", "Landroid/view/View;", "view", "<init>", "(Landroid/view/View;)V", "suggest-locations_release"}, k = 1, mv = {1, 4, 2})
public final class SuggestLocationsHolder extends SuggestHolder<SuggestLocationItem> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SuggestLocationsHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }

    public void bind(@NotNull SuggestLocationItem suggestLocationItem) {
        Intrinsics.checkNotNullParameter(suggestLocationItem, VerticalFilterCloseDialogEventKt.MODEL_DIALOG);
        Views.setVisible(getImageSuggestType(), suggestLocationItem.withIcon());
        SuggestLocationItem.From from = suggestLocationItem.getFrom();
        if (from != null) {
            Views.setVisible(getTextParent(), false);
            TextView textLocation = getTextLocation();
            String name = from.getName();
            if (name == null) {
                name = "";
            }
            String name2 = suggestLocationItem.getNames().getName();
            Intrinsics.checkNotNullExpressionValue(name2, "model.names.name");
            String H = a.H(new Object[]{name, name2}, 2, "%s → %s", "java.lang.String.format(this, *args)");
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(H);
            spannableStringBuilder.setSpan(new StyleSpan(1), name.length() + 3, H.length(), 17);
            TextViews.bindText$default(textLocation, spannableStringBuilder, false, 2, null);
            return;
        }
        SuggestLocationItem.Parent parent = suggestLocationItem.getParent();
        if (parent != null) {
            Views.setVisible(getTextParent(), true);
            getTextParent().setText(parent.getNames().getName());
            getTextLocation().setText(suggestLocationItem.getNames().getName());
            return;
        }
        getTextLocation().setText(suggestLocationItem.getNames().getName());
        Views.setVisible(getTextParent(), false);
    }
}
