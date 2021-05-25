package com.sumsub.sns.core.data.model;

import com.avito.android.remote.auth.AuthSource;
import com.sumsub.sns.core.data.model.SNSException;
import java.io.Serializable;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import ru.ok.android.sdk.OkListener;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/sumsub/sns/core/data/model/Error;", "Ljava/io/Serializable;", "<init>", "()V", "Common", "Init", "Network", "Upload", "Lcom/sumsub/sns/core/data/model/Error$Network;", "Lcom/sumsub/sns/core/data/model/Error$Upload;", "Lcom/sumsub/sns/core/data/model/Error$Common;", "Lcom/sumsub/sns/core/data/model/Error$Init;", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public abstract class Error implements Serializable {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/data/model/Error$Common;", "Lcom/sumsub/sns/core/data/model/Error;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AuthSource.SEND_ABUSE, "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Common extends Error {
        @Nullable
        public final Exception a;

        public Common() {
            this(null, 1, null);
        }

        public Common(@Nullable Exception exc) {
            super(null);
            this.a = exc;
        }

        @Nullable
        public final Exception getException() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Common(Exception exc, int i, j jVar) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/data/model/Error$Init;", "Lcom/sumsub/sns/core/data/model/Error;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AuthSource.SEND_ABUSE, "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Init extends Error {
        @Nullable
        public final Exception a;

        public Init() {
            this(null, 1, null);
        }

        public Init(@Nullable Exception exc) {
            super(null);
            this.a = exc;
        }

        @Nullable
        public final Exception getException() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Init(Exception exc, int i, j jVar) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u0003¢\u0006\u0004\b\t\u0010\nR!\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038\u0006@\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/sumsub/sns/core/data/model/Error$Network;", "Lcom/sumsub/sns/core/data/model/Error;", "Ljava/lang/Exception;", "Lkotlin/Exception;", AuthSource.SEND_ABUSE, "Ljava/lang/Exception;", "getException", "()Ljava/lang/Exception;", OkListener.KEY_EXCEPTION, "<init>", "(Ljava/lang/Exception;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Network extends Error {
        @Nullable
        public final Exception a;

        public Network() {
            this(null, 1, null);
        }

        public Network(@Nullable Exception exc) {
            super(null);
            this.a = exc;
        }

        @Nullable
        public final Exception getException() {
            return this.a;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Network(Exception exc, int i, j jVar) {
            this((i & 1) != 0 ? null : exc);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\b\u0010\r\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/data/model/Error$Upload;", "Lcom/sumsub/sns/core/data/model/Error;", "Lcom/sumsub/sns/core/data/model/SNSException$Api;", AuthSource.BOOKING_ORDER, "Lcom/sumsub/sns/core/data/model/SNSException$Api;", "getException", "()Lcom/sumsub/sns/core/data/model/SNSException$Api;", OkListener.KEY_EXCEPTION, "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getDescription", "()Ljava/lang/String;", "description", "<init>", "(Ljava/lang/String;Lcom/sumsub/sns/core/data/model/SNSException$Api;)V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Upload extends Error {
        @Nullable
        public final String a;
        @Nullable
        public final SNSException.Api b;

        public Upload(@Nullable String str, @Nullable SNSException.Api api) {
            super(null);
            this.a = str;
            this.b = api;
        }

        @Nullable
        public final String getDescription() {
            return this.a;
        }

        @Nullable
        public final SNSException.Api getException() {
            return this.b;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Upload(String str, SNSException.Api api, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : api);
        }
    }

    public Error() {
    }

    public Error(j jVar) {
    }
}
