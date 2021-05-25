package com.avito.android.remote.model;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.google.gson.annotations.SerializedName;
import com.vk.sdk.api.model.VKScopes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
@Parcelize
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0007\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB-\u0012\u0006\u0010\u0011\u001a\u00020\u0002\u0012\u0006\u0010\u0019\u001a\u00020\u0014\u0012\u0006\u0010\u0015\u001a\u00020\u0014\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0004R\u001c\u0010\u0015\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u00020\u00148\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0016\u001a\u0004\b\u001a\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/avito/android/remote/model/Questionnaire;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "Lcom/avito/android/remote/model/Questionnaire$Question;", VKScopes.QUESTIONS, "Ljava/util/List;", "getQuestions", "()Ljava/util/List;", "id", "I", "getId", "", "completeText", "Ljava/lang/String;", "getCompleteText", "()Ljava/lang/String;", "title", "getTitle", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "Answer", "Question", "models_release"}, k = 1, mv = {1, 4, 2})
public final class Questionnaire implements Parcelable {
    public static final Parcelable.Creator<Questionnaire> CREATOR = new Creator();
    @SerializedName("completeText")
    @NotNull
    private final String completeText;
    @SerializedName("id")
    private final int id;
    @SerializedName(VKScopes.QUESTIONS)
    @NotNull
    private final List<Question> questions;
    @SerializedName("title")
    @NotNull
    private final String title;

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u00020\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/avito/android/remote/model/Questionnaire$Answer;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "id", "I", "getId", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", DecodeProducer.EXTRA_IS_FINAL, "Z", "()Z", "<init>", "(ILjava/lang/String;Z)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Answer implements Parcelable {
        public static final Parcelable.Creator<Answer> CREATOR = new Creator();
        @SerializedName("id")
        private final int id;
        @SerializedName(DecodeProducer.EXTRA_IS_FINAL)
        private final boolean isFinal;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Answer> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Answer createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Answer(parcel.readInt(), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Answer[] newArray(int i) {
                return new Answer[i];
            }
        }

        public Answer(int i, @NotNull String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "text");
            this.id = i;
            this.text = str;
            this.isFinal = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        public final boolean isFinal() {
            return this.isFinal;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.id);
            parcel.writeString(this.text);
            parcel.writeInt(this.isFinal ? 1 : 0);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
    public static class Creator implements Parcelable.Creator<Questionnaire> {
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Questionnaire createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "in");
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt2);
            while (readInt2 != 0) {
                arrayList.add(Question.CREATOR.createFromParcel(parcel));
                readInt2--;
            }
            return new Questionnaire(readInt, readString, readString2, arrayList);
        }

        @Override // android.os.Parcelable.Creator
        @NotNull
        public final Questionnaire[] newArray(int i) {
            return new Questionnaire[i];
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u0004R\u001c\u0010\u000f\u001a\u00020\u000e8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/avito/android/remote/model/Questionnaire$Question;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "id", "I", "getId", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "", "Lcom/avito/android/remote/model/Questionnaire$Answer;", "answers", "Ljava/util/List;", "getAnswers", "()Ljava/util/List;", "<init>", "(ILjava/lang/String;Ljava/util/List;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Question implements Parcelable {
        public static final Parcelable.Creator<Question> CREATOR = new Creator();
        @SerializedName("answers")
        @NotNull
        private final List<Answer> answers;
        @SerializedName("id")
        private final int id;
        @SerializedName("text")
        @NotNull
        private final String text;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Question> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Question createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                int readInt2 = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt2);
                while (readInt2 != 0) {
                    arrayList.add(Answer.CREATOR.createFromParcel(parcel));
                    readInt2--;
                }
                return new Question(readInt, readString, arrayList);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Question[] newArray(int i) {
                return new Question[i];
            }
        }

        public Question(int i, @NotNull String str, @NotNull List<Answer> list) {
            Intrinsics.checkNotNullParameter(str, "text");
            Intrinsics.checkNotNullParameter(list, "answers");
            this.id = i;
            this.text = str;
            this.answers = list;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final List<Answer> getAnswers() {
            return this.answers;
        }

        public final int getId() {
            return this.id;
        }

        @NotNull
        public final String getText() {
            return this.text;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeInt(this.id);
            parcel.writeString(this.text);
            Iterator n0 = a.n0(this.answers, parcel);
            while (n0.hasNext()) {
                ((Answer) n0.next()).writeToParcel(parcel, 0);
            }
        }
    }

    public Questionnaire(int i, @NotNull String str, @NotNull String str2, @NotNull List<Question> list) {
        a.c1(str, "title", str2, "completeText", list, VKScopes.QUESTIONS);
        this.id = i;
        this.title = str;
        this.completeText = str2;
        this.questions = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @NotNull
    public final String getCompleteText() {
        return this.completeText;
    }

    public final int getId() {
        return this.id;
    }

    @NotNull
    public final List<Question> getQuestions() {
        return this.questions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "parcel");
        parcel.writeInt(this.id);
        parcel.writeString(this.title);
        parcel.writeString(this.completeText);
        Iterator n0 = a.n0(this.questions, parcel);
        while (n0.hasNext()) {
            ((Question) n0.next()).writeToParcel(parcel, 0);
        }
    }
}
