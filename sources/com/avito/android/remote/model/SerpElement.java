package com.avito.android.remote.model;

import android.os.Parcelable;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\bf\u0018\u0000 \b2\u00020\u0001:\u0001\bR\u001c\u0010\u0007\u001a\u00020\u00028&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/SerpElement;", "Landroid/os/Parcelable;", "", "getUniqueId", "()J", "setUniqueId", "(J)V", "uniqueId", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
public interface SerpElement extends Parcelable {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final long NO_ID = 0;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/remote/model/SerpElement$Companion;", "", "", "NO_ID", "J", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final long NO_ID = 0;

        private Companion() {
        }
    }

    long getUniqueId();

    void setUniqueId(long j);
}
