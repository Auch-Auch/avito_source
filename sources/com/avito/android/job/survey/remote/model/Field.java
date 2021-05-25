package com.avito.android.job.survey.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/avito/android/job/survey/remote/model/Field;", "", "<init>", "()V", "RadioGroupField", "TextAreaField", "Lcom/avito/android/job/survey/remote/model/Field$RadioGroupField;", "Lcom/avito/android/job/survey/remote/model/Field$TextAreaField;", "job_release"}, k = 1, mv = {1, 4, 2})
public abstract class Field {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\nB\u0015\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\b\u0010\tR\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/avito/android/job/survey/remote/model/Field$RadioGroupField;", "Lcom/avito/android/job/survey/remote/model/Field;", "", "Lcom/avito/android/job/survey/remote/model/Field$RadioGroupField$Option;", "options", "Ljava/util/List;", "getOptions", "()Ljava/util/List;", "<init>", "(Ljava/util/List;)V", "Option", "job_release"}, k = 1, mv = {1, 4, 2})
    public static final class RadioGroupField extends Field {
        @SerializedName("options")
        @NotNull
        private final List<Option> options;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/avito/android/job/survey/remote/model/Field$RadioGroupField$Option;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "title", "getTitle", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "job_release"}, k = 1, mv = {1, 4, 2})
        public static final class Option {
            @SerializedName("title")
            @NotNull
            private final String title;
            @SerializedName("value")
            @NotNull
            private final String value;

            public Option(@NotNull String str, @NotNull String str2) {
                Intrinsics.checkNotNullParameter(str, "title");
                Intrinsics.checkNotNullParameter(str2, "value");
                this.title = str;
                this.value = str2;
            }

            @NotNull
            public final String getTitle() {
                return this.title;
            }

            @NotNull
            public final String getValue() {
                return this.value;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RadioGroupField(@NotNull List<Option> list) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "options");
            this.options = list;
        }

        @NotNull
        public final List<Option> getOptions() {
            return this.options;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/job/survey/remote/model/Field$TextAreaField;", "Lcom/avito/android/job/survey/remote/model/Field;", "", "hint", "Ljava/lang/String;", "getHint", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "job_release"}, k = 1, mv = {1, 4, 2})
    public static final class TextAreaField extends Field {
        @SerializedName("hint")
        @NotNull
        private final String hint;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TextAreaField(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "hint");
            this.hint = str;
        }

        @NotNull
        public final String getHint() {
            return this.hint;
        }
    }

    public Field() {
    }

    public Field(j jVar) {
    }
}
