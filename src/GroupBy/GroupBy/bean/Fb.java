package GroupBy.GroupBy.bean;

import java.util.Arrays;

public class Fb {
	private Long fbId;
	private Long textId;
	private String descText;
	private byte[] descPhoto;

	public Long getFbId() {
		return fbId;
	}

	public void setFbId(Long fbId) {
		this.fbId = fbId;
	}

	public Long getTextId() {
		return textId;
	}

	public void setTextId(Long textId) {
		this.textId = textId;
	}

	public String getDescText() {
		return descText;
	}

	public void setDescText(String descText) {
		this.descText = descText;
	}

	public byte[] getDescPhoto() {
		return descPhoto;
	}

	public void setDescPhoto(byte[] descPhoto) {
		this.descPhoto = descPhoto;
	}

	@Override
	public String toString() {
		return "fb [fbId=" + fbId + ", textId=" + textId + ", descText=" + descText + ", descPhoto="
				+ Arrays.toString(descPhoto) + ", getFbId()=" + getFbId() + ", getTextId()=" + getTextId()
				+ ", getDescText()=" + getDescText() + ", getDescPhoto()=" + Arrays.toString(getDescPhoto())
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

}
