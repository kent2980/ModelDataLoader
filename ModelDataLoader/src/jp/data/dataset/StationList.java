package jp.data.dataset;

import java.util.ArrayList;

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
}
