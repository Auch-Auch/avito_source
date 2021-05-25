package hu.akarnokd.rxjava3.retrofit;

import a2.b.a.a.a;
import io.reactivex.rxjava3.annotations.Nullable;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.core.Single;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import r6.a.b.l.e;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
public final class RxJava3CallAdapterFactory extends CallAdapter.Factory {
    @Nullable
    public final Scheduler a;
    public final boolean b;

    public RxJava3CallAdapterFactory(@Nullable Scheduler scheduler, boolean z) {
        this.a = scheduler;
        this.b = z;
    }

    public static RxJava3CallAdapterFactory create() {
        return new RxJava3CallAdapterFactory(null, false);
    }

    public static RxJava3CallAdapterFactory createAsync() {
        return new RxJava3CallAdapterFactory(null, true);
    }

    public static RxJava3CallAdapterFactory createWithScheduler(Scheduler scheduler) {
        Objects.requireNonNull(scheduler, "scheduler == null");
        return new RxJava3CallAdapterFactory(scheduler, false);
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
            return new e(Void.class, this.a, this.b, false, true, false, false, false, true);
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
            return new e(type2, this.a, this.b, z2, z, z4, z5, z7, false);
        } else if (parameterUpperBound instanceof ParameterizedType) {
            type3 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z3 = true;
        } else {
            throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
        }
        type2 = type3;
        z2 = z3;
        z = false;
        return new e(type2, this.a, this.b, z2, z, z4, z5, z7, false);
    }
}
