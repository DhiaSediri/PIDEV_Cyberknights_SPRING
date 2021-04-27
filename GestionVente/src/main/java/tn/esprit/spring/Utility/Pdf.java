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
import tn.esprit.spring.Entity.DetailsCommande;

public class Pdf {

	public static void generatePdf(String file_name, Commande commande) {

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));

			document.open();

			document.add(new Paragraph(" "));
			Paragraph p = new Paragraph("Facture d'achat");
			p.setAlignment(Paragraph.ALIGN_CENTER);
			document.add(p);
			document.add(new Paragraph(" "));

			Image image = Image.getInstance("C:\\generer_pdf\\logo.PNG");
			image.scaleAbsoluteWidth(500);
			image.scaleAbsoluteHeight(92);
			image.setAlignment(Image.ALIGN_CENTER);
			document.add(image);

			document.add(new Paragraph(" "));
			Paragraph p2 = new Paragraph("Facture № " + commande.getFacture().getId());
			p2.setAlignment(Paragraph.ALIGN_LEFT);
			document.add(p2);
			document.add(new Paragraph(" "));

			document.add(new Paragraph(" "));
			Paragraph p3 = new Paragraph("A Tunis le " + String.valueOf(new Date()));
			p3.setAlignment(Paragraph.ALIGN_RIGHT);
			document.add(p3);
			document.add(new Paragraph(" "));

			//////////////////////////////////////////////////////////////////////////////////////////
			document.add(new Paragraph(" "));
			document.add(new Paragraph("Details Commande"));
			document.add(new Paragraph(" "));

			PdfPTable tableDetailsCommande = new PdfPTable(5);
			tableDetailsCommande.setWidthPercentage(100);

			PdfPCell cell1;

			cell1 = new PdfPCell(new Phrase("Nom Produit", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			cell1 = new PdfPCell(new Phrase("Quantité demandée", FontFactory.getFont("Comic Sans MS", 11)));
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

			cell1 = new PdfPCell(
					new Phrase("Date de validation de commande", FontFactory.getFont("Comic Sans MS", 11)));
			cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell1.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell1);

			//////////////////////////////////////////////////////////////////////////////////////////
			// détails du commande
			for (DetailsCommande dc : commande.getDetailsCommandes()) {

				cell1 = new PdfPCell(new Phrase(dc.getProduit().getNom(), FontFactory.getFont("Arial", 11)));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tableDetailsCommande.addCell(cell1);

				cell1 = new PdfPCell(
						new Phrase(String.valueOf(dc.getQuantite_produit()), FontFactory.getFont("Arial", 11)));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tableDetailsCommande.addCell(cell1);

				cell1 = new PdfPCell(
						new Phrase(String.valueOf(dc.getProduit().getPrix()), FontFactory.getFont("Arial", 11)));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tableDetailsCommande.addCell(cell1);

				cell1 = new PdfPCell(new Phrase(String.valueOf(dc.getQuantite_produit() * dc.getProduit().getPrix()),
						FontFactory.getFont("Arial", 11)));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tableDetailsCommande.addCell(cell1);

				cell1 = new PdfPCell(new Phrase(String.valueOf(commande.getDateValidationCommande()),
						FontFactory.getFont("Arial", 11)));
				cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
				tableDetailsCommande.addCell(cell1);

				document.add(new Paragraph(" "));
				document.add(new Paragraph("Coordonnées Client"));
				document.add(new Paragraph(" "));
			}
			//////////////////////////////////////////////////////////////////////////////////////
			PdfPTable tableCoordonneesClient = new PdfPTable(5);
			tableDetailsCommande.setWidthPercentage(100);

			PdfPCell cell2;

			cell2 = new PdfPCell(new Phrase("Nom", FontFactory.getFont("Comic Sans MS", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase("Prenom", FontFactory.getFont("Comic Sans MS", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase("Adresse", FontFactory.getFont("Comic Sans MS", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase("Nom Proprietaire", FontFactory.getFont("Comic Sans MS", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase("Type de Paiement", FontFactory.getFont("Comic Sans MS", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.GRAY);
			tableCoordonneesClient.addCell(cell2);

			//////////////////////////////////////////////////////////////////////////////////////
			// coordonnees du client
			cell2 = new PdfPCell(new Phrase(commande.getClient().getNom(), FontFactory.getFont("Arial", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase(commande.getClient().getPrenom(), FontFactory.getFont("Arial", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase(commande.getClient().getAdresse(), FontFactory.getFont("Arial", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(
					new Phrase(commande.getPaiement().getNomProprietaire(), FontFactory.getFont("Arial", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableDetailsCommande.addCell(cell2);

			cell2 = new PdfPCell(new Phrase(String.valueOf(commande.getPaiement().getTypePaiement()),
					FontFactory.getFont("Arial", 11)));
			cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell2.setBackgroundColor(BaseColor.LIGHT_GRAY);
			tableCoordonneesClient.addCell(cell2);

			document.add(tableDetailsCommande);
			document.add(tableCoordonneesClient);

			document.close();

			System.out.print("Generetion de facture en PDF effectuée");

		} catch (Exception e) {
			System.err.print(e);
		}
	}
}
