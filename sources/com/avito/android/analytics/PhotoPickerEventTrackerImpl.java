package com.avito.android.analytics;

import com.avito.android.remote.auth.AuthSource;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u0007¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\"\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\b0\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/avito/android/analytics/PhotoPickerEventTrackerImpl;", "Lcom/avito/android/analytics/PhotoPickerEventTracker;", "Lcom/avito/android/analytics/UnhandledPhotoPickerEvent;", "event", "", "track", "(Lcom/avito/android/analytics/UnhandledPhotoPickerEvent;)V", "", "Lio/reactivex/rxjava3/functions/Consumer;", AuthSource.SEND_ABUSE, "Ljava/util/Set;", "observers", "<init>", "(Ljava/util/Set;)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public final class PhotoPickerEventTrackerImpl implements PhotoPickerEventTracker {
    public final Set<Consumer<UnhandledPhotoPickerEvent>> a;

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Set<? extends io.reactivex.rxjava3.functions.Consumer<com.avito.android.analytics.UnhandledPhotoPickerEvent>> */
    /* JADX WARN: Multi-variable type inference failed */
    public PhotoPickerEventTrackerImpl(@NotNull Set<? extends Consumer<UnhandledPhotoPickerEvent>> set) {
        Intrinsics.checkNotNullParameter(set, "observers");
        this.a = set;
    }

    @Override // com.avito.android.analytics.PhotoPickerEventTracker
    public void track(@NotNull UnhandledPhotoPickerEvent unhandledPhotoPickerEvent) {
        Intrinsics.checkNotNullParameter(unhandledPhotoPickerEvent, "event");
        Iterator<T> it = this.a.iterator();
        while (it.hasNext()) {
            it.next().accept(unhandledPhotoPickerEvent);
        }
    }
}
