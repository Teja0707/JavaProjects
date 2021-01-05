package com.webdev.flightreservation.util;



import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.stereotype.Component;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.webdev.flightreservation.entities.Reservation;

@Component
public class PdfGenerator {
	
	public void generateItenary(Reservation reservation, String filepath) {
		
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream(filepath));
			
			document.open();
			document.add(generateTable(reservation));
			document.close();
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (DocumentException e) {
			
			e.printStackTrace();
		}
	}

	private PdfPTable generateTable(Reservation reservation) {
		PdfPTable table = new PdfPTable(2);
		PdfPCell cell;
		
		cell = new PdfPCell(new Phrase("Flight Itinerary"));
		cell.setColspan(2);
		table.addCell(cell);
		
		cell = new PdfPCell(new Phrase("Flight Details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Departure City");
		table.addCell(reservation.getFlight().getDepartureCity());
		
		table.addCell("Arrival City");
		table.addCell(reservation.getFlight().getArrivalCity());
		
		table.addCell("Flight Number");
		table.addCell(reservation.getFlight().getFlightNumber());
		
		table.addCell("Operating Airlines");
		table.addCell(reservation.getFlight().getOperatingAirlines());
		
		table.addCell("Date");
		table.addCell(reservation.getFlight().getDateOfDeparture().toString());
		
		table.addCell("Estimated Time");
		table.addCell(reservation.getFlight().getEstimatedDepartureTime().toString());
		
		
		cell = new PdfPCell(new Phrase("Passenger details"));
		cell.setColspan(2);
		table.addCell(cell);
		
		table.addCell("Name");
		table.addCell(reservation.getPassenger().getFirstName() + " " + reservation.getPassenger().getLastName());
		
		table.addCell("Phone");
		table.addCell(reservation.getPassenger().getPhone());
		
		return table;
	}

}
