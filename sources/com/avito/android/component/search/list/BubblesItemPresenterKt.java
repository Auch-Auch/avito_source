package com.avito.android.component.search.list;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.search.suggest.SuggestBubbleItem;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a-\u0010\u0005\u001a\u00020\u0004*\u0004\u0018\u00010\u00002\u0016\b\u0002\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001H\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;", "Lkotlin/Function1;", "", "action", "", AuthSource.SEND_ABUSE, "(Lcom/avito/android/remote/model/search/suggest/SuggestBubbleItem$ColorConfiguration;Lkotlin/jvm/functions/Function1;)Z", "ui-components_release"}, k = 2, mv = {1, 4, 2})
public final class BubblesItemPresenterKt {
    public static final boolean a(SuggestBubbleItem.ColorConfiguration colorConfiguration, Function1<? super SuggestBubbleItem.ColorConfiguration, Unit> function1) {
        if (colorConfiguration == null || colorConfiguration.getBackground() == null || colorConfiguration.getHighlightedBackground() == null || colorConfiguration.getBorder() == null || colorConfiguration.getText() == null || colorConfiguration.getDescription() == null) {
            return false;
        }
        if (function1 != null) {
            function1.invoke(colorConfiguration);
        }
        return true;
    }
}
