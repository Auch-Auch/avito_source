package com.avito.android.deep_linking;

import android.content.Intent;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.deep_linking.links.DeepLinkContainer;
import com.avito.android.deep_linking.links.FallbackableLink;
import com.avito.android.deep_linking.links.MultipleLink;
import com.avito.android.remote.auth.AuthSource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b\f\u0010\rJ\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\b8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactoryImpl;", "Lcom/avito/android/deep_linking/DeepLinkContainerIntentFactory;", "Lcom/avito/android/deep_linking/links/DeepLinkContainer;", "deepLinkContainer", "", "Landroid/content/Intent;", "getIntents", "(Lcom/avito/android/deep_linking/links/DeepLinkContainer;)Ljava/util/List;", "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", AuthSource.SEND_ABUSE, "Lcom/avito/android/deep_linking/DeepLinkIntentFactory;", "deepLinkIntentFactory", "<init>", "(Lcom/avito/android/deep_linking/DeepLinkIntentFactory;)V", "core_release"}, k = 1, mv = {1, 4, 2})
public final class DeepLinkContainerIntentFactoryImpl implements DeepLinkContainerIntentFactory {
    public final DeepLinkIntentFactory a;

    public DeepLinkContainerIntentFactoryImpl(@NotNull DeepLinkIntentFactory deepLinkIntentFactory) {
        Intrinsics.checkNotNullParameter(deepLinkIntentFactory, "deepLinkIntentFactory");
        this.a = deepLinkIntentFactory;
    }

    @Override // com.avito.android.deep_linking.DeepLinkContainerIntentFactory
    @NotNull
    public List<Intent> getIntents(@NotNull DeepLinkContainer deepLinkContainer) {
        Intrinsics.checkNotNullParameter(deepLinkContainer, "deepLinkContainer");
        if (deepLinkContainer instanceof MultipleLink) {
            List<DeepLink> deepLinks = deepLinkContainer.getDeepLinks();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = deepLinks.iterator();
            while (it.hasNext()) {
                Intent intent = this.a.getIntent(it.next());
                if (intent != null) {
                    arrayList.add(intent);
                }
            }
            return arrayList;
        } else if (deepLinkContainer instanceof FallbackableLink) {
            List<DeepLink> deepLinks2 = deepLinkContainer.getDeepLinks();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it2 = deepLinks2.iterator();
            while (it2.hasNext()) {
                Intent intent2 = this.a.getIntent(it2.next());
                if (intent2 != null) {
                    arrayList2.add(intent2);
                }
            }
            return CollectionsKt___CollectionsKt.take(arrayList2, 1);
        } else {
            throw new IllegalArgumentException(deepLinkContainer + " is not supported");
        }
    }
}
