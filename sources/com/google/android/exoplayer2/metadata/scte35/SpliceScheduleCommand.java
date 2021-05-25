package com.google.android.exoplayer2.metadata.scte35;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public final class SpliceScheduleCommand extends SpliceCommand {
    public static final Parcelable.Creator<SpliceScheduleCommand> CREATOR = new a();
    public final List<Event> events;

    public class a implements Parcelable.Creator<SpliceScheduleCommand> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand createFromParcel(Parcel parcel) {
            return new SpliceScheduleCommand(parcel, null);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public SpliceScheduleCommand[] newArray(int i) {
            return new SpliceScheduleCommand[i];
        }
    }

    public SpliceScheduleCommand(List<Event> list) {
        this.events = Collections.unmodifiableList(list);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int size = this.events.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            Event event = this.events.get(i2);
            parcel.writeLong(event.spliceEventId);
            parcel.writeByte(event.spliceEventCancelIndicator ? (byte) 1 : 0);
            parcel.writeByte(event.outOfNetworkIndicator ? (byte) 1 : 0);
            parcel.writeByte(event.programSpliceFlag ? (byte) 1 : 0);
            int size2 = event.componentSpliceList.size();
            parcel.writeInt(size2);
            for (int i3 = 0; i3 < size2; i3++) {
                ComponentSplice componentSplice = event.componentSpliceList.get(i3);
                parcel.writeInt(componentSplice.componentTag);
                parcel.writeLong(componentSplice.utcSpliceTime);
            }
            parcel.writeLong(event.utcSpliceTime);
            parcel.writeByte(event.autoReturn ? (byte) 1 : 0);
            parcel.writeLong(event.breakDurationUs);
            parcel.writeInt(event.uniqueProgramId);
            parcel.writeInt(event.availNum);
            parcel.writeInt(event.availsExpected);
        }
    }

    public static final class ComponentSplice {
        public final int componentTag;
        public final long utcSpliceTime;

        public ComponentSplice(int i, long j) {
            this.componentTag = i;
            this.utcSpliceTime = j;
        }

        public ComponentSplice(int i, long j, a aVar) {
            this.componentTag = i;
            this.utcSpliceTime = j;
        }
    }

    public SpliceScheduleCommand(Parcel parcel, a aVar) {
        int readInt = parcel.readInt();
        ArrayList arrayList = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            arrayList.add(new Event(parcel));
        }
        this.events = Collections.unmodifiableList(arrayList);
    }

    public static final class Event {
        public final boolean autoReturn;
        public final int availNum;
        public final int availsExpected;
        public final long breakDurationUs;
        public final List<ComponentSplice> componentSpliceList;
        public final boolean outOfNetworkIndicator;
        public final boolean programSpliceFlag;
        public final boolean spliceEventCancelIndicator;
        public final long spliceEventId;
        public final int uniqueProgramId;
        public final long utcSpliceTime;

        public Event(long j, boolean z, boolean z2, boolean z3, List<ComponentSplice> list, long j2, boolean z4, long j3, int i, int i2, int i3) {
            this.spliceEventId = j;
            this.spliceEventCancelIndicator = z;
            this.outOfNetworkIndicator = z2;
            this.programSpliceFlag = z3;
            this.componentSpliceList = Collections.unmodifiableList(list);
            this.utcSpliceTime = j2;
            this.autoReturn = z4;
            this.breakDurationUs = j3;
            this.uniqueProgramId = i;
            this.availNum = i2;
            this.availsExpected = i3;
        }

        public Event(Parcel parcel) {
            this.spliceEventId = parcel.readLong();
            boolean z = false;
            this.spliceEventCancelIndicator = parcel.readByte() == 1;
            this.outOfNetworkIndicator = parcel.readByte() == 1;
            this.programSpliceFlag = parcel.readByte() == 1;
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i = 0; i < readInt; i++) {
                arrayList.add(new ComponentSplice(parcel.readInt(), parcel.readLong()));
            }
            this.componentSpliceList = Collections.unmodifiableList(arrayList);
            this.utcSpliceTime = parcel.readLong();
            this.autoReturn = parcel.readByte() == 1 ? true : z;
            this.breakDurationUs = parcel.readLong();
            this.uniqueProgramId = parcel.readInt();
            this.availNum = parcel.readInt();
            this.availsExpected = parcel.readInt();
        }
    }
}
