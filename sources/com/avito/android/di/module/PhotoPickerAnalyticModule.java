package com.avito.android.di.module;

import com.avito.android.analytics.PhotoPickerEventTracker;
import com.avito.android.analytics.PhotoPickerEventTrackerImpl;
import com.avito.android.analytics.UnhandledPhotoPickerEvent;
import dagger.Module;
import dagger.Provides;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Set;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ(\u0010\n\u001a\u00020\u00072\u0017\u0010\u0006\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\b\u00050\u0002H\u0001¢\u0006\u0004\b\b\u0010\t¨\u0006\r"}, d2 = {"Lcom/avito/android/di/module/PhotoPickerAnalyticModule;", "", "", "Lio/reactivex/rxjava3/functions/Consumer;", "Lcom/avito/android/analytics/UnhandledPhotoPickerEvent;", "Lkotlin/jvm/JvmSuppressWildcards;", "observers", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "provideEventStream$photo_picker_release", "(Ljava/util/Set;)Lcom/avito/android/analytics/PhotoPickerEventTracker;", "provideEventStream", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
@Module
public final class PhotoPickerAnalyticModule {
    @NotNull
    public static final PhotoPickerAnalyticModule INSTANCE = new PhotoPickerAnalyticModule();

    @Provides
    @JvmStatic
    @NotNull
    @Singleton
    public static final PhotoPickerEventTracker provideEventStream$photo_picker_release(@NotNull Set<Consumer<UnhandledPhotoPickerEvent>> set) {
        Intrinsics.checkNotNullParameter(set, "observers");
        return new PhotoPickerEventTrackerImpl(set);
    }
}
