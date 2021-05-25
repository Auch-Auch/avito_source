package com.avito.android.rating.details.adapter.comment;

import a2.g.r.g;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.rating.details.adapter.RatingDetailsItem;
import com.avito.android.remote.auth.AuthSource;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.TnsGalleryImage;
import com.avito.android.search.map.view.PanelStateKt;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 A2\u00020\u0001:\u0002ABBy\u0012\u0006\u00105\u001a\u00020\t\u0012\u0006\u00108\u001a\u00020\t\u0012\b\u0010(\u001a\u0004\u0018\u00010#\u0012\b\u0010>\u001a\u0004\u0018\u000109\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\t\u0012\b\u0010+\u001a\u0004\u0018\u00010\t\u0012\b\u0010\"\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u000f\u0012\u0010\b\u0002\u00102\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,¢\u0006\u0004\b?\u0010@J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\"\u0010\u0016\u001a\u00020\u000f8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001f\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u000b\u001a\u0004\b\u001e\u0010\rR\u001b\u0010\"\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b \u0010\u000b\u001a\u0004\b!\u0010\rR\u001b\u0010(\u001a\u0004\u0018\u00010#8\u0006@\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u0004\u0018\u00010\t8\u0006@\u0006¢\u0006\f\n\u0004\b)\u0010\u000b\u001a\u0004\b*\u0010\rR!\u00102\u001a\n\u0012\u0004\u0012\u00020-\u0018\u00010,8\u0006@\u0006¢\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101R\u001c\u00105\u001a\u00020\t8\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b3\u0010\u000b\u001a\u0004\b4\u0010\rR\u0019\u00108\u001a\u00020\t8\u0006@\u0006¢\u0006\f\n\u0004\b6\u0010\u000b\u001a\u0004\b7\u0010\rR\u001b\u0010>\u001a\u0004\u0018\u0001098\u0006@\u0006¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=¨\u0006C"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/CommentItem;", "Lcom/avito/android/rating/details/adapter/RatingDetailsItem;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "h", "Ljava/lang/String;", "getPublicationDate", "()Ljava/lang/String;", "publicationDate", "", "j", "Z", "getExpanded", "()Z", "setExpanded", "(Z)V", PanelStateKt.PANEL_EXPANDED, "Lcom/avito/android/rating/details/adapter/comment/CommentItem$Reply;", "i", "Lcom/avito/android/rating/details/adapter/comment/CommentItem$Reply;", "getReply", "()Lcom/avito/android/rating/details/adapter/comment/CommentItem$Reply;", "reply", "e", "getMessage", "message", g.a, "getItem", "item", "", "c", "Ljava/lang/Float;", "getScore", "()Ljava/lang/Float;", "score", "f", "getStage", "stage", "", "Lcom/avito/android/remote/model/TnsGalleryImage;", "k", "Ljava/util/List;", "getImages", "()Ljava/util/List;", "images", AuthSource.SEND_ABUSE, "getStringId", "stringId", AuthSource.BOOKING_ORDER, "getName", "name", "Lcom/avito/android/remote/model/Image;", "d", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/rating/details/adapter/comment/CommentItem$Reply;ZLjava/util/List;)V", "Companion", "Reply", "rating_release"}, k = 1, mv = {1, 4, 2})
public final class CommentItem extends RatingDetailsItem {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<CommentItem> CREATOR = Parcels.creator(a.a);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public final String a;
    @NotNull
    public final String b;
    @Nullable
    public final Float c;
    @Nullable
    public final Image d;
    @Nullable
    public final String e;
    @Nullable
    public final String f;
    @Nullable
    public final String g;
    @Nullable
    public final String h;
    @Nullable
    public final Reply i;
    public boolean j;
    @Nullable
    public final List<TnsGalleryImage> k;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/CommentItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/rating/details/adapter/comment/CommentItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        public Companion() {
        }

        public Companion(j jVar) {
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u001c\u001a\u00020\u000b\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\u0006\u0010\u0019\u001a\u00020\u000b\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b\"\u0010#J\u0010\u0010\u0003\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\t\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nR\u0019\u0010\u0010\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u0019\u0010\u0019\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u000fR\u0019\u0010\u001c\u001a\u00020\u000b8\u0006@\u0006¢\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u000fR\u0019\u0010 \u001a\u00020\u001d8\u0006@\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/avito/android/rating/details/adapter/comment/CommentItem$Reply;", "Landroid/os/Parcelable;", "", "describeContents", "()I", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "", AuthSource.SEND_ABUSE, "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "title", "Lcom/avito/android/remote/model/Image;", "c", "Lcom/avito/android/remote/model/Image;", "getAvatar", "()Lcom/avito/android/remote/model/Image;", "avatar", "d", "getText", "text", AuthSource.BOOKING_ORDER, "getAnswerDate", "answerDate", "", "e", "Z", "isShop", "()Z", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/lang/String;Z)V", "rating_release"}, k = 1, mv = {1, 4, 2})
    public static final class Reply implements Parcelable {
        public static final Parcelable.Creator<Reply> CREATOR = new Creator();
        @NotNull
        public final String a;
        @NotNull
        public final String b;
        @Nullable
        public final Image c;
        @NotNull
        public final String d;
        public final boolean e;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Reply> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Reply createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Reply(parcel.readString(), parcel.readString(), (Image) parcel.readParcelable(Reply.class.getClassLoader()), parcel.readString(), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Reply[] newArray(int i) {
                return new Reply[i];
            }
        }

        public Reply(@NotNull String str, @NotNull String str2, @Nullable Image image, @NotNull String str3, boolean z) {
            a2.b.a.a.a.Z0(str, "title", str2, "answerDate", str3, "text");
            this.a = str;
            this.b = str2;
            this.c = image;
            this.d = str3;
            this.e = z;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NotNull
        public final String getAnswerDate() {
            return this.b;
        }

        @Nullable
        public final Image getAvatar() {
            return this.c;
        }

        @NotNull
        public final String getText() {
            return this.d;
        }

        @NotNull
        public final String getTitle() {
            return this.a;
        }

        public final boolean isShop() {
            return this.e;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.a);
            parcel.writeString(this.b);
            parcel.writeParcelable(this.c, i);
            parcel.writeString(this.d);
            parcel.writeInt(this.e ? 1 : 0);
        }
    }

    public static final class a extends Lambda implements Function1<Parcel, CommentItem> {
        public static final a a = new a();

        public a() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.jvm.functions.Function1
        public CommentItem invoke(Parcel parcel) {
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "$receiver");
            String u2 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            String u22 = a2.b.a.a.a.u2(parcel2, "readString()!!");
            Object readValue = parcel2.readValue(Float.class.getClassLoader());
            if (!(readValue instanceof Float)) {
                readValue = null;
            }
            return new CommentItem(u2, u22, (Float) readValue, (Image) parcel2.readParcelable(Image.class.getClassLoader()), parcel2.readString(), parcel2.readString(), parcel2.readString(), parcel2.readString(), (Reply) parcel2.readParcelable(Reply.class.getClassLoader()), ParcelsKt.readBool(parcel2), ParcelsKt.createParcelableList(parcel2, TnsGalleryImage.class));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CommentItem(String str, String str2, Float f2, Image image, String str3, String str4, String str5, String str6, Reply reply, boolean z, List list, int i2, j jVar) {
        this(str, str2, f2, image, str3, str4, str5, str6, reply, (i2 & 512) != 0 ? false : z, (i2 & 1024) != 0 ? null : list);
    }

    @Nullable
    public final Image getAvatar() {
        return this.d;
    }

    public final boolean getExpanded() {
        return this.j;
    }

    @Nullable
    public final List<TnsGalleryImage> getImages() {
        return this.k;
    }

    @Nullable
    public final String getItem() {
        return this.g;
    }

    @Nullable
    public final String getMessage() {
        return this.e;
    }

    @NotNull
    public final String getName() {
        return this.b;
    }

    @Nullable
    public final String getPublicationDate() {
        return this.h;
    }

    @Nullable
    public final Reply getReply() {
        return this.i;
    }

    @Nullable
    public final Float getScore() {
        return this.c;
    }

    @Nullable
    public final String getStage() {
        return this.f;
    }

    @Override // com.avito.conveyor_item.Item
    @NotNull
    public String getStringId() {
        return this.a;
    }

    public final void setExpanded(boolean z) {
        this.j = z;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(getStringId());
        parcel.writeString(this.b);
        ParcelsKt.writeNullableValue(parcel, this.c);
        parcel.writeParcelable(this.d, i2);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        parcel.writeString(this.g);
        parcel.writeString(this.h);
        parcel.writeParcelable(this.i, i2);
        ParcelsKt.writeBool(parcel, this.j);
        ParcelsKt.writeOptimizedParcelableList(parcel, this.k, i2);
    }

    public CommentItem(@NotNull String str, @NotNull String str2, @Nullable Float f2, @Nullable Image image, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable Reply reply, boolean z, @Nullable List<TnsGalleryImage> list) {
        Intrinsics.checkNotNullParameter(str, "stringId");
        Intrinsics.checkNotNullParameter(str2, "name");
        this.a = str;
        this.b = str2;
        this.c = f2;
        this.d = image;
        this.e = str3;
        this.f = str4;
        this.g = str5;
        this.h = str6;
        this.i = reply;
        this.j = z;
        this.k = list;
    }
}
