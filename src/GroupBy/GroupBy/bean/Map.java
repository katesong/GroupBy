package GroupBy.GroupBy.bean;

public class Map {
	private Long mapId;
	private Long eventId;

	@Override
	public String toString() {
		return "map [mapId=" + mapId + ", eventId=" + eventId + ", getMapId()=" + getMapId() + ", getEventId()="
				+ getEventId() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public Long getMapId() {
		return mapId;
	}

	public void setMapId(Long mapId) {
		this.mapId = mapId;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

}
