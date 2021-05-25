package com.avito.android.publish.category_suggest;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\"\u0019\u0010\u0005\u001a\u00020\u00008\u0006@\u0006¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0007\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b\"\u0016\u0010\t\u001a\u00020\u00068\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/Navigation;", AuthSource.SEND_ABUSE, "Lcom/avito/android/remote/model/Navigation;", "getOTHER_CATEGORY_NAVIGATION", "()Lcom/avito/android/remote/model/Navigation;", "OTHER_CATEGORY_NAVIGATION", "", "OTHER_CATEGORY_TITLE", "Ljava/lang/String;", "CHOSEN_CATEGORY_ITEM_ID", "publish_release"}, k = 2, mv = {1, 4, 2})
public final class CategoriesSuggestionsViewModelKt {
    @NotNull
    public static final String CHOSEN_CATEGORY_ITEM_ID = "chosen_id";
    @NotNull
    public static final String OTHER_CATEGORY_TITLE = "Другая категория";
    @NotNull
    public static final Navigation a = new Navigation(OTHER_CATEGORY_TITLE, null, null, null, null, null, null, 126, null);

    @NotNull
    public static final Navigation getOTHER_CATEGORY_NAVIGATION() {
        return a;
    }
}
