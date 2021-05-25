package com.avito.android.serp;

import com.avito.android.remote.model.SerpDisplayType;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\bf\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u0019\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0004\b\u0003\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH&¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\bH&¢\u0006\u0004\b\r\u0010\nJ\u000f\u0010\u000e\u001a\u00020\bH&¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u000f\u001a\u00020\bH&¢\u0006\u0004\b\u000f\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/avito/android/serp/SerpResourcesProvider;", "", "", "getColumnsCount", "()I", "Lcom/avito/android/remote/model/SerpDisplayType;", "displayType", "(Lcom/avito/android/remote/model/SerpDisplayType;)I", "", "getCallUnavailableMessage", "()Ljava/lang/String;", "getMessengerUnavailableMessage", "getMessengerLoadingMessage", "getSearchHint", "getEmptySearchText", "getCommonErrorText", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpResourcesProvider {
    @NotNull
    String getCallUnavailableMessage();

    int getColumnsCount();

    int getColumnsCount(@Nullable SerpDisplayType serpDisplayType);

    @NotNull
    String getCommonErrorText();

    @NotNull
    String getEmptySearchText();

    @NotNull
    String getMessengerLoadingMessage();

    @NotNull
    String getMessengerUnavailableMessage();

    @NotNull
    String getSearchHint();
}
