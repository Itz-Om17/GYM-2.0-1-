import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PDFGenerator {

    public static void generatePaymentReceipt(String paymentDetails, double amountPaid) throws IOException, DocumentException {
        String[] details = paymentDetails.split(",");
        String name = details[0];
        String upiId = details[1];
        String date = details[2];

        BaseColor topBlueColor = new BaseColor(0, 188, 242);   
        BaseColor lightBlueColor = new BaseColor(237, 247, 252); 
        BaseColor textColor = BaseColor.BLACK;

        Font titleFont = new Font(Font.FontFamily.HELVETICA, 30, Font.BOLD, textColor);
        Font headerFont = new Font(Font.FontFamily.HELVETICA, 16, Font.BOLD, textColor);
        Font labelFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD, textColor);
        Font valueFont = new Font(Font.FontFamily.HELVETICA, 12, Font.NORMAL, textColor);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String fileName = name + "_payment_receipt_" + timestamp + ".pdf";
        String userHome = System.getProperty("user.home");
        String filePath = userHome + File.separator + "Downloads" + File.separator + fileName;
        File pdfFile = new File(filePath);

        Document document = new Document(PageSize.A4, 50, 50, 50, 50); 
        try {
            PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
            document.open();

            Paragraph title = new Paragraph("FITCORE", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            PdfPTable topBarTable = new PdfPTable(1);
            topBarTable.setWidthPercentage(100);
            PdfPCell topBar = new PdfPCell(new Phrase(""));
            topBar.setBorder(Rectangle.NO_BORDER);
            topBar.setFixedHeight(15);
            topBar.setBackgroundColor(topBlueColor);
            topBarTable.addCell(topBar);
            document.add(topBarTable);
            
            document.add(Chunk.NEWLINE);

            PdfPTable receiptHeaderTable = new PdfPTable(1);
            receiptHeaderTable.setWidthPercentage(100);
            PdfPCell receiptHeaderCell = new PdfPCell(new Phrase("Payment Receipt", headerFont));
            receiptHeaderCell.setHorizontalAlignment(Element.ALIGN_CENTER);
            receiptHeaderCell.setBackgroundColor(lightBlueColor);
            receiptHeaderCell.setBorder(Rectangle.NO_BORDER);
            receiptHeaderCell.setPadding(10);
            receiptHeaderTable.addCell(receiptHeaderCell);
            document.add(receiptHeaderTable);

            document.add(Chunk.NEWLINE);

            PdfPTable contentTable = new PdfPTable(2);
            contentTable.setWidthPercentage(100);
            contentTable.setWidths(new float[]{1, 3});

            addTableRow(contentTable, "DATE:", date, labelFont, valueFont);

            addEmptyRow(contentTable, 2);

            PdfPCell memberInfoHeader = new PdfPCell(new Phrase("Member Information", headerFont));
            memberInfoHeader.setColspan(2);
            memberInfoHeader.setBorder(Rectangle.NO_BORDER);
            contentTable.addCell(memberInfoHeader);

            addTableRow(contentTable, "Name:", name, labelFont, valueFont);
            addTableRow(contentTable, "UPI ID:", upiId, labelFont, valueFont);

            addEmptyRow(contentTable, 2);

            PdfPCell paymentDetailsHeader = new PdfPCell(new Phrase("Payment Details", headerFont));
            paymentDetailsHeader.setColspan(2);
            paymentDetailsHeader.setBorder(Rectangle.NO_BORDER);
            contentTable.addCell(paymentDetailsHeader);

            addTableRow(contentTable, "Amount Paid:", "₹" + amountPaid, labelFont, valueFont);
            addTableRow(contentTable, "Payment Method:", "UPI", labelFont, valueFont);

            document.add(contentTable);

        } finally {
            if (document != null && document.isOpen()) {
                document.close();
            }
        }

        openPDF(pdfFile);
    }

    private static void addTableRow(PdfPTable table, String label, String value, Font labelFont, Font valueFont) {
        PdfPCell labelCell = new PdfPCell(new Phrase(label, labelFont));
        PdfPCell valueCell = new PdfPCell(new Phrase(value, valueFont));
        labelCell.setBorder(Rectangle.NO_BORDER);
        valueCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(labelCell);
        table.addCell(valueCell);
    }
    private static void addEmptyRow(PdfPTable table, int colspan) {
        PdfPCell emptyCell = new PdfPCell(new Phrase(" "));
        emptyCell.setColspan(colspan);
        emptyCell.setBorder(Rectangle.NO_BORDER);
        table.addCell(emptyCell);
    }

    private static void openPDF(File pdfFile) throws IOException {
        try {
            if (Desktop.isDesktopSupported()) {
                Desktop desktop = Desktop.getDesktop();
                if (pdfFile.exists()) {
                    desktop.open(pdfFile);
                }
            } else {
                String os = System.getProperty("os.name").toLowerCase();
                if (os.contains("linux")) {
                    Runtime.getRuntime().exec(new String[] {"xdg-open", pdfFile.getPath()});
                } else if (os.contains("mac")) {
                    Runtime.getRuntime().exec(new String[] {"open", pdfFile.getPath()});
                } else {
                    Runtime.getRuntime().exec(new String[] {"cmd", "/c", pdfFile.getPath()});
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("PDF was generated but could not be opened automatically.");
        }
    }
    
}