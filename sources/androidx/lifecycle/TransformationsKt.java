package androidx.lifecycle;

import androidx.arch.core.util.Function;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001aE\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u0014\b\u0004\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001aK\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0002\"\u0004\b\u0000\u0010\u0000\"\u0004\b\u0001\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\u001a\b\u0004\u0010\u0004\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\u00020\u0003H\bø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\u0006\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\b¢\u0006\u0004\b\b\u0010\t\u0002\u0007\n\u0005\b20\u0001¨\u0006\n"}, d2 = {"X", "Y", "Landroidx/lifecycle/LiveData;", "Lkotlin/Function1;", "transform", "map", "(Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)Landroidx/lifecycle/LiveData;", "switchMap", "distinctUntilChanged", "(Landroidx/lifecycle/LiveData;)Landroidx/lifecycle/LiveData;", "lifecycle-livedata-ktx_release"}, k = 2, mv = {1, 4, 1})
public final class TransformationsKt {
    @NotNull
    public static final <X> LiveData<X> distinctUntilChanged(@NotNull LiveData<X> liveData) {
        Intrinsics.checkNotNullParameter(liveData, "$this$distinctUntilChanged");
        LiveData<X> distinctUntilChanged = Transformations.distinctUntilChanged(liveData);
        Intrinsics.checkNotNullExpressionValue(distinctUntilChanged, "Transformations.distinctUntilChanged(this)");
        return distinctUntilChanged;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> map(@NotNull LiveData<X> liveData, @NotNull Function1<? super X, ? extends Y> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$map");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LiveData<Y> map = Transformations.map(liveData, new Function<X, Y>(function1) { // from class: androidx.lifecycle.TransformationsKt$map$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.arch.core.util.Function
            public final Y apply(X x) {
                return (Y) this.a.invoke(x);
            }
        });
        Intrinsics.checkNotNullExpressionValue(map, "Transformations.map(this) { transform(it) }");
        return map;
    }

    @NotNull
    public static final <X, Y> LiveData<Y> switchMap(@NotNull LiveData<X> liveData, @NotNull Function1<? super X, ? extends LiveData<Y>> function1) {
        Intrinsics.checkNotNullParameter(liveData, "$this$switchMap");
        Intrinsics.checkNotNullParameter(function1, "transform");
        LiveData<Y> switchMap = Transformations.switchMap(liveData, new Function<X, LiveData<Y>>(function1) { // from class: androidx.lifecycle.TransformationsKt$switchMap$1
            public final /* synthetic */ Function1 a;

            {
                this.a = r1;
            }

            @Override // androidx.arch.core.util.Function
            public final LiveData<Y> apply(X x) {
                return (LiveData) this.a.invoke(x);
            }
        });
        Intrinsics.checkNotNullExpressionValue(switchMap, "Transformations.switchMap(this) { transform(it) }");
        return switchMap;
    }
}
