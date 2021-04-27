package tn.esprit.spring.Utility;

import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.Entity.Commande;

public class Pdf_facture {

	public static void generatePdf(String file_name, Commande commande) {
		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));

			document.open();

			document.add(new Paragraph(" "));
			Paragraph p = new Paragraph("Facture d'achat");
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);

			Image image = Image.getInstance("C:\\generer_pdf\\logo.PNG");
			image.scaleAbsoluteWidth(500);
			image.scaleAbsoluteHeight(92);
			image.setAlignment(Image.ALIGN_CENTER);
			document.add(image);

			document.add(new Paragraph(" "));
			Paragraph p3 = new Paragraph("A Tunis le 2021/04/28");
			p3.setAlignment(Paragraph.ALIGN_RIGHT);
			document.add(p3);
			document.add(new Paragraph(" "));

			document.add(new Paragraph(" "));
			document.add(new Paragraph("Details Commande"));
			document.add(new Paragraph(" "));

			PdfPTable tableDetailsCommande = new PdfPTable(5);
			tableDetailsCommande.setWidthPercentage(100);

			PdfPCell cell1;

			cell1 = new PdfPCell(new Phrase("Articles", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Quantité", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Prix Unitaire", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Totale", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Date de commande", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			///////////////////////////////////////////////////////////////////////////////////////////////////

			cell1 = new PdfPCell(new Phrase("Chemise ZARA, Table TV, Service fruits", FontFactory.getFont("Arial", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Chemise ZARA : 2, Table TV : 1, Service fruits : 1", FontFactory.getFont("Arial", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Chemise ZARA : 160 DNT, Table TV : 200 DNT, Service fruits : 80 DNT", FontFactory.getFont("Arial", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("440 Dinares", FontFactory.getFont("Arial", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("2021/04/27", FontFactory.getFont("Arial", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell1);
			
			document.add(tableDetailsCommande);

			///////////////////////////////////////////////////////////////////////////////////////////////////

			document.add(new Paragraph("Coordonnées client :"));
			document.add(new Paragraph("Nom : Mohamed Dhia"));
			document.add(new Paragraph("Prénom : Sediri"));
			document.add(new Paragraph("Adresse : Rue 8 Cité El Ghazzela - Ariana"));
			document.add(new Paragraph("Téléphone : 22333444"));
			document.add(new Paragraph("Nom Proprietaire : Mohamed Dhia Sediri"));
			document.add(new Paragraph("Type de Paiement : En ligne"));
			
			document.close();

			System.out.print("Generetion de facture en PDF effectuée");

		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
