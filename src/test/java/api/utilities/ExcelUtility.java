package api.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlFile, String xlsheet) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	public static int getCellCount(String xlFile, String xlsheet, int rownum) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static String getCellData(String xlFile, String xlsheet, int rownum, int colnum) throws Exception {
		fi = new FileInputStream(xlFile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	    row = ws.getRow(rownum);
	    cell = row.getCell(colnum);
	    String data;
	    try {
	        DataFormatter formatter = new DataFormatter();
	        data = formatter.formatCellValue(cell);
	    } catch (Exception e) {
	        data = "";
	    }
	    wb.close();
	    fi.close();
	    return data;
	}
	public static int getCellCount(String xlFile, String xlsheet) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int cellCount = ws.getRow(0).getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static void setCellData(String xlFile, String xlsheet, int rownum, int colnum, String data) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillGreenColor(String xlFile, String xlsheet, int rownum, int colnum) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();
		style.setFillForegroundColor((IndexedColors.GREEN.getIndex()));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillRedColor(String xlFile, String xlsheet, int rownum, int colnum) throws Exception {
		fi = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		style = wb.createCellStyle();
		style.setFillForegroundColor((IndexedColors.RED.getIndex()));
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cell.setCellStyle(style);
		fo = new FileOutputStream(xlFile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void main(String[] args) {
}

}
