package com.avito.android.remote.model.text;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.n.d;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/text/AttributedTextCreatorImpl;", "Lcom/avito/android/remote/model/text/AttributedTextCreator;", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "deepLinkText", "Lcom/avito/android/remote/model/text/AttributedText;", "from", "(Lcom/avito/android/deep_linking/links/DeepLink;Ljava/lang/String;)Lcom/avito/android/remote/model/text/AttributedText;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public final class AttributedTextCreatorImpl implements AttributedTextCreator {
    @Override // com.avito.android.remote.model.text.AttributedTextCreator
    @NotNull
    public AttributedText from(@NotNull DeepLink deepLink, @NotNull String str) {
        Intrinsics.checkNotNullParameter(deepLink, "deepLink");
        Intrinsics.checkNotNullParameter(str, "deepLinkText");
        return new AttributedText("{{attr}}", d.listOf(new DeepLinkAttribute("attr", str, deepLink, null, null, 24, null)));
    }
}
