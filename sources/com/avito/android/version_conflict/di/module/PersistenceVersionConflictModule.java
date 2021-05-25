package com.avito.android.version_conflict.di.module;

import com.avito.android.version_conflict.ConfigStorage;
import com.avito.android.version_conflict.MutableConfigStorage;
import com.avito.android.version_conflict.PrefConfigStorage;
import dagger.Binds;
import dagger.Module;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H'¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0004H'¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/avito/android/version_conflict/di/module/PersistenceVersionConflictModule;", "", "Lcom/avito/android/version_conflict/PrefConfigStorage;", "preferences", "Lcom/avito/android/version_conflict/MutableConfigStorage;", "bindMutableConfigStorage", "(Lcom/avito/android/version_conflict/PrefConfigStorage;)Lcom/avito/android/version_conflict/MutableConfigStorage;", "storage", "Lcom/avito/android/version_conflict/ConfigStorage;", "bindConfigStorage", "(Lcom/avito/android/version_conflict/MutableConfigStorage;)Lcom/avito/android/version_conflict/ConfigStorage;", "version-conflict_release"}, k = 1, mv = {1, 4, 2})
@Module
public interface PersistenceVersionConflictModule {
    @Binds
    @NotNull
    ConfigStorage bindConfigStorage(@NotNull MutableConfigStorage mutableConfigStorage);

    @Binds
    @NotNull
    MutableConfigStorage bindMutableConfigStorage(@NotNull PrefConfigStorage prefConfigStorage);
}
