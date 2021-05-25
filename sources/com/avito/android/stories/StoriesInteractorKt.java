package com.avito.android.stories;

import androidx.annotation.VisibleForTesting;
import com.avito.android.remote.auth.AuthSource;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\"\u001c\u0010\u0001\u001a\u00020\u00008\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0001\u0010\u0002\u0012\u0004\b\u0003\u0010\u0004\"\u001c\u0010\u0005\u001a\u00020\u00008\u0006@\u0007XT¢\u0006\f\n\u0004\b\u0005\u0010\u0002\u0012\u0004\b\u0006\u0010\u0004\"\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t\"\u001c\u0010\u000b\u001a\u00020\u00008\u0006@\u0007XT¢\u0006\f\n\u0004\b\u000b\u0010\u0002\u0012\u0004\b\f\u0010\u0004¨\u0006\r"}, d2 = {"", "LAST_STORIES_KEY", "Ljava/lang/String;", "getLAST_STORIES_KEY$annotations", "()V", "LAST_UPDATED_KEY", "getLAST_UPDATED_KEY$annotations", "", AuthSource.SEND_ABUSE, "J", "STORIES_LIFETIME_MILLIS", "VIEWED_STORIES_KEY", "getVIEWED_STORIES_KEY$annotations", "serp-core_release"}, k = 2, mv = {1, 4, 2})
public final class StoriesInteractorKt {
    @NotNull
    public static final String LAST_STORIES_KEY = "last_stories_key";
    @NotNull
    public static final String LAST_UPDATED_KEY = "last_updated_key";
    @NotNull
    public static final String VIEWED_STORIES_KEY = "viewed_stories_key";
    public static final long a = TimeUnit.DAYS.toMillis(1);

    @VisibleForTesting
    public static /* synthetic */ void getLAST_STORIES_KEY$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLAST_UPDATED_KEY$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getVIEWED_STORIES_KEY$annotations() {
    }
}
