import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {

    static FileInputStream fis;

    public FileInputStream getFileInputStream(){
        String filePath = System.getProperty("user.dir")+"/src/Data/TestData.xlsx";
        File srcFile = new File(filePath);
        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("ERROR occurred"+e.getMessage());;
        }
        return fis;
    }

    public Object [][]  getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);
        int numberOfRows = (sheet.getLastRowNum()+1);
        int numberOfColumns = 2;

        String[][] arrayExcelData = new String[numberOfRows][numberOfColumns];
        for(int i =0;i<numberOfRows;i++){
            for (int j=0; j<numberOfColumns;j++){
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;
    }

}
