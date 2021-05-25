package com.avito.android.home;

import com.avito.android.remote.auth.AuthSource;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.yandex.mobile.ads.video.tracking.Tracker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u00132\u00020\u0001:\u0005\u0014\u0013\u0015\u0016\u0017J\u0017\u0010\u0004\u001a\u00020\u00032\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\u0004\u0010\u0005R\u0019\u0010\u000b\u001a\u00020\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\"\u0010\u0012\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\b\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\u0011\u0001\u0004\u0018\u0019\u001a\u001b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/home/DataChangesHolder;", "", "source", "", "isNotifiedBy", "(Ljava/lang/Object;)Z", "", AuthSource.BOOKING_ORDER, "I", "getCount", "()I", "count", AuthSource.SEND_ABUSE, "Ljava/lang/Object;", "c", "getIndex", "setIndex", "(I)V", FirebaseAnalytics.Param.INDEX, "Companion", "Changed", "Inserted", "Invalidated", "Removed", "Lcom/avito/android/home/DataChangesHolder$Invalidated;", "Lcom/avito/android/home/DataChangesHolder$Inserted;", "Lcom/avito/android/home/DataChangesHolder$Changed;", "Lcom/avito/android/home/DataChangesHolder$Removed;", "serp_release"}, k = 1, mv = {1, 4, 2})
public abstract class DataChangesHolder {
    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int INDEX_UNKNOWN = -1;
    public final Object a;
    public final int b;
    public int c;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/home/DataChangesHolder$Changed;", "Lcom/avito/android/home/DataChangesHolder;", "", Tracker.Events.CREATIVE_START, "count", "", "source", "<init>", "(IILjava/lang/Object;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static class Changed extends DataChangesHolder {
        public Changed() {
            this(0, 0, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Changed(int i, int i2, Object obj, int i3, j jVar) {
            this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 1 : i2, (i3 & 4) != 0 ? null : obj);
        }

        public Changed(int i, int i2, @Nullable Object obj) {
            super(obj, i2, i, (j) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/avito/android/home/DataChangesHolder$Companion;", "", "", "INDEX_UNKNOWN", "I", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/home/DataChangesHolder$Inserted;", "Lcom/avito/android/home/DataChangesHolder;", "", Tracker.Events.CREATIVE_START, "count", "", "source", "<init>", "(IILjava/lang/Object;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Inserted extends DataChangesHolder {
        public Inserted() {
            this(0, 0, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Inserted(int i, int i2, Object obj, int i3, j jVar) {
            this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 1 : i2, (i3 & 4) != 0 ? null : obj);
        }

        public Inserted(int i, int i2, @Nullable Object obj) {
            super(obj, i2, i, (j) null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/home/DataChangesHolder$Invalidated;", "Lcom/avito/android/home/DataChangesHolder;", "<init>", "()V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static final class Invalidated extends DataChangesHolder {
        public Invalidated() {
            super((Object) null, 0, 0, 7);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B'\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/avito/android/home/DataChangesHolder$Removed;", "Lcom/avito/android/home/DataChangesHolder;", "", Tracker.Events.CREATIVE_START, "count", "", "source", "<init>", "(IILjava/lang/Object;)V", "serp_release"}, k = 1, mv = {1, 4, 2})
    public static class Removed extends DataChangesHolder {
        public Removed() {
            this(0, 0, null, 7, null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Removed(int i, int i2, Object obj, int i3, j jVar) {
            this((i3 & 1) != 0 ? -1 : i, (i3 & 2) != 0 ? 1 : i2, (i3 & 4) != 0 ? null : obj);
        }

        public Removed(int i, int i2, @Nullable Object obj) {
            super(obj, i2, i, (j) null);
        }
    }

    public DataChangesHolder(Object obj, int i, int i2, int i3) {
        int i4 = i3 & 1;
        i = (i3 & 2) != 0 ? 0 : i;
        i2 = (i3 & 4) != 0 ? -1 : i2;
        this.a = null;
        this.b = i;
        this.c = i2;
    }

    public final int getCount() {
        return this.b;
    }

    public final int getIndex() {
        return this.c;
    }

    public final boolean isNotifiedBy(@Nullable Object obj) {
        return obj != null && Intrinsics.areEqual(this.a, obj);
    }

    public final void setIndex(int i) {
        this.c = i;
    }

    public DataChangesHolder(Object obj, int i, int i2, j jVar) {
        this.a = obj;
        this.b = i;
        this.c = i2;
    }
}
