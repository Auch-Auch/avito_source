package retrofit2.adapter.rxjava2;

import a2.b.a.a.a;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;
    @Nullable
    private final Scheduler scheduler;

    private RxJava2CallAdapterFactory(@Nullable Scheduler scheduler2, boolean z) {
        this.scheduler = scheduler2;
        this.isAsync = z;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(Scheduler scheduler2) {
        Objects.requireNonNull(scheduler2, "scheduler == null");
        return new RxJava2CallAdapterFactory(scheduler2, false);
    }

    @Override // retrofit2.CallAdapter.Factory
    @Nullable
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        boolean z;
        boolean z2;
        Type type2;
        boolean z3;
        Type type3;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == Completable.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z4 = rawType == Flowable.class;
        boolean z5 = rawType == Single.class;
        boolean z7 = rawType == Maybe.class;
        if (rawType != Observable.class && !z4 && !z5 && !z7) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z4 ? !z5 ? z7 ? "Maybe" : "Observable" : "Single" : "Flowable";
            StringBuilder W = a.W(str, " return type must be parameterized as ", str, "<Foo> or ", str);
            W.append("<? extends Foo>");
            throw new IllegalStateException(W.toString());
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (parameterUpperBound instanceof ParameterizedType) {
                type3 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
                z3 = false;
            } else {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z2 = false;
            z = true;
            return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z2, z, z4, z5, z7, false);
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type3 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z3 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        type2 = type3;
        z2 = z3;
        z = false;
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z2, z, z4, z5, z7, false);
    }
}
