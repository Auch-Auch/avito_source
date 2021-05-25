package com.avito.android.remote.model;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0007\b\tB\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0003\u0010\u0004\u0001\u0003\n\u000b\f¨\u0006\r"}, d2 = {"Lcom/avito/android/remote/model/PretendErrorValue;", "", "", "getSingleMessage", "()Ljava/lang/String;", "<init>", "()V", "FieldsMessages", "Message", "ObjectsMessages", "Lcom/avito/android/remote/model/PretendErrorValue$ObjectsMessages;", "Lcom/avito/android/remote/model/PretendErrorValue$FieldsMessages;", "Lcom/avito/android/remote/model/PretendErrorValue$Message;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class PretendErrorValue {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR'\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/PretendErrorValue$FieldsMessages;", "Lcom/avito/android/remote/model/PretendErrorValue;", "", "", "Lcom/avito/android/remote/model/PretendErrorValue$Message;", "value", "Ljava/util/Map;", "getValue", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class FieldsMessages extends PretendErrorValue {
        @Nullable
        private final Map<String, Message> value;

        public FieldsMessages(@Nullable Map<String, Message> map) {
            super(null);
            this.value = map;
        }

        @Nullable
        public final Map<String, Message> getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/PretendErrorValue$Message;", "Lcom/avito/android/remote/model/PretendErrorValue;", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Message extends PretendErrorValue {
        @SerializedName("message")
        @Nullable
        private final String message;

        public Message() {
            this(null, 1, null);
        }

        public Message(@Nullable String str) {
            super(null);
            this.message = str;
        }

        @Nullable
        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Message(String str, int i, j jVar) {
            this((i & 1) != 0 ? null : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B)\u0012 \u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\u0002¢\u0006\u0004\b\t\u0010\nR3\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00020\u0003\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u0002\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/PretendErrorValue$ObjectsMessages;", "Lcom/avito/android/remote/model/PretendErrorValue;", "", "", "", "objectsErrorParams", "Ljava/util/Map;", "getObjectsErrorParams", "()Ljava/util/Map;", "<init>", "(Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ObjectsMessages extends PretendErrorValue {
        @Nullable
        private final Map<Integer, Map<String, PretendErrorValue>> objectsErrorParams;

        /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.Map<java.lang.Integer, ? extends java.util.Map<java.lang.String, ? extends com.avito.android.remote.model.PretendErrorValue>> */
        /* JADX WARN: Multi-variable type inference failed */
        public ObjectsMessages(@Nullable Map<Integer, ? extends Map<String, ? extends PretendErrorValue>> map) {
            super(null);
            this.objectsErrorParams = map;
        }

        @Nullable
        public final Map<Integer, Map<String, PretendErrorValue>> getObjectsErrorParams() {
            return this.objectsErrorParams;
        }
    }

    private PretendErrorValue() {
    }

    @Nullable
    public final String getSingleMessage() {
        if (this instanceof Message) {
            return ((Message) this).getMessage();
        }
        return null;
    }

    public /* synthetic */ PretendErrorValue(j jVar) {
        this();
    }
}
