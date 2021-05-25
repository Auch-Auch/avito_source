package com.avito.android.deep_linking.links;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00018&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0007"}, d2 = {"Lcom/avito/android/deep_linking/links/ChainedDeepLink;", "Lcom/avito/android/deep_linking/links/DeepLink;", "getThen", "()Lcom/avito/android/deep_linking/links/DeepLink;", "then", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChainedDeepLink extends DeepLink {
    @Nullable
    public abstract DeepLink getThen();
}
