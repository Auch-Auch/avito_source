package hu.akarnokd.rxjava3.retrofit;

import io.reactivex.rxjava3.annotations.Nullable;
import java.util.Objects;
import retrofit2.Response;
public final class Result<T> {
    @Nullable
    public final Response<T> a;
    @Nullable
    public final Throwable b;

    public Result(@Nullable Response<T> response, @Nullable Throwable th) {
        this.a = response;
        this.b = th;
    }

    public static <T> Result<T> error(Throwable th) {
        Objects.requireNonNull(th, "error == null");
        return new Result<>(null, th);
    }

    public static <T> Result<T> response(Response<T> response) {
        Objects.requireNonNull(response, "response == null");
        return new Result<>(response, null);
    }

    public boolean isError() {
        return this.b != null;
    }

    @Nullable
    public Throwable error() {
        return this.b;
    }

    @Nullable
    public Response<T> response() {
        return this.a;
    }
}
