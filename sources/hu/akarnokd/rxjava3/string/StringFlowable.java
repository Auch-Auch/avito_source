package hu.akarnokd.rxjava3.string;

import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableTransformer;
import io.reactivex.rxjava3.internal.functions.ObjectHelper;
import io.reactivex.rxjava3.plugins.RxJavaPlugins;
import java.util.Objects;
import java.util.regex.Pattern;
import r6.a.b.m.a;
import r6.a.b.m.b;
public final class StringFlowable {
    public StringFlowable() {
        throw new IllegalStateException("No instances!");
    }

    public static Flowable<Integer> characters(CharSequence charSequence) {
        Objects.requireNonNull(charSequence, "string is null");
        return RxJavaPlugins.onAssembly(new a(charSequence));
    }

    public static FlowableTransformer<String, String> split(Pattern pattern) {
        return split(pattern, Flowable.bufferSize());
    }

    public static FlowableTransformer<String, String> split(Pattern pattern, int i) {
        Objects.requireNonNull(pattern, "pattern is null");
        ObjectHelper.verifyPositive(i, "bufferSize");
        return new b(null, pattern, i);
    }

    public static FlowableTransformer<String, String> split(String str) {
        return split(str, Flowable.bufferSize());
    }

    public static FlowableTransformer<String, String> split(String str, int i) {
        return split(Pattern.compile(str), i);
    }
}
