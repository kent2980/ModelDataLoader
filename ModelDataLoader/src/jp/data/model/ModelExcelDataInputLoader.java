/**
 *
 */
package jp.data.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import jp.data.dataset.StationDataSet;

/**
 * モデルデータをエクセルファイルからインプットするクラスです
 * @author kent2
 *
 */
public class ModelExcelDataInputLoader extends ModelDataInputLoader {
	private String filePath;
	@SuppressWarnings("unused")
	private Sheet sheet;

	/**
	 * コンストラクタ
	 */
	public ModelExcelDataInputLoader() {}

	/**
	 * コンストラクタ
	 * @param filePath ファイルパス
	 * @throws IOException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 * @throws InvalidFormatException 依存ライブラリーが足りないために発生している場合。
	 * @throws EncryptedDocumentException パスワードがかかっているExcelファイルを読み込んだ際に発生する例外
	 */
	public ModelExcelDataInputLoader(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.filePath = filePath;
		setFilePath(filePath);
	}

	/**
	 * エクセルファイルのパスを返します
	 * @return filePath ファイルパス
	 */
	public String getFilePath() {
		return filePath;
	}

	/* (非 Javadoc)
	 * @see jp.data.model.ModelDataInputLoader#setComment(java.lang.String)
	 */
	@Override
	protected void setComment() {
		Row row = sheet.getRow(7);
		Cell cell = row.getCell(1);
		this.comment = cell.getStringCellValue();
	}

	/**
	 * エクセルファイルのファイルパスを設定します
	 * @param filePath セットする filePath
	 * @throws IOException ファイルが存在しないか、通常ファイルではなくディレクトリであるか、またはなんらかの理由で開くことができない場合。
	 * @throws InvalidFormatException 依存ライブラリーが足りないために発生している場合。
	 * @throws EncryptedDocumentException パスワードがかかっているExcelファイルを読み込んだ際に発生する例外
	 */
	public void setFilePath(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException {
		this.filePath = filePath;
		InputStream inputStream = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(inputStream);
		sheet = workbook.getSheetAt(0);
		setComment();
		setKanriNo();
		setMachineName();
		setModelName();
		setSubstrateName();
		setSolderCode();
		setSolderMaskCode();
		setSubstrateCode();
		setReelStationList();
		setTrayStationList();
	}

	/* (非 Javadoc)
	 * @see jp.data.model.ModelDataInputLoader#setKanriNo(java.lang.String)
	 */
	@Override
	protected void setKanriNo() {
		Row row = sheet.getRow(1);
		Cell cell = row.getCell(1);
		this.kanriNo = cell.getStringCellValue();
	}

	/* (非 Javadoc)
	 * @see jp.data.model.ModelDataInputLoader#setMachineName(java.lang.String)
	 */
	@Override
	protected void setMachineName() {
		Row row = sheet.getRow(5);
		Cell cell = row.getCell(1);
		this.machineName = cell.getStringCellValue();
	}

	/* (非 Javadoc)
	 * @see jp.data.model.ModelDataInputLoader#setModelName(java.lang.String)
	 */
	@Override
	protected void setModelName() {
		Row row = sheet.getRow(3);
		Cell cell = row.getCell(1);
		this.modelName = cell.getStringCellValue();
	}
	/* (非 Javadoc)
	 * @see jp.data.model.ModelDataInputLoader#setSubstrateName(java.lang.String)
	 */
	@Override
	protected void setSubstrateName() {
		Row row = sheet.getRow(6);
		Cell cell = row.getCell(1);
		this.substrateName = cell.getStringCellValue();
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setSolderCode() {
		int lastRow = sheet.getLastRowNum();
		for(int i = 10; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell stationCell = row.getCell(0);
			Cell partsCodeCell = row.getCell(1);
			int station = 0;
			switch(stationCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				station = Integer.valueOf(stationCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				station = (int) stationCell.getNumericCellValue();
			}
			String partsCode = partsCodeCell.getStringCellValue();
			if(station == 2) {
				this.solderCode = partsCode;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setSolderMaskCode() {
		int lastRow = sheet.getLastRowNum();
		for(int i = 10; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell stationCell = row.getCell(0);
			Cell partsCodeCell = row.getCell(1);
			int station = 0;
			switch(stationCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				station = Integer.valueOf(stationCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				station = (int) stationCell.getNumericCellValue();
			}
			String partsCode = partsCodeCell.getStringCellValue();
			if(station == 3) {
				this.solderMaskCode = partsCode;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setSubstrateCode() {
		int lastRow = sheet.getLastRowNum();
		for(int i = 10; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell stationCell = row.getCell(0);
			Cell partsCodeCell = row.getCell(1);
			int station = 0;
			switch(stationCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				station = Integer.valueOf(stationCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				station = (int) stationCell.getNumericCellValue();
			}
			String partsCode = partsCodeCell.getStringCellValue();
			if(station == 1) {
				this.substrateCode = partsCode;
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setReelStationList() {
		int lastRow = sheet.getLastRowNum();
		for(int i = 10; i <= lastRow; i++) {
			Row row = sheet.getRow(i);
			Cell stationCell = row.getCell(0);
			Cell partsCodeCell = row.getCell(1);
			int station = 0;
			switch(stationCell.getCellType()) {
			case Cell.CELL_TYPE_STRING:
				station = Integer.valueOf(stationCell.getStringCellValue());
				break;
			case Cell.CELL_TYPE_NUMERIC:
				station = (int) stationCell.getNumericCellValue();
			}
			String partsCode = partsCodeCell.getStringCellValue();
			if(station > 100) {
				StationDataSet dataSet = new StationDataSet(station, partsCode);
				boolean timFlag = machineName.contains("5100");
				if(timFlag == true) {
					if(station < 300) {
						reelStationList.add(dataSet);
					}
				}else {
					reelStationList.add(dataSet);
				}
			}
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void setTrayStationList() {
		boolean timFlag = machineName.contains("5100");
		if(timFlag == true) {
			int lastRow = sheet.getLastRowNum();
			for(int i = 10; i <= lastRow; i++) {
				Row row = sheet.getRow(i);
				Cell stationCell = row.getCell(0);
				Cell partsCodeCell = row.getCell(1);
				int station = 0;
				switch(stationCell.getCellType()) {
				case Cell.CELL_TYPE_STRING:
					station = Integer.valueOf(stationCell.getStringCellValue());
					break;
				case Cell.CELL_TYPE_NUMERIC:
					station = (int) stationCell.getNumericCellValue();
				}
				String partsCode = partsCodeCell.getStringCellValue();
				if(station > 300) {
					StationDataSet dataSet = new StationDataSet(station, partsCode);
					trayStationList.add(dataSet);
				}
			}
		}
	}

}
