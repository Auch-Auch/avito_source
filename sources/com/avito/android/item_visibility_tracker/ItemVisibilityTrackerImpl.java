package com.avito.android.item_visibility_tracker;

import a2.g.r.g;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.avito.android.item_visibility_tracker.ItemVisibilityTracker;
import com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.util.Logs;
import com.avito.android.util.rx3.InteropKt;
import com.avito.konveyor.data_source.DataSource;
import com.avito.konveyor.util.DataSources;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.jakewharton.rxbinding3.recyclerview.RecyclerViewScrollEvent;
import com.jakewharton.rxbinding3.recyclerview.RxRecyclerView;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.functions.Consumer;
import io.reactivex.rxjava3.kotlin.DisposableKt;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.y;
import t6.v.e;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001aB\u001d\u0012\f\u0010R\u001a\b\u0012\u0004\u0012\u00020\"0M\u0012\u0006\u0010^\u001a\u00020\f¢\u0006\u0004\b_\u0010`J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001b\u0010\b\u001a\u00020\u00072\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J!\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0017\u0010\u0018J/\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u001b\u0010#\u001a\u0004\u0018\u00010\"2\b\u0010!\u001a\u0004\u0018\u00010 H\u0002¢\u0006\u0004\b#\u0010$J\u001f\u0010)\u001a\u00020\u00072\u0006\u0010&\u001a\u00020%2\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J%\u0010-\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00020%0+2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b-\u0010.R\u0018\u00102\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u00101R\u0016\u00105\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b3\u00104R2\u00109\u001a\u001e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020'06j\u000e\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020'`78\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b-\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R&\u0010,\u001a\u0012\u0012\u0004\u0012\u00020%0>j\b\u0012\u0004\u0012\u00020%`?8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010AR$\u0010\u0014\u001a\u00020\u00132\u0006\u0010B\u001a\u00020\u00138\u0016@RX\u000e¢\u0006\f\n\u0004\b#\u00104\u001a\u0004\bC\u0010DR\u0018\u0010H\u001a\u0004\u0018\u00010E8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bF\u0010GR\u0016\u0010L\u001a\u00020I8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bJ\u0010KR\u001f\u0010R\u001a\b\u0012\u0004\u0012\u00020\"0M8\u0006@\u0006¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010QR\u0016\u0010V\u001a\u00020S8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\bT\u0010UR\u0016\u0010X\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bW\u00104R\u001c\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b)\u0010YR\u0019\u0010^\u001a\u00020\f8\u0006@\u0006¢\u0006\f\n\u0004\bZ\u0010[\u001a\u0004\b\\\u0010]¨\u0006b"}, d2 = {"Lcom/avito/android/item_visibility_tracker/ItemVisibilityTrackerImpl;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "Landroid/os/Bundle;", "onSaveState", "()Landroid/os/Bundle;", "Lcom/avito/konveyor/data_source/DataSource;", "dataSource", "", "onDataSourceChanged", "(Lcom/avito/konveyor/data_source/DataSource;)V", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "forceRemove", "updateTrackingKeys", "(Landroidx/recyclerview/widget/RecyclerView;Z)V", "clear", "()V", "recycler", "Landroid/graphics/Rect;", "viewportInset", "subscribe", "(Landroidx/recyclerview/widget/RecyclerView;Landroid/graphics/Rect;)V", "unsubscribe", "(Landroidx/recyclerview/widget/RecyclerView;)V", "", ViewHierarchyConstants.DIMENSION_LEFT_KEY, "top", "right", "bottom", "updateViewportInset", "(IIII)V", "", "item", "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", AuthSource.SEND_ABUSE, "(Ljava/lang/Object;)Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "Lcom/avito/android/item_visibility_tracker/TrackKey;", "key", "Lcom/avito/android/item_visibility_tracker/TrackedInfo;", "info", "c", "(Lcom/avito/android/item_visibility_tracker/TrackKey;Lcom/avito/android/item_visibility_tracker/TrackedInfo;)V", "", "activeKeys", AuthSource.BOOKING_ORDER, "(Ljava/util/Set;Z)V", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", g.a, "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "adapterDataObserver", "k", "Landroid/graphics/Rect;", "itemViewRect", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Ljava/util/HashMap;", "trackingMap", "Landroid/view/View$OnAttachStateChangeListener;", "h", "Landroid/view/View$OnAttachStateChangeListener;", "onAttachStateChangeListener", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "i", "Ljava/util/HashSet;", "<set-?>", "getViewportInset", "()Landroid/graphics/Rect;", "Ljava/lang/Runnable;", "e", "Ljava/lang/Runnable;", "delayedUpdate", "Landroid/os/Handler;", "d", "Landroid/os/Handler;", "handler", "", "l", "Ljava/util/List;", "getFilters", "()Ljava/util/List;", "filters", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "f", "Lio/reactivex/rxjava3/disposables/CompositeDisposable;", "rxSubscriptions", "j", "recyclerViewRect", "Lcom/avito/konveyor/data_source/DataSource;", AuthSource.OPEN_CHANNEL_LIST, "Z", "getSupportsIncrementalUpdate", "()Z", "supportsIncrementalUpdate", "<init>", "(Ljava/util/List;Z)V", "Builder", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public final class ItemVisibilityTrackerImpl implements ItemVisibilityTracker {
    @NotNull
    public Rect a = new Rect();
    public final HashMap<TrackKey, TrackedInfo> b = new HashMap<>();
    public DataSource<?> c;
    public final Handler d = new Handler();
    public Runnable e;
    public final CompositeDisposable f = new CompositeDisposable();
    public RecyclerView.AdapterDataObserver g;
    public View.OnAttachStateChangeListener h;
    public HashSet<TrackKey> i = new HashSet<>();
    public Rect j = new Rect();
    public Rect k = new Rect();
    @NotNull
    public final List<ItemVisibilityFilter> l;
    public final boolean m;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\f\u001a\u00020\t\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\f\u001a\u00020\t8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u001c\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00118\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/avito/android/item_visibility_tracker/ItemVisibilityTrackerImpl$Builder;", "", "Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;", "filter", "addFilter", "(Lcom/avito/android/item_visibility_tracker/filters/ItemVisibilityFilter;)Lcom/avito/android/item_visibility_tracker/ItemVisibilityTrackerImpl$Builder;", "Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "build", "()Lcom/avito/android/item_visibility_tracker/ItemVisibilityTracker;", "", AuthSource.BOOKING_ORDER, "Z", "supportsIncrementalUpdate", "", AuthSource.SEND_ABUSE, "Ljava/util/List;", "filters", "Landroid/os/Bundle;", "c", "Landroid/os/Bundle;", "state", "<init>", "(ZLandroid/os/Bundle;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Builder {
        public final List<ItemVisibilityFilter> a = new ArrayList();
        public final boolean b;
        public final Bundle c;

        public Builder(boolean z, @Nullable Bundle bundle) {
            this.b = z;
            this.c = bundle;
        }

        @NotNull
        public final Builder addFilter(@NotNull ItemVisibilityFilter itemVisibilityFilter) {
            Intrinsics.checkNotNullParameter(itemVisibilityFilter, "filter");
            this.a.add(itemVisibilityFilter);
            return this;
        }

        @NotNull
        public final ItemVisibilityTracker build() {
            ItemVisibilityTrackerImpl itemVisibilityTrackerImpl = new ItemVisibilityTrackerImpl(this.a, this.b);
            ItemVisibilityTrackerImpl.access$onRestoreState(itemVisibilityTrackerImpl, this.c);
            return itemVisibilityTrackerImpl;
        }
    }

    public static final class a<T> implements Consumer<RecyclerViewScrollEvent> {
        public final /* synthetic */ ItemVisibilityTrackerImpl a;
        public final /* synthetic */ RecyclerView b;

        public a(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl, RecyclerView recyclerView) {
            this.a = itemVisibilityTrackerImpl;
            this.b = recyclerView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.rxjava3.functions.Consumer
        public void accept(RecyclerViewScrollEvent recyclerViewScrollEvent) {
            this.a.updateTrackingKeys(this.b, false);
        }
    }

    public static final class b implements Runnable {
        public final /* synthetic */ ItemVisibilityTrackerImpl a;
        public final /* synthetic */ WeakReference b;

        public b(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl, WeakReference weakReference) {
            this.a = itemVisibilityTrackerImpl;
            this.b = weakReference;
        }

        @Override // java.lang.Runnable
        public final void run() {
            RecyclerView recyclerView = (RecyclerView) this.b.get();
            if (recyclerView != null) {
                ItemVisibilityTrackerImpl itemVisibilityTrackerImpl = this.a;
                Intrinsics.checkNotNullExpressionValue(recyclerView, "it");
                itemVisibilityTrackerImpl.updateTrackingKeys(recyclerView, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter> */
    /* JADX WARN: Multi-variable type inference failed */
    public ItemVisibilityTrackerImpl(@NotNull List<? extends ItemVisibilityFilter> list, boolean z) {
        Intrinsics.checkNotNullParameter(list, "filters");
        this.l = list;
        this.m = z;
    }

    public static final void access$onRestoreState(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl, Bundle bundle) {
        ArrayList parcelableArrayList;
        T t;
        Objects.requireNonNull(itemVisibilityTrackerImpl);
        if (bundle != null && (parcelableArrayList = bundle.getParcelableArrayList("key_tracked_info_list")) != null) {
            Intrinsics.checkNotNullExpressionValue(parcelableArrayList, "savedInstanceState.getPa…CKED_INFO_LIST) ?: return");
            IntProgression step = e.step(e.until(0, parcelableArrayList.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if (step2 >= 0) {
                if (first > last) {
                    return;
                }
            } else if (first < last) {
                return;
            }
            while (true) {
                Object obj = parcelableArrayList.get(first);
                Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.item_visibility_tracker.TrackKey");
                TrackKey trackKey = (TrackKey) obj;
                Object obj2 = parcelableArrayList.get(first + 1);
                Objects.requireNonNull(obj2, "null cannot be cast to non-null type com.avito.android.item_visibility_tracker.TrackedInfo");
                TrackedInfo trackedInfo = (TrackedInfo) obj2;
                Iterator<T> it = itemVisibilityTrackerImpl.l.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t = null;
                        break;
                    }
                    t = it.next();
                    if (Intrinsics.areEqual(t.getClass(), trackedInfo.getFilterClass())) {
                        break;
                    }
                }
                T t2 = t;
                if (t2 != null) {
                    HashMap<TrackKey, TrackedInfo> hashMap = itemVisibilityTrackerImpl.b;
                    trackedInfo.setFilter(t2);
                    hashMap.put(trackKey, trackedInfo);
                }
                if (first != last) {
                    first += step2;
                } else {
                    return;
                }
            }
        }
    }

    public static final void access$trackIfNeeded(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl, TrackKey trackKey, TrackedInfo trackedInfo) {
        Objects.requireNonNull(itemVisibilityTrackerImpl);
        if (trackedInfo.getTimerRunnable() != null && itemVisibilityTrackerImpl.b.containsKey(trackKey)) {
            itemVisibilityTrackerImpl.c(trackKey, trackedInfo);
        }
    }

    public static final void access$updateTrackingKeysDelayed(ItemVisibilityTrackerImpl itemVisibilityTrackerImpl) {
        Runnable runnable = itemVisibilityTrackerImpl.e;
        if (runnable != null) {
            itemVisibilityTrackerImpl.d.removeCallbacks(runnable);
            itemVisibilityTrackerImpl.d.postDelayed(runnable, 200);
        }
    }

    public final ItemVisibilityFilter a(Object obj) {
        T t = null;
        if (!(obj instanceof ItemVisibilityTracker.Item)) {
            return null;
        }
        Iterator<T> it = this.l.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            T next = it.next();
            if (next.canStartTracking((ItemVisibilityTracker.Item) obj)) {
                t = next;
                break;
            }
        }
        return t;
    }

    public final void b(Set<TrackKey> set, boolean z) {
        Iterator<Map.Entry<TrackKey, TrackedInfo>> it = this.b.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<TrackKey, TrackedInfo> next = it.next();
            if (!set.contains(next.getKey())) {
                TrackKey key = next.getKey();
                TrackedInfo value = next.getValue();
                ItemVisibilityFilter filter = value.getFilter();
                boolean z2 = false;
                if (filter != null) {
                    boolean z3 = (filter.isSingleTrack() && value.isTracked()) || (filter.getKeepTrackedTimeOnDisappear() && !value.isTracked());
                    if (z || !z3) {
                        z2 = true;
                    }
                    Runnable timerRunnable = value.getTimerRunnable();
                    if (timerRunnable != null) {
                        value.setTimerRunnable(null);
                        this.d.removeCallbacks(timerRunnable);
                        if (!z2) {
                            StringBuilder L = a2.b.a.a.a.L("Paused Tracking with left duration: ");
                            L.append(value.getTimerDuration());
                            L.append(", ");
                            L.append(key.getItemId());
                            L.append(' ');
                            L.append(key.getItemClass());
                            Logs.debug$default("ItemVisibilityTracker", L.toString(), null, 4, null);
                        }
                        if (value.isTracked()) {
                            c(key, value);
                        }
                    }
                }
                if (z2) {
                    StringBuilder L2 = a2.b.a.a.a.L("Removed from Tracking with left duration: ");
                    L2.append(next.getValue().getTimerDuration());
                    L2.append(", ");
                    L2.append(next.getKey().getItemId());
                    L2.append(' ');
                    L2.append(next.getKey().getItemClass());
                    Logs.debug$default("ItemVisibilityTracker", L2.toString(), null, 4, null);
                    it.remove();
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047 A[EDGE_INSN: B:25:0x0047->B:17:0x0047 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(com.avito.android.item_visibility_tracker.TrackKey r9, com.avito.android.item_visibility_tracker.TrackedInfo r10) {
        /*
            r8 = this;
            r0 = 0
            r10.setTimerRunnable(r0)
            r10.setAsTracked()
            com.avito.konveyor.data_source.DataSource<?> r1 = r8.c
            if (r1 == 0) goto L_0x0046
            com.avito.konveyor.data_source.IterableDataSource r1 = com.avito.konveyor.util.DataSources.toIterableDataSource(r1)
            if (r1 == 0) goto L_0x0046
            java.util.Iterator r1 = r1.iterator()
        L_0x0015:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r1.next()
            boolean r3 = r2 instanceof com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
            if (r3 == 0) goto L_0x0042
            java.lang.Class r3 = r9.getItemClass()
            r4 = r2
            com.avito.android.item_visibility_tracker.ItemVisibilityTracker$Item r4 = (com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item) r4
            java.lang.Class r5 = r4.getClass()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r3, r5)
            if (r3 == 0) goto L_0x0042
            long r3 = r4.getTrackId()
            long r5 = r9.getItemId()
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            if (r3 == 0) goto L_0x0015
            goto L_0x0047
        L_0x0046:
            r2 = r0
        L_0x0047:
            boolean r1 = r2 instanceof com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item
            if (r1 != 0) goto L_0x004c
            r2 = r0
        L_0x004c:
            com.avito.android.item_visibility_tracker.ItemVisibilityTracker$Item r2 = (com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item) r2
            if (r2 == 0) goto L_0x007c
            java.lang.String r1 = "Tracked: "
            java.lang.StringBuilder r1 = a2.b.a.a.a.L(r1)
            long r3 = r9.getItemId()
            r1.append(r3)
            r3 = 32
            r1.append(r3)
            java.lang.Class r9 = r9.getItemClass()
            r1.append(r9)
            java.lang.String r9 = r1.toString()
            r1 = 4
            java.lang.String r3 = "ItemVisibilityTracker"
            com.avito.android.util.Logs.debug$default(r3, r9, r0, r1, r0)
            com.avito.android.item_visibility_tracker.filters.ItemVisibilityFilter r9 = r10.getFilter()
            if (r9 == 0) goto L_0x007c
            r9.track(r2)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl.c(com.avito.android.item_visibility_tracker.TrackKey, com.avito.android.item_visibility_tracker.TrackedInfo):void");
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    public void clear() {
        this.d.removeCallbacksAndMessages(null);
        this.b.clear();
    }

    @NotNull
    public final List<ItemVisibilityFilter> getFilters() {
        return this.l;
    }

    public final boolean getSupportsIncrementalUpdate() {
        return this.m;
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    @NotNull
    public Rect getViewportInset() {
        return this.a;
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    public void onDataSourceChanged(@NotNull DataSource<?> dataSource) {
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        this.c = dataSource;
        if (!this.m && (!this.b.isEmpty())) {
            for (Object obj : DataSources.toIterableDataSource(dataSource)) {
                if (a(obj) != null) {
                    HashSet<TrackKey> hashSet = this.i;
                    Objects.requireNonNull(obj, "null cannot be cast to non-null type com.avito.android.item_visibility_tracker.ItemVisibilityTracker.Item");
                    ItemVisibilityTracker.Item item = (ItemVisibilityTracker.Item) obj;
                    hashSet.add(new TrackKey(item.getClass(), item.getTrackId()));
                }
            }
            b(this.i, true);
            this.i.clear();
        }
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    @NotNull
    public Bundle onSaveState() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        for (Map.Entry<TrackKey, TrackedInfo> entry : this.b.entrySet()) {
            arrayList.add(entry.getKey());
            arrayList.add(entry.getValue());
        }
        bundle.putParcelableArrayList("key_tracked_info_list", arrayList);
        return bundle;
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    public void subscribe(@NotNull RecyclerView recyclerView, @Nullable Rect rect) {
        Intrinsics.checkNotNullParameter(recyclerView, "recycler");
        CompositeDisposable compositeDisposable = this.f;
        Disposable subscribe = InteropKt.toV3(RxRecyclerView.scrollEvents(recyclerView)).throttleLast(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this, recyclerView));
        Intrinsics.checkNotNullExpressionValue(subscribe, "recycler.scrollEvents().…ler, false)\n            }");
        DisposableKt.plusAssign(compositeDisposable, subscribe);
        if (rect != null) {
            this.a = rect;
        }
        this.e = new b(this, new WeakReference(recyclerView));
        ItemVisibilityTrackerImpl$createAdapterDataObserver$1 itemVisibilityTrackerImpl$createAdapterDataObserver$1 = new RecyclerView.AdapterDataObserver(recyclerView) { // from class: com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl$createAdapterDataObserver$1
            public final /* synthetic */ RecyclerView b;

            {
                this.b = r2;
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onChanged() {
                super.onChanged();
                if (ItemVisibilityTrackerImpl.this.getSupportsIncrementalUpdate()) {
                    ItemVisibilityTrackerImpl.this.updateTrackingKeys(this.b, true);
                }
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeChanged(int i2, int i3) {
                super.onItemRangeChanged(i2, i3);
                ItemVisibilityTrackerImpl.access$updateTrackingKeysDelayed(ItemVisibilityTrackerImpl.this);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeInserted(int i2, int i3) {
                super.onItemRangeInserted(i2, i3);
                ItemVisibilityTrackerImpl.access$updateTrackingKeysDelayed(ItemVisibilityTrackerImpl.this);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeMoved(int i2, int i3, int i4) {
                super.onItemRangeMoved(i2, i3, i4);
                ItemVisibilityTrackerImpl.access$updateTrackingKeysDelayed(ItemVisibilityTrackerImpl.this);
            }

            @Override // androidx.recyclerview.widget.RecyclerView.AdapterDataObserver
            public void onItemRangeRemoved(int i2, int i3) {
                super.onItemRangeRemoved(i2, i3);
                ItemVisibilityTrackerImpl.access$updateTrackingKeysDelayed(ItemVisibilityTrackerImpl.this);
            }
        };
        this.g = itemVisibilityTrackerImpl$createAdapterDataObserver$1;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(itemVisibilityTrackerImpl$createAdapterDataObserver$1);
        }
        ItemVisibilityTrackerImpl$createOnAttachStateChangeListener$1 itemVisibilityTrackerImpl$createOnAttachStateChangeListener$1 = new View.OnAttachStateChangeListener(recyclerView) { // from class: com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl$createOnAttachStateChangeListener$1
            public final /* synthetic */ RecyclerView b;

            {
                this.b = r2;
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewAttachedToWindow(@Nullable View view) {
            }

            @Override // android.view.View.OnAttachStateChangeListener
            public void onViewDetachedFromWindow(@Nullable View view) {
                ItemVisibilityTrackerImpl.this.unsubscribe(this.b);
            }
        };
        this.h = itemVisibilityTrackerImpl$createOnAttachStateChangeListener$1;
        recyclerView.addOnAttachStateChangeListener(itemVisibilityTrackerImpl$createOnAttachStateChangeListener$1);
        updateTrackingKeys(recyclerView, false);
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    public void unsubscribe(@NotNull RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recycler");
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.h;
        if (onAttachStateChangeListener != null) {
            recyclerView.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.h = null;
        }
        RecyclerView.AdapterDataObserver adapterDataObserver = this.g;
        if (adapterDataObserver != null) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.unregisterAdapterDataObserver(adapterDataObserver);
            }
            this.g = null;
        }
        this.d.removeCallbacksAndMessages(null);
        this.f.clear();
        this.c = null;
        this.e = null;
        b(y.emptySet(), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a7, code lost:
        if (r7.top <= 0) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00be, code lost:
        if (r7.bottom > r16.j.bottom) goto L_0x0118;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0114, code lost:
        if (r12 >= r8.getMinVisibilityPercentage()) goto L_0x0116;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0118, code lost:
        r4 = false;
     */
    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateTrackingKeys(@org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r17, boolean r18) {
        /*
        // Method dump skipped, instructions count: 467
        */
        throw new UnsupportedOperationException("Method not decompiled: com.avito.android.item_visibility_tracker.ItemVisibilityTrackerImpl.updateTrackingKeys(androidx.recyclerview.widget.RecyclerView, boolean):void");
    }

    @Override // com.avito.android.item_visibility_tracker.ItemVisibilityTracker
    public void updateViewportInset(int i2, int i3, int i4, int i5) {
        Rect rect = new Rect(i2, i3, i4, i5);
        if (!Intrinsics.areEqual(getViewportInset(), rect)) {
            this.a = rect;
            Runnable runnable = this.e;
            if (runnable != null) {
                this.d.removeCallbacks(runnable);
                this.d.postDelayed(runnable, 200);
            }
        }
    }
}
