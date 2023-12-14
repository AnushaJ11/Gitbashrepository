package practice;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class ReadDataFromPDF {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		File fpdf = new File("D:\\MY Courses\\Selenium\\Core Java - Selenium (5) (1).pdf");
		PDDocument doc = new PDDocument().load(fpdf);
		int pages = doc.getNumberOfPages();
		System.out.println(pages);
		PDFTextStripper content = new PDFTextStripper();
		String EntirePdf = content.getText(doc);
		System.out.println(EntirePdf);
	}

}
