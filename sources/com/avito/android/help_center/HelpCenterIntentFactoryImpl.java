package com.avito.android.help_center;

import android.content.Context;
import android.content.Intent;
import com.avito.android.HelpCenterIntentFactory;
import com.avito.android.help_center.help_center_articles.HelpCenterArticlesActivityKt;
import com.avito.android.help_center.help_center_request.HelpCenterRequestActivityKt;
import com.avito.android.remote.auth.AuthSource;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u000f¢\u0006\u0004\b\u0013\u0010\u0014J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J-\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\n\u0010\u000bJ5\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/avito/android/help_center/HelpCenterIntentFactoryImpl;", "Lcom/avito/android/HelpCenterIntentFactory;", "", "url", "Landroid/content/Intent;", "helpCenterIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "theme", "advertisementId", "contextId", "helpCenterRequestIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "articleId", "helpCenterArticleShowIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/content/Context;", AuthSource.SEND_ABUSE, "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "help-center_release"}, k = 1, mv = {1, 4, 2})
public final class HelpCenterIntentFactoryImpl implements HelpCenterIntentFactory {
    public final Context a;

    @Inject
    public HelpCenterIntentFactoryImpl(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = context;
    }

    @Override // com.avito.android.HelpCenterIntentFactory
    @NotNull
    public Intent helpCenterArticleShowIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "articleId");
        return HelpCenterArticlesActivityKt.createHelpCenterArticlesIntent(this.a, str, str2, str3, str4);
    }

    @Override // com.avito.android.HelpCenterIntentFactory
    @NotNull
    public Intent helpCenterIntent(@Nullable String str) {
        return HelpCenterActivityKt.createHelpCenterIntent(this.a, str);
    }

    @Override // com.avito.android.HelpCenterIntentFactory
    @NotNull
    public Intent helpCenterRequestIntent(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return HelpCenterRequestActivityKt.createHelpCenterRequestIntent(this.a, str, str2, str3);
    }
}
