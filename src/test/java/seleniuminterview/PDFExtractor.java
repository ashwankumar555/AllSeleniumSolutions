package seleniuminterview;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class PDFExtractor {
    public static String extractTextFromPDF(String filePath) throws IOException {
        PDDocument document = PDDocument.load(new File(filePath));
        PDFTextStripper pdfStripper = new PDFTextStripper();
        String text = pdfStripper.getText(document);
        document.close();
        return text;
    }

    public static void main(String[] args) {
        try {
            String extractedText = extractTextFromPDF("C:\\Users\\user\\OneDrive\\Desktop\\CV\\Ashwin Kumar Ganji.pdf");
            System.out.println("Extracted Text:\n" + extractedText);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

