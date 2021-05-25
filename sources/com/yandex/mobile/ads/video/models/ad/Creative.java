package com.yandex.mobile.ads.video.models.ad;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Pair;
import com.yandex.mobile.ads.impl.ie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
public class Creative implements Parcelable {
    public static final Parcelable.Creator<Creative> CREATOR = new Parcelable.Creator<Creative>() { // from class: com.yandex.mobile.ads.video.models.ad.Creative.1
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ Creative createFromParcel(Parcel parcel) {
            return new Creative(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ Creative[] newArray(int i) {
            return new Creative[i];
        }
    };
    private final ArrayList<String> mClickThroughEvents = new ArrayList<>();
    private int mDurationMillis;
    private List<Icon> mIcons = new ArrayList();
    private String mId;
    private List<MediaFile> mMediaFiles = new ArrayList();
    @Nullable
    private SkipOffset mSkipOffset;
    private Map<String, List<String>> mTrackingEvents = new HashMap();

    private Creative() {
    }

    private void addClickThroughUrls(Collection<String> collection) {
        this.mClickThroughEvents.addAll(ie.a(collection));
    }

    private void addMediaFile(MediaFile mediaFile) {
        this.mMediaFiles.add(mediaFile);
    }

    private void addMediaFiles(Collection<MediaFile> collection) {
        for (MediaFile mediaFile : ie.a(collection)) {
            addMediaFile(mediaFile);
        }
    }

    private void addTrackingEvents(Collection<Pair<String, String>> collection) {
        for (Pair pair : ie.a(collection)) {
            addTrackingEvent((String) pair.first, (String) pair.second);
        }
    }

    private void setDurationHHMMSS(String str) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("hh:mm:ss", Locale.US);
            this.mDurationMillis = (int) (simpleDateFormat.parse(str).getTime() - simpleDateFormat.parse("00:00:00").getTime());
        } catch (ParseException unused) {
        }
    }

    private void setDurationMillis(int i) {
        this.mDurationMillis = i;
    }

    private void setId(String str) {
        this.mId = str;
    }

    private void setSkipOffset(@Nullable SkipOffset skipOffset) {
        this.mSkipOffset = skipOffset;
    }

    public void addIcons(Collection<Icon> collection) {
        this.mIcons.addAll(ie.a(collection));
    }

    public void addTrackingEvent(String str, String str2) {
        List<String> list = this.mTrackingEvents.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.mTrackingEvents.put(str, list);
        }
        list.add(str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Creative creative = (Creative) obj;
        if (this.mDurationMillis != creative.mDurationMillis) {
            return false;
        }
        ArrayList<String> arrayList = this.mClickThroughEvents;
        if (arrayList == null ? creative.mClickThroughEvents != null : !arrayList.equals(creative.mClickThroughEvents)) {
            return false;
        }
        String str = this.mId;
        if (str == null ? creative.mId != null : !str.equals(creative.mId)) {
            return false;
        }
        List<MediaFile> list = this.mMediaFiles;
        if (list == null ? creative.mMediaFiles != null : !list.equals(creative.mMediaFiles)) {
            return false;
        }
        Map<String, List<String>> map = this.mTrackingEvents;
        return map == null ? creative.mTrackingEvents == null : map.equals(creative.mTrackingEvents);
    }

    public String getClickThroughUrl() {
        if (this.mClickThroughEvents.isEmpty()) {
            return null;
        }
        return this.mClickThroughEvents.get(0);
    }

    public int getDurationMillis() {
        return this.mDurationMillis;
    }

    public List<Icon> getIcons() {
        return Collections.unmodifiableList(this.mIcons);
    }

    public String getId() {
        return this.mId;
    }

    public List<MediaFile> getMediaFiles() {
        return Collections.unmodifiableList(this.mMediaFiles);
    }

    @Nullable
    public SkipOffset getSkipOffset() {
        return this.mSkipOffset;
    }

    public Map<String, List<String>> getTrackingEvents() {
        return Collections.unmodifiableMap(this.mTrackingEvents);
    }

    @Override // java.lang.Object
    public int hashCode() {
        String str = this.mId;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + this.mDurationMillis) * 31;
        List<MediaFile> list = this.mMediaFiles;
        int hashCode2 = (hashCode + (list != null ? list.hashCode() : 0)) * 31;
        Map<String, List<String>> map = this.mTrackingEvents;
        int hashCode3 = (hashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        ArrayList<String> arrayList = this.mClickThroughEvents;
        if (arrayList != null) {
            i = arrayList.hashCode();
        }
        return hashCode3 + i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeInt(this.mDurationMillis);
        parcel.writeTypedList(this.mMediaFiles);
        parcel.writeInt(this.mTrackingEvents.size());
        for (Map.Entry<String, List<String>> entry : this.mTrackingEvents.entrySet()) {
            parcel.writeString(entry.getKey());
            parcel.writeList(entry.getValue());
        }
        parcel.writeInt(this.mClickThroughEvents.size());
        Iterator<String> it = this.mClickThroughEvents.iterator();
        while (it.hasNext()) {
            parcel.writeString(it.next());
        }
    }

    public Creative(Parcel parcel) {
        this.mId = parcel.readString();
        this.mDurationMillis = parcel.readInt();
        parcel.readTypedList(this.mMediaFiles, MediaFile.CREATOR);
        this.mTrackingEvents = new HashMap();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.mTrackingEvents.put(parcel.readString(), parcel.readArrayList(getClass().getClassLoader()));
        }
        int readInt2 = parcel.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            this.mClickThroughEvents.add(parcel.readString());
        }
    }
}
