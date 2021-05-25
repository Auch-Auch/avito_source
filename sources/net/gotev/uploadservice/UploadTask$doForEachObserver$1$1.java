package net.gotev.uploadservice;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0003\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "invoke", "()Ljava/lang/String;", "<anonymous>"}, k = 3, mv = {1, 4, 0})
public final class UploadTask$doForEachObserver$1$1 extends Lambda implements Function0<String> {
    public static final UploadTask$doForEachObserver$1$1 INSTANCE = new UploadTask$doForEachObserver$1$1();

    public UploadTask$doForEachObserver$1$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final String invoke() {
        return "error while dispatching event to observer";
    }
}
