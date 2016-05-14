package GroupBy.GroupBy.bean;

public class calendarId {
	private Long calendarId;
	private Long eventId;

	public Long getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(Long calendarId) {
		this.calendarId = calendarId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	@Override
	public String toString() {
		return "calendarId [calendarId=" + calendarId + ", eventId=" + eventId + ", getCalendarId()=" + getCalendarId()
				+ ", getEventId()=" + getEventId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
