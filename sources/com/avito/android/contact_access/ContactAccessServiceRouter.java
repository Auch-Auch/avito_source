package com.avito.android.contact_access;

import com.avito.android.deep_linking.links.DeepLink;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H&¢\u0006\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/avito/android/contact_access/ContactAccessServiceRouter;", "", "Lcom/avito/android/deep_linking/links/DeepLink;", "deepLink", "", "onActionRequest", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "showIncompleteRegister", "()V", "close", "contact-access_release"}, k = 1, mv = {1, 4, 2})
public interface ContactAccessServiceRouter {
    void close();

    void onActionRequest(@NotNull DeepLink deepLink);

    void showIncompleteRegister();
}
