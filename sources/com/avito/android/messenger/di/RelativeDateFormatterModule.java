package com.avito.android.messenger.di;

import android.content.res.Resources;
import com.avito.android.date_time_formatter.RelativeDateFormatter;
import com.avito.android.date_time_formatter.RelativeDateFormatterImpl;
import com.avito.android.server_time.TimeSource;
import dagger.Module;
import dagger.Provides;
import dagger.Reusable;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/avito/android/messenger/di/RelativeDateFormatterModule;", "", "Lcom/avito/android/server_time/TimeSource;", "timeSource", "Ljava/util/Locale;", "locale", "Landroid/content/res/Resources;", "resources", "Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "provideRelativeDateFormatter", "(Lcom/avito/android/server_time/TimeSource;Ljava/util/Locale;Landroid/content/res/Resources;)Lcom/avito/android/date_time_formatter/RelativeDateFormatter;", "<init>", "()V", "messenger_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class RelativeDateFormatterModule {
    @NotNull
    public static final RelativeDateFormatterModule INSTANCE = new RelativeDateFormatterModule();

    @Provides
    @JvmStatic
    @Reusable
    @NotNull
    public static final RelativeDateFormatter provideRelativeDateFormatter(@NotNull TimeSource timeSource, @NotNull Locale locale, @NotNull Resources resources) {
        Intrinsics.checkNotNullParameter(timeSource, "timeSource");
        Intrinsics.checkNotNullParameter(locale, "locale");
        Intrinsics.checkNotNullParameter(resources, "resources");
        return new RelativeDateFormatterImpl(timeSource, resources, locale);
    }
}
