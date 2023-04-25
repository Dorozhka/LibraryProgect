
package manager;

import java.io.File;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelProvider {
    private File file;
    private XSSFWorkbook workbook;

    public ExcelProvider(String path){
        file = new File(path);
    }
    public void Open() throws IOException, InvalidFormatException{
        workbook = new XSSFWorkbook(file);
    }
    public String randomOfName(String nameOfSheet, int numberOfCollum) throws IOException, InvalidFormatException{
        String randomName = null;
        XSSFSheet sheet;
        Open();
        sheet = workbook.getSheet(nameOfSheet);
        int numberOfName = sheet.getLastRowNum();
        Row row = sheet.getRow(0);
        for(int i = 0; i<= sheet.getLastRowNum(); i++){
            row = sheet.getRow(i);
            if(row.getCell(numberOfCollum)==null){
                numberOfName = i-1;
                break;
            }
        }
        int random = (int)Math.round(Math.random()*(numberOfName));
        row = sheet.getRow(random);
        randomName = row.getCell(numberOfCollum).getStringCellValue();
        Close();
        return randomName;
    }
    public void Close() throws IOException{
        workbook.close();
    }
}
