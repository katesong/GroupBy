package GroupBy.GroupBy.bean;

import java.util.Arrays;

public class photo {
	private int photoId;
	private byte[] photo;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "photo [photoId=" + photoId + ", photo=" + Arrays.toString(photo) + ", getPhotoId()=" + getPhotoId()
				+ ", getPhoto()=" + Arrays.toString(getPhoto()) + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
