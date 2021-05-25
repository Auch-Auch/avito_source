package com.avito.android.serp;

import com.avito.android.remote.SearchApi;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.TypedResult;
import com.avito.android.util.Logs;
import com.avito.android.util.SchedulersFactory3;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.n.r;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001:\u0001\fJ-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\t\u0010\bJ-\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\n\u0010\bJ-\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H&¢\u0006\u0004\b\u000b\u0010\b¨\u0006\r"}, d2 = {"Lcom/avito/android/serp/SerpSnippetInteractor;", "", "", "id", "", "analytics", "", "sendClick", "(Ljava/lang/String;Ljava/util/Map;)V", "sendClose", "sendShow", "sendHide", "Impl", "serp-core_release"}, k = 1, mv = {1, 4, 2})
public interface SerpSnippetInteractor {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u000f\u0012\u0006\u0010\u0015\u001a\u00020\u0012¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ-\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\t\u0010\bJ-\u0010\n\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\n\u0010\bJ-\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\bJ5\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u00022\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0016\u0010\u0011\u001a\u00020\u000f8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/avito/android/serp/SerpSnippetInteractor$Impl;", "Lcom/avito/android/serp/SerpSnippetInteractor;", "", "id", "", "analytics", "", "sendClick", "(Ljava/lang/String;Ljava/util/Map;)V", "sendClose", "sendShow", "sendHide", "action", AuthSource.SEND_ABUSE, "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", "Lcom/avito/android/util/SchedulersFactory3;", "Lcom/avito/android/util/SchedulersFactory3;", "schedulersFactory", "Lcom/avito/android/remote/SearchApi;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/remote/SearchApi;", "searchApi", "<init>", "(Lcom/avito/android/util/SchedulersFactory3;Lcom/avito/android/remote/SearchApi;)V", "serp-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Impl implements SerpSnippetInteractor {
        public final SchedulersFactory3 a;
        public final SearchApi b;

        public static final class a<T> implements Consumer<TypedResult<Unit>> {
            public static final a a = new a();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(TypedResult<Unit> typedResult) {
            }
        }

        public static final class b<T> implements Consumer<Throwable> {
            public static final b a = new b();

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // io.reactivex.rxjava3.functions.Consumer
            public void accept(Throwable th) {
                Logs.error(th);
            }
        }

        @Inject
        public Impl(@NotNull SchedulersFactory3 schedulersFactory3, @NotNull SearchApi searchApi) {
            Intrinsics.checkNotNullParameter(schedulersFactory3, "schedulersFactory");
            Intrinsics.checkNotNullParameter(searchApi, "searchApi");
            this.a = schedulersFactory3;
            this.b = searchApi;
        }

        public final void a(String str, String str2, Map<String, String> map) {
            SearchApi searchApi = this.b;
            if (map == null) {
                map = r.emptyMap();
            }
            searchApi.sendSerpSnippetAction(str, str2, map).subscribeOn(this.a.io()).subscribe(a.a, b.a);
        }

        @Override // com.avito.android.serp.SerpSnippetInteractor
        public void sendClick(@NotNull String str, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "id");
            a(str, "click", map);
        }

        @Override // com.avito.android.serp.SerpSnippetInteractor
        public void sendClose(@NotNull String str, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "id");
            a(str, "close", map);
        }

        @Override // com.avito.android.serp.SerpSnippetInteractor
        public void sendHide(@NotNull String str, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "id");
            a(str, "disappear", map);
        }

        @Override // com.avito.android.serp.SerpSnippetInteractor
        public void sendShow(@NotNull String str, @Nullable Map<String, String> map) {
            Intrinsics.checkNotNullParameter(str, "id");
            a(str, "show", map);
        }
    }

    void sendClick(@NotNull String str, @Nullable Map<String, String> map);

    void sendClose(@NotNull String str, @Nullable Map<String, String> map);

    void sendHide(@NotNull String str, @Nullable Map<String, String> map);

    void sendShow(@NotNull String str, @Nullable Map<String, String> map);
}
