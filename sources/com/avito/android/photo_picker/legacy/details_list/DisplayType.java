package com.avito.android.photo_picker.legacy.details_list;

import com.avito.android.remote.auth.AuthSource;
import kotlin.Metadata;
import t6.r.a.j;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0004\u0005\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "", "<init>", "()V", "ExtraSmall", "FourOnThree", "Normal", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$ExtraSmall;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$FourOnThree;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$Normal;", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
public abstract class DisplayType {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$ExtraSmall;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class ExtraSmall extends DisplayType {
        public ExtraSmall() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$FourOnThree;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "<init>", "()V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class FourOnThree extends DisplayType {
        public FourOnThree() {
            super(null);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\b\u0010\tR\u0019\u0010\u0007\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Lcom/avito/android/photo_picker/legacy/details_list/DisplayType$Normal;", "Lcom/avito/android/photo_picker/legacy/details_list/DisplayType;", "", AuthSource.SEND_ABUSE, "I", "getRemainingHeight", "()I", "remainingHeight", "<init>", "(I)V", "photo-picker_release"}, k = 1, mv = {1, 4, 2})
    public static final class Normal extends DisplayType {
        public final int a;

        public Normal(int i) {
            super(null);
            this.a = i;
        }

        public final int getRemainingHeight() {
            return this.a;
        }
    }

    public DisplayType() {
    }

    public DisplayType(j jVar) {
    }
}
