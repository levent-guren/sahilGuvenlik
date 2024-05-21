package converter;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import util.Util;

@FacesConverter("dateConverter")
public class LocalDateConverter implements Converter<LocalDate> {

	@Override
	public LocalDate getAsObject(FacesContext context, UIComponent component, String value) {
		LocalDate d = null;
		try {
			d = LocalDate.parse(value, Util.getDateTimeFormatter());
		} catch (DateTimeParseException e) {
			// tarih formatı uygun değil
			throw new ConverterException(new FacesMessage("Tarih gün/ay/yıl formatında olmalıdır"));
		}
		return d;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, LocalDate value) {
		if (value == null) {
			return "";
		}
		return value.format(Util.getDateTimeFormatter());
	}

}
