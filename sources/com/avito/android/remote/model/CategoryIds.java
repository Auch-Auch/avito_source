package com.avito.android.remote.model;

import androidx.room.RoomMasterTable;
import com.avito.android.advert.item.AdvertDetailsPresenterKt;
import com.avito.android.messenger.conversation.adapter.LocationMessagesKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds;", "", "<init>", "()V", "AUTO", "JOB", "RE", "SE", "models_release"}, k = 1, mv = {1, 4, 2})
public final class CategoryIds {
    @NotNull
    public static final CategoryIds INSTANCE = new CategoryIds();

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$AUTO;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "ROOT", "CARS", "SPAREPARTS", "WATER", "MOTO", "TRUCKS", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum AUTO {
        ROOT("1"),
        CARS(AdvertDetailsPresenterKt.AUTO_CATEGORY_ID),
        SPAREPARTS("10"),
        WATER("11"),
        MOTO(LocationMessagesKt.MAP_SNIPPET_WITH_MARKERS_ZOOM),
        TRUCKS("81");
        
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String id;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$AUTO$Companion;", "", "", "", "allIds", "()Ljava/util/List;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final List<String> allIds() {
                AUTO[] values = AUTO.values();
                ArrayList arrayList = new ArrayList(6);
                for (AUTO auto : values) {
                    arrayList.add(auto.getId());
                }
                return arrayList;
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        private AUTO(String str) {
            this.id = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$JOB;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROOT", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum JOB {
        ROOT("110");
        
        @NotNull
        private final String id;

        private JOB(String str) {
            this.id = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$RE;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "ROOT", "RE_ROOMS", "RE_FLATS", "RE_HOUSES", "RE_LANDS", "RE_GARAGES", "RE_COMMERCIAL", "RE_ABROAD", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum RE {
        ROOT("4"),
        RE_ROOMS("23"),
        RE_FLATS("24"),
        RE_HOUSES("25"),
        RE_LANDS("26"),
        RE_GARAGES("85"),
        RE_COMMERCIAL(RoomMasterTable.DEFAULT_ID),
        RE_ABROAD("86");
        
        @NotNull
        public static final Companion Companion = new Companion(null);
        @NotNull
        private final String id;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\b"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$RE$Companion;", "", "", "", "allIds", "()Ljava/util/List;", "<init>", "()V", "models_release"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            @NotNull
            public final List<String> allIds() {
                RE[] values = RE.values();
                ArrayList arrayList = new ArrayList(8);
                for (RE re : values) {
                    arrayList.add(re.getId());
                }
                return arrayList;
            }

            public /* synthetic */ Companion(j jVar) {
                this();
            }
        }

        private RE(String str) {
            this.id = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/remote/model/CategoryIds$SE;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "ROOT", "models_release"}, k = 1, mv = {1, 4, 2})
    public enum SE {
        ROOT("113");
        
        @NotNull
        private final String id;

        private SE(String str) {
            this.id = str;
        }

        @NotNull
        public final String getId() {
            return this.id;
        }
    }

    private CategoryIds() {
    }
}
