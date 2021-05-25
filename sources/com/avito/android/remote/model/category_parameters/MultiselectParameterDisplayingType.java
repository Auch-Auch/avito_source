package com.avito.android.remote.model.category_parameters;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import org.jetbrains.annotations.NotNull;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\b\u0002\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameterDisplayingType;", "", "<init>", "()V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
@Retention(RetentionPolicy.SOURCE)
@kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface MultiselectParameterDisplayingType {
    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;
    @NotNull
    public static final String TYPE_BOTTOM_SHEET = "bottomSheet";
    @NotNull
    public static final String TYPE_CHIPS = "chips";
    @NotNull
    public static final String TYPE_DEFAULT = "default";
    @NotNull
    public static final String TYPE_DIALOG = "dialog";
    @NotNull
    public static final String TYPE_GROUP_SELECT = "groupSelect";
    @NotNull
    public static final String TYPE_INLINED = "inlined";
    @NotNull
    public static final String TYPE_TAGS = "tags";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/category_parameters/MultiselectParameterDisplayingType$Companion;", "", "", "TYPE_INLINED", "Ljava/lang/String;", "TYPE_DIALOG", "TYPE_BOTTOM_SHEET", "TYPE_TAGS", "TYPE_CHIPS", "TYPE_GROUP_SELECT", "TYPE_DEFAULT", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE = new Companion();
        @NotNull
        public static final String TYPE_BOTTOM_SHEET = "bottomSheet";
        @NotNull
        public static final String TYPE_CHIPS = "chips";
        @NotNull
        public static final String TYPE_DEFAULT = "default";
        @NotNull
        public static final String TYPE_DIALOG = "dialog";
        @NotNull
        public static final String TYPE_GROUP_SELECT = "groupSelect";
        @NotNull
        public static final String TYPE_INLINED = "inlined";
        @NotNull
        public static final String TYPE_TAGS = "tags";

        private Companion() {
        }
    }
}
