package ru.avito.messenger.internal.config;

import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Navigation;
import com.avito.android.util.SchedulersFactory;
import io.reactivex.Single;
import io.reactivex.functions.Function;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import ru.avito.messenger.config.MessengerConfig;
import ru.avito.messenger.config.MessengerConfigProvider;
import ru.avito.messenger.config.MessengerConfigStorage;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\r\u001a\u00020\n\u0012\u0006\u0010\u0005\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0005\u001a\u00020\u00028\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\r\u001a\u00020\n8\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u001c\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lru/avito/messenger/internal/config/SimpleConfigProvider;", "Lru/avito/messenger/config/MessengerConfigProvider;", "Lcom/avito/android/util/SchedulersFactory;", AuthSource.BOOKING_ORDER, "Lcom/avito/android/util/SchedulersFactory;", "schedulers", "Lru/avito/messenger/config/MessengerConfig;", "c", "Lru/avito/messenger/config/MessengerConfig;", "defaultConfig", "Lru/avito/messenger/config/MessengerConfigStorage;", AuthSource.SEND_ABUSE, "Lru/avito/messenger/config/MessengerConfigStorage;", "storage", "Lio/reactivex/Single;", "getConfig", "()Lio/reactivex/Single;", Navigation.CONFIG, "<init>", "(Lru/avito/messenger/config/MessengerConfigStorage;Lcom/avito/android/util/SchedulersFactory;Lru/avito/messenger/config/MessengerConfig;)V", "messenger_release"}, k = 1, mv = {1, 4, 2})
public final class SimpleConfigProvider implements MessengerConfigProvider {
    public final MessengerConfigStorage a;
    public final SchedulersFactory b;
    public final MessengerConfig c;

    public static final class a<T, R> implements Function<Throwable, MessengerConfig> {
        public final /* synthetic */ SimpleConfigProvider a;

        public a(SimpleConfigProvider simpleConfigProvider) {
            this.a = simpleConfigProvider;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // io.reactivex.functions.Function
        public MessengerConfig apply(Throwable th) {
            Intrinsics.checkNotNullParameter(th, "it");
            return this.a.c;
        }
    }

    public SimpleConfigProvider(@NotNull MessengerConfigStorage messengerConfigStorage, @NotNull SchedulersFactory schedulersFactory, @NotNull MessengerConfig messengerConfig) {
        Intrinsics.checkNotNullParameter(messengerConfigStorage, "storage");
        Intrinsics.checkNotNullParameter(schedulersFactory, "schedulers");
        Intrinsics.checkNotNullParameter(messengerConfig, "defaultConfig");
        this.a = messengerConfigStorage;
        this.b = schedulersFactory;
        this.c = messengerConfig;
    }

    @Override // ru.avito.messenger.config.MessengerConfigProvider
    @NotNull
    public Single<MessengerConfig> getConfig() {
        return a2.b.a.a.a.V1(this.b, this.a.loadConfig(this.c).observeOn(this.b.computation()).onErrorReturn(new a(this)), "storage.loadConfig(defau…scribeOn(schedulers.io())");
    }
}
