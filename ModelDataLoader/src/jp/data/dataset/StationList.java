package jp.data.dataset;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * 部品コードとステーションデータのデータセットをリスト化するクラス
 * @author kent2
 *
 */
public class StationList extends ArrayList<StationDataSet> {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/* (非 Javadoc)
	 * @see java.util.ArrayList#add(java.lang.Object)
	 */
	@Override
	public boolean add(StationDataSet e) {
		// TODO 自動生成されたメソッド・スタブ
		return super.add(e);
	}
	/**
	 * 引数のステーションに紐づいた部品コードを返します
	 * @param station ステーション
	 * @return 部品コード
	 * @exception NoSuchElementException 指定したステーションが存在しません
	 */
	public String getPartsCode(int station) throws NoSuchElementException {
		String partsCode = this.stream()
							   .filter(s -> s.getStation() == station)
							   .map(s -> s.getPartsCode())
							   .findFirst()
							   .get();
		return partsCode;
	}
	/**
	 * 引数の部品コードに紐づいたステーションを返します
	 * @param partsCode 部品コード
	 * @return ステーション
	 * @throws NoSuchElementException 指定した部品コードが存在しません
	 */
	public int getStation(String partsCode) throws NoSuchElementException {
		int station = this.stream()
							   .filter(s -> s.getPartsCode().equals(partsCode))
							   .mapToInt(s -> s.getStation())
							   .findFirst()
							   .getAsInt();
		return station;
	}
	/**
	 * ２つのStationListオブジェクトからステーションの共通性を判定します
	 * @param stationList ステーションリスト
	 * @return ステーションの共通性
	 */
	public boolean isCommonStation(StationList stationList) {
		if(this.size() == 0 && stationList.size() == 0) {
			return true;
		}else if(this.size() == 0) {
			return false;
		}
		for(StationDataSet dataSet : this) {
			boolean flag;
			//このオブジェクトのデータを取得する
			int station = dataSet.getStation();
			String partsCode = dataSet.getPartsCode();
			//引数のオブジェクトのデータを取得する
			try {
				int argumentStation = stationList.getStation(partsCode);
				flag = station == argumentStation;
			}catch(NoSuchElementException e) {
				return false;
			}
			//ステーションが同じか判定する
			if(flag == false) {
				return false;
			}
		}
		return true;
	}
}
