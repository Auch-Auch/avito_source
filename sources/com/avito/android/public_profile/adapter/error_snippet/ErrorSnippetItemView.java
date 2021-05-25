package com.avito.android.public_profile.adapter.error_snippet;

import com.avito.android.component.load_snippet.LoadSnippet;
import com.avito.konveyor.blueprint.ItemView;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/avito/android/public_profile/adapter/error_snippet/ErrorSnippetItemView;", "Lcom/avito/konveyor/blueprint/ItemView;", "Lcom/avito/android/component/load_snippet/LoadSnippet;", "public-profile_release"}, k = 1, mv = {1, 4, 2})
public interface ErrorSnippetItemView extends ItemView, LoadSnippet {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static void onUnbind(@NotNull ErrorSnippetItemView errorSnippetItemView) {
            ItemView.DefaultImpls.onUnbind(errorSnippetItemView);
        }
    }
}
