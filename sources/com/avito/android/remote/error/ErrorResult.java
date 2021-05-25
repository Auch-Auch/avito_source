package com.avito.android.remote.error;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.deep_linking.links.DeepLink;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.UserDialog;
import com.facebook.internal.NativeProtocol;
import com.google.gson.annotations.SerializedName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u00012\u00020\u0002:\u000b\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005\u0001\u000b\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d¨\u0006\u001e"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult;", "Lcom/avito/android/remote/error/ErrorWithMessage;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "<init>", "()V", "BadRequest", "ErrorAction", "ErrorDialog", "Forbidden", "IncorrectData", "InternalError", "NetworkIOError", "Unauthenticated", "Unauthorized", NativeProtocol.ERROR_UNKNOWN_ERROR, "UnknownStatusError", "Lcom/avito/android/remote/error/ErrorResult$Unauthorized;", "Lcom/avito/android/remote/error/ErrorResult$Unauthenticated;", "Lcom/avito/android/remote/error/ErrorResult$BadRequest;", "Lcom/avito/android/remote/error/ErrorResult$InternalError;", "Lcom/avito/android/remote/error/ErrorResult$UnknownStatusError;", "Lcom/avito/android/remote/error/ErrorResult$NetworkIOError;", "Lcom/avito/android/remote/error/ErrorResult$UnknownError;", "Lcom/avito/android/remote/error/ErrorResult$Forbidden;", "Lcom/avito/android/remote/error/ErrorResult$IncorrectData;", "Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "Lcom/avito/android/remote/error/ErrorResult$ErrorAction;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ErrorResult implements ErrorWithMessage, Parcelable {

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$BadRequest;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$BadRequest;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class BadRequest extends ErrorResult {
        public static final Parcelable.Creator<BadRequest> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<BadRequest> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BadRequest createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new BadRequest(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final BadRequest[] newArray(int i) {
                return new BadRequest[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public BadRequest(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ BadRequest copy$default(BadRequest badRequest, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = badRequest.getMessage();
            }
            return badRequest.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final BadRequest copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new BadRequest(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof BadRequest) && Intrinsics.areEqual(getMessage(), ((BadRequest) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("BadRequest(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001c\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$ErrorAction;", "Lcom/avito/android/remote/error/ErrorResult;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component1", "()Lcom/avito/android/deep_linking/links/DeepLink;", "action", "copy", "(Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/error/ErrorResult$ErrorAction;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getAction", "getMessage", "message", "<init>", "(Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorAction extends ErrorResult {
        public static final Parcelable.Creator<ErrorAction> CREATOR = new Creator();
        @SerializedName("action")
        @NotNull
        private final DeepLink action;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ErrorAction> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ErrorAction createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ErrorAction((DeepLink) parcel.readParcelable(ErrorAction.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ErrorAction[] newArray(int i) {
                return new ErrorAction[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorAction(@NotNull DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(deepLink, "action");
            this.action = deepLink;
        }

        public static /* synthetic */ ErrorAction copy$default(ErrorAction errorAction, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                deepLink = errorAction.action;
            }
            return errorAction.copy(deepLink);
        }

        @NotNull
        public final DeepLink component1() {
            return this.action;
        }

        @NotNull
        public final ErrorAction copy(@NotNull DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(deepLink, "action");
            return new ErrorAction(deepLink);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ErrorAction) && Intrinsics.areEqual(this.action, ((ErrorAction) obj).action);
            }
            return true;
        }

        @NotNull
        public final DeepLink getAction() {
            return this.action;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return "Action";
        }

        @Override // java.lang.Object
        public int hashCode() {
            DeepLink deepLink = this.action;
            if (deepLink != null) {
                return deepLink.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.m(a.L("ErrorAction(action="), this.action, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.action, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001a\u001a\u00020\b8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\nR\u001c\u0010\u0005\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0004¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "Lcom/avito/android/remote/error/ErrorResult;", "Lcom/avito/android/remote/model/UserDialog;", "component1", "()Lcom/avito/android/remote/model/UserDialog;", "userDialog", "copy", "(Lcom/avito/android/remote/model/UserDialog;)Lcom/avito/android/remote/error/ErrorResult$ErrorDialog;", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "getMessage", "message", "Lcom/avito/android/remote/model/UserDialog;", "getUserDialog", "<init>", "(Lcom/avito/android/remote/model/UserDialog;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class ErrorDialog extends ErrorResult {
        public static final Parcelable.Creator<ErrorDialog> CREATOR = new Creator();
        @SerializedName("userDialog")
        @NotNull
        private final UserDialog userDialog;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<ErrorDialog> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ErrorDialog createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new ErrorDialog((UserDialog) parcel.readParcelable(ErrorDialog.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final ErrorDialog[] newArray(int i) {
                return new ErrorDialog[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ErrorDialog(@NotNull UserDialog userDialog2) {
            super(null);
            Intrinsics.checkNotNullParameter(userDialog2, "userDialog");
            this.userDialog = userDialog2;
        }

        public static /* synthetic */ ErrorDialog copy$default(ErrorDialog errorDialog, UserDialog userDialog2, int i, Object obj) {
            if ((i & 1) != 0) {
                userDialog2 = errorDialog.userDialog;
            }
            return errorDialog.copy(userDialog2);
        }

        @NotNull
        public final UserDialog component1() {
            return this.userDialog;
        }

        @NotNull
        public final ErrorDialog copy(@NotNull UserDialog userDialog2) {
            Intrinsics.checkNotNullParameter(userDialog2, "userDialog");
            return new ErrorDialog(userDialog2);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof ErrorDialog) && Intrinsics.areEqual(this.userDialog, ((ErrorDialog) obj).userDialog);
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            String message = this.userDialog.getMessage();
            if (!(message.length() > 0)) {
                message = null;
            }
            return message != null ? message : this.userDialog.getTitle();
        }

        @NotNull
        public final UserDialog getUserDialog() {
            return this.userDialog;
        }

        @Override // java.lang.Object
        public int hashCode() {
            UserDialog userDialog2 = this.userDialog;
            if (userDialog2 != null) {
                return userDialog2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ErrorDialog(userDialog=");
            L.append(this.userDialog);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeParcelable(this.userDialog, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J&\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\f\u0010\u0004J\u0010\u0010\u000e\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u000e\u0010\u000fJ\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J \u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\rHÖ\u0001¢\u0006\u0004\b\u0019\u0010\u001aR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\t\u0010\u001b\u001a\u0004\b\u001c\u0010\u0007R\u001c\u0010\b\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u0004¨\u0006!"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$Forbidden;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "Lcom/avito/android/deep_linking/links/DeepLink;", "component2", "()Lcom/avito/android/deep_linking/links/DeepLink;", "message", "link", "copy", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)Lcom/avito/android/remote/error/ErrorResult$Forbidden;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/deep_linking/links/DeepLink;", "getLink", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;Lcom/avito/android/deep_linking/links/DeepLink;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Forbidden extends ErrorResult {
        public static final Parcelable.Creator<Forbidden> CREATOR = new Creator();
        @SerializedName("link")
        @Nullable
        private final DeepLink link;
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Forbidden> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Forbidden createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Forbidden(parcel.readString(), (DeepLink) parcel.readParcelable(Forbidden.class.getClassLoader()));
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Forbidden[] newArray(int i) {
                return new Forbidden[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Forbidden(@NotNull String str, @Nullable DeepLink deepLink) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.link = deepLink;
        }

        public static /* synthetic */ Forbidden copy$default(Forbidden forbidden, String str, DeepLink deepLink, int i, Object obj) {
            if ((i & 1) != 0) {
                str = forbidden.getMessage();
            }
            if ((i & 2) != 0) {
                deepLink = forbidden.link;
            }
            return forbidden.copy(str, deepLink);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final DeepLink component2() {
            return this.link;
        }

        @NotNull
        public final Forbidden copy(@NotNull String str, @Nullable DeepLink deepLink) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Forbidden(str, deepLink);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Forbidden)) {
                return false;
            }
            Forbidden forbidden = (Forbidden) obj;
            return Intrinsics.areEqual(getMessage(), forbidden.getMessage()) && Intrinsics.areEqual(this.link, forbidden.link);
        }

        @Nullable
        public final DeepLink getLink() {
            return this.link;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            int i = 0;
            int hashCode = (message2 != null ? message2.hashCode() : 0) * 31;
            DeepLink deepLink = this.link;
            if (deepLink != null) {
                i = deepLink.hashCode();
            }
            return hashCode + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Forbidden(message=");
            L.append(getMessage());
            L.append(", link=");
            return a.m(L, this.link, ")");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
            parcel.writeParcelable(this.link, i);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J&\u0010\u0007\u001a\u00020\u00002\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018R(\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0019\u001a\u0004\b\u001a\u0010\u0005R\u0016\u0010\u001c\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\n¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$IncorrectData;", "Lcom/avito/android/remote/error/ErrorResult;", "", "", "component1", "()Ljava/util/Map;", "messages", "copy", "(Ljava/util/Map;)Lcom/avito/android/remote/error/ErrorResult$IncorrectData;", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/util/Map;", "getMessages", "getMessage", "message", "<init>", "(Ljava/util/Map;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class IncorrectData extends ErrorResult {
        public static final Parcelable.Creator<IncorrectData> CREATOR = new Creator();
        @SerializedName("messages")
        @NotNull
        private final Map<String, String> messages;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<IncorrectData> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final IncorrectData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                LinkedHashMap linkedHashMap = new LinkedHashMap(readInt);
                while (readInt != 0) {
                    readInt = a.U(parcel, linkedHashMap, parcel.readString(), readInt, -1);
                }
                return new IncorrectData(linkedHashMap);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final IncorrectData[] newArray(int i) {
                return new IncorrectData[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public IncorrectData(@NotNull Map<String, String> map) {
            super(null);
            Intrinsics.checkNotNullParameter(map, "messages");
            this.messages = map;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.error.ErrorResult$IncorrectData */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ IncorrectData copy$default(IncorrectData incorrectData, Map map, int i, Object obj) {
            if ((i & 1) != 0) {
                map = incorrectData.messages;
            }
            return incorrectData.copy(map);
        }

        @NotNull
        public final Map<String, String> component1() {
            return this.messages;
        }

        @NotNull
        public final IncorrectData copy(@NotNull Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "messages");
            return new IncorrectData(map);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof IncorrectData) && Intrinsics.areEqual(this.messages, ((IncorrectData) obj).messages);
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.messages.isEmpty() ^ true ? (String) CollectionsKt___CollectionsKt.first(this.messages.values()) : "";
        }

        @NotNull
        public final Map<String, String> getMessages() {
            return this.messages;
        }

        @Override // java.lang.Object
        public int hashCode() {
            Map<String, String> map = this.messages;
            if (map != null) {
                return map.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.x(a.L("IncorrectData(messages="), this.messages, ")");
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Map$Entry, java.lang.Object] */
        /* JADX WARNING: Unknown variable types count: 1 */
        @Override // android.os.Parcelable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void writeToParcel(@org.jetbrains.annotations.NotNull android.os.Parcel r3, int r4) {
            /*
                r2 = this;
                java.lang.String r4 = "parcel"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r4)
                java.util.Map<java.lang.String, java.lang.String> r4 = r2.messages
                java.util.Iterator r4 = a2.b.a.a.a.o0(r4, r3)
            L_0x000b:
                boolean r0 = r4.hasNext()
                if (r0 == 0) goto L_0x0028
                java.lang.Object r0 = r4.next()
                java.lang.Object r1 = r0.getKey()
                java.lang.String r1 = (java.lang.String) r1
                r3.writeString(r1)
                java.lang.Object r0 = r0.getValue()
                java.lang.String r0 = (java.lang.String) r0
                r3.writeString(r0)
                goto L_0x000b
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.avito.android.remote.error.ErrorResult.IncorrectData.writeToParcel(android.os.Parcel, int):void");
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$InternalError;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$InternalError;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class InternalError extends ErrorResult {
        public static final Parcelable.Creator<InternalError> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<InternalError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InternalError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new InternalError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final InternalError[] newArray(int i) {
                return new InternalError[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InternalError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ InternalError copy$default(InternalError internalError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = internalError.getMessage();
            }
            return internalError.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final InternalError copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new InternalError(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof InternalError) && Intrinsics.areEqual(getMessage(), ((InternalError) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("InternalError(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$NetworkIOError;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$NetworkIOError;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class NetworkIOError extends ErrorResult {
        public static final Parcelable.Creator<NetworkIOError> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<NetworkIOError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NetworkIOError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new NetworkIOError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final NetworkIOError[] newArray(int i) {
                return new NetworkIOError[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NetworkIOError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ NetworkIOError copy$default(NetworkIOError networkIOError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = networkIOError.getMessage();
            }
            return networkIOError.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final NetworkIOError copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new NetworkIOError(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof NetworkIOError) && Intrinsics.areEqual(getMessage(), ((NetworkIOError) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("NetworkIOError(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$Unauthenticated;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$Unauthenticated;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unauthenticated extends ErrorResult {
        public static final Parcelable.Creator<Unauthenticated> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Unauthenticated> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unauthenticated createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Unauthenticated(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unauthenticated[] newArray(int i) {
                return new Unauthenticated[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unauthenticated(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Unauthenticated copy$default(Unauthenticated unauthenticated, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unauthenticated.getMessage();
            }
            return unauthenticated.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final Unauthenticated copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Unauthenticated(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Unauthenticated) && Intrinsics.areEqual(getMessage(), ((Unauthenticated) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Unauthenticated(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$Unauthorized;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$Unauthorized;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unauthorized extends ErrorResult {
        public static final Parcelable.Creator<Unauthorized> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Unauthorized> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unauthorized createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Unauthorized(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unauthorized[] newArray(int i) {
                return new Unauthorized[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unauthorized(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ Unauthorized copy$default(Unauthorized unauthorized, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unauthorized.getMessage();
            }
            return unauthorized.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final Unauthorized copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new Unauthorized(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Unauthorized) && Intrinsics.areEqual(getMessage(), ((Unauthorized) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("Unauthorized(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b$\u0010%J\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ2\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\t\u001a\u00020\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000e\u0010\u0004J\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J \u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cR\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010\bR\u001c\u0010\t\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\t\u0010 \u001a\u0004\b!\u0010\u0004R\u001b\u0010\n\u001a\u0004\u0018\u00010\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\"\u0010 \u001a\u0004\b#\u0010\u0004¨\u0006&"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$UnknownError;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "component2", "", "component3", "()Ljava/lang/Throwable;", "message", "debugInfo", "debugThrowable", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)Lcom/avito/android/remote/error/ErrorResult$UnknownError;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", AuthSource.BOOKING_ORDER, "Ljava/lang/Throwable;", "getDebugThrowable", "Ljava/lang/String;", "getMessage", AuthSource.SEND_ABUSE, "getDebugInfo", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnknownError extends ErrorResult {
        public static final Parcelable.Creator<UnknownError> CREATOR = new Creator();
        @Nullable
        public final String a;
        @Nullable
        public final Throwable b;
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UnknownError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UnknownError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new UnknownError(parcel.readString(), parcel.readString(), (Throwable) parcel.readSerializable());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UnknownError[] newArray(int i) {
                return new UnknownError[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UnknownError(String str, String str2, Throwable th, int i, j jVar) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : th);
        }

        public static /* synthetic */ UnknownError copy$default(UnknownError unknownError, String str, String str2, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownError.getMessage();
            }
            if ((i & 2) != 0) {
                str2 = unknownError.a;
            }
            if ((i & 4) != 0) {
                th = unknownError.b;
            }
            return unknownError.copy(str, str2, th);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @Nullable
        public final String component2() {
            return this.a;
        }

        @Nullable
        public final Throwable component3() {
            return this.b;
        }

        @NotNull
        public final UnknownError copy(@NotNull String str, @Nullable String str2, @Nullable Throwable th) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new UnknownError(str, str2, th);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UnknownError)) {
                return false;
            }
            UnknownError unknownError = (UnknownError) obj;
            return Intrinsics.areEqual(getMessage(), unknownError.getMessage()) && Intrinsics.areEqual(this.a, unknownError.a) && Intrinsics.areEqual(this.b, unknownError.b);
        }

        @Nullable
        public final String getDebugInfo() {
            return this.a;
        }

        @Nullable
        public final Throwable getDebugThrowable() {
            return this.b;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            int i = 0;
            int hashCode = (message2 != null ? message2.hashCode() : 0) * 31;
            String str = this.a;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            Throwable th = this.b;
            if (th != null) {
                i = th.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("UnknownError(message=");
            L.append(getMessage());
            L.append(", debugInfo=");
            L.append(this.a);
            L.append(", debugThrowable=");
            L.append(this.b);
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
            parcel.writeString(this.a);
            parcel.writeSerializable(this.b);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnknownError(@NotNull String str, @Nullable String str2, @Nullable Throwable th) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
            this.a = str2;
            this.b = th;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0005\u001a\u00020\u00028\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0017\u001a\u0004\b\u0018\u0010\u0004¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/error/ErrorResult$UnknownStatusError;", "Lcom/avito/android/remote/error/ErrorResult;", "", "component1", "()Ljava/lang/String;", "message", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/error/ErrorResult$UnknownStatusError;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getMessage", "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class UnknownStatusError extends ErrorResult {
        public static final Parcelable.Creator<UnknownStatusError> CREATOR = new Creator();
        @SerializedName("message")
        @NotNull
        private final String message;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UnknownStatusError> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UnknownStatusError createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new UnknownStatusError(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UnknownStatusError[] newArray(int i) {
                return new UnknownStatusError[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UnknownStatusError(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "message");
            this.message = str;
        }

        public static /* synthetic */ UnknownStatusError copy$default(UnknownStatusError unknownStatusError, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknownStatusError.getMessage();
            }
            return unknownStatusError.copy(str);
        }

        @NotNull
        public final String component1() {
            return getMessage();
        }

        @NotNull
        public final UnknownStatusError copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "message");
            return new UnknownStatusError(str);
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof UnknownStatusError) && Intrinsics.areEqual(getMessage(), ((UnknownStatusError) obj).getMessage());
            }
            return true;
        }

        @Override // com.avito.android.remote.error.ErrorWithMessage
        @NotNull
        public String getMessage() {
            return this.message;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String message2 = getMessage();
            if (message2 != null) {
                return message2.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("UnknownStatusError(message=");
            L.append(getMessage());
            L.append(")");
            return L.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.message);
        }
    }

    public ErrorResult() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ErrorResult(j jVar) {
    }
}
