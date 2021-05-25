package com.avito.android.remote.model.messenger.context;

import a2.b.a.a.a;
import android.os.Parcel;
import android.os.Parcelable;
import com.avito.android.remote.model.Image;
import com.avito.android.remote.model.messenger.attach_menu.AttachMenu;
import com.avito.android.remote.model.messenger.message.MessageBody;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t6.r.a.j;
import t6.y.f;
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u000e2\u00020\u00012\u00020\u0002:\u0005\u000e\u000f\u0010\u0011\u0012B\t\b\u0002¢\u0006\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\b8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n\u0001\u0004\u0013\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "Lru/avito/messenger/api/entity/context/ChannelContext;", "Landroid/os/Parcelable;", "", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "getMenu", "()Ljava/util/List;", "menu", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getAttachMenu", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", ChannelContext.ATTACH_MENU, "<init>", "()V", "Companion", "Item", "System", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "UserToUser", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$System;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext$Unknown;", "models_release"}, k = 1, mv = {1, 4, 2})
public abstract class ChannelContext implements ru.avito.messenger.api.entity.context.ChannelContext, Parcelable {
    @NotNull
    public static final String ATTACH_MENU = "attachMenu";
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    public static final String MENU = "menu";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$Companion;", "", "", "ATTACH_MENU", "Ljava/lang/String;", "MENU", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(j jVar) {
            this();
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\b\b\u0018\u0000 R2\u00020\u0001:\u0001RB\u0001\u0012\u0006\u0010\u001f\u001a\u00020\u0002\u0012\u0006\u0010 \u001a\u00020\u0002\u0012\u0006\u0010!\u001a\u00020\u0002\u0012\u0006\u0010\"\u001a\u00020\u0002\u0012\u0006\u0010#\u001a\u00020\u0002\u0012\b\u0010$\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010%\u001a\u00020\r\u0012\b\u0010&\u001a\u0004\u0018\u00010\u0002\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0015\u0012\b\u0010)\u001a\u0004\u0018\u00010\u0018\u0012\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010+\u001a\u00020\r¢\u0006\u0004\bP\u0010QJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0010\u0010\u0006\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0010\u0010\b\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\b\u0010\u0004J\u0010\u0010\t\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\t\u0010\u0004J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u000e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0004J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0015HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0018HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001bHÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\rHÆ\u0003¢\u0006\u0004\b\u001e\u0010\u000fJ¢\u0001\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u001f\u001a\u00020\u00022\b\b\u0002\u0010 \u001a\u00020\u00022\b\b\u0002\u0010!\u001a\u00020\u00022\b\b\u0002\u0010\"\u001a\u00020\u00022\b\b\u0002\u0010#\u001a\u00020\u00022\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010%\u001a\u00020\r2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\u00022\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010+\u001a\u00020\rHÆ\u0001¢\u0006\u0004\b,\u0010-J\u0010\u0010/\u001a\u00020.HÖ\u0001¢\u0006\u0004\b/\u00100J\u001a\u00103\u001a\u00020\r2\b\u00102\u001a\u0004\u0018\u000101HÖ\u0003¢\u0006\u0004\b3\u00104J\u0010\u00105\u001a\u00020.HÖ\u0001¢\u0006\u0004\b5\u00100J \u0010:\u001a\u0002092\u0006\u00107\u001a\u0002062\u0006\u00108\u001a\u00020.HÖ\u0001¢\u0006\u0004\b:\u0010;R\u001e\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b$\u0010<\u001a\u0004\b=\u0010\fR\u001c\u0010%\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b%\u0010>\u001a\u0004\b?\u0010\u000fR\u001e\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b&\u0010@\u001a\u0004\bA\u0010\u0004R\u001c\u0010!\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b!\u0010@\u001a\u0004\bB\u0010\u0004R\u001c\u0010+\u001a\u00020\r8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b+\u0010>\u001a\u0004\bC\u0010\u000fR\u001c\u0010 \u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b \u0010@\u001a\u0004\bD\u0010\u0004R\u001c\u0010\"\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\"\u0010@\u001a\u0004\bE\u0010\u0004R\"\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b'\u0010F\u001a\u0004\bG\u0010\u0014R\u001e\u0010(\u001a\u0004\u0018\u00010\u00158\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b(\u0010H\u001a\u0004\bI\u0010\u0017R\u001e\u0010)\u001a\u0004\u0018\u00010\u00188\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b)\u0010J\u001a\u0004\bK\u0010\u001aR\u001e\u0010*\u001a\u0004\u0018\u00010\u001b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b*\u0010L\u001a\u0004\bM\u0010\u001dR\u001c\u0010#\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b#\u0010@\u001a\u0004\bN\u0010\u0004R\u001c\u0010\u001f\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u001f\u0010@\u001a\u0004\bO\u0010\u0004¨\u0006S"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "component5", "Lcom/avito/android/remote/model/Image;", "component6", "()Lcom/avito/android/remote/model/Image;", "", "component7", "()Z", "component8", "", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "component9", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "component10", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "component11", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "component12", "()Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "component13", "id", "categoryId", "category", "title", "price", "image", "deleted", Item.USER_ID, "menu", ChannelContext.ATTACH_MENU, "sharedLocation", Item.REPLY_TIME, Item.HIDE_PHONE, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;Z)Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item;", "", "hashCode", "()I", "", "other", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/Image;", "getImage", "Z", "getDeleted", "Ljava/lang/String;", "getUserId", "getCategory", "getHidePhone", "getCategoryId", "getTitle", "Ljava/util/List;", "getMenu", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getAttachMenu", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getSharedLocation", "Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;", "getReplyTime", "getPrice", "getId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;ZLjava/lang/String;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Lcom/avito/android/remote/model/messenger/context/ChatReplyTime;Z)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Item extends ChannelContext {
        @NotNull
        public static final String ACTIONS = "actions";
        @NotNull
        public static final String CATEGORY = "category";
        @NotNull
        public static final String CATEGORY_ID = "categoryId";
        public static final Parcelable.Creator<Item> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String DELETED = "deleted";
        @NotNull
        public static final String HIDE_PHONE = "hidePhone";
        @NotNull
        public static final String ID = "id";
        @NotNull
        public static final String IMAGE = "image";
        @NotNull
        public static final String PRICE = "priceString";
        @NotNull
        public static final String REPLY_TIME = "replyTime";
        @NotNull
        public static final String SHARED_LOCATION = "sharedLocation";
        @NotNull
        public static final String TITLE = "title";
        @NotNull
        public static final String TYPE = "item";
        @NotNull
        public static final String USER_ID = "userId";
        @SerializedName(ChannelContext.ATTACH_MENU)
        @Nullable
        private final AttachMenu attachMenu;
        @SerializedName("category")
        @NotNull
        private final String category;
        @SerializedName("categoryId")
        @NotNull
        private final String categoryId;
        @SerializedName("deleted")
        private final boolean deleted;
        @SerializedName(HIDE_PHONE)
        private final boolean hidePhone;
        @SerializedName("id")
        @NotNull
        private final String id;
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("menu")
        @NotNull
        private final List<ChannelMenuAction> menu;
        @SerializedName("priceString")
        @NotNull
        private final String price;
        @SerializedName(REPLY_TIME)
        @Nullable
        private final ChatReplyTime replyTime;
        @SerializedName("sharedLocation")
        @Nullable
        private final MessageBody.Location sharedLocation;
        @SerializedName("title")
        @NotNull
        private final String title;
        @SerializedName(USER_ID)
        @Nullable
        private final String userId;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004R\u0016\u0010\t\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\t\u0010\u0004R\u0016\u0010\n\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\n\u0010\u0004R\u0016\u0010\u000b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000b\u0010\u0004R\u0016\u0010\f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\f\u0010\u0004R\u0016\u0010\r\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\r\u0010\u0004R\u0016\u0010\u000e\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000e\u0010\u0004R\u0016\u0010\u000f\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0016\u0010\u0010\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0010\u0010\u0004¨\u0006\u0013"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$Item$Companion;", "", "", "ACTIONS", "Ljava/lang/String;", "CATEGORY", "CATEGORY_ID", "DELETED", "HIDE_PHONE", "ID", ShareConstants.IMAGE_URL, "PRICE", "REPLY_TIME", "SHARED_LOCATION", ShareConstants.TITLE, "TYPE", "USER_ID", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Item> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                Image image = (Image) parcel.readParcelable(Item.class.getClassLoader());
                boolean z = parcel.readInt() != 0;
                String readString6 = parcel.readString();
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(ChannelMenuAction.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                MessageBody.Location location = null;
                AttachMenu createFromParcel = parcel.readInt() != 0 ? AttachMenu.CREATOR.createFromParcel(parcel) : null;
                if (parcel.readInt() != 0) {
                    location = MessageBody.Location.CREATOR.createFromParcel(parcel);
                }
                return new Item(readString, readString2, readString3, readString4, readString5, image, z, readString6, arrayList, createFromParcel, location, (ChatReplyTime) parcel.readParcelable(Item.class.getClassLoader()), parcel.readInt() != 0);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Item[] newArray(int i) {
                return new Item[i];
            }
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Item(String str, String str2, String str3, String str4, String str5, Image image2, boolean z, String str6, List list, AttachMenu attachMenu2, MessageBody.Location location, ChatReplyTime chatReplyTime, boolean z2, int i, j jVar) {
            this(str, str2, str3, str4, str5, image2, z, str6, list, attachMenu2, location, (i & 2048) != 0 ? null : chatReplyTime, (i & 4096) != 0 ? false : z2);
        }

        public static /* synthetic */ Item copy$default(Item item, String str, String str2, String str3, String str4, String str5, Image image2, boolean z, String str6, List list, AttachMenu attachMenu2, MessageBody.Location location, ChatReplyTime chatReplyTime, boolean z2, int i, Object obj) {
            return item.copy((i & 1) != 0 ? item.id : str, (i & 2) != 0 ? item.categoryId : str2, (i & 4) != 0 ? item.category : str3, (i & 8) != 0 ? item.title : str4, (i & 16) != 0 ? item.price : str5, (i & 32) != 0 ? item.image : image2, (i & 64) != 0 ? item.deleted : z, (i & 128) != 0 ? item.userId : str6, (i & 256) != 0 ? item.getMenu() : list, (i & 512) != 0 ? item.getAttachMenu() : attachMenu2, (i & 1024) != 0 ? item.sharedLocation : location, (i & 2048) != 0 ? item.replyTime : chatReplyTime, (i & 4096) != 0 ? item.hidePhone : z2);
        }

        @NotNull
        public final String component1() {
            return this.id;
        }

        @Nullable
        public final AttachMenu component10() {
            return getAttachMenu();
        }

        @Nullable
        public final MessageBody.Location component11() {
            return this.sharedLocation;
        }

        @Nullable
        public final ChatReplyTime component12() {
            return this.replyTime;
        }

        public final boolean component13() {
            return this.hidePhone;
        }

        @NotNull
        public final String component2() {
            return this.categoryId;
        }

        @NotNull
        public final String component3() {
            return this.category;
        }

        @NotNull
        public final String component4() {
            return this.title;
        }

        @NotNull
        public final String component5() {
            return this.price;
        }

        @Nullable
        public final Image component6() {
            return this.image;
        }

        public final boolean component7() {
            return this.deleted;
        }

        @Nullable
        public final String component8() {
            return this.userId;
        }

        @NotNull
        public final List<ChannelMenuAction> component9() {
            return getMenu();
        }

        @NotNull
        public final Item copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable Image image2, boolean z, @Nullable String str6, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2, @Nullable MessageBody.Location location, @Nullable ChatReplyTime chatReplyTime, boolean z2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "categoryId");
            Intrinsics.checkNotNullParameter(str3, "category");
            Intrinsics.checkNotNullParameter(str4, "title");
            Intrinsics.checkNotNullParameter(str5, "price");
            Intrinsics.checkNotNullParameter(list, "menu");
            return new Item(str, str2, str3, str4, str5, image2, z, str6, list, attachMenu2, location, chatReplyTime, z2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Item)) {
                return false;
            }
            Item item = (Item) obj;
            return Intrinsics.areEqual(this.id, item.id) && Intrinsics.areEqual(this.categoryId, item.categoryId) && Intrinsics.areEqual(this.category, item.category) && Intrinsics.areEqual(this.title, item.title) && Intrinsics.areEqual(this.price, item.price) && Intrinsics.areEqual(this.image, item.image) && this.deleted == item.deleted && Intrinsics.areEqual(this.userId, item.userId) && Intrinsics.areEqual(getMenu(), item.getMenu()) && Intrinsics.areEqual(getAttachMenu(), item.getAttachMenu()) && Intrinsics.areEqual(this.sharedLocation, item.sharedLocation) && Intrinsics.areEqual(this.replyTime, item.replyTime) && this.hidePhone == item.hidePhone;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @Nullable
        public AttachMenu getAttachMenu() {
            return this.attachMenu;
        }

        @NotNull
        public final String getCategory() {
            return this.category;
        }

        @NotNull
        public final String getCategoryId() {
            return this.categoryId;
        }

        public final boolean getDeleted() {
            return this.deleted;
        }

        public final boolean getHidePhone() {
            return this.hidePhone;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @NotNull
        public List<ChannelMenuAction> getMenu() {
            return this.menu;
        }

        @NotNull
        public final String getPrice() {
            return this.price;
        }

        @Nullable
        public final ChatReplyTime getReplyTime() {
            return this.replyTime;
        }

        @Nullable
        public final MessageBody.Location getSharedLocation() {
            return this.sharedLocation;
        }

        @NotNull
        public final String getTitle() {
            return this.title;
        }

        @Nullable
        public final String getUserId() {
            return this.userId;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.id;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.categoryId;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.category;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            String str4 = this.title;
            int hashCode4 = (hashCode3 + (str4 != null ? str4.hashCode() : 0)) * 31;
            String str5 = this.price;
            int hashCode5 = (hashCode4 + (str5 != null ? str5.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode6 = (hashCode5 + (image2 != null ? image2.hashCode() : 0)) * 31;
            boolean z = this.deleted;
            int i2 = 1;
            if (z) {
                z = true;
            }
            int i3 = z ? 1 : 0;
            int i4 = z ? 1 : 0;
            int i5 = z ? 1 : 0;
            int i6 = (hashCode6 + i3) * 31;
            String str6 = this.userId;
            int hashCode7 = (i6 + (str6 != null ? str6.hashCode() : 0)) * 31;
            List<ChannelMenuAction> menu2 = getMenu();
            int hashCode8 = (hashCode7 + (menu2 != null ? menu2.hashCode() : 0)) * 31;
            AttachMenu attachMenu2 = getAttachMenu();
            int hashCode9 = (hashCode8 + (attachMenu2 != null ? attachMenu2.hashCode() : 0)) * 31;
            MessageBody.Location location = this.sharedLocation;
            int hashCode10 = (hashCode9 + (location != null ? location.hashCode() : 0)) * 31;
            ChatReplyTime chatReplyTime = this.replyTime;
            if (chatReplyTime != null) {
                i = chatReplyTime.hashCode();
            }
            int i7 = (hashCode10 + i) * 31;
            boolean z2 = this.hidePhone;
            if (!z2) {
                i2 = z2 ? 1 : 0;
            }
            return i7 + i2;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelContext.Item(\n                |   id='");
            L.append(this.id);
            L.append("',\n                |   categoryId='");
            L.append(this.categoryId);
            L.append("',\n                |   category='");
            L.append(this.category);
            L.append("',\n                |   title='");
            L.append(this.title);
            L.append("',\n                |   price='");
            L.append(this.price);
            L.append("',\n                |   image=");
            L.append(this.image);
            L.append(",\n                |   deleted=");
            L.append(this.deleted);
            L.append(",\n                |   userId=");
            L.append(this.userId);
            L.append(",\n                |   menu=");
            L.append(getMenu());
            L.append(",\n                |   attachMenu=");
            L.append(getAttachMenu());
            L.append(",\n                |   sharedLocation=");
            L.append(this.sharedLocation);
            L.append(",\n                |   replyTime=");
            L.append(this.replyTime);
            L.append(",\n                |   hidePhone=");
            return f.trimMargin$default(a.B(L, this.hidePhone, "\n                |)"), null, 1, null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.id);
            parcel.writeString(this.categoryId);
            parcel.writeString(this.category);
            parcel.writeString(this.title);
            parcel.writeString(this.price);
            parcel.writeParcelable(this.image, i);
            parcel.writeInt(this.deleted ? 1 : 0);
            parcel.writeString(this.userId);
            Iterator n0 = a.n0(this.menu, parcel);
            while (n0.hasNext()) {
                ((ChannelMenuAction) n0.next()).writeToParcel(parcel, 0);
            }
            AttachMenu attachMenu2 = this.attachMenu;
            if (attachMenu2 != null) {
                parcel.writeInt(1);
                attachMenu2.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            MessageBody.Location location = this.sharedLocation;
            if (location != null) {
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            parcel.writeParcelable(this.replyTime, i);
            parcel.writeInt(this.hidePhone ? 1 : 0);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Item(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @Nullable Image image2, boolean z, @Nullable String str6, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2, @Nullable MessageBody.Location location, @Nullable ChatReplyTime chatReplyTime, boolean z2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "categoryId");
            Intrinsics.checkNotNullParameter(str3, "category");
            Intrinsics.checkNotNullParameter(str4, "title");
            Intrinsics.checkNotNullParameter(str5, "price");
            Intrinsics.checkNotNullParameter(list, "menu");
            this.id = str;
            this.categoryId = str2;
            this.category = str3;
            this.title = str4;
            this.price = str5;
            this.image = image2;
            this.deleted = z;
            this.userId = str6;
            this.menu = list;
            this.attachMenu = attachMenu2;
            this.sharedLocation = location;
            this.replyTime = chatReplyTime;
            this.hidePhone = z2;
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0010\b\b\u0018\u0000 52\u00020\u0001:\u00015BE\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\b\u0012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b3\u00104J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0004J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0007\u0010\u0004J\u0012\u0010\t\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0004\b\u0010\u0010\u0011JZ\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\b2\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001b\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010 \u001a\u00020\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001dHÖ\u0003¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b\"\u0010\u001cJ \u0010'\u001a\u00020&2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020\u001aHÖ\u0001¢\u0006\u0004\b'\u0010(R\u001e\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0014\u0010)\u001a\u0004\b*\u0010\u0004R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u000f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0017\u0010+\u001a\u0004\b,\u0010\u0011R\u001e\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0013\u0010)\u001a\u0004\b-\u0010\u0004R\u001e\u0010\u0015\u001a\u0004\u0018\u00010\b8\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0015\u0010.\u001a\u0004\b/\u0010\nR\"\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0016\u00100\u001a\u0004\b1\u0010\u000eR\u001c\u0010\u0012\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0012\u0010)\u001a\u0004\b2\u0010\u0004¨\u00066"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$System;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "", "toString", "()Ljava/lang/String;", "component1", "component2", "component3", "Lcom/avito/android/remote/model/Image;", "component4", "()Lcom/avito/android/remote/model/Image;", "", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "component5", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "component6", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "name", "status", "description", "image", "menu", ChannelContext.ATTACH_MENU, "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$System;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getDescription", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getAttachMenu", "getStatus", "Lcom/avito/android/remote/model/Image;", "getImage", "Ljava/util/List;", "getMenu", "getName", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/avito/android/remote/model/Image;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class System extends ChannelContext {
        public static final Parcelable.Creator<System> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String DESCRIPTION = "description";
        @NotNull
        public static final String IMAGE = "image";
        @NotNull
        public static final String NAME = "name";
        @NotNull
        public static final String STATUS = "status";
        @NotNull
        public static final String TYPE = "system";
        @SerializedName(ChannelContext.ATTACH_MENU)
        @Nullable
        private final AttachMenu attachMenu;
        @SerializedName("description")
        @Nullable
        private final String description;
        @SerializedName("image")
        @Nullable
        private final Image image;
        @SerializedName("menu")
        @NotNull
        private final List<ChannelMenuAction> menu;
        @SerializedName("name")
        @NotNull
        private final String name;
        @SerializedName("status")
        @Nullable
        private final String status;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$System$Companion;", "", "", ShareConstants.DESCRIPTION, "Ljava/lang/String;", ShareConstants.IMAGE_URL, "NAME", "STATUS", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<System> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final System createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                Image image = (Image) parcel.readParcelable(System.class.getClassLoader());
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(ChannelMenuAction.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                return new System(readString, readString2, readString3, image, arrayList, parcel.readInt() != 0 ? AttachMenu.CREATOR.createFromParcel(parcel) : null);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final System[] newArray(int i) {
                return new System[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public System(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Image image2, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, "menu");
            this.name = str;
            this.status = str2;
            this.description = str3;
            this.image = image2;
            this.menu = list;
            this.attachMenu = attachMenu2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: com.avito.android.remote.model.messenger.context.ChannelContext$System */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ System copy$default(System system, String str, String str2, String str3, Image image2, List list, AttachMenu attachMenu2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = system.name;
            }
            if ((i & 2) != 0) {
                str2 = system.status;
            }
            if ((i & 4) != 0) {
                str3 = system.description;
            }
            if ((i & 8) != 0) {
                image2 = system.image;
            }
            if ((i & 16) != 0) {
                list = system.getMenu();
            }
            if ((i & 32) != 0) {
                attachMenu2 = system.getAttachMenu();
            }
            return system.copy(str, str2, str3, image2, list, attachMenu2);
        }

        @NotNull
        public final String component1() {
            return this.name;
        }

        @Nullable
        public final String component2() {
            return this.status;
        }

        @Nullable
        public final String component3() {
            return this.description;
        }

        @Nullable
        public final Image component4() {
            return this.image;
        }

        @NotNull
        public final List<ChannelMenuAction> component5() {
            return getMenu();
        }

        @Nullable
        public final AttachMenu component6() {
            return getAttachMenu();
        }

        @NotNull
        public final System copy(@NotNull String str, @Nullable String str2, @Nullable String str3, @Nullable Image image2, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2) {
            Intrinsics.checkNotNullParameter(str, "name");
            Intrinsics.checkNotNullParameter(list, "menu");
            return new System(str, str2, str3, image2, list, attachMenu2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof System)) {
                return false;
            }
            System system = (System) obj;
            return Intrinsics.areEqual(this.name, system.name) && Intrinsics.areEqual(this.status, system.status) && Intrinsics.areEqual(this.description, system.description) && Intrinsics.areEqual(this.image, system.image) && Intrinsics.areEqual(getMenu(), system.getMenu()) && Intrinsics.areEqual(getAttachMenu(), system.getAttachMenu());
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @Nullable
        public AttachMenu getAttachMenu() {
            return this.attachMenu;
        }

        @Nullable
        public final String getDescription() {
            return this.description;
        }

        @Nullable
        public final Image getImage() {
            return this.image;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @NotNull
        public List<ChannelMenuAction> getMenu() {
            return this.menu;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        @Nullable
        public final String getStatus() {
            return this.status;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.status;
            int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            String str3 = this.description;
            int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
            Image image2 = this.image;
            int hashCode4 = (hashCode3 + (image2 != null ? image2.hashCode() : 0)) * 31;
            List<ChannelMenuAction> menu2 = getMenu();
            int hashCode5 = (hashCode4 + (menu2 != null ? menu2.hashCode() : 0)) * 31;
            AttachMenu attachMenu2 = getAttachMenu();
            if (attachMenu2 != null) {
                i = attachMenu2.hashCode();
            }
            return hashCode5 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelContext.System(\n                |   name='");
            L.append(this.name);
            L.append("',\n                |   status=");
            L.append(this.status);
            L.append(",\n                |   description=");
            L.append(this.description);
            L.append(",\n                |   image=");
            L.append(this.image);
            L.append(",\n                |   menu=");
            L.append(getMenu());
            L.append(",\n                |   attachMenu=");
            L.append(getAttachMenu());
            L.append("\n                |)");
            return f.trimMargin$default(L.toString(), null, 1, null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.name);
            parcel.writeString(this.status);
            parcel.writeString(this.description);
            parcel.writeParcelable(this.image, i);
            Iterator n0 = a.n0(this.menu, parcel);
            while (n0.hasNext()) {
                ((ChannelMenuAction) n0.next()).writeToParcel(parcel, 0);
            }
            AttachMenu attachMenu2 = this.attachMenu;
            if (attachMenu2 != null) {
                parcel.writeInt(1);
                attachMenu2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0002¢\u0006\u0004\b#\u0010$J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u001a\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0006\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0011\u0010\u000bJ \u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0006\u001a\u00020\u00028\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u0006\u0010\u0018\u001a\u0004\b\u0019\u0010\u0004R\u001c\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b \u0010!¨\u0006%"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$Unknown;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "", "toString", "()Ljava/lang/String;", "component1", "type", "copy", "(Ljava/lang/String;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$Unknown;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Ljava/lang/String;", "getType", "", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "getMenu", "()Ljava/util/List;", "menu", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getAttachMenu", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", ChannelContext.ATTACH_MENU, "<init>", "(Ljava/lang/String;)V", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class Unknown extends ChannelContext {
        public static final Parcelable.Creator<Unknown> CREATOR = new Creator();
        @SerializedName("type")
        @NotNull
        private final String type;

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<Unknown> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unknown createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                return new Unknown(parcel.readString());
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final Unknown[] newArray(int i) {
                return new Unknown[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Unknown(@NotNull String str) {
            super(null);
            Intrinsics.checkNotNullParameter(str, "type");
            this.type = str;
        }

        public static /* synthetic */ Unknown copy$default(Unknown unknown, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = unknown.type;
            }
            return unknown.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.type;
        }

        @NotNull
        public final Unknown copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "type");
            return new Unknown(str);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this != obj) {
                return (obj instanceof Unknown) && Intrinsics.areEqual(this.type, ((Unknown) obj).type);
            }
            return true;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @Nullable
        public AttachMenu getAttachMenu() {
            return null;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @NotNull
        public List<ChannelMenuAction> getMenu() {
            return CollectionsKt__CollectionsKt.emptyList();
        }

        @NotNull
        public final String getType() {
            return this.type;
        }

        @Override // java.lang.Object
        public int hashCode() {
            String str = this.type;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            return a.t(a.L("ChannelContext.Unknown(type='"), this.type, "')");
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            parcel.writeString(this.type);
        }
    }

    @Parcelize
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\b\b\u0018\u0000 +2\u00020\u0001:\u0001+B)\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\r\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ8\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u001a\u001a\u00020\u00192\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0016J \u0010!\u001a\u00020 2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b!\u0010\"R\u001e\u0010\u0011\u001a\u0004\u0018\u00010\f8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0011\u0010#\u001a\u0004\b$\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00058\u0006@\u0007X\u0004¢\u0006\f\n\u0004\b\u000f\u0010%\u001a\u0004\b&\u0010\u0007R\"\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0016@\u0017X\u0004¢\u0006\f\n\u0004\b\u0010\u0010'\u001a\u0004\b(\u0010\u000b¨\u0006,"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser;", "Lcom/avito/android/remote/model/messenger/context/ChannelContext;", "", "toString", "()Ljava/lang/String;", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "component1", "()Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "", "Lcom/avito/android/remote/model/messenger/context/ChannelMenuAction;", "component2", "()Ljava/util/List;", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "component3", "()Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "sharedLocation", "menu", ChannelContext.ATTACH_MENU, "copy", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;)Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;", "getAttachMenu", "Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;", "getSharedLocation", "Ljava/util/List;", "getMenu", "<init>", "(Lcom/avito/android/remote/model/messenger/message/MessageBody$Location;Ljava/util/List;Lcom/avito/android/remote/model/messenger/attach_menu/AttachMenu;)V", "Companion", "models_release"}, k = 1, mv = {1, 4, 2})
    public static final class UserToUser extends ChannelContext {
        public static final Parcelable.Creator<UserToUser> CREATOR = new Creator();
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        public static final String SHARED_LOCATION = "sharedLocation";
        @NotNull
        public static final String TYPE = "user";
        @SerializedName(ChannelContext.ATTACH_MENU)
        @Nullable
        private final AttachMenu attachMenu;
        @SerializedName("menu")
        @NotNull
        private final List<ChannelMenuAction> menu;
        @SerializedName("sharedLocation")
        @Nullable
        private final MessageBody.Location sharedLocation;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00028\u0006@\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/messenger/context/ChannelContext$UserToUser$Companion;", "", "", "SHARED_LOCATION", "Ljava/lang/String;", "TYPE", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 2})
        public static class Creator implements Parcelable.Creator<UserToUser> {
            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UserToUser createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "in");
                AttachMenu attachMenu = null;
                MessageBody.Location createFromParcel = parcel.readInt() != 0 ? MessageBody.Location.CREATOR.createFromParcel(parcel) : null;
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                while (readInt != 0) {
                    arrayList.add(ChannelMenuAction.CREATOR.createFromParcel(parcel));
                    readInt--;
                }
                if (parcel.readInt() != 0) {
                    attachMenu = AttachMenu.CREATOR.createFromParcel(parcel);
                }
                return new UserToUser(createFromParcel, arrayList, attachMenu);
            }

            @Override // android.os.Parcelable.Creator
            @NotNull
            public final UserToUser[] newArray(int i) {
                return new UserToUser[i];
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UserToUser(@Nullable MessageBody.Location location, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2) {
            super(null);
            Intrinsics.checkNotNullParameter(list, "menu");
            this.sharedLocation = location;
            this.menu = list;
            this.attachMenu = attachMenu2;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: com.avito.android.remote.model.messenger.context.ChannelContext$UserToUser */
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ UserToUser copy$default(UserToUser userToUser, MessageBody.Location location, List list, AttachMenu attachMenu2, int i, Object obj) {
            if ((i & 1) != 0) {
                location = userToUser.sharedLocation;
            }
            if ((i & 2) != 0) {
                list = userToUser.getMenu();
            }
            if ((i & 4) != 0) {
                attachMenu2 = userToUser.getAttachMenu();
            }
            return userToUser.copy(location, list, attachMenu2);
        }

        @Nullable
        public final MessageBody.Location component1() {
            return this.sharedLocation;
        }

        @NotNull
        public final List<ChannelMenuAction> component2() {
            return getMenu();
        }

        @Nullable
        public final AttachMenu component3() {
            return getAttachMenu();
        }

        @NotNull
        public final UserToUser copy(@Nullable MessageBody.Location location, @NotNull List<ChannelMenuAction> list, @Nullable AttachMenu attachMenu2) {
            Intrinsics.checkNotNullParameter(list, "menu");
            return new UserToUser(location, list, attachMenu2);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // java.lang.Object
        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UserToUser)) {
                return false;
            }
            UserToUser userToUser = (UserToUser) obj;
            return Intrinsics.areEqual(this.sharedLocation, userToUser.sharedLocation) && Intrinsics.areEqual(getMenu(), userToUser.getMenu()) && Intrinsics.areEqual(getAttachMenu(), userToUser.getAttachMenu());
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @Nullable
        public AttachMenu getAttachMenu() {
            return this.attachMenu;
        }

        @Override // com.avito.android.remote.model.messenger.context.ChannelContext
        @NotNull
        public List<ChannelMenuAction> getMenu() {
            return this.menu;
        }

        @Nullable
        public final MessageBody.Location getSharedLocation() {
            return this.sharedLocation;
        }

        @Override // java.lang.Object
        public int hashCode() {
            MessageBody.Location location = this.sharedLocation;
            int i = 0;
            int hashCode = (location != null ? location.hashCode() : 0) * 31;
            List<ChannelMenuAction> menu2 = getMenu();
            int hashCode2 = (hashCode + (menu2 != null ? menu2.hashCode() : 0)) * 31;
            AttachMenu attachMenu2 = getAttachMenu();
            if (attachMenu2 != null) {
                i = attachMenu2.hashCode();
            }
            return hashCode2 + i;
        }

        @Override // java.lang.Object
        @NotNull
        public String toString() {
            StringBuilder L = a.L("ChannelContext.UserToUser(\n                |   sharedLocation=");
            L.append(this.sharedLocation);
            L.append(",\n                |   menu=");
            L.append(getMenu());
            L.append(", \n                |   attachMenu=");
            L.append(getAttachMenu());
            L.append("\n                |)");
            return f.trimMargin$default(L.toString(), null, 1, null);
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NotNull Parcel parcel, int i) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            MessageBody.Location location = this.sharedLocation;
            if (location != null) {
                parcel.writeInt(1);
                location.writeToParcel(parcel, 0);
            } else {
                parcel.writeInt(0);
            }
            Iterator n0 = a.n0(this.menu, parcel);
            while (n0.hasNext()) {
                ((ChannelMenuAction) n0.next()).writeToParcel(parcel, 0);
            }
            AttachMenu attachMenu2 = this.attachMenu;
            if (attachMenu2 != null) {
                parcel.writeInt(1);
                attachMenu2.writeToParcel(parcel, 0);
                return;
            }
            parcel.writeInt(0);
        }
    }

    private ChannelContext() {
    }

    @Nullable
    public abstract AttachMenu getAttachMenu();

    @NotNull
    public abstract List<ChannelMenuAction> getMenu();

    public /* synthetic */ ChannelContext(j jVar) {
        this();
    }
}
