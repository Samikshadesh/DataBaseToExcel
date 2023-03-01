
package com.Hcc.ExportToExcel.service;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.Hcc.ExportToExcel.entity.Customer;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

public class ExcelExportUtils {
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	private List<Customer> customerList;//export data to xlsx file

	public ExcelExportUtils(List<Customer> customerList) {
		this.customerList = customerList;
		workbook = new XSSFWorkbook();
	}
	
//we don't know about data comming in which data types
	private void createCells(Row row, int columnCount, Object value, CellStyle style) {
		sheet.autoSizeColumn(columnCount);//resize as per the no of column
		Cell cell = row.createCell(columnCount);//it creates number of cells based on number of column(attribute) we have
		//don't about value(data type) coming to this cells
		if (value instanceof Integer) {
			cell.setCellValue((Integer) value);
		} else if (value instanceof Double) {
			cell.setCellValue((Double) value);
		} else if (value instanceof Boolean) {
			cell.setCellValue((Boolean) value);
		} else if (value instanceof Long) {
			cell.setCellValue((Long) value);
		} else {
			cell.setCellValue((String) value);
		}
		cell.setCellStyle(style);//set style

	}

	private void createHeaderRow() {
		sheet = workbook.createSheet("Customer Information");//sheet name
		Row row = sheet.createRow(0);//first row
		CellStyle style = workbook.createCellStyle();//workbook style
		XSSFFont font = workbook.createFont();//workbook font
		font.setBold(true);//header row
		font.setFontHeight(20);
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		createCells(row, 0, "Customer Information", style);
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 8));//number of column
		font.setFontHeightInPoints((short) 10);

		row = sheet.createRow(1);// header
		font.setBold(true);
		font.setFontHeight(16);
		style.setFont(font);

		createCells(row, 0, "ID", style);
		createCells(row, 1, "FirstName", style);
		createCells(row, 2, "LastName", style);
		createCells(row, 3, "Email", style);
		createCells(row, 4, "Country", style);
		createCells(row, 5, "State", style);
		createCells(row, 6, "City", style);
		createCells(row, 7, "Address", style);

	}

	private void writeCustomerData() {
		int rowCount = 2;
		CellStyle style = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontHeight(14);
		style.setFont(font);

		for (Customer customer : customerList) {
			Row row = sheet.createRow(rowCount++);
			int columnCount = 0;
			createCells(row, columnCount++, customer.getId(), style);
			createCells(row, columnCount++, customer.getFirstName(), style);
			createCells(row, columnCount++, customer.getLastName(), style);
			createCells(row, columnCount++, customer.getEmail(), style);
			createCells(row, columnCount++, customer.getAddress().getCountry(), style);
			createCells(row, columnCount++, customer.getAddress().getState(), style);
			createCells(row, columnCount++, customer.getAddress().getCity(), style);
			createCells(row, columnCount++, customer.getAddress().getAddress(), style);

		}

	}

	public void exportDataToExcel(HttpServletResponse response) throws IOException {
		createHeaderRow();
		writeCustomerData();
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

}
