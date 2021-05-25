package com.avito.android.remote.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u0011\b\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0004J\r\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0004J\r\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0004J\r\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\u0004J\r\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\u0004R\u0019\u0010\u000b\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/avito/android/remote/model/SerpDisplayType;", "", "", "isGrid", "()Z", "isList", "isRich", "isVacancy", "isInformative", "isSingleColumn", "", "id", "I", "getId", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "Grid", "List", "Rich", "Vacancy", "models_release"}, k = 1, mv = {1, 4, 2})
public enum SerpDisplayType {
    Grid(1),
    List(2),
    Rich(3),
    Vacancy(4);
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int id;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/avito/android/remote/model/SerpDisplayType$Companion;", "", "", "value", "Lcom/avito/android/remote/model/SerpDisplayType;", "fromString", "(Ljava/lang/String;)Lcom/avito/android/remote/model/SerpDisplayType;", "", "defaultValues", "()[Lcom/avito/android/remote/model/SerpDisplayType;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        @NotNull
        public final SerpDisplayType[] defaultValues() {
            return new SerpDisplayType[]{SerpDisplayType.Grid, SerpDisplayType.List};
        }

        @Nullable
        public final SerpDisplayType fromString(@Nullable String str) {
            String str2;
            if (str != null) {
                str2 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(str2, "(this as java.lang.String).toLowerCase()");
            } else {
                str2 = null;
            }
            if (str2 == null) {
                return null;
            }
            switch (str2.hashCode()) {
                case 3181382:
                    if (str2.equals("grid")) {
                        return SerpDisplayType.Grid;
                    }
                    return null;
                case 3322014:
                    if (str2.equals("list")) {
                        return SerpDisplayType.List;
                    }
                    return null;
                case 3500252:
                    if (str2.equals("rich")) {
                        return SerpDisplayType.Rich;
                    }
                    return null;
                case 222706811:
                    if (str2.equals("vacancy")) {
                        return SerpDisplayType.Vacancy;
                    }
                    return null;
                default:
                    return null;
            }
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    private SerpDisplayType(int i) {
        this.id = i;
    }

    public final int getId() {
        return this.id;
    }

    public final boolean isGrid() {
        return this == Grid;
    }

    public final boolean isInformative() {
        return isRich() || isVacancy();
    }

    public final boolean isList() {
        return this == List;
    }

    public final boolean isRich() {
        return this == Rich;
    }

    public final boolean isSingleColumn() {
        return isList() || isInformative();
    }

    public final boolean isVacancy() {
        return this == Vacancy;
    }
}
