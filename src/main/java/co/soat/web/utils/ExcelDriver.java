package co.soat.web.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jline.utils.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExcelDriver {
    private Map<Integer, Map<Integer, String>> fullList = new TreeMap<>();
    private Map<Integer, String> data = new TreeMap<>();
    private static final String NUMERIC = "NUMERIC";

    public Map<Integer, Map<Integer, String>> loadDataDrive(String fileName, Integer... sheetNumber) {
        String filePath = "src/test/resources/" + fileName;

        int columnNumber;
        int rowNumber;

        try (FileInputStream file = new FileInputStream(new File(filePath))) {
            XSSFWorkbook worbook = new XSSFWorkbook(file);
            XSSFSheet sheet = null;
            if (sheetNumber.length == 0) {
                sheet = worbook.getSheetAt(0);
            } else {
                sheet = worbook.getSheetAt(sheetNumber[0]);
            }
            worbook.close();
            Iterator<Row> rowIterator = sheet.iterator();
            Row row;
            rowNumber = 0;
            while (rowIterator.hasNext()) {
                columnNumber = 0;
                row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                Cell cell;
                while (cellIterator.hasNext()) {
                    cell = cellIterator.next();
                    CellType cellType = cell.getCellTypeEnum();
                    String type = cellType.toString();
                    if (type.equals(NUMERIC)) {
                        long numericData = (long) cell.getNumericCellValue();
                        data.put(columnNumber, String.valueOf(numericData));
                    } else {
                        data.put(columnNumber, cell.getStringCellValue());

                    }
                    columnNumber++;
                }
                fullList.put(rowNumber, data);
                data = new TreeMap<>();
                rowNumber++;
            }
        } catch (IOException e) {
            Log.error("error: Could not get the datadriven", e);
        }
        return fullList;
    }
}
