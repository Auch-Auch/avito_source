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
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\b\u0018\u00002\u00020\u0001:\u0002\u001e\u001fB\u001f\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ,\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0011\u001a\u00020\u0010HÖ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0013HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u001a\u001a\u0004\b\u001b\u0010\b¨\u0006 "}, d2 = {"Lcom/avito/android/remote/model/GalleryWidget;", "Lcom/avito/android/remote/model/Widget;", "Lcom/avito/android/remote/model/GalleryWidget$Config;", "component1", "()Lcom/avito/android/remote/model/GalleryWidget$Config;", "", "Lcom/avito/android/remote/model/GalleryWidget$Field;", "component2", "()Ljava/util/List;", Navigation.CONFIG, "fields", "copy", "(Lcom/avito/android/remote/model/GalleryWidget$Config;Ljava/util/List;)Lcom/avito/android/remote/model/GalleryWidget;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/GalleryWidget$Config;", "getConfig", "Ljava/util/List;", "getFields", "<init>", "(Lcom/avito/android/remote/model/GalleryWidget$Config;Ljava/util/List;)V", "Config", "Field", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
public final class GalleryWidget implements Widget {
    @SerializedName(Navigation.CONFIG)
    @NotNull
    private final Config config;
    @SerializedName("fields")
    @Nullable
    private final List<Field> fields;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0002\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u000e\u001a\u00020\u0006\u0012\u0006\u0010\u000f\u001a\u00020\t¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ:\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\f\u001a\u00020\u00022\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0013\u0010\bJ\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001e\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u001a\u0010\u0004R\u001c\u0010\u000e\u001a\u00020\u00068\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u001b\u001a\u0004\b\u001c\u0010\bR\u001c\u0010\u000f\u001a\u00020\t8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u000b¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/GalleryWidget$Config;", "", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()I", "", "component4", "()F", "title", InternalConstsKt.PLACEHOLDER, "maxFilesCount", "maxFileSizeMB", "copy", "(Ljava/lang/String;Ljava/lang/String;IF)Lcom/avito/android/remote/model/GalleryWidget$Config;", "toString", "hashCode", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getTitle", "getPlaceholder", "I", "getMaxFilesCount", "F", "getMaxFileSizeMB", "<init>", "(Ljava/lang/String;Ljava/lang/String;IF)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Config {
        @SerializedName("maxFileSizeMB")
        private final float maxFileSizeMB;
        @SerializedName("maxFilesCount")
        private final int maxFilesCount;
        @SerializedName(InternalConstsKt.PLACEHOLDER)
        @Nullable
        private final String placeholder;
        @SerializedName("title")
        @NotNull
        private final String title;

        public Config(@NotNull String str, @Nullable String str2, int i, float f) {
            Intrinsics.checkNotNullParameter(str, "title");
            this.title = str;
            this.placeholder = str2;
            this.maxFilesCount = i;
            this.maxFileSizeMB = f;
        }

        public static /* synthetic */ Config copy$default(Config config, String str, String str2, int i, float f, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = config.title;
            }
            if ((i2 & 2) != 0) {
                str2 = config.placeholder;
            }
            if ((i2 & 4) != 0) {
                i = config.maxFilesCount;
            }
            if ((i2 & 8) != 0) {
                f = config.maxFileSizeMB;
            }
            return config.copy(str, str2, i, f);
        }

        @NotNull
        public final String component1() {
            return this.title;
        }

        @Nullable
        public final String component2() {
            return this.placeholder;
        }

        public final int component3() {
            return this.maxFilesCount;
        }

        public final float component4() {
            return this.maxFileSizeMB;
        }

        @NotNull
        public final Config copy(@NotNull String str, @Nullable String str2, int i, float f) {
            Intrinsics.checkNotNullParameter(str, "title");
            return new Config(str, str2, i, f);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Config)) {
                return false;
            }
            Config config = (Config) obj;
            return Intrinsics.areEqual(this.title, config.title) && Intrinsics.areEqual(this.placeholder, config.placeholder) && this.maxFilesCount == config.maxFilesCount && Float.compare(this.maxFileSizeMB, config.maxFileSizeMB) == 0;
        }

        public final float getMaxFileSizeMB() {
            return this.maxFileSizeMB;
        }

        public final int getMaxFilesCount() {
            return this.maxFilesCount;
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
            return Float.floatToIntBits(this.maxFileSizeMB) + ((((hashCode + i) * 31) + this.maxFilesCount) * 31);
        }

        @NotNull
        public String toString() {
            StringBuilder L = a.L("Config(title=");
            L.append(this.title);
            L.append(", placeholder=");
            L.append(this.placeholder);
            L.append(", maxFilesCount=");
            L.append(this.maxFilesCount);
            L.append(", maxFileSizeMB=");
            L.append(this.maxFileSizeMB);
            L.append(")");
            return L.toString();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\b\b\u0018\u00002\u00020\u0001:\u0001\u001bB\u001d\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ*\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\r\u0010\u0004J\u0010\u0010\u000f\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001c\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0015\u001a\u0004\b\u0016\u0010\u0004R\"\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/avito/android/remote/model/GalleryWidget$Field;", "", "", "component1", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue;", "component2", "()Ljava/util/List;", "name", ResidentialComplexModuleKt.VALUES, "copy", "(Ljava/lang/String;Ljava/util/List;)Lcom/avito/android/remote/model/GalleryWidget$Field;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getName", "Ljava/util/List;", "getValues", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "FieldValue", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
    public static final class Field {
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName(ResidentialComplexModuleKt.VALUES)
        @NotNull
        private final List<FieldValue> values;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001:\u0001 B#\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ2\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0004J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0016\u001a\u00020\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0016\u0010\u0017R\u001e\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u0018\u001a\u0004\b\u0019\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\u001a\u001a\u0004\b\u001b\u0010\u0007R\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;", "component2", "()Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;", "Lcom/avito/android/remote/model/FieldModeration;", "component3", "()Lcom/avito/android/remote/model/FieldModeration;", "valueId", "text", "moderation", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;Lcom/avito/android/remote/model/FieldModeration;)Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Lcom/avito/android/remote/model/FieldModeration;", "getModeration", "Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;", "getText", "Ljava/lang/String;", "getValueId", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;Lcom/avito/android/remote/model/FieldModeration;)V", "ImageValue", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
        public static final class FieldValue {
            @SerializedName("moderation")
            @Nullable
            private final FieldModeration moderation;
            @SerializedName("value")
            @Nullable
            private final ImageValue text;
            @SerializedName("valueId")
            @NotNull
            private final String valueId;

            @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001c\u0010\b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\u0014\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\t\u001a\u00020\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;", "", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/Image;", "component2", "()Lcom/avito/android/remote/model/Image;", "imageId", "image", "copy", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)Lcom/avito/android/remote/model/GalleryWidget$Field$FieldValue$ImageValue;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getImageId", "Lcom/avito/android/remote/model/Image;", "getImage", "<init>", "(Ljava/lang/String;Lcom/avito/android/remote/model/Image;)V", "extended-profile-settings_release"}, k = 1, mv = {1, 4, 2})
            public static final class ImageValue {
                @SerializedName("urls")
                @NotNull
                private final Image image;
                @SerializedName("imageId")
                @NotNull
                private final String imageId;

                public ImageValue(@NotNull String str, @NotNull Image image2) {
                    Intrinsics.checkNotNullParameter(str, "imageId");
                    Intrinsics.checkNotNullParameter(image2, "image");
                    this.imageId = str;
                    this.image = image2;
                }

                public static /* synthetic */ ImageValue copy$default(ImageValue imageValue, String str, Image image2, int i, Object obj) {
                    if ((i & 1) != 0) {
                        str = imageValue.imageId;
                    }
                    if ((i & 2) != 0) {
                        image2 = imageValue.image;
                    }
                    return imageValue.copy(str, image2);
                }

                @NotNull
                public final String component1() {
                    return this.imageId;
                }

                @NotNull
                public final Image component2() {
                    return this.image;
                }

                @NotNull
                public final ImageValue copy(@NotNull String str, @NotNull Image image2) {
                    Intrinsics.checkNotNullParameter(str, "imageId");
                    Intrinsics.checkNotNullParameter(image2, "image");
                    return new ImageValue(str, image2);
                }

                public boolean equals(@Nullable Object obj) {
                    if (this == obj) {
                        return true;
                    }
                    if (!(obj instanceof ImageValue)) {
                        return false;
                    }
                    ImageValue imageValue = (ImageValue) obj;
                    return Intrinsics.areEqual(this.imageId, imageValue.imageId) && Intrinsics.areEqual(this.image, imageValue.image);
                }

                @NotNull
                public final Image getImage() {
                    return this.image;
                }

                @NotNull
                public final String getImageId() {
                    return this.imageId;
                }

                public int hashCode() {
                    String str = this.imageId;
                    int i = 0;
                    int hashCode = (str != null ? str.hashCode() : 0) * 31;
                    Image image2 = this.image;
                    if (image2 != null) {
                        i = image2.hashCode();
                    }
                    return hashCode + i;
                }

                @NotNull
                public String toString() {
                    StringBuilder L = a.L("ImageValue(imageId=");
                    L.append(this.imageId);
                    L.append(", image=");
                    L.append(this.image);
                    L.append(")");
                    return L.toString();
                }
            }

            public FieldValue(@NotNull String str, @Nullable ImageValue imageValue, @Nullable FieldModeration fieldModeration) {
                Intrinsics.checkNotNullParameter(str, "valueId");
                this.valueId = str;
                this.text = imageValue;
                this.moderation = fieldModeration;
            }

            public static /* synthetic */ FieldValue copy$default(FieldValue fieldValue, String str, ImageValue imageValue, FieldModeration fieldModeration, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = fieldValue.valueId;
                }
                if ((i & 2) != 0) {
                    imageValue = fieldValue.text;
                }
                if ((i & 4) != 0) {
                    fieldModeration = fieldValue.moderation;
                }
                return fieldValue.copy(str, imageValue, fieldModeration);
            }

            @NotNull
            public final String component1() {
                return this.valueId;
            }

            @Nullable
            public final ImageValue component2() {
                return this.text;
            }

            @Nullable
            public final FieldModeration component3() {
                return this.moderation;
            }

            @NotNull
            public final FieldValue copy(@NotNull String str, @Nullable ImageValue imageValue, @Nullable FieldModeration fieldModeration) {
                Intrinsics.checkNotNullParameter(str, "valueId");
                return new FieldValue(str, imageValue, fieldModeration);
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
            public final ImageValue getText() {
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
                ImageValue imageValue = this.text;
                int hashCode2 = (hashCode + (imageValue != null ? imageValue.hashCode() : 0)) * 31;
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

        public Field(@NotNull String str, @NotNull List<FieldValue> list) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
            this.name = str;
            this.values = list;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.GalleryWidget$Field */
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

        @NotNull
        public final List<FieldValue> component2() {
            return this.values;
        }

        @NotNull
        public final Field copy(@NotNull String str, @NotNull List<FieldValue> list) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, ResidentialComplexModuleKt.VALUES);
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

        @NotNull
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

    public GalleryWidget(@NotNull Config config2, @Nullable List<Field> list) {
        Intrinsics.checkNotNullParameter(config2, Navigation.CONFIG);
        this.config = config2;
        this.fields = list;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.GalleryWidget */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GalleryWidget copy$default(GalleryWidget galleryWidget, Config config2, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            config2 = galleryWidget.config;
        }
        if ((i & 2) != 0) {
            list = galleryWidget.fields;
        }
        return galleryWidget.copy(config2, list);
    }

    @NotNull
    public final Config component1() {
        return this.config;
    }

    @Nullable
    public final List<Field> component2() {
        return this.fields;
    }

    @NotNull
    public final GalleryWidget copy(@NotNull Config config2, @Nullable List<Field> list) {
        Intrinsics.checkNotNullParameter(config2, Navigation.CONFIG);
        return new GalleryWidget(config2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GalleryWidget)) {
            return false;
        }
        GalleryWidget galleryWidget = (GalleryWidget) obj;
        return Intrinsics.areEqual(this.config, galleryWidget.config) && Intrinsics.areEqual(this.fields, galleryWidget.fields);
    }

    @NotNull
    public final Config getConfig() {
        return this.config;
    }

    @Nullable
    public final List<Field> getFields() {
        return this.fields;
    }

    public int hashCode() {
        Config config2 = this.config;
        int i = 0;
        int hashCode = (config2 != null ? config2.hashCode() : 0) * 31;
        List<Field> list = this.fields;
        if (list != null) {
            i = list.hashCode();
        }
        return hashCode + i;
    }

    @NotNull
    public String toString() {
        StringBuilder L = a.L("GalleryWidget(config=");
        L.append(this.config);
        L.append(", fields=");
        return a.w(L, this.fields, ")");
    }
}
