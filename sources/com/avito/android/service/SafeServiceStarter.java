package com.avito.android.service;

import android.content.Context;
import android.content.Intent;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/service/SafeServiceStarter;", "", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", Tracker.Events.CREATIVE_START, "(Landroid/content/Context;Landroid/content/Intent;)V", "", "needForeground", "(Landroid/content/Intent;)Z", "core_release"}, k = 1, mv = {1, 4, 2})
public interface SafeServiceStarter {
    boolean needForeground(@NotNull Intent intent);

    void start(@NotNull Context context, @NotNull Intent intent);
}
