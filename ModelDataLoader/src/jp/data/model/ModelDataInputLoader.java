/**
 *
 */
package jp.data.model;

import jp.data.dataset.StationList;

/**
 * モデルデータをインプットするための抽象クラス
 * @author kent2
 *
 */
public abstract class ModelDataInputLoader {
	protected String kanriNo;
	protected String modelName;
	protected String machineName;
	protected String substrateName;
	protected String comment;
	protected StationList reelStationList;
	protected StationList trayStationList;
	protected String substrateCode;
	protected String solderCode;
	protected String solderMaskCode;

	/**
	 * コンストラクタ
	 */
	public ModelDataInputLoader() {
		reelStationList = new StationList();
		trayStationList = new StationList();
	}
	/**　
	 * コメントを返します
	 * @return comment コメント
	 */
	public String getComment() {
		return comment;
	}
	/**
	 * 管理Noを返します
	 * @return kanriNo 管理No
	 */
	public String getKanriNo() {
		return kanriNo;
	}
	/**
	 * マシン名称を返します
	 * @return machineName マシン名称
	 */
	public String getMachineName() {
		return machineName;
	}
	/**
	 * 機種名を返します
	 * @return modelName 機種名
	 */
	public String getModelName() {
		return modelName;
	}
	/** 半田の部品コードを返します
	 * @return solderCode 半田の部品コード
	 */
	public String getSolderCode() {
		return solderCode;
	}
	/**
	 * 半田マスクの部品コードを返します
	 * @return solderMaskCode 半田マスクの部品コード
	 */
	public String getSolderMaskCode() {
		return solderMaskCode;
	}
	/**
	 * 基板の部品コードを返します
	 * @return substrateCode 基板の部品コード
	 */
	public String getSubstrateCode() {
		return substrateCode;
	}
	/**
	 * 基板名称を返します
	 * @return substrateName 基板名
	 */
	public String getSubstrateName() {
		return substrateName;
	}
	/**
	 * コメントを読み込みます
	 * @param comment セットする comment
	 */
	abstract protected void setComment();
	/**
	 * 管理Noを読み込みます
	 * @param kanriNo セットする kanriNo
	 */
	abstract protected void setKanriNo();
	/**
	 * マシン名称を読み込みます
	 * @param machineName セットする machineName
	 */
	abstract protected void setMachineName();
	/**
	 * 機種名を読み込みます
	 * @param modelName セットする modelName
	 */
	abstract protected void setModelName();
	/**
	 * 半田の部品コードを読み込みます
	 * @param solderCode セットする solderCode
	 */
	abstract protected void setSolderCode();
	/**
	 * 半田マスクの部品コードを読み込みます
	 * @param solderMaskCode セットする solderMaskCode
	 */
	abstract protected void setSolderMaskCode();
	/**
	 * 基板の部品コードを読み込みます
	 * @param substrateCode セットする substrateCode
	 */
	abstract protected void setSubstrateCode();
	/**
	 * 基板名称を読み込みます
	 * @param substrateName セットする substrateName
	 */
	abstract protected void setSubstrateName();
	/**
	 * リール部材のステーションリストを読み込みます
	 * @return reelStationList
	 */
	public StationList getReelStationList() {
		return reelStationList;
	}
	/**
	 * トレイ部材のステーションリストを読み込みます
	 * @return trayStationList
	 */
	public StationList getTrayStationList() {
		return trayStationList;
	}
	/**
	 * リール部材のステーションリストを返します
	 * @param reelStationList セットする reelStationList
	 */
	abstract protected void setReelStationList();
	/**
	 * トレイ部材のステーションリストを返します
	 * @param trayStationList セットする trayStationList
	 */
	abstract protected void setTrayStationList();

}
