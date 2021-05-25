package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONObject;
public class VKApiAudio extends VKAttachments.VKApiAttachment implements Identifiable, Parcelable {
    public static Parcelable.Creator<VKApiAudio> CREATOR = new a();
    public String access_key;
    public int album_id;
    public String artist;
    public int duration;
    public int genre;
    public int id;
    public int lyrics_id;
    public int owner_id;
    public String title;
    public String url;

    public static final class Genre {
        public static final int ACOUSTIC_AND_VOCAL = 14;
        public static final int ALTERNATIVE = 21;
        public static final int CHANSON = 12;
        public static final int CLASSICAL = 16;
        public static final int DANCE_AND_HOUSE = 5;
        public static final int DRUM_AND_BASS = 10;
        public static final int DUBSTEP = 8;
        public static final int EASY_LISTENING = 4;
        public static final int ELECTROPOP_AND_DISCO = 22;
        public static final int ETHNIC = 13;
        public static final int INDIE_POP = 17;
        public static final int INSTRUMENTAL = 6;
        public static final int JAZZ_AND_BLUES = 9;
        public static final int METAL = 7;
        public static final int OTHER = 18;
        public static final int POP = 2;
        public static final int RAP_AND_HIPHOP = 3;
        public static final int REGGAE = 15;
        public static final int ROCK = 1;
        public static final int SPEECH = 19;
        public static final int TRANCE = 11;
    }

    public static class a implements Parcelable.Creator<VKApiAudio> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiAudio createFromParcel(Parcel parcel) {
            return new VKApiAudio(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiAudio[] newArray(int i) {
            return new VKApiAudio[i];
        }
    }

    public VKApiAudio(JSONObject jSONObject) {
        parse(jSONObject);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.vk.sdk.api.model.Identifiable
    public int getId() {
        return this.id;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public String getType() {
        return "audio";
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        StringBuilder sb = new StringBuilder("audio");
        sb.append(this.owner_id);
        sb.append('_');
        sb.append(this.id);
        if (!TextUtils.isEmpty(this.access_key)) {
            sb.append('_');
            sb.append(this.access_key);
        }
        return sb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.owner_id);
        parcel.writeString(this.artist);
        parcel.writeString(this.title);
        parcel.writeInt(this.duration);
        parcel.writeString(this.url);
        parcel.writeInt(this.lyrics_id);
        parcel.writeInt(this.album_id);
        parcel.writeInt(this.genre);
        parcel.writeString(this.access_key);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiAudio parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.artist = jSONObject.optString("artist");
        this.title = jSONObject.optString("title");
        this.duration = jSONObject.optInt("duration");
        this.url = jSONObject.optString("url");
        this.lyrics_id = jSONObject.optInt("lyrics_id");
        this.album_id = jSONObject.optInt(VKApiConst.ALBUM_ID);
        this.genre = jSONObject.optInt("genre_id");
        this.access_key = jSONObject.optString("access_key");
        return this;
    }

    public VKApiAudio(Parcel parcel) {
        this.id = parcel.readInt();
        this.owner_id = parcel.readInt();
        this.artist = parcel.readString();
        this.title = parcel.readString();
        this.duration = parcel.readInt();
        this.url = parcel.readString();
        this.lyrics_id = parcel.readInt();
        this.album_id = parcel.readInt();
        this.genre = parcel.readInt();
        this.access_key = parcel.readString();
    }

    public VKApiAudio() {
    }
}
