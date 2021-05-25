package com.avito.android.deep_linking;

import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0004H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/deep_linking/ClickStreamLinkHandler;", "", "Lcom/avito/android/deep_linking/links/ClickStreamLink;", "link", "Lkotlin/Function1;", "Lcom/avito/android/deep_linking/links/DeepLink;", "", "redirectAction", "handleDeepLink", "(Lcom/avito/android/deep_linking/links/ClickStreamLink;Lkotlin/jvm/functions/Function1;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public interface ClickStreamLinkHandler {
    void handleDeepLink(@NotNull ClickStreamLink clickStreamLink, @Nullable Function1<? super DeepLink, Unit> function1);
}
