package com.avito.android;

import android.content.Intent;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J-\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H&¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/StoriesIntentFactory;", "", "", "url", "", "stories", "currentStoryId", "Landroid/content/Intent;", "storiesIntent", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Landroid/content/Intent;", "core_release"}, k = 1, mv = {1, 4, 2})
public interface StoriesIntentFactory {
    @NotNull
    Intent storiesIntent(@NotNull String str, @NotNull List<String> list, @NotNull String str2);
}
