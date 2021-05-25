package com.avito.android.remote.model.section;

import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Action;
import com.avito.android.util.Parcels;
import com.avito.android.util.ParcelsKt;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 (2\u00020\u0001:\u0001(BQ\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u001b\u0012\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 \u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b&\u0010'J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u00108\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0012\u001a\u0004\b\u001a\u0010\u0014R\u001e\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\"\u0010\"\u001a\b\u0012\u0004\u0012\u00020!0 8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%¨\u0006)"}, d2 = {"Lcom/avito/android/remote/model/section/SectionTypeItem;", "Lcom/avito/android/remote/model/section/SectionTypeElement;", "Landroid/os/Parcel;", "dest", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Lcom/avito/android/remote/model/section/SectionDisplaying;", "displaying", "Lcom/avito/android/remote/model/section/SectionDisplaying;", "getDisplaying", "()Lcom/avito/android/remote/model/section/SectionDisplaying;", "", "engine", "Ljava/lang/String;", "getEngine", "()Ljava/lang/String;", MessengerShareContentUtility.SUBTITLE, "getSubtitle", "context", "getContext", "title", "getTitle", "Lcom/avito/android/remote/model/Action;", "action", "Lcom/avito/android/remote/model/Action;", "getAction", "()Lcom/avito/android/remote/model/Action;", "", "Lcom/avito/android/remote/model/section/SectionElement;", "items", "Ljava/util/List;", "getItems", "()Ljava/util/List;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Action;Ljava/util/List;Lcom/avito/android/remote/model/section/SectionDisplaying;Ljava/lang/String;Ljava/lang/String;)V", "Companion", "search_release"}, k = 1, mv = {1, 4, 2})
public final class SectionTypeItem implements SectionTypeElement {
    @JvmField
    @NotNull
    public static final Parcelable.Creator<SectionTypeItem> CREATOR = Parcels.creator(SectionTypeItem$Companion$CREATOR$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion(null);
    @SerializedName("action")
    @Nullable
    private final Action action;
    @SerializedName("context")
    @Nullable
    private final String context;
    @SerializedName("displaying")
    @Nullable
    private final SectionDisplaying displaying;
    @SerializedName("engine")
    @Nullable
    private final String engine;
    @SerializedName("list")
    @NotNull
    private final List<SectionElement> items;
    @SerializedName(MessengerShareContentUtility.SUBTITLE)
    @Nullable
    private final String subtitle;
    @SerializedName("title")
    @Nullable
    private final String title;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006@\u0007X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/section/SectionTypeItem$Companion;", "", "Landroid/os/Parcelable$Creator;", "Lcom/avito/android/remote/model/section/SectionTypeItem;", "CREATOR", "Landroid/os/Parcelable$Creator;", "<init>", "()V", "search_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: java.util.List<? extends com.avito.android.remote.model.section.SectionElement> */
    /* JADX WARN: Multi-variable type inference failed */
    public SectionTypeItem(@Nullable String str, @Nullable String str2, @Nullable Action action2, @NotNull List<? extends SectionElement> list, @Nullable SectionDisplaying sectionDisplaying, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(list, "items");
        this.title = str;
        this.subtitle = str2;
        this.action = action2;
        this.items = list;
        this.displaying = sectionDisplaying;
        this.context = str3;
        this.engine = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final Action getAction() {
        return this.action;
    }

    @Nullable
    public final String getContext() {
        return this.context;
    }

    @Nullable
    public final SectionDisplaying getDisplaying() {
        return this.displaying;
    }

    @Nullable
    public final String getEngine() {
        return this.engine;
    }

    @NotNull
    public final List<SectionElement> getItems() {
        return this.items;
    }

    @Nullable
    public final String getSubtitle() {
        return this.subtitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeString(this.title);
        parcel.writeString(this.subtitle);
        parcel.writeParcelable(this.action, i);
        ParcelsKt.writeOptimizedParcelableList$default(parcel, this.items, 0, 2, null);
        parcel.writeParcelable(this.displaying, i);
        parcel.writeString(this.context);
        parcel.writeString(this.engine);
    }
}
