package com.avito.android.util.architecture_components;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import com.avito.android.remote.auth.AuthSource;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u001c\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aC\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\b\u001aA\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\b\u001aC\u0010\u0007\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0016\b\u0004\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u000b\u001aA\u0010\t\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u00020\n2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0004\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000¢\u0006\u0004\b\t\u0010\u000b\u001a=\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u000e\u0010\u000f\u001aC\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\f*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0018\u0010\r\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0004¢\u0006\u0004\b\u0010\u0010\u000f\u001a3\u0010\u0015\u001a\u00020\u0005\"\u0004\b\u0000\u0010\u0000*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\u00112\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016\u001aC\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001a0\u0002\"\u0004\b\u0000\u0010\u0017\"\u0004\b\u0001\u0010\u0018*\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002¢\u0006\u0004\b\u001b\u0010\u001c\u0002\u0007\n\u0005\b20\u0001¨\u0006\u001d"}, d2 = {"T", "Landroidx/fragment/app/Fragment;", "Landroidx/lifecycle/LiveData;", "liveData", "Lkotlin/Function1;", "", "observer", "observe", "(Landroidx/fragment/app/Fragment;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", "observeNotNull", "Landroidx/lifecycle/LifecycleOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "f", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "switchMap", "Landroidx/lifecycle/MutableLiveData;", "", "", "list", "append", "(Landroidx/lifecycle/MutableLiveData;Ljava/lang/Iterable;)V", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", AuthSource.BOOKING_ORDER, "Lkotlin/Pair;", "combineLatest", "(Landroidx/lifecycle/LiveData;Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "android_release"}, k = 2, mv = {1, 4, 2})
public final class LiveDatasKt {

    public static final class a<T> implements Observer<A> {
        public final /* synthetic */ MediatorLiveData a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.ObjectRef c;

        public a(MediatorLiveData mediatorLiveData, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.a = mediatorLiveData;
            this.b = objectRef;
            this.c = objectRef2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: A */
        /* JADX DEBUG: Multi-variable search result rejected for r0v3, resolved type: androidx.lifecycle.MediatorLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(A a3) {
            if (a3 == 0 && this.a.getValue() != null) {
                this.a.setValue(null);
            }
            this.b.element = a3;
            if (a3 != 0 && this.c.element != null) {
                MediatorLiveData mediatorLiveData = this.a;
                Intrinsics.checkNotNull(a3);
                T t = this.c.element;
                Intrinsics.checkNotNull(t);
                mediatorLiveData.setValue(TuplesKt.to(a3, t));
            }
        }
    }

    public static final class b<T> implements Observer<B> {
        public final /* synthetic */ MediatorLiveData a;
        public final /* synthetic */ Ref.ObjectRef b;
        public final /* synthetic */ Ref.ObjectRef c;

        public b(MediatorLiveData mediatorLiveData, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            this.a = mediatorLiveData;
            this.b = objectRef;
            this.c = objectRef2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: B */
        /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: androidx.lifecycle.MediatorLiveData */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.Observer
        public final void onChanged(B b2) {
            if (b2 == 0 && this.a.getValue() != null) {
                this.a.setValue(null);
            }
            this.b.element = b2;
            T t = this.c.element;
            if (t != null && b2 != 0) {
                MediatorLiveData mediatorLiveData = this.a;
                Intrinsics.checkNotNull(t);
                T t2 = this.b.element;
                Intrinsics.checkNotNull(t2);
                mediatorLiveData.setValue(TuplesKt.to(t, t2));
            }
        }
    }

    public static final <T> void append(@NotNull MutableLiveData<List<T>> mutableLiveData, @Nullable Iterable<? extends T> iterable) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "$this$append");
        List<T> value = mutableLiveData.getValue();
        if (value == null) {
            value = CollectionsKt__CollectionsKt.emptyList();
        }
        if (iterable == null) {
            iterable = CollectionsKt__CollectionsKt.emptyList();
        }
        mutableLiveData.setValue(CollectionsKt___CollectionsKt.plus((Collection) value, (Iterable) iterable));
    }

    @NotNull
    public static final <A, B> LiveData<Pair<A, B>> combineLatest(@NotNull LiveData<A> liveData, @NotNull LiveData<B> liveData2) {
        Intrinsics.checkNotNullParameter(liveData, "$this$combineLatest");
        Intrinsics.checkNotNullParameter(liveData2, AuthSource.BOOKING_ORDER);
        MediatorLiveData mediatorLiveData = new MediatorLiveData();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        objectRef2.element = null;
        mediatorLiveData.addSource(liveData, new a(mediatorLiveData, objectRef, objectRef2));
        mediatorLiveData.addSource(liveData2, new b(mediatorLiveData, objectRef2, objectRef));
        return mediatorLiveData;
    }

    @NotNull
    public static final <T, V> LiveData<V> map(@NotNull LiveData<T> liveData, @NotNull Function1<? super T, ? extends V> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "f");
        LiveData<V> map = Transformations.map(liveData, new a2.a.a.n3.w.a(function1));
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(this, f)");
        return map;
    }

    public static final <T> void observe(@NotNull Fragment fragment, @NotNull LiveData<T> liveData, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "$this$observe");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(function1, "observer");
        liveData.observe(fragment.getViewLifecycleOwner(), new Observer<T>(function1) { // from class: com.avito.android.util.architecture_components.LiveDatasKt$observe$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                this.a.invoke(t);
            }
        });
    }

    public static final <T> void observeNotNull(@NotNull Fragment fragment, @NotNull LiveData<T> liveData, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(fragment, "$this$observeNotNull");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(function1, "observer");
        liveData.observe(fragment.getViewLifecycleOwner(), new Observer<T>(function1) { // from class: com.avito.android.util.architecture_components.LiveDatasKt$observeNotNull$$inlined$observe$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.invoke(t);
                }
            }
        });
    }

    @NotNull
    public static final <T, V> LiveData<V> switchMap(@NotNull LiveData<T> liveData, @NotNull Function1<? super T, ? extends LiveData<V>> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$switchMap");
        Intrinsics.checkNotNullParameter(function1, "f");
        LiveData<V> switchMap = Transformations.switchMap(liveData, new a2.a.a.n3.w.a(function1));
        Intrinsics.checkNotNullExpressionValue(switchMap, "Transformations.switchMap(this, f)");
        return switchMap;
    }

    public static final <T> void observe(@NotNull LifecycleOwner lifecycleOwner, @NotNull LiveData<T> liveData, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$this$observe");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(function1, "observer");
        liveData.observe(lifecycleOwner, new Observer<T>(function1) { // from class: com.avito.android.util.architecture_components.LiveDatasKt$observe$2
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                this.a.invoke(t);
            }
        });
    }

    public static final <T> void observeNotNull(@NotNull LifecycleOwner lifecycleOwner, @NotNull LiveData<T> liveData, @NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "$this$observeNotNull");
        Intrinsics.checkNotNullParameter(liveData, "liveData");
        Intrinsics.checkNotNullParameter(function1, "observer");
        liveData.observe(lifecycleOwner, new Observer<T>(function1) { // from class: com.avito.android.util.architecture_components.LiveDatasKt$observeNotNull$$inlined$observe$2
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(T t) {
                if (t != null) {
                    this.a.invoke(t);
                }
            }
        });
    }
}
