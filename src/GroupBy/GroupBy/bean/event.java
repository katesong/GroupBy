package GroupBy.GroupBy.bean;

import java.sql.Date;

public class event {
	private Long eventId;
	private Long nemberId;
	private String local;
	private Date date;
	private String descEvent;
	private int photoIdCalendar;
	private int photoIdMap;
	private String evetType;

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getNemberId() {
		return nemberId;
	}

	public void setNemberId(Long nemberId) {
		this.nemberId = nemberId;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescEvent() {
		return descEvent;
	}

	public void setDescEvent(String descEvent) {
		this.descEvent = descEvent;
	}

	public int getPhotoIdCalendar() {
		return photoIdCalendar;
	}

	public void setPhotoIdCalendar(int photoIdCalendar) {
		this.photoIdCalendar = photoIdCalendar;
	}

	public int getPhotoIdMap() {
		return photoIdMap;
	}

	public void setPhotoIdMap(int photoIdMap) {
		this.photoIdMap = photoIdMap;
	}

	public String getEvetType() {
		return evetType;
	}

	public void setEvetType(String evetType) {
		this.evetType = evetType;
	}

	@Override
	public String toString() {
		return "event [eventId=" + eventId + ", nemberId=" + nemberId + ", local=" + local + ", date=" + date
				+ ", descEvent=" + descEvent + ", photoIdCalendar=" + photoIdCalendar + ", photoIdMap=" + photoIdMap
				+ ", evetType=" + evetType + "]";
	}

}
