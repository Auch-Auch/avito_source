package com.avito.android.messenger.channels.mvi.common.v4.rendering;

import androidx.annotation.CheckResult;
import com.jakewharton.rxrelay2.BehaviorRelay;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.schedulers.Schedulers;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001au\u0010\u000e\u001a\u00020\r\"\b\b\u0000\u0010\u0001*\u00020\u0000\"\u0004\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u00062\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u001c\b\u0006\u0010\f\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00018\u0000\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u000b0\nH\bø\u0001\u0000¢\u0006\u0004\b\u000e\u0010\u000f\"*\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00108Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"*\u0010\u0013\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00068Æ\u0002@\u0006¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0014\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0015"}, d2 = {"", "StateT", "Item", "Lio/reactivex/Observable;", "", "logTag", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;", "renderer", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Differ;", "differ", "Lkotlin/Function2;", "", "onRendered", "Lio/reactivex/disposables/Disposable;", "render", "(Lio/reactivex/Observable;Ljava/lang/String;Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Differ;Lkotlin/jvm/functions/Function2;)Lio/reactivex/disposables/Disposable;", "Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;", "getLastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/Renderer;)Ljava/lang/Object;", "lastRenderedState", "(Lcom/avito/android/messenger/channels/mvi/common/v4/rendering/RendererWithDiff;)Ljava/lang/Object;", "mvi_release"}, k = 2, mv = {1, 4, 2})
public final class RendererKt {
    @Nullable
    public static final <StateT> StateT getLastRenderedState(@NotNull Renderer<StateT> renderer) {
        Intrinsics.checkNotNullParameter(renderer, "$this$lastRenderedState");
        return renderer.getLastRenderedState(renderer);
    }

    @CheckResult
    @NotNull
    public static final <StateT, Item> Disposable render(@NotNull Observable<StateT> observable, @NotNull String str, @NotNull RendererWithDiff<StateT> rendererWithDiff, @NotNull Differ<StateT, Item> differ, @NotNull Function2<? super StateT, ? super StateT, Unit> function2) {
        Intrinsics.checkNotNullParameter(observable, "$this$render");
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(rendererWithDiff, "renderer");
        Intrinsics.checkNotNullParameter(differ, "differ");
        Intrinsics.checkNotNullParameter(function2, "onRendered");
        BehaviorRelay createDefault = BehaviorRelay.createDefault(Unit.INSTANCE);
        Observable<StateT> observeOn = observable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(AndroidSchedulers.mainThread())");
        Intrinsics.checkNotNullExpressionValue(createDefault, "nextStateTrigger");
        Observable<R> zipWith = observeOn.zipWith(createDefault, new BiFunction<StateT, Unit, R>(rendererWithDiff) { // from class: com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererKt$render$$inlined$zipWith$1
            public final /* synthetic */ RendererWithDiff a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(StateT statet, Unit unit) {
                RendererWithDiff rendererWithDiff2 = this.a;
                return (R) TuplesKt.to(rendererWithDiff2.getLastRenderedState(rendererWithDiff2), statet);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        Disposable subscribe = zipWith.observeOn(Schedulers.computation()).map(new RendererKt$render$3(differ)).observeOn(AndroidSchedulers.mainThread()).subscribe(new RendererKt$render$4(rendererWithDiff, str, function2, createDefault));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(AndroidSchedul…Trigger += Unit\n        }");
        return subscribe;
    }

    public static /* synthetic */ Disposable render$default(Observable observable, String str, RendererWithDiff rendererWithDiff, Differ differ, Function2 function2, int i, Object obj) {
        if ((i & 8) != 0) {
            function2 = RendererKt$render$1.INSTANCE;
        }
        Intrinsics.checkNotNullParameter(observable, "$this$render");
        Intrinsics.checkNotNullParameter(str, "logTag");
        Intrinsics.checkNotNullParameter(rendererWithDiff, "renderer");
        Intrinsics.checkNotNullParameter(differ, "differ");
        Intrinsics.checkNotNullParameter(function2, "onRendered");
        BehaviorRelay createDefault = BehaviorRelay.createDefault(Unit.INSTANCE);
        Observable observeOn = observable.observeOn(AndroidSchedulers.mainThread());
        Intrinsics.checkNotNullExpressionValue(observeOn, "observeOn(AndroidSchedulers.mainThread())");
        Intrinsics.checkNotNullExpressionValue(createDefault, "nextStateTrigger");
        Observable zipWith = observeOn.zipWith(createDefault, new BiFunction<StateT, Unit, R>(rendererWithDiff) { // from class: com.avito.android.messenger.channels.mvi.common.v4.rendering.RendererKt$render$$inlined$zipWith$2
            public final /* synthetic */ RendererWithDiff a;

            {
                this.a = r1;
            }

            @Override // io.reactivex.functions.BiFunction
            public final R apply(StateT statet, Unit unit) {
                RendererWithDiff rendererWithDiff2 = this.a;
                return (R) TuplesKt.to(rendererWithDiff2.getLastRenderedState(rendererWithDiff2), statet);
            }
        });
        Intrinsics.checkExpressionValueIsNotNull(zipWith, "zipWith(other, BiFunctio…-> zipper.invoke(t, u) })");
        Disposable subscribe = zipWith.observeOn(Schedulers.computation()).map(new RendererKt$render$3(differ)).observeOn(AndroidSchedulers.mainThread()).subscribe(new RendererKt$render$4(rendererWithDiff, str, function2, createDefault));
        Intrinsics.checkNotNullExpressionValue(subscribe, "observeOn(AndroidSchedul…Trigger += Unit\n        }");
        return subscribe;
    }

    @Nullable
    public static final <StateT> StateT getLastRenderedState(@NotNull RendererWithDiff<StateT> rendererWithDiff) {
        Intrinsics.checkNotNullParameter(rendererWithDiff, "$this$lastRenderedState");
        return rendererWithDiff.getLastRenderedState(rendererWithDiff);
    }
}
