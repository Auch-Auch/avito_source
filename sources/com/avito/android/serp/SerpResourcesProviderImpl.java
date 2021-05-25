package com.avito.android.serp;

import android.content.res.Resources;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.SerpDisplayType;
import com.avito.android.ui_components.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0010¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\nR\u0016\u0010\u0013\u001a\u00020\u00108\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/avito/android/serp/SerpResourcesProviderImpl;", "Lcom/avito/android/serp/SerpResourcesProvider;", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "", "getColumnsCount", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "()I", "", "getCallUnavailableMessage", "()Ljava/lang/String;", "getMessengerUnavailableMessage", "getMessengerLoadingMessage", "getSearchHint", "getEmptySearchText", "getCommonErrorText", "Landroid/content/res/Resources;", AuthSource.SEND_ABUSE, "Landroid/content/res/Resources;", "resources", "<init>", "(Landroid/content/res/Resources;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class SerpResourcesProviderImpl implements SerpResourcesProvider {
    public final Resources a;

    public SerpResourcesProviderImpl(@NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(resources, "resources");
        this.a = resources;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getCallUnavailableMessage() {
        String string = this.a.getString(R.string.cant_do_call);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.cant_do_call)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    public int getColumnsCount(@Nullable SerpDisplayType serpDisplayType) {
        if (serpDisplayType == null || !serpDisplayType.isSingleColumn()) {
            return getColumnsCount();
        }
        return 1;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getCommonErrorText() {
        String string = this.a.getString(com.avito.android.search.R.string.saved_search_common_error);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(sear…aved_search_common_error)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getEmptySearchText() {
        String string = this.a.getString(com.avito.android.serp_core.R.string.empty_search);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(R.string.empty_search)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getMessengerLoadingMessage() {
        String string = this.a.getString(R.string.advert_chat_loading);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…ring.advert_chat_loading)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getMessengerUnavailableMessage() {
        String string = this.a.getString(R.string.advert_cant_open_chat);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R…ng.advert_cant_open_chat)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    @NotNull
    public String getSearchHint() {
        String string = this.a.getString(R.string.search);
        Intrinsics.checkNotNullExpressionValue(string, "resources.getString(ui_R.string.search)");
        return string;
    }

    @Override // com.avito.android.serp.SerpResourcesProvider
    public int getColumnsCount() {
        return this.a.getInteger(R.integer.serp_columns);
    }
}
