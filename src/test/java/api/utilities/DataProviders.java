package api.utilities;

import org.testng.annotations.DataProvider;

import api.payload.User;

import java.io.File;
public class DataProviders {
	

//    @DataProvider(name = "Userdata")
//    public String[][] getAllUserData() throws Exception {
//    	String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
//
//        
//        int rowCount = ExcelUtility.getRowCount(path, "Sheet1");
//        int colCount = ExcelUtility.getCellCount(path, "Sheet1", 1);
//        
//        String userData[][] = new String[rowCount][colCount];
//        for (int i = 1; i <= rowCount; i++) {
//			for (int j = 0; j < colCount; j++) {
//				userData[i - 1][j] = ExcelUtility.getCellData(path, "Sheet1", i, j);
//			}
//		}
//		return userData;
//}
//    
//    @DataProvider(name = "UserNames")
//	public String[] getUserDataFromExcel() throws Exception {
//    	String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
//
//		
//		int rowCount = ExcelUtility.getRowCount(path, "Sheet1");
//		
//		String userData[]= new String[rowCount];
//		
//		for (int i = 1; i <= rowCount; i++) {
//			userData[i - 1] = ExcelUtility.getCellData(path, "Sheet1", i, 1);
//		}
//		
//		return userData;
//	}

	 @DataProvider(name = "Userdata")
	    public String[][] getAllUserData() throws Exception {
	        String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
	        String sheet = "Sheet1";

	        int rowCount = ExcelUtility.getRowCount(path, sheet);
	        int colCount = ExcelUtility.getCellCount(path, sheet, 1);

	        // First, count how many rows are non-empty (by checking first column, i.e., UserID)
	        int validRowCount = 0;
	        for (int i = 1; i <= rowCount; i++) {
	            String cellValue = ExcelUtility.getCellData(path, sheet, i, 0);
	            if (cellValue != null && !cellValue.trim().isEmpty()) {
	                validRowCount++;
	            }
	        }

	        // Now, collect valid data only
	        String[][] userData = new String[validRowCount][colCount];
	        int dataIndex = 0;
	        for (int i = 1; i <= rowCount; i++) {
	            String cellValue = ExcelUtility.getCellData(path, sheet, i, 0);
	            if (cellValue != null && !cellValue.trim().isEmpty()) {
	                for (int j = 0; j < colCount; j++) {
	                    userData[dataIndex][j] = ExcelUtility.getCellData(path, sheet, i, j);
	                }
	                dataIndex++;
	            }
	        }

	        return userData;
	    }

	    @DataProvider(name = "UserNames")
	    public String[] getUserDataFromExcel() throws Exception {
	        String path = System.getProperty("user.dir") + "/testData/Userdata.xlsx";
	        String sheet = "Sheet1";

	        int rowCount = ExcelUtility.getRowCount(path, sheet);

	        // Count valid rows based on username (column index 1)
	        int validCount = 0;
	        for (int i = 1; i <= rowCount; i++) {
	            String username = ExcelUtility.getCellData(path, sheet, i, 1);
	            if (username != null && !username.trim().isEmpty()) {
	                validCount++;
	            }
	        }

	        // Collect usernames
	        String[] userData = new String[validCount];
	        int index = 0;
	        for (int i = 1; i <= rowCount; i++) {
	            String username = ExcelUtility.getCellData(path, sheet, i, 1);
	            if (username != null && !username.trim().isEmpty()) {
	                userData[index] = username;
	                index++;
	            }
	        }

	        return userData;
	    }
	
}
	
