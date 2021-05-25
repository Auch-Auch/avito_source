package com.avito.android.error_helper.di;

import com.avito.android.error_helper.ErrorHelper;
import com.avito.android.error_helper.ErrorHelperImpl;
import com.avito.android.util.ErrorFormatter;
import com.avito.android.util.ErrorFormatterImpl;
import dagger.Binds;
import dagger.Module;
import dagger.Reusable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H'¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/avito/android/error_helper/di/ErrorHelperModule;", "", "Lcom/avito/android/util/ErrorFormatterImpl;", "formatter", "Lcom/avito/android/util/ErrorFormatter;", "bindErrorFormatter", "(Lcom/avito/android/util/ErrorFormatterImpl;)Lcom/avito/android/util/ErrorFormatter;", "Lcom/avito/android/error_helper/ErrorHelperImpl;", "helper", "Lcom/avito/android/error_helper/ErrorHelper;", "bindErrorHelper", "(Lcom/avito/android/error_helper/ErrorHelperImpl;)Lcom/avito/android/error_helper/ErrorHelper;", "tns-core_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface ErrorHelperModule {
    @Reusable
    @Binds
    @NotNull
    ErrorFormatter bindErrorFormatter(@NotNull ErrorFormatterImpl errorFormatterImpl);

    @Reusable
    @Binds
    @NotNull
    ErrorHelper bindErrorHelper(@NotNull ErrorHelperImpl errorHelperImpl);
}
