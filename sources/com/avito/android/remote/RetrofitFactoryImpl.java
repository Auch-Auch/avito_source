package com.avito.android.remote;

import androidx.core.app.NotificationCompat;
import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ#\u0010\u0005\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\n\u001a\u00020\u00078\u0002@\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/RetrofitFactoryImpl;", "Lcom/avito/android/remote/RetrofitFactory;", "T", "Ljava/lang/Class;", NotificationCompat.CATEGORY_SERVICE, "create", "(Ljava/lang/Class;)Ljava/lang/Object;", "Lretrofit2/Retrofit;", AuthSource.SEND_ABUSE, "Lretrofit2/Retrofit;", "retrofit", "<init>", "(Lretrofit2/Retrofit;)V"}, k = 1, mv = {1, 4, 2})
public final class RetrofitFactoryImpl implements RetrofitFactory {
    public final Retrofit a;

    public RetrofitFactoryImpl(@NotNull Retrofit retrofit) {
        Intrinsics.checkNotNullParameter(retrofit, "retrofit");
        this.a = retrofit;
    }

    @Override // com.avito.android.remote.RetrofitFactory
    public <T> T create(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, NotificationCompat.CATEGORY_SERVICE);
        return (T) this.a.create(cls);
    }
}
