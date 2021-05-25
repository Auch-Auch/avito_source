package com.sumsub.sns.core.data.model;

import a2.b.a.a.a;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.auth.AuthSource;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.annotations.JsonAdapter;
import com.sumsub.sns.core.common.ExtensionsKt;
import com.sumsub.sns.core.common.SNSConstants;
import java.lang.reflect.Type;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.m;
@Parcelize
@JsonAdapter(Companion.Serializer.class)
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\b\b\u0018\u0000 )2\u00020\u0001:\u0001)B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0004\b'\u0010(J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\u0010\u0010\t\u001a\u00020\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u000e\u0010\nJ\u0010\u0010\u0010\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u001a\u0010\u0015\u001a\u00020\u00142\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0011J \u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001¢\u0006\u0004\b\u001c\u0010\u001dR\u0013\u0010\u001e\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u000b\u001a\u00020\b8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010\nR\u0013\u0010#\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b#\u0010\u001fR\u0013\u0010$\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010\u001fR\u0013\u0010%\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b%\u0010\u001fR\u0013\u0010&\u001a\u00020\u00148F@\u0006¢\u0006\u0006\u001a\u0004\b&\u0010\u001f¨\u0006*"}, d2 = {"Lcom/sumsub/sns/core/data/model/DocumentType;", "Landroid/os/Parcelable;", "Landroid/content/Context;", "context", "", "getTitle", "(Landroid/content/Context;)Ljava/lang/CharSequence;", "getPrompt", "", "component1", "()Ljava/lang/String;", "value", "copy", "(Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/DocumentType;", "toString", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "isPOA", "()Z", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getValue", "isApplicantData", "isIdentity", "isSupported", "isSelfie", "<init>", "(Ljava/lang/String;)V", "Companion", "sns-core_release"}, k = 1, mv = {1, 4, 2})
public final class DocumentType implements Parcelable {
    public static final Parcelable.Creator<DocumentType> CREATOR = new Creator();
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String TYPE_APPLICANT_DATA = "APPLICANT_DATA";
    @NotNull
    public static final String TYPE_IDENTITY = "IDENTITY";
    @NotNull
    public static final String TYPE_INVESTABILITY = "INVESTABILITY";
    @NotNull
    public static final String TYPE_POA = "PROOF_OF_RESIDENCE";
    @NotNull
    public static final String TYPE_SELFIE = "SELFIE";
    @NotNull
    public final String a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0003\u0018\u00002\u00020\u0001:\u0001\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\bR\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\bR\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/sumsub/sns/core/data/model/DocumentType$Companion;", "", "", "value", "Lcom/sumsub/sns/core/data/model/DocumentType;", "create", "(Ljava/lang/String;)Lcom/sumsub/sns/core/data/model/DocumentType;", "TYPE_APPLICANT_DATA", "Ljava/lang/String;", "TYPE_IDENTITY", "TYPE_INVESTABILITY", "TYPE_POA", "TYPE_SELFIE", "<init>", "()V", "Serializer", "sns-core_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J'\u0010\n\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u000f\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/sumsub/sns/core/data/model/DocumentType$Companion$Serializer;", "Lcom/google/gson/JsonSerializer;", "Lcom/sumsub/sns/core/data/model/DocumentType;", "Lcom/google/gson/JsonDeserializer;", "src", "Ljava/lang/reflect/Type;", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "context", "Lcom/google/gson/JsonElement;", "serialize", "(Lcom/sumsub/sns/core/data/model/DocumentType;Ljava/lang/reflect/Type;Lcom/google/gson/JsonSerializationContext;)Lcom/google/gson/JsonElement;", "json", "typeOfT", "Lcom/google/gson/JsonDeserializationContext;", "deserialize", "(Lcom/google/gson/JsonElement;Ljava/lang/reflect/Type;Lcom/google/gson/JsonDeserializationContext;)Lcom/sumsub/sns/core/data/model/DocumentType;", "<init>", "()V", "sns-core_release"}, k = 1, mv = {1, 4, 2})
        public static final class Serializer implements JsonSerializer<DocumentType>, JsonDeserializer<DocumentType> {
            @Override // com.google.gson.JsonDeserializer
            @NotNull
            public DocumentType deserialize(@NotNull JsonElement jsonElement, @NotNull Type type, @NotNull JsonDeserializationContext jsonDeserializationContext) {
                Intrinsics.checkNotNullParameter(jsonElement, "json");
                Intrinsics.checkNotNullParameter(type, "typeOfT");
                Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
                return DocumentType.Companion.create(jsonElement.getAsString());
            }

            @NotNull
            public JsonElement serialize(@NotNull DocumentType documentType, @NotNull Type type, @NotNull JsonSerializationContext jsonSerializationContext) {
                Intrinsics.checkNotNullParameter(documentType, "src");
                Intrinsics.checkNotNullParameter(type, "typeOfSrc");
                Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
                JsonElement serialize = jsonSerializationContext.serialize(documentType.getValue());
                Intrinsics.checkNotNullExpressionValue(serialize, "context.serialize(src.value)");
                return serialize;
            }
        }

        public Companion() {
        }

        @NotNull
        public final DocumentType create(@Nullable String str) {
            if ((str != null && m.startsWith$default(str, DocumentType.TYPE_SELFIE, false, 2, null)) || ((str != null && m.startsWith$default(str, DocumentType.TYPE_IDENTITY, false, 2, null)) || ((str != null && m.startsWith$default(str, DocumentType.TYPE_APPLICANT_DATA, false, 2, null)) || ((str != null && m.startsWith$default(str, DocumentType.TYPE_POA, false, 2, null)) || (str != null && m.startsWith$default(str, DocumentType.TYPE_INVESTABILITY, false, 2, null)))))) {
                return new DocumentType(str);
            }
            if (str != null) {
                return new DocumentType(str);
            }
            throw new IllegalArgumentException("Null document type");
        }

        public Companion(j jVar) {
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<DocumentType> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DocumentType createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            return new DocumentType(parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final DocumentType[] newArray(int i) {
            return new DocumentType[i];
        }
    }

    public DocumentType(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.a = str;
    }

    public static /* synthetic */ DocumentType copy$default(DocumentType documentType, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = documentType.a;
        }
        return documentType.copy(str);
    }

    @NotNull
    public final String component1() {
        return this.a;
    }

    @NotNull
    public final DocumentType copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        return new DocumentType(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(@Nullable Object obj) {
        if (this != obj) {
            return (obj instanceof DocumentType) && Intrinsics.areEqual(this.a, ((DocumentType) obj).a);
        }
        return true;
    }

    @NotNull
    public final CharSequence getPrompt(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = true;
        String format = String.format(SNSConstants.Resources.Key.DOCUMENT_PROMPT, Arrays.copyOf(new Object[]{this.a}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        String stringResource$default = ExtensionsKt.getStringResource$default(context, format, (String) null, 2, (Object) null);
        if (stringResource$default.length() == 0) {
            if (isIdentity()) {
                String format2 = String.format(SNSConstants.Resources.Key.DOCUMENT_PROMPT, Arrays.copyOf(new Object[]{TYPE_IDENTITY}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format2, (String) null, 2, (Object) null);
            } else if (isSelfie()) {
                String format3 = String.format(SNSConstants.Resources.Key.DOCUMENT_PROMPT, Arrays.copyOf(new Object[]{TYPE_SELFIE}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format3, (String) null, 2, (Object) null);
            } else if (isApplicantData()) {
                String format4 = String.format(SNSConstants.Resources.Key.DOCUMENT_PROMPT, Arrays.copyOf(new Object[]{TYPE_APPLICANT_DATA}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format4, (String) null, 2, (Object) null);
            } else {
                str = this.a;
            }
            stringResource$default = str;
        }
        if (stringResource$default.length() != 0) {
            z = false;
        }
        return z ? this.a : ExtensionsKt.asHtml(stringResource$default);
    }

    @NotNull
    public final CharSequence getTitle(@NotNull Context context) {
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        boolean z = true;
        String format = String.format(SNSConstants.Resources.Key.DOCUMENT_TITLE, Arrays.copyOf(new Object[]{this.a}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        String stringResource$default = ExtensionsKt.getStringResource$default(context, format, (String) null, 2, (Object) null);
        if (stringResource$default.length() == 0) {
            if (isIdentity()) {
                String format2 = String.format(SNSConstants.Resources.Key.DOCUMENT_TITLE, Arrays.copyOf(new Object[]{TYPE_IDENTITY}, 1));
                Intrinsics.checkNotNullExpressionValue(format2, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format2, (String) null, 2, (Object) null);
            } else if (isSelfie()) {
                String format3 = String.format(SNSConstants.Resources.Key.DOCUMENT_TITLE, Arrays.copyOf(new Object[]{TYPE_SELFIE}, 1));
                Intrinsics.checkNotNullExpressionValue(format3, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format3, (String) null, 2, (Object) null);
            } else if (isApplicantData()) {
                String format4 = String.format(SNSConstants.Resources.Key.DOCUMENT_TITLE, Arrays.copyOf(new Object[]{TYPE_APPLICANT_DATA}, 1));
                Intrinsics.checkNotNullExpressionValue(format4, "java.lang.String.format(format, *args)");
                str = ExtensionsKt.getStringResource$default(context, format4, (String) null, 2, (Object) null);
            } else {
                str = this.a;
            }
            stringResource$default = str;
        }
        if (stringResource$default.length() != 0) {
            z = false;
        }
        return z ? this.a : ExtensionsKt.asHtml(stringResource$default);
    }

    @NotNull
    public final String getValue() {
        return this.a;
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final boolean isApplicantData() {
        return m.startsWith$default(this.a, TYPE_APPLICANT_DATA, false, 2, null);
    }

    public final boolean isIdentity() {
        return m.startsWith$default(this.a, TYPE_IDENTITY, false, 2, null);
    }

    public final boolean isPOA() {
        return m.startsWith$default(this.a, TYPE_POA, false, 2, null);
    }

    public final boolean isSelfie() {
        return m.startsWith$default(this.a, TYPE_SELFIE, false, 2, null);
    }

    public final boolean isSupported() {
        return isIdentity() || isSelfie() || isPOA() || isApplicantData();
    }

    @Override // java.lang.Object
    @NotNull
    public String toString() {
        return a.t(a.L("DocumentType(value="), this.a, ")");
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeString(this.a);
    }
}
