package com.avito.android.remote.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
@Retention(RetentionPolicy.SOURCE)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/PublishShortcutType;", "", "<init>", "()V", "Companion", "publish_release"}, k = 1, mv = {1, 4, 2})
public @interface PublishShortcutType {
    @NotNull
    public static final String AUTO = "transport";
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    @NotNull
    public static final String GENERAL = "general";
    @NotNull
    public static final String JOB = "rabota";
    @NotNull
    public static final String REALTY = "nedvizhimost";
    @NotNull
    public static final String SERVICES = "uslugi";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/PublishShortcutType$Companion;", "", "", "JOB", "Ljava/lang/String;", "GENERAL", "REALTY", "SERVICES", "AUTO", "<init>", "()V", "publish_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        public static final String AUTO = "transport";
        @NotNull
        public static final String GENERAL = "general";
        @NotNull
        public static final String JOB = "rabota";
        @NotNull
        public static final String REALTY = "nedvizhimost";
        @NotNull
        public static final String SERVICES = "uslugi";

        private Companion() {
        }
    }
}
