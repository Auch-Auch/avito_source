package hu.akarnokd.rxjava2.string;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.regex.Pattern;
import r6.a.a.k.a;
import r6.a.a.k.b;
public final class StringFlowable {
    public StringFlowable() {
        throw new IllegalStateException("No instances!");
    }

    public static Flowable<Integer> characters(CharSequence charSequence) {
        ObjectHelper.requireNonNull(charSequence, "string is null");
        return RxJavaPlugins.onAssembly(new a(charSequence));
    }

    public static FlowableTransformer<String, String> split(Pattern pattern) {
        return split(pattern, Flowable.bufferSize());
    }

    public static FlowableTransformer<String, String> split(Pattern pattern, int i) {
        ObjectHelper.requireNonNull(pattern, "pattern is null");
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
