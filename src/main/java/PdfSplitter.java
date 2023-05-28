
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class PdfSplitter {
    public static void main(String[] args) {
        String inputFilePath = "/Users/tharunnaidu/CC MODULE-4.pdf";

        try {
            PDDocument document = PDDocument.load(new File(inputFilePath));

            Splitter splitter = new Splitter();

            List<PDDocument> splitDocuments = splitter.split(document);


            Iterator<PDDocument> iterator = splitDocuments.listIterator();
            int partNumber = 1;
            while (iterator.hasNext()) {
                PDDocument splitDocument = iterator.next();
                String outputFilePath = "/Users/tharunnaidu/Movies" + partNumber + ".pdf";
                splitDocument.save(outputFilePath);
                splitDocument.close();
                System.out.println("Split document saved: " + outputFilePath);
                partNumber++;
            }

            document.close();

            System.out.println("PDF splitting completed successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

