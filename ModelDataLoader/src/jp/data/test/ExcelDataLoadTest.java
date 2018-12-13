package jp.data.test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import jp.data.dataset.StationDataSet;
import jp.data.model.ModelExcelDataInputLoader;

public class ExcelDataLoadTest {

	public static void main(String[] args) {
		ModelExcelDataInputLoader loader = new ModelExcelDataInputLoader();
		String path = "D:\\sample\\段取りサポートリスト.xls";
		try {
			loader.setFilePath(path);
			System.out.println("管理No：" + loader.getKanriNo());
			System.out.println("機種名：" + loader.getModelName());
			System.out.println("マシン名称：" + loader.getMachineName());
			System.out.println("基板名称：" + loader.getSubstrateName());
			System.out.println("コメント：" + loader.getComment());
			System.out.println("基板コード：" + loader.getSubstrateCode());
			System.out.println("はんだ：" + loader.getSolderCode());
			System.out.println("はんだマスク：" + loader.getSolderMaskCode());
			System.out.println("リール部材：");
			for(StationDataSet set : loader.getReelStationList()) {
				System.out.println(set);
			}
			System.out.println("トレイ部材：");
			for(StationDataSet set : loader.getTrayStationList()) {
				System.out.println(set);
			}
		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}
