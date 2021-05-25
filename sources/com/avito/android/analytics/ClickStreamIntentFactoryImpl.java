package com.avito.android.analytics;

import android.content.Context;
import android.content.Intent;
import com.avito.android.ClickStreamIntentFactory;
import com.avito.android.deep_linking.links.ClickStreamLink;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/analytics/ClickStreamIntentFactoryImpl;", "Lcom/avito/android/ClickStreamIntentFactory;", "Lcom/avito/android/deep_linking/links/ClickStreamLink;", "clickStreamLink", "Landroid/content/Intent;", "clickStreamIntentIntent", "(Lcom/avito/android/deep_linking/links/ClickStreamLink;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "deep-linking_release"}, k = 1, mv = {1, 4, 2})
public final class ClickStreamIntentFactoryImpl implements ClickStreamIntentFactory {
    public final Context a;

    @Inject
    public ClickStreamIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.ClickStreamIntentFactory
    @NotNull
    public Intent clickStreamIntentIntent(@NotNull ClickStreamLink clickStreamLink) {
        Intrinsics.checkNotNullParameter(clickStreamLink, "clickStreamLink");
        return ClickStreamDeepLinkActivityKt.createClickStreamIntent(this.a, clickStreamLink);
    }
}
