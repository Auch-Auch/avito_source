package com.avito.android.validation;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a%\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0000*\b\u0012\u0004\u0012\u00020\u00010\u00002\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"Lio/reactivex/Observable;", "", "neededItemId", "filterItemIdFromNotifications", "(Lio/reactivex/Observable;Ljava/lang/String;)Lio/reactivex/Observable;", "item-temporary_release"}, k = 2, mv = {1, 4, 2})
public final class ItemsKt {

    /* compiled from: java-style lambda group */
    public static final class a<T, R> implements Function<String, String> {
        public static final a b = new a(0);
        public static final a c = new a(1);
        public final /* synthetic */ int a;

        public a(int i) {
            this.a = i;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public final String apply(String str) {
            int i = this.a;
            if (i == 0) {
                String str2 = str;
                Intrinsics.checkNotNullParameter(str2, "it");
                return StringsKt__StringsKt.removeSuffix(str2, (CharSequence) "_notification");
            } else if (i == 1) {
                String str3 = str;
                Intrinsics.checkNotNullParameter(str3, "it");
                return StringsKt__StringsKt.removePrefix(str3, (CharSequence) "motivation_");
            } else {
                throw null;
            }
        }
    }

    public static final class b<T> implements Predicate<String> {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Predicate
        public boolean test(String str) {
            String str2 = str;
            Intrinsics.checkNotNullParameter(str2, "itemId");
            return Intrinsics.areEqual(str2, this.a);
        }
    }

    @NotNull
    public static final Observable<String> filterItemIdFromNotifications(@NotNull Observable<String> observable, @NotNull String str) {
        Intrinsics.checkNotNullParameter(observable, "$this$filterItemIdFromNotifications");
        Intrinsics.checkNotNullParameter(str, "neededItemId");
        Observable<R> filter = observable.map(a.b).map(a.c).filter(new b(str));
        Intrinsics.checkNotNullExpressionValue(filter, "map { it.removeSuffix(\"_… itemId == neededItemId }");
        return filter;
    }
}
