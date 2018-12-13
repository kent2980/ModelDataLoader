package jp.data.dataset;

/**
 * 部品コードとステーションデータのデータセットクラス
 * @author kent2
 *
 */
public class StationDataSet {
	private final int station;
	private final String partsCode;

	/**
	 * 部品コードとステーションデータのオブジェクトを作成します
	 * @param partsCode 部品コード
	 * @param station ステーション
	 */
	public StationDataSet(int station, String partsCode) {
		this.partsCode = partsCode;
		this.station = station;
	}
	/**
	 * 部品コードを返します
	 * @return partsCode 部品コード
	 */
	public String getPartsCode() {
		return partsCode;
	}
	/**
	 * ステーションデータを返します
	 * @return station ステーション
	 */
	public int getStation() {
		return station;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StationDataSet [ステーション=" + station + ", 部品コード=" + partsCode + "]";
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((partsCode == null) ? 0 : partsCode.hashCode());
		result = prime * result + station;
		return result;
	}
	/* (非 Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StationDataSet other = (StationDataSet) obj;
		if (partsCode == null) {
			if (other.partsCode != null)
				return false;
		} else if (!partsCode.equals(other.partsCode))
			return false;
		if (station != other.station)
			return false;
		return true;
	}
}
