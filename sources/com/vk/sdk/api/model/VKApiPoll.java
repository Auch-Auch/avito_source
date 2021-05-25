package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.api.VKApiConst;
import com.vk.sdk.api.model.VKAttachments;
import org.json.JSONException;
import org.json.JSONObject;
public class VKApiPoll extends VKAttachments.VKApiAttachment implements Parcelable {
    public static Parcelable.Creator<VKApiPoll> CREATOR = new a();
    public int answer_id;
    public VKList<Answer> answers;
    public long created;
    public int id;
    public int owner_id;
    public String question;
    public int votes;

    public static final class Answer extends VKApiModel implements Identifiable, Parcelable {
        public static Parcelable.Creator<Answer> CREATOR = new a();
        public int id;
        public double rate;
        public String text;
        public int votes;

        public static class a implements Parcelable.Creator<Answer> {
            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public Answer createFromParcel(Parcel parcel) {
                return new Answer(parcel);
            }

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public Answer[] newArray(int i) {
                return new Answer[i];
            }
        }

        public Answer(Parcel parcel) {
            this.id = parcel.readInt();
            this.text = parcel.readString();
            this.votes = parcel.readInt();
            this.rate = parcel.readDouble();
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // com.vk.sdk.api.model.Identifiable
        public int getId() {
            return this.id;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.id);
            parcel.writeString(this.text);
            parcel.writeInt(this.votes);
            parcel.writeDouble(this.rate);
        }

        @Override // com.vk.sdk.api.model.VKApiModel
        public Answer parse(JSONObject jSONObject) {
            this.id = jSONObject.optInt("id");
            this.text = jSONObject.optString("text");
            this.votes = jSONObject.optInt("votes");
            this.rate = jSONObject.optDouble("rate");
            return this;
        }
    }

    public static class a implements Parcelable.Creator<VKApiPoll> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPoll createFromParcel(Parcel parcel) {
            return new VKApiPoll(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKApiPoll[] newArray(int i) {
            return new VKApiPoll[i];
        }
    }

    public VKApiPoll(JSONObject jSONObject) throws JSONException {
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
        return VKAttachments.TYPE_POLL;
    }

    @Override // com.vk.sdk.api.model.VKAttachments.VKApiAttachment
    public CharSequence toAttachmentString() {
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeInt(this.owner_id);
        parcel.writeLong(this.created);
        parcel.writeString(this.question);
        parcel.writeInt(this.votes);
        parcel.writeInt(this.answer_id);
        parcel.writeParcelable(this.answers, i);
    }

    @Override // com.vk.sdk.api.model.VKApiModel
    public VKApiPoll parse(JSONObject jSONObject) {
        this.id = jSONObject.optInt("id");
        this.owner_id = jSONObject.optInt(VKApiConst.OWNER_ID);
        this.created = jSONObject.optLong("created");
        this.question = jSONObject.optString("question");
        this.votes = jSONObject.optInt("votes");
        this.answer_id = jSONObject.optInt("answer_id");
        this.answers = new VKList<>(jSONObject.optJSONArray("answers"), Answer.class);
        return this;
    }

    public VKApiPoll(Parcel parcel) {
        this.id = parcel.readInt();
        this.owner_id = parcel.readInt();
        this.created = parcel.readLong();
        this.question = parcel.readString();
        this.votes = parcel.readInt();
        this.answer_id = parcel.readInt();
        this.answers = (VKList) parcel.readParcelable(VKList.class.getClassLoader());
    }

    public VKApiPoll() {
    }
}
