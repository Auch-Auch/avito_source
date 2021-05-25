package com.avito.android.remote.model;

import com.avito.android.remote.model.text.AttributedText;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.webrtc.PeerConnectionFactory;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/PublishAnonymousNumber;", "", "<init>", "()V", "Empty", PeerConnectionFactory.TRIAL_ENABLED, "Required", "Lcom/avito/android/remote/model/PublishAnonymousNumber$Empty;", "Lcom/avito/android/remote/model/PublishAnonymousNumber$Enabled;", "Lcom/avito/android/remote/model/PublishAnonymousNumber$Required;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class PublishAnonymousNumber {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/remote/model/PublishAnonymousNumber$Empty;", "Lcom/avito/android/remote/model/PublishAnonymousNumber;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Empty extends PublishAnonymousNumber {
        @NotNull
        public static final Empty INSTANCE = new Empty();

        private Empty() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u00020\u00078\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u00020\f8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/PublishAnonymousNumber$Enabled;", "Lcom/avito/android/remote/model/PublishAnonymousNumber;", "", "title", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/text/AttributedText;", "description", "Lcom/avito/android/remote/model/text/AttributedText;", "getDescription", "()Lcom/avito/android/remote/model/text/AttributedText;", "", "value", "Z", "getValue", "()Z", "<init>", "(Lcom/avito/android/remote/model/text/AttributedText;Ljava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Enabled extends PublishAnonymousNumber {
        @SerializedName("description")
        @NotNull
        private final AttributedText description;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName("value")
        private final boolean value;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Enabled(@NotNull AttributedText attributedText, @NotNull String str, boolean z) {
            super(null);
            Intrinsics.checkNotNullParameter(attributedText, "description");
            Intrinsics.checkNotNullParameter(str, "title");
            this.description = attributedText;
            this.title = str;
            this.value = z;
        }

        @NotNull
        public final AttributedText getDescription() {
            return this.description;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/avito/android/remote/model/PublishAnonymousNumber$Required;", "Lcom/avito/android/remote/model/PublishAnonymousNumber;", "", "value", "Z", "getValue", "()Z", "<init>", "(Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Required extends PublishAnonymousNumber {
        @SerializedName("value")
        private final boolean value;

        public Required(boolean z) {
            super(null);
            this.value = z;
        }

        public final boolean getValue() {
            return this.value;
        }
    }

    private PublishAnonymousNumber() {
    }

    public /* synthetic */ PublishAnonymousNumber(j jVar) {
        this();
    }
}
