package com.vk.sdk.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.vk.sdk.api.model.VKList;
import com.vk.sdk.util.VKStringJoiner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
public class VKAttachments extends VKList<VKApiAttachment> implements Parcelable {
    public static Parcelable.Creator<VKAttachments> CREATOR = new b();
    public static final String TYPE_ALBUM = "album";
    public static final String TYPE_APP = "app";
    public static final String TYPE_AUDIO = "audio";
    public static final String TYPE_DOC = "doc";
    public static final String TYPE_LINK = "link";
    public static final String TYPE_NOTE = "note";
    public static final String TYPE_PHOTO = "photo";
    public static final String TYPE_POLL = "poll";
    public static final String TYPE_POST = "wall";
    public static final String TYPE_POSTED_PHOTO = "posted_photo";
    public static final String TYPE_VIDEO = "video";
    public static final String TYPE_WIKI_PAGE = "page";
    public final VKList.Parser<VKApiAttachment> e = new a(this);

    public static abstract class VKApiAttachment extends VKApiModel implements Identifiable {
        public abstract String getType();

        public abstract CharSequence toAttachmentString();
    }

    public class a implements VKList.Parser<VKApiAttachment> {
        public a(VKAttachments vKAttachments) {
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.vk.sdk.api.model.VKList.Parser
        public VKApiAttachment parseObject(JSONObject jSONObject) throws Exception {
            String optString = jSONObject.optString("type");
            if ("photo".equals(optString)) {
                return new VKApiPhoto().parse(jSONObject.getJSONObject("photo"));
            }
            if ("video".equals(optString)) {
                return new VKApiVideo().parse(jSONObject.getJSONObject("video"));
            }
            if ("audio".equals(optString)) {
                return new VKApiAudio().parse(jSONObject.getJSONObject("audio"));
            }
            if (VKAttachments.TYPE_DOC.equals(optString)) {
                return new VKApiDocument().parse(jSONObject.getJSONObject(VKAttachments.TYPE_DOC));
            }
            if ("wall".equals(optString)) {
                return new VKApiPost().parse(jSONObject.getJSONObject("wall"));
            }
            if (VKAttachments.TYPE_POSTED_PHOTO.equals(optString)) {
                return new VKApiPostedPhoto().parse(jSONObject.getJSONObject(VKAttachments.TYPE_POSTED_PHOTO));
            }
            if ("link".equals(optString)) {
                return new VKApiLink().parse(jSONObject.getJSONObject("link"));
            }
            if (VKAttachments.TYPE_NOTE.equals(optString)) {
                return new VKApiNote().parse(jSONObject.getJSONObject(VKAttachments.TYPE_NOTE));
            }
            if ("app".equals(optString)) {
                return new VKApiApplicationContent().parse(jSONObject.getJSONObject("app"));
            }
            if (VKAttachments.TYPE_POLL.equals(optString)) {
                return new VKApiPoll().parse(jSONObject.getJSONObject(VKAttachments.TYPE_POLL));
            }
            if ("page".equals(optString)) {
                return new VKApiWikiPage().parse(jSONObject.getJSONObject("page"));
            }
            if (VKAttachments.TYPE_ALBUM.equals(optString)) {
                return new VKApiPhotoAlbum().parse(jSONObject.getJSONObject(VKAttachments.TYPE_ALBUM));
            }
            return null;
        }
    }

    public static class b implements Parcelable.Creator<VKAttachments> {
        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKAttachments createFromParcel(Parcel parcel) {
            return new VKAttachments(parcel);
        }

        /* Return type fixed from 'java.lang.Object[]' to match base method */
        @Override // android.os.Parcelable.Creator
        public VKAttachments[] newArray(int i) {
            return new VKAttachments[i];
        }
    }

    public VKAttachments() {
    }

    @Override // com.vk.sdk.api.model.VKList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void fill(JSONObject jSONObject) {
        super.fill(jSONObject, this.e);
    }

    public String toAttachmentsString() {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterator();
        while (it.hasNext()) {
            arrayList.add(((VKApiAttachment) it.next()).toAttachmentString());
        }
        return VKStringJoiner.join(arrayList, ",");
    }

    @Override // com.vk.sdk.api.model.VKList, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(size());
        Iterator it = iterator();
        while (it.hasNext()) {
            VKApiAttachment vKApiAttachment = (VKApiAttachment) it.next();
            parcel.writeString(vKApiAttachment.getType());
            parcel.writeParcelable(vKApiAttachment, 0);
        }
    }

    public void fill(JSONArray jSONArray) {
        super.fill(jSONArray, this.e);
    }

    public VKAttachments(VKApiAttachment... vKApiAttachmentArr) {
        super(Arrays.asList(vKApiAttachmentArr));
    }

    public VKAttachments(List<? extends VKApiAttachment> list) {
        super(list);
    }

    public VKAttachments(JSONObject jSONObject) {
        fill(jSONObject);
    }

    public VKAttachments(JSONArray jSONArray) {
        fill(jSONArray);
    }

    public VKAttachments(Parcel parcel) {
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            String readString = parcel.readString();
            if ("photo".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiPhoto.class.getClassLoader())));
            } else if ("video".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiVideo.class.getClassLoader())));
            } else if ("audio".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiAudio.class.getClassLoader())));
            } else if (TYPE_DOC.equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiDocument.class.getClassLoader())));
            } else if ("wall".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiPost.class.getClassLoader())));
            } else if (TYPE_POSTED_PHOTO.equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiPostedPhoto.class.getClassLoader())));
            } else if ("link".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiLink.class.getClassLoader())));
            } else if (TYPE_NOTE.equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiNote.class.getClassLoader())));
            } else if ("app".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiApplicationContent.class.getClassLoader())));
            } else if (TYPE_POLL.equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiPoll.class.getClassLoader())));
            } else if ("page".equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiWikiPage.class.getClassLoader())));
            } else if (TYPE_ALBUM.equals(readString)) {
                add((VKAttachments) ((VKApiAttachment) parcel.readParcelable(VKApiPhotoAlbum.class.getClassLoader())));
            }
        }
    }
}
