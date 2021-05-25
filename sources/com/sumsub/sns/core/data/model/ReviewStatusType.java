package com.sumsub.sns.core.data.model;

import com.avito.android.remote.auth.AuthSource;
import com.facebook.internal.AnalyticsEvents;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@JsonAdapter(Companion.Serializer.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "value", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "Init", "Queued", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED, "Pending", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "sns-core_release"}, k = 1, mv = {1, 4, 2})
public enum ReviewStatusType {
    Init("init"),
    Queued("queued"),
    Completed("completed"),
    Pending("pending"),
    Unknown("unknown");
    
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001:\u0001\tB\t\b\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/sumsub/sns/core/data/model/ReviewStatusType$Companion;", "", "", "value", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "get", "(Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "<init>", "()V", "Serializer", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/data/model/ReviewStatusType$Companion$Serializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/sumsub/sns/core/data/model/ReviewStatusType;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/sumsub/sns/core/data/model/ReviewStatusType;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Serializer implements JsonSerializer<ReviewStatusType>, JsonDeserializer<ReviewStatusType> {
            @Override // com.google.gson.JsonDeserializer
            @NotNull
            public ReviewStatusType deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
                Intrinsics.checkNotNullParameter(jsonElement, "json");
                Intrinsics.checkNotNullParameter(type, "typeOfT");
                Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
                Companion companion = ReviewStatusType.Companion;
                String asString = jsonElement.getAsString();
                Intrinsics.checkNotNullExpressionValue(asString, "json.asString");
                return companion.get(asString);
            }

            @NotNull
            public JsonElement serialize(@NotNull ReviewStatusType reviewStatusType, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
                Intrinsics.checkNotNullParameter(reviewStatusType, "src");
                Intrinsics.checkNotNullParameter(type, "typeOfSrc");
                Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
                JsonElement serialize = jsonSerializationContext.serialize(reviewStatusType.getValue());
                Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src.value)");
                return serialize;
            }
        }

        public Companion() {
        }

        @NotNull
        public final ReviewStatusType get(@NotNull String str) {
            ReviewStatusType reviewStatusType;
            Intrinsics.checkNotNullParameter(str, "value");
            ReviewStatusType[] values = ReviewStatusType.values();
            int i = 0;
            while (true) {
                if (i >= 5) {
                    reviewStatusType = null;
                    break;
                }
                reviewStatusType = values[i];
                if (Intrinsics.areEqual(reviewStatusType.getValue(), str)) {
                    break;
                }
                i++;
            }
            return reviewStatusType != null ? reviewStatusType : ReviewStatusType.Unknown;
        }

        public Companion(j jVar) {
        }
    }

    /* access modifiers changed from: public */
    ReviewStatusType(String str) {
        this.a = str;
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }
}
