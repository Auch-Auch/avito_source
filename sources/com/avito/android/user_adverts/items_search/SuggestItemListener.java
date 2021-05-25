package com.avito.android.user_adverts.items_search;

import com.avito.android.authorization.event.SocialButtonClickedEventKt;
import com.vk.sdk.api.VKApiConst;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/user_adverts/items_search/SuggestItemListener;", "", "", SocialButtonClickedEventKt.SUGGEST, "", VKApiConst.POSITION, "", "onSuggestClicked", "(Ljava/lang/String;I)V", "user-adverts_release"}, k = 1, mv = {1, 4, 2})
public interface SuggestItemListener {
    void onSuggestClicked(@NotNull String str, int i);
}
