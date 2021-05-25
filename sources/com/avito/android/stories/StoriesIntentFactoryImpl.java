package com.avito.android.stories;

import android.app.Application;
import android.content.Intent;
import com.avito.android.StoriesIntentFactory;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.stories.StoriesActivity;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\u0006\u0010\r\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\u000fJ-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/stories/StoriesIntentFactoryImpl;", "Lcom/avito/android/StoriesIntentFactory;", "", "url", "", "stories", "currentStoryId", "Landroid/content/Intent;", "storiesIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "Landroid/app/Application;", AuthSource.SEND_ABUSE, "Landroid/app/Application;", "context", "<init>", "(Landroid/app/Application;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
public final class StoriesIntentFactoryImpl implements StoriesIntentFactory {
    public final Application a;

    @Inject
    public StoriesIntentFactoryImpl(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, "context");
        this.a = application;
    }

    @Override // com.avito.android.StoriesIntentFactory
    @NotNull
    public Intent storiesIntent(@NotNull String str, @NotNull List<String> list, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(list, "stories");
        Intrinsics.checkNotNullParameter(str2, "currentStoryId");
        return new StoriesActivity.Factory().create(this.a, new StoriesArguments(str, list, str2));
    }
}
