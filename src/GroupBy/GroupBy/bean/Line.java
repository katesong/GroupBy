package GroupBy.GroupBy.bean;

public class Line {
	private Long lineId;
	private Long historyId;
	private String desc;

	public Long getLineId() {
		return lineId;
	}

	public void setLineId(Long lineId) {
		this.lineId = lineId;
	}

	public Long getHistoryId() {
		return historyId;
	}

	public void setHistoryId(Long historyId) {
		this.historyId = historyId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Override
	public String toString() {
		return "line [lineId=" + lineId + ", historyId=" + historyId + ", desc=" + desc + ", getLineId()=" + getLineId()
				+ ", getHistoryId()=" + getHistoryId() + ", getDesc()=" + getDesc() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
