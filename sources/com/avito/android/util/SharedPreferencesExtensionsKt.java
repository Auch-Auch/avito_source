package com.avito.android.util;

import android.content.SharedPreferences;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.functions.Cancellable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\u001a0\u0010\u0006\u001a\u00020\u0003*\u00020\u00002\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004H\bø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007\u001a\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b*\u00020\u0000¢\u0006\u0004\b\n\u0010\u000b\u001a#\u0010\u000f\u001a\u0004\u0018\u00010\r*\u00020\u00002\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0011"}, d2 = {"Landroid/content/SharedPreferences;", "Lkotlin/Function1;", "Landroid/content/SharedPreferences$Editor;", "", "Lkotlin/ExtensionFunctionType;", "action", "edit", "(Landroid/content/SharedPreferences;Lkotlin/jvm/functions/Function1;)V", "Lio/reactivex/Observable;", "", "changes", "(Landroid/content/SharedPreferences;)Lio/reactivex/Observable;", "key", "", "defaultValue", "getNullableInt", "(Landroid/content/SharedPreferences;Ljava/lang/String;I)Ljava/lang/Integer;", "core_release"}, k = 2, mv = {1, 4, 2})
public final class SharedPreferencesExtensionsKt {

    public static final class a<T> implements ObservableOnSubscribe<String> {
        public final /* synthetic */ SharedPreferences a;

        /* renamed from: com.avito.android.util.SharedPreferencesExtensionsKt$a$a  reason: collision with other inner class name */
        public static final class C0168a implements Cancellable {
            public final /* synthetic */ a a;
            public final /* synthetic */ SharedPreferences.OnSharedPreferenceChangeListener b;

            public C0168a(a aVar, SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
                this.a = aVar;
                this.b = onSharedPreferenceChangeListener;
            }

            @Override // io.reactivex.functions.Cancellable
            public final void cancel() {
                this.a.a.unregisterOnSharedPreferenceChangeListener(this.b);
            }
        }

        public static final class b implements SharedPreferences.OnSharedPreferenceChangeListener {
            public final /* synthetic */ ObservableEmitter a;

            public b(ObservableEmitter observableEmitter) {
                this.a = observableEmitter;
            }

            @Override // android.content.SharedPreferences.OnSharedPreferenceChangeListener
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                ObservableEmitter observableEmitter = this.a;
                Intrinsics.checkNotNullExpressionValue(observableEmitter, "emitter");
                if (!observableEmitter.isDisposed()) {
                    this.a.onNext(str);
                }
            }
        }

        public a(SharedPreferences sharedPreferences) {
            this.a = sharedPreferences;
        }

        @Override // io.reactivex.ObservableOnSubscribe
        public final void subscribe(@NotNull ObservableEmitter<String> observableEmitter) {
            Intrinsics.checkNotNullParameter(observableEmitter, "emitter");
            b bVar = new b(observableEmitter);
            this.a.registerOnSharedPreferenceChangeListener(bVar);
            observableEmitter.setCancellable(new C0168a(this, bVar));
        }
    }

    @NotNull
    public static final Observable<String> changes(@NotNull SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "$this$changes");
        Observable<String> create = Observable.create(new a(sharedPreferences));
        Intrinsics.checkNotNullExpressionValue(create, "Observable.create { emit…r(changeListener) }\n    }");
        return create;
    }

    public static final void edit(@NotNull SharedPreferences sharedPreferences, @NotNull Function1<? super SharedPreferences.Editor, Unit> function1) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "$this$edit");
        Intrinsics.checkNotNullParameter(function1, "action");
        SharedPreferences.Editor edit = sharedPreferences.edit();
        function1.invoke(edit);
        edit.apply();
    }

    @Nullable
    public static final Integer getNullableInt(@NotNull SharedPreferences sharedPreferences, @NotNull String str, int i) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "$this$getNullableInt");
        Intrinsics.checkNotNullParameter(str, "key");
        int i2 = sharedPreferences.getInt(str, i);
        if (i2 == i) {
            return null;
        }
        return Integer.valueOf(i2);
    }
}
