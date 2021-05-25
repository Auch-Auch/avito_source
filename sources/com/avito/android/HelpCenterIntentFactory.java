package com.avito.android;

import android.content.Intent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006J3\u0010\n\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/avito/android/HelpCenterIntentFactory;", "", "", "url", "Landroid/content/Intent;", "helpCenterIntent", "(Ljava/lang/String;)Landroid/content/Intent;", "theme", "advertisementId", "contextId", "helpCenterRequestIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "articleId", "helpCenterArticleShowIntent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface HelpCenterIntentFactory {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static final class DefaultImpls {
        public static /* synthetic */ Intent helpCenterArticleShowIntent$default(HelpCenterIntentFactory helpCenterIntentFactory, String str, String str2, String str3, String str4, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                if ((i & 8) != 0) {
                    str4 = null;
                }
                return helpCenterIntentFactory.helpCenterArticleShowIntent(str, str2, str3, str4);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: helpCenterArticleShowIntent");
        }

        public static /* synthetic */ Intent helpCenterRequestIntent$default(HelpCenterIntentFactory helpCenterIntentFactory, String str, String str2, String str3, int i, Object obj) {
            if (obj == null) {
                if ((i & 1) != 0) {
                    str = null;
                }
                if ((i & 2) != 0) {
                    str2 = null;
                }
                if ((i & 4) != 0) {
                    str3 = null;
                }
                return helpCenterIntentFactory.helpCenterRequestIntent(str, str2, str3);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: helpCenterRequestIntent");
        }
    }

    @NotNull
    Intent helpCenterArticleShowIntent(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable String str4);

    @NotNull
    Intent helpCenterIntent(@Nullable String str);

    @NotNull
    Intent helpCenterRequestIntent(@Nullable String str, @Nullable String str2, @Nullable String str3);
}
