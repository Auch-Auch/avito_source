package com.avito.android.remote.model;

import a2.b.a.a.a;
import com.avito.android.analytics.screens.InternalConstsKt;
import com.avito.android.publish.residential_complex_search.di.ResidentialComplexModuleKt;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/TextWidget;", "Lcom/avito/android/remote/model/Widget;", "Lcom/avito/android/remote/model/TextWidget$Config;", "component1", "()Lcom/avito/android/remote/model/TextWidget$Config;", "", "Lcom/avito/android/remote/model/TextWidget$Field;", "component2", "()Ljava/util/List;", Navigation.CONFIG, ResidentialComplexModuleKt.VALUES, "copy", "(Lcom/avito/android/remote/model/TextWidget$Config;Ljava/util/List;)Lcom/avito/android/remote/model/TextWidget;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/TextWidget$Config;", "getConfig", "Ljava/util/List;", "getValues", "<init>", "(Lcom/avito/android/remote/model/TextWidget$Config;Ljava/util/List;)V", "Config", "Field", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class TextWidget implements Widget {
    @SerializedName(Navigation.CONFIG)
    @NotNull
    private final Config config;
    @SerializedName("fields")
    @Nullable
    private final List<Field> values;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J&\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\n\u0010\u0004J\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0014\u0010\u0004¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/TextWidget$Config;", "", "", "component1", "()Ljava/lang/String;", "component2", "title", InternalConstsKt.PLACEHOLDER, "copy", "(Ljava/lang/String;Ljava/lang/String;)Lcom/avito/android/remote/model/TextWidget$Config;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getPlaceholder", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config {
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("title")
        @NotNull
        private final String title;

        public Config(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.placeholder = str2;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = config.title;
            }
            if ((i & 2) != 0) {
                str2 = config.placeholder;
            }
            return config.copy(str, str2);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final String component2() {
            return this.placeholder;
        }

        @NotNull
        public final Config copy(@NotNull String str, @Nullable String str2) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Config(str, str2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.title, config.title) && Intrinsics.areEqual(this.placeholder, config.placeholder);
        }

        @Nullable
        public final String getPlaceholder() {
            return this.placeholder;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public int hashCode() {
            String str = this.title;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.placeholder;
            if (str2 != null) {
                i = str2.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Config(title=");
            L.append(this.title);
            L.append(", placeholder=");
            return a.t(L, this.placeholder, ")");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/TextWidget$Field;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/TextWidget$Field$FieldValue;", "component2", "()Ljava/util/List;", "name", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/TextWidget$Field;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getValues", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "FieldValue", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Field {
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @Nullable
        private final List<FieldValue> values;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0014\u001a\u00020\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0014\u0010\u0015R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0004R\u001e\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0018\u0010\u0004R\u001e\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b\u001a\u0010\b¨\u0006\u001d"}, d2 = {"Lcom/avito/android/remote/model/TextWidget$Field$FieldValue;", "", "", "component1", "()Ljava/lang/String;", "component2", "Lcom/avito/android/remote/model/FieldModeration;", "component3", "()Lcom/avito/android/remote/model/FieldModeration;", "valueId", "text", "moderation", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/FieldModeration;)Lcom/avito/android/remote/model/TextWidget$Field$FieldValue;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getValueId", "getText", "Lcom/avito/android/remote/model/FieldModeration;", "getModeration", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/FieldModeration;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
        public static final class FieldValue {
            @SerializedName("moderation")
            @Nullable
            private final FieldModeration moderation;
            @SerializedName("value")
            @Nullable
            private final String text;
            @SerializedName("valueId")
            @NotNull
            private final String valueId;

            public FieldValue(@NotNull String str, @Nullable String str2, @Nullable FieldModeration fieldModeration) {
                Intrinsics.checkNotNullParameter(str, "valueId");
                this.valueId = str;
                this.text = str2;
                this.moderation = fieldModeration;
            }

            public static /* synthetic */ FieldValue copy$default(FieldValue fieldValue, String str, String str2, FieldModeration fieldModeration, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fieldValue.valueId;
                }
                if ((i & 2) != 0) {
                    str2 = fieldValue.text;
                }
                if ((i & 4) != 0) {
                    fieldModeration = fieldValue.moderation;
                }
                return fieldValue.copy(str, str2, fieldModeration);
            }

            @NotNull
            public final String component1() {
                return this.valueId;
            }

            @Nullable
            public final String component2() {
                return this.text;
            }

            @Nullable
            public final FieldModeration component3() {
                return this.moderation;
            }

            @NotNull
            public final FieldValue copy(@NotNull String str, @Nullable String str2, @Nullable FieldModeration fieldModeration) {
                Intrinsics.checkNotNullParameter(str, "valueId");
                return new FieldValue(str, str2, fieldModeration);
            }

            public boolean equals(@Nullable Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof FieldValue)) {
                    return false;
                }
                FieldValue fieldValue = (FieldValue) obj;
                return Intrinsics.areEqual(this.valueId, fieldValue.valueId) && Intrinsics.areEqual(this.text, fieldValue.text) && Intrinsics.areEqual(this.moderation, fieldValue.moderation);
            }

            @Nullable
            public final FieldModeration getModeration() {
                return this.moderation;
            }

            @Nullable
            public final String getText() {
                return this.text;
            }

            @NotNull
            public final String getValueId() {
                return this.valueId;
            }

            public int hashCode() {
                String str = this.valueId;
                int i = 0;
                int hashCode = (str != null ? str.hashCode() : 0) * 31;
                String str2 = this.text;
                int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
                FieldModeration fieldModeration = this.moderation;
                if (fieldModeration != null) {
                    i = fieldModeration.hashCode();
                }
                return hashCode2 + i;
            }

            @NotNull
            public String toString() {
                StringBuilder L = a.L("FieldValue(valueId=");
                L.append(this.valueId);
                L.append(", text=");
                L.append(this.text);
                L.append(", moderation=");
                L.append(this.moderation);
                L.append(")");
                return L.toString();
            }
        }

        public Field(@NotNull String str, @Nullable List<FieldValue> list) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.name = str;
            this.values = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.TextWidget$Field */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Field copy$default(Field field, String str, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = field.name;
            }
            if ((i & 2) != 0) {
                list = field.values;
            }
            return field.copy(str, list);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @Nullable
        public final List<FieldValue> component2() {
            return this.values;
        }

        @NotNull
        public final Field copy(@NotNull String str, @Nullable List<FieldValue> list) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new Field(str, list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Field)) {
                return false;
            }
            Field field = (Field) obj;
            return Intrinsics.areEqual(this.name, field.name) && Intrinsics.areEqual(this.values, field.values);
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final List<FieldValue> getValues() {
            return this.values;
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            List<FieldValue> list = this.values;
            if (list != null) {
                i = list.hashCode();
            }
            return hashCode + i;
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Field(name=");
            L.append(this.name);
            L.append(", values=");
            return a.w(L, this.values, ")");
        }
    }

    public TextWidget(@NotNull Config config2, @Nullable List<Field> list) {
        Intrinsics.checkNotNullParameter(config2, Navigation.CONFIG);
        this.config = config2;
        this.values = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.TextWidget */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TextWidget copy$default(TextWidget textWidget, Config config2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            config2 = textWidget.config;
        }
        if ((i & 2) != 0) {
            list = textWidget.values;
        }
        return textWidget.copy(config2, list);
    }

    @NotNull
    public final Config component1() {
        return this.config;
    }

    @Nullable
    public final List<Field> component2() {
        return this.values;
    }

    @NotNull
    public final TextWidget copy(@NotNull Config config2, @Nullable List<Field> list) {
        Intrinsics.checkNotNullParameter(config2, Navigation.CONFIG);
        return new TextWidget(config2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextWidget)) {
            return false;
        }
        TextWidget textWidget = (TextWidget) obj;
        return Intrinsics.areEqual(this.config, textWidget.config) && Intrinsics.areEqual(this.values, textWidget.values);
    }

    @NotNull
    public final Config getConfig() {
        return this.config;
    }

    @Nullable
    public final List<Field> getValues() {
        return this.values;
    }

    public int hashCode() {
        Config config2 = this.config;
        int i = 0;
        int hashCode = (config2 != null ? config2.hashCode() : 0) * 31;
        List<Field> list = this.values;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("TextWidget(config=");
        L.append(this.config);
        L.append(", values=");
        return a.w(L, this.values, ")");
    }
}
