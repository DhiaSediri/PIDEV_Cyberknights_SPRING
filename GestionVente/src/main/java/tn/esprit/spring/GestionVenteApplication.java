package tn.esprit.spring;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAutoConfiguration
@EnableAspectJAutoProxy
@SpringBootApplication
public class GestionVenteApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionVenteApplication.class, args);
		/*
		try{
			Pdf.generatePdf("C:\\generer_pdf\\facture.pdf", commande);				
		} catch (Exception e){
			System.err.print(e);
		}
		
		try {
			Mail.sendMail("mohameddhia.sediri@esprit.tn", "C:/generer_pdf/facture.pdf");
		} catch (Exception e) {
			System.err.println(e);
		}	
		*/
	}

	@Bean
	public ModelMapper modelMapper() {
	    return new ModelMapper();
	}
}
